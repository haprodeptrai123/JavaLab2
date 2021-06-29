/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hats.main.Author;
import hats.main.Book;
import hats.main.NewAuthor;
import hats.main.NewBook;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.TreeSet;

/**
 *
 * @author DELL
 */
public class file {
    public static TreeSet<Book> loadBook(String filename){
        TreeSet<Book> list=new TreeSet<>();
        FileReader fr=null;
        BufferedReader br=null;
        try {
            fr=new FileReader(filename);
            br=new BufferedReader(fr);
            while(br.ready()){
                String s=new String();
                Book obj=null;
                s=br.readLine();
                String[] book=s.split((";"));
                obj= new NewBook(book[0], book[1], book[2], Float.parseFloat(book[3]), book[4]);
                if(obj!=null){
                    list.add(obj);
                }
            }
        } catch (Exception e) {
            System.out.println("An error occured :"+e);
        }finally{
            try {
                 if(fr!=null){
                fr.close();
            }
            if(br!=null){
                br.close();
            }
            } catch (Exception e) {
                System.out.println("Bug at closing file");
            }
        }
        return list;
    }
    
    
    
    
    public static TreeSet<Author> loadAuthor(String filename) {
         TreeSet<Author> list=new TreeSet<>();
        FileReader fr=null;
        BufferedReader br=null;
        try {
            fr=new FileReader(filename);
            br=new BufferedReader(fr);
            while(br.ready()){
                String s=new String();
                Author obj=null;
                s=br.readLine();
                String[] author=s.split((";"));
                obj= new NewAuthor(author[0],author[1]);
                if(obj!=null){
                    list.add(obj);
                }
            }
        } catch (Exception e) {
            System.out.println("An error occured :"+e);
        }finally{
            try {
                 if(fr!=null){
                fr.close();
            }
            if(br!=null){
                br.close();
            }
            } catch (Exception e) {
                System.out.println("Bug at closing file");
            }
        }
        return list;
    }
    
    
    
    
    public static void writeData(String filename,TreeSet<Book> list){
        PrintWriter pw=null;
        try {
            pw=new PrintWriter(filename);
            for(Book a:list){
                pw.println(a.toString());
                pw.flush();
            }
            System.out.println("Successfully written data to file!");
        } catch (Exception e) {
            System.out.println("Bug at write data!");
        }finally{
            try {
                if(pw!=null){
                    pw.close();
                }
            } catch (Exception e) {
                System.out.println("Bug at closing file writer");
            }
        }
    }

    
    
    
    
    
    
    
    
}
