package com.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 1: Two Sum
 * 
 * Given an array of integers nums and an integer target, return indices of the two numbers such
 * that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may not use the same
 * element twice.
 * 
 * You can return the answer in any order.
 * 
 * Examples: Input: nums = [2,7,11,15], target = 9 Output: [0,1] Explanation: Because nums[0] +
 * nums[1] == 9, we return [0, 1].
 * 
 * Input: nums = [3,2,4], target = 6 Output: [1,2]
 * 
 * Input: nums = [3,3], target = 6 Output: [0,1]
 * 
 * Constraints: - 2 <= nums.length <= 10^4 - -10^9 <= nums[i] <= 10^9 - -10^9 <= target <= 10^9 -
 * Only one valid answer exists.
 */
public class TwoSum {

    // ========================================
    // APPROACH 1: HASH MAP - ONE PASS (OPTIMAL)
    // Time: O(n), Space: O(n)
    // ========================================

    /**
     * Approach 1: Hash Map - One Pass (Recommended)
     * 
     * This is the optimal solution for the Two Sum problem.
     * 
     * Algorithm: 1. Create a hash map to store each number and its index 2. For each number,
     * calculate its complement (target - current number) 3. Check if the complement exists in the
     * hash map 4. If found, return the indices; otherwise, add current number to map
     * 
     * Key insights: - We only need to traverse the array once - Hash map provides O(1) lookup time
     * - We check for complement before adding current element to avoid using same element twice
     * 
     * Time Complexity: O(n) where n is the length of the array Space Complexity: O(n) for the hash
     * map
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        Map<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if complement exists in the map
            if (numToIndex.containsKey(complement)) {
                return new int[] {numToIndex.get(complement), i};
            }

            // Add current number and its index to the map
            numToIndex.put(nums[i], i);
        }

        // No solution found (shouldn't happen based on problem constraints)
        return new int[0];
    }

    // ========================================
    // APPROACH 2: HASH MAP - TWO PASS
    // Time: O(n), Space: O(n)
    // ========================================

    /**
     * Approach 2: Hash Map - Two Pass
     * 
     * This approach uses two passes through the array.
     * 
     * Algorithm: 1. First pass: Store all numbers and their indices in a hash map 2. Second pass:
     * For each number, check if its complement exists in the map 3. Ensure we don't use the same
     * element twice (i != complement_index)
     * 
     * Time Complexity: O(n) - two passes through the array Space Complexity: O(n) for the hash map
     */
    public int[] twoSumTwoPass(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        // First pass: build the hash map
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numToIndex.put(nums[i], i);
        }

