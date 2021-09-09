package ua.gudz.test1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task2Test {
    @Test
    void testLowerCase() {
        Assertions.assertFalse(Task2.isCorrectMove("h1c2"));
        Assertions.assertFalse(Task2.isCorrectMove("a1c2"));
        Assertions.assertFalse(Task2.isCorrectMove("d4g2"));
    }

    @Test
    void testOutsideTheParametersOfMatches() {
        Assertions.assertFalse(Task2.isCorrectMove("x1y2"));
        Assertions.assertFalse(Task2.isCorrectMove("x1c2"));
        Assertions.assertFalse(Task2.isCorrectMove("d4r2"));
    }

    @Test
    void testIncorrectIn() {
        Assertions.assertFalse(Task2.isCorrectMove("2345"));
        Assertions.assertFalse(Task2.isCorrectMove("wer3"));
        Assertions.assertFalse(Task2.isCorrectMove("R y4"));
    }

}