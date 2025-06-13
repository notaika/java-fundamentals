package fundamentals.conditionals;

import java.util.Scanner;

public class GradeMessageSE {
    /* Have a user enter their letter grade and using the switch EXPRESSION
     * print out a message letting them know how they did*/
    public static void main(String[] args) {
        System.out.println("Enter your letter grade");
        Scanner scanner = new Scanner(System.in);

        // Scanner does not have a method .nextChar(); - therefore we use String
        String grade = scanner.next();
        scanner.close();

        String message = switch (grade) {
            case "A" -> "Excellent job!";
            case "B" -> "Great job!";
            case "C" -> "Good job!";
            case "D" -> "You need to work a little harder";
            case "F" -> "See me after class.";
            default -> "Enter a valid grade";
        };

        System.out.println(message);
    }
}
