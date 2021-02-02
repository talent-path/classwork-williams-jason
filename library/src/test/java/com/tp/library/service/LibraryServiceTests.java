package com.tp.library.service;

import com.tp.library.exceptions.*;
import com.tp.library.models.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LibraryServiceTests {

    @Autowired
    LibraryService service;

    @BeforeEach
    public void setup() throws InvalidIdException {
        List<Book> allBooks = service.getAllBooks();

        for(Book toRemove : allBooks){
            service.deleteBook(toRemove.getBookId());
        }
    }

    @Test
    public void addBookGoldenPathTest(){
        Book book = new Book();
        try {
            List<String> authors = new ArrayList<>();
            authors.add("bob");
            authors.add("bob2");
            book.setAuthors(authors);
            book.setPublicationYear(1990);
            book.setTitle("a book");
            book = service.addBook(book);
            //book.setBookId(1);
            assertEquals(1,book.getBookId());
            assertEquals("bob",book.getAuthors().get(0));
            assertEquals("bob2",book.getAuthors().get(1));
            assertEquals(1990,book.getPublicationYear());
            assertEquals("a book",book.getTitle());
        } catch (InvalidIdException | InvalidAuthorsException | InvalidYearException | InvalidTitleException | InvalidBookException e){
            fail();
        }
        Book book2 = new Book();
        try {
            List<String> authors = new ArrayList<>();
            authors.add("bob3");
            authors.add("bob4");
            book2.setAuthors(authors);
            book2.setPublicationYear(1991);
            book2.setTitle("a different book");
            book2 = service.addBook(book2);
            assertEquals(2,book2.getBookId());
            assertEquals("bob3",book2.getAuthors().get(0));
            assertEquals("bob4",book2.getAuthors().get(1));
            assertEquals(1991,book2.getPublicationYear());
            assertEquals("a different book",book2.getTitle());
        } catch (InvalidIdException | InvalidAuthorsException | InvalidYearException | InvalidTitleException | InvalidBookException e){
            fail();
        }

    }

    @Test
    public void addBookNullBook() throws InvalidIdException, InvalidTitleException, InvalidAuthorsException, InvalidYearException{

        try{
            service.addBook(null);
            fail();
        } catch(InvalidBookException e){

        }
    }

    @Test
    public void addBookNullTitle() throws InvalidTitleException, InvalidYearException, InvalidBookException, InvalidIdException, InvalidAuthorsException {
        Book book = new Book();
        List<String> authors = new ArrayList<>();
        authors.add("bob");
        authors.add("bob2");
        book.setAuthors(authors);
        book.setPublicationYear(1990);
        try{
            book = service.addBook(book);
            fail();
        } catch(InvalidTitleException e){

        }
    }

    @Test
    public void addBookNullAuthors() throws InvalidTitleException, InvalidYearException, InvalidBookException, InvalidIdException, InvalidAuthorsException {
        Book book = new Book();
        List<String> authors = new ArrayList<>();
        book.setTitle("test123");
        book.setPublicationYear(1990);
        try{
            book = service.addBook(book);
            fail();
        } catch(InvalidAuthorsException e){

        }
    }

    @Test
    public void addBookNullYear() throws InvalidTitleException, InvalidYearException, InvalidBookException, InvalidIdException, InvalidAuthorsException {
        Book book = new Book();
        List<String> authors = new ArrayList<>();
        authors.add("bob");
        authors.add("bob2");
        book.setAuthors(authors);
        book.setTitle("Test456");
        try{
            book = service.addBook(book);
            fail();
        } catch(InvalidYearException e){

        }
    }

    @Test
    public void getAllBooksGoldenPath() throws InvalidYearException, InvalidBookException, InvalidAuthorsException, InvalidTitleException, InvalidIdException {
        Book book = new Book();
        List<String> authors = new ArrayList<>();
        authors.add("bob");
        authors.add("bob2");
        book.setAuthors(authors);
        book.setTitle("Test456");
        book.setPublicationYear(1990);
        Book book2 = new Book();
        List<String> authors2 = new ArrayList<>();
        authors2.add("bob");
        authors2.add("bob2");
        book2.setAuthors(authors);
        book2.setTitle("Test456");
        book2.setPublicationYear(1990);
        service.addBook(book);
        service.addBook(book2);

        assertEquals(2,service.getAllBooks().size());
    }

    @Test
    public void getAllTitlesGoldenPath() throws InvalidBookException, InvalidAuthorsException, InvalidTitleException, InvalidIdException, InvalidYearException {
        Book book = new Book();
        List<String> authors = new ArrayList<>();
        authors.add("bob");
        authors.add("bob2");
        book.setAuthors(authors);
        book.setTitle("Test123");
        book.setPublicationYear(1990);
        Book book2 = new Book();
        List<String> authors2 = new ArrayList<>();
        authors2.add("bob");
        authors2.add("bob2");
        book2.setAuthors(authors);
        book2.setTitle("Test123");
        book2.setPublicationYear(1990);
        Book book3 = new Book();
        List<String> authors3 = new ArrayList<>();
        authors3.add("bob");
        authors3.add("bob2");
        book3.setAuthors(authors3);
        book3.setTitle("Test1234");
        book3.setPublicationYear(1990);
        service.addBook(book);
        service.addBook(book2);
        service.addBook(book3);
        List<Book> expectedList = new ArrayList<>();
        expectedList.add(book);
        expectedList.add(book2);
        expectedList.add(book3);
        assertEquals(expectedList.get(0).getTitle(),service.getAllTitles("Test123").get(0).getTitle());
        assertEquals(expectedList.get(1).getTitle(),service.getAllTitles("Test123").get(0).getTitle());
        assertEquals(expectedList.get(2).getTitle(),service.getAllTitles("Test1235").get(0).getTitle());

    }

    @Test
    public void getAllAuthorsGoldenPath(){

    }

    @Test
    public void getAllYearsGoldenPath(){

    }

//    @Test
//    public void getBookByIdTestsGoldenPath(){
//
//    }
//
//    @Test
//    public void getAllTitlesTestsGoldenPath(){
//        List<String> authors = new ArrayList<>();
//        authors.add("bob1");
//        authors.add("bob2");
//        Book test1 = new Book("test1",authors,1990);
//        try{
//            assertEquals(1,service.getAllTitles(test1.getTitle()));
//        } catch(InvalidTitleException e){
//            fail();
//        }
//    }
//
//    @Test
//    public void getAllAuthorsTestsGoldenPath(){
//        List<String> authors = new ArrayList<>();
//        authors.add("bob1");
//        authors.add("bob2");
//        Book test1 = new Book("test1",authors,1990);
//        try{
//            assertEquals(1,service.getAllAuthors(test1.getAuthors()));
//        } catch(InvalidAuthorsException e){
//            fail();
//        }
//    }
//    @Test
//    public void getAllYearsTestsGoldenPath(){
//        List<String> authors = new ArrayList<>();
//        authors.add("bob1");
//        authors.add("bob2");
//        Book test1 = new Book("test1",authors,1990);
//        try{
//            assertEquals(1,service.getAllYears(test1.getPublicationYear()));
//        } catch(InvalidYearException e){
//            fail();
//        }
//    }
//
//    @Test
//    public void addBookGoldenPath(){
//        List<String> authors = new ArrayList<>();
//        authors.add("bob1");
//        authors.add("bob2");
//        Book test1 = new Book("test1",authors,1990);
//        try{
//            service.addBook(test1);
//            assertEquals(2,test1.getBookId());
//            assertEquals("test1",test1.getTitle());
//            assertEquals(1990,test1.getPublicationYear());
//            assertEquals(authors,test1.getAuthors());
//        } catch(InvalidBookException | InvalidIdException | InvalidAuthorsException | InvalidYearException | InvalidTitleException ex){
//            fail();
//        }
//
//    }
//
//    public void deleteBookByIdGoldenPath() throws InvalidIdException, InvalidBookException, InvalidAuthorsException, InvalidYearException, InvalidTitleException {
//        List<String> authors = new ArrayList<>();
//        authors.add("bob1");
//        authors.add("bob2");
//        Book test1 = new Book("test1",authors,1990);
//        service.addBook(test1);
//
//        try{
//            service.deleteBook(2);
//        } catch (InvalidIdException ex){
//            fail();
//        }
//
//
//    }
}
