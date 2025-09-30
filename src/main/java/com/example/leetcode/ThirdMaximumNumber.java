package com.example.leetcode;

import java.util.*;

/**
 * LeetCode 414: Third Maximum Number
 * 
 * Problem Description: Given an integer array nums, return the third distinct maximum number in
 * this array. If the third maximum does not exist, return the maximum number.
 * 
 * Example 1: Input: nums = [3,2,1] Output: 1 Explanation: The first distinct maximum is 3, the
 * second is 2, and the third is 1.
 * 
 * Example 2: Input: nums = [1,2] Output: 2 Explanation: The third maximum does not exist, so the
 * maximum (2) is returned.
 * 
 * Example 3: Input: nums = [2,2,3,1] Output: 1 Explanation: The first distinct maximum is 3, the
 * second is 2, and the third is 1.
 * 
 * Constraints: - 1 <= nums.length <= 10^4 - -2^31 <= nums[i] <= 2^31 - 1
 * 
 * Time Complexity Analysis: - Three-Variable Tracking: O(n) time, O(1) space - Most efficient -
 * TreeSet Approach: O(n log 3) time, O(3) space - Automatic sorting - Sorting Approach: O(n log n)
 * time, O(n) space - Simple but less efficient - HashSet + Sorting: O(n log n) time, O(n) space -
 * Handles duplicates explicitly
 */
public class ThirdMaximumNumber {

    /**
     * Approach 1: Three-Variable Tracking (Most Efficient)
     * 
     * Time Complexity: O(n) where n = nums.length Space Complexity: O(1) - only uses three
     * variables
     * 
     * This is the most efficient approach for this problem.
     */
    public int thirdMaxThreeVariables(int[] nums) {
        // Use Long.MIN_VALUE to handle Integer.MIN_VALUE cases
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        for (int num : nums) {
            // Skip duplicates
            if (num == first || num == second || num == third) {
                continue;
            }

            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second) {
                third = second;
                second = num;
            } else if (num > third) {
                third = num;
            }
        }

