package practice.basic_practice;

import java.util.Scanner;

public class IntegerAndDoubleMethods {
    /*Integer and Double wrapper class methods practice*/
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String strWhole = getInput("Enter string of numbers (whole numbers) to be analyzed:");
        String strDouble = getInput("Enter string of numbers (float numbers) to be analyzed:");

        scanner.close();

        int strToInt = strToInt(strWhole);
        System.out.println("String to Integer: " + strToInt);

        double strToDouble = strToDouble(strDouble);
        System.out.println("String to Double: " + strToDouble);
    }

    public static String getInput(String prompt) {
        System.out.println(prompt);
        return scanner.next();
    }
    public static int strToInt(String str) {
        return Integer.parseInt(str);
    }

    public static double strToDouble(String str) {
        return Double.parseDouble(str);
    }
}
