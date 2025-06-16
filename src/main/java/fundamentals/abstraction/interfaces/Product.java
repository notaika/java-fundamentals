package fundamentals.abstraction.interfaces;

public interface Product {
    /* === INTERFACE INTRODUCTION ===
    When creating fields in interfaces...
    *   - they cannot be 'private'
    *   - they MUST be initialized; not just declared because interface fields are final
    * Only give interfaces fields if you already know the value, and that value should NEVER change
    * 99% of the time, don't need fields in interfaces*/

    // By default, these methods are abstract and implicitly 'public'
    String getName();
    void setName(String name);

    String getSize();

    /* === MULTIPLE INHERITANCE WITH INTERFACES === */
    // Add methods to the Product interface to get and set the price

    /*Adding more methods to an interface breaks all the subclasses. Now we have to manually
    * override those methods in the subclass body
    *   - You can make a 'default' implementation, though remember to change it/override it if needed...
    *   - Probably just best to let it break, but good to know*/
    default double getPrice() {
        return 50;
    }

    default void setPrice(double price){

    }
}
