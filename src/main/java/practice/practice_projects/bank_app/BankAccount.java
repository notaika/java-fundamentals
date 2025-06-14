package practice.practice_projects.bank_app;

public class BankAccount {
    private String name;
    private int age;
    private double balance;
    private String accountId;

    public BankAccount(String name, int age, double balance) {
        setName(name);
        setAge(age);
        setBalance(balance);
    }

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

    public int loggedInMenuInterface(java.util.Scanner scanner) {
        System.out.println("Welcome to Java Bank!");
        System.out.println("Hello " + name + "!");
        System.out.println("How would you like to proceed?");
        System.out.println("1: Withdraw Money\n2: Deposit Money\n3: Check Balance\n4: Logout");
        return scanner.nextInt();
    }

    public double getMoneyInput(String prompt, java.util.Scanner scanner) {
        System.out.println(prompt);
        return scanner.nextDouble();
    }

    public void depositMoney(java.util.Scanner scanner) {
        double amount = getMoneyInput("How much would you like to deposit?", scanner);
        scanner.nextLine(); // clear newline

        if (amount < 1) {
            System.out.println("ERROR: Deposit cannot be 0 or negative");
            return;
        }

        setBalance(balance + amount);
        System.out.println("Success! New Account Balance: $" + balance);
    }

    public void withdrawMoney(java.util.Scanner scanner) {
        double amount = getMoneyInput("How much would you like to withdraw?", scanner);
        scanner.nextLine(); // clear newline

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
}
