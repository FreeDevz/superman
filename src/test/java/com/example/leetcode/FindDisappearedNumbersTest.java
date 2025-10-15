package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Comprehensive test suite for FindDisappearedNumbers problem
 */
public class FindDisappearedNumbersTest {

    private FindDisappearedNumbers solution;

    @BeforeEach
    void setUp() {
        solution = new FindDisappearedNumbers();
    }

    @Nested
    @DisplayName("In-Place Negation Approach Tests")
    class InPlaceNegationTests {

        @Test
        @DisplayName("Test LeetCode Example 1: [4,3,2,7,8,2,3,1]")
        void testExample1() {
            int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
            List<Integer> result = solution.findDisappearedNumbersInPlaceNegation(nums);
            assertEquals(Arrays.asList(5, 6), result);
        }

        @Test
        @DisplayName("Test LeetCode Example 2: [1,1]")
        void testExample2() {
            int[] nums = {1, 1};
            List<Integer> result = solution.findDisappearedNumbersInPlaceNegation(nums);
            assertEquals(Arrays.asList(2), result);
        }

        @Test
        @DisplayName("Test no missing numbers")
        void testNoMissing() {
            int[] nums = {1, 2, 3, 4, 5};
            List<Integer> result = solution.findDisappearedNumbersInPlaceNegation(nums);
            assertTrue(result.isEmpty());
        }

        @Test
        @DisplayName("Test all missing except one")
        void testAllMissingExceptOne() {
            int[] nums = {2, 2, 2, 2, 2};
            List<Integer> result = solution.findDisappearedNumbersInPlaceNegation(nums);
            assertEquals(Arrays.asList(1, 3, 4, 5), result);
        }

        @Test
        @DisplayName("Test single element array - value 1")
        void testSingleElement1() {
            int[] nums = {1};
            List<Integer> result = solution.findDisappearedNumbersInPlaceNegation(nums);
            assertTrue(result.isEmpty());
        }

        @Test
        @DisplayName("Test two element array - missing first")
        void testTwoElementMissingFirst() {
            int[] nums = {2, 2};
            List<Integer> result = solution.findDisappearedNumbersInPlaceNegation(nums);
            assertEquals(Arrays.asList(1), result);
        }

        @Test
        @DisplayName("Test reversed sequence")
        void testReversed() {
            int[] nums = {5, 4, 3, 2, 1};
            List<Integer> result = solution.findDisappearedNumbersInPlaceNegation(nums);
            assertTrue(result.isEmpty());
        }
    }

    @Nested
    @DisplayName("Hash Set Approach Tests")
    class HashSetTests {

        @Test
        @DisplayName("Test LeetCode Example 1")
        void testExample1() {
            int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
            List<Integer> result = solution.findDisappearedNumbersHashSet(nums);
            assertEquals(Arrays.asList(5, 6), result);
        }

        @Test
        @DisplayName("Test LeetCode Example 2")
        void testExample2() {
            int[] nums = {1, 1};
            List<Integer> result = solution.findDisappearedNumbersHashSet(nums);
            assertEquals(Arrays.asList(2), result);
        }

        @Test
        @DisplayName("Test no missing numbers")
        void testNoMissing() {
            int[] nums = {1, 2, 3, 4, 5};
            List<Integer> result = solution.findDisappearedNumbersHashSet(nums);
            assertTrue(result.isEmpty());
        }
    }

    @Nested
    @DisplayName("Boolean Array Approach Tests")
    class BooleanArrayTests {

        @Test
        @DisplayName("Test LeetCode Example 1")
        void testExample1() {
            int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
            List<Integer> result = solution.findDisappearedNumbersBooleanArray(nums);
            assertEquals(Arrays.asList(5, 6), result);
        }

        @Test
        @DisplayName("Test LeetCode Example 2")
        void testExample2() {
            int[] nums = {1, 1};
            List<Integer> result = solution.findDisappearedNumbersBooleanArray(nums);
            assertEquals(Arrays.asList(2), result);
        }

        @Test
        @DisplayName("Test all duplicates")
        void testAllDuplicates() {
            int[] nums = {3, 3, 3};
            List<Integer> result = solution.findDisappearedNumbersBooleanArray(nums);
            assertEquals(Arrays.asList(1, 2), result);
        }
    }

