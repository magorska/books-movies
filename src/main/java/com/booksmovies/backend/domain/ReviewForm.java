package com.booksmovies.backend.domain;

import com.booksmovies.backend.service.BookService;
import com.booksmovies.ui.BookView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class ReviewForm {

    private TextField rate = new TextField("Your rate");
    private TextField review = new TextField("Your review");


    private BookView bookView;
    private BookService service = BookService.getInstance();

    private Button save = new Button("Save");
    private Button delete = new Button("Delete");

    private Binder<Book> binder = new Binder<Book>(Book.class);

    public ReviewForm() {
        HorizontalLayout buttons = new HorizontalLayout(save, delete);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        binder.bindInstanceFields(this);
        save.addClickListener(event -> save());
        delete.addClickListener(event -> delete());
        add(rate, review, buttons);
    }

    public ReviewForm(BookView bookView) {
        this.bookView = bookView;
    }

    private void save() {
        Book book = binder.getBean();
        service.save(book);
        bookView.refresh();
        setBook(null);
    }

    private void delete() {
        Book book = binder.getBean();
        service.delete(book);
        bookView.refresh();
        setBook(null);
    }
}
