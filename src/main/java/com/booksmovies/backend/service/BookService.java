package com.booksmovies.backend.service;

import com.booksmovies.backend.domain.Book;
import com.vaadin.flow.data.binder.Binder;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.vaadin.flow.data.binder.Binder.setVisible;

public class BookService {

    private Set books;
    private static BookService bookService;
    private Binder<Book> binder = new Binder<Book>(Book.class);

    private BookService() {
        this.books = exampleData();
    }

    public static BookService getInstance() {
        if (bookService == null) {
            bookService = new BookService();
        }
        return bookService;
    }

    public Set getBooks() {
        return new HashSet<>(books);
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    private Set exampleData() {
        Set books = new HashSet<>();
        books.add(new Book("Cracking the Coding Interview: 189 Programming Questions and Solutions", "Gayle Laakmann McDowell",  2015, 1L, 200 ));
        books.add(new Book("Introduction to Algorithms", "The MIT Press", 2009, 2L, 345));
        books.add(new Book("Introduction to the Theory of Computation", "Michael Sipser", 2012, 3L, 520));
        books.add(new Book("Operating System Concepts", "Silberschatz, Galvin, Gagne", 2012, 4L, 532));
        books.add(new Book("The Silent Patient", "Alex Michaelides", 2019, 5L, 345));
        books.add(new Book("The Handmaid's Tale", "Margaret Atwood", 2019, 6L, 394));
        books.add(new Book("Watch Us Rise", "Renée Watson,  Ellen Hagan", 2019, 7L, 530));
        return books;
    }

    public Set findByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle.contains(title))
                .collect(Collectors.toSet());
    }

    public void save(Book book) {
        this.books.add(book);
    }

    public void delete(Book book) {
        this.books.remove(book);
    }

    public void setBook(Book book) {
        binder.setBean(book);

        if (book == null) {
            setVisible(false);
        } else {
            setVisible(true);
            title.focus();
        }
    }
}


