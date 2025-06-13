package fundamentals.methods;
import java.util.Scanner;

public class GreetUser {
    /*Write a method that asks a user for their name, then another method that greets the user by name*/
    public static void main(String[] args) {
        // we're using the main method as a control mechanism
        // instead of doing everything inside this 'main' method, make calls to methods
        String name = getUserName();
        greetUser(name);
    }

    // returns a value of String (which is the user's name)
    public static String getUserName() {
        System.out.println("Enter your name");
        Scanner scanner = new Scanner(System.in);

        // note that even if line 8 and line 17 share the same variable 'name', it is scoped inside the method it was declared in
        String name = scanner.next();
        scanner.close();

        return name;
    }

    // greetUser method doesn't return anything, just prints out a greeting
    public static void greetUser(String name) {
        System.out.println("Hello " + name + "!");
    }
}
