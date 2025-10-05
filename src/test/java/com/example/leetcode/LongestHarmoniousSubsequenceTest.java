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
 * Comprehensive test suite for LongestHarmoniousSubsequence problem
 */
public class LongestHarmoniousSubsequenceTest {

    private LongestHarmoniousSubsequence solution;

    @BeforeEach
    void setUp() {
        solution = new LongestHarmoniousSubsequence();
    }

    @Nested
    @DisplayName("HashMap Approach Tests")
    class HashMapApproachTests {

        @Test
        @DisplayName("Test LeetCode Example 1: [1,3,2,2,5,2,3,7]")
        void testLeetCodeExample1() {
            int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
            int result = solution.findLHSHashMap(nums);
            assertEquals(5, result); // [3,2,2,2,3]
        }

        @Test
        @DisplayName("Test LeetCode Example 2: [1,2,3,4]")
        void testLeetCodeExample2() {
            int[] nums = {1, 2, 3, 4};
            int result = solution.findLHSHashMap(nums);
            assertEquals(2, result); // [1,2] or [2,3] or [3,4]
        }

        @Test
        @DisplayName("Test LeetCode Example 3: [1,1,1,1]")
        void testLeetCodeExample3() {
            int[] nums = {1, 1, 1, 1};
            int result = solution.findLHSHashMap(nums);
            assertEquals(0, result); // No harmonious subsequence
        }

        @Test
        @DisplayName("Test single element array")
        void testSingleElement() {
            int[] nums = {5};
            int result = solution.findLHSHashMap(nums);
            assertEquals(0, result);
        }

        @Test
        @DisplayName("Test two different elements")
        void testTwoDifferentElements() {
            int[] nums = {1, 3};
            int result = solution.findLHSHashMap(nums);
            assertEquals(0, result); // Difference is 2, not 1
        }

        @Test
        @DisplayName("Test two consecutive elements")
        void testTwoConsecutiveElements() {
            int[] nums = {2, 3};
            int result = solution.findLHSHashMap(nums);
            assertEquals(2, result); // [2,3]
        }

        @Test
        @DisplayName("Test negative numbers")
        void testNegativeNumbers() {
            int[] nums = {-1, 0, 1, 2};
            int result = solution.findLHSHashMap(nums);
            assertEquals(2, result); // [-1,0] or [0,1] or [1,2]
        }

        @Test
        @DisplayName("Test all negative numbers")
        void testAllNegativeNumbers() {
            int[] nums = {-3, -2, -1, -4};
            int result = solution.findLHSHashMap(nums);
            assertEquals(2, result); // [-3,-2] or [-2,-1] or [-4,-3]
        }

        @Test
        @DisplayName("Test large numbers")
        void testLargeNumbers() {
            int[] nums = {1000000000, 1000000001, 999999999};
            int result = solution.findLHSHashMap(nums);
            assertEquals(2, result); // [999999999, 1000000000] or [1000000000, 1000000001]
        }
    }

    @Nested
    @DisplayName("Sorting Approach Tests")
    class SortingApproachTests {

        @Test
        @DisplayName("Test sorting approach with LeetCode Example 1")
        void testSortingLeetCodeExample1() {
            int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
            int result = solution.findLHSSorting(nums);
            assertEquals(5, result);
        }

        @Test
        @DisplayName("Test sorting approach with consecutive numbers")
        void testSortingConsecutiveNumbers() {
            int[] nums = {3, 1, 2, 4, 2, 3, 1};
            int result = solution.findLHSSorting(nums);
            assertEquals(4, result); // [1,1,2,2] or [2,2,3,3] or [3,3,4,4]
        }

        @Test
        @DisplayName("Test sorting approach with no harmonious subsequence")
        void testSortingNoHarmonious() {
            int[] nums = {1, 3, 5, 7, 9};
            int result = solution.findLHSSorting(nums);
            assertEquals(0, result);
        }

        @Test
        @DisplayName("Test sorting approach with duplicates")
        void testSortingDuplicates() {
            int[] nums = {2, 2, 2, 3, 3, 3, 4, 4};
            int result = solution.findLHSSorting(nums);
            assertEquals(6, result); // [2,2,2,3,3,3] or [3,3,3,4,4,4]
        }
    }

    @Nested
    @DisplayName("Two Pass Approach Tests")
    class TwoPassApproachTests {

        @Test
        @DisplayName("Test two pass approach with mixed positive and negative")
        void testTwoPassMixedNumbers() {
            int[] nums = {-2, -1, 0, 1, 2, 3};
            int result = solution.findLHSTwoPass(nums);
            assertEquals(2, result); // Multiple possible sequences of length 2
        }

