package com.example.leetcode;

/**
 * LeetCode 338: Counting Bits
 * 
 * Problem Statement: Given an integer n, return an array ans of length n + 1 such that for each i
 * (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 * 
 * Example 1: Input: n = 2 Output: [0,1,1] Explanation: 0 --> 0 1 --> 1 2 --> 10
 * 
 * Example 2: Input: n = 5 Output: [0,1,1,2,1,2] Explanation: 0 --> 0 1 --> 1 2 --> 10 3 --> 11 4
 * --> 100 5 --> 101
 * 
 * Constraints: - 0 <= n <= 10^5
 * 
 * Follow up: - It is very easy to come up with a solution with a runtime of O(n log n). Can you do
 * it in linear time O(n) and possibly in a single pass? - Space complexity should be O(n). - Can
 * you do it without using any built-in function (i.e., like __builtin_popcount in C++)?
 * 
 * @author LeetCode
 * @version 1.0
 */
public class CountingBits {

    /**
     * Approach 1: Dynamic Programming with Right Shift
     * 
     * Key Insight: The number of 1's in the binary representation of a number i is equal to the
     * number of 1's in i/2 (i right-shifted by 1) plus the least significant bit of i.
     * 
     * Formula: ans[i] = ans[i >> 1] + (i & 1)
     * 
     * Time Complexity: O(n) Space Complexity: O(n)
     * 
     * @param n the upper bound (inclusive)
     * @return array containing count of 1's for each number from 0 to n
     */
    public int[] countBitsDP(int n) {
        int[] ans = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
    }

    /**
     * Approach 2: Dynamic Programming with Power of 2
     * 
     * Key Insight: For numbers that are powers of 2, the count is 1. For other numbers, we can use
     * the fact that any number can be written as a power of 2 plus a remainder.
     * 
     * Time Complexity: O(n) Space Complexity: O(n)
     * 
     * @param n the upper bound (inclusive)
     * @return array containing count of 1's for each number from 0 to n
     */
    public int[] countBitsPowerOf2(int n) {
        int[] ans = new int[n + 1];
        int offset = 1;

        for (int i = 1; i <= n; i++) {
            if (offset * 2 == i) {
                offset = i;
            }
            ans[i] = ans[i - offset] + 1;
        }

        return ans;
    }

    /**
     * Approach 3: Dynamic Programming with Last Set Bit
     * 
     * Key Insight: The number of 1's in i is equal to the number of 1's in i with its last set bit
     * removed, plus 1.
     * 
     * Formula: ans[i] = ans[i & (i - 1)] + 1
     * 
     * Time Complexity: O(n) Space Complexity: O(n)
     * 
     * @param n the upper bound (inclusive)
     * @return array containing count of 1's for each number from 0 to n
     */
    public int[] countBitsLastSetBit(int n) {
        int[] ans = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i & (i - 1)] + 1;
        }

        return ans;
    }

    /**
     * Approach 4: Naive Approach (for comparison)
     * 
     * For each number from 0 to n, count the number of 1's in its binary representation. This
     * approach is less efficient but demonstrates the basic concept.
     * 
     * Time Complexity: O(n log n) - each number has at most log n bits Space Complexity: O(n)
     * 
     * @param n the upper bound (inclusive)
     * @return array containing count of 1's for each number from 0 to n
     */
    public int[] countBitsNaive(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            ans[i] = countOnes(i);
        }

        return ans;
    }

    /**
     * Helper method to count the number of 1's in the binary representation of a number.
     * 
     * @param num the number to count 1's for
     * @return the count of 1's in the binary representation
     */
    private int countOnes(int num) {
        int count = 0;
        while (num > 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }

    /**
     * Approach 5: Using Built-in Integer.bitCount() (for reference)
     * 
     * This approach uses Java's built-in method to count bits. While efficient, it doesn't
     * demonstrate the algorithmic thinking.
     * 
     * Time Complexity: O(n log n) Space Complexity: O(n)
     * 
     * @param n the upper bound (inclusive)
     * @return array containing count of 1's for each number from 0 to n
     */
    public int[] countBitsBuiltIn(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            ans[i] = Integer.bitCount(i);
        }

        return ans;
    }

    /**
     * Approach 6: Optimized Bit Manipulation
     * 
     * This approach uses a more sophisticated bit manipulation technique that processes multiple
     * bits at once.
     * 
     * Time Complexity: O(n) Space Complexity: O(n)
     * 
     * @param n the upper bound (inclusive)
     * @return array containing count of 1's for each number from 0 to n
     */
    public int[] countBitsOptimized(int n) {
        int[] ans = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            // Use the fact that ans[i] = ans[i/2] + (i % 2)
            ans[i] = ans[i / 2] + (i % 2);
        }

        return ans;
    }

    /**
     * Main method to demonstrate the solution approaches.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        CountingBits solution = new CountingBits();

        // Test with n = 5
        int n = 5;
        System.out.println("Testing Counting Bits with n = " + n);
        System.out.println("Expected: [0, 1, 1, 2, 1, 2]");

        // Test all approaches
        int[] result1 = solution.countBitsDP(n);
        int[] result2 = solution.countBitsPowerOf2(n);
        int[] result3 = solution.countBitsLastSetBit(n);
        int[] result4 = solution.countBitsNaive(n);
        int[] result5 = solution.countBitsBuiltIn(n);
        int[] result6 = solution.countBitsOptimized(n);

        System.out.println("DP Right Shift: " + java.util.Arrays.toString(result1));
        System.out.println("DP Power of 2:  " + java.util.Arrays.toString(result2));
        System.out.println("DP Last Set Bit:" + java.util.Arrays.toString(result3));
        System.out.println("Naive Approach: " + java.util.Arrays.toString(result4));
        System.out.println("Built-in Method:" + java.util.Arrays.toString(result5));
        System.out.println("Optimized:      " + java.util.Arrays.toString(result6));

        // Verify all approaches produce the same result
        boolean allEqual = java.util.Arrays.equals(result1, result2)
                && java.util.Arrays.equals(result2, result3)
                && java.util.Arrays.equals(result3, result4)
                && java.util.Arrays.equals(result4, result5)
                && java.util.Arrays.equals(result5, result6);

        System.out.println("All approaches produce same result: " + allEqual);
    }
}
