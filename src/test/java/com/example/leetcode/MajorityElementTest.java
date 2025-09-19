package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Comprehensive test suite for Majority Element problem Tests all seven different approaches with
 * various test cases
 */
@DisplayName("Majority Element Tests")
class MajorityElementTest {

    private MajorityElement solution;

    @BeforeEach
    void setUp() {
        solution = new MajorityElement();
    }

    @Nested
    @DisplayName("Boyer-Moore Voting Algorithm Tests")
    class BoyerMooreApproachTests {

        @Test
        @DisplayName("Basic test case 1")
        void testBasicCase1() {
            int[] nums = {3, 2, 3};
            int expected = 3;
            int result = solution.majorityElement(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Basic test case 2")
        void testBasicCase2() {
            int[] nums = {2, 2, 1, 1, 1, 2, 2};
            int expected = 2;
            int result = solution.majorityElement(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Single element")
        void testSingleElement() {
            int[] nums = {1};
            int expected = 1;
            int result = solution.majorityElement(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Two elements")
        void testTwoElements() {
            int[] nums = {1, 1};
            int expected = 1;
            int result = solution.majorityElement(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("All same elements")
        void testAllSameElements() {
            int[] nums = {5, 5, 5, 5, 5};
            int expected = 5;
            int result = solution.majorityElement(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Majority at beginning")
        void testMajorityAtBeginning() {
            int[] nums = {1, 1, 1, 2, 3};
            int expected = 1;
            int result = solution.majorityElement(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Majority at end")
        void testMajorityAtEnd() {
            int[] nums = {1, 2, 3, 4, 4, 4, 4};
            int expected = 4;
            int result = solution.majorityElement(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Negative numbers")
        void testNegativeNumbers() {
            int[] nums = {-1, -1, -1, 2, 3};
            int expected = -1;
            int result = solution.majorityElement(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Large numbers")
        void testLargeNumbers() {
            int[] nums = {1000000000, 1000000000, 999999999};
            int expected = 1000000000;
            int result = solution.majorityElement(nums);
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Boyer-Moore with Verification Tests")
    class BoyerMooreVerificationTests {

        @Test
        @DisplayName("Basic verification test")
        void testBasicVerification() {
            int[] nums = {3, 2, 3};
            int expected = 3;
            int result = solution.majorityElementWithVerification(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Complex verification test")
        void testComplexVerification() {
            int[] nums = {2, 2, 1, 1, 1, 2, 2};
            int expected = 2;
            int result = solution.majorityElementWithVerification(nums);
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("HashMap Approach Tests")
    class HashMapApproachTests {

        @Test
        @DisplayName("HashMap basic test")
        void testHashMapBasic() {
            int[] nums = {3, 2, 3};
            int expected = 3;
            int result = solution.majorityElementHashMap(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("HashMap complex test")
        void testHashMapComplex() {
            int[] nums = {2, 2, 1, 1, 1, 2, 2};
            int expected = 2;
            int result = solution.majorityElementHashMap(nums);
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Sorting Approach Tests")
    class SortingApproachTests {

        @Test
        @DisplayName("Sorting basic test")
        void testSortingBasic() {
            int[] nums = {3, 2, 3};
            int expected = 3;
            int result = solution.majorityElementSorting(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Sorting complex test")
        void testSortingComplex() {
            int[] nums = {2, 2, 1, 1, 1, 2, 2};
            int expected = 2;
            int result = solution.majorityElementSorting(nums);
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Divide and Conquer Tests")
    class DivideConquerTests {

        @Test
        @DisplayName("Divide and conquer basic test")
        void testDivideConquerBasic() {
            int[] nums = {3, 2, 3};
            int expected = 3;
            int result = solution.majorityElementDivideConquer(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Divide and conquer complex test")
        void testDivideConquerComplex() {
            int[] nums = {2, 2, 1, 1, 1, 2, 2};
            int expected = 2;
            int result = solution.majorityElementDivideConquer(nums);
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Bit Manipulation Tests")
    class BitManipulationTests {

        @Test
        @DisplayName("Bit manipulation basic test")
        void testBitManipulationBasic() {
            int[] nums = {3, 2, 3};
            int expected = 3;
            int result = solution.majorityElementBitManipulation(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Bit manipulation complex test")
        void testBitManipulationComplex() {
            int[] nums = {2, 2, 1, 1, 1, 2, 2};
            int expected = 2;
            int result = solution.majorityElementBitManipulation(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Bit manipulation with negative numbers")
        void testBitManipulationNegative() {
            int[] nums = {-1, -1, -1, 2, 3};
            int expected = -1;
            int result = solution.majorityElementBitManipulation(nums);
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Cross-Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @Test
        @DisplayName("All approaches should produce same results")
        void testAllApproachesProduceSameResults() {
            int[][] testCases = {{3, 2, 3}, {2, 2, 1, 1, 1, 2, 2}, {1}, {1, 1, 2, 2, 2}, {6, 5, 5},
                    {1, 1, 1, 2, 2, 2, 2}, {-1, -1, -1, 2, 3}, {1000000000, 1000000000, 999999999}};

            for (int[] nums : testCases) {
                int result1 = solution.majorityElement(nums);
                int result2 = solution.majorityElementWithVerification(nums);
                int result3 = solution.majorityElementHashMap(nums);
                int result4 = solution.majorityElementSorting(nums);
                int result5 = solution.majorityElementDivideConquer(nums);
                int result6 = solution.majorityElementBitManipulation(nums);

                // All approaches should produce the same result
                assertEquals(result1, result2, "Boyer-Moore with verification differs");
                assertEquals(result2, result3, "HashMap differs from Boyer-Moore");
                assertEquals(result3, result4, "Sorting differs from HashMap");
                assertEquals(result4, result5, "Divide & Conquer differs from Sorting");
                assertEquals(result5, result6, "Bit Manipulation differs from Divide & Conquer");
            }
        }
    }

    @Nested
    @DisplayName("Edge Case Tests")
    class EdgeCaseTests {

        @Test
        @DisplayName("Minimum valid input")
        void testMinimumInput() {
            int[] nums = {1};
            int expected = 1;
            int result = solution.majorityElement(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Two elements with majority")
        void testTwoElementsMajority() {
            int[] nums = {1, 1};
            int expected = 1;
            int result = solution.majorityElement(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Three elements")
        void testThreeElements() {
            int[] nums = {1, 2, 1};
            int expected = 1;
            int result = solution.majorityElement(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Large array with majority")
        void testLargeArray() {
            int[] nums = new int[1000];
            Arrays.fill(nums, 0, 501, 5); // First 501 elements are 5
            Arrays.fill(nums, 501, 1000, 3); // Remaining elements are 3

            int expected = 5;
            int result = solution.majorityElement(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("All elements are the same")
        void testAllElementsSame() {
            int[] nums = {7, 7, 7, 7, 7, 7, 7};
            int expected = 7;
            int result = solution.majorityElement(nums);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Alternating pattern")
        void testAlternatingPattern() {
            int[] nums = {1, 2, 1, 2, 1, 2, 1};
            int expected = 1;
            int result = solution.majorityElement(nums);
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Utility Method Tests")
    class UtilityMethodTests {

        @Test
        @DisplayName("Test majority element verification")
        void testMajorityElementVerification() {
            int[] nums = {3, 2, 3};
            assertTrue(solution.isMajorityElement(nums, 3));
            assertFalse(solution.isMajorityElement(nums, 2));
        }

        @Test
        @DisplayName("Test majority element verification with complex case")
        void testMajorityElementVerificationComplex() {
            int[] nums = {2, 2, 1, 1, 1, 2, 2};
            assertTrue(solution.isMajorityElement(nums, 2));
            assertFalse(solution.isMajorityElement(nums, 1));
        }

        @Test
        @DisplayName("Test n/3 majority elements")
        void testMajorityElementsN3() {
            int[] nums = {3, 2, 3};
            int[] result = solution.majorityElementsN3(nums);
            assertEquals(1, result.length);
            assertEquals(3, result[0]);
        }

        @Test
        @DisplayName("Test n/3 majority elements with two candidates")
        void testMajorityElementsN3TwoCandidates() {
            int[] nums = {1, 1, 1, 3, 3, 2, 2, 2};
            int[] result = solution.majorityElementsN3(nums);
            assertEquals(2, result.length);
            assertTrue(Arrays.equals(new int[] {1, 2}, result)
                    || Arrays.equals(new int[] {2, 1}, result));
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Performance comparison for medium inputs")
        void testPerformanceMediumInputs() {
            int[][] testCases = {generateArray(100), generateArray(500), generateArray(1000)};

            for (int[] nums : testCases) {
                long startTime, endTime;

                // Test Boyer-Moore approach
                startTime = System.nanoTime();
                int result1 = solution.majorityElement(nums);
                endTime = System.nanoTime();
                long boyerMooreTime = endTime - startTime;

                // Test HashMap approach
                startTime = System.nanoTime();
                int result2 = solution.majorityElementHashMap(nums);
                endTime = System.nanoTime();
                long hashMapTime = endTime - startTime;

                // Test sorting approach
                startTime = System.nanoTime();
                int result3 = solution.majorityElementSorting(nums);
                endTime = System.nanoTime();
                long sortingTime = endTime - startTime;

                // Test divide and conquer approach
                startTime = System.nanoTime();
                int result4 = solution.majorityElementDivideConquer(nums);
                endTime = System.nanoTime();
                long divideConquerTime = endTime - startTime;

                // Test bit manipulation approach
                startTime = System.nanoTime();
                int result5 = solution.majorityElementBitManipulation(nums);
                endTime = System.nanoTime();
                long bitManipulationTime = endTime - startTime;

                // All should produce same result
                assertEquals(result1, result2);
                assertEquals(result2, result3);
                assertEquals(result3, result4);
                assertEquals(result4, result5);

                System.out.printf(
                        "Input size: %d, Boyer-Moore: %dns, HashMap: %dns, Sorting: %dns, Divide&Conquer: %dns, BitManip: %dns%n",
                        nums.length, boyerMooreTime, hashMapTime, sortingTime, divideConquerTime,
                        bitManipulationTime);
            }
        }

        private int[] generateArray(int size) {
            int[] nums = new int[size];
            int majorityElement = 1;
            int majorityCount = size / 2 + 1;

            // Fill majority elements
            for (int i = 0; i < majorityCount; i++) {
                nums[i] = majorityElement;
            }

            // Fill remaining elements with different values
            for (int i = majorityCount; i < size; i++) {
                nums[i] = i - majorityCount + 2;
            }

            return nums;
        }
    }

    @Nested
    @DisplayName("Parameterized Tests")
    class ParameterizedTests {

        @ParameterizedTest
        @CsvSource({"'3,2,3', 3", "'2,2,1,1,1,2,2', 2", "'1', 1", "'1,1,2,2,2', 2", "'6,5,5', 5"})
        @DisplayName("Parameterized test for various inputs")
        void testParameterized(String input, int expected) {
            int[] nums = Arrays.stream(input.split(",")).map(String::trim)
                    .mapToInt(Integer::parseInt).toArray();

            int result = solution.majorityElement(nums);
            assertEquals(expected, result);
        }
    }
}
