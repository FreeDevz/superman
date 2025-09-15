package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Comprehensive test suite for FindMostFrequentVowelAndConsonant Tests all solution approaches and
 * edge cases
 */
public class FindMostFrequentVowelAndConsonantTest {

    private FindMostFrequentVowelAndConsonant solution;

    @BeforeEach
    void setUp() {
        solution = new FindMostFrequentVowelAndConsonant();
    }

    @Nested
    @DisplayName("LeetCode Example Tests")
    class LeetCodeExampleTests {

        @Test
        @DisplayName("Example 1: leetcode")
        void testExample1() {
            String s = "leetcode";
            int expected = 4; // 'e' appears 3 times (max vowel), 'l','t','c','d' each appear 1 time
                              // (max consonant = 1)
            assertEquals(expected, solution.maxFreqSum(s));
            assertEquals(expected, solution.maxFreqSumHashMap(s));
            assertEquals(expected, solution.maxFreqSumSinglePass(s));
            assertEquals(expected, solution.maxFreqSumStreams(s));
        }

        @Test
        @DisplayName("Example 2: aeiou")
        void testExample2() {
            String s = "aeiou";
            int expected = 1; // Each vowel appears once, no consonants
            assertEquals(expected, solution.maxFreqSum(s));
            assertEquals(expected, solution.maxFreqSumHashMap(s));
            assertEquals(expected, solution.maxFreqSumSinglePass(s));
            assertEquals(expected, solution.maxFreqSumStreams(s));
        }

        @Test
        @DisplayName("Example 3: abcde")
        void testExample3() {
            String s = "abcde";
            int expected = 2; // Each character appears once: max vowel = 1, max consonant = 1
            assertEquals(expected, solution.maxFreqSum(s));
            assertEquals(expected, solution.maxFreqSumHashMap(s));
            assertEquals(expected, solution.maxFreqSumSinglePass(s));
            assertEquals(expected, solution.maxFreqSumStreams(s));
        }
    }

    @Nested
    @DisplayName("Basic Functionality Tests")
    class BasicFunctionalityTests {

        @Test
        @DisplayName("Single character - vowel")
        void testSingleVowel() {
            String s = "a";
            int expected = 1;
            assertEquals(expected, solution.maxFreqSum(s));
        }

        @Test
        @DisplayName("Single character - consonant")
        void testSingleConsonant() {
            String s = "b";
            int expected = 1;
            assertEquals(expected, solution.maxFreqSum(s));
        }

        @Test
        @DisplayName("All vowels")
        void testAllVowels() {
            String s = "aeiou";
            int expected = 1;
            assertEquals(expected, solution.maxFreqSum(s));
        }

        @Test
        @DisplayName("All consonants")
        void testAllConsonants() {
            String s = "bcdfg";
            int expected = 1;
            assertEquals(expected, solution.maxFreqSum(s));
        }

        @Test
        @DisplayName("Repeated vowels")
        void testRepeatedVowels() {
            String s = "aaaeee";
            int expected = 3; // 'a' appears 3 times, 'e' appears 3 times, no consonants
            assertEquals(expected, solution.maxFreqSum(s));
        }

        @Test
        @DisplayName("Repeated consonants")
        void testRepeatedConsonants() {
            String s = "bbccdd";
            int expected = 2; // 'b', 'c', 'd' each appear 2 times, no vowels
            assertEquals(expected, solution.maxFreqSum(s));
        }
    }

    @Nested
    @DisplayName("Edge Cases and Boundary Tests")
    class EdgeCasesAndBoundaryTests {

        @Test
        @DisplayName("Minimum length string")
        void testMinimumLength() {
            String s = "a";
            int expected = 1;
            assertEquals(expected, solution.maxFreqSum(s));
        }

