package ua.gudz.hw17;

//Задан список случайных чисел, с фомощью функции reduce найти минимальное число

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        Collections.addAll(myList, 3, 4, 9, 0, -23, -156, 78);
        int result = myList
                .stream()
                .reduce(0,
                        (x, y) -> {
                            if (x < y)
                                return x;
                            else
                                return y;
                        });
        System.out.println(result);
    }
}