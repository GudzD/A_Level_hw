package ua.gudz.hw5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task2Test {
    @Test
    void testSameNumbers() {
        Assertions.assertTrue(Task2.inOrder(new int[][]{{1, 1,}, {1, 1, 1}, {1, 1, 1, 1}}));
        Assertions.assertTrue(Task2.inOrder(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
        Assertions.assertTrue(Task2.inOrder(new int[][]{{9}, {9, 9, 9}, {9, 9}}));
    }

    @Test
    void testNegativeNumbers() {
        Assertions.assertTrue(Task2.inOrder(new int[][]{{-8, -9, -10}, {-4, -5, -6}, {-1, -2, -3}}));
        Assertions.assertTrue(Task2.inOrder(new int[][]{{-32, -45, -67}, {-10, -11, -12}, {-4, -6}}));
        Assertions.assertTrue(Task2.inOrder(new int[][]{{-8, -56}, {-32, -55, -345}, {-1, -2, -3}}));
    }

    @Test
    void testNoSort() {
        Assertions.assertFalse(Task2.inOrder(new int[][]{{-8, 23, 12}, {4, -5, 23}, {1, 0, -3}}));
        Assertions.assertFalse(Task2.inOrder(new int[][]{{-9, 34, 1442}, {12, 89, 3}, {0, 7}}));
        Assertions.assertFalse(Task2.inOrder(new int[][]{{89, 3, 342}, {-9, 903}, {1}}));
    }

    @Test
    void testEmptyArray() {
        Assertions.assertTrue(Task2.inOrder(new int[4][6]));
    }
}

