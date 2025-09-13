package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Comprehensive test suite for BestTimeToBuyAndSellStock LeetCode problem
 * 
 * Tests all six different approaches: 1. One Pass (Optimal) 2. Brute Force 3. Dynamic Programming
 * 4. Peak Valley Analysis 5. Kadane's Algorithm 6. Divide and Conquer
 */
@DisplayName("Best Time to Buy and Sell Stock Tests")
class BestTimeToBuyAndSellStockTest {

    private BestTimeToBuyAndSellStock solution;

    @BeforeEach
    void setUp() {
        solution = new BestTimeToBuyAndSellStock();
    }

    @Nested
    @DisplayName("Basic Functionality Tests")
    class BasicFunctionalityTests {

        @Test
        @DisplayName("Single element array")
        void testSingleElement() {
            int[] prices = {1};
            int expected = 0;

            assertEquals(expected, solution.maxProfitOnePass(prices));
            assertEquals(expected, solution.maxProfitBruteForce(prices));
            assertEquals(expected, solution.maxProfitDynamicProgramming(prices));
            assertEquals(expected, solution.maxProfitPeakValley(prices));
            assertEquals(expected, solution.maxProfitKadane(prices));
            assertEquals(expected, solution.maxProfitDivideAndConquer(prices));
        }

        @Test
        @DisplayName("Two elements - increasing")
        void testTwoElementsIncreasing() {
            int[] prices = {1, 2};
            int expected = 1;

            assertEquals(expected, solution.maxProfitOnePass(prices));
            assertEquals(expected, solution.maxProfitBruteForce(prices));
            assertEquals(expected, solution.maxProfitDynamicProgramming(prices));
            assertEquals(expected, solution.maxProfitPeakValley(prices));
            assertEquals(expected, solution.maxProfitKadane(prices));
            assertEquals(expected, solution.maxProfitDivideAndConquer(prices));
        }

        @Test
        @DisplayName("Two elements - decreasing")
        void testTwoElementsDecreasing() {
            int[] prices = {2, 1};
            int expected = 0;

            assertEquals(expected, solution.maxProfitOnePass(prices));
            assertEquals(expected, solution.maxProfitBruteForce(prices));
            assertEquals(expected, solution.maxProfitDynamicProgramming(prices));
            assertEquals(expected, solution.maxProfitPeakValley(prices));
            assertEquals(expected, solution.maxProfitKadane(prices));
            assertEquals(expected, solution.maxProfitDivideAndConquer(prices));
        }

        @Test
        @DisplayName("Two elements - equal")
        void testTwoElementsEqual() {
            int[] prices = {5, 5};
            int expected = 0;

            assertEquals(expected, solution.maxProfitOnePass(prices));
            assertEquals(expected, solution.maxProfitBruteForce(prices));
            assertEquals(expected, solution.maxProfitDynamicProgramming(prices));
            assertEquals(expected, solution.maxProfitPeakValley(prices));
            assertEquals(expected, solution.maxProfitKadane(prices));
            assertEquals(expected, solution.maxProfitDivideAndConquer(prices));
        }
    }

    @Nested
    @DisplayName("LeetCode Example Tests")
    class LeetCodeExampleTests {

        @Test
        @DisplayName("LeetCode Example 1: [7,1,5,3,6,4]")
        void testLeetCodeExample1() {
            int[] prices = {7, 1, 5, 3, 6, 4};
            int expected = 5;

            assertEquals(expected, solution.maxProfitOnePass(prices));
            assertEquals(expected, solution.maxProfitBruteForce(prices));
            assertEquals(expected, solution.maxProfitDynamicProgramming(prices));
            assertEquals(expected, solution.maxProfitPeakValley(prices));
            assertEquals(expected, solution.maxProfitKadane(prices));
            assertEquals(expected, solution.maxProfitDivideAndConquer(prices));
        }

