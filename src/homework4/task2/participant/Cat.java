package homework4.task2.participant;

public class Cat extends Participant{
    public Cat(String name, Double maxClimbingHeight,Double maximumDistance) {
        super(name, maxClimbingHeight,maximumDistance);
    }
    @Override
    public void run(String obstacle) {
        System.out.println(name + " running... " + obstacle);
    }
    @Override
    public void jump(String obstacle) {
        System.out.println(name + " jumping... " + obstacle);
    }
}
