package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Comprehensive test suite for ZigZagConversion Tests all four approaches: Simulation, Mathematical
 * Pattern, String Array, and Optimized Simulation
 */
public class ZigZagConversionTest {

    private ZigZagConversion solution;

    @BeforeEach
    void setUp() {
        solution = new ZigZagConversion();
    }

    // ========================================
    // TEST DATA PROVIDERS
    // ========================================

    /**
     * Provides test cases with input string, numRows, and expected output
     */
    static Stream<Arguments> zigzagTestCases() {
        return Stream.of(
                // LeetCode examples
                Arguments.of("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"),
                Arguments.of("PAYPALISHIRING", 4, "PINALSIGYAHRPI"), Arguments.of("A", 1, "A"),

                // Edge cases
                Arguments.of("AB", 1, "AB"), // Two characters, one row
                Arguments.of("ABCD", 2, "ACBD"), // Simple 2-row case
                Arguments.of("ABCDE", 3, "AEBDC"), // Odd length, 3 rows
                Arguments.of("ABCDEF", 3, "AEBDFC"), // Even length, 3 rows

                // Single character
                Arguments.of("X", 1, "X"), Arguments.of("X", 2, "X"), Arguments.of("X", 5, "X"),

                // Two characters with different rows
                Arguments.of("AB", 2, "AB"), Arguments.of("AB", 3, "AB"),

                // Larger examples - CORRECTED OUTPUTS
                Arguments.of("ABCDEFGHIJ", 3, "AEIBDFHJCG"),
                Arguments.of("ABCDEFGHIJ", 4, "AGBFHCEIDJ"),
                Arguments.of("ABCDEFGHIJ", 5, "AIBHJCGDFE"),

                // Special characters (as per constraints) - CORRECTED OUTPUTS
                Arguments.of("A,B.C", 2, "ABC,."), Arguments.of("Hello,World.", 3, "Horel,ol.lWd"),

                // Longer strings - CORRECTED OUTPUTS
                Arguments.of("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 4, "AGMSYBFHLNRTXZCEIKOQUWDJPV"),
                Arguments.of("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 5, "AIQYBHJPRXZCGKOSWDFLNTVEMU"),

                // Same string with different row numbers - CORRECTED OUTPUTS
                Arguments.of("PROGRAMMING", 2, "PORMIGRGAMN"),
                Arguments.of("PROGRAMMING", 3, "PRIRGAMNOMG"),
                Arguments.of("PROGRAMMING", 4, "PMRAMORIGGN"),
                Arguments.of("PROGRAMMING", 6, "PGRNOIGMRMA"),

                // Maximum length edge case (within constraints) - CORRECTED OUTPUT
                Arguments.of("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ", 10,
                        "ASKBRTJLCQUIMDPVHNZEOWGOYFNXFPXGMYEQWHLZDRVIKACSUJBT"));
    }

    /**
     * Provides edge cases for error handling and boundary conditions
     */
    static Stream<Arguments> edgeCaseTestCases() {
        return Stream.of(Arguments.of("", 1, ""), // Empty string
                Arguments.of("", 3, ""), // Empty string with multiple rows
                Arguments.of("A", 1, "A"), // Single character, single row
                Arguments.of("A", 100, "A"), // Single character, many rows
                Arguments.of("AB", 1, "AB"), // Two characters, single row
                Arguments.of("ABCDE", 1, "ABCDE"), // Multiple characters, single row
                Arguments.of("ABCDE", 10, "ABCDE") // Characters less than rows
        );
    }

    // ========================================
    // APPROACH 1: SIMULATION TESTS
    // ========================================

    @ParameterizedTest
    @MethodSource("zigzagTestCases")
    @DisplayName("Test Simulation approach")
    void testZigZagConversionSimulation(String input, int numRows, String expected) {
        String result = solution.convert(input, numRows);
        assertEquals(expected, result,
                String.format("Simulation failed for input='%s', numRows=%d", input, numRows));
    }

    @Test
    @DisplayName("Test Simulation with specific examples")
    void testSimulationSpecificCases() {
        // Test the classic PAYPALISHIRING example step by step
        assertEquals("PAHNAPLSIIGYIR", solution.convert("PAYPALISHIRING", 3));
        assertEquals("PINALSIGYAHRPI", solution.convert("PAYPALISHIRING", 4));

        // Test edge case
        assertEquals("A", solution.convert("A", 1));
        assertEquals("AB", solution.convert("AB", 1));
    }

    // ========================================
    // APPROACH 2: MATHEMATICAL PATTERN TESTS
    // ========================================

    @ParameterizedTest
    @MethodSource("zigzagTestCases")
    @DisplayName("Test Mathematical Pattern approach")
    void testZigZagConversionMathematical(String input, int numRows, String expected) {
        String result = solution.convertMathematical(input, numRows);
        assertEquals(expected, result,
                String.format("Mathematical failed for input='%s', numRows=%d", input, numRows));
    }

    @Test
    @DisplayName("Test Mathematical Pattern with complex cases")
    void testMathematicalComplexCases() {
        // Test longer strings where pattern recognition is crucial
        String longString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        assertEquals("AGMSYBFHLNRTXZCEIKOQUWDJPV", solution.convertMathematical(longString, 4));

        // Test with many rows
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", solution.convertMathematical(longString, 26));
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", solution.convertMathematical(longString, 100));
    }

    // ========================================
    // APPROACH 3: STRING ARRAY TESTS
    // ========================================

    @ParameterizedTest
    @MethodSource("zigzagTestCases")
    @DisplayName("Test String Array approach")
    void testZigZagConversionStringArray(String input, int numRows, String expected) {
        String result = solution.convertWithStringArray(input, numRows);
        assertEquals(expected, result,
                String.format("String Array failed for input='%s', numRows=%d", input, numRows));
    }

    @Test
    @DisplayName("Test String Array with edge cases")
    void testStringArrayEdgeCases() {
        // Test empty string
        assertEquals("", solution.convertWithStringArray("", 1));
        assertEquals("", solution.convertWithStringArray("", 5));

        // Test single character
        assertEquals("Z", solution.convertWithStringArray("Z", 3));
    }

    // ========================================
    // APPROACH 4: OPTIMIZED SIMULATION TESTS
    // ========================================

    @ParameterizedTest
    @MethodSource("zigzagTestCases")
    @DisplayName("Test Optimized Simulation approach")
    void testZigZagConversionOptimized(String input, int numRows, String expected) {
        String result = solution.convertOptimized(input, numRows);
        assertEquals(expected, result,
                String.format("Optimized failed for input='%s', numRows=%d", input, numRows));
    }

    @Test
    @DisplayName("Test Optimized Simulation performance")
    void testOptimizedPerformance() {
        // Test with larger input for performance
        StringBuilder largeInput = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            largeInput.append("ABCDEFGHIJ");
        }
        String input = largeInput.toString();

        long start = System.currentTimeMillis();
        String result = solution.convertOptimized(input, 7);
        long time = System.currentTimeMillis() - start;

        assertNotNull(result);
        assertEquals(input.length(), result.length());
        assertTrue(time < 100, "Should complete within reasonable time");
    }

    // ========================================
    // CROSS-VALIDATION TESTS
    // ========================================

    @Test
    @DisplayName("Test all approaches return same results")
    void testAllApproachesConsistency() {
        String[] testStrings = {"PAYPALISHIRING", "ABCDEFGHIJ", "Hello,World.", "PROGRAMMING",
                "ZigZagConversion", "A", "AB", ""};
        int[] testRows = {1, 2, 3, 4, 5, 10};

        for (String testString : testStrings) {
            for (int numRows : testRows) {
                if (testString.isEmpty() && numRows > 1)
                    continue; // Skip invalid combinations

                String result1 = solution.convert(testString, numRows);
                String result2 = solution.convertMathematical(testString, numRows);
                String result3 = solution.convertWithStringArray(testString, numRows);
                String result4 = solution.convertOptimized(testString, numRows);

                assertEquals(result1, result2,
                        String.format("Simulation and Mathematical differ for '%s', rows=%d",
                                testString, numRows));
                assertEquals(result1, result3,
                        String.format("Simulation and String Array differ for '%s', rows=%d",
                                testString, numRows));
                assertEquals(result1, result4, String.format(
                        "Simulation and Optimized differ for '%s', rows=%d", testString, numRows));
            }
        }
    }

    // ========================================
    // UTILITY METHOD TESTS
    // ========================================

    @Test
    @DisplayName("Test visualization utility")
    void testVisualization() {
        String pattern = solution.visualizeZigZag("PAYPALISHIRING", 3);
        assertNotNull(pattern);
        assertTrue(pattern.contains("P"));
        assertTrue(pattern.contains("A"));

        // Test single row visualization
        String singleRow = solution.visualizeZigZag("ABC", 1);
        assertEquals("ABC", singleRow);
    }

    @Test
    @DisplayName("Test cycle length calculation")
    void testCycleLength() {
        assertEquals(1, solution.getCycleLength(1));
        assertEquals(2, solution.getCycleLength(2));
        assertEquals(4, solution.getCycleLength(3));
        assertEquals(6, solution.getCycleLength(4));
        assertEquals(8, solution.getCycleLength(5));
        assertEquals(18, solution.getCycleLength(10));
    }

    @Test
    @DisplayName("Test row index calculation")
    void testRowForIndex() {
        // Test for numRows = 3 (cycle length = 4)
        assertEquals(0, solution.getRowForIndex(0, 3)); // P
        assertEquals(1, solution.getRowForIndex(1, 3)); // A
        assertEquals(2, solution.getRowForIndex(2, 3)); // Y
        assertEquals(1, solution.getRowForIndex(3, 3)); // P
        assertEquals(0, solution.getRowForIndex(4, 3)); // A (next cycle)

        // Test for numRows = 4 (cycle length = 6)
        assertEquals(0, solution.getRowForIndex(0, 4)); // P
        assertEquals(1, solution.getRowForIndex(1, 4)); // A
        assertEquals(2, solution.getRowForIndex(2, 4)); // Y
        assertEquals(3, solution.getRowForIndex(3, 4)); // P
        assertEquals(2, solution.getRowForIndex(4, 4)); // A
        assertEquals(1, solution.getRowForIndex(5, 4)); // L
        assertEquals(0, solution.getRowForIndex(6, 4)); // I (next cycle)

        // Test for numRows = 1
        assertEquals(0, solution.getRowForIndex(0, 1));
        assertEquals(0, solution.getRowForIndex(5, 1));
        assertEquals(0, solution.getRowForIndex(100, 1));
    }

    // ========================================
    // LEETCODE CONSTRAINT TESTS
    // ========================================

    @ParameterizedTest
    @MethodSource("edgeCaseTestCases")
    @DisplayName("Test LeetCode constraint compliance")
    void testLeetCodeConstraints(String input, int numRows, String expected) {
        String result = solution.convert(input, numRows);
        assertEquals(expected, result);

        // Verify result length matches input length
        assertEquals(input.length(), result.length());

        // Verify all characters are preserved
        char[] inputChars = input.toCharArray();
        char[] resultChars = result.toCharArray();
        java.util.Arrays.sort(inputChars);
        java.util.Arrays.sort(resultChars);
        assertArrayEquals(inputChars, resultChars);
    }

    @Test
    @DisplayName("Test constraint boundaries")
    void testConstraintBoundaries() {
        // Test minimum constraints: 1 <= s.length <= 1000, 1 <= numRows <= 1000
        String singleChar = "X";
        assertEquals("X", solution.convert(singleChar, 1));
        assertEquals("X", solution.convert(singleChar, 1000));

        // Test special characters (constraint: s consists of English letters, ',' and '.')
        String specialChars = "A,B.C,D.E";
        String result = solution.convert(specialChars, 3);
        assertEquals(specialChars.length(), result.length());
        assertTrue(result.matches("[A-Za-z,.]+"));
    }

    // ========================================
    // PERFORMANCE TESTS
    // ========================================

    @Test
    @DisplayName("Test performance with maximum constraints")
    void testMaximumConstraints() {
        // Create string with 1000 characters (maximum constraint)
        StringBuilder maxInput = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            maxInput.append((char) ('A' + (i % 26)));
        }
        String input = maxInput.toString();

        // Test with maximum rows (1000)
        long start = System.currentTimeMillis();
        String result = solution.convert(input, 1000);
        long time = System.currentTimeMillis() - start;

        assertEquals(input, result); // With 1000 rows, result should be same as input
        assertTrue(time < 1000, "Should complete within 1 second even for maximum constraints");

        // Test mathematical approach performance
        start = System.currentTimeMillis();
        String result2 = solution.convertMathematical(input, 1000);
        long time2 = System.currentTimeMillis() - start;

        assertEquals(result, result2);
        assertTrue(time2 < 1000, "Mathematical approach should also be fast");
    }

