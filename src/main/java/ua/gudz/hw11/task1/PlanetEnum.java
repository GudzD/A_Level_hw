package ua.gudz.hw11.task1;

public enum PlanetEnum {
    EARTH(1), MARS(2), JUPITER(79), SATURN(82);

    private final int satellites;

    PlanetEnum(int satellites) {
        this.satellites = satellites;
    }

    public int getSatellites() {
        return satellites;
    }

    public static void main(String[] args) {
        System.out.println("Count of satellites on Earth: " + EARTH.getSatellites());
        System.out.println("Count of satellites on Mars: " + MARS.getSatellites());
        System.out.println("Count of satellites on Jupiter: " + JUPITER.getSatellites());
        System.out.println("Count of satellites on Saturn: " + SATURN.getSatellites());
    }
}