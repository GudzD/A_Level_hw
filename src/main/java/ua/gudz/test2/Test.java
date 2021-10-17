package ua.gudz.test2;

import ua.gudz.test2.electronics.Electronics;
import ua.gudz.test2.services.ShopService;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        ShopService service = new ShopService();
        Invoice invoice = new Invoice();
        try {
            service.read(new File("C:\\Java Projects\\A_Level_hw\\src\\main\\resources\\myList.csv"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<Invoice> myImitationOf15_Orders = new ArrayList<>(15);
        for (int i = 0; i < 15; i++) {
            ArrayList<Electronics> order = service.createOrder();
            Invoice invoice1 = invoice.createInvoice(order);
            myImitationOf15_Orders.add(invoice1);
            service.write(invoice1);
        }
        System.out.println("==========>");
        System.out.println("We have in 15 orders count of Televisions: " + myImitationOf15_Orders.stream()
                .map(Invoice::getList)
                .flatMap(Collection::stream)
                .map(Electronics::getType)
                .filter(x -> x.matches("Television"))
                .count());
        System.out.println("==========>");
        System.out.println("We have in 15 orders count of Telephones: " + myImitationOf15_Orders.stream()
                .map(Invoice::getList)
                .flatMap(Collection::stream)
                .map(Electronics::getType)
                .filter(x -> x.matches("Telephone"))
                .count());
//        System.out.println("We have in 15 orders sum of min check: " + myImitationOf15_Orders.stream()
//                .map(Invoice::getList)
//                .map(service::sum)
//                .reduce(Integer::min) +
//                " and His owner: - " +
//                myImitationOf15_Orders.stream()
//                        .map(Invoice::getList)
//                        .map(service::sum)
//                        .reduce(Integer::min)
//                        .filter(x->x.)
        System.out.println("==========>");
        System.out.println("Sum of All orders: " + myImitationOf15_Orders.stream()
                .map(Invoice::getList)
                .flatMap(Collection::stream)
                .map(Electronics::getPrice)
                .mapToInt(Integer::valueOf)
                .sum());
        System.out.println("==========>");
        System.out.println("Count of Orders with type \"retail\": " + myImitationOf15_Orders.stream()
                .map(Invoice::getType)
                .filter(x -> x.matches("retail"))
                .count());
        System.out.println("==========>");
        System.out.println("Orders with one type of Electronics: ");
        myImitationOf15_Orders.stream()
                .sorted(Comparator.comparing((Invoice x) -> x.getList().stream()
                        .map(Electronics::getType)
                        .allMatch(y -> y.matches("Television"))))
                .map(Invoice::getList)
                .forEach(System.out::println);
        System.out.println("==========>");
        System.out.println("Orders with age under 18 years: ");
        myImitationOf15_Orders.stream()
                .filter(x -> x.getMyCustomer().getAge() < 18)
                .peek(x -> x.setType("Low_Age"))
                .forEach(System.out::println);
        System.out.println("==========>");
        System.out.println("First 3 Orders: ");
        myImitationOf15_Orders.stream()
                .limit(3)
                .map(Invoice::getList)
//                .flatMap(Collection::stream)
                .forEach(System.out::println);
        System.out.println("==========>");
        System.out.println("My sort: ");
        service.mySort(myImitationOf15_Orders);
    }
}