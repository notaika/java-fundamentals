package practice.basic_practice;
import java.util.Scanner;

public class CharacterMethods {
    /*Character wrapper class methods practice*/
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String input = getUserInput("Enter a string of letters and numbers to analyze");

        int digitsExtracted = getAllDigits(input);
        System.out.println("Extracted digits: " + digitsExtracted);

        String lettersExtracted = getAllLetters(input);
        System.out.println("Extracted letters: " + lettersExtracted);

        boolean specialCharsExtracted = containsSpecialChar(input);
        System.out.println("String contains special characters?: " + specialCharsExtracted);
    }
    public static String getUserInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }
    public static int getAllDigits(String str) {
        StringBuilder digitsExtracted = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                digitsExtracted.append(c);
            }
        }
        return Integer.parseInt(digitsExtracted.toString());
    }
    public static String getAllLetters(String str) {
        StringBuilder lettersExtracted = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetter(c)) {
                lettersExtracted.append(c);
            }
        }
        return lettersExtracted.toString();
    }
    public static boolean containsSpecialChar(String str) {
        StringBuilder specialCharExtracted = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                specialCharExtracted.append(c);
            }
        }
        return specialCharExtracted.length() != 0;
    }
}
