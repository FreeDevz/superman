package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
 * Comprehensive test suite for RangeSumQueryImmutable LeetCode problem Tests all six different
 * approaches with various edge cases
 */
public class RangeSumQueryImmutableTest {

    @Nested
    @DisplayName("Prefix Sum Approach Tests")
    class PrefixSumApproachTests {

        @Test
        @DisplayName("Basic example from LeetCode")
        void testBasicExample() {
            int[] nums = {-2, 0, 3, -5, 2, -1};
            RangeSumQueryImmutable.NumArrayPrefixSum numArray =
                    new RangeSumQueryImmutable.NumArrayPrefixSum(nums);

            assertEquals(1, numArray.sumRange(0, 2));
            assertEquals(-1, numArray.sumRange(2, 5));
            assertEquals(-3, numArray.sumRange(0, 5));
        }

        @Test
        @DisplayName("Single element array")
        void testSingleElement() {
            int[] nums = {42};
            RangeSumQueryImmutable.NumArrayPrefixSum numArray =
                    new RangeSumQueryImmutable.NumArrayPrefixSum(nums);

            assertEquals(42, numArray.sumRange(0, 0));
        }

        @Test
        @DisplayName("Empty array")
        void testEmptyArray() {
            int[] nums = {};
            RangeSumQueryImmutable.NumArrayPrefixSum numArray =
                    new RangeSumQueryImmutable.NumArrayPrefixSum(nums);

            assertEquals(0, numArray.sumRange(0, 0));
        }

        @Test
        @DisplayName("Null array")
        void testNullArray() {
            int[] nums = null;
            RangeSumQueryImmutable.NumArrayPrefixSum numArray =
                    new RangeSumQueryImmutable.NumArrayPrefixSum(nums);

            assertEquals(0, numArray.sumRange(0, 0));
        }

        @Test
        @DisplayName("All positive numbers")
        void testAllPositive() {
            int[] nums = {1, 2, 3, 4, 5};
            RangeSumQueryImmutable.NumArrayPrefixSum numArray =
                    new RangeSumQueryImmutable.NumArrayPrefixSum(nums);

            assertEquals(15, numArray.sumRange(0, 4));
            assertEquals(3, numArray.sumRange(0, 1));
            assertEquals(7, numArray.sumRange(2, 3));
        }

        @Test
        @DisplayName("All negative numbers")
        void testAllNegative() {
            int[] nums = {-1, -2, -3, -4, -5};
            RangeSumQueryImmutable.NumArrayPrefixSum numArray =
                    new RangeSumQueryImmutable.NumArrayPrefixSum(nums);

            assertEquals(-15, numArray.sumRange(0, 4));
            assertEquals(-3, numArray.sumRange(0, 1));
            assertEquals(-7, numArray.sumRange(2, 3));
        }

        @Test
        @DisplayName("Mixed positive and negative")
        void testMixedNumbers() {
            int[] nums = {1, -2, 3, -4, 5};
            RangeSumQueryImmutable.NumArrayPrefixSum numArray =
                    new RangeSumQueryImmutable.NumArrayPrefixSum(nums);

            assertEquals(3, numArray.sumRange(0, 4));
            assertEquals(-1, numArray.sumRange(0, 1));
            assertEquals(-1, numArray.sumRange(2, 3));
        }

        @Test
        @DisplayName("All zeros")
        void testAllZeros() {
            int[] nums = {0, 0, 0, 0, 0};
            RangeSumQueryImmutable.NumArrayPrefixSum numArray =
                    new RangeSumQueryImmutable.NumArrayPrefixSum(nums);

            assertEquals(0, numArray.sumRange(0, 4));
            assertEquals(0, numArray.sumRange(0, 1));
            assertEquals(0, numArray.sumRange(2, 3));
        }

        @Test
        @DisplayName("Invalid range throws exception")
        void testInvalidRange() {
            int[] nums = {1, 2, 3, 4, 5};
            RangeSumQueryImmutable.NumArrayPrefixSum numArray =
                    new RangeSumQueryImmutable.NumArrayPrefixSum(nums);

            assertThrows(IllegalArgumentException.class, () -> numArray.sumRange(-1, 2));
            assertThrows(IllegalArgumentException.class, () -> numArray.sumRange(0, 5));
            assertThrows(IllegalArgumentException.class, () -> numArray.sumRange(3, 1));
        }
    }

    @Nested
    @DisplayName("Segment Tree Approach Tests")
    class SegmentTreeApproachTests {

