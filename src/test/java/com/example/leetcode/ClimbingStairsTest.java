package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Test class for ClimbingStairs solution
 * 
 * Tests all approaches with comprehensive test cases including edge cases, boundary conditions, and
 * performance scenarios.
 * 
 * @author Superman
 * @version 1.0
 */
@DisplayName("Climbing Stairs Tests")
class ClimbingStairsTest {

    private ClimbingStairs solution;

    @BeforeEach
    void setUp() {
        solution = new ClimbingStairs();
    }

    @Nested
    @DisplayName("Dynamic Programming (Bottom-up) Tests")
    class DynamicProgrammingBottomUpTests {

        @Test
        @DisplayName("Test case 1: n = 1")
        void testClimbStairs_N1() {
            assertEquals(1, solution.climbStairs(1));
        }

        @Test
        @DisplayName("Test case 2: n = 2")
        void testClimbStairs_N2() {
            assertEquals(2, solution.climbStairs(2));
        }

        @Test
        @DisplayName("Test case 3: n = 3")
        void testClimbStairs_N3() {
            assertEquals(3, solution.climbStairs(3));
        }

        @Test
        @DisplayName("Test case 4: n = 4")
        void testClimbStairs_N4() {
            assertEquals(5, solution.climbStairs(4));
        }

        @Test
        @DisplayName("Test case 5: n = 5")
        void testClimbStairs_N5() {
            assertEquals(8, solution.climbStairs(5));
        }

        @Test
        @DisplayName("Test case 6: n = 10")
        void testClimbStairs_N10() {
            assertEquals(89, solution.climbStairs(10));
        }

        @Test
        @DisplayName("Test case 7: n = 20")
        void testClimbStairs_N20() {
            assertEquals(10946, solution.climbStairs(20));
        }

        @Test
        @DisplayName("Test case 8: n = 30")
        void testClimbStairs_N30() {
            assertEquals(1346269, solution.climbStairs(30));
        }

        @Test
        @DisplayName("Test case 9: n = 45 (maximum constraint)")
        void testClimbStairs_N45() {
            assertEquals(1836311903, solution.climbStairs(45));
        }
    }

    @Nested
    @DisplayName("Dynamic Programming (Memoization) Tests")
    class DynamicProgrammingMemoizationTests {

        @Test
        @DisplayName("Test case 1: n = 1")
        void testClimbStairsMemoization_N1() {
            assertEquals(1, solution.climbStairsMemoization(1));
        }

        @Test
        @DisplayName("Test case 2: n = 2")
        void testClimbStairsMemoization_N2() {
            assertEquals(2, solution.climbStairsMemoization(2));
        }

        @Test
        @DisplayName("Test case 3: n = 3")
        void testClimbStairsMemoization_N3() {
            assertEquals(3, solution.climbStairsMemoization(3));
        }

        @Test
        @DisplayName("Test case 4: n = 4")
        void testClimbStairsMemoization_N4() {
            assertEquals(5, solution.climbStairsMemoization(4));
        }

        @Test
        @DisplayName("Test case 5: n = 5")
        void testClimbStairsMemoization_N5() {
            assertEquals(8, solution.climbStairsMemoization(5));
        }

        @Test
        @DisplayName("Test case 6: n = 10")
        void testClimbStairsMemoization_N10() {
            assertEquals(89, solution.climbStairsMemoization(10));
        }

        @Test
        @DisplayName("Test case 7: n = 20")
        void testClimbStairsMemoization_N20() {
            assertEquals(10946, solution.climbStairsMemoization(20));
        }

        @Test
        @DisplayName("Test case 8: n = 30")
        void testClimbStairsMemoization_N30() {
            assertEquals(1346269, solution.climbStairsMemoization(30));
        }

        @Test
        @DisplayName("Test case 9: n = 45 (maximum constraint)")
        void testClimbStairsMemoization_N45() {
            assertEquals(1836311903, solution.climbStairsMemoization(45));
        }
    }

