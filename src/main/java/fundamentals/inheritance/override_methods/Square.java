package fundamentals.inheritance.override_methods;
import fundamentals.objects.Rectangle;

public class Square extends Rectangle {

    public Square(double side) {
        super(side, side);
    }

    @Override
    public double calculatePerimeter() {
        return sides * length;
    }

    public void print(String str) {
        System.out.println("I am " + str);
    }
}