        @Test
        @DisplayName("Maximum length string (1000 characters)")
        void testMaximumLength() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 1000; i++) {
                sb.append('a');
            }
            String s = sb.toString();
            int expected = 1000; // All 'a' (vowel), no consonants
            assertEquals(expected, solution.maxFreqSum(s));
        }

        @Test
        @DisplayName("All same vowel")
        void testAllSameVowel() {
            String s = "aaaaa";
            int expected = 5; // All 'a' (vowel), no consonants
            assertEquals(expected, solution.maxFreqSum(s));
        }

        @Test
        @DisplayName("All same consonant")
        void testAllSameConsonant() {
            String s = "bbbbb";
            int expected = 5; // All 'b' (consonant), no vowels
            assertEquals(expected, solution.maxFreqSum(s));
        }

        @Test
        @DisplayName("Mixed with one dominant vowel")
        void testDominantVowel() {
            String s = "aaabbbccc";
            int expected = 6; // 'a' appears 3 times (max vowel), 'b' and 'c' each appear 3 times
                              // (max consonant = 3)
            assertEquals(expected, solution.maxFreqSum(s));
        }

        @Test
        @DisplayName("Mixed with one dominant consonant")
        void testDominantConsonant() {
            String s = "aaabbbbb";
            int expected = 8; // 'a' appears 3 times (max vowel), 'b' appears 5 times (max consonant
                              // = 5)
            assertEquals(expected, solution.maxFreqSum(s));
        }
    }

    @Nested
    @DisplayName("Complex Scenarios")
    class ComplexScenarios {

        @Test
        @DisplayName("Complex mixed string")
        void testComplexMixed() {
            String s = "programming";
            // p(1), r(2), o(1), g(2), a(1), m(2), i(1), n(1)
            // Vowels: o(1), a(1), i(1) -> max = 1
            // Consonants: p(1), r(2), g(2), m(2), n(1) -> max = 2
            int expected = 3; // 1 + 2
            assertEquals(expected, solution.maxFreqSum(s));
        }

        @Test
        @DisplayName("Palindrome with mixed frequencies")
        void testPalindrome() {
            String s = "racecar";
            // r(2), a(2), c(2), e(1)
            // Vowels: a(2), e(1) -> max = 2
            // Consonants: r(2), c(2) -> max = 2
            int expected = 4; // 2 + 2
            assertEquals(expected, solution.maxFreqSum(s));
        }

        @Test
        @DisplayName("String with all letters")
        void testAllLetters() {
            String s = "abcdefghijklmnopqrstuvwxyz";
            // Each letter appears once
            // Vowels: a(1), e(1), i(1), o(1), u(1) -> max = 1
            // Consonants: all others appear once -> max = 1
            int expected = 2; // 1 + 1
            assertEquals(expected, solution.maxFreqSum(s));
        }
    }

    @Nested
    @DisplayName("Parameterized Tests")
    class ParameterizedTests {

        @ParameterizedTest
        @CsvSource({"hello, 3", // h(1), e(1), l(2), o(1) -> vowels: e(1), o(1) max=1, consonants:
                                // h(1), l(2) max=2
                "world, 2", // w(1), o(1), r(1), l(1), d(1) -> vowels: o(1) max=1, consonants: w(1),
                            // r(1), l(1), d(1) max=1
                "algorithm, 2", // a(1), l(1), g(1), o(1), r(1), i(1), t(1), h(1), m(1) -> vowels:
                                // a(1), o(1), i(1) max=1, consonants: l(1), g(1), r(1), t(1), h(1),
                                // m(1) max=1
                "computer, 2", // c(1), o(1), m(1), p(1), u(1), t(1), e(1), r(1) -> vowels: o(1),
                               // u(1), e(1) max=1, consonants: c(1), m(1), p(1), t(1), r(1) max=1
                "programming, 3" // p(1), r(2), o(1), g(2), a(1), m(2), i(1), n(1) -> vowels: o(1),
                                 // a(1), i(1) max=1, consonants: p(1), r(2), g(2), m(2), n(1) max=2
        })
        @DisplayName("Various test cases with expected results")
        void testVariousCases(String input, int expected) {
            assertEquals(expected, solution.maxFreqSum(input));
            assertEquals(expected, solution.maxFreqSumHashMap(input));
            assertEquals(expected, solution.maxFreqSumSinglePass(input));
            assertEquals(expected, solution.maxFreqSumStreams(input));
        }

        @ParameterizedTest
        @ValueSource(strings = {"a", "e", "i", "o", "u"})
        @DisplayName("Single vowel characters")
        void testSingleVowels(String vowel) {
            assertEquals(1, solution.maxFreqSum(vowel));
        }

        @ParameterizedTest
        @ValueSource(strings = {"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q",
                "r", "s", "t", "v", "w", "x", "y", "z"})
        @DisplayName("Single consonant characters")
        void testSingleConsonants(String consonant) {
            assertEquals(1, solution.maxFreqSum(consonant));
        }
    }

    @Nested
    @DisplayName("Cross-Validation Tests")
    class CrossValidationTests {

        @Test
        @DisplayName("All solution methods produce same result")
        void testAllMethodsConsistency() {
            String[] testCases = {"leetcode", "aeiou", "abcde", "hello", "world", "programming",
                    "racecar", "abcdefghijklmnopqrstuvwxyz", "aaabbbccc", "zzzzz", "aeiouaeiou"};

            for (String testCase : testCases) {
                int result1 = solution.maxFreqSum(testCase);
                int result2 = solution.maxFreqSumHashMap(testCase);
                int result3 = solution.maxFreqSumSinglePass(testCase);
                int result4 = solution.maxFreqSumStreams(testCase);

                assertEquals(result1, result2, "HashMap method differs for: " + testCase);
                assertEquals(result1, result3, "Single pass method differs for: " + testCase);
                assertEquals(result1, result4, "Streams method differs for: " + testCase);
            }
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Large string performance test")
        void testLargeStringPerformance() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 1000; i++) {
                sb.append((char) ('a' + (i % 26)));
            }
            String largeString = sb.toString();

            long startTime = System.nanoTime();
            int result = solution.maxFreqSum(largeString);
            long endTime = System.nanoTime();

            assertTrue(result > 0, "Result should be positive");
            assertTrue((endTime - startTime) < 1_000_000, "Should complete within 1ms"); // 1ms =
                                                                                         // 1,000,000
                                                                                         // nanoseconds
        }
    }

    @Nested
    @DisplayName("Analysis Helper Tests")
    class AnalysisHelperTests {

        @Test
        @DisplayName("String analysis helper method")
        void testAnalyzeString() {
            String s = "hello";
            String analysis = solution.analyzeString(s);

            assertTrue(analysis.contains("String: hello"));
            assertTrue(analysis.contains("Vowels:"));
            assertTrue(analysis.contains("Consonants:"));
            assertTrue(analysis.contains("Max vowel frequency:"));
            assertTrue(analysis.contains("Max consonant frequency:"));
            assertTrue(analysis.contains("Result:"));
        }

        @Test
        @DisplayName("Analysis matches actual result")
        void testAnalysisMatchesResult() {
            String s = "programming";
            String analysis = solution.analyzeString(s);
            int actualResult = solution.maxFreqSum(s);

            // Extract result from analysis string
            String[] lines = analysis.split("\n");
            String resultLine = lines[lines.length - 1];
            int analysisResult = Integer.parseInt(resultLine.split(": ")[1]);

            assertEquals(actualResult, analysisResult);
        }
    }

    @Nested
    @DisplayName("Validation Tests")
    class ValidationTests {

        @Test
        @DisplayName("Result is always non-negative")
        void testNonNegativeResult() {
            String[] testCases = {"a", "b", "aa", "bb", "ab", "leetcode", "aeiou", "bcdfg"};

            for (String testCase : testCases) {
                int result = solution.maxFreqSum(testCase);
                assertTrue(result >= 0, "Result should be non-negative for: " + testCase);
            }
        }

        @Test
        @DisplayName("Result is at most string length")
        void testResultAtMostStringLength() {
            String[] testCases = {"a", "ab", "abc", "leetcode", "programming"};

            for (String testCase : testCases) {
                int result = solution.maxFreqSum(testCase);
                assertTrue(result <= testCase.length(),
                        "Result should be at most string length for: " + testCase + " (result: "
                                + result + ", length: " + testCase.length() + ")");
            }
        }
    }
}
