package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Comprehensive test suite for MergeSortedArray (LeetCode 88)
 * 
 * This test suite validates all 6 different algorithmic approaches with extensive test cases
 * covering edge cases, performance scenarios, and cross-validation between approaches.
 */
@DisplayName("Merge Sorted Array Tests")
class MergeSortedArrayTest {

    private MergeSortedArray solution;

    @BeforeEach
    void setUp() {
        solution = new MergeSortedArray();
    }

    @Nested
    @DisplayName("Two Pointers from End Tests (Recommended Approach)")
    class TwoPointersFromEndTests {

        @Test
        @DisplayName("Basic merge with overlapping elements")
        void testBasicMerge() {
            int[] nums1 = {1, 2, 3, 0, 0, 0};
            int[] nums2 = {2, 5, 6};
            int[] expected = {1, 2, 2, 3, 5, 6};

            solution.merge(nums1, 3, nums2, 3);

            assertArrayEquals(expected, nums1);
        }

        @Test
        @DisplayName("nums1 has only one element")
        void testNums1SingleElement() {
            int[] nums1 = {1};
            int[] nums2 = {};
            int[] expected = {1};

            solution.merge(nums1, 1, nums2, 0);

            assertArrayEquals(expected, nums1);
        }

        @Test
        @DisplayName("nums2 has only one element")
        void testNums2SingleElement() {
            int[] nums1 = {0};
            int[] nums2 = {1};
            int[] expected = {1};

            solution.merge(nums1, 0, nums2, 1);

            assertArrayEquals(expected, nums1);
        }

        @Test
        @DisplayName("nums1 is empty")
        void testNums1Empty() {
            int[] nums1 = {0, 0};
            int[] nums2 = {1, 2};
            int[] expected = {1, 2};

            solution.merge(nums1, 0, nums2, 2);

            assertArrayEquals(expected, nums1);
        }

        @Test
        @DisplayName("nums2 is empty")
        void testNums2Empty() {
            int[] nums1 = {1, 2, 3, 0, 0};
            int[] nums2 = {};
            int[] expected = {1, 2, 3, 0, 0};

            solution.merge(nums1, 3, nums2, 0);

            assertArrayEquals(expected, nums1);
        }

        @Test
        @DisplayName("All elements in nums1 are smaller")
        void testNums1AllSmaller() {
            int[] nums1 = {1, 2, 3, 0, 0, 0};
            int[] nums2 = {4, 5, 6};
            int[] expected = {1, 2, 3, 4, 5, 6};

            solution.merge(nums1, 3, nums2, 3);

            assertArrayEquals(expected, nums1);
        }

        @Test
        @DisplayName("All elements in nums2 are smaller")
        void testNums2AllSmaller() {
            int[] nums1 = {4, 5, 6, 0, 0, 0};
            int[] nums2 = {1, 2, 3};
            int[] expected = {1, 2, 3, 4, 5, 6};

            solution.merge(nums1, 3, nums2, 3);

            assertArrayEquals(expected, nums1);
        }

        @Test
        @DisplayName("Single elements merge")
        void testSingleElements() {
            int[] nums1 = {2, 0};
            int[] nums2 = {1};
            int[] expected = {1, 2};

            solution.merge(nums1, 1, nums2, 1);

            assertArrayEquals(expected, nums1);
        }

        @Test
        @DisplayName("Negative numbers")
        void testNegativeNumbers() {
            int[] nums1 = {-1, 0, 0, 3, 3, 3, 0, 0, 0};
            int[] nums2 = {1, 2, 2};
            int[] expected = {-1, 0, 0, 1, 2, 2, 3, 3, 3};

            solution.merge(nums1, 6, nums2, 3);

            assertArrayEquals(expected, nums1);
        }

        @Test
        @DisplayName("Duplicate elements")
        void testDuplicateElements() {
            int[] nums1 = {1, 1, 1, 0, 0, 0};
            int[] nums2 = {1, 1, 1};
            int[] expected = {1, 1, 1, 1, 1, 1};

            solution.merge(nums1, 3, nums2, 3);

            assertArrayEquals(expected, nums1);
        }

        @Test
        @DisplayName("Large numbers")
        void testLargeNumbers() {
            int[] nums1 = {1000000000, 0};
            int[] nums2 = {1000000000};
            int[] expected = {1000000000, 1000000000};

            solution.merge(nums1, 1, nums2, 1);

            assertArrayEquals(expected, nums1);
        }