    @Nested
    @DisplayName("Recursive Solution Tests")
    class RecursiveSolutionTests {

        @Test
        @DisplayName("Test case 1: n = 1")
        void testClimbStairsRecursive_N1() {
            assertEquals(1, solution.climbStairsRecursive(1));
        }

        @Test
        @DisplayName("Test case 2: n = 2")
        void testClimbStairsRecursive_N2() {
            assertEquals(2, solution.climbStairsRecursive(2));
        }

        @Test
        @DisplayName("Test case 3: n = 3")
        void testClimbStairsRecursive_N3() {
            assertEquals(3, solution.climbStairsRecursive(3));
        }

        @Test
        @DisplayName("Test case 4: n = 4")
        void testClimbStairsRecursive_N4() {
            assertEquals(5, solution.climbStairsRecursive(4));
        }

        @Test
        @DisplayName("Test case 5: n = 5")
        void testClimbStairsRecursive_N5() {
            assertEquals(8, solution.climbStairsRecursive(5));
        }

        @Test
        @DisplayName("Test case 6: n = 10")
        void testClimbStairsRecursive_N10() {
            assertEquals(89, solution.climbStairsRecursive(10));
        }

        @Test
        @DisplayName("Test case 7: n = 20 (performance limit)")
        void testClimbStairsRecursive_N20() {
            assertEquals(10946, solution.climbStairsRecursive(20));
        }
    }

    @Nested
    @DisplayName("Matrix Exponentiation Tests")
    class MatrixExponentiationTests {

        @Test
        @DisplayName("Test case 1: n = 1")
        void testClimbStairsMatrix_N1() {
            assertEquals(1, solution.climbStairsMatrix(1));
        }

        @Test
        @DisplayName("Test case 2: n = 2")
        void testClimbStairsMatrix_N2() {
            assertEquals(2, solution.climbStairsMatrix(2));
        }

        @Test
        @DisplayName("Test case 3: n = 3")
        void testClimbStairsMatrix_N3() {
            assertEquals(3, solution.climbStairsMatrix(3));
        }

        @Test
        @DisplayName("Test case 4: n = 4")
        void testClimbStairsMatrix_N4() {
            assertEquals(5, solution.climbStairsMatrix(4));
        }

        @Test
        @DisplayName("Test case 5: n = 5")
        void testClimbStairsMatrix_N5() {
            assertEquals(8, solution.climbStairsMatrix(5));
        }

        @Test
        @DisplayName("Test case 6: n = 10")
        void testClimbStairsMatrix_N10() {
            assertEquals(89, solution.climbStairsMatrix(10));
        }

        @Test
        @DisplayName("Test case 7: n = 20")
        void testClimbStairsMatrix_N20() {
            assertEquals(10946, solution.climbStairsMatrix(20));
        }

        @Test
        @DisplayName("Test case 8: n = 30")
        void testClimbStairsMatrix_N30() {
            assertEquals(1346269, solution.climbStairsMatrix(30));
        }

        @Test
        @DisplayName("Test case 9: n = 45 (maximum constraint)")
        void testClimbStairsMatrix_N45() {
            assertEquals(1836311903, solution.climbStairsMatrix(45));
        }
    }

    @Nested
    @DisplayName("Fibonacci Formula Tests")
    class FibonacciFormulaTests {

        @Test
        @DisplayName("Test case 1: n = 1")
        void testClimbStairsFormula_N1() {
            assertEquals(1, solution.climbStairsFormula(1));
        }

        @Test
        @DisplayName("Test case 2: n = 2")
        void testClimbStairsFormula_N2() {
            assertEquals(2, solution.climbStairsFormula(2));
        }

        @Test
        @DisplayName("Test case 3: n = 3")
        void testClimbStairsFormula_N3() {
            assertEquals(3, solution.climbStairsFormula(3));
        }

