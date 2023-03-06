package org.example.homework12.Task_1;

public class PetrolStation {

    public float totalAmount;
    int min;
    int max;

    public PetrolStation(float totalAmount, int min, int max) {
        this.totalAmount = totalAmount;
        this.min = min;
        this.max = max;
    }

    public void doRefuel(Client client) throws InterruptedException {

        if (this.totalAmount >= client.amount) {
            int randomNum = (int) ((Math.random() * (max - min)) + min) * 1000;
            System.out.println("Do refuel take time " + randomNum / 1000 + " s");
            Thread.sleep(randomNum);
            if (this.totalAmount >= client.amount) {
                this.totalAmount -= client.amount;
                System.out.println("Done left amount of fuel " + this.totalAmount);
            } else {
                System.err.println("Error : not enough fuel");
            }
        } else {
            System.err.println("Error : not enough fuel");

        }
    }
}

