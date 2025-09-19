package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Comprehensive test suite for Reverse Bits problem Tests all seven different approaches with
 * various test cases
 */
@DisplayName("Reverse Bits Tests")
class ReverseBitsTest {

    private ReverseBits solution;

    @BeforeEach
    void setUp() {
        solution = new ReverseBits();
    }

    @Nested
    @DisplayName("Bit-by-bit Reversal Tests")
    class BitByBitApproachTests {

        @Test
        @DisplayName("Basic test case 1")
        void testBasicCase1() {
            int n = 43261596; // 00000010100101000001111010011100
            int expected = 964176192; // 00111001011110000010100101000000
            int result = solution.reverseBits(n);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Basic test case 2")
        void testBasicCase2() {
            int n = -3; // 11111111111111111111111111111101
            int expected = -1073741825; // 10111111111111111111111111111111
            int result = solution.reverseBits(n);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Zero input")
        void testZeroInput() {
            int n = 0;
            int expected = 0;
            int result = solution.reverseBits(n);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Single bit set")
        void testSingleBitSet() {
            int n = 1; // 00000000000000000000000000000001
            int expected = -2147483648; // 10000000000000000000000000000000
            int result = solution.reverseBits(n);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("All bits set")
        void testAllBitsSet() {
            int n = -1; // 11111111111111111111111111111111
            int expected = -1; // 11111111111111111111111111111111
            int result = solution.reverseBits(n);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Alternating pattern")
        void testAlternatingPattern() {
            int n = 1431655765; // 01010101010101010101010101010101
            int expected = -1431655766; // 10101010101010101010101010101010
            int result = solution.reverseBits(n);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Maximum positive integer")
        void testMaxPositiveInteger() {
            int n = 2147483647; // 01111111111111111111111111111111
            int expected = -2; // 11111111111111111111111111111110
            int result = solution.reverseBits(n);
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Optimal Bit Manipulation Tests")
    class OptimalApproachTests {

        @Test
        @DisplayName("Optimal approach basic test")
        void testOptimalBasic() {
            int n = 43261596;
            int expected = 964176192;
            int result = solution.reverseBitsOptimal(n);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Optimal approach edge case")
        void testOptimalEdgeCase() {
            int n = 0;
            int expected = 0;
            int result = solution.reverseBitsOptimal(n);
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Lookup Table Approach Tests")
    class LookupTableApproachTests {

        @Test
        @DisplayName("Lookup table basic test")
        void testLookupTableBasic() {
            int n = 43261596;
            int expected = 964176192;
            int result = solution.reverseBitsLookupTable(n);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Lookup table edge case")
        void testLookupTableEdgeCase() {
            int n = 1;
            int expected = -2147483648;
            int result = solution.reverseBitsLookupTable(n);
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Divide and Conquer Tests")
    class DivideConquerTests {

        @Test
        @DisplayName("Divide and conquer basic test")
        void testDivideConquerBasic() {
            int n = 43261596;
            int expected = 964176192;
            int result = solution.reverseBitsDivideConquer(n);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Divide and conquer edge case")
        void testDivideConquerEdgeCase() {
            int n = 0;
            int expected = 0;
            int result = solution.reverseBitsDivideConquer(n);
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("String-based Approach Tests")
    class StringBasedApproachTests {

        @Test
        @DisplayName("String-based basic test")
        void testStringBasedBasic() {
            int n = 43261596;
            int expected = 964176192;
            int result = solution.reverseBitsString(n);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("String-based edge case")
        void testStringBasedEdgeCase() {
            int n = 1;
            int expected = -2147483648;
            int result = solution.reverseBitsString(n);
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Precomputed Masks Tests")
    class PrecomputedMasksTests {

        @Test
        @DisplayName("Precomputed masks basic test")
        void testPrecomputedMasksBasic() {
            int n = 43261596;
            int expected = 964176192;
            int result = solution.reverseBitsPrecomputedMasks(n);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Precomputed masks edge case")
        void testPrecomputedMasksEdgeCase() {
            int n = 0;
            int expected = 0;
            int result = solution.reverseBitsPrecomputedMasks(n);
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Two-Pointer Approach Tests")
    class TwoPointerApproachTests {

        @Test
        @DisplayName("Two-pointer basic test")
        void testTwoPointerBasic() {
            int n = 43261596;
            int expected = 964176192;
            int result = solution.reverseBitsTwoPointer(n);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Two-pointer edge case")
        void testTwoPointerEdgeCase() {
            int n = 1;
            int expected = -2147483648;
            int result = solution.reverseBitsTwoPointer(n);
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Cross-Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @Test
        @DisplayName("All approaches should produce same results")
        void testAllApproachesProduceSameResults() {
            int[] testCases = {43261596, -3, 0, 1, 2147483647, 1431655765, -1, -1431655766};

            for (int n : testCases) {
                int result1 = solution.reverseBits(n);
                int result2 = solution.reverseBitsOptimal(n);
                int result3 = solution.reverseBitsLookupTable(n);
                int result4 = solution.reverseBitsDivideConquer(n);
                int result5 = solution.reverseBitsString(n);
                int result6 = solution.reverseBitsPrecomputedMasks(n);
                int result7 = solution.reverseBitsTwoPointer(n);

                // All approaches should produce the same result
                assertEquals(result1, result2, "Optimal differs from bit-by-bit");
                assertEquals(result2, result3, "Lookup table differs from optimal");
                assertEquals(result3, result4, "Divide & conquer differs from lookup table");
                assertEquals(result4, result5, "String-based differs from divide & conquer");
                assertEquals(result5, result6, "Precomputed masks differs from string-based");
                assertEquals(result6, result7, "Two-pointer differs from precomputed masks");
            }
        }
    }

    @Nested
    @DisplayName("Edge Case Tests")
    class EdgeCaseTests {

        @Test
        @DisplayName("Minimum input")
        void testMinimumInput() {
            int n = 0;
            int expected = 0;
            int result = solution.reverseBits(n);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Single bit patterns")
        void testSingleBitPatterns() {
            // Test each bit position
            for (int i = 0; i < 32; i++) {
                int n = 1 << i;
                int expected = 1 << (31 - i);
                int result = solution.reverseBits(n);
                assertEquals(expected, result, "Failed for bit position " + i);
            }
        }

        @Test
        @DisplayName("Power of 2 numbers")
        void testPowerOfTwoNumbers() {
            int[] powersOfTwo = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192,
                    16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608,
                    16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824};

            for (int power : powersOfTwo) {
                int result = solution.reverseBits(power);
                // For powers of 2, reversing should move the single bit to the opposite end
                int expected = 1 << (31 - Integer.numberOfTrailingZeros(power));
                assertEquals(expected, result, "Failed for power of 2: " + power);
            }
        }

        @Test
        @DisplayName("Palindrome bit patterns")
        void testPalindromeBitPatterns() {
            // Test numbers that are palindromes in 32-bit binary representation
            int[] palindromes = {0, -1}; // Only 0 and -1 are palindromes in 32-bit representation

            for (int palindrome : palindromes) {
                int result = solution.reverseBits(palindrome);
                assertEquals(palindrome, result, "Failed for palindrome: " + palindrome);
            }
        }

        @Test
        @DisplayName("Negative numbers")
        void testNegativeNumbers() {
            int[] negativeNumbers = {-1, -2, -3, -2147483648, -1073741824, -536870912};

            for (int n : negativeNumbers) {
                int result = solution.reverseBits(n);
                // Verify that reversing twice gives original (for unsigned interpretation)
                int doubleReversed = solution.reverseBits(result);
                assertEquals(n, doubleReversed, "Double reverse failed for: " + n);
            }
        }
    }

    @Nested
    @DisplayName("Utility Method Tests")
    class UtilityMethodTests {

        @Test
        @DisplayName("Test binary string conversion")
        void testBinaryStringConversion() {
            int n = 43261596;
            String expected = "00000010100101000001111010011100";
            String result = solution.toBinaryString(n);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Test set bits counting")
        void testSetBitsCounting() {
            assertEquals(0, solution.countSetBits(0));
            assertEquals(1, solution.countSetBits(1));
            assertEquals(1, solution.countSetBits(2));
            assertEquals(2, solution.countSetBits(3));
            assertEquals(16, solution.countSetBits(1431655765)); // alternating pattern
            assertEquals(32, solution.countSetBits(-1)); // all bits set
        }

        @Test
        @DisplayName("Test power of two detection")
        void testPowerOfTwoDetection() {
            assertTrue(solution.isPowerOfTwo(1));
            assertTrue(solution.isPowerOfTwo(2));
            assertTrue(solution.isPowerOfTwo(4));
            assertTrue(solution.isPowerOfTwo(8));
            assertTrue(solution.isPowerOfTwo(16));
            assertTrue(solution.isPowerOfTwo(32));
            assertTrue(solution.isPowerOfTwo(64));
            assertTrue(solution.isPowerOfTwo(128));
            assertTrue(solution.isPowerOfTwo(256));
            assertTrue(solution.isPowerOfTwo(512));
            assertTrue(solution.isPowerOfTwo(1024));
            assertTrue(solution.isPowerOfTwo(2048));
            assertTrue(solution.isPowerOfTwo(4096));
            assertTrue(solution.isPowerOfTwo(8192));
            assertTrue(solution.isPowerOfTwo(16384));
            assertTrue(solution.isPowerOfTwo(32768));
            assertTrue(solution.isPowerOfTwo(65536));
            assertTrue(solution.isPowerOfTwo(131072));
            assertTrue(solution.isPowerOfTwo(262144));
            assertTrue(solution.isPowerOfTwo(524288));
            assertTrue(solution.isPowerOfTwo(1048576));
            assertTrue(solution.isPowerOfTwo(2097152));
            assertTrue(solution.isPowerOfTwo(4194304));
            assertTrue(solution.isPowerOfTwo(8388608));
            assertTrue(solution.isPowerOfTwo(16777216));
            assertTrue(solution.isPowerOfTwo(33554432));
            assertTrue(solution.isPowerOfTwo(67108864));
            assertTrue(solution.isPowerOfTwo(134217728));
            assertTrue(solution.isPowerOfTwo(268435456));
            assertTrue(solution.isPowerOfTwo(536870912));
            assertTrue(solution.isPowerOfTwo(1073741824));

            assertFalse(solution.isPowerOfTwo(0));
            assertFalse(solution.isPowerOfTwo(3));
            assertFalse(solution.isPowerOfTwo(5));
            assertFalse(solution.isPowerOfTwo(6));
            assertFalse(solution.isPowerOfTwo(7));
            assertFalse(solution.isPowerOfTwo(9));
            assertFalse(solution.isPowerOfTwo(10));
            assertFalse(solution.isPowerOfTwo(15));
            assertFalse(solution.isPowerOfTwo(17));
            assertFalse(solution.isPowerOfTwo(21));
            assertFalse(solution.isPowerOfTwo(27));
            assertFalse(solution.isPowerOfTwo(31));
            assertFalse(solution.isPowerOfTwo(33));
            assertFalse(solution.isPowerOfTwo(45));
            assertFalse(solution.isPowerOfTwo(51));
            assertFalse(solution.isPowerOfTwo(63));
            assertFalse(solution.isPowerOfTwo(65));
            assertFalse(solution.isPowerOfTwo(73));
            assertFalse(solution.isPowerOfTwo(85));
            assertFalse(solution.isPowerOfTwo(93));
            assertFalse(solution.isPowerOfTwo(99));
            assertFalse(solution.isPowerOfTwo(107));
            assertFalse(solution.isPowerOfTwo(119));
            assertFalse(solution.isPowerOfTwo(127));
        }

        @Test
        @DisplayName("Test rightmost set bit position")
        void testRightmostSetBitPosition() {
            assertEquals(-1, solution.getRightmostSetBitPosition(0));
            assertEquals(0, solution.getRightmostSetBitPosition(1));
            assertEquals(1, solution.getRightmostSetBitPosition(2));
            assertEquals(0, solution.getRightmostSetBitPosition(3));
            assertEquals(2, solution.getRightmostSetBitPosition(4));
            assertEquals(0, solution.getRightmostSetBitPosition(5));
            assertEquals(1, solution.getRightmostSetBitPosition(6));
            assertEquals(0, solution.getRightmostSetBitPosition(7));
            assertEquals(3, solution.getRightmostSetBitPosition(8));
            assertEquals(0, solution.getRightmostSetBitPosition(9));
            assertEquals(1, solution.getRightmostSetBitPosition(10));
            assertEquals(0, solution.getRightmostSetBitPosition(11));
            assertEquals(2, solution.getRightmostSetBitPosition(12));
            assertEquals(0, solution.getRightmostSetBitPosition(13));
            assertEquals(1, solution.getRightmostSetBitPosition(14));
            assertEquals(0, solution.getRightmostSetBitPosition(15));
            assertEquals(4, solution.getRightmostSetBitPosition(16));
            assertEquals(0, solution.getRightmostSetBitPosition(17));
            assertEquals(1, solution.getRightmostSetBitPosition(18));
            assertEquals(0, solution.getRightmostSetBitPosition(19));
            assertEquals(2, solution.getRightmostSetBitPosition(20));
            assertEquals(0, solution.getRightmostSetBitPosition(21));
            assertEquals(1, solution.getRightmostSetBitPosition(22));
            assertEquals(0, solution.getRightmostSetBitPosition(23));
            assertEquals(3, solution.getRightmostSetBitPosition(24));
            assertEquals(0, solution.getRightmostSetBitPosition(25));
            assertEquals(1, solution.getRightmostSetBitPosition(26));
            assertEquals(0, solution.getRightmostSetBitPosition(27));
            assertEquals(2, solution.getRightmostSetBitPosition(28));
            assertEquals(0, solution.getRightmostSetBitPosition(29));
            assertEquals(1, solution.getRightmostSetBitPosition(30));
            assertEquals(0, solution.getRightmostSetBitPosition(31));
            assertEquals(31, solution.getRightmostSetBitPosition(-2147483648));
        }

        @Test
        @DisplayName("Test toggle all bits")
        void testToggleAllBits() {
            assertEquals(-1, solution.toggleAllBits(0));
            assertEquals(-2, solution.toggleAllBits(1));
            assertEquals(-3, solution.toggleAllBits(2));
            assertEquals(-4, solution.toggleAllBits(3));
            assertEquals(-5, solution.toggleAllBits(4));
            assertEquals(-6, solution.toggleAllBits(5));
            assertEquals(-7, solution.toggleAllBits(6));
            assertEquals(-8, solution.toggleAllBits(7));
            assertEquals(-9, solution.toggleAllBits(8));
            assertEquals(-10, solution.toggleAllBits(9));
            assertEquals(-11, solution.toggleAllBits(10));
            assertEquals(-12, solution.toggleAllBits(11));
            assertEquals(-13, solution.toggleAllBits(12));
            assertEquals(-14, solution.toggleAllBits(13));
            assertEquals(-15, solution.toggleAllBits(14));
            assertEquals(-16, solution.toggleAllBits(15));
            assertEquals(-17, solution.toggleAllBits(16));
            assertEquals(-18, solution.toggleAllBits(17));
            assertEquals(-19, solution.toggleAllBits(18));
            assertEquals(-20, solution.toggleAllBits(19));
            assertEquals(-21, solution.toggleAllBits(20));
            assertEquals(-22, solution.toggleAllBits(21));
            assertEquals(-23, solution.toggleAllBits(22));
            assertEquals(-24, solution.toggleAllBits(23));
            assertEquals(-25, solution.toggleAllBits(24));
            assertEquals(-26, solution.toggleAllBits(25));
            assertEquals(-27, solution.toggleAllBits(26));
            assertEquals(-28, solution.toggleAllBits(27));
            assertEquals(-29, solution.toggleAllBits(28));
            assertEquals(-30, solution.toggleAllBits(29));
            assertEquals(-31, solution.toggleAllBits(30));
            assertEquals(-32, solution.toggleAllBits(31));
            assertEquals(0, solution.toggleAllBits(-1));
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Performance comparison for various inputs")
        void testPerformanceComparison() {
            int[] testCases = {43261596, -3, 0, 1, 2147483647, 1431655765, -1, -1431655766};

            for (int n : testCases) {
                long startTime, endTime;

                // Test bit-by-bit approach
                startTime = System.nanoTime();
                int result1 = solution.reverseBits(n);
                endTime = System.nanoTime();
                long bitByBitTime = endTime - startTime;

                // Test optimal approach
                startTime = System.nanoTime();
                int result2 = solution.reverseBitsOptimal(n);
                endTime = System.nanoTime();
                long optimalTime = endTime - startTime;

                // Test lookup table approach
                startTime = System.nanoTime();
                int result3 = solution.reverseBitsLookupTable(n);
                endTime = System.nanoTime();
                long lookupTime = endTime - startTime;

                // Test divide and conquer approach
                startTime = System.nanoTime();
                int result4 = solution.reverseBitsDivideConquer(n);
                endTime = System.nanoTime();
                long divideConquerTime = endTime - startTime;

                // Test string-based approach
                startTime = System.nanoTime();
                int result5 = solution.reverseBitsString(n);
                endTime = System.nanoTime();
                long stringTime = endTime - startTime;

                // Test precomputed masks approach
                startTime = System.nanoTime();
                int result6 = solution.reverseBitsPrecomputedMasks(n);
                endTime = System.nanoTime();
                long precomputedTime = endTime - startTime;

                // Test two-pointer approach
                startTime = System.nanoTime();
                int result7 = solution.reverseBitsTwoPointer(n);
                endTime = System.nanoTime();
                long twoPointerTime = endTime - startTime;

                // All should produce same result
                assertEquals(result1, result2);
                assertEquals(result2, result3);
                assertEquals(result3, result4);
                assertEquals(result4, result5);
                assertEquals(result5, result6);
                assertEquals(result6, result7);

                System.out.printf(
                        "Input: %d, Bit-by-bit: %dns, Optimal: %dns, Lookup: %dns, Divide&Conquer: %dns, String: %dns, Precomputed: %dns, Two-pointer: %dns%n",
                        n, bitByBitTime, optimalTime, lookupTime, divideConquerTime, stringTime,
                        precomputedTime, twoPointerTime);
            }
        }
    }

    @Nested
    @DisplayName("Parameterized Tests")
    class ParameterizedTests {

        @ParameterizedTest
        @CsvSource({"43261596, 964176192", "-3, -1073741825", "0, 0", "1, -2147483648",
                "2147483647, -2"})
        @DisplayName("Parameterized test for various inputs")
        void testParameterized(int input, int expected) {
            int result = solution.reverseBits(input);
            assertEquals(expected, result);
        }
    }
}
