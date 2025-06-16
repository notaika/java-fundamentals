package fundamentals.abstraction;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(25, 10);
        rectangle.print();

        double area = rectangle.calculateArea();
        System.out.println(area);
    }
}
