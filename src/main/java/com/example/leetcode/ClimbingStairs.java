package com.example.leetcode;

/**
 * LeetCode #70: Climbing Stairs
 * 
 * Problem Statement: You are climbing a staircase. It takes n steps to reach the top. Each time you
 * can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * Constraints: 1 <= n <= 45
 * 
 * This solution demonstrates multiple algorithmic approaches: 1. Dynamic Programming (Bottom-up) -
 * O(n) time, O(1) space (most efficient) 2. Dynamic Programming (Top-down with Memoization) - O(n)
 * time, O(n) space 3. Recursive Solution - O(2^n) time, O(n) space (educational baseline) 4. Matrix
 * Exponentiation - O(log n) time, O(1) space (advanced approach) 5. Fibonacci Formula - O(1) time,
 * O(1) space (mathematical approach) 6. Iterative Fibonacci - O(n) time, O(1) space (simple and
 * efficient)
 * 
 * @author Superman
 * @version 1.0
 */
public class ClimbingStairs {

    /**
     * Approach 1: Dynamic Programming (Bottom-up) - Recommended
     * 
     * Uses bottom-up dynamic programming with space optimization. The key insight is that the
     * number of ways to reach step n is the sum of ways to reach steps (n-1) and (n-2). This
     * follows the Fibonacci sequence pattern.
     * 
     * Time Complexity: O(n) Space Complexity: O(1)
     * 
     * @param n Number of steps
     * @return Number of distinct ways to climb to the top
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int prev2 = 1; // ways to reach step 1
        int prev1 = 2; // ways to reach step 2

        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    /**
     * Approach 2: Dynamic Programming (Top-down with Memoization)
     * 
     * Uses recursive approach with memoization to avoid recalculating the same subproblems. This
     * approach is more intuitive but uses additional space for the memoization array.
     * 
     * Time Complexity: O(n) Space Complexity: O(n)
     * 
     * @param n Number of steps
     * @return Number of distinct ways to climb to the top
     */
    public int climbStairsMemoization(int n) {
        if (n <= 2) {
            return n;
        }

        int[] memo = new int[n + 1];
        memo[1] = 1;
        memo[2] = 2;

        return climbStairsHelper(n, memo);
    }

