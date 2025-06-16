package fundamentals.abstraction.interfaces;

public interface Product {
    /*When creating fields in interfaces...
    *   - they cannot be 'private'
    *   - they MUST be initialized; not just declared because interface fields are final
    * Only give interfaces fields if you already know the value, and that value should NEVER change
    * 99% of the time, don't need fields in interfaces*/

    // By default, these methods are abstract
    String getName();
    void setName(String name);
}
