package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 228: Summary Ranges
 * 
 * Problem Description: You are given a sorted unique integer array nums. A range [a,b] is the set
 * of all integers from a to b (inclusive). Return the smallest sorted list of ranges that cover all
 * the numbers in the array exactly. That is, each element of nums is covered by exactly one of the
 * ranges, and there is no integer x such that x is in one of the ranges but not in nums.
 * 
 * Each range [a,b] in the list should be output as: - "a->b" if a != b - "a" if a == b
 * 
 * Example 1: Input: nums = [0,1,2,4,5,7] Output: ["0->2","4->5","7"] Explanation: The ranges are:
 * [0,2] --> "0->2" [4,5] --> "4->5" [7,7] --> "7"
 * 
 * Example 2: Input: nums = [0,2,3,4,6,8,9] Output: ["0","2->4","6","8->9"] Explanation: The ranges
 * are: [0,0] --> "0" [2,4] --> "2->4" [6,6] --> "6" [8,9] --> "8->9"
 * 
 * Constraints: - 0 <= nums.length <= 20 - -2^31 <= nums[i] <= 2^31 - 1 - All the values of nums are
 * unique. - nums is sorted in ascending order.
 * 
 * Time Complexity: O(n) where n is the length of nums Space Complexity: O(1) excluding the output
 * array
 */
public class SummaryRanges {

