package fundamentals.objects;

public class Rectangle2 {
    /*Write a class that describes the fields and methods of a rectangle*/

    // Rectangle fields (data): what are some characteristics all rectangles can have?
    private double length;
    private double width;
    private int sides = 4;

    // Rectangle behaviours (methods): what can all rectangles 'do'?
    public double calculatePerimeter() {
        return (2 * length) + (2 * width);
    }

    public double calculateArea() {
        return length * width;
    }

    // Examples of getter and setter methods:
    // NOTE: 'this' refers to the current object (instance) of the class 'Rectangle'. NOT the class itself.
    // 'this' cannot be used in a static context, why?
    // because making a method static, makes it so it belongs to the CLASS thus, 'this' has no context - it must REFER TO AN OBJECT
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }
}