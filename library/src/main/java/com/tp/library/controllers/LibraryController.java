package com.tp.library.controllers;

import com.tp.library.exceptions.*;
import com.tp.library.models.Book;
import com.tp.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {

    @Autowired
    LibraryService service;

    @GetMapping("/library")
    public List<Book> getAllBooks(){
        return service.getAllBooks();
    }

//    @GetMapping("/library/bookId/{bookId}")
//    public ResponseEntity getBookById(@PathVariable Integer bookId){
//        Book input = null;
//        try{
//             input = service.getBookWithId(bookId);
//        } catch (InvalidIdException e){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        }
//
//        return ResponseEntity.ok(toReturn);
//    }

    @GetMapping("library/authors/{authors}")
    public List<Book> getBookById(@PathVariable List<String> authors) throws InvalidAuthorsException {
        return service.getAllAuthors(authors);
    }

    @GetMapping("library/publicationyear/{publicationYear}")
    public List<Book> getBookByYear(@PathVariable Integer publicationYear) throws InvalidYearException {
        return service.getAllYears(publicationYear);
    }

    @GetMapping("library/title/{title}")
    public List<Book> getBookByTitle(@PathVariable String title) throws InvalidTitleException {
        return service.getAllTitles(title);
    }

    @PostMapping("library/add")
    public void addBook(@RequestBody Book input) throws InvalidBookException, InvalidIdException, InvalidAuthorsException, InvalidTitleException, InvalidYearException {
        service.addBook(input);
    }

    //TODO: get rid of all throws replace with try catch blocks
}
