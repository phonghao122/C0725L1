package ss6.controller;

import ss6.entities.point.Point2D;
import ss6.entities.point.Point3D;

public class Main {
    public static void main(String[] args) {
//        Circle circle = new Circle(2.0,"red");
//        Cylinder cylinder = new Cylinder(3.0,"blue",5.0);
//        System.out.println("radius circle: " + circle.getRadius());
//        System.out.println("color circle: " + circle.getColor());
//        System.out.println("Acreage circle: " + circle.getAcreage());
//        System.out.println("radius cylinder: " + cylinder.getRadius());
//        System.out.println("color cylinder: " + cylinder.getColor());
//        System.out.println("Acreage cylinder: " + cylinder.getAcreage());
//        System.out.println("volume cylinder: " + cylinder.getVolume());
        Point2D point2d = new Point2D(1,2);
        Point3D point3d = new Point3D(1,2,3);
        System.out.println(point2d.toString());
        System.out.println(point3d.toString());
    }
}
