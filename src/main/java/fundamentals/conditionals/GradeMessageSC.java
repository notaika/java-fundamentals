package fundamentals.conditionals;
import java.util.Scanner;

public class GradeMessageSC {
    /* Have a user enter their letter grade and using the switch statement
    * print out a message letting them know how they did*/
    public static void main(String[] args) {
        System.out.println("Enter your letter grade");
        Scanner scanner = new Scanner(System.in);

        // Scanner does not have a method .nextChar(); - therefore we use String
        String grade = scanner.next();
        scanner.close();

        String message;
        switch (grade) {
            case "A":
                message = "Excellent job!";
                break;
            case "B":
                message = "Great job!";
                break;
            case "C":
                message = "Good job!";
                break;
            case "D":
                message = "You need to work a bit harder.";
                break;
            case "F":
                message = "See me after class.";
                break;
            default:
                message = "Enter a valid grade: A, B, C, D or F";
                break;
        }
        System.out.println(message);
    }
}
