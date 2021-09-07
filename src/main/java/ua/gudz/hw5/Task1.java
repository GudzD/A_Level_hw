package ua.gudz.hw5;

import java.util.Arrays;

public class Task1 {
    // Заполнение двумерного массива значениями индекса, при этом каждая вторая строка - отрицательными значениями.
    //Например
    //1 2 3
    //-4 -5 -6
    //7 8 9
    //-10 -11 -12
    //*Передать массив в метод, заполнить данный массив

    public static void main(String[] args) {
        int[][] numbers = new int[4][5];
        fillArray(numbers);
        for (int[] number : numbers) {
            System.out.println(Arrays.toString(number));
        }
    }

    public static void fillArray(int[][] array) {
        int j;
        int n = 0;
        for (int i = 0; i < array.length; i++) {
            for (j = 0; j < array[i].length; j++) {
                n++;
                array[i][j] = n;
                if (i % 2 != 0) array[i][j] = -array[i][j];
            }
        }
    }
}




