package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Comprehensive test suite for LeetCode 414: Third Maximum Number
 * 
 * Tests all approaches with various edge cases and performance scenarios.
 */
public class ThirdMaximumNumberTest {

    private ThirdMaximumNumber solution;

    @BeforeEach
    void setUp() {
        solution = new ThirdMaximumNumber();
    }

    @Nested
    @DisplayName("Three Variables Approach Tests")
    class ThreeVariablesApproachTests {

        @Test
        @DisplayName("Basic example - three distinct numbers")
        void testBasicExampleThreeDistinct() {
            int[] nums = {3, 2, 1};
            int expected = 1;
            int result = solution.thirdMaxThreeVariables(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Basic example - two distinct numbers")
        void testBasicExampleTwoDistinct() {
            int[] nums = {1, 2};
            int expected = 2;
            int result = solution.thirdMaxThreeVariables(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Basic example - with duplicates")
        void testBasicExampleWithDuplicates() {
            int[] nums = {2, 2, 3, 1};
            int expected = 1;
            int result = solution.thirdMaxThreeVariables(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Single element")
        void testSingleElement() {
            int[] nums = {1};
            int expected = 1;
            int result = solution.thirdMaxThreeVariables(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("All same elements")
        void testAllSameElements() {
            int[] nums = {1, 1, 1, 1};
            int expected = 1;
            int result = solution.thirdMaxThreeVariables(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Negative numbers")
        void testNegativeNumbers() {
            int[] nums = {-1, -2, -3};
            int expected = -3;
            int result = solution.thirdMaxThreeVariables(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Mixed positive and negative numbers")
        void testMixedNumbers() {
            int[] nums = {1, -1, 2, -2, 3, -3};
            int expected = 1;
            int result = solution.thirdMaxThreeVariables(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Integer.MIN_VALUE handling")
        void testIntegerMinValue() {
            int[] nums = {1, 2, Integer.MIN_VALUE};
            int expected = Integer.MIN_VALUE;
            int result = solution.thirdMaxThreeVariables(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Integer.MAX_VALUE handling")
        void testIntegerMaxValue() {
            int[] nums = {Integer.MAX_VALUE, 2, 1};
            int expected = 1;
            int result = solution.thirdMaxThreeVariables(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Large array with many duplicates")
        void testLargeArrayWithDuplicates() {
            int[] nums = new int[1000];
            for (int i = 0; i < 1000; i++) {
                nums[i] = i % 10; // Only 10 distinct values: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
            }
            int expected = 7; // Third maximum among {9, 8, 7, 6, 5, 4, 3, 2, 1, 0}
            int result = solution.thirdMaxThreeVariables(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Descending order")
        void testDescendingOrder() {
            int[] nums = {5, 4, 3, 2, 1};
            int expected = 3;
            int result = solution.thirdMaxThreeVariables(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Ascending order")
        void testAscendingOrder() {
            int[] nums = {1, 2, 3, 4, 5};
            int expected = 3;
            int result = solution.thirdMaxThreeVariables(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Random order")
        void testRandomOrder() {
            int[] nums = {3, 1, 4, 1, 5, 9, 2, 6};
            int expected = 5; // Third maximum among distinct elements {9, 6, 5, 4, 3, 2, 1}
            int result = solution.thirdMaxThreeVariables(nums);
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("TreeSet Approach Tests")
    class TreeSetApproachTests {

        @Test
        @DisplayName("Basic example with TreeSet")
        void testBasicExample() {
            int[] nums = {3, 2, 1};
            int expected = 1;
            int result = solution.thirdMaxTreeSet(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Two distinct numbers with TreeSet")
        void testTwoDistinctNumbers() {
            int[] nums = {1, 2};
            int expected = 2;
            int result = solution.thirdMaxTreeSet(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("With duplicates using TreeSet")
        void testWithDuplicates() {
            int[] nums = {2, 2, 3, 1};
            int expected = 1;
            int result = solution.thirdMaxTreeSet(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Single element with TreeSet")
        void testSingleElement() {
            int[] nums = {1};
            int expected = 1;
            int result = solution.thirdMaxTreeSet(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("All same elements with TreeSet")
        void testAllSameElements() {
            int[] nums = {1, 1, 1, 1};
            int expected = 1;
            int result = solution.thirdMaxTreeSet(nums);
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("HashSet + Sorting Approach Tests")
    class HashSetSortingApproachTests {

        @Test
        @DisplayName("Basic example with HashSet + Sorting")
        void testBasicExample() {
            int[] nums = {3, 2, 1};
            int expected = 1;
            int result = solution.thirdMaxHashSetSorting(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("With many duplicates")
        void testWithManyDuplicates() {
            int[] nums = {1, 1, 2, 2, 3, 3, 3};
            int expected = 1;
            int result = solution.thirdMaxHashSetSorting(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Negative numbers with HashSet + Sorting")
        void testNegativeNumbers() {
            int[] nums = {-1, -2, -3, -1};
            int expected = -3;
            int result = solution.thirdMaxHashSetSorting(nums);
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Array Tracking Approach Tests")
    class ArrayTrackingApproachTests {

        @Test
        @DisplayName("Basic example with Array Tracking")
        void testBasicExample() {
            int[] nums = {3, 2, 1};
            int expected = 1;
            int result = solution.thirdMaxArrayTracking(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Edge case with Integer.MIN_VALUE")
        void testIntegerMinValue() {
            int[] nums = {1, 2, Integer.MIN_VALUE};
            int expected = Integer.MIN_VALUE;
            int result = solution.thirdMaxArrayTracking(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Two distinct numbers")
        void testTwoDistinctNumbers() {
            int[] nums = {5, 3};
            int expected = 5;
            int result = solution.thirdMaxArrayTracking(nums);
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Priority Queue Approach Tests")
    class PriorityQueueApproachTests {

        @Test
        @DisplayName("Basic example with Priority Queue")
        void testBasicExample() {
            int[] nums = {3, 2, 1};
            int expected = 1;
            int result = solution.thirdMaxPriorityQueue(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("With duplicates using Priority Queue")
        void testWithDuplicates() {
            int[] nums = {2, 2, 3, 1};
            int expected = 1;
            int result = solution.thirdMaxPriorityQueue(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Single element with Priority Queue")
        void testSingleElement() {
            int[] nums = {1};
            int expected = 1;
            int result = solution.thirdMaxPriorityQueue(nums);
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Streams Approach Tests")
    class StreamsApproachTests {

        @Test
        @DisplayName("Basic example with Streams")
        void testBasicExample() {
            int[] nums = {3, 2, 1};
            int expected = 1;
            int result = solution.thirdMaxStreams(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("With duplicates using Streams")
        void testWithDuplicates() {
            int[] nums = {2, 2, 3, 1};
            int expected = 1;
            int result = solution.thirdMaxStreams(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Large array with Streams")
        void testLargeArray() {
            int[] nums = new int[100];
            for (int i = 0; i < 100; i++) {
                nums[i] = i % 5; // Only 5 distinct values: 0, 1, 2, 3, 4
            }
            int expected = 2; // Third maximum among 0, 1, 2, 3, 4
            int result = solution.thirdMaxStreams(nums);
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Optimized Approach Tests")
    class OptimizedApproachTests {

        @Test
        @DisplayName("Basic example with Optimized approach")
        void testBasicExample() {
            int[] nums = {3, 2, 1};
            int expected = 1;
            int result = solution.thirdMaxOptimized(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Edge case with null handling")
        void testNullHandling() {
            int[] nums = {1, 2};
            int expected = 2;
            int result = solution.thirdMaxOptimized(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Integer.MIN_VALUE with Optimized approach")
        void testIntegerMinValue() {
            int[] nums = {1, 2, Integer.MIN_VALUE};
            int expected = Integer.MIN_VALUE;
            int result = solution.thirdMaxOptimized(nums);
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Cross Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @Test
        @DisplayName("All approaches should produce same result")
        void testAllApproachesConsistency() {
            int[] nums = {3, 2, 1, 4, 5, 2, 3};

            int result1 = solution.thirdMaxThreeVariables(nums.clone());
            int result2 = solution.thirdMaxTreeSet(nums.clone());
            int result3 = solution.thirdMaxHashSetSorting(nums.clone());
            int result4 = solution.thirdMaxArrayTracking(nums.clone());
            int result5 = solution.thirdMaxPriorityQueue(nums.clone());
            int result6 = solution.thirdMaxStreams(nums.clone());
            int result7 = solution.thirdMaxOptimized(nums.clone());

            // All results should be the same
            assertEquals(result1, result2);
            assertEquals(result2, result3);
            assertEquals(result3, result4);
            assertEquals(result4, result5);
            assertEquals(result5, result6);
            assertEquals(result6, result7);
        }

        @Test
        @DisplayName("Edge case - two distinct numbers")
        void testTwoDistinctNumbersAllApproaches() {
            int[] nums = {1, 2};

            int result1 = solution.thirdMaxThreeVariables(nums.clone());
            int result2 = solution.thirdMaxTreeSet(nums.clone());
            int result3 = solution.thirdMaxHashSetSorting(nums.clone());
            int result4 = solution.thirdMaxArrayTracking(nums.clone());
            int result5 = solution.thirdMaxPriorityQueue(nums.clone());
            int result6 = solution.thirdMaxStreams(nums.clone());
            int result7 = solution.thirdMaxOptimized(nums.clone());

            assertEquals(result1, result2);
            assertEquals(result2, result3);
            assertEquals(result3, result4);
            assertEquals(result4, result5);
            assertEquals(result5, result6);
            assertEquals(result6, result7);
            assertEquals(2, result1); // Should return maximum when third doesn't exist
        }

        @Test
        @DisplayName("Edge case - single element")
        void testSingleElementAllApproaches() {
            int[] nums = {1};

            int result1 = solution.thirdMaxThreeVariables(nums.clone());
            int result2 = solution.thirdMaxTreeSet(nums.clone());
            int result3 = solution.thirdMaxHashSetSorting(nums.clone());
            int result4 = solution.thirdMaxArrayTracking(nums.clone());
            int result5 = solution.thirdMaxPriorityQueue(nums.clone());
            int result6 = solution.thirdMaxStreams(nums.clone());
            int result7 = solution.thirdMaxOptimized(nums.clone());

            assertEquals(result1, result2);
            assertEquals(result2, result3);
            assertEquals(result3, result4);
            assertEquals(result4, result5);
            assertEquals(result5, result6);
            assertEquals(result6, result7);
            assertEquals(1, result1);
        }

        @Test
        @DisplayName("Edge case - all same elements")
        void testAllSameElementsAllApproaches() {
            int[] nums = {1, 1, 1, 1};

            int result1 = solution.thirdMaxThreeVariables(nums.clone());
            int result2 = solution.thirdMaxTreeSet(nums.clone());
            int result3 = solution.thirdMaxHashSetSorting(nums.clone());
            int result4 = solution.thirdMaxArrayTracking(nums.clone());
            int result5 = solution.thirdMaxPriorityQueue(nums.clone());
            int result6 = solution.thirdMaxStreams(nums.clone());
            int result7 = solution.thirdMaxOptimized(nums.clone());

            assertEquals(result1, result2);
            assertEquals(result2, result3);
            assertEquals(result3, result4);
            assertEquals(result4, result5);
            assertEquals(result5, result6);
            assertEquals(result6, result7);
            assertEquals(1, result1);
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Large array performance test")
        void testLargeArrayPerformance() {
            // Create large array with many distinct values
            int[] nums = new int[10000];
            for (int i = 0; i < 10000; i++) {
                nums[i] = i % 1000; // 1000 distinct values
            }

            long startTime = System.nanoTime();
            int result = solution.thirdMaxThreeVariables(nums);
            long endTime = System.nanoTime();

            long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds

            // Should complete in reasonable time (less than 100ms)
            assertTrue(duration < 100,
                    "Three variables approach took too long: " + duration + "ms");
            assertEquals(997, result); // Third maximum among 0-999 (sorted descending: 999, 998,
                                       // 997, ...)
        }

        @Test
        @DisplayName("Maximum constraint test")
        void testMaximumConstraints() {
            // Test with maximum constraints: 10^4 elements, values -2^31 to 2^31-1
            int[] nums = new int[10000];
            for (int i = 0; i < 10000; i++) {
                nums[i] = i - 5000; // Values from -5000 to 4999
            }

            int result = solution.thirdMaxThreeVariables(nums);

            // Should handle without errors
            assertNotNull(result);
            assertEquals(4997, result); // Third maximum among -5000 to 4999
        }

        @Test
        @DisplayName("Performance comparison between approaches")
        void testPerformanceComparison() {
            int[] nums = new int[1000];
            for (int i = 0; i < 1000; i++) {
                nums[i] = i % 100; // 100 distinct values
            }

            // Test three variables approach (should be fastest)
            long startTime = System.nanoTime();
            int result1 = solution.thirdMaxThreeVariables(nums.clone());
            long endTime = System.nanoTime();
            long duration1 = (endTime - startTime) / 1_000_000;

            // Test TreeSet approach
            startTime = System.nanoTime();
            int result2 = solution.thirdMaxTreeSet(nums.clone());
            endTime = System.nanoTime();
            long duration2 = (endTime - startTime) / 1_000_000;

            // Results should be the same
            assertEquals(result1, result2);

            // Both should complete in reasonable time
            assertTrue(duration1 < 100,
                    "Three variables approach took too long: " + duration1 + "ms");
            assertTrue(duration2 < 100, "TreeSet approach took too long: " + duration2 + "ms");
        }
    }

    @Nested
    @DisplayName("Utility Method Tests")
    class UtilityMethodTests {

        @Test
        @DisplayName("Test getDistinctElements method")
        void testGetDistinctElements() {
            int[] nums = {1, 2, 2, 3, 3, 3};
            var distinct = ThirdMaximumNumber.getDistinctElements(nums);

            assertEquals(3, distinct.size());
            assertTrue(distinct.contains(1));
            assertTrue(distinct.contains(2));
            assertTrue(distinct.contains(3));
        }

        @Test
        @DisplayName("Test getSortedDistinctElements method")
        void testGetSortedDistinctElements() {
            int[] nums = {3, 1, 2, 2, 3, 1};
            var sortedDistinct = ThirdMaximumNumber.getSortedDistinctElements(nums);

            assertEquals(3, sortedDistinct.size());
            assertEquals(3, sortedDistinct.get(0));
            assertEquals(2, sortedDistinct.get(1));
            assertEquals(1, sortedDistinct.get(2));
        }

        @Test
        @DisplayName("Test printArray method")
        void testPrintArray() {
            int[] nums = {1, 2, 3};
            // This test just ensures the method doesn't throw an exception
            assertDoesNotThrow(() -> ThirdMaximumNumber.printArray(nums));
        }
    }

    @Nested
    @DisplayName("Edge Case Tests")
    class EdgeCaseTests {

        @Test
        @DisplayName("Array with Integer.MIN_VALUE and Integer.MAX_VALUE")
        void testMinMaxValues() {
            int[] nums = {Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
            int result = solution.thirdMaxThreeVariables(nums);
            assertEquals(Integer.MIN_VALUE, result); // Third maximum among {MAX_VALUE, 0,
                                                     // MIN_VALUE}
        }

        @Test
        @DisplayName("Array with zeros")
        void testZeros() {
            int[] nums = {0, 0, 0, 0};
            int result = solution.thirdMaxThreeVariables(nums);
            assertEquals(0, result);
        }

        @Test
        @DisplayName("Array with alternating pattern")
        void testAlternatingPattern() {
            int[] nums = {1, -1, 2, -2, 3, -3};
            int result = solution.thirdMaxThreeVariables(nums);
            assertEquals(1, result);
        }

        @Test
        @DisplayName("Array with large negative numbers")
        void testLargeNegativeNumbers() {
            int[] nums = {-1000, -999, -998, -997};
            int result = solution.thirdMaxThreeVariables(nums);
            assertEquals(-999, result); // Third maximum among {-997, -998, -999, -1000}
        }

        @Test
        @DisplayName("Array with large positive numbers")
        void testLargePositiveNumbers() {
            int[] nums = {1000, 999, 998, 997};
            int result = solution.thirdMaxThreeVariables(nums);
            assertEquals(998, result);
        }
    }
}
