package ua.gudz.hw9.task1;

import java.util.Objects;

public class Mars implements Planet {
    double mass;
    double radius;
    boolean atmosphere;
    int averageTemp;

    public Mars(double mass, double radius, boolean atmosphere, int averageTemp) {
        this.mass = mass;
        this.radius = radius;
        this.atmosphere = atmosphere;
        this.averageTemp = averageTemp;
    }

    @Override
    public String toString() {
        return "Mars ";
    }

    @Override
    public double accelerationOfGravity() {
        return G * (mass / Math.pow(radius, 2));
    }

    @Override
    public boolean existsOfAtmosphere() {
        return atmosphere;
    }

    @Override
    public int whatAverageTemp() {
        return averageTemp;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Mars mars = (Mars) obj;
        return Double.compare(mars.mass, mass) == 0 && Double.compare(mars.radius, radius) == 0 &&
                atmosphere == mars.atmosphere && mars.averageTemp == averageTemp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mass, radius, atmosphere, averageTemp);
    }
}


