package homework12.Task_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static float AMOUNT = 100;
    private static int AT_THE_SAME_TIME_COUNT = 3;

    static int min = 3;
    static int max = 11;

    public static float randFloat(float min, float max) {

        Random rand = new Random();

        return rand.nextFloat() * (max - min) + min;
    }

    public static void main(String[] args) {
        PetrolStation petrolStation = new PetrolStation(AMOUNT, min, max);
        List<Client> clients = new ArrayList<>();
//        clients.add(new Client("Client test",100));
        for (int i = 0; i < max; i++) {
            clients.add(new Client("Client" + i, randFloat(1, AMOUNT)));
        }

        Queue queue = new Queue(AT_THE_SAME_TIME_COUNT);

        Thread[] thread = new Thread[max];
        for (int i = 0; i < max; i++) {
            thread[i] = new Thread(new Task(queue, petrolStation, clients.get(i)), "Thread" + i);
        }

        for (int i = 0; i < max; i++) {
            thread[i].start();
        }
    }

}
