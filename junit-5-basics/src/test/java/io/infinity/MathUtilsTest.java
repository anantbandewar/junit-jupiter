package io.infinity;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_METHOD)
// This is by DEFAULT. Same as @BeforeEach lifecycle method, the instance of this class gets created.

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
// If we set this, we can have a non-static method for @BeforeAll. As only one instance of this class gets created.

class MathUtilsTest {

    MathUtils mathUtils;

    @BeforeAll
    // This needs to be static, because we won't be having an instance of this class created at this point.
    static void beforeAllInit() {
        System.out.println("This needs to run before all");
    }

    @BeforeEach
    void init() {
        mathUtils = new MathUtils();
    }

    @AfterEach
    void cleanup() {
        System.out.println("Cleaning up...");
    }

    @Test
    void testAdd() {
        int expected = 2;
        int actual = mathUtils.add(1, 1);

        assertEquals(expected, actual);
    }

    @Test
    void testComputeCircleArea() {
        double radius = 10;
        double expected = 314.1592653589793;
        double actual = mathUtils.computeCircleArea(radius);

        assertEquals(expected, actual, "Should return right circle area");
    }

    @Test
    void testDivide() {
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide by zero should throw ArithmeticException");
    }
}