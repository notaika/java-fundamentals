package fundamentals.abstraction;

/* For example, in the real world:
* Shape is `abstract`.
*   - it exists in theory, but it doesn't have a concrete existence
*   - there are different types of shapes, and those are concrete
*   - but 'Shape' as a concept by itself is `abstract`.*/

// This 'Shape' class cannot be instantiated (abstract)
public abstract class Shape {
    // This 'calculateArea' method cannot have a body (abstract)
    abstract double calculateArea();

    // Can still have regular accessible methods
    public void print() {
        System.out.println("I am a shape");
    }
}
