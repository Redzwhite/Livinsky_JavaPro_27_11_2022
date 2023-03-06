package org.example.homework4.task1;

public class Main {

    static double sum()
    {
        int sum = 0;
        int i;
        for (i = 0; i < abc.length; i++)
            sum += abc[i].area();

        return sum;
    }
    static GeometricShape[] abc = new GeometricShape[3];

    public static void main(String[] args) {
        abc[0] = new Circle(8.0);
        abc[1] = new Triangle(4.0,4.0);
        abc[2] = new Square(6.0);

        System.out.println(sum());
    }



}
