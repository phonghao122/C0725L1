package ss6.entities.circle;

public class Cylinder extends Circle{
    private double height;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    @Override
    public double getAcreage(){
        return 2*3.14159*this.getRadius() * this.getHeight();
    }

    public double getVolume(){
        return 3.14159 * Math.pow(this.getRadius(), 2) *  this.getHeight();
    }
}
