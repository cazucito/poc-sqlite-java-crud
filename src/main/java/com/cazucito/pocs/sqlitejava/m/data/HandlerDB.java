package com.cazucito.pocs.sqlitejava.m.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class HandlerDB {

    private static final HandlerDB HANDLER_DB = new HandlerDB();

    private HandlerDB() {
    }
    /**
     * 
     * @return 
     */
    public static HandlerDB getInstance() {
        return HANDLER_DB;
    }
    /**
     * 
     * @return 
     */
    public Optional<Connection> getCxn() {
        Optional<Connection> cxnOpt = Optional.empty();
        try {
            cxnOpt = Optional.of(DriverManager.getConnection("jdbc:sqlite:libri-alms.sqlite"));
        } catch (SQLException ex) {
            Logger.getLogger(HandlerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cxnOpt;
    }
}
