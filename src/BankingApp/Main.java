package BankingApp;

import java.util.Scanner;

public class Main {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static Scanner scanner = new Scanner(System.in);
    static Bank bank = new Bank();

    public static void main(String[] args) {
        commandRunner();
    }

    static void printError(String message) {
        System.out.println(ANSI_RED + "Error: " + message);
    }

    static void printInfo(String message) {
        System.out.println(ANSI_BLUE + message);
    }

    static void printSuccess(String message) {
        System.out.println(ANSI_GREEN + "Success: " + message);
    }

    static int getInput() {
        String inputString = scanner.nextLine();
        try {
            return Integer.parseInt(inputString);
        } catch (Exception e) {
            return 8;
        }
    }
    static void commandRunner() {
        Integer command = null;
        Integer input = null;

        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // print instructions
            System.out.println(ANSI_WHITE + "==================================");
            System.out.println("Please select an option:");
            System.out.println("1. Deposit funds");
            System.out.println("2. Withdraw funds");
            System.out.println("3. Check balance");
            System.out.println("4. Exit");
            System.out.println("==================================");

            String commandString = scanner.nextLine();
            String inputString = null;

            try {
                command = Integer.parseInt(commandString);
            } catch (Exception e) {
                continue;
            }

            switch (command) {
                case 1:
                    printInfo("How much do you want to deposit?");
                    input = getInput();
                    bank.deposit(input);
                    printSuccess("You deposited funds (" + input + ")");
                    break;
                case 2:
                    printInfo("How much do you want to withdraw?");
                    input = getInput();
                    int balance = bank.withdraw(input);

                    if (balance >= 0) {
                        printSuccess("You withdrew funds (" + input + ")");
                    } else {
                        printError("You can't withdraw more than your balance!");
                    }

                    break;
                case 3:
                    printInfo("Current Balance: " + bank.checkBalance());
                    break;
                case 8:
                    printError("Input Error!");
                    break;
                default:
                    break;
            }
        }
         while (command != 4);
    }
}
