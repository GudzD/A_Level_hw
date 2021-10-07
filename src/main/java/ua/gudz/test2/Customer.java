package ua.gudz.test2;

import lombok.Data;

@Data
public class Customer {
    private int id;
    private String email;
    private int age;

    public Customer(PersonService in) {
        this.email = in.randomEmail;
        this.age = in.randomAge;
        this.id = in.randomId;
    }

    public Customer(int id, String email, int age) {
        this.id = id;
        this.email = email;
        this.age = age;
    }
}
