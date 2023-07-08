package com.techelevator;
import java.util.Scanner;

public class BankAccount {
        private String accountNumber;
        private String accountHolderName;
        private double checkingBalance;
        private double savingBalance;

        public BankAccount(String accountNumber, String accountHolderName) {
            this.accountNumber = accountNumber;
            this.accountHolderName = accountHolderName;
            this.checkingBalance = 0.0;
            this.savingBalance = 0.0;
        }

        public void deposit(String accountType, double amount) {
            if (accountType.equals("checking")) {
                this.checkingBalance += amount;
            } else if (accountType.equals("saving")) {
                this.savingBalance += amount;
            } else {
                System.out.println("Invalid account type!");
            }
        }

        public void withdraw(String accountType, double amount) {
            if (accountType.equals("checking")) {
                if (amount > this.checkingBalance) {
                    System.out.println("Insufficient balance!");
                } else {
                    this.checkingBalance -= amount;
                }
            } else if (accountType.equals("saving")) {
                if (amount > this.savingBalance) {
                    System.out.println("Insufficient balance!");
                } else {
                    this.savingBalance -= amount;
                }
            } else {
                System.out.println("Invalid account type!");
            }
        }

        public void displayBalance() {
            System.out.println("Account Holder Name: " + this.accountHolderName);
            System.out.println("Account Number: " + this.accountNumber);
            System.out.println("Checking Account Balance: $" + this.checkingBalance);
            System.out.println("Saving Account Balance: $" + this.savingBalance);
        }

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter account number: ");
            String accountNumber = scanner.nextLine();

            System.out.print("Enter account holder name: ");
            String accountHolderName = scanner.nextLine();

            BankAccount bankAccount = new BankAccount(accountNumber, accountHolderName);

            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Display Balance");
                System.out.println("4. Exit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter account type (checking/saving): ");
                        String accountType = scanner.next();

                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();

                        bankAccount.deposit(accountType, depositAmount);
                        break;

                    case 2:
                        System.out.print("Enter account type (checking/saving): ");
                        accountType = scanner.next();

                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();

                        bankAccount.withdraw(accountType, withdrawAmount);
                        break;

                    case 3:
                        bankAccount.displayBalance();
                        break;

                    case 4:
                        System.out.println("Exiting program...");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice!");
                }
            }
        }
    }
