package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Comprehensive test suite for Longest Common Prefix Tests all five approaches: Horizontal
 * Scanning, Vertical Scanning, Divide and Conquer, Binary Search, and Trie
 */
public class LongestCommonPrefixTest {

    private LongestCommonPrefix solution;

    @BeforeEach
    void setUp() {
        solution = new LongestCommonPrefix();
    }

    // ========================================
    // TEST DATA PROVIDERS
    // ========================================

    /**
     * Provides test cases with input array and expected common prefix
     */
    static Stream<Arguments> commonPrefixTestCases() {
        return Stream.of(
                // LeetCode examples
                Arguments.of(new String[] {"flower", "flow", "flight"}, "fl"),
                Arguments.of(new String[] {"dog", "racecar", "car"}, ""),

                // Single string cases
                Arguments.of(new String[] {"hello"}, "hello"), Arguments.of(new String[] {""}, ""),

                // Empty and null cases
                Arguments.of(new String[] {}, ""), Arguments.of(null, ""),

                // Common prefix cases
                Arguments.of(new String[] {"interspecies", "interstellar", "interstate"}, "inters"),
                Arguments.of(new String[] {"throne", "throne"}, "throne"),
                Arguments.of(new String[] {"throne", "dungeon"}, ""),

                // Edge cases
                Arguments.of(new String[] {"a", "b"}, ""),
                Arguments.of(new String[] {"a", "a"}, "a"),
                Arguments.of(new String[] {"aa", "a"}, "a"),
                Arguments.of(new String[] {"a", "aa"}, "a"),

                // Mixed length cases
                Arguments.of(new String[] {"hello", "hell", "he"}, "he"),
                Arguments.of(new String[] {"hello", "world", "hi"}, ""),
                Arguments.of(new String[] {"programming", "program", "pro"}, "pro"),

                // Special characters and numbers
                Arguments.of(new String[] {"123", "1234", "12345"}, "123"),
                Arguments.of(new String[] {"abc123", "abc456", "abc789"}, "abc"),
                Arguments.of(new String[] {"!@#", "!@#$", "!@#$%"}, "!@#"),

                // Long strings
                Arguments.of(new String[] {"abcdefghijklmnopqrstuvwxyz",
                        "abcdefghijklmnopqrstuvwxy", "abcdefghijklmnopqrstuvwx"},
                        "abcdefghijklmnopqrstuvwx"),

                // All empty strings
                Arguments.of(new String[] {"", "", ""}, ""),
                Arguments.of(new String[] {"", "a", ""}, ""),

                // Null strings in array
                Arguments.of(new String[] {null, "hello", "world"}, ""),
                Arguments.of(new String[] {"hello", null, "world"}, ""),
                Arguments.of(new String[] {"hello", "world", null}, ""));
    }

    /**
     * Provides edge case test inputs
     */
    static Stream<Arguments> edgeCaseInputs() {
        return Stream.of(Arguments.of(new String[] {}, "Empty array"),
                Arguments.of(null, "Null array"),
                Arguments.of(new String[] {""}, "Single empty string"),
                Arguments.of(new String[] {"", ""}, "Two empty strings"),
                Arguments.of(new String[] {null}, "Single null string"),
                Arguments.of(new String[] {null, null}, "Two null strings"));
    }

    /**
     * Provides performance test arrays of different sizes
     */
    static Stream<Arguments> performanceTestCases() {
        return Stream.of(
                Arguments.of(generateStringArray(5, 10), "Small array (5 strings, max 10 chars)"),
                Arguments.of(generateStringArray(20, 50),
                        "Medium array (20 strings, max 50 chars)"),
                Arguments.of(generateStringArray(100, 100),
                        "Large array (100 strings, max 100 chars)"),
                Arguments.of(generateStringArray(200, 200),
                        "Extra large array (200 strings, max 200 chars)"));
    }

