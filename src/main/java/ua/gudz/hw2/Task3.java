package ua.gudz.hw2;

import java.util.Scanner;

class Task3{

    public static boolean DivBy2(int n) {
        if (n % 2 == 0) {
            System.out.println("Четное");
        } else System.out.println("Нечетное");
        return true;
    }

    public static void main(String[] args) {
        System.out.print("Введите число: ");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (DivBy2(n)) {
                System.out.println("Проверка завершена");
            }
        } else System.out.println("Введенное число не являеться целым");
    }
}








