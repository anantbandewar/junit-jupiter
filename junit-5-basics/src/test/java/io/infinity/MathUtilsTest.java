package io.infinity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MathUtilsTest {

    @Test
    void add() {
        MathUtils mathUtils = new MathUtils();

        int expected = 2;
        int actual = mathUtils.add(1, 1);

        assertEquals(expected, actual);
    }

    @Test
    void computeCircleArea() {
        MathUtils mathUtils = new MathUtils();

        double radius = 10;
        double expected = 314.1592653589793;
        double actual = mathUtils.computeCircleArea(radius);

        assertEquals(expected, actual, "Should return right circle area");
    }
}