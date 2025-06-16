package fundamentals.inheritance;

public class Person {
    /*Create a Person class, then create an Employee class that inherits from Person*/
    private String name;
    private int age;
    private String gender;

    // default constructor
    public Person() {
        System.out.println("In Person default constructor.");
    }

    // another constructor
    public Person(String name) {
        setName(name);
        System.out.println("In Person w/ arg constructor.");
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
