package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Comprehensive test suite for IntersectionOfTwoArrays
 * 
 * Tests all approaches with various edge cases and scenarios.
 */
public class IntersectionOfTwoArraysTest {

    private IntersectionOfTwoArrays solution;

    @BeforeEach
    void setUp() {
        solution = new IntersectionOfTwoArrays();
    }

    @Nested
    @DisplayName("HashSet Approach Tests")
    class HashSetApproachTests {

        @Test
        @DisplayName("Basic intersection with duplicates")
        void testBasicIntersectionWithDuplicates() {
            int[] nums1 = {1, 2, 2, 1};
            int[] nums2 = {2, 2};
            int[] expected = {2};
            int[] result = solution.intersectionHashSet(nums1, nums2);

            assertTrue(IntersectionOfTwoArrays.arraysEqual(expected, result));
        }

        @Test
        @DisplayName("Multiple common elements")
        void testMultipleCommonElements() {
            int[] nums1 = {4, 9, 5};
            int[] nums2 = {9, 4, 9, 8, 4};
            int[] result = solution.intersectionHashSet(nums1, nums2);

            // Result should contain 4 and 9 (order doesn't matter)
            assertEquals(2, result.length);
            assertTrue(Arrays.stream(result).anyMatch(x -> x == 4));
            assertTrue(Arrays.stream(result).anyMatch(x -> x == 9));
        }

        @Test
        @DisplayName("No intersection")
        void testNoIntersection() {
            int[] nums1 = {1, 2, 3};
            int[] nums2 = {4, 5, 6};
            int[] result = solution.intersectionHashSet(nums1, nums2);

            assertEquals(0, result.length);
        }

        @Test
        @DisplayName("Identical arrays")
        void testIdenticalArrays() {
            int[] nums1 = {1, 2, 3};
            int[] nums2 = {1, 2, 3};
            int[] result = solution.intersectionHashSet(nums1, nums2);

            assertEquals(3, result.length);
            assertTrue(Arrays.stream(result).anyMatch(x -> x == 1));
            assertTrue(Arrays.stream(result).anyMatch(x -> x == 2));
            assertTrue(Arrays.stream(result).anyMatch(x -> x == 3));
        }

        @Test
        @DisplayName("Single element arrays")
        void testSingleElementArrays() {
            int[] nums1 = {1};
            int[] nums2 = {1};
            int[] result = solution.intersectionHashSet(nums1, nums2);

            assertEquals(1, result.length);
            assertEquals(1, result[0]);
        }

        @Test
        @DisplayName("One array is subset of another")
        void testOneArraySubset() {
            int[] nums1 = {1, 2, 3, 4, 5};
            int[] nums2 = {3, 4};
            int[] result = solution.intersectionHashSet(nums1, nums2);

            assertEquals(2, result.length);
            assertTrue(Arrays.stream(result).anyMatch(x -> x == 3));
            assertTrue(Arrays.stream(result).anyMatch(x -> x == 4));
        }
    }

    @Nested
    @DisplayName("Two Pointers Approach Tests")
    class TwoPointersApproachTests {

        @Test
        @DisplayName("Basic intersection with two pointers")
        void testBasicIntersectionTwoPointers() {
            int[] nums1 = {1, 2, 2, 1};
            int[] nums2 = {2, 2};
            int[] expected = {2};
            int[] result = solution.intersectionTwoPointers(nums1, nums2);

            assertTrue(IntersectionOfTwoArrays.arraysEqual(expected, result));
        }

        @Test
        @DisplayName("Multiple elements with two pointers")
        void testMultipleElementsTwoPointers() {
            int[] nums1 = {4, 9, 5};
            int[] nums2 = {9, 4, 9, 8, 4};
            int[] result = solution.intersectionTwoPointers(nums1, nums2);

            assertEquals(2, result.length);
            assertTrue(Arrays.stream(result).anyMatch(x -> x == 4));
            assertTrue(Arrays.stream(result).anyMatch(x -> x == 9));
        }

