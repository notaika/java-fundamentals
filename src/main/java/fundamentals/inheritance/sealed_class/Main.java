package fundamentals.inheritance.sealed_class;

public class Main {
    public static void main(String[] args) {
        Shape s1 = new Rectangle();
        Shape s2 = new Circle();
        Shape s3 = new Square();

        s1.draw(); // Drawing a rectangle
        s2.draw(); // Drawing a circle
        s3.draw(); // Drawing a square
    }
}
