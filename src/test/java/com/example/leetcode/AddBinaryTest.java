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
 * Comprehensive test suite for LeetCode #67: Add Binary
 * 
 * This test suite validates all 6 algorithmic approaches with extensive test cases: - Basic
 * functionality tests - Edge case testing - Performance validation - Cross-validation between
 * approaches - Stress testing with large inputs
 * 
 * @author Superman
 * @version 1.0
 */
@DisplayName("Add Binary Tests")
class AddBinaryTest {

    private AddBinary solution;

    @BeforeEach
    void setUp() {
        solution = new AddBinary();
    }

    // ==================== Basic Functionality Tests ====================

    @Test
    @DisplayName("Basic test case: 11 + 1 = 100")
    void testBasicCase1() {
        String a = "11";
        String b = "1";
        String expected = "100";

        assertEquals(expected, solution.addBinaryBuiltIn(a, b));
        assertEquals(expected, solution.addBinaryManual(a, b));
        assertEquals(expected, solution.addBinaryArray(a, b));
        assertEquals(expected, solution.addBinaryRecursive(a, b));
        assertEquals(expected, solution.addBinaryBitManipulation(a, b));
        assertEquals(expected, solution.addBinaryOptimized(a, b));
    }

    @Test
    @DisplayName("Basic test case: 1010 + 1011 = 10101")
    void testBasicCase2() {
        String a = "1010";
        String b = "1011";
        String expected = "10101";

        assertEquals(expected, solution.addBinaryBuiltIn(a, b));
        assertEquals(expected, solution.addBinaryManual(a, b));
        assertEquals(expected, solution.addBinaryArray(a, b));
        assertEquals(expected, solution.addBinaryRecursive(a, b));
        assertEquals(expected, solution.addBinaryBitManipulation(a, b));
        assertEquals(expected, solution.addBinaryOptimized(a, b));
    }

    @Test
    @DisplayName("Basic test case: 0 + 0 = 0")
    void testBasicCaseZero() {
        String a = "0";
        String b = "0";
        String expected = "0";

        assertEquals(expected, solution.addBinaryBuiltIn(a, b));
        assertEquals(expected, solution.addBinaryManual(a, b));
        assertEquals(expected, solution.addBinaryArray(a, b));
        assertEquals(expected, solution.addBinaryRecursive(a, b));
        assertEquals(expected, solution.addBinaryBitManipulation(a, b));
        assertEquals(expected, solution.addBinaryOptimized(a, b));
    }

    @Test
    @DisplayName("Basic test case: 1 + 1 = 10")
    void testBasicCaseOnes() {
        String a = "1";
        String b = "1";
        String expected = "10";

        assertEquals(expected, solution.addBinaryBuiltIn(a, b));
        assertEquals(expected, solution.addBinaryManual(a, b));
        assertEquals(expected, solution.addBinaryArray(a, b));
        assertEquals(expected, solution.addBinaryRecursive(a, b));
        assertEquals(expected, solution.addBinaryBitManipulation(a, b));
        assertEquals(expected, solution.addBinaryOptimized(a, b));
    }

    // ==================== Edge Case Tests ====================

    @Test
    @DisplayName("Edge case: null inputs")
    void testNullInputs() {
        String expected = "0";

        assertEquals(expected, solution.addBinaryBuiltIn(null, "1"));
        assertEquals(expected, solution.addBinaryBuiltIn("1", null));
        assertEquals(expected, solution.addBinaryBuiltIn(null, null));

        assertEquals(expected, solution.addBinaryManual(null, "1"));
        assertEquals(expected, solution.addBinaryManual("1", null));
        assertEquals(expected, solution.addBinaryManual(null, null));

        assertEquals(expected, solution.addBinaryArray(null, "1"));
        assertEquals(expected, solution.addBinaryArray("1", null));
        assertEquals(expected, solution.addBinaryArray(null, null));

        assertEquals(expected, solution.addBinaryRecursive(null, "1"));
        assertEquals(expected, solution.addBinaryRecursive("1", null));
        assertEquals(expected, solution.addBinaryRecursive(null, null));

        assertEquals(expected, solution.addBinaryBitManipulation(null, "1"));
        assertEquals(expected, solution.addBinaryBitManipulation("1", null));
        assertEquals(expected, solution.addBinaryBitManipulation(null, null));

        assertEquals(expected, solution.addBinaryOptimized(null, "1"));
        assertEquals(expected, solution.addBinaryOptimized("1", null));
        assertEquals(expected, solution.addBinaryOptimized(null, null));
    }

