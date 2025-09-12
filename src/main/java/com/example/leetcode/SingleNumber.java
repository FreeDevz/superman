package com.example.leetcode;

import java.util.*;

/**
 * LeetCode 136: Single Number
 * 
 * Problem Description: Given a non-empty array of integers nums, every element appears twice except
 * for one. Find that single one.
 * 
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * 
 * Example 1: Input: nums = [2,2,1] Output: 1
 * 
 * Example 2: Input: nums = [4,1,2,1,2] Output: 4
 * 
 * Example 3: Input: nums = [1] Output: 1
 * 
 * Constraints: - 1 <= nums.length <= 3 * 10^4 - -3 * 10^4 <= nums[i] <= 3 * 10^4 - Each element in
 * the array appears twice except for one element which appears only once.
 * 
 * Approach 1: XOR Operation (Optimal) Time Complexity: O(n) Space Complexity: O(1)
 * 
 * Key insight: XOR has the following properties: - a ^ a = 0 (any number XORed with itself equals
 * 0) - a ^ 0 = a (any number XORed with 0 equals itself) - XOR is commutative and associative
 * 
 * By XORing all elements, pairs cancel out, leaving only the single number.
 * 
 * Approach 2: HashSet Time Complexity: O(n) Space Complexity: O(n)
 * 
 * Use a set to track seen numbers. If we see a number twice, remove it. The remaining number is our
 * answer.
 * 
 * Approach 3: Mathematical Formula Time Complexity: O(n) Space Complexity: O(n)
 * 
 * Use the formula: 2 * (sum of unique elements) - sum of all elements = single number
 */
public class SingleNumber {

    /**
     * Approach 1: XOR Operation (Optimal Solution)
     * 
     * This is the most efficient solution using bitwise XOR. Since every element appears twice
     * except one, XORing all elements will cancel out the pairs and leave only the single number.
     * 
     * @param nums array of integers where every element appears twice except one
     * @return the single number that appears only once
     */
    public int singleNumberXOR(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    /**
     * Approach 2: HashSet Solution
     * 
     * Use a set to track numbers we've seen. If we encounter a number that's already in the set,
     * remove it. The remaining number is our answer.
     * 
     * @param nums array of integers where every element appears twice except one
     * @return the single number that appears only once
     */
    public int singleNumberHashSet(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                seen.remove(num);
            } else {
                seen.add(num);
            }
        }

        // The set should contain exactly one element
        return seen.iterator().next();
    }

    /**
     * Approach 3: Mathematical Formula
     * 
     * Use the mathematical property: 2 * (sum of unique elements) - sum of all elements = single
     * number
     * 
     * @param nums array of integers where every element appears twice except one
     * @return the single number that appears only once
     */
    public int singleNumberMath(int[] nums) {
        Set<Integer> uniqueElements = new HashSet<>();
        int sumAll = 0;
        int sumUnique = 0;

        for (int num : nums) {
            sumAll += num;
            if (uniqueElements.add(num)) {
                sumUnique += num;
            }
        }

        return 2 * sumUnique - sumAll;
    }

    /**
     * Approach 4: HashMap Solution
     * 
     * Count the frequency of each number and return the one with count 1.
     * 
     * @param nums array of integers where every element appears twice except one
     * @return the single number that appears only once
     */
    public int singleNumberHashMap(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();

        // Count frequency of each number
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        // Find the number with frequency 1
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1; // Should never reach here given problem constraints
    }

    /**
     * Approach 5: Sorting Solution
     * 
     * Sort the array and check adjacent elements. The single number will be the one that doesn't
     * have a matching adjacent element.
     * 
     * @param nums array of integers where every element appears twice except one
     * @return the single number that appears only once
     */
    public int singleNumberSorting(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }

        // If we reach here, the single number is the last element
        return nums[nums.length - 1];
    }

    /**
     * Main method to demonstrate all approaches
     */
    public static void main(String[] args) {
        SingleNumber solution = new SingleNumber();

        // Test cases
        int[][] testCases =
                {{2, 2, 1}, {4, 1, 2, 1, 2}, {1}, {1, 3, 1, 3, 5}, {-1, -1, -2}, {0, 0, 1, 1, 2}};

        int[] expectedResults = {1, 4, 1, 5, -2, 2};

        System.out.println("Testing Single Number Solutions:");
        System.out.println("=================================");

        for (int i = 0; i < testCases.length; i++) {
            int[] nums = testCases[i];
            int expected = expectedResults[i];

            System.out.println("\nTest Case " + (i + 1) + ": " + Arrays.toString(nums));
            System.out.println("Expected: " + expected);

            // Test all approaches
            int result1 = solution.singleNumberXOR(nums);
            int result2 = solution.singleNumberHashSet(nums);
            int result3 = solution.singleNumberMath(nums);
            int result4 = solution.singleNumberHashMap(nums);
            int result5 = solution.singleNumberSorting(nums);

            System.out.println("XOR Result: " + result1 + " " + (result1 == expected ? "✓" : "✗"));
            System.out.println(
                    "HashSet Result: " + result2 + " " + (result2 == expected ? "✓" : "✗"));
            System.out.println("Math Result: " + result3 + " " + (result3 == expected ? "✓" : "✗"));
            System.out.println(
                    "HashMap Result: " + result4 + " " + (result4 == expected ? "✓" : "✗"));
            System.out.println(
                    "Sorting Result: " + result5 + " " + (result5 == expected ? "✓" : "✗"));
        }

        // Performance comparison
        System.out.println("\n\nPerformance Analysis:");
        System.out.println("=====================");
        System.out.println("Approach 1 (XOR): O(n) time, O(1) space - OPTIMAL");
        System.out.println("Approach 2 (HashSet): O(n) time, O(n) space");
        System.out.println("Approach 3 (Math): O(n) time, O(n) space");
        System.out.println("Approach 4 (HashMap): O(n) time, O(n) space");
        System.out.println("Approach 5 (Sorting): O(n log n) time, O(1) space");

        System.out.println("\nKey Insights:");
        System.out.println("=============");
        System.out.println("• XOR is the most efficient solution for this problem");
        System.out.println("• XOR properties: a ^ a = 0, a ^ 0 = a");
        System.out.println("• XOR is commutative and associative");
        System.out.println("• All pairs cancel out, leaving only the single number");
    }
}
