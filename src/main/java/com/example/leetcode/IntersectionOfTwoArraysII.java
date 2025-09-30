package com.example.leetcode;

import java.util.*;

/**
 * LeetCode 350: Intersection of Two Arrays II
 * 
 * Problem Description: Given two integer arrays nums1 and nums2, return an array of their
 * intersection. Each element in the result must appear as many times as it shows in both arrays and
 * you may return the result in any order.
 * 
 * Example 1: Input: nums1 = [1,2,2,1], nums2 = [2,2] Output: [2,2]
 * 
 * Example 2: Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4] Output: [4,9] or [9,4]
 * 
 * Constraints: - 1 <= nums1.length, nums2.length <= 1000 - 0 <= nums1[i], nums2[i] <= 1000
 * 
 * Time Complexity Analysis: - HashMap Approach: O(n + m) time, O(min(n, m)) space - Sorting + Two
 * Pointers: O(n log n + m log m) time, O(1) space (excluding output) - Binary Search: O(n log n + m
 * log n) time, O(1) space (excluding output)
 */
public class IntersectionOfTwoArraysII {

    /**
     * Approach 1: HashMap Frequency Counting (Most Efficient)
     * 
     * Time Complexity: O(n + m) where n = nums1.length, m = nums2.length Space Complexity: O(min(n,
     * m)) - we use the smaller array for frequency counting
     * 
     * This is the most efficient approach for this problem.
     */
    public int[] intersectHashMap(int[] nums1, int[] nums2) {
        // Use the smaller array for frequency counting to minimize space
        if (nums1.length > nums2.length) {
            return intersectHashMap(nums2, nums1);
        }

        // Count frequencies in the smaller array
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums1) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Build result array by checking frequencies in nums2
        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (frequencyMap.containsKey(num) && frequencyMap.get(num) > 0) {
                result.add(num);
                frequencyMap.put(num, frequencyMap.get(num) - 1);
            }
        }

        // Convert list to array
        int[] resultArray = new int[result.size()];
        for (int idx = 0; idx < result.size(); idx++) {
            resultArray[idx] = result.get(idx);
        }

        return resultArray;
    }

    /**
     * Approach 2: Sorting + Two Pointers
     * 
     * Time Complexity: O(n log n + m log m) for sorting + O(n + m) for intersection = O(n log n + m
     * log m) Space Complexity: O(1) excluding output array
     * 
     * Good when you need to minimize space usage and arrays are already sorted.
     */
    public int[] intersectSorting(int[] nums1, int[] nums2) {
        // Sort both arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        // Convert list to array
        int[] resultArray = new int[result.size()];
        for (int idx = 0; idx < result.size(); idx++) {
            resultArray[idx] = result.get(idx);
        }

        return resultArray;
    }

    /**
     * Approach 3: Binary Search for Each Element
     * 
     * Time Complexity: O(n log n + m log n) where we sort nums1 and binary search for each element
     * in nums2 Space Complexity: O(1) excluding output array
     * 
     * Useful when one array is much smaller than the other. Note: This approach requires tracking
     * which elements have been used.
     */
    public int[] intersectBinarySearch(int[] nums1, int[] nums2) {
        // Sort the first array for binary search
        Arrays.sort(nums1);

        List<Integer> result = new ArrayList<>();
        boolean[] used = new boolean[nums1.length];

        // For each element in nums2, find its first unused occurrence in nums1
        for (int num : nums2) {
            int index = findFirstUnused(nums1, used, num);
            if (index != -1) {
                result.add(num);
                used[index] = true;
            }
        }

        // Convert list to array
        int[] resultArray = new int[result.size()];
        for (int idx = 0; idx < result.size(); idx++) {
            resultArray[idx] = result.get(idx);
        }

        return resultArray;
    }

    /**
     * Helper method to find the first unused occurrence of target in sorted array
     */
    private int findFirstUnused(int[] nums, boolean[] used, int target) {
        int left = 0, right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result = mid;
                right = mid - 1; // Continue searching for the first occurrence
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Find the first unused occurrence from the left
        if (result != -1) {
            for (int i = result; i < nums.length && nums[i] == target; i++) {
                if (!used[i]) {
                    return i;
                }
            }
        }

        return -1;
    }

    /**
     * Approach 4: Using Java 8 Streams with Frequency Counting
     * 
     * Time Complexity: O(n + m) Space Complexity: O(n + m)
     * 
     * More concise but potentially less efficient due to boxing/unboxing.
     */
    public int[] intersectStreams(int[] nums1, int[] nums2) {
        // Convert to Integer arrays for stream processing
        Integer[] nums1Boxed = Arrays.stream(nums1).boxed().toArray(Integer[]::new);
        Integer[] nums2Boxed = Arrays.stream(nums2).boxed().toArray(Integer[]::new);

        // Count frequencies in nums1
        Map<Integer, Long> frequencyMap = Arrays.stream(nums1Boxed)
                .collect(java.util.stream.Collectors.groupingBy(
                        java.util.function.Function.identity(),
                        java.util.stream.Collectors.counting()));

        // Build result by checking each element in nums2
        List<Integer> result = new ArrayList<>();
        Map<Integer, Long> tempMap = new HashMap<>(frequencyMap);

        for (Integer num : nums2Boxed) {
            if (tempMap.containsKey(num) && tempMap.get(num) > 0) {
                result.add(num);
                tempMap.put(num, tempMap.get(num) - 1);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Approach 5: Optimized HashMap with Array as Result
     * 
     * Time Complexity: O(n + m) Space Complexity: O(min(n, m))
     * 
     * Optimized version that avoids ArrayList and directly builds the result array.
     */
    public int[] intersectOptimized(int[] nums1, int[] nums2) {
        // Use the smaller array for frequency counting
        if (nums1.length > nums2.length) {
            return intersectOptimized(nums2, nums1);
        }

        // Count frequencies in the smaller array
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums1) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Count total intersections to pre-allocate array
        int intersectionCount = 0;
        for (int num : nums2) {
            if (frequencyMap.containsKey(num) && frequencyMap.get(num) > 0) {
                intersectionCount++;
                frequencyMap.put(num, frequencyMap.get(num) - 1);
            }
        }

        // Reset frequency map and build result
        frequencyMap.clear();
        for (int num : nums1) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[intersectionCount];
        int index = 0;

        for (int num : nums2) {
            if (frequencyMap.containsKey(num) && frequencyMap.get(num) > 0) {
                result[index++] = num;
                frequencyMap.put(num, frequencyMap.get(num) - 1);
            }
        }

        return result;
    }

    /**
     * Approach 6: Two Arrays Approach (When arrays are already sorted)
     * 
     * Time Complexity: O(n + m) if arrays are already sorted Space Complexity: O(1) excluding
     * output array
     * 
     * Most efficient when arrays are already sorted.
     */
    public int[] intersectSorted(int[] nums1, int[] nums2) {
        // Assume arrays are already sorted
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Utility method to print array for debugging
     */
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Utility method to check if two arrays contain the same elements with same frequencies (order
     * doesn't matter, but frequency does)
     */
    public static boolean arraysEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length)
            return false;

        // Count frequencies in both arrays
        Map<Integer, Integer> count1 = new HashMap<>();
        Map<Integer, Integer> count2 = new HashMap<>();

        for (int num : arr1) {
            count1.put(num, count1.getOrDefault(num, 0) + 1);
        }

        for (int num : arr2) {
            count2.put(num, count2.getOrDefault(num, 0) + 1);
        }

        return count1.equals(count2);
    }

    /**
     * Utility method to sort array for comparison (modifies original array)
     */
    public static int[] sortArray(int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        return sorted;
    }

    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        IntersectionOfTwoArraysII solution = new IntersectionOfTwoArraysII();

        // Test case 1: Example from problem
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = solution.intersectHashMap(nums1, nums2);
        System.out.println("Test 1 - HashMap: " + Arrays.toString(result));

        // Test case 2: Example from problem
        nums1 = new int[] {4, 9, 5};
        nums2 = new int[] {9, 4, 9, 8, 4};
        result = solution.intersectHashMap(nums1, nums2);
        System.out.println("Test 2 - HashMap: " + Arrays.toString(result));

        // Test all approaches
        int[] test1 = {1, 2, 2, 1};
        int[] test2 = {2, 2};

        System.out.println("\nTesting all approaches with nums1=[1,2,2,1], nums2=[2,2]:");
        System.out.println("HashMap: " + Arrays.toString(solution.intersectHashMap(test1, test2)));
        System.out.println("Sorting: "
                + Arrays.toString(solution.intersectSorting(test1.clone(), test2.clone())));
        System.out.println("Binary Search: "
                + Arrays.toString(solution.intersectBinarySearch(test1.clone(), test2.clone())));
        System.out.println("Streams: " + Arrays.toString(solution.intersectStreams(test1, test2)));
        System.out.println(
                "Optimized: " + Arrays.toString(solution.intersectOptimized(test1, test2)));
    }
}