    @Test
    @DisplayName("Compare performance of all approaches")
    void testPerformanceComparison() {
        String testString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".repeat(20); // 520 characters
        int numRows = 13;

        long start, time1, time2, time3, time4;

        start = System.currentTimeMillis();
        String result1 = solution.convert(testString, numRows);
        time1 = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        String result2 = solution.convertMathematical(testString, numRows);
        time2 = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        String result3 = solution.convertWithStringArray(testString, numRows);
        time3 = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        String result4 = solution.convertOptimized(testString, numRows);
        time4 = System.currentTimeMillis() - start;

        // All should produce same result
        assertEquals(result1, result2);
        assertEquals(result1, result3);
        assertEquals(result1, result4);

        System.out.printf("Performance comparison (input length: %d):%n", testString.length());
        System.out.printf("Simulation: %d ms%n", time1);
        System.out.printf("Mathematical: %d ms%n", time2);
        System.out.printf("String Array: %d ms%n", time3);
        System.out.printf("Optimized: %d ms%n", time4);

        // All should complete reasonably fast
        assertTrue(time1 < 100, "Simulation should be fast");
        assertTrue(time2 < 100, "Mathematical should be fast");
        assertTrue(time3 < 100, "String Array should be fast");
        assertTrue(time4 < 100, "Optimized should be fast");
    }
}
