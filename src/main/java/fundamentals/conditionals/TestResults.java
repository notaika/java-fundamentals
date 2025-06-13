package fundamentals.conditionals;
import java.util.Scanner;

public class TestResults {
    // Display a letter grade for a student based on their test score
    // A, B, C, D or F
    public static void main(String[] args) {
        System.out.println("Enter your test score:");
        Scanner scanner = new Scanner(System.in);
        double score = scanner.nextDouble();
        scanner.close();

        // a single input of a character data type is char, not a string
        // we declare the variable but don't know what it will be initialized to
        char grade;

        if (score < 60) {
            // char data types use a SINGLE QUOTE
            grade = 'F';
        } else if (score < 70) {
            grade = 'D';
        } else if (score < 80) {
            grade = 'C';
        } else if (score < 90) {
            grade = 'B';
        } else {
            grade = 'A';
        }

        System.out.println("Your Letter Grade for the test is: " + grade);
    }
}