        // Second pass: find the complement
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if complement exists and it's not the same element
            if (numToIndex.containsKey(complement) && numToIndex.get(complement) != i) {
                return new int[] {i, numToIndex.get(complement)};
            }
        }

        return new int[0];
    }

    // ========================================
    // APPROACH 3: BRUTE FORCE
    // Time: O(n²), Space: O(1)
    // ========================================

    /**
     * Approach 3: Brute Force
     * 
     * This is the simplest but least efficient approach.
     * 
     * Algorithm: 1. Use two nested loops to check all possible pairs 2. For each pair (i, j) where
     * i < j, check if nums[i] + nums[j] == target 3. Return indices when a valid pair is found
     * 
     * Time Complexity: O(n²) where n is the length of the array Space Complexity: O(1) - only uses
     * constant extra space
     */
    public int[] twoSumBruteForce(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }

        return new int[0];
    }

    // ========================================
    // APPROACH 4: SORTING + TWO POINTERS (Modified)
    // Time: O(n log n), Space: O(n)
    // ========================================

    /**
     * Approach 4: Sorting + Two Pointers
     * 
     * This approach sorts the array first, then uses two pointers. Note: We need to track original
     * indices since sorting changes positions.
     * 
     * Algorithm: 1. Create pairs of (value, original_index) 2. Sort the pairs by value 3. Use two
     * pointers to find the pair that sums to target 4. Return the original indices
     * 
     * Time Complexity: O(n log n) due to sorting Space Complexity: O(n) for storing value-index
     * pairs
     */
    public int[] twoSumSortingTwoPointers(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        // Create pairs of (value, index)
        int[][] pairs = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            pairs[i][0] = nums[i]; // value
            pairs[i][1] = i; // original index
        }

        // Sort by value
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        // Two pointers approach
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = pairs[left][0] + pairs[right][0];

            if (sum == target) {
                // Return original indices (order doesn't matter)
                return new int[] {pairs[left][1], pairs[right][1]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[0];
    }

    // ========================================
    // UTILITY METHODS
    // ========================================

    /**
     * Validates if the returned indices form a valid solution
     */
    public boolean isValidSolution(int[] nums, int target, int[] result) {
        if (result == null || result.length != 2) {
            return false;
        }

        int i = result[0];
        int j = result[1];

        if (i < 0 || i >= nums.length || j < 0 || j >= nums.length || i == j) {
            return false;
        }

        return nums[i] + nums[j] == target;
    }

    /**
     * Compares two result arrays (order-independent)
     */
    public boolean areResultsEqual(int[] result1, int[] result2) {
        if (result1 == null || result2 == null) {
            return result1 == result2;
        }

        if (result1.length != 2 || result2.length != 2) {
            return false;
        }

        return (result1[0] == result2[0] && result1[1] == result2[1])
                || (result1[0] == result2[1] && result1[1] == result2[0]);
    }

    /**
     * Prints the result in a readable format
     */
    public String formatResult(int[] nums, int target, int[] result) {
        if (result == null || result.length == 0) {
            return "No solution found";
        }

        int i = result[0];
        int j = result[1];

        return String.format("Indices: [%d, %d], Values: [%d, %d], Sum: %d, Target: %d", i, j,
                nums[i], nums[j], nums[i] + nums[j], target);
    }

    // ========================================
    // MAIN METHOD FOR TESTING
    // ========================================

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        // Test Case 1: LeetCode Example 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("Test 1 - " + solution.formatResult(nums1, target1, result1));

        // Test Case 2: LeetCode Example 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("Test 2 - " + solution.formatResult(nums2, target2, result2));

        // Test Case 3: LeetCode Example 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("Test 3 - " + solution.formatResult(nums3, target3, result3));

        // Test Case 4: Negative numbers
        int[] nums4 = {-1, -2, -3, -4, -5};
        int target4 = -8;
        int[] result4 = solution.twoSum(nums4, target4);
        System.out.println("Test 4 - " + solution.formatResult(nums4, target4, result4));

        // Test Case 5: Mixed positive and negative
        int[] nums5 = {-3, 4, 3, 90};
        int target5 = 0;
        int[] result5 = solution.twoSum(nums5, target5);
        System.out.println("Test 5 - " + solution.formatResult(nums5, target5, result5));

        System.out.println("\n=== Approach Comparison ===");

        // Compare all approaches
        int[] testNums = {2, 7, 11, 15};
        int testTarget = 9;

        System.out
                .println("Input: nums = " + Arrays.toString(testNums) + ", target = " + testTarget);

        int[] hashMapResult = solution.twoSum(testNums, testTarget);
        System.out.println("Hash Map (One Pass): " + Arrays.toString(hashMapResult));

        int[] twoPassResult = solution.twoSumTwoPass(testNums, testTarget);
        System.out.println("Hash Map (Two Pass): " + Arrays.toString(twoPassResult));

        int[] bruteForceResult = solution.twoSumBruteForce(testNums, testTarget);
        System.out.println("Brute Force: " + Arrays.toString(bruteForceResult));

        int[] sortingResult = solution.twoSumSortingTwoPointers(testNums, testTarget);
        System.out.println("Sorting + Two Pointers: " + Arrays.toString(sortingResult));
    }
}

