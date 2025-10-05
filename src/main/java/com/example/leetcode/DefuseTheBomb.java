package com.example.leetcode;

import java.util.Arrays;

/**
 * LeetCode 1652: Defuse the Bomb
 * 
 * Problem Description: You have a bomb to defuse, and your time is running out! Your informer will
 * provide you with a circular array code of length n and a key k. To decrypt the code, you must
 * replace every number. All the numbers are replaced simultaneously.
 * 
 * If k > 0, replace the ith number with the sum of the next k numbers. If k < 0, replace the ith
 * number with the sum of the previous k numbers. If k == 0, replace the ith number with 0. As code
 * is circular, the next element of code[n-1] is code[0], and the previous element of code[0] is
 * code[n-1].
 * 
 * Given the circular array code and an integer key k, return the decrypted code to defuse the bomb!
 * 
 * Example 1: Input: code = [5,7,1,4], k = 3 Output: [12,10,16,13] Explanation: Each number is
 * replaced by the sum of the next 3 numbers. The decrypted code is [7+1+4, 1+4+5, 4+5+7, 5+7+1].
 * Notice that the numbers wrap around.
 * 
 * Example 2: Input: code = [1,2,3,4], k = 0 Output: [0,0,0,0] Explanation: When k is zero, the
 * numbers are replaced by 0.
 * 
 * Example 3: Input: code = [2,4,9,3], k = -2 Output: [12,5,6,13] Explanation: The decrypted code is
 * [3+9, 9+4, 4+2, 2+3]. Notice that the numbers wrap around when k is negative.
 * 
 * Constraints: - n == code.length - 1 <= n <= 100 - 1 <= code[i] <= 100 - -(n - 1) <= k <= n - 1
 * 
 * Time Complexity Analysis: - Sliding Window Approach: O(n) time, O(1) space - Brute Force
 * Approach: O(n*k) time, O(1) space - Prefix Sum Approach: O(n) time, O(n) space - Optimized
 * Sliding Window: O(n) time, O(1) space
 */
public class DefuseTheBomb {

    /**
     * Approach 1: Sliding Window (Recommended)
     * 
     * Time Complexity: O(n) where n is the length of code Space Complexity: O(1) - only using
     * constant extra space
     * 
     * Strategy: Use sliding window technique to efficiently calculate the sum of k consecutive
     * elements. Handle circular array by using modulo arithmetic.
     */
    public int[] decryptSlidingWindow(int[] code, int k) {
        int n = code.length;
        int[] decrypted = new int[n];

        // Handle k == 0 case
        if (k == 0) {
            return decrypted; // All zeros
        }

        // Calculate initial window sum
        int windowSum = 0;
        if (k > 0) {
            // Sum of next k elements starting from index 1
            for (int i = 1; i <= k; i++) {
                windowSum += code[i % n];
            }
        } else {
            // Sum of previous |k| elements starting from index n + k
            int start = n + k;
            for (int i = 0; i < Math.abs(k); i++) {
                windowSum += code[(start + i) % n];
            }
        }

        // Slide the window and fill decrypted array
        for (int i = 0; i < n; i++) {
            decrypted[i] = windowSum;

            if (k > 0) {
                // Remove the element leaving the window and add the element entering
                windowSum -= code[(i + 1) % n];
                windowSum += code[(i + 1 + k) % n];
            } else {
                // For negative k, adjust window differently
                windowSum -= code[(i + n + k) % n];
                windowSum += code[i % n];
            }
        }

        return decrypted;
    }

