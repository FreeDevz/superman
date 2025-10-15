package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Comprehensive test suite for PowerOfTwo problem
 */
public class PowerOfTwoTest {

    private PowerOfTwo solution;

    @BeforeEach
    void setUp() {
        solution = new PowerOfTwo();
    }

    @Nested
    @DisplayName("Bit Manipulation Approach Tests")
    class BitManipulationTests {

        @Test
        @DisplayName("Test power of two: n = 1 (2^0)")
        void testPowerOfTwo1() {
            assertTrue(solution.isPowerOfTwoBitManipulation(1));
        }

        @Test
        @DisplayName("Test power of two: n = 2 (2^1)")
        void testPowerOfTwo2() {
            assertTrue(solution.isPowerOfTwoBitManipulation(2));
        }

        @Test
        @DisplayName("Test power of two: n = 16 (2^4)")
        void testPowerOfTwo16() {
            assertTrue(solution.isPowerOfTwoBitManipulation(16));
        }

        @Test
        @DisplayName("Test not power of two: n = 3")
        void testNotPowerOfTwo3() {
            assertFalse(solution.isPowerOfTwoBitManipulation(3));
        }

        @Test
        @DisplayName("Test not power of two: n = 5")
        void testNotPowerOfTwo5() {
            assertFalse(solution.isPowerOfTwoBitManipulation(5));
        }

        @Test
        @DisplayName("Test zero: n = 0")
        void testZero() {
            assertFalse(solution.isPowerOfTwoBitManipulation(0));
        }

        @Test
        @DisplayName("Test negative number: n = -1")
        void testNegative1() {
            assertFalse(solution.isPowerOfTwoBitManipulation(-1));
        }

        @Test
        @DisplayName("Test negative power of two: n = -16")
        void testNegative16() {
            assertFalse(solution.isPowerOfTwoBitManipulation(-16));
        }

        @Test
        @DisplayName("Test large power of two: n = 1073741824 (2^30)")
        void testLargePowerOfTwo() {
            assertTrue(solution.isPowerOfTwoBitManipulation(1073741824));
        }

        @Test
        @DisplayName("Test all powers of 2 from 2^0 to 2^30")
        void testAllPowersOfTwo() {
            for (int i = 0; i <= 30; i++) {
                int power = 1 << i; // 2^i
                assertTrue(solution.isPowerOfTwoBitManipulation(power),
                        "2^" + i + " = " + power + " should be a power of two");
            }
        }

        @Test
        @DisplayName("Test numbers one less than powers of 2")
        void testOneLessThanPowersOfTwo() {
            for (int i = 2; i <= 30; i++) {
                int power = (1 << i) - 1; // 2^i - 1
                assertFalse(solution.isPowerOfTwoBitManipulation(power),
                        "2^" + i + " - 1 = " + power + " should NOT be a power of two");
            }
        }

        @Test
        @DisplayName("Test numbers one more than powers of 2")
        void testOneMoreThanPowersOfTwo() {
            for (int i = 1; i <= 29; i++) {
                int power = (1 << i) + 1; // 2^i + 1
                assertFalse(solution.isPowerOfTwoBitManipulation(power),
                        "2^" + i + " + 1 = " + power + " should NOT be a power of two");
            }
        }
    }

    @Nested
    @DisplayName("Iterative Division Approach Tests")
    class IterativeDivisionTests {

        @Test
        @DisplayName("Test power of two: n = 1")
        void testPowerOfTwo1() {
            assertTrue(solution.isPowerOfTwoIterativeDivision(1));
        }

        @Test
        @DisplayName("Test power of two: n = 16")
        void testPowerOfTwo16() {
            assertTrue(solution.isPowerOfTwoIterativeDivision(16));
        }

        @Test
        @DisplayName("Test not power of two: n = 3")
        void testNotPowerOfTwo3() {
            assertFalse(solution.isPowerOfTwoIterativeDivision(3));
        }

        @Test
        @DisplayName("Test zero")
        void testZero() {
            assertFalse(solution.isPowerOfTwoIterativeDivision(0));
        }

        @Test
        @DisplayName("Test negative number")
        void testNegative() {
            assertFalse(solution.isPowerOfTwoIterativeDivision(-16));
        }

