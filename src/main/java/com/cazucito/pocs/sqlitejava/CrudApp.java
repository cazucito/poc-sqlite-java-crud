package com.cazucito.pocs.sqlitejava;

import com.cazucito.pocs.sqlitejava.m.BookSvc;
import com.cazucito.pocs.sqlitejava.m.data.Book;

public class CrudApp {
    public static void main(String[] args) {
        BookSvc svc = new BookSvc();
        svc.getAllBooks().forEach(Book::toDefaultOutput);
    }
}