    @Nested
    @DisplayName("Cyclic Sort Approach Tests")
    class CyclicSortTests {

        @Test
        @DisplayName("Test LeetCode Example 1")
        void testExample1() {
            int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
            List<Integer> result = solution.findDisappearedNumbersCyclicSort(nums);
            assertEquals(Arrays.asList(5, 6), result);
        }

        @Test
        @DisplayName("Test LeetCode Example 2")
        void testExample2() {
            int[] nums = {1, 1};
            List<Integer> result = solution.findDisappearedNumbersCyclicSort(nums);
            assertEquals(Arrays.asList(2), result);
        }

        @Test
        @DisplayName("Test no missing numbers")
        void testNoMissing() {
            int[] nums = {1, 2, 3, 4, 5};
            List<Integer> result = solution.findDisappearedNumbersCyclicSort(nums);
            assertTrue(result.isEmpty());
        }

        @Test
        @DisplayName("Test already sorted")
        void testAlreadySorted() {
            int[] nums = {1, 2, 2, 4, 5};
            List<Integer> result = solution.findDisappearedNumbersCyclicSort(nums);
            assertEquals(Arrays.asList(3), result);
        }
    }

    @Nested
    @DisplayName("Count Array Approach Tests")
    class CountArrayTests {

        @Test
        @DisplayName("Test LeetCode Example 1")
        void testExample1() {
            int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
            List<Integer> result = solution.findDisappearedNumbersCountArray(nums);
            assertEquals(Arrays.asList(5, 6), result);
        }

        @Test
        @DisplayName("Test LeetCode Example 2")
        void testExample2() {
            int[] nums = {1, 1};
            List<Integer> result = solution.findDisappearedNumbersCountArray(nums);
            assertEquals(Arrays.asList(2), result);
        }

        @Test
        @DisplayName("Test multiple occurrences")
        void testMultipleOccurrences() {
            int[] nums = {1, 1, 1, 1, 1};
            List<Integer> result = solution.findDisappearedNumbersCountArray(nums);
            assertEquals(Arrays.asList(2, 3, 4, 5), result);
        }
    }

    @Nested
    @DisplayName("Sorting Approach Tests")
    class SortingTests {

        @Test
        @DisplayName("Test LeetCode Example 1")
        void testExample1() {
            int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
            List<Integer> result = solution.findDisappearedNumbersSorting(nums);
            assertEquals(Arrays.asList(5, 6), result);
        }

        @Test
        @DisplayName("Test LeetCode Example 2")
        void testExample2() {
            int[] nums = {1, 1};
            List<Integer> result = solution.findDisappearedNumbersSorting(nums);
            assertEquals(Arrays.asList(2), result);
        }

        @Test
        @DisplayName("Test consecutive missing at end")
        void testMissingAtEnd() {
            int[] nums = {1, 2, 3, 3, 3};
            List<Integer> result = solution.findDisappearedNumbersSorting(nums);
            assertEquals(Arrays.asList(4, 5), result);
        }
    }

    @Nested
    @DisplayName("In-Place Addition Approach Tests")
    class InPlaceAdditionTests {

        @Test
        @DisplayName("Test LeetCode Example 1")
        void testExample1() {
            int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
            List<Integer> result = solution.findDisappearedNumbersInPlaceAddition(nums);
            assertEquals(Arrays.asList(5, 6), result);
        }

        @Test
        @DisplayName("Test LeetCode Example 2")
        void testExample2() {
            int[] nums = {1, 1};
            List<Integer> result = solution.findDisappearedNumbersInPlaceAddition(nums);
            assertEquals(Arrays.asList(2), result);
        }

        @Test
        @DisplayName("Test no missing numbers")
        void testNoMissing() {
            int[] nums = {1, 2, 3, 4, 5};
            List<Integer> result = solution.findDisappearedNumbersInPlaceAddition(nums);
            assertTrue(result.isEmpty());
        }
    }

    @Nested
    @DisplayName("Set Difference Approach Tests")
    class SetDifferenceTests {

