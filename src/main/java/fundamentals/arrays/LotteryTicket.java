package fundamentals.arrays;
import java.util.Arrays;
import java.util.Random;

public class LotteryTicket {
    /*Create a Lottery Quick Pick application that will generate a lottery ticket with 6
    * random numbers between 1-69*/

    // length of an array declared as a constant
    // final = CANNOT CHANGE
    // LENGTH = all caps; means it's a constant
    private static final int LENGTH = 6;
    private static final int MAX_TICKET_NUMBER = 69;
    private static final Random random = new Random();

    public static void main(String[] args) {
        // Store the returned array from generateLotteryTicket()
        int[] ticket = generateLotteryTicket();

        // Print the ticket
        printTicket(ticket);
        System.out.println(Arrays.toString(ticket));
    }

    public static int[] generateLotteryTicket() {
        int[] ticket = new int[LENGTH];

        for (int i = 0; i < LENGTH; i++) {
            int randomNum;

            do {
                randomNum = generateNumbers();
            } while (searchDuplicates(ticket, randomNum));

            ticket[i] = randomNum;
        }

        return ticket; // return the generated array
    }

    public static int generateNumbers() {
        return random.nextInt(1, MAX_TICKET_NUMBER + 1);
    }

    // don't want duplicate numbers; keep generating if duplicates found
    public static boolean searchDuplicates(int[] array, int numberToSearch) {
        // enhanced for-loop; read-only by the way
        for (int num : array) {
            if (numberToSearch == num) {
                return true;
            }
        }
        return false;
    }

    public static void printTicket(int[] array) {
        Arrays.sort(array);
        System.out.println("Your lottery ticket: " + Arrays.toString(array));
    }
}
