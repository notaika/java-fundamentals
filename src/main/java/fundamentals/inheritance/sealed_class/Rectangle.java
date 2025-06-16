package fundamentals.inheritance.sealed_class;

public sealed class Rectangle extends Shape permits Square {
    /*In human words...
    *   The class 'Rectangle' is "sealed"
    *   'Rectangle' inherits from Shape (also sealed)
    *   'Rectangle' permits 'Square' class to inherit from it*/
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}
