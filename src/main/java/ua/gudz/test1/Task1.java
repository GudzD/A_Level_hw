package ua.gudz.test1;

import java.util.Arrays;

public class Task1 {
    static int[] numbers = new int[]{3, 7, 4, 19, -9, 7, -9, -127};

    public static void main(String[] args) {
        System.out.println(countDifferent(sortArray()));
    }

    public static int[] sortArray() {
        int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(numbersCopy);
        return numbersCopy;
    }

    public static int countDifferent(int[] array) {
        int count = 1;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (array[i] != array[i + 1])
                count++;
        }
        return count;
    }
}