package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Comprehensive test suite for Excel Sheet Column Title problem Tests all five different approaches
 * with various test cases
 */
@DisplayName("Excel Sheet Column Title Tests")
class ExcelSheetColumnTitleTest {

    private ExcelSheetColumnTitle solution;

    @BeforeEach
    void setUp() {
        solution = new ExcelSheetColumnTitle();
    }

    @Nested
    @DisplayName("Iterative Approach Tests")
    class IterativeApproachTests {

        @Test
        @DisplayName("Single character columns (A-Z)")
        void testSingleCharacterColumns() {
            assertEquals("A", solution.convertToTitleIterative(1));
            assertEquals("B", solution.convertToTitleIterative(2));
            assertEquals("C", solution.convertToTitleIterative(3));
            assertEquals("Z", solution.convertToTitleIterative(26));
        }

        @Test
        @DisplayName("Two character columns (AA-ZZ)")
        void testTwoCharacterColumns() {
            assertEquals("AA", solution.convertToTitleIterative(27));
            assertEquals("AB", solution.convertToTitleIterative(28));
            assertEquals("AC", solution.convertToTitleIterative(29));
            assertEquals("AZ", solution.convertToTitleIterative(52));
            assertEquals("BA", solution.convertToTitleIterative(53));
            assertEquals("ZZ", solution.convertToTitleIterative(702));
        }

        @Test
        @DisplayName("Three character columns")
        void testThreeCharacterColumns() {
            assertEquals("AAA", solution.convertToTitleIterative(703));
            assertEquals("AAB", solution.convertToTitleIterative(704));
            assertEquals("ABA", solution.convertToTitleIterative(729));
            assertEquals("ZZZ", solution.convertToTitleIterative(18278));
        }

        @Test
        @DisplayName("Edge cases")
        void testEdgeCases() {
            assertEquals("A", solution.convertToTitleIterative(1));
            assertEquals("Z", solution.convertToTitleIterative(26));
            assertEquals("AA", solution.convertToTitleIterative(27));
            assertEquals("ZY", solution.convertToTitleIterative(701));
        }

        @Test
        @DisplayName("Large numbers")
        void testLargeNumbers() {
            assertEquals("FXSHRXW", solution.convertToTitleIterative(2147483647));
            assertEquals("CFDGSXL", solution.convertToTitleIterative(1000000000));
        }
    }

    @Nested
    @DisplayName("Recursive Approach Tests")
    class RecursiveApproachTests {

        @Test
        @DisplayName("Single character columns (A-Z)")
        void testSingleCharacterColumns() {
            assertEquals("A", solution.convertToTitleRecursive(1));
            assertEquals("B", solution.convertToTitleRecursive(2));
            assertEquals("C", solution.convertToTitleRecursive(3));
            assertEquals("Z", solution.convertToTitleRecursive(26));
        }

        @Test
        @DisplayName("Two character columns (AA-ZZ)")
        void testTwoCharacterColumns() {
            assertEquals("AA", solution.convertToTitleRecursive(27));
            assertEquals("AB", solution.convertToTitleRecursive(28));
            assertEquals("AC", solution.convertToTitleRecursive(29));
            assertEquals("AZ", solution.convertToTitleRecursive(52));
            assertEquals("BA", solution.convertToTitleRecursive(53));
            assertEquals("ZZ", solution.convertToTitleRecursive(702));
        }

        @Test
        @DisplayName("Three character columns")
        void testThreeCharacterColumns() {
            assertEquals("AAA", solution.convertToTitleRecursive(703));
            assertEquals("AAB", solution.convertToTitleRecursive(704));
            assertEquals("ABA", solution.convertToTitleRecursive(729));
            assertEquals("ZZZ", solution.convertToTitleRecursive(18278));
        }