    /**
     * Approach 1: Two Pointers Use two pointers to track the start and end of each range.
     * 
     * Time Complexity: O(n) Space Complexity: O(1) excluding output
     */
    public List<String> summaryRangesTwoPointers(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        int start = nums[0];
        int end = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                end = nums[i];
            } else {
                // Add current range
                if (start == end) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + end);
                }
                // Start new range
                start = nums[i];
                end = nums[i];
            }
        }

        // Add the last range
        if (start == end) {
            result.add(String.valueOf(start));
        } else {
            result.add(start + "->" + end);
        }

        return result;
    }

    /**
     * Approach 2: Single Pass with StringBuilder More memory efficient by building strings on the
     * fly.
     * 
     * Time Complexity: O(n) Space Complexity: O(1) excluding output
     */
    public List<String> summaryRangesSinglePass(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        int start = nums[0];

        for (int i = 1; i <= nums.length; i++) {
            // Check if we've reached the end or found a gap
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + nums[i - 1]);
                }
                if (i < nums.length) {
                    start = nums[i];
                }
            }
        }

        return result;
    }

    /**
     * Approach 3: Using ArrayList for intermediate storage Store ranges as pairs and convert to
     * strings at the end.
     * 
     * Time Complexity: O(n) Space Complexity: O(n) for intermediate storage
     */
    public List<String> summaryRangesWithPairs(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        List<int[]> ranges = new ArrayList<>();
        int start = nums[0];
        int end = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                end = nums[i];
            } else {
                ranges.add(new int[] {start, end});
                start = nums[i];
                end = nums[i];
            }
        }
        ranges.add(new int[] {start, end});

        // Convert ranges to strings
        for (int[] range : ranges) {
            if (range[0] == range[1]) {
                result.add(String.valueOf(range[0]));
            } else {
                result.add(range[0] + "->" + range[1]);
            }
        }

        return result;
    }

    /**
     * Approach 4: Recursive Solution Divide and conquer approach (less efficient but demonstrates
     * recursion).
     * 
     * Time Complexity: O(n) Space Complexity: O(n) due to recursion stack
     */
    public List<String> summaryRangesRecursive(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        helper(nums, 0, result);
        return result;
    }

    private void helper(int[] nums, int index, List<String> result) {
        if (index >= nums.length) {
            return;
        }

        int start = nums[index];
        int end = start;

        // Find the end of current consecutive sequence
        while (index + 1 < nums.length && nums[index + 1] == nums[index] + 1) {
            index++;
            end = nums[index];
        }

        // Add current range
        if (start == end) {
            result.add(String.valueOf(start));
        } else {
            result.add(start + "->" + end);
        }

        // Process remaining elements
        helper(nums, index + 1, result);
    }

    /**
     * Approach 5: Optimized with early termination Optimized version that handles edge cases more
     * efficiently.
     * 
     * Time Complexity: O(n) Space Complexity: O(1) excluding output
     */
    public List<String> summaryRangesOptimized(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        if (nums.length == 1) {
            result.add(String.valueOf(nums[0]));
            return result;
        }

        int start = nums[0];
        int prev = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != prev + 1) {
                // Gap found, add current range
                if (start == prev) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + prev);
                }
                start = nums[i];
            }
            prev = nums[i];
        }

        // Add final range
        if (start == prev) {
            result.add(String.valueOf(start));
        } else {
            result.add(start + "->" + prev);
        }

        return result;
    }

    /**
     * Utility method to print ranges in a formatted way
     */
    public void printRanges(List<String> ranges) {
        System.out.print("[");
        for (int i = 0; i < ranges.size(); i++) {
            System.out.print("\"" + ranges.get(i) + "\"");
            if (i < ranges.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /**
     * Utility method to compare two lists of ranges
     */
    public boolean compareRanges(List<String> ranges1, List<String> ranges2) {
        if (ranges1.size() != ranges2.size()) {
            return false;
        }

        for (int i = 0; i < ranges1.size(); i++) {
            if (!ranges1.get(i).equals(ranges2.get(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        SummaryRanges solution = new SummaryRanges();

        // Test cases
        int[][] testCases = {{0, 1, 2, 4, 5, 7}, {0, 2, 3, 4, 6, 8, 9}, {0}, {}, {1, 3},
                {-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {-2, -1, 0, 1, 2, 4, 5, 7, 8, 9, 10, 12, 13, 14, 15, 16, 17, 18, 19, 20}};

        String[][] expectedResults = {{"0->2", "4->5", "7"}, {"0", "2->4", "6", "8->9"}, {"0"}, {},
                {"1", "3"}, {"-1->10"}, {"-2->2", "4->5", "7->10", "12->20"}};

        System.out.println("Testing Summary Ranges Solutions:");
        System.out.println("=================================");

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("\nTest Case " + (i + 1) + ":");
            System.out.println("Input: " + Arrays.toString(testCases[i]));
            System.out.println("Expected: " + Arrays.toString(expectedResults[i]));

            // Test all approaches
            List<String> result1 = solution.summaryRangesTwoPointers(testCases[i]);
            List<String> result2 = solution.summaryRangesSinglePass(testCases[i]);
            List<String> result3 = solution.summaryRangesWithPairs(testCases[i]);
            List<String> result4 = solution.summaryRangesRecursive(testCases[i]);
            List<String> result5 = solution.summaryRangesOptimized(testCases[i]);

            System.out.println("Two Pointers: " + result1);
            System.out.println("Single Pass: " + result2);
            System.out.println("With Pairs: " + result3);
            System.out.println("Recursive: " + result4);
            System.out.println("Optimized: " + result5);

            // Verify all approaches produce the same result
            boolean allMatch = solution.compareRanges(result1, result2)
                    && solution.compareRanges(result2, result3)
                    && solution.compareRanges(result3, result4)
                    && solution.compareRanges(result4, result5);

            System.out.println("All approaches match: " + allMatch);
        }

        // Performance comparison
        System.out.println("\nPerformance Analysis:");
        System.out.println("====================");

        int[] largeArray = new int[1000];
        for (int i = 0; i < 1000; i++) {
            largeArray[i] = i * 2; // Create gaps
        }

        long startTime, endTime;

        startTime = System.nanoTime();
        solution.summaryRangesTwoPointers(largeArray);
        endTime = System.nanoTime();
        System.out.println("Two Pointers: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        solution.summaryRangesSinglePass(largeArray);
        endTime = System.nanoTime();
        System.out.println("Single Pass: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        solution.summaryRangesOptimized(largeArray);
        endTime = System.nanoTime();
        System.out.println("Optimized: " + (endTime - startTime) + " ns");
    }
}
