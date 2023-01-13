package homework12;

import java.util.Random;

public class PetrolStation {
    private volatile static float AMOUNT = 100;
    private static float AT_THE_SAME_TIME_COUNT = 3;
    static int min = 3;
    static int max = 11;

    public static void doRefuel(float fuelAmount) throws InterruptedException {

        if (AMOUNT >= fuelAmount) {
            int randomNum = (int) ((Math.random() * (max - min)) + min) * 1000;
            Thread.sleep(randomNum);
            if (AMOUNT >= fuelAmount) {
                AMOUNT -= fuelAmount;
            } else {
                System.out.println("Error : not enough fuel");
            }
        } else {
            System.out.println("Error : not enough fuel");

        }
    }
}

