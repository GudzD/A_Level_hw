package ua.gudz.hw9.task1;

import java.util.Objects;

public class Earth implements Planet {
    double mass;
    double radius;
    boolean atmosphere;
    int averageTemp;

    public Earth(double mass, double radius, boolean atmosphere, int averageTemp) {
        this.mass = mass;
        this.radius = radius;
        this.atmosphere = atmosphere;
        this.averageTemp = averageTemp;
    }

    @Override
    public String toString() {
        return "Earth ";
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
        Earth earth = (Earth) obj;
        return Double.compare(earth.mass, mass) == 0 && Double.compare(earth.radius, radius) == 0 &&
                atmosphere == earth.atmosphere && earth.averageTemp == averageTemp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mass, radius, atmosphere, averageTemp);
    }
}









