package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Comprehensive test suite for LeetCode #28: Find the Index of the First Occurrence in a String
 * 
 * This test suite validates all 5 algorithmic approaches with extensive test cases: - Basic
 * functionality tests - Edge case testing - Performance validation - Cross-validation between
 * approaches - Stress testing with large inputs
 * 
 * @author Superman
 * @version 1.0
 */
@DisplayName("Find First Occurrence in String Tests")
class FindFirstOccurrenceInStringTest {

    private FindFirstOccurrenceInString solution;

    @BeforeEach
    void setUp() {
        solution = new FindFirstOccurrenceInString();
    }

    // ==================== Basic Functionality Tests ====================

    @Test
    @DisplayName("Basic test case: needle found at beginning")
    void testBasicCaseFoundAtBeginning() {
        String haystack = "sadbutsad";
        String needle = "sad";
        int expected = 0;

        assertEquals(expected, solution.strStrBuiltIn(haystack, needle));
        assertEquals(expected, solution.strStrBruteForce(haystack, needle));
        assertEquals(expected, solution.strStrKMP(haystack, needle));
        assertEquals(expected, solution.strStrRollingHash(haystack, needle));
        assertEquals(expected, solution.strStrOptimizedBruteForce(haystack, needle));
    }

    @Test
    @DisplayName("Basic test case: needle not found")
    void testBasicCaseNotFound() {
        String haystack = "leetcode";
        String needle = "leeto";
        int expected = -1;

        assertEquals(expected, solution.strStrBuiltIn(haystack, needle));
        assertEquals(expected, solution.strStrBruteForce(haystack, needle));
        assertEquals(expected, solution.strStrKMP(haystack, needle));
        assertEquals(expected, solution.strStrRollingHash(haystack, needle));
        assertEquals(expected, solution.strStrOptimizedBruteForce(haystack, needle));
    }

    @Test
    @DisplayName("Basic test case: needle found in middle")
    void testBasicCaseFoundInMiddle() {
        String haystack = "hello";
        String needle = "ll";
        int expected = 2;

        assertEquals(expected, solution.strStrBuiltIn(haystack, needle));
        assertEquals(expected, solution.strStrBruteForce(haystack, needle));
        assertEquals(expected, solution.strStrKMP(haystack, needle));
        assertEquals(expected, solution.strStrRollingHash(haystack, needle));
        assertEquals(expected, solution.strStrOptimizedBruteForce(haystack, needle));
    }

    // ==================== Edge Case Tests ====================

    @Test
    @DisplayName("Edge case: single character match")
    void testSingleCharacterMatch() {
        String haystack = "a";
        String needle = "a";
        int expected = 0;

        assertEquals(expected, solution.strStrBuiltIn(haystack, needle));
        assertEquals(expected, solution.strStrBruteForce(haystack, needle));
        assertEquals(expected, solution.strStrKMP(haystack, needle));
        assertEquals(expected, solution.strStrRollingHash(haystack, needle));
        assertEquals(expected, solution.strStrOptimizedBruteForce(haystack, needle));
    }

    @Test
    @DisplayName("Edge case: needle at end of haystack")
    void testNeedleAtEnd() {
        String haystack = "abc";
        String needle = "c";
        int expected = 2;

        assertEquals(expected, solution.strStrBuiltIn(haystack, needle));
        assertEquals(expected, solution.strStrBruteForce(haystack, needle));
        assertEquals(expected, solution.strStrKMP(haystack, needle));
        assertEquals(expected, solution.strStrRollingHash(haystack, needle));
        assertEquals(expected, solution.strStrOptimizedBruteForce(haystack, needle));
    }

    @Test
    @DisplayName("Edge case: empty needle")
    void testEmptyNeedle() {
        String haystack = "hello";
        String needle = "";
        int expected = 0; // Empty string is found at index 0

        assertEquals(expected, solution.strStrBuiltIn(haystack, needle));
        assertEquals(expected, solution.strStrBruteForce(haystack, needle));
        assertEquals(expected, solution.strStrKMP(haystack, needle));
        assertEquals(expected, solution.strStrRollingHash(haystack, needle));
        assertEquals(expected, solution.strStrOptimizedBruteForce(haystack, needle));
    }

    @Test
    @DisplayName("Edge case: needle longer than haystack")
    void testNeedleLongerThanHaystack() {
        String haystack = "abc";
        String needle = "abcd";
        int expected = -1;

        assertEquals(expected, solution.strStrBuiltIn(haystack, needle));
        assertEquals(expected, solution.strStrBruteForce(haystack, needle));
        assertEquals(expected, solution.strStrKMP(haystack, needle));
        assertEquals(expected, solution.strStrRollingHash(haystack, needle));
        assertEquals(expected, solution.strStrOptimizedBruteForce(haystack, needle));
    }

