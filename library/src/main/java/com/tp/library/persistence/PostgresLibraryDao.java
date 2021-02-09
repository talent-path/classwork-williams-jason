package com.tp.library.persistence;

import com.tp.library.exceptions.*;
import com.tp.library.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PostgresLibraryDao implements LibraryDao{

    @Autowired
    JdbcTemplate template;

    @Override
    public Book getBookById(Integer bookId) throws InvalidIdException {
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return null;
    }

    @Override
    public void updateLibraryBook(Book book) throws InvalidBookException, InvalidIdException {

    }

    @Override
    public void deleteBook(Integer bookId) throws InvalidIdException {

    }

    @Override
    public List<Book> getAllBooksWithTitle(String title) throws InvalidTitleException {
        return null;
    }

    @Override
    public List<Book> getAllBooksWithAuthors(List<String> authors) throws InvalidAuthorsException {
        return null;
    }

    @Override
    public List<Book> getAllBooksWithYear(Integer publicationYear) throws InvalidYearException {
        return null;
    }

    private int addAuthor(String author){

        return template.query("INSERT INTO \"Authors\" (\"AuthorName\")\n" +
                "VALUES ('"+author+"')\n" +
                "RETURNING \"AuthorId\"\n" +
                "\n",new IdMapper()).get(0);
    }


    @Override
    public Book addBook(Book input) throws InvalidYearException, InvalidTitleException, InvalidAuthorsException, InvalidIdException, InvalidBookException {

        List<Integer> authorList = new ArrayList<>();

        for (int i = 0; i < input.getAuthors().size(); i++) {

            Integer authorId = addOrRetrieve(input.getAuthors().get(i));
            authorList.add(authorId);

        }
        return null;
    }

    private Integer addOrRetrieve(String author) {
        Integer authorId = getAuthorid(author);
        if(authorId==null){
            authorId = addAuthor(author);
        }
        return authorId;
    }

    private Integer getAuthorid(String author) {

        List<Integer> id = template.query("SELECT \"AuthorId\" FROM \"Authors\"\n" +
                "WHERE \"AuthorName\" = "+author+";",new IdMapper());

        if(id.isEmpty()){
            return null;
        }

        return id.get(0);

    }

    private class IdMapper implements RowMapper<Integer> {

        @Override
        public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
            return resultSet.getInt("authorId");
        }
    }
}
