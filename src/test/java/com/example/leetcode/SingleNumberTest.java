package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
 * Comprehensive test suite for SingleNumber LeetCode problem
 * 
 * Tests all five different approaches: 1. XOR Operation (Optimal) 2. HashSet Solution 3.
 * Mathematical Formula 4. HashMap Solution 5. Sorting Solution
 */
@DisplayName("Single Number Tests")
class SingleNumberTest {

    private SingleNumber solution;

    @BeforeEach
    void setUp() {
        solution = new SingleNumber();
    }

    @Nested
    @DisplayName("Basic Functionality Tests")
    class BasicFunctionalityTests {

        @Test
        @DisplayName("Single element array")
        void testSingleElement() {
            int[] nums = {1};
            int expected = 1;

            assertEquals(expected, solution.singleNumberXOR(nums));
            assertEquals(expected, solution.singleNumberHashSet(nums));
            assertEquals(expected, solution.singleNumberMath(nums));
            assertEquals(expected, solution.singleNumberHashMap(nums));
            assertEquals(expected, solution.singleNumberSorting(nums));
        }

        @Test
        @DisplayName("Three elements with one unique")
        void testThreeElements() {
            int[] nums = {2, 2, 1};
            int expected = 1;

            assertEquals(expected, solution.singleNumberXOR(nums));
            assertEquals(expected, solution.singleNumberHashSet(nums));
            assertEquals(expected, solution.singleNumberMath(nums));
            assertEquals(expected, solution.singleNumberHashMap(nums));
            assertEquals(expected, solution.singleNumberSorting(nums));
        }

        @Test
        @DisplayName("Five elements with one unique")
        void testFiveElements() {
            int[] nums = {4, 1, 2, 1, 2};
            int expected = 4;

            assertEquals(expected, solution.singleNumberXOR(nums));
            assertEquals(expected, solution.singleNumberHashSet(nums));
            assertEquals(expected, solution.singleNumberMath(nums));
            assertEquals(expected, solution.singleNumberHashMap(nums));
            assertEquals(expected, solution.singleNumberSorting(nums));
        }

        @Test
        @DisplayName("Negative numbers")
        void testNegativeNumbers() {
            int[] nums = {-1, -1, -2};
            int expected = -2;

            assertEquals(expected, solution.singleNumberXOR(nums));
            assertEquals(expected, solution.singleNumberHashSet(nums));
            assertEquals(expected, solution.singleNumberMath(nums));
            assertEquals(expected, solution.singleNumberHashMap(nums));
            assertEquals(expected, solution.singleNumberSorting(nums));
        }

        @Test
        @DisplayName("Zero in array")
        void testZeroInArray() {
            int[] nums = {0, 0, 1, 1, 2};
            int expected = 2;

            assertEquals(expected, solution.singleNumberXOR(nums));
            assertEquals(expected, solution.singleNumberHashSet(nums));
            assertEquals(expected, solution.singleNumberMath(nums));
            assertEquals(expected, solution.singleNumberHashMap(nums));
            assertEquals(expected, solution.singleNumberSorting(nums));
        }
    }

    @Nested
    @DisplayName("Edge Cases and Boundary Tests")
    class EdgeCasesAndBoundaryTests {

        @Test
        @DisplayName("Minimum array size (1 element)")
        void testMinimumArraySize() {
            int[] nums = {42};
            int expected = 42;

            assertEquals(expected, solution.singleNumberXOR(nums));
            assertEquals(expected, solution.singleNumberHashSet(nums));
            assertEquals(expected, solution.singleNumberMath(nums));
            assertEquals(expected, solution.singleNumberHashMap(nums));
            assertEquals(expected, solution.singleNumberSorting(nums));
        }

        @Test
        @DisplayName("Maximum constraint values")
        void testMaximumConstraintValues() {
            int[] nums = {30000, 30000, -30000};
            int expected = -30000;

            assertEquals(expected, solution.singleNumberXOR(nums));
            assertEquals(expected, solution.singleNumberHashSet(nums));
            assertEquals(expected, solution.singleNumberMath(nums));
            assertEquals(expected, solution.singleNumberHashMap(nums));
            assertEquals(expected, solution.singleNumberSorting(nums));
        }

        @Test
        @DisplayName("Single number at beginning")
        void testSingleNumberAtBeginning() {
            int[] nums = {5, 1, 1, 2, 2};
            int expected = 5;

            assertEquals(expected, solution.singleNumberXOR(nums));
            assertEquals(expected, solution.singleNumberHashSet(nums));
            assertEquals(expected, solution.singleNumberMath(nums));
            assertEquals(expected, solution.singleNumberHashMap(nums));
            assertEquals(expected, solution.singleNumberSorting(nums));
        }

