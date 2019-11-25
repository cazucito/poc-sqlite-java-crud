package com.cazucito.pocs.sqlitejava.m;

import com.cazucito.pocs.sqlitejava.m.data.Book;
import com.cazucito.pocs.sqlitejava.m.data.BookDAO;

import java.util.List;

public class BookSvc {

    public List<Book> getAllBooks() {
        return (new BookDAO()).retrieveAll();
    }

}