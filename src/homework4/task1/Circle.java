package homework4.task1;

public class Circle implements GeometricShape {
    double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double area()
    {
        double area = Math.PI * r * r;

        return area;
    }
}
