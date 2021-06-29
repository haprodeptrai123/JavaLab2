/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import hats.main.Author;
import hats.main.AuthorList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author DELL
 */
public class Validation {

    static Scanner scan = new Scanner(System.in);

    public static String getAnswer(String msg, String errorMsg) {
        String answer = new String();
        while (true) {
            try {
                System.out.println(msg);
                answer = scan.nextLine();
                if (!(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no"))) {
                    throw new Exception();
                }
                return answer.trim();
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static String GetBookID(String msg, String errorMsg) {
        String str = new String();
        while (true) {
            try {
                System.out.println(msg);
                str = scan.nextLine();
                if (!str.matches("[\\w]{1}[0-9]{5}")) {
                    System.out.println("You must input following the format! one letter and five numbers!(Example : A01234)");
                }
                if (str.isEmpty()) {
                    System.out.println("Empty!!!");
                    throw new Exception();
                }
                return str;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static String getAuthor(String msg, String errorMsg) {
        String str = new String();
        AuthorList obj = new AuthorList();
        obj.loadAuthor("Author.dat");
        TreeSet<Author> list =new TreeSet<>();
        while (true) {
            try {
                System.out.println("Author List");
                obj.showAll();
                System.out.println(msg);
                str = scan.nextLine();
//           for(Author a: list){
//               if(a.authorID.trim().equalsIgnoreCase(str)){
//                   return str;
//               }
//           }
                if(str.isEmpty()){
                    System.out.println("Empty!!");
                    throw new Exception();
                }
                return str;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static String GetIsbn(String msg, String errorMsg) {
        String str = new String();
        while (true) {
            try {
                System.out.println(msg);
                str = scan.nextLine();
                if (!str.matches("^(\\d{13}|\\s*)?$")) {
                    System.out.println("You must input 13 numbers!");
                    throw new Exception();
                }
                if (str.isEmpty()) {
                    System.out.println("Empty!!!");
                    throw new Exception();
                }
                return str;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static String getTitle(String msg, String errorMsg) {
        String name = new String();

        while (true) {
            try {
                System.out.println(msg);
                name = scan.nextLine();
                if (!name.matches("[a-zA-Z].+")) {
                    throw new Exception();
                }
                return name;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static float getPrice(String msg, String errorMsg, float min, float max) {
        float number;
        if (min > max) {
            float t = min;
            min = max;
            max = t;
        }
        while (true) {
            try {
                System.out.println(msg);
                number = Integer.parseInt(scan.nextLine());
                if (!(number >= min && number <= max)) {
                    throw new Exception();
                }
                return number;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

}