        @Test
        @DisplayName("Edge cases")
        void testEdgeCases() {
            assertEquals("A", solution.convertToTitleRecursive(1));
            assertEquals("Z", solution.convertToTitleRecursive(26));
            assertEquals("AA", solution.convertToTitleRecursive(27));
            assertEquals("ZY", solution.convertToTitleRecursive(701));
        }
    }

    @Nested
    @DisplayName("Optimized Approach Tests")
    class OptimizedApproachTests {

        @Test
        @DisplayName("Single character columns (A-Z)")
        void testSingleCharacterColumns() {
            assertEquals("A", solution.convertToTitleOptimized(1));
            assertEquals("B", solution.convertToTitleOptimized(2));
            assertEquals("C", solution.convertToTitleOptimized(3));
            assertEquals("Z", solution.convertToTitleOptimized(26));
        }

        @Test
        @DisplayName("Two character columns (AA-ZZ)")
        void testTwoCharacterColumns() {
            assertEquals("AA", solution.convertToTitleOptimized(27));
            assertEquals("AB", solution.convertToTitleOptimized(28));
            assertEquals("AC", solution.convertToTitleOptimized(29));
            assertEquals("AZ", solution.convertToTitleOptimized(52));
            assertEquals("BA", solution.convertToTitleOptimized(53));
            assertEquals("ZZ", solution.convertToTitleOptimized(702));
        }

        @Test
        @DisplayName("Three character columns")
        void testThreeCharacterColumns() {
            assertEquals("AAA", solution.convertToTitleOptimized(703));
            assertEquals("AAB", solution.convertToTitleOptimized(704));
            assertEquals("ABA", solution.convertToTitleOptimized(729));
            assertEquals("ZZZ", solution.convertToTitleOptimized(18278));
        }

        @Test
        @DisplayName("Edge cases")
        void testEdgeCases() {
            assertEquals("A", solution.convertToTitleOptimized(1));
            assertEquals("Z", solution.convertToTitleOptimized(26));
            assertEquals("AA", solution.convertToTitleOptimized(27));
            assertEquals("ZY", solution.convertToTitleOptimized(701));
        }
    }

    @Nested
    @DisplayName("Character Array Approach Tests")
    class CharArrayApproachTests {

        @Test
        @DisplayName("Single character columns (A-Z)")
        void testSingleCharacterColumns() {
            assertEquals("A", solution.convertToTitleCharArray(1));
            assertEquals("B", solution.convertToTitleCharArray(2));
            assertEquals("C", solution.convertToTitleCharArray(3));
            assertEquals("Z", solution.convertToTitleCharArray(26));
        }

        @Test
        @DisplayName("Two character columns (AA-ZZ)")
        void testTwoCharacterColumns() {
            assertEquals("AA", solution.convertToTitleCharArray(27));
            assertEquals("AB", solution.convertToTitleCharArray(28));
            assertEquals("AC", solution.convertToTitleCharArray(29));
            assertEquals("AZ", solution.convertToTitleCharArray(52));
            assertEquals("BA", solution.convertToTitleCharArray(53));
            assertEquals("ZZ", solution.convertToTitleCharArray(702));
        }

        @Test
        @DisplayName("Three character columns")
        void testThreeCharacterColumns() {
            assertEquals("AAA", solution.convertToTitleCharArray(703));
            assertEquals("AAB", solution.convertToTitleCharArray(704));
            assertEquals("ABA", solution.convertToTitleCharArray(729));
            assertEquals("ZZZ", solution.convertToTitleCharArray(18278));
        }

        @Test
        @DisplayName("Edge cases")
        void testEdgeCases() {
            assertEquals("A", solution.convertToTitleCharArray(1));
            assertEquals("Z", solution.convertToTitleCharArray(26));
            assertEquals("AA", solution.convertToTitleCharArray(27));
            assertEquals("ZY", solution.convertToTitleCharArray(701));
        }
    }

    @Nested
    @DisplayName("Mathematical Approach Tests")
    class MathematicalApproachTests {

