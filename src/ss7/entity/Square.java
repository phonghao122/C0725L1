package ss7.entity;

import ss7.service.IColorable;
import ss7.service.IResizeable;

public class Square extends Shape implements IColorable, IResizeable {
    private double width = 1.0;

    public Square() {
    }

    public Square(double width) {
        this.width = width;
    }

    public Square(double width, String color, boolean filled) {
        super(color, filled);
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getArea() {
        return Math.pow(this.width, 2) ;
    }

    public double getPerimeter() {
        return this.width * 4;
    }

    @Override
    public String toString() {
        return "A Square with width="
                + getWidth()
                + ", which is a subclass of "
                + super.toString();
    }

    public void resize(double percent) {
        this.width = this.width + this.width * percent;
    }

    public void howToColor() {
        System.out.println("Color all four sides.");
    }
}
