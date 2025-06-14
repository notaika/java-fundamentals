package fundamentals.objects;

public class HomeAreaCalculator {
    /*Write a class that creates instances of Rectangle to find the total are aof two rooms in a house*/
    public static void main(String[] args) {

        // instantiating with a default constructor
        // creates an instance (object) stored in the variable name 'room1' with the type of 'Rectangle2'
        Rectangle room1 = new Rectangle();

        // this object now has access to all the methods
        room1.setLength(50);
        room1.setWidth(25);
        double areaOfRoom1 = room1.calculateArea();

        // instantiating with the all-args constructor
        // creates an instance (object) stored in the variable name 'room2' with the type of 'Rectangle2'
        Rectangle room2 = new Rectangle(30, 75);
        // notice we don't have to set those values with the setters anymore
        double areaOfRoom2 = room2.calculateArea();

        double totalArea = areaOfRoom1 + areaOfRoom2;
        System.out.println("Area if both rooms: " + totalArea);
    }
    /*We didn't have to import "Rectangle2", why? -> Because we're within the same package
    * If 'Rectangle2' was in a different package (e.g. shapes)...
    * have to: `import shapes.Rectangle2;` at the top of this file
    *   - only works as long as packages are within the same root project (src)
    *   - different src? Check obsidian notes*/
}
