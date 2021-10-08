package ua.gudz.test2;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        Customer petr = new Customer(new PersonService());
        System.out.println(petr);
        ShopService service = new ShopService();
        Invoice invoice = new Invoice();
        try {
            service.read(new File("src/main/resources/myList.csv"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(service.getOrder());
        service.sum(service.getOrder());
        invoice.whatType = service.sum(service.getOrder());
        service.write(service.getOrder());
    }
}