        @Test
        @DisplayName("Test case 4: n = 4")
        void testClimbStairsFormula_N4() {
            assertEquals(5, solution.climbStairsFormula(4));
        }

        @Test
        @DisplayName("Test case 5: n = 5")
        void testClimbStairsFormula_N5() {
            assertEquals(8, solution.climbStairsFormula(5));
        }

        @Test
        @DisplayName("Test case 6: n = 10")
        void testClimbStairsFormula_N10() {
            assertEquals(89, solution.climbStairsFormula(10));
        }

        @Test
        @DisplayName("Test case 7: n = 20")
        void testClimbStairsFormula_N20() {
            assertEquals(10946, solution.climbStairsFormula(20));
        }

        @Test
        @DisplayName("Test case 8: n = 30")
        void testClimbStairsFormula_N30() {
            assertEquals(1346269, solution.climbStairsFormula(30));
        }

        @Test
        @DisplayName("Test case 9: n = 45 (maximum constraint)")
        void testClimbStairsFormula_N45() {
            assertEquals(1836311903, solution.climbStairsFormula(45));
        }
    }

    @Nested
    @DisplayName("Iterative Fibonacci Tests")
    class IterativeFibonacciTests {

        @Test
        @DisplayName("Test case 1: n = 1")
        void testClimbStairsIterative_N1() {
            assertEquals(1, solution.climbStairsIterative(1));
        }

        @Test
        @DisplayName("Test case 2: n = 2")
        void testClimbStairsIterative_N2() {
            assertEquals(2, solution.climbStairsIterative(2));
        }

        @Test
        @DisplayName("Test case 3: n = 3")
        void testClimbStairsIterative_N3() {
            assertEquals(3, solution.climbStairsIterative(3));
        }

        @Test
        @DisplayName("Test case 4: n = 4")
        void testClimbStairsIterative_N4() {
            assertEquals(5, solution.climbStairsIterative(4));
        }

        @Test
        @DisplayName("Test case 5: n = 5")
        void testClimbStairsIterative_N5() {
            assertEquals(8, solution.climbStairsIterative(5));
        }

        @Test
        @DisplayName("Test case 6: n = 10")
        void testClimbStairsIterative_N10() {
            assertEquals(89, solution.climbStairsIterative(10));
        }

        @Test
        @DisplayName("Test case 7: n = 20")
        void testClimbStairsIterative_N20() {
            assertEquals(10946, solution.climbStairsIterative(20));
        }

        @Test
        @DisplayName("Test case 8: n = 30")
        void testClimbStairsIterative_N30() {
            assertEquals(1346269, solution.climbStairsIterative(30));
        }

        @Test
        @DisplayName("Test case 9: n = 45 (maximum constraint)")
        void testClimbStairsIterative_N45() {
            assertEquals(1836311903, solution.climbStairsIterative(45));
        }
    }

    @Nested
    @DisplayName("Cross-Approach Consistency Tests")
    class CrossApproachConsistencyTests {

        @Test
        @DisplayName("All approaches should return same result for n = 1-10")
        void testAllApproachesConsistency() {
            for (int n = 1; n <= 10; n++) {
                int dpResult = solution.climbStairs(n);
                int memoResult = solution.climbStairsMemoization(n);
                int recursiveResult = solution.climbStairsRecursive(n);
                int matrixResult = solution.climbStairsMatrix(n);
                int formulaResult = solution.climbStairsFormula(n);
                int iterativeResult = solution.climbStairsIterative(n);

                assertEquals(dpResult, memoResult, "DP and Memoization should match for n=" + n);
                assertEquals(dpResult, recursiveResult, "DP and Recursive should match for n=" + n);
                assertEquals(dpResult, matrixResult, "DP and Matrix should match for n=" + n);
                assertEquals(dpResult, formulaResult, "DP and Formula should match for n=" + n);
                assertEquals(dpResult, iterativeResult, "DP and Iterative should match for n=" + n);
            }
        }

