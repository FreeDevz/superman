package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Comprehensive test suite for LeetCode #66: Plus One
 * 
 * This test suite validates all 6 algorithmic approaches with extensive test cases: - Basic
 * functionality tests - Edge case testing - Performance validation - Cross-validation between
 * approaches - Stress testing with large inputs
 * 
 * @author Superman
 * @version 1.0
 */
@DisplayName("Plus One Tests")
class PlusOneTest {

    private PlusOne solution;

    @BeforeEach
    void setUp() {
        solution = new PlusOne();
    }

    // ==================== Basic Functionality Tests ====================

    @Test
    @DisplayName("Basic test case: [1,2,3] -> [1,2,4]")
    void testBasicCase1() {
        int[] input = {1, 2, 3};
        int[] expected = {1, 2, 4};

        assertArrayEquals(expected, solution.plusOneSimple(input.clone()));
        assertArrayEquals(expected, solution.plusOneRecursive(input));
        assertArrayEquals(expected, solution.plusOneStringConversion(input));
        assertArrayEquals(expected, solution.plusOneMathematical(input));
        assertArrayEquals(expected, solution.plusOneTwoPass(input));
        assertArrayEquals(expected, solution.plusOneOptimized(input.clone()));
    }

    @Test
    @DisplayName("Basic test case: [4,3,2,1] -> [4,3,2,2]")
    void testBasicCase2() {
        int[] input = {4, 3, 2, 1};
        int[] expected = {4, 3, 2, 2};

        assertArrayEquals(expected, solution.plusOneSimple(input.clone()));
        assertArrayEquals(expected, solution.plusOneRecursive(input));
        assertArrayEquals(expected, solution.plusOneStringConversion(input));
        assertArrayEquals(expected, solution.plusOneMathematical(input));
        assertArrayEquals(expected, solution.plusOneTwoPass(input));
        assertArrayEquals(expected, solution.plusOneOptimized(input.clone()));
    }

    @Test
    @DisplayName("Basic test case: [9] -> [1,0]")
    void testBasicCaseSingleNine() {
        int[] input = {9};
        int[] expected = {1, 0};

        assertArrayEquals(expected, solution.plusOneSimple(input.clone()));
        assertArrayEquals(expected, solution.plusOneRecursive(input));
        assertArrayEquals(expected, solution.plusOneStringConversion(input));
        assertArrayEquals(expected, solution.plusOneMathematical(input));
        assertArrayEquals(expected, solution.plusOneTwoPass(input));
        assertArrayEquals(expected, solution.plusOneOptimized(input.clone()));
    }

    @Test
    @DisplayName("Basic test case: [0] -> [1]")
    void testBasicCaseZero() {
        int[] input = {0};
        int[] expected = {1};

        assertArrayEquals(expected, solution.plusOneSimple(input.clone()));
        assertArrayEquals(expected, solution.plusOneRecursive(input));
        assertArrayEquals(expected, solution.plusOneStringConversion(input));
        assertArrayEquals(expected, solution.plusOneMathematical(input));
        assertArrayEquals(expected, solution.plusOneTwoPass(input));
        assertArrayEquals(expected, solution.plusOneOptimized(input.clone()));
    }

    // ==================== Edge Case Tests ====================

    @Test
    @DisplayName("Edge case: null input")
    void testNullInput() {
        int[] expected = {1};

        assertArrayEquals(expected, solution.plusOneSimple(null));
        assertArrayEquals(expected, solution.plusOneRecursive(null));
        assertArrayEquals(expected, solution.plusOneStringConversion(null));
        assertArrayEquals(expected, solution.plusOneMathematical(null));
        assertArrayEquals(expected, solution.plusOneTwoPass(null));
        assertArrayEquals(expected, solution.plusOneOptimized(null));
    }

    @Test
    @DisplayName("Edge case: empty array")
    void testEmptyArray() {
        int[] input = {};
        int[] expected = {1};

        assertArrayEquals(expected, solution.plusOneSimple(input.clone()));
        assertArrayEquals(expected, solution.plusOneRecursive(input));
        assertArrayEquals(expected, solution.plusOneStringConversion(input));
        assertArrayEquals(expected, solution.plusOneMathematical(input));
        assertArrayEquals(expected, solution.plusOneTwoPass(input));
        assertArrayEquals(expected, solution.plusOneOptimized(input.clone()));
    }

