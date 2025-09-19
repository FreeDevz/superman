package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Comprehensive test suite for Count and Say problem Tests all five different approaches with
 * various test cases
 */
@DisplayName("Count and Say Tests")
class CountAndSayTest {

    private CountAndSay solution;

    @BeforeEach
    void setUp() {
        solution = new CountAndSay();
    }

    @Nested
    @DisplayName("Iterative Approach Tests")
    class IterativeApproachTests {

        @Test
        @DisplayName("Base case")
        void testBaseCase() {
            assertEquals("1", solution.countAndSayIterative(1));
        }

        @Test
        @DisplayName("First few terms")
        void testFirstFewTerms() {
            assertEquals("1", solution.countAndSayIterative(1));
            assertEquals("11", solution.countAndSayIterative(2));
            assertEquals("21", solution.countAndSayIterative(3));
            assertEquals("1211", solution.countAndSayIterative(4));
            assertEquals("111221", solution.countAndSayIterative(5));
        }

        @Test
        @DisplayName("Medium terms")
        void testMediumTerms() {
            assertEquals("312211", solution.countAndSayIterative(6));
            assertEquals("13112221", solution.countAndSayIterative(7));
            assertEquals("1113213211", solution.countAndSayIterative(8));
            assertEquals("31131211131221", solution.countAndSayIterative(9));
            assertEquals("13211311123113112211", solution.countAndSayIterative(10));
        }

        @Test
        @DisplayName("Edge cases")
        void testEdgeCases() {
            assertEquals("1", solution.countAndSayIterative(1));
            assertEquals("11", solution.countAndSayIterative(2));
        }

        @Test
        @DisplayName("Large terms")
        void testLargeTerms() {
            assertEquals(
                    "311311222113111231131112132112311321322112111312211312111322212311322113212221",
                    solution.countAndSayIterative(15));
        }
    }

    @Nested
    @DisplayName("Recursive Approach Tests")
    class RecursiveApproachTests {

        @Test
        @DisplayName("Base case")
        void testBaseCase() {
            assertEquals("1", solution.countAndSayRecursive(1));
        }

        @Test
        @DisplayName("First few terms")
        void testFirstFewTerms() {
            assertEquals("1", solution.countAndSayRecursive(1));
            assertEquals("11", solution.countAndSayRecursive(2));
            assertEquals("21", solution.countAndSayRecursive(3));
            assertEquals("1211", solution.countAndSayRecursive(4));
            assertEquals("111221", solution.countAndSayRecursive(5));
        }

        @Test
        @DisplayName("Medium terms")
        void testMediumTerms() {
            assertEquals("312211", solution.countAndSayRecursive(6));
            assertEquals("13112221", solution.countAndSayRecursive(7));
            assertEquals("1113213211", solution.countAndSayRecursive(8));
            assertEquals("31131211131221", solution.countAndSayRecursive(9));
            assertEquals("13211311123113112211", solution.countAndSayRecursive(10));
        }

        @Test
        @DisplayName("Edge cases")
        void testEdgeCases() {
            assertEquals("1", solution.countAndSayRecursive(1));
            assertEquals("11", solution.countAndSayRecursive(2));
        }
    }

    @Nested
    @DisplayName("Optimized Approach Tests")
    class OptimizedApproachTests {

        @Test
        @DisplayName("Base case")
        void testBaseCase() {
            assertEquals("1", solution.countAndSayOptimized(1));
        }

        @Test
        @DisplayName("First few terms")
        void testFirstFewTerms() {
            assertEquals("1", solution.countAndSayOptimized(1));
            assertEquals("11", solution.countAndSayOptimized(2));
            assertEquals("21", solution.countAndSayOptimized(3));
            assertEquals("1211", solution.countAndSayOptimized(4));
            assertEquals("111221", solution.countAndSayOptimized(5));
        }

        @Test
        @DisplayName("Medium terms")
        void testMediumTerms() {
            assertEquals("312211", solution.countAndSayOptimized(6));
            assertEquals("13112221", solution.countAndSayOptimized(7));
            assertEquals("1113213211", solution.countAndSayOptimized(8));
            assertEquals("31131211131221", solution.countAndSayOptimized(9));
            assertEquals("13211311123113112211", solution.countAndSayOptimized(10));
        }

        @Test
        @DisplayName("Edge cases")
        void testEdgeCases() {
            assertEquals("1", solution.countAndSayOptimized(1));
            assertEquals("11", solution.countAndSayOptimized(2));
        }
    }

    @Nested
    @DisplayName("Character Array Approach Tests")
    class CharArrayApproachTests {

