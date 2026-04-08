import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class BankAccount {
    String accountNumber;
    String username;
    double balance;

    public BankAccount(String accountNumber, String username, double balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList<BankAccount> accounts = new LinkedList<>();
        Stack<String> history = new Stack<>();
        Queue<String> billQueue = new LinkedList<>();
        Queue<BankAccount> accountRequests = new LinkedList<>();

        int mainChoice;

        do {
            System.out.println("\n1 - Enter Bank");
            System.out.println("2 - Enter ATM");
            System.out.println("3 - Admin Area");
            System.out.println("4 - Exit");
            System.out.print("Choose: ");
            mainChoice = sc.nextInt();
            sc.nextLine();

            if (mainChoice == 1) {
                System.out.println("\nBank Menu");
                System.out.println("1 - Submit account opening request");
                System.out.println("2 - Deposit money");
                System.out.println("3 - Withdraw money");
                System.out.println("4 - Add bill payment request");
                System.out.print("Choose: ");
                int bankChoice = sc.nextInt();
                sc.nextLine();

                if (bankChoice == 1) {
                    System.out.print("Enter account number: ");
                    String accNum = sc.nextLine();
                    System.out.print("Enter username: ");
                    String user = sc.nextLine();
                    System.out.print("Enter balance: ");
                    double bal = sc.nextDouble();
                    sc.nextLine();

                    accountRequests.add(new BankAccount(accNum, user, bal));
                    System.out.println("Account request submitted");
                }
                else if (bankChoice == 2) {
                    System.out.print("Enter username: ");
                    String user = sc.nextLine();

                    boolean found = false;
                    for (BankAccount acc : accounts) {
                        if (acc.username.equalsIgnoreCase(user)) {
                            System.out.print("Enter deposit amount: ");
                            double amount = sc.nextDouble();
                            sc.nextLine();

                            acc.balance += amount;
                            history.push("Deposit " + amount + " to " + user);
                            System.out.println("New balance: " + acc.balance);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account not found");
                    }
                }
                else if (bankChoice == 3) {
                    System.out.print("Enter username: ");
                    String user = sc.nextLine();

                    boolean found = false;
                    for (BankAccount acc : accounts) {
                        if (acc.username.equalsIgnoreCase(user)) {
                            System.out.print("Enter withdraw amount: ");
                            double amount = sc.nextDouble();
                            sc.nextLine();

                            if (acc.balance >= amount) {
                                acc.balance -= amount;
                                history.push("Withdraw " + amount + " from " + user);
                                System.out.println("New balance: " + acc.balance);
                            } else {
                                System.out.println("Not enough balance");
                            }
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account not found");
                    }
                }
                else if (bankChoice == 4) {
                    System.out.print("Enter bill name: ");
                    String bill = sc.nextLine();
                    billQueue.add(bill);
                    System.out.println("Bill payment request added");
                }
            }
            else if (mainChoice == 2) {
                System.out.println("\nATM Menu");
                System.out.println("1 - Balance enquiry");
                System.out.println("2 - Withdraw");
                System.out.print("Choose: ");
                int atmChoice = sc.nextInt();
                sc.nextLine();

                if (atmChoice == 1) {
                    System.out.print("Enter username: ");
                    String user = sc.nextLine();

                    boolean found = false;
                    for (BankAccount acc : accounts) {
                        if (acc.username.equalsIgnoreCase(user)) {
                            System.out.println("Balance: " + acc.balance);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account not found");
                    }
                }
                else if (atmChoice == 2) {
                    System.out.print("Enter username: ");
                    String user = sc.nextLine();

                    boolean found = false;
                    for (BankAccount acc : accounts) {
                        if (acc.username.equalsIgnoreCase(user)) {
                            System.out.print("Enter withdraw amount: ");
                            double amount = sc.nextDouble();
                            sc.nextLine();

                            if (acc.balance >= amount) {
                                acc.balance -= amount;
                                history.push("ATM Withdraw " + amount + " from " + user);
                                System.out.println("Withdraw successful. New balance: " + acc.balance);
                            } else {
                                System.out.println("Not enough balance");
                            }
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account not found");
                    }
                }
            }
            else if (mainChoice == 3) {
                System.out.println("\nAdmin Menu");
                System.out.println("1 - View pending account requests");
                System.out.println("2 - Process next account request");
                System.out.println("3 - View bill payment queue");
                System.out.println("4 - Process next bill payment");
                System.out.println("5 - View last transaction");
                System.out.print("Choose: ");
                int adminChoice = sc.nextInt();
                sc.nextLine();

                if (adminChoice == 1) {
                    if (accountRequests.isEmpty()) {
                        System.out.println("No pending requests");
                    } else {
                        for (BankAccount acc : accountRequests) {
                            System.out.println(acc.username + " - " + acc.accountNumber);
                        }
                    }
                }
                else if (adminChoice == 2) {
                    if (accountRequests.isEmpty()) {
                        System.out.println("No pending requests");
                    } else {
                        BankAccount approved = accountRequests.poll();
                        accounts.add(approved);
                        System.out.println("Processed request for: " + approved.username);
                    }
                }
                else if (adminChoice == 3) {
                    if (billQueue.isEmpty()) {
                        System.out.println("No bills in queue");
                    } else {
                        for (String bill : billQueue) {
                            System.out.println(bill);
                        }
                    }
                }
                else if (adminChoice == 4) {
                    if (billQueue.isEmpty()) {
                        System.out.println("No bills to process");
                    } else {
                        System.out.println("Processing: " + billQueue.poll());
                    }
                }
                else if (adminChoice == 5) {
                    if (history.isEmpty()) {
                        System.out.println("No transactions");
                    } else {
                        System.out.println("Last transaction: " + history.peek());
                    }
                }
            }
            else if (mainChoice == 4) {
                System.out.println("Program ended");
            }
            else {
                System.out.println("Invalid choice");
            }

        } while (mainChoice != 4);

        sc.close();
    }
}