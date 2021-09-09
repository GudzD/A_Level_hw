package ua.gudz.hw7.task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AspirantTest {
    @Test
    void testIntegerNumber() {
        assertEquals(180, new Aspirant("", "", "", 4, "")
                .getScholarship());
        assertEquals(200, new Aspirant("", "", "", 5, "")
                .getScholarship());
        assertEquals(180, new Aspirant("", "", "", 0, "")
                .getScholarship());
    }

    @Test
    void testAverageMarkIsApproximateNumber() {
        assertEquals(180, new Aspirant("", "", "", 4.99, "")
                .getScholarship());
        assertEquals(180, new Aspirant("", "", "", 5.001, "")
                .getScholarship());
        assertEquals(180, new Aspirant("", "", "", 5.1, "")
                .getScholarship());
    }
}
