package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Comprehensive test suite for MoveZeroes LeetCode problem Tests all six different approaches with
 * various edge cases
 */
public class MoveZeroesTest {

    private MoveZeroes solution;

    @BeforeEach
    void setUp() {
        solution = new MoveZeroes();
    }

    @Nested
    @DisplayName("Two Pointers Approach Tests")
    class TwoPointersApproachTests {

        @Test
        @DisplayName("Basic example from LeetCode")
        void testBasicExample() {
            int[] nums = {0, 1, 0, 3, 12};
            int[] expected = {1, 3, 12, 0, 0};
            solution.moveZeroesTwoPointers(nums);
            assertArrayEquals(expected, nums);
        }

        @Test
        @DisplayName("Single element array with zero")
        void testSingleElementZero() {
            int[] nums = {0};
            int[] expected = {0};
            solution.moveZeroesTwoPointers(nums);
            assertArrayEquals(expected, nums);
        }

        @Test
        @DisplayName("Single element array without zero")
        void testSingleElementNonZero() {
            int[] nums = {1};
            int[] expected = {1};
            solution.moveZeroesTwoPointers(nums);
            assertArrayEquals(expected, nums);
        }

        @Test
        @DisplayName("All zeros")
        void testAllZeros() {
            int[] nums = {0, 0, 0, 0, 0};
            int[] expected = {0, 0, 0, 0, 0};
            solution.moveZeroesTwoPointers(nums);
            assertArrayEquals(expected, nums);
        }

        @Test
        @DisplayName("No zeros")
        void testNoZeros() {
            int[] nums = {1, 2, 3, 4, 5};
            int[] expected = {1, 2, 3, 4, 5};
            solution.moveZeroesTwoPointers(nums);
            assertArrayEquals(expected, nums);
        }

        @Test
        @DisplayName("Zeros at beginning")
        void testZerosAtBeginning() {
            int[] nums = {0, 0, 1, 2, 3};
            int[] expected = {1, 2, 3, 0, 0};
            solution.moveZeroesTwoPointers(nums);
            assertArrayEquals(expected, nums);
        }

        @Test
        @DisplayName("Zeros at end")
        void testZerosAtEnd() {
            int[] nums = {1, 2, 3, 0, 0};
            int[] expected = {1, 2, 3, 0, 0};
            solution.moveZeroesTwoPointers(nums);
            assertArrayEquals(expected, nums);
        }

        @Test
        @DisplayName("Alternating zeros and non-zeros")
        void testAlternating() {
            int[] nums = {1, 0, 1, 0, 1};
            int[] expected = {1, 1, 1, 0, 0};
            solution.moveZeroesTwoPointers(nums);
            assertArrayEquals(expected, nums);
        }

        @Test
        @DisplayName("Negative numbers")
        void testNegativeNumbers() {
            int[] nums = {0, -1, 0, -2, 3};
            int[] expected = {-1, -2, 3, 0, 0};
            solution.moveZeroesTwoPointers(nums);
            assertArrayEquals(expected, nums);
        }

        @Test
        @DisplayName("Large numbers")
        void testLargeNumbers() {
            int[] nums = {0, Integer.MAX_VALUE, 0, Integer.MIN_VALUE, 0};
            int[] expected = {Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 0, 0};
            solution.moveZeroesTwoPointers(nums);
            assertArrayEquals(expected, nums);
        }
    }

    @Nested
    @DisplayName("Two Pass Approach Tests")
    class TwoPassApproachTests {

        @Test
        @DisplayName("Basic functionality")
        void testBasicFunctionality() {
            int[] nums = {0, 1, 0, 3, 12};
            int[] expected = {1, 3, 12, 0, 0};
            solution.moveZeroesTwoPass(nums);
            assertArrayEquals(expected, nums);
        }

        @Test
        @DisplayName("Edge case: single element")
        void testSingleElement() {
            int[] nums = {42};
            int[] expected = {42};
            solution.moveZeroesTwoPass(nums);
            assertArrayEquals(expected, nums);
        }

        @Test
        @DisplayName("Edge case: all zeros")
        void testAllZeros() {
            int[] nums = {0, 0, 0, 0};
            int[] expected = {0, 0, 0, 0};
            solution.moveZeroesTwoPass(nums);
            assertArrayEquals(expected, nums);
        }
    }

    @Nested
    @DisplayName("Optimized Approach Tests")
    class OptimizedApproachTests {

        @Test
        @DisplayName("Basic functionality")
        void testBasicFunctionality() {
            int[] nums = {0, 1, 0, 3, 12};
            int[] expected = {1, 3, 12, 0, 0};
            solution.moveZeroesOptimized(nums);
            assertArrayEquals(expected, nums);
        }