        // Return third if it exists, otherwise return first (maximum)
        return third == Long.MIN_VALUE ? (int) first : (int) third;
    }

    /**
     * Approach 2: TreeSet with Size Limit
     * 
     * Time Complexity: O(n log 3) = O(n) where n = nums.length Space Complexity: O(3) = O(1) -
     * TreeSet maintains at most 3 elements
     * 
     * Automatically handles sorting and size management.
     */
    public int thirdMaxTreeSet(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();

        for (int num : nums) {
            set.add(num);
            // Keep only the 3 largest elements
            if (set.size() > 3) {
                set.pollFirst(); // Remove the smallest element
            }
        }

        // Return the third maximum if it exists, otherwise return the maximum
        return set.size() == 3 ? set.first() : set.last();
    }

    /**
     * Approach 3: HashSet + Sorting
     * 
     * Time Complexity: O(n log n) where n = nums.length (due to sorting) Space Complexity: O(n) for
     * the HashSet and array
     * 
     * Handles duplicates explicitly and provides clear logic.
     */
    public int thirdMaxHashSetSorting(int[] nums) {
        // Remove duplicates using HashSet
        Set<Integer> uniqueNums = new HashSet<>();
        for (int num : nums) {
            uniqueNums.add(num);
        }

        // Convert to array and sort in descending order
        Integer[] uniqueArray = uniqueNums.toArray(new Integer[0]);
        Arrays.sort(uniqueArray, Collections.reverseOrder());

        // Return third maximum if it exists, otherwise return maximum
        return uniqueArray.length >= 3 ? uniqueArray[2] : uniqueArray[0];
    }

    /**
     * Approach 4: Single Pass with Array Tracking
     * 
     * Time Complexity: O(n) where n = nums.length Space Complexity: O(1) - uses array of size 3
     * 
     * Similar to three-variable approach but uses array for cleaner code.
     */
    public int thirdMaxArrayTracking(int[] nums) {
        long[] maxThree = {Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE};

        for (int num : nums) {
            // Skip duplicates
            if (num == maxThree[0] || num == maxThree[1] || num == maxThree[2]) {
                continue;
            }

            // Insert num in correct position
            if (num > maxThree[0]) {
                maxThree[2] = maxThree[1];
                maxThree[1] = maxThree[0];
                maxThree[0] = num;
            } else if (num > maxThree[1]) {
                maxThree[2] = maxThree[1];
                maxThree[1] = num;
            } else if (num > maxThree[2]) {
                maxThree[2] = num;
            }
        }

        // Return third maximum if it exists, otherwise return maximum
        return maxThree[2] == Long.MIN_VALUE ? (int) maxThree[0] : (int) maxThree[2];
    }

    /**
     * Approach 5: PriorityQueue (Min Heap)
     * 
     * Time Complexity: O(n log 3) = O(n) where n = nums.length Space Complexity: O(3) = O(1) -
     * PriorityQueue maintains at most 3 elements
     * 
     * Uses min heap to maintain the 3 largest elements.
     */
    public int thirdMaxPriorityQueue(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            if (!seen.contains(num)) {
                seen.add(num);
                minHeap.offer(num);

                // Keep only the 3 largest elements
                if (minHeap.size() > 3) {
                    minHeap.poll(); // Remove the smallest element
                }
            }
        }

        // If we have 3 elements, return the smallest (third maximum)
        // Otherwise, return the largest (maximum)
        if (minHeap.size() == 3) {
            return minHeap.poll(); // This is the third maximum
        } else {
            // Return the maximum by polling all elements
            int max = minHeap.poll();
            while (!minHeap.isEmpty()) {
                max = minHeap.poll();
            }
            return max;
        }
    }

    /**
     * Approach 6: Streams with Distinct and Sorting
     * 
     * Time Complexity: O(n log n) where n = nums.length (due to sorting) Space Complexity: O(n) for
     * the stream processing
     * 
     * Functional programming approach using Java 8 streams.
     */
    public int thirdMaxStreams(int[] nums) {
        List<Integer> distinctSorted = Arrays.stream(nums).distinct().boxed()
                .sorted(Collections.reverseOrder()).collect(java.util.stream.Collectors.toList());

        // Return third maximum if it exists, otherwise return maximum
        return distinctSorted.size() >= 3 ? distinctSorted.get(2) : distinctSorted.get(0);
    }

    /**
     * Approach 7: Optimized Three-Variable with Integer.MIN_VALUE Handling
     * 
     * Time Complexity: O(n) where n = nums.length Space Complexity: O(1) - only uses three
     * variables
     * 
     * Handles edge cases with Integer.MIN_VALUE more elegantly.
     */
    public int thirdMaxOptimized(int[] nums) {
        Integer first = null;
        Integer second = null;
        Integer third = null;

        for (int num : nums) {
            // Skip duplicates
            if ((first != null && num == first) || (second != null && num == second)
                    || (third != null && num == third)) {
                continue;
            }

            if (first == null || num > first) {
                third = second;
                second = first;
                first = num;
            } else if (second == null || num > second) {
                third = second;
                second = num;
            } else if (third == null || num > third) {
                third = num;
            }
        }

        // Return third maximum if it exists, otherwise return maximum
        return third != null ? third : first;
    }

    /**
     * Utility method to print array for debugging
     */
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Utility method to find all distinct elements in array
     */
    public static Set<Integer> getDistinctElements(int[] nums) {
        Set<Integer> distinct = new HashSet<>();
        for (int num : nums) {
            distinct.add(num);
        }
        return distinct;
    }

    /**
     * Utility method to get sorted distinct elements
     */
    public static List<Integer> getSortedDistinctElements(int[] nums) {
        return Arrays.stream(nums).distinct().boxed().sorted(Collections.reverseOrder())
                .collect(java.util.stream.Collectors.toList());
    }

    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        ThirdMaximumNumber solution = new ThirdMaximumNumber();

        // Test case 1: Example from problem
        int[] nums1 = {3, 2, 1};
        int result = solution.thirdMaxThreeVariables(nums1);
        System.out.println("Test 1 - Three Variables: " + result);

        // Test case 2: Example from problem
        int[] nums2 = {1, 2};
        result = solution.thirdMaxThreeVariables(nums2);
        System.out.println("Test 2 - Three Variables: " + result);

        // Test case 3: Example from problem
        int[] nums3 = {2, 2, 3, 1};
        result = solution.thirdMaxThreeVariables(nums3);
        System.out.println("Test 3 - Three Variables: " + result);

        // Test all approaches
        int[] test = {2, 2, 3, 1};

        System.out.println("\nTesting all approaches with nums=[2,2,3,1]:");
        System.out.println("Three Variables: " + solution.thirdMaxThreeVariables(test));
        System.out.println("TreeSet: " + solution.thirdMaxTreeSet(test));
        System.out.println("HashSet + Sorting: " + solution.thirdMaxHashSetSorting(test));
        System.out.println("Array Tracking: " + solution.thirdMaxArrayTracking(test));
        System.out.println("Priority Queue: " + solution.thirdMaxPriorityQueue(test));
        System.out.println("Streams: " + solution.thirdMaxStreams(test));
        System.out.println("Optimized: " + solution.thirdMaxOptimized(test));
    }
}
