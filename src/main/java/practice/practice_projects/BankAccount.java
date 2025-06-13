package practice.practice_projects;
import java.util.Scanner;
import java.util.UUID;

/*Notes:
 * - waitForEnter() method was added so user didn't lose track of where they are in console
 * - encapsulated app into its own method to run the logics (runApp)
 * - so far only stores one account, haven't learned ArrayLists yet
 * - */

public class BankAccount {
    private String name;
    private int age;
    private double balance;
    private String accountId;

    static Scanner scanner = new Scanner(System.in);

    public BankAccount(String name, int age, double balance) {
        setName(name);
        setAge(age);
        setBalance(balance);
    }

    // setter and getter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    // methods
    public static String getUserDetails(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public static void waitForEnter() {
        System.out.println("\n(Press Enter to continue...)");
        scanner.nextLine();
    }

    public static void runApp() {
        int userInput = 0;
        BankAccount activeUser = null;
        BankAccount[] accounts = new BankAccount[1];

        while (activeUser == null) {
            userInput = loggedOutMenuInterface();
            scanner.nextLine();

            switch (userInput) {
                case 1:
                    BankAccount newAccount = BankAccount.createAccount();
                    if (newAccount == null) {
                        System.out.println("ERROR: Account creation failed.");
                        waitForEnter();
                        continue;
                    }
                    accounts[0] = newAccount;
                    waitForEnter();
                    break;
                case 2:
                    System.out.println("Enter the account ID");
                    String accId = scanner.next();
                    scanner.nextLine();

                    activeUser = BankAccount.accountLogIn(accId, accounts);
                    if (activeUser == null) {
                        System.out.println("ERROR: No account found. Please create an account and try again.");
                        waitForEnter();
                        continue;
                    }

                    activeUser = accounts[0];
                    waitForEnter();
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
            userInput = activeUser.loggedInMenuInterface();
            scanner.nextLine();

            switch (userInput) {
                case 1:
                    activeUser.withdrawMoney();
                    waitForEnter();
                    break;
                case 2:
                    activeUser.depositMoney();
                    waitForEnter();
                    break;
                case 3:
                    activeUser.checkBalance();
                    waitForEnter();
                    break;
                case 4:
                    activeUser = null;
                    System.out.println("Successfully logged out. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
                    waitForEnter();
                    break;
            }
        }
    }

    public static int loggedOutMenuInterface() {
        System.out.println("Welcome to Java Bank!");
        System.out.println("How would you like to proceed?");
        System.out.println("1: Create an Account\n2: Log-in Account\n4: Exit");
        return scanner.nextInt();
    }

    public int loggedInMenuInterface() {
        System.out.println("Welcome to Java Bank!");
        System.out.println("Hello " + name + "!");
        System.out.println("How would you like to proceed?");
        System.out.println("1: Withdraw Money\n2: Deposit Money\n3: Check Balance\n4: Logout");
        return scanner.nextInt();
    }

    public static BankAccount createAccount() {
        System.out.println("Welcome to Java Bank! To create your account we need some details");

        String name = getUserDetails("What is your name?");
        waitForEnter();

        int age = Integer.parseInt(getUserDetails("How old are you?"));
        waitForEnter();

        if (age < 18) {
            System.out.println("ERROR: Cannot create new user. Must be 18 or older");
            return null;
        }

        double balance = Double.parseDouble(getUserDetails("What is your starting balance?"));
        waitForEnter();

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

    public static BankAccount accountLogIn(String accId, BankAccount[] accounts) {
        if (accounts[0] != null && accounts[0].getAccountId().equals(accId)) {
            System.out.println("Log-in Success");
            return accounts[0];
        }
        return null;
    }

    public double getMoneyInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextDouble();
    }

    public void depositMoney() {
        double amount = getMoneyInput("How much would you like to deposit?");
        waitForEnter();

        if (amount < 1) {
            System.out.println("ERROR: Deposit cannot be 0 or negative");
            return;
        }

        setBalance(balance + amount);
        System.out.println("Success! New Account Balance: $" + balance);
    }

    public void withdrawMoney() {
        double amount = getMoneyInput("How much would you like to withdraw?");
        waitForEnter();

        if (amount < 1 || amount > balance) {
            System.out.println("ERROR: Withdrawal unsuccessful. Please double check your balance.");
            return;
        }

        setBalance(balance - amount);
        System.out.println("Success! New Account Balance: $" + balance);
    }

    public void checkBalance() {
        System.out.println("Your current account balance is: $" + balance);
    }

    // main
    public static void main(String[] args) {
        runApp();
    }
}