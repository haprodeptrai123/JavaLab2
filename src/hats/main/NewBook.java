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
public class NewBook extends Book implements  Serializable{
    public NewBook(){
        super();
    }

    public NewBook(String bookID, String isbn, String title, float price, String authorID) {
        super(bookID, isbn, title, price, authorID);
    }
@Override
public void input(){
    bookID=Validation.GetBookID("Enter Book ID with Format : (A12345)","Wrong Format!");
    authorID=Validation.getAuthor("Enter AuthorID","An error occured");
    isbn=Validation.GetIsbn("Enter ISBN(13 numbers): ","Wrong Format!");
    title=Validation.getTitle("Enter title:","Wrong format!!!");
    price=Validation.getPrice("Enter price:","You must enter a number", 0, 300000000);
    
    
}

    @Override
    public void showinfo() {
        String msg=new String();
        msg=String.format("%-10s|%-10s|%-20s|%-10f|%-10s|", bookID,isbn,title,price,authorID);
        System.out.println(msg);
    }
}
