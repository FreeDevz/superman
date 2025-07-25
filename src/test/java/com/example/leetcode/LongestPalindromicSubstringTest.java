package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Comprehensive test suite for LongestPalindromicSubstring Tests all four approaches: Expand Around
 * Centers, Manacher's Algorithm, Dynamic Programming, and Brute Force
 */
public class LongestPalindromicSubstringTest {

    private LongestPalindromicSubstring solution;

    @BeforeEach
    void setUp() {
        solution = new LongestPalindromicSubstring();
    }

    // ========================================
    // TEST DATA PROVIDERS
    // ========================================

    /**
     * Provides test cases with input and expected output
     */
    static Stream<Arguments> palindromeTestCases() {
        return Stream.of(
                // Basic examples from LeetCode
                Arguments.of("babad", List.of("bab", "aba")), // Multiple valid answers
                Arguments.of("cbbd", List.of("bb")),

                // Edge cases
                Arguments.of("a", List.of("a")), // Single character
                Arguments.of("ac", List.of("a", "c")), // Two different characters
                Arguments.of("aa", List.of("aa")), // Two same characters
                Arguments.of("", List.of("")), // Empty string

                // Palindromes at different positions
                Arguments.of("racecar", List.of("racecar")), // Entire string is palindrome
                Arguments.of("abcdef", List.of("a", "b", "c", "d", "e", "f")), // No palindromes > 1
                Arguments.of("abacabad", List.of("abacaba")), // Long palindrome in middle

                // Even and odd length palindromes
                Arguments.of("noon", List.of("noon")), // Even length
                Arguments.of("level", List.of("level")), // Odd length
                Arguments.of("abccba", List.of("abccba")), // Even length, entire string

                // Multiple palindromes of same length
                Arguments.of("abacad", List.of("aba", "aca")), // Two 3-length palindromes
                Arguments.of("xaabacxcabaax", List.of("xaabacxcabaax")), // Nested palindromes

                // Special patterns
                Arguments.of("aaaa", List.of("aaaa")), // All same characters
                Arguments.of("abcba", List.of("abcba")), // Classic palindrome
                Arguments.of("abcdeffedcba", List.of("abcdeffedcba")), // Long palindrome

                // Edge cases with repeated patterns
                Arguments.of("bananas", List.of("anana")), // Example from Wikipedia
                Arguments.of(
                        "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendure",
                        List.of("ranynar")) // Complex string with embedded palindrome
        );
    }

    /**
     * Provides edge case test scenarios
     */
    static Stream<Arguments> edgeCaseTestCases() {
        return Stream.of(Arguments.of(null, ""), // Null input
                Arguments.of("", ""), // Empty string
                Arguments.of("a", "a"), // Single character
                Arguments.of("ab", "a"), // Two different characters
                Arguments.of("aa", "aa"), // Two same characters
                Arguments.of("aba", "aba"), // Three character palindrome
                Arguments.of("abcd", "a") // No palindrome longer than 1
        );
    }

    // ========================================
    // APPROACH 1: EXPAND AROUND CENTERS TESTS
    // ========================================

    @ParameterizedTest
    @MethodSource("palindromeTestCases")
    @DisplayName("Test Expand Around Centers approach")
    void testLongestPalindromeExpandCenters(String input, List<String> expectedOutputs) {
        String result = solution.longestPalindrome(input);

        assertNotNull(result, "Result should not be null");
        assertTrue(expectedOutputs.contains(result),
                String.format("Expected one of %s, but got '%s'", expectedOutputs, result));
        assertTrue(solution.isPalindrome(result),
                String.format("Result '%s' should be a palindrome", result));
    }

    @Test
    @DisplayName("Test Expand Around Centers with specific examples")
    void testExpandAroundCentersSpecificCases() {
        // Test case where entire string is palindrome
        assertEquals("racecar", solution.longestPalindrome("racecar"));

        // Test case with even-length palindrome
        assertEquals("bb", solution.longestPalindrome("abbc"));

        // Test case with odd-length palindrome
        assertEquals("aba", solution.longestPalindrome("xabay"));
    }

    // ========================================
    // APPROACH 2: MANACHER'S ALGORITHM TESTS
    // ========================================

    @ParameterizedTest
    @MethodSource("palindromeTestCases")
    @DisplayName("Test Manacher's Algorithm approach")
    void testLongestPalindromeManacher(String input, List<String> expectedOutputs) {
        String result = solution.longestPalindromeManacher(input);

        assertNotNull(result, "Result should not be null");
        assertTrue(expectedOutputs.contains(result),
                String.format("Expected one of %s, but got '%s'", expectedOutputs, result));
        assertTrue(solution.isPalindrome(result),
                String.format("Result '%s' should be a palindrome", result));
    }

    @Test
    @DisplayName("Test Manacher's Algorithm with complex cases")
    void testManacherComplexCases() {
        // Test with repeated characters
        String result1 = solution.longestPalindromeManacher("aaaa");
        assertEquals("aaaa", result1);

        // Test with nested palindromes
        String result2 = solution.longestPalindromeManacher("abacabad");
        assertEquals("abacaba", result2);

        // Test performance case
        String longString = "a".repeat(500) + "b" + "a".repeat(500);
        String result3 = solution.longestPalindromeManacher(longString);
        assertEquals(longString, result3);
    }

    // ========================================
    // APPROACH 3: DYNAMIC PROGRAMMING TESTS
    // ========================================

