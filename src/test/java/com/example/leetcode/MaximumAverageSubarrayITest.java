package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Comprehensive test suite for MaximumAverageSubarrayI problem
 */
public class MaximumAverageSubarrayITest {

    private MaximumAverageSubarrayI solution;
    private static final double DELTA = 1e-5; // For double comparison

    @BeforeEach
    void setUp() {
        solution = new MaximumAverageSubarrayI();
    }

    @Nested
    @DisplayName("Sliding Window Approach Tests")
    class SlidingWindowApproachTests {

        @Test
        @DisplayName("Test LeetCode Example 1: [1,12,-5,-6,50,3], k=4")
        void testLeetCodeExample1() {
            int[] nums = {1, 12, -5, -6, 50, 3};
            int k = 4;
            double result = solution.findMaxAverageSlidingWindow(nums, k);
            assertEquals(12.75000, result, DELTA);
        }

        @Test
        @DisplayName("Test LeetCode Example 2: [5], k=1")
        void testLeetCodeExample2() {
            int[] nums = {5};
            int k = 1;
            double result = solution.findMaxAverageSlidingWindow(nums, k);
            assertEquals(5.00000, result, DELTA);
        }

        @Test
        @DisplayName("Test with all positive numbers")
        void testAllPositiveNumbers() {
            int[] nums = {1, 2, 3, 4, 5};
            int k = 3;
            double result = solution.findMaxAverageSlidingWindow(nums, k);
            assertEquals(4.0, result, DELTA); // [3,4,5]
        }

        @Test
        @DisplayName("Test with all negative numbers")
        void testAllNegativeNumbers() {
            int[] nums = {-5, -4, -3, -2, -1};
            int k = 2;
            double result = solution.findMaxAverageSlidingWindow(nums, k);
            assertEquals(-1.5, result, DELTA); // [-2,-1]
        }

        @Test
        @DisplayName("Test with mixed positive and negative")
        void testMixedNumbers() {
            int[] nums = {-1, 0, 1, -2, 3};
            int k = 3;
            double result = solution.findMaxAverageSlidingWindow(nums, k);
            assertEquals(2.0 / 3.0, result, DELTA); // [0,1,-2] or [1,-2,3]
        }

        @Test
        @DisplayName("Test with k equals array length")
        void testKEqualsArrayLength() {
            int[] nums = {1, 2, 3, 4, 5};
            int k = 5;
            double result = solution.findMaxAverageSlidingWindow(nums, k);
            assertEquals(3.0, result, DELTA); // Average of entire array
        }

        @Test
        @DisplayName("Test with large numbers")
        void testLargeNumbers() {
            int[] nums = {10000, -10000, 10000, -10000, 10000};
            int k = 3;
            double result = solution.findMaxAverageSlidingWindow(nums, k);
            assertEquals(10000.0 / 3.0, result, DELTA);
        }

        @Test
        @DisplayName("Test with zeros")
        void testWithZeros() {
            int[] nums = {0, 0, 0, 0, 0};
            int k = 3;
            double result = solution.findMaxAverageSlidingWindow(nums, k);
            assertEquals(0.0, result, DELTA);
        }
    }

    @Nested
    @DisplayName("Brute Force Approach Tests")
    class BruteForceApproachTests {

        @Test
        @DisplayName("Test brute force with LeetCode Example 1")
        void testBruteForceLeetCodeExample1() {
            int[] nums = {1, 12, -5, -6, 50, 3};
            int k = 4;
            double result = solution.findMaxAverageBruteForce(nums, k);
            assertEquals(12.75000, result, DELTA);
        }

        @Test
        @DisplayName("Test brute force with small array")
        void testBruteForceSmallArray() {
            int[] nums = {1, 2, 3};
            int k = 2;
            double result = solution.findMaxAverageBruteForce(nums, k);
            assertEquals(2.5, result, DELTA); // [2,3]
        }

