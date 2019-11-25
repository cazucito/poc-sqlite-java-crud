package com.cazucito.pocs.sqlitejava.m;

import java.util.List;

import com.cazucito.pocs.sqlitejava.m.data.Book;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author cazucito
 */
public class BookSvcTest {

    private final String TAB = "\t";

    public BookSvcTest() {
    }
   
    /**
     * Test of getAllBooks method, of class BookSvc.
     */
    @Test
    public void testGetAllBooks() {
        System.out.print(TAB + "<getAllBooks ");
        final BookSvc instance = new BookSvc();
        final List<Book> books = instance.getAllBooks();
        assertTrue(!books.isEmpty());
        System.out.println(TAB + "/>");
    }

   
}
