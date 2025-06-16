package fundamentals.polymorphism;

public class Dog extends Animal {

    @Override
    public void makeSound() {
        System.out.println("Woof woof~");
    }

    public void fetch() {
        System.out.println("The dog plays fetch");
    }
}
