package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Comprehensive test suite for LeetCode 338: Counting Bits
 * 
 * This test class validates all solution approaches for the Counting Bits problem, ensuring
 * correctness across various test cases including edge cases, boundary conditions, and performance
 * scenarios.
 * 
 * @author LeetCode Test Suite
 * @version 1.0
 */
public class CountingBitsTest {

    private CountingBits solution;

    @BeforeEach
    void setUp() {
        solution = new CountingBits();
    }

    @Nested
    @DisplayName("Dynamic Programming Right Shift Approach Tests")
    class DPRightShiftApproachTests {

        @Test
        @DisplayName("Test with n = 0")
        void testWithZero() {
            int[] expected = {0};
            int[] result = solution.countBitsDP(0);
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test with n = 1")
        void testWithOne() {
            int[] expected = {0, 1};
            int[] result = solution.countBitsDP(1);
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test with n = 2")
        void testWithTwo() {
            int[] expected = {0, 1, 1};
            int[] result = solution.countBitsDP(2);
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test with n = 5")
        void testWithFive() {
            int[] expected = {0, 1, 1, 2, 1, 2};
            int[] result = solution.countBitsDP(5);
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test with n = 8")
        void testWithEight() {
            int[] expected = {0, 1, 1, 2, 1, 2, 2, 3, 1};
            int[] result = solution.countBitsDP(8);
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test with n = 15")
        void testWithFifteen() {
            int[] expected = {0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4};
            int[] result = solution.countBitsDP(15);
            assertArrayEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Dynamic Programming Power of 2 Approach Tests")
    class DPPowerOf2ApproachTests {

        @Test
        @DisplayName("Test with n = 0")
        void testWithZero() {
            int[] expected = {0};
            int[] result = solution.countBitsPowerOf2(0);
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test with n = 5")
        void testWithFive() {
            int[] expected = {0, 1, 1, 2, 1, 2};
            int[] result = solution.countBitsPowerOf2(5);
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test with power of 2 values")
        void testWithPowerOfTwoValues() {
            // Test n = 7 (just before 8)
            int[] expected = {0, 1, 1, 2, 1, 2, 2, 3};
            int[] result = solution.countBitsPowerOf2(7);
            assertArrayEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Dynamic Programming Last Set Bit Approach Tests")
    class DPLastSetBitApproachTests {

        @Test
        @DisplayName("Test with n = 0")
        void testWithZero() {
            int[] expected = {0};
            int[] result = solution.countBitsLastSetBit(0);
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test with n = 5")
        void testWithFive() {
            int[] expected = {0, 1, 1, 2, 1, 2};
            int[] result = solution.countBitsLastSetBit(5);
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test with consecutive numbers")
        void testWithConsecutiveNumbers() {
            int[] expected = {0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4};
            int[] result = solution.countBitsLastSetBit(15);
            assertArrayEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Naive Approach Tests")
    class NaiveApproachTests {

        @Test
        @DisplayName("Test with n = 0")
        void testWithZero() {
            int[] expected = {0};
            int[] result = solution.countBitsNaive(0);
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test with n = 5")
        void testWithFive() {
            int[] expected = {0, 1, 1, 2, 1, 2};
            int[] result = solution.countBitsNaive(5);
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test with larger values")
        void testWithLargerValues() {
            int[] expected = {0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4};
            int[] result = solution.countBitsNaive(15);
            assertArrayEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Built-in Method Tests")
    class BuiltInMethodTests {

        @Test
        @DisplayName("Test with n = 0")
        void testWithZero() {
            int[] expected = {0};
            int[] result = solution.countBitsBuiltIn(0);
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test with n = 5")
        void testWithFive() {
            int[] expected = {0, 1, 1, 2, 1, 2};
            int[] result = solution.countBitsBuiltIn(5);
            assertArrayEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Optimized Approach Tests")
    class OptimizedApproachTests {

        @Test
        @DisplayName("Test with n = 0")
        void testWithZero() {
            int[] expected = {0};
            int[] result = solution.countBitsOptimized(0);
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test with n = 5")
        void testWithFive() {
            int[] expected = {0, 1, 1, 2, 1, 2};
            int[] result = solution.countBitsOptimized(5);
            assertArrayEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Cross Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @Test
        @DisplayName("All approaches should produce same result for n = 0")
        void testAllApproachesWithZero() {
            int[] dpResult = solution.countBitsDP(0);
            int[] powerOf2Result = solution.countBitsPowerOf2(0);
            int[] lastSetBitResult = solution.countBitsLastSetBit(0);
            int[] naiveResult = solution.countBitsNaive(0);
            int[] builtInResult = solution.countBitsBuiltIn(0);
            int[] optimizedResult = solution.countBitsOptimized(0);

            assertArrayEquals(dpResult, powerOf2Result);
            assertArrayEquals(powerOf2Result, lastSetBitResult);
            assertArrayEquals(lastSetBitResult, naiveResult);
            assertArrayEquals(naiveResult, builtInResult);
            assertArrayEquals(builtInResult, optimizedResult);
        }

        @Test
        @DisplayName("All approaches should produce same result for n = 5")
        void testAllApproachesWithFive() {
            int[] dpResult = solution.countBitsDP(5);
            int[] powerOf2Result = solution.countBitsPowerOf2(5);
            int[] lastSetBitResult = solution.countBitsLastSetBit(5);
            int[] naiveResult = solution.countBitsNaive(5);
            int[] builtInResult = solution.countBitsBuiltIn(5);
            int[] optimizedResult = solution.countBitsOptimized(5);

            assertArrayEquals(dpResult, powerOf2Result);
            assertArrayEquals(powerOf2Result, lastSetBitResult);
            assertArrayEquals(lastSetBitResult, naiveResult);
            assertArrayEquals(naiveResult, builtInResult);
            assertArrayEquals(builtInResult, optimizedResult);
        }

        @Test
        @DisplayName("All approaches should produce same result for n = 15")
        void testAllApproachesWithFifteen() {
            int[] dpResult = solution.countBitsDP(15);
            int[] powerOf2Result = solution.countBitsPowerOf2(15);
            int[] lastSetBitResult = solution.countBitsLastSetBit(15);
            int[] naiveResult = solution.countBitsNaive(15);
            int[] builtInResult = solution.countBitsBuiltIn(15);
            int[] optimizedResult = solution.countBitsOptimized(15);

            assertArrayEquals(dpResult, powerOf2Result);
            assertArrayEquals(powerOf2Result, lastSetBitResult);
            assertArrayEquals(lastSetBitResult, naiveResult);
            assertArrayEquals(naiveResult, builtInResult);
            assertArrayEquals(builtInResult, optimizedResult);
        }
    }

    @Nested
    @DisplayName("Edge Case Tests")
    class EdgeCaseTests {

        @Test
        @DisplayName("Test with maximum constraint value")
        void testWithMaximumValue() {
            int n = 100000; // Maximum constraint value
            int[] dpResult = solution.countBitsDP(n);
            int[] powerOf2Result = solution.countBitsPowerOf2(n);
            int[] lastSetBitResult = solution.countBitsLastSetBit(n);
            int[] optimizedResult = solution.countBitsOptimized(n);

            // Verify array length
            assertEquals(n + 1, dpResult.length);
            assertEquals(n + 1, powerOf2Result.length);
            assertEquals(n + 1, lastSetBitResult.length);
            assertEquals(n + 1, optimizedResult.length);

            // Verify all approaches produce same result
            assertArrayEquals(dpResult, powerOf2Result);
            assertArrayEquals(powerOf2Result, lastSetBitResult);
            assertArrayEquals(lastSetBitResult, optimizedResult);

            // Verify specific values
            assertEquals(0, dpResult[0]);
            assertEquals(1, dpResult[1]);
            assertEquals(1, dpResult[2]);
            assertEquals(2, dpResult[3]);
        }

        @Test
        @DisplayName("Test with power of 2 boundary")
        void testWithPowerOfTwoBoundary() {
            int n = 16; // 2^4
            int[] result = solution.countBitsDP(n);

            // Verify that powers of 2 have exactly 1 bit set
            assertEquals(1, result[1]); // 2^0
            assertEquals(1, result[2]); // 2^1
            assertEquals(1, result[4]); // 2^2
            assertEquals(1, result[8]); // 2^3
            assertEquals(1, result[16]); // 2^4
        }

        @Test
        @DisplayName("Test with consecutive odd and even numbers")
        void testWithConsecutiveNumbers() {
            int n = 10;
            int[] result = solution.countBitsDP(n);

            // Test pattern: even numbers should have same count as n/2
            // odd numbers should have count of n/2 + 1
            for (int i = 1; i <= n; i++) {
                if (i % 2 == 0) {
                    assertEquals(result[i / 2], result[i]);
                } else {
                    assertEquals(result[i / 2] + 1, result[i]);
                }
            }
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Performance comparison for moderate input size")
        void testPerformanceComparison() {
            int n = 10000;

            long startTime, endTime;

            // Test DP Right Shift approach
            startTime = System.nanoTime();
            int[] dpResult = solution.countBitsDP(n);
            endTime = System.nanoTime();
            long dpTime = endTime - startTime;

            // Test Power of 2 approach
            startTime = System.nanoTime();
            int[] powerOf2Result = solution.countBitsPowerOf2(n);
            endTime = System.nanoTime();
            long powerOf2Time = endTime - startTime;

            // Test Last Set Bit approach
            startTime = System.nanoTime();
            int[] lastSetBitResult = solution.countBitsLastSetBit(n);
            endTime = System.nanoTime();
            long lastSetBitTime = endTime - startTime;

            // Test Optimized approach
            startTime = System.nanoTime();
            int[] optimizedResult = solution.countBitsOptimized(n);
            endTime = System.nanoTime();
            long optimizedTime = endTime - startTime;

            // Verify all approaches produce same result
            assertArrayEquals(dpResult, powerOf2Result);
            assertArrayEquals(powerOf2Result, lastSetBitResult);
            assertArrayEquals(lastSetBitResult, optimizedResult);

            // Performance should be reasonable (less than 1 second for n=10000)
            assertTrue(dpTime < 1_000_000_000L, "DP approach took too long: " + dpTime + " ns");
            assertTrue(powerOf2Time < 1_000_000_000L,
                    "Power of 2 approach took too long: " + powerOf2Time + " ns");
            assertTrue(lastSetBitTime < 1_000_000_000L,
                    "Last set bit approach took too long: " + lastSetBitTime + " ns");
            assertTrue(optimizedTime < 1_000_000_000L,
                    "Optimized approach took too long: " + optimizedTime + " ns");
        }
    }

    @Nested
    @DisplayName("Binary Pattern Tests")
    class BinaryPatternTests {

        @Test
        @DisplayName("Test binary patterns for small numbers")
        void testBinaryPatterns() {
            int n = 7;
            int[] result = solution.countBitsDP(n);

            // Verify binary patterns manually
            assertEquals(0, result[0]); // 0 -> 0 (0 bits)
            assertEquals(1, result[1]); // 1 -> 1 (1 bit)
            assertEquals(1, result[2]); // 2 -> 10 (1 bit)
            assertEquals(2, result[3]); // 3 -> 11 (2 bits)
            assertEquals(1, result[4]); // 4 -> 100 (1 bit)
            assertEquals(2, result[5]); // 5 -> 101 (2 bits)
            assertEquals(2, result[6]); // 6 -> 110 (2 bits)
            assertEquals(3, result[7]); // 7 -> 111 (3 bits)
        }

        @Test
        @DisplayName("Test that count never exceeds log2(n) + 1")
        void testCountUpperBound() {
            int n = 1000;
            int[] result = solution.countBitsDP(n);

            int maxBits = (int) (Math.log(n) / Math.log(2)) + 1;

            for (int i = 0; i <= n; i++) {
                assertTrue(result[i] <= maxBits, "Count for " + i + " (" + result[i]
                        + ") exceeds theoretical maximum (" + maxBits + ")");
            }
        }
    }
}
