package ua.gudz.hw17;
// Задан массив строк. Используя средства
// StreamAPI отсортировать строки в лексикографическом порядке и вывести в консоль.

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        String[] array = new String[]{"firstString", "SecondString", "thirdString", "fourString"};
        mySort(array);
    }

    public static void mySort(String[] array) {
        Arrays
                .stream(array)
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .forEach(System.out::println);
    }
}