        @Test
        @DisplayName("Basic functionality")
        void testBasicFunctionality() {
            int[] nums = {-2, 0, 3, -5, 2, -1};
            RangeSumQueryImmutable.NumArraySegmentTree numArray =
                    new RangeSumQueryImmutable.NumArraySegmentTree(nums);

            assertEquals(1, numArray.sumRange(0, 2));
            assertEquals(-1, numArray.sumRange(2, 5));
            assertEquals(-3, numArray.sumRange(0, 5));
        }

        @Test
        @DisplayName("Single element")
        void testSingleElement() {
            int[] nums = {42};
            RangeSumQueryImmutable.NumArraySegmentTree numArray =
                    new RangeSumQueryImmutable.NumArraySegmentTree(nums);

            assertEquals(42, numArray.sumRange(0, 0));
        }

        @Test
        @DisplayName("Empty array")
        void testEmptyArray() {
            int[] nums = {};
            RangeSumQueryImmutable.NumArraySegmentTree numArray =
                    new RangeSumQueryImmutable.NumArraySegmentTree(nums);

            assertEquals(0, numArray.sumRange(0, 0));
        }
    }

    @Nested
    @DisplayName("Binary Indexed Tree Approach Tests")
    class BinaryIndexedTreeApproachTests {

        @Test
        @DisplayName("Basic functionality")
        void testBasicFunctionality() {
            int[] nums = {-2, 0, 3, -5, 2, -1};
            RangeSumQueryImmutable.NumArrayBinaryIndexedTree numArray =
                    new RangeSumQueryImmutable.NumArrayBinaryIndexedTree(nums);

            assertEquals(1, numArray.sumRange(0, 2));
            assertEquals(-1, numArray.sumRange(2, 5));
            assertEquals(-3, numArray.sumRange(0, 5));
        }

        @Test
        @DisplayName("Single element")
        void testSingleElement() {
            int[] nums = {42};
            RangeSumQueryImmutable.NumArrayBinaryIndexedTree numArray =
                    new RangeSumQueryImmutable.NumArrayBinaryIndexedTree(nums);

            assertEquals(42, numArray.sumRange(0, 0));
        }

        @Test
        @DisplayName("Empty array")
        void testEmptyArray() {
            int[] nums = {};
            RangeSumQueryImmutable.NumArrayBinaryIndexedTree numArray =
                    new RangeSumQueryImmutable.NumArrayBinaryIndexedTree(nums);

            assertEquals(0, numArray.sumRange(0, 0));
        }
    }

    @Nested
    @DisplayName("Sparse Table Approach Tests")
    class SparseTableApproachTests {

        @Test
        @DisplayName("Basic functionality")
        void testBasicFunctionality() {
            int[] nums = {-2, 0, 3, -5, 2, -1};
            RangeSumQueryImmutable.NumArraySparseTable numArray =
                    new RangeSumQueryImmutable.NumArraySparseTable(nums);

            assertEquals(1, numArray.sumRange(0, 2));
            assertEquals(-1, numArray.sumRange(2, 5));
            assertEquals(-3, numArray.sumRange(0, 5));
        }

        @Test
        @DisplayName("Single element")
        void testSingleElement() {
            int[] nums = {42};
            RangeSumQueryImmutable.NumArraySparseTable numArray =
                    new RangeSumQueryImmutable.NumArraySparseTable(nums);

            assertEquals(42, numArray.sumRange(0, 0));
        }

        @Test
        @DisplayName("Empty array")
        void testEmptyArray() {
            int[] nums = {};
            RangeSumQueryImmutable.NumArraySparseTable numArray =
                    new RangeSumQueryImmutable.NumArraySparseTable(nums);

            assertEquals(0, numArray.sumRange(0, 0));
        }
    }

    @Nested
    @DisplayName("Simple Approach Tests")
    class SimpleApproachTests {

        @Test
        @DisplayName("Basic functionality")
        void testBasicFunctionality() {
            int[] nums = {-2, 0, 3, -5, 2, -1};
            RangeSumQueryImmutable.NumArraySimple numArray =
                    new RangeSumQueryImmutable.NumArraySimple(nums);

            assertEquals(1, numArray.sumRange(0, 2));
            assertEquals(-1, numArray.sumRange(2, 5));
            assertEquals(-3, numArray.sumRange(0, 5));
        }

        @Test
        @DisplayName("Single element")
        void testSingleElement() {
            int[] nums = {42};
            RangeSumQueryImmutable.NumArraySimple numArray =
                    new RangeSumQueryImmutable.NumArraySimple(nums);

            assertEquals(42, numArray.sumRange(0, 0));
        }

