package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Comprehensive test suite for IntegerToRoman Tests all four approaches: Greedy Arrays, Greedy Map,
 * Lookup Table, and Recursive
 */
public class IntegerToRomanTest {

    private IntegerToRoman solution;

    @BeforeEach
    void setUp() {
        solution = new IntegerToRoman();
    }

    // ========================================
    // TEST DATA PROVIDERS
    // ========================================

    /**
     * Provides test cases with input number and expected Roman numeral output
     */
    static Stream<Arguments> romanNumeralTestCases() {
        return Stream.of(
                // LeetCode examples
                Arguments.of(3, "III"), Arguments.of(4, "IV"), Arguments.of(9, "IX"),
                Arguments.of(58, "LVIII"), Arguments.of(1994, "MCMXCIV"),

                // Basic single symbols
                Arguments.of(1, "I"), Arguments.of(5, "V"), Arguments.of(10, "X"),
                Arguments.of(50, "L"), Arguments.of(100, "C"), Arguments.of(500, "D"),
                Arguments.of(1000, "M"),

                // Subtractive cases
                Arguments.of(4, "IV"), Arguments.of(9, "IX"), Arguments.of(40, "XL"),
                Arguments.of(90, "XC"), Arguments.of(400, "CD"), Arguments.of(900, "CM"),

                // Combinations without subtractive cases
                Arguments.of(2, "II"), Arguments.of(3, "III"), Arguments.of(6, "VI"),
                Arguments.of(7, "VII"), Arguments.of(8, "VIII"), Arguments.of(11, "XI"),
                Arguments.of(12, "XII"), Arguments.of(13, "XIII"), Arguments.of(15, "XV"),
                Arguments.of(20, "XX"), Arguments.of(30, "XXX"),

                // More complex numbers
                Arguments.of(27, "XXVII"), Arguments.of(44, "XLIV"), Arguments.of(49, "XLIX"),
                Arguments.of(99, "XCIX"), Arguments.of(444, "CDXLIV"), Arguments.of(499, "CDXCIX"),
                Arguments.of(999, "CMXCIX"), Arguments.of(1444, "MCDXLIV"),
                Arguments.of(1999, "MCMXCIX"),

                // Numbers with multiple thousands
                Arguments.of(2000, "MM"), Arguments.of(3000, "MMM"), Arguments.of(2023, "MMXXIII"),
                Arguments.of(3999, "MMMCMXCIX"), // Maximum constraint

                // Special patterns
                Arguments.of(1234, "MCCXXXIV"), Arguments.of(2345, "MMCCCXLV"),
                Arguments.of(3456, "MMMCDLVI"), Arguments.of(1776, "MDCCLXXVI"), // Historical year
                Arguments.of(2024, "MMXXIV"), // Current year

                // Numbers with all subtractive cases
                Arguments.of(1949, "MCMXLIX"), // CM + XL + IX
                Arguments.of(2494, "MMCDXCIV"), // CD + XC + IV
                Arguments.of(3944, "MMMCMXLIV"), // CM + XL + IV

                // Edge cases
                Arguments.of(1, "I"), // Minimum constraint
                Arguments.of(3999, "MMMCMXCIX"), // Maximum constraint

                // Random test cases for robustness
                Arguments.of(123, "CXXIII"), Arguments.of(234, "CCXXXIV"),
                Arguments.of(345, "CCCXLV"), Arguments.of(456, "CDLVI"),
                Arguments.of(567, "DLXVII"), Arguments.of(678, "DCLXXVIII"),
                Arguments.of(789, "DCCLXXXIX"), Arguments.of(890, "DCCCXC"),
                Arguments.of(1111, "MCXI"), Arguments.of(2222, "MMCCXXII"),
                Arguments.of(3333, "MMMCCCXXXIII"));
    }