        @Test
        @DisplayName("Test LeetCode Example 1")
        void testExample1() {
            int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
            List<Integer> result = solution.findDisappearedNumbersSetDifference(nums);
            Set<Integer> resultSet = new HashSet<>(result);
            Set<Integer> expectedSet = new HashSet<>(Arrays.asList(5, 6));
            assertEquals(expectedSet, resultSet);
        }

        @Test
        @DisplayName("Test LeetCode Example 2")
        void testExample2() {
            int[] nums = {1, 1};
            List<Integer> result = solution.findDisappearedNumbersSetDifference(nums);
            Set<Integer> resultSet = new HashSet<>(result);
            Set<Integer> expectedSet = new HashSet<>(Arrays.asList(2));
            assertEquals(expectedSet, resultSet);
        }

        @Test
        @DisplayName("Test empty result")
        void testEmptyResult() {
            int[] nums = {1, 2, 3};
            List<Integer> result = solution.findDisappearedNumbersSetDifference(nums);
            assertTrue(result.isEmpty());
        }
    }

    @Nested
    @DisplayName("LeetCode Examples Tests")
    class LeetCodeExamplesTests {

        @Test
        @DisplayName("Example 1: [4,3,2,7,8,2,3,1] -> [5,6]")
        void testExample1() {
            int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
            List<Integer> result = solution.findDisappearedNumbersInPlaceNegation(nums);
            assertEquals(Arrays.asList(5, 6), result);
        }

        @Test
        @DisplayName("Example 2: [1,1] -> [2]")
        void testExample2() {
            int[] nums = {1, 1};
            List<Integer> result = solution.findDisappearedNumbersInPlaceNegation(nums);
            assertEquals(Arrays.asList(2), result);
        }
    }

    @Nested
    @DisplayName("Edge Cases Tests")
    class EdgeCasesTests {

        @Test
        @DisplayName("Test minimum size array: [1]")
        void testMinimumSize() {
            int[] nums = {1};
            List<Integer> result = solution.findDisappearedNumbersInPlaceNegation(nums);
            assertTrue(result.isEmpty());
        }

        @Test
        @DisplayName("Test all same number")
        void testAllSame() {
            int[] nums = {5, 5, 5, 5, 5};
            List<Integer> result = solution.findDisappearedNumbersInPlaceNegation(nums);
            assertEquals(Arrays.asList(1, 2, 3, 4), result);
        }

        @Test
        @DisplayName("Test consecutive numbers starting from 1")
        void testConsecutiveFrom1() {
            int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            List<Integer> result = solution.findDisappearedNumbersInPlaceNegation(nums);
            assertTrue(result.isEmpty());
        }

        @Test
        @DisplayName("Test only first number present")
        void testOnlyFirst() {
            int[] nums = {1, 1, 1};
            List<Integer> result = solution.findDisappearedNumbersInPlaceNegation(nums);
            assertEquals(Arrays.asList(2, 3), result);
        }

        @Test
        @DisplayName("Test only last number present")
        void testOnlyLast() {
            int[] nums = {5, 5, 5, 5, 5};
            List<Integer> result = solution.findDisappearedNumbersInPlaceNegation(nums);
            assertEquals(Arrays.asList(1, 2, 3, 4), result);
        }

        @Test
        @DisplayName("Test alternating pattern")
        void testAlternating() {
            int[] nums = {1, 3, 5, 7, 9, 1, 3, 5, 7, 9};
            List<Integer> result = solution.findDisappearedNumbersInPlaceNegation(nums);
            assertEquals(Arrays.asList(2, 4, 6, 8, 10), result);
        }
    }

    @Nested
    @DisplayName("Boundary Tests")
    class BoundaryTests {

        @Test
        @DisplayName("Test two elements - both same")
        void testTwoSame() {
            int[] nums = {1, 1};
            List<Integer> result = solution.findDisappearedNumbersInPlaceNegation(nums);
            assertEquals(Arrays.asList(2), result);
        }

        @Test
        @DisplayName("Test two elements - both different")
        void testTwoDifferent() {
            int[] nums = {1, 2};
            List<Integer> result = solution.findDisappearedNumbersInPlaceNegation(nums);
            assertTrue(result.isEmpty());
        }

        @Test
        @DisplayName("Test large array with no missing")
        void testLargeNoMissing() {
            int[] nums = new int[100];
            for (int i = 0; i < 100; i++) {
                nums[i] = i + 1;
            }
            List<Integer> result = solution.findDisappearedNumbersInPlaceNegation(nums);
            assertTrue(result.isEmpty());
        }

