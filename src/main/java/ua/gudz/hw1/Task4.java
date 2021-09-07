package ua.gudz.hw1;

import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {
        System.out.println("Please enter your number and I will return it:  ");
        String num = new Scanner(System.in).nextLine();
        for (int i = num.length() - 1; i >= 0; i--) {
            System.out.print(num.charAt(i));
        }
    }
}
