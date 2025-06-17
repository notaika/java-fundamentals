package fundamentals.data_structures;
import java.util.HashSet;
import java.util.Set;

public class FruitSet {
    /* Create a Set of fruits */
    public void setDemo() {
        /*A 'set' is an interface, so you cannot instantiate it
        *   - You cannot do: `Set<String> mySet = new Set<>();`
        *   - Must use a class that implements Set: `Set<String> mySet = new HashSet<>();`  <- no duplicates, fast access & no order
        *                                                              = new LinkedHashSet<>(); <- keeps order
        *                                                              = new TreeSet<>(); <- sorted automatically (must be comparable)
        *                                                              = ...etc
        * My understanding: You're essentially using polymorphism to reference one of the classes above through the Set interface.
        *
        * Q: But then why do we need to reference it as a Set interface rather than just it's own object?
        * A: Heart of polymorphism; allows for more flexibility, so your code isn't locked into a specific implementation.
        *   - I guess if you did HashSet<String> items = new HashSet<>(); you're tied to only HashSet unless you go back and change every line of code that uses items
        *   - Maybe you don't know what kind of Set you'll need in the future, or might want to write code that works for any kind of Set
        *   - Also now your code referenced with Set on an interface level, now works with any Set implementation (any one of the classes that implements Set)
        * Though keep in mind that you don't have access to the class methods defined in HashSet, TreeSet, etc. (if they even have any)*/

        Set<String> fruits = new HashSet<>();

        // Collections store OBJECTS - not primitives; use wrapper classes
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("lemon");
        fruits.add("lemon");

        System.out.println("Add fruit objects to Set: " + fruits.toString()); // [banana, apple, lemon]
        /*Notice that it doesn't add the objects in the order we added it in. Also, the duplicate lemon only shows up once.
        *   - Remember that a Set is an UNORDERED collection of UNIQUE objects (insertion order is not guaranteed, but possible)
        *   - We used HashSet, so it uses HashCodes to decide the order
        *   - But if you use a LinkedHastSet, then the insertion order will be kept*/

        fruits.remove("banana");
        System.out.println("Remove \"banana\" from Set: " + fruits.toString());

        System.out.println("The size (length) of this set is: " + fruits.size());

        // Could initialize a Set with values, but they are immutable (cannot add/remove/change anything after it's initialized)
        Set<String> sweetFruits = Set.of("strawberry", "grapes", "pear");
        System.out.println("Initialized immutable set: " + sweetFruits);
        // sweetFruits.add("blueberry"); <- running this will throw an error.
    }
}