        @Test
        @DisplayName("Test brute force with single element")
        void testBruteForceSingleElement() {
            int[] nums = {42};
            int k = 1;
            double result = solution.findMaxAverageBruteForce(nums, k);
            assertEquals(42.0, result, DELTA);
        }
    }

    @Nested
    @DisplayName("Prefix Sum Approach Tests")
    class PrefixSumApproachTests {

        @Test
        @DisplayName("Test prefix sum with LeetCode Example 1")
        void testPrefixSumLeetCodeExample1() {
            int[] nums = {1, 12, -5, -6, 50, 3};
            int k = 4;
            double result = solution.findMaxAveragePrefixSum(nums, k);
            assertEquals(12.75000, result, DELTA);
        }

        @Test
        @DisplayName("Test prefix sum with decreasing sequence")
        void testPrefixSumDecreasingSequence() {
            int[] nums = {5, 4, 3, 2, 1};
            int k = 2;
            double result = solution.findMaxAveragePrefixSum(nums, k);
            assertEquals(4.5, result, DELTA); // [5,4]
        }

        @Test
        @DisplayName("Test prefix sum with alternating pattern")
        void testPrefixSumAlternatingPattern() {
            int[] nums = {1, -1, 1, -1, 1};
            int k = 3;
            double result = solution.findMaxAveragePrefixSum(nums, k);
            assertEquals(1.0 / 3.0, result, DELTA); // [1,-1,1]
        }
    }

    @Nested
    @DisplayName("Optimized Sliding Window Tests")
    class OptimizedSlidingWindowTests {

        @Test
        @DisplayName("Test optimized sliding window with LeetCode Example 1")
        void testOptimizedLeetCodeExample1() {
            int[] nums = {1, 12, -5, -6, 50, 3};
            int k = 4;
            double result = solution.findMaxAverageOptimized(nums, k);
            assertEquals(12.75000, result, DELTA);
        }

        @Test
        @DisplayName("Test optimized with single element array")
        void testOptimizedSingleElement() {
            int[] nums = {100};
            int k = 1;
            double result = solution.findMaxAverageOptimized(nums, k);
            assertEquals(100.0, result, DELTA);
        }

        @Test
        @DisplayName("Test optimized with edge case")
        void testOptimizedEdgeCase() {
            int[] nums = {0, 4, 0, 3, 2};
            int k = 1;
            double result = solution.findMaxAverageOptimized(nums, k);
            assertEquals(4.0, result, DELTA); // Maximum single element
        }
    }

    @Nested
    @DisplayName("Double Precision Approach Tests")
    class DoublePrecisionApproachTests {

        @Test
        @DisplayName("Test double precision with LeetCode Example 1")
        void testDoublePrecisionLeetCodeExample1() {
            int[] nums = {1, 12, -5, -6, 50, 3};
            int k = 4;
            double result = solution.findMaxAverageDoublePrecision(nums, k);
            assertEquals(12.75000, result, DELTA);
        }

        @Test
        @DisplayName("Test double precision with fractional result")
        void testDoublePrecisionFractionalResult() {
            int[] nums = {1, 2, 3, 4};
            int k = 3;
            double result = solution.findMaxAverageDoublePrecision(nums, k);
            assertEquals(3.0, result, DELTA); // [2,3,4]
        }

        @Test
        @DisplayName("Test double precision with negative fractional result")
        void testDoublePrecisionNegativeFractional() {
            int[] nums = {-1, -2, -3, -4};
            int k = 2;
            double result = solution.findMaxAverageDoublePrecision(nums, k);
            assertEquals(-1.5, result, DELTA); // [-1,-2]
        }
    }

    @Nested
    @DisplayName("Recursive Approach Tests")
    class RecursiveApproachTests {

        @Test
        @DisplayName("Test recursive with LeetCode Example 1")
        void testRecursiveLeetCodeExample1() {
            int[] nums = {1, 12, -5, -6, 50, 3};
            int k = 4;
            double result = solution.findMaxAverageRecursive(nums, k);
            assertEquals(12.75000, result, DELTA);
        }

