package fundamentals.polymorphism;

public class Cat extends Animal {

    @Override
    public void makeSound() {
        System.out.println("Meow meow~");
    }

    public void scratch() {
        System.out.println("The cat scratches the post");
    }
}
