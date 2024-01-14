import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ATMMain {
    protected static final Map<String, String> userCredentials = new HashMap<>();
    protected static final Map<String, Double> accountBalances = new HashMap<>();
    protected static final Map<String, String> transactionHistory = new HashMap<>();

    static {
        // Sample user credentials and initial account balances (replace with your own)

        userCredentials.put("Vamshi", "1234");   //1

        userCredentials.put("Krishna", "5678");  //2
        
        userCredentials.put("Ajay", "9101");     //3
        
        userCredentials.put("Pavan", "1213");    //4
        
        userCredentials.put("Abhishek","1314"); //5
        
        userCredentials.put("Ram", "1516");      //6
        
        userCredentials.put("Revanth", "1718");  //7
        
        userCredentials.put("Arun", "1920");     //8
         
        userCredentials.put("Ishan", "2122");    //9
        
        userCredentials.put("Avani", "2223");    //10
        


        accountBalances.put("Vamshi", 1000.0);

        accountBalances.put("Krishna", 1500.0);

        accountBalances.put("Ajay", 2000.0 );

        accountBalances.put("Pavan", 2500.0);

        accountBalances.put("Abhishek", 3000.0);

        accountBalances.put("Ram", 3500.0);

        accountBalances.put("Revanth", 4000.0);

        accountBalances.put("Arun", 4500.0);

        accountBalances.put("Ishan", 5000.0);

        accountBalances.put("Avani", 10000.0);
  


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM Interface!");
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter User PIN: ");
        String userPin = scanner.nextLine();

        if (validateUser(userId, userPin)) {
            System.out.println("Authentication successful. You are now logged in.");

            boolean continueTransactions = true;
            while (continueTransactions) {
                displayMenu();
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        TransactionHistory.showTransactionHistory(userId);
                        break;
                    case 2:
                        Withdrawal.performWithdrawal(userId);
                        break;
                    case 3:
                        Deposit.performDeposit(userId);
                        break;
                    case 4:
                        Transfer.performTransfer(userId);
                        break;
                    case 5:
                        continueTransactions = false;
                        System.out.println("Logging out.");
                        System.out.println("Thank you for using the ATM Interface!");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        System.out.println("Please try again.");
                }
            }
        } else {
            System.out.println("Authentication failed.");
            System.out.println("Exiting...");
        }
    }

    private static boolean validateUser(String userId, String userPin) {
        return userCredentials.containsKey(userId) && userCredentials.get(userId).equals(userPin);
    }

    private static void displayMenu() {
        System.out.println("\nChoose an option:");
        System.out.println("1. View Transactions History");
        System.out.println("2. Withdraw Funds");
        System.out.println("3. Deposit Funds");
        System.out.println("4. Transfer Funds");
        System.out.println("5. Logout");
        System.out.print("Enter your choice: ");
    }
}

class TransactionHistory {
    public static void showTransactionHistory(String userId) {
        System.out.println("\nTransaction History for " + userId + ":");
        if (ATMMain.transactionHistory.containsKey(userId)) {
            System.out.println(ATMMain.transactionHistory.get(userId));
        } else {
            System.out.println("No transactions yet.");
        }
    }
}

class Withdrawal {
    public static void performWithdrawal(String userId) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (isValidAmount(amount) && hasSufficientFunds(userId, amount)) {
            ATMMain.accountBalances.put(userId, ATMMain.accountBalances.get(userId) - amount);
            updateTransactionHistory(userId, "Withdrawal: -$" + amount);
            System.out.println("Withdrawal successful. Remaining balance: $" + ATMMain.accountBalances.get(userId));
        } else {
            System.out.println("Invalid amount or insufficient funds. Please try again.");
        }
    }

    private static boolean isValidAmount(double amount) {
        return amount > 0;
    }

    private static boolean hasSufficientFunds(String userId, double amount) {
        return amount <= ATMMain.accountBalances.get(userId);
    }

    private static void updateTransactionHistory(String userId, String transaction) {
        if (ATMMain.transactionHistory.containsKey(userId)) {
            String history = ATMMain.transactionHistory.get(userId);
            history += "\n" + transaction;
            ATMMain.transactionHistory.put(userId, history);
        } else {
            ATMMain.transactionHistory.put(userId, transaction);
        }
    }
}

class Deposit {
    public static void performDeposit(String userId) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();

        if (isValidAmount(amount)) {
            ATMMain.accountBalances.put(userId, ATMMain.accountBalances.get(userId) + amount);
            updateTransactionHistory(userId, "Deposit: +$" + amount);
            System.out.println("Deposit successful. New balance: $" + ATMMain.accountBalances.get(userId));
        } else {
            System.out.println("Invalid amount. Please try again.");
        }
    }

    private static boolean isValidAmount(double amount) {
        return amount > 0;
    }

    private static void updateTransactionHistory(String userId, String transaction) {
        if (ATMMain.transactionHistory.containsKey(userId)) {
            String history = ATMMain.transactionHistory.get(userId);
            history += "\n" + transaction;
            ATMMain.transactionHistory.put(userId, history);
        } else {
            ATMMain.transactionHistory.put(userId, transaction);
        }
    }
}

class Transfer {
    public static void performTransfer(String senderUserId) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the recipient's User ID: ");
        String recipientUserId = scanner.nextLine();

        if (isValidRecipient(senderUserId, recipientUserId)) {
            System.out.print("Enter the amount to transfer: ");
            double amount = scanner.nextDouble();

            if (isValidAmount(amount) && hasSufficientFunds(senderUserId, amount)) {
                ATMMain.accountBalances.put(senderUserId, ATMMain.accountBalances.get(senderUserId) - amount);
                ATMMain.accountBalances.put(recipientUserId, ATMMain.accountBalances.get(recipientUserId) + amount);

                updateTransactionHistory(senderUserId, "Transfer to " + recipientUserId + ": -$" + amount);
                updateTransactionHistory(recipientUserId, "Transfer from " + senderUserId + ": +$" + amount);

                System.out.println("Transfer successful.");
                System.out.println("Your remaining balance: $" + ATMMain.accountBalances.get(senderUserId));
            } else {
                System.out.println("Invalid amount or insufficient funds. Please try again.");
            }
        } else {
            System.out.println("Invalid recipient User ID. Please try again.");
        }
    }

    private static boolean isValidRecipient(String senderUserId, String recipientUserId) {
        return ATMMain.userCredentials.containsKey(recipientUserId) && !senderUserId.equals(recipientUserId);
    }

    private static boolean isValidAmount(double amount) {
        return amount > 0;
    }

    private static boolean hasSufficientFunds(String userId, double amount) {
        return amount <= ATMMain.accountBalances.get(userId);
    }

    private static void updateTransactionHistory(String userId, String transaction) {
        if (ATMMain.transactionHistory.containsKey(userId)) {
            String history = ATMMain.transactionHistory.get(userId);
            history += "\n" + transaction;
            ATMMain.transactionHistory.put(userId, history);
        } else {
            ATMMain.transactionHistory.put(userId, transaction);
        }
    }
}
