package fundamentals.polymorphism;

public class Main {
    /*Polymorphism; a subclass can be treated as if it were a superclass object*/
    public static void main(String[] args) {
        Dog goldie = new Dog();
        goldie.makeSound();
        goldie.fetch();

        // Runtime polymorphism
        Animal dog = new Dog();
        dog.makeSound();
//        dog.fetch(); does not work, because 'fetch' method is not defined in Animal

        Cat persian = new Cat();
        persian.makeSound();
        persian.scratch();

        // Runtime polymorphism
        Animal cat = new Cat();
        cat.makeSound();
//        cat.scratch(); does not work, because 'scratch' method is not defined in Animal
    }
}
