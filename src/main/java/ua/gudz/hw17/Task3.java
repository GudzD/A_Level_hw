package ua.gudz.hw17;

// Задан список строк в формате даты YYYY/MM/DD, преобразовать строки в даты,
// проверить что присутствует хотя-бы одна дата за 2021 год.

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

public class Task3 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();
        Collections.addAll(myList, "2013.12.01", "2014.10.04", "2001.09.23", "2007.05.04", "2021.08.14");
        if (!stringInDate(myList)) System.out.print("В списке нет 2021 года");
        else {
            myList.forEach(System.out::println);
        }
    }

    private static boolean stringInDate(ArrayList<String> list) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        return list.stream()
                .map(i -> LocalDate.parse(i, formatter))
                .anyMatch(i -> i.getYear() == 2021);
    }
}