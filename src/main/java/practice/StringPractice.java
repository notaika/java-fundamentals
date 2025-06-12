package practice;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringPractice {
    /*Practicing + experimenting with new string methods*/
    public static void main(String[] args) {
        System.out.println("Enter word to be analyzed:");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        System.out.println("Enter the character of word to be analyzed:");
        char c = scanner.next().charAt(0);
        scanner.close();


        int strLength = getStrLength(word);
        System.out.println("String length: " + strLength);

        List<Character> strChars = getCharAt(word);
        System.out.println("String chars: " + strChars);

        boolean isStrEqual = isStrEqual(word);
        System.out.println("String equals hello?: " + isStrEqual);

        int indexOfChar = indexOfChar(c, word);
        System.out.println("String index of " + c + ": " + indexOfChar);

        String capitalized = capitalizedWord(word);
        System.out.println("Capitalized word: " + capitalized);

        String lowercased = lowercasedWord(word);
        System.out.println("Lowercased word: " + lowercased);

        String replacedStr = replaceChar(c, word);
        System.out.println("Replaced char: " + replacedStr);

        // the original string is immutable; pass-by-value
        System.out.println("Strings are immutable; original word: " + word);
    }

    public static int getStrLength(String str) {
        return str.length();
    }

    public static List<Character> getCharAt(String str) {
        List<Character> charsArr = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            charsArr.add(str.charAt(i));
        }
        return charsArr;
    }

    public static boolean isStrEqual(String str) {
        return str.equals("hello");
    }

    public static int indexOfChar(char c, String str) {
        return str.indexOf(c);
    }

    public static String capitalizedWord(String str) {
        return str.toUpperCase();
    }

    public static String lowercasedWord(String str) {
        return str.toLowerCase();
    }

    public static String replaceChar(char c, String str){
        return str.replace(c, '*');
    }
}
