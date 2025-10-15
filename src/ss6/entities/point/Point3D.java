package ss6.entities.point;

import java.util.Arrays;

public class Point3D extends Point2D{
    private float z;
    private float[] xyz;

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float[] getXyz() {
        return xyz;
    }

    public void setXyz(float x, float y, float z) {
        this.xyz = new float[]{x, y, z};
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
        this.xyz = new float[]{x, y, z};
    }
    public Point3D() {}

    @Override
    public String toString() {
        return "Point2D{" + "x=" + this.getX() + ", y=" + this.getY() + ", z=" + this.getZ() + ", xyz=" + Arrays.toString(xyz) + '}';
    }
}
