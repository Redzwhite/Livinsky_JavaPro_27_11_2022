package homework4.task1;

import homework4.task1.GeometricShape;

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

