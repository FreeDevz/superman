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
 * Comprehensive test suite for ContainsDuplicate LeetCode problem
 * 
 * Tests all implemented approaches with various edge cases and scenarios
 */
class ContainsDuplicateTest {

    @Nested
    @DisplayName("HashSet Approach Tests")
    class HashSetApproachTests {

        @Test
        @DisplayName("Should return true for array with duplicates")
        void testContainsDuplicateWithDuplicates() {
            int[] nums = {1, 2, 3, 1};
            assertTrue(ContainsDuplicate.containsDuplicateHashSet(nums));
        }

        @Test
        @DisplayName("Should return false for array without duplicates")
        void testContainsDuplicateWithoutDuplicates() {
            int[] nums = {1, 2, 3, 4};
            assertFalse(ContainsDuplicate.containsDuplicateHashSet(nums));
        }

        @Test
        @DisplayName("Should return true for array with multiple duplicates")
        void testContainsDuplicateWithMultipleDuplicates() {
            int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
            assertTrue(ContainsDuplicate.containsDuplicateHashSet(nums));
        }

        @Test
        @DisplayName("Should return false for single element array")
        void testSingleElementArray() {
            int[] nums = {5};
            assertFalse(ContainsDuplicate.containsDuplicateHashSet(nums));
        }

        @Test
        @DisplayName("Should return false for empty array")
        void testEmptyArray() {
            int[] nums = {};
            assertFalse(ContainsDuplicate.containsDuplicateHashSet(nums));
        }

        @Test
        @DisplayName("Should return false for null array")
        void testNullArray() {
            assertFalse(ContainsDuplicate.containsDuplicateHashSet(null));
        }

        @Test
        @DisplayName("Should handle negative numbers")
        void testNegativeNumbers() {
            int[] nums = {-1, -2, -1, -3};
            assertTrue(ContainsDuplicate.containsDuplicateHashSet(nums));
        }

        @Test
        @DisplayName("Should handle zero")
        void testZero() {
            int[] nums = {0, 1, 0};
            assertTrue(ContainsDuplicate.containsDuplicateHashSet(nums));
        }

        @Test
        @DisplayName("Should handle large numbers")
        void testLargeNumbers() {
            int[] nums = {1000000000, -1000000000, 1000000000};
            assertTrue(ContainsDuplicate.containsDuplicateHashSet(nums));
        }
    }

    @Nested
    @DisplayName("Sorting Approach Tests")
    class SortingApproachTests {

        @Test
        @DisplayName("Should return true for array with duplicates")
        void testContainsDuplicateWithDuplicates() {
            int[] nums = {1, 2, 3, 1};
            assertTrue(ContainsDuplicate.containsDuplicateSorting(nums));
        }

        @Test
        @DisplayName("Should return false for array without duplicates")
        void testContainsDuplicateWithoutDuplicates() {
            int[] nums = {1, 2, 3, 4};
            assertFalse(ContainsDuplicate.containsDuplicateSorting(nums));
        }

        @Test
        @DisplayName("Should return true for array with multiple duplicates")
        void testContainsDuplicateWithMultipleDuplicates() {
            int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
            assertTrue(ContainsDuplicate.containsDuplicateSorting(nums));
        }

        @Test
        @DisplayName("Should return false for single element array")
        void testSingleElementArray() {
            int[] nums = {5};
            assertFalse(ContainsDuplicate.containsDuplicateSorting(nums));
        }

        @Test
        @DisplayName("Should return false for empty array")
        void testEmptyArray() {
            int[] nums = {};
            assertFalse(ContainsDuplicate.containsDuplicateSorting(nums));
        }

        @Test
        @DisplayName("Should return false for null array")
        void testNullArray() {
            assertFalse(ContainsDuplicate.containsDuplicateSorting(null));
        }

        @Test
        @DisplayName("Should handle negative numbers")
        void testNegativeNumbers() {
            int[] nums = {-1, -2, -1, -3};
            assertTrue(ContainsDuplicate.containsDuplicateSorting(nums));
        }

        @Test
        @DisplayName("Should handle zero")
        void testZero() {
            int[] nums = {0, 1, 0};
            assertTrue(ContainsDuplicate.containsDuplicateSorting(nums));
        }

        @Test
        @DisplayName("Should handle large numbers")
        void testLargeNumbers() {
            int[] nums = {1000000000, -1000000000, 1000000000};
            assertTrue(ContainsDuplicate.containsDuplicateSorting(nums));
        }
    }

    @Nested
    @DisplayName("Stream Approach Tests")
    class StreamApproachTests {

        @Test
        @DisplayName("Should return true for array with duplicates")
        void testContainsDuplicateWithDuplicates() {
            int[] nums = {1, 2, 3, 1};
            assertTrue(ContainsDuplicate.containsDuplicateStream(nums));
        }

        @Test
        @DisplayName("Should return false for array without duplicates")
        void testContainsDuplicateWithoutDuplicates() {
            int[] nums = {1, 2, 3, 4};
            assertFalse(ContainsDuplicate.containsDuplicateStream(nums));
        }

