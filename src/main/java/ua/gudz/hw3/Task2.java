package ua.gudz.hw3;

import java.util.Scanner;

public class Task2 {
    // Удалить из строки пробелы и определить, является ли она перевертышем
    // Считать строку из консоли. Передать в метод, который удалит из нее все пробелы.
    // После этого определить, является ли она палиндромом (перевертышем),
    // т.е. одинаково пишется как с начала, так и с конца.

    public static void main(String[] args) {
        System.out.print("Введите строку: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        input = delSpaces(input);
        System.out.println("Строка без пробелов: " + input);
        System.out.println(isPalindrome(input) ? "Палиндром" : "Не Палиндром");
    }

    public static String delSpaces(String n) {
        n = n.replaceAll("\\s+", "");
        return n;
    }

    public static boolean isPalindrome(String n) {
        String n1 = n.toLowerCase();
        System.out.println("Строка в нижнем регистре: " + n1);
        int i = 0, j = n1.length() - 1;
        while (i < j) {
            if (n1.charAt(i++) == n1.charAt(j--)) {
                return true;
            }
        }
        return false;
    }
}


