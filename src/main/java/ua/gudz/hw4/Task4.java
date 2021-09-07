package ua.gudz.hw4;

import java.util.Arrays;
import java.util.Random;

public class Task4 {

    //Заполнить одномерный массив случайными целочисленными значениями.
    // Все четные значения заменить на нули. Размер массива - 2000 элементов.

    public static void main(String[] args) {
        int[] numbers = new int[2000];
        Random rand = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt();
        }
        int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
        System.out.println(Arrays.toString(numbers));
        change(numbersCopy);
        System.out.println(Arrays.toString(numbersCopy));
    }

    public static void change(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                array[i] = 0;
            }
        }
    }
}

