package fundamentals.inheritance.override_methods;

import fundamentals.objects.Rectangle;

public class Main {

    public static void main(String[] args) {
        /*Create a Square class that inherits from Rectangle and overrides its calculatePerimeter() method*/
        Square square = new Square(25);
        double squarePerimeter = square.calculatePerimeter();
        System.out.printf("The perimeter of the given square is %.2f cm.%n", squarePerimeter);

        /*Create a print() method in the superclass then overload it in the subclass*/
        Rectangle rectangle = new Rectangle();
        rectangle.print();
        square.print("Square");
    }
}
