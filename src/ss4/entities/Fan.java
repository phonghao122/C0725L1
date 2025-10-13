package ss4.entities;

import ss4.commons.Speed;

public class Fan {
    private Speed speed = Speed.SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public Speed getSpeed() {
        return speed;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Fan() {
    }
    public Fan(Speed speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    public void toStringFan(){
        if(this.on){
            System.out.println("speed: "+this.speed+"\ncolor: "+this.color+"\nradius: "+this.radius+ "\nFan is on");
        }else {
            System.out.println("color: "+this.color+"\nradius: "+this.radius+ "\nFan is off");
        }
    }
}