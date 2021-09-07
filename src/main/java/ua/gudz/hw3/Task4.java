package ua.gudz.hw3;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        System.out.println("Игра - угадайте число, которое загадал компьютер!");
        System.out.println("Введите число ");
        Scanner sc = new Scanner(System.in);
        int guess = sc.nextInt();
        int secret = generateRandomWithMathRandom(100, 0);

        for (; ; ) {
            if (guess > secret) {
                System.out.println(" Много, введите повторно ");
                guess = sc.nextInt();
                continue;
            } else if (guess < secret) {
                System.out.println(" Мало, введите повторно  ");
                guess = sc.nextInt();
                continue;
            } else System.out.println("Угадали!!!!");
            break;
        }
    }

    public static Integer generateRandomWithMathRandom(int max, int min) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
