package com.example.leetcode;

/**
 * LeetCode 35. Search Insert Position
 * 
 * Problem Description: Given a sorted array of distinct integers and a target value, return the
 * index if the target is found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Example 1: Input: nums = [1,3,5,6], target = 5 Output: 2
 * 
 * Example 2: Input: nums = [1,3,5,6], target = 2 Output: 1
 * 
 * Example 3: Input: nums = [1,3,5,6], target = 7 Output: 4
 * 
 * Constraints: - 1 <= nums.length <= 10^4 - -10^4 <= nums[i] <= 10^4 - nums contains distinct
 * values sorted in ascending order. - -10^4 <= target <= 10^4
 * 
 * Approach: This is a classic binary search problem. We need to find the position where the target
 * should be inserted. The key insight is that we're looking for the leftmost position where nums[i]
 * >= target.
 * 
 * Time Complexity: O(log n) - Binary search Space Complexity: O(1) - Constant extra space
 * 
 * @author LeetCode Solutions
 */
public class SearchInsertPosition {

    /**
     * Solution using binary search to find the insert position
     * 
     * @param nums sorted array of distinct integers
     * @param target target value to search for
     * @return index where target should be inserted
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // Binary search for the insert position
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                // Target found, return its index
                return mid;
            } else if (nums[mid] < target) {
                // Target is in the right half
                left = mid + 1;
            } else {
                // Target is in the left half
                right = mid - 1;
            }
        }

        // Target not found, left is the insert position
        return left;
    }

    /**
     * Alternative solution using binary search with explicit insert position logic This version
     * makes the insert position logic more explicit
     * 
     * @param nums sorted array of distinct integers
     * @param target target value to search for
     * @return index where target should be inserted
     */
    public int searchInsertAlternative(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        // Binary search for the leftmost position where nums[i] >= target
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    /**
     * Recursive solution using binary search
     * 
     * @param nums sorted array of distinct integers
     * @param target target value to search for
     * @return index where target should be inserted
     */
    public int searchInsertRecursive(int[] nums, int target) {
        return binarySearchRecursive(nums, target, 0, nums.length - 1);
    }

    private int binarySearchRecursive(int[] nums, int target, int left, int right) {
        if (left > right) {
            return left;
        }

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearchRecursive(nums, target, mid + 1, right);
        } else {
            return binarySearchRecursive(nums, target, left, mid - 1);
        }
    }

    /**
     * Linear search solution (O(n) time complexity) This is included for comparison but not optimal
     * for the problem requirements
     * 
     * @param nums sorted array of distinct integers
     * @param target target value to search for
     * @return index where target should be inserted
     */
    public int searchInsertLinear(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * Main method for testing the solution
     */
    public static void main(String[] args) {
        SearchInsertPosition solution = new SearchInsertPosition();

        // Test cases
        int[] nums1 = {1, 3, 5, 6};
        int target1 = 5;
        System.out.println("Test 1 - nums: [1,3,5,6], target: 5");
        System.out.println("Expected: 2, Actual: " + solution.searchInsert(nums1, target1));

        int[] nums2 = {1, 3, 5, 6};
        int target2 = 2;
        System.out.println("Test 2 - nums: [1,3,5,6], target: 2");
        System.out.println("Expected: 1, Actual: " + solution.searchInsert(nums2, target2));

        int[] nums3 = {1, 3, 5, 6};
        int target3 = 7;
        System.out.println("Test 3 - nums: [1,3,5,6], target: 7");
        System.out.println("Expected: 4, Actual: " + solution.searchInsert(nums3, target3));

        int[] nums4 = {1, 3, 5, 6};
        int target4 = 0;
        System.out.println("Test 4 - nums: [1,3,5,6], target: 0");
        System.out.println("Expected: 0, Actual: " + solution.searchInsert(nums4, target4));

        int[] nums5 = {1};
        int target5 = 1;
        System.out.println("Test 5 - nums: [1], target: 1");
        System.out.println("Expected: 0, Actual: " + solution.searchInsert(nums5, target5));
    }
}
