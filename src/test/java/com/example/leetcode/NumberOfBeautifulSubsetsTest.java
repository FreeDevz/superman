package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Comprehensive test suite for NumberOfBeautifulSubsets problem
 */
public class NumberOfBeautifulSubsetsTest {

    private NumberOfBeautifulSubsets solution;

    @BeforeEach
    void setUp() {
        solution = new NumberOfBeautifulSubsets();
    }

    @Nested
    @DisplayName("Backtracking Approach Tests")
    class BacktrackingApproachTests {

        @Test
        @DisplayName("LeetCode Example 1: [2,4,6], k=2")
        void testExample1() {
            int[] nums = {2, 4, 6};
            int k = 2;
            int result = solution.beautifulSubsets(nums, k);
            assertEquals(4, result);
        }

        @Test
        @DisplayName("LeetCode Example 2: [1], k=1")
        void testExample2() {
            int[] nums = {1};
            int k = 1;
            int result = solution.beautifulSubsets(nums, k);
            assertEquals(1, result);
        }

        @Test
        @DisplayName("Test with no conflicts")
        void testNoConflicts() {
            int[] nums = {1, 3, 5};
            int k = 10;
            int result = solution.beautifulSubsets(nums, k);
            // All 7 non-empty subsets are beautiful: {1}, {3}, {5}, {1,3}, {1,5}, {3,5}, {1,3,5}
            assertEquals(7, result);
        }

        @Test
        @DisplayName("Test with all conflicts")
        void testAllConflicts() {
            int[] nums = {1, 3, 5};
            int k = 2;
            int result = solution.beautifulSubsets(nums, k);
            // Beautiful subsets: {1}, {3}, {5}, {1,5} (4 total)
            // {1,3} and {3,5} have diff=2, so not beautiful
            assertEquals(4, result);
        }

        @Test
        @DisplayName("Test with duplicate values")
        void testDuplicateValues() {
            int[] nums = {2, 2, 4};
            int k = 2;
            int result = solution.beautifulSubsets(nums, k);
            // Beautiful subsets: {2}, {2}, {4}, {2,2} (4 total)
            // {2,4} has diff=2, so not beautiful
            assertEquals(4, result);
        }

        @Test
        @DisplayName("Test with larger array")
        void testLargerArray() {
            int[] nums = {1, 2, 3, 4, 5};
            int k = 1;
            int result = solution.beautifulSubsets(nums, k);
            assertTrue(result > 0);
        }
    }

    @Nested
    @DisplayName("Backtracking with Set Approach Tests")
    class BacktrackingWithSetApproachTests {

        @Test
        @DisplayName("Test Example 1 with Set approach")
        void testExample1WithSet() {
            int[] nums = {2, 4, 6};
            int k = 2;
            int result = solution.beautifulSubsetsWithSet(nums, k);
            assertEquals(4, result);
        }

        @Test
        @DisplayName("Test Example 2 with Set approach")
        void testExample2WithSet() {
            int[] nums = {1};
            int k = 1;
            int result = solution.beautifulSubsetsWithSet(nums, k);
            assertEquals(1, result);
        }

        @Test
        @DisplayName("Test consistency with backtracking approach")
        void testConsistencyWithBacktracking() {
            int[] nums = {1, 3, 5, 7};
            int k = 2;
            int backtrackingResult = solution.beautifulSubsets(nums, k);
            int setResult = solution.beautifulSubsetsWithSet(nums, k);
            assertEquals(backtrackingResult, setResult);
        }
    }

    @Nested
    @DisplayName("Bitmasking Approach Tests")
    class BitmaskingApproachTests {

        @Test
        @DisplayName("Test Example 1 with Bitmasking")
        void testExample1Bitmask() {
            int[] nums = {2, 4, 6};
            int k = 2;
            int result = solution.beautifulSubsetsBitmask(nums, k);
            assertEquals(4, result);
        }

        @Test
        @DisplayName("Test Example 2 with Bitmasking")
        void testExample2Bitmask() {
            int[] nums = {1};
            int k = 1;
            int result = solution.beautifulSubsetsBitmask(nums, k);
            assertEquals(1, result);
        }

