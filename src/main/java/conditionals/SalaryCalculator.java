package conditionals;
import java.util.Scanner;

public class SalaryCalculator {
    //All sales people get a payment of $1000 for the week.
    //Sales people who exceeded 10 sales get an additional bonus of $250
    public static void main(String[] args) {
        // all given constants
        double salary = 1000;
        double bonus = 250;
        int quota = 10;

        System.out.println("How many sales did you get this week?");
        Scanner scanner = new Scanner(System.in);

        int sales = scanner.nextInt();
        scanner.close();

        // similar to JavaScript
        if (sales > quota) {
            salary = salary + bonus;
        }

        System.out.println("Salary: $" + salary);
    }
}
