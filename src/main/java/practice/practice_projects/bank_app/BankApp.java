package practice.practice_projects.bank_app;
import java.util.Scanner;
import java.util.UUID;

/*Notes:
 * - scanner.nextLine(); // clear newline was added, so user didn't lose track of where they are in console
 * - encapsulated app into its own method to run the logics (runApp)
 * - so far only stores one account, haven't learned ArrayLists yet*/

public class BankApp {
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BankApp app = new BankApp();
        app.runApp();
    }

    public void runApp() {
        int userInput = 0;
        BankAccount activeUser = null;
        BankAccount[] accounts = new BankAccount[1];

        while (activeUser == null) {
            userInput = loggedOutMenuInterface();
            scanner.nextLine();

            switch (userInput) {
                case 1:
                    BankAccount newAccount = createAccount();
                    if (newAccount == null) {
                        System.out.println("ERROR: Account creation failed.");
                        scanner.nextLine(); // clear newline
                        continue;
                    }
                    accounts[0] = newAccount;
                    scanner.nextLine(); // clear newline
                    break;
                case 2:
                    System.out.println("Enter the account ID");
                    String accId = scanner.next();
                    scanner.nextLine();

                    activeUser = accountLogIn(accId, accounts);
                    if (activeUser == null) {
                        System.out.println("ERROR: No account found. Please create an account and try again.");
                        scanner.nextLine(); // clear newline
                        continue;
                    }
                    scanner.nextLine(); // clear newline
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }

        while (userInput != 4) {
            userInput = activeUser.loggedInMenuInterface(scanner);
            scanner.nextLine();

            switch (userInput) {
                case 1:
                    activeUser.withdrawMoney(scanner);
                    scanner.nextLine(); // clear newline
                    break;
                case 2:
                    activeUser.depositMoney(scanner);
                    scanner.nextLine(); // clear newline
                    break;
                case 3:
                    activeUser.checkBalance();
                    scanner.nextLine(); // clear newline
                    break;
                case 4:
                    activeUser = null;
                    System.out.println("Successfully logged out. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
                    scanner.nextLine(); // clear newline
                    break;
            }
        }
    }

    public int loggedOutMenuInterface() {
        System.out.println("Welcome to Java Bank!");
        System.out.println("How would you like to proceed?");
        System.out.println("1: Create an Account\n2: Log-in Account\n4: Exit");
        return scanner.nextInt();
    }

    public BankAccount createAccount() {
        System.out.println("Welcome to Java Bank! To create your account we need some details");

        System.out.println("What is your name?");
        String name = scanner.nextLine();
        scanner.nextLine(); // clear newline

        System.out.println("How old are you?");
        int age = Integer.parseInt(scanner.nextLine());
        scanner.nextLine(); // clear newline

        if (age < 18) {
            System.out.println("ERROR: Cannot create new user. Must be 18 or older");
            return null;
        }

        System.out.println("What is your starting balance?");
        double balance = Double.parseDouble(scanner.nextLine());
        scanner.nextLine(); // clear newline

        if (balance < 0) {
            System.out.println("ERROR: Cannot start account with negative balance");
            return null;
        }

        String uniqueId = UUID.randomUUID().toString();
        BankAccount newAccount = new BankAccount(name, age, balance);
        newAccount.setAccountId(uniqueId);

        System.out.println("\n✅ Account Created Successfully!");
        System.out.println("Name: " + newAccount.getName());
        System.out.println("Age: " + newAccount.getAge());
        System.out.println("Balance: $" + newAccount.getBalance());
        System.out.println("Account ID: " + newAccount.getAccountId() + " use this to log in the future.");

        return newAccount;
    }

    public BankAccount accountLogIn(String accId, BankAccount[] accounts) {
        if (accounts[0] != null && accounts[0].getAccountId().equals(accId)) {
            System.out.println("Log-in Success");
            return accounts[0];
        }
        return null;
    }
}