package com.cazucito.pocs.sqlitejava.m.data;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A Book entity
 *
 * @author cazucito
 */
public class Book {

    /**
     * Book identification field
     */
    private int idBook;
    /**
     * Book title
     */
    private String title;
    /**
     * Name of the author of the book
     */
    private String author;

    public Book(int idBook, String title, String author) {
        this.idBook = idBook;
        this.title = title;
        this.author = author;
    }

    /**
     * @return the idBook
     */
    public int getIdBook() {
        return idBook;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Create a string from object data
     *
     * @return A String reference to JSON format object data
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("[hascode:").append(hashCode()).append("] ");
        sb.append("id:").append(getIdBook()).append(", ");
        sb.append("title:").append(getTitle()).append(", ");
        sb.append("author:").append(getAuthor());
        sb.append("}");
        return sb.toString();
    }

    /**
     * "Prints" on default output object
     */
    public void toDefaultOutput() {
        Logger.getLogger(Book.class.getName()).log(Level.INFO, "\t {0} ", this);
    }

    /**
     * Are equals?
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof Book) {
            Book b = (Book) obj;
            if (idBook == b.idBook
                    && title.equals(b.title)
                    && author.equals(b.author)) {
                equal = true;
            }
        }
        return equal;
    }

    /**
     * Hashcode number
     *
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return idBook + Objects.hashCode(title) + Objects.hashCode(author);
    }

}