        @Test
        @DisplayName("Should return true for array with multiple duplicates")
        void testContainsDuplicateWithMultipleDuplicates() {
            int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
            assertTrue(ContainsDuplicate.containsDuplicateStream(nums));
        }

        @Test
        @DisplayName("Should return false for single element array")
        void testSingleElementArray() {
            int[] nums = {5};
            assertFalse(ContainsDuplicate.containsDuplicateStream(nums));
        }

        @Test
        @DisplayName("Should return false for empty array")
        void testEmptyArray() {
            int[] nums = {};
            assertFalse(ContainsDuplicate.containsDuplicateStream(nums));
        }

        @Test
        @DisplayName("Should return false for null array")
        void testNullArray() {
            assertFalse(ContainsDuplicate.containsDuplicateStream(null));
        }
    }

    @Nested
    @DisplayName("Enhanced HashSet Approach Tests")
    class EnhancedHashSetApproachTests {

        @Test
        @DisplayName("Should return true for array with duplicates")
        void testContainsDuplicateWithDuplicates() {
            int[] nums = {1, 2, 3, 1};
            assertTrue(ContainsDuplicate.containsDuplicateEnhanced(nums));
        }

        @Test
        @DisplayName("Should return false for array without duplicates")
        void testContainsDuplicateWithoutDuplicates() {
            int[] nums = {1, 2, 3, 4};
            assertFalse(ContainsDuplicate.containsDuplicateEnhanced(nums));
        }

        @Test
        @DisplayName("Should return true for array with multiple duplicates")
        void testContainsDuplicateWithMultipleDuplicates() {
            int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
            assertTrue(ContainsDuplicate.containsDuplicateEnhanced(nums));
        }

        @Test
        @DisplayName("Should return false for single element array")
        void testSingleElementArray() {
            int[] nums = {5};
            assertFalse(ContainsDuplicate.containsDuplicateEnhanced(nums));
        }

        @Test
        @DisplayName("Should return false for empty array")
        void testEmptyArray() {
            int[] nums = {};
            assertFalse(ContainsDuplicate.containsDuplicateEnhanced(nums));
        }

        @Test
        @DisplayName("Should return false for null array")
        void testNullArray() {
            assertFalse(ContainsDuplicate.containsDuplicateEnhanced(null));
        }
    }

    @Nested
    @DisplayName("Brute Force Approach Tests")
    class BruteForceApproachTests {

        @Test
        @DisplayName("Should return true for array with duplicates")
        void testContainsDuplicateWithDuplicates() {
            int[] nums = {1, 2, 3, 1};
            assertTrue(ContainsDuplicate.containsDuplicateBruteForce(nums));
        }

        @Test
        @DisplayName("Should return false for array without duplicates")
        void testContainsDuplicateWithoutDuplicates() {
            int[] nums = {1, 2, 3, 4};
            assertFalse(ContainsDuplicate.containsDuplicateBruteForce(nums));
        }

        @Test
        @DisplayName("Should return true for array with multiple duplicates")
        void testContainsDuplicateWithMultipleDuplicates() {
            int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
            assertTrue(ContainsDuplicate.containsDuplicateBruteForce(nums));
        }

        @Test
        @DisplayName("Should return false for single element array")
        void testSingleElementArray() {
            int[] nums = {5};
            assertFalse(ContainsDuplicate.containsDuplicateBruteForce(nums));
        }

        @Test
        @DisplayName("Should return false for empty array")
        void testEmptyArray() {
            int[] nums = {};
            assertFalse(ContainsDuplicate.containsDuplicateBruteForce(nums));
        }

        @Test
        @DisplayName("Should return false for null array")
        void testNullArray() {
            assertFalse(ContainsDuplicate.containsDuplicateBruteForce(null));
        }
    }

