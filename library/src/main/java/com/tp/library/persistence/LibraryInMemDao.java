package com.tp.library.persistence;

import com.tp.library.exceptions.*;
import com.tp.library.models.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LibraryInMemDao implements LibraryDao{



    private List<Book> allBooks = new ArrayList<>();

    public LibraryInMemDao(){
    }

    @Override
    public void addBook(Book toAdd) throws InvalidYearException, InvalidTitleException, InvalidYearException, InvalidIdException, InvalidAuthorsException {
        Book newBook = new Book(toAdd);
        newBook.setBookId(allBooks.size());

        if(newBook.getBookId() == null)
           throw new InvalidIdException("invalid Id Entered");
        if(newBook.getAuthors() == null)
            throw new InvalidIdException("invalid authors Entered");
        if(newBook.getTitle() == null)
            throw new InvalidIdException("invalid title Entered");
        if(newBook.getPublicationYear() == null)
            throw new InvalidIdException("invalid publication year Entered");
    }

    @Override
    public Book getBookById(Integer bookId) throws InvalidIdException{
        Book toReturn = null;

        for(Book toCheck : allBooks){
            if(toCheck.getBookId().equals(bookId)){
                toReturn = new Book(toCheck);
                break;
            }
        }

        return toReturn;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> copyList = new ArrayList<>();
        for( Book toCopy : allBooks ){
            copyList.add( new Book(toCopy) );
        }
        return copyList;
    }

    @Override
    public List<Book> getAllBooksWithTitle(String title) throws InvalidTitleException {
        List<Book> books = new ArrayList<>();

        if(title == null)
            throw new InvalidTitleException("invalid title entered");
        for(Book toCheck : allBooks){
            if(toCheck.getTitle().equals(title)){
                books.add(toCheck);
                break;
            }
        }

        return books;
    }

    @Override
    public List<Book> getAllBooksWithAuthors(List<String> authors) throws InvalidAuthorsException {
        List<Book> books = new ArrayList<>();

        if(authors == null){
            throw new InvalidAuthorsException("invalid authors entered");
        }

        for(Book toCheck : allBooks){
            if(toCheck.getTitle().equals(authors)){
                books.add(toCheck);
                break;
            }
        }

        return books;
    }



    @Override
    public List<Book> getAllBooksWithYear(Integer publicationYear) throws InvalidYearException {
        List<Book> books = new ArrayList<>();

        if(publicationYear == null)
            throw new InvalidYearException("invalid year inputted");

        for(Book toCheck : allBooks){
            if(toCheck.getTitle().equals(publicationYear )){
                books.add(toCheck);
                break;
            }
        }

        return books;
    }




    @Override
    public void updateLibraryBook(Book book) throws InvalidBookException, InvalidIdException {

        if(book == null)
            throw new InvalidBookException("invalid book inputted");

        for( int i = 0; i < allBooks.size(); i++){
            if( allBooks.get(i).getBookId().equals(book.getBookId())){
                //we found the game to update
                allBooks.set(i, new Book(book) );
            }
        }
    }

    @Override
    public void deleteLibraryBook(Integer bookId) throws InvalidIdException {
        int removeIndex = -1;

        if(bookId == null)
            throw new InvalidIdException("invalid id inputted");
        for (int i = 0; i < allBooks.size(); i++) {
            if(allBooks.get(i).getBookId().equals(bookId)){
                removeIndex = i;
                break;
            }

        }
        if( removeIndex != -1 ){
            allBooks.remove(removeIndex);
        } else {
            System.out.println("invalid remove request");
        }
    }
}
