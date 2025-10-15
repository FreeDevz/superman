package com.example.leetcode;

import java.util.*;

/**
 * LeetCode 448: Find All Numbers Disappeared in an Array
 * 
 * Problem Description: Given an array nums of n integers where nums[i] is in the range [1, n],
 * return an array of all the integers in the range [1, n] that do not appear in nums.
 * 
 * Example 1: Input: nums = [4,3,2,7,8,2,3,1] Output: [5,6]
 * 
 * Example 2: Input: nums = [1,1] Output: [2]
 * 
 * Constraints: - n == nums.length - 1 <= n <= 10^5 - 1 <= nums[i] <= n
 * 
 * Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned
 * list does not count as extra space.
 * 
 * Approach 1: In-Place Marking with Negation (Optimal) Time Complexity: O(n) Space Complexity: O(1)
 * 
 * Approach 2: Hash Set Time Complexity: O(n) Space Complexity: O(n)
 * 
 * Approach 3: Boolean Array Time Complexity: O(n) Space Complexity: O(n)
 * 
 * Approach 4: Cyclic Sort Time Complexity: O(n) Space Complexity: O(1)
 * 
 * Approach 5: Count Array Time Complexity: O(n) Space Complexity: O(n)
 * 
 * Approach 6: Sorting Approach Time Complexity: O(n log n) Space Complexity: O(1) or O(n)
 * 
 * Approach 7: In-Place Marking with Addition Time Complexity: O(n) Space Complexity: O(1)
 * 
 * Approach 8: Set Difference Time Complexity: O(n) Space Complexity: O(n)
 */
public class FindDisappearedNumbers {

    /**
     * Approach 1: In-Place Marking with Negation (Optimal Solution)
     * 
     * Use the array indices to mark presence of numbers by negating values. Since all numbers are
     * in range [1,n], we can use each number as an index (minus 1). Mark presence by making the
     * value at that index negative.
     * 
     * @param nums the input array
     * @return list of disappeared numbers
     */
    public List<Integer> findDisappearedNumbersInPlaceNegation(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // Mark presence by negating values at indices
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        // Find indices with positive values - these are missing numbers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        // Restore original array (optional, good practice)
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        return result;
    }

    /**
     * Approach 2: Hash Set
     * 
     * Use a HashSet to store all numbers present in the array, then iterate through [1,n] to find
     * missing numbers.
     * 
     * @param nums the input array
     * @return list of disappeared numbers
     */
    public List<Integer> findDisappearedNumbersHashSet(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> present = new HashSet<>();

        // Add all numbers to set
        for (int num : nums) {
            present.add(num);
        }

        // Find missing numbers
        for (int i = 1; i <= nums.length; i++) {
            if (!present.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }

    /**
     * Approach 3: Boolean Array
     * 
     * Use a boolean array to mark presence of numbers, then find unmarked positions.
     * 
     * @param nums the input array
     * @return list of disappeared numbers
     */
    public List<Integer> findDisappearedNumbersBooleanArray(int[] nums) {
        List<Integer> result = new ArrayList<>();
        boolean[] present = new boolean[nums.length + 1]; // Index 0 unused

        // Mark present numbers
        for (int num : nums) {
            present[num] = true;
        }

        // Find missing numbers
        for (int i = 1; i <= nums.length; i++) {
            if (!present[i]) {
                result.add(i);
            }
        }

        return result;
    }

    /**
     * Approach 4: Cyclic Sort
     * 
     * Place each number at its correct position (num at index num-1). After sorting, numbers not at
     * their correct positions are duplicates, and their positions indicate missing numbers.
     * 
     * @param nums the input array
     * @return list of disappeared numbers
     */
    public List<Integer> findDisappearedNumbersCyclicSort(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int i = 0;

        // Cyclic sort: place each number at its correct position
        while (i < nums.length) {
            int correctPos = nums[i] - 1;
            // Swap if number is not at correct position and not a duplicate
            if (nums[i] != nums[correctPos]) {
                swap(nums, i, correctPos);
            } else {
                i++;
            }
        }

        // Find missing numbers
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }

        return result;
    }

    /**
     * Approach 5: Count Array
     * 
     * Use an array to count occurrences of each number, then find numbers with zero count.
     * 
     * @param nums the input array
     * @return list of disappeared numbers
     */
    public List<Integer> findDisappearedNumbersCountArray(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[] count = new int[nums.length + 1]; // Index 0 unused

        // Count occurrences
        for (int num : nums) {
            count[num]++;
        }

        // Find numbers with zero count
        for (int i = 1; i <= nums.length; i++) {
            if (count[i] == 0) {
                result.add(i);
            }
        }

        return result;
    }

    /**
     * Approach 6: Sorting Approach
     * 
     * Sort the array and then iterate to find missing numbers. This modifies the input array.
     * 
     * @param nums the input array
     * @return list of disappeared numbers
     */
    public List<Integer> findDisappearedNumbersSorting(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);

        int expected = 1;
        for (int num : nums) {
            // Add all missing numbers before current number
            while (expected < num) {
                result.add(expected);
                expected++;
            }
            // Move to next expected if current matches
            if (expected == num) {
                expected++;
            }
        }

        // Add remaining missing numbers
        while (expected <= nums.length) {
            result.add(expected);
            expected++;
        }

        return result;
    }

