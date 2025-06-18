package fundamentals.data_structures;
import java.util.ArrayList;
import java.util.List;

public class FruitList {
    /*Create a List of Fruits*/
    public void listDemo() {
        /*A 'List' is an interface, so you cannot instantiate it
         *   - Must use a class that implements List: `List<String> myList = new ArrayList<>();` <- resizable array
         *                                                                = new LinkedList<>(); <- doubly-linked list
         *                                                                = new Vector<>(); <- thread-safe (rarely used nowadays)
         *                                                                = ...etc
         * As a general, this is most similar to JavaScript arrays albeit more verbose, and it's TYPE-SAFE and only hold OBJECTS (primitive values need wrapper class).
         * Not as flexible either since it's never recommended to have a mixed list (array)
         */
        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("lemon");
        fruits.add("lemon");
        fruits.add("orange");
        fruits.add("lemon");

        System.out.println("Add fruit objects to List: " + fruits.toString()); // [apple, banana, lemon, orange]

        // Lists are indexed, thus we can:
        for (int i = 0; i < fruits.size(); i++) {
            System.out.printf("Fruit at index %d: %s%n", i, fruits.get(i));

            // Change fruit at index 2 to watermelon
            if (i == 2) {
                fruits.set(2, "watermelon");
                System.out.printf("Fruit at index 2 was changed to: \"%s\"%n", fruits.get(i));
            }

            // If item in arraylist matches "banana", print "banana found"
            if (fruits.get(i).equals("banana")) {
                System.out.printf("Banana found at index: %d%n", i);
            }
        }
        System.out.println(fruits.toString());
        System.out.println("The size (length) of this set is: " + fruits.size());

        // Remove fruit at index 3
        System.out.printf("Removing fruit at index 3: %s%n", fruits.get(3));
        fruits.remove(3);
        // fruits.remove("lemon") <- also works but only removes the first match
        System.out.println("New list: " + fruits.toString());

        // Can also initialize an immutable list
        List<String> moreFruits = List.of("cherry", "plum", "tomato");
        System.out.println("Initialized immutable set: " + moreFruits.toString());

        /*forEach example!
        * cleaner than enhanced for loop so use when:
        *   - want clearer/more expressive syntax
        *   - simple code (one-liner)
        *   - chaining streams/using method references
        *   - don't need 'break' and 'continue'*/
        fruits.forEach(fruit -> System.out.println("Printing each fruit with forEach: " + fruit));
    }
}
