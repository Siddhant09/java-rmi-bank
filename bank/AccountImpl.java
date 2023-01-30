package bank;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.Account;

public class AccountImpl extends UnicastRemoteObject implements Account {

    //private property for storing name
    private String name;
    //private property for storing balance
    private Double balance;

    //creating a constructor
    public AccountImpl() throws RemoteException {
        super();
    }

    //method for getting name
    @Override
    public String getName() throws RemoteException {
        return name;
    }

    //method for setting name
    @Override
    public void setName(String name) throws RemoteException {
        this.name = name;
    }

    //method for getting balance
    @Override
    public Double getBalance() throws RemoteException {
        return balance;
    }

    //method for setting name
    @Override
    public void setBalance(Double balance) throws RemoteException {
        this.balance = balance;
    }

    //method for depositing amount
    @Override
    public Double deposit(Double amount) throws RemoteException {
        try {
            //adding amount to balance
            balance += amount;
        } catch (Exception ex) {
            System.out.println("Server error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return balance;
    }

    //method for withdrawing amount
    @Override
    public Double withdraw(Double amount) throws RemoteException {
        try {
            //deducting amount from balance
            balance -= amount;
        } catch (Exception ex) {
            System.out.println("Server error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return balance;
    }
}