        @Test
        @DisplayName("Test two pass approach with single harmonious pair")
        void testTwoPassSinglePair() {
            int[] nums = {1, 1, 1, 2, 2, 2, 3, 3, 3};
            int result = solution.findLHSTwoPass(nums);
            assertEquals(6, result); // [1,1,1,2,2,2] or [2,2,2,3,3,3]
        }

        @Test
        @DisplayName("Test two pass approach with edge case")
        void testTwoPassEdgeCase() {
            int[] nums = {1, 2, 2, 2, 3, 3, 3, 3};
            int result = solution.findLHSTwoPass(nums);
            assertEquals(7, result); // [1,2,2,2] or [2,2,2,3,3,3,3]
        }
    }

    @Nested
    @DisplayName("Single Pass Approach Tests")
    class SinglePassApproachTests {

        @Test
        @DisplayName("Test single pass approach with complex case")
        void testSinglePassComplexCase() {
            int[] nums = {1, 2, 1, 2, 1, 2, 3, 2, 3, 2, 3};
            int result = solution.findLHSSinglePass(nums);
            assertEquals(8, result); // [1,2,1,2,1,2,3,2] or [2,3,2,3,2,3] (length 8)
        }

        @Test
        @DisplayName("Test single pass approach with alternating pattern")
        void testSinglePassAlternating() {
            int[] nums = {1, 3, 1, 3, 1, 3, 5, 7};
            int result = solution.findLHSSinglePass(nums);
            assertEquals(0, result); // No consecutive pairs, so no harmonious subsequence
        }

        @Test
        @DisplayName("Test single pass approach with no solution")
        void testSinglePassNoSolution() {
            int[] nums = {5, 5, 5, 5, 5};
            int result = solution.findLHSSinglePass(nums);
            assertEquals(0, result);
        }
    }

    @Nested
    @DisplayName("Optimized Approach Tests")
    class OptimizedApproachTests {

        @Test
        @DisplayName("Test optimized approach with maximum constraint values")
        void testOptimizedMaxConstraints() {
            int[] nums = new int[20000];
            for (int i = 0; i < 10000; i++) {
                nums[i] = 1;
                nums[i + 10000] = 2;
            }
            int result = solution.findLHSOptimized(nums);
            assertEquals(20000, result);
        }

        @Test
        @DisplayName("Test optimized approach with sparse distribution")
        void testOptimizedSparseDistribution() {
            int[] nums = {1, 10, 2, 20, 3, 30, 4, 40};
            int result = solution.findLHSOptimized(nums);
            assertEquals(2, result); // [1,2] or [2,3] or [3,4]
        }

        @Test
        @DisplayName("Test optimized approach with large gaps")
        void testOptimizedLargeGaps() {
            int[] nums = {1, 100, 2, 200, 3, 300};
            int result = solution.findLHSOptimized(nums);
            assertEquals(2, result); // [1,2] or [2,3]
        }
    }

    @Nested
    @DisplayName("Array-based Approach Tests")
    class ArrayBasedApproachTests {

        @Test
        @DisplayName("Test array-based approach with small range")
        void testArrayBasedSmallRange() {
            int[] nums = {1, 2, 3, 2, 3, 4, 3, 4, 5};
            int result = solution.findLHSArrayBased(nums);
            assertEquals(5, result); // [2,3,2,3,4] or [3,4,3,4,5] (max length 5)
        }

        @Test
        @DisplayName("Test array-based approach with binary values")
        void testArrayBasedBinaryValues() {
            int[] nums = {0, 1, 0, 1, 0, 1, 0, 1};
            int result = solution.findLHSArrayBased(nums);
            assertEquals(8, result); // All elements form harmonious subsequence
        }

        @Test
        @DisplayName("Test array-based approach with three consecutive values")
        void testArrayBasedThreeConsecutive() {
            int[] nums = {1, 1, 2, 2, 3, 3, 4, 4};
            int result = solution.findLHSArrayBased(nums);
            assertEquals(4, result); // [1,1,2,2] or [2,2,3,3] or [3,3,4,4]
        }
    }

