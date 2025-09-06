package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Comprehensive test suite for LeetCode #69: Sqrt(x)
 * 
 * This test suite validates all 6 algorithmic approaches with extensive test cases including edge
 * cases, boundary conditions, and performance validation.
 * 
 * @author Superman
 * @version 1.0
 */
@DisplayName("Sqrt(x) - LeetCode #69")
class SqrtXTest {

    private SqrtX sqrtX;

    @BeforeEach
    void setUp() {
        sqrtX = new SqrtX();
    }

    @Test
    @DisplayName("Test all approaches produce identical results")
    void testAllApproachesConsistency() {
        int[] testCases = {0, 1, 2, 3, 4, 8, 9, 15, 16, 24, 25, 26, 100, 1000, 10000, 100000,
                1000000, 2147483647, 2147395599};

        for (int x : testCases) {
            int result1 = sqrtX.mySqrtBinarySearch(x);
            int result2 = sqrtX.mySqrtNewtonsMethod(x);
            int result3 = sqrtX.mySqrtLinearSearch(x);
            int result4 = sqrtX.mySqrtBitManipulation(x);
            int result5 = sqrtX.mySqrtExponentialSearch(x);
            int result6 = sqrtX.mySqrtOptimized(x);

            assertEquals(result1, result2, "Binary Search vs Newton's Method for x=" + x);
            assertEquals(result1, result3, "Binary Search vs Linear Search for x=" + x);
            assertEquals(result1, result4, "Binary Search vs Bit Manipulation for x=" + x);
            assertEquals(result1, result5, "Binary Search vs Exponential Search for x=" + x);
            assertEquals(result1, result6, "Binary Search vs Optimized for x=" + x);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 8, 9, 15, 16, 24, 25, 26, 100, 1000, 10000})
    @DisplayName("Test Binary Search approach")
    void testBinarySearch(int x) {
        int result = sqrtX.mySqrtBinarySearch(x);
        int expected = (int) Math.sqrt(x);

        assertEquals(expected, result, "Binary Search failed for x=" + x);

        // Verify the result is correct
        assertTrue((long) result * result <= x, "Result too large for x=" + x);
        assertTrue((long) (result + 1) * (result + 1) > x, "Result too small for x=" + x);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 8, 9, 15, 16, 24, 25, 26, 100, 1000, 10000})
    @DisplayName("Test Newton's Method approach")
    void testNewtonsMethod(int x) {
        int result = sqrtX.mySqrtNewtonsMethod(x);
        int expected = (int) Math.sqrt(x);

        assertEquals(expected, result, "Newton's Method failed for x=" + x);

        // Verify the result is correct
        assertTrue((long) result * result <= x, "Result too large for x=" + x);
        assertTrue((long) (result + 1) * (result + 1) > x, "Result too small for x=" + x);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 8, 9, 15, 16, 24, 25, 26, 100, 1000, 10000})
    @DisplayName("Test Linear Search approach")
    void testLinearSearch(int x) {
        int result = sqrtX.mySqrtLinearSearch(x);
        int expected = (int) Math.sqrt(x);

        assertEquals(expected, result, "Linear Search failed for x=" + x);

        // Verify the result is correct
        assertTrue((long) result * result <= x, "Result too large for x=" + x);
        assertTrue((long) (result + 1) * (result + 1) > x, "Result too small for x=" + x);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 8, 9, 15, 16, 24, 25, 26, 100, 1000, 10000})
    @DisplayName("Test Bit Manipulation approach")
    void testBitManipulation(int x) {
        int result = sqrtX.mySqrtBitManipulation(x);
        int expected = (int) Math.sqrt(x);

        assertEquals(expected, result, "Bit Manipulation failed for x=" + x);

        // Verify the result is correct
        assertTrue((long) result * result <= x, "Result too large for x=" + x);
        assertTrue((long) (result + 1) * (result + 1) > x, "Result too small for x=" + x);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 8, 9, 15, 16, 24, 25, 26, 100, 1000, 10000})
    @DisplayName("Test Exponential Search approach")
    void testExponentialSearch(int x) {
        int result = sqrtX.mySqrtExponentialSearch(x);
        int expected = (int) Math.sqrt(x);

        assertEquals(expected, result, "Exponential Search failed for x=" + x);

        // Verify the result is correct
        assertTrue((long) result * result <= x, "Result too large for x=" + x);
        assertTrue((long) (result + 1) * (result + 1) > x, "Result too small for x=" + x);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 8, 9, 15, 16, 24, 25, 26, 100, 1000, 10000})
    @DisplayName("Test Optimized Binary Search approach")
    void testOptimizedBinarySearch(int x) {
        int result = sqrtX.mySqrtOptimized(x);
        int expected = (int) Math.sqrt(x);

        assertEquals(expected, result, "Optimized Binary Search failed for x=" + x);

        // Verify the result is correct
        assertTrue((long) result * result <= x, "Result too large for x=" + x);
        assertTrue((long) (result + 1) * (result + 1) > x, "Result too small for x=" + x);
    }

    @ParameterizedTest
    @CsvSource({"0, 0", "1, 1", "2, 1", "3, 1", "4, 2", "8, 2", "9, 3", "15, 3", "16, 4", "24, 4",
            "25, 5", "26, 5", "100, 10", "1000, 31", "10000, 100", "100000, 316", "1000000, 1000",
            "2147483647, 46340", "2147395599, 46339"})
    @DisplayName("Test specific input-output pairs")
    void testSpecificCases(int x, int expected) {
        int result = sqrtX.mySqrtBinarySearch(x);
        assertEquals(expected, result, "Failed for x=" + x);
    }

    @Test
    @DisplayName("Test edge cases - zero and one")
    void testEdgeCasesZeroAndOne() {
        assertEquals(0, sqrtX.mySqrtBinarySearch(0));
        assertEquals(1, sqrtX.mySqrtBinarySearch(1));

        assertEquals(0, sqrtX.mySqrtNewtonsMethod(0));
        assertEquals(1, sqrtX.mySqrtNewtonsMethod(1));

        assertEquals(0, sqrtX.mySqrtLinearSearch(0));
        assertEquals(1, sqrtX.mySqrtLinearSearch(1));

        assertEquals(0, sqrtX.mySqrtBitManipulation(0));
        assertEquals(1, sqrtX.mySqrtBitManipulation(1));

        assertEquals(0, sqrtX.mySqrtExponentialSearch(0));
        assertEquals(1, sqrtX.mySqrtExponentialSearch(1));

        assertEquals(0, sqrtX.mySqrtOptimized(0));
        assertEquals(1, sqrtX.mySqrtOptimized(1));
    }

    @Test
    @DisplayName("Test perfect squares")
    void testPerfectSquares() {
        int[] perfectSquares = {1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169, 196, 225};

        for (int x : perfectSquares) {
            int expected = (int) Math.sqrt(x);
            assertEquals(expected, sqrtX.mySqrtBinarySearch(x), "Perfect square failed for x=" + x);
            assertEquals(expected, sqrtX.mySqrtNewtonsMethod(x),
                    "Perfect square failed for x=" + x);
            assertEquals(expected, sqrtX.mySqrtLinearSearch(x), "Perfect square failed for x=" + x);
            assertEquals(expected, sqrtX.mySqrtBitManipulation(x),
                    "Perfect square failed for x=" + x);
            assertEquals(expected, sqrtX.mySqrtExponentialSearch(x),
                    "Perfect square failed for x=" + x);
            assertEquals(expected, sqrtX.mySqrtOptimized(x), "Perfect square failed for x=" + x);
        }
    }

    @Test
    @DisplayName("Test non-perfect squares")
    void testNonPerfectSquares() {
        int[] nonPerfectSquares = {2, 3, 5, 6, 7, 8, 10, 11, 12, 13, 14, 15, 17, 18, 19, 20};

        for (int x : nonPerfectSquares) {
            int expected = (int) Math.sqrt(x);
            assertEquals(expected, sqrtX.mySqrtBinarySearch(x),
                    "Non-perfect square failed for x=" + x);
            assertEquals(expected, sqrtX.mySqrtNewtonsMethod(x),
                    "Non-perfect square failed for x=" + x);
            assertEquals(expected, sqrtX.mySqrtLinearSearch(x),
                    "Non-perfect square failed for x=" + x);
            assertEquals(expected, sqrtX.mySqrtBitManipulation(x),
                    "Non-perfect square failed for x=" + x);
            assertEquals(expected, sqrtX.mySqrtExponentialSearch(x),
                    "Non-perfect square failed for x=" + x);
            assertEquals(expected, sqrtX.mySqrtOptimized(x),
                    "Non-perfect square failed for x=" + x);
        }
    }

    @Test
    @DisplayName("Test large numbers")
    void testLargeNumbers() {
        int[] largeNumbers = {1000000, 10000000, 100000000, 1000000000, 2147483647};

        for (int x : largeNumbers) {
            int expected = (int) Math.sqrt(x);
            assertEquals(expected, sqrtX.mySqrtBinarySearch(x), "Large number failed for x=" + x);
            assertEquals(expected, sqrtX.mySqrtNewtonsMethod(x), "Large number failed for x=" + x);
            assertEquals(expected, sqrtX.mySqrtLinearSearch(x), "Large number failed for x=" + x);
            assertEquals(expected, sqrtX.mySqrtBitManipulation(x),
                    "Large number failed for x=" + x);
            assertEquals(expected, sqrtX.mySqrtExponentialSearch(x),
                    "Large number failed for x=" + x);
            assertEquals(expected, sqrtX.mySqrtOptimized(x), "Large number failed for x=" + x);
        }
    }

    @Test
    @DisplayName("Test maximum integer value")
    void testMaxIntegerValue() {
        int x = Integer.MAX_VALUE;
        int expected = (int) Math.sqrt(x);

        assertEquals(expected, sqrtX.mySqrtBinarySearch(x));
        assertEquals(expected, sqrtX.mySqrtNewtonsMethod(x));
        assertEquals(expected, sqrtX.mySqrtLinearSearch(x));
        assertEquals(expected, sqrtX.mySqrtBitManipulation(x));
        assertEquals(expected, sqrtX.mySqrtExponentialSearch(x));
        assertEquals(expected, sqrtX.mySqrtOptimized(x));

        // Verify the result is correct
        int result = sqrtX.mySqrtBinarySearch(x);
        assertTrue((long) result * result <= x, "Result too large for MAX_VALUE");
        assertTrue((long) (result + 1) * (result + 1) > x, "Result too small for MAX_VALUE");
    }

    @Test
    @DisplayName("Test boundary conditions around perfect squares")
    void testBoundaryConditions() {
        // Test numbers just below and above perfect squares
        int[] perfectSquares = {4, 9, 16, 25, 36, 49, 64, 81, 100};

        for (int square : perfectSquares) {
            int sqrt = (int) Math.sqrt(square);

            // Test square - 1
            assertEquals(sqrt - 1, sqrtX.mySqrtBinarySearch(square - 1));
            assertEquals(sqrt - 1, sqrtX.mySqrtNewtonsMethod(square - 1));
            assertEquals(sqrt - 1, sqrtX.mySqrtLinearSearch(square - 1));
            assertEquals(sqrt - 1, sqrtX.mySqrtBitManipulation(square - 1));
            assertEquals(sqrt - 1, sqrtX.mySqrtExponentialSearch(square - 1));
            assertEquals(sqrt - 1, sqrtX.mySqrtOptimized(square - 1));

            // Test the perfect square itself
            assertEquals(sqrt, sqrtX.mySqrtBinarySearch(square));
            assertEquals(sqrt, sqrtX.mySqrtNewtonsMethod(square));
            assertEquals(sqrt, sqrtX.mySqrtLinearSearch(square));
            assertEquals(sqrt, sqrtX.mySqrtBitManipulation(square));
            assertEquals(sqrt, sqrtX.mySqrtExponentialSearch(square));
            assertEquals(sqrt, sqrtX.mySqrtOptimized(square));

            // Test square + 1
            assertEquals(sqrt, sqrtX.mySqrtBinarySearch(square + 1));
            assertEquals(sqrt, sqrtX.mySqrtNewtonsMethod(square + 1));
            assertEquals(sqrt, sqrtX.mySqrtLinearSearch(square + 1));
            assertEquals(sqrt, sqrtX.mySqrtBitManipulation(square + 1));
            assertEquals(sqrt, sqrtX.mySqrtExponentialSearch(square + 1));
            assertEquals(sqrt, sqrtX.mySqrtOptimized(square + 1));
        }
    }

    @Test
    @DisplayName("Test performance with sequential numbers")
    void testPerformanceSequential() {
        int[] sequentialNumbers = new int[1000];
        for (int i = 0; i < 1000; i++) {
            sequentialNumbers[i] = i;
        }

        for (int x : sequentialNumbers) {
            int expected = (int) Math.sqrt(x);
            assertEquals(expected, sqrtX.mySqrtBinarySearch(x),
                    "Sequential test failed for x=" + x);
            assertEquals(expected, sqrtX.mySqrtNewtonsMethod(x),
                    "Sequential test failed for x=" + x);
            assertEquals(expected, sqrtX.mySqrtLinearSearch(x),
                    "Sequential test failed for x=" + x);
            assertEquals(expected, sqrtX.mySqrtBitManipulation(x),
                    "Sequential test failed for x=" + x);
            assertEquals(expected, sqrtX.mySqrtExponentialSearch(x),
                    "Sequential test failed for x=" + x);
            assertEquals(expected, sqrtX.mySqrtOptimized(x), "Sequential test failed for x=" + x);
        }
    }

    @Test
    @DisplayName("Test mathematical properties")
    void testMathematicalProperties() {
        int[] testValues = {1, 2, 3, 4, 5, 10, 25, 50, 100, 1000, 10000};

        for (int x : testValues) {
            int result = sqrtX.mySqrtBinarySearch(x);

            // Property 1: result^2 <= x < (result+1)^2
            assertTrue((long) result * result <= x,
                    "Property 1 failed for x=" + x + ", result=" + result);
            assertTrue((long) (result + 1) * (result + 1) > x,
                    "Property 1 failed for x=" + x + ", result=" + result);

            // Property 2: result is non-negative
            assertTrue(result >= 0, "Result should be non-negative for x=" + x);

            // Property 3: result <= x (since sqrt(x) <= x for x >= 1)
            if (x >= 1) {
                assertTrue(result <= x, "Result should be <= x for x=" + x);
            }
        }
    }

    @Test
    @DisplayName("Test overflow protection")
    void testOverflowProtection() {
        // Test with numbers that could cause overflow when squared
        int[] overflowTestCases = {46340, 46341, 46342, 100000, 1000000, Integer.MAX_VALUE};

        for (int x : overflowTestCases) {
            // All methods should handle overflow gracefully
            assertDoesNotThrow(() -> sqrtX.mySqrtBinarySearch(x),
                    "Binary Search overflow for x=" + x);
            assertDoesNotThrow(() -> sqrtX.mySqrtNewtonsMethod(x),
                    "Newton's Method overflow for x=" + x);
            assertDoesNotThrow(() -> sqrtX.mySqrtLinearSearch(x),
                    "Linear Search overflow for x=" + x);
            assertDoesNotThrow(() -> sqrtX.mySqrtBitManipulation(x),
                    "Bit Manipulation overflow for x=" + x);
            assertDoesNotThrow(() -> sqrtX.mySqrtExponentialSearch(x),
                    "Exponential Search overflow for x=" + x);
            assertDoesNotThrow(() -> sqrtX.mySqrtOptimized(x),
                    "Optimized Binary Search overflow for x=" + x);
        }
    }

    @Test
    @DisplayName("Test consistency across all approaches")
    void testConsistencyAcrossApproaches() {
        int[] testCases = {0, 1, 2, 3, 4, 8, 9, 15, 16, 24, 25, 26, 100, 1000, 10000, 100000,
                1000000, 2147483647, 2147395599};

        for (int x : testCases) {
            int[] results = {sqrtX.mySqrtBinarySearch(x), sqrtX.mySqrtNewtonsMethod(x),
                    sqrtX.mySqrtLinearSearch(x), sqrtX.mySqrtBitManipulation(x),
                    sqrtX.mySqrtExponentialSearch(x), sqrtX.mySqrtOptimized(x)};

            // All results should be identical
            for (int i = 1; i < results.length; i++) {
                assertEquals(results[0], results[i],
                        "Inconsistent results for x=" + x + " between approaches");
            }
        }
    }

    @Test
    @DisplayName("Test edge case: 2147395599 (specific LeetCode test case)")
    void testSpecificLeetCodeCase() {
        int x = 2147395599;
        int expected = 46339;

        assertEquals(expected, sqrtX.mySqrtBinarySearch(x));
        assertEquals(expected, sqrtX.mySqrtNewtonsMethod(x));
        assertEquals(expected, sqrtX.mySqrtLinearSearch(x));
        assertEquals(expected, sqrtX.mySqrtBitManipulation(x));
        assertEquals(expected, sqrtX.mySqrtExponentialSearch(x));
        assertEquals(expected, sqrtX.mySqrtOptimized(x));
    }

    @Test
    @DisplayName("Test edge case: 2147483647 (Integer.MAX_VALUE)")
    void testIntegerMaxValue() {
        int x = 2147483647;
        int expected = 46340;

        assertEquals(expected, sqrtX.mySqrtBinarySearch(x));
        assertEquals(expected, sqrtX.mySqrtNewtonsMethod(x));
        assertEquals(expected, sqrtX.mySqrtLinearSearch(x));
        assertEquals(expected, sqrtX.mySqrtBitManipulation(x));
        assertEquals(expected, sqrtX.mySqrtExponentialSearch(x));
        assertEquals(expected, sqrtX.mySqrtOptimized(x));
    }
}
