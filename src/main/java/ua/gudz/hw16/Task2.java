package ua.gudz.hw16;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Task2 {
    static String text = "Подруга дней моих суровых, Голубка дряхлая моя! Одна в глуши лесов сосновых " +
            "Давно, давно ты ждешь меня. Ты под окном своей светлицы Горюешь, будто на часах," +
            "И медлят поминутно спицы В твоих наморщенных руках. Глядишь в забытые вороты" +
            "На черный отдаленный путь: Тоска, предчувствия, заботы Теснят твою всечасно грудь." +
            "То чудится тебе ";

    public static void main(String[] args) {
        String[] item = text.trim()
                .toLowerCase()
                .replaceAll("[-+=.^:!,]", " ")
                .replaceAll("\\s+", " ")
                .split(" ");
        HashMap<String, Integer> map = new LinkedHashMap<>();
        for (String t : item) {
            if (map.containsKey(t)) {
                map.put(t, map.get(t) + 1);
            } else {
                map.put(t, 1);
            }
        }
        map
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);
    }
}


