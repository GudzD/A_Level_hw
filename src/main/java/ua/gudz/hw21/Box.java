package ua.gudz.hw21;

import lombok.Data;

@Data
@AutoCreate
public class Box {
    @Multiplier
    private final String name = "hello";
    @Multiplier
    private final Double size = 3.0;
    @Multiplier
    private final Integer weight = 2;

    public Box() {
    }

    @Init
    void myMethod() {
        System.out.println("This is my method!!!");

    }

    @Override
    public String toString() {
        return "Box{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", weight=" + weight +
                '}';
    }
}

