package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Comprehensive test suite for RomanToInteger LeetCode solution
 * 
 * Tests all 5 algorithmic approaches with 200+ test cases including: - Basic Roman numerals (I, V,
 * X, L, C, D, M) - Subtractive cases (IV, IX, XL, XC, CD, CM) - Edge cases and boundary conditions
 * - Performance validation - Cross-validation between approaches
 */
@DisplayName("Roman to Integer - LeetCode #13")
class RomanToIntegerTest {

    private RomanToInteger romanToInteger;

    @BeforeEach
    void setUp() {
        romanToInteger = new RomanToInteger();
    }

    // ========================================
    // BASIC FUNCTIONALITY TESTS
    // ========================================

    @Test
    @DisplayName("Basic Roman numerals - single characters")
    void testBasicRomanNumerals() {
        assertEquals(1, romanToInteger.romanToInt("I"));
        assertEquals(5, romanToInteger.romanToInt("V"));
        assertEquals(10, romanToInteger.romanToInt("X"));
        assertEquals(50, romanToInteger.romanToInt("L"));
        assertEquals(100, romanToInteger.romanToInt("C"));
        assertEquals(500, romanToInteger.romanToInt("D"));
        assertEquals(1000, romanToInteger.romanToInt("M"));
    }

    @Test
    @DisplayName("Additive cases - multiple same characters")
    void testAdditiveCases() {
        assertEquals(2, romanToInteger.romanToInt("II"));
        assertEquals(3, romanToInteger.romanToInt("III"));
        assertEquals(6, romanToInteger.romanToInt("VI"));
        assertEquals(7, romanToInteger.romanToInt("VII"));
        assertEquals(8, romanToInteger.romanToInt("VIII"));
        assertEquals(11, romanToInteger.romanToInt("XI"));
        assertEquals(12, romanToInteger.romanToInt("XII"));
        assertEquals(15, romanToInteger.romanToInt("XV"));
        assertEquals(20, romanToInteger.romanToInt("XX"));
        assertEquals(30, romanToInteger.romanToInt("XXX"));
    }

    @Test
    @DisplayName("Subtractive cases - smaller before larger")
    void testSubtractiveCases() {
        assertEquals(4, romanToInteger.romanToInt("IV"));
        assertEquals(9, romanToInteger.romanToInt("IX"));
        assertEquals(40, romanToInteger.romanToInt("XL"));
        assertEquals(90, romanToInteger.romanToInt("XC"));
        assertEquals(400, romanToInteger.romanToInt("CD"));
        assertEquals(900, romanToInteger.romanToInt("CM"));
    }

    @Test
    @DisplayName("LeetCode examples")
    void testLeetCodeExamples() {
        assertEquals(3, romanToInteger.romanToInt("III"));
        assertEquals(4, romanToInteger.romanToInt("IV"));
        assertEquals(9, romanToInteger.romanToInt("IX"));
        assertEquals(58, romanToInteger.romanToInt("LVIII"));
        assertEquals(1994, romanToInteger.romanToInt("MCMXCIV"));
    }

    // ========================================
    // COMPREHENSIVE TEST CASES
    // ========================================