    @Test
    @DisplayName("Edge case: single digit [1] -> [2]")
    void testSingleDigit() {
        int[] input = {1};
        int[] expected = {2};

        assertArrayEquals(expected, solution.plusOneSimple(input.clone()));
        assertArrayEquals(expected, solution.plusOneRecursive(input));
        assertArrayEquals(expected, solution.plusOneStringConversion(input));
        assertArrayEquals(expected, solution.plusOneMathematical(input));
        assertArrayEquals(expected, solution.plusOneTwoPass(input));
        assertArrayEquals(expected, solution.plusOneOptimized(input.clone()));
    }

    @Test
    @DisplayName("Edge case: all nines [9,9,9] -> [1,0,0,0]")
    void testAllNines() {
        int[] input = {9, 9, 9};
        int[] expected = {1, 0, 0, 0};

        assertArrayEquals(expected, solution.plusOneSimple(input.clone()));
        assertArrayEquals(expected, solution.plusOneRecursive(input));
        assertArrayEquals(expected, solution.plusOneStringConversion(input));
        assertArrayEquals(expected, solution.plusOneMathematical(input));
        assertArrayEquals(expected, solution.plusOneTwoPass(input));
        assertArrayEquals(expected, solution.plusOneOptimized(input.clone()));
    }

    @Test
    @DisplayName("Edge case: two nines [9,9] -> [1,0,0]")
    void testTwoNines() {
        int[] input = {9, 9};
        int[] expected = {1, 0, 0};

        assertArrayEquals(expected, solution.plusOneSimple(input.clone()));
        assertArrayEquals(expected, solution.plusOneRecursive(input));
        assertArrayEquals(expected, solution.plusOneStringConversion(input));
        assertArrayEquals(expected, solution.plusOneMathematical(input));
        assertArrayEquals(expected, solution.plusOneTwoPass(input));
        assertArrayEquals(expected, solution.plusOneOptimized(input.clone()));
    }

    // ==================== Complex Pattern Tests ====================

    @Test
    @DisplayName("Complex pattern: mixed digits [8,9,9] -> [9,0,0]")
    void testMixedDigits() {
        int[] input = {8, 9, 9};
        int[] expected = {9, 0, 0};

        assertArrayEquals(expected, solution.plusOneSimple(input.clone()));
        assertArrayEquals(expected, solution.plusOneRecursive(input));
        assertArrayEquals(expected, solution.plusOneStringConversion(input));
        assertArrayEquals(expected, solution.plusOneMathematical(input));
        assertArrayEquals(expected, solution.plusOneTwoPass(input));
        assertArrayEquals(expected, solution.plusOneOptimized(input.clone()));
    }

    @Test
    @DisplayName("Complex pattern: nine in middle [9,8,9] -> [9,9,0]")
    void testNineInMiddle() {
        int[] input = {9, 8, 9};
        int[] expected = {9, 9, 0};

        assertArrayEquals(expected, solution.plusOneSimple(input.clone()));
        assertArrayEquals(expected, solution.plusOneRecursive(input));
        assertArrayEquals(expected, solution.plusOneStringConversion(input));
        assertArrayEquals(expected, solution.plusOneMathematical(input));
        assertArrayEquals(expected, solution.plusOneTwoPass(input));
        assertArrayEquals(expected, solution.plusOneOptimized(input.clone()));
    }

    @Test
    @DisplayName("Complex pattern: one followed by nines [1,9,9] -> [2,0,0]")
    void testOneFollowedByNines() {
        int[] input = {1, 9, 9};
        int[] expected = {2, 0, 0};

        assertArrayEquals(expected, solution.plusOneSimple(input.clone()));
        assertArrayEquals(expected, solution.plusOneRecursive(input));
        assertArrayEquals(expected, solution.plusOneStringConversion(input));
        assertArrayEquals(expected, solution.plusOneMathematical(input));
        assertArrayEquals(expected, solution.plusOneTwoPass(input));
        assertArrayEquals(expected, solution.plusOneOptimized(input.clone()));
    }