    private static String[] generateStringArray(int size, int maxLength) {
        String[] arr = new String[size];
        for (int i = 0; i < size; i++) {
            int length = (int) (Math.random() * maxLength) + 1;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < length; j++) {
                sb.append((char) ('a' + (int) (Math.random() * 26)));
            }
            arr[i] = sb.toString();
        }
        return arr;
    }

    // ========================================
    // APPROACH 1: HORIZONTAL SCANNING TESTS
    // ========================================

    @ParameterizedTest
    @MethodSource("commonPrefixTestCases")
    @DisplayName("Test Horizontal Scanning approach")
    void testLongestCommonPrefix(String[] input, String expected) {
        String result = solution.longestCommonPrefix(input);
        assertEquals(expected, result, String.format("Expected '%s', got '%s' for input %s",
                expected, result, java.util.Arrays.toString(input)));
    }

    @Test
    @DisplayName("Test Horizontal Scanning with specific examples")
    void testHorizontalScanningSpecificCases() {
        // Test case 1: Classic LeetCode example
        String[] strs1 = {"flower", "flow", "flight"};
        String result1 = solution.longestCommonPrefix(strs1);
        assertEquals("fl", result1);

        // Test case 2: No common prefix
        String[] strs2 = {"dog", "racecar", "car"};
        String result2 = solution.longestCommonPrefix(strs2);
        assertEquals("", result2);

        // Test case 3: All same strings
        String[] strs3 = {"hello", "hello", "hello"};
        String result3 = solution.longestCommonPrefix(strs3);
        assertEquals("hello", result3);
    }

    // ========================================
    // APPROACH 2: VERTICAL SCANNING TESTS
    // ========================================

    @ParameterizedTest
    @MethodSource("commonPrefixTestCases")
    @DisplayName("Test Vertical Scanning approach")
    void testLongestCommonPrefixVertical(String[] input, String expected) {
        String result = solution.longestCommonPrefixVertical(input);
        assertEquals(expected, result, String.format("Expected '%s', got '%s' for input %s",
                expected, result, java.util.Arrays.toString(input)));
    }

    @Test
    @DisplayName("Test Vertical Scanning with complex case")
    void testVerticalScanningComplexCase() {
        String[] strs = {"interspecies", "interstellar", "interstate"};
        String result = solution.longestCommonPrefixVertical(strs);
        assertEquals("inters", result);
    }

    // ========================================
    // APPROACH 3: DIVIDE AND CONQUER TESTS
    // ========================================

    @ParameterizedTest
    @MethodSource("commonPrefixTestCases")
    @DisplayName("Test Divide and Conquer approach")
    void testLongestCommonPrefixDivideAndConquer(String[] input, String expected) {
        String result = solution.longestCommonPrefixDivideAndConquer(input);
        assertEquals(expected, result, String.format("Expected '%s', got '%s' for input %s",
                expected, result, java.util.Arrays.toString(input)));
    }

    @Test
    @DisplayName("Test Divide and Conquer with power of 2 array size")
    void testDivideAndConquerPowerOfTwo() {
        String[] strs = {"a", "b", "c", "d"};
        String result = solution.longestCommonPrefixDivideAndConquer(strs);
        assertEquals("", result);
    }

    // ========================================
    // APPROACH 4: BINARY SEARCH TESTS
    // ========================================

    @ParameterizedTest
    @MethodSource("commonPrefixTestCases")
    @DisplayName("Test Binary Search approach")
    void testLongestCommonPrefixBinarySearch(String[] input, String expected) {
        String result = solution.longestCommonPrefixBinarySearch(input);
        assertEquals(expected, result, String.format("Expected '%s', got '%s' for input %s",
                expected, result, java.util.Arrays.toString(input)));
    }

    @Test
    @DisplayName("Test Binary Search with long common prefix")
    void testBinarySearchLongPrefix() {
        String[] strs = {"abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxy",
                "abcdefghijklmnopqrstuvwx"};
        String result = solution.longestCommonPrefixBinarySearch(strs);
        assertEquals("abcdefghijklmnopqrstuvwx", result);
    }

    // ========================================
    // APPROACH 5: TRIE TESTS
    // ========================================

    @ParameterizedTest
    @MethodSource("commonPrefixTestCases")
    @DisplayName("Test Trie approach")
    void testLongestCommonPrefixTrie(String[] input, String expected) {
        String result = solution.longestCommonPrefixTrie(input);
        assertEquals(expected, result, String.format("Expected '%s', got '%s' for input %s",
                expected, result, java.util.Arrays.toString(input)));
    }

    @Test
    @DisplayName("Test Trie with branching case")
    void testTrieBranchingCase() {
        String[] strs = {"cat", "car", "can"};
        String result = solution.longestCommonPrefixTrie(strs);
        assertEquals("ca", result);
    }

    // ========================================
    // CROSS-VALIDATION TESTS
    // ========================================

    @Test
    @DisplayName("Test all approaches return same results")
    void testAllApproachesConsistency() {
        String[][] testCases = {{"flower", "flow", "flight"}, {"dog", "racecar", "car"},
                {"interspecies", "interstellar", "interstate"}, {"hello", "world", "hi"},
                {"a", "b", "c"}, {"", "a", "b"}, {null, "hello", "world"}};

        for (String[] testCase : testCases) {
            String result1 = solution.longestCommonPrefix(testCase);
            String result2 = solution.longestCommonPrefixVertical(testCase);
            String result3 = solution.longestCommonPrefixDivideAndConquer(testCase);
            String result4 = solution.longestCommonPrefixBinarySearch(testCase);
            String result5 = solution.longestCommonPrefixTrie(testCase);

            assertTrue(solution.compareResults(result1, result2), String.format(
                    "Horizontal and Vertical differ for %s", java.util.Arrays.toString(testCase)));
            assertTrue(solution.compareResults(result1, result3),
                    String.format("Horizontal and Divide&Conquer differ for %s",
                            java.util.Arrays.toString(testCase)));
            assertTrue(solution.compareResults(result1, result4),
                    String.format("Horizontal and BinarySearch differ for %s",
                            java.util.Arrays.toString(testCase)));
            assertTrue(solution.compareResults(result1, result5), String.format(
                    "Horizontal and Trie differ for %s", java.util.Arrays.toString(testCase)));
        }
    }

    // ========================================
    // EDGE CASE TESTS
    // ========================================

    @ParameterizedTest
    @MethodSource("edgeCaseInputs")
    @DisplayName("Test edge cases")
    void testEdgeCases(String[] input, String description) {
        String result1 = solution.longestCommonPrefix(input);
        String result2 = solution.longestCommonPrefixVertical(input);
        String result3 = solution.longestCommonPrefixDivideAndConquer(input);
        String result4 = solution.longestCommonPrefixBinarySearch(input);
        String result5 = solution.longestCommonPrefixTrie(input);

        // All should return empty string for invalid inputs
        assertEquals("", result1, description + ": Horizontal approach should return empty");
        assertEquals("", result2, description + ": Vertical approach should return empty");
        assertEquals("", result3, description + ": Divide&Conquer should return empty");
        assertEquals("", result4, description + ": BinarySearch should return empty");
        assertEquals("", result5, description + ": Trie should return empty");
    }

    @Test
    @DisplayName("Test minimum array size requirement")
    void testMinimumArraySize() {
        // Empty array should return empty string
        assertDoesNotThrow(() -> {
            assertEquals("", solution.longestCommonPrefix(new String[] {}));
            assertEquals("", solution.longestCommonPrefixVertical(new String[] {}));
            assertEquals("", solution.longestCommonPrefixDivideAndConquer(new String[] {}));
            assertEquals("", solution.longestCommonPrefixBinarySearch(new String[] {}));
            assertEquals("", solution.longestCommonPrefixTrie(new String[] {}));
        });
    }

    // ========================================
    // UTILITY METHOD TESTS
    // ========================================

    @Test
    @DisplayName("Test utility methods")
    void testUtilityMethods() {
        // Test compareResults
        assertTrue(solution.compareResults("hello", "hello"));
        assertTrue(solution.compareResults("", ""));
        assertTrue(solution.compareResults(null, null));
        assertFalse(solution.compareResults("hello", "world"));
        assertFalse(solution.compareResults("hello", null));
        assertFalse(solution.compareResults(null, "hello"));

        // Test getStringArrayStatistics
        String[] testStrs = {"hello", "world", "", null, "hi"};
        String stats = solution.getStringArrayStatistics(testStrs);
        assertTrue(stats.contains("Array size: 5"));
        assertTrue(stats.contains("Total characters: 12")); // 5+5+0+0+2 = 12
        assertTrue(stats.contains("Min length: 2")); // Minimum among non-null strings
        assertTrue(stats.contains("Max length: 5"));
        assertTrue(stats.contains("Null strings: 1"));
        assertTrue(stats.contains("Empty strings: 1"));
    }

    // ========================================
    // PERFORMANCE TESTS
    // ========================================

    @ParameterizedTest
    @MethodSource("performanceTestCases")
    @DisplayName("Test performance comparison")
    void testPerformanceComparison(String[] input, String description) {
        long[] times = new long[5];

        // Measure each approach
        times[0] = solution.measureExecutionTime(() -> solution.longestCommonPrefix(input));
        times[1] = solution.measureExecutionTime(() -> solution.longestCommonPrefixVertical(input));
        times[2] = solution
                .measureExecutionTime(() -> solution.longestCommonPrefixDivideAndConquer(input));
        times[3] = solution
                .measureExecutionTime(() -> solution.longestCommonPrefixBinarySearch(input));
        times[4] = solution.measureExecutionTime(() -> solution.longestCommonPrefixTrie(input));

        // Verify all produce same results
        String result1 = solution.longestCommonPrefix(input);
        String result2 = solution.longestCommonPrefixVertical(input);
        String result3 = solution.longestCommonPrefixDivideAndConquer(input);
        String result4 = solution.longestCommonPrefixBinarySearch(input);
        String result5 = solution.longestCommonPrefixTrie(input);

        assertTrue(solution.compareResults(result1, result2),
                description + ": Horizontal and Vertical should match");
        assertTrue(solution.compareResults(result1, result3),
                description + ": Horizontal and Divide&Conquer should match");
        assertTrue(solution.compareResults(result1, result4),
                description + ": Horizontal and BinarySearch should match");
        assertTrue(solution.compareResults(result1, result5),
                description + ": Horizontal and Trie should match");

        // All should complete within reasonable time (100ms)
        assertTrue(times[0] < 100_000_000, description + ": Horizontal approach should be fast");
        assertTrue(times[1] < 100_000_000, description + ": Vertical approach should be fast");
        assertTrue(times[2] < 100_000_000, description + ": Divide&Conquer should be fast");
        assertTrue(times[3] < 100_000_000, description + ": BinarySearch should be fast");
        assertTrue(times[4] < 100_000_000, description + ": Trie should be fast");
    }

    @Test
    @DisplayName("Test constraint boundaries")
    void testConstraintBoundaries() {
        // Test maximum constraint values
        String[] maxSizeArray = new String[200];
        for (int i = 0; i < 200; i++) {
            maxSizeArray[i] = "a".repeat(200);
        }

        assertDoesNotThrow(() -> {
            String result = solution.longestCommonPrefix(maxSizeArray);
            assertNotNull(result);
            assertEquals("a".repeat(200), result);
        });
    }

    @Test
    @DisplayName("Test with maximum string length")
    void testMaximumStringLength() {
        // Test with strings at maximum length constraint
        String[] longStrings = {"a".repeat(200), "a".repeat(200), "a".repeat(200)};

        assertDoesNotThrow(() -> {
            String result = solution.longestCommonPrefix(longStrings);
            assertNotNull(result);
            assertEquals("a".repeat(200), result);
        });
    }
}
