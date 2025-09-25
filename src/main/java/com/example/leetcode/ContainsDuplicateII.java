package com.example.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LeetCode 219. Contains Duplicate II
 * 
 * Problem Description: Given an integer array nums and an integer k, return true if there are two
 * distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 * 
 * Example 1: Input: nums = [1,2,3,1], k = 3 Output: true
 * 
 * Example 2: Input: nums = [1,0,1,1], k = 1 Output: true
 * 
 * Example 3: Input: nums = [1,2,3,1,2,3], k = 2 Output: false
 * 
 * Constraints: - 1 <= nums.length <= 10^5 - -10^9 <= nums[i] <= 10^9 - 0 <= k <= 10^5
 * 
 * Approach Analysis: 1. Sliding Window with HashSet: O(n) time, O(min(n,k)) space - Most efficient
 * for this problem 2. HashMap with Index Tracking: O(n) time, O(n) space - Alternative approach
 * with index tracking 3. Brute Force: O(n*k) time, O(1) space - Educational baseline approach
 * 
 * @author LeetCode Solutions
 * @version 1.0
 */
public class ContainsDuplicateII {

    /**
     * Approach 1: Sliding Window with HashSet - Optimal Solution
     * 
     * Time Complexity: O(n) - Single pass through the array Space Complexity: O(min(n, k)) -
     * HashSet stores at most k elements
     * 
     * This is the most efficient approach for this problem. We maintain a sliding window of size
     * k+1 using a HashSet. For each element, we check if it already exists in the current window.
     * 
     * @param nums The input array
     * @param k The maximum allowed distance between duplicate indices
     * @return true if duplicates exist within distance k, false otherwise
     */
    public static boolean containsNearbyDuplicateSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k < 0) {
            return false;
        }

        // Special case: k = 0 means we can only have duplicates at the same index
        // Since we can't have duplicates at the same index, return false
        if (k == 0) {
            return false;
        }

        Set<Integer> window = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            // Remove element that's now outside the window (if window size > k)
            if (i > k) {
                window.remove(nums[i - k - 1]);
            }

            // Check if current element already exists in the window
            if (window.contains(nums[i])) {
                return true;
            }

            // Add current element to the window
            window.add(nums[i]);
        }
        return false;
    }

    /**
     * Approach 2: HashMap with Index Tracking - Alternative Approach
     * 
     * Time Complexity: O(n) - Single pass through the array Space Complexity: O(n) - HashMap stores
     * all unique elements with their indices
     * 
     * We use a HashMap to store each element and its most recent index. For each element, we check
     * if it exists and if the distance from its previous occurrence is <= k.
     * 
     * @param nums The input array
     * @param k The maximum allowed distance between duplicate indices
     * @return true if duplicates exist within distance k, false otherwise
     */
    public static boolean containsNearbyDuplicateHashMap(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k < 0) {
            return false;
        }

        // Special case: k = 0 means we can only have duplicates at the same index
        // Since we can't have duplicates at the same index, return false
        if (k == 0) {
            return false;
        }

        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(nums[i])) {
                int prevIndex = indexMap.get(nums[i]);
                if (i - prevIndex <= k) {
                    return true;
                }
            }
            indexMap.put(nums[i], i);
        }
        return false;
    }

    /**
     * Approach 3: Brute Force - Educational Purpose Only
     * 
     * Time Complexity: O(n*k) - For each element, check up to k elements ahead Space Complexity:
     * O(1) - No additional space used
     * 
     * This approach is included for educational purposes to show the naive solution. It compares
     * each element with up to k elements ahead.
     * 
     * @param nums The input array
     * @param k The maximum allowed distance between duplicate indices
     * @return true if duplicates exist within distance k, false otherwise
     */
    public static boolean containsNearbyDuplicateBruteForce(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k < 0) {
            return false;
        }

        // Special case: k = 0 means we can only have duplicates at the same index
        // Since we can't have duplicates at the same index, return false
        if (k == 0) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= Math.min(i + k, nums.length - 1); j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Approach 4: Optimized Sliding Window - Enhanced Version
     * 
     * Time Complexity: O(n) - Single pass with optimized operations Space Complexity: O(min(n, k))
     * - HashSet with pre-allocated capacity
     * 
     * Enhanced version of the sliding window approach with optimizations like pre-allocated HashSet
     * capacity and early termination conditions.
     * 
     * @param nums The input array
     * @param k The maximum allowed distance between duplicate indices
     * @return true if duplicates exist within distance k, false otherwise
     */
    public static boolean containsNearbyDuplicateOptimized(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k < 0) {
            return false;
        }

        // Special case: k = 0 means we can only have duplicates at the same index
        // Since we can't have duplicates at the same index, return false
        if (k == 0) {
            return false;
        }

        // Early termination: if k >= nums.length, any duplicate will satisfy the condition
        if (k >= nums.length - 1) {
            return containsNearbyDuplicateHashMap(nums, k);
        }

        // Pre-allocate HashSet with expected capacity
        Set<Integer> window = new HashSet<>(Math.min(k + 1, nums.length));

        for (int i = 0; i < nums.length; i++) {
            // Remove element outside the window
            if (i > k) {
                window.remove(nums[i - k - 1]);
            }

            // Check and add current element
            if (!window.add(nums[i])) {
                return true; // add() returns false if element already exists
            }
        }
        return false;
    }

    /**
     * Approach 5: Sliding Window with Array - Space Optimized
     * 
     * Time Complexity: O(n*k) worst case, O(n) average Space Complexity: O(k) - Fixed size array
     * for the sliding window
     * 
     * Alternative implementation using an array to represent the sliding window. This approach uses
     * less memory overhead than HashSet for small k values.
     * 
     * @param nums The input array
     * @param k The maximum allowed distance between duplicate indices
     * @return true if duplicates exist within distance k, false otherwise
     */
    public static boolean containsNearbyDuplicateArrayWindow(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k < 0) {
            return false;
        }

        // Special case: k = 0 means we can only have duplicates at the same index
        // Since we can't have duplicates at the same index, return false
        if (k == 0) {
            return false;
        }

        // For small k, use array-based approach
        if (k <= 100) {
            for (int i = 0; i < nums.length; i++) {
                int start = Math.max(0, i - k);
                int end = Math.min(nums.length - 1, i + k);

                for (int j = start; j <= end; j++) {
                    if (i != j && nums[i] == nums[j]) {
                        return true;
                    }
                }
            }
            return false;
        }

        // For larger k, fall back to HashSet approach
        return containsNearbyDuplicateSlidingWindow(nums, k);
    }

    /**
     * Main method for testing and demonstration
     */
    public static void main(String[] args) {
        // Test cases from LeetCode examples
        int[] test1 = {1, 2, 3, 1};
        int[] test2 = {1, 0, 1, 1};
        int[] test3 = {1, 2, 3, 1, 2, 3};
        int k1 = 3, k2 = 1, k3 = 2;

        System.out.println("=== Contains Duplicate II Test Cases ===");

        // Test Sliding Window approach
        System.out.println("\nSliding Window Approach:");
        System.out.println(
                "Test 1 [1,2,3,1], k=3: " + containsNearbyDuplicateSlidingWindow(test1, k1)); // Expected:
                                                                                              // true
        System.out.println(
                "Test 2 [1,0,1,1], k=1: " + containsNearbyDuplicateSlidingWindow(test2, k2)); // Expected:
                                                                                              // true
        System.out.println(
                "Test 3 [1,2,3,1,2,3], k=2: " + containsNearbyDuplicateSlidingWindow(test3, k3)); // Expected:
                                                                                                  // false

        // Test HashMap approach
        System.out.println("\nHashMap Approach:");
        System.out.println("Test 1 [1,2,3,1], k=3: " + containsNearbyDuplicateHashMap(test1, k1));
        System.out.println("Test 2 [1,0,1,1], k=1: " + containsNearbyDuplicateHashMap(test2, k2));
        System.out
                .println("Test 3 [1,2,3,1,2,3], k=2: " + containsNearbyDuplicateHashMap(test3, k3));

        // Test Optimized approach
        System.out.println("\nOptimized Approach:");
        System.out.println("Test 1 [1,2,3,1], k=3: " + containsNearbyDuplicateOptimized(test1, k1));
        System.out.println("Test 2 [1,0,1,1], k=1: " + containsNearbyDuplicateOptimized(test2, k2));
        System.out.println(
                "Test 3 [1,2,3,1,2,3], k=2: " + containsNearbyDuplicateOptimized(test3, k3));

        // Performance comparison
        System.out.println("\n=== Performance Analysis ===");
        performanceTest();
    }

    /**
     * Performance testing method to compare different approaches
     */
    private static void performanceTest() {
        // Create test data with different scenarios
        int[] smallArray = generateTestArray(1000, 50);
        int[] mediumArray = generateTestArray(10000, 100);
        int[] largeArray = generateTestArray(100000, 1000);

        System.out.println("\nSmall Array (1000 elements, k=50):");
        timeApproach("Sliding Window",
                () -> containsNearbyDuplicateSlidingWindow(smallArray.clone(), 50));
        timeApproach("HashMap", () -> containsNearbyDuplicateHashMap(smallArray.clone(), 50));
        timeApproach("Optimized", () -> containsNearbyDuplicateOptimized(smallArray.clone(), 50));
        timeApproach("Array Window",
                () -> containsNearbyDuplicateArrayWindow(smallArray.clone(), 50));

        System.out.println("\nMedium Array (10000 elements, k=100):");
        timeApproach("Sliding Window",
                () -> containsNearbyDuplicateSlidingWindow(mediumArray.clone(), 100));
        timeApproach("HashMap", () -> containsNearbyDuplicateHashMap(mediumArray.clone(), 100));
        timeApproach("Optimized", () -> containsNearbyDuplicateOptimized(mediumArray.clone(), 100));
        timeApproach("Array Window",
                () -> containsNearbyDuplicateArrayWindow(mediumArray.clone(), 100));

        System.out.println("\nLarge Array (100000 elements, k=1000):");
        timeApproach("Sliding Window",
                () -> containsNearbyDuplicateSlidingWindow(largeArray.clone(), 1000));
        timeApproach("HashMap", () -> containsNearbyDuplicateHashMap(largeArray.clone(), 1000));
        timeApproach("Optimized", () -> containsNearbyDuplicateOptimized(largeArray.clone(), 1000));
        timeApproach("Array Window",
                () -> containsNearbyDuplicateArrayWindow(largeArray.clone(), 1000));
    }

    /**
     * Helper method to generate test arrays with controlled duplicates
     */
    private static int[] generateTestArray(int size, int maxValue) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i % maxValue; // This creates controlled duplicates
        }
        return arr;
    }

    /**
     * Helper method to time approach execution
     */
    private static void timeApproach(String name, Runnable approach) {
        long startTime = System.nanoTime();
        approach.run();
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000.0; // Convert to milliseconds
        System.out.printf("%-15s: %.3f ms%n", name, duration);
    }
}
