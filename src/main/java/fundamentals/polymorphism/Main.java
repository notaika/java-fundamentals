package fundamentals.polymorphism;

public class Main {
    /*Polymorphism; a subclass can be treated as if it were a superclass object
    * These notes are a messssss zzzzz...*/
    public static void main(String[] args) {
        System.out.println("=== polymorphism + implicit upcasting ===");
        Animal animal = new Animal();
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
        System.out.println("=== explicit downcasting ===");
        ((Dog) dog).fetch(); // dog.fetch(); explicitly on Animal; this is a temporary cast to provide access

        // Downcast 'cat' to scratch
        Cat notACat = (Cat) cat;
        notACat.scratch();

        // ============ instanceof + typecasting ==============
        System.out.println("=== instanceof + typecasting ===");
        Animal[] animals = {animal, dog, cat};
        whatCanDo(animals);

        feed(dog);
        feed(cat);
        feed(animal);
    }

    /*Great use case of instanceof in typecasting*/
    public static void whatCanDo(Animal[] animals) {
        for (Animal animal : animals) {
            if (animal instanceof Dog) {
                ((Dog) animal).fetch();
            } else if (animal instanceof Cat) {
                ((Cat) animal).scratch();
            } else {
                System.out.println("The animal does a specific behaviour");
            }
        }
    }

    // instanceof pattern matching
    public static void whatCanDo2(Animal[] animals) {
        for (Animal animal : animals) {
            if (animal instanceof Dog dog) {
                dog.fetch();
            } else if (animal instanceof Cat cat) {
                cat.scratch();
            } else {
                animal.makeSound();
            }
        }
    }

    public static void feed(Animal animal) {
        if (animal instanceof Dog) {
            System.out.println("Here's some dog food");
        } else if (animal instanceof Cat) {
            System.out.println("Here's some cat food");
        } else {
            System.out.println("Here's some non-specific animal food");
        }
    }
}
