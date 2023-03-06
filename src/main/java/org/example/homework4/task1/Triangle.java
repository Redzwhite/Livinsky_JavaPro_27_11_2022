package org.example.homework4.task1;

public class Triangle implements GeometricShape {

    double w,h;
    public Triangle(double w, double h) {
        this.w = w;
        this.h = h;
    }

    @Override
    public double area()
    {
        double area = w * h;

        return area;
    }
}
