package practice.practice_projects;
import java.util.Scanner;
import java.util.UUID;

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

    public static BankAccount createAccount() {
        System.out.println("Welcome to Union Bank! To create your account we need some details");

        String name = getUserDetails("What is your name?");

        int age = Integer.parseInt(getUserDetails("How old are you?"));
        if (age < 18) {
            System.out.println("ERROR: Cannot create new user. Must be 18 or older");
            return null;
        }

        double balance = Double.parseDouble(getUserDetails("What is your starting balance?"));
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
        System.out.println("Account ID: " + newAccount.getAccountId());

        return newAccount;
    }

    public double getMoneyInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextDouble();
    }

    public void depositMoney() {
        double amount = getMoneyInput("How much would you like to deposit?");
        if (amount < 1) {
            System.out.println("ERROR: Deposit cannot be 0 or negative");
            return;
        }

        setBalance(balance + amount);
        System.out.println("Success! New Account Balance: $" + balance);
    }

    public void withdrawMoney() {
        double amount = getMoneyInput("How much would you like to withdraw?");
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

    // main + tests
    public static void main(String[] args) {
        BankAccount newAccount = BankAccount.createAccount();

        assert newAccount != null;

        newAccount.withdrawMoney();
        newAccount.depositMoney();

        scanner.close();

        newAccount.checkBalance();
    }
}

/*Could maybe add an interface on the main program in the future.*/