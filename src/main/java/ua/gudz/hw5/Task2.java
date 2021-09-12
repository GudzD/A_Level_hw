package ua.gudz.hw5;

import java.util.Arrays;

public class Task2 {
    //Проверить, заданный массив на упорядоченность по невозрастанию, т. е. определить,
    // верно ли, что каждый его элемент, начиная со второго, не больше предыдущего.
    //*передать массив в метод, получить boolean

    public static void main(String[] args) {
        int[][] numbers = new int[4][5];
        int n = 20;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                numbers[i][j] = n;
                n--;
            }
        }
        for (int[] number : numbers) {
            System.out.println(Arrays.toString(number));
        }
        System.out.println("Проверка на упорядоченность:  " + inOrder(numbers));
    }

    public static boolean inOrder(int[][] array) {
        int j;
        for (int[] ints : array) {
            for (j = 0; j < ints.length-1; j++) {
                if (ints[j + 1] > ints[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

