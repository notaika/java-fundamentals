package fundamentals.data_structures;
import java.util.HashMap;
import java.util.Map;

public class FruitMap {
    /*Create a Map of Fruits*/
    public void mapDemo() {
        /*A 'Map' is an interface, so you cannot instantiate it
         *Though unlike Set, List and Queue; it does not extend Collection interface -> it's not a collection of INDIVIDUAL elements but rather holds key:value PAIRS
         *   - Must use a class that implements Map: `Map<String> mySet = new HashMap<>();` <- fast unordered, allows null
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
}