    /**
     * Approach 7: In-Place Marking with Addition
     * 
     * Similar to negation approach, but marks presence by adding n to values. This allows retrieval
     * of original values while maintaining marks.
     * 
     * @param nums the input array
     * @return list of disappeared numbers
     */
    public List<Integer> findDisappearedNumbersInPlaceAddition(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        // Mark presence by adding n
        for (int i = 0; i < n; i++) {
            int index = (nums[i] - 1) % n;
            nums[index] += n;
        }

        // Find unmarked positions
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                result.add(i + 1);
            }
        }

        // Restore original array (optional)
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] % n == 0 ? n : nums[i] % n;
        }

        return result;
    }

    /**
     * Approach 8: Set Difference
     * 
     * Create a set of all numbers [1,n] and remove numbers present in array. More concise but uses
     * extra space.
     * 
     * @param nums the input array
     * @return list of disappeared numbers
     */
    public List<Integer> findDisappearedNumbersSetDifference(int[] nums) {
        Set<Integer> allNumbers = new HashSet<>();
        for (int i = 1; i <= nums.length; i++) {
            allNumbers.add(i);
        }

        // Remove present numbers
        for (int num : nums) {
            allNumbers.remove(num);
        }

        return new ArrayList<>(allNumbers);
    }

    /**
     * Helper method to swap two elements in an array
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * Utility method to check if a result is valid
     * 
     * @param nums the input array
     * @param result the result to verify
     * @return true if result is correct
     */
    public boolean verifyResult(int[] nums, List<Integer> result) {
        Set<Integer> present = new HashSet<>();
        for (int num : nums) {
            present.add(num);
        }

        Set<Integer> expected = new HashSet<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!present.contains(i)) {
                expected.add(i);
            }
        }

        return new HashSet<>(result).equals(expected);
    }

    /**
     * Utility method to count missing numbers
     * 
     * @param nums the input array
     * @return count of missing numbers
     */
    public int countMissingNumbers(int[] nums) {
        Set<Integer> present = new HashSet<>();
        for (int num : nums) {
            present.add(num);
        }
        return nums.length - present.size();
    }

    /**
     * Utility method to find missing numbers in a range
     * 
     * @param nums the input array
     * @param start start of range (inclusive)
     * @param end end of range (inclusive)
     * @return list of missing numbers in range
     */
    public List<Integer> findMissingInRange(int[] nums, int start, int end) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> present = new HashSet<>();
        for (int num : nums) {
            present.add(num);
        }

        for (int i = start; i <= end; i++) {
            if (!present.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }

    /**
     * Main method to demonstrate all approaches
     */
    public static void main(String[] args) {
        FindDisappearedNumbers solution = new FindDisappearedNumbers();

        // Test cases
        int[][] testCases = {{4, 3, 2, 7, 8, 2, 3, 1}, {1, 1}, {1, 2, 3, 4, 5}, {2, 2, 2, 2, 2},
                {5, 4, 3, 2, 1}, {1}, {10, 2, 5, 10, 9, 1, 1, 4, 3, 7}, {1, 2, 2, 3, 3, 4, 7, 8}};

        System.out.println("Testing Find All Numbers Disappeared in an Array Solutions:");
        System.out.println("=============================================================");

        for (int i = 0; i < testCases.length; i++) {
            int[] nums = testCases[i].clone();
            System.out.println("\nTest Case " + (i + 1) + ": " + Arrays.toString(nums));

            // Test all approaches
            List<Integer> result1 = solution.findDisappearedNumbersInPlaceNegation(nums.clone());
            List<Integer> result2 = solution.findDisappearedNumbersHashSet(nums.clone());
            List<Integer> result3 = solution.findDisappearedNumbersBooleanArray(nums.clone());
            List<Integer> result4 = solution.findDisappearedNumbersCyclicSort(nums.clone());
            List<Integer> result5 = solution.findDisappearedNumbersCountArray(nums.clone());
            List<Integer> result6 = solution.findDisappearedNumbersSorting(nums.clone());
            List<Integer> result7 = solution.findDisappearedNumbersInPlaceAddition(nums.clone());
            List<Integer> result8 = solution.findDisappearedNumbersSetDifference(nums.clone());

            System.out.println("In-Place Negation: " + result1);
            System.out.println("Hash Set: " + result2);
            System.out.println("Boolean Array: " + result3);
            System.out.println("Cyclic Sort: " + result4);
            System.out.println("Count Array: " + result5);
            System.out.println("Sorting: " + result6);
            System.out.println("In-Place Addition: " + result7);
            System.out.println("Set Difference: " + result8);

            // Verify all approaches agree
            boolean allAgree = result1.equals(result2) && result2.equals(result3)
                    && result3.equals(result4) && result4.equals(result5) && result5.equals(result6)
                    && result6.equals(result7) && result7.equals(result8);

            System.out.println("All approaches agree: " + (allAgree ? "✓" : "✗"));
            System.out.println(
                    "Result verified: " + (solution.verifyResult(nums, result1) ? "✓" : "✗"));
            System.out.println("Missing count: " + solution.countMissingNumbers(nums));
        }

        // Performance comparison
        System.out.println("\n\nPerformance Analysis:");
        System.out.println("=====================");
        System.out.println("Approach 1 (In-Place Negation): O(n) time, O(1) space - OPTIMAL");
        System.out.println("Approach 2 (Hash Set): O(n) time, O(n) space");
        System.out.println("Approach 3 (Boolean Array): O(n) time, O(n) space");
        System.out.println("Approach 4 (Cyclic Sort): O(n) time, O(1) space - SPACE OPTIMAL");
        System.out.println("Approach 5 (Count Array): O(n) time, O(n) space");
        System.out.println("Approach 6 (Sorting): O(n log n) time, O(1) or O(n) space");
        System.out.println("Approach 7 (In-Place Addition): O(n) time, O(1) space");
        System.out.println("Approach 8 (Set Difference): O(n) time, O(n) space - CONCISE");

        System.out.println("\nKey Insights:");
        System.out.println("=============");
        System.out.println("• Use array indices as markers to achieve O(1) space");
        System.out.println("• Negation preserves original values via Math.abs()");
        System.out.println("• Adding n allows retrieval: original = value % n");
        System.out.println("• Cyclic sort places each element at its correct position");
        System.out.println("• Hash set provides simple but O(n) space solution");
        System.out.println("• Numbers are in range [1,n], perfect for index mapping");
        System.out.println("• In-place approaches modify input but can restore it");
        System.out.println("• Optimal solution: O(n) time, O(1) space using negation");
    }
}

