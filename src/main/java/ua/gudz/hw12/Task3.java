package ua.gudz.hw12;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("Введите число ");
        int number = new Scanner(System.in).nextInt();
        try {
            throwOneOfThreeExceptions(number);
        } catch (OneException | TwoException | ThreeException e) {
            e.printStackTrace();
        }
    }

    public static void throwOneOfThreeExceptions(int number) throws OneException, TwoException, ThreeException {
        if (number == 0) {
            throw new OneException("Число равно нулю");
        }
        if (number > 0) {
            throw new TwoException("Число больше нуля");
        } else {
            throw new ThreeException("Число меньше нуля");
        }
    }
}

class OneException extends Exception {
    public OneException(String message) {
        super(message);
    }
}

class TwoException extends Exception {
    public TwoException(String message) {
        super(message);
    }
}

class ThreeException extends Exception {
    public ThreeException(String message) {
        super(message);
    }
}

