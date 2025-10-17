package ss7.controller;

import ss7.entities.Circle;
import ss7.entities.Rectangle;
import ss7.entities.Shape;
import ss7.entities.Square;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(3.5, "indigo", false);
        shapes[1] = new Rectangle(2.5, 3.8, "orange", true);
        shapes[2] = new Square(2.5,"orange", true);

        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                System.out.println(shape);
                System.out.println(((Circle) shape).getArea());
                System.out.println(((Circle) shape).getPerimeter());
                ((Circle) shape).resize(new Random().nextDouble(100)+1);
                System.out.println(shape);
                System.out.println(((Circle) shape).getArea());
                System.out.println(((Circle) shape).getPerimeter());
                continue;
            }
            if (shape instanceof Rectangle) {
                System.out.println(shape);
                System.out.println(((Rectangle) shape).getArea());
                System.out.println(((Rectangle) shape).getPerimeter());
                ((Rectangle) shape).resize(new Random().nextDouble(100)+1);
                System.out.println(shape);
                System.out.println(((Rectangle) shape).getArea());
                System.out.println(((Rectangle) shape).getPerimeter());
                continue;
            }
            if (shape instanceof Square) {
                System.out.println(shape);
                System.out.println(((Square) shape).getArea());
                System.out.println(((Square) shape).getPerimeter());
                ((Square) shape).howToColor();
                ((Square) shape).resize(new Random().nextDouble(100)+1);
                System.out.println(shape);
                System.out.println(((Square) shape).getArea());
                System.out.println(((Square) shape).getPerimeter());
                ((Square) shape).howToColor();
            }

        }
    }
}
