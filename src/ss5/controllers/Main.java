package ss5.controllers;

import ss5.entities.Circle;
import ss5.entities.Student;

public class Main {
    public static void main(String[] args){
        Circle circle1 = new Circle();
        Circle circle2 = new Circle(2.0);
        System.out.println(circle1.getRadius() + " " + circle2.getRadius());
        Student student = new Student();
        student.setName("Hao");
        student.setClasses("C01");
    }
}
