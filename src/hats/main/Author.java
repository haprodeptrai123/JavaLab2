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
public abstract class Author implements Comparable<Author>,Serializable{
    public String authorID;
    public String authorName;

    public Author() {
    }

    public Author(String authorID, String authorName) {
        this.authorID = authorID;
        this.authorName = authorName;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return  authorID + ";" + authorName;
    }
public abstract void showinfo();
    @Override
    public int compareTo(Author o) {
        return this.authorID.compareToIgnoreCase(o.authorID);
    }
    
}
