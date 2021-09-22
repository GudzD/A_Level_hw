package ua.gudz.hw15.task3;
//  Реализовать метод, принимающий список строк и возвращающий Map,
//  где ключ - строка, значение - количество букв в строке

import java.util.HashMap;
import java.util.Map;

public class Task3 {
    public static void main(String[] args) {
        String text = ("Реализовать метод, принимающий список строк и     возвращающий Map, где ключ - строка" +
                ", значение - количество букв в строке");
        System.out.println(text);
        var result = turnToMap(text);
        result.forEach((key, value) -> System.out.println(key + " " + value));
    }

    public static Map turnToMap(String text) {
        text = text.toLowerCase().trim()
                .replaceAll("[-+.^:,]", "  ")
                .replaceAll("\\s+", " ");
        String[] text1 = text.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String s : text1) {
            map.put(s, s.length());
        }
        return map;
    }
}
