package fundamentals.loops;
import java.util.Scanner;

public class GrossPayInputValidation {
    /* Each store employee makes $15 an hour.
    * Write a program that allows the employee to enter the number of hours worked for the week.
    * Do not allow overtime. */
    public static void main(String[] args) {
        double rate = 15;
        double maxHours = 40;

        System.out.println("How many hours did you work?");
        Scanner scanner = new Scanner(System.in);
        double hoursWorked = scanner.nextDouble();

        // if you ever enter a while loop... you must do something with one of the variables being evaluated
        // if not, you'll be stuck in an infinite loop!
        while (hoursWorked > maxHours || hoursWorked < 0) {
            System.out.println("Invalid entry. Your hours must be between 0 and 40. Try again.");
            // a chance to change the value of hoursWorked
            hoursWorked = scanner.nextDouble();
        }

        scanner.close();

        double grossPay = hoursWorked * rate;
        System.out.println("Gross pay: " + grossPay);
    }
}
