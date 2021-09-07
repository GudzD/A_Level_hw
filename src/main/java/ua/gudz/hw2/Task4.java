package ua.gudz.hw2;

import java.util.Scanner;

class Task4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i;
        int a;
        int b;
        System.out.print("Введите число: ");
        i = sc.nextInt();
        System.out.println("Введите второе число: ");
        a = sc.nextInt();
        System.out.println("Введите третье число: ");
        b = sc.nextInt();
        int res1, res2, res3;
        res1 = module(i);
        res2 = module(a);
        res3 = module(b);
        low(res1, res2, res3);
    }

    public static int module(int n) {
        n = n > 0 ? n : n * (-1);
        return n;
    }
    public static void low(int res1, int res2, int res3) {
        if (res1 <= res2 && res1 <= res3) {
            System.out.println("Наименьшее число " + res1);
        } else if (res2 <= res1 && res2 <= res3) {
            System.out.println("Наименьшее число " + res2);
        } else System.out.println("Наименьшее число " + res3);
    }
}

