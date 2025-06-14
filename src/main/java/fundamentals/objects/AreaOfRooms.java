package fundamentals.objects;
import java.util.Scanner;

public class AreaOfRooms {
    /*A redo of HomeAreaCalculator to include a calculateArea() method that accepts two Rectangles
    * and a getRoom() method that returns a Rectangle*/
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        AreaOfRooms area1 = new AreaOfRooms();
        Rectangle room1 = area1.getRoom();
        Rectangle room2 = area1.getRoom();
        double totalArea = area1.calculateAreaOfRoom(room1, room2);

        System.out.println("Area of both rooms: " + totalArea);
    }

    public Rectangle getRoom() {
        System.out.println("Enter the length of the room:");
        double length = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter the width of the room:");
        double width = scanner.nextDouble();
        scanner.nextLine();

        return new Rectangle(length, width);
    }

    public double calculateAreaOfRoom(Rectangle room1, Rectangle room2) {
        return room1.calculateArea() + room2.calculateArea();
    }
}