        @Test
        @DisplayName("No intersection with two pointers")
        void testNoIntersectionTwoPointers() {
            int[] nums1 = {1, 2, 3};
            int[] nums2 = {4, 5, 6};
            int[] result = solution.intersectionTwoPointers(nums1, nums2);

            assertEquals(0, result.length);
        }
    }

    @Nested
    @DisplayName("Binary Search Approach Tests")
    class BinarySearchApproachTests {

        @Test
        @DisplayName("Basic intersection with binary search")
        void testBasicIntersectionBinarySearch() {
            int[] nums1 = {1, 2, 2, 1};
            int[] nums2 = {2, 2};
            int[] expected = {2};
            int[] result = solution.intersectionBinarySearch(nums1, nums2);

            assertTrue(IntersectionOfTwoArrays.arraysEqual(expected, result));
        }

        @Test
        @DisplayName("Multiple elements with binary search")
        void testMultipleElementsBinarySearch() {
            int[] nums1 = {4, 9, 5};
            int[] nums2 = {9, 4, 9, 8, 4};
            int[] result = solution.intersectionBinarySearch(nums1, nums2);

            assertEquals(2, result.length);
            assertTrue(Arrays.stream(result).anyMatch(x -> x == 4));
            assertTrue(Arrays.stream(result).anyMatch(x -> x == 9));
        }
    }

    @Nested
    @DisplayName("Streams Approach Tests")
    class StreamsApproachTests {

        @Test
        @DisplayName("Basic intersection with streams")
        void testBasicIntersectionStreams() {
            int[] nums1 = {1, 2, 2, 1};
            int[] nums2 = {2, 2};
            int[] expected = {2};
            int[] result = solution.intersectionStreams(nums1, nums2);

            assertTrue(IntersectionOfTwoArrays.arraysEqual(expected, result));
        }

        @Test
        @DisplayName("Multiple elements with streams")
        void testMultipleElementsStreams() {
            int[] nums1 = {4, 9, 5};
            int[] nums2 = {9, 4, 9, 8, 4};
            int[] result = solution.intersectionStreams(nums1, nums2);

            assertEquals(2, result.length);
            assertTrue(Arrays.stream(result).anyMatch(x -> x == 4));
            assertTrue(Arrays.stream(result).anyMatch(x -> x == 9));
        }
    }

    @Nested
    @DisplayName("Optimized Approach Tests")
    class OptimizedApproachTests {

        @Test
        @DisplayName("Basic intersection with optimized approach")
        void testBasicIntersectionOptimized() {
            int[] nums1 = {1, 2, 2, 1};
            int[] nums2 = {2, 2};
            int[] expected = {2};
            int[] result = solution.intersectionOptimized(nums1, nums2);

            assertTrue(IntersectionOfTwoArrays.arraysEqual(expected, result));
        }

        @Test
        @DisplayName("Optimized with smaller first array")
        void testOptimizedSmallerFirstArray() {
            int[] nums1 = {2, 2};
            int[] nums2 = {1, 2, 2, 1};
            int[] expected = {2};
            int[] result = solution.intersectionOptimized(nums1, nums2);

            assertTrue(IntersectionOfTwoArrays.arraysEqual(expected, result));
        }
    }

    @Nested
    @DisplayName("Edge Case Tests")
    class EdgeCaseTests {

        @Test
        @DisplayName("Empty arrays")
        void testEmptyArrays() {
            int[] nums1 = {};
            int[] nums2 = {};
            int[] result = solution.intersectionHashSet(nums1, nums2);

            assertEquals(0, result.length);
        }

        @Test
        @DisplayName("One empty array")
        void testOneEmptyArray() {
            int[] nums1 = {1, 2, 3};
            int[] nums2 = {};
            int[] result = solution.intersectionHashSet(nums1, nums2);

            assertEquals(0, result.length);
        }

