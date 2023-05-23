package org.example.homework26.Builder;

public class Main {
    public static void main(String[] args) {
        Car car = new CarBuilder().setEngine("V8").setTires("Winter").setSeats("Leather").build();
    }
}
