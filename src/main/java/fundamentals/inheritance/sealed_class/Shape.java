package fundamentals.inheritance.sealed_class;

/* Create a Shape class, where only Rectangle and Circle can directly inherit from it
   Square can directly inherit from Rectangle and cannot be inherited from
   Circle can have children from anywhere

To make a sealed class, write the keyword 'sealed' */
public sealed class Shape permits Rectangle, Circle {
    /*In human words...
     *   The class 'Shape' is "sealed"
     *   'Shape' class can only be inherited by 'Rectangle' and 'Circle'*/
    public void draw() {
        System.out.println("Drawing a shape");
    }
}
