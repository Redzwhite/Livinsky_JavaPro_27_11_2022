package org.example.homework26.Strategy;

class RectangleArea implements AreaStrategy {
    private double length;
    private double width;

    RectangleArea(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double computeArea() {
        return length * width;
    }
}
