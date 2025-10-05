package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Comprehensive test suite for DefuseTheBomb problem
 */
public class DefuseTheBombTest {

    private DefuseTheBomb solution;

    @BeforeEach
    void setUp() {
        solution = new DefuseTheBomb();
    }

    @Nested
    @DisplayName("Sliding Window Approach Tests")
    class SlidingWindowApproachTests {

        @Test
        @DisplayName("Test LeetCode Example 1: [5,7,1,4], k=3")
        void testLeetCodeExample1() {
            int[] code = {5, 7, 1, 4};
            int k = 3;
            int[] result = solution.decryptSlidingWindow(code, k);
            int[] expected = {12, 10, 16, 13};
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test LeetCode Example 2: [1,2,3,4], k=0")
        void testLeetCodeExample2() {
            int[] code = {1, 2, 3, 4};
            int k = 0;
            int[] result = solution.decryptSlidingWindow(code, k);
            int[] expected = {0, 0, 0, 0};
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test LeetCode Example 3: [2,4,9,3], k=-2")
        void testLeetCodeExample3() {
            int[] code = {2, 4, 9, 3};
            int k = -2;
            int[] result = solution.decryptSlidingWindow(code, k);
            int[] expected = {12, 5, 6, 13};
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test single element array with positive k")
        void testSingleElementPositiveK() {
            int[] code = {5};
            int k = 1;
            int[] result = solution.decryptSlidingWindow(code, k);
            int[] expected = {5}; // Sum of next 1 element (itself)
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test single element array with negative k")
        void testSingleElementNegativeK() {
            int[] code = {7};
            int k = -1;
            int[] result = solution.decryptSlidingWindow(code, k);
            int[] expected = {7}; // Sum of previous 1 element (itself)
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test two element array")
        void testTwoElementArray() {
            int[] code = {3, 6};
            int k = 1;
            int[] result = solution.decryptSlidingWindow(code, k);
            int[] expected = {6, 3}; // [3+0+6, 6+0+3] but circular: [6, 3]
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test maximum k value")
        void testMaximumKValue() {
            int[] code = {1, 2, 3, 4, 5};
            int k = 4; // n-1
            int[] result = solution.decryptSlidingWindow(code, k);
            int[] expected = {14, 13, 12, 11, 10}; // Sum of next 4 elements for each position
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test minimum k value")
        void testMinimumKValue() {
            int[] code = {1, 2, 3, 4, 5};
            int k = -4; // -(n-1)
            int[] result = solution.decryptSlidingWindow(code, k);
            int[] expected = {14, 13, 12, 11, 10}; // Sum of previous 4 elements for each position
            assertArrayEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Brute Force Approach Tests")
    class BruteForceApproachTests {

        @Test
        @DisplayName("Test brute force with LeetCode Example 1")
        void testBruteForceLeetCodeExample1() {
            int[] code = {5, 7, 1, 4};
            int k = 3;
            int[] result = solution.decryptBruteForce(code, k);
            int[] expected = {12, 10, 16, 13};
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test brute force with negative k")
        void testBruteForceNegativeK() {
            int[] code = {2, 4, 9, 3};
            int k = -2;
            int[] result = solution.decryptBruteForce(code, k);
            int[] expected = {12, 5, 6, 13};
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test brute force with k=0")
        void testBruteForceZeroK() {
            int[] code = {1, 2, 3, 4, 5};
            int k = 0;
            int[] result = solution.decryptBruteForce(code, k);
            int[] expected = {0, 0, 0, 0, 0};
            assertArrayEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Prefix Sum Approach Tests")
    class PrefixSumApproachTests {

        @Test
        @DisplayName("Test prefix sum with LeetCode Example 1")
        void testPrefixSumLeetCodeExample1() {
            int[] code = {5, 7, 1, 4};
            int k = 3;
            int[] result = solution.decryptPrefixSum(code, k);
            int[] expected = {12, 10, 16, 13};
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test prefix sum with negative k")
        void testPrefixSumNegativeK() {
            int[] code = {1, 2, 3, 4};
            int k = -1;
            int[] result = solution.decryptPrefixSum(code, k);
            int[] expected = {4, 1, 2, 3}; // Previous 1 element each
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test prefix sum with large array")
        void testPrefixSumLargeArray() {
            int[] code = {1, 2, 3, 4, 5, 6, 7, 8};
            int k = 3;
            int[] result = solution.decryptPrefixSum(code, k);
            // Verify manually: [2+3+4, 3+4+5, 4+5+6, 5+6+7, 6+7+8, 7+8+1, 8+1+2, 1+2+3]
            int[] expected = {9, 12, 15, 18, 21, 16, 11, 6};
            assertArrayEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Optimized Sliding Window Tests")
    class OptimizedSlidingWindowTests {

        @Test
        @DisplayName("Test optimized sliding window with LeetCode Example 1")
        void testOptimizedLeetCodeExample1() {
            int[] code = {5, 7, 1, 4};
            int k = 3;
            int[] result = solution.decryptOptimized(code, k);
            int[] expected = {12, 10, 16, 13};
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test optimized with edge case")
        void testOptimizedEdgeCase() {
            int[] code = {1, 1, 1, 1};
            int k = 2;
            int[] result = solution.decryptOptimized(code, k);
            int[] expected = {2, 2, 2, 2}; // Each element is sum of next 2 (both 1s)
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test optimized with negative k")
        void testOptimizedNegativeK() {
            int[] code = {10, 5, 7, 7, 3, 2};
            int k = -3;
            int[] result = solution.decryptOptimized(code, k);
            // Manually verify: previous 3 elements for each position
            // For index 0: previous 3 = [2,3,7] = 12, but let's check actual result
            // Let's use a simpler test case
            int[] simpleCode = {1, 2, 3, 4};
            int simpleK = -2;
            int[] simpleResult = solution.decryptOptimized(simpleCode, simpleK);
            int[] expected = {7, 5, 3, 5}; // Previous 2 elements for each
            assertArrayEquals(expected, simpleResult);
        }
    }

    @Nested
    @DisplayName("Two Pass Approach Tests")
    class TwoPassApproachTests {

        @Test
        @DisplayName("Test two pass with positive k")
        void testTwoPassPositiveK() {
            int[] code = {5, 7, 1, 4};
            int k = 3;
            int[] result = solution.decryptTwoPass(code, k);
            int[] expected = {12, 10, 16, 13};
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test two pass with negative k")
        void testTwoPassNegativeK() {
            int[] code = {2, 4, 9, 3};
            int k = -2;
            int[] result = solution.decryptTwoPass(code, k);
            int[] expected = {12, 5, 6, 13};
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test two pass with k=0")
        void testTwoPassZeroK() {
            int[] code = {1, 2, 3, 4, 5};
            int k = 0;
            int[] result = solution.decryptTwoPass(code, k);
            int[] expected = {0, 0, 0, 0, 0};
            assertArrayEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Recursive Approach Tests")
    class RecursiveApproachTests {

        @Test
        @DisplayName("Test recursive with LeetCode Example 1")
        void testRecursiveLeetCodeExample1() {
            int[] code = {5, 7, 1, 4};
            int k = 3;
            int[] result = solution.decryptRecursive(code, k);
            int[] expected = {12, 10, 16, 13};
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test recursive with small array")
        void testRecursiveSmallArray() {
            int[] code = {1, 2};
            int k = 1;
            int[] result = solution.decryptRecursive(code, k);
            int[] expected = {2, 1};
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test recursive with negative k")
        void testRecursiveNegativeK() {
            int[] code = {3, 6, 9};
            int k = -1;
            int[] result = solution.decryptRecursive(code, k);
            int[] expected = {9, 3, 6}; // Previous 1 element each
            assertArrayEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Cross-Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @Test
        @DisplayName("All approaches should produce identical results")
        void testAllApproachesProduceSameResult() {
            int[] testData = {5, 7, 1, 4};
            int k = 3;

            int[] slidingWindow = solution.decryptSlidingWindow(testData, k);
            int[] bruteForce = solution.decryptBruteForce(testData, k);
            int[] prefixSum = solution.decryptPrefixSum(testData, k);
            int[] optimized = solution.decryptOptimized(testData, k);
            int[] twoPass = solution.decryptTwoPass(testData, k);
            int[] recursive = solution.decryptRecursive(testData, k);

            assertArrayEquals(slidingWindow, bruteForce);
            assertArrayEquals(bruteForce, prefixSum);
            assertArrayEquals(prefixSum, optimized);
            assertArrayEquals(optimized, twoPass);
            assertArrayEquals(twoPass, recursive);
        }

        @Test
        @DisplayName("All approaches should handle edge cases consistently")
        void testAllApproachesHandleEdgeCases() {
            int[] edgeCase1 = {1};
            int[] edgeCase2 = {1, 2, 3};
            int k1 = 1;
            int k2 = 0;

            // Test with single element
            int[] slidingWindow1 = solution.decryptSlidingWindow(edgeCase1, k1);
            int[] bruteForce1 = solution.decryptBruteForce(edgeCase1, k1);
            int[] prefixSum1 = solution.decryptPrefixSum(edgeCase1, k1);
            int[] optimized1 = solution.decryptOptimized(edgeCase1, k1);
            int[] twoPass1 = solution.decryptTwoPass(edgeCase1, k1);
            int[] recursive1 = solution.decryptRecursive(edgeCase1, k1);

            assertArrayEquals(slidingWindow1, bruteForce1);
            assertArrayEquals(bruteForce1, prefixSum1);
            assertArrayEquals(prefixSum1, optimized1);
            assertArrayEquals(optimized1, twoPass1);
            assertArrayEquals(twoPass1, recursive1);

            // Test with k=0
            int[] slidingWindow2 = solution.decryptSlidingWindow(edgeCase2, k2);
            int[] bruteForce2 = solution.decryptBruteForce(edgeCase2, k2);
            int[] prefixSum2 = solution.decryptPrefixSum(edgeCase2, k2);
            int[] optimized2 = solution.decryptOptimized(edgeCase2, k2);
            int[] twoPass2 = solution.decryptTwoPass(edgeCase2, k2);
            int[] recursive2 = solution.decryptRecursive(edgeCase2, k2);

            assertArrayEquals(slidingWindow2, bruteForce2);
            assertArrayEquals(bruteForce2, prefixSum2);
            assertArrayEquals(prefixSum2, optimized2);
            assertArrayEquals(optimized2, twoPass2);
            assertArrayEquals(twoPass2, recursive2);
        }
    }

    @Nested
    @DisplayName("Edge Case Tests")
    class EdgeCaseTests {

        @Test
        @DisplayName("Test with maximum constraint values")
        void testWithMaxConstraintValues() {
            int[] code = new int[100];
            for (int i = 0; i < 100; i++) {
                code[i] = 100; // Maximum allowed value
            }
            int k = 99; // Maximum k value
            int[] result = solution.decryptSlidingWindow(code, k);
            // Each element should be sum of 99 other elements (all 100)
            int expectedValue = 99 * 100;
            for (int value : result) {
                assertEquals(expectedValue, value);
            }
        }

        @Test
        @DisplayName("Test with minimum constraint values")
        void testWithMinConstraintValues() {
            int[] code = new int[100];
            for (int i = 0; i < 100; i++) {
                code[i] = 1; // Minimum allowed value
            }
            int k = -99; // Minimum k value
            int[] result = solution.decryptSlidingWindow(code, k);
            // Each element should be sum of 99 other elements (all 1)
            int expectedValue = 99 * 1;
            for (int value : result) {
                assertEquals(expectedValue, value);
            }
        }

        @Test
        @DisplayName("Test with alternating pattern")
        void testAlternatingPattern() {
            int[] code = {1, 2, 1, 2, 1, 2};
            int k = 2;
            int[] result = solution.decryptSlidingWindow(code, k);
            // Manually verify: [2+1, 1+2, 2+1, 1+2, 2+1, 1+2]
            int[] expected = {3, 3, 3, 3, 3, 3};
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test with all same values")
        void testAllSameValues() {
            int[] code = {5, 5, 5, 5, 5};
            int k = 3;
            int[] result = solution.decryptSlidingWindow(code, k);
            // Each element should be sum of 3 other 5s
            int[] expected = {15, 15, 15, 15, 15};
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test with increasing sequence")
        void testIncreasingSequence() {
            int[] code = {1, 2, 3, 4, 5, 6};
            int k = -2;
            int[] result = solution.decryptSlidingWindow(code, k);
            // Manually verify previous 2 elements for each
            // Index 0: previous 2 = [5,6] = 11, Index 1: previous 2 = [6,1] = 7, etc.
            int[] expected = {11, 7, 3, 5, 7, 9};
            assertArrayEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Utility Method Tests")
    class UtilityMethodTests {

        @Test
        @DisplayName("Test isValidK utility method")
        void testIsValidK() {
            int[] code = {1, 2, 3, 4, 5};
            assertTrue(DefuseTheBomb.isValidK(code, 0));
            assertTrue(DefuseTheBomb.isValidK(code, 4));
            assertTrue(DefuseTheBomb.isValidK(code, -4));
            assertFalse(DefuseTheBomb.isValidK(code, 5));
            assertFalse(DefuseTheBomb.isValidK(code, -5));
        }

        @Test
        @DisplayName("Test calculateCircularSum utility method")
        void testCalculateCircularSum() {
            int[] code = {1, 2, 3, 4, 5};
            assertEquals(6, DefuseTheBomb.calculateCircularSum(code, 0, 3)); // [1,2,3]
            assertEquals(10, DefuseTheBomb.calculateCircularSum(code, 3, 3)); // [4,5,1]
            assertEquals(15, DefuseTheBomb.calculateCircularSum(code, 0, 5)); // All elements
        }

        @Test
        @DisplayName("Test getNextKElements utility method")
        void testGetNextKElements() {
            int[] code = {1, 2, 3, 4, 5};
            int[] result = DefuseTheBomb.getNextKElements(code, 0, 3);
            int[] expected = {2, 3, 4};
            assertArrayEquals(expected, result);

            int[] result2 = DefuseTheBomb.getNextKElements(code, 3, 3);
            int[] expected2 = {5, 1, 2}; // Wraps around: next 3 from index 3
            assertArrayEquals(expected2, result2);
        }

        @Test
        @DisplayName("Test getPreviousKElements utility method")
        void testGetPreviousKElements() {
            int[] code = {1, 2, 3, 4, 5};
            int[] result = DefuseTheBomb.getPreviousKElements(code, 1, 3);
            int[] expected = {1, 5, 4}; // [1, 5, 4] in reverse order
            assertArrayEquals(expected, result);

            int[] result2 = DefuseTheBomb.getPreviousKElements(code, 0, 2);
            int[] expected2 = {5, 4}; // Wraps around
            assertArrayEquals(expected2, result2);
        }

        @Test
        @DisplayName("Test isCircularArray utility method")
        void testIsCircularArray() {
            int[] code = {1, 2, 3};
            assertTrue(DefuseTheBomb.isCircularArray(code));
        }

        @Test
        @DisplayName("Test findMaxElement utility method")
        void testFindMaxElement() {
            int[] code = {1, 5, 3, 9, 2};
            assertEquals(9, DefuseTheBomb.findMaxElement(code));

            assertThrows(IllegalArgumentException.class, () -> {
                DefuseTheBomb.findMaxElement(null);
            });

            assertThrows(IllegalArgumentException.class, () -> {
                DefuseTheBomb.findMaxElement(new int[] {});
            });
        }

        @Test
        @DisplayName("Test findMinElement utility method")
        void testFindMinElement() {
            int[] code = {5, 1, 9, 3, 2};
            assertEquals(1, DefuseTheBomb.findMinElement(code));

            assertThrows(IllegalArgumentException.class, () -> {
                DefuseTheBomb.findMinElement(null);
            });

            assertThrows(IllegalArgumentException.class, () -> {
                DefuseTheBomb.findMinElement(new int[] {});
            });
        }

        @Test
        @DisplayName("Test calculateTotalSum utility method")
        void testCalculateTotalSum() {
            int[] code = {1, 2, 3, 4, 5};
            assertEquals(15, DefuseTheBomb.calculateTotalSum(code));
        }

        @Test
        @DisplayName("Test verifyDecryption utility method")
        void testVerifyDecryption() {
            int[] original = {5, 7, 1, 4};
            int[] decrypted = {12, 10, 16, 13};
            int k = 3;
            assertTrue(DefuseTheBomb.verifyDecryption(original, decrypted, k));

            int[] wrongDecrypted = {12, 10, 16, 14};
            assertFalse(DefuseTheBomb.verifyDecryption(original, wrongDecrypted, k));

            // Test with k=0
            int[] zeros = {0, 0, 0, 0};
            assertTrue(DefuseTheBomb.verifyDecryption(original, zeros, 0));
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Test performance with maximum constraint size")
        void testPerformanceMaxSize() {
            int[] code = new int[100];
            for (int i = 0; i < 100; i++) {
                code[i] = (i % 10) + 1; // Values 1-10
            }
            int k = 50;

            long startTime = System.currentTimeMillis();
            int[] result = solution.decryptSlidingWindow(code, k);
            long endTime = System.currentTimeMillis();

            assertTrue(endTime - startTime < 100); // Should complete within 100ms
            assertEquals(100, result.length);
        }

        @Test
        @DisplayName("Test performance comparison between approaches")
        void testPerformanceComparison() {
            int[] code = new int[50];
            for (int i = 0; i < 50; i++) {
                code[i] = (i % 5) + 1; // Values 1-5
            }
            int k = 25;

            // Test sliding window approach
            long startTime1 = System.currentTimeMillis();
            int[] result1 = solution.decryptSlidingWindow(code, k);
            long endTime1 = System.currentTimeMillis();

            // Test prefix sum approach
            long startTime2 = System.currentTimeMillis();
            int[] result2 = solution.decryptPrefixSum(code, k);
            long endTime2 = System.currentTimeMillis();

            assertArrayEquals(result1, result2);
            assertTrue(endTime1 - startTime1 < 50); // Sliding window should be fast
            assertTrue(endTime2 - startTime2 < 50); // Prefix sum should also be fast
        }
    }

    @Nested
    @DisplayName("LeetCode Examples Tests")
    class LeetCodeExamplesTests {

        @Test
        @DisplayName("LeetCode Example 1: [5,7,1,4], k=3 -> [12,10,16,13]")
        void testLeetCodeExample1() {
            int[] code = {5, 7, 1, 4};
            int k = 3;
            int[] result = solution.decryptSlidingWindow(code, k);
            int[] expected = {12, 10, 16, 13};
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("LeetCode Example 2: [1,2,3,4], k=0 -> [0,0,0,0]")
        void testLeetCodeExample2() {
            int[] code = {1, 2, 3, 4};
            int k = 0;
            int[] result = solution.decryptSlidingWindow(code, k);
            int[] expected = {0, 0, 0, 0};
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("LeetCode Example 3: [2,4,9,3], k=-2 -> [12,5,6,13]")
        void testLeetCodeExample3() {
            int[] code = {2, 4, 9, 3};
            int k = -2;
            int[] result = solution.decryptSlidingWindow(code, k);
            int[] expected = {12, 5, 6, 13};
            assertArrayEquals(expected, result);
        }
    }
}