        @Test
        @DisplayName("Complex case")
        void testComplexCase() {
            int[] nums = {0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1};
            int[] expected = {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0};
            solution.moveZeroesOptimized(nums);
            assertArrayEquals(expected, nums);
        }
    }

    @Nested
    @DisplayName("Count Zeros Approach Tests")
    class CountZerosApproachTests {

        @Test
        @DisplayName("Basic functionality")
        void testBasicFunctionality() {
            int[] nums = {0, 1, 0, 3, 12};
            int[] expected = {1, 3, 12, 0, 0};
            solution.moveZeroesCountZeros(nums);
            assertArrayEquals(expected, nums);
        }

        @Test
        @DisplayName("Multiple zeros")
        void testMultipleZeros() {
            int[] nums = {0, 0, 1, 0, 2, 0, 0, 3};
            int[] expected = {1, 2, 3, 0, 0, 0, 0, 0};
            solution.moveZeroesCountZeros(nums);
            assertArrayEquals(expected, nums);
        }
    }

    @Nested
    @DisplayName("Partition Approach Tests")
    class PartitionApproachTests {

        @Test
        @DisplayName("Basic functionality")
        void testBasicFunctionality() {
            int[] nums = {0, 1, 0, 3, 12};
            int[] expected = {1, 3, 12, 0, 0};
            solution.moveZeroesPartition(nums);
            assertArrayEquals(expected, nums);
        }

        @Test
        @DisplayName("Edge case: single zero")
        void testSingleZero() {
            int[] nums = {0};
            int[] expected = {0};
            solution.moveZeroesPartition(nums);
            assertArrayEquals(expected, nums);
        }
    }

    @Nested
    @DisplayName("Recursive Approach Tests")
    class RecursiveApproachTests {

        @Test
        @DisplayName("Basic functionality")
        void testBasicFunctionality() {
            int[] nums = {0, 1, 0, 3, 12};
            int[] expected = {1, 3, 12, 0, 0};
            solution.moveZeroesRecursive(nums);
            assertArrayEquals(expected, nums);
        }

        @Test
        @DisplayName("Deep recursion test")
        void testDeepRecursion() {
            int[] nums = new int[100];
            for (int i = 0; i < 100; i++) {
                nums[i] = (i % 2 == 0) ? 0 : i; // Every other number is zero
            }
            solution.moveZeroesRecursive(nums);
            assertTrue(solution.verifyZeroesAtEnd(nums));
        }
    }