    private int climbStairsHelper(int n, int[] memo) {
        if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] = climbStairsHelper(n - 1, memo) + climbStairsHelper(n - 2, memo);
        return memo[n];
    }

    /**
     * Approach 3: Recursive Solution (Educational)
     * 
     * Pure recursive solution without optimization. This approach has exponential time complexity
     * and is included for educational purposes to understand the problem structure.
     * 
     * Time Complexity: O(2^n) Space Complexity: O(n)
     * 
     * @param n Number of steps
     * @return Number of distinct ways to climb to the top
     */
    public int climbStairsRecursive(int n) {
        if (n <= 2) {
            return n;
        }

        return climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2);
    }

    /**
     * Approach 4: Matrix Exponentiation (Advanced)
     * 
     * Uses matrix exponentiation to compute Fibonacci numbers in logarithmic time. This is an
     * advanced approach that demonstrates mathematical optimization.
     * 
     * Time Complexity: O(log n) Space Complexity: O(1)
     * 
     * @param n Number of steps
     * @return Number of distinct ways to climb to the top
     */
    public int climbStairsMatrix(int n) {
        if (n <= 2) {
            return n;
        }

        // The transformation matrix for Fibonacci sequence
        // [F(n+1)] [1 1]^n [F(1)]
        // [F(n) ] = [1 0] * [F(0)]
        int[][] matrix = {{1, 1}, {1, 0}};
        int[][] result = matrixPower(matrix, n - 1);

        // F(n) = result[0][0] * F(1) + result[0][1] * F(0)
        // Since F(1) = 1 and F(0) = 1 (for our problem)
        return result[0][0] + result[0][1];
    }

    private int[][] matrixPower(int[][] matrix, int power) {
        int[][] result = {{1, 0}, {0, 1}}; // Identity matrix

        while (power > 0) {
            if (power % 2 == 1) {
                result = matrixMultiply(result, matrix);
            }
            matrix = matrixMultiply(matrix, matrix);
            power /= 2;
        }

        return result;
    }

    private int[][] matrixMultiply(int[][] a, int[][] b) {
        int[][] result = new int[2][2];
        result[0][0] = a[0][0] * b[0][0] + a[0][1] * b[1][0];
        result[0][1] = a[0][0] * b[0][1] + a[0][1] * b[1][1];
        result[1][0] = a[1][0] * b[0][0] + a[1][1] * b[1][0];
        result[1][1] = a[1][0] * b[0][1] + a[1][1] * b[1][1];
        return result;
    }

    /**
     * Approach 5: Fibonacci Formula (Mathematical)
     * 
     * Uses Binet's formula to compute Fibonacci numbers directly. This provides constant time
     * complexity but may have precision issues for very large numbers.
     * 
     * Time Complexity: O(1) Space Complexity: O(1)
     * 
     * @param n Number of steps
     * @return Number of distinct ways to climb to the top
     */
    public int climbStairsFormula(int n) {
        if (n <= 2) {
            return n;
        }

        double sqrt5 = Math.sqrt(5);
        double phi = (1 + sqrt5) / 2; // Golden ratio
        double psi = (1 - sqrt5) / 2; // Conjugate of golden ratio

        // F(n) = (phi^n - psi^n) / sqrt(5)
        double result = (Math.pow(phi, n + 1) - Math.pow(psi, n + 1)) / sqrt5;

        return (int) Math.round(result);
    }

    /**
     * Approach 6: Iterative Fibonacci (Simple and Efficient)
     * 
     * Simple iterative approach that builds up the Fibonacci sequence step by step. This is easy to
     * understand and implement while maintaining good performance.
     * 
     * Time Complexity: O(n) Space Complexity: O(1)
     * 
     * @param n Number of steps
     * @return Number of distinct ways to climb to the top
     */
    public int climbStairsIterative(int n) {
        if (n <= 2) {
            return n;
        }

        int a = 1, b = 2, c;

        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return b;
    }

    /**
     * Main method to demonstrate all approaches
     */
    public static void main(String[] args) {
        ClimbingStairs solution = new ClimbingStairs();

        // Test cases
        int[] testCases = {1, 2, 3, 4, 5, 10, 20, 30, 45};

        System.out.println("Climbing Stairs - All Approaches Comparison");
        System.out.println("==========================================");
        System.out.printf("%-4s | %-12s | %-12s | %-12s | %-12s | %-12s | %-12s%n", "n",
                "DP Bottom-up", "Memoization", "Recursive", "Matrix", "Formula", "Iterative");
        System.out.println(
                "----|--------------|--------------|--------------|--------------|--------------|--------------");

        for (int n : testCases) {
            int result1 = solution.climbStairs(n);
            int result2 = solution.climbStairsMemoization(n);
            int result3 = (n <= 20) ? solution.climbStairsRecursive(n) : -1; // Skip recursive for
                                                                             // large n
            int result4 = solution.climbStairsMatrix(n);
            int result5 = solution.climbStairsFormula(n);
            int result6 = solution.climbStairsIterative(n);

            System.out.printf("%-4d | %-12d | %-12d | %-12s | %-12d | %-12d | %-12d%n", n, result1,
                    result2, result3 == -1 ? "N/A" : String.valueOf(result3), result4, result5,
                    result6);
        }

        // Performance comparison for larger values
        System.out.println("\nPerformance Analysis:");
        System.out.println("====================");

        int largeN = 40;
        long startTime, endTime;

        // Test DP Bottom-up
        startTime = System.nanoTime();
        solution.climbStairs(largeN);
        endTime = System.nanoTime();
        System.out.printf("DP Bottom-up (n=%d): %d ns%n", largeN, endTime - startTime);

        // Test Memoization
        startTime = System.nanoTime();
        solution.climbStairsMemoization(largeN);
        endTime = System.nanoTime();
        System.out.printf("Memoization (n=%d): %d ns%n", largeN, endTime - startTime);

        // Test Matrix Exponentiation
        startTime = System.nanoTime();
        solution.climbStairsMatrix(largeN);
        endTime = System.nanoTime();
        System.out.printf("Matrix Exponentiation (n=%d): %d ns%n", largeN, endTime - startTime);

        // Test Formula
        startTime = System.nanoTime();
        solution.climbStairsFormula(largeN);
        endTime = System.nanoTime();
        System.out.printf("Formula (n=%d): %d ns%n", largeN, endTime - startTime);

        // Test Iterative
        startTime = System.nanoTime();
        solution.climbStairsIterative(largeN);
        endTime = System.nanoTime();
        System.out.printf("Iterative (n=%d): %d ns%n", largeN, endTime - startTime);
    }
}