    /**
     * Approach 2: Brute Force
     * 
     * Time Complexity: O(n*k) where n is the length of code and k is the key Space Complexity: O(1)
     * - only using constant extra space
     * 
     * Strategy: For each element, directly calculate the sum of k consecutive elements. This
     * approach is straightforward but less efficient.
     */
    public int[] decryptBruteForce(int[] code, int k) {
        int n = code.length;
        int[] decrypted = new int[n];

        // Handle k == 0 case
        if (k == 0) {
            return decrypted; // All zeros
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            if (k > 0) {
                // Sum of next k elements
                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % n];
                }
            } else {
                // Sum of previous |k| elements
                for (int j = 1; j <= Math.abs(k); j++) {
                    sum += code[(i - j + n) % n];
                }
            }
            decrypted[i] = sum;
        }

        return decrypted;
    }

    /**
     * Approach 3: Prefix Sum with Circular Array
     * 
     * Time Complexity: O(n) where n is the length of code Space Complexity: O(n) for the extended
     * array
     * 
     * Strategy: Create an extended array to handle circular nature, then use prefix sum to quickly
     * calculate subarray sums.
     */
    public int[] decryptPrefixSum(int[] code, int k) {
        int n = code.length;
        int[] decrypted = new int[n];

        // Handle k == 0 case
        if (k == 0) {
            return decrypted; // All zeros
        }

        // Create extended array: [code, code] to handle circular nature
        int[] extended = new int[2 * n];
        for (int i = 0; i < n; i++) {
            extended[i] = code[i];
            extended[i + n] = code[i];
        }

        // Calculate prefix sum
        int[] prefixSum = new int[2 * n + 1];
        for (int i = 0; i < 2 * n; i++) {
            prefixSum[i + 1] = prefixSum[i] + extended[i];
        }

        // Calculate decrypted array
        for (int i = 0; i < n; i++) {
            if (k > 0) {
                // Sum of next k elements
                int start = i + 1;
                int end = i + k;
                decrypted[i] = prefixSum[end + 1] - prefixSum[start];
            } else {
                // Sum of previous |k| elements
                int start = i - Math.abs(k) + n;
                int end = i - 1 + n;
                decrypted[i] = prefixSum[end + 1] - prefixSum[start];
            }
        }

        return decrypted;
    }

    /**
     * Approach 4: Optimized Sliding Window
     * 
     * Time Complexity: O(n) where n is the length of code Space Complexity: O(1) - only using
     * constant extra space
     * 
     * Strategy: Optimized sliding window with cleaner index calculations and early termination.
     */
    public int[] decryptOptimized(int[] code, int k) {
        int n = code.length;
        int[] decrypted = new int[n];

        // Handle k == 0 case
        if (k == 0) {
            return decrypted; // All zeros
        }

        // Initialize window boundaries
        int start, end;
        if (k > 0) {
            start = 1;
            end = k;
        } else {
            start = n + k;
            end = n - 1;
        }

        // Calculate initial window sum
        int windowSum = 0;
        for (int i = start; i <= end; i++) {
            windowSum += code[i % n];
        }

        // Slide the window
        for (int i = 0; i < n; i++) {
            decrypted[i] = windowSum;

            // Update window for next iteration
            windowSum -= code[start % n];
            start = (start + 1) % n;
            end = (end + 1) % n;
            windowSum += code[end % n];
        }

        return decrypted;
    }

    /**
     * Approach 5: Two Pass with Separate Handling
     * 
     * Time Complexity: O(n) where n is the length of code Space Complexity: O(1) - only using
     * constant extra space
     * 
     * Strategy: Handle positive and negative k separately for cleaner code and better performance.
     */
    public int[] decryptTwoPass(int[] code, int k) {
        int n = code.length;
        int[] decrypted = new int[n];

        // Handle k == 0 case
        if (k == 0) {
            return decrypted; // All zeros
        }

        if (k > 0) {
            return decryptPositiveK(code, k);
        } else {
            return decryptNegativeK(code, Math.abs(k));
        }
    }

    private int[] decryptPositiveK(int[] code, int k) {
        int n = code.length;
        int[] decrypted = new int[n];

        // Calculate initial sum for first element
        int sum = 0;
        for (int i = 1; i <= k; i++) {
            sum += code[i % n];
        }

        // Fill decrypted array using sliding window
        for (int i = 0; i < n; i++) {
            decrypted[i] = sum;
            sum = sum - code[(i + 1) % n] + code[(i + 1 + k) % n];
        }

        return decrypted;
    }

    private int[] decryptNegativeK(int[] code, int k) {
        int n = code.length;
        int[] decrypted = new int[n];

        // Calculate initial sum for first element
        int sum = 0;
        for (int i = 1; i <= k; i++) {
            sum += code[(n - i) % n];
        }

        // Fill decrypted array using sliding window
        for (int i = 0; i < n; i++) {
            decrypted[i] = sum;
            sum = sum - code[(n - k + i) % n] + code[i % n];
        }

        return decrypted;
    }

    /**
     * Approach 6: Recursive with Memoization
     * 
     * Time Complexity: O(n) where n is the length of code Space Complexity: O(n) for recursion
     * stack
     * 
     * Strategy: Use recursion for educational purposes, though not the most efficient approach.
     */
    public int[] decryptRecursive(int[] code, int k) {
        int n = code.length;
        int[] decrypted = new int[n];

        // Handle k == 0 case
        if (k == 0) {
            return decrypted; // All zeros
        }

        // Calculate initial window sum
        int windowSum = calculateInitialSum(code, k);

        return decryptRecursiveHelper(code, k, decrypted, windowSum, 0, n);
    }

    private int calculateInitialSum(int[] code, int k) {
        int n = code.length;
        int sum = 0;

        if (k > 0) {
            for (int i = 1; i <= k; i++) {
                sum += code[i % n];
            }
        } else {
            for (int i = 1; i <= Math.abs(k); i++) {
                sum += code[(n - i) % n];
            }
        }

        return sum;
    }

    private int[] decryptRecursiveHelper(int[] code, int k, int[] decrypted, int windowSum,
            int index, int n) {
        if (index >= n) {
            return decrypted;
        }

        decrypted[index] = windowSum;

        // Calculate next window sum
        int nextWindowSum;
        if (k > 0) {
            nextWindowSum = windowSum - code[(index + 1) % n] + code[(index + 1 + k) % n];
        } else {
            nextWindowSum = windowSum - code[(n - Math.abs(k) + index) % n] + code[index % n];
        }

        return decryptRecursiveHelper(code, k, decrypted, nextWindowSum, index + 1, n);
    }

    /**
     * Utility method to validate if k is within valid range
     */
    public static boolean isValidK(int[] code, int k) {
        int n = code.length;
        return k >= -(n - 1) && k <= (n - 1);
    }

    /**
     * Utility method to calculate sum of elements in circular array
     */
    public static int calculateCircularSum(int[] code, int start, int count) {
        int n = code.length;
        int sum = 0;

        for (int i = 0; i < count; i++) {
            sum += code[(start + i) % n];
        }

        return sum;
    }

    /**
     * Utility method to get next k elements from given index
     */
    public static int[] getNextKElements(int[] code, int startIndex, int k) {
        int n = code.length;
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = code[(startIndex + 1 + i) % n];
        }

        return result;
    }

    /**
     * Utility method to get previous k elements from given index
     */
    public static int[] getPreviousKElements(int[] code, int startIndex, int k) {
        int n = code.length;
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = code[(startIndex - 1 - i + n) % n];
        }

        return result;
    }

    /**
     * Utility method to check if array is circular
     */
    public static boolean isCircularArray(int[] code) {
        // By definition, all arrays in this problem are circular
        return true;
    }

    /**
     * Utility method to find maximum element in array
     */
    public static int findMaxElement(int[] code) {
        if (code == null || code.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        int max = code[0];
        for (int i = 1; i < code.length; i++) {
            max = Math.max(max, code[i]);
        }
        return max;
    }

    /**
     * Utility method to find minimum element in array
     */
    public static int findMinElement(int[] code) {
        if (code == null || code.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        int min = code[0];
        for (int i = 1; i < code.length; i++) {
            min = Math.min(min, code[i]);
        }
        return min;
    }

    /**
     * Utility method to calculate total sum of array
     */
    public static int calculateTotalSum(int[] code) {
        int sum = 0;
        for (int num : code) {
            sum += num;
        }
        return sum;
    }

    /**
     * Utility method to print array elements
     */
    public static void printArray(int[] code) {
        System.out.println(Arrays.toString(code));
    }

    /**
     * Utility method to verify decrypted result
     */
    public static boolean verifyDecryption(int[] original, int[] decrypted, int k) {
        if (original.length != decrypted.length) {
            return false;
        }

        if (k == 0) {
            for (int num : decrypted) {
                if (num != 0) {
                    return false;
                }
            }
            return true;
        }

        // Verify each element
        for (int i = 0; i < original.length; i++) {
            int expectedSum = 0;
            if (k > 0) {
                for (int j = 1; j <= k; j++) {
                    expectedSum += original[(i + j) % original.length];
                }
            } else {
                for (int j = 1; j <= Math.abs(k); j++) {
                    expectedSum += original[(i - j + original.length) % original.length];
                }
            }

            if (decrypted[i] != expectedSum) {
                return false;
            }
        }

        return true;
    }
}