        @Test
        @DisplayName("Test consistency with backtracking approach")
        void testConsistencyWithBacktracking() {
            int[] nums = {1, 2, 3, 4};
            int k = 1;
            int backtrackingResult = solution.beautifulSubsets(nums, k);
            int bitmaskResult = solution.beautifulSubsetsBitmask(nums, k);
            assertEquals(backtrackingResult, bitmaskResult);
        }
    }

    @Nested
    @DisplayName("Memoization Approach Tests")
    class MemoizationApproachTests {

        @Test
        @DisplayName("Test Example 1 with Memoization")
        void testExample1Memo() {
            int[] nums = {2, 4, 6};
            int k = 2;
            int result = solution.beautifulSubsetsMemoization(nums, k);
            assertEquals(4, result);
        }

        @Test
        @DisplayName("Test Example 2 with Memoization")
        void testExample2Memo() {
            int[] nums = {1};
            int k = 1;
            int result = solution.beautifulSubsetsMemoization(nums, k);
            assertEquals(1, result);
        }
    }

    @Nested
    @DisplayName("Optimized Backtracking Approach Tests")
    class OptimizedBacktrackingApproachTests {

        @Test
        @DisplayName("Test Example 1 with Optimized approach")
        void testExample1Optimized() {
            int[] nums = {2, 4, 6};
            int k = 2;
            int result = solution.beautifulSubsetsOptimized(nums, k);
            assertEquals(4, result);
        }

        @Test
        @DisplayName("Test Example 2 with Optimized approach")
        void testExample2Optimized() {
            int[] nums = {1};
            int k = 1;
            int result = solution.beautifulSubsetsOptimized(nums, k);
            assertEquals(1, result);
        }

        @Test
        @DisplayName("Test consistency with standard backtracking")
        void testConsistencyWithStandard() {
            int[] nums = {1, 2, 3, 4, 5};
            int k = 2;
            int standardResult = solution.beautifulSubsets(nums, k);
            int optimizedResult = solution.beautifulSubsetsOptimized(nums, k);
            assertEquals(standardResult, optimizedResult);
        }
    }

    @Nested
    @DisplayName("Cross-Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @Test
        @DisplayName("All approaches should produce identical results for Example 1")
        void testAllApproachesExample1() {
            int[] nums = {2, 4, 6};
            int k = 2;

            int backtracking = solution.beautifulSubsets(nums, k);
            int withSet = solution.beautifulSubsetsWithSet(nums, k);
            int bitmask = solution.beautifulSubsetsBitmask(nums, k);
            int memo = solution.beautifulSubsetsMemoization(nums, k);
            int optimized = solution.beautifulSubsetsOptimized(nums, k);

            assertEquals(4, backtracking);
            assertEquals(backtracking, withSet);
            assertEquals(backtracking, bitmask);
            assertEquals(backtracking, memo);
            assertEquals(backtracking, optimized);
        }

        @Test
        @DisplayName("All approaches should produce identical results for Example 2")
        void testAllApproachesExample2() {
            int[] nums = {1};
            int k = 1;

            int backtracking = solution.beautifulSubsets(nums, k);
            int withSet = solution.beautifulSubsetsWithSet(nums, k);
            int bitmask = solution.beautifulSubsetsBitmask(nums, k);
            int memo = solution.beautifulSubsetsMemoization(nums, k);
            int optimized = solution.beautifulSubsetsOptimized(nums, k);

            assertEquals(1, backtracking);
            assertEquals(backtracking, withSet);
            assertEquals(backtracking, bitmask);
            assertEquals(backtracking, memo);
            assertEquals(backtracking, optimized);
        }

        @Test
        @DisplayName("All approaches should produce identical results for complex case")
        void testAllApproachesComplexCase() {
            int[] nums = {1, 3, 5, 7, 9};
            int k = 2;

            int backtracking = solution.beautifulSubsets(nums, k);
            int withSet = solution.beautifulSubsetsWithSet(nums, k);
            int bitmask = solution.beautifulSubsetsBitmask(nums, k);
            int memo = solution.beautifulSubsetsMemoization(nums, k);
            int optimized = solution.beautifulSubsetsOptimized(nums, k);

            assertEquals(backtracking, withSet);
            assertEquals(backtracking, bitmask);
            assertEquals(backtracking, memo);
            assertEquals(backtracking, optimized);
        }
    }

    @Nested
    @DisplayName("Edge Case Tests")
    class EdgeCaseTests {

