package client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import common.Account;

public class TransactionImpl extends UnicastRemoteObject {

    //private field to store the amount entered by user
    private Double amount;

    //creating a constructor
    TransactionImpl() throws RemoteException {
        super();
    }

    //creating an instance of menuimpl class
    MenuImpl menu = new MenuImpl();

    //method for displaying balance
    public void displayBalance(Account stub) throws RemoteException {
        menu.clearScreen();
        System.out.println("Your current account balance is $" + stub.getBalance());
    }

    //method for withdrawing amount
    public void withdrawAmount(Account stub, Scanner scanner) throws RemoteException {
        try {
            menu.clearScreen();
            System.out.println("Please enter the amount you want to withdraw");

            //checking is the input is valid
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input! Please enter amount");
                scanner.next();
                continue;
            }
            amount = scanner.nextDouble();

            //checking is entered amount is greater than 0 
            if (amount <= 0)
                System.out.println("Invalid input, amount must be greater than 0");
            //checking if the user has sufficient balance                
            else if (amount <= stub.getBalance())
                System.out.println("Amount withdrawn successfully, your current account balance is $"
                        + stub.withdraw(amount));
            else
                System.out.println("Insufficient balance");
        } catch (Exception ex) {
            System.out.println("Client error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    //method for depositing amount
    public void depositAmount(Account stub, Scanner scanner) throws RemoteException {
        try {
            menu.clearScreen();
            System.out.println("Please enter the amount you want to deposit");

            //checking isthe input is valid
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input! Please enter amount");
                scanner.next();
                continue;
            }
            amount = scanner.nextDouble();
            menu.clearScreen();
            
            //checking is entered amount is greater than 0 
            if (amount <= 0)
                System.out.println("Invalid input, amount must be greater than 0");
            else
                System.out.println("Amount deposited successfully, your current account balance is $"
                        + stub.deposit(amount));
        } catch (Exception ex) {
            System.out.println("Client error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    //method for exiting the application
    public void exit() throws RemoteException {
        try {
            menu.clearScreen();
            System.out.println("Thank you for using RMI Bank");

            //exiting the application
            System.exit(0);
        } catch (Exception ex) {
            System.out.println("Client error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
}
