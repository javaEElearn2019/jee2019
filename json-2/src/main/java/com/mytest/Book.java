package com.mytest;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private String tilte;
    private List<String> authors = new ArrayList<String>();
    private String isbn;

    public String getTilte() {
        return tilte;
    }

    public void setTilte(String tilte) {
        this.tilte = tilte;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
