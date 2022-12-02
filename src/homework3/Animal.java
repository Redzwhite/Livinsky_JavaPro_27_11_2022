package homework3;

public abstract class Animal {
    private static int totalCount = 0;
    public Animal() {
        totalCount++;
    }
    public static int getTotalCount() {
        return totalCount;
    }

    public abstract void run(int obstacleLength);

    public abstract void swim(int obstacleLength);
}
