package fundamentals.methods;
import java.util.Scanner;

public class InstantCreditCheck {
    /*Write a program that approves anyone who:
        - makes at least $25,000
        - has a credit score of 700 or better
    Reject all others...*/

    // you can define variables at a class level
    // the scope of these variables are accessible to all methods define inside this class
    static double requiredSalary = 25000;
    static int requiredCreditScore = 700;

    // move scanner at a higher level (class level in this case) to give access to other methods
    // added static keyword because static methods can only access other static modified stuff
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // we're going to use the main method to control the flow of the program
        double salary = getSalary();
        int creditScore = getCreditScore();

        //after getting the return values of our methods, we can close the scanner here...
        scanner.close();

        boolean isQualified = isUserQualified(salary, creditScore);
        notifyUser(isQualified);
    }

    public static double getSalary() {
        System.out.println("What is your salary?");
        // dont need int salary = scanner.nextDouble(); return salary. it's redundant
        return scanner.nextDouble();
    }

    public static int getCreditScore() {
        System.out.println("What is your credit score?");
        // same for redundancy here
        return scanner.nextInt();
    }

    public static boolean isUserQualified(double salary, int creditScore) {
        // can simplify the same as JavaScript one-liners
        return salary >= requiredSalary && creditScore >= requiredCreditScore;
    }

    public static void notifyUser(boolean isQualified) {
        if (isQualified)
            System.out.println("Congratulations! You have been approved.");
        else {
            System.out.println("Sorry, you do not qualify.");
        }
    }
}
