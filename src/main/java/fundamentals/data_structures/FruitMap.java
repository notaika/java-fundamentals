package fundamentals.data_structures;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FruitMap {
    /*Create a Map of Fruits*/
    public void mapDemo() {
        /*A 'Map' is an interface, so you cannot instantiate it
         *Though unlike Set, List and Queue; it does not extend Collection interface -> it's not a collection of INDIVIDUAL elements but rather holds key:value PAIRS
         *   - Must use a class that implements Map: `Map<String> myMap = new HashMap<>();` <- fast unordered, allows null
         *                                                              = new LinkedHashMap<>(); <- keeps insertion order
         *                                                              = new TreeMap<>(); <- sorted by key
         *                                                              = new HashTable<>(); legacy; synchronized
         *                                                              = ...etc
         *
         */

        // <Key, Value> - in this case... <fruitName, fruitCalories>
        Map<String, Integer> fruitCalories = new HashMap<>();
        fruitCalories.put("apple", 95);
        //fruitCalories.put("lemon", 17); <- cannot have duplicate keys, last duplicate key overrides (20)
        fruitCalories.put("lemon", 20);
        fruitCalories.putIfAbsent("lemon", 25); // <- doesn't override; because only allows overriding if the key doesn't exist
        fruitCalories.put("banana", 105);
        fruitCalories.put("orange", 45);

        System.out.println("Add fruit objects to Map: " + fruitCalories); //{banana=105, apple=95, lemon=20} unordered; no duplicate keys

        // You remove objects in a map by key
        System.out.println("REMOVING: lemon");
        fruitCalories.remove("lemon");
        System.out.println(fruitCalories);

        // Print key value PAIRS
        loopKeyValue(fruitCalories);
        // Print keys ONLY
        loopKeys(fruitCalories);
        // Print values ONLY
        loopValues(fruitCalories);

        // Initialized Immutable Map
        Map<String, Integer> fruityCalories = Map.of(
                "apple", 95,
                "lemon", 20,
                "banana", 105,
                "orange", 45
        );

        System.out.println("Initialized immutable Map: " + fruityCalories);
    }
    public void loopKeyValue(Map<String, Integer> fruitMap) {
        // Looping through key:value pairs; basically the for...in equivalent in JS
        System.out.println("""
                =========================
                KEY-VALUE LOOP (FOR...IN)
                =========================""");
        for (Map.Entry<String, Integer> fruit : fruitMap.entrySet()) {
            String key = fruit.getKey();
            Integer value = fruit.getValue();

            System.out.printf("A %s contains a total of %d calories%n", key, value);
        }
    }
    public void loopKeys(Map<String, Integer> fruitMap) {
        // Loops through KEYS only
        System.out.println("""
                =============
                KEY-ONLY LOOP
                =============""");
        for (String key : fruitMap.keySet()) {
            System.out.println("Key: " + key);
        }
    }
    public void loopValues(Map<String, Integer> fruitMap) {
        // Loops through VALUES only
        System.out.println("""
                ===============
                VALUE-ONLY LOOP
                ===============""");
        for (int value : fruitMap.values()) {
            System.out.println("Value: " + value);
        }
    }
    public void mapViewIterator() {
        /*Some Map examples with iterator; converting the view to a 'Set' to allow for .iterator()
         *   - Most important use case is if you need to remove keys based off their values
         *   - Not like JS, where you can use for...each and .delete() - this misses edge cases anyway*/
        Map<String, Integer> fruitInventory = new HashMap<>();

        fruitInventory.put("apple", 0);
        fruitInventory.put("banana", 3);
        fruitInventory.put("grapes", 6);
        fruitInventory.put("orange", 7);
        fruitInventory.put("lemon", 3);

        // --- fruitSet() with Iterator ---
        System.out.println("1. fruitSet() - Key + Value (with iterator):");
        System.out.println("Remove fruits that are not in stock");
        Iterator<Map.Entry<String, Integer>> fruitIterator = fruitInventory.entrySet().iterator();

        while (fruitIterator.hasNext()) {
            Map.Entry<String, Integer> fruit = fruitIterator.next();

            if (fruit.getValue() <= 0) {
                System.out.println("Removing: " + fruit.getKey() + " | " + fruit.getValue() + " in stock.");
                fruitIterator.remove();
            } else {
                System.out.println("Keeping: " + fruit.getKey() + " | " + fruit.getValue() + " in stock.");
            }
        }

        // --- Final inventory after removals ---
        System.out.println("\nFinal Inventory after Checks");
        for (Map.Entry<String, Integer> fruit : fruitInventory.entrySet()) {
            System.out.println(fruit.getKey() + " → " + fruit.getValue());
        }

        // --- keySet() with Iterator ---
        System.out.println("\n2. keySet() - Key Only (with iterator):");
        Iterator<String> keyIterator = fruitInventory.keySet().iterator();
        while (keyIterator.hasNext()) {
            String key = keyIterator.next();
            System.out.println("Fruit Key: " + key);
        }

        // --- values() with Iterator ---
        System.out.println("\n3. values() - Values Only (with iterator):");
        Iterator<Integer> valueIterator = fruitInventory.values().iterator();
        while (valueIterator.hasNext()) {
            Integer value = valueIterator.next();
            System.out.println("Quantity: " + value);
        }
    }

    public static void main(String[] args) {

    }
}