    @Test
    @DisplayName("Edge case: one operand is zero")
    void testOneOperandZero() {
        String a = "0";
        String b = "1010";

        assertEquals(b, solution.addBinaryBuiltIn(a, b));
        assertEquals(b, solution.addBinaryManual(a, b));
        assertEquals(b, solution.addBinaryArray(a, b));
        assertEquals(b, solution.addBinaryRecursive(a, b));
        assertEquals(b, solution.addBinaryBitManipulation(a, b));
        assertEquals(b, solution.addBinaryOptimized(a, b));

        assertEquals(b, solution.addBinaryBuiltIn(b, a));
        assertEquals(b, solution.addBinaryManual(b, a));
        assertEquals(b, solution.addBinaryArray(b, a));
        assertEquals(b, solution.addBinaryRecursive(b, a));
        assertEquals(b, solution.addBinaryBitManipulation(b, a));
        assertEquals(b, solution.addBinaryOptimized(b, a));
    }

    @Test
    @DisplayName("Edge case: single digit addition")
    void testSingleDigitAddition() {
        String a = "1";
        String b = "0";
        String expected = "1";

        assertEquals(expected, solution.addBinaryBuiltIn(a, b));
        assertEquals(expected, solution.addBinaryManual(a, b));
        assertEquals(expected, solution.addBinaryArray(a, b));
        assertEquals(expected, solution.addBinaryRecursive(a, b));
        assertEquals(expected, solution.addBinaryBitManipulation(a, b));
        assertEquals(expected, solution.addBinaryOptimized(a, b));
    }

    @Test
    @DisplayName("Edge case: maximum carry propagation")
    void testMaximumCarryPropagation() {
        String a = "1111";
        String b = "1111";
        String expected = "11110";

        assertEquals(expected, solution.addBinaryBuiltIn(a, b));
        assertEquals(expected, solution.addBinaryManual(a, b));
        assertEquals(expected, solution.addBinaryArray(a, b));
        assertEquals(expected, solution.addBinaryRecursive(a, b));
        assertEquals(expected, solution.addBinaryBitManipulation(a, b));
        assertEquals(expected, solution.addBinaryOptimized(a, b));
    }

    // ==================== Complex Pattern Tests ====================

    @Test
    @DisplayName("Complex pattern: alternating bits")
    void testAlternatingBits() {
        String a = "1010101010";
        String b = "1010101010";
        String expected = "10101010100";

        assertEquals(expected, solution.addBinaryBuiltIn(a, b));
        assertEquals(expected, solution.addBinaryManual(a, b));
        assertEquals(expected, solution.addBinaryArray(a, b));
        assertEquals(expected, solution.addBinaryRecursive(a, b));
        assertEquals(expected, solution.addBinaryBitManipulation(a, b));
        assertEquals(expected, solution.addBinaryOptimized(a, b));
    }

    @Test
    @DisplayName("Complex pattern: different lengths")
    void testDifferentLengths() {
        String a = "100";
        String b = "110010";
        String expected = "110110";

        assertEquals(expected, solution.addBinaryBuiltIn(a, b));
        assertEquals(expected, solution.addBinaryManual(a, b));
        assertEquals(expected, solution.addBinaryArray(a, b));
        assertEquals(expected, solution.addBinaryRecursive(a, b));
        assertEquals(expected, solution.addBinaryBitManipulation(a, b));
        assertEquals(expected, solution.addBinaryOptimized(a, b));
    }

