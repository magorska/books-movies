package com.booksmovies.backend.domain;

import java.util.Objects;

public class WolneLektury {

    private String title;
    private String author;
    private String category;

    public WolneLektury(String title, String author, String category) {
        this.title = title;
        this.author = author;
        this.category = category;
    }

    public WolneLektury() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WolneLektury that = (WolneLektury) o;
        return Objects.equals(title, that.title) && Objects.equals(author, that.author) && Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, category);
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