        @Test
        @DisplayName("Test all powers of 2 from 2^0 to 2^30")
        void testAllPowersOfTwo() {
            for (int i = 0; i <= 30; i++) {
                int power = 1 << i;
                assertTrue(solution.isPowerOfTwoIterativeDivision(power),
                        "2^" + i + " = " + power + " should be a power of two");
            }
        }
    }

    @Nested
    @DisplayName("Recursive Division Approach Tests")
    class RecursiveDivisionTests {

        @Test
        @DisplayName("Test power of two: n = 1")
        void testPowerOfTwo1() {
            assertTrue(solution.isPowerOfTwoRecursiveDivision(1));
        }

        @Test
        @DisplayName("Test power of two: n = 16")
        void testPowerOfTwo16() {
            assertTrue(solution.isPowerOfTwoRecursiveDivision(16));
        }

        @Test
        @DisplayName("Test not power of two: n = 3")
        void testNotPowerOfTwo3() {
            assertFalse(solution.isPowerOfTwoRecursiveDivision(3));
        }

        @Test
        @DisplayName("Test zero")
        void testZero() {
            assertFalse(solution.isPowerOfTwoRecursiveDivision(0));
        }

        @Test
        @DisplayName("Test negative number")
        void testNegative() {
            assertFalse(solution.isPowerOfTwoRecursiveDivision(-16));
        }

        @Test
        @DisplayName("Test all powers of 2 from 2^0 to 2^30")
        void testAllPowersOfTwo() {
            for (int i = 0; i <= 30; i++) {
                int power = 1 << i;
                assertTrue(solution.isPowerOfTwoRecursiveDivision(power),
                        "2^" + i + " = " + power + " should be a power of two");
            }
        }
    }

    @Nested
    @DisplayName("Logarithm Approach Tests")
    class LogarithmTests {

        @Test
        @DisplayName("Test power of two: n = 1")
        void testPowerOfTwo1() {
            assertTrue(solution.isPowerOfTwoLogarithm(1));
        }

        @Test
        @DisplayName("Test power of two: n = 16")
        void testPowerOfTwo16() {
            assertTrue(solution.isPowerOfTwoLogarithm(16));
        }

        @Test
        @DisplayName("Test not power of two: n = 3")
        void testNotPowerOfTwo3() {
            assertFalse(solution.isPowerOfTwoLogarithm(3));
        }

        @Test
        @DisplayName("Test zero")
        void testZero() {
            assertFalse(solution.isPowerOfTwoLogarithm(0));
        }

        @Test
        @DisplayName("Test negative number")
        void testNegative() {
            assertFalse(solution.isPowerOfTwoLogarithm(-16));
        }
    }

    @Nested
    @DisplayName("Count Set Bits Approach Tests")
    class CountSetBitsTests {

        @Test
        @DisplayName("Test power of two: n = 1")
        void testPowerOfTwo1() {
            assertTrue(solution.isPowerOfTwoCountSetBits(1));
        }

        @Test
        @DisplayName("Test power of two: n = 16")
        void testPowerOfTwo16() {
            assertTrue(solution.isPowerOfTwoCountSetBits(16));
        }

        @Test
        @DisplayName("Test not power of two: n = 3")
        void testNotPowerOfTwo3() {
            assertFalse(solution.isPowerOfTwoCountSetBits(3));
        }

        @Test
        @DisplayName("Test zero")
        void testZero() {
            assertFalse(solution.isPowerOfTwoCountSetBits(0));
        }

        @Test
        @DisplayName("Test negative number")
        void testNegative() {
            assertFalse(solution.isPowerOfTwoCountSetBits(-16));
        }

        @Test
        @DisplayName("Test all powers of 2 from 2^0 to 2^30")
        void testAllPowersOfTwo() {
            for (int i = 0; i <= 30; i++) {
                int power = 1 << i;
                assertTrue(solution.isPowerOfTwoCountSetBits(power),
                        "2^" + i + " = " + power + " should be a power of two");
            }
        }
    }

    @Nested
    @DisplayName("Iterative Multiplication Approach Tests")
    class IterativeMultiplicationTests {

