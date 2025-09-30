package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Comprehensive test suite for LeetCode 350: Intersection of Two Arrays II
 * 
 * Tests all approaches with various edge cases and performance scenarios.
 */
public class IntersectionOfTwoArraysIITest {

    private IntersectionOfTwoArraysII solution;

    @BeforeEach
    void setUp() {
        solution = new IntersectionOfTwoArraysII();
    }

    @Nested
    @DisplayName("HashMap Approach Tests")
    class HashMapApproachTests {

        @Test
        @DisplayName("Basic example from problem description")
        void testBasicExample1() {
            int[] nums1 = {1, 2, 2, 1};
            int[] nums2 = {2, 2};
            int[] expected = {2, 2};
            int[] result = solution.intersectHashMap(nums1, nums2);

            assertTrue(IntersectionOfTwoArraysII.arraysEqual(result, expected),
                    "Expected: " + Arrays.toString(expected) + ", Got: " + Arrays.toString(result));
        }

        @Test
        @DisplayName("Basic example from problem description - second example")
        void testBasicExample2() {
            int[] nums1 = {4, 9, 5};
            int[] nums2 = {9, 4, 9, 8, 4};
            int[] result = solution.intersectHashMap(nums1, nums2);

            // Result should contain [4, 9] in any order
            assertTrue(result.length == 2);
            Arrays.sort(result);
            assertArrayEquals(new int[] {4, 9}, result);
        }

        @Test
        @DisplayName("No intersection")
        void testNoIntersection() {
            int[] nums1 = {1, 2, 3};
            int[] nums2 = {4, 5, 6};
            int[] result = solution.intersectHashMap(nums1, nums2);

            assertEquals(0, result.length);
        }

        @Test
        @DisplayName("Identical arrays")
        void testIdenticalArrays() {
            int[] nums1 = {1, 2, 3, 4, 5};
            int[] nums2 = {1, 2, 3, 4, 5};
            int[] result = solution.intersectHashMap(nums1, nums2);

            assertTrue(IntersectionOfTwoArraysII.arraysEqual(result, nums1));
        }

        @Test
        @DisplayName("One array is subset of another")
        void testSubsetArray() {
            int[] nums1 = {1, 2, 2, 3, 4};
            int[] nums2 = {2, 2};
            int[] expected = {2, 2};
            int[] result = solution.intersectHashMap(nums1, nums2);

            assertTrue(IntersectionOfTwoArraysII.arraysEqual(result, expected));
        }

        @Test
        @DisplayName("Single element arrays")
        void testSingleElement() {
            int[] nums1 = {1};
            int[] nums2 = {1};
            int[] expected = {1};
            int[] result = solution.intersectHashMap(nums1, nums2);

            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Single element - no match")
        void testSingleElementNoMatch() {
            int[] nums1 = {1};
            int[] nums2 = {2};
            int[] result = solution.intersectHashMap(nums1, nums2);

            assertEquals(0, result.length);
        }

        @Test
        @DisplayName("Arrays with duplicates")
        void testArraysWithDuplicates() {
            int[] nums1 = {1, 1, 1, 2, 2, 3};
            int[] nums2 = {1, 1, 2, 2, 2, 4};
            int[] result = solution.intersectHashMap(nums1, nums2);

            // Should contain [1, 1, 2, 2] in any order
            assertTrue(result.length == 4);
            Arrays.sort(result);
            assertArrayEquals(new int[] {1, 1, 2, 2}, result);
        }

        @Test
        @DisplayName("Large numbers")
        void testLargeNumbers() {
            int[] nums1 = {1000, 999, 998};
            int[] nums2 = {999, 998, 997};
            int[] result = solution.intersectHashMap(nums1, nums2);

            // Should contain [999, 998] in any order
            assertTrue(result.length == 2);
            Arrays.sort(result);
            assertArrayEquals(new int[] {998, 999}, result);
        }

        @Test
        @DisplayName("Zero values")
        void testZeroValues() {
            int[] nums1 = {0, 1, 0, 2};
            int[] nums2 = {0, 0, 3};
            int[] result = solution.intersectHashMap(nums1, nums2);

            // Should contain [0, 0] in any order
            assertTrue(result.length == 2);
            Arrays.sort(result);
            assertArrayEquals(new int[] {0, 0}, result);
        }
    }

    @Nested
    @DisplayName("Sorting Approach Tests")
    class SortingApproachTests {

        @Test
        @DisplayName("Basic example with sorting")
        void testBasicExample() {
            int[] nums1 = {1, 2, 2, 1};
            int[] nums2 = {2, 2};
            int[] expected = {2, 2};
            int[] result = solution.intersectSorting(nums1, nums2);

            assertTrue(IntersectionOfTwoArraysII.arraysEqual(result, expected));
        }