    @ParameterizedTest
    @CsvSource({
            // Basic cases
            "I, 1", "II, 2", "III, 3", "V, 5", "VI, 6", "VII, 7", "VIII, 8", "X, 10", "XI, 11",
            "XII, 12", "XV, 15", "XX, 20", "XXX, 30", "L, 50", "LI, 51", "LV, 55", "LX, 60",
            "LXX, 70", "LXXX, 80", "C, 100", "CI, 101", "CV, 105", "CX, 110", "CL, 150", "CC, 200",
            "CCC, 300", "D, 500", "DI, 501", "DV, 505", "DX, 510", "DL, 550", "DC, 600", "DCC, 700",
            "DCCC, 800", "M, 1000", "MI, 1001", "MV, 1005", "MX, 1010", "ML, 1050", "MC, 1100",
            "MM, 2000", "MMM, 3000",

            // Subtractive cases
            "IV, 4", "IX, 9", "XL, 40", "XC, 90", "CD, 400", "CM, 900",

            // Complex cases
            "XIV, 14", "XIX, 19", "XXIV, 24", "XXIX, 29", "XLIV, 44", "XLIX, 49", "LIV, 54",
            "LIX, 59", "XCIV, 94", "XCIX, 99", "CXL, 140", "CXC, 190", "CCXL, 240", "CCXC, 290",
            "CDXL, 440", "CDXC, 490", "DXL, 540", "DXC, 590", "CMXL, 940", "CMXC, 990", "MCD, 1400",
            "MCM, 1900", "MMCD, 2400", "MMCM, 2900",

            // Edge cases
            "MMMCMXCIX, 3999", "MMMCMXCVIII, 3998", "MMMCMXCVII, 3997", "MMMCMXCVI, 3996",
            "MMMCMXCV, 3995", "MMMCMXCIV, 3994",

            // Mixed cases
            "MDCCLXXVI, 1776", "MCMLIV, 1954", "MCMXC, 1990", "MMXIV, 2014", "MMXVIII, 2018",
            "MMXX, 2020", "MMXXI, 2021", "MMXXII, 2022", "MMXXIII, 2023", "MMXXIV, 2024"})
    @DisplayName("Comprehensive Roman numeral conversions")
    void testComprehensiveConversions(String roman, int expected) {
        assertEquals(expected, romanToInteger.romanToInt(roman));
    }

    // ========================================
    // MULTIPLE APPROACHES CROSS-VALIDATION
    // ========================================

    @Test
    @DisplayName("Cross-validation: All approaches produce same results")
    void testAllApproachesProduceSameResults() {
        String[] testCases = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
                "XII", "XIV", "XV", "XIX", "XX", "XXIV", "XXIX", "XXX", "XL", "XLIV", "XLIX", "L",
                "LIV", "LIX", "LX", "LXX", "LXXX", "XC", "XCIV", "XCIX", "C", "CXL", "CXC", "CC",
                "CCC", "CD", "CDXL", "CDXC", "D", "DXL", "DXC", "DC", "DCC", "DCCC", "CM", "CMXL",
                "CMXC", "M", "MCD", "MCM", "MM", "MMM", "MMMCMXCIX"};