        @Test
        @DisplayName("Test power of two: n = 1")
        void testPowerOfTwo1() {
            assertTrue(solution.isPowerOfTwoIterativeMultiplication(1));
        }

        @Test
        @DisplayName("Test power of two: n = 16")
        void testPowerOfTwo16() {
            assertTrue(solution.isPowerOfTwoIterativeMultiplication(16));
        }

        @Test
        @DisplayName("Test not power of two: n = 3")
        void testNotPowerOfTwo3() {
            assertFalse(solution.isPowerOfTwoIterativeMultiplication(3));
        }

        @Test
        @DisplayName("Test zero")
        void testZero() {
            assertFalse(solution.isPowerOfTwoIterativeMultiplication(0));
        }

        @Test
        @DisplayName("Test negative number")
        void testNegative() {
            assertFalse(solution.isPowerOfTwoIterativeMultiplication(-16));
        }

        @Test
        @DisplayName("Test all powers of 2 from 2^0 to 2^30")
        void testAllPowersOfTwo() {
            for (int i = 0; i <= 30; i++) {
                int power = 1 << i;
                assertTrue(solution.isPowerOfTwoIterativeMultiplication(power),
                        "2^" + i + " = " + power + " should be a power of two");
            }
        }
    }

    @Nested
    @DisplayName("Remove Rightmost Bit Approach Tests")
    class RemoveRightmostBitTests {

        @Test
        @DisplayName("Test power of two: n = 1")
        void testPowerOfTwo1() {
            assertTrue(solution.isPowerOfTwoRemoveRightmostBit(1));
        }

        @Test
        @DisplayName("Test power of two: n = 16")
        void testPowerOfTwo16() {
            assertTrue(solution.isPowerOfTwoRemoveRightmostBit(16));
        }

        @Test
        @DisplayName("Test not power of two: n = 3")
        void testNotPowerOfTwo3() {
            assertFalse(solution.isPowerOfTwoRemoveRightmostBit(3));
        }

        @Test
        @DisplayName("Test zero")
        void testZero() {
            assertFalse(solution.isPowerOfTwoRemoveRightmostBit(0));
        }

        @Test
        @DisplayName("Test negative number")
        void testNegative() {
            assertFalse(solution.isPowerOfTwoRemoveRightmostBit(-16));
        }

        @Test
        @DisplayName("Test all powers of 2 from 2^0 to 2^30")
        void testAllPowersOfTwo() {
            for (int i = 0; i <= 30; i++) {
                int power = 1 << i;
                assertTrue(solution.isPowerOfTwoRemoveRightmostBit(power),
                        "2^" + i + " = " + power + " should be a power of two");
            }
        }
    }

    @Nested
    @DisplayName("Check Against Largest Approach Tests")
    class CheckAgainstLargestTests {

        @Test
        @DisplayName("Test power of two: n = 1")
        void testPowerOfTwo1() {
            assertTrue(solution.isPowerOfTwoCheckAgainstLargest(1));
        }

        @Test
        @DisplayName("Test power of two: n = 16")
        void testPowerOfTwo16() {
            assertTrue(solution.isPowerOfTwoCheckAgainstLargest(16));
        }

        @Test
        @DisplayName("Test not power of two: n = 3")
        void testNotPowerOfTwo3() {
            assertFalse(solution.isPowerOfTwoCheckAgainstLargest(3));
        }

        @Test
        @DisplayName("Test zero")
        void testZero() {
            assertFalse(solution.isPowerOfTwoCheckAgainstLargest(0));
        }

        @Test
        @DisplayName("Test negative number")
        void testNegative() {
            assertFalse(solution.isPowerOfTwoCheckAgainstLargest(-16));
        }

        @Test
        @DisplayName("Test all powers of 2 from 2^0 to 2^30")
        void testAllPowersOfTwo() {
            for (int i = 0; i <= 30; i++) {
                int power = 1 << i;
                assertTrue(solution.isPowerOfTwoCheckAgainstLargest(power),
                        "2^" + i + " = " + power + " should be a power of two");
            }
        }

        @Test
        @DisplayName("Test largest power of 2 in 32-bit signed integer")
        void testLargestPowerOfTwo() {
            assertTrue(solution.isPowerOfTwoCheckAgainstLargest(1073741824));
        }
    }

