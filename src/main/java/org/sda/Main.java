package org.sda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.sda.impl.Kernel;

public class Main {
    
    public static void main(String[] args) {
        BufferedReader br = null;
        Kernel os = new Kernel();
    
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            printMenu();
            
            while (true) {
                String input = br.readLine();
                System.out.println("-----------------\nPlease choose an option : ");
                
                switch (input) {
                    case "0":
                        System.exit(0);
                        break;
                    case "1":
                        os.startUp();
                        System.out.println("\n");
                        break;
                    case "2":
                        System.out.println("Please input the user : ");
                        String user = br.readLine();
                        System.out.println("Please input the password : ");
                        String pass = br.readLine();
                        System.out.println(os.login(user, pass) + "\n");
                        printMenu();
                        break;
                    case "3":
                        System.out.println(os.logout());
                        break;
                    case "4":
                        os.shutDown();
                        break;
                    case "5":
                        printMenu();
                        break;
                    default:
                        System.out.println("Unsupported operation!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    private static void printMenu() {
        System.out.print("Please choose an option : \n" +
                "0 - to quit\n" +
                "1 - to start system\n" +
                "2 - to login\n" +
                "3 - to logout\n" +
                "4 - to shut down\n" +
                "5 - to print menu\n" +
                "Enter a number : \n");
    }
}
