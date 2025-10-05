package com.example.leetcode;

import java.util.Arrays;

/**
 * LeetCode 643: Maximum Average Subarray I
 * 
 * Problem Description: You are given an integer array nums consisting of n elements, and an integer
 * k. Find a contiguous subarray whose length is equal to k that has the maximum average value and
 * return this value. Any answer with a calculation error less than 10^-5 will be accepted.
 * 
 * Example 1: Input: nums = [1,12,-5,-6,50,3], k = 4 Output: 12.75000 Explanation: Maximum average
 * is (12-5-6+50)/4 = 51/4 = 12.75
 * 
 * Example 2: Input: nums = [5], k = 1 Output: 5.00000
 * 
 * Constraints: - n == nums.length - 1 <= k <= n <= 10^5 - -10^4 <= nums[i] <= 10^4
 * 
 * Time Complexity Analysis: - Sliding Window Approach: O(n) time, O(1) space - Brute Force
 * Approach: O(n*k) time, O(1) space - Prefix Sum Approach: O(n) time, O(n) space - Optimized
 * Sliding Window: O(n) time, O(1) space
 */
public class MaximumAverageSubarrayI {

    /**
     * Approach 1: Sliding Window (Recommended)
     * 
     * Time Complexity: O(n) where n is the length of nums Space Complexity: O(1) - only using
     * constant extra space
     * 
     * Strategy: Use sliding window technique to efficiently calculate the sum of each subarray of
     * length k. Start with the first window, then slide the window by removing the leftmost element
     * and adding the rightmost element.
     */
    public double findMaxAverageSlidingWindow(int[] nums, int k) {
        // Calculate sum of first k elements
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int maxSum = windowSum;

        // Slide the window across the array
        for (int i = k; i < nums.length; i++) {
            // Remove the leftmost element and add the rightmost element
            windowSum = windowSum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, windowSum);
        }

        return (double) maxSum / k;
    }

    /**
     * Approach 2: Brute Force
     * 
     * Time Complexity: O(n*k) where n is the length of nums and k is the subarray length Space
     * Complexity: O(1) - only using constant extra space
     * 
     * Strategy: For each possible starting position, calculate the sum of the next k elements. This
     * approach is less efficient but easier to understand.
     */
    public double findMaxAverageBruteForce(int[] nums, int k) {
        double maxAverage = Double.NEGATIVE_INFINITY;

        for (int i = 0; i <= nums.length - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += nums[j];
            }
            double average = (double) sum / k;
            maxAverage = Math.max(maxAverage, average);
        }

        return maxAverage;
    }

    /**
     * Approach 3: Prefix Sum
     * 
     * Time Complexity: O(n) where n is the length of nums Space Complexity: O(n) for the prefix sum
     * array
     * 
     * Strategy: Build a prefix sum array to quickly calculate the sum of any subarray. Then iterate
     * through all possible subarrays of length k.
     */
    public double findMaxAveragePrefixSum(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];

        // Build prefix sum array
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        double maxAverage = Double.NEGATIVE_INFINITY;

        // Find maximum average using prefix sum
        for (int i = 0; i <= n - k; i++) {
            int sum = prefixSum[i + k] - prefixSum[i];
            double average = (double) sum / k;
            maxAverage = Math.max(maxAverage, average);
        }

        return maxAverage;
    }

    /**
     * Approach 4: Optimized Sliding Window with Early Termination
     * 
     * Time Complexity: O(n) where n is the length of nums Space Complexity: O(1) - only using
     * constant extra space
     * 
     * Strategy: Similar to sliding window but with additional optimizations and early termination
     * conditions.
     */
    public double findMaxAverageOptimized(int[] nums, int k) {
        if (nums.length == 1) {
            return (double) nums[0];
        }

        // Calculate sum of first k elements
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int maxSum = windowSum;

        // Slide the window
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];
            if (windowSum > maxSum) {
                maxSum = windowSum;
            }
        }

        return (double) maxSum / k;
    }

    /**
     * Approach 5: Sliding Window with Double Precision
     * 
     * Time Complexity: O(n) where n is the length of nums Space Complexity: O(1) - only using
     * constant extra space
     * 
     * Strategy: Use double precision for sum calculations to avoid integer overflow and maintain
     * precision.
     */
    public double findMaxAverageDoublePrecision(int[] nums, int k) {
        double windowSum = 0.0;

        // Calculate sum of first k elements
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        double maxSum = windowSum;

        // Slide the window
        for (int i = k; i < nums.length; i++) {
            windowSum = windowSum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum / k;
    }

    /**
     * Approach 6: Recursive Sliding Window
     * 
     * Time Complexity: O(n) where n is the length of nums Space Complexity: O(n) due to recursion
     * stack
     * 
     * Strategy: Implement sliding window using recursion for educational purposes.
     */
    public double findMaxAverageRecursive(int[] nums, int k) {
        if (nums.length == 1) {
            return (double) nums[0];
        }

        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        return findMaxAverageRecursiveHelper(nums, k, windowSum, windowSum, k);
    }

    private double findMaxAverageRecursiveHelper(int[] nums, int k, int currentSum, int maxSum,
            int index) {
        if (index >= nums.length) {
            return (double) maxSum / k;
        }

        currentSum = currentSum - nums[index - k] + nums[index];
        maxSum = Math.max(maxSum, currentSum);

        return findMaxAverageRecursiveHelper(nums, k, currentSum, maxSum, index + 1);
    }

    /**
     * Utility method to calculate the sum of a subarray
     */
    public static int calculateSubarraySum(int[] nums, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        return sum;
    }

    /**
     * Utility method to calculate the average of a subarray
     */
    public static double calculateSubarrayAverage(int[] nums, int start, int end) {
        int sum = calculateSubarraySum(nums, start, end);
        return (double) sum / (end - start + 1);
    }

    /**
     * Utility method to find all subarrays of length k
     */
    public static int[][] findAllSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[][] subarrays = new int[n - k + 1][k];

        for (int i = 0; i <= n - k; i++) {
            for (int j = 0; j < k; j++) {
                subarrays[i][j] = nums[i + j];
            }
        }

        return subarrays;
    }

    /**
     * Utility method to calculate prefix sum array
     */
    public static int[] calculatePrefixSum(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        return prefixSum;
    }

    /**
     * Utility method to get subarray sum using prefix sum
     */
    public static int getSubarraySum(int[] prefixSum, int start, int end) {
        return prefixSum[end + 1] - prefixSum[start];
    }

    /**
     * Utility method to validate if k is within valid range
     */
    public static boolean isValidK(int[] nums, int k) {
        return k > 0 && k <= nums.length;
    }

    /**
     * Utility method to find the maximum element in array
     */
    public static int findMaxElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    /**
     * Utility method to find the minimum element in array
     */
    public static int findMinElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        return min;
    }

    /**
     * Utility method to calculate the sum of entire array
     */
    public static long calculateTotalSum(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    /**
     * Utility method to check if array contains only positive numbers
     */
    public static boolean containsOnlyPositive(int[] nums) {
        for (int num : nums) {
            if (num <= 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Utility method to check if array contains only negative numbers
     */
    public static boolean containsOnlyNegative(int[] nums) {
        for (int num : nums) {
            if (num >= 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Utility method to print array elements
     */
    public static void printArray(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }

    /**
     * Utility method to print subarray
     */
    public static void printSubarray(int[] nums, int start, int end) {
        System.out.print("[");
        for (int i = start; i <= end; i++) {
            System.out.print(nums[i]);
            if (i < end) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