    @Nested
    @DisplayName("LeetCode Examples Tests")
    class LeetCodeExamplesTests {

        @Test
        @DisplayName("Example 1: n = 1")
        void testExample1() {
            assertTrue(solution.isPowerOfTwoBitManipulation(1));
        }

        @Test
        @DisplayName("Example 2: n = 16")
        void testExample2() {
            assertTrue(solution.isPowerOfTwoBitManipulation(16));
        }

        @Test
        @DisplayName("Example 3: n = 3")
        void testExample3() {
            assertFalse(solution.isPowerOfTwoBitManipulation(3));
        }
    }

    @Nested
    @DisplayName("Edge Cases Tests")
    class EdgeCasesTests {

        @Test
        @DisplayName("Test minimum positive power of two: n = 1 (2^0)")
        void testMinPowerOfTwo() {
            assertTrue(solution.isPowerOfTwoBitManipulation(1));
        }

        @Test
        @DisplayName("Test maximum 32-bit signed power of two: n = 1073741824 (2^30)")
        void testMaxPowerOfTwo() {
            assertTrue(solution.isPowerOfTwoBitManipulation(1073741824));
        }

        @Test
        @DisplayName("Test Integer.MAX_VALUE (2^31 - 1)")
        void testIntegerMaxValue() {
            assertFalse(solution.isPowerOfTwoBitManipulation(Integer.MAX_VALUE));
        }

        @Test
        @DisplayName("Test Integer.MIN_VALUE (-2^31)")
        void testIntegerMinValue() {
            assertFalse(solution.isPowerOfTwoBitManipulation(Integer.MIN_VALUE));
        }

        @Test
        @DisplayName("Test zero")
        void testZero() {
            assertFalse(solution.isPowerOfTwoBitManipulation(0));
        }

        @Test
        @DisplayName("Test negative numbers that are negative of powers of two")
        void testNegativePowersOfTwo() {
            int[] negatives = {-1, -2, -4, -8, -16, -32, -64, -128, -256, -512, -1024};
            for (int n : negatives) {
                assertFalse(solution.isPowerOfTwoBitManipulation(n),
                        n + " should NOT be a power of two");
            }
        }
    }

    @Nested
    @DisplayName("Boundary Tests")
    class BoundaryTests {

        @Test
        @DisplayName("Test numbers around small powers of two")
        void testAroundSmallPowers() {
            // Around 2^2 = 4
            assertFalse(solution.isPowerOfTwoBitManipulation(3));
            assertTrue(solution.isPowerOfTwoBitManipulation(4));
            assertFalse(solution.isPowerOfTwoBitManipulation(5));

            // Around 2^3 = 8
            assertFalse(solution.isPowerOfTwoBitManipulation(7));
            assertTrue(solution.isPowerOfTwoBitManipulation(8));
            assertFalse(solution.isPowerOfTwoBitManipulation(9));
        }

        @Test
        @DisplayName("Test numbers around large powers of two")
        void testAroundLargePowers() {
            // Around 2^20 = 1048576
            assertFalse(solution.isPowerOfTwoBitManipulation(1048575));
            assertTrue(solution.isPowerOfTwoBitManipulation(1048576));
            assertFalse(solution.isPowerOfTwoBitManipulation(1048577));

            // Around 2^30 = 1073741824
            assertFalse(solution.isPowerOfTwoBitManipulation(1073741823));
            assertTrue(solution.isPowerOfTwoBitManipulation(1073741824));
            assertFalse(solution.isPowerOfTwoBitManipulation(1073741825));
        }
    }

