/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hats.main;

import java.util.Scanner;
import java.util.TreeSet;
import validation.Validation;

/**
 *
 * @author DELL
 */
public class JavaLab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int choice = 0;
        BookList obj = new BookList();
        AuthorList obj2 = new AuthorList();
        obj.loadBook("Book.dat");
        obj2.loadAuthor("Author.dat");
        do {
            Menu();
            Scanner sc = new Scanner(System.in);
            System.out.println(" Your choice :");
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid choice. Try again.");
            }
            switch (choice) {
                case 1: {
                    if (!obj.getList().isEmpty()) {
                        obj.showAll();
                    }
                    break;
                }
                case 2: {
                    int flag = 1;
                    while (flag == 1) {
                        obj.loadBook("Book.dat");
                        NewBook obj1 = new NewBook();
                        obj1.input();
                        if (obj.addBook(obj1)) {
                            System.out.println("Successfully added!");
                            obj.storeBook("Book.dat");
                        } else {
                            System.out.println("Book existed in system!");
                        }
                        String answer = new String();
                        answer = Validation.getAnswer("Do you want to continue?<Yes/No>", "Please only input yes or no");
                        if (answer.equalsIgnoreCase("yes")) {
                            flag = 1;
                        } else {
                            flag = 0;
                        }
                    }
                    break;
                }
                case 3: {
                    obj.showAll();
                    String modelInput = new String();
                    modelInput = Validation.GetBookID("Enter BookID you want to input", "Error occured!");
                    obj.updateBook(modelInput);
                    obj.storeBook("Book.dat");
                    break;
                }
                case 4: {
                    String modelInput = new String();
                    modelInput = Validation.GetBookID("Enter Book ID you want to delete", "Please try again!");
                    obj.deleteBook(modelInput);
                    obj.storeBook("Book.dat");
                    break;
                }
                case 5: {
                    if (obj.getList().isEmpty()) {
                        System.out.println("Nothing in list!");
                    } else {
                        TreeSet<Book> tmpList = new TreeSet<>();
                        String modelInput = Validation.GetBookID("Enter BookID you want to search:", "Error occured");
                        tmpList = obj.searchByBookID(modelInput);
                        if (!tmpList.isEmpty()) {
                            obj.showAll(tmpList);
                        } else {
                            System.out.println("Book not found!");
                        }
                    }

                    break;
                }
                case 6: {
                    System.out.println("Goodbye!");
                    break;
                }
            }

        } while (choice != 7);

    }

    public static void Menu() {

        System.out.println("-----------------------------------------------------");
        System.out.println("WELCOME TO HKT BOOKSTORE -@2021 by SE140620 - Tran Son Ha");
        System.out.println("1. Show the book list");
        System.out.println("2. Add Book");
        System.out.println("3. Update a Book by BookID  ");
        System.out.println("4. Delete a Book");
        System.out.println("5. Search Book");
        System.out.println("6. Exit ");
    }

}
