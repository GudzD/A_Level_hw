package ua.gudz.hw18;

import java.io.File;

public class BoxOperations {
    public static void main(String[] args) {
        Box box1 = new Box(new File("src/main/resources/Task18.xml"));
        System.out.println("Box From Xml: " + box1);
        System.out.println("======>");
        Box box2 = new Box(new File("src/main/resources/Task18.json"));
        System.out.println("Box From Json: " + box2);
    }
}

