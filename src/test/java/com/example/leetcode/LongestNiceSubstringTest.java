package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Comprehensive test suite for LongestNiceSubstring LeetCode problem
 * 
 * Tests all implemented approaches with various edge cases, performance scenarios, and
 * cross-approach comparisons to ensure correctness and consistency.
 */
public class LongestNiceSubstringTest {

    private LongestNiceSubstring solution;

    @BeforeEach
    void setUp() {
        solution = new LongestNiceSubstring();
    }

    @Nested
    @DisplayName("LeetCode Examples Tests")
    class LeetCodeExamplesTests {

        @Test
        @DisplayName("Example 1: YazaAay should return aAa")
        void testExample1() {
            String input = "YazaAay";
            String expected = "aAa";

            assertEquals(expected, solution.longestNiceSubstringDivideAndConquer(input));
            assertEquals(expected, solution.longestNiceSubstringSlidingWindow(input));
            assertEquals(expected, solution.longestNiceSubstringBruteForce(input));
            assertEquals(expected, solution.longestNiceSubstringOptimized(input));
            assertEquals(expected, solution.longestNiceSubstringTwoPass(input));
        }

        @Test
        @DisplayName("Example 2: Bb should return Bb")
        void testExample2() {
            String input = "Bb";
            String expected = "Bb";

            assertEquals(expected, solution.longestNiceSubstringDivideAndConquer(input));
            assertEquals(expected, solution.longestNiceSubstringSlidingWindow(input));
            assertEquals(expected, solution.longestNiceSubstringBruteForce(input));
            assertEquals(expected, solution.longestNiceSubstringOptimized(input));
            assertEquals(expected, solution.longestNiceSubstringTwoPass(input));
        }

        @Test
        @DisplayName("Example 3: c should return empty string")
        void testExample3() {
            String input = "c";
            String expected = "";

            assertEquals(expected, solution.longestNiceSubstringDivideAndConquer(input));
            assertEquals(expected, solution.longestNiceSubstringSlidingWindow(input));
            assertEquals(expected, solution.longestNiceSubstringBruteForce(input));
            assertEquals(expected, solution.longestNiceSubstringOptimized(input));
            assertEquals(expected, solution.longestNiceSubstringTwoPass(input));
        }
    }

    @Nested
    @DisplayName("Edge Case Tests")
    class EdgeCaseTests {

        @Test
        @DisplayName("Empty string should return empty string")
        void testEmptyString() {
            String input = "";
            String expected = "";

            assertEquals(expected, solution.longestNiceSubstringDivideAndConquer(input));
            assertEquals(expected, solution.longestNiceSubstringSlidingWindow(input));
            assertEquals(expected, solution.longestNiceSubstringBruteForce(input));
            assertEquals(expected, solution.longestNiceSubstringOptimized(input));
            assertEquals(expected, solution.longestNiceSubstringTwoPass(input));
        }

        @Test
        @DisplayName("Single character should return empty string")
        void testSingleCharacter() {
            String input = "a";
            String expected = "";

            assertEquals(expected, solution.longestNiceSubstringDivideAndConquer(input));
            assertEquals(expected, solution.longestNiceSubstringSlidingWindow(input));
            assertEquals(expected, solution.longestNiceSubstringBruteForce(input));
            assertEquals(expected, solution.longestNiceSubstringOptimized(input));
            assertEquals(expected, solution.longestNiceSubstringTwoPass(input));
        }

        @Test
        @DisplayName("Two different characters should return empty string")
        void testTwoDifferentCharacters() {
            String input = "ab";
            String expected = "";

            assertEquals(expected, solution.longestNiceSubstringDivideAndConquer(input));
            assertEquals(expected, solution.longestNiceSubstringSlidingWindow(input));
            assertEquals(expected, solution.longestNiceSubstringBruteForce(input));
            assertEquals(expected, solution.longestNiceSubstringOptimized(input));
            assertEquals(expected, solution.longestNiceSubstringTwoPass(input));
        }

        @Test
        @DisplayName("All uppercase should return empty string")
        void testAllUppercase() {
            String input = "ABC";
            String expected = "";

            assertEquals(expected, solution.longestNiceSubstringDivideAndConquer(input));
            assertEquals(expected, solution.longestNiceSubstringSlidingWindow(input));
            assertEquals(expected, solution.longestNiceSubstringBruteForce(input));
            assertEquals(expected, solution.longestNiceSubstringOptimized(input));
            assertEquals(expected, solution.longestNiceSubstringTwoPass(input));
        }

