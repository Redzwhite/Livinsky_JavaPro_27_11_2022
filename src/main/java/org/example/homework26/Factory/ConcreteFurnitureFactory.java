package org.example.homework26.Factory;

class ConcreteFurnitureFactory implements FurnitureFactory {
    public Furniture createFurniture(String type) {
        if (type.equalsIgnoreCase("table")) {
            return new Table();
        } else if (type.equalsIgnoreCase("chair")) {
            return new Chair();
        }
        return null;
    }
}
