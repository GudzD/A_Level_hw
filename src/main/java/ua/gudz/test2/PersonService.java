package ua.gudz.test2;

import java.util.Random;

public class PersonService {
    String[] emails = new String[]{"One@gmail.com", "Two@gmail.com", "Three@gmail.com", "Four@gmail.com",
            "Five@gmail.com", "Six@gmail.com", "Seven@gmail.com", "Eight@gmail.com", "Nine@gmail.com"};
    int randomAge = new Random().nextInt(100);
    int randomId = new Random().nextInt(1000);
    String randomEmail = emails[new Random().nextInt(9)];

    public PersonService() {
    }
}
