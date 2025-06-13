package fundamentals.loops;
import java.util.Scanner;

public class AddNumbers {
    /*Write a program that allows a user to enter two numbers and sums up the two numbers
    * The user should be able to repeat this action until they indicate they are done*/
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // need a variable to control the condition; let's set one to a boolean
        boolean runAgain;

        do {
            // ask for the first number
            System.out.println("Enter the first number:");
            double firstNum = scanner.nextDouble();

            // ask for the second number
            System.out.println("Enter the second number");
            double secondNum = scanner.nextDouble();

            // print out sum
            // firstNum + secondNum is in its own parenthesis to indicate it's a separate use for "+"
            System.out.println("Sum: " + (firstNum + secondNum));

            // ask user if they want to continue using the program
            System.out.println("Would you like to run again? (Yes: enter 'true' or No: enter 'false')");

            // note that 1 and 0 are also valid booleans
            runAgain = scanner.nextBoolean();

            // note that we did not close the scanner inside the do! scanner.close() will close the underlying input stream
            // we cannot reopen or reuse it
        } while (runAgain);

        // call the scanner here
        scanner.close();
    }
}

// Q: Can't this program work with a 'while' loop?
// A: Yes, you would have to initialize the runAgain variable with 'true' though, then change alter it inside the while loop
