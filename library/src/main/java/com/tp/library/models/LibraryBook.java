package com.tp.library.models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class LibraryBook {

    private Integer bookId;
    private String title;
    private List<String> authors;
    private Integer publicationYear;

    public LibraryBook(Integer bookId, String title, List<String> authors, Integer publicationYear){
        this.bookId = bookId;
        this.title = title;
        this.authors = authors;
        this.publicationYear = publicationYear;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

}