    @Nested
    @DisplayName("Cross-Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @Test
        @DisplayName("All approaches should agree for powers of two")
        void testAllApproachesAgreeForPowersOfTwo() {
            int[] powersOfTwo = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192,
                    16384, 32768, 65536, 131072, 262144, 524288, 1048576};

            for (int n : powersOfTwo) {
                boolean result1 = solution.isPowerOfTwoBitManipulation(n);
                boolean result2 = solution.isPowerOfTwoIterativeDivision(n);
                boolean result3 = solution.isPowerOfTwoRecursiveDivision(n);
                boolean result4 = solution.isPowerOfTwoCountSetBits(n);
                boolean result5 = solution.isPowerOfTwoIterativeMultiplication(n);
                boolean result6 = solution.isPowerOfTwoRemoveRightmostBit(n);
                boolean result7 = solution.isPowerOfTwoCheckAgainstLargest(n);

                assertTrue(result1, "Bit Manipulation failed for " + n);
                assertTrue(result2, "Iterative Division failed for " + n);
                assertTrue(result3, "Recursive Division failed for " + n);
                assertTrue(result4, "Count Set Bits failed for " + n);
                assertTrue(result5, "Iterative Multiplication failed for " + n);
                assertTrue(result6, "Remove Rightmost Bit failed for " + n);
                assertTrue(result7, "Check Against Largest failed for " + n);
            }
        }

