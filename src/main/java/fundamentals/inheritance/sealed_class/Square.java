package fundamentals.inheritance.sealed_class;

public final class Square extends Rectangle {
    /*In human words...
     *   The class 'Square' is "final"
     *   'Square' inherits from a "sealed" class 'Rectangle'
     *   'Square' cannot be inherited from; will be the last of its descendants in this hierarchy
     *    "final" keyword means that the class cannot have any subclasses*/
    @Override
    public void draw() {
        System.out.println("Drawing a square");
    }
}