        @Test
        @DisplayName("Base case")
        void testBaseCase() {
            assertEquals("1", solution.countAndSayCharArray(1));
        }

        @Test
        @DisplayName("First few terms")
        void testFirstFewTerms() {
            assertEquals("1", solution.countAndSayCharArray(1));
            assertEquals("11", solution.countAndSayCharArray(2));
            assertEquals("21", solution.countAndSayCharArray(3));
            assertEquals("1211", solution.countAndSayCharArray(4));
            assertEquals("111221", solution.countAndSayCharArray(5));
        }

        @Test
        @DisplayName("Medium terms")
        void testMediumTerms() {
            assertEquals("312211", solution.countAndSayCharArray(6));
            assertEquals("13112221", solution.countAndSayCharArray(7));
            assertEquals("1113213211", solution.countAndSayCharArray(8));
            assertEquals("31131211131221", solution.countAndSayCharArray(9));
            assertEquals("13211311123113112211", solution.countAndSayCharArray(10));
        }

        @Test
        @DisplayName("Edge cases")
        void testEdgeCases() {
            assertEquals("1", solution.countAndSayCharArray(1));
            assertEquals("11", solution.countAndSayCharArray(2));
        }
    }

    @Nested
    @DisplayName("Two-Pointer Approach Tests")
    class TwoPointerApproachTests {

        @Test
        @DisplayName("Base case")
        void testBaseCase() {
            assertEquals("1", solution.countAndSayTwoPointers(1));
        }

        @Test
        @DisplayName("First few terms")
        void testFirstFewTerms() {
            assertEquals("1", solution.countAndSayTwoPointers(1));
            assertEquals("11", solution.countAndSayTwoPointers(2));
            assertEquals("21", solution.countAndSayTwoPointers(3));
            assertEquals("1211", solution.countAndSayTwoPointers(4));
            assertEquals("111221", solution.countAndSayTwoPointers(5));
        }

        @Test
        @DisplayName("Medium terms")
        void testMediumTerms() {
            assertEquals("312211", solution.countAndSayTwoPointers(6));
            assertEquals("13112221", solution.countAndSayTwoPointers(7));
            assertEquals("1113213211", solution.countAndSayTwoPointers(8));
            assertEquals("31131211131221", solution.countAndSayTwoPointers(9));
            assertEquals("13211311123113112211", solution.countAndSayTwoPointers(10));
        }

        @Test
        @DisplayName("Edge cases")
        void testEdgeCases() {
            assertEquals("1", solution.countAndSayTwoPointers(1));
            assertEquals("11", solution.countAndSayTwoPointers(2));
        }
    }

    @Nested
    @DisplayName("Cross-Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @ParameterizedTest
        @CsvSource({"1, 1", "2, 11", "3, 21", "4, 1211", "5, 111221", "6, 312211", "7, 13112221",
                "8, 1113213211", "9, 31131211131221", "10, 13211311123113112211"})
        @DisplayName("All approaches should produce same results")
        void testAllApproachesProduceSameResults(int n, String expected) {
            String iterative = solution.countAndSayIterative(n);
            String recursive = solution.countAndSayRecursive(n);
            String optimized = solution.countAndSayOptimized(n);
            String charArray = solution.countAndSayCharArray(n);
            String twoPointers = solution.countAndSayTwoPointers(n);

            assertEquals(expected, iterative);
            assertEquals(expected, recursive);
            assertEquals(expected, optimized);
            assertEquals(expected, charArray);
            assertEquals(expected, twoPointers);

            // All approaches should produce the same result
            assertEquals(iterative, recursive);
            assertEquals(recursive, optimized);
            assertEquals(optimized, charArray);
            assertEquals(charArray, twoPointers);
        }
    }

    @Nested
    @DisplayName("Edge Case Tests")
    class EdgeCaseTests {

        @Test
        @DisplayName("Minimum valid input")
        void testMinimumInput() {
            String result = solution.countAndSayIterative(1);
            assertEquals("1", result);
        }

        @Test
        @DisplayName("Maximum constraint input")
        void testMaximumConstraint() {
            // Test with n = 30 (maximum constraint)
            String result = solution.countAndSayIterative(30);
            assertNotNull(result);
            assertFalse(result.isEmpty());
            assertTrue(result.matches("[0-9]+"));
        }

        @Test
        @DisplayName("Sequence progression")
        void testSequenceProgression() {
            String[] expected =
                    {"1", "11", "21", "1211", "111221", "312211", "13112221", "1113213211"};

            for (int i = 0; i < expected.length; i++) {
                String result = solution.countAndSayIterative(i + 1);
                assertEquals(expected[i], result);
            }
        }

