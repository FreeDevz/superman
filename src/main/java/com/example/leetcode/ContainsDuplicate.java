package com.example.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * LeetCode 217. Contains Duplicate
 * 
 * Problem Description: Given an integer array nums, return true if any value appears at least twice
 * in the array, and return false if every element is distinct.
 * 
 * Example 1: Input: nums = [1,2,3,1] Output: true
 * 
 * Example 2: Input: nums = [1,2,3,4] Output: false
 * 
 * Example 3: Input: nums = [1,1,1,3,3,4,3,2,4,2] Output: true
 * 
 * Constraints: - 1 <= nums.length <= 10^5 - -10^9 <= nums[i] <= 10^9
 * 
 * Approach Analysis: 1. HashSet Approach: O(n) time, O(n) space - Most efficient for this problem
 * 2. Sorting Approach: O(n log n) time, O(1) space - Space efficient but slower 3. Stream/Distinct
 * Approach: O(n) time, O(n) space - Functional programming style
 * 
 * @author LeetCode Solutions
 * @version 1.0
 */
public class ContainsDuplicate {

    /**
     * Approach 1: HashSet - Optimal Solution
     * 
     * Time Complexity: O(n) - Single pass through the array Space Complexity: O(n) - HashSet can
     * contain at most n elements
     * 
     * This is the most efficient approach for this problem. We iterate through the array once,
     * adding each element to a HashSet. If we encounter an element that's already in the set, we
     * immediately return true.
     * 
     * @param nums The input array
     * @return true if duplicates exist, false otherwise
     */
    public static boolean containsDuplicateHashSet(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    /**
     * Approach 2: Sorting - Space Efficient
     * 
     * Time Complexity: O(n log n) - Due to sorting Space Complexity: O(1) - If sorting is done
     * in-place (depends on implementation)
     * 
     * We sort the array first, then check if any adjacent elements are equal. This approach is
     * space-efficient but has higher time complexity due to sorting.
     * 
     * @param nums The input array
     * @return true if duplicates exist, false otherwise
     */
    public static boolean containsDuplicateSorting(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Approach 3: Stream with Distinct - Functional Programming Style
     * 
     * Time Complexity: O(n) - Stream operations are optimized Space Complexity: O(n) - Internal
     * HashSet for distinct operation
     * 
     * Uses Java 8 streams to compare the original array length with the distinct elements count. If
     * they differ, there are duplicates.
     * 
     * @param nums The input array
     * @return true if duplicates exist, false otherwise
     */
    public static boolean containsDuplicateStream(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        return nums.length != IntStream.of(nums).distinct().count();
    }

    /**
     * Approach 4: Enhanced HashSet with Early Termination
     * 
     * Time Complexity: O(n) - Single pass with early termination Space Complexity: O(n) - HashSet
     * storage
     * 
     * Similar to Approach 1 but with explicit early termination logic and size-based optimization
     * for very large arrays.
     * 
     * @param nums The input array
     * @return true if duplicates exist, false otherwise
     */
    public static boolean containsDuplicateEnhanced(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        // If array length is greater than max possible distinct integers, must have duplicates
        if (nums.length > 1000000000) { // 10^9 is constraint max
            return true;
        }

        Set<Integer> seen = new HashSet<>(nums.length);
        for (int num : nums) {
            if (!seen.add(num)) { // add() returns false if element already exists
                return true;
            }
        }
        return false;
    }

    /**
     * Approach 5: Brute Force - Educational Purpose Only
     * 
     * Time Complexity: O(n²) - Nested loops comparing every pair Space Complexity: O(1) - No
     * additional space used
     * 
     * This approach is included for educational purposes to show the naive solution. It compares
     * every element with every other element, which is very inefficient.
     * 
     * @param nums The input array
     * @return true if duplicates exist, false otherwise
     */
    public static boolean containsDuplicateBruteForce(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Main method for testing and demonstration
     */
    public static void main(String[] args) {
        // Test cases from LeetCode examples
        int[] test1 = {1, 2, 3, 1};
        int[] test2 = {1, 2, 3, 4};
        int[] test3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

        System.out.println("=== Contains Duplicate Test Cases ===");

        // Test HashSet approach
        System.out.println("\nHashSet Approach:");
        System.out.println("Test 1 [1,2,3,1]: " + containsDuplicateHashSet(test1)); // Expected:
                                                                                    // true
        System.out.println("Test 2 [1,2,3,4]: " + containsDuplicateHashSet(test2)); // Expected:
                                                                                    // false
        System.out.println("Test 3 [1,1,1,3,3,4,3,2,4,2]: " + containsDuplicateHashSet(test3)); // Expected:
                                                                                                // true

        // Test Sorting approach
        System.out.println("\nSorting Approach:");
        System.out.println("Test 1 [1,2,3,1]: " + containsDuplicateSorting(test1.clone())); // clone
                                                                                            // to
                                                                                            // avoid
                                                                                            // modifying
                                                                                            // original
        System.out.println("Test 2 [1,2,3,4]: " + containsDuplicateSorting(test2.clone()));
        System.out.println(
                "Test 3 [1,1,1,3,3,4,3,2,4,2]: " + containsDuplicateSorting(test3.clone()));

        // Test Stream approach
        System.out.println("\nStream Approach:");
        System.out.println("Test 1 [1,2,3,1]: " + containsDuplicateStream(test1));
        System.out.println("Test 2 [1,2,3,4]: " + containsDuplicateStream(test2));
        System.out.println("Test 3 [1,1,1,3,3,4,3,2,4,2]: " + containsDuplicateStream(test3));

        // Test Enhanced approach
        System.out.println("\nEnhanced HashSet Approach:");
        System.out.println("Test 1 [1,2,3,1]: " + containsDuplicateEnhanced(test1));
        System.out.println("Test 2 [1,2,3,4]: " + containsDuplicateEnhanced(test2));
        System.out.println("Test 3 [1,1,1,3,3,4,3,2,4,2]: " + containsDuplicateEnhanced(test3));

        // Performance comparison
        System.out.println("\n=== Performance Analysis ===");
        performanceTest();
    }

    /**
     * Performance testing method to compare different approaches
     */
    private static void performanceTest() {
        // Create test data
        int[] smallArray = generateTestArray(1000);
        int[] mediumArray = generateTestArray(10000);
        int[] largeArray = generateTestArray(100000);

        System.out.println("\nSmall Array (1000 elements):");
        timeApproach("HashSet", () -> containsDuplicateHashSet(smallArray.clone()));
        timeApproach("Sorting", () -> containsDuplicateSorting(smallArray.clone()));
        timeApproach("Stream", () -> containsDuplicateStream(smallArray.clone()));
        timeApproach("Enhanced", () -> containsDuplicateEnhanced(smallArray.clone()));

        System.out.println("\nMedium Array (10000 elements):");
        timeApproach("HashSet", () -> containsDuplicateHashSet(mediumArray.clone()));
        timeApproach("Sorting", () -> containsDuplicateSorting(mediumArray.clone()));
        timeApproach("Stream", () -> containsDuplicateStream(mediumArray.clone()));
        timeApproach("Enhanced", () -> containsDuplicateEnhanced(mediumArray.clone()));

        System.out.println("\nLarge Array (100000 elements):");
        timeApproach("HashSet", () -> containsDuplicateHashSet(largeArray.clone()));
        timeApproach("Sorting", () -> containsDuplicateSorting(largeArray.clone()));
        timeApproach("Stream", () -> containsDuplicateStream(largeArray.clone()));
        timeApproach("Enhanced", () -> containsDuplicateEnhanced(largeArray.clone()));
    }

    /**
     * Helper method to generate test arrays with duplicates
     */
    private static int[] generateTestArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i % (size / 2); // This ensures duplicates
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
        System.out.printf("%-10s: %.3f ms%n", name, duration);
    }
}
