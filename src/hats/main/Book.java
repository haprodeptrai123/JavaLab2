/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hats.main;

import java.io.Serializable;
import validation.Validation;

/**
 *
 * @author DELL
 */
public abstract class Book implements Comparable<Book>, Serializable {

    public String bookID;
    public String isbn;
    public String title;
    public float price;
    public String authorID;

    public Book() {
    }

    public Book(String bookID, String isbn, String title, float price, String authorID) {
        this.bookID = bookID;
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.authorID = authorID;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    @Override
    public String toString() {
        return bookID + " ; " + isbn + " ; " + title + " ; " + price + " ; " + authorID;
    }

    public abstract void input();

    public abstract void showinfo();

    @Override
    public int compareTo(Book o) {
        return this.bookID.compareToIgnoreCase(o.bookID);
    }

    void update() {     
        isbn = Validation.GetIsbn("Enter ISBN(13 numbers): ", "Wrong Format!");
        title = Validation.getTitle("Enter title:", "Wrong format!!!");
        price = Validation.getPrice("Enter price:", "You must enter a number", 0, 300000000);
    }

}
