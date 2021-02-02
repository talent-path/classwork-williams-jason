package com.tp.library.persistence;


import com.tp.library.exceptions.*;
import com.tp.library.models.Book;

import java.util.List;

public interface LibraryDao {

    Book getBookById(Integer bookId) throws InvalidIdException;

    List<Book> getAllBooks();

    void updateLibraryBook(Book book) throws InvalidBookException, InvalidIdException;

    void deleteBook(Integer bookId) throws InvalidIdException;

    List<Book> getAllBooksWithTitle(String title) throws InvalidTitleException;

    List<Book> getAllBooksWithAuthors(List<String> authors) throws InvalidAuthorsException;

    List<Book> getAllBooksWithYear(Integer publicationYear) throws InvalidYearException;

    Book addBook(Book input) throws InvalidYearException, InvalidTitleException, InvalidAuthorsException, InvalidIdException, InvalidBookException;



}