    @Nested
    @DisplayName("Cross Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @ParameterizedTest
        @MethodSource("provideTestCases")
        @DisplayName("All approaches should return same result")
        void testAllApproachesReturnSameResult(int[] nums, boolean expected) {
            assertEquals(expected, ContainsDuplicate.containsDuplicateHashSet(nums.clone()));
            assertEquals(expected, ContainsDuplicate.containsDuplicateSorting(nums.clone()));
            assertEquals(expected, ContainsDuplicate.containsDuplicateStream(nums.clone()));
            assertEquals(expected, ContainsDuplicate.containsDuplicateEnhanced(nums.clone()));
            assertEquals(expected, ContainsDuplicate.containsDuplicateBruteForce(nums.clone()));
        }

        static Stream<Arguments> provideTestCases() {
            return Stream.of(Arguments.of(new int[] {1, 2, 3, 1}, true),
                    Arguments.of(new int[] {1, 2, 3, 4}, false),
                    Arguments.of(new int[] {1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, true),
                    Arguments.of(new int[] {5}, false), Arguments.of(new int[] {}, false),
                    Arguments.of(new int[] {-1, -2, -1, -3}, true),
                    Arguments.of(new int[] {0, 1, 0}, true),
                    Arguments.of(new int[] {1000000000, -1000000000, 1000000000}, true),
                    Arguments.of(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, false),
                    Arguments.of(new int[] {1, 1}, true),
                    Arguments.of(new int[] {2, 14, 18, 22, 22}, true),
                    Arguments.of(new int[] {3, 3, 3, 3, 3}, true));
        }
    }

    @Nested
    @DisplayName("Edge Case Tests")
    class EdgeCaseTests {

        @Test
        @DisplayName("Should handle two element array with duplicates")
        void testTwoElementsWithDuplicates() {
            int[] nums = {1, 1};
            assertTrue(ContainsDuplicate.containsDuplicateHashSet(nums));
        }

        @Test
        @DisplayName("Should handle two element array without duplicates")
        void testTwoElementsWithoutDuplicates() {
            int[] nums = {1, 2};
            assertFalse(ContainsDuplicate.containsDuplicateHashSet(nums));
        }

        @Test
        @DisplayName("Should handle array with all same elements")
        void testAllSameElements() {
            int[] nums = {5, 5, 5, 5, 5};
            assertTrue(ContainsDuplicate.containsDuplicateHashSet(nums));
        }

        @Test
        @DisplayName("Should handle array with duplicate at the end")
        void testDuplicateAtEnd() {
            int[] nums = {1, 2, 3, 4, 5, 1};
            assertTrue(ContainsDuplicate.containsDuplicateHashSet(nums));
        }

        @Test
        @DisplayName("Should handle array with duplicate at the beginning")
        void testDuplicateAtBeginning() {
            int[] nums = {1, 1, 2, 3, 4, 5};
            assertTrue(ContainsDuplicate.containsDuplicateHashSet(nums));
        }

        @Test
        @DisplayName("Should handle array with duplicate in the middle")
        void testDuplicateInMiddle() {
            int[] nums = {1, 2, 2, 3, 4, 5};
            assertTrue(ContainsDuplicate.containsDuplicateHashSet(nums));
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
            assertTrue(ContainsDuplicate.containsDuplicateHashSet(largeArray));
            assertTrue(ContainsDuplicate.containsDuplicateSorting(largeArray.clone()));
            assertTrue(ContainsDuplicate.containsDuplicateStream(largeArray));
            assertTrue(ContainsDuplicate.containsDuplicateEnhanced(largeArray));
        }

        @Test
        @DisplayName("Should handle large array without duplicates")
        void testLargeArrayNoDuplicates() {
            // Create a large array without duplicates
            int[] largeArray = new int[10000];
            for (int i = 0; i < largeArray.length; i++) {
                largeArray[i] = i;
            }

            // All approaches should return false
            assertFalse(ContainsDuplicate.containsDuplicateHashSet(largeArray));
            assertFalse(ContainsDuplicate.containsDuplicateSorting(largeArray.clone()));
            assertFalse(ContainsDuplicate.containsDuplicateStream(largeArray));
            assertFalse(ContainsDuplicate.containsDuplicateEnhanced(largeArray));
        }
    }

    @Nested
    @DisplayName("Parameterized Tests")
    class ParameterizedTests {

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3, 4, 5, 10, 100, 1000})
        @DisplayName("Should handle arrays of different sizes")
        void testDifferentArraySizes(int size) {
            int[] nums = new int[size];
            for (int i = 0; i < size; i++) {
                nums[i] = i;
            }
            assertFalse(ContainsDuplicate.containsDuplicateHashSet(nums));
        }

        @ParameterizedTest
        @ValueSource(ints = {-1000000000, -1, 0, 1, 1000000000})
        @DisplayName("Should handle boundary values")
        void testBoundaryValues(int value) {
            int[] nums = {value, value};
            assertTrue(ContainsDuplicate.containsDuplicateHashSet(nums));
        }
    }

    @Nested
    @DisplayName("Utility Method Tests")
    class UtilityMethodTests {

        @Test
        @DisplayName("Should handle arrays with mixed positive and negative numbers")
        void testMixedPositiveNegative() {
            int[] nums = {-5, -3, -1, 0, 1, 3, 5, -5};
            assertTrue(ContainsDuplicate.containsDuplicateHashSet(nums));
        }

        @Test
        @DisplayName("Should handle arrays with zero and negative numbers")
        void testZeroAndNegative() {
            int[] nums = {0, -1, 0, -2};
            assertTrue(ContainsDuplicate.containsDuplicateHashSet(nums));
        }

        @Test
        @DisplayName("Should handle arrays with consecutive numbers")
        void testConsecutiveNumbers() {
            int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            assertFalse(ContainsDuplicate.containsDuplicateHashSet(nums));
        }

        @Test
        @DisplayName("Should handle arrays with non-consecutive numbers")
        void testNonConsecutiveNumbers() {
            int[] nums = {2, 14, 18, 22, 25, 30};
            assertFalse(ContainsDuplicate.containsDuplicateHashSet(nums));
        }
    }
}