    @Test
    @DisplayName("Complex pattern: large numbers")
    void testLargeNumbers() {
        String a = "1111111111";
        String b = "1";
        String expected = "10000000000";

        assertEquals(expected, solution.addBinaryBuiltIn(a, b));
        assertEquals(expected, solution.addBinaryManual(a, b));
        assertEquals(expected, solution.addBinaryArray(a, b));
        assertEquals(expected, solution.addBinaryRecursive(a, b));
        assertEquals(expected, solution.addBinaryBitManipulation(a, b));
        assertEquals(expected, solution.addBinaryOptimized(a, b));
    }

    @Test
    @DisplayName("Complex pattern: all ones")
    void testAllOnes() {
        String a = "1111111111";
        String b = "1111111111";
        String expected = "11111111110";

        assertEquals(expected, solution.addBinaryBuiltIn(a, b));
        assertEquals(expected, solution.addBinaryManual(a, b));
        assertEquals(expected, solution.addBinaryArray(a, b));
        assertEquals(expected, solution.addBinaryRecursive(a, b));
        assertEquals(expected, solution.addBinaryBitManipulation(a, b));
        assertEquals(expected, solution.addBinaryOptimized(a, b));
    }

    // ==================== Parameterized Tests ====================

    @ParameterizedTest
    @CsvSource({"11, 1, 100", "1010, 1011, 10101", "0, 0, 0", "1, 1, 10", "1111, 1111, 11110",
            "100, 110010, 110110", "10101, 1010, 11111", "0, 1, 1", "1111111111, 1, 10000000000",
            "1010101010, 1010101010, 10101010100", "1, 1111111111, 10000000000",
            "1000000000, 1000000000, 10000000000"})
    @DisplayName("Parameterized test cases")
    void testParameterizedCases(String a, String b, String expected) {
        assertEquals(expected, solution.addBinaryBuiltIn(a, b));
        assertEquals(expected, solution.addBinaryManual(a, b));
        assertEquals(expected, solution.addBinaryArray(a, b));
        assertEquals(expected, solution.addBinaryRecursive(a, b));
        assertEquals(expected, solution.addBinaryBitManipulation(a, b));
        assertEquals(expected, solution.addBinaryOptimized(a, b));
    }

    // ==================== Cross-Validation Tests ====================

    @Test
    @DisplayName("Cross-validation: All approaches produce identical results")
    void testCrossValidation() {
        String[] testA = {"11", "1010", "0", "1", "1111", "100", "10101", "0", "1111111111",
                "1010101010", "1", "1000000000"};
        String[] testB = {"1", "1011", "0", "1", "1111", "110010", "1010", "1", "1", "1010101010",
                "1111111111", "1000000000"};

        for (int i = 0; i < testA.length; i++) {
            String a = testA[i];
            String b = testB[i];

            String result1 = solution.addBinaryBuiltIn(a, b);
            String result2 = solution.addBinaryManual(a, b);
            String result3 = solution.addBinaryArray(a, b);
            String result4 = solution.addBinaryRecursive(a, b);
            String result5 = solution.addBinaryBitManipulation(a, b);
            String result6 = solution.addBinaryOptimized(a, b);

            assertEquals(result1, result2, "Built-in vs Manual mismatch for: " + a + " + " + b);
            assertEquals(result1, result3, "Built-in vs Array mismatch for: " + a + " + " + b);
            assertEquals(result1, result4, "Built-in vs Recursive mismatch for: " + a + " + " + b);
            assertEquals(result1, result5,
                    "Built-in vs Bit Manipulation mismatch for: " + a + " + " + b);
            assertEquals(result1, result6, "Built-in vs Optimized mismatch for: " + a + " + " + b);
        }
    }

    // ==================== Performance Tests ====================

    @Test
    @DisplayName("Performance test: Large binary strings")
    void testPerformanceLargeStrings() {
        // Create large binary strings
        StringBuilder sbA = new StringBuilder();
        StringBuilder sbB = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sbA.append(i % 2);
            sbB.append((i + 1) % 2);
        }
        String a = sbA.toString();
        String b = sbB.toString();