    @Nested
    @DisplayName("Cross-Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @Test
        @DisplayName("All approaches should produce identical results")
        void testAllApproachesProduceSameResult() {
            int[] testData = {1, 3, 2, 2, 5, 2, 3, 7};

            int hashMapResult = solution.findLHSHashMap(testData);
            int sortingResult = solution.findLHSSorting(testData);
            int twoPassResult = solution.findLHSTwoPass(testData);
            int singlePassResult = solution.findLHSSinglePass(testData);
            int optimizedResult = solution.findLHSOptimized(testData);
            int arrayBasedResult = solution.findLHSArrayBased(testData);

            assertEquals(hashMapResult, sortingResult);
            assertEquals(sortingResult, twoPassResult);
            assertEquals(twoPassResult, singlePassResult);
            assertEquals(singlePassResult, optimizedResult);
            assertEquals(optimizedResult, arrayBasedResult);
        }

        @Test
        @DisplayName("All approaches should handle edge cases consistently")
        void testAllApproachesHandleEdgeCases() {
            int[] edgeCase1 = {1};
            int[] edgeCase2 = {1, 3};
            int[] edgeCase3 = {1, 1, 1, 1};

            for (int[] testCase : new int[][] {edgeCase1, edgeCase2, edgeCase3}) {
                int hashMapResult = solution.findLHSHashMap(testCase);
                int sortingResult = solution.findLHSSorting(testCase);
                int twoPassResult = solution.findLHSTwoPass(testCase);
                int singlePassResult = solution.findLHSSinglePass(testCase);
                int optimizedResult = solution.findLHSOptimized(testCase);
                int arrayBasedResult = solution.findLHSArrayBased(testCase);

                assertEquals(hashMapResult, sortingResult);
                assertEquals(sortingResult, twoPassResult);
                assertEquals(twoPassResult, singlePassResult);
                assertEquals(singlePassResult, optimizedResult);
                assertEquals(optimizedResult, arrayBasedResult);
            }
        }
    }

    @Nested
    @DisplayName("Edge Case Tests")
    class EdgeCaseTests {

        @Test
        @DisplayName("Test with maximum constraint length")
        void testMaxConstraintLength() {
            int[] nums = new int[20000];
            for (int i = 0; i < 20000; i++) {
                nums[i] = (i % 2) + 1; // Alternating 1 and 2
            }
            int result = solution.findLHSHashMap(nums);
            assertEquals(20000, result);
        }

        @Test
        @DisplayName("Test with maximum constraint values")
        void testMaxConstraintValues() {
            int[] nums = {Integer.MAX_VALUE - 1, Integer.MAX_VALUE};
            int result = solution.findLHSHashMap(nums);
            assertEquals(2, result);
        }

        @Test
        @DisplayName("Test with minimum constraint values")
        void testMinConstraintValues() {
            int[] nums = {Integer.MIN_VALUE, Integer.MIN_VALUE + 1};
            int result = solution.findLHSHashMap(nums);
            assertEquals(2, result);
        }

        @Test
        @DisplayName("Test with alternating pattern")
        void testAlternatingPattern() {
            int[] nums = {1, 2, 1, 2, 1, 2, 1, 2};
            int result = solution.findLHSHashMap(nums);
            assertEquals(8, result);
        }

        @Test
        @DisplayName("Test with three consecutive numbers")
        void testThreeConsecutiveNumbers() {
            int[] nums = {1, 2, 3, 1, 2, 3, 1, 2, 3};
            int result = solution.findLHSHashMap(nums);
            assertEquals(6, result); // [1,2,1,2,3,3] or [2,3,2,3,1,2] (max length 6)
        }
    }

    @Nested
    @DisplayName("Utility Method Tests")
    class UtilityMethodTests {

        @Test
        @DisplayName("Test isHarmonious utility method")
        void testIsHarmonious() {
            assertTrue(LongestHarmoniousSubsequence.isHarmonious(new int[] {1, 2}));
            assertTrue(LongestHarmoniousSubsequence.isHarmonious(new int[] {1, 2, 2, 2, 1}));
            assertFalse(LongestHarmoniousSubsequence.isHarmonious(new int[] {1, 3}));
            assertFalse(LongestHarmoniousSubsequence.isHarmonious(new int[] {1, 1, 1}));
            assertFalse(LongestHarmoniousSubsequence.isHarmonious(new int[] {1}));
            assertFalse(LongestHarmoniousSubsequence.isHarmonious(null));
        }

        @Test
        @DisplayName("Test findMax utility method")
        void testFindMax() {
            assertEquals(5, LongestHarmoniousSubsequence.findMax(new int[] {1, 3, 5, 2, 4}));
            assertEquals(-1, LongestHarmoniousSubsequence.findMax(new int[] {-5, -3, -1, -2}));
            assertEquals(0, LongestHarmoniousSubsequence.findMax(new int[] {0}));

            assertThrows(IllegalArgumentException.class, () -> {
                LongestHarmoniousSubsequence.findMax(null);
            });

            assertThrows(IllegalArgumentException.class, () -> {
                LongestHarmoniousSubsequence.findMax(new int[] {});
            });
        }

