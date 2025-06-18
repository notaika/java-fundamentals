package fundamentals.data_structures;
import java.util.LinkedList;
import java.util.Queue;

public class FruitQueue {
    /*Create a Queue of Fruits*/
    public void queueDemo() {
        /*A 'Queue' is an interface, so you cannot instantiate it
         *   - Must use a class that implements Queue: `Queue<String> mySet = new ArrayDeque<>();` <- resizable array with access to both ends of structure (stack and queue behaviour in one class)
         *                                                                  = new LinkedList<>(); <- doubly-linked list; basic fifo queue
         *                                                                  = new PriorityQueue<>(); <- orders by PRIORITY, not insertion (NOT FIFO)
         *                                                                  = new ArrayBlockingQueue<>(int fixedLength); <- bounded queues (fixed size)
         *                                                                  = ...etc
         *
         */

        // Note: We're using LinkedList, so it follows basic FIFO rules, but this doesn't always apply (PriorityQueue/ArrayDeque)
        Queue<String> fruits = new LinkedList<>(); //Though it's faster to use ArrayDeque as default for FIFO (avoids node allocation)
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("lemon");
        fruits.add("orange");

        System.out.println("Add fruit objects to Queue: " + fruits); // [apple, banana, lemon, orange]

        fifoRemoval(fruits);

        // Queue is now empty; so it mutates the Queue in memory
        System.out.println(fruits);
    }
    public void fifoRemoval(Queue<String> fruits) {
        /*In Lists, to remove an object from a List, we had to specify the index or if it matches the reference
         *   - In Queue (LINKED LIST), it's first in, first out */
        System.out.println("""
        ====================
        INITIALIZING REMOVAL
        ====================""");
        int i = 1;
        System.out.printf("Starting Queue Collection: %s | Queue Length: %d | ", fruits, fruits.size());

        while (!fruits.isEmpty()) {
            System.out.println("- REMOVING FIRST ITEM IN QUEUE: " + fruits.peek());
            fruits.poll();

            System.out.printf("Current iteration: %d | Queue: %s | Queue Length: %d%n", i, fruits, fruits.size());

            if (fruits.isEmpty()) {
                System.out.println("QUEUE IS NOW EMPTY");
            }

            i++;
        }
    }
}
