package org.example.homework26.Strategy;

class TriangleArea implements AreaStrategy {
    private double base;
    private double height;

    TriangleArea(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double computeArea() {
        return 0.5 * base * height;
    }
}
