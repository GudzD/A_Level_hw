package ua.gudz.test2;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        Customer petr = new Customer(new PersonService());
        System.out.println(petr);
        try {
            ShopService.read(new File("src/main/resources/myList.csv"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        ShopService.order.forEach(System.out::println);
        ShopService.sum(ShopService.order);
    }
}