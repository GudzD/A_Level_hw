package ua.gudz.hw5;

import java.util.Arrays;
import java.util.Scanner;


public class Task4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] numbers = new int[20];
        fillArray(numbers);
        System.out.println("Начальный массив: " + Arrays.toString(numbers));
        System.out.print("Удалить элемент: ");
        int index = in.nextInt();
        System.out.println("Измененный массив: " + Arrays.toString(removeIndex(numbers, index)) +
                "  без элемента с индексом:  " + index);
    }
    public static void fillArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (1 + Math.random() * 10);
        }
    }

    public static int[] removeIndex(int[] numbers, int index) {
        int[] copyOfNumbers = Arrays.copyOf(numbers, numbers.length - 1);
        if (index >= 0 && index <= numbers.length - 1) {
            System.arraycopy(numbers, index + 1, copyOfNumbers, index, copyOfNumbers.length - index);
        } else {
            return null;
        }
        return copyOfNumbers;
    }
}

