package com.cazucito.pocs.sqlitejava.m.data;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookDAO implements CrudDAO<Book> {

    /**
     * Create a row in the data source
     *
     * @param entity Entity to persist in data source
     * @return Was the operation success?
     */
    @Override
    public boolean create(Book entity) {
        boolean success = false;
        Optional<Connection> cxnOpt = HandlerDB.getInstance().getCxn();
        if (cxnOpt.isPresent()) {
            try (Connection cxn = cxnOpt.get();
                    PreparedStatement pStmt = cxn.prepareStatement("INSERT INTO book(idBook, title, author) VALUES (?, ?, ?)");) {
                pStmt.setInt(1, entity.getIdBook());
                pStmt.setString(2, entity.getTitle());
                pStmt.setString(3, entity.getAuthor());
                if (pStmt.executeUpdate() == 1) {
                    success = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return success;
    }

    /**
     * Retrieve all entities
     *
     * @return A <code>List</code> reference with entities references
     */
    @Override
    public List<Book> retrieveAll() {
        List<Book> books = new ArrayList<>();
        Optional<Connection> cxnOpt = HandlerDB.getInstance().getCxn();
        if (cxnOpt.isPresent()) {
            try (Connection cxn = cxnOpt.get();
                    PreparedStatement pstmt = cxn.prepareStatement("SELECT * FROM book");
                    ResultSet rs = pstmt.executeQuery();) {
                while (rs.next()) {
                    books.add(new Book(rs.getInt("idBook"), rs.getString("title"), rs.getString("author")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return books;
    }

    /**
     * Retrieve one entity matching with the <code>id</code> parameter
     *
     * @param id Entity identifier
     * @return A <code>List</code> reference with entities references
     */
    @Override
    public Optional<Book> retrieveById(int id) {
        Optional<Book> bookOpt = Optional.empty();
        Optional<Connection> cxnOpt = HandlerDB.getInstance().getCxn();
        if (cxnOpt.isPresent()) {
            ResultSet rs = null;
            try (Connection cxn = cxnOpt.get();
                    PreparedStatement pStmt = cxn.prepareStatement("SELECT * FROM book WHERE idBook=?");) {
                pStmt.setInt(1, id);
                rs = pStmt.executeQuery();
                while (rs.next()) {
                    bookOpt = Optional.of(new Book(rs.getInt("idBook"), rs.getString("title"), rs.getString("author")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return bookOpt;
    }

    /**
     * Update a row in the data source
     *
     * @param entity Entity to update in data source
     * @return Was the operation success?
     */
    @Override
    public boolean update(Book entity) {
        boolean success = false;
        Optional<Connection> cxnOpt = HandlerDB.getInstance().getCxn();
        if (cxnOpt.isPresent()) {
            try (Connection cxn = cxnOpt.get();
                    PreparedStatement pStmt = cxn.prepareStatement("UPDATE book SET title=?, author=? WHERE idBook=?");) {
                pStmt.setString(1, entity.getTitle());
                pStmt.setString(2, entity.getAuthor());
                pStmt.setInt(3, entity.getIdBook());
                if (pStmt.executeUpdate() == 1) {
                    success = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return success;
    }

    /**
     * Delete one entity matching with the <code>id</code> parameter
     *
     * @param id Entity identifier
     * @return Was the operation success?
     */
    @Override
    public boolean deleteById(int id) {
        boolean success = false;
        Optional<Connection> cxnOpt = HandlerDB.getInstance().getCxn();
        if (cxnOpt.isPresent()) {
            try (Connection cxn = cxnOpt.get();
                    PreparedStatement pStmt = cxn.prepareStatement("DELETE FROM book WHERE idBook=?");) {
                pStmt.setInt(1, id);
                if (pStmt.executeUpdate() == 1) {
                    success = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return success;
    }

    /**
     * Delete one entity matching with the <code>id</code> parameter
     *
     * @param entity Entity to persist in data source
     * @return Was the operation success?
     */
    @Override
    public boolean delete(Book entity) {
        return deleteById(entity.getIdBook());
    }
}
