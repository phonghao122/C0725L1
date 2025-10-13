package ss5.entities;

public class Circle {
    private double radius = 1;
    private String color = "red";

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public Circle(){
    }

    public Circle(double radius) {
        this.radius = radius;
    }
}
