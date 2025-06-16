package fundamentals.inheritance.chain_of_inheritance;

public class Garage {
    /*Show's the chain of inheritance from Vehicle -> Car -> Coupe*/
    public static void main(String[] args) {
        Coupe myCar = new Coupe();
        myCar.setColor("red");
        myCar.setMileage(11000);
        System.out.printf("My car is %s and has ran %,d kilometres.", myCar.getColor(), myCar.getMileage());
    }


    /*Random brain dump about how I understand chain of inheritance and weird AHA moments...
    * - It's mentioned that the 'Object' class is the GODFATHER of all other classes... what does this mean?
    * - Object is the topmost class in Java every class implicitly extends Object even if you don't explicitly write 'extends Object'
    *   - Because every class is a child of some other class, and all of them eventually come from the Object class
    *   - The root superclass of every class in Java is `public class Object`
    *   - Now that I think about it, even if you have 99% of your classes extend from another parent class, there will always be your first class
    *   which extends from nothing <- this automatically extends from the Object class implicitly
    *       - AHH. That's why we have all these common 'built-in' methods.
    *       - They're technically just methods defined inside the Object class in java.lang package that is inherited by all
    * - A class can only explicitly inherit from one other class (only one class after 'extends')
    *   - But the child inherits everything down the chain; though parents obviously cannot inherit from their children
    * */
}
