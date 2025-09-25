package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Comprehensive test suite for ContainsDuplicateII LeetCode problem
 * 
 * Tests all implemented approaches with various edge cases and scenarios
 */
class ContainsDuplicateIITest {

    @Nested
    @DisplayName("Sliding Window Approach Tests")
    class SlidingWindowApproachTests {

        @Test
        @DisplayName("Should return true for duplicates within distance k")
        void testDuplicatesWithinDistance() {
            int[] nums = {1, 2, 3, 1};
            int k = 3;
            assertTrue(ContainsDuplicateII.containsNearbyDuplicateSlidingWindow(nums, k));
        }

        @Test
        @DisplayName("Should return true for adjacent duplicates")
        void testAdjacentDuplicates() {
            int[] nums = {1, 0, 1, 1};
            int k = 1;
            assertTrue(ContainsDuplicateII.containsNearbyDuplicateSlidingWindow(nums, k));
        }

        @Test
        @DisplayName("Should return false when duplicates are beyond distance k")
        void testDuplicatesBeyondDistance() {
            int[] nums = {1, 2, 3, 1, 2, 3};
            int k = 2;
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateSlidingWindow(nums, k));
        }

        @Test
        @DisplayName("Should return false for single element array")
        void testSingleElementArray() {
            int[] nums = {5};
            int k = 1;
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateSlidingWindow(nums, k));
        }

        @Test
        @DisplayName("Should return false for empty array")
        void testEmptyArray() {
            int[] nums = {};
            int k = 1;
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateSlidingWindow(nums, k));
        }

        @Test
        @DisplayName("Should return false for null array")
        void testNullArray() {
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateSlidingWindow(null, 1));
        }

        @Test
        @DisplayName("Should return false for negative k")
        void testNegativeK() {
            int[] nums = {1, 2, 3, 1};
            int k = -1;
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateSlidingWindow(nums, k));
        }

        @Test
        @DisplayName("Should return false when k is 0")
        void testKIsZero() {
            int[] nums = {1, 1, 2, 3};
            int k = 0;
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateSlidingWindow(nums, k));
        }

        @Test
        @DisplayName("Should handle negative numbers")
        void testNegativeNumbers() {
            int[] nums = {-1, -2, -1, -3};
            int k = 2;
            assertTrue(ContainsDuplicateII.containsNearbyDuplicateSlidingWindow(nums, k));
        }

        @Test
        @DisplayName("Should handle zero")
        void testZero() {
            int[] nums = {0, 1, 0};
            int k = 2;
            assertTrue(ContainsDuplicateII.containsNearbyDuplicateSlidingWindow(nums, k));
        }

        @Test
        @DisplayName("Should handle large numbers")
        void testLargeNumbers() {
            int[] nums = {1000000000, -1000000000, 1000000000};
            int k = 2;
            assertTrue(ContainsDuplicateII.containsNearbyDuplicateSlidingWindow(nums, k));
        }
    }

    @Nested
    @DisplayName("HashMap Approach Tests")
    class HashMapApproachTests {

        @Test
        @DisplayName("Should return true for duplicates within distance k")
        void testDuplicatesWithinDistance() {
            int[] nums = {1, 2, 3, 1};
            int k = 3;
            assertTrue(ContainsDuplicateII.containsNearbyDuplicateHashMap(nums, k));
        }

        @Test
        @DisplayName("Should return true for adjacent duplicates")
        void testAdjacentDuplicates() {
            int[] nums = {1, 0, 1, 1};
            int k = 1;
            assertTrue(ContainsDuplicateII.containsNearbyDuplicateHashMap(nums, k));
        }

        @Test
        @DisplayName("Should return false when duplicates are beyond distance k")
        void testDuplicatesBeyondDistance() {
            int[] nums = {1, 2, 3, 1, 2, 3};
            int k = 2;
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateHashMap(nums, k));
        }

        @Test
        @DisplayName("Should return false for single element array")
        void testSingleElementArray() {
            int[] nums = {5};
            int k = 1;
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateHashMap(nums, k));
        }

        @Test
        @DisplayName("Should return false for empty array")
        void testEmptyArray() {
            int[] nums = {};
            int k = 1;
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateHashMap(nums, k));
        }

        @Test
        @DisplayName("Should return false for null array")
        void testNullArray() {
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateHashMap(null, 1));
        }

        @Test
        @DisplayName("Should return false for negative k")
        void testNegativeK() {
            int[] nums = {1, 2, 3, 1};
            int k = -1;
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateHashMap(nums, k));
        }

        @Test
        @DisplayName("Should return false when k is 0")
        void testKIsZero() {
            int[] nums = {1, 1, 2, 3};
            int k = 0;
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateHashMap(nums, k));
        }

        @Test
        @DisplayName("Should handle negative numbers")
        void testNegativeNumbers() {
            int[] nums = {-1, -2, -1, -3};
            int k = 2;
            assertTrue(ContainsDuplicateII.containsNearbyDuplicateHashMap(nums, k));
        }

        @Test
        @DisplayName("Should handle zero")
        void testZero() {
            int[] nums = {0, 1, 0};
            int k = 2;
            assertTrue(ContainsDuplicateII.containsNearbyDuplicateHashMap(nums, k));
        }

        @Test
        @DisplayName("Should handle large numbers")
        void testLargeNumbers() {
            int[] nums = {1000000000, -1000000000, 1000000000};
            int k = 2;
            assertTrue(ContainsDuplicateII.containsNearbyDuplicateHashMap(nums, k));
        }
    }

    @Nested
    @DisplayName("Brute Force Approach Tests")
    class BruteForceApproachTests {

        @Test
        @DisplayName("Should return true for duplicates within distance k")
        void testDuplicatesWithinDistance() {
            int[] nums = {1, 2, 3, 1};
            int k = 3;
            assertTrue(ContainsDuplicateII.containsNearbyDuplicateBruteForce(nums, k));
        }

        @Test
        @DisplayName("Should return true for adjacent duplicates")
        void testAdjacentDuplicates() {
            int[] nums = {1, 0, 1, 1};
            int k = 1;
            assertTrue(ContainsDuplicateII.containsNearbyDuplicateBruteForce(nums, k));
        }

        @Test
        @DisplayName("Should return false when duplicates are beyond distance k")
        void testDuplicatesBeyondDistance() {
            int[] nums = {1, 2, 3, 1, 2, 3};
            int k = 2;
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateBruteForce(nums, k));
        }

        @Test
        @DisplayName("Should return false for single element array")
        void testSingleElementArray() {
            int[] nums = {5};
            int k = 1;
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateBruteForce(nums, k));
        }

        @Test
        @DisplayName("Should return false for empty array")
        void testEmptyArray() {
            int[] nums = {};
            int k = 1;
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateBruteForce(nums, k));
        }

        @Test
        @DisplayName("Should return false for null array")
        void testNullArray() {
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateBruteForce(null, 1));
        }

        @Test
        @DisplayName("Should return false for negative k")
        void testNegativeK() {
            int[] nums = {1, 2, 3, 1};
            int k = -1;
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateBruteForce(nums, k));
        }

        @Test
        @DisplayName("Should return false when k is 0")
        void testKIsZero() {
            int[] nums = {1, 1, 2, 3};
            int k = 0;
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateBruteForce(nums, k));
        }
    }

    @Nested
    @DisplayName("Optimized Approach Tests")
    class OptimizedApproachTests {

        @Test
        @DisplayName("Should return true for duplicates within distance k")
        void testDuplicatesWithinDistance() {
            int[] nums = {1, 2, 3, 1};
            int k = 3;
            assertTrue(ContainsDuplicateII.containsNearbyDuplicateOptimized(nums, k));
        }

        @Test
        @DisplayName("Should return true for adjacent duplicates")
        void testAdjacentDuplicates() {
            int[] nums = {1, 0, 1, 1};
            int k = 1;
            assertTrue(ContainsDuplicateII.containsNearbyDuplicateOptimized(nums, k));
        }

        @Test
        @DisplayName("Should return false when duplicates are beyond distance k")
        void testDuplicatesBeyondDistance() {
            int[] nums = {1, 2, 3, 1, 2, 3};
            int k = 2;
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateOptimized(nums, k));
        }

        @Test
        @DisplayName("Should return false for single element array")
        void testSingleElementArray() {
            int[] nums = {5};
            int k = 1;
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateOptimized(nums, k));
        }

        @Test
        @DisplayName("Should return false for empty array")
        void testEmptyArray() {
            int[] nums = {};
            int k = 1;
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateOptimized(nums, k));
        }

        @Test
        @DisplayName("Should return false for null array")
        void testNullArray() {
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateOptimized(null, 1));
        }

        @Test
        @DisplayName("Should return false for negative k")
        void testNegativeK() {
            int[] nums = {1, 2, 3, 1};
            int k = -1;
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateOptimized(nums, k));
        }

        @Test
        @DisplayName("Should return false when k is 0")
        void testKIsZero() {
            int[] nums = {1, 1, 2, 3};
            int k = 0;
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateOptimized(nums, k));
        }
    }

    @Nested
    @DisplayName("Array Window Approach Tests")
    class ArrayWindowApproachTests {

        @Test
        @DisplayName("Should return true for duplicates within distance k")
        void testDuplicatesWithinDistance() {
            int[] nums = {1, 2, 3, 1};
            int k = 3;
            assertTrue(ContainsDuplicateII.containsNearbyDuplicateArrayWindow(nums, k));
        }

        @Test
        @DisplayName("Should return true for adjacent duplicates")
        void testAdjacentDuplicates() {
            int[] nums = {1, 0, 1, 1};
            int k = 1;
            assertTrue(ContainsDuplicateII.containsNearbyDuplicateArrayWindow(nums, k));
        }

        @Test
        @DisplayName("Should return false when duplicates are beyond distance k")
        void testDuplicatesBeyondDistance() {
            int[] nums = {1, 2, 3, 1, 2, 3};
            int k = 2;
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateArrayWindow(nums, k));
        }

        @Test
        @DisplayName("Should return false for single element array")
        void testSingleElementArray() {
            int[] nums = {5};
            int k = 1;
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateArrayWindow(nums, k));
        }

        @Test
        @DisplayName("Should return false for empty array")
        void testEmptyArray() {
            int[] nums = {};
            int k = 1;
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateArrayWindow(nums, k));
        }

        @Test
        @DisplayName("Should return false for null array")
        void testNullArray() {
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateArrayWindow(null, 1));
        }

        @Test
        @DisplayName("Should return false for negative k")
        void testNegativeK() {
            int[] nums = {1, 2, 3, 1};
            int k = -1;
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateArrayWindow(nums, k));
        }

        @Test
        @DisplayName("Should return false when k is 0")
        void testKIsZero() {
            int[] nums = {1, 1, 2, 3};
            int k = 0;
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateArrayWindow(nums, k));
        }
    }

    @Nested
    @DisplayName("Cross Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @ParameterizedTest
        @MethodSource("provideTestCases")
        @DisplayName("All approaches should return same result")
        void testAllApproachesReturnSameResult(int[] nums, int k, boolean expected) {
            assertEquals(expected,
                    ContainsDuplicateII.containsNearbyDuplicateSlidingWindow(nums.clone(), k));
            assertEquals(expected,
                    ContainsDuplicateII.containsNearbyDuplicateHashMap(nums.clone(), k));
            assertEquals(expected,
                    ContainsDuplicateII.containsNearbyDuplicateBruteForce(nums.clone(), k));
            assertEquals(expected,
                    ContainsDuplicateII.containsNearbyDuplicateOptimized(nums.clone(), k));
            assertEquals(expected,
                    ContainsDuplicateII.containsNearbyDuplicateArrayWindow(nums.clone(), k));
        }

        static Stream<Arguments> provideTestCases() {
            return Stream.of(Arguments.of(new int[] {1, 2, 3, 1}, 3, true),
                    Arguments.of(new int[] {1, 0, 1, 1}, 1, true),
                    Arguments.of(new int[] {1, 2, 3, 1, 2, 3}, 2, false),
                    Arguments.of(new int[] {5}, 1, false), Arguments.of(new int[] {}, 1, false),
                    Arguments.of(new int[] {-1, -2, -1, -3}, 2, true),
                    Arguments.of(new int[] {0, 1, 0}, 2, true),
                    Arguments.of(new int[] {1000000000, -1000000000, 1000000000}, 2, true),
                    Arguments.of(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5, false),
                    Arguments.of(new int[] {1, 1}, 1, true),
                    Arguments.of(new int[] {2, 14, 18, 22, 22}, 1, true),
                    Arguments.of(new int[] {3, 3, 3, 3, 3}, 2, true),
                    Arguments.of(new int[] {1, 2, 3, 4, 5, 1}, 5, true),
                    Arguments.of(new int[] {1, 2, 3, 4, 5, 1}, 4, false),
                    Arguments.of(new int[] {1, 2, 1, 3, 4, 5}, 2, true),
                    Arguments.of(new int[] {1, 2, 1, 3, 4, 5}, 1, false));
        }
    }

    @Nested
    @DisplayName("Edge Case Tests")
    class EdgeCaseTests {

        @Test
        @DisplayName("Should handle k equals array length minus 1")
        void testKEqualsArrayLengthMinusOne() {
            int[] nums = {1, 2, 3, 4, 5, 1};
            int k = 5; // nums.length - 1
            assertTrue(ContainsDuplicateII.containsNearbyDuplicateSlidingWindow(nums, k));
        }

        @Test
        @DisplayName("Should handle k equals array length")
        void testKEqualsArrayLength() {
            int[] nums = {1, 2, 3, 4, 5, 1};
            int k = 6; // nums.length
            assertTrue(ContainsDuplicateII.containsNearbyDuplicateSlidingWindow(nums, k));
        }

        @Test
        @DisplayName("Should handle k greater than array length")
        void testKGreaterThanArrayLength() {
            int[] nums = {1, 2, 3, 4, 5, 1};
            int k = 10; // > nums.length
            assertTrue(ContainsDuplicateII.containsNearbyDuplicateSlidingWindow(nums, k));
        }

        @Test
        @DisplayName("Should handle all same elements with small k")
        void testAllSameElementsSmallK() {
            int[] nums = {5, 5, 5, 5, 5};
            int k = 1;
            assertTrue(ContainsDuplicateII.containsNearbyDuplicateSlidingWindow(nums, k));
        }

        @Test
        @DisplayName("Should handle all same elements with k=0")
        void testAllSameElementsKZero() {
            int[] nums = {5, 5, 5, 5, 5};
            int k = 0;
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateSlidingWindow(nums, k));
        }

        @Test
        @DisplayName("Should handle duplicate at the end")
        void testDuplicateAtEnd() {
            int[] nums = {1, 2, 3, 4, 5, 1};
            int k = 5;
            assertTrue(ContainsDuplicateII.containsNearbyDuplicateSlidingWindow(nums, k));
        }

        @Test
        @DisplayName("Should handle duplicate at the beginning")
        void testDuplicateAtBeginning() {
            int[] nums = {1, 1, 2, 3, 4, 5};
            int k = 1;
            assertTrue(ContainsDuplicateII.containsNearbyDuplicateSlidingWindow(nums, k));
        }

        @Test
        @DisplayName("Should handle duplicate in the middle")
        void testDuplicateInMiddle() {
            int[] nums = {1, 2, 2, 3, 4, 5};
            int k = 1;
            assertTrue(ContainsDuplicateII.containsNearbyDuplicateSlidingWindow(nums, k));
        }

        @Test
        @DisplayName("Should handle two element array with duplicates")
        void testTwoElementsWithDuplicates() {
            int[] nums = {1, 1};
            int k = 1;
            assertTrue(ContainsDuplicateII.containsNearbyDuplicateSlidingWindow(nums, k));
        }

        @Test
        @DisplayName("Should handle two element array without duplicates")
        void testTwoElementsWithoutDuplicates() {
            int[] nums = {1, 2};
            int k = 1;
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateSlidingWindow(nums, k));
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Should handle large array efficiently")
        void testLargeArray() {
            // Create a large array with duplicates
            int[] largeArray = new int[10000];
            for (int i = 0; i < largeArray.length; i++) {
                largeArray[i] = i % 1000; // This creates duplicates
            }

            // All approaches should handle this efficiently
            assertTrue(ContainsDuplicateII.containsNearbyDuplicateSlidingWindow(largeArray, 1000));
            assertTrue(ContainsDuplicateII.containsNearbyDuplicateHashMap(largeArray, 1000));
            assertTrue(ContainsDuplicateII.containsNearbyDuplicateOptimized(largeArray, 1000));
            assertTrue(ContainsDuplicateII.containsNearbyDuplicateArrayWindow(largeArray, 1000));
        }

        @Test
        @DisplayName("Should handle large array without nearby duplicates")
        void testLargeArrayNoNearbyDuplicates() {
            // Create a large array without nearby duplicates
            int[] largeArray = new int[10000];
            for (int i = 0; i < largeArray.length; i++) {
                largeArray[i] = i;
            }

            // All approaches should return false for small k
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateSlidingWindow(largeArray, 5));
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateHashMap(largeArray, 5));
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateOptimized(largeArray, 5));
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateArrayWindow(largeArray, 5));
        }
    }

    @Nested
    @DisplayName("Parameterized Tests")
    class ParameterizedTests {

        @ParameterizedTest
        @ValueSource(ints = {0, 1, 2, 3, 4, 5, 10, 100})
        @DisplayName("Should handle different k values")
        void testDifferentKValues(int k) {
            int[] nums = {1, 2, 1, 3, 4, 5};
            // For k >= 2, we should find duplicates (indices 0 and 2 have distance 2)
            boolean expected = k >= 2;
            assertEquals(expected,
                    ContainsDuplicateII.containsNearbyDuplicateSlidingWindow(nums, k));
        }

        @ParameterizedTest
        @ValueSource(ints = {-1000000000, -1, 0, 1, 1000000000})
        @DisplayName("Should handle boundary values")
        void testBoundaryValues(int value) {
            int[] nums = {value, 0, value};
            int k = 2;
            assertTrue(ContainsDuplicateII.containsNearbyDuplicateSlidingWindow(nums, k));
        }
    }

    @Nested
    @DisplayName("Utility Method Tests")
    class UtilityMethodTests {

        @Test
        @DisplayName("Should handle arrays with mixed positive and negative numbers")
        void testMixedPositiveNegative() {
            int[] nums = {-5, -3, -1, 0, 1, 3, 5, -5};
            int k = 7;
            assertTrue(ContainsDuplicateII.containsNearbyDuplicateSlidingWindow(nums, k));
        }

        @Test
        @DisplayName("Should handle arrays with zero and negative numbers")
        void testZeroAndNegative() {
            int[] nums = {0, -1, 0, -2};
            int k = 2;
            assertTrue(ContainsDuplicateII.containsNearbyDuplicateSlidingWindow(nums, k));
        }

        @Test
        @DisplayName("Should handle arrays with consecutive numbers")
        void testConsecutiveNumbers() {
            int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            int k = 5;
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateSlidingWindow(nums, k));
        }

        @Test
        @DisplayName("Should handle arrays with non-consecutive numbers")
        void testNonConsecutiveNumbers() {
            int[] nums = {2, 14, 18, 22, 25, 30};
            int k = 3;
            assertFalse(ContainsDuplicateII.containsNearbyDuplicateSlidingWindow(nums, k));
        }

        @Test
        @DisplayName("Should handle sliding window edge cases")
        void testSlidingWindowEdgeCases() {
            int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1};
            int k = 9; // Should find duplicate at indices 0 and 9
            assertTrue(ContainsDuplicateII.containsNearbyDuplicateSlidingWindow(nums, k));
        }
    }
}
