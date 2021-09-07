package ua.gudz.hw9.task1;

interface Planet {
    double G = 6.67 * Math.pow(10, -11);
    double accelerationOfGravity();
    boolean existsOfAtmosphere();
    int whatAverageTemp();
}