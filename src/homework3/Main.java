package homework3;

public class Main {

    public static void main(String[] args) {

        Dog dog1 = new Dog("Bobik");
        Dog dog2 = new Dog("Popik");
        dog1.run(345);
        dog1.swim(10);

        Cat cat1 = new Cat("Kitty");
        cat1.swim( 10);
        cat1.run(120);

        System.out.println("Number of dogs created:" + Dog.count);
        System.out.println("Number of cats created:" + Cat.count);
        System.out.println("Number of animals created:" + (Dog.count + Cat.count));
    }
}
