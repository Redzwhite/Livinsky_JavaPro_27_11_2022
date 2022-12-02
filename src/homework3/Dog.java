package homework3;

public class Dog extends Animal {

    String name;
    static int count=0;
    public Dog(String name) {
        this.name = name;
        count++;
    }
    @Override
    public void run(int obstacleLength) {
        if (obstacleLength <= 500) {
            System.out.println(this.name + " run " + obstacleLength + " m");
        } else {
            System.out.println(this.name + " can run up to 500 meters");
        }
    }
    @Override
    public void swim(int obstacleLength) {
        if (obstacleLength <= 10) {
            System.out.println(this.name + " swim " + obstacleLength + " m");
        } else {
            System.out.println(this.name + " can swim up to 10 meters");
        }
    }
}
