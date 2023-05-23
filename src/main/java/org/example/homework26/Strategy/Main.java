package org.example.homework26.Strategy;

public class Main {
    public static void main(String[] args) {
        AreaCalculator rectangleAreaCalculator = new AreaCalculator(new RectangleArea(5, 6));
        System.out.println(rectangleAreaCalculator.computeArea());

        AreaCalculator triangleAreaCalculator = new AreaCalculator(new TriangleArea(5, 6));
        System.out.println(triangleAreaCalculator.computeArea());
    }
}