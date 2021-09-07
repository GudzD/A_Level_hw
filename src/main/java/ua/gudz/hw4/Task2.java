package ua.gudz.hw4;

import java.util.Arrays;
import java.util.Random;

public class Task2 {

    //Заполнить одномерный массив случайными целочисленными значениями.
    // Проверить сколько простых чисел присутствует в массиве. Размер массива 1000 элементов.

    public static void main(String[] args) {
        int[] numbers = new int[1000];
        Random rand = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt();
        }
        System.out.println(Arrays.toString(numbers));
        System.out.println("We have " + countPrimeNum(numbers) + " prime numbers");
    }

    public static int countPrimeNum(int[] array) {
        int result = 0;
        for (int j : array) {
            if (checkPrimeNum(j)) {
                result++;
            }
        }
        return result;
    }

    public static boolean checkPrimeNum(int number) {
        boolean num = true;
        if (number <= 0) {
            num = false;
        } else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    num = false;
                    break;
                }
            }
        }
        return num;
    }
}
