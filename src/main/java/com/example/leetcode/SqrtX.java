package com.example.leetcode;

/**
 * LeetCode #69: Sqrt(x)
 * 
 * Problem Statement: Given a non-negative integer x, return the square root of x rounded down to
 * the nearest integer. The returned integer should be non-negative as well. You must not use any
 * built-in exponent function or operator.
 * 
 * Constraints: - 0 <= x <= 2^31 - 1
 * 
 * This solution demonstrates multiple algorithmic approaches: 1. Binary Search - O(log x) time,
 * O(1) space (most efficient) 2. Newton's Method - O(log x) time, O(1) space (mathematical
 * approach) 3. Linear Search - O(√x) time, O(1) space (educational baseline) 4. Bit Manipulation -
 * O(log x) time, O(1) space (advanced approach) 5. Exponential Search - O(log x) time, O(1) space
 * (alternative binary search) 6. Optimized Binary Search - O(log x) time, O(1) space
 * (production-ready)
 * 
 * @author Superman
 * @version 1.0
 */
public class SqrtX {

    /**
     * Approach 1: Binary Search (Recommended)
     * 
     * Uses binary search to find the largest integer whose square is less than or equal to x. This
     * is the most efficient and interview-friendly approach.
     * 
     * Time Complexity: O(log x) Space Complexity: O(1)
     * 
     * @param x Non-negative integer
     * @return Integer square root of x
     */
    public int mySqrtBinarySearch(int x) {
        if (x <= 1) {
            return x;
        }

        int left = 1;
        int right = x;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;

            if (square == x) {
                return mid;
            } else if (square < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    /**
     * Approach 2: Newton's Method
     * 
     * Uses Newton's method for finding square roots. This mathematical approach converges very
     * quickly to the solution.
     * 
     * Time Complexity: O(log x) Space Complexity: O(1)
     * 
     * @param x Non-negative integer
     * @return Integer square root of x
     */
    public int mySqrtNewtonsMethod(int x) {
        if (x <= 1) {
            return x;
        }

        double guess = x;
        double epsilon = 1e-6;

        while (Math.abs(guess * guess - x) > epsilon) {
            guess = (guess + x / guess) / 2.0;
        }

        return (int) guess;
    }

    /**
     * Approach 3: Linear Search
     * 
     * Simple linear search from 1 to find the largest integer whose square is <= x. Educational
     * approach to understand the problem.
     * 
     * Time Complexity: O(√x) Space Complexity: O(1)
     * 
     * @param x Non-negative integer
     * @return Integer square root of x
     */
    public int mySqrtLinearSearch(int x) {
        if (x <= 1) {
            return x;
        }

        int result = 1;
        for (int i = 1; i <= x; i++) {
            long square = (long) i * i;
            if (square <= x) {
                result = i;
            } else {
                break;
            }
        }

        return result;
    }

    /**
     * Approach 4: Bit Manipulation
     * 
     * Uses bit manipulation to find the square root. This approach works by finding the most
     * significant bit of the result and then refining it.
     * 
     * Time Complexity: O(log x) Space Complexity: O(1)
     * 
     * @param x Non-negative integer
     * @return Integer square root of x
     */
    public int mySqrtBitManipulation(int x) {
        if (x <= 1) {
            return x;
        }

        int result = 0;
        int bit = 1 << 15; // Start with the highest possible bit

        while (bit > 0) {
            result |= bit;
            if ((long) result * result > x) {
                result ^= bit; // Remove the bit if it makes result too large
            }
            bit >>= 1;
        }

        return result;
    }

    /**
     * Approach 5: Exponential Search
     * 
     * First finds the range using exponential search, then applies binary search within that range.
     * This can be more efficient for very large numbers.
     * 
     * Time Complexity: O(log x) Space Complexity: O(1)
     * 
     * @param x Non-negative integer
     * @return Integer square root of x
     */
    public int mySqrtExponentialSearch(int x) {
        if (x <= 1) {
            return x;
        }

        // Find the range using exponential search
        int left = 1;
        int right = 1;

        while ((long) right * right <= x) {
            left = right;
            right *= 2;
        }

        // Now apply binary search in the range [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;

            if (square == x) {
                return mid;
            } else if (square < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    /**
     * Approach 6: Optimized Binary Search
     * 
     * Optimized binary search with better initial bounds and overflow protection. This is the
     * production-ready version with all edge cases handled.
     * 
     * Time Complexity: O(log x) Space Complexity: O(1)
     * 
     * @param x Non-negative integer
     * @return Integer square root of x
     */
    public int mySqrtOptimized(int x) {
        if (x <= 1) {
            return x;
        }

        // Optimize initial bounds
        int left = 1;
        int right = Math.min(x, 46340); // sqrt(2^31 - 1) ≈ 46340

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Use division to avoid overflow
            if (mid <= x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    /**
     * Utility method to demonstrate all approaches and compare results.
     * 
     * @param x Non-negative integer
     */
    public void demonstrateAllApproaches(int x) {
        System.out.println("=== Sqrt(x) ===");
        System.out.println("Input: " + x);
        System.out.println("Expected: " + (int) Math.sqrt(x));
        System.out.println();

        long startTime, endTime;

        // Approach 1: Binary Search
        startTime = System.nanoTime();
        int result1 = mySqrtBinarySearch(x);
        endTime = System.nanoTime();
        System.out.println("1. Binary Search: " + result1 + " (Time: "
                + (endTime - startTime) / 1000 + " μs)");

        // Approach 2: Newton's Method
        startTime = System.nanoTime();
        int result2 = mySqrtNewtonsMethod(x);
        endTime = System.nanoTime();
        System.out.println("2. Newton's Method: " + result2 + " (Time: "
                + (endTime - startTime) / 1000 + " μs)");

        // Approach 3: Linear Search
        startTime = System.nanoTime();
        int result3 = mySqrtLinearSearch(x);
        endTime = System.nanoTime();
        System.out.println("3. Linear Search: " + result3 + " (Time: "
                + (endTime - startTime) / 1000 + " μs)");

        // Approach 4: Bit Manipulation
        startTime = System.nanoTime();
        int result4 = mySqrtBitManipulation(x);
        endTime = System.nanoTime();
        System.out.println("4. Bit Manipulation: " + result4 + " (Time: "
                + (endTime - startTime) / 1000 + " μs)");

        // Approach 5: Exponential Search
        startTime = System.nanoTime();
        int result5 = mySqrtExponentialSearch(x);
        endTime = System.nanoTime();
        System.out.println("5. Exponential Search: " + result5 + " (Time: "
                + (endTime - startTime) / 1000 + " μs)");

        // Approach 6: Optimized Binary Search
        startTime = System.nanoTime();
        int result6 = mySqrtOptimized(x);
        endTime = System.nanoTime();
        System.out.println("6. Optimized Binary Search: " + result6 + " (Time: "
                + (endTime - startTime) / 1000 + " μs)");

        // Verify all results are the same
        boolean allMatch = (result1 == result2 && result2 == result3 && result3 == result4
                && result4 == result5 && result5 == result6);
        System.out.println("\n✅ All approaches produce identical results: " + allMatch);

        if (allMatch) {
            System.out.println("Result: " + result1);
            System.out.println("Verification: " + result1 + "² = " + ((long) result1 * result1)
                    + " ≤ " + x + " < " + (result1 + 1) + "² = "
                    + ((long) (result1 + 1) * (result1 + 1)));
        }

        System.out.println();
    }

    /**
     * Utility method to analyze the performance characteristics of different approaches.
     * 
     * @param testCases Array of test cases to analyze
     */
    public void analyzePerformance(int[] testCases) {
        System.out.println("🔍 Performance Analysis for Sqrt(x)");
        System.out.println("=".repeat(50));

        for (int x : testCases) {
            System.out.println("\nTesting with x = " + x + ":");

            // Binary Search
            long start = System.nanoTime();
            mySqrtBinarySearch(x);
            long binaryTime = System.nanoTime() - start;

            // Newton's Method
            start = System.nanoTime();
            mySqrtNewtonsMethod(x);
            long newtonTime = System.nanoTime() - start;

            // Linear Search
            start = System.nanoTime();
            mySqrtLinearSearch(x);
            long linearTime = System.nanoTime() - start;

            // Bit Manipulation
            start = System.nanoTime();
            mySqrtBitManipulation(x);
            long bitTime = System.nanoTime() - start;

            // Exponential Search
            start = System.nanoTime();
            mySqrtExponentialSearch(x);
            long expTime = System.nanoTime() - start;

            // Optimized Binary Search
            start = System.nanoTime();
            mySqrtOptimized(x);
            long optTime = System.nanoTime() - start;

            System.out.printf("Binary Search: %d μs%n", binaryTime / 1000);
            System.out.printf("Newton's Method: %d μs%n", newtonTime / 1000);
            System.out.printf("Linear Search: %d μs%n", linearTime / 1000);
            System.out.printf("Bit Manipulation: %d μs%n", bitTime / 1000);
            System.out.printf("Exponential Search: %d μs%n", expTime / 1000);
            System.out.printf("Optimized Binary Search: %d μs%n", optTime / 1000);
        }
    }

    /**
     * Utility method to demonstrate edge cases and boundary conditions.
     */
    public void demonstrateEdgeCases() {
        System.out.println("🧪 Edge Cases and Boundary Conditions");
        System.out.println("=".repeat(50));

        int[] edgeCases = {0, 1, 2, 3, 4, 8, 9, 15, 16, 24, 25, 26, 100, 1000, 10000,
                Integer.MAX_VALUE, 2147483647, 2147395599};

        for (int x : edgeCases) {
            System.out.println("\nTesting edge case: x = " + x);
            int result = mySqrtOptimized(x);
            long square = (long) result * result;
            long nextSquare = (long) (result + 1) * (result + 1);

            System.out.println("Result: " + result);
            System.out.println("Verification: " + result + "² = " + square + " ≤ " + x + " < "
                    + (result + 1) + "² = " + nextSquare);
            System.out.println("Valid: " + (square <= x && x < nextSquare));
        }
    }

    /**
     * Main method for demonstration and testing.
     */
    public static void main(String[] args) {
        SqrtX solution = new SqrtX();

        System.out.println("🚀 LeetCode #69: Sqrt(x)");
        System.out.println("=".repeat(50));

        // Test cases
        int[] testCases = {0, 1, 2, 3, 4, 8, 9, 15, 16, 24, 25, 26, 100, 1000, 10000, 100000,
                1000000, 2147483647, 2147395599};

        for (int testCase : testCases) {
            solution.demonstrateAllApproaches(testCase);
        }

        // Performance analysis
        int[] perfTestCases = {100, 1000, 10000, 100000, 1000000, 2147483647};
        solution.analyzePerformance(perfTestCases);

        // Edge cases demonstration
        solution.demonstrateEdgeCases();

        System.out.println("🎯 Algorithm Analysis:");
        System.out.println("• Binary Search: Most efficient and interview-friendly (recommended)");
        System.out.println("• Newton's Method: Mathematical approach with fast convergence");
        System.out.println("• Linear Search: Educational baseline, O(√x) complexity");
        System.out.println("• Bit Manipulation: Advanced approach using bit operations");
        System.out.println("• Exponential Search: Alternative binary search with range finding");
        System.out.println("• Optimized Binary Search: Production-ready with overflow protection");
        System.out.println();
        System.out.println("🏆 Recommendation: Use Binary Search for interviews and production!");
        System.out.println(
                "💡 Key Insight: Avoid overflow by using division instead of multiplication!");
    }
}