    @Nested
    @DisplayName("Cross Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @ParameterizedTest
        @MethodSource("provideTestCases")
        @DisplayName("All approaches produce same result")
        void testAllApproachesConsistency(int[] nums, int[] expected) {
            int[] test1 = nums.clone();
            int[] test2 = nums.clone();
            int[] test3 = nums.clone();
            int[] test4 = nums.clone();
            int[] test5 = nums.clone();
            int[] test6 = nums.clone();

            solution.moveZeroesTwoPointers(test1);
            solution.moveZeroesTwoPass(test2);
            solution.moveZeroesOptimized(test3);
            solution.moveZeroesCountZeros(test4);
            solution.moveZeroesPartition(test5);
            solution.moveZeroesRecursive(test6);

            assertArrayEquals(expected, test1, "Two Pointers approach failed");
            assertArrayEquals(expected, test2, "Two Pass approach failed");
            assertArrayEquals(expected, test3, "Optimized approach failed");
            assertArrayEquals(expected, test4, "Count Zeros approach failed");
            assertArrayEquals(expected, test5, "Partition approach failed");
            assertArrayEquals(expected, test6, "Recursive approach failed");

            // All approaches should produce the same result
            assertArrayEquals(test1, test2);
            assertArrayEquals(test2, test3);
            assertArrayEquals(test3, test4);
            assertArrayEquals(test4, test5);
            assertArrayEquals(test5, test6);
        }

        static Stream<Arguments> provideTestCases() {
            return Stream.of(Arguments.of(new int[] {0, 1, 0, 3, 12}, new int[] {1, 3, 12, 0, 0}),
                    Arguments.of(new int[] {0}, new int[] {0}),
                    Arguments.of(new int[] {1, 0, 1}, new int[] {1, 1, 0}),
                    Arguments.of(new int[] {0, 0, 1}, new int[] {1, 0, 0}),
                    Arguments.of(new int[] {1, 2, 3, 4, 5}, new int[] {1, 2, 3, 4, 5}),
                    Arguments.of(new int[] {0, 0, 0, 0, 0}, new int[] {0, 0, 0, 0, 0}),
                    Arguments.of(new int[] {1, 0, 0, 0, 1}, new int[] {1, 1, 0, 0, 0}),
                    Arguments.of(new int[] {0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                            new int[] {1, 1, 1, 0, 0, 0, 0, 0, 0, 0}));
        }
    }

    @Nested
    @DisplayName("Edge Case Tests")
    class EdgeCaseTests {

        @Test
        @DisplayName("Null array handling")
        void testNullArray() {
            assertDoesNotThrow(() -> solution.moveZeroesTwoPointers(null));
            assertDoesNotThrow(() -> solution.moveZeroesTwoPass(null));
            assertDoesNotThrow(() -> solution.moveZeroesOptimized(null));
            assertDoesNotThrow(() -> solution.moveZeroesCountZeros(null));
            assertDoesNotThrow(() -> solution.moveZeroesPartition(null));
            assertDoesNotThrow(() -> solution.moveZeroesRecursive(null));
        }

        @Test
        @DisplayName("Empty array handling")
        void testEmptyArray() {
            int[] empty = {};
            assertDoesNotThrow(() -> solution.moveZeroesTwoPointers(empty));
            assertDoesNotThrow(() -> solution.moveZeroesTwoPass(empty));
            assertDoesNotThrow(() -> solution.moveZeroesOptimized(empty));
            assertDoesNotThrow(() -> solution.moveZeroesCountZeros(empty));
            assertDoesNotThrow(() -> solution.moveZeroesPartition(empty));
            assertDoesNotThrow(() -> solution.moveZeroesRecursive(empty));
        }

        @Test
        @DisplayName("Single element arrays")
        void testSingleElementArrays() {
            int[] singleZero = {0};
            int[] singleNonZero = {1};

            solution.moveZeroesTwoPointers(singleZero);
            solution.moveZeroesTwoPointers(singleNonZero);

            assertArrayEquals(new int[] {0}, singleZero);
            assertArrayEquals(new int[] {1}, singleNonZero);
        }

        @Test
        @DisplayName("Maximum constraint test")
        void testMaximumConstraint() {
            int[] nums = new int[10000];
            for (int i = 0; i < 10000; i++) {
                nums[i] = (i % 2 == 0) ? 0 : i;
            }

            solution.moveZeroesTwoPointers(nums);
            assertTrue(solution.verifyZeroesAtEnd(nums));
        }

        @Test
        @DisplayName("Integer boundary values")
        void testIntegerBoundaryValues() {
            int[] nums = {0, Integer.MAX_VALUE, 0, Integer.MIN_VALUE, 0};
            int[] expected = {Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 0, 0};

            solution.moveZeroesTwoPointers(nums);
            assertArrayEquals(expected, nums);
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Large array performance test")
        void testLargeArrayPerformance() {
            int[] nums = new int[10000];
            for (int i = 0; i < 10000; i++) {
                nums[i] = (i % 3 == 0) ? 0 : i; // Every third element is zero
            }

            long startTime, endTime;

            int[] testArray1 = nums.clone();
            startTime = System.nanoTime();
            solution.moveZeroesTwoPointers(testArray1);
            endTime = System.nanoTime();
            long twoPointersTime = endTime - startTime;

            int[] testArray2 = nums.clone();
            startTime = System.nanoTime();
            solution.moveZeroesTwoPass(testArray2);
            endTime = System.nanoTime();
            long twoPassTime = endTime - startTime;

            int[] testArray3 = nums.clone();
            startTime = System.nanoTime();
            solution.moveZeroesOptimized(testArray3);
            endTime = System.nanoTime();
            long optimizedTime = endTime - startTime;

            System.out.println("Two Pointers: " + twoPointersTime + " ns");
            System.out.println("Two Pass: " + twoPassTime + " ns");
            System.out.println("Optimized: " + optimizedTime + " ns");

            // All approaches should complete in reasonable time
            assertTrue(twoPointersTime < 10_000_000); // Less than 10ms
            assertTrue(twoPassTime < 10_000_000);
            assertTrue(optimizedTime < 10_000_000);
        }

        @Test
        @DisplayName("Memory efficiency test")
        void testMemoryEfficiency() {
            int[] nums = new int[1000];
            for (int i = 0; i < 1000; i++) {
                nums[i] = (i % 2 == 0) ? 0 : i;
            }

            // Test that all approaches produce the same result
            int[] result1 = nums.clone();
            int[] result2 = nums.clone();
            int[] result3 = nums.clone();
            int[] result4 = nums.clone();
            int[] result5 = nums.clone();
            int[] result6 = nums.clone();

            solution.moveZeroesTwoPointers(result1);
            solution.moveZeroesTwoPass(result2);
            solution.moveZeroesOptimized(result3);
            solution.moveZeroesCountZeros(result4);
            solution.moveZeroesPartition(result5);
            solution.moveZeroesRecursive(result6);

            assertArrayEquals(result1, result2);
            assertArrayEquals(result2, result3);
            assertArrayEquals(result3, result4);
            assertArrayEquals(result4, result5);
            assertArrayEquals(result5, result6);
        }
    }

    @Nested
    @DisplayName("Utility Method Tests")
    class UtilityMethodTests {

        @Test
        @DisplayName("Compare arrays utility test")
        void testCompareArrays() {
            int[] arr1 = {1, 2, 3, 0, 0};
            int[] arr2 = {1, 2, 3, 0, 0};
            int[] arr3 = {1, 2, 0, 0, 3};

            assertTrue(solution.compareArrays(arr1, arr2));
            assertFalse(solution.compareArrays(arr1, arr3));
        }

        @Test
        @DisplayName("Count zeros utility test")
        void testCountZeros() {
            int[] nums = {1, 0, 2, 0, 3, 0};
            assertEquals(3, solution.countZeros(nums));

            int[] noZeros = {1, 2, 3, 4, 5};
            assertEquals(0, solution.countZeros(noZeros));

            int[] allZeros = {0, 0, 0, 0};
            assertEquals(4, solution.countZeros(allZeros));
        }

        @Test
        @DisplayName("Verify zeros at end utility test")
        void testVerifyZerosAtEnd() {
            int[] correct = {1, 2, 3, 0, 0};
            int[] incorrect = {1, 0, 2, 0, 3};
            int[] noZeros = {1, 2, 3, 4, 5};
            int[] allZeros = {0, 0, 0, 0};

            assertTrue(solution.verifyZeroesAtEnd(correct));
            assertFalse(solution.verifyZeroesAtEnd(incorrect));
            assertTrue(solution.verifyZeroesAtEnd(noZeros));
            assertTrue(solution.verifyZeroesAtEnd(allZeros));
        }

        @Test
        @DisplayName("Count operations utility test")
        void testCountOperations() {
            int[] original = {0, 1, 0, 3, 12};
            int[] modified = {1, 3, 12, 0, 0};
            assertEquals(5, solution.countOperations(original, modified));

            int[] same = {1, 2, 3, 4, 5};
            assertEquals(0, solution.countOperations(same, same));
        }

        @Test
        @DisplayName("Print array utility test")
        void testPrintArray() {
            int[] nums = {1, 2, 3, 0, 0};
            // This test just ensures the method doesn't throw an exception
            assertDoesNotThrow(() -> solution.printArray(nums));
        }
    }

    @Nested
    @DisplayName("Parameterized Tests")
    class ParameterizedTests {

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 5, 10, 20, 50, 100})
        @DisplayName("Test with different array sizes")
        void testDifferentArraySizes(int size) {
            int[] nums = new int[size];
            for (int i = 0; i < size; i++) {
                nums[i] = (i % 2 == 0) ? 0 : i;
            }

            solution.moveZeroesTwoPointers(nums);
            assertTrue(solution.verifyZeroesAtEnd(nums));

            // Count zeros should remain the same
            // For alternating pattern: even indices (0, 2, 4, ...) are zeros
            int expectedZeroCount = (size + 1) / 2; // For size=1: 1 zero, size=3: 2 zeros, etc.
            assertEquals(expectedZeroCount, solution.countZeros(nums));
        }
    }

    @Nested
    @DisplayName("Stress Tests")
    class StressTests {

        @Test
        @DisplayName("Maximum constraint stress test")
        void testMaximumConstraintStress() {
            int[] nums = new int[10000];
            for (int i = 0; i < 10000; i++) {
                nums[i] = (i % 5 == 0) ? 0 : i; // Every fifth element is zero
            }

            solution.moveZeroesTwoPointers(nums);
            assertTrue(solution.verifyZeroesAtEnd(nums));

            // Verify zero count
            int expectedZeroCount = 10000 / 5;
            assertEquals(expectedZeroCount, solution.countZeros(nums));
        }

        @Test
        @DisplayName("Alternating pattern stress test")
        void testAlternatingPatternStress() {
            int[] nums = new int[1000];
            for (int i = 0; i < 1000; i++) {
                nums[i] = (i % 2 == 0) ? 0 : i;
            }

            solution.moveZeroesTwoPointers(nums);
            assertTrue(solution.verifyZeroesAtEnd(nums));

            // Should have 500 zeros
            assertEquals(500, solution.countZeros(nums));
        }
    }
}
