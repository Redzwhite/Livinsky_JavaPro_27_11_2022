package homework4.task2.participant;

public abstract class Participant {
    public String name;
    public Double maxClimbingHeight;
    public Double maximumDistance;
    public Participant(String name,Double maxClimbingHeight,Double maximumDistance) {
        this.name = name;
        this.maxClimbingHeight = maxClimbingHeight;
        this.maximumDistance = maximumDistance;

    }

    public abstract void run(String obstacle);

    public abstract void jump(String obstacle);

}
