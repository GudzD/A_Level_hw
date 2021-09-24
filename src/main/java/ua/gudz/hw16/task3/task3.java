package ua.gudz.hw16.task3;

import java.util.Arrays;
import java.util.List;

public class task3 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Anton", "alexandr", "Anna", "Dmitrii", "Marina");
        ListIterator itr = new ListIterator(list);
        while (itr.hasNext())
            System.out.println(itr.next());
    }
}