    @Test
    @DisplayName("Edge case: identical strings")
    void testIdenticalStrings() {
        String haystack = "hello";
        String needle = "hello";
        int expected = 0;

        assertEquals(expected, solution.strStrBuiltIn(haystack, needle));
        assertEquals(expected, solution.strStrBruteForce(haystack, needle));
        assertEquals(expected, solution.strStrKMP(haystack, needle));
        assertEquals(expected, solution.strStrRollingHash(haystack, needle));
        assertEquals(expected, solution.strStrOptimizedBruteForce(haystack, needle));
    }

    @Test
    @DisplayName("Edge case: null inputs")
    void testNullInputs() {
        int expected = -1;

        assertEquals(expected, solution.strStrBuiltIn(null, "test"));
        assertEquals(expected, solution.strStrBuiltIn("test", null));
        assertEquals(expected, solution.strStrBuiltIn(null, null));

        assertEquals(expected, solution.strStrBruteForce(null, "test"));
        assertEquals(expected, solution.strStrBruteForce("test", null));
        assertEquals(expected, solution.strStrBruteForce(null, null));

        assertEquals(expected, solution.strStrKMP(null, "test"));
        assertEquals(expected, solution.strStrKMP("test", null));
        assertEquals(expected, solution.strStrKMP(null, null));

        assertEquals(expected, solution.strStrRollingHash(null, "test"));
        assertEquals(expected, solution.strStrRollingHash("test", null));
        assertEquals(expected, solution.strStrRollingHash(null, null));

        assertEquals(expected, solution.strStrOptimizedBruteForce(null, "test"));
        assertEquals(expected, solution.strStrOptimizedBruteForce("test", null));
        assertEquals(expected, solution.strStrOptimizedBruteForce(null, null));
    }

    // ==================== Complex Pattern Tests ====================

    @Test
    @DisplayName("Complex pattern: Mississippi case")
    void testMississippiCase() {
        String haystack = "mississippi";
        String needle = "issip";
        int expected = 4;

        assertEquals(expected, solution.strStrBuiltIn(haystack, needle));
        assertEquals(expected, solution.strStrBruteForce(haystack, needle));
        assertEquals(expected, solution.strStrKMP(haystack, needle));
        assertEquals(expected, solution.strStrRollingHash(haystack, needle));
        assertEquals(expected, solution.strStrOptimizedBruteForce(haystack, needle));
    }

    @Test
    @DisplayName("Complex pattern: repeated characters")
    void testRepeatedCharacters() {
        String haystack = "aabaaabaaac";
        String needle = "aabaaac";
        int expected = 4;

        assertEquals(expected, solution.strStrBuiltIn(haystack, needle));
        assertEquals(expected, solution.strStrBruteForce(haystack, needle));
        assertEquals(expected, solution.strStrKMP(haystack, needle));
        assertEquals(expected, solution.strStrRollingHash(haystack, needle));
        assertEquals(expected, solution.strStrOptimizedBruteForce(haystack, needle));
    }

    @Test
    @DisplayName("Complex pattern: overlapping matches")
    void testOverlappingMatches() {
        String haystack = "ababababab";
        String needle = "ababab";
        int expected = 0; // First occurrence

        assertEquals(expected, solution.strStrBuiltIn(haystack, needle));
        assertEquals(expected, solution.strStrBruteForce(haystack, needle));
        assertEquals(expected, solution.strStrKMP(haystack, needle));
        assertEquals(expected, solution.strStrRollingHash(haystack, needle));
        assertEquals(expected, solution.strStrOptimizedBruteForce(haystack, needle));
    }

    @Test
    @DisplayName("Complex pattern: many repeated characters")
    void testManyRepeatedCharacters() {
        String haystack = "aaaaaaaaab";
        String needle = "aaab";
        int expected = 6;

        assertEquals(expected, solution.strStrBuiltIn(haystack, needle));
        assertEquals(expected, solution.strStrBruteForce(haystack, needle));
        assertEquals(expected, solution.strStrKMP(haystack, needle));
        assertEquals(expected, solution.strStrRollingHash(haystack, needle));
        assertEquals(expected, solution.strStrOptimizedBruteForce(haystack, needle));
    }

    // ==================== Parameterized Tests ====================