        @Test
        @DisplayName("LeetCode Example 2: [7,6,4,3,1]")
        void testLeetCodeExample2() {
            int[] prices = {7, 6, 4, 3, 1};
            int expected = 0;

            assertEquals(expected, solution.maxProfitOnePass(prices));
            assertEquals(expected, solution.maxProfitBruteForce(prices));
            assertEquals(expected, solution.maxProfitDynamicProgramming(prices));
            assertEquals(expected, solution.maxProfitPeakValley(prices));
            assertEquals(expected, solution.maxProfitKadane(prices));
            assertEquals(expected, solution.maxProfitDivideAndConquer(prices));
        }
    }

    @Nested
    @DisplayName("Edge Cases and Boundary Tests")
    class EdgeCasesAndBoundaryTests {

        @Test
        @DisplayName("Null array")
        void testNullArray() {
            int[] prices = null;
            int expected = 0;

            assertEquals(expected, solution.maxProfitOnePass(prices));
            assertEquals(expected, solution.maxProfitBruteForce(prices));
            assertEquals(expected, solution.maxProfitDynamicProgramming(prices));
            assertEquals(expected, solution.maxProfitPeakValley(prices));
            assertEquals(expected, solution.maxProfitKadane(prices));
            assertEquals(expected, solution.maxProfitDivideAndConquer(prices));
        }

        @Test
        @DisplayName("Empty array")
        void testEmptyArray() {
            int[] prices = {};
            int expected = 0;

            assertEquals(expected, solution.maxProfitOnePass(prices));
            assertEquals(expected, solution.maxProfitBruteForce(prices));
            assertEquals(expected, solution.maxProfitDynamicProgramming(prices));
            assertEquals(expected, solution.maxProfitPeakValley(prices));
            assertEquals(expected, solution.maxProfitKadane(prices));
            assertEquals(expected, solution.maxProfitDivideAndConquer(prices));
        }

        @Test
        @DisplayName("All same prices")
        void testAllSamePrices() {
            int[] prices = {5, 5, 5, 5, 5};
            int expected = 0;

            assertEquals(expected, solution.maxProfitOnePass(prices));
            assertEquals(expected, solution.maxProfitBruteForce(prices));
            assertEquals(expected, solution.maxProfitDynamicProgramming(prices));
            assertEquals(expected, solution.maxProfitPeakValley(prices));
            assertEquals(expected, solution.maxProfitKadane(prices));
            assertEquals(expected, solution.maxProfitDivideAndConquer(prices));
        }

        @Test
        @DisplayName("Strictly increasing prices")
        void testStrictlyIncreasing() {
            int[] prices = {1, 2, 3, 4, 5};
            int expected = 4;

            assertEquals(expected, solution.maxProfitOnePass(prices));
            assertEquals(expected, solution.maxProfitBruteForce(prices));
            assertEquals(expected, solution.maxProfitDynamicProgramming(prices));
            assertEquals(expected, solution.maxProfitPeakValley(prices));
            assertEquals(expected, solution.maxProfitKadane(prices));
            assertEquals(expected, solution.maxProfitDivideAndConquer(prices));
        }

        @Test
        @DisplayName("Strictly decreasing prices")
        void testStrictlyDecreasing() {
            int[] prices = {5, 4, 3, 2, 1};
            int expected = 0;

            assertEquals(expected, solution.maxProfitOnePass(prices));
            assertEquals(expected, solution.maxProfitBruteForce(prices));
            assertEquals(expected, solution.maxProfitDynamicProgramming(prices));
            assertEquals(expected, solution.maxProfitPeakValley(prices));
            assertEquals(expected, solution.maxProfitKadane(prices));
            assertEquals(expected, solution.maxProfitDivideAndConquer(prices));
        }

