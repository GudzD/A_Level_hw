package ua.gudz.hw5;

import java.util.Arrays;

public class Task3 {
    //Дан двумерный массив NxN(количество строк = количество столбцов), написать программу
    // которая поменяет местами столбцы и строки.
    //*Необходимо создать новый массив, в котором удаляется элемент и вернуть его из метода.
    // Изначальный массив не должен измениться
    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        int n = 25;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = n;
                n--;
            }
        }
        System.out.println("Начальный массив:  ");
        for (int[] number : arr) {
            System.out.println(Arrays.toString(number));
        }
        int[][] arrNew = Arrays.copyOf(arr, arr.length);
        rotateArray(arrNew);
        System.out.println("Измененный массив:  ");
        for (int[] number : arrNew) {
            System.out.println(Arrays.toString(number));
        }
    }
    public static void rotateArray(int[][] array) {
        int temp;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                temp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = temp;
            }
        }
    }
}