        @Test
        @DisplayName("Single number at end")
        void testSingleNumberAtEnd() {
            int[] nums = {1, 1, 2, 2, 5};
            int expected = 5;

            assertEquals(expected, solution.singleNumberXOR(nums));
            assertEquals(expected, solution.singleNumberHashSet(nums));
            assertEquals(expected, solution.singleNumberMath(nums));
            assertEquals(expected, solution.singleNumberHashMap(nums));
            assertEquals(expected, solution.singleNumberSorting(nums));
        }

        @Test
        @DisplayName("Single number in middle")
        void testSingleNumberInMiddle() {
            int[] nums = {1, 1, 5, 2, 2};
            int expected = 5;

            assertEquals(expected, solution.singleNumberXOR(nums));
            assertEquals(expected, solution.singleNumberHashSet(nums));
            assertEquals(expected, solution.singleNumberMath(nums));
            assertEquals(expected, solution.singleNumberHashMap(nums));
            assertEquals(expected, solution.singleNumberSorting(nums));
        }
    }

    @Nested
    @DisplayName("Parameterized Tests")
    class ParameterizedTests {

        @ParameterizedTest
        @MethodSource("provideTestCases")
        @DisplayName("All approaches with various test cases")
        void testAllApproaches(int[] nums, int expected) {
            assertEquals(expected, solution.singleNumberXOR(nums),
                    "XOR approach failed for: " + Arrays.toString(nums));
            assertEquals(expected, solution.singleNumberHashSet(nums),
                    "HashSet approach failed for: " + Arrays.toString(nums));
            assertEquals(expected, solution.singleNumberMath(nums),
                    "Math approach failed for: " + Arrays.toString(nums));
            assertEquals(expected, solution.singleNumberHashMap(nums),
                    "HashMap approach failed for: " + Arrays.toString(nums));
            assertEquals(expected, solution.singleNumberSorting(nums),
                    "Sorting approach failed for: " + Arrays.toString(nums));
        }

