package fundamentals.conditionals;
import java.util.Scanner;

public class QuoteCalculator {
    /* All salespeople are expected to make 10 sales each week.
        - For those who do, they receive a congratulatory message.
        - For those who don't, they are informed of how many sales they were short.*/
    public static void main(String[] args) {
        int quota = 10;

        System.out.println("How many sales did you make this week?");
        Scanner scanner = new Scanner(System.in);
        int sales = scanner.nextInt();
        scanner.close();

        // works similar to JavaScript
        if (sales >= 10) {
            System.out.println("Congratulations! You hit the weekly sales goal.");
        } else {
            int salesShort = quota - sales;
            System.out.println("You were short " + salesShort + " sales this week.");
        }
    }
}