        @Test
        @DisplayName("Test large array with many missing")
        void testLargeManyMissing() {
            int[] nums = new int[100];
            Arrays.fill(nums, 1);
            List<Integer> result = solution.findDisappearedNumbersInPlaceNegation(nums);
            assertEquals(99, result.size());
        }
    }

    @Nested
    @DisplayName("Cross-Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @Test
        @DisplayName("All approaches agree on example 1")
        void testAllApproachesExample1() {
            int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

            List<Integer> result1 = solution.findDisappearedNumbersInPlaceNegation(nums.clone());
            List<Integer> result2 = solution.findDisappearedNumbersHashSet(nums.clone());
            List<Integer> result3 = solution.findDisappearedNumbersBooleanArray(nums.clone());
            List<Integer> result4 = solution.findDisappearedNumbersCyclicSort(nums.clone());
            List<Integer> result5 = solution.findDisappearedNumbersCountArray(nums.clone());
            List<Integer> result6 = solution.findDisappearedNumbersSorting(nums.clone());
            List<Integer> result7 = solution.findDisappearedNumbersInPlaceAddition(nums.clone());

            // Convert to sets for comparison (order might differ)
            Set<Integer> set1 = new HashSet<>(result1);
            Set<Integer> set2 = new HashSet<>(result2);
            Set<Integer> set3 = new HashSet<>(result3);
            Set<Integer> set4 = new HashSet<>(result4);
            Set<Integer> set5 = new HashSet<>(result5);
            Set<Integer> set6 = new HashSet<>(result6);
            Set<Integer> set7 = new HashSet<>(result7);

            assertEquals(set1, set2);
            assertEquals(set2, set3);
            assertEquals(set3, set4);
            assertEquals(set4, set5);
            assertEquals(set5, set6);
            assertEquals(set6, set7);
        }

        @Test
        @DisplayName("All approaches agree on multiple test cases")
        void testAllApproachesMultiple() {
            int[][] testCases = {{1, 1}, {1, 2, 3, 4, 5}, {5, 4, 3, 2, 1}, {2, 2, 2, 2, 2},
                    {1, 3, 5, 7, 9, 1, 3, 5, 7, 9}};

            for (int[] nums : testCases) {
                List<Integer> result1 =
                        solution.findDisappearedNumbersInPlaceNegation(nums.clone());
                List<Integer> result2 = solution.findDisappearedNumbersHashSet(nums.clone());
                List<Integer> result3 = solution.findDisappearedNumbersCyclicSort(nums.clone());

                Set<Integer> set1 = new HashSet<>(result1);
                Set<Integer> set2 = new HashSet<>(result2);
                Set<Integer> set3 = new HashSet<>(result3);

                assertEquals(set1, set2);
                assertEquals(set2, set3);
            }
        }
    }

    @Nested
    @DisplayName("Utility Methods Tests")
    class UtilityMethodsTests {

        @Test
        @DisplayName("Test verifyResult with correct result")
        void testVerifyResultCorrect() {
            int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
            List<Integer> result = Arrays.asList(5, 6);
            assertTrue(solution.verifyResult(nums, result));
        }

        @Test
        @DisplayName("Test countMissingNumbers")
        void testCountMissing() {
            int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
            assertEquals(2, solution.countMissingNumbers(nums));
        }

        @Test
        @DisplayName("Test countMissingNumbers with no missing")
        void testCountNoMissing() {
            int[] nums = {1, 2, 3, 4, 5};
            assertEquals(0, solution.countMissingNumbers(nums));
        }

        @Test
        @DisplayName("Test findMissingInRange")
        void testFindMissingInRange() {
            int[] nums = {1, 3, 5, 7, 9};
            List<Integer> result = solution.findMissingInRange(nums, 1, 5);
            assertEquals(Arrays.asList(2, 4), result);
        }

