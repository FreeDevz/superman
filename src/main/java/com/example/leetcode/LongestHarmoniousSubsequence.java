package com.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 594: Longest Harmonious Subsequence
 * 
 * Problem Description: We define a harmonious array as an array where the difference between its
 * maximum value and its minimum value is exactly 1. Given an integer array nums, return the length
 * of its longest harmonious subsequence among all its possible subsequences.
 * 
 * Example 1: Input: nums = [1,3,2,2,5,2,3,7] Output: 5 Explanation: The longest harmonious
 * subsequence is [3,2,2,2,3].
 * 
 * Example 2: Input: nums = [1,2,3,4] Output: 2
 * 
 * Example 3: Input: nums = [1,1,1,1] Output: 0
 * 
 * Constraints: - 1 <= nums.length <= 2 * 10^4 - -10^9 <= nums[i] <= 10^9
 * 
 * Time Complexity Analysis: - HashMap Approach: O(n) time, O(n) space - Sorting Approach: O(n log
 * n) time, O(1) space - Two Pass Approach: O(n) time, O(n) space - Single Pass Approach: O(n) time,
 * O(n) space
 */
public class LongestHarmoniousSubsequence {

    /**
     * Approach 1: HashMap with Frequency Counting (Recommended)
     * 
     * Time Complexity: O(n) where n is the length of nums Space Complexity: O(n) for the frequency
     * map
     * 
     * Strategy: Count frequency of each number, then for each number x, check if x+1 exists. If so,
     * the harmonious subsequence length is count[x] + count[x+1].
     */
    public int findLHSHashMap(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        // Count frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int maxLength = 0;
        // For each number, check if its consecutive number exists
        for (int num : frequencyMap.keySet()) {
            if (frequencyMap.containsKey(num + 1)) {
                maxLength = Math.max(maxLength, frequencyMap.get(num) + frequencyMap.get(num + 1));
            }
        }

        return maxLength;
    }

    /**
     * Approach 2: Sorting with Sliding Window
     * 
     * Time Complexity: O(n log n) where n is the length of nums Space Complexity: O(1) if we don't
     * count the sorting space
     * 
     * Strategy: Sort the array, then use sliding window to find the longest subsequence where max -
     * min = 1.
     */
    public int findLHSSorting(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        Arrays.sort(nums);
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            // Shrink window until difference is <= 1
            while (nums[right] - nums[left] > 1) {
                left++;
            }

            // If difference is exactly 1, update max length
            if (nums[right] - nums[left] == 1) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        return maxLength;
    }

    /**
     * Approach 3: Two Pass with Separate Counters
     * 
     * Time Complexity: O(n) where n is the length of nums Space Complexity: O(n) for the frequency
     * map
     * 
     * Strategy: First pass to count frequencies, second pass to find maximum harmonious length.
     */
    public int findLHSTwoPass(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        // First pass: count frequencies
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int maxLength = 0;
        // Second pass: find maximum harmonious subsequence length
        for (int num : frequencyMap.keySet()) {
            int currentCount = frequencyMap.get(num);
            int nextCount = frequencyMap.getOrDefault(num + 1, 0);
            int prevCount = frequencyMap.getOrDefault(num - 1, 0);

            // Check both directions (num-1, num) and (num, num+1)
            if (nextCount > 0) {
                maxLength = Math.max(maxLength, currentCount + nextCount);
            }
            if (prevCount > 0) {
                maxLength = Math.max(maxLength, currentCount + prevCount);
            }
        }

        return maxLength;
    }

    /**
     * Approach 4: Single Pass with Early Termination
     * 
     * Time Complexity: O(n) where n is the length of nums Space Complexity: O(n) for the frequency
     * map
     * 
     * Strategy: Count frequencies in one pass while simultaneously checking for harmonious pairs.
     */
    public int findLHSSinglePass(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int maxLength = 0;

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);

            // Check current number with its consecutive numbers
            int currentCount = frequencyMap.get(num);
            int nextCount = frequencyMap.getOrDefault(num + 1, 0);
            int prevCount = frequencyMap.getOrDefault(num - 1, 0);

            if (nextCount > 0) {
                maxLength = Math.max(maxLength, currentCount + nextCount);
            }
            if (prevCount > 0) {
                maxLength = Math.max(maxLength, currentCount + prevCount);
            }
        }

        return maxLength;
    }

    /**
     * Approach 5: Optimized HashMap with Entry Set Iteration
     * 
     * Time Complexity: O(n) where n is the length of nums Space Complexity: O(n) for the frequency
     * map
     * 
     * Strategy: Use entry set iteration for better performance and cleaner code.
     */
    public int findLHSOptimized(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.merge(num, 1, Integer::sum);
        }

        int maxLength = 0;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            int consecutiveCount = frequencyMap.getOrDefault(num + 1, 0);

            if (consecutiveCount > 0) {
                maxLength = Math.max(maxLength, count + consecutiveCount);
            }
        }

        return maxLength;
    }

    /**
     * Approach 6: Array-based Counter (for small integer ranges)
     * 
     * Time Complexity: O(n) where n is the length of nums Space Complexity: O(range) where range is
     * the difference between max and min values
     * 
     * Strategy: Use array-based counting for better performance when the range of values is small.
     * Note: This approach works well when the range of values is manageable.
     */
    public int findLHSArrayBased(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        // Find min and max values
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // If range is too large, fall back to HashMap approach
        if (max - min > 100000) {
            return findLHSHashMap(nums);
        }

        // Use array-based counting
        int[] frequency = new int[max - min + 1];
        for (int num : nums) {
            frequency[num - min]++;
        }

        int maxLength = 0;
        for (int i = 0; i < frequency.length - 1; i++) {
            if (frequency[i] > 0 && frequency[i + 1] > 0) {
                maxLength = Math.max(maxLength, frequency[i] + frequency[i + 1]);
            }
        }

        return maxLength;
    }

    /**
     * Utility method to validate if a subsequence is harmonious
     */
    public static boolean isHarmonious(int[] subsequence) {
        if (subsequence == null || subsequence.length <= 1) {
            return false;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : subsequence) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return max - min == 1;
    }

    /**
     * Utility method to find the maximum value in an array
     */
    public static int findMax(int[] nums) {
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
     * Utility method to find the minimum value in an array
     */
    public static int findMin(int[] nums) {
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
     * Utility method to calculate the range of values in an array
     */
    public static int calculateRange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int min = findMin(nums);
        int max = findMax(nums);
        return max - min;
    }

    /**
     * Utility method to count distinct values in an array
     */
    public static int countDistinct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return (int) Arrays.stream(nums).distinct().count();
    }

    /**
     * Utility method to check if array has consecutive numbers
     */
    public static boolean hasConsecutiveNumbers(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (int num : frequencyMap.keySet()) {
            if (frequencyMap.containsKey(num + 1)) {
                return true;
            }
        }

        return false;
    }
}