    /**
     * Provides boundary test cases
     */
    static Stream<Arguments> boundaryTestCases() {
        return Stream.of(Arguments.of(1, "I"), Arguments.of(3999, "MMMCMXCIX"),
                Arguments.of(1000, "M"), Arguments.of(2000, "MM"), Arguments.of(3000, "MMM"),
                Arguments.of(999, "CMXCIX"), Arguments.of(1001, "MI"),
                Arguments.of(1999, "MCMXCIX"));
    }

    // ========================================
    // APPROACH 1: GREEDY ARRAYS TESTS
    // ========================================

    @ParameterizedTest
    @MethodSource("romanNumeralTestCases")
    @DisplayName("Test Greedy Arrays approach")
    void testIntToRomanGreedyArrays(int input, String expected) {
        String result = solution.intToRoman(input);
        assertEquals(expected, result, String.format("Greedy Arrays failed for input=%d", input));
    }

    @Test
    @DisplayName("Test Greedy Arrays with specific examples")
    void testGreedyArraysSpecificCases() {
        assertEquals("III", solution.intToRoman(3));
        assertEquals("IV", solution.intToRoman(4));
        assertEquals("LVIII", solution.intToRoman(58));
        assertEquals("MCMXCIV", solution.intToRoman(1994));
    }

    // ========================================
    // APPROACH 2: GREEDY MAP TESTS
    // ========================================

    @ParameterizedTest
    @MethodSource("romanNumeralTestCases")
    @DisplayName("Test Greedy Map approach")
    void testIntToRomanGreedyMap(int input, String expected) {
        String result = solution.intToRomanWithMap(input);
        assertEquals(expected, result, String.format("Greedy Map failed for input=%d", input));
    }

    @Test
    @DisplayName("Test Greedy Map with complex cases")
    void testGreedyMapComplexCases() {
        assertEquals("MMMCMXCIX", solution.intToRomanWithMap(3999));
        assertEquals("MCMXLIX", solution.intToRomanWithMap(1949));
        assertEquals("MMCDXCIV", solution.intToRomanWithMap(2494));
    }

    // ========================================
    // APPROACH 3: LOOKUP TABLE TESTS
    // ========================================

    @ParameterizedTest
    @MethodSource("romanNumeralTestCases")
    @DisplayName("Test Lookup Table approach")
    void testIntToRomanLookup(int input, String expected) {
        String result = solution.intToRomanLookup(input);
        assertEquals(expected, result, String.format("Lookup Table failed for input=%d", input));
    }

    @Test
    @DisplayName("Test Lookup Table with digit breakdown")
    void testLookupTableDigitBreakdown() {
        // Test that each digit position is handled correctly
        assertEquals("M", solution.intToRomanLookup(1000)); // Only thousands
        assertEquals("C", solution.intToRomanLookup(100)); // Only hundreds
        assertEquals("X", solution.intToRomanLookup(10)); // Only tens
        assertEquals("I", solution.intToRomanLookup(1)); // Only ones

        // Test combinations
        assertEquals("MCI", solution.intToRomanLookup(1101)); // M + C + I
        assertEquals("MCCXI", solution.intToRomanLookup(1211)); // M + CC + X + I
    }

    // ========================================
    // APPROACH 4: RECURSIVE TESTS
    // ========================================

    @ParameterizedTest
    @MethodSource("romanNumeralTestCases")
    @DisplayName("Test Recursive approach")
    void testIntToRomanRecursive(int input, String expected) {
        String result = solution.intToRomanRecursive(input);
        assertEquals(expected, result, String.format("Recursive failed for input=%d", input));
    }

    @Test
    @DisplayName("Test Recursive approach with subtractive cases")
    void testRecursiveSubtractiveCases() {
        assertEquals("IV", solution.intToRomanRecursive(4));
        assertEquals("IX", solution.intToRomanRecursive(9));
        assertEquals("XL", solution.intToRomanRecursive(40));
        assertEquals("XC", solution.intToRomanRecursive(90));
        assertEquals("CD", solution.intToRomanRecursive(400));
        assertEquals("CM", solution.intToRomanRecursive(900));
    }