        @Test
        @DisplayName("Test with minimum array size")
        void testMinimumArraySize() {
            int[] nums = {1};
            int k = 1;
            int result = solution.beautifulSubsets(nums, k);
            assertEquals(1, result);
        }

        @Test
        @DisplayName("Test with maximum constraint values")
        void testMaxConstraintValues() {
            int[] nums = new int[20];
            for (int i = 0; i < 20; i++) {
                nums[i] = 1000 - i;
            }
            int k = 1;
            int result = solution.beautifulSubsets(nums, k);
            assertTrue(result > 0);
        }

        @Test
        @DisplayName("Test with k=1 and consecutive numbers")
        void testK1Consecutive() {
            int[] nums = {1, 2, 3, 4, 5};
            int k = 1;
            int result = solution.beautifulSubsets(nums, k);
            // Beautiful subsets:
            // Single: {1}, {2}, {3}, {4}, {5} = 5
            // Two (non-consecutive): {1,3}, {1,4}, {1,5}, {2,4}, {2,5}, {3,5} = 6
            // Three: {1,3,5} = 1
            // Total: 12
            assertEquals(12, result);
        }

        @Test
        @DisplayName("Test with large k value")
        void testLargeK() {
            int[] nums = {1, 2, 3, 4, 5};
            int k = 1000;
            int result = solution.beautifulSubsets(nums, k);
            // All non-empty subsets are beautiful (2^5 - 1 = 31)
            assertEquals(31, result);
        }

        @Test
        @DisplayName("Test with sorted array")
        void testSortedArray() {
            int[] nums = {1, 5, 3, 2, 4};
            int k = 1;
            int result1 = solution.beautifulSubsets(nums, k);
            // Sort the array
            java.util.Arrays.sort(nums);
            int result2 = solution.beautifulSubsets(nums, k);
            // Results should be the same regardless of input order
            assertEquals(result1, result2);
        }
    }

    @Nested
    @DisplayName("Utility Method Tests")
    class UtilityMethodTests {

        @Test
        @DisplayName("Test isBeautifulSubset utility method")
        void testIsBeautifulSubset() {
            List<Integer> subset1 = List.of(2, 6);
            assertTrue(NumberOfBeautifulSubsets.isBeautifulSubset(subset1, 2));

            List<Integer> subset2 = List.of(2, 4);
            assertFalse(NumberOfBeautifulSubsets.isBeautifulSubset(subset2, 2));

            List<Integer> subset3 = List.of(1);
            assertTrue(NumberOfBeautifulSubsets.isBeautifulSubset(subset3, 1));

            List<Integer> subset4 = List.of(1, 3, 5);
            assertTrue(NumberOfBeautifulSubsets.isBeautifulSubset(subset4, 1));
            assertFalse(NumberOfBeautifulSubsets.isBeautifulSubset(subset4, 2));
        }

        @Test
        @DisplayName("Test generateAllSubsets utility method")
        void testGenerateAllSubsets() {
            int[] nums = {1, 2, 3};
            List<List<Integer>> subsets = NumberOfBeautifulSubsets.generateAllSubsets(nums);
            // Should generate 2^3 = 8 subsets (including empty subset)
            assertEquals(8, subsets.size());
        }

        @Test
        @DisplayName("Test generateAllSubsets with single element")
        void testGenerateAllSubsetsSingle() {
            int[] nums = {1};
            List<List<Integer>> subsets = NumberOfBeautifulSubsets.generateAllSubsets(nums);
            assertEquals(2, subsets.size()); // {} and {1}
        }
    }

    @Nested
    @DisplayName("LeetCode Examples Tests")
    class LeetCodeExamplesTests {

        @Test
        @DisplayName("LeetCode Example 1: [2,4,6], k=2 -> 4")
        void testLeetCodeExample1() {
            int[] nums = {2, 4, 6};
            int k = 2;
            int result = solution.beautifulSubsets(nums, k);
            assertEquals(4, result);
            // Beautiful subsets: [2], [4], [6], [2, 6]
        }

        @Test
        @DisplayName("LeetCode Example 2: [1], k=1 -> 1")
        void testLeetCodeExample2() {
            int[] nums = {1};
            int k = 1;
            int result = solution.beautifulSubsets(nums, k);
            assertEquals(1, result);
            // Beautiful subset: [1]
        }
    }
}