        @Test
        @DisplayName("Empty array")
        void testEmptyArray() {
            int[] nums = {};
            RangeSumQueryImmutable.NumArraySimple numArray =
                    new RangeSumQueryImmutable.NumArraySimple(nums);

            assertEquals(0, numArray.sumRange(0, 0));
        }
    }

    @Nested
    @DisplayName("Optimized Approach Tests")
    class OptimizedApproachTests {

        @Test
        @DisplayName("Basic functionality")
        void testBasicFunctionality() {
            int[] nums = {-2, 0, 3, -5, 2, -1};
            RangeSumQueryImmutable.NumArrayOptimized numArray =
                    new RangeSumQueryImmutable.NumArrayOptimized(nums);

            assertEquals(1, numArray.sumRange(0, 2));
            assertEquals(-1, numArray.sumRange(2, 5));
            assertEquals(-3, numArray.sumRange(0, 5));
        }

        @Test
        @DisplayName("Single element")
        void testSingleElement() {
            int[] nums = {42};
            RangeSumQueryImmutable.NumArrayOptimized numArray =
                    new RangeSumQueryImmutable.NumArrayOptimized(nums);

            assertEquals(42, numArray.sumRange(0, 0));
        }

        @Test
        @DisplayName("Empty array")
        void testEmptyArray() {
            int[] nums = {};
            RangeSumQueryImmutable.NumArrayOptimized numArray =
                    new RangeSumQueryImmutable.NumArrayOptimized(nums);

            assertEquals(0, numArray.sumRange(0, 0));
        }

        @Test
        @DisplayName("Null array throws exception")
        void testNullArray() {
            assertThrows(IllegalArgumentException.class,
                    () -> new RangeSumQueryImmutable.NumArrayOptimized(null));
        }

        @Test
        @DisplayName("Additional utility methods")
        void testUtilityMethods() {
            int[] nums = {1, 2, 3, 4, 5};
            RangeSumQueryImmutable.NumArrayOptimized numArray =
                    new RangeSumQueryImmutable.NumArrayOptimized(nums);

            assertEquals(15, numArray.getTotalSum());
            assertEquals(3, numArray.getElement(2));
            assertEquals(5, numArray.getLength());
        }

        @Test
        @DisplayName("Invalid range throws exception")
        void testInvalidRange() {
            int[] nums = {1, 2, 3, 4, 5};
            RangeSumQueryImmutable.NumArrayOptimized numArray =
                    new RangeSumQueryImmutable.NumArrayOptimized(nums);

            assertThrows(IllegalArgumentException.class, () -> numArray.sumRange(-1, 2));
            assertThrows(IllegalArgumentException.class, () -> numArray.sumRange(0, 5));
            assertThrows(IllegalArgumentException.class, () -> numArray.sumRange(3, 1));
        }

        @Test
        @DisplayName("Invalid element access throws exception")
        void testInvalidElementAccess() {
            int[] nums = {1, 2, 3, 4, 5};
            RangeSumQueryImmutable.NumArrayOptimized numArray =
                    new RangeSumQueryImmutable.NumArrayOptimized(nums);

            assertThrows(IllegalArgumentException.class, () -> numArray.getElement(-1));
            assertThrows(IllegalArgumentException.class, () -> numArray.getElement(5));
        }
    }

