package com.cazucito.pocs.sqlitejava.m.data;

import java.util.List;
import java.util.Optional;

import com.cazucito.pocs.sqlitejava.m.data.Book;
import com.cazucito.pocs.sqlitejava.m.data.BookDAO;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author cazucito
 */
public class BookDAOTest {

    private final String TAB = "\t";
    private static Book entity2Create;
    private static Book entity2Delete;
    private static Book entity2Update;

    public BookDAOTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        entity2Create = new Book(7777777, "title7777777", "author7777777");
        entity2Delete = new Book(999999999, "title999999999", "author999999999");
        entity2Update = new Book(88888888, "title88888888", "author88888888");
    }

    /**
     * Test of create method, of class BookDAO.
     */
    @Test
    public void testCreate() {
        System.out.print(TAB + "<create ");
        final BookDAO instance = new BookDAO();

        if (instance.create(entity2Create)) {
            instance.delete(entity2Create);
        } else {
            fail("NO CREATED");
        }
        System.out.println(TAB + "/>");
    }
    /**
     * Test of create method, of class BookDAO.
     */
    @Test
    public void testCreateNo() {
        System.out.print(TAB + "<createNo ");
        final BookDAO instance = new BookDAO();
        Book b = new Book(-1, "title", "author");
        instance.create(b);
        if (!instance.create(b)) {
            assertTrue(true);
        }
        instance.delete(b);
        System.out.println(TAB + "/>");
    }
    /**
     * Test of retrieveAll method, of class BookDAO.
     */
    @Test
    public void testRetrieveAll() {
        System.out.print(TAB + "<retrieveAll ");
        final BookDAO instance = new BookDAO();
        final List<Book> books = instance.retrieveAll();
        assertTrue(!books.isEmpty());
        System.out.println(TAB + "/>");
    }

    /**
     * Test of retrieveById method, of class BookDAO.
     */
    @Test
    public void testRetrieveById() {
        System.out.print(TAB + "<update ");
        final BookDAO instance = new BookDAO();
        instance.create(entity2Update);
        final Optional<Book> retrievedEntityOpt = instance.retrieveById(entity2Update.getIdBook());
        if (retrievedEntityOpt.isPresent()) {
            instance.delete(entity2Update);
            assertEquals(entity2Update, retrievedEntityOpt.get());
        } else {
            fail("THERE IS NO ENTITY");
        }

        System.out.println(TAB + "/>");
    }

    /**
     * Test of update method, of class BookDAO.
     */
    @Test
    public void testUpdate() {
        System.out.print(TAB + "<update ");
        final BookDAO instance = new BookDAO();
        if (instance.create(entity2Update)) {
            entity2Update.setTitle("UPDATED TITLE");
            entity2Update.setAuthor("UPDATED AUTHOR");
            assertTrue(instance.update(entity2Update));
            instance.delete(entity2Update);
        } else {
            fail("BAD PRECONDITIONS");
        }
        System.out.println(TAB + "/>");
    }

    /**
     * Test of update method, of class BookDAO.
     */
    @Test
    public void testUpdateNo() {
        System.out.print(TAB + "<updateNo ");
        final BookDAO instance = new BookDAO();
        if (!instance.update(new Book(-123, "title", "author"))) {
            assertTrue(true);
        } else {
            fail("BAD PRECONDITIONS");
        }
        System.out.println(TAB + "/>");
    }
    /**
     * Test of deleteById method, of class BookDAO.
     */
    @Test
    public void testDeleteById() {
        System.out.print(TAB + "<deleteById ");
        final BookDAO instance = new BookDAO();
        if (instance.create(entity2Delete)) {
            assertTrue(instance.deleteById(entity2Delete.getIdBook()));
        } else {
            fail("BAD PRECONDITIONS");
        }
        System.out.println(TAB + "/>");
    }
    /**
     * Test of deleteById method, of class BookDAO.
     */
    @Test
    public void testDeleteByIdNo() {
        System.out.print(TAB + "<deleteByIdNo ");
        final BookDAO instance = new BookDAO();
        if (!instance.deleteById(-123)) {
            assertTrue(true);
        } else {
            fail("BAD PRECONDITIONS");
        }
        System.out.println(TAB + "/>");
    }
        /**
     * Test of deleteById method, of class BookDAO.
     */
    @Test
    public void testDeleteByIdNo2() {
        System.out.print(TAB + "<deleteByIdNo2 ");
        final BookDAO instance = new BookDAO();
        if (!instance.deleteById(Integer.MIN_VALUE)) {
            assertTrue(true);
        } else {
            fail("BAD PRECONDITIONS");
        }
        System.out.println(TAB + "/>");
    }
    /**
     * Test of delete method, of class BookDAO.
     */
    @Test
    public void testDelete() {
        System.out.print(TAB + "<delete ");
        final BookDAO instance = new BookDAO();
        if (instance.create(entity2Delete)) {
            assertTrue(instance.delete(entity2Delete));
        } else {
            fail("BAD PRECONDITIONS");
        }
        System.out.println(TAB + "/>");
    }

}
