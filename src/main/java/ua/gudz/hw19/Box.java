package ua.gudz.hw19;

@AutoCreate
public class Box {
    @Multiplier
    private final String name = "hello";
    @Multiplier
    private final Double size = 3.0;
    private final Integer weight = 2;

    public Box() {
    }

    @Init
    void show(){
        System.out.println("All Works");

    }
}

