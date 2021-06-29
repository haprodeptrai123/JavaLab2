/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hats.main;

import dao.file;
import java.util.TreeSet;
import validation.Validation;

/**
 *
 * @author DELL
 */
class BookList {

    public TreeSet<Book> list;

    public BookList() {
        list = new TreeSet<>();
    }

    public BookList(TreeSet<Book> list) {
        this.list = list;
    }

    public TreeSet<Book> getList() {
        return list;
    }

    public void setList(TreeSet<Book> list) {
        this.list = list;
    }

    public void loadBook(String filename) {
        list = file.loadBook(filename);
        if (!list.isEmpty()) {
            System.out.println("Load Successful");
        } else {
            System.out.println("Nothing to load.");
        }
    }

    public boolean addBook(Book a) {
        for (Book o : list) {
            if (a.bookID.trim().equalsIgnoreCase(o.bookID)) {
                return false;
            }
        }
        return list.add(a);
    }

    public void updateBook(String modelInput) {
        if (!list.isEmpty()) {
            for (Book a : list) {
                if (a.bookID.trim().equalsIgnoreCase(modelInput)) {
                    a.update();
                    System.out.println("Successfully updated!");
                    a.showinfo();
                    storeBook("Book.dat");
                    return;
                }
            }
            System.out.println("Book doesn't exist");
        } else {
            System.out.println("Nothing to update!");
        }
    }

    public void deleteBook(String modelInput) {
        int flag = 0;
        if (!list.isEmpty()) {
            TreeSet<Book> tmpList = new TreeSet<>();
            for (Book a : list) {
                if (a.bookID.trim().equalsIgnoreCase(modelInput)) {
                    tmpList.add(a);
                    flag = 1;
                }
            }
            if (flag == 1) {
                String answer = new String();
                answer = Validation.getAnswer("Do you want to delete this book<Yes/No>", "Enter here :");
                if (answer.equalsIgnoreCase("yes")) {
                    if (list.removeAll(tmpList)) {
                        System.out.println("Succesfully deleted");
                    } else {
                        System.out.println("Delete failed");
                    }
                } else {
                    System.out.println("Book existed on the list.");
                }
            } else {
                System.out.println("The book doesn't exist in the list.");
            }
        } else {
            System.out.println("Nothing to delete");
        }
    }

    public TreeSet<Book> searchByBookID(String modelInput){
        TreeSet<Book> tmpList=new TreeSet<>();
        for(Book a: list){
            if(a.bookID.trim().equalsIgnoreCase(modelInput)){
                tmpList.add(a);
            }
        }
        return tmpList;
    }
    
    public void showAll(){
        System.out.println("Book ID   |  Title     | Author ID  |        Price       |");
        for(Book a: list){
            a.showinfo();
        }
    }
    public void showAll(TreeSet<Book> tmp){
        System.out.println("Book ID   |  Title     | Author ID  |        Price       | ");
        for(Book a: tmp){
            a.showinfo();
        }
    }
    
    
    public void storeBook(String filename){
        file.writeData(filename, list);
    }
    
    
    
}