    @Test
    @DisplayName("Complex pattern: large number [1,0,0,0] -> [1,0,0,1]")
    void testLargeNumber() {
        int[] input = {1, 0, 0, 0};
        int[] expected = {1, 0, 0, 1};

        assertArrayEquals(expected, solution.plusOneSimple(input.clone()));
        assertArrayEquals(expected, solution.plusOneRecursive(input));
        assertArrayEquals(expected, solution.plusOneStringConversion(input));
        assertArrayEquals(expected, solution.plusOneMathematical(input));
        assertArrayEquals(expected, solution.plusOneTwoPass(input));
        assertArrayEquals(expected, solution.plusOneOptimized(input.clone()));
    }

    // ==================== Parameterized Tests ====================

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Parameterized test cases")
    void testParameterizedCases(int[] input, int[] expected) {
        assertArrayEquals(expected, solution.plusOneSimple(input.clone()));
        assertArrayEquals(expected, solution.plusOneRecursive(input));
        assertArrayEquals(expected, solution.plusOneStringConversion(input));
        assertArrayEquals(expected, solution.plusOneMathematical(input));
        assertArrayEquals(expected, solution.plusOneTwoPass(input));
        assertArrayEquals(expected, solution.plusOneOptimized(input.clone()));
    }

    static Stream<Object[]> provideTestCases() {
        return Stream.of(new Object[] {new int[] {1, 2, 3}, new int[] {1, 2, 4}},
                new Object[] {new int[] {4, 3, 2, 1}, new int[] {4, 3, 2, 2}},
                new Object[] {new int[] {9}, new int[] {1, 0}},
                new Object[] {new int[] {9, 9}, new int[] {1, 0, 0}},
                new Object[] {new int[] {9, 9, 9}, new int[] {1, 0, 0, 0}},
                new Object[] {new int[] {1, 0, 0, 0}, new int[] {1, 0, 0, 1}},
                new Object[] {new int[] {0}, new int[] {1}},
                new Object[] {new int[] {1}, new int[] {2}},
                new Object[] {new int[] {8, 9, 9}, new int[] {9, 0, 0}},
                new Object[] {new int[] {9, 8, 9}, new int[] {9, 9, 0}},
                new Object[] {new int[] {1, 9, 9}, new int[] {2, 0, 0}},
                new Object[] {new int[] {9, 0, 9}, new int[] {9, 1, 0}},
                new Object[] {new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9},
                        new int[] {1, 2, 3, 4, 5, 6, 7, 9, 0}});
    }

    // ==================== Cross-Validation Tests ====================

    @Test
    @DisplayName("Cross-validation: All approaches produce identical results")
    void testCrossValidation() {
        int[][] testInputs = {{1, 2, 3}, {4, 3, 2, 1}, {9}, {9, 9}, {9, 9, 9}, {1, 0, 0, 0}, {0},
                {1}, {8, 9, 9}, {9, 8, 9}, {1, 9, 9}, {9, 0, 9}, {1, 2, 3, 4, 5, 6, 7, 8, 9}};

        for (int[] input : testInputs) {
            int[] result1 = solution.plusOneSimple(input.clone());
            int[] result2 = solution.plusOneRecursive(input);
            int[] result3 = solution.plusOneStringConversion(input);
            int[] result4 = solution.plusOneMathematical(input);
            int[] result5 = solution.plusOneTwoPass(input);
            int[] result6 = solution.plusOneOptimized(input.clone());

            assertArrayEquals(result1, result2, "Simple vs Recursive mismatch");
            assertArrayEquals(result1, result3, "Simple vs String Conversion mismatch");
            assertArrayEquals(result1, result4, "Simple vs Mathematical mismatch");
            assertArrayEquals(result1, result5, "Simple vs Two-Pass mismatch");
            assertArrayEquals(result1, result6, "Simple vs Optimized mismatch");
        }
    }

    // ==================== Performance Tests ====================

    @Test
    @DisplayName("Performance test: Large array with all nines")
    void testPerformanceAllNines() {
        // Create large array of all 9s
        int[] input = new int[1000];
        for (int i = 0; i < input.length; i++) {
            input[i] = 9;
        }

        long startTime, endTime;

        // Test Simple Iterative
        startTime = System.nanoTime();
        int[] result1 = solution.plusOneSimple(input.clone());
        endTime = System.nanoTime();
        long time1 = endTime - startTime;

        // Test Two-Pass
        startTime = System.nanoTime();
        int[] result2 = solution.plusOneTwoPass(input);
        endTime = System.nanoTime();
        long time2 = endTime - startTime;

        assertArrayEquals(result1, result2);
        assertTrue(time1 > 0 && time2 > 0, "Performance test should complete successfully");
    }

    @Test
    @DisplayName("Performance test: Large array with no nines")
    void testPerformanceNoNines() {
        // Create large array with no 9s
        int[] input = new int[1000];
        for (int i = 0; i < input.length; i++) {
            input[i] = i % 8; // 0-7, no 9s
        }

        long startTime, endTime;

        // Test Simple Iterative
        startTime = System.nanoTime();
        int[] result1 = solution.plusOneSimple(input.clone());
        endTime = System.nanoTime();
        long time1 = endTime - startTime;

        // Test Optimized In-Place
        startTime = System.nanoTime();
        int[] result2 = solution.plusOneOptimized(input.clone());
        endTime = System.nanoTime();
        long time2 = endTime - startTime;

        assertArrayEquals(result1, result2);
        assertTrue(time1 > 0 && time2 > 0, "Performance test should complete successfully");
    }

    // ==================== Stress Tests ====================

    @Test
    @DisplayName("Stress test: Maximum constraint size")
    void testStressTestMaximumConstraints() {
        // Test with maximum constraint size (100 digits)
        int[] input = new int[100];
        for (int i = 0; i < input.length; i++) {
            input[i] = 9;
        }

        int[] result = solution.plusOneSimple(input.clone());
        assertTrue(result.length == 101, "Result should have 101 digits");
        assertTrue(result[0] == 1, "First digit should be 1");
        for (int i = 1; i < result.length; i++) {
            assertTrue(result[i] == 0, "All other digits should be 0");
        }
    }

    @Test
    @DisplayName("Stress test: Very large number")
    void testStressTestVeryLargeNumber() {
        // Create a very large number
        int[] input = new int[50];
        for (int i = 0; i < input.length; i++) {
            input[i] = 8; // All 8s, so adding 1 will not cause carry
        }

        int[] result = solution.plusOneSimple(input.clone());
        assertTrue(result.length == 50, "Result should have same length");
        assertTrue(result[result.length - 1] == 9, "Last digit should be 9");
    }

    // ==================== Algorithm-Specific Tests ====================

    @Test
    @DisplayName("Recursive: Test with single digit")
    void testRecursiveSingleDigit() {
        int[] input = {5};
        int[] expected = {6};

        int[] result = solution.plusOneRecursive(input);
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("String Conversion: Test with large number")
    void testStringConversionLargeNumber() {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 9, 0};

        int[] result = solution.plusOneStringConversion(input);
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Mathematical: Test with carry propagation")
    void testMathematicalCarryPropagation() {
        int[] input = {1, 9, 9};
        int[] expected = {2, 0, 0};

        int[] result = solution.plusOneMathematical(input);
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Two-Pass: Test with mixed digits")
    void testTwoPassMixedDigits() {
        int[] input = {8, 9, 9};
        int[] expected = {9, 0, 0};

        int[] result = solution.plusOneTwoPass(input);
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Optimized In-Place: Test with no carry needed")
    void testOptimizedNoCarryNeeded() {
        int[] input = {1, 2, 3};
        int[] expected = {1, 2, 4};

        int[] result = solution.plusOneOptimized(input.clone());
        assertArrayEquals(expected, result);
    }

    // ==================== Utility Tests ====================

    @Test
    @DisplayName("Utility test: Demonstrate all approaches")
    void testDemonstrateAllApproaches() {
        // This test ensures the demonstration method works without throwing exceptions
        assertDoesNotThrow(() -> {
            solution.demonstrateAllApproaches(new int[] {1, 2, 3});
            solution.demonstrateAllApproaches(new int[] {9, 9, 9});
            solution.demonstrateAllApproaches(new int[] {0});
        });
    }

    // ==================== Boundary Tests ====================

    @Test
    @DisplayName("Boundary test: Minimum valid input")
    void testBoundaryMinimumInput() {
        int[] input = {0};
        int[] expected = {1};

        assertArrayEquals(expected, solution.plusOneSimple(input.clone()));
        assertArrayEquals(expected, solution.plusOneRecursive(input));
        assertArrayEquals(expected, solution.plusOneStringConversion(input));
        assertArrayEquals(expected, solution.plusOneMathematical(input));
        assertArrayEquals(expected, solution.plusOneTwoPass(input));
        assertArrayEquals(expected, solution.plusOneOptimized(input.clone()));
    }

    @Test
    @DisplayName("Boundary test: Single digit maximum")
    void testBoundarySingleDigitMaximum() {
        int[] input = {9};
        int[] expected = {1, 0};

        assertArrayEquals(expected, solution.plusOneSimple(input.clone()));
        assertArrayEquals(expected, solution.plusOneRecursive(input));
        assertArrayEquals(expected, solution.plusOneStringConversion(input));
        assertArrayEquals(expected, solution.plusOneMathematical(input));
        assertArrayEquals(expected, solution.plusOneTwoPass(input));
        assertArrayEquals(expected, solution.plusOneOptimized(input.clone()));
    }

    @Test
    @DisplayName("Boundary test: Two digits with carry")
    void testBoundaryTwoDigitsWithCarry() {
        int[] input = {9, 9};
        int[] expected = {1, 0, 0};

        assertArrayEquals(expected, solution.plusOneSimple(input.clone()));
        assertArrayEquals(expected, solution.plusOneRecursive(input));
        assertArrayEquals(expected, solution.plusOneStringConversion(input));
        assertArrayEquals(expected, solution.plusOneMathematical(input));
        assertArrayEquals(expected, solution.plusOneTwoPass(input));
        assertArrayEquals(expected, solution.plusOneOptimized(input.clone()));
    }

    // ==================== Special Pattern Tests ====================

    @Test
    @DisplayName("Special pattern: Powers of 10")
    void testPowersOfTen() {
        int[] input = {1, 0, 0, 0}; // 1000
        int[] expected = {1, 0, 0, 1}; // 1001

        assertArrayEquals(expected, solution.plusOneSimple(input.clone()));
        assertArrayEquals(expected, solution.plusOneRecursive(input));
        assertArrayEquals(expected, solution.plusOneStringConversion(input));
        assertArrayEquals(expected, solution.plusOneMathematical(input));
        assertArrayEquals(expected, solution.plusOneTwoPass(input));
        assertArrayEquals(expected, solution.plusOneOptimized(input.clone()));
    }

    @Test
    @DisplayName("Special pattern: Palindrome number")
    void testPalindromeNumber() {
        int[] input = {1, 2, 3, 2, 1};
        int[] expected = {1, 2, 3, 2, 2};

        assertArrayEquals(expected, solution.plusOneSimple(input.clone()));
        assertArrayEquals(expected, solution.plusOneRecursive(input));
        assertArrayEquals(expected, solution.plusOneStringConversion(input));
        assertArrayEquals(expected, solution.plusOneMathematical(input));
        assertArrayEquals(expected, solution.plusOneTwoPass(input));
        assertArrayEquals(expected, solution.plusOneOptimized(input.clone()));
    }

    @Test
    @DisplayName("Special pattern: Alternating digits")
    void testAlternatingDigits() {
        int[] input = {1, 9, 1, 9, 1};
        int[] expected = {1, 9, 1, 9, 2};

        assertArrayEquals(expected, solution.plusOneSimple(input.clone()));
        assertArrayEquals(expected, solution.plusOneRecursive(input));
        assertArrayEquals(expected, solution.plusOneStringConversion(input));
        assertArrayEquals(expected, solution.plusOneMathematical(input));
        assertArrayEquals(expected, solution.plusOneTwoPass(input));
        assertArrayEquals(expected, solution.plusOneOptimized(input.clone()));
    }
}
