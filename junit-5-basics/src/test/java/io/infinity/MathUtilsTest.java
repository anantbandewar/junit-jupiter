package io.infinity;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

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
    @DisplayName("Testing add method")
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
    @DisplayName("Testing Divide method for divide by zero")
    void testDivide() {
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide by zero should throw ArithmeticException");
    }

    @Test
    @Disabled
    @DisplayName("TDD method. Should not run")
    void testDisabled() {
        fail("This test should be disabled");
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    @DisplayName("Only runs on Linux OS")
    void testLinuxTest() {
        fail("This test should not run on non linux OS");
    }

    @Test
    @DisplayName("Multiply method")
    void testMultiply() {
        //assertEquals(4, mathUtils.multiply(2, 2), "Should return the right product");
        assertAll(
                () -> assertEquals(4, mathUtils.multiply(2, 2), "Should return the right product"),
                () -> assertEquals(15, mathUtils.multiply(5, 3), "Should return the right product")
        );
    }

    @Nested
    @DisplayName("Add method")
    class AddTests {
        @Test
        @DisplayName("When adding two +ve numbers")
        void testAddPositive() {
            assertEquals(2, mathUtils.add(1, 1), "Should return the right sum");
        }

        @Test
        @DisplayName("When adding two -ve numbers")
        void testAddNegative() {
            assertEquals(-2, mathUtils.add(-1, -1), "Should return the right sum");
        }
    }
}