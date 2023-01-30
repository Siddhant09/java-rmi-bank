package bank;

import java.rmi.*;

import common.Account;

public class RemoteAccount {

    public static void main(String[] args) {
        try {
            //creating an instance the class 
            Account stub = new AccountImpl();

            //binding the name of the stub
            Naming.rebind("localhost", stub);

            System.out.println("RMI Bank Server Started");
        } catch (Exception ex) {
            System.out.println("Server error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
