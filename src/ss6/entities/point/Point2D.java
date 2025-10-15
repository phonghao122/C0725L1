package ss6.entities.point;

import java.util.Arrays;

public class Point2D{
    private float x;
    private float y;
    private float[] xy;

    public float[] getXY() {
        return xy;
    }

    public void setXY(float x, float y) {
        this.xy = new float[]{x, y};
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Point2D(float x, float y){
        this.x = x;
        this.y = y;
        this.setXY(x,y);
    }

    public Point2D(){}

    public String toString(){
        return "Point2D{" + "x=" + x + ", y=" + y + ", xy=" + Arrays.toString(xy) + '}';
    }
}