        @Test
        @DisplayName("Test findMin utility method")
        void testFindMin() {
            assertEquals(1, LongestHarmoniousSubsequence.findMin(new int[] {1, 3, 5, 2, 4}));
            assertEquals(-5, LongestHarmoniousSubsequence.findMin(new int[] {-1, -3, -5, -2}));
            assertEquals(0, LongestHarmoniousSubsequence.findMin(new int[] {0}));

            assertThrows(IllegalArgumentException.class, () -> {
                LongestHarmoniousSubsequence.findMin(null);
            });

            assertThrows(IllegalArgumentException.class, () -> {
                LongestHarmoniousSubsequence.findMin(new int[] {});
            });
        }

        @Test
        @DisplayName("Test calculateRange utility method")
        void testCalculateRange() {
            assertEquals(4, LongestHarmoniousSubsequence.calculateRange(new int[] {1, 3, 5, 2, 4}));
            assertEquals(0, LongestHarmoniousSubsequence.calculateRange(new int[] {5, 5, 5}));
            assertEquals(0, LongestHarmoniousSubsequence.calculateRange(new int[] {0}));
            assertEquals(0, LongestHarmoniousSubsequence.calculateRange(null));
            assertEquals(0, LongestHarmoniousSubsequence.calculateRange(new int[] {}));
        }

        @Test
        @DisplayName("Test countDistinct utility method")
        void testCountDistinct() {
            assertEquals(5, LongestHarmoniousSubsequence.countDistinct(new int[] {1, 2, 3, 4, 5}));
            assertEquals(3, LongestHarmoniousSubsequence.countDistinct(new int[] {1, 1, 2, 2, 3}));
            assertEquals(1, LongestHarmoniousSubsequence.countDistinct(new int[] {5, 5, 5}));
            assertEquals(0, LongestHarmoniousSubsequence.countDistinct(null));
            assertEquals(0, LongestHarmoniousSubsequence.countDistinct(new int[] {}));
        }

        @Test
        @DisplayName("Test hasConsecutiveNumbers utility method")
        void testHasConsecutiveNumbers() {
            assertTrue(LongestHarmoniousSubsequence.hasConsecutiveNumbers(new int[] {1, 2, 3}));
            assertTrue(LongestHarmoniousSubsequence.hasConsecutiveNumbers(new int[] {1, 3, 2}));
            assertFalse(LongestHarmoniousSubsequence.hasConsecutiveNumbers(new int[] {1, 3, 5}));
            assertFalse(LongestHarmoniousSubsequence.hasConsecutiveNumbers(new int[] {1, 1, 1}));
            assertFalse(LongestHarmoniousSubsequence.hasConsecutiveNumbers(new int[] {1}));
            assertFalse(LongestHarmoniousSubsequence.hasConsecutiveNumbers(null));
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Test performance with large dataset")
        void testPerformanceLargeDataset() {
            int[] nums = new int[20000];
            for (int i = 0; i < 20000; i++) {
                nums[i] = (i % 100) + 1; // Values from 1 to 100
            }

            long startTime = System.currentTimeMillis();
            int result = solution.findLHSHashMap(nums);
            long endTime = System.currentTimeMillis();

            assertTrue(endTime - startTime < 1000); // Should complete within 1 second
            assertTrue(result > 0);
        }

        @Test
        @DisplayName("Test performance with sparse dataset")
        void testPerformanceSparseDataset() {
            int[] nums = new int[10000];
            for (int i = 0; i < 10000; i++) {
                nums[i] = i * 2; // Even numbers only, no consecutive pairs
            }

            long startTime = System.currentTimeMillis();
            int result = solution.findLHSHashMap(nums);
            long endTime = System.currentTimeMillis();

            assertTrue(endTime - startTime < 1000);
            assertEquals(0, result); // No harmonious subsequence
        }
    }

    @Nested
    @DisplayName("Null and Empty Input Tests")
    class NullAndEmptyInputTests {

        @Test
        @DisplayName("Test all approaches with null input")
        void testNullInput() {
            int[] nums = null;

            assertEquals(0, solution.findLHSHashMap(nums));
            assertEquals(0, solution.findLHSSorting(nums));
            assertEquals(0, solution.findLHSTwoPass(nums));
            assertEquals(0, solution.findLHSSinglePass(nums));
            assertEquals(0, solution.findLHSOptimized(nums));
            assertEquals(0, solution.findLHSArrayBased(nums));
        }

        @Test
        @DisplayName("Test all approaches with empty array")
        void testEmptyArray() {
            int[] nums = {};

            assertEquals(0, solution.findLHSHashMap(nums));
            assertEquals(0, solution.findLHSSorting(nums));
            assertEquals(0, solution.findLHSTwoPass(nums));
            assertEquals(0, solution.findLHSSinglePass(nums));
            assertEquals(0, solution.findLHSOptimized(nums));
            assertEquals(0, solution.findLHSArrayBased(nums));
        }
    }
}