        @Test
        @DisplayName("Edge case with zeros")
        void testEdgeCaseWithZeros() {
            int[] nums1 = {0, 0, 0, 0, 0};
            int[] nums2 = {1, 2, 3, 4, 5};
            int[] expected = {1, 2, 3, 4, 5};

            solution.merge(nums1, 0, nums2, 5);

            assertArrayEquals(expected, nums1);
        }

        @Test
        @DisplayName("All same values")
        void testAllSameValues() {
            int[] nums1 = {5, 5, 5, 0, 0, 0};
            int[] nums2 = {5, 5, 5};
            int[] expected = {5, 5, 5, 5, 5, 5};

            solution.merge(nums1, 3, nums2, 3);

            assertArrayEquals(expected, nums1);
        }
    }

    @Nested
    @DisplayName("Copy and Sort Tests")
    class CopyAndSortTests {

        @Test
        @DisplayName("Basic merge with copy and sort")
        void testBasicMerge() {
            int[] nums1 = {1, 2, 3, 0, 0, 0};
            int[] nums2 = {2, 5, 6};
            int[] expected = {1, 2, 2, 3, 5, 6};

            solution.mergeCopyAndSort(nums1, 3, nums2, 3);

            assertArrayEquals(expected, nums1);
        }

        @Test
        @DisplayName("Single element merge")
        void testSingleElement() {
            int[] nums1 = {0};
            int[] nums2 = {1};
            int[] expected = {1};

            solution.mergeCopyAndSort(nums1, 0, nums2, 1);

            assertArrayEquals(expected, nums1);
        }

        @Test
        @DisplayName("Empty nums2")
        void testEmptyNums2() {
            int[] nums1 = {1, 2, 3, 0, 0};
            int[] nums2 = {};
            int[] expected = {1, 2, 3, 0, 0};

            solution.mergeCopyAndSort(nums1, 3, nums2, 0);

            assertArrayEquals(expected, nums1);
        }
    }

    @Nested
    @DisplayName("Auxiliary Array Tests")
    class AuxiliaryArrayTests {

        @Test
        @DisplayName("Basic merge with auxiliary array")
        void testBasicMerge() {
            int[] nums1 = {1, 2, 3, 0, 0, 0};
            int[] nums2 = {2, 5, 6};
            int[] expected = {1, 2, 2, 3, 5, 6};

            solution.mergeAuxiliaryArray(nums1, 3, nums2, 3);

            assertArrayEquals(expected, nums1);
        }

        @Test
        @DisplayName("Single element merge")
        void testSingleElement() {
            int[] nums1 = {0};
            int[] nums2 = {1};
            int[] expected = {1};

            solution.mergeAuxiliaryArray(nums1, 0, nums2, 1);

            assertArrayEquals(expected, nums1);
        }

        @Test
        @DisplayName("Empty nums2")
        void testEmptyNums2() {
            int[] nums1 = {1, 2, 3, 0, 0};
            int[] nums2 = {};
            int[] expected = {1, 2, 3, 0, 0};

            solution.mergeAuxiliaryArray(nums1, 3, nums2, 0);

            assertArrayEquals(expected, nums1);
        }
    }

    @Nested
    @DisplayName("Two Pointers from Start Tests")
    class TwoPointersFromStartTests {

        @Test
        @DisplayName("Basic merge with two pointers from start")
        void testBasicMerge() {
            int[] nums1 = {1, 2, 3, 0, 0, 0};
            int[] nums2 = {2, 5, 6};
            int[] expected = {1, 2, 2, 3, 5, 6};

            solution.mergeTwoPointersFromStart(nums1, 3, nums2, 3);

            assertArrayEquals(expected, nums1);
        }

        @Test
        @DisplayName("Single element merge")
        void testSingleElement() {
            int[] nums1 = {0};
            int[] nums2 = {1};
            int[] expected = {1};

            solution.mergeTwoPointersFromStart(nums1, 0, nums2, 1);

            assertArrayEquals(expected, nums1);
        }

        @Test
        @DisplayName("Empty nums2")
        void testEmptyNums2() {
            int[] nums1 = {1, 2, 3, 0, 0};
            int[] nums2 = {};
            int[] expected = {1, 2, 3, 0, 0};

            solution.mergeTwoPointersFromStart(nums1, 3, nums2, 0);

            assertArrayEquals(expected, nums1);
        }
    }

