package ua.gudz.hw17;

// Задан список случайных чисел, отфильтровать числа >= 0 и получить обьект IntSummaryStatistics.
//  Вывести на экране все его показатели

import java.util.ArrayList;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        ArrayList<Integer> myRandomNumbers = generatedList();
        System.out.println(intSummaryStatistics(myRandomNumbers));
    }

    private static ArrayList<Integer> generatedList() {
        ArrayList<Integer> numbersGenerated = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Random random = new Random();
            int iNumber = random.nextInt();
            numbersGenerated.add(iNumber);
        }
        return numbersGenerated;
    }

    private static Object intSummaryStatistics(ArrayList<Integer> list) {
        return list.stream()
                .filter(i -> i >= 0)
                .mapToInt(i -> i)
                .summaryStatistics();
    }
}





