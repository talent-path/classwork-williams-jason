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
    public void setup() throws InvalidIdException, InvalidBookException, InvalidAuthorsException, InvalidYearException, InvalidTitleException {
        List<Book> allBooks = service.getAllBooks();

        for(Book toDelete: allBooks){
            service.deleteBook(toDelete.getBookId());
        }
        List<String> authors = new ArrayList<>();
        authors.add("bob1");
        authors.add("bob2");
        Book toAdd = new Book("TestTitle",authors,1990);
        service.addBook(toAdd);
    }

    @Test
    public void getBookByIdTestsGoldenPath(){
        List<String> authors = new ArrayList<>();
        authors.add("bob1");
        authors.add("bob2");
        Book test1 = new Book("test1",authors,1990);

        try{
            test1.setBookId(2);
            assertEquals(2,test1.getBookId());
        } catch(InvalidIdException e){
            fail();
        }


    }

    @Test
    public void getAllTitlesTestsGoldenPath(){
        List<String> authors = new ArrayList<>();
        authors.add("bob1");
        authors.add("bob2");
        Book test1 = new Book("test1",authors,1990);
        try{
            assertEquals(1,service.getAllTitles(test1.getTitle()));
        } catch(InvalidTitleException e){
            fail();
        }
    }

    @Test
    public void getAllAuthorsTestsGoldenPath(){
        List<String> authors = new ArrayList<>();
        authors.add("bob1");
        authors.add("bob2");
        Book test1 = new Book("test1",authors,1990);
        try{
            assertEquals(1,service.getAllAuthors(test1.getAuthors()));
        } catch(InvalidAuthorsException e){
            fail();
        }
    }
    @Test
    public void getAllYearsTestsGoldenPath(){
        List<String> authors = new ArrayList<>();
        authors.add("bob1");
        authors.add("bob2");
        Book test1 = new Book("test1",authors,1990);
        try{
            assertEquals(1,service.getAllYears(test1.getPublicationYear()));
        } catch(InvalidYearException e){
            fail();
        }
    }

    @Test
    public void addBookGoldenPath(){
        List<String> authors = new ArrayList<>();
        authors.add("bob1");
        authors.add("bob2");
        Book test1 = new Book("test1",authors,1990);
        try{
            service.addBook(test1);
            assertEquals(2,test1.getBookId());
            assertEquals("test1",test1.getTitle());
            assertEquals(1990,test1.getPublicationYear());
            assertEquals(authors,test1.getAuthors());
        } catch(InvalidBookException | InvalidIdException | InvalidAuthorsException | InvalidYearException | InvalidTitleException ex){
            fail();
        }

    }

    public void deleteBookByIdGoldenPath() throws InvalidIdException, InvalidBookException, InvalidAuthorsException, InvalidYearException, InvalidTitleException {
        List<String> authors = new ArrayList<>();
        authors.add("bob1");
        authors.add("bob2");
        Book test1 = new Book("test1",authors,1990);
        service.addBook(test1);

        try{
            service.deleteBook(2);
        } catch (InvalidIdException ex){
            fail();
        }


    }
}
