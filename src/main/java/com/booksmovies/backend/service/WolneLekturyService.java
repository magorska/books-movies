package com.booksmovies.backend.service;

import com.booksmovies.backend.domain.WolneLektury;

import java.util.HashSet;
import java.util.Set;

public class WolneLekturyService {

    private Set books;
    private static WolneLekturyService wolneLekturyService;

    private WolneLekturyService() {
        this.books = exampleData();
    }

    public static WolneLekturyService getInstance() {
        if (wolneLekturyService == null) {
            wolneLekturyService= new WolneLekturyService();
        }
        return wolneLekturyService;
    }

    public Set getAllBooks() {
        return new HashSet<>(books);
    }

    private Set exampleData() {
        Set books = new HashSet<>();
        books.add(new WolneLektury("Cracking the Coding Interview: 189 Programming Questions and Solutions", "Gayle Laakmann McDowell", "comedy" ));
        books.add(new WolneLektury("Introduction to Algorithms", "The MIT Press", "drama"));
        books.add(new WolneLektury("Introduction to the Theory of Computation", "Michael Sipser", "drama"));
        return books;
    }

}
