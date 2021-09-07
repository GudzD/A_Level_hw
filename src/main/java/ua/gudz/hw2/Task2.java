package ua.gudz.hw2;

public class Task2 {
    public static void main(String[] args) {
        double aX = 2, aY = 1;
        double bX = -5, bY = 6;
        double cX = 2, cY = -5;
        System.out.println(triangleSquare(aX, aY, bX, bY, cX, cY));
    }

    public static double triangleSquare(double aX, double aY, double bX, double bY, double cX, double cY) {
        double ab = Math.sqrt(Math.pow(aX - bX, 2) + Math.pow(aY - bY, 2));
        double bc = Math.sqrt(Math.pow(bX - cX, 2) + Math.pow(bY - cY, 2));
        double ca = Math.sqrt(Math.pow(cX - aX, 2) + Math.pow(cY - aY, 2));
        double p = (ab + bc + ca) / 2;
        return (double) Math.round(1000000 * Math.sqrt(p * (p - ab) * (p - bc) * (p - ca))) / 1000000;
    }
}