        @Test
        @DisplayName("Test findMissingInRange with extended range")
        void testFindMissingInRangeExtended() {
            int[] nums = {1, 2, 3};
            List<Integer> result = solution.findMissingInRange(nums, 1, 10);
            assertEquals(Arrays.asList(4, 5, 6, 7, 8, 9, 10), result);
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Test with large array (1000 elements)")
        void testLargeArray() {
            int[] nums = new int[1000];
            for (int i = 0; i < 1000; i++) {
                nums[i] = (i % 500) + 1; // Create pattern with missing numbers
            }

            List<Integer> result = solution.findDisappearedNumbersInPlaceNegation(nums);
            assertTrue(result.size() > 0);
            assertTrue(solution.verifyResult(nums, result));
        }

        @Test
        @DisplayName("Test performance comparison")
        void testPerformanceComparison() {
            int[] nums = new int[1000];
            for (int i = 0; i < 1000; i++) {
                nums[i] = (i % 500) + 1;
            }

            long start = System.nanoTime();
            solution.findDisappearedNumbersInPlaceNegation(nums.clone());
            long time1 = System.nanoTime() - start;

            start = System.nanoTime();
            solution.findDisappearedNumbersHashSet(nums.clone());
            long time2 = System.nanoTime() - start;

            // Both should complete in reasonable time
            assertTrue(time1 < 10_000_000); // 10ms
            assertTrue(time2 < 10_000_000); // 10ms
        }
    }

    @Nested
    @DisplayName("Pattern Tests")
    class PatternTests {

        @Test
        @DisplayName("Test sequential missing numbers")
        void testSequentialMissing() {
            int[] nums = {1, 2, 6, 7, 8, 1, 2, 6, 7, 8};
            List<Integer> result = solution.findDisappearedNumbersInPlaceNegation(nums);
            assertEquals(Arrays.asList(3, 4, 5, 9, 10), result);
        }

        @Test
        @DisplayName("Test evens only")
        void testEvensOnly() {
            int[] nums = {2, 4, 6, 8, 10, 2, 4, 6, 8, 10};
            List<Integer> result = solution.findDisappearedNumbersInPlaceNegation(nums);
            assertEquals(Arrays.asList(1, 3, 5, 7, 9), result);
        }

        @Test
        @DisplayName("Test odds only")
        void testOddsOnly() {
            int[] nums = {1, 3, 5, 7, 9, 1, 3, 5, 7, 9};
            List<Integer> result = solution.findDisappearedNumbersInPlaceNegation(nums);
            assertEquals(Arrays.asList(2, 4, 6, 8, 10), result);
        }

        @Test
        @DisplayName("Test first half missing")
        void testFirstHalfMissing() {
            int[] nums = {6, 7, 8, 9, 10, 6, 7, 8, 9, 10};
            List<Integer> result = solution.findDisappearedNumbersInPlaceNegation(nums);
            assertEquals(Arrays.asList(1, 2, 3, 4, 5), result);
        }

        @Test
        @DisplayName("Test second half missing")
        void testSecondHalfMissing() {
            int[] nums = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
            List<Integer> result = solution.findDisappearedNumbersInPlaceNegation(nums);
            assertEquals(Arrays.asList(6, 7, 8, 9, 10), result);
        }
    }

    @Nested
    @DisplayName("Duplicate Pattern Tests")
    class DuplicatePatternTests {

        @Test
        @DisplayName("Test all duplicates of first element")
        void testAllFirstElement() {
            int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
            List<Integer> result = solution.findDisappearedNumbersInPlaceNegation(nums);
            assertEquals(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10), result);
        }

        @Test
        @DisplayName("Test all duplicates of last element")
        void testAllLastElement() {
            int[] nums = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
            List<Integer> result = solution.findDisappearedNumbersInPlaceNegation(nums);
            assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), result);
        }

        @Test
        @DisplayName("Test all duplicates of middle element")
        void testAllMiddleElement() {
            int[] nums = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
            List<Integer> result = solution.findDisappearedNumbersInPlaceNegation(nums);
            assertEquals(Arrays.asList(1, 2, 3, 4, 6, 7, 8, 9, 10), result);
        }

        @Test
        @DisplayName("Test pairs of duplicates")
        void testPairsOfDuplicates() {
            int[] nums = {1, 1, 3, 3, 5, 5};
            List<Integer> result = solution.findDisappearedNumbersInPlaceNegation(nums);
            assertEquals(Arrays.asList(2, 4, 6), result);
        }
    }
}

