package fundamentals.objects;

public class TextProcessor {
    /*Write a method that counts the number of words in a String
    * and prints them individually on new lines*/
    public static void main(String[] args) {
        countWords("Hello World!");
        reverseWords("Hello World!");
        addSpaces("HelloWorld!It'sAika!");
    }
    public static void countWords(String str) {
        String[] wordSplit = str.split(" ");
        int wordCount = wordSplit.length;

        System.out.printf("Your string has %d words.%n", wordCount);

        for (String word : wordSplit) {
            System.out.println(word);
        }
    }

    /*Write a method that prints a given String backwards*/
    public static void reverseWords(String str) {
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            System.out.print(c);
        }
        System.out.println(); // for a clean new line
    }

    /*Write a method that adds spaces to a jumbled String where all words were written together w/ no spaces
    * Each new word begins with a capital letter*/
    public static void addSpaces(String str) {
        StringBuilder modifiedStr = new StringBuilder(str);
        for (int i = 0; i < modifiedStr.length(); i++) {
            char c = modifiedStr.charAt(i);
            if (Character.isUpperCase(c) && i != 0) {
                modifiedStr.insert(i, " ");
                i++;
            }
        }

        // A better solution honestly... do it backwards
//        for (int i = modifiedStr.length() - 1; i > 0; i--) {
//            char c = modifiedStr.charAt(i);
//            if (Character.isUpperCase(c)) {
//                modifiedStr.insert(i, " ");
//            }
//        }

        System.out.println(modifiedStr);
    }
}