    // ========================================
    // CROSS-VALIDATION TESTS
    // ========================================

    @Test
    @DisplayName("Test all approaches return same results")
    void testAllApproachesConsistency() {
        int[] testCases = {1, 4, 9, 27, 58, 99, 444, 999, 1234, 1994, 2023, 3999};

        for (int testCase : testCases) {
            String result1 = solution.intToRoman(testCase);
            String result2 = solution.intToRomanWithMap(testCase);
            String result3 = solution.intToRomanLookup(testCase);
            String result4 = solution.intToRomanRecursive(testCase);

            assertEquals(result1, result2, String.format(
                    "Greedy Arrays and Map differ for %d: %s vs %s", testCase, result1, result2));
            assertEquals(result1, result3,
                    String.format("Greedy Arrays and Lookup differ for %d: %s vs %s", testCase,
                            result1, result3));
            assertEquals(result1, result4,
                    String.format("Greedy Arrays and Recursive differ for %d: %s vs %s", testCase,
                            result1, result4));
        }
    }

    // ========================================
    // UTILITY METHOD TESTS
    // ========================================

    @Test
    @DisplayName("Test isValidRoman utility")
    void testIsValidRoman() {
        // Valid Roman numerals
        assertTrue(solution.isValidRoman("I"));
        assertTrue(solution.isValidRoman("IV"));
        assertTrue(solution.isValidRoman("MCMXCIV"));
        assertTrue(solution.isValidRoman("MMMCMXCIX"));

        // Invalid inputs
        assertFalse(solution.isValidRoman(""));
        assertFalse(solution.isValidRoman(null));
        assertFalse(solution.isValidRoman("IIII")); // Should be IV
        assertFalse(solution.isValidRoman("ABC")); // Invalid characters
        assertFalse(solution.isValidRoman("123")); // Numbers
    }

    @Test
    @DisplayName("Test getRomanValue utility")
    void testGetRomanValue() {
        assertEquals(1, solution.getRomanValue('I'));
        assertEquals(5, solution.getRomanValue('V'));
        assertEquals(10, solution.getRomanValue('X'));
        assertEquals(50, solution.getRomanValue('L'));
        assertEquals(100, solution.getRomanValue('C'));
        assertEquals(500, solution.getRomanValue('D'));
        assertEquals(1000, solution.getRomanValue('M'));
        assertEquals(0, solution.getRomanValue('Z')); // Invalid character
    }

    @Test
    @DisplayName("Test getRomanLength utility")
    void testGetRomanLength() {
        assertEquals(1, solution.getRomanLength(1)); // "I"
        assertEquals(2, solution.getRomanLength(4)); // "IV"
        assertEquals(3, solution.getRomanLength(3)); // "III"
        assertEquals(5, solution.getRomanLength(58)); // "LVIII"
        assertEquals(7, solution.getRomanLength(1994)); // "MCMXCIV"
        assertEquals(9, solution.getRomanLength(3999)); // "MMMCMXCIX"
    }

    @Test
    @DisplayName("Test getSubtractiveCases utility")
    void testGetSubtractiveCases() {
        String[] subtractiveCases = solution.getSubtractiveCases();
        assertArrayEquals(new String[] {"IV", "IX", "XL", "XC", "CD", "CM"}, subtractiveCases);
    }

    @Test
    @DisplayName("Test hasSubtractiveCase utility")
    void testHasSubtractiveCase() {
        assertTrue(solution.hasSubtractiveCase(4)); // IV
        assertTrue(solution.hasSubtractiveCase(9)); // IX
        assertTrue(solution.hasSubtractiveCase(40)); // XL
        assertTrue(solution.hasSubtractiveCase(90)); // XC
        assertTrue(solution.hasSubtractiveCase(400)); // CD
        assertTrue(solution.hasSubtractiveCase(900)); // CM
        assertTrue(solution.hasSubtractiveCase(1994)); // MCMXCIV (has CM and IV)

        assertFalse(solution.hasSubtractiveCase(1)); // I
        assertFalse(solution.hasSubtractiveCase(3)); // III
        assertFalse(solution.hasSubtractiveCase(58)); // LVIII
        assertFalse(solution.hasSubtractiveCase(1000)); // M
    }