        @Test
        @DisplayName("Single character columns (A-Z)")
        void testSingleCharacterColumns() {
            assertEquals("A", solution.convertToTitleMathematical(1));
            assertEquals("B", solution.convertToTitleMathematical(2));
            assertEquals("C", solution.convertToTitleMathematical(3));
            assertEquals("Z", solution.convertToTitleMathematical(26));
        }

        @Test
        @DisplayName("Two character columns (AA-ZZ)")
        void testTwoCharacterColumns() {
            assertEquals("AA", solution.convertToTitleMathematical(27));
            assertEquals("AB", solution.convertToTitleMathematical(28));
            assertEquals("AC", solution.convertToTitleMathematical(29));
            assertEquals("AZ", solution.convertToTitleMathematical(52));
            assertEquals("BA", solution.convertToTitleMathematical(53));
            assertEquals("ZZ", solution.convertToTitleMathematical(702));
        }

        @Test
        @DisplayName("Three character columns")
        void testThreeCharacterColumns() {
            assertEquals("AAA", solution.convertToTitleMathematical(703));
            assertEquals("AAB", solution.convertToTitleMathematical(704));
            assertEquals("ABA", solution.convertToTitleMathematical(729));
            assertEquals("ZZZ", solution.convertToTitleMathematical(18278));
        }

        @Test
        @DisplayName("Edge cases")
        void testEdgeCases() {
            assertEquals("A", solution.convertToTitleMathematical(1));
            assertEquals("Z", solution.convertToTitleMathematical(26));
            assertEquals("AA", solution.convertToTitleMathematical(27));
            assertEquals("ZY", solution.convertToTitleMathematical(701));
        }
    }

    @Nested
    @DisplayName("Cross-Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @ParameterizedTest
        @CsvSource({"1, A", "26, Z", "27, AA", "28, AB", "52, AZ", "53, BA", "701, ZY", "702, ZZ",
                "703, AAA", "18278, ZZZ", "2147483647, FXSHRXW"})
        @DisplayName("All approaches should produce same results")
        void testAllApproachesProduceSameResults(int columnNumber, String expected) {
            String iterative = solution.convertToTitleIterative(columnNumber);
            String recursive = solution.convertToTitleRecursive(columnNumber);
            String optimized = solution.convertToTitleOptimized(columnNumber);
            String charArray = solution.convertToTitleCharArray(columnNumber);
            String mathematical = solution.convertToTitleMathematical(columnNumber);

            assertEquals(expected, iterative);
            assertEquals(expected, recursive);
            assertEquals(expected, optimized);
            assertEquals(expected, charArray);
            assertEquals(expected, mathematical);

            // All approaches should produce the same result
            assertEquals(iterative, recursive);
            assertEquals(recursive, optimized);
            assertEquals(optimized, charArray);
            assertEquals(charArray, mathematical);
        }
    }

    @Nested
    @DisplayName("Edge Case Tests")
    class EdgeCaseTests {

        @Test
        @DisplayName("Minimum valid input")
        void testMinimumInput() {
            String result = solution.convertToTitleIterative(1);
            assertEquals("A", result);
        }

        @Test
        @DisplayName("Boundary between single and double character")
        void testBoundarySingleDouble() {
            assertEquals("Z", solution.convertToTitleIterative(26));
            assertEquals("AA", solution.convertToTitleIterative(27));
        }

        @Test
        @DisplayName("Boundary between double and triple character")
        void testBoundaryDoubleTriple() {
            assertEquals("ZZ", solution.convertToTitleIterative(702));
            assertEquals("AAA", solution.convertToTitleIterative(703));
        }

