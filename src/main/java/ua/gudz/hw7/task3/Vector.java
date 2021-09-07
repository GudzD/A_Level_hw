package ua.gudz.hw7.task3;

import java.util.Random;

public class Vector {
    public int x;
    public int y;
    public int z;

    public Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double vectorLength() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public Vector vectorAdded(Vector in) {
        return new Vector(y * in.z - z * in.y, z * in.x - x * in.z, x * in.y - y * in.x);
    }

    public double vectorScalar(Vector in) {
        return x * in.x + y * in.y + z * in.z;
    }

    public double vectorCos(Vector in) {
        return vectorScalar(in) / Math.abs(vectorLength() * in.vectorLength());
    }

    public Vector vectorSum(Vector in) {
        return new Vector(x + in.x, y + in.y, z + in.z);
    }

    public Vector vectorResidual(Vector in) {
        return new Vector(x - in.x, y - in.y, z - in.z);
    }

    public static Vector[] vectorArray(int n) {
        Vector[] vectors = new Vector[n];
        Random rand = new Random();
        for (int i = 0; i < vectors.length; i++) {
            vectors[i] = new Vector(rand.nextInt(100), rand.nextInt(100), rand.nextInt(100));
        }
        return vectors;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

}