package fundamentals.inheritance.sealed_class;

public non-sealed class Circle extends Shape {
    /*In human words...
     *   The class 'Circle' is "non-sealed"
     *   'Circle' inherits from a "sealed" class 'Shape'
     *   'Circle' opens anyone to inherit from it
     *   The "non-sealed" keyword basically allows for normal, default open-inheritance*/
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}