    @Nested
    @DisplayName("Optimized Two Pointers Tests")
    class OptimizedTwoPointersTests {

        @Test
        @DisplayName("Basic merge with optimized approach")
        void testBasicMerge() {
            int[] nums1 = {1, 2, 3, 0, 0, 0};
            int[] nums2 = {2, 5, 6};
            int[] expected = {1, 2, 2, 3, 5, 6};

            solution.mergeOptimized(nums1, 3, nums2, 3);

            assertArrayEquals(expected, nums1);
        }

        @Test
        @DisplayName("Single element merge")
        void testSingleElement() {
            int[] nums1 = {0};
            int[] nums2 = {1};
            int[] expected = {1};

            solution.mergeOptimized(nums1, 0, nums2, 1);

            assertArrayEquals(expected, nums1);
        }

        @Test
        @DisplayName("Empty nums2")
        void testEmptyNums2() {
            int[] nums1 = {1, 2, 3, 0, 0};
            int[] nums2 = {};
            int[] expected = {1, 2, 3, 0, 0};

            solution.mergeOptimized(nums1, 3, nums2, 0);

            assertArrayEquals(expected, nums1);
        }
    }

    @Nested
    @DisplayName("Recursive Merge Tests")
    class RecursiveMergeTests {

        @Test
        @DisplayName("Basic merge with recursive approach")
        void testBasicMerge() {
            int[] nums1 = {1, 2, 3, 0, 0, 0};
            int[] nums2 = {2, 5, 6};
            int[] expected = {1, 2, 2, 3, 5, 6};

            solution.mergeRecursive(nums1, 3, nums2, 3);

            assertArrayEquals(expected, nums1);
        }

        @Test
        @DisplayName("Single element merge")
        void testSingleElement() {
            int[] nums1 = {0};
            int[] nums2 = {1};
            int[] expected = {1};

            solution.mergeRecursive(nums1, 0, nums2, 1);

            assertArrayEquals(expected, nums1);
        }

        @Test
        @DisplayName("Empty nums2")
        void testEmptyNums2() {
            int[] nums1 = {1, 2, 3, 0, 0};
            int[] nums2 = {};
            int[] expected = {1, 2, 3, 0, 0};

            solution.mergeRecursive(nums1, 3, nums2, 0);

            assertArrayEquals(expected, nums1);
        }
    }

    @Nested
    @DisplayName("Cross-Approach Consistency Tests")
    class CrossApproachConsistencyTests {

        @ParameterizedTest
        @MethodSource("com.example.leetcode.MergeSortedArrayTest#createTestCases")
        @DisplayName("All approaches produce identical results")
        void testAllApproachesConsistency(MergeSortedArray.TestCase testCase) {
            // Test all approaches
            int[] result1 = testCase.nums1.clone();
            int[] result2 = testCase.nums1.clone();
            int[] result3 = testCase.nums1.clone();
            int[] result4 = testCase.nums1.clone();
            int[] result5 = testCase.nums1.clone();
            int[] result6 = testCase.nums1.clone();

            solution.merge(result1, testCase.m, testCase.nums2, testCase.n);
            solution.mergeCopyAndSort(result2, testCase.m, testCase.nums2, testCase.n);
            solution.mergeAuxiliaryArray(result3, testCase.m, testCase.nums2, testCase.n);
            solution.mergeTwoPointersFromStart(result4, testCase.m, testCase.nums2, testCase.n);
            solution.mergeOptimized(result5, testCase.m, testCase.nums2, testCase.n);
            solution.mergeRecursive(result6, testCase.m, testCase.nums2, testCase.n);

            // All results should be identical
            assertArrayEquals(testCase.expected, result1, "Two pointers from end failed");
            assertArrayEquals(testCase.expected, result2, "Copy and sort failed");
            assertArrayEquals(testCase.expected, result3, "Auxiliary array failed");
            assertArrayEquals(testCase.expected, result4, "Two pointers from start failed");
            assertArrayEquals(testCase.expected, result5, "Optimized approach failed");
            assertArrayEquals(testCase.expected, result6, "Recursive approach failed");

            // All results should be identical to each other
            assertArrayEquals(result1, result2, "Results 1 and 2 differ");
            assertArrayEquals(result1, result3, "Results 1 and 3 differ");
            assertArrayEquals(result1, result4, "Results 1 and 4 differ");
            assertArrayEquals(result1, result5, "Results 1 and 5 differ");
            assertArrayEquals(result1, result6, "Results 1 and 6 differ");
        }
    }