        long startTime, endTime;

        // Test Manual Addition (should be fastest)
        startTime = System.nanoTime();
        String result1 = solution.addBinaryManual(a, b);
        endTime = System.nanoTime();
        long time1 = endTime - startTime;

        // Test Optimized Manual
        startTime = System.nanoTime();
        String result2 = solution.addBinaryOptimized(a, b);
        endTime = System.nanoTime();
        long time2 = endTime - startTime;

        assertEquals(result1, result2);
        assertTrue(time1 > 0 && time2 > 0, "Performance test should complete successfully");
    }

    @Test
    @DisplayName("Performance test: Maximum carry propagation")
    void testPerformanceMaximumCarry() {
        // Create strings that will cause maximum carry propagation
        String a = "1".repeat(100);
        String b = "1".repeat(100);

        long startTime, endTime;

        // Test Manual Addition
        startTime = System.nanoTime();
        String result1 = solution.addBinaryManual(a, b);
        endTime = System.nanoTime();
        long time1 = endTime - startTime;

        // Test Array-based
        startTime = System.nanoTime();
        String result2 = solution.addBinaryArray(a, b);
        endTime = System.nanoTime();
        long time2 = endTime - startTime;

        assertEquals(result1, result2);
        assertTrue(time1 > 0 && time2 > 0, "Performance test should complete successfully");
    }

    // ==================== Stress Tests ====================

    @Test
    @DisplayName("Stress test: Maximum constraint sizes")
    void testStressTestMaximumConstraints() {
        // Test with maximum constraint sizes (10^4 characters)
        // Adding two numbers of all 1s: (2^10001 - 1) + (2^10001 - 1) = 2^10002 - 2
        // Pattern: n ones + n ones = (n-1) ones + "10"
        String a = "1".repeat(10000);
        String b = "1".repeat(10000);

        String result = solution.addBinaryManual(a, b);
        String expected = "1".repeat(9999) + "10";
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Stress test: Very different lengths")
    void testStressTestDifferentLengths() {
        String a = "1";
        String b = "1".repeat(1000);

        String result = solution.addBinaryManual(a, b);
        assertEquals("1" + "0".repeat(1000), result);
    }

    // ==================== Algorithm-Specific Tests ====================

    @Test
    @DisplayName("Built-in BigInteger: Test with very large numbers")
    void testBuiltInLargeNumbers() {
        String a = "11111111111111111111111111111111";
        String b = "1";

        String result = solution.addBinaryBuiltIn(a, b);
        assertTrue(result.length() > a.length(), "Result should be longer due to carry");
    }

    @Test
    @DisplayName("Recursive: Test with different length strings")
    void testRecursiveDifferentLengths() {
        String a = "101";
        String b = "11010";

        String result = solution.addBinaryRecursive(a, b);
        assertEquals("11111", result);
    }

    @Test
    @DisplayName("Bit Manipulation: Test with edge cases")
    void testBitManipulationEdgeCases() {
        String a = "0";
        String b = "0";

        String result = solution.addBinaryBitManipulation(a, b);
        assertEquals("0", result);
    }

    @Test
    @DisplayName("Array-based: Test with single digits")
    void testArrayBasedSingleDigits() {
        String a = "1";
        String b = "1";

        String result = solution.addBinaryArray(a, b);
        assertEquals("10", result);
    }

    @Test
    @DisplayName("Optimized: Test with zero operands")
    void testOptimizedZeroOperands() {
        String a = "0";
        String b = "1010";

        String result = solution.addBinaryOptimized(a, b);
        assertEquals("1010", result);
    }

    // ==================== Utility Tests ====================

    @Test
    @DisplayName("Utility test: Demonstrate all approaches")
    void testDemonstrateAllApproaches() {
        // This test ensures the demonstration method works without throwing exceptions
        assertDoesNotThrow(() -> {
            solution.demonstrateAllApproaches("11", "1");
            solution.demonstrateAllApproaches("1010", "1011");
            solution.demonstrateAllApproaches("0", "0");
        });
    }

    // ==================== Boundary Tests ====================

    @Test
    @DisplayName("Boundary test: Minimum valid inputs")
    void testBoundaryMinimumInputs() {
        String a = "0";
        String b = "0";
        String expected = "0";

        assertEquals(expected, solution.addBinaryBuiltIn(a, b));
        assertEquals(expected, solution.addBinaryManual(a, b));
        assertEquals(expected, solution.addBinaryArray(a, b));
        assertEquals(expected, solution.addBinaryRecursive(a, b));
        assertEquals(expected, solution.addBinaryBitManipulation(a, b));
        assertEquals(expected, solution.addBinaryOptimized(a, b));
    }

    @Test
    @DisplayName("Boundary test: Single character strings")
    void testBoundarySingleCharacters() {
        String a = "1";
        String b = "0";
        String expected = "1";

        assertEquals(expected, solution.addBinaryBuiltIn(a, b));
        assertEquals(expected, solution.addBinaryManual(a, b));
        assertEquals(expected, solution.addBinaryArray(a, b));
        assertEquals(expected, solution.addBinaryRecursive(a, b));
        assertEquals(expected, solution.addBinaryBitManipulation(a, b));
        assertEquals(expected, solution.addBinaryOptimized(a, b));
    }

    @Test
    @DisplayName("Boundary test: Maximum carry")
    void testBoundaryMaximumCarry() {
        String a = "1";
        String b = "1";
        String expected = "10";

        assertEquals(expected, solution.addBinaryBuiltIn(a, b));
        assertEquals(expected, solution.addBinaryManual(a, b));
        assertEquals(expected, solution.addBinaryArray(a, b));
        assertEquals(expected, solution.addBinaryRecursive(a, b));
        assertEquals(expected, solution.addBinaryBitManipulation(a, b));
        assertEquals(expected, solution.addBinaryOptimized(a, b));
    }

    // ==================== Special Pattern Tests ====================

    @Test
    @DisplayName("Special pattern: Powers of 2")
    void testPowersOfTwo() {
        String a = "1000"; // 8 in decimal
        String b = "1000"; // 8 in decimal
        String expected = "10000"; // 16 in decimal

        assertEquals(expected, solution.addBinaryBuiltIn(a, b));
        assertEquals(expected, solution.addBinaryManual(a, b));
        assertEquals(expected, solution.addBinaryArray(a, b));
        assertEquals(expected, solution.addBinaryRecursive(a, b));
        assertEquals(expected, solution.addBinaryBitManipulation(a, b));
        assertEquals(expected, solution.addBinaryOptimized(a, b));
    }

    @Test
    @DisplayName("Special pattern: Fibonacci-like sequence")
    void testFibonacciLikeSequence() {
        String a = "1"; // 1
        String b = "10"; // 2
        String expected = "11"; // 3

        assertEquals(expected, solution.addBinaryBuiltIn(a, b));
        assertEquals(expected, solution.addBinaryManual(a, b));
        assertEquals(expected, solution.addBinaryArray(a, b));
        assertEquals(expected, solution.addBinaryRecursive(a, b));
        assertEquals(expected, solution.addBinaryBitManipulation(a, b));
        assertEquals(expected, solution.addBinaryOptimized(a, b));
    }

    @Test
    @DisplayName("Special pattern: Palindrome addition")
    void testPalindromeAddition() {
        String a = "101";
        String b = "101";
        String expected = "1010";

        assertEquals(expected, solution.addBinaryBuiltIn(a, b));
        assertEquals(expected, solution.addBinaryManual(a, b));
        assertEquals(expected, solution.addBinaryArray(a, b));
        assertEquals(expected, solution.addBinaryRecursive(a, b));
        assertEquals(expected, solution.addBinaryBitManipulation(a, b));
        assertEquals(expected, solution.addBinaryOptimized(a, b));
    }
}
