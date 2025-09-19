package com.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * LeetCode #169: Majority Element
 * 
 * Problem Description: Given an array nums of size n, return the majority element. The majority
 * element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority
 * element always exists in the array.
 * 
 * Example 1: Input: nums = [3,2,3] Output: 3 Example 2: Input: nums = [2,2,1,1,1,2,2] Output: 2
 * 
 * Constraints: - n == nums.length - 1 <= n <= 5 * 10^4 - -10^9 <= nums[i] <= 10^9
 * 
 * Approach Analysis: This problem can be solved using multiple approaches: 1. Boyer-Moore Voting
 * Algorithm (Optimal) - O(n) time, O(1) space 2. HashMap approach - O(n) time, O(n) space 3.
 * Sorting approach - O(n log n) time, O(1) space 4. Randomization approach - O(n) expected time,
 * O(1) space 5. Divide and Conquer approach - O(n log n) time, O(log n) space
 * 
 * Time Complexity: O(n) for optimal approach Space Complexity: O(1) for optimal approach
 */
public class MajorityElement {

    /**
     * Approach 1: Boyer-Moore Voting Algorithm (Recommended)
     * 
     * This is the optimal solution. The key insight is that the majority element will always
     * "survive" the voting process because it appears more than n/2 times.
     * 
     * Time: O(n) Space: O(1)
     */
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        // First pass: find the candidate
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Since the problem guarantees a majority element exists,
        // we don't need a second pass to verify
        return candidate;
    }

    /**
     * Approach 2: Boyer-Moore with Verification
     * 
     * Same as above but includes verification step for robustness.
     * 
     * Time: O(n) Space: O(1)
     */
    public int majorityElementWithVerification(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        // First pass: find the candidate
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Second pass: verify the candidate (optional for this problem)
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        return count > nums.length / 2 ? candidate : -1;
    }

    /**
     * Approach 3: HashMap Approach
     * 
     * Count the frequency of each element and return the one with count > n/2.
     * 
     * Time: O(n) Space: O(n)
     */
    public int majorityElementHashMap(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int majorityThreshold = nums.length / 2;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > majorityThreshold) {
                return entry.getKey();
            }
        }

        return -1; // Should never reach here given problem constraints
    }

    /**
     * Approach 4: Sorting Approach
     * 
     * Sort the array and return the middle element, which will be the majority element.
     * 
     * Time: O(n log n) Space: O(1)
     */
    public int majorityElementSorting(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * Approach 5: Randomization Approach
     * 
     * Randomly pick an element and check if it's the majority element. Expected to find the answer
     * quickly.
     * 
     * Time: O(n) expected Space: O(1)
     */
    public int majorityElementRandomization(int[] nums) {
        Random rand = new Random();
        int majorityCount = nums.length / 2;

        while (true) {
            int candidate = nums[rand.nextInt(nums.length)];
            int count = 0;

            for (int num : nums) {
                if (num == candidate) {
                    count++;
                }
            }

            if (count > majorityCount) {
                return candidate;
            }
        }
    }

    /**
     * Approach 6: Divide and Conquer
     * 
     * Divide the array into two halves and find the majority element in each half. The majority
     * element of the whole array must be the majority element of at least one half.
     * 
     * Time: O(n log n) Space: O(log n) for recursion stack
     */
    public int majorityElementDivideConquer(int[] nums) {
        return majorityElementRecursive(nums, 0, nums.length - 1);
    }

    private int majorityElementRecursive(int[] nums, int left, int right) {
        // Base case: single element
        if (left == right) {
            return nums[left];
        }

        // Divide
        int mid = left + (right - left) / 2;
        int leftMajority = majorityElementRecursive(nums, left, mid);
        int rightMajority = majorityElementRecursive(nums, mid + 1, right);

        // Conquer: if both halves have the same majority element, return it
        if (leftMajority == rightMajority) {
            return leftMajority;
        }

        // Otherwise, count occurrences of both candidates in the entire range
        int leftCount = countInRange(nums, leftMajority, left, right);
        int rightCount = countInRange(nums, rightMajority, left, right);

        return leftCount > rightCount ? leftMajority : rightMajority;
    }

    private int countInRange(int[] nums, int num, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    /**
     * Approach 7: Bit Manipulation
     * 
     * For each bit position, count how many numbers have that bit set. If more than half have it
     * set, the majority element has that bit set.
     * 
     * Time: O(32 * n) = O(n) Space: O(1)
     */
    public int majorityElementBitManipulation(int[] nums) {
        int majority = 0;
        int n = nums.length;

        for (int i = 0; i < 32; i++) {
            int bitCount = 0;

            // Count how many numbers have the i-th bit set
            for (int num : nums) {
                if ((num >> i & 1) == 1) {
                    bitCount++;
                }
            }

            // If more than half have this bit set, set it in the result
            if (bitCount > n / 2) {
                majority |= (1 << i);
            }
        }

        return majority;
    }

    /**
     * Utility method to verify if an element is actually the majority element
     */
    public boolean isMajorityElement(int[] nums, int candidate) {
        int count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
        return count > nums.length / 2;
    }

    /**
     * Utility method to find all elements that appear more than n/3 times (Extension of the
     * majority element problem)
     */
    public int[] majorityElementsN3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int candidate1 = nums[0], candidate2 = nums[0];
        int count1 = 0, count2 = 0;

        // First pass: find two candidates
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Second pass: verify candidates
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1)
                count1++;
            else if (num == candidate2)
                count2++;
        }

        int threshold = nums.length / 3;
        if (count1 > threshold && count2 > threshold) {
            return new int[] {candidate1, candidate2};
        } else if (count1 > threshold) {
            return new int[] {candidate1};
        } else if (count2 > threshold) {
            return new int[] {candidate2};
        } else {
            return new int[0];
        }
    }

    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        MajorityElement solution = new MajorityElement();

        // Test cases
        int[][] testCases = {{3, 2, 3}, {2, 2, 1, 1, 1, 2, 2}, {1}, {1, 1, 2, 2, 2}, {6, 5, 5},
                {1, 1, 1, 2, 2, 2, 2}};

        System.out.println("Testing Majority Element Solutions:");
        System.out.println("===================================");

        for (int i = 0; i < testCases.length; i++) {
            int[] nums = testCases[i];
            System.out.printf("Test Case %d: %s\n", i + 1, Arrays.toString(nums));

            int result1 = solution.majorityElement(nums);
            int result2 = solution.majorityElementWithVerification(nums);
            int result3 = solution.majorityElementHashMap(nums);
            int result4 = solution.majorityElementSorting(nums);
            int result5 = solution.majorityElementDivideConquer(nums);
            int result6 = solution.majorityElementBitManipulation(nums);

            System.out.printf("Boyer-Moore: %d\n", result1);
            System.out.printf("Boyer-Moore + Verify: %d\n", result2);
            System.out.printf("HashMap: %d\n", result3);
            System.out.printf("Sorting: %d\n", result4);
            System.out.printf("Divide & Conquer: %d\n", result5);
            System.out.printf("Bit Manipulation: %d\n", result6);

            // Validate results
            boolean allEqual = result1 == result2 && result2 == result3 && result3 == result4
                    && result4 == result5 && result5 == result6;

            System.out.printf("All approaches consistent: %s\n", allEqual ? "✓" : "✗");
            System.out.printf("Is majority element: %s\n",
                    solution.isMajorityElement(nums, result1) ? "✓" : "✗");
            System.out.println("---");
        }

        // Test n/3 majority elements
        System.out.println("Testing Majority Elements (n/3):");
        System.out.println("=================================");
        int[] testN3 = {3, 2, 3};
        int[] resultN3 = solution.majorityElementsN3(testN3);
        System.out.printf("Input: %s, Result: %s\n", Arrays.toString(testN3),
                Arrays.toString(resultN3));
    }
}