        @Test
        @DisplayName("Large numbers")
        void testLargeNumbers() {
            // Test with various large n values
            int[] largeNumbers = {15, 20, 25, 30};

            for (int n : largeNumbers) {
                String iterative = solution.countAndSayIterative(n);
                String recursive = solution.countAndSayRecursive(n);
                String optimized = solution.countAndSayOptimized(n);
                String charArray = solution.countAndSayCharArray(n);
                String twoPointers = solution.countAndSayTwoPointers(n);

                // All approaches should produce the same result
                assertEquals(iterative, recursive);
                assertEquals(recursive, optimized);
                assertEquals(optimized, charArray);
                assertEquals(charArray, twoPointers);

                // Result should not be null or empty
                assertNotNull(iterative);
                assertFalse(iterative.isEmpty());
                assertTrue(iterative.matches("[0-9]+"));
            }
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Performance comparison for medium numbers")
        void testPerformanceMediumNumbers() {
            int[] testNumbers = {10, 15, 20, 25};

            for (int n : testNumbers) {
                long startTime, endTime;

                // Test iterative approach
                startTime = System.nanoTime();
                String iterative = solution.countAndSayIterative(n);
                endTime = System.nanoTime();
                long iterativeTime = endTime - startTime;

                // Test recursive approach
                startTime = System.nanoTime();
                String recursive = solution.countAndSayRecursive(n);
                endTime = System.nanoTime();
                long recursiveTime = endTime - startTime;

                // Test optimized approach
                startTime = System.nanoTime();
                String optimized = solution.countAndSayOptimized(n);
                endTime = System.nanoTime();
                long optimizedTime = endTime - startTime;

                // Test char array approach
                startTime = System.nanoTime();
                String charArray = solution.countAndSayCharArray(n);
                endTime = System.nanoTime();
                long charArrayTime = endTime - startTime;

                // Test two-pointer approach
                startTime = System.nanoTime();
                String twoPointers = solution.countAndSayTwoPointers(n);
                endTime = System.nanoTime();
                long twoPointersTime = endTime - startTime;

                // All should produce same result
                assertEquals(iterative, recursive);
                assertEquals(recursive, optimized);
                assertEquals(optimized, charArray);
                assertEquals(charArray, twoPointers);

                System.out.printf(
                        "n = %d, Iterative: %dns, Recursive: %dns, Optimized: %dns, CharArray: %dns, TwoPointers: %dns%n",
                        n, iterativeTime, recursiveTime, optimizedTime, charArrayTime,
                        twoPointersTime);
            }
        }
    }

    @Nested
    @DisplayName("Utility Method Tests")
    class UtilityMethodTests {

        @Test
        @DisplayName("Test sequence generation")
        void testSequenceGeneration() {
            String[] sequence = solution.generateSequence(5);

            assertEquals(5, sequence.length);
            assertEquals("1", sequence[0]);
            assertEquals("11", sequence[1]);
            assertEquals("21", sequence[2]);
            assertEquals("1211", sequence[3]);
            assertEquals("111221", sequence[4]);
        }

        @Test
        @DisplayName("Test term analysis")
        void testTermAnalysis() {
            assertEquals("1 1's", solution.analyzeTerm("1"));
            assertEquals("2 1's", solution.analyzeTerm("11"));
            assertEquals("1 2's, 1 1's", solution.analyzeTerm("21"));
            assertEquals("1 1's, 1 2's, 2 1's", solution.analyzeTerm("1211"));
        }

        @Test
        @DisplayName("Test term length")
        void testTermLength() {
            assertEquals(1, solution.getTermLength(1));
            assertEquals(2, solution.getTermLength(2));
            assertEquals(2, solution.getTermLength(3));
            assertEquals(4, solution.getTermLength(4));
            assertEquals(6, solution.getTermLength(5));
        }
    }

    @Nested
    @DisplayName("Comprehensive Test Suite")
    class ComprehensiveTestSuite {

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15, 20, 25, 30})
        @DisplayName("Comprehensive test for all valid inputs")
        void testComprehensive(int n) {
            String iterative = solution.countAndSayIterative(n);
            String recursive = solution.countAndSayRecursive(n);
            String optimized = solution.countAndSayOptimized(n);
            String charArray = solution.countAndSayCharArray(n);
            String twoPointers = solution.countAndSayTwoPointers(n);

            // All approaches should produce the same result
            assertEquals(iterative, recursive);
            assertEquals(recursive, optimized);
            assertEquals(optimized, charArray);
            assertEquals(charArray, twoPointers);

            // Result should be valid
            assertNotNull(iterative);
            assertFalse(iterative.isEmpty());
            assertTrue(iterative.matches("[0-9]+"));
        }
    }
}
