package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Comprehensive test suite for Two Sum problem (LeetCode #1)
 * 
 * Test Categories: 1. LeetCode Examples - Official test cases 2. Basic Functionality - Core
 * algorithm tests 3. Edge Cases - Boundary conditions 4. Special Values - Zeros, negatives,
 * duplicates 5. Performance Tests - Large inputs 6. Approach Comparison - Verify all approaches
 * produce same results 7. Utility Methods - Helper function tests
 */
@DisplayName("Two Sum - All Test Cases")
public class TwoSumTest {

    private TwoSum solution;

    @BeforeEach
    void setUp() {
        solution = new TwoSum();
    }

    // ========================================
    // LEETCODE EXAMPLE TESTS
    // ========================================

    @Nested
    @DisplayName("LeetCode Official Examples")
    class LeetCodeExamplesTests {

        @Test
        @DisplayName("Example 1: [2,7,11,15], target=9 -> [0,1]")
        void testExample1() {
            int[] nums = {2, 7, 11, 15};
            int target = 9;
            int[] result = solution.twoSum(nums, target);

            assertNotNull(result);
            assertEquals(2, result.length);
            assertTrue(solution.isValidSolution(nums, target, result));
            assertEquals(9, nums[result[0]] + nums[result[1]]);
        }

        @Test
        @DisplayName("Example 2: [3,2,4], target=6 -> [1,2]")
        void testExample2() {
            int[] nums = {3, 2, 4};
            int target = 6;
            int[] result = solution.twoSum(nums, target);

            assertNotNull(result);
            assertEquals(2, result.length);
            assertTrue(solution.isValidSolution(nums, target, result));

            // Should return indices 1 and 2 (values 2 and 4)
            assertTrue((result[0] == 1 && result[1] == 2) || (result[0] == 2 && result[1] == 1));
        }

        @Test
        @DisplayName("Example 3: [3,3], target=6 -> [0,1]")
        void testExample3() {
            int[] nums = {3, 3};
            int target = 6;
            int[] result = solution.twoSum(nums, target);

            assertNotNull(result);
            assertEquals(2, result.length);
            assertTrue(solution.isValidSolution(nums, target, result));
            assertEquals(6, nums[result[0]] + nums[result[1]]);
        }
    }

    // ========================================
    // BASIC FUNCTIONALITY TESTS
    // ========================================

    @Nested
    @DisplayName("Basic Functionality Tests")
    class BasicFunctionalityTests {

        @Test
        @DisplayName("Simple two elements array")
        void testTwoElements() {
            int[] nums = {1, 2};
            int target = 3;
            int[] result = solution.twoSum(nums, target);

            assertTrue(solution.isValidSolution(nums, target, result));
            assertEquals(0, result[0]);
            assertEquals(1, result[1]);
        }

        @Test
        @DisplayName("Solution at beginning of array")
        void testSolutionAtBeginning() {
            int[] nums = {5, 10, 2, 3, 4};
            int target = 15;
            int[] result = solution.twoSum(nums, target);

            assertTrue(solution.isValidSolution(nums, target, result));
            assertTrue((result[0] == 0 && result[1] == 1) || (result[0] == 1 && result[1] == 0));
        }

        @Test
        @DisplayName("Solution at end of array")
        void testSolutionAtEnd() {
            int[] nums = {1, 2, 3, 4, 5};
            int target = 9;
            int[] result = solution.twoSum(nums, target);

            assertTrue(solution.isValidSolution(nums, target, result));
            assertTrue((result[0] == 3 && result[1] == 4) || (result[0] == 4 && result[1] == 3));
        }

        @Test
        @DisplayName("Solution in middle of array")
        void testSolutionInMiddle() {
            int[] nums = {1, 5, 7, 3, 9};
            int target = 10;
            int[] result = solution.twoSum(nums, target);

            assertTrue(solution.isValidSolution(nums, target, result));
        }
    }

    // ========================================
    // EDGE CASES TESTS
    // ========================================

    @Nested
    @DisplayName("Edge Cases")
    class EdgeCasesTests {

        @Test
        @DisplayName("Minimum array size (2 elements)")
        void testMinimumSize() {
            int[] nums = {10, 20};
            int target = 30;
            int[] result = solution.twoSum(nums, target);

            assertTrue(solution.isValidSolution(nums, target, result));
        }

        @Test
        @DisplayName("Large array with many elements")
        void testLargeArray() {
            int[] nums = new int[100];
            for (int i = 0; i < 100; i++) {
                nums[i] = i + 1;
            }
            int target = 199; // Last two elements: 99 + 100
            int[] result = solution.twoSum(nums, target);

            assertTrue(solution.isValidSolution(nums, target, result));
        }

        @Test
        @DisplayName("All same values except two")
        void testAllSameExceptTwo() {
            int[] nums = {5, 5, 5, 5, 3, 5, 5, 7};
            int target = 10;
            int[] result = solution.twoSum(nums, target);

            assertTrue(solution.isValidSolution(nums, target, result));
        }
    }

    // ========================================
    // SPECIAL VALUES TESTS
    // ========================================

    @Nested
    @DisplayName("Special Values Tests")
    class SpecialValuesTests {

        @Test
        @DisplayName("Array with zeros")
        void testWithZeros() {
            int[] nums = {0, 4, 3, 0};
            int target = 0;
            int[] result = solution.twoSum(nums, target);

            assertTrue(solution.isValidSolution(nums, target, result));
            assertTrue((result[0] == 0 && result[1] == 3) || (result[0] == 3 && result[1] == 0));
        }

        @Test
        @DisplayName("Array with single zero")
        void testWithSingleZero() {
            int[] nums = {0, 1, 2, 3};
            int target = 3;
            int[] result = solution.twoSum(nums, target);

            assertTrue(solution.isValidSolution(nums, target, result));
        }

        @Test
        @DisplayName("All negative numbers")
        void testAllNegative() {
            int[] nums = {-1, -2, -3, -4, -5};
            int target = -8;
            int[] result = solution.twoSum(nums, target);

            assertTrue(solution.isValidSolution(nums, target, result));
        }

        @Test
        @DisplayName("Mixed positive and negative")
        void testMixedPositiveNegative() {
            int[] nums = {-3, 4, 3, 90};
            int target = 0;
            int[] result = solution.twoSum(nums, target);

            assertTrue(solution.isValidSolution(nums, target, result));
            assertTrue((result[0] == 0 && result[1] == 2) || (result[0] == 2 && result[1] == 0));
        }

        @Test
        @DisplayName("Negative target")
        void testNegativeTarget() {
            int[] nums = {1, -3, 5, -7};
            int target = -2;
            int[] result = solution.twoSum(nums, target);

            assertTrue(solution.isValidSolution(nums, target, result));
        }

        @Test
        @DisplayName("Duplicate values in array")
        void testDuplicateValues() {
            int[] nums = {2, 5, 5, 11};
            int target = 10;
            int[] result = solution.twoSum(nums, target);

            assertTrue(solution.isValidSolution(nums, target, result));
            assertTrue((result[0] == 1 && result[1] == 2) || (result[0] == 2 && result[1] == 1));
        }

        @Test
        @DisplayName("Large positive and negative values")
        void testLargeValues() {
            int[] nums = {1000000000, -1000000000, 500000000, -500000000};
            int target = 0;
            int[] result = solution.twoSum(nums, target);

            assertTrue(solution.isValidSolution(nums, target, result));
        }
    }

    // ========================================
    // PARAMETERIZED TESTS
    // ========================================

    @Nested
    @DisplayName("Parameterized Tests")
    class ParameterizedTests {

        @ParameterizedTest(name = "Test {index}: nums={0}, target={1}")
        @MethodSource("com.example.leetcode.TwoSumTest#provideTwoSumTestCases")
        @DisplayName("Various input combinations")
        void testVariousInputs(int[] nums, int target) {
            int[] result = solution.twoSum(nums, target);
            assertTrue(solution.isValidSolution(nums, target, result),
                    "Failed for nums=" + Arrays.toString(nums) + ", target=" + target);
        }
    }

    static Stream<Arguments> provideTwoSumTestCases() {
        return Stream.of(Arguments.of(new int[] {2, 7, 11, 15}, 9),
                Arguments.of(new int[] {3, 2, 4}, 6), Arguments.of(new int[] {3, 3}, 6),
                Arguments.of(new int[] {1, 2, 3, 4, 5}, 9),
                Arguments.of(new int[] {-1, -2, -3, -4}, -6),
                Arguments.of(new int[] {0, 4, 3, 0}, 0), Arguments.of(new int[] {-3, 4, 3, 90}, 0),
                Arguments.of(new int[] {1, 5, 7, 3, 9}, 10));
    }

    // ========================================
    // APPROACH COMPARISON TESTS
    // ========================================

    @Nested
    @DisplayName("Cross-Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @Test
        @DisplayName("All approaches return valid solution - Example 1")
        void testAllApproachesExample1() {
            int[] nums = {2, 7, 11, 15};
            int target = 9;

            int[] result1 = solution.twoSum(nums, target);
            int[] result2 = solution.twoSumTwoPass(nums, target);
            int[] result3 = solution.twoSumBruteForce(nums, target);
            int[] result4 = solution.twoSumSortingTwoPointers(nums, target);

            assertTrue(solution.isValidSolution(nums, target, result1));
            assertTrue(solution.isValidSolution(nums, target, result2));
            assertTrue(solution.isValidSolution(nums, target, result3));
            assertTrue(solution.isValidSolution(nums, target, result4));
        }

        @Test
        @DisplayName("All approaches return valid solution - Negative numbers")
        void testAllApproachesNegative() {
            int[] nums = {-1, -2, -3, -4, -5};
            int target = -8;

            int[] result1 = solution.twoSum(nums, target);
            int[] result2 = solution.twoSumTwoPass(nums, target);
            int[] result3 = solution.twoSumBruteForce(nums, target);
            int[] result4 = solution.twoSumSortingTwoPointers(nums, target);

            assertTrue(solution.isValidSolution(nums, target, result1));
            assertTrue(solution.isValidSolution(nums, target, result2));
            assertTrue(solution.isValidSolution(nums, target, result3));
            assertTrue(solution.isValidSolution(nums, target, result4));
        }

        @Test
        @DisplayName("All approaches return valid solution - Duplicates")
        void testAllApproachesDuplicates() {
            int[] nums = {3, 3};
            int target = 6;

            int[] result1 = solution.twoSum(nums, target);
            int[] result2 = solution.twoSumTwoPass(nums, target);
            int[] result3 = solution.twoSumBruteForce(nums, target);
            int[] result4 = solution.twoSumSortingTwoPointers(nums, target);

            assertTrue(solution.isValidSolution(nums, target, result1));
            assertTrue(solution.isValidSolution(nums, target, result2));
            assertTrue(solution.isValidSolution(nums, target, result3));
            assertTrue(solution.isValidSolution(nums, target, result4));
        }

        @Test
        @DisplayName("All approaches consistency test with random data")
        void testAllApproachesConsistency() {
            int[] nums = {10, 15, 3, 7, 20, 5, 12};
            int target = 17;

            int[] result1 = solution.twoSum(nums, target);
            int[] result2 = solution.twoSumTwoPass(nums, target);
            int[] result3 = solution.twoSumBruteForce(nums, target);
            int[] result4 = solution.twoSumSortingTwoPointers(nums, target);

            // All should be valid solutions
            assertTrue(solution.isValidSolution(nums, target, result1));
            assertTrue(solution.isValidSolution(nums, target, result2));
            assertTrue(solution.isValidSolution(nums, target, result3));
            assertTrue(solution.isValidSolution(nums, target, result4));
        }
    }

    // ========================================
    // PERFORMANCE TESTS
    // ========================================

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Performance: Hash Map approach with 10,000 elements")
        void testHashMapPerformance() {
            int[] nums = new int[10000];
            for (int i = 0; i < 10000; i++) {
                nums[i] = i;
            }
            int target = 19997; // Last two elements: 9998 + 9999

            long startTime = System.nanoTime();
            int[] result = solution.twoSum(nums, target);
            long endTime = System.nanoTime();

            assertTrue(solution.isValidSolution(nums, target, result));
            long duration = endTime - startTime;
            System.out.println("Hash Map One Pass: " + duration / 1_000_000.0 + " ms");
        }

        @Test
        @DisplayName("Performance: Brute Force approach with 1,000 elements")
        void testBruteForcePerformance() {
            int[] nums = new int[1000];
            for (int i = 0; i < 1000; i++) {
                nums[i] = i;
            }
            int target = 1997; // Last two elements: 998 + 999

            long startTime = System.nanoTime();
            int[] result = solution.twoSumBruteForce(nums, target);
            long endTime = System.nanoTime();

            assertTrue(solution.isValidSolution(nums, target, result));
            long duration = endTime - startTime;
            System.out.println("Brute Force: " + duration / 1_000_000.0 + " ms");
        }

        @Test
        @DisplayName("Performance: Compare all approaches with 1,000 elements")
        void testPerformanceComparison() {
            int[] nums = new int[1000];
            for (int i = 0; i < 1000; i++) {
                nums[i] = i + 1;
            }
            int target = 1999;

            // Hash Map One Pass
            long start1 = System.nanoTime();
            int[] result1 = solution.twoSum(nums, target);
            long end1 = System.nanoTime();

            // Hash Map Two Pass
            long start2 = System.nanoTime();
            int[] result2 = solution.twoSumTwoPass(nums, target);
            long end2 = System.nanoTime();

            // Brute Force
            long start3 = System.nanoTime();
            int[] result3 = solution.twoSumBruteForce(nums, target);
            long end3 = System.nanoTime();

            // Sorting + Two Pointers
            long start4 = System.nanoTime();
            int[] result4 = solution.twoSumSortingTwoPointers(nums, target);
            long end4 = System.nanoTime();

            System.out.println("\n=== Performance Comparison (1000 elements) ===");
            System.out.println("Hash Map One Pass:       " + (end1 - start1) / 1_000_000.0 + " ms");
            System.out.println("Hash Map Two Pass:       " + (end2 - start2) / 1_000_000.0 + " ms");
            System.out.println("Brute Force:             " + (end3 - start3) / 1_000_000.0 + " ms");
            System.out.println("Sorting + Two Pointers:  " + (end4 - start4) / 1_000_000.0 + " ms");

            assertTrue(solution.isValidSolution(nums, target, result1));
            assertTrue(solution.isValidSolution(nums, target, result2));
            assertTrue(solution.isValidSolution(nums, target, result3));
            assertTrue(solution.isValidSolution(nums, target, result4));
        }
    }

    // ========================================
    // UTILITY METHODS TESTS
    // ========================================

    @Nested
    @DisplayName("Utility Methods Tests")
    class UtilityMethodsTests {

        @Test
        @DisplayName("isValidSolution - valid solution")
        void testIsValidSolutionValid() {
            int[] nums = {2, 7, 11, 15};
            int target = 9;
            int[] result = {0, 1};

            assertTrue(solution.isValidSolution(nums, target, result));
        }

        @Test
        @DisplayName("isValidSolution - invalid solution (wrong sum)")
        void testIsValidSolutionWrongSum() {
            int[] nums = {2, 7, 11, 15};
            int target = 10;
            int[] result = {0, 1}; // 2 + 7 = 9, not 10

            assertFalse(solution.isValidSolution(nums, target, result));
        }

        @Test
        @DisplayName("isValidSolution - same index used twice")
        void testIsValidSolutionSameIndex() {
            int[] nums = {2, 7, 11, 15};
            int target = 9;
            int[] result = {1, 1}; // Same index

            assertFalse(solution.isValidSolution(nums, target, result));
        }

        @Test
        @DisplayName("isValidSolution - out of bounds index")
        void testIsValidSolutionOutOfBounds() {
            int[] nums = {2, 7, 11, 15};
            int target = 9;
            int[] result = {0, 5}; // Index 5 is out of bounds

            assertFalse(solution.isValidSolution(nums, target, result));
        }

        @Test
        @DisplayName("areResultsEqual - same order")
        void testAreResultsEqualSameOrder() {
            int[] result1 = {0, 1};
            int[] result2 = {0, 1};

            assertTrue(solution.areResultsEqual(result1, result2));
        }

        @Test
        @DisplayName("areResultsEqual - different order")
        void testAreResultsEqualDifferentOrder() {
            int[] result1 = {0, 1};
            int[] result2 = {1, 0};

            assertTrue(solution.areResultsEqual(result1, result2));
        }

        @Test
        @DisplayName("areResultsEqual - different values")
        void testAreResultsEqualDifferentValues() {
            int[] result1 = {0, 1};
            int[] result2 = {2, 3};

            assertFalse(solution.areResultsEqual(result1, result2));
        }

        @Test
        @DisplayName("formatResult - valid result")
        void testFormatResult() {
            int[] nums = {2, 7, 11, 15};
            int target = 9;
            int[] result = {0, 1};

            String formatted = solution.formatResult(nums, target, result);

            assertNotNull(formatted);
            assertTrue(formatted.contains("0"));
            assertTrue(formatted.contains("1"));
            assertTrue(formatted.contains("2"));
            assertTrue(formatted.contains("7"));
            assertTrue(formatted.contains("9"));
        }

        @Test
        @DisplayName("formatResult - empty result")
        void testFormatResultEmpty() {
            int[] nums = {2, 7, 11, 15};
            int target = 100;
            int[] result = {};

            String formatted = solution.formatResult(nums, target, result);

            assertNotNull(formatted);
            assertTrue(formatted.contains("No solution"));
        }
    }

    // ========================================
    // STRESS TESTS
    // ========================================

    @Nested
    @DisplayName("Stress Tests")
    class StressTests {

        @Test
        @DisplayName("Maximum constraint size (10,000 elements)")
        void testMaximumConstraintSize() {
            int[] nums = new int[10000];
            for (int i = 0; i < 10000; i++) {
                nums[i] = i;
            }
            int target = 19997; // Last two elements: 9998 + 9999

            int[] result = solution.twoSum(nums, target);
            assertTrue(solution.isValidSolution(nums, target, result));
        }

        @Test
        @DisplayName("Large values near constraints")
        void testLargeValuesNearConstraints() {
            int[] nums = {1000000000, -1000000000, 999999999, -999999999};
            int target = 0;

            int[] result = solution.twoSum(nums, target);
            assertTrue(solution.isValidSolution(nums, target, result));
        }

        @Test
        @DisplayName("Random large array")
        void testRandomLargeArray() {
            Random random = new Random(42); // Fixed seed for reproducibility
            int size = 5000;
            int[] nums = new int[size];

            for (int i = 0; i < size; i++) {
                nums[i] = random.nextInt(20000) - 10000;
            }

            // Pick two random indices and calculate their sum as target
            int idx1 = random.nextInt(size);
            int idx2 = random.nextInt(size);
            while (idx2 == idx1) {
                idx2 = random.nextInt(size);
            }
            int target = nums[idx1] + nums[idx2];

            int[] result = solution.twoSum(nums, target);
            assertTrue(solution.isValidSolution(nums, target, result));
        }
    }
}