        @Test
        @DisplayName("All approaches should agree for non-powers of two")
        void testAllApproachesAgreeForNonPowersOfTwo() {
            int[] nonPowersOfTwo = {0, 3, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15, 17, 100, 1000, 10000,
                    12345, 99999, -1, -16};

            for (int n : nonPowersOfTwo) {
                boolean result1 = solution.isPowerOfTwoBitManipulation(n);
                boolean result2 = solution.isPowerOfTwoIterativeDivision(n);
                boolean result3 = solution.isPowerOfTwoRecursiveDivision(n);
                boolean result4 = solution.isPowerOfTwoCountSetBits(n);
                boolean result5 = solution.isPowerOfTwoIterativeMultiplication(n);
                boolean result6 = solution.isPowerOfTwoRemoveRightmostBit(n);
                boolean result7 = solution.isPowerOfTwoCheckAgainstLargest(n);

                assertFalse(result1, "Bit Manipulation failed for " + n);
                assertFalse(result2, "Iterative Division failed for " + n);
                assertFalse(result3, "Recursive Division failed for " + n);
                assertFalse(result4, "Count Set Bits failed for " + n);
                assertFalse(result5, "Iterative Multiplication failed for " + n);
                assertFalse(result6, "Remove Rightmost Bit failed for " + n);
                assertFalse(result7, "Check Against Largest failed for " + n);
            }
        }
    }

    @Nested
    @DisplayName("Utility Methods Tests")
    class UtilityMethodsTests {

        @Test
        @DisplayName("Test getPowerOfTwo for valid powers")
        void testGetPowerOfTwoValid() {
            assertEquals(0, solution.getPowerOfTwo(1)); // 2^0 = 1
            assertEquals(1, solution.getPowerOfTwo(2)); // 2^1 = 2
            assertEquals(4, solution.getPowerOfTwo(16)); // 2^4 = 16
            assertEquals(10, solution.getPowerOfTwo(1024)); // 2^10 = 1024
            assertEquals(30, solution.getPowerOfTwo(1073741824)); // 2^30 = 1073741824
        }

        @Test
        @DisplayName("Test getPowerOfTwo for non-powers")
        void testGetPowerOfTwoInvalid() {
            assertEquals(-1, solution.getPowerOfTwo(3));
            assertEquals(-1, solution.getPowerOfTwo(5));
            assertEquals(-1, solution.getPowerOfTwo(0));
            assertEquals(-1, solution.getPowerOfTwo(-1));
        }

        @Test
        @DisplayName("Test nextPowerOfTwo")
        void testNextPowerOfTwo() {
            assertEquals(1, solution.nextPowerOfTwo(0));
            assertEquals(1, solution.nextPowerOfTwo(1));
            assertEquals(2, solution.nextPowerOfTwo(2));
            assertEquals(4, solution.nextPowerOfTwo(3));
            assertEquals(8, solution.nextPowerOfTwo(5));
            assertEquals(8, solution.nextPowerOfTwo(8));
            assertEquals(16, solution.nextPowerOfTwo(9));
            assertEquals(16, solution.nextPowerOfTwo(16));
            assertEquals(32, solution.nextPowerOfTwo(17));
            assertEquals(128, solution.nextPowerOfTwo(100));
            assertEquals(1024, solution.nextPowerOfTwo(1000));
        }

        @Test
        @DisplayName("Test previousPowerOfTwo")
        void testPreviousPowerOfTwo() {
            assertEquals(0, solution.previousPowerOfTwo(0));
            assertEquals(1, solution.previousPowerOfTwo(1));
            assertEquals(2, solution.previousPowerOfTwo(2));
            assertEquals(2, solution.previousPowerOfTwo(3));
            assertEquals(4, solution.previousPowerOfTwo(5));
            assertEquals(8, solution.previousPowerOfTwo(8));
            assertEquals(8, solution.previousPowerOfTwo(9));
            assertEquals(16, solution.previousPowerOfTwo(16));
            assertEquals(16, solution.previousPowerOfTwo(17));
            assertEquals(64, solution.previousPowerOfTwo(100));
            assertEquals(512, solution.previousPowerOfTwo(1000));
        }

        @Test
        @DisplayName("Test checkWithBinaryRepresentation")
        void testCheckWithBinaryRepresentation() {
            String result1 = solution.checkWithBinaryRepresentation(8);
            assertTrue(result1.contains("n=8"));
            assertTrue(result1.contains("isPowerOfTwo=true"));
            assertTrue(result1.contains("binary="));

            String result2 = solution.checkWithBinaryRepresentation(3);
            assertTrue(result2.contains("n=3"));
            assertTrue(result2.contains("isPowerOfTwo=false"));
            assertTrue(result2.contains("binary="));
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Test performance with large inputs")
        void testLargeInputs() {
            long startTime, endTime;

            // Test with maximum power of two
            int n = 1073741824; // 2^30

            // Bit Manipulation (should be fastest)
            startTime = System.nanoTime();
            boolean result1 = solution.isPowerOfTwoBitManipulation(n);
            endTime = System.nanoTime();
            long time1 = endTime - startTime;

            // Count Set Bits
            startTime = System.nanoTime();
            boolean result2 = solution.isPowerOfTwoCountSetBits(n);
            endTime = System.nanoTime();

            // All should return true
            assertTrue(result1);
            assertTrue(result2);

            // Performance assertion (bit manipulation should be very fast)
            assertTrue(time1 < 1000000); // Should be under 1ms
        }

        @Test
        @DisplayName("Test all powers of 2 from 0 to 30")
        void testAllPowersPerformance() {
            for (int i = 0; i <= 30; i++) {
                int power = 1 << i;
                assertTrue(solution.isPowerOfTwoBitManipulation(power));
            }
        }
    }

    @Nested
    @DisplayName("Binary Pattern Tests")
    class BinaryPatternTests {

        @Test
        @DisplayName("Test binary pattern of powers of two")
        void testBinaryPatternPowersOfTwo() {
            // Powers of 2 should have exactly one bit set
            int[] powersOfTwo = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};

            for (int n : powersOfTwo) {
                int bitCount = Integer.bitCount(n);
                assertEquals(1, bitCount, "Power of 2 (" + n + ") should have exactly 1 bit set");
            }
        }

        @Test
        @DisplayName("Test binary pattern of non-powers of two")
        void testBinaryPatternNonPowersOfTwo() {
            // Non-powers of 2 should have != 1 bit set
            int[] nonPowersOfTwo = {3, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15};

            for (int n : nonPowersOfTwo) {
                int bitCount = Integer.bitCount(n);
                assertNotEquals(1, bitCount,
                        "Non-power of 2 (" + n + ") should NOT have exactly 1 bit set");
            }
        }

        @Test
        @DisplayName("Test n & (n-1) pattern for powers of two")
        void testBitManipulationPattern() {
            // For powers of 2, n & (n-1) should be 0
            int[] powersOfTwo = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};

            for (int n : powersOfTwo) {
                assertEquals(0, n & (n - 1), "For power of 2 (" + n + "), n & (n-1) should be 0");
            }
        }

        @Test
        @DisplayName("Test n & (n-1) pattern for non-powers of two")
        void testBitManipulationPatternNonPowers() {
            // For non-powers of 2, n & (n-1) should NOT be 0
            int[] nonPowersOfTwo = {3, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15};

            for (int n : nonPowersOfTwo) {
                assertNotEquals(0, n & (n - 1),
                        "For non-power of 2 (" + n + "), n & (n-1) should NOT be 0");
            }
        }
    }
}