        static Stream<Arguments> provideTestCases() {
            return Stream.of(Arguments.of(new int[] {1, 3, 1, 3, 5}, 5),
                    Arguments.of(new int[] {7, 7, 8, 8, 9}, 9),
                    Arguments.of(new int[] {10, 20, 10, 20, 30}, 30),
                    Arguments.of(new int[] {-5, -5, -10, -10, -15}, -15),
                    Arguments.of(new int[] {100, 200, 100, 200, 300}, 300),
                    Arguments.of(new int[] {1, 2, 3, 4, 1, 2, 3}, 4),
                    Arguments.of(new int[] {5, 4, 3, 2, 1, 5, 4, 3, 2}, 1),
                    Arguments.of(new int[] {0, 1, 0, 1, 2}, 2),
                    Arguments.of(new int[] {-1, 0, -1, 0, 1}, 1),
                    Arguments.of(new int[] {999, 888, 777, 999, 888}, 777));
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Large array performance test")
        void testLargeArrayPerformance() {
            // Create a large array with 10,001 elements (smaller for performance)
            int[] nums = new int[10001];

            // Fill with pairs of unique numbers
            for (int i = 0; i < 5000; i++) {
                int num = i + 1; // Use sequential numbers to ensure uniqueness
                nums[i * 2] = num;
                nums[i * 2 + 1] = num;
            }

            // Add single number at the end
            nums[10000] = 12345;
            int expected = 12345;

            // Test all approaches
            long startTime, endTime;

            startTime = System.nanoTime();
            int result1 = solution.singleNumberXOR(nums);
            endTime = System.nanoTime();
            System.out.println("XOR approach time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertEquals(expected, result1);

            startTime = System.nanoTime();
            int result2 = solution.singleNumberHashSet(nums);
            endTime = System.nanoTime();
            System.out
                    .println("HashSet approach time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertEquals(expected, result2);

            startTime = System.nanoTime();
            int result3 = solution.singleNumberMath(nums);
            endTime = System.nanoTime();
            System.out.println("Math approach time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertEquals(expected, result3);

            startTime = System.nanoTime();
            int result4 = solution.singleNumberHashMap(nums);
            endTime = System.nanoTime();
            System.out
                    .println("HashMap approach time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertEquals(expected, result4);

            startTime = System.nanoTime();
            int result5 = solution.singleNumberSorting(nums);
            endTime = System.nanoTime();
            System.out
                    .println("Sorting approach time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertEquals(expected, result5);
        }
    }

    @Nested
    @DisplayName("Validation Tests")
    class ValidationTests {

        @Test
        @DisplayName("Verify XOR properties")
        void testXORProperties() {
            // Test XOR properties: a ^ a = 0, a ^ 0 = a
            assertEquals(0, 5 ^ 5, "a ^ a should equal 0");
            assertEquals(5, 5 ^ 0, "a ^ 0 should equal a");
            assertEquals(0, 0 ^ 0, "0 ^ 0 should equal 0");

            // Test commutativity: a ^ b = b ^ a
            assertEquals(3 ^ 7, 7 ^ 3, "XOR should be commutative");

            // Test associativity: (a ^ b) ^ c = a ^ (b ^ c)
            int a = 5, b = 3, c = 7;
            assertEquals((a ^ b) ^ c, a ^ (b ^ c), "XOR should be associative");
        }

        @Test
        @DisplayName("Verify all approaches return same result")
        void testAllApproachesConsistency() {
            int[][] testCases = {{1, 2, 3, 4, 1, 2, 3}, {-10, -20, -30, -10, -20}, {0, 1, 2, 0, 1},
                    {100, 200, 300, 100, 200}};

            for (int[] nums : testCases) {
                int xorResult = solution.singleNumberXOR(nums);
                int hashSetResult = solution.singleNumberHashSet(nums);
                int mathResult = solution.singleNumberMath(nums);
                int hashMapResult = solution.singleNumberHashMap(nums);
                int sortingResult = solution.singleNumberSorting(nums);

                assertEquals(xorResult, hashSetResult,
                        "XOR and HashSet results should match for: " + Arrays.toString(nums));
                assertEquals(xorResult, mathResult,
                        "XOR and Math results should match for: " + Arrays.toString(nums));
                assertEquals(xorResult, hashMapResult,
                        "XOR and HashMap results should match for: " + Arrays.toString(nums));
                assertEquals(xorResult, sortingResult,
                        "XOR and Sorting results should match for: " + Arrays.toString(nums));
            }
        }
    }

    @Nested
    @DisplayName("Cross Validation Tests")
    class CrossValidationTests {

        @Test
        @DisplayName("Random test cases with cross validation")
        void testRandomCasesWithCrossValidation() {
            Random random = new Random(123);

            for (int test = 0; test < 50; test++) {
                // Generate random array size (odd number, 3 to 21)
                int size = 3 + random.nextInt(19) * 2;
                int[] nums = new int[size];

                // Generate pairs of unique numbers using sequential approach
                for (int i = 0; i < (size - 1) / 2; i++) {
                    int num = test * 100 + i; // Ensure uniqueness across test cases
                    nums[i * 2] = num;
                    nums[i * 2 + 1] = num;
                }

                // Add single number
                nums[size - 1] = test * 100 + 1000; // Ensure it's unique
                int expected = nums[size - 1];

                // Test all approaches
                assertEquals(expected, solution.singleNumberXOR(nums),
                        "XOR failed for test case " + test);
                assertEquals(expected, solution.singleNumberHashSet(nums),
                        "HashSet failed for test case " + test);
                assertEquals(expected, solution.singleNumberMath(nums),
                        "Math failed for test case " + test);
                assertEquals(expected, solution.singleNumberHashMap(nums),
                        "HashMap failed for test case " + test);
                assertEquals(expected, solution.singleNumberSorting(nums),
                        "Sorting failed for test case " + test);
            }
        }
    }

    @Nested
    @DisplayName("Comprehensive Integration Tests")
    class ComprehensiveIntegrationTests {

        @Test
        @DisplayName("Stress test with maximum constraints")
        void testStressTestWithMaxConstraints() {
            // Test with array size near maximum constraint (10,001 for performance)
            int[] nums = new int[10001];

            // Fill with pairs of unique numbers
            for (int i = 0; i < 5000; i++) {
                int num = i - 5000; // Range: -5000 to -1
                nums[i * 2] = num;
                nums[i * 2 + 1] = num;
            }

            // Add single number
            nums[10000] = 25000;
            int expected = 25000;

            // Test all approaches
            assertEquals(expected, solution.singleNumberXOR(nums));
            assertEquals(expected, solution.singleNumberHashSet(nums));
            assertEquals(expected, solution.singleNumberMath(nums));
            assertEquals(expected, solution.singleNumberHashMap(nums));
            assertEquals(expected, solution.singleNumberSorting(nums));
        }

        @Test
        @DisplayName("Test with many different pairs and one single")
        void testManyDifferentPairsAndOneSingle() {
            int[] nums = new int[1001];
            // Fill with 500 different pairs
            for (int i = 0; i < 500; i++) {
                nums[i * 2] = i; // Each number appears exactly twice
                nums[i * 2 + 1] = i;
            }
            nums[1000] = 9999; // Single different number
            int expected = 9999;

            assertEquals(expected, solution.singleNumberXOR(nums));
            assertEquals(expected, solution.singleNumberHashSet(nums));
            assertEquals(expected, solution.singleNumberMath(nums));
            assertEquals(expected, solution.singleNumberHashMap(nums));
            assertEquals(expected, solution.singleNumberSorting(nums));
        }
    }
}