        @Test
        @DisplayName("Test recursive with single element")
        void testRecursiveSingleElement() {
            int[] nums = {99};
            int k = 1;
            double result = solution.findMaxAverageRecursive(nums, k);
            assertEquals(99.0, result, DELTA);
        }

        @Test
        @DisplayName("Test recursive with two elements")
        void testRecursiveTwoElements() {
            int[] nums = {10, 20};
            int k = 1;
            double result = solution.findMaxAverageRecursive(nums, k);
            assertEquals(20.0, result, DELTA); // Maximum single element
        }
    }

    @Nested
    @DisplayName("Cross-Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @Test
        @DisplayName("All approaches should produce identical results")
        void testAllApproachesProduceSameResult() {
            int[] testData = {1, 12, -5, -6, 50, 3};
            int k = 4;

            double slidingWindow = solution.findMaxAverageSlidingWindow(testData, k);
            double bruteForce = solution.findMaxAverageBruteForce(testData, k);
            double prefixSum = solution.findMaxAveragePrefixSum(testData, k);
            double optimized = solution.findMaxAverageOptimized(testData, k);
            double doublePrecision = solution.findMaxAverageDoublePrecision(testData, k);
            double recursive = solution.findMaxAverageRecursive(testData, k);

            assertEquals(slidingWindow, bruteForce, DELTA);
            assertEquals(bruteForce, prefixSum, DELTA);
            assertEquals(prefixSum, optimized, DELTA);
            assertEquals(optimized, doublePrecision, DELTA);
            assertEquals(doublePrecision, recursive, DELTA);
        }

        @Test
        @DisplayName("All approaches should handle edge cases consistently")
        void testAllApproachesHandleEdgeCases() {
            int[] edgeCase1 = {5};
            int[] edgeCase2 = {1, 2, 3};
            int k1 = 1;
            int k2 = 2;

            for (int[] testCase : new int[][] {edgeCase1, edgeCase2}) {
                int k = (testCase.length == 1) ? k1 : k2;

                double slidingWindow = solution.findMaxAverageSlidingWindow(testCase, k);
                double bruteForce = solution.findMaxAverageBruteForce(testCase, k);
                double prefixSum = solution.findMaxAveragePrefixSum(testCase, k);
                double optimized = solution.findMaxAverageOptimized(testCase, k);
                double doublePrecision = solution.findMaxAverageDoublePrecision(testCase, k);
                double recursive = solution.findMaxAverageRecursive(testCase, k);

                assertEquals(slidingWindow, bruteForce, DELTA);
                assertEquals(bruteForce, prefixSum, DELTA);
                assertEquals(prefixSum, optimized, DELTA);
                assertEquals(optimized, doublePrecision, DELTA);
                assertEquals(doublePrecision, recursive, DELTA);
            }
        }
    }

    @Nested
    @DisplayName("Edge Case Tests")
    class EdgeCaseTests {

        @Test
        @DisplayName("Test with maximum constraint values")
        void testWithMaxConstraintValues() {
            int[] nums = new int[100000];
            for (int i = 0; i < 100000; i++) {
                nums[i] = 10000; // Maximum allowed value
            }
            int k = 50000;
            double result = solution.findMaxAverageSlidingWindow(nums, k);
            assertEquals(10000.0, result, DELTA);
        }

        @Test
        @DisplayName("Test with minimum constraint values")
        void testWithMinConstraintValues() {
            int[] nums = new int[100000];
            for (int i = 0; i < 100000; i++) {
                nums[i] = -10000; // Minimum allowed value
            }
            int k = 50000;
            double result = solution.findMaxAverageSlidingWindow(nums, k);
            assertEquals(-10000.0, result, DELTA);
        }

        @Test
        @DisplayName("Test with alternating max and min values")
        void testAlternatingMaxMinValues() {
            int[] nums = {10000, -10000, 10000, -10000};
            int k = 2;
            double result = solution.findMaxAverageSlidingWindow(nums, k);
            assertEquals(0.0, result, DELTA); // All pairs average to 0
        }

