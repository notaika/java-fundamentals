package objects;

public class Rectangle2 {
    /*Add a default constructor and an all-arg constructor to the Rectangle class*/

    private double length;
    private double width;
    private int sides = 4;

    // note that all classes have their own default constructor - you just can't see it.
    // if you wanted to change default values, you would explicitly write the default constructor

    // default constructor
    public Rectangle2() {
        /*using setter method or 'this' would be fine and would work
        if you have setter methods, it's best to use those, don't want to be in the habit of another class
        directly assigning your fields - more scalable; if you change setter - don't have to rewrite constructor*/
        setLength(0); //this.length = 0;
        setWidth(0); //this.width = 0;
    }

    // all-args constructor
    public Rectangle2(double length, double width) {
        setLength(length);
        setWidth(width);
    }

    // setter and getter methods
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

    // methods
    public double calculatePerimeter() {
        return (2 * length) + (2 * width);
    }

    public double calculateArea() {
        return length * width;
    }
}