    @Nested
    @DisplayName("Cross Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @ParameterizedTest
        @MethodSource("provideTestCases")
        @DisplayName("All approaches produce same result")
        void testAllApproachesConsistency(int[] nums, int left, int right, int expected) {
            RangeSumQueryImmutable.NumArrayPrefixSum prefixSum =
                    new RangeSumQueryImmutable.NumArrayPrefixSum(nums);
            RangeSumQueryImmutable.NumArraySegmentTree segmentTree =
                    new RangeSumQueryImmutable.NumArraySegmentTree(nums);
            RangeSumQueryImmutable.NumArrayBinaryIndexedTree bit =
                    new RangeSumQueryImmutable.NumArrayBinaryIndexedTree(nums);
            RangeSumQueryImmutable.NumArraySparseTable sparseTable =
                    new RangeSumQueryImmutable.NumArraySparseTable(nums);
            RangeSumQueryImmutable.NumArraySimple simple =
                    new RangeSumQueryImmutable.NumArraySimple(nums);
            RangeSumQueryImmutable.NumArrayOptimized optimized =
                    new RangeSumQueryImmutable.NumArrayOptimized(nums);

            int result1 = prefixSum.sumRange(left, right);
            int result2 = segmentTree.sumRange(left, right);
            int result3 = bit.sumRange(left, right);
            int result4 = sparseTable.sumRange(left, right);
            int result5 = simple.sumRange(left, right);
            int result6 = optimized.sumRange(left, right);

            assertEquals(expected, result1, "Prefix Sum approach failed");
            assertEquals(expected, result2, "Segment Tree approach failed");
            assertEquals(expected, result3, "Binary Indexed Tree approach failed");
            assertEquals(expected, result4, "Sparse Table approach failed");
            assertEquals(expected, result5, "Simple approach failed");
            assertEquals(expected, result6, "Optimized approach failed");

            // All approaches should produce the same result
            assertEquals(result1, result2);
            assertEquals(result2, result3);
            assertEquals(result3, result4);
            assertEquals(result4, result5);
            assertEquals(result5, result6);
        }

        static Stream<Arguments> provideTestCases() {
            return Stream.of(Arguments.of(new int[] {-2, 0, 3, -5, 2, -1}, 0, 2, 1),
                    Arguments.of(new int[] {-2, 0, 3, -5, 2, -1}, 2, 5, -1),
                    Arguments.of(new int[] {-2, 0, 3, -5, 2, -1}, 0, 5, -3),
                    Arguments.of(new int[] {1, 2, 3, 4, 5}, 0, 4, 15),
                    Arguments.of(new int[] {1, 2, 3, 4, 5}, 0, 1, 3),
                    Arguments.of(new int[] {1, 2, 3, 4, 5}, 2, 3, 7),
                    Arguments.of(new int[] {42}, 0, 0, 42),
                    Arguments.of(new int[] {0, 0, 0, 0, 0}, 0, 4, 0),
                    Arguments.of(new int[] {-1, -2, -3, -4, -5}, 0, 4, -15),
                    Arguments.of(new int[] {1, -2, 3, -4, 5}, 0, 4, 3));
        }
    }

    @Nested
    @DisplayName("Edge Case Tests")
    class EdgeCaseTests {

        @Test
        @DisplayName("Maximum constraint test")
        void testMaximumConstraint() {
            int[] nums = new int[10000];
            for (int i = 0; i < 10000; i++) {
                nums[i] = i - 5000; // Mix of positive and negative numbers
            }

            RangeSumQueryImmutable.NumArrayOptimized numArray =
                    new RangeSumQueryImmutable.NumArrayOptimized(nums);

            assertEquals(-5000, numArray.sumRange(0, 0));
            assertEquals(4999, numArray.sumRange(9999, 9999));
            // Sum of all elements: sum of i from 0 to 9999 where i = i - 5000
            // This is sum of (i - 5000) from i=0 to 9999 = sum of i from 0 to 9999 - 5000*10000
            // = 9999*10000/2 - 5000*10000 = 49995000 - 50000000 = -5000
            assertEquals(-5000, numArray.sumRange(0, 9999)); // Sum of all elements
        }

        @Test
        @DisplayName("Large range queries")
        void testLargeRangeQueries() {
            int[] nums = new int[1000];
            for (int i = 0; i < 1000; i++) {
                nums[i] = 1; // All ones
            }

            RangeSumQueryImmutable.NumArrayOptimized numArray =
                    new RangeSumQueryImmutable.NumArrayOptimized(nums);

            assertEquals(1000, numArray.sumRange(0, 999));
            assertEquals(500, numArray.sumRange(0, 499));
            assertEquals(500, numArray.sumRange(500, 999));
        }

        @Test
        @DisplayName("Single element queries")
        void testSingleElementQueries() {
            int[] nums = {1, 2, 3, 4, 5};
            RangeSumQueryImmutable.NumArrayOptimized numArray =
                    new RangeSumQueryImmutable.NumArrayOptimized(nums);

            assertEquals(1, numArray.sumRange(0, 0));
            assertEquals(2, numArray.sumRange(1, 1));
            assertEquals(3, numArray.sumRange(2, 2));
            assertEquals(4, numArray.sumRange(3, 3));
            assertEquals(5, numArray.sumRange(4, 4));
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
                nums[i] = i - 5000;
            }

            long startTime, endTime;

            // Test prefix sum approach
            startTime = System.nanoTime();
            RangeSumQueryImmutable.NumArrayPrefixSum prefixSum =
                    new RangeSumQueryImmutable.NumArrayPrefixSum(nums);
            for (int i = 0; i < 1000; i++) {
                prefixSum.sumRange(0, 9999);
            }
            endTime = System.nanoTime();
            long prefixSumTime = endTime - startTime;

            // Test simple approach
            startTime = System.nanoTime();
            RangeSumQueryImmutable.NumArraySimple simple =
                    new RangeSumQueryImmutable.NumArraySimple(nums);
            for (int i = 0; i < 1000; i++) {
                simple.sumRange(0, 9999);
            }
            endTime = System.nanoTime();
            long simpleTime = endTime - startTime;