    @ParameterizedTest
    @MethodSource("palindromeTestCases")
    @DisplayName("Test Dynamic Programming approach")
    void testLongestPalindromeDynamicProgramming(String input, List<String> expectedOutputs) {
        String result = solution.longestPalindromeDP(input);

        assertNotNull(result, "Result should not be null");
        assertTrue(expectedOutputs.contains(result),
                String.format("Expected one of %s, but got '%s'", expectedOutputs, result));
        assertTrue(solution.isPalindrome(result),
                String.format("Result '%s' should be a palindrome", result));
    }

    @Test
    @DisplayName("Test Dynamic Programming with matrix building")
    void testDynamicProgrammingSpecificCases() {
        // Test that DP correctly identifies all palindromes
        assertEquals("abcba", solution.longestPalindromeDP("abcba"));
        assertEquals("aa", solution.longestPalindromeDP("baa"));
        assertEquals("aba", solution.longestPalindromeDP("aba"));
    }

    // ========================================
    // APPROACH 4: BRUTE FORCE TESTS
    // ========================================

    @ParameterizedTest
    @MethodSource("edgeCaseTestCases")
    @DisplayName("Test Brute Force approach with edge cases")
    void testLongestPalindromeBruteForce(String input, String expectedOutput) {
        String result = solution.longestPalindromeBruteForce(input);

        if (input == null || expectedOutput.isEmpty()) {
            assertTrue(result.isEmpty(),
                    "Result should be empty for null or empty expected output");
        } else {
            assertTrue(solution.isPalindrome(result), "Result should be a palindrome");
            assertEquals(expectedOutput.length(), result.length(),
                    "Result should have expected length");
        }
    }

    @Test
    @DisplayName("Test Brute Force with small inputs only")
    void testBruteForceSmallInputs() {
        // Only test brute force with small inputs due to O(n³) complexity
        assertEquals("aba", solution.longestPalindromeBruteForce("aba"));
        assertEquals("aa", solution.longestPalindromeBruteForce("aa"));
        assertEquals("racecar", solution.longestPalindromeBruteForce("racecar"));
    }

    // ========================================
    // CROSS-VALIDATION TESTS
    // ========================================

    @Test
    @DisplayName("Test all approaches return same results")
    void testAllApproachesConsistency() {
        String[] testCases = {"babad", "cbbd", "racecar", "abcdef", "noon", "level", "abacabad",
                "bananas", "aaaa"};

        for (String testCase : testCases) {
            String result1 = solution.longestPalindrome(testCase);
            String result2 = solution.longestPalindromeManacher(testCase);
            String result3 = solution.longestPalindromeDP(testCase);

            // All approaches should return palindromes of the same length
            assertEquals(result1.length(), result2.length(),
                    String.format("Expand Centers and Manacher differ for '%s': %s vs %s", testCase,
                            result1, result2));
            assertEquals(result1.length(), result3.length(), String.format(
                    "Expand Centers and DP differ for '%s': %s vs %s", testCase, result1, result3));

            // All results should be valid palindromes
            assertTrue(solution.isPalindrome(result1));
            assertTrue(solution.isPalindrome(result2));
            assertTrue(solution.isPalindrome(result3));
        }
    }

    // ========================================
    // UTILITY METHOD TESTS
    // ========================================

    @Test
    @DisplayName("Test isPalindrome utility method")
    void testIsPalindromeUtility() {
        // Test valid palindromes
        assertTrue(solution.isPalindrome("a"));
        assertTrue(solution.isPalindrome("aa"));
        assertTrue(solution.isPalindrome("aba"));
        assertTrue(solution.isPalindrome("abba"));
        assertTrue(solution.isPalindrome("racecar"));
        assertTrue(solution.isPalindrome(""));

        // Test non-palindromes
        assertFalse(solution.isPalindrome("ab"));
        assertFalse(solution.isPalindrome("abc"));
        assertFalse(solution.isPalindrome("abcd"));

        // Test null
        assertFalse(solution.isPalindrome(null));
    }

    // ========================================
    // PERFORMANCE TESTS
    // ========================================

    @Test
    @DisplayName("Test performance with larger inputs")
    void testPerformance() {
        // Create a large string with palindrome in the middle
        String largePalindrome = "a".repeat(100) + "racecar" + "b".repeat(100);

        // Test that all approaches handle reasonably large inputs
        long start = System.currentTimeMillis();
        String result1 = solution.longestPalindrome(largePalindrome);
        long time1 = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        String result2 = solution.longestPalindromeManacher(largePalindrome);
        long time2 = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        String result3 = solution.longestPalindromeDP(largePalindrome);
        long time3 = System.currentTimeMillis() - start;

        // All should find the same length palindrome
        assertEquals(result1.length(), result2.length());
        assertEquals(result1.length(), result3.length());

        // Manacher should be fastest for large inputs (though timing can vary)
        System.out.printf("Performance test (input length %d):%n", largePalindrome.length());
        System.out.printf("Expand Centers: %d ms%n", time1);
        System.out.printf("Manacher: %d ms%n", time2);
        System.out.printf("Dynamic Programming: %d ms%n", time3);
    }

    // ========================================
    // LEETCODE CONSTRAINT TESTS
    // ========================================

    @Test
    @DisplayName("Test LeetCode constraint compliance")
    void testLeetCodeConstraints() {
        // Test minimum constraint: 1 <= s.length <= 1000
        String singleChar = "a";
        String result = solution.longestPalindrome(singleChar);
        assertEquals("a", result);

        // Test with digits and letters (constraint: s consist of only digits and English letters)
        String mixedString = "abc123321def";
        String mixedResult = solution.longestPalindrome(mixedString);
        assertEquals("123321", mixedResult);

        // Test case sensitivity
        String caseString = "AaBbA";
        String caseResult = solution.longestPalindrome(caseString);
        assertTrue(solution.isPalindrome(caseResult));
    }
}
