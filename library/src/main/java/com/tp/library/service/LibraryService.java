package com.tp.library.service;

import com.tp.library.exceptions.*;
import com.tp.library.models.Book;
import com.tp.library.persistence.LibraryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LibraryService {

    @Autowired
    LibraryDao dao;


    public List<Book> getAllBooks() {
        List<Book> allBooks = dao.getAllBooks();
        return allBooks;

    }

    public Book getBookWithId(Integer id) throws InvalidIdException {
        if(id == null)
            throw new InvalidIdException("invalid Id inputted");
        Book returnBook = dao.getBookById(id);
        return returnBook;
    }

    public List<Book> getAllTitles(String title) throws InvalidTitleException {
        if(title == null)
            throw new InvalidTitleException("invalid title inputted");
        List<Book> booksWithTitles = new ArrayList<>();
        booksWithTitles = dao.getAllBooksWithTitle(title);
        return booksWithTitles;
    }

    public List<Book> getAllAuthors(List<String> authors) throws InvalidAuthorsException {
        if(authors == null)
            throw new InvalidAuthorsException("invalid authors inputted");
        List<Book> booksWithAuthors = new ArrayList<>();
        booksWithAuthors = dao.getAllBooksWithAuthors(authors);
        return booksWithAuthors;
    }

    public List<Book> getAllYears(Integer publicationYear) throws InvalidYearException {
        if(publicationYear == null || publicationYear < 0 || publicationYear > 2021)
            throw new InvalidYearException("invalid publication year inputted");
        List<Book> booksWithYears = new ArrayList<>();
        booksWithYears = dao.getAllBooksWithYear(publicationYear);
        return booksWithYears;
    }

    public void addBook(Book toAdd) throws InvalidBookException, InvalidIdException, InvalidAuthorsException, InvalidTitleException, InvalidYearException {
        dao.addBook(toAdd);
    }

    public void deleteBook(Integer id) throws InvalidIdException {
        dao.deleteLibraryBook(id);
    }


}
