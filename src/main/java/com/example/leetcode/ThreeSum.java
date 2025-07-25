package com.example.leetcode;

import java.util.*;

/**
 * LeetCode 15: 3Sum
 * 
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i !=
 * j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * Examples: Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]]
 * 
 * Input: nums = [0,1,1] Output: []
 * 
 * Input: nums = [0,0,0] Output: [[0,0,0]]
 * 
 * Constraints: - 3 <= nums.length <= 3000 - -10^5 <= nums[i] <= 10^5 - Solution set must not
 * contain duplicate triplets
 */
public class ThreeSum {

    // ========================================
    // APPROACH 1: SORTING + TWO POINTERS (OPTIMAL)
    // Time: O(n²), Space: O(1) excluding output
    // ========================================

    /**
     * Approach 1: Sorting + Two Pointers (Recommended)
     * 
     * This is the optimal solution for the 3Sum problem.
     * 
     * Algorithm: 1. Sort the array to enable two-pointer technique and easy duplicate skipping 2.
     * For each element nums[i], treat it as the first element of potential triplet 3. Use two
     * pointers (left=i+1, right=n-1) to find pairs that sum to -nums[i] 4. Skip duplicates at all
     * levels to avoid duplicate triplets
     * 
     * Key insights: - Sorting enables two-pointer technique and duplicate handling - If nums[i] >
     * 0, we can break early since all remaining elements are positive - Skip duplicate values for
     * first element and when finding valid triplets
     * 
     * Time Complexity: O(n²) - O(n log n) for sorting + O(n²) for two-pointer search Space
     * Complexity: O(1) excluding output space
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Early termination: if first element is positive, no valid triplets exist
            if (nums[i] > 0) {
                break;
            }

            // Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i]; // We want nums[left] + nums[right] = target

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    // Found a valid triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left pointer
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // Skip duplicates for right pointer
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < target) {
                    left++; // Need larger sum
                } else {
                    right--; // Need smaller sum
                }
            }
        }

        return result;
    }

    // ========================================
    // APPROACH 2: BRUTE FORCE WITH SET
    // Time: O(n³), Space: O(k) where k is number of triplets
    // ========================================

    /**
     * Approach 2: Brute Force with Set (Educational)
     * 
     * This approach checks all possible triplets using three nested loops. Uses a Set to
     * automatically handle duplicates by storing sorted triplets.
     * 
     * Algorithm: 1. Use three nested loops to check all possible triplets 2. For each triplet that
     * sums to zero, sort it and add to Set 3. Convert Set to List for return
     * 
     * Time Complexity: O(n³) - three nested loops Space Complexity: O(k) where k is the number of
     * unique triplets
     */
    public List<List<Integer>> threeSumBruteForce(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        Set<List<Integer>> uniqueTriplets = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet); // Sort to handle duplicates
                        uniqueTriplets.add(triplet);
                    }
                }
            }
        }

        return new ArrayList<>(uniqueTriplets);
    }

    // ========================================
    // APPROACH 3: HASH SET APPROACH
    // Time: O(n²), Space: O(n)
    // ========================================

    /**
     * Approach 3: Hash Set Approach
     * 
     * For each pair (i, j), use a hash set to check if the complement exists. This avoids the third
     * loop but requires careful duplicate handling.
     * 
     * Algorithm: 1. For each i, create a set to track seen elements after i 2. For each j > i,
     * calculate complement = -(nums[i] + nums[j]) 3. If complement exists in set, we found a
     * triplet 4. Add nums[j] to set for future iterations 5. Use Set<List<Integer>> to handle
     * duplicates
     * 
     * Time Complexity: O(n²) - two nested loops with O(1) hash operations Space Complexity: O(n)
     * for the hash set
     */
    public List<List<Integer>> threeSumHashSet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        Set<List<Integer>> uniqueTriplets = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            Set<Integer> seen = new HashSet<>();

            for (int j = i + 1; j < nums.length; j++) {
                int complement = -(nums[i] + nums[j]);

                if (seen.contains(complement)) {
                    List<Integer> triplet = Arrays.asList(nums[i], complement, nums[j]);
                    Collections.sort(triplet); // Sort to handle duplicates
                    uniqueTriplets.add(triplet);
                }

                seen.add(nums[j]);
            }
        }

        return new ArrayList<>(uniqueTriplets);
    }

    // ========================================
    // APPROACH 4: OPTIMIZED TWO POINTERS
    // Time: O(n²), Space: O(1) excluding output
    // ========================================

    /**
     * Approach 4: Optimized Two Pointers with Enhanced Duplicate Skipping
     * 
     * Similar to approach 1 but with additional optimizations: - More aggressive early termination
     * - Enhanced duplicate skipping - Better bounds checking
     * 
     * Time Complexity: O(n²) - same as approach 1 but with better constants Space Complexity: O(1)
     * excluding output space
     */
    public List<List<Integer>> threeSumOptimized(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Early termination optimizations
            if (nums[i] > 0)
                break; // All remaining elements are positive
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] < 0)
                continue; // Maximum possible sum too small
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0)
                break; // Minimum possible sum too large

            // Skip duplicates for first element
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // More efficient duplicate skipping
                    int leftVal = nums[left];
                    int rightVal = nums[right];

                    while (left < right && nums[left] == leftVal)
                        left++;
                    while (left < right && nums[right] == rightVal)
                        right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    // ========================================
    // UTILITY METHODS
    // ========================================

    /**
     * Check if a triplet sums to zero
     */
    public boolean isValidTriplet(int a, int b, int c) {
        return a + b + c == 0;
    }

    /**
     * Check if a list contains unique elements (no duplicates within the triplet)
     */
    public boolean hasUniqueElements(List<Integer> triplet) {
        Set<Integer> seen = new HashSet<>(triplet);
        return seen.size() == triplet.size();
    }

    /**
     * Count total number of triplets found by an approach
     */
    public int countTriplets(List<List<Integer>> triplets) {
        return triplets.size();
    }

    /**
     * Validate that all triplets in result are unique
     */
    public boolean hasNoDuplicateTriplets(List<List<Integer>> triplets) {
        Set<List<Integer>> uniqueSet = new HashSet<>();
        for (List<Integer> triplet : triplets) {
            List<Integer> sorted = new ArrayList<>(triplet);
            Collections.sort(sorted);
            if (!uniqueSet.add(sorted)) {
                return false; // Found duplicate
            }
        }
        return true;
    }

    /**
     * Validate that all triplets sum to zero
     */
    public boolean allTripletsValid(List<List<Integer>> triplets) {
        for (List<Integer> triplet : triplets) {
            if (triplet.size() != 3)
                return false;
            if (!isValidTriplet(triplet.get(0), triplet.get(1), triplet.get(2))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Get statistics about the triplets found
     */
    public String getTripletStatistics(List<List<Integer>> triplets) {
        if (triplets.isEmpty()) {
            return "No triplets found";
        }

        int count = triplets.size();
        boolean allValid = allTripletsValid(triplets);
        boolean noDuplicates = hasNoDuplicateTriplets(triplets);

        StringBuilder stats = new StringBuilder();
        stats.append(String.format("Found %d triplet(s)", count));
        stats.append(String.format(", All valid: %s", allValid));
        stats.append(String.format(", No duplicates: %s", noDuplicates));

        return stats.toString();
    }

    /**
     * Compare results from different approaches
     */
    public boolean compareResults(List<List<Integer>> result1, List<List<Integer>> result2) {
        if (result1.size() != result2.size()) {
            return false;
        }

        // Convert to sets of sorted triplets for comparison
        Set<List<Integer>> set1 = new HashSet<>();
        Set<List<Integer>> set2 = new HashSet<>();

        for (List<Integer> triplet : result1) {
            List<Integer> sorted = new ArrayList<>(triplet);
            Collections.sort(sorted);
            set1.add(sorted);
        }

        for (List<Integer> triplet : result2) {
            List<Integer> sorted = new ArrayList<>(triplet);
            Collections.sort(sorted);
            set2.add(sorted);
        }

        return set1.equals(set2);
    }

    /**
     * Find the maximum and minimum sums in the array (for analysis)
     */
    public int[] findMinMaxPossibleSums(int[] nums) {
        if (nums.length < 3)
            return new int[] {0, 0};

        Arrays.sort(nums);
        int minSum = nums[0] + nums[1] + nums[2];
        int maxSum = nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1];

        return new int[] {minSum, maxSum};
    }

    /**
     * Performance analysis helper - measures execution time
     */
    public long measureExecutionTime(Runnable algorithm) {
        long startTime = System.nanoTime();
        algorithm.run();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
