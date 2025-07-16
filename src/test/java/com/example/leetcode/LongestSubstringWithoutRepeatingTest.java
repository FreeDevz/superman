package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Test class for LongestSubstringWithoutRepeating LeetCode solution
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("LeetCode #3: Longest Substring Without Repeating Characters")
class LongestSubstringWithoutRepeatingTest {

    private LongestSubstringWithoutRepeating solution;

    @BeforeEach
    void setUp() {
        solution = new LongestSubstringWithoutRepeating();
    }

    @ParameterizedTest
    @CsvSource({"'abcabcbb', 3", // Example 1: "abc"
            "'bbbbb', 1", // Example 2: "b"
            "'pwwkew', 3", // Example 3: "wke"
            "'', 0", // Empty string
            "'au', 2", // Two unique characters
            "'dvdf', 3", // "vdf"
            "' ', 1", // Single space
            "'abcdef', 6", // All unique characters
    })
    @DisplayName("Test main solution with various inputs")
    void testLengthOfLongestSubstring(String input, int expected) {
        assertEquals(expected, solution.lengthOfLongestSubstring(input));
    }

    @ParameterizedTest
    @CsvSource({"'abcabcbb', 3", // Example 1: "abc"
            "'bbbbb', 1", // Example 2: "b"
            "'pwwkew', 3", // Example 3: "wke"
            "'', 0", // Empty string
            "'au', 2", // Two unique characters
            "'dvdf', 3", // "vdf"
            "' ', 1", // Single space
            "'abcdef', 6", // All unique characters
    })
    @DisplayName("Test HashSet solution with various inputs")
    void testLengthOfLongestSubstringHashSet(String input, int expected) {
        assertEquals(expected, solution.lengthOfLongestSubstringHashSet(input));
    }

    @ParameterizedTest
    @CsvSource({"'abcabcbb', 3", // Example 1: "abc"
            "'bbbbb', 1", // Example 2: "b"
            "'pwwkew', 3", // Example 3: "wke"
            "'', 0", // Empty string
            "'au', 2", // Two unique characters
            "'dvdf', 3", // "vdf"
            "' ', 1", // Single space
            "'abcdef', 6", // All unique characters
    })
    @DisplayName("Test brute force solution with various inputs")
    void testLengthOfLongestSubstringBruteForce(String input, int expected) {
        assertEquals(expected, solution.lengthOfLongestSubstringBruteForce(input));
    }

    @Test
    @DisplayName("Test null input")
    void testNullInput() {
        assertEquals(0, solution.lengthOfLongestSubstring(null));
        assertEquals(0, solution.lengthOfLongestSubstringHashSet(null));
        assertEquals(0, solution.lengthOfLongestSubstringBruteForce(null));
    }

    @Test
    @DisplayName("Test single character")
    void testSingleCharacter() {
        assertEquals(1, solution.lengthOfLongestSubstring("a"));
        assertEquals(1, solution.lengthOfLongestSubstringHashSet("a"));
        assertEquals(1, solution.lengthOfLongestSubstringBruteForce("a"));
    }

    @Test
    @DisplayName("Test all same characters")
    void testAllSameCharacters() {
        String input = "aaaaaaa";
        assertEquals(1, solution.lengthOfLongestSubstring(input));
        assertEquals(1, solution.lengthOfLongestSubstringHashSet(input));
        assertEquals(1, solution.lengthOfLongestSubstringBruteForce(input));
    }

    @Test
    @DisplayName("Test string with special characters")
    void testSpecialCharacters() {
        String input = "!@#$%^&*()";
        assertEquals(10, solution.lengthOfLongestSubstring(input));
        assertEquals(10, solution.lengthOfLongestSubstringHashSet(input));
        assertEquals(10, solution.lengthOfLongestSubstringBruteForce(input));
    }

    @Test
    @DisplayName("Test string with digits")
    void testWithDigits() {
        String input = "0123456789";
        assertEquals(10, solution.lengthOfLongestSubstring(input));
        assertEquals(10, solution.lengthOfLongestSubstringHashSet(input));
        assertEquals(10, solution.lengthOfLongestSubstringBruteForce(input));
    }

    @Test
    @DisplayName("Test string with repeating pattern")
    void testRepeatingPattern() {
        String input = "abcabcabcabc";
        assertEquals(3, solution.lengthOfLongestSubstring(input));
        assertEquals(3, solution.lengthOfLongestSubstringHashSet(input));
        assertEquals(3, solution.lengthOfLongestSubstringBruteForce(input));
    }

    @Test
    @DisplayName("Test alternating characters")
    void testAlternatingCharacters() {
        String input = "abababab";
        assertEquals(2, solution.lengthOfLongestSubstring(input));
        assertEquals(2, solution.lengthOfLongestSubstringHashSet(input));
        assertEquals(2, solution.lengthOfLongestSubstringBruteForce(input));
    }

    @Test
    @DisplayName("Test consistency between different approaches")
    void testConsistencyBetweenApproaches() {
        String[] testCases = {"abcabcbb", "bbbbb", "pwwkew", "au", "dvdf", " ", "abcdef", "hello",
                "world", "java", "algorithm", "data", "structure"};

        for (String testCase : testCases) {
            int result1 = solution.lengthOfLongestSubstring(testCase);
            int result2 = solution.lengthOfLongestSubstringHashSet(testCase);
            int result3 = solution.lengthOfLongestSubstringBruteForce(testCase);

            assertEquals(result1, result2,
                    String.format("HashMap and HashSet results differ for input: %s", testCase));
            assertEquals(result1, result3,
                    String.format("HashMap and BruteForce results differ for input: %s", testCase));
        }
    }

    @Test
    @DisplayName("Test with long repeating substring")
    void testLongRepeatingSubstring() {
        String input = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
        int expected = 26; // All lowercase English letters

        assertEquals(expected, solution.lengthOfLongestSubstring(input));
        assertEquals(expected, solution.lengthOfLongestSubstringHashSet(input));
        // Skip brute force for this test as it's O(n^3) and would be slow
    }

    @Test
    @DisplayName("Test performance comparison")
    void testPerformanceComparison() {
        String input = "abcdefghijklmnopqrstuvwxyz".repeat(10); // 260 characters

        // Test that all solutions return the same result
        long start1 = System.nanoTime();
        int result1 = solution.lengthOfLongestSubstring(input);
        long time1 = System.nanoTime() - start1;

        long start2 = System.nanoTime();
        int result2 = solution.lengthOfLongestSubstringHashSet(input);
        long time2 = System.nanoTime() - start2;

        assertEquals(result1, result2);
        assertEquals(26, result1); // Should be 26 (all lowercase letters)

        // HashMap solution should be faster or comparable
        assertTrue(time1 <= time2 * 2, "HashMap solution should be reasonably fast");

        System.out.printf("Performance test - HashMap: %.2f ms, HashSet: %.2f ms%n",
                time1 / 1_000_000.0, time2 / 1_000_000.0);
    }
}