        @Test
        @DisplayName("Test with k equals 1")
        void testKEqualsOne() {
            int[] nums = {1, 5, 3, 9, 2};
            int k = 1;
            double result = solution.findMaxAverageSlidingWindow(nums, k);
            assertEquals(9.0, result, DELTA); // Maximum single element
        }

        @Test
        @DisplayName("Test with all same values")
        void testAllSameValues() {
            int[] nums = {7, 7, 7, 7, 7};
            int k = 3;
            double result = solution.findMaxAverageSlidingWindow(nums, k);
            assertEquals(7.0, result, DELTA); // All subarrays have same average
        }
    }

    @Nested
    @DisplayName("Utility Method Tests")
    class UtilityMethodTests {

        @Test
        @DisplayName("Test calculateSubarraySum utility method")
        void testCalculateSubarraySum() {
            int[] nums = {1, 2, 3, 4, 5};
            assertEquals(6, MaximumAverageSubarrayI.calculateSubarraySum(nums, 0, 2)); // [1,2,3]
            assertEquals(14, MaximumAverageSubarrayI.calculateSubarraySum(nums, 1, 4)); // [2,3,4,5]
        }

        @Test
        @DisplayName("Test calculateSubarrayAverage utility method")
        void testCalculateSubarrayAverage() {
            int[] nums = {1, 2, 3, 4, 5};
            assertEquals(2.0, MaximumAverageSubarrayI.calculateSubarrayAverage(nums, 0, 2), DELTA);
            assertEquals(3.5, MaximumAverageSubarrayI.calculateSubarrayAverage(nums, 1, 4), DELTA);
        }

        @Test
        @DisplayName("Test findAllSubarrays utility method")
        void testFindAllSubarrays() {
            int[] nums = {1, 2, 3};
            int[][] subarrays = MaximumAverageSubarrayI.findAllSubarrays(nums, 2);
            assertEquals(2, subarrays.length); // Two subarrays of length 2
            assertEquals(2, subarrays[0].length);
            assertEquals(2, subarrays[1].length);
        }

        @Test
        @DisplayName("Test calculatePrefixSum utility method")
        void testCalculatePrefixSum() {
            int[] nums = {1, 2, 3, 4, 5};
            int[] prefixSum = MaximumAverageSubarrayI.calculatePrefixSum(nums);
            assertEquals(6, prefixSum.length); // n + 1
            assertEquals(0, prefixSum[0]);
            assertEquals(15, prefixSum[5]); // Sum of all elements
        }

        @Test
        @DisplayName("Test getSubarraySum utility method")
        void testGetSubarraySum() {
            int[] nums = {1, 2, 3, 4, 5};
            int[] prefixSum = MaximumAverageSubarrayI.calculatePrefixSum(nums);
            assertEquals(6, MaximumAverageSubarrayI.getSubarraySum(prefixSum, 0, 2)); // [1,2,3]
            assertEquals(14, MaximumAverageSubarrayI.getSubarraySum(prefixSum, 1, 4)); // [2,3,4,5]
        }

        @Test
        @DisplayName("Test isValidK utility method")
        void testIsValidK() {
            int[] nums = {1, 2, 3, 4, 5};
            assertTrue(MaximumAverageSubarrayI.isValidK(nums, 1));
            assertTrue(MaximumAverageSubarrayI.isValidK(nums, 5));
            assertFalse(MaximumAverageSubarrayI.isValidK(nums, 0));
            assertFalse(MaximumAverageSubarrayI.isValidK(nums, 6));
        }

        @Test
        @DisplayName("Test findMaxElement utility method")
        void testFindMaxElement() {
            int[] nums = {1, 5, 3, 9, 2};
            assertEquals(9, MaximumAverageSubarrayI.findMaxElement(nums));

            assertThrows(IllegalArgumentException.class, () -> {
                MaximumAverageSubarrayI.findMaxElement(null);
            });

            assertThrows(IllegalArgumentException.class, () -> {
                MaximumAverageSubarrayI.findMaxElement(new int[] {});
            });
        }