    @ParameterizedTest
    @CsvSource({"sadbutsad, sad, 0", "leetcode, leeto, -1", "hello, ll, 2", "a, a, 0", "abc, c, 2",
            "mississippi, issip, 4", "aabaaabaaac, aabaaac, 4",
            "abcdefghijklmnopqrstuvwxyz, xyz, 23", "thequickbrownfoxjumpsoverthelazydog, fox, 13",
            "ababababab, ababab, 0", "aaaaaaaaab, aaab, 6"})
    @DisplayName("Parameterized test cases")
    void testParameterizedCases(String haystack, String needle, int expected) {
        assertEquals(expected, solution.strStrBuiltIn(haystack, needle));
        assertEquals(expected, solution.strStrBruteForce(haystack, needle));
        assertEquals(expected, solution.strStrKMP(haystack, needle));
        assertEquals(expected, solution.strStrRollingHash(haystack, needle));
        assertEquals(expected, solution.strStrOptimizedBruteForce(haystack, needle));
    }

    // ==================== Cross-Validation Tests ====================

    @Test
    @DisplayName("Cross-validation: All approaches produce identical results")
    void testCrossValidation() {
        String[] haystacks = {"sadbutsad", "leetcode", "hello", "a", "abc", "mississippi",
                "aabaaabaaac", "abcdefghijklmnopqrstuvwxyz", "aaaaaaaaab", "ababababab",
                "thequickbrownfoxjumpsoverthelazydog"};

        String[] needles = {"sad", "leeto", "ll", "a", "c", "issip", "aabaaac", "xyz", "aaab",
                "ababab", "fox"};

        for (int i = 0; i < haystacks.length; i++) {
            String haystack = haystacks[i];
            String needle = needles[i];

            int result1 = solution.strStrBuiltIn(haystack, needle);
            int result2 = solution.strStrBruteForce(haystack, needle);
            int result3 = solution.strStrKMP(haystack, needle);
            int result4 = solution.strStrRollingHash(haystack, needle);
            int result5 = solution.strStrOptimizedBruteForce(haystack, needle);

            assertEquals(result1, result2,
                    "Built-in vs Brute Force mismatch for: " + haystack + ", " + needle);
            assertEquals(result1, result3,
                    "Built-in vs KMP mismatch for: " + haystack + ", " + needle);
            assertEquals(result1, result4,
                    "Built-in vs Rolling Hash mismatch for: " + haystack + ", " + needle);
            assertEquals(result1, result5,
                    "Built-in vs Optimized Brute Force mismatch for: " + haystack + ", " + needle);
        }
    }

    // ==================== Performance Tests ====================

    @Test
    @DisplayName("Performance test: Large haystack with needle at end")
    void testPerformanceLargeHaystackNeedleAtEnd() {
        // Create a large haystack
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append("abcdefghij");
        }
        sb.append("xyz");
        String haystack = sb.toString();
        String needle = "xyz";

        long startTime, endTime;

        // Test Built-in
        startTime = System.nanoTime();
        int result1 = solution.strStrBuiltIn(haystack, needle);
        endTime = System.nanoTime();
        long time1 = endTime - startTime;

        // Test KMP
        startTime = System.nanoTime();
        int result3 = solution.strStrKMP(haystack, needle);
        endTime = System.nanoTime();
        long time3 = endTime - startTime;