        @Test
        @DisplayName("All approaches should return same result for larger values")
        void testAllApproachesConsistencyLargeValues() {
            int[] testValues = {15, 20, 25, 30, 35, 40, 45};

            for (int n : testValues) {
                int dpResult = solution.climbStairs(n);
                int memoResult = solution.climbStairsMemoization(n);
                int matrixResult = solution.climbStairsMatrix(n);
                int formulaResult = solution.climbStairsFormula(n);
                int iterativeResult = solution.climbStairsIterative(n);

                assertEquals(dpResult, memoResult, "DP and Memoization should match for n=" + n);
                assertEquals(dpResult, matrixResult, "DP and Matrix should match for n=" + n);
                assertEquals(dpResult, formulaResult, "DP and Formula should match for n=" + n);
                assertEquals(dpResult, iterativeResult, "DP and Iterative should match for n=" + n);
            }
        }
    }

    @Nested
    @DisplayName("Edge Cases and Boundary Tests")
    class EdgeCasesAndBoundaryTests {

        @Test
        @DisplayName("Minimum constraint: n = 1")
        void testMinimumConstraint() {
            int result = solution.climbStairs(1);
            assertEquals(1, result);
        }

        @Test
        @DisplayName("Maximum constraint: n = 45")
        void testMaximumConstraint() {
            int result = solution.climbStairs(45);
            assertEquals(1836311903, result);
        }

        @Test
        @DisplayName("Fibonacci sequence verification")
        void testFibonacciSequence() {
            int[] expected = {1, 2, 3, 5, 8, 13, 21, 34, 55, 89};

            for (int i = 0; i < expected.length; i++) {
                int n = i + 1;
                int result = solution.climbStairs(n);
                assertEquals(expected[i], result, "Fibonacci sequence should match for n=" + n);
            }
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Performance test for large input")
        void testPerformanceLargeInput() {
            long startTime = System.nanoTime();
            int result = solution.climbStairs(45);
            long endTime = System.nanoTime();

            assertEquals(1836311903, result);

            long duration = endTime - startTime;
            System.out.println("Performance test for n=45: " + duration + " ns");

            // Should complete in reasonable time (less than 1 second)
            assertTrue(duration < 1_000_000_000, "Solution should complete within 1 second");
        }

        @Test
        @DisplayName("Performance comparison between approaches")
        void testPerformanceComparison() {
            int n = 40;

            // Test DP Bottom-up
            long startTime = System.nanoTime();
            int dpResult = solution.climbStairs(n);
            long dpTime = System.nanoTime() - startTime;

            // Test Memoization
            startTime = System.nanoTime();
            int memoResult = solution.climbStairsMemoization(n);
            long memoTime = System.nanoTime() - startTime;

            // Test Matrix Exponentiation
            startTime = System.nanoTime();
            int matrixResult = solution.climbStairsMatrix(n);
            long matrixTime = System.nanoTime() - startTime;

            // Test Formula
            startTime = System.nanoTime();
            int formulaResult = solution.climbStairsFormula(n);
            long formulaTime = System.nanoTime() - startTime;

            // Test Iterative
            startTime = System.nanoTime();
            int iterativeResult = solution.climbStairsIterative(n);
            long iterativeTime = System.nanoTime() - startTime;

            // All results should be the same
            assertEquals(dpResult, memoResult);
            assertEquals(dpResult, matrixResult);
            assertEquals(dpResult, formulaResult);
            assertEquals(dpResult, iterativeResult);

            System.out.println("Performance comparison for n=" + n + ":");
            System.out.println("DP Bottom-up: " + dpTime + " ns");
            System.out.println("Memoization: " + memoTime + " ns");
            System.out.println("Matrix Exponentiation: " + matrixTime + " ns");
            System.out.println("Formula: " + formulaTime + " ns");
            System.out.println("Iterative: " + iterativeTime + " ns");
        }
    }
}