        @Test
        @DisplayName("All lowercase should return empty string")
        void testAllLowercase() {
            String input = "abc";
            String expected = "";

            assertEquals(expected, solution.longestNiceSubstringDivideAndConquer(input));
            assertEquals(expected, solution.longestNiceSubstringSlidingWindow(input));
            assertEquals(expected, solution.longestNiceSubstringBruteForce(input));
            assertEquals(expected, solution.longestNiceSubstringOptimized(input));
            assertEquals(expected, solution.longestNiceSubstringTwoPass(input));
        }
    }

    @Nested
    @DisplayName("Nice Substring Tests")
    class NiceSubstringTests {

        @Test
        @DisplayName("Complete nice string should return itself")
        void testCompleteNiceString() {
            String input = "abABB";
            String expected = "abABB";

            assertEquals(expected, solution.longestNiceSubstringDivideAndConquer(input));
            assertEquals(expected, solution.longestNiceSubstringSlidingWindow(input));
            assertEquals(expected, solution.longestNiceSubstringBruteForce(input));
            assertEquals(expected, solution.longestNiceSubstringOptimized(input));
            assertEquals(expected, solution.longestNiceSubstringTwoPass(input));
        }

        @Test
        @DisplayName("Long nice string should return itself")
        void testLongNiceString() {
            String input = "aAbBcCdD";
            String expected = "aAbBcCdD";

            assertEquals(expected, solution.longestNiceSubstringDivideAndConquer(input));
            assertEquals(expected, solution.longestNiceSubstringSlidingWindow(input));
            assertEquals(expected, solution.longestNiceSubstringBruteForce(input));
            assertEquals(expected, solution.longestNiceSubstringOptimized(input));
            assertEquals(expected, solution.longestNiceSubstringTwoPass(input));
        }

        @Test
        @DisplayName("Nice substring at beginning")
        void testNiceSubstringAtBeginning() {
            String input = "aAbBc";
            String expected = "aAbB";

            assertEquals(expected, solution.longestNiceSubstringDivideAndConquer(input));
            assertEquals(expected, solution.longestNiceSubstringSlidingWindow(input));
            assertEquals(expected, solution.longestNiceSubstringBruteForce(input));
            assertEquals(expected, solution.longestNiceSubstringOptimized(input));
            assertEquals(expected, solution.longestNiceSubstringTwoPass(input));
        }

        @Test
        @DisplayName("Nice substring at end")
        void testNiceSubstringAtEnd() {
            String input = "caAbB";
            String expected = "aAbB";

            assertEquals(expected, solution.longestNiceSubstringDivideAndConquer(input));
            assertEquals(expected, solution.longestNiceSubstringSlidingWindow(input));
            assertEquals(expected, solution.longestNiceSubstringBruteForce(input));
            assertEquals(expected, solution.longestNiceSubstringOptimized(input));
            assertEquals(expected, solution.longestNiceSubstringTwoPass(input));
        }

        @Test
        @DisplayName("Nice substring in middle")
        void testNiceSubstringInMiddle() {
            String input = "caAbBd";
            String expected = "aAbB";

            assertEquals(expected, solution.longestNiceSubstringDivideAndConquer(input));
            assertEquals(expected, solution.longestNiceSubstringSlidingWindow(input));
            assertEquals(expected, solution.longestNiceSubstringBruteForce(input));
            assertEquals(expected, solution.longestNiceSubstringOptimized(input));
            assertEquals(expected, solution.longestNiceSubstringTwoPass(input));
        }
    }

    @Nested
    @DisplayName("Multiple Nice Substrings Tests")
    class MultipleNiceSubstringsTests {

        @Test
        @DisplayName("Two equal length nice substrings should return first")
        void testTwoEqualLengthNiceSubstrings() {
            String input = "aAbBcCdD";
            String expected = "aAbBcCdD"; // Should return the entire string

            assertEquals(expected, solution.longestNiceSubstringDivideAndConquer(input));
            assertEquals(expected, solution.longestNiceSubstringSlidingWindow(input));
            assertEquals(expected, solution.longestNiceSubstringBruteForce(input));
            assertEquals(expected, solution.longestNiceSubstringOptimized(input));
            assertEquals(expected, solution.longestNiceSubstringTwoPass(input));
        }

