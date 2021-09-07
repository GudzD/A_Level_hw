package ua.gudz.hw9.task1;

import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {
        DecimalFormat dF = new DecimalFormat("###,###.###");
        Planet earth = new Earth(5.97 * Math.pow(10, 24), 6371000, true, 12);
        Planet saturn = new Saturn(568.46 * Math.pow(10, 24), 53232000, true, -175);
        Planet mars = new Mars(641.85 * Math.pow(10, 24), 3390000, true, -63);
        Planet jupiter = new Jupiter(1898.6 * Math.pow(10, 24), 69911000, true, -163);
        Planet[] collection = new Planet[]{earth, saturn, mars, jupiter};
        for (Planet planet : collection) {
            System.out.print("Acceleration Of Gravity on: " + planet + dF.format(planet.accelerationOfGravity()) +
                    " м/с²" + System.lineSeparator() + "Atmosphere on: " + planet + planet.existsOfAtmosphere() +
                    System.lineSeparator() + "Average temperature on: " + planet + planet.whatAverageTemp() + "°C");
            System.out.println(System.lineSeparator());
        }
    }
}