    @Nested
    @DisplayName("Edge Cases and Boundary Tests")
    class EdgeCasesAndBoundaryTests {

        @Test
        @DisplayName("Minimum constraint test")
        void testMinimumConstraint() {
            int[] nums1 = {1, 0};
            int[] nums2 = {2};
            int[] expected = {1, 2};

            solution.merge(nums1, 1, nums2, 1);

            assertArrayEquals(expected, nums1);
        }

        @Test
        @DisplayName("Maximum constraint test (200 elements)")
        void testMaximumConstraint() {
            int[] nums1 = new int[200];
            int[] nums2 = new int[100];

            // Fill nums1 with first 100 elements
            for (int i = 0; i < 100; i++) {
                nums1[i] = i + 1;
            }

            // Fill nums2 with next 100 elements
            for (int i = 0; i < 100; i++) {
                nums2[i] = i + 101;
            }

            solution.merge(nums1, 100, nums2, 100);

            // Verify result is sorted
            assertTrue(solution.isSorted(nums1), "Result should be sorted");

            // Verify all elements are present
            for (int i = 0; i < 200; i++) {
                assertEquals(i + 1, nums1[i], "Element at index " + i + " should be " + (i + 1));
            }
        }

        @Test
        @DisplayName("All negative numbers")
        void testAllNegativeNumbers() {
            int[] nums1 = {-5, -3, -1, 0, 0, 0};
            int[] nums2 = {-4, -2, 0};
            int[] expected = {-5, -4, -3, -2, -1, 0};

            solution.merge(nums1, 3, nums2, 3);

            assertArrayEquals(expected, nums1);
        }

        @Test
        @DisplayName("Mixed positive and negative")
        void testMixedPositiveNegative() {
            int[] nums1 = {-2, 0, 0, 3, 0, 0, 0};
            int[] nums2 = {-1, 1, 2};
            int[] expected = {-2, -1, 0, 0, 1, 2, 3};

            solution.merge(nums1, 4, nums2, 3);

            assertArrayEquals(expected, nums1);
        }

        @Test
        @DisplayName("Zero values")
        void testZeroValues() {
            int[] nums1 = {0, 0, 0, 0, 0};
            int[] nums2 = {0, 0, 0};
            int[] expected = {0, 0, 0, 0, 0};

            solution.merge(nums1, 2, nums2, 3);

            assertArrayEquals(expected, nums1);
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Performance comparison between approaches")
        void testPerformanceComparison() {
            // Create large test case
            int[] nums1 = new int[200];
            int[] nums2 = new int[100];

            for (int i = 0; i < 100; i++) {
                nums1[i] = i * 2;
                nums2[i] = i * 2 + 1;
            }

            // Measure execution time for each approach
            long time1 = solution.measureExecutionTime(() -> {
                int[] test1 = nums1.clone();
                solution.merge(test1, 100, nums2, 100);
            });

            long time2 = solution.measureExecutionTime(() -> {
                int[] test2 = nums1.clone();
                solution.mergeCopyAndSort(test2, 100, nums2, 100);
            });

            long time3 = solution.measureExecutionTime(() -> {
                int[] test3 = nums1.clone();
                solution.mergeAuxiliaryArray(test3, 100, nums2, 100);
            });

            long time4 = solution.measureExecutionTime(() -> {
                int[] test4 = nums1.clone();
                solution.mergeTwoPointersFromStart(test4, 100, nums2, 100);
            });

            long time5 = solution.measureExecutionTime(() -> {
                int[] test5 = nums1.clone();
                solution.mergeOptimized(test5, 100, nums2, 100);
            });

            long time6 = solution.measureExecutionTime(() -> {
                int[] test6 = nums1.clone();
                solution.mergeRecursive(test6, 100, nums2, 100);
            });

            // Print performance results (for debugging/analysis)
            System.out.println("Performance Results (nanoseconds):");
            System.out.println("Two Pointers from End: " + time1);
            System.out.println("Copy and Sort: " + time2);
            System.out.println("Auxiliary Array: " + time3);
            System.out.println("Two Pointers from Start: " + time4);
            System.out.println("Optimized: " + time5);
            System.out.println("Recursive: " + time6);

            // Verify all approaches complete successfully
            assertTrue(time1 > 0, "Two pointers from end should complete");
            assertTrue(time2 > 0, "Copy and sort should complete");
            assertTrue(time3 > 0, "Auxiliary array should complete");
            assertTrue(time4 > 0, "Two pointers from start should complete");
            assertTrue(time5 > 0, "Optimized should complete");
            assertTrue(time6 > 0, "Recursive should complete");
        }
    }