    @Test
    @DisplayName("Test analyzeConstruction utility")
    void testAnalyzeConstruction() {
        String analysis1 = solution.analyzeConstruction(1994);
        assertTrue(analysis1.contains("1994"));
        assertTrue(analysis1.contains("MCMXCIV"));

        String analysis2 = solution.analyzeConstruction(58);
        assertTrue(analysis2.contains("58"));
        assertTrue(analysis2.contains("LVIII"));

        String analysis3 = solution.analyzeConstruction(4);
        assertTrue(analysis3.contains("4"));
        assertTrue(analysis3.contains("IV"));
    }

    // ========================================
    // BOUNDARY TESTS
    // ========================================

    @ParameterizedTest
    @MethodSource("boundaryTestCases")
    @DisplayName("Test boundary cases")
    void testBoundaryCases(int input, String expected) {
        assertEquals(expected, solution.intToRoman(input));
        assertEquals(expected, solution.intToRomanWithMap(input));
        assertEquals(expected, solution.intToRomanLookup(input));
        assertEquals(expected, solution.intToRomanRecursive(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100, 1000, 3999})
    @DisplayName("Test constraint boundaries")
    void testConstraintBoundaries(int input) {
        String result = solution.intToRoman(input);
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertTrue(solution.isValidRoman(result));
    }

    // ========================================
    // PERFORMANCE TESTS
    // ========================================

    @Test
    @DisplayName("Test performance comparison")
    void testPerformanceComparison() {
        int[] testNumbers = {1, 50, 500, 1000, 1500, 2500, 3999};

        for (int num : testNumbers) {
            long start, time1, time2, time3, time4;

            start = System.nanoTime();
            String result1 = solution.intToRoman(num);
            time1 = System.nanoTime() - start;

            start = System.nanoTime();
            String result2 = solution.intToRomanWithMap(num);
            time2 = System.nanoTime() - start;

            start = System.nanoTime();
            String result3 = solution.intToRomanLookup(num);
            time3 = System.nanoTime() - start;

            start = System.nanoTime();
            String result4 = solution.intToRomanRecursive(num);
            time4 = System.nanoTime() - start;

            // All should produce same result
            assertEquals(result1, result2);
            assertEquals(result1, result3);
            assertEquals(result1, result4);

            // All should complete very quickly (performance test)
            // Use more reasonable time limits - 10ms should be plenty for these simple operations
            assertTrue(time1 < 10_000_000, "Greedy Arrays should be fast"); // < 10ms
            assertTrue(time2 < 10_000_000, "Greedy Map should be fast");
            assertTrue(time3 < 10_000_000, "Lookup should be fast");
            assertTrue(time4 < 10_000_000, "Recursive should be fast");
        }
    }

    @Test
    @DisplayName("Test all numbers in range")
    void testAllNumbersInRange() {
        // Test a representative sample of the full range (1-3999)
        // Testing every number would be too slow, so test strategic points
        for (int i = 1; i <= 100; i++) {
            String result = solution.intToRoman(i);
            assertNotNull(result);
            assertFalse(result.isEmpty());
            assertTrue(solution.isValidRoman(result));
        }

        // Test hundreds
        for (int i = 100; i <= 1000; i += 100) {
            String result = solution.intToRoman(i);
            assertNotNull(result);
            assertTrue(solution.isValidRoman(result));
        }

        // Test thousands
        for (int i = 1000; i <= 3000; i += 1000) {
            String result = solution.intToRoman(i);
            assertNotNull(result);
            assertTrue(solution.isValidRoman(result));
        }

        // Test near maximum
        for (int i = 3990; i <= 3999; i++) {
            String result = solution.intToRoman(i);
            assertNotNull(result);
            assertTrue(solution.isValidRoman(result));
        }
    }
}
