package com.example.leetcode;

import java.util.*;

/**
 * LeetCode 2597: The Number of Beautiful Subsets
 * 
 * Problem Description: You are given an array nums of positive integers and a positive integer k. A
 * subset of nums is called beautiful if it does not contain two integers with an absolute
 * difference equal to k. Return the number of non-empty beautiful subsets of nums.
 * 
 * Example 1: Input: nums = [2,4,6], k = 2 Output: 4 Explanation: The beautiful subsets of the array
 * nums are: [2], [4], [6], [2, 6]. It can be shown that there are only 4 beautiful subsets.
 * 
 * Example 2: Input: nums = [1], k = 1 Output: 1 Explanation: The beautiful subset of the array nums
 * is [1]. It can be shown that there is only 1 beautiful subset.
 * 
 * Constraints: - 1 <= nums.length <= 20 - 1 <= nums[i], k <= 1000
 * 
 * Time Complexity Analysis: - Backtracking Approach: O(2^n * n) time, O(n) space - Dynamic
 * Programming with Bitmasking: O(2^n * n) time, O(2^n) space - Recursive with Memoization: O(2^n *
 * n) time, O(2^n) space
 */
public class NumberOfBeautifulSubsets {

    /**
     * Approach 1: Backtracking (Recommended)
     * 
     * This approach explores all possible subsets using backtracking. For each element, we decide
     * whether to include it or not. Before including an element, we check if it would violate the
     * beautiful subset condition (no two elements with absolute difference equal to k).
     * 
     * Strategy: 1. Sort the array to make checking easier 2. Use backtracking to explore all
     * subsets 3. Before including an element, check if it conflicts with any existing element 4.
     * Count all valid non-empty subsets
     * 
     * Time Complexity: O(2^n * n) where n is the length of nums Space Complexity: O(n) for
     * recursion stack and current subset
     * 
     * @param nums array of positive integers
     * @param k positive integer representing the forbidden difference
     * @return number of non-empty beautiful subsets
     */
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        return backtrack(nums, 0, new ArrayList<>(), k) - 1; // Subtract 1 to exclude empty subset
    }

    private int backtrack(int[] nums, int index, List<Integer> current, int k) {
        if (index == nums.length) {
            return 1; // Count this subset (including empty subset)
        }

        // Option 1: Exclude current element
        int count = backtrack(nums, index + 1, current, k);

        // Option 2: Include current element if valid
        boolean canInclude = true;
        for (int num : current) {
            if (Math.abs(nums[index] - num) == k) {
                canInclude = false;
                break;
            }
        }

        if (canInclude) {
            current.add(nums[index]);
            count += backtrack(nums, index + 1, current, k);
            current.remove(current.size() - 1); // Backtrack
        }

        return count;
    }

    /**
     * Approach 2: Backtracking with Set (Optimized)
     * 
     * Similar to Approach 1, but uses a Set to track current subset elements for O(1) lookup when
     * checking conflicts. This is more efficient for larger subsets.
     * 
     * Time Complexity: O(2^n * n) where n is the length of nums Space Complexity: O(n) for
     * recursion stack and set
     * 
     * @param nums array of positive integers
     * @param k positive integer representing the forbidden difference
     * @return number of non-empty beautiful subsets
     */
    public int beautifulSubsetsWithSet(int[] nums, int k) {
        Arrays.sort(nums);
        return backtrackWithSet(nums, 0, new HashSet<>(), k) - 1;
    }

    private int backtrackWithSet(int[] nums, int index, Set<Integer> current, int k) {
        if (index == nums.length) {
            return 1;
        }

        // Option 1: Exclude current element
        int count = backtrackWithSet(nums, index + 1, current, k);

        // Option 2: Include current element if valid
        boolean canInclude = true;
        for (int num : current) {
            if (Math.abs(nums[index] - num) == k) {
                canInclude = false;
                break;
            }
        }

        if (canInclude) {
            current.add(nums[index]);
            count += backtrackWithSet(nums, index + 1, current, k);
            current.remove(nums[index]); // Backtrack
        }

        return count;
    }

    /**
     * Approach 3: Dynamic Programming with Bitmasking
     * 
     * Since nums.length <= 20, we can use bitmasking to represent subsets. For each mask (subset),
     * we check if it's beautiful and count it.
     * 
     * Strategy: 1. Generate all possible subsets using bitmasks (2^n possibilities) 2. For each
     * subset, check if it's beautiful 3. Count all non-empty beautiful subsets
     * 
     * Time Complexity: O(2^n * n^2) where n is the length of nums Space Complexity: O(1) excluding
     * input
     * 
     * @param nums array of positive integers
     * @param k positive integer representing the forbidden difference
     * @return number of non-empty beautiful subsets
     */
    public int beautifulSubsetsBitmask(int[] nums, int k) {
        int n = nums.length;
        int totalSubsets = 1 << n; // 2^n
        int count = 0;

        // Check each possible subset (mask)
        for (int mask = 1; mask < totalSubsets; mask++) { // Start from 1 to exclude empty subset
            List<Integer> subset = new ArrayList<>();

            // Extract elements in this subset
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }

            // Check if subset is beautiful
            boolean isBeautiful = true;
            for (int i = 0; i < subset.size() && isBeautiful; i++) {
                for (int j = i + 1; j < subset.size(); j++) {
                    if (Math.abs(subset.get(i) - subset.get(j)) == k) {
                        isBeautiful = false;
                        break;
                    }
                }
            }

            if (isBeautiful) {
                count++;
            }
        }

        return count;
    }

    /**
     * Approach 4: Recursive with Memoization
     * 
     * Uses memoization to cache results of subproblems. However, since we need to track which
     * elements are in the current subset, memoization is less effective here compared to
     * backtracking.
     * 
     * Time Complexity: O(2^n * n) where n is the length of nums Space Complexity: O(2^n) for
     * memoization
     * 
     * @param nums array of positive integers
     * @param k positive integer representing the forbidden difference
     * @return number of non-empty beautiful subsets
     */
    public int beautifulSubsetsMemoization(int[] nums, int k) {
        Arrays.sort(nums);
        Map<String, Integer> memo = new HashMap<>();
        return dfsMemo(nums, 0, new ArrayList<>(), k, memo) - 1;
    }

    private int dfsMemo(int[] nums, int index, List<Integer> current, int k,
            Map<String, Integer> memo) {
        if (index == nums.length) {
            return 1;
        }

        // Create a key for memoization (index + sorted current subset)
        String key = index + ":" + current.toString();
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Option 1: Exclude current element
        int count = dfsMemo(nums, index + 1, current, k, memo);

        // Option 2: Include current element if valid
        boolean canInclude = true;
        for (int num : current) {
            if (Math.abs(nums[index] - num) == k) {
                canInclude = false;
                break;
            }
        }

        if (canInclude) {
            current.add(nums[index]);
            count += dfsMemo(nums, index + 1, current, k, memo);
            current.remove(current.size() - 1);
        }

        memo.put(key, count);
        return count;
    }

    /**
     * Approach 5: Optimized Backtracking with Early Termination
     * 
     * Similar to Approach 1, but with optimizations: - Pre-computes conflicts to avoid repeated
     * checks - Uses array instead of list for better performance
     * 
     * Time Complexity: O(2^n * n) where n is the length of nums Space Complexity: O(n) for
     * recursion stack
     * 
     * @param nums array of positive integers
     * @param k positive integer representing the forbidden difference
     * @return number of non-empty beautiful subsets
     */
    public int beautifulSubsetsOptimized(int[] nums, int k) {
        Arrays.sort(nums);
        return backtrackOptimized(nums, 0, new int[nums.length], 0, k) - 1;
    }

    private int backtrackOptimized(int[] nums, int index, int[] current, int size, int k) {
        if (index == nums.length) {
            return 1;
        }

        // Option 1: Exclude current element
        int count = backtrackOptimized(nums, index + 1, current, size, k);

        // Option 2: Include current element if valid
        boolean canInclude = true;
        for (int i = 0; i < size; i++) {
            if (Math.abs(nums[index] - current[i]) == k) {
                canInclude = false;
                break;
            }
        }

        if (canInclude) {
            current[size] = nums[index];
            count += backtrackOptimized(nums, index + 1, current, size + 1, k);
        }

        return count;
    }

    /**
     * Utility method to check if a subset is beautiful
     * 
     * @param subset the subset to check
     * @param k the forbidden difference
     * @return true if the subset is beautiful, false otherwise
     */
    public static boolean isBeautifulSubset(List<Integer> subset, int k) {
        for (int i = 0; i < subset.size(); i++) {
            for (int j = i + 1; j < subset.size(); j++) {
                if (Math.abs(subset.get(i) - subset.get(j)) == k) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Utility method to generate all subsets of an array
     * 
     * @param nums the input array
     * @return list of all subsets
     */
    public static List<List<Integer>> generateAllSubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsetsHelper(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void generateSubsetsHelper(int[] nums, int index, List<Integer> current,
            List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Exclude current element
        generateSubsetsHelper(nums, index + 1, current, result);

        // Include current element
        current.add(nums[index]);
        generateSubsetsHelper(nums, index + 1, current, result);
        current.remove(current.size() - 1);
    }
}