        @Test
        @DisplayName("Different length nice substrings should return longer")
        void testDifferentLengthNiceSubstrings() {
            String input = "aAbBcCd";
            String expected = "aAbBcC";

            assertEquals(expected, solution.longestNiceSubstringDivideAndConquer(input));
            assertEquals(expected, solution.longestNiceSubstringSlidingWindow(input));
            assertEquals(expected, solution.longestNiceSubstringBruteForce(input));
            assertEquals(expected, solution.longestNiceSubstringOptimized(input));
            assertEquals(expected, solution.longestNiceSubstringTwoPass(input));
        }

        @Test
        @DisplayName("Multiple nice substrings with different lengths")
        void testMultipleNiceSubstrings() {
            String input = "aAbBcCdDeE";
            String expected = "aAbBcCdDeE";

            assertEquals(expected, solution.longestNiceSubstringDivideAndConquer(input));
            assertEquals(expected, solution.longestNiceSubstringSlidingWindow(input));
            assertEquals(expected, solution.longestNiceSubstringBruteForce(input));
            assertEquals(expected, solution.longestNiceSubstringOptimized(input));
            assertEquals(expected, solution.longestNiceSubstringTwoPass(input));
        }
    }

    @Nested
    @DisplayName("Complex Pattern Tests")
    class ComplexPatternTests {

        @Test
        @DisplayName("Nested nice substrings")
        void testNestedNiceSubstrings() {
            String input = "aAbBcCdDeEfF";
            String expected = "aAbBcCdDeEfF";

            assertEquals(expected, solution.longestNiceSubstringDivideAndConquer(input));
            assertEquals(expected, solution.longestNiceSubstringSlidingWindow(input));
            assertEquals(expected, solution.longestNiceSubstringBruteForce(input));
            assertEquals(expected, solution.longestNiceSubstringOptimized(input));
            assertEquals(expected, solution.longestNiceSubstringTwoPass(input));
        }

        @Test
        @DisplayName("Alternating nice and non-nice patterns")
        void testAlternatingPatterns() {
            String input = "aAbBcCdDeEfFgG";
            String expected = "aAbBcCdDeEfFgG";

            assertEquals(expected, solution.longestNiceSubstringDivideAndConquer(input));
            assertEquals(expected, solution.longestNiceSubstringSlidingWindow(input));
            assertEquals(expected, solution.longestNiceSubstringBruteForce(input));
            assertEquals(expected, solution.longestNiceSubstringOptimized(input));
            assertEquals(expected, solution.longestNiceSubstringTwoPass(input));
        }

        @Test
        @DisplayName("Complex mixed case string")
        void testComplexMixedCase() {
            String input = "dDzeE";
            String expected = "dD";

            assertEquals(expected, solution.longestNiceSubstringDivideAndConquer(input));
            assertEquals(expected, solution.longestNiceSubstringSlidingWindow(input));
            assertEquals(expected, solution.longestNiceSubstringBruteForce(input));
            assertEquals(expected, solution.longestNiceSubstringOptimized(input));
            assertEquals(expected, solution.longestNiceSubstringTwoPass(input));
        }
    }

