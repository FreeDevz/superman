package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Comprehensive test suite for Happy Number problem Tests all seven different approaches with
 * various test cases
 */
@DisplayName("Happy Number Tests")
class HappyNumberTest {

    private HappyNumber solution;

    @BeforeEach
    void setUp() {
        solution = new HappyNumber();
    }

    @Nested
    @DisplayName("HashSet Approach Tests")
    class HashSetApproachTests {

        @Test
        @DisplayName("Basic happy number test")
        void testBasicHappyNumber() {
            assertTrue(solution.isHappy(19));
        }

        @Test
        @DisplayName("Basic non-happy number test")
        void testBasicNonHappyNumber() {
            assertFalse(solution.isHappy(2));
        }

        @Test
        @DisplayName("Number 1 is happy")
        void testNumberOne() {
            assertTrue(solution.isHappy(1));
        }

        @Test
        @DisplayName("Number 7 is happy")
        void testNumberSeven() {
            assertTrue(solution.isHappy(7));
        }

        @Test
        @DisplayName("Number 13 is happy")
        void testNumberThirteen() {
            assertTrue(solution.isHappy(13));
        }

        @Test
        @DisplayName("Number 23 is happy")
        void testNumberTwentyThree() {
            assertTrue(solution.isHappy(23));
        }

        @Test
        @DisplayName("Number 28 is happy")
        void testNumberTwentyEight() {
            assertTrue(solution.isHappy(28));
        }

        @Test
        @DisplayName("Number 31 is happy")
        void testNumberThirtyOne() {
            assertTrue(solution.isHappy(31));
        }

        @Test
        @DisplayName("Number 32 is happy")
        void testNumberThirtyTwo() {
            assertTrue(solution.isHappy(32));
        }

        @Test
        @DisplayName("Number 44 is happy")
        void testNumberFortyFour() {
            assertTrue(solution.isHappy(44));
        }

        @Test
        @DisplayName("Number 49 is happy")
        void testNumberFortyNine() {
            assertTrue(solution.isHappy(49));
        }

        @Test
        @DisplayName("Number 68 is happy")
        void testNumberSixtyEight() {
            assertTrue(solution.isHappy(68));
        }

        @Test
        @DisplayName("Number 70 is happy")
        void testNumberSeventy() {
            assertTrue(solution.isHappy(70));
        }

        @Test
        @DisplayName("Number 79 is happy")
        void testNumberSeventyNine() {
            assertTrue(solution.isHappy(79));
        }

        @Test
        @DisplayName("Number 82 is happy")
        void testNumberEightyTwo() {
            assertTrue(solution.isHappy(82));
        }

        @Test
        @DisplayName("Number 86 is happy")
        void testNumberEightySix() {
            assertTrue(solution.isHappy(86));
        }

        @Test
        @DisplayName("Number 91 is happy")
        void testNumberNinetyOne() {
            assertTrue(solution.isHappy(91));
        }

        @Test
        @DisplayName("Number 94 is happy")
        void testNumberNinetyFour() {
            assertTrue(solution.isHappy(94));
        }

        @Test
        @DisplayName("Number 97 is happy")
        void testNumberNinetySeven() {
            assertTrue(solution.isHappy(97));
        }

        @Test
        @DisplayName("Number 100 is happy")
        void testNumberOneHundred() {
            assertTrue(solution.isHappy(100));
        }
    }

    @Nested
    @DisplayName("Floyd's Cycle Detection Tests")
    class FloydCycleDetectionTests {

        @Test
        @DisplayName("Floyd's approach basic happy number")
        void testFloydBasicHappy() {
            assertTrue(solution.isHappyFloyd(19));
        }

        @Test
        @DisplayName("Floyd's approach basic non-happy number")
        void testFloydBasicNonHappy() {
            assertFalse(solution.isHappyFloyd(2));
        }

        @Test
        @DisplayName("Floyd's approach with number 1")
        void testFloydNumberOne() {
            assertTrue(solution.isHappyFloyd(1));
        }

        @Test
        @DisplayName("Floyd's approach with number 7")
        void testFloydNumberSeven() {
            assertTrue(solution.isHappyFloyd(7));
        }
    }

    @Nested
    @DisplayName("Mathematical Approach Tests")
    class MathematicalApproachTests {

        @Test
        @DisplayName("Math approach basic happy number")
        void testMathBasicHappy() {
            assertTrue(solution.isHappyMath(19));
        }

