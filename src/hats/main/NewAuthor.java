/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hats.main;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class NewAuthor extends Author implements Serializable{
    public NewAuthor(){
        super();
    }

    public NewAuthor(String authorID, String authorName) {
        super(authorID, authorName);
    }
    public void showinfo() {
        String msg = new String();
        msg = String.format("%-10s|%-10s|",authorID,authorName);
        System.out.println(msg);
        
    }
}
