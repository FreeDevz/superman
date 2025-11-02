package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * LeetCode #56: Merge Intervals
 * 
 * Problem Description: Given an array of intervals where intervals[i] = [starti, endi], merge all
 * overlapping intervals, and return an array of the non-overlapping intervals that cover all the
 * intervals in the input.
 * 
 * Example 1: Input: intervals = [[1,3],[2,6],[8,10],[15,18]] Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * 
 * Example 2: Input: intervals = [[1,4],[4,5]] Output: [[1,5]] Explanation: Intervals [1,4] and
 * [4,5] are considered overlapping.
 * 
 * Example 3: Input: intervals = [[1,4],[2,3]] Output: [[1,4]] Explanation: Since intervals [1,4]
 * and [2,3] overlap, merge them into [1,4].
 * 
 * Constraints: - 1 <= intervals.length <= 10^4 - intervals[i].length == 2 - 0 <= starti <= endi <=
 * 10^4
 * 
 * Approach 1: Sort and Merge (Recommended) Time Complexity: O(n log n) Space Complexity: O(1)
 * excluding output array
 * 
 * Approach 2: Using Priority Queue Time Complexity: O(n log n) Space Complexity: O(n)
 * 
 * Approach 3: In-Place Merging Time Complexity: O(n log n) Space Complexity: O(1) excluding output
 * array
 * 
 * Approach 4: Two-Pointer Technique Time Complexity: O(n log n) Space Complexity: O(1) excluding
 * output array
 */
public class MergeIntervals {

    /**
     * Approach 1: Sort and Merge (Recommended)
     * 
     * Sorts intervals by start time, then merges overlapping intervals by comparing the end time of
     * the last merged interval with the start time of the current interval.
     * 
     * This is the most straightforward and efficient approach for LeetCode problems.
     * 
     * Time: O(n log n) Space: O(1) excluding output array
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            int[] last = merged.get(merged.size() - 1);

            // If current interval overlaps with the last merged interval
            if (current[0] <= last[1]) {
                // Merge by updating the end time
                last[1] = Math.max(last[1], current[1]);
            } else {
                // No overlap, add current interval
                merged.add(current);
            }
        }

        return merged.toArray(new int[merged.size()][2]);
    }

    /**
     * Approach 2: Using Priority Queue
     * 
     * Uses a priority queue to sort intervals and then merges them. Alternative approach that
     * demonstrates different sorting techniques.
     * 
     * Time: O(n log n) Space: O(n)
     */
    public int[][] mergeWithPriorityQueue(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // Use priority queue to sort intervals by start time
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int[] interval : intervals) {
            pq.offer(interval);
        }

        List<int[]> merged = new ArrayList<>();
        merged.add(pq.poll());

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int[] last = merged.get(merged.size() - 1);

