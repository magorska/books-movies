package com.booksmovies.ui;

import com.booksmovies.backend.domain.WolneLektury;
import com.booksmovies.backend.service.WolneLekturyService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/v1/wolneLektury/allBooks")

public class WolneLekturyView extends VerticalLayout {

    private WolneLekturyService wolneLekturyService = WolneLekturyService.getInstance();
    private Grid<WolneLektury> grid = new Grid<>(WolneLektury.class);

    public WolneLekturyView() {
        grid.setColumns("Title", "Overview", "Kind");
        add(grid);
        setSizeFull();
        refresh();
    }
    public void refresh() {
        grid.setItems(wolneLekturyService.getAllBooks());
    }
}