        @Test
        @DisplayName("Math approach basic non-happy number")
        void testMathBasicNonHappy() {
            assertFalse(solution.isHappyMath(2));
        }

        @Test
        @DisplayName("Math approach with number 1")
        void testMathNumberOne() {
            assertTrue(solution.isHappyMath(1));
        }

        @Test
        @DisplayName("Math approach with number 7")
        void testMathNumberSeven() {
            assertTrue(solution.isHappyMath(7));
        }

        @Test
        @DisplayName("Math approach with large number")
        void testMathLargeNumber() {
            assertTrue(solution.isHappyMath(1000));
        }
    }

    @Nested
    @DisplayName("Recursive Approach Tests")
    class RecursiveApproachTests {

        @Test
        @DisplayName("Recursive approach basic happy number")
        void testRecursiveBasicHappy() {
            assertTrue(solution.isHappyRecursive(19));
        }

        @Test
        @DisplayName("Recursive approach basic non-happy number")
        void testRecursiveBasicNonHappy() {
            assertFalse(solution.isHappyRecursive(2));
        }

        @Test
        @DisplayName("Recursive approach with number 1")
        void testRecursiveNumberOne() {
            assertTrue(solution.isHappyRecursive(1));
        }

        @Test
        @DisplayName("Recursive approach with number 7")
        void testRecursiveNumberSeven() {
            assertTrue(solution.isHappyRecursive(7));
        }
    }

    @Nested
    @DisplayName("Iterative Approach Tests")
    class IterativeApproachTests {

        @Test
        @DisplayName("Iterative approach basic happy number")
        void testIterativeBasicHappy() {
            assertTrue(solution.isHappyIterative(19));
        }

        @Test
        @DisplayName("Iterative approach basic non-happy number")
        void testIterativeBasicNonHappy() {
            assertFalse(solution.isHappyIterative(2));
        }

        @Test
        @DisplayName("Iterative approach with number 1")
        void testIterativeNumberOne() {
            assertTrue(solution.isHappyIterative(1));
        }

        @Test
        @DisplayName("Iterative approach with number 7")
        void testIterativeNumberSeven() {
            assertTrue(solution.isHappyIterative(7));
        }
    }

    @Nested
    @DisplayName("Bit Manipulation Approach Tests")
    class BitManipulationApproachTests {

        @Test
        @DisplayName("Bit manipulation approach basic happy number")
        void testBitManipulationBasicHappy() {
            assertTrue(solution.isHappyBitManipulation(19));
        }

        @Test
        @DisplayName("Bit manipulation approach basic non-happy number")
        void testBitManipulationBasicNonHappy() {
            assertFalse(solution.isHappyBitManipulation(2));
        }

        @Test
        @DisplayName("Bit manipulation approach with number 1")
        void testBitManipulationNumberOne() {
            assertTrue(solution.isHappyBitManipulation(1));
        }

        @Test
        @DisplayName("Bit manipulation approach with number 7")
        void testBitManipulationNumberSeven() {
            assertTrue(solution.isHappyBitManipulation(7));
        }
    }

    @Nested
    @DisplayName("String-based Approach Tests")
    class StringBasedApproachTests {

        @Test
        @DisplayName("String-based approach basic happy number")
        void testStringBasedBasicHappy() {
            assertTrue(solution.isHappyString(19));
        }

        @Test
        @DisplayName("String-based approach basic non-happy number")
        void testStringBasedBasicNonHappy() {
            assertFalse(solution.isHappyString(2));
        }

        @Test
        @DisplayName("String-based approach with number 1")
        void testStringBasedNumberOne() {
            assertTrue(solution.isHappyString(1));
        }

        @Test
        @DisplayName("String-based approach with number 7")
        void testStringBasedNumberSeven() {
            assertTrue(solution.isHappyString(7));
        }
    }

