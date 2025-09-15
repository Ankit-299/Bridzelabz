abstract class Animal {
    private String name;
    private int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    abstract void makeSound();
}

class Dog extends Animal {
    Dog(String name, int age) { super(name, age); }

    @Override
    void makeSound() {
        System.out.println(getName() + " barks: Woof Woof!");
    }
}

class Cat extends Animal {
    Cat(String name, int age) { super(name, age); }

    @Override
    void makeSound() {
        System.out.println(getName() + " meows: Meow Meow!");
    }
}

class Bird extends Animal {
    Bird(String name, int age) { super(name, age); }

    @Override
    void makeSound() {
        System.out.println(getName() + " chirps: Tweet Tweet!");
    }
}

public class AnimalHierarchy {
    public static void main(String[] args) {
        Animal dog = new Dog("Bruno", 3);
        Animal cat = new Cat("Kitty", 2);
        Animal bird = new Bird("Parrot", 1);

        dog.makeSound();
        cat.makeSound();
        bird.makeSound();
    }
}
