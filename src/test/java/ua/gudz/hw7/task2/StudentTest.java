package ua.gudz.hw7.task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {
    @Test
    void testIntegerNumber() {
        assertEquals(80, new Student("", "", "", 9).getScholarship());
        assertEquals(100, new Student("", "", "", 5).getScholarship());
        assertEquals(80, new Student("", "", "", 0).getScholarship());
    }

    @Test
    void testAverageMarkIsApproximateNumber() {
        assertEquals(80, new Student("", "", "", 4.99).getScholarship());
        assertEquals(80, new Student("", "", "", 5.001).getScholarship());
        assertEquals(80, new Student("", "", "", 5.1).getScholarship());
    }
}