        @Test
        @DisplayName("Maximum constraint test")
        void testMaximumConstraint() {
            // Create array with maximum allowed length (10^5)
            int[] prices = new int[1000]; // Using 1000 for practical testing
            for (int i = 0; i < prices.length; i++) {
                prices[i] = (i % 2 == 0) ? 1 : 10000; // Alternating min and max values
            }

            int result = solution.maxProfitOnePass(prices);
            assertTrue(result >= 0, "Result should be non-negative");
            assertTrue(result <= 9999, "Result should not exceed maximum possible profit");
        }
    }

    @Nested
    @DisplayName("Parameterized Tests")
    class ParameterizedTests {

        @ParameterizedTest
        @MethodSource("provideTestCases")
        @DisplayName("All approaches with various test cases")
        void testAllApproaches(int[] prices, int expected) {
            assertEquals(expected, solution.maxProfitOnePass(prices),
                    "One Pass failed for: " + Arrays.toString(prices));
            assertEquals(expected, solution.maxProfitBruteForce(prices),
                    "Brute Force failed for: " + Arrays.toString(prices));
            assertEquals(expected, solution.maxProfitDynamicProgramming(prices),
                    "Dynamic Programming failed for: " + Arrays.toString(prices));
            assertEquals(expected, solution.maxProfitPeakValley(prices),
                    "Peak Valley failed for: " + Arrays.toString(prices));
            assertEquals(expected, solution.maxProfitKadane(prices),
                    "Kadane's failed for: " + Arrays.toString(prices));
            assertEquals(expected, solution.maxProfitDivideAndConquer(prices),
                    "Divide & Conquer failed for: " + Arrays.toString(prices));
        }

        static Stream<Arguments> provideTestCases() {
            return Stream.of(Arguments.of(new int[] {1}, 0), Arguments.of(new int[] {1, 2}, 1),
                    Arguments.of(new int[] {2, 1}, 0), Arguments.of(new int[] {2, 4, 1}, 2),
                    Arguments.of(new int[] {1, 2, 3, 4, 5}, 4),
                    Arguments.of(new int[] {5, 4, 3, 2, 1}, 0),
                    Arguments.of(new int[] {3, 3, 5, 0, 0, 3, 1, 4}, 4),
                    Arguments.of(new int[] {1, 2, 4, 2, 5, 7, 2, 4, 9, 0}, 8),
                    Arguments.of(new int[] {2, 1, 2, 0, 1}, 1),
                    Arguments.of(new int[] {6, 1, 3, 2, 4, 7}, 6),
                    Arguments.of(new int[] {7, 1, 5, 3, 6, 4}, 5),
                    Arguments.of(new int[] {7, 6, 4, 3, 1}, 0));
        }

