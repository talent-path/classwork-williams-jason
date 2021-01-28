package com.tp.library.persistence;

import com.tp.library.models.LibraryBook;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LibraryInMemDao {

    private List<LibraryBook> allBooks = new ArrayList<>();
}