    @Nested
    @DisplayName("Cross Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @Test
        @DisplayName("All approaches should return same result for simple case")
        void testApproachesConsistencySimple() {
            String input = "YazaAay";

            String result1 = solution.longestNiceSubstringDivideAndConquer(input);
            String result2 = solution.longestNiceSubstringSlidingWindow(input);
            String result3 = solution.longestNiceSubstringBruteForce(input);
            String result4 = solution.longestNiceSubstringOptimized(input);
            String result5 = solution.longestNiceSubstringTwoPass(input);

            assertEquals(result1, result2);
            assertEquals(result1, result3);
            assertEquals(result1, result4);
            assertEquals(result1, result5);
        }

        @Test
        @DisplayName("All approaches should return same result for complex case")
        void testApproachesConsistencyComplex() {
            String input = "aAbBcCdDeEfFgGhHiIjJ";

            String result1 = solution.longestNiceSubstringDivideAndConquer(input);
            String result2 = solution.longestNiceSubstringSlidingWindow(input);
            String result3 = solution.longestNiceSubstringBruteForce(input);
            String result4 = solution.longestNiceSubstringOptimized(input);
            String result5 = solution.longestNiceSubstringTwoPass(input);

            assertEquals(result1, result2);
            assertEquals(result1, result3);
            assertEquals(result1, result4);
            assertEquals(result1, result5);
        }

        @Test
        @DisplayName("All approaches should return same result for edge cases")
        void testApproachesConsistencyEdgeCases() {
            List<String> testCases =
                    Arrays.asList("", "a", "ab", "ABC", "abc", "aAbB", "aAbBc", "caAbBd");

            for (String testCase : testCases) {
                String result1 = solution.longestNiceSubstringDivideAndConquer(testCase);
                String result2 = solution.longestNiceSubstringSlidingWindow(testCase);
                String result3 = solution.longestNiceSubstringBruteForce(testCase);
                String result4 = solution.longestNiceSubstringOptimized(testCase);
                String result5 = solution.longestNiceSubstringTwoPass(testCase);

                assertEquals(result1, result2, "Failed for input: " + testCase);
                assertEquals(result1, result3, "Failed for input: " + testCase);
                assertEquals(result1, result4, "Failed for input: " + testCase);
                assertEquals(result1, result5, "Failed for input: " + testCase);
            }
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Performance test with maximum length string")
        void testPerformanceMaxLength() {
            // Create a string of maximum allowed length (100)
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 50; i++) {
                sb.append((char) ('a' + i % 26));
                sb.append((char) ('A' + i % 26));
            }
            String input = sb.toString();

            long startTime = System.nanoTime();
            String result = solution.longestNiceSubstringDivideAndConquer(input);
            long endTime = System.nanoTime();

            long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds

            assertNotNull(result);
            assertTrue(duration < 1000, "Performance test took too long: " + duration + "ms");
        }

        @Test
        @DisplayName("Performance comparison between approaches")
        void testPerformanceComparison() {
            String input = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ";

            // Test divide and conquer approach
            long start1 = System.nanoTime();
            String result1 = solution.longestNiceSubstringDivideAndConquer(input);
            long end1 = System.nanoTime();

            // Test sliding window approach
            long start2 = System.nanoTime();
            String result2 = solution.longestNiceSubstringSlidingWindow(input);
            long end2 = System.nanoTime();

            // Test optimized approach
            long start3 = System.nanoTime();
            String result3 = solution.longestNiceSubstringOptimized(input);
            long end3 = System.nanoTime();

            assertEquals(result1, result2);
            assertEquals(result1, result3);

            // Log performance (optional)
            System.out.println("Divide and Conquer: " + (end1 - start1) / 1_000_000 + "ms");
            System.out.println("Sliding Window: " + (end2 - start2) / 1_000_000 + "ms");
            System.out.println("Optimized: " + (end3 - start3) / 1_000_000 + "ms");
        }
    }

    @Nested
    @DisplayName("Utility Method Tests")
    class UtilityMethodTests {

        @Test
        @DisplayName("Demonstrate examples method should work without errors")
        void testDemonstrateExamples() {
            // This test ensures the demonstration method doesn't throw exceptions
            assertDoesNotThrow(() -> solution.demonstrateExamples());
        }
    }

    @Nested
    @DisplayName("Boundary Condition Tests")
    class BoundaryConditionTests {

        @Test
        @DisplayName("String with only one type of character")
        void testOnlyOneCharacterType() {
            String input = "aaaa";
            String expected = "";

            assertEquals(expected, solution.longestNiceSubstringDivideAndConquer(input));
            assertEquals(expected, solution.longestNiceSubstringSlidingWindow(input));
            assertEquals(expected, solution.longestNiceSubstringBruteForce(input));
            assertEquals(expected, solution.longestNiceSubstringOptimized(input));
            assertEquals(expected, solution.longestNiceSubstringTwoPass(input));
        }

        @Test
        @DisplayName("String with alternating single characters")
        void testAlternatingSingleCharacters() {
            String input = "ababab";
            String expected = "";

            assertEquals(expected, solution.longestNiceSubstringDivideAndConquer(input));
            assertEquals(expected, solution.longestNiceSubstringSlidingWindow(input));
            assertEquals(expected, solution.longestNiceSubstringBruteForce(input));
            assertEquals(expected, solution.longestNiceSubstringOptimized(input));
            assertEquals(expected, solution.longestNiceSubstringTwoPass(input));
        }

        @Test
        @DisplayName("String with repeated nice pairs")
        void testRepeatedNicePairs() {
            String input = "aAaAaA";
            String expected = "aAaAaA";

            assertEquals(expected, solution.longestNiceSubstringDivideAndConquer(input));
            assertEquals(expected, solution.longestNiceSubstringSlidingWindow(input));
            assertEquals(expected, solution.longestNiceSubstringBruteForce(input));
            assertEquals(expected, solution.longestNiceSubstringOptimized(input));
            assertEquals(expected, solution.longestNiceSubstringTwoPass(input));
        }
    }
}