        @Test
        @DisplayName("Test findMinElement utility method")
        void testFindMinElement() {
            int[] nums = {5, 1, 9, 3, 2};
            assertEquals(1, MaximumAverageSubarrayI.findMinElement(nums));

            assertThrows(IllegalArgumentException.class, () -> {
                MaximumAverageSubarrayI.findMinElement(null);
            });

            assertThrows(IllegalArgumentException.class, () -> {
                MaximumAverageSubarrayI.findMinElement(new int[] {});
            });
        }

        @Test
        @DisplayName("Test calculateTotalSum utility method")
        void testCalculateTotalSum() {
            int[] nums = {1, 2, 3, 4, 5};
            assertEquals(15, MaximumAverageSubarrayI.calculateTotalSum(nums));
        }

        @Test
        @DisplayName("Test containsOnlyPositive utility method")
        void testContainsOnlyPositive() {
            assertTrue(MaximumAverageSubarrayI.containsOnlyPositive(new int[] {1, 2, 3, 4}));
            assertFalse(MaximumAverageSubarrayI.containsOnlyPositive(new int[] {1, -2, 3, 4}));
            assertFalse(MaximumAverageSubarrayI.containsOnlyPositive(new int[] {0, 1, 2}));
        }

        @Test
        @DisplayName("Test containsOnlyNegative utility method")
        void testContainsOnlyNegative() {
            assertTrue(MaximumAverageSubarrayI.containsOnlyNegative(new int[] {-1, -2, -3, -4}));
            assertFalse(MaximumAverageSubarrayI.containsOnlyNegative(new int[] {-1, 2, -3, -4}));
            assertFalse(MaximumAverageSubarrayI.containsOnlyNegative(new int[] {0, -1, -2}));
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Test performance with large dataset")
        void testPerformanceLargeDataset() {
            int[] nums = new int[100000];
            for (int i = 0; i < 100000; i++) {
                nums[i] = (i % 1000) - 500; // Values from -500 to 499
            }
            int k = 50000;

            long startTime = System.currentTimeMillis();
            double result = solution.findMaxAverageSlidingWindow(nums, k);
            long endTime = System.currentTimeMillis();

            assertTrue(endTime - startTime < 1000); // Should complete within 1 second
            assertTrue(result > Double.NEGATIVE_INFINITY);
        }

        @Test
        @DisplayName("Test performance comparison between approaches")
        void testPerformanceComparison() {
            int[] nums = new int[10000];
            for (int i = 0; i < 10000; i++) {
                nums[i] = (i % 100) - 50; // Values from -50 to 49
            }
            int k = 5000;

            // Test sliding window approach
            long startTime1 = System.currentTimeMillis();
            double result1 = solution.findMaxAverageSlidingWindow(nums, k);
            long endTime1 = System.currentTimeMillis();

            // Test prefix sum approach
            long startTime2 = System.currentTimeMillis();
            double result2 = solution.findMaxAveragePrefixSum(nums, k);
            long endTime2 = System.currentTimeMillis();

            assertEquals(result1, result2, DELTA);
            assertTrue(endTime1 - startTime1 < 100); // Sliding window should be fast
            assertTrue(endTime2 - startTime2 < 100); // Prefix sum should also be fast
        }
    }

    @Nested
    @DisplayName("LeetCode Examples Tests")
    class LeetCodeExamplesTests {

        @Test
        @DisplayName("LeetCode Example 1: [1,12,-5,-6,50,3], k=4 -> 12.75")
        void testLeetCodeExample1() {
            int[] nums = {1, 12, -5, -6, 50, 3};
            int k = 4;
            double result = solution.findMaxAverageSlidingWindow(nums, k);
            assertEquals(12.75000, result, DELTA);
        }

        @Test
        @DisplayName("LeetCode Example 2: [5], k=1 -> 5.0")
        void testLeetCodeExample2() {
            int[] nums = {5};
            int k = 1;
            double result = solution.findMaxAverageSlidingWindow(nums, k);
            assertEquals(5.00000, result, DELTA);
        }
    }
}
