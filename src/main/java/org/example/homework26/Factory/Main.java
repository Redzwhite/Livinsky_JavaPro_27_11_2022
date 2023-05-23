package org.example.homework26.Factory;

public class Main {
    public static void main(String[] args) {
        FurnitureFactory furnitureFactory = new ConcreteFurnitureFactory();

        Furniture table = furnitureFactory.createFurniture("table");
        table.create();

        Furniture chair = furnitureFactory.createFurniture("chair");
        chair.create();
    }
}