            if (current[0] <= last[1]) {
                last[1] = Math.max(last[1], current[1]);
            } else {
                merged.add(current);
            }
        }

        return merged.toArray(new int[merged.size()][2]);
    }

    /**
     * Approach 3: In-Place Merging
     * 
     * Sorts the input array in-place and merges intervals without using extra space for the result
     * list (except for the final array creation).
     * 
     * Time: O(n log n) Space: O(1) excluding output array
     */
    public int[][] mergeInPlace(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int writeIndex = 0;

        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            int[] last = intervals[writeIndex];

            if (current[0] <= last[1]) {
                // Merge by updating the end time
                last[1] = Math.max(last[1], current[1]);
            } else {
                // No overlap, move to next position
                writeIndex++;
                intervals[writeIndex] = current;
            }
        }

        // Create result array with correct size
        return Arrays.copyOf(intervals, writeIndex + 1);
    }

    /**
     * Approach 4: Two-Pointer Technique
     * 
     * Uses two pointers to efficiently merge intervals after sorting. Demonstrates an alternative
     * merging strategy.
     * 
     * Time: O(n log n) Space: O(1) excluding output array
     */
    public int[][] mergeWithTwoPointers(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int i = 0;

        while (i < intervals.length) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            // Find all overlapping intervals
            while (i + 1 < intervals.length && intervals[i + 1][0] <= end) {
                i++;
                end = Math.max(end, intervals[i][1]);
            }

            merged.add(new int[] {start, end});
            i++;
        }

        return merged.toArray(new int[merged.size()][2]);
    }

    /**
     * Utility method to check if two intervals overlap
     */
    public boolean intervalsOverlap(int[] interval1, int[] interval2) {
        return interval1[1] >= interval2[0] && interval2[1] >= interval1[0];
    }

    /**
     * Utility method to merge two overlapping intervals
     */
    public int[] mergeTwoIntervals(int[] interval1, int[] interval2) {
        return new int[] {Math.min(interval1[0], interval2[0]),
                Math.max(interval1[1], interval2[1])};
    }

    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        MergeIntervals solution = new MergeIntervals();

        System.out.println("🚀 LeetCode #56: Merge Intervals");
        System.out.println("=".repeat(50));

        // Test case 1
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println("Test Case 1:");
        System.out.println("Input: [[1,3],[2,6],[8,10],[15,18]]");

        int[][] result1 = solution.merge(intervals1);
        System.out.print("Output: ");
        printIntervals(result1);
        System.out.println("Expected: [[1,6],[8,10],[15,18]]");
        System.out.println();

        // Test case 2
        int[][] intervals2 = {{1, 4}, {4, 5}};
        System.out.println("Test Case 2:");
        System.out.println("Input: [[1,4],[4,5]]");

        int[][] result2 = solution.merge(intervals2);
        System.out.print("Output: ");
        printIntervals(result2);
        System.out.println("Expected: [[1,5]]");
        System.out.println();

        // Test case 3
        int[][] intervals3 = {{1, 4}, {2, 3}};
        System.out.println("Test Case 3:");
        System.out.println("Input: [[1,4],[2,3]]");

        int[][] result3 = solution.merge(intervals3);
        System.out.print("Output: ");
        printIntervals(result3);
        System.out.println("Expected: [[1,4]]");
        System.out.println();

        // Test case 4: Single interval
        int[][] intervals4 = {{1, 4}};
        System.out.println("Test Case 4:");
        System.out.println("Input: [[1,4]]");

        int[][] result4 = solution.merge(intervals4);
        System.out.print("Output: ");
        printIntervals(result4);
        System.out.println("Expected: [[1,4]]");
        System.out.println();

        // Test case 5: No overlaps
        int[][] intervals5 = {{1, 2}, {3, 4}, {5, 6}};
        System.out.println("Test Case 5:");
        System.out.println("Input: [[1,2],[3,4],[5,6]]");

        int[][] result5 = solution.merge(intervals5);
        System.out.print("Output: ");
        printIntervals(result5);
        System.out.println("Expected: [[1,2],[3,4],[5,6]]");
        System.out.println();

        // Test all approaches
        System.out.println("Testing all approaches:");
        testAllApproaches(solution, intervals1);
    }

    private static void testAllApproaches(MergeIntervals solution, int[][] intervals) {
        System.out.println("\nInput: [[1,3],[2,6],[8,10],[15,18]]");

        // Clone intervals for each approach to avoid mutation
        int[][] intervals1 = clone2DArray(intervals);
        int[][] result1 = solution.merge(intervals1);
        System.out.print("Approach 1 (Sort and Merge): ");
        printIntervals(result1);

        int[][] intervals2 = clone2DArray(intervals);
        int[][] result2 = solution.mergeWithPriorityQueue(intervals2);
        System.out.print("Approach 2 (Priority Queue): ");
        printIntervals(result2);

        int[][] intervals3 = clone2DArray(intervals);
        int[][] result3 = solution.mergeInPlace(intervals3);
        System.out.print("Approach 3 (In-Place): ");
        printIntervals(result3);

        int[][] intervals4 = clone2DArray(intervals);
        int[][] result4 = solution.mergeWithTwoPointers(intervals4);
        System.out.print("Approach 4 (Two Pointers): ");
        printIntervals(result4);

        // Verify all approaches produce the same result
        boolean allSame = Arrays.deepEquals(result1, result2) && Arrays.deepEquals(result2, result3)
                && Arrays.deepEquals(result3, result4);
        System.out.println("All approaches produce same result: " + allSame);
    }

    private static void printIntervals(int[][] intervals) {
        System.out.print("[");
        for (int i = 0; i < intervals.length; i++) {
            System.out.print("[" + intervals[i][0] + "," + intervals[i][1] + "]");
            if (i < intervals.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    private static int[][] clone2DArray(int[][] array) {
        int[][] clone = new int[array.length][];
        for (int i = 0; i < array.length; i++) {
            clone[i] = array[i].clone();
        }
        return clone;
    }
}

