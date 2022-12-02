package homework3;

public class Cat extends Animal {

    String name;
    static int count=0;
    public Cat(String name) {
        this.name = name;
        count ++;
    }

    @Override
    public void run(int obstacleLength) {
        if (obstacleLength <= 200) {
            System.out.println(this.name + " run " + obstacleLength + " m");
        } else {
            System.out.println("The cat cannot run more than 200 meters");
        }
    }
    @Override
    public void swim(int obstacleLength) {
            System.out.println(this.name + " cannot swim");
    }
}