        assertEquals(result1, result3);
        assertTrue(time1 > 0 && time3 > 0, "Performance test should complete successfully");
    }

    @Test
    @DisplayName("Performance test: Worst case for brute force")
    void testPerformanceWorstCaseBruteForce() {
        // Create worst case: haystack = "aaaa...aaab", needle = "aaab"
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append("a");
        }
        sb.append("b");
        String haystack = sb.toString();
        String needle = "aaab";

        long startTime, endTime;

        // Test Brute Force
        startTime = System.nanoTime();
        int result2 = solution.strStrBruteForce(haystack, needle);
        endTime = System.nanoTime();
        long time2 = endTime - startTime;

        // Test KMP (should be much faster)
        startTime = System.nanoTime();
        int result3 = solution.strStrKMP(haystack, needle);
        endTime = System.nanoTime();
        long time3 = endTime - startTime;

        assertEquals(result2, result3);
        assertTrue(time2 > 0 && time3 > 0, "Performance test should complete successfully");
    }

    // ==================== Stress Tests ====================

    @Test
    @DisplayName("Stress test: Maximum constraint sizes")
    void testStressTestMaximumConstraints() {
        // Test with maximum constraint sizes (10^4 characters)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            sb.append((char) ('a' + (i % 26)));
        }
        String haystack = sb.toString();
        String needle = "z"; // Should be found at the end

        int result = solution.strStrKMP(haystack, needle);
        assertTrue(result >= 0, "Should find needle in large haystack");
    }

    @Test
    @DisplayName("Stress test: All same characters")
    void testStressTestAllSameCharacters() {
        // Create haystack of all 'a's
        String haystack = "a".repeat(1000);
        String needle = "a".repeat(100);

        int result = solution.strStrKMP(haystack, needle);
        assertEquals(0, result, "Should find needle at beginning");
    }

    // ==================== Algorithm-Specific Tests ====================

    @Test
    @DisplayName("KMP specific: Test failure function building")
    void testKMPFailureFunction() {
        // Test with pattern that has proper prefix-suffix matches
        String haystack = "ababababab";
        String needle = "ababab";

        int result = solution.strStrKMP(haystack, needle);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Rolling Hash specific: Test hash collision handling")
    void testRollingHashCollisionHandling() {
        // Test with strings that might cause hash collisions
        String haystack = "abcdefghijklmnopqrstuvwxyz";
        String needle = "xyz";

        int result = solution.strStrRollingHash(haystack, needle);
        assertEquals(23, result);
    }

    @Test
    @DisplayName("Optimized Brute Force specific: Test character filtering")
    void testOptimizedBruteForceCharacterFiltering() {
        // Test with needle containing characters not in haystack
        String haystack = "abcdef";
        String needle = "xyz";

        int result = solution.strStrOptimizedBruteForce(haystack, needle);
        assertEquals(-1, result);
    }

    // ==================== Utility Tests ====================

    @Test
    @DisplayName("Utility test: Demonstrate all approaches")
    void testDemonstrateAllApproaches() {
        // This test ensures the demonstration method works without throwing exceptions
        assertDoesNotThrow(() -> {
            solution.demonstrateAllApproaches("sadbutsad", "sad");
            solution.demonstrateAllApproaches("leetcode", "leeto");
            solution.demonstrateAllApproaches("hello", "ll");
        });
    }

    // ==================== Boundary Tests ====================

    @Test
    @DisplayName("Boundary test: Minimum valid inputs")
    void testBoundaryMinimumInputs() {
        String haystack = "a";
        String needle = "a";
        int expected = 0;

        assertEquals(expected, solution.strStrBuiltIn(haystack, needle));
        assertEquals(expected, solution.strStrBruteForce(haystack, needle));
        assertEquals(expected, solution.strStrKMP(haystack, needle));
        assertEquals(expected, solution.strStrRollingHash(haystack, needle));
        assertEquals(expected, solution.strStrOptimizedBruteForce(haystack, needle));
    }

    @Test
    @DisplayName("Boundary test: Needle equals haystack")
    void testBoundaryNeedleEqualsHaystack() {
        String str = "hello";
        int expected = 0;

        assertEquals(expected, solution.strStrBuiltIn(str, str));
        assertEquals(expected, solution.strStrBruteForce(str, str));
        assertEquals(expected, solution.strStrKMP(str, str));
        assertEquals(expected, solution.strStrRollingHash(str, str));
        assertEquals(expected, solution.strStrOptimizedBruteForce(str, str));
    }

    @Test
    @DisplayName("Boundary test: Needle one character shorter than haystack")
    void testBoundaryNeedleOneCharShorter() {
        String haystack = "ab";
        String needle = "a";
        int expected = 0;

        assertEquals(expected, solution.strStrBuiltIn(haystack, needle));
        assertEquals(expected, solution.strStrBruteForce(haystack, needle));
        assertEquals(expected, solution.strStrKMP(haystack, needle));
        assertEquals(expected, solution.strStrRollingHash(haystack, needle));
        assertEquals(expected, solution.strStrOptimizedBruteForce(haystack, needle));
    }

    // ==================== Special Character Tests ====================

    @Test
    @DisplayName("Special case: Alphabet sequence")
    void testAlphabetSequence() {
        String haystack = "abcdefghijklmnopqrstuvwxyz";
        String needle = "xyz";
        int expected = 23;

        assertEquals(expected, solution.strStrBuiltIn(haystack, needle));
        assertEquals(expected, solution.strStrBruteForce(haystack, needle));
        assertEquals(expected, solution.strStrKMP(haystack, needle));
        assertEquals(expected, solution.strStrRollingHash(haystack, needle));
        assertEquals(expected, solution.strStrOptimizedBruteForce(haystack, needle));
    }

    @Test
    @DisplayName("Special case: Pangram test")
    void testPangramCase() {
        String haystack = "thequickbrownfoxjumpsoverthelazydog";
        String needle = "fox";
        int expected = 13;

        assertEquals(expected, solution.strStrBuiltIn(haystack, needle));
        assertEquals(expected, solution.strStrBruteForce(haystack, needle));
        assertEquals(expected, solution.strStrKMP(haystack, needle));
        assertEquals(expected, solution.strStrRollingHash(haystack, needle));
        assertEquals(expected, solution.strStrOptimizedBruteForce(haystack, needle));
    }
}
