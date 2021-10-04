package ua.gudz.hw18.task1;

import java.io.File;

public class BoxOperations {
    public static void main(String[] args) {
        Box box1 = new Box(new File("src/main/resources/Task18.xml"));
        System.out.println(box1);
    }
}

