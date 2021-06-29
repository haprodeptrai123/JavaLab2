/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hats.main;

import dao.file;
import java.util.TreeSet;

/**
 *
 * @author DELL
 */
public class AuthorList {

    public TreeSet<Author> list;

    public AuthorList() {
        list = new TreeSet<>();
    }

    public AuthorList(TreeSet<Author> list) {
        this.list = list;
    }

    public TreeSet<Author> getList() {
        return list;
    }

    public void setList(TreeSet<Author> list) {
        this.list = list;
    }
public void loadAuthor(String filename){
    list=file.loadAuthor(filename);
    if(!list.isEmpty()){
        System.out.println("Author load successful");
    }else{
        System.out.println("Nothing to load!");
    }
}
public TreeSet <Author> searchAuthor(String modelInput){
    TreeSet<Author> tmpList=new TreeSet<>();
    for(Author a : list){
        if(a.authorID.equalsIgnoreCase(modelInput));
        tmpList.add(a);
    }
        return tmpList;
}
public void showAll(){
        System.out.println("Author ID | Author Name ");
        for(Author a: list){
            a.showinfo();
        }
}
}