        @ParameterizedTest
        @ValueSource(ints = {2, 3, 4, 5, 6, 7, 8, 9, 10, 15, 20, 25, 50, 100})
        @DisplayName("Random test cases with various lengths")
        void testRandomCases(int length) {
            Random random = new Random(42); // Fixed seed for reproducibility
            int[] prices = new int[length];

            // Generate random prices between 0 and 10000
            for (int i = 0; i < length; i++) {
                prices[i] = random.nextInt(10001);
            }

            int onePassResult = solution.maxProfitOnePass(prices);
            int bruteForceResult = solution.maxProfitBruteForce(prices);
            int dynamicProgrammingResult = solution.maxProfitDynamicProgramming(prices);
            int peakValleyResult = solution.maxProfitPeakValley(prices);
            int kadaneResult = solution.maxProfitKadane(prices);
            int divideConquerResult = solution.maxProfitDivideAndConquer(prices);

            assertEquals(bruteForceResult, onePassResult,
                    "One Pass should match Brute Force for length " + length);
            assertEquals(bruteForceResult, dynamicProgrammingResult,
                    "Dynamic Programming should match Brute Force for length " + length);
            assertEquals(bruteForceResult, peakValleyResult,
                    "Peak Valley should match Brute Force for length " + length);
            assertEquals(bruteForceResult, kadaneResult,
                    "Kadane's should match Brute Force for length " + length);
            assertEquals(bruteForceResult, divideConquerResult,
                    "Divide & Conquer should match Brute Force for length " + length);
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Large array performance test")
        void testLargeArrayPerformance() {
            int[] prices = generateLargeArray(1000);
            int expected = solution.maxProfitBruteForce(prices);

            // Test all approaches
            long startTime, endTime;

            startTime = System.nanoTime();
            int result1 = solution.maxProfitOnePass(prices);
            endTime = System.nanoTime();
            System.out.println("One Pass time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertEquals(expected, result1);

            startTime = System.nanoTime();
            int result3 = solution.maxProfitDynamicProgramming(prices);
            endTime = System.nanoTime();
            System.out.println(
                    "Dynamic Programming time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertEquals(expected, result3);

            startTime = System.nanoTime();
            int result4 = solution.maxProfitPeakValley(prices);
            endTime = System.nanoTime();
            System.out.println("Peak Valley time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertEquals(expected, result4);

            startTime = System.nanoTime();
            int result5 = solution.maxProfitKadane(prices);
            endTime = System.nanoTime();
            System.out.println("Kadane's time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertEquals(expected, result5);

            startTime = System.nanoTime();
            int result6 = solution.maxProfitDivideAndConquer(prices);
            endTime = System.nanoTime();
            System.out
                    .println("Divide & Conquer time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertEquals(expected, result6);
        }

        @Test
        @DisplayName("Maximum constraint performance test")
        void testMaximumConstraintPerformance() {
            int[] prices = generateLargeArray(10000);

            // Test all approaches
            long startTime, endTime;

            startTime = System.nanoTime();
            int result1 = solution.maxProfitOnePass(prices);
            endTime = System.nanoTime();
            System.out.println("One Pass time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertTrue(result1 >= 0);

            startTime = System.nanoTime();
            int result3 = solution.maxProfitDynamicProgramming(prices);
            endTime = System.nanoTime();
            System.out.println(
                    "Dynamic Programming time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertTrue(result3 >= 0);

            startTime = System.nanoTime();
            int result4 = solution.maxProfitPeakValley(prices);
            endTime = System.nanoTime();
            System.out.println("Peak Valley time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertTrue(result4 >= 0);

            startTime = System.nanoTime();
            int result5 = solution.maxProfitKadane(prices);
            endTime = System.nanoTime();
            System.out.println("Kadane's time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertTrue(result5 >= 0);

            startTime = System.nanoTime();
            int result6 = solution.maxProfitDivideAndConquer(prices);
            endTime = System.nanoTime();
            System.out
                    .println("Divide & Conquer time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertTrue(result6 >= 0);
        }

        private int[] generateLargeArray(int size) {
            int[] prices = new int[size];
            Random random = new Random(42);
            for (int i = 0; i < size; i++) {
                prices[i] = random.nextInt(10001);
            }
            return prices;
        }
    }

    @Nested
    @DisplayName("Validation Tests")
    class ValidationTests {

        @Test
        @DisplayName("Verify all approaches return same result")
        void testAllApproachesConsistency() {
            int[][] testCases = {{1}, {1, 2}, {2, 1}, {2, 4, 1}, {1, 2, 3, 4, 5}, {5, 4, 3, 2, 1},
                    {3, 3, 5, 0, 0, 3, 1, 4}, {1, 2, 4, 2, 5, 7, 2, 4, 9, 0}, {2, 1, 2, 0, 1},
                    {6, 1, 3, 2, 4, 7}, {7, 1, 5, 3, 6, 4}, {7, 6, 4, 3, 1}};

            for (int[] prices : testCases) {
                int onePassResult = solution.maxProfitOnePass(prices);
                int bruteForceResult = solution.maxProfitBruteForce(prices);
                int dynamicProgrammingResult = solution.maxProfitDynamicProgramming(prices);
                int peakValleyResult = solution.maxProfitPeakValley(prices);
                int kadaneResult = solution.maxProfitKadane(prices);
                int divideConquerResult = solution.maxProfitDivideAndConquer(prices);

                assertEquals(bruteForceResult, onePassResult,
                        "One Pass and Brute Force should match for: " + Arrays.toString(prices));
                assertEquals(bruteForceResult, dynamicProgrammingResult,
                        "Brute Force and Dynamic Programming should match for: "
                                + Arrays.toString(prices));
                assertEquals(bruteForceResult, peakValleyResult,
                        "Brute Force and Peak Valley should match for: " + Arrays.toString(prices));
                assertEquals(bruteForceResult, kadaneResult,
                        "Brute Force and Kadane's should match for: " + Arrays.toString(prices));
                assertEquals(bruteForceResult, divideConquerResult,
                        "Brute Force and Divide & Conquer should match for: "
                                + Arrays.toString(prices));
            }
        }

        @Test
        @DisplayName("Verify profit calculation utility")
        void testProfitCalculation() {
            int[] prices = {7, 1, 5, 3, 6, 4};

            // Test valid transactions
            assertEquals(5, solution.calculateProfit(prices, 1, 4)); // Buy at 1, sell at 6
            assertEquals(4, solution.calculateProfit(prices, 1, 2)); // Buy at 1, sell at 5
            assertEquals(3, solution.calculateProfit(prices, 3, 4)); // Buy at 3, sell at 6

            // Test invalid transactions
            assertEquals(0, solution.calculateProfit(prices, -1, 2)); // Invalid buy day
            assertEquals(0, solution.calculateProfit(prices, 1, 6)); // Invalid sell day
            assertEquals(0, solution.calculateProfit(prices, 2, 1)); // Sell before buy
            assertEquals(0, solution.calculateProfit(prices, 1, 1)); // Same day
        }

        @Test
        @DisplayName("Verify transaction validation utility")
        void testTransactionValidation() {
            int[] prices = {7, 1, 5, 3, 6, 4};

            // Test valid transactions
            assertTrue(solution.isValidTransaction(prices, 1, 4));
            assertTrue(solution.isValidTransaction(prices, 0, 5));
            assertTrue(solution.isValidTransaction(prices, 2, 3));

            // Test invalid transactions
            assertTrue(!solution.isValidTransaction(prices, -1, 2));
            assertTrue(!solution.isValidTransaction(prices, 1, 6));
            assertTrue(!solution.isValidTransaction(prices, 2, 1));
            assertTrue(!solution.isValidTransaction(prices, 1, 1));
            assertTrue(!solution.isValidTransaction(null, 1, 2));
        }

        @Test
        @DisplayName("Verify best transaction finder")
        void testBestTransactionFinder() {
            int[] prices = {7, 1, 5, 3, 6, 4};
            int[] transaction = solution.findBestTransaction(prices);

            assertEquals(3, transaction.length); // Should return [buyDay, sellDay, profit]
            assertEquals(1, transaction[0]); // Buy day
            assertEquals(4, transaction[1]); // Sell day
            assertEquals(5, transaction[2]); // Profit

            // Verify the transaction is valid
            assertTrue(solution.isValidTransaction(prices, transaction[0], transaction[1]));
            assertEquals(transaction[2],
                    solution.calculateProfit(prices, transaction[0], transaction[1]));
        }

        @Test
        @DisplayName("Test no profit scenario")
        void testNoProfitScenario() {
            int[] prices = {7, 6, 4, 3, 1};
            int[] transaction = solution.findBestTransaction(prices);

            assertEquals(3, transaction.length);
            assertEquals(-1, transaction[0]); // No buy day
            assertEquals(-1, transaction[1]); // No sell day
            assertEquals(0, transaction[2]); // No profit
        }
    }

    @Nested
    @DisplayName("Cross Validation Tests")
    class CrossValidationTests {

        @Test
        @DisplayName("Random test cases with cross validation")
        void testRandomCasesWithCrossValidation() {
            Random random = new Random(123);
            for (int test = 0; test < 50; test++) {
                int length = random.nextInt(20) + 1; // Length between 1 and 20
                int[] prices = new int[length];

                // Generate random prices
                for (int i = 0; i < length; i++) {
                    prices[i] = random.nextInt(100) + 1; // Prices between 1 and 100
                }

                int onePassResult = solution.maxProfitOnePass(prices);
                int bruteForceResult = solution.maxProfitBruteForce(prices);
                int dynamicProgrammingResult = solution.maxProfitDynamicProgramming(prices);
                int peakValleyResult = solution.maxProfitPeakValley(prices);
                int kadaneResult = solution.maxProfitKadane(prices);
                int divideConquerResult = solution.maxProfitDivideAndConquer(prices);

                assertEquals(bruteForceResult, onePassResult,
                        "One Pass failed for test case " + test + ": " + Arrays.toString(prices));
                assertEquals(bruteForceResult, dynamicProgrammingResult,
                        "Dynamic Programming failed for test case " + test + ": "
                                + Arrays.toString(prices));
                assertEquals(bruteForceResult, peakValleyResult, "Peak Valley failed for test case "
                        + test + ": " + Arrays.toString(prices));
                assertEquals(bruteForceResult, kadaneResult,
                        "Kadane's failed for test case " + test + ": " + Arrays.toString(prices));
                assertEquals(bruteForceResult, divideConquerResult,
                        "Divide & Conquer failed for test case " + test + ": "
                                + Arrays.toString(prices));
            }
        }
    }

    @Nested
    @DisplayName("Comprehensive Integration Tests")
    class ComprehensiveIntegrationTests {

        @Test
        @DisplayName("Stress test with maximum constraints")
        void testStressTestWithMaxConstraints() {
            // Test with array size close to maximum constraint
            int[] prices = new int[1000];
            Random random = new Random(456);

            // Create a scenario with potential profit
            for (int i = 0; i < prices.length; i++) {
                prices[i] = random.nextInt(10000) + 1;
            }

            int result = solution.maxProfitOnePass(prices);

            // Verify basic properties
            assertTrue(result >= 0, "Result should be non-negative");
            assertTrue(result <= 9999, "Result should not exceed maximum possible profit");

            // Verify against other approaches
            int bruteForceResult = solution.maxProfitBruteForce(prices);
            assertEquals(bruteForceResult, result, "One Pass should match Brute Force");

            // Verify transaction details
            int[] transaction = solution.findBestTransaction(prices);
            if (result > 0) {
                assertTrue(transaction[0] >= 0 && transaction[0] < prices.length,
                        "Buy day should be valid");
                assertTrue(transaction[1] >= 0 && transaction[1] < prices.length,
                        "Sell day should be valid");
                assertTrue(transaction[0] < transaction[1], "Buy day should be before sell day");
                assertEquals(result, transaction[2], "Transaction profit should match result");
            }
        }

        @Test
        @DisplayName("Test with very large price differences")
        void testVeryLargePriceDifferences() {
            int[] prices = {1, 10000, 1, 10000, 1};
            int result = solution.maxProfitOnePass(prices);

            assertTrue(result >= 0, "Result should be non-negative");
            assertEquals(9999, result, "Should achieve maximum profit of 9999");

            // Verify transaction details
            int[] transaction = solution.findBestTransaction(prices);
            assertEquals(9999, transaction[2], "Transaction should yield maximum profit");
        }

        @Test
        @DisplayName("Test with alternating high-low prices")
        void testAlternatingHighLowPrices() {
            int[] prices = {100, 1, 100, 1, 100, 1};
            int result = solution.maxProfitOnePass(prices);

            assertTrue(result >= 0, "Result should be non-negative");
            assertEquals(99, result, "Should achieve profit of 99");

            // Verify transaction details
            int[] transaction = solution.findBestTransaction(prices);
            assertEquals(99, transaction[2], "Transaction should yield profit of 99");
        }
    }
}