    @Nested
    @DisplayName("Utility Method Tests")
    class UtilityMethodTests {

        @Test
        @DisplayName("Array equality test")
        void testArrayEquality() {
            int[] arr1 = {1, 2, 3};
            int[] arr2 = {1, 2, 3};
            int[] arr3 = {1, 2, 4};
            int[] arr4 = {1, 2};

            assertTrue(solution.arraysEqual(arr1, arr2), "Identical arrays should be equal");
            assertFalse(solution.arraysEqual(arr1, arr3), "Different arrays should not be equal");
            assertFalse(solution.arraysEqual(arr1, arr4),
                    "Different length arrays should not be equal");
        }

        @Test
        @DisplayName("Array sorting validation")
        void testArraySorting() {
            int[] sorted = {1, 2, 3, 4, 5};
            int[] unsorted = {1, 3, 2, 4, 5};
            int[] single = {1};
            int[] empty = {};

            assertTrue(solution.isSorted(sorted), "Sorted array should be valid");
            assertFalse(solution.isSorted(unsorted), "Unsorted array should be invalid");
            assertTrue(solution.isSorted(single), "Single element array should be valid");
            assertTrue(solution.isSorted(empty), "Empty array should be valid");
        }

        @Test
        @DisplayName("Array statistics")
        void testArrayStatistics() {
            int[] arr = {1, 3, 2, 4, 5};
            String stats = solution.getArrayStatistics(arr);

            assertTrue(stats.contains("Length=5"), "Stats should contain length");
            assertTrue(stats.contains("Min=1"), "Stats should contain min value");
            assertTrue(stats.contains("Max=5"), "Stats should contain max value");
            assertTrue(stats.contains("Sum=15"), "Stats should contain sum");
            assertTrue(stats.contains("IsSorted=false"), "Stats should indicate sorting status");
        }

        @Test
        @DisplayName("Test case creation")
        void testTestCaseCreation() {
            MergeSortedArray.TestCase testCase = MergeSortedArray
                    .createTestCase(new int[] {1, 2, 3, 0, 0, 0}, 3, new int[] {2, 5, 6}, 3);

            assertArrayEquals(new int[] {1, 2, 3, 0, 0, 0}, testCase.nums1);
            assertEquals(3, testCase.m);
            assertArrayEquals(new int[] {2, 5, 6}, testCase.nums2);
            assertEquals(3, testCase.n);
            assertArrayEquals(new int[] {1, 2, 2, 3, 5, 6}, testCase.expected);
        }
    }

    @Nested
    @DisplayName("Comprehensive Test Cases")
    class ComprehensiveTestCases {

        @ParameterizedTest
        @MethodSource("com.example.leetcode.MergeSortedArrayTest#createTestCases")
        @DisplayName("Comprehensive test case validation")
        void testComprehensiveCases(MergeSortedArray.TestCase testCase) {
            // Test the recommended approach
            int[] result = testCase.nums1.clone();
            solution.merge(result, testCase.m, testCase.nums2, testCase.n);

            // Verify result matches expected
            assertArrayEquals(testCase.expected, result,
                    "Test case failed: " + solution.arrayToString(testCase.nums1) + " + "
                            + solution.arrayToString(testCase.nums2));

            // Verify result is sorted (only check the merged portion)
            assertTrue(solution.isSorted(result, testCase.m + testCase.n), "Result should be sorted");

            // Verify array statistics
            String stats = solution.getArrayStatistics(result);
            assertNotNull(stats, "Statistics should not be null");
            assertTrue(stats.length() > 0, "Statistics should not be empty");
        }
    }

    /**
     * Create comprehensive test cases for parameterized testing
     */
    static Stream<MergeSortedArray.TestCase> createTestCases() {
        return Stream.of(MergeSortedArray.createTestCases());
    }
}
