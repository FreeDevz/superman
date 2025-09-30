package com.example.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 349: Intersection of Two Arrays
 * 
 * Problem Description: Given two integer arrays nums1 and nums2, return an array of their
 * intersection. Each element in the result must be unique and you may return the result in any
 * order.
 * 
 * Example 1: Input: nums1 = [1,2,2,1], nums2 = [2,2] Output: [2]
 * 
 * Example 2: Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4] Output: [9,4] or [4,9]
 * 
 * Constraints: - 1 <= nums1.length, nums2.length <= 1000 - 0 <= nums1[i], nums2[i] <= 1000
 * 
 * Time Complexity Analysis: - HashSet Approach: O(n + m) time, O(n + m) space - Two Pointers
 * Approach: O(n log n + m log m) time, O(1) space (excluding output) - Binary Search Approach: O(n
 * log n + m log m) time, O(1) space (excluding output)
 */
public class IntersectionOfTwoArrays {

    /**
     * Approach 1: HashSet (Most Efficient)
     * 
     * Time Complexity: O(n + m) where n = nums1.length, m = nums2.length Space Complexity: O(n + m)
     * 
     * This is the most efficient approach for this problem.
     */
    public int[] intersectionHashSet(int[] nums1, int[] nums2) {
        // Convert first array to set for O(1) lookup
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        // Use another set to store intersection results (avoids duplicates)
        Set<Integer> resultSet = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }

        // Convert set to array
        int[] result = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            result[index++] = num;
        }

        return result;
    }

    /**
     * Approach 2: Two Pointers (After Sorting)
     * 
     * Time Complexity: O(n log n + m log m) for sorting + O(n + m) for intersection = O(n log n + m
     * log m) Space Complexity: O(1) excluding output array
     * 
     * Good when you need to minimize space usage and arrays are already sorted.
     */
    public int[] intersectionTwoPointers(int[] nums1, int[] nums2) {
        // Sort both arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer> resultSet = new HashSet<>();
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                resultSet.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        // Convert set to array
        int[] result = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            result[index++] = num;
        }

        return result;
    }

    /**
     * Approach 3: Binary Search
     * 
     * Time Complexity: O(n log n + m log n) where we sort nums1 and binary search for each element
     * in nums2 Space Complexity: O(1) excluding output array
     * 
     * Useful when one array is much smaller than the other.
     */
    public int[] intersectionBinarySearch(int[] nums1, int[] nums2) {
        // Sort the first array for binary search
        Arrays.sort(nums1);

        Set<Integer> resultSet = new HashSet<>();

        // For each element in nums2, binary search in nums1
        for (int num : nums2) {
            if (binarySearch(nums1, num)) {
                resultSet.add(num);
            }
        }

        // Convert set to array
        int[] result = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            result[index++] = num;
        }

        return result;
    }

    /**
     * Helper method for binary search
     */
    private boolean binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    /**
     * Approach 4: Using Java 8 Streams (Functional Programming)
     * 
     * Time Complexity: O(n + m) Space Complexity: O(n + m)
     * 
     * More concise but potentially less efficient due to boxing/unboxing.
     */
    public int[] intersectionStreams(int[] nums1, int[] nums2) {
        Set<Integer> set1 =
                Arrays.stream(nums1).boxed().collect(java.util.stream.Collectors.toSet());
        Set<Integer> set2 =
                Arrays.stream(nums2).boxed().collect(java.util.stream.Collectors.toSet());

        return set1.stream().filter(set2::contains).mapToInt(Integer::intValue).toArray();
    }

    /**
     * Approach 5: Using Arrays.binarySearch (Built-in Binary Search)
     * 
     * Time Complexity: O(n log n + m log n) Space Complexity: O(1) excluding output array
     */
    public int[] intersectionBuiltInBinarySearch(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);

        Set<Integer> resultSet = new HashSet<>();
        for (int num : nums2) {
            if (Arrays.binarySearch(nums1, num) >= 0) {
                resultSet.add(num);
            }
        }

        return resultSet.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Approach 6: Optimized HashSet (Single Pass)
     * 
     * Time Complexity: O(n + m) Space Complexity: O(min(n, m)) in best case
     * 
     * Optimized version that uses the smaller array for the set.
     */
    public int[] intersectionOptimized(int[] nums1, int[] nums2) {
        // Use the smaller array for the set to minimize space
        if (nums1.length > nums2.length) {
            return intersectionOptimized(nums2, nums1);
        }

        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        Set<Integer> resultSet = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }

        return resultSet.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Utility method to print array for debugging
     */
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Utility method to check if two arrays contain the same elements (order doesn't matter)
     */
    public static boolean arraysEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length)
            return false;

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }

        return true;
    }
}
