package client;

import java.rmi.Naming;
import java.util.Scanner;

import common.Account;

public class AccountClient {

    //private field to store user choise for menu
    private static int choise;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            //looking for the stub with the name given in server
            Account stub = (Account) Naming.lookup("localhost");

            //setting user details
            stub.setName("John Raymond");
            stub.setBalance(1000.0);

            //creating an instance of menuimpl class
            MenuImpl menu = new MenuImpl();
            
            //creating an instance of transactionimpl class
            TransactionImpl transaction = new TransactionImpl();

            //cleaing the console
            menu.clearScreen();

            //displaying a welcome message
            menu.showWelcomeMessage(stub.getName());

            while (true) {
                //displaying the menu
                menu.showMenu();
                
                //checking of the input is valid
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input, please select a valid option");
                    scanner.next();
                    continue;
                }
                choise = scanner.nextInt();

                //performing actions based on user choise
                switch (choise) {
                    case 1:
                        transaction.displayBalance(stub);
                        break;
                    case 2:
                        transaction.withdrawAmount(stub, scanner);
                        break;
                    case 3:
                        transaction.depositAmount(stub, scanner);
                        break;
                    case 4:
                        transaction.exit();
                        break;
                    default:
                        menu.clearScreen();
                        System.out.println("Invalid input, please select a valid option");
                        break;
                }
            }
        } catch (Exception ex) {
            System.out.println("Client error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}