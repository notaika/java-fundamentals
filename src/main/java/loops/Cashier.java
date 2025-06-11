package loops;
import java.util.Scanner;

public class Cashier {
    // Write a cashier program that will scan a given number of items and tally the cost
    public static void main(String[] args) {
        System.out.println("Enter the number of items you would like to scan");
        Scanner scanner = new Scanner(System.in);
        int quantity = scanner.nextInt();

        // declare and initialize outside of the loop
        double total = 0;

        for (int i = 1; i <= quantity; i++) {
            System.out.println("Enter the cost of the item");
            double cost = scanner.nextDouble();
            total += cost * i;
        }

        scanner.close();
        System.out.println("Total cost of all items: " + total);
    }
}
