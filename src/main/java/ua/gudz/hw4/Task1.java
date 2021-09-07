package ua.gudz.hw4;

import java.util.Arrays;
import java.util.Random;

public class Task1 {
    //Заполнить одномерный массив случайными целочисленными значениями.
    // Найти среднее арифметическое и среднее геометрическое элементов массива.
    // Размер массива - 400 элементов.
    //P.S. значения элементов ограничить значениями 1-10 включительно.
    public static void main(String[] args) {
        int[] numbers = new int[400];
        Random rand = new Random();
        int i;
        for (i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(11);
        }
        System.out.println(Arrays.toString(numbers));
        System.out.println("Среднее арифметичесткое: " + getAverage(numbers));
        System.out.println("Среднее Геометрическое! " + geoMean(numbers));
    }

    public static double getAverage(int[] array) {
        double summ = 0;
        double average = 0;
        for (int j : array) {
            summ += j;
            average = summ / array.length;
        }
        return average;
    }

    public static double geoMean(int[] array) {
        double gm = 1.0;
        for (int j : array) {
            if (j != 0) {
                gm *= j;
            }
        }
        gm = Math.pow(gm, 1.0 / array.length);
        return gm;
    }
}