        @Test
        @DisplayName("Arrays with zeros")
        void testArraysWithZeros() {
            int[] nums1 = {0, 1, 2};
            int[] nums2 = {0, 2, 3};
            int[] result = solution.intersectionHashSet(nums1, nums2);

            assertEquals(2, result.length);
            assertTrue(Arrays.stream(result).anyMatch(x -> x == 0));
            assertTrue(Arrays.stream(result).anyMatch(x -> x == 2));
        }

        @Test
        @DisplayName("Large numbers")
        void testLargeNumbers() {
            int[] nums1 = {1000, 999, 998};
            int[] nums2 = {999, 1000, 997};
            int[] result = solution.intersectionHashSet(nums1, nums2);

            assertEquals(2, result.length);
            assertTrue(Arrays.stream(result).anyMatch(x -> x == 999));
            assertTrue(Arrays.stream(result).anyMatch(x -> x == 1000));
        }

        @Test
        @DisplayName("All same elements")
        void testAllSameElements() {
            int[] nums1 = {1, 1, 1, 1};
            int[] nums2 = {1, 1, 1};
            int[] result = solution.intersectionHashSet(nums1, nums2);

            assertEquals(1, result.length);
            assertEquals(1, result[0]);
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Large arrays performance test")
        void testLargeArraysPerformance() {
            // Create large arrays with some intersection
            int[] nums1 = new int[1000];
            int[] nums2 = new int[1000];

            for (int i = 0; i < 1000; i++) {
                nums1[i] = i;
                nums2[i] = i + 500; // nums2 starts from 500, so intersection is 500-999
            }

            long startTime = System.nanoTime();
            int[] result = solution.intersectionHashSet(nums1, nums2);
            long endTime = System.nanoTime();

            assertEquals(500, result.length);
            System.out.println(
                    "Large arrays test took: " + (endTime - startTime) / 1_000_000 + " ms");
        }
    }

    @Nested
    @DisplayName("Cross Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @Test
        @DisplayName("All approaches should produce same result")
        void testAllApproachesSameResult() {
            int[] nums1 = {4, 9, 5, 1, 2, 2, 1};
            int[] nums2 = {9, 4, 9, 8, 4, 2, 2};

            int[] result1 = solution.intersectionHashSet(nums1, nums2);
            int[] result2 = solution.intersectionTwoPointers(nums1, nums2);
            int[] result3 = solution.intersectionBinarySearch(nums1, nums2);
            int[] result4 = solution.intersectionStreams(nums1, nums2);
            int[] result5 = solution.intersectionOptimized(nums1, nums2);
            int[] result6 = solution.intersectionBuiltInBinarySearch(nums1, nums2);

            // All results should have same length
            assertEquals(result1.length, result2.length);
            assertEquals(result1.length, result3.length);
            assertEquals(result1.length, result4.length);
            assertEquals(result1.length, result5.length);
            assertEquals(result1.length, result6.length);

            // All results should contain the same elements
            Arrays.sort(result1);
            Arrays.sort(result2);
            Arrays.sort(result3);
            Arrays.sort(result4);
            Arrays.sort(result5);
            Arrays.sort(result6);

            assertArrayEquals(result1, result2);
            assertArrayEquals(result1, result3);
            assertArrayEquals(result1, result4);
            assertArrayEquals(result1, result5);
            assertArrayEquals(result1, result6);
        }
    }

    @Nested
    @DisplayName("Utility Method Tests")
    class UtilityMethodTests {

        @Test
        @DisplayName("Test arraysEqual utility method")
        void testArraysEqualUtility() {
            int[] arr1 = {1, 2, 3};
            int[] arr2 = {3, 1, 2};
            int[] arr3 = {1, 2, 4};

            assertTrue(IntersectionOfTwoArrays.arraysEqual(arr1, arr2));
            assertFalse(IntersectionOfTwoArrays.arraysEqual(arr1, arr3));
        }

        @Test
        @DisplayName("Test printArray utility method")
        void testPrintArrayUtility() {
            int[] arr = {1, 2, 3};
            // This test mainly ensures the method doesn't throw an exception
            assertDoesNotThrow(() -> IntersectionOfTwoArrays.printArray(arr));
        }
    }
}
