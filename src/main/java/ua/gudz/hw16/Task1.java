package ua.gudz.hw16;

// Напишите метод, который добавляет 1000000 элементов в ArrayList и LinkedList. Напишите еще один метод
// , который выбирает из заполненного списка элемент наугад 100000 раз. Замерьте время, которое потрачено на это.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        ArrayList<Integer> listA = new ArrayList<>();
        LinkedList<Integer> listL = new LinkedList<>();
        System.out.print("Add method to ArrayList. ");
        add(listA);
        System.out.print("Add method to LinkedList. ");
        add(listL);
        System.out.print("Get method to ArrayList. ");
        get(listA);
        System.out.print("Get method to LinkedList. ");
        get(listL);
    }

    static void add(List<Integer> in) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            in.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) + "ms");
    }

    static void get(List<Integer> in) {
        long startTime = System.currentTimeMillis();
        for (Integer ignored : in) {
            int i = new Random().nextInt(99999);
            in.get(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) + "ms");
    }
}