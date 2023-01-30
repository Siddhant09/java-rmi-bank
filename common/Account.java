package common;

import java.rmi.*;

public interface Account extends Remote {

    //method for getting name
    String getName() throws RemoteException;

    //method for setting name
    void setName(String name) throws RemoteException;

    //method for getting balance
    Double getBalance() throws RemoteException;

    //method for setting balance
    void setBalance(Double balance) throws RemoteException;

    //method for depositing amount
    Double deposit(Double amount) throws RemoteException;

    //method for withdrawing amount
    Double withdraw(Double amount) throws RemoteException;
}