    @Nested
    @DisplayName("Cross-Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @Test
        @DisplayName("All approaches should produce same results")
        void testAllApproachesProduceSameResults() {
            int[] testCases =
                    {1, 2, 7, 13, 19, 23, 28, 31, 32, 44, 49, 68, 70, 79, 82, 86, 91, 94, 97, 100};

            for (int n : testCases) {
                boolean result1 = solution.isHappy(n);
                boolean result2 = solution.isHappyFloyd(n);
                boolean result3 = solution.isHappyMath(n);
                boolean result4 = solution.isHappyRecursive(n);
                boolean result5 = solution.isHappyIterative(n);
                boolean result6 = solution.isHappyBitManipulation(n);
                boolean result7 = solution.isHappyString(n);

                // All approaches should produce the same result
                assertEquals(result1, result2, "Floyd's differs from HashSet for " + n);
                assertEquals(result2, result3, "Math differs from Floyd's for " + n);
                assertEquals(result3, result4, "Recursive differs from Math for " + n);
                assertEquals(result4, result5, "Iterative differs from Recursive for " + n);
                assertEquals(result5, result6, "Bit Manipulation differs from Iterative for " + n);
                assertEquals(result6, result7,
                        "String-based differs from Bit Manipulation for " + n);
            }
        }
    }

    @Nested
    @DisplayName("Edge Case Tests")
    class EdgeCaseTests {

        @Test
        @DisplayName("Minimum input value")
        void testMinimumInput() {
            assertTrue(solution.isHappy(1));
        }

        @Test
        @DisplayName("Single digit happy numbers")
        void testSingleDigitHappyNumbers() {
            assertTrue(solution.isHappy(1));
            assertTrue(solution.isHappy(7));
        }

        @Test
        @DisplayName("Single digit non-happy numbers")
        void testSingleDigitNonHappyNumbers() {
            assertFalse(solution.isHappy(2));
            assertFalse(solution.isHappy(3));
            assertFalse(solution.isHappy(4));
            assertFalse(solution.isHappy(5));
            assertFalse(solution.isHappy(6));
            assertFalse(solution.isHappy(8));
            assertFalse(solution.isHappy(9));
        }

        @Test
        @DisplayName("Two digit happy numbers")
        void testTwoDigitHappyNumbers() {
            assertTrue(solution.isHappy(10));
            assertTrue(solution.isHappy(13));
            assertTrue(solution.isHappy(19));
            assertTrue(solution.isHappy(23));
            assertTrue(solution.isHappy(28));
            assertTrue(solution.isHappy(31));
            assertTrue(solution.isHappy(32));
            assertTrue(solution.isHappy(44));
            assertTrue(solution.isHappy(49));
            assertTrue(solution.isHappy(68));
            assertTrue(solution.isHappy(70));
            assertTrue(solution.isHappy(79));
            assertTrue(solution.isHappy(82));
            assertTrue(solution.isHappy(86));
            assertTrue(solution.isHappy(91));
            assertTrue(solution.isHappy(94));
            assertTrue(solution.isHappy(97));
        }

        @Test
        @DisplayName("Large numbers")
        void testLargeNumbers() {
            assertTrue(solution.isHappy(1000));
            assertTrue(solution.isHappy(10000));
            assertTrue(solution.isHappy(100000));
        }

        @Test
        @DisplayName("Numbers with zeros")
        void testNumbersWithZeros() {
            assertTrue(solution.isHappy(10));
            assertTrue(solution.isHappy(100));
            assertTrue(solution.isHappy(1000));
            assertTrue(solution.isHappy(10000));
        }

        @Test
        @DisplayName("Numbers with repeated digits")
        void testNumbersWithRepeatedDigits() {
            // Test some numbers with repeated digits
            assertFalse(solution.isHappy(11));
            assertTrue(solution.isHappy(44));
            assertFalse(solution.isHappy(77));
            assertFalse(solution.isHappy(88));
            assertFalse(solution.isHappy(99));
        }
    }

    @Nested
    @DisplayName("Utility Method Tests")
    class UtilityMethodTests {

        @Test
        @DisplayName("Test getDigits method")
        void testGetDigits() {
            assertArrayEquals(new int[] {1, 9}, solution.getDigits(19));
            assertArrayEquals(new int[] {1, 2, 3}, solution.getDigits(123));
            assertArrayEquals(new int[] {1}, solution.getDigits(1));
            assertArrayEquals(new int[] {1, 0, 0}, solution.getDigits(100));
        }

        @Test
        @DisplayName("Test isPerfectSquare method")
        void testIsPerfectSquare() {
            assertTrue(solution.isPerfectSquare(1));
            assertTrue(solution.isPerfectSquare(4));
            assertTrue(solution.isPerfectSquare(9));
            assertTrue(solution.isPerfectSquare(16));
            assertTrue(solution.isPerfectSquare(25));
            assertTrue(solution.isPerfectSquare(36));
            assertTrue(solution.isPerfectSquare(49));
            assertTrue(solution.isPerfectSquare(64));
            assertTrue(solution.isPerfectSquare(81));
            assertTrue(solution.isPerfectSquare(100));

            assertFalse(solution.isPerfectSquare(2));
            assertFalse(solution.isPerfectSquare(3));
            assertFalse(solution.isPerfectSquare(5));
            assertFalse(solution.isPerfectSquare(6));
            assertFalse(solution.isPerfectSquare(7));
            assertFalse(solution.isPerfectSquare(8));
            assertFalse(solution.isPerfectSquare(10));
            assertFalse(solution.isPerfectSquare(15));
            assertFalse(solution.isPerfectSquare(20));
            assertFalse(solution.isPerfectSquare(30));

            assertFalse(solution.isPerfectSquare(-1));
            assertFalse(solution.isPerfectSquare(-4));
            assertFalse(solution.isPerfectSquare(-9));
        }

        @Test
        @DisplayName("Test findNextHappyNumber method")
        void testFindNextHappyNumber() {
            assertEquals(1, solution.findNextHappyNumber(0));
            assertEquals(7, solution.findNextHappyNumber(6));
            assertEquals(10, solution.findNextHappyNumber(9));
            assertEquals(13, solution.findNextHappyNumber(12));
            assertEquals(19, solution.findNextHappyNumber(18));
            assertEquals(23, solution.findNextHappyNumber(22));
            assertEquals(28, solution.findNextHappyNumber(27));
            assertEquals(31, solution.findNextHappyNumber(30));
            assertEquals(32, solution.findNextHappyNumber(31));
            assertEquals(44, solution.findNextHappyNumber(43));
        }

        @Test
        @DisplayName("Test findHappyNumbersInRange method")
        void testFindHappyNumbersInRange() {
            int[] happyNumbers1to20 = solution.findHappyNumbersInRange(1, 20);
            int[] expected1to20 = {1, 7, 10, 13, 19};
            assertArrayEquals(expected1to20, happyNumbers1to20);

            int[] happyNumbers21to50 = solution.findHappyNumbersInRange(21, 50);
            int[] expected21to50 = {23, 28, 31, 32, 44, 49};
            assertArrayEquals(expected21to50, happyNumbers21to50);

            int[] happyNumbers51to100 = solution.findHappyNumbersInRange(51, 100);
            int[] expected51to100 = {68, 70, 79, 82, 86, 91, 94, 97, 100};
            assertArrayEquals(expected51to100, happyNumbers51to100);
        }

        @Test
        @DisplayName("Test getHappySequence method")
        void testGetHappySequence() {
            int[] sequence19 = solution.getHappySequence(19);
            int[] expected19 = {19, 82, 68, 100, 1};
            assertArrayEquals(expected19, sequence19);

            int[] sequence2 = solution.getHappySequence(2);
            int[] expected2 = {2, 4, 16, 37, 58, 89, 145, 42, 20, 4};
            assertArrayEquals(expected2, sequence2);

            int[] sequence1 = solution.getHappySequence(1);
            int[] expected1 = {1};
            assertArrayEquals(expected1, sequence1);

            int[] sequence7 = solution.getHappySequence(7);
            int[] expected7 = {7, 49, 97, 130, 10, 1};
            assertArrayEquals(expected7, sequence7);
        }

        @Test
        @DisplayName("Test countStepsToHappy method")
        void testCountStepsToHappy() {
            assertEquals(0, solution.countStepsToHappy(1));
            assertEquals(4, solution.countStepsToHappy(19));
            assertEquals(5, solution.countStepsToHappy(7));
            assertEquals(1, solution.countStepsToHappy(10));
            assertEquals(2, solution.countStepsToHappy(13));
            assertEquals(3, solution.countStepsToHappy(23));
            assertEquals(3, solution.countStepsToHappy(28));
            assertEquals(2, solution.countStepsToHappy(31));
            assertEquals(3, solution.countStepsToHappy(32));
            assertEquals(4, solution.countStepsToHappy(44));
            assertEquals(4, solution.countStepsToHappy(49));
            assertEquals(2, solution.countStepsToHappy(68));
            assertEquals(5, solution.countStepsToHappy(70));
            assertEquals(3, solution.countStepsToHappy(79));
            assertEquals(3, solution.countStepsToHappy(82));
            assertEquals(2, solution.countStepsToHappy(86));
            assertEquals(4, solution.countStepsToHappy(91));
            assertEquals(4, solution.countStepsToHappy(94));
            assertEquals(3, solution.countStepsToHappy(97));
            assertEquals(1, solution.countStepsToHappy(100));
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Performance comparison for various inputs")
        void testPerformanceComparison() {
            int[] testCases = {1, 2, 7, 13, 19, 23, 28, 31, 32, 44, 49, 68, 70, 79, 82, 86, 91, 94,
                    97, 100, 1000, 10000, 100000};

            for (int n : testCases) {
                long startTime, endTime;

                // Test HashSet approach
                startTime = System.nanoTime();
                boolean result1 = solution.isHappy(n);
                endTime = System.nanoTime();
                long hashSetTime = endTime - startTime;

                // Test Floyd's approach
                startTime = System.nanoTime();
                boolean result2 = solution.isHappyFloyd(n);
                endTime = System.nanoTime();
                long floydTime = endTime - startTime;

                // Test Math approach
                startTime = System.nanoTime();
                boolean result3 = solution.isHappyMath(n);
                endTime = System.nanoTime();
                long mathTime = endTime - startTime;

                // Test Recursive approach
                startTime = System.nanoTime();
                boolean result4 = solution.isHappyRecursive(n);
                endTime = System.nanoTime();
                long recursiveTime = endTime - startTime;

                // Test Iterative approach
                startTime = System.nanoTime();
                boolean result5 = solution.isHappyIterative(n);
                endTime = System.nanoTime();
                long iterativeTime = endTime - startTime;

                // Test Bit Manipulation approach
                startTime = System.nanoTime();
                boolean result6 = solution.isHappyBitManipulation(n);
                endTime = System.nanoTime();
                long bitManipulationTime = endTime - startTime;

                // Test String-based approach
                startTime = System.nanoTime();
                boolean result7 = solution.isHappyString(n);
                endTime = System.nanoTime();
                long stringTime = endTime - startTime;

                // All should produce same result
                assertEquals(result1, result2);
                assertEquals(result2, result3);
                assertEquals(result3, result4);
                assertEquals(result4, result5);
                assertEquals(result5, result6);
                assertEquals(result6, result7);

                System.out.printf(
                        "Input: %d, HashSet: %dns, Floyd: %dns, Math: %dns, Recursive: %dns, Iterative: %dns, BitManip: %dns, String: %dns%n",
                        n, hashSetTime, floydTime, mathTime, recursiveTime, iterativeTime,
                        bitManipulationTime, stringTime);
            }
        }
    }

    @Nested
    @DisplayName("Parameterized Tests")
    class ParameterizedTests {

        @ParameterizedTest
        @ValueSource(ints = {1, 7, 10, 13, 19, 23, 28, 31, 32, 44, 49, 68, 70, 79, 82, 86, 91, 94,
                97, 100})
        @DisplayName("Parameterized test for happy numbers")
        void testParameterizedHappyNumbers(int n) {
            assertTrue(solution.isHappy(n), "Number " + n + " should be happy");
        }

        @ParameterizedTest
        @ValueSource(ints = {2, 3, 4, 5, 6, 8, 9, 11, 12, 14, 15, 16, 17, 18, 20, 21, 22, 24, 25,
                26, 27, 29, 30, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 45, 46, 47, 48, 50, 51,
                52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 69, 71, 72, 73, 74,
                75, 76, 77, 78, 80, 81, 83, 84, 85, 87, 88, 89, 90, 92, 93, 95, 96, 98, 99})
        @DisplayName("Parameterized test for non-happy numbers")
        void testParameterizedNonHappyNumbers(int n) {
            assertFalse(solution.isHappy(n), "Number " + n + " should not be happy");
        }

        @ParameterizedTest
        @CsvSource({"19, true", "2, false", "7, true", "1, true", "13, true", "23, true",
                "28, true", "31, true", "32, true", "44, true", "49, true", "68, true", "70, true",
                "79, true", "82, true", "86, true", "91, true", "94, true", "97, true",
                "100, true"})
        @DisplayName("Parameterized test for various inputs")
        void testParameterized(String input, boolean expected) {
            int n = Integer.parseInt(input);
            boolean result = solution.isHappy(n);
            assertEquals(expected, result);
        }
    }
}
