package ua.gudz.test1;

import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите текущее положение Коня на доске в пределах A-H и 1-8");
        String currentPos = in.next();
        System.out.println("Введите предпологаемое положение Коня на доске в пределах A-H и 1-8");
        String possiblyPos = in.next();
        String move = currentPos + possiblyPos;
        move = move.toUpperCase();
        System.out.println(move);
        System.out.println("Может ли конь сделать такой ход: " + isCorrectMove(move));
    }

    public static boolean isCorrectMove(String move) {
        if (move.matches("[A-H][1-8][A-H][1-8]")) {
            int x = Math.abs(move.charAt(0) - move.charAt(2));
            int y = Math.abs(move.charAt(1) - move.charAt(3));
            return (x <= 2 && x + y == 3);
        } else {
            return false;
        }
    }
}