        @Test
        @DisplayName("Already sorted arrays")
        void testAlreadySorted() {
            int[] nums1 = {1, 2, 3, 4, 5};
            int[] nums2 = {2, 4, 6};
            int[] result = solution.intersectSorting(nums1, nums2);

            Arrays.sort(result);
            assertArrayEquals(new int[] {2, 4}, result);
        }

        @Test
        @DisplayName("Reverse sorted arrays")
        void testReverseSorted() {
            int[] nums1 = {5, 4, 3, 2, 1};
            int[] nums2 = {4, 2, 6};
            int[] result = solution.intersectSorting(nums1, nums2);

            Arrays.sort(result);
            assertArrayEquals(new int[] {2, 4}, result);
        }

        @Test
        @DisplayName("No intersection with sorting")
        void testNoIntersection() {
            int[] nums1 = {1, 3, 5};
            int[] nums2 = {2, 4, 6};
            int[] result = solution.intersectSorting(nums1, nums2);

            assertEquals(0, result.length);
        }
    }

    @Nested
    @DisplayName("Binary Search Approach Tests")
    class BinarySearchApproachTests {

        @Test
        @DisplayName("Basic example with binary search")
        void testBasicExample() {
            int[] nums1 = {1, 2, 2, 1};
            int[] nums2 = {2, 2};
            int[] expected = {2, 2};
            int[] result = solution.intersectBinarySearch(nums1, nums2);

            assertTrue(IntersectionOfTwoArraysII.arraysEqual(result, expected));
        }

        @Test
        @DisplayName("Large first array, small second array")
        void testLargeFirstArray() {
            int[] nums1 = {1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 5, 6, 7, 8, 9};
            int[] nums2 = {2, 3, 9};
            int[] result = solution.intersectBinarySearch(nums1, nums2);

            Arrays.sort(result);
            assertArrayEquals(new int[] {2, 3, 9}, result);
        }

        @Test
        @DisplayName("Multiple occurrences of same element")
        void testMultipleOccurrences() {
            int[] nums1 = {1, 1, 1, 1, 2, 2};
            int[] nums2 = {1, 1, 1, 2};
            int[] result = solution.intersectBinarySearch(nums1, nums2);

            Arrays.sort(result);
            assertArrayEquals(new int[] {1, 1, 1, 2}, result);
        }

        @Test
        @DisplayName("Element not found in first array")
        void testElementNotFound() {
            int[] nums1 = {1, 2, 3};
            int[] nums2 = {4, 5, 6};
            int[] result = solution.intersectBinarySearch(nums1, nums2);

            assertEquals(0, result.length);
        }
    }

    @Nested
    @DisplayName("Streams Approach Tests")
    class StreamsApproachTests {

        @Test
        @DisplayName("Basic example with streams")
        void testBasicExample() {
            int[] nums1 = {1, 2, 2, 1};
            int[] nums2 = {2, 2};
            int[] expected = {2, 2};
            int[] result = solution.intersectStreams(nums1, nums2);

            assertTrue(IntersectionOfTwoArraysII.arraysEqual(result, expected));
        }

        @Test
        @DisplayName("Complex frequency matching")
        void testComplexFrequencyMatching() {
            int[] nums1 = {1, 1, 2, 2, 2, 3};
            int[] nums2 = {1, 1, 1, 2, 2, 4};
            int[] result = solution.intersectStreams(nums1, nums2);

            Arrays.sort(result);
            assertArrayEquals(new int[] {1, 1, 2, 2}, result);
        }
    }

    @Nested
    @DisplayName("Optimized Approach Tests")
    class OptimizedApproachTests {

        @Test
        @DisplayName("Basic example with optimized approach")
        void testBasicExample() {
            int[] nums1 = {1, 2, 2, 1};
            int[] nums2 = {2, 2};
            int[] expected = {2, 2};
            int[] result = solution.intersectOptimized(nums1, nums2);

            assertTrue(IntersectionOfTwoArraysII.arraysEqual(result, expected));
        }

        @Test
        @DisplayName("Larger first array should use smaller array for counting")
        void testArraySizeOptimization() {
            int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            int[] nums2 = {2, 4, 6};
            int[] result = solution.intersectOptimized(nums1, nums2);

            Arrays.sort(result);
            assertArrayEquals(new int[] {2, 4, 6}, result);
        }
    }

