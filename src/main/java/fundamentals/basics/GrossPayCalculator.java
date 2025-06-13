package fundamentals.basics; // package defined * required *
import java.util.Scanner; // import scanner

// class declaration
// name of the class must be the same name as the file (cae sensitive)

public class GrossPayCalculator {
    // Write a program that calculates an employee's gross pay...
    // the line below is the entry point of any standalone Java application
    public static void main(String[] args) {
        System.out.println("How many hours did you work?");

        // create a new scanner, and scan the input shown in the console
        Scanner scanner = new Scanner(System.in);
        // .next() allows us to read from the input (w/e was the last thing on the console)
        // .nextInt() - we expect the input to be an integer
        // to use what was inputted and scanned by scanner, we must store it in a variable
        int hours = scanner.nextInt();

        // hourly pay rate could be a decimal; use double for float numbers
        System.out.println("What is your hourly pay rate?");
        double rate = scanner.nextDouble();

        // done getting inputs = close the scanner
        scanner.close();

        double payRate = hours * rate;

        System.out.println("Gross Pay: " + payRate);
    }
}
