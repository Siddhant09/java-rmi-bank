package client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MenuImpl extends UnicastRemoteObject {

    //creating a constructor
    MenuImpl() throws RemoteException {
        super();
    }    

    //method for displaying welcome message
    public void showWelcomeMessage(String name) throws RemoteException {
        try {
            System.out.println("============================");
            System.out.println("Connected to RMI Bank Server");
            System.out.println("============================");
            System.out.println();
            System.out.println("Hello, " + name);
        } catch (Exception ex) {
            System.out.println("Server error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }  

    //method for displaying the menu options
    public void showMenu() throws RemoteException {
        try {
            System.out.println("-----------------------------------");
            System.out.println("What would you like to do next?");
            System.out.println("1. Check your account balance");
            System.out.println("2. Withdraw money from your account");
            System.out.println("3. Deposit money into your account");
            System.out.println("4. Exit");
            System.out.println("-----------------------------------");
        } catch (Exception ex) {
            System.out.println("Server error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    //method for clearing the console
    public void clearScreen() throws RemoteException {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }    
}
