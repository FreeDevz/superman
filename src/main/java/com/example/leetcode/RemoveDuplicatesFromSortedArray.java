package com.example.leetcode;

/**
 * LeetCode Problem 26: Remove Duplicates from Sorted Array
 * 
 * Problem Description: Given an integer array nums sorted in non-decreasing order, remove the
 * duplicates in-place such that each unique element appears only once. The relative order of the
 * elements should be kept the same. Then return the number of unique elements in nums.
 * 
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the
 * following things: - Change the array nums such that the first k elements of nums contain the
 * unique elements in the same order they were present in nums initially. The remaining elements of
 * nums are not important as well as the size of nums. - Return k.
 * 
 * Example 1: Input: nums = [1,1,2] Output: 2, nums = [1,2,_] Explanation: Your function should
 * return k = 2, with the first two elements of nums being 1 and 2 respectively. It does not matter
 * what you leave beyond the returned k (hence they are underscores).
 * 
 * Example 2: Input: nums = [0,0,1,1,1,2,2,3,3,4] Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1,
 * 2, 3, and 4 respectively. It does not matter what you leave beyond the returned k (hence they are
 * underscores).
 * 
 * Constraints: - 1 <= nums.length <= 3 * 10^4 - -100 <= nums[i] <= 100 - nums is sorted in
 * non-decreasing order.
 * 
 * Approach 1: Two Pointers (Optimal) Time Complexity: O(n) Space Complexity: O(1)
 * 
 * Approach 2: Using Set (Not in-place, for reference) Time Complexity: O(n) Space Complexity: O(n)
 * 
 * Approach 3: Brute Force with Array Copy Time Complexity: O(n^2) Space Complexity: O(n)
 */
public class RemoveDuplicatesFromSortedArray {

    /**
     * Approach 1: Two Pointers (Optimal Solution)
     * 
     * This is the most efficient approach that modifies the array in-place. We use two pointers: -
     * i: iterates through the entire array - k: tracks the position for the next unique element
     * 
     * Algorithm: 1. Initialize k = 1 (first element is always unique) 2. For each element from
     * index 1 to n-1: - If current element is different from previous element - Place it at
     * position k and increment k 3. Return k (number of unique elements)
     * 
     * @param nums sorted array with potential duplicates
     * @return number of unique elements
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int k = 1; // Index for next unique element

        for (int i = 1; i < nums.length; i++) {
            // If current element is different from previous element
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i]; // Place unique element at position k
                k++; // Move to next position for unique element
            }
        }

        return k; // Return count of unique elements
    }

    /**
     * Approach 2: Using Set (Not in-place, for educational purposes)
     * 
     * This approach uses a Set to track unique elements but doesn't modify the original array
     * in-place, so it doesn't meet the problem requirements. However, it's useful for understanding
     * the concept.
     * 
     * @param nums sorted array with potential duplicates
     * @return number of unique elements
     */
    public int removeDuplicatesWithSet(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        java.util.Set<Integer> uniqueElements = new java.util.LinkedHashSet<>();

        // Add all elements to set (automatically removes duplicates)
        for (int num : nums) {
            uniqueElements.add(num);
        }

        // Convert set back to array (this modifies the original array)
        int index = 0;
        for (int element : uniqueElements) {
            nums[index++] = element;
        }

        return uniqueElements.size();
    }

    /**
     * Approach 3: Brute Force with Array Copy
     * 
     * This approach creates a new array with unique elements and copies them back to the original
     * array. Less efficient but easier to understand.
     * 
     * @param nums sorted array with potential duplicates
     * @return number of unique elements
     */
    public int removeDuplicatesBruteForce(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Create temporary array to store unique elements
        int[] temp = new int[nums.length];
        temp[0] = nums[0];
        int uniqueCount = 1;

        // Copy unique elements to temp array
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                temp[uniqueCount] = nums[i];
                uniqueCount++;
            }
        }

        // Copy unique elements back to original array
        for (int i = 0; i < uniqueCount; i++) {
            nums[i] = temp[i];
        }

        return uniqueCount;
    }

    /**
     * Approach 4: Optimized Two Pointers with Early Termination
     * 
     * Similar to Approach 1 but with some optimizations for edge cases.
     * 
     * @param nums sorted array with potential duplicates
     * @return number of unique elements
     */
    public int removeDuplicatesOptimized(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        int writeIndex = 1;

        for (int readIndex = 1; readIndex < nums.length; readIndex++) {
            if (nums[readIndex] != nums[readIndex - 1]) {
                if (writeIndex != readIndex) { // Avoid unnecessary assignments
                    nums[writeIndex] = nums[readIndex];
                }
                writeIndex++;
            }
        }

        return writeIndex;
    }

    /**
     * Utility method to print array for debugging
     * 
     * @param nums array to print
     * @param length number of elements to print
     */
    public void printArray(int[] nums, int length) {
        System.out.print("[");
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i]);
            if (i < length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /**
     * Main method for testing the solution
     */
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();

        // Test case 1: [1,1,2]
        int[] nums1 = {1, 1, 2};
        System.out.println("Test 1 - Original: [1,1,2]");
        int result1 = solution.removeDuplicates(nums1);
        System.out.println("Result: " + result1);
        solution.printArray(nums1, result1);
        System.out.println();

        // Test case 2: [0,0,1,1,1,2,2,3,3,4]
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("Test 2 - Original: [0,0,1,1,1,2,2,3,3,4]");
        int result2 = solution.removeDuplicates(nums2);
        System.out.println("Result: " + result2);
        solution.printArray(nums2, result2);
        System.out.println();

        // Test case 3: Single element
        int[] nums3 = {1};
        System.out.println("Test 3 - Original: [1]");
        int result3 = solution.removeDuplicates(nums3);
        System.out.println("Result: " + result3);
        solution.printArray(nums3, result3);
        System.out.println();

        // Test case 4: All same elements
        int[] nums4 = {1, 1, 1, 1};
        System.out.println("Test 4 - Original: [1,1,1,1]");
        int result4 = solution.removeDuplicates(nums4);
        System.out.println("Result: " + result4);
        solution.printArray(nums4, result4);
        System.out.println();

        // Test case 5: No duplicates
        int[] nums5 = {1, 2, 3, 4, 5};
        System.out.println("Test 5 - Original: [1,2,3,4,5]");
        int result5 = solution.removeDuplicates(nums5);
        System.out.println("Result: " + result5);
        solution.printArray(nums5, result5);
    }
}
