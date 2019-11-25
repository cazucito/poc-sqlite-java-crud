package com.cazucito.pocs.sqlitejava.m.data;

import java.sql.Connection;
import java.util.Optional;

import com.cazucito.pocs.sqlitejava.m.data.HandlerDB;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author cazucito
 */
public class HandlerDBTest {

    private final String TAB = "\t";

    public HandlerDBTest() {
    }

    /**
     * Test of getInstancia method, of class GestorBD.
     */
    @Test
    public void testGetInstance() {
        System.out.print(TAB + "<getInstance ");
        HandlerDB expResult = HandlerDB.getInstance();
        HandlerDB result = HandlerDB.getInstance();
        assertEquals(expResult, result);
        System.out.println(TAB + " /> ");
    }

    /**
     * Test of getCxn method, of class GestorBD.
     */
    @Test
    public void testGetCxn() {
        System.out.print(TAB + "<getCxn ");
        Optional<Connection> result = HandlerDB.getInstance().getCxn();
        assertTrue(result.isPresent());
        System.out.println(TAB + " /> ");
    }

}
