package homework12.Task_1;

import java.util.concurrent.Semaphore;

public class Queue {
    private volatile Semaphore semaphore;

    Queue(int countPrints) {
        this.semaphore = new Semaphore(countPrints);
    }

    void doJob(PetrolStation petrolStation, Client client) {
        try {
            semaphore.acquire();
            petrolStation.doRefuel(client);
            System.out.println("acquired " + client.name + "\nfree " + semaphore.availablePermits());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("\nPrinting failed.\n");
            e.printStackTrace();
        } finally {
            semaphore.release();
            System.out.println("released " + client.name + "\nfree " + semaphore.availablePermits());
        }
    }
}
