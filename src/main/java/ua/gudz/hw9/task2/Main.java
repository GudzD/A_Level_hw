package ua.gudz.hw9.task2;

public class Main {
    public static void main(String[] args) {

        Pow inPow = (number, pow) -> {
            int result = 1;
            for (int i = 0; i < pow; i++) {
                result *= number;
            }
            return result;
        };

        System.out.println(inPow.pow(2, 3));
    }
}
