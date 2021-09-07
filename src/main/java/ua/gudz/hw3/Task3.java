package ua.gudz.hw3;

import java.util.Scanner;

public class Task3 {

    // Вводится строка, состоящая из слов, разделенных пробелами.
    // Требуется посчитать количество слов в ней.

    public static void main(String[] args) {
        System.out.println("Введите строку: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        input = input.trim().replaceAll("\\s+", " ");
        System.out.println("Вы ввели " + counterWords(input) + " слова");
    }

    public static int counterWords(String text) {
        int counter = 0;
        if (text.length() != 0) {
            counter++;
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == ' ') {
                    counter++;
                }
            }
        }
        return counter;
    }
}