        @Test
        @DisplayName("Large numbers")
        void testLargeNumbers() {
            // Test with very large numbers
            int[] largeNumbers = {1000000, 10000000, 100000000, 1000000000, 2147483647};

            for (int num : largeNumbers) {
                String iterative = solution.convertToTitleIterative(num);
                String recursive = solution.convertToTitleRecursive(num);
                String optimized = solution.convertToTitleOptimized(num);
                String charArray = solution.convertToTitleCharArray(num);
                String mathematical = solution.convertToTitleMathematical(num);

                // All approaches should produce the same result
                assertEquals(iterative, recursive);
                assertEquals(recursive, optimized);
                assertEquals(optimized, charArray);
                assertEquals(charArray, mathematical);

                // Result should not be null or empty
                assertNotNull(iterative);
                assertFalse(iterative.isEmpty());
            }
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Performance comparison for medium numbers")
        void testPerformanceMediumNumbers() {
            int[] testNumbers = {1000, 10000, 100000, 1000000};

            for (int num : testNumbers) {
                long startTime, endTime;

                // Test iterative approach
                startTime = System.nanoTime();
                String iterative = solution.convertToTitleIterative(num);
                endTime = System.nanoTime();
                long iterativeTime = endTime - startTime;

                // Test recursive approach
                startTime = System.nanoTime();
                String recursive = solution.convertToTitleRecursive(num);
                endTime = System.nanoTime();
                long recursiveTime = endTime - startTime;

                // Test optimized approach
                startTime = System.nanoTime();
                String optimized = solution.convertToTitleOptimized(num);
                endTime = System.nanoTime();
                long optimizedTime = endTime - startTime;

                // Test char array approach
                startTime = System.nanoTime();
                String charArray = solution.convertToTitleCharArray(num);
                endTime = System.nanoTime();
                long charArrayTime = endTime - startTime;

                // Test mathematical approach
                startTime = System.nanoTime();
                String mathematical = solution.convertToTitleMathematical(num);
                endTime = System.nanoTime();
                long mathematicalTime = endTime - startTime;

                // All should produce same result
                assertEquals(iterative, recursive);
                assertEquals(recursive, optimized);
                assertEquals(optimized, charArray);
                assertEquals(charArray, mathematical);

                System.out.printf(
                        "Number: %d, Iterative: %dns, Recursive: %dns, Optimized: %dns, CharArray: %dns, Mathematical: %dns%n",
                        num, iterativeTime, recursiveTime, optimizedTime, charArrayTime,
                        mathematicalTime);
            }
        }
    }

    @Nested
    @DisplayName("Utility Method Tests")
    class UtilityMethodTests {

        @Test
        @DisplayName("Test input validation")
        void testInputValidation() {
            // Note: The current implementation doesn't have input validation in the public methods
            // This test documents the expected behavior if validation is added
            assertDoesNotThrow(() -> solution.convertToTitleIterative(1));
            assertDoesNotThrow(() -> solution.convertToTitleIterative(Integer.MAX_VALUE));
        }
    }

    @Nested
    @DisplayName("Comprehensive Test Suite")
    class ComprehensiveTestSuite {

        @ParameterizedTest
        @ValueSource(
                ints = {1, 2, 3, 25, 26, 27, 28, 52, 53, 701, 702, 703, 18278, 1000000, 2147483647})
        @DisplayName("Comprehensive test for all valid inputs")
        void testComprehensive(int columnNumber) {
            String iterative = solution.convertToTitleIterative(columnNumber);
            String recursive = solution.convertToTitleRecursive(columnNumber);
            String optimized = solution.convertToTitleOptimized(columnNumber);
            String charArray = solution.convertToTitleCharArray(columnNumber);
            String mathematical = solution.convertToTitleMathematical(columnNumber);

            // All approaches should produce the same result
            assertEquals(iterative, recursive);
            assertEquals(recursive, optimized);
            assertEquals(optimized, charArray);
            assertEquals(charArray, mathematical);

            // Result should be valid
            assertNotNull(iterative);
            assertFalse(iterative.isEmpty());
            assertTrue(iterative.matches("[A-Z]+"));
        }
    }
}
