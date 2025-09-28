package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
 * Comprehensive test suite for SummaryRanges LeetCode problem Tests all five different approaches
 * with various edge cases
 */
public class SummaryRangesTest {

    private SummaryRanges solution;

    @BeforeEach
    void setUp() {
        solution = new SummaryRanges();
    }

    @Nested
    @DisplayName("Two Pointers Approach Tests")
    class TwoPointersApproachTests {

        @Test
        @DisplayName("Basic example from LeetCode")
        void testBasicExample() {
            int[] nums = {0, 1, 2, 4, 5, 7};
            List<String> expected = Arrays.asList("0->2", "4->5", "7");
            List<String> result = solution.summaryRangesTwoPointers(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Second example from LeetCode")
        void testSecondExample() {
            int[] nums = {0, 2, 3, 4, 6, 8, 9};
            List<String> expected = Arrays.asList("0", "2->4", "6", "8->9");
            List<String> result = solution.summaryRangesTwoPointers(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Single element array")
        void testSingleElement() {
            int[] nums = {5};
            List<String> expected = Arrays.asList("5");
            List<String> result = solution.summaryRangesTwoPointers(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Empty array")
        void testEmptyArray() {
            int[] nums = {};
            List<String> expected = new ArrayList<>();
            List<String> result = solution.summaryRangesTwoPointers(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Null array")
        void testNullArray() {
            int[] nums = null;
            List<String> expected = new ArrayList<>();
            List<String> result = solution.summaryRangesTwoPointers(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("All consecutive numbers")
        void testAllConsecutive() {
            int[] nums = {1, 2, 3, 4, 5};
            List<String> expected = Arrays.asList("1->5");
            List<String> result = solution.summaryRangesTwoPointers(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("No consecutive numbers")
        void testNoConsecutive() {
            int[] nums = {1, 3, 5, 7, 9};
            List<String> expected = Arrays.asList("1", "3", "5", "7", "9");
            List<String> result = solution.summaryRangesTwoPointers(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Negative numbers")
        void testNegativeNumbers() {
            int[] nums = {-3, -2, -1, 0, 1, 3, 4, 5};
            List<String> expected = Arrays.asList("-3->1", "3->5");
            List<String> result = solution.summaryRangesTwoPointers(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Large numbers")
        void testLargeNumbers() {
            int[] nums = {Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE};
            List<String> expected =
                    Arrays.asList((Integer.MAX_VALUE - 2) + "->" + Integer.MAX_VALUE);
            List<String> result = solution.summaryRangesTwoPointers(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Minimum integer values")
        void testMinIntegerValues() {
            int[] nums = {Integer.MIN_VALUE, Integer.MIN_VALUE + 1, Integer.MIN_VALUE + 3};
            List<String> expected =
                    Arrays.asList(Integer.MIN_VALUE + "->" + (Integer.MIN_VALUE + 1),
                            String.valueOf(Integer.MIN_VALUE + 3));
            List<String> result = solution.summaryRangesTwoPointers(nums);
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Single Pass Approach Tests")
    class SinglePassApproachTests {

        @Test
        @DisplayName("Basic functionality")
        void testBasicFunctionality() {
            int[] nums = {0, 1, 2, 4, 5, 7};
            List<String> expected = Arrays.asList("0->2", "4->5", "7");
            List<String> result = solution.summaryRangesSinglePass(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Edge case: single element")
        void testSingleElement() {
            int[] nums = {42};
            List<String> expected = Arrays.asList("42");
            List<String> result = solution.summaryRangesSinglePass(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Edge case: empty array")
        void testEmptyArray() {
            int[] nums = {};
            List<String> expected = new ArrayList<>();
            List<String> result = solution.summaryRangesSinglePass(nums);
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("With Pairs Approach Tests")
    class WithPairsApproachTests {

        @Test
        @DisplayName("Basic functionality")
        void testBasicFunctionality() {
            int[] nums = {0, 1, 2, 4, 5, 7};
            List<String> expected = Arrays.asList("0->2", "4->5", "7");
            List<String> result = solution.summaryRangesWithPairs(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Complex ranges")
        void testComplexRanges() {
            int[] nums = {-5, -4, -3, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 12};
            List<String> expected = Arrays.asList("-5->-3", "-1->1", "3->5", "7->10", "12");
            List<String> result = solution.summaryRangesWithPairs(nums);
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Recursive Approach Tests")
    class RecursiveApproachTests {

        @Test
        @DisplayName("Basic functionality")
        void testBasicFunctionality() {
            int[] nums = {0, 1, 2, 4, 5, 7};
            List<String> expected = Arrays.asList("0->2", "4->5", "7");
            List<String> result = solution.summaryRangesRecursive(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Deep recursion test")
        void testDeepRecursion() {
            int[] nums = new int[100];
            for (int i = 0; i < 100; i++) {
                nums[i] = i * 2; // Every other number
            }
            List<String> result = solution.summaryRangesRecursive(nums);
            assertNotNull(result);
            assertEquals(100, result.size()); // Each number is its own range
        }
    }

    @Nested
    @DisplayName("Optimized Approach Tests")
    class OptimizedApproachTests {

        @Test
        @DisplayName("Basic functionality")
        void testBasicFunctionality() {
            int[] nums = {0, 1, 2, 4, 5, 7};
            List<String> expected = Arrays.asList("0->2", "4->5", "7");
            List<String> result = solution.summaryRangesOptimized(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Single element optimization")
        void testSingleElementOptimization() {
            int[] nums = {999};
            List<String> expected = Arrays.asList("999");
            List<String> result = solution.summaryRangesOptimized(nums);
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Cross Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @ParameterizedTest
        @MethodSource("provideTestCases")
        @DisplayName("All approaches produce same result")
        void testAllApproachesConsistency(int[] nums, List<String> expected) {
            List<String> result1 = solution.summaryRangesTwoPointers(nums);
            List<String> result2 = solution.summaryRangesSinglePass(nums);
            List<String> result3 = solution.summaryRangesWithPairs(nums);
            List<String> result4 = solution.summaryRangesRecursive(nums);
            List<String> result5 = solution.summaryRangesOptimized(nums);

            assertEquals(expected, result1, "Two Pointers approach failed");
            assertEquals(expected, result2, "Single Pass approach failed");
            assertEquals(expected, result3, "With Pairs approach failed");
            assertEquals(expected, result4, "Recursive approach failed");
            assertEquals(expected, result5, "Optimized approach failed");

            // All approaches should produce the same result
            assertEquals(result1, result2);
            assertEquals(result2, result3);
            assertEquals(result3, result4);
            assertEquals(result4, result5);
        }

        static Stream<Arguments> provideTestCases() {
            return Stream.of(
                    Arguments.of(new int[] {0, 1, 2, 4, 5, 7}, Arrays.asList("0->2", "4->5", "7")),
                    Arguments.of(new int[] {0, 2, 3, 4, 6, 8, 9},
                            Arrays.asList("0", "2->4", "6", "8->9")),
                    Arguments.of(new int[] {0}, Arrays.asList("0")),
                    Arguments.of(new int[] {}, new ArrayList<>()),
                    Arguments.of(new int[] {1, 3}, Arrays.asList("1", "3")),
                    Arguments.of(new int[] {-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                            Arrays.asList("-1->10")),
                    Arguments.of(
                            new int[] {-2, -1, 0, 1, 2, 4, 5, 7, 8, 9, 10, 12, 13, 14, 15, 16, 17,
                                    18, 19, 20},
                            Arrays.asList("-2->2", "4->5", "7->10", "12->20")));
        }
    }

    @Nested
    @DisplayName("Edge Case Tests")
    class EdgeCaseTests {

        @Test
        @DisplayName("Maximum constraint test")
        void testMaximumConstraint() {
            int[] nums = new int[20];
            for (int i = 0; i < 20; i++) {
                nums[i] = i;
            }
            List<String> expected = Arrays.asList("0->19");
            List<String> result = solution.summaryRangesTwoPointers(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Integer overflow test")
        void testIntegerOverflow() {
            int[] nums = {Integer.MAX_VALUE - 1, Integer.MAX_VALUE};
            List<String> expected =
                    Arrays.asList((Integer.MAX_VALUE - 1) + "->" + Integer.MAX_VALUE);
            List<String> result = solution.summaryRangesTwoPointers(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Integer underflow test")
        void testIntegerUnderflow() {
            int[] nums = {Integer.MIN_VALUE, Integer.MIN_VALUE + 1};
            List<String> expected =
                    Arrays.asList(Integer.MIN_VALUE + "->" + (Integer.MIN_VALUE + 1));
            List<String> result = solution.summaryRangesTwoPointers(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Zero and negative numbers")
        void testZeroAndNegative() {
            int[] nums = {-3, -2, -1, 0, 1, 2, 4, 5, 7};
            List<String> expected = Arrays.asList("-3->2", "4->5", "7");
            List<String> result = solution.summaryRangesTwoPointers(nums);
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Large array performance test")
        void testLargeArrayPerformance() {
            int[] nums = new int[1000];
            for (int i = 0; i < 1000; i++) {
                nums[i] = i * 2; // Create gaps to test range detection
            }

            long startTime, endTime;

            startTime = System.nanoTime();
            solution.summaryRangesTwoPointers(nums);
            endTime = System.nanoTime();
            long twoPointersTime = endTime - startTime;

            startTime = System.nanoTime();
            solution.summaryRangesSinglePass(nums);
            endTime = System.nanoTime();
            long singlePassTime = endTime - startTime;

            startTime = System.nanoTime();
            solution.summaryRangesOptimized(nums);
            endTime = System.nanoTime();
            long optimizedTime = endTime - startTime;

            System.out.println("Two Pointers: " + twoPointersTime + " ns");
            System.out.println("Single Pass: " + singlePassTime + " ns");
            System.out.println("Optimized: " + optimizedTime + " ns");

            // All approaches should complete in reasonable time
            assertTrue(twoPointersTime < 1_000_000); // Less than 1ms
            assertTrue(singlePassTime < 1_000_000);
            assertTrue(optimizedTime < 1_000_000);
        }

        @Test
        @DisplayName("Memory efficiency test")
        void testMemoryEfficiency() {
            int[] nums = new int[100];
            for (int i = 0; i < 100; i++) {
                nums[i] = i;
            }

            // Test that all approaches produce the same result
            List<String> result1 = solution.summaryRangesTwoPointers(nums);
            List<String> result2 = solution.summaryRangesSinglePass(nums);
            List<String> result3 = solution.summaryRangesWithPairs(nums);
            List<String> result4 = solution.summaryRangesRecursive(nums);
            List<String> result5 = solution.summaryRangesOptimized(nums);

            assertEquals(result1, result2);
            assertEquals(result2, result3);
            assertEquals(result3, result4);
            assertEquals(result4, result5);
        }
    }

    @Nested
    @DisplayName("Utility Method Tests")
    class UtilityMethodTests {

        @Test
        @DisplayName("Compare ranges utility test")
        void testCompareRanges() {
            List<String> ranges1 = Arrays.asList("1->3", "5", "7->9");
            List<String> ranges2 = Arrays.asList("1->3", "5", "7->9");
            List<String> ranges3 = Arrays.asList("1->3", "5", "7->8");

            assertTrue(solution.compareRanges(ranges1, ranges2));
            assertFalse(solution.compareRanges(ranges1, ranges3));
        }

        @Test
        @DisplayName("Print ranges utility test")
        void testPrintRanges() {
            List<String> ranges = Arrays.asList("1->3", "5", "7->9");
            // This test just ensures the method doesn't throw an exception
            assertDoesNotThrow(() -> solution.printRanges(ranges));
        }
    }

    @Nested
    @DisplayName("Parameterized Tests")
    class ParameterizedTests {

        @ParameterizedTest
        @ValueSource(ints = {0, 1, 2, 5, 10, 20})
        @DisplayName("Test with different array sizes")
        void testDifferentArraySizes(int size) {
            int[] nums = new int[size];
            for (int i = 0; i < size; i++) {
                nums[i] = i;
            }

            List<String> result = solution.summaryRangesTwoPointers(nums);
            assertNotNull(result);

            if (size == 0) {
                assertTrue(result.isEmpty());
            } else if (size == 1) {
                assertEquals(1, result.size());
                assertEquals("0", result.get(0));
            } else {
                assertEquals(1, result.size());
                assertEquals("0->" + (size - 1), result.get(0));
            }
        }
    }
}