    @Nested
    @DisplayName("Cross Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @Test
        @DisplayName("All approaches should produce same result")
        void testAllApproachesConsistency() {
            int[] nums1 = {1, 2, 2, 1, 3, 3, 3};
            int[] nums2 = {2, 2, 3, 3, 4, 5};

            int[] result1 = solution.intersectHashMap(nums1.clone(), nums2.clone());
            int[] result2 = solution.intersectSorting(nums1.clone(), nums2.clone());
            int[] result3 = solution.intersectBinarySearch(nums1.clone(), nums2.clone());
            int[] result4 = solution.intersectStreams(nums1.clone(), nums2.clone());
            int[] result5 = solution.intersectOptimized(nums1.clone(), nums2.clone());

            // All results should have the same frequency distribution
            assertTrue(IntersectionOfTwoArraysII.arraysEqual(result1, result2));
            assertTrue(IntersectionOfTwoArraysII.arraysEqual(result2, result3));
            assertTrue(IntersectionOfTwoArraysII.arraysEqual(result3, result4));
            assertTrue(IntersectionOfTwoArraysII.arraysEqual(result4, result5));
        }

        @Test
        @DisplayName("Edge case - empty arrays")
        void testEmptyArrays() {
            int[] nums1 = {};
            int[] nums2 = {1, 2, 3};

            int[] result1 = solution.intersectHashMap(nums1, nums2);
            int[] result2 = solution.intersectSorting(nums1, nums2);
            int[] result3 = solution.intersectBinarySearch(nums1, nums2);
            int[] result4 = solution.intersectStreams(nums1, nums2);
            int[] result5 = solution.intersectOptimized(nums1, nums2);

            assertEquals(0, result1.length);
            assertEquals(0, result2.length);
            assertEquals(0, result3.length);
            assertEquals(0, result4.length);
            assertEquals(0, result5.length);
        }

        @Test
        @DisplayName("Edge case - both arrays empty")
        void testBothArraysEmpty() {
            int[] nums1 = {};
            int[] nums2 = {};

            int[] result1 = solution.intersectHashMap(nums1, nums2);
            int[] result2 = solution.intersectSorting(nums1, nums2);
            int[] result3 = solution.intersectBinarySearch(nums1, nums2);
            int[] result4 = solution.intersectStreams(nums1, nums2);
            int[] result5 = solution.intersectOptimized(nums1, nums2);

            assertEquals(0, result1.length);
            assertEquals(0, result2.length);
            assertEquals(0, result3.length);
            assertEquals(0, result4.length);
            assertEquals(0, result5.length);
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Large arrays performance test")
        void testLargeArraysPerformance() {
            // Create large arrays with many duplicates
            int[] nums1 = new int[1000];
            int[] nums2 = new int[1000];

            for (int i = 0; i < 1000; i++) {
                nums1[i] = i % 100; // Values 0-99
                nums2[i] = (i + 50) % 100; // Values 50-99, 0-49
            }

            long startTime = System.nanoTime();
            int[] result = solution.intersectHashMap(nums1, nums2);
            long endTime = System.nanoTime();

            long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds

            // Should complete in reasonable time (less than 100ms)
            assertTrue(duration < 100, "HashMap approach took too long: " + duration + "ms");
            assertTrue(result.length > 0, "Should have intersection");
        }

        @Test
        @DisplayName("Maximum constraint test")
        void testMaximumConstraints() {
            // Test with maximum constraints: 1000 elements, values 0-1000
            int[] nums1 = new int[1000];
            int[] nums2 = new int[1000];

            for (int i = 0; i < 1000; i++) {
                nums1[i] = i;
                nums2[i] = 1000 - i;
            }

            int[] result = solution.intersectHashMap(nums1, nums2);

            // Should handle without errors
            assertNotNull(result);
        }
    }

    @Nested
    @DisplayName("Utility Method Tests")
    class UtilityMethodTests {

        @Test
        @DisplayName("Test arraysEqual method")
        void testArraysEqual() {
            int[] arr1 = {1, 2, 2, 3};
            int[] arr2 = {2, 1, 3, 2};
            int[] arr3 = {1, 2, 3};
            int[] arr4 = {1, 2, 2, 4};

            assertTrue(IntersectionOfTwoArraysII.arraysEqual(arr1, arr2));
            assertFalse(IntersectionOfTwoArraysII.arraysEqual(arr1, arr3));
            assertFalse(IntersectionOfTwoArraysII.arraysEqual(arr1, arr4));
        }

        @Test
        @DisplayName("Test arraysEqual with different frequencies")
        void testArraysEqualDifferentFrequencies() {
            int[] arr1 = {1, 1, 2};
            int[] arr2 = {1, 2, 2};

            assertFalse(IntersectionOfTwoArraysII.arraysEqual(arr1, arr2));
        }

        @Test
        @DisplayName("Test sortArray method")
        void testSortArray() {
            int[] arr = {3, 1, 4, 1, 5};
            int[] sorted = IntersectionOfTwoArraysII.sortArray(arr);
            int[] expected = {1, 1, 3, 4, 5};

            assertArrayEquals(expected, sorted);

            // Original array should be unchanged
            int[] original = {3, 1, 4, 1, 5};
            assertArrayEquals(original, arr);
        }
    }
}
