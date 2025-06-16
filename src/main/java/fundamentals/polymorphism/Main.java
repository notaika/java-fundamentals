package fundamentals.polymorphism;

public class Main {
    /*Polymorphism; a subclass can be treated as if it were a superclass object*/
    public static void main(String[] args) {
        Dog goldie = new Dog();
        goldie.makeSound();
        goldie.fetch();

        // Runtime polymorphism + implicit upcast
        Animal dog = new Dog();
        dog.makeSound();
//        dog.fetch(); does not work, because 'fetch' method is not defined in Animal (implicit upcast)

        Cat persian = new Cat();
        persian.makeSound();
        persian.scratch();

        // Runtime polymorphism + implicit upcast
        Animal cat = new Cat();
        cat.makeSound();
//        cat.scratch(); does not work, because 'scratch' method is not defined in Animal (implicit upcast)

        // ============ Explicit Type Casting Examples start here ==============
        // Downcast 'dog' to play fetch
        ((Dog) dog).fetch(); // dog.fetch(); explicitly on Animal; this is a temporary cast to provide access

        // Downcast 'cat' to scratch
        Cat notACat = (Cat) cat;
        notACat.scratch();
    }
}