            // Test optimized approach
            startTime = System.nanoTime();
            RangeSumQueryImmutable.NumArrayOptimized optimized =
                    new RangeSumQueryImmutable.NumArrayOptimized(nums);
            for (int i = 0; i < 1000; i++) {
                optimized.sumRange(0, 9999);
            }
            endTime = System.nanoTime();
            long optimizedTime = endTime - startTime;

            System.out.println("Prefix Sum: " + prefixSumTime + " ns");
            System.out.println("Simple: " + simpleTime + " ns");
            System.out.println("Optimized: " + optimizedTime + " ns");

            // All approaches should complete in reasonable time
            assertTrue(prefixSumTime < 100_000_000); // Less than 100ms
            assertTrue(simpleTime < 100_000_000);
            assertTrue(optimizedTime < 100_000_000);
        }

        @Test
        @DisplayName("Memory efficiency test")
        void testMemoryEfficiency() {
            int[] nums = new int[1000];
            for (int i = 0; i < 1000; i++) {
                nums[i] = i;
            }

            // Test that all approaches produce the same result
            RangeSumQueryImmutable.NumArrayPrefixSum prefixSum =
                    new RangeSumQueryImmutable.NumArrayPrefixSum(nums);
            RangeSumQueryImmutable.NumArraySegmentTree segmentTree =
                    new RangeSumQueryImmutable.NumArraySegmentTree(nums);
            RangeSumQueryImmutable.NumArrayBinaryIndexedTree bit =
                    new RangeSumQueryImmutable.NumArrayBinaryIndexedTree(nums);
            RangeSumQueryImmutable.NumArraySparseTable sparseTable =
                    new RangeSumQueryImmutable.NumArraySparseTable(nums);
            RangeSumQueryImmutable.NumArraySimple simple =
                    new RangeSumQueryImmutable.NumArraySimple(nums);
            RangeSumQueryImmutable.NumArrayOptimized optimized =
                    new RangeSumQueryImmutable.NumArrayOptimized(nums);

            int result1 = prefixSum.sumRange(0, 999);
            int result2 = segmentTree.sumRange(0, 999);
            int result3 = bit.sumRange(0, 999);
            int result4 = sparseTable.sumRange(0, 999);
            int result5 = simple.sumRange(0, 999);
            int result6 = optimized.sumRange(0, 999);

            assertEquals(result1, result2);
            assertEquals(result2, result3);
            assertEquals(result3, result4);
            assertEquals(result4, result5);
            assertEquals(result5, result6);
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
                nums[i] = i + 1; // 1, 2, 3, ...
            }

            RangeSumQueryImmutable.NumArrayOptimized numArray =
                    new RangeSumQueryImmutable.NumArrayOptimized(nums);

            // Test full range
            int expectedSum = size * (size + 1) / 2; // Sum of 1 to size
            assertEquals(expectedSum, numArray.sumRange(0, size - 1));

            // Test partial ranges
            if (size > 1) {
                assertEquals(3, numArray.sumRange(0, 1)); // 1 + 2
                if (size > 2) {
                    assertEquals(6, numArray.sumRange(0, 2)); // 1 + 2 + 3
                }
            }
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
                nums[i] = (i % 2 == 0) ? 1 : -1; // Alternating 1 and -1
            }

            RangeSumQueryImmutable.NumArrayOptimized numArray =
                    new RangeSumQueryImmutable.NumArrayOptimized(nums);

            // Sum of alternating 1 and -1 should be 0
            assertEquals(0, numArray.sumRange(0, 9999));

            // Test various ranges
            assertEquals(1, numArray.sumRange(0, 0));
            assertEquals(-1, numArray.sumRange(1, 1));
            assertEquals(0, numArray.sumRange(0, 1));
        }

        @Test
        @DisplayName("Multiple query stress test")
        void testMultipleQueryStress() {
            int[] nums = new int[1000];
            for (int i = 0; i < 1000; i++) {
                nums[i] = i;
            }

            RangeSumQueryImmutable.NumArrayOptimized numArray =
                    new RangeSumQueryImmutable.NumArrayOptimized(nums);

            // Perform many queries
            for (int i = 0; i < 1000; i++) {
                for (int j = i; j < 1000; j++) {
                    int expectedSum = j * (j + 1) / 2 - (i > 0 ? (i - 1) * i / 2 : 0);
                    assertEquals(expectedSum, numArray.sumRange(i, j));
                }
            }
        }
    }
}
