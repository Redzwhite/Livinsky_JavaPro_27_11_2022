package org.example.homework4.task1;

public class Square implements GeometricShape {

    double a;

    public Square(double a) {
        this.a = a;
    }

    public double area() {
      double  area = (a*a);

        return area;
    }
}

