package homework12.Task_1;

public class Task implements Runnable {

    private Queue queue;
    private PetrolStation petrolStation;

    private Client client;

    Task(Queue queue, PetrolStation petrolStation, Client client) {
        this.queue = queue;
        this.petrolStation = petrolStation;
        this.client = client;
    }

    @Override
    public void run() {
        this.queue.doJob(this.petrolStation, this.client);
    }
}
