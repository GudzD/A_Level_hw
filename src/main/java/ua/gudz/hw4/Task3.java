package ua.gudz.hw4;

import java.util.Arrays;
import java.util.Random;

public class Task3 {

    //Заполнить одномерный массив случайными целочисленными значениями.
    // Проверить сколько составных чисел присутствует в массиве. Размер массива 1000 элементов.

    public static void main(String[] args) {
        int[] numbers = new int[1000];
        Random rand = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt();
        }
        System.out.println(Arrays.toString(numbers));
        System.out.println("We have " + countCompositeNum(numbers) + " composite numbers");
    }

    public static int countCompositeNum(int[] array) {
        int result = 0;
        for (int j : array) {
            if (checkNum(j)) {
                result++;
            }
        }
        return result;
    }

    public static boolean checkNum(int number) {
        boolean num = false;
        if (number < 1) {
            return false;
        } else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    num = true;
                    break;
                }
            }
        }
        return num;
    }
}


