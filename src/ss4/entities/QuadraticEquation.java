package ss4.entities;

public class QuadraticEquation {
    private double a,b,c;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminant(){
        return Math.pow(this.b,2) - 4 * this.a *  this.c;
    }

    private double getRoot1(){
        return (-this.b + Math.sqrt(Math.pow(this.b,2)- 4 * this.a *  this.c)) / (2 * this.c);
    }

    private double getRoot2(){
        return (-this.b - Math.sqrt(Math.pow(this.b,2)- 4 * this.a *  this.c)) / (2 * this.c);
    }

    public void getRoots(){
        double delta = this.getDiscriminant();
        if(delta > 0){
            System.out.println("Nghiệm 1: "+ getRoot1());
            System.out.println("Nghiệm 2: "+ getRoot2());
        }else  if(delta == 0){
            System.out.println("Nghiệm chung: "+ getRoot1());
        }else {
            System.out.println("The equation has no roots");
        }
    }
}