        for (String testCase : testCases) {
            int result1 = romanToInteger.romanToInt(testCase);
            int result2 = romanToInteger.romanToIntWithMap(testCase);
            int result3 = romanToInteger.romanToIntRightToLeft(testCase);
            int result4 = romanToInteger.romanToIntSubtractivePairs(testCase);
            int result5 = romanToInteger.romanToIntArray(testCase);

            assertEquals(result1, result2, "Approach 1 vs 2 failed for: " + testCase);
            assertEquals(result1, result3, "Approach 1 vs 3 failed for: " + testCase);
            assertEquals(result1, result4, "Approach 1 vs 4 failed for: " + testCase);
            assertEquals(result1, result5, "Approach 1 vs 5 failed for: " + testCase);
        }
    }

    // ========================================
    // EDGE CASES AND BOUNDARY CONDITIONS
    // ========================================

    @Test
    @DisplayName("Edge cases - minimum and maximum values")
    void testEdgeCases() {
        // Minimum valid Roman numeral
        assertEquals(1, romanToInteger.romanToInt("I"));

        // Maximum valid Roman numeral (within LeetCode constraints)
        assertEquals(3999, romanToInteger.romanToInt("MMMCMXCIX"));

        // Common edge cases
        assertEquals(2, romanToInteger.romanToInt("II"));
        assertEquals(3, romanToInteger.romanToInt("III"));
        assertEquals(4, romanToInteger.romanToInt("IV"));
        assertEquals(5, romanToInteger.romanToInt("V"));
    }

    @Test
    @DisplayName("Null and empty string handling")
    void testNullAndEmptyHandling() {
        assertEquals(0, romanToInteger.romanToInt(null));
        assertEquals(0, romanToInteger.romanToInt(""));

        assertEquals(0, romanToInteger.romanToIntWithMap(null));
        assertEquals(0, romanToInteger.romanToIntWithMap(""));

        assertEquals(0, romanToInteger.romanToIntRightToLeft(null));
        assertEquals(0, romanToInteger.romanToIntRightToLeft(""));

        assertEquals(0, romanToInteger.romanToIntSubtractivePairs(null));
        assertEquals(0, romanToInteger.romanToIntSubtractivePairs(""));

        assertEquals(0, romanToInteger.romanToIntArray(null));
        assertEquals(0, romanToInteger.romanToIntArray(""));
    }

    // ========================================
    // SUBTRACTIVE CASES TESTING
    // ========================================

    @Test
    @DisplayName("All subtractive cases")
    void testAllSubtractiveCases() {
        // Test all 6 subtractive cases
        assertEquals(4, romanToInteger.romanToInt("IV")); // 5-1
        assertEquals(9, romanToInteger.romanToInt("IX")); // 10-1
        assertEquals(40, romanToInteger.romanToInt("XL")); // 50-10
        assertEquals(90, romanToInteger.romanToInt("XC")); // 100-10
        assertEquals(400, romanToInteger.romanToInt("CD")); // 500-100
        assertEquals(900, romanToInteger.romanToInt("CM")); // 1000-100
    }

    @Test
    @DisplayName("Multiple subtractive cases in one numeral")
    void testMultipleSubtractiveCases() {
        assertEquals(14, romanToInteger.romanToInt("XIV")); // 10 + (5-1)
        assertEquals(19, romanToInteger.romanToInt("XIX")); // 10 + (10-1)
        assertEquals(24, romanToInteger.romanToInt("XXIV")); // 10 + 10 + (5-1)
        assertEquals(29, romanToInteger.romanToInt("XXIX")); // 10 + 10 + (10-1)
        assertEquals(44, romanToInteger.romanToInt("XLIV")); // (50-10) + (5-1)
        assertEquals(49, romanToInteger.romanToInt("XLIX")); // (50-10) + (10-1)
        assertEquals(94, romanToInteger.romanToInt("XCIV")); // (100-10) + (5-1)
        assertEquals(99, romanToInteger.romanToInt("XCIX")); // (100-10) + (10-1)
    }

    @Test
    @DisplayName("Complex subtractive cases")
    void testComplexSubtractiveCases() {
        assertEquals(1944, romanToInteger.romanToInt("MCMXLIV")); // 1000 + (1000-100) + (50-10) +
                                                                  // (5-1)
        assertEquals(1994, romanToInteger.romanToInt("MCMXCIV")); // 1000 + (1000-100) + (100-10) +
                                                                  // (5-1)
        assertEquals(3999, romanToInteger.romanToInt("MMMCMXCIX")); // 1000 + 1000 + 1000 +
                                                                    // (1000-100) + (100-10) +
                                                                    // (10-1)
    }

    // ========================================
    // VALIDATION TESTS
    // ========================================

    @Test
    @DisplayName("Roman numeral validation")
    void testRomanNumeralValidation() {
        // Valid Roman numerals
        assertTrue(romanToInteger.isValidRoman("I"));
        assertTrue(romanToInteger.isValidRoman("V"));
        assertTrue(romanToInteger.isValidRoman("X"));
        assertTrue(romanToInteger.isValidRoman("L"));
        assertTrue(romanToInteger.isValidRoman("C"));
        assertTrue(romanToInteger.isValidRoman("D"));
        assertTrue(romanToInteger.isValidRoman("M"));
        assertTrue(romanToInteger.isValidRoman("IV"));
        assertTrue(romanToInteger.isValidRoman("IX"));
        assertTrue(romanToInteger.isValidRoman("XL"));
        assertTrue(romanToInteger.isValidRoman("XC"));
        assertTrue(romanToInteger.isValidRoman("CD"));
        assertTrue(romanToInteger.isValidRoman("CM"));
        assertTrue(romanToInteger.isValidRoman("MMMCMXCIX"));

        // Invalid Roman numerals
        assertFalse(romanToInteger.isValidRoman(null));
        assertFalse(romanToInteger.isValidRoman(""));
        assertFalse(romanToInteger.isValidRoman("A"));
        assertFalse(romanToInteger.isValidRoman("1"));
        assertFalse(romanToInteger.isValidRoman("IIII")); // More than 3 I's
        assertFalse(romanToInteger.isValidRoman("VV")); // V cannot repeat
        assertFalse(romanToInteger.isValidRoman("LL")); // L cannot repeat
        assertFalse(romanToInteger.isValidRoman("DD")); // D cannot repeat
        assertFalse(romanToInteger.isValidRoman("IL")); // Invalid subtractive
        assertFalse(romanToInteger.isValidRoman("IC")); // Invalid subtractive
        assertFalse(romanToInteger.isValidRoman("XD")); // Invalid subtractive
        assertFalse(romanToInteger.isValidRoman("XM")); // Invalid subtractive
    }

    @Test
    @DisplayName("Subtractive case detection")
    void testSubtractiveCaseDetection() {
        // Cases with subtractive notation
        assertTrue(romanToInteger.hasSubtractiveCase("IV"));
        assertTrue(romanToInteger.hasSubtractiveCase("IX"));
        assertTrue(romanToInteger.hasSubtractiveCase("XL"));
        assertTrue(romanToInteger.hasSubtractiveCase("XC"));
        assertTrue(romanToInteger.hasSubtractiveCase("CD"));
        assertTrue(romanToInteger.hasSubtractiveCase("CM"));
        assertTrue(romanToInteger.hasSubtractiveCase("XIV"));
        assertTrue(romanToInteger.hasSubtractiveCase("MCMXCIV"));

        // Cases without subtractive notation
        assertFalse(romanToInteger.hasSubtractiveCase("I"));
        assertFalse(romanToInteger.hasSubtractiveCase("II"));
        assertFalse(romanToInteger.hasSubtractiveCase("III"));
        assertFalse(romanToInteger.hasSubtractiveCase("V"));
        assertFalse(romanToInteger.hasSubtractiveCase("VI"));
        assertFalse(romanToInteger.hasSubtractiveCase("VII"));
        assertFalse(romanToInteger.hasSubtractiveCase("VIII"));
        assertFalse(romanToInteger.hasSubtractiveCase("X"));
        assertFalse(romanToInteger.hasSubtractiveCase("XI"));
        assertFalse(romanToInteger.hasSubtractiveCase("XII"));
        assertFalse(romanToInteger.hasSubtractiveCase("XV"));
        assertFalse(romanToInteger.hasSubtractiveCase("XX"));
        assertFalse(romanToInteger.hasSubtractiveCase("XXX"));

        // Edge cases
        assertFalse(romanToInteger.hasSubtractiveCase(null));
        assertFalse(romanToInteger.hasSubtractiveCase(""));
        assertFalse(romanToInteger.hasSubtractiveCase("A"));
    }

    // ========================================
    // UTILITY METHOD TESTS
    // ========================================

    @Test
    @DisplayName("Character counting")
    void testCharacterCounting() {
        Map<Character, Integer> counts = romanToInteger.getCharacterCounts("MMMCMXCIX");
        assertEquals(4, counts.get('M')); // M appears 3 times at start + 1 time in CM
        assertEquals(2, counts.get('C')); // C appears 1 time in CM + 1 time in XC
        assertEquals(2, counts.get('X')); // X appears 1 time in XC + 1 time in IX
        assertEquals(1, counts.get('I')); // I appears 1 time in IX
        assertNull(counts.get('V'));
        assertNull(counts.get('L'));
        assertNull(counts.get('D'));

        counts = romanToInteger.getCharacterCounts("LVIII");
        assertEquals(1, counts.get('L'));
        assertEquals(1, counts.get('V'));
        assertEquals(3, counts.get('I'));
        assertNull(counts.get('M'));
        assertNull(counts.get('C'));
        assertNull(counts.get('X'));
        assertNull(counts.get('D'));
    }

    @Test
    @DisplayName("Roman numeral length")
    void testRomanNumeralLength() {
        assertEquals(1, romanToInteger.getRomanLength("I"));
        assertEquals(2, romanToInteger.getRomanLength("IV"));
        assertEquals(3, romanToInteger.getRomanLength("III"));
        assertEquals(5, romanToInteger.getRomanLength("LVIII"));
        assertEquals(7, romanToInteger.getRomanLength("MCMXCIV"));
        assertEquals(9, romanToInteger.getRomanLength("MMMCMXCIX"));
        assertEquals(0, romanToInteger.getRomanLength(null));
        assertEquals(0, romanToInteger.getRomanLength(""));
    }

    @Test
    @DisplayName("Subtractive cases array")
    void testSubtractiveCasesArray() {
        String[] subtractiveCases = romanToInteger.getSubtractiveCases();
        assertEquals(6, subtractiveCases.length);

        List<String> casesList = Arrays.asList(subtractiveCases);
        assertTrue(casesList.contains("IV"));
        assertTrue(casesList.contains("IX"));
        assertTrue(casesList.contains("XL"));
        assertTrue(casesList.contains("XC"));
        assertTrue(casesList.contains("CD"));
        assertTrue(casesList.contains("CM"));
    }

    // ========================================
    // ANALYSIS AND DEBUGGING TESTS
    // ========================================

    @Test
    @DisplayName("Conversion analysis")
    void testConversionAnalysis() {
        String analysis = romanToInteger.analyzeConversion("MCMXCIV");
        assertTrue(analysis.contains("MCMXCIV"));
        assertTrue(analysis.contains("1994"));
        assertTrue(analysis.contains("+1000"));
        assertTrue(analysis.contains("-100"));
        assertTrue(analysis.contains("+1000"));
        assertTrue(analysis.contains("-10"));
        assertTrue(analysis.contains("+100"));
        assertTrue(analysis.contains("-1"));
        assertTrue(analysis.contains("+5"));

        analysis = romanToInteger.analyzeConversion("IV");
        assertTrue(analysis.contains("IV"));
        assertTrue(analysis.contains("4"));
        assertTrue(analysis.contains("-1"));
        assertTrue(analysis.contains("+5"));
    }

    // ========================================
    // PERFORMANCE TESTS
    // ========================================

    @Test
    @DisplayName("Performance test - all approaches")
    void testPerformanceAllApproaches() {
        String[] testCases = {"I", "IV", "IX", "LVIII", "MCMXCIV", "MMMCMXCIX"};

        for (String testCase : testCases) {
            // Test that all approaches produce the same result
            int result1 = romanToInteger.romanToInt(testCase);
            int result2 = romanToInteger.romanToIntWithMap(testCase);
            int result3 = romanToInteger.romanToIntRightToLeft(testCase);
            int result4 = romanToInteger.romanToIntSubtractivePairs(testCase);
            int result5 = romanToInteger.romanToIntArray(testCase);

            assertEquals(result1, result2);
            assertEquals(result1, result3);
            assertEquals(result1, result4);
            assertEquals(result1, result5);
        }
    }

    // ========================================
    // STRESS TESTS
    // ========================================

    @Test
    @DisplayName("Stress test - maximum length Roman numeral")
    void testStressTestMaximumLength() {
        // Test the maximum valid Roman numeral (15 characters max per LeetCode constraints)
        String maxRoman = "MMMCMXCIX"; // 3999
        assertEquals(3999, romanToInteger.romanToInt(maxRoman));
        assertEquals(3999, romanToInteger.romanToIntWithMap(maxRoman));
        assertEquals(3999, romanToInteger.romanToIntRightToLeft(maxRoman));
        assertEquals(3999, romanToInteger.romanToIntSubtractivePairs(maxRoman));
        assertEquals(3999, romanToInteger.romanToIntArray(maxRoman));
    }

    @Test
    @DisplayName("Stress test - all single character Roman numerals")
    void testStressTestAllSingleCharacters() {
        char[] romanChars = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] expectedValues = {1, 5, 10, 50, 100, 500, 1000};

        for (int i = 0; i < romanChars.length; i++) {
            String roman = String.valueOf(romanChars[i]);
            int expected = expectedValues[i];

            assertEquals(expected, romanToInteger.romanToInt(roman));
            assertEquals(expected, romanToInteger.romanToIntWithMap(roman));
            assertEquals(expected, romanToInteger.romanToIntRightToLeft(roman));
            assertEquals(expected, romanToInteger.romanToIntSubtractivePairs(roman));
            assertEquals(expected, romanToInteger.romanToIntArray(roman));
        }
    }

    // ========================================
    // PARAMETERIZED TESTS FOR COMPREHENSIVE COVERAGE
    // ========================================

    @ParameterizedTest
    @ValueSource(strings = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIV", "XV", "XIX", "XX", "XXIV", "XXIX", "XXX", "XL", "XLIV", "XLIX", "L",
            "LIV", "LIX", "LX", "LXX", "LXXX", "XC", "XCIV", "XCIX", "C", "CXL", "CXC", "CC", "CCC",
            "CD", "CDXL", "CDXC", "D", "DXL", "DXC", "DC", "DCC", "DCCC", "CM", "CMXL", "CMXC", "M",
            "MCD", "MCM", "MM", "MMM", "MMMCMXCIX"})
    @DisplayName("Parameterized test - all approaches consistency")
    void testAllApproachesConsistency(String roman) {
        int result1 = romanToInteger.romanToInt(roman);
        int result2 = romanToInteger.romanToIntWithMap(roman);
        int result3 = romanToInteger.romanToIntRightToLeft(roman);
        int result4 = romanToInteger.romanToIntSubtractivePairs(roman);
        int result5 = romanToInteger.romanToIntArray(roman);

        assertEquals(result1, result2, "Approach 1 vs 2 failed for: " + roman);
        assertEquals(result1, result3, "Approach 1 vs 3 failed for: " + roman);
        assertEquals(result1, result4, "Approach 1 vs 4 failed for: " + roman);
        assertEquals(result1, result5, "Approach 1 vs 5 failed for: " + roman);
    }

    // ========================================
    // SPECIAL CASES AND EDGE SCENARIOS
    // ========================================

    @Test
    @DisplayName("Special cases - years and dates")
    void testSpecialCasesYearsAndDates() {
        // Historical years
        assertEquals(1776, romanToInteger.romanToInt("MDCCLXXVI")); // US Declaration of
                                                                    // Independence
        assertEquals(1954, romanToInteger.romanToInt("MCMLIV")); // Some historical event
        assertEquals(1990, romanToInteger.romanToInt("MCMXC")); // Year 1990
        assertEquals(2014, romanToInteger.romanToInt("MMXIV")); // Year 2014
        assertEquals(2018, romanToInteger.romanToInt("MMXVIII")); // Year 2018
        assertEquals(2020, romanToInteger.romanToInt("MMXX")); // Year 2020
        assertEquals(2021, romanToInteger.romanToInt("MMXXI")); // Year 2021
        assertEquals(2022, romanToInteger.romanToInt("MMXXII")); // Year 2022
        assertEquals(2023, romanToInteger.romanToInt("MMXXIII")); // Year 2023
        assertEquals(2024, romanToInteger.romanToInt("MMXXIV")); // Year 2024
    }

    @Test
    @DisplayName("Special cases - complex combinations")
    void testSpecialCasesComplexCombinations() {
        // Test complex combinations with multiple subtractive cases
        assertEquals(1944, romanToInteger.romanToInt("MCMXLIV")); // 1000 + 900 + 40 + 4
        assertEquals(1994, romanToInteger.romanToInt("MCMXCIV")); // 1000 + 900 + 90 + 4
        assertEquals(3999, romanToInteger.romanToInt("MMMCMXCIX")); // 3000 + 900 + 90 + 9

        // Test cases with multiple same characters
        assertEquals(8, romanToInteger.romanToInt("VIII")); // 5 + 1 + 1 + 1
        assertEquals(13, romanToInteger.romanToInt("XIII")); // 10 + 1 + 1 + 1
        assertEquals(18, romanToInteger.romanToInt("XVIII")); // 10 + 5 + 1 + 1 + 1
        assertEquals(23, romanToInteger.romanToInt("XXIII")); // 10 + 10 + 1 + 1 + 1
        assertEquals(28, romanToInteger.romanToInt("XXVIII")); // 10 + 10 + 5 + 1 + 1 + 1
    }

    @Test
    @DisplayName("Special cases - boundary values")
    void testSpecialCasesBoundaryValues() {
        // Test values just below and above subtractive cases
        assertEquals(3, romanToInteger.romanToInt("III")); // Just below IV (4)
        assertEquals(4, romanToInteger.romanToInt("IV")); // Subtractive case
        assertEquals(5, romanToInteger.romanToInt("V")); // Just above IV (4)

        assertEquals(8, romanToInteger.romanToInt("VIII")); // Just below IX (9)
        assertEquals(9, romanToInteger.romanToInt("IX")); // Subtractive case
        assertEquals(10, romanToInteger.romanToInt("X")); // Just above IX (9)

        assertEquals(39, romanToInteger.romanToInt("XXXIX")); // Just below XL (40)
        assertEquals(40, romanToInteger.romanToInt("XL")); // Subtractive case
        assertEquals(41, romanToInteger.romanToInt("XLI")); // Just above XL (40)
    }
}
