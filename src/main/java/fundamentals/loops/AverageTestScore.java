package fundamentals.loops;
import java.util.Scanner;

public class AverageTestScore {
    /*Find the average test scores for each student in the class
    *   - Loop 1: go through every student in the class
    *   - Loop 2: go through every test grade that student has*/
    public static void main(String[] args) {
        // Initialize variables for what we know:
        int numberOfStudents = 3;
        int numberOfTests = 4;

        Scanner scanner = new Scanner(System.in);

        // Process all of the students
        for (int i = 0; i < numberOfStudents; i++) {
            // total of all test scores per student
            double total = 0;

            // For every student, process all of their tests
            for (int j = 0; j < numberOfTests; j++) {
                System.out.println("Score for Test #" +(j + 1) + " of Student #" + (i+ 1 ));
                double score = scanner.nextDouble();
                total += score;
            }

            double average = total/numberOfTests;
            System.out.println("The average test score for student #" + (i + 1) + " is " + average);
        }
        scanner.close();
    }
}
