package com.cazucito.pocs.sqlitejava;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 *
 * @author cazucito
 */
public class CrudAppTest {

    private final String TAB = "\t";

    public CrudAppTest() {
    }

   
    /**
     * Test of getAllBooks method, of class BookSvc.
     */
    @Test
    public void testMain() {
        System.out.print(TAB + "<main ");
        String[] args = {};
        CrudApp.main(args);
        assertTrue(true);
        System.out.println(TAB + "/>");
    }

        /**
     * Test of getAllBooks method, of class BookSvc.
     */
    @Test
    public void testMainNew() {
        System.out.print(TAB + "<main ");
        String[] args = {};
        new CrudApp().main(args);
        assertTrue(true);
        System.out.println(TAB + "/>");
    }

   
}
