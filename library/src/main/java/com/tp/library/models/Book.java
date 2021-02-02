package com.tp.library.models;

import com.tp.library.exceptions.InvalidAuthorsException;
import com.tp.library.exceptions.InvalidIdException;
import com.tp.library.exceptions.InvalidTitleException;
import com.tp.library.exceptions.InvalidYearException;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private Integer bookId;
    private String title;
    private List<String> authors;
    private Integer publicationYear;

    public Book(){

    }

    public Book(Integer bookId, String title, List<String> authors, Integer publicationYear){
        this.bookId = bookId;
        this.title = title;
        this.authors = authors;
        this.publicationYear = publicationYear;
    }

    public Book(Book that){
        this.bookId = that.bookId;
        this.title = that.title;
        this.authors = new ArrayList<>();
        for( String toCopy : that.authors ){
            this.authors.add( toCopy );
        }
        this.publicationYear = that.publicationYear;
    }



    public Integer getBookId() throws InvalidIdException {
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

    public List<String> getAuthors()   {
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
