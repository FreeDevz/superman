package com.example.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * HackerRank: Merge and Sort Intervals
 * 
 * Problem Description: Given a collection of intervals, merge all overlapping intervals and return
 * a list of non-overlapping intervals sorted by their start times.
 * 
 * An interval is represented as [start, end] where start and end are integers. Two intervals [a, b]
 * and [c, d] overlap if and only if b >= c (assuming a <= b and c <= d).
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
 * Constraints: - 1 <= intervals.length <= 10^4 - intervals[i].length == 2 - 0 <= start <= end <=
 * 10^4
 * 
 * Approach Analysis: This is a classic interval merging problem. The key insight is to sort
 * intervals by start time and then merge overlapping ones by comparing end times.
 * 
 * Time Complexity: O(n log n) for sorting + O(n) for merging = O(n log n) Space Complexity: O(1)
 * excluding the output list
 */
public class MergeAndSortIntervals {

    /**
     * Approach 1: Sort and Merge (Recommended)
     * 
     * Sorts intervals by start time, then merges overlapping intervals by comparing the end time of
     * the last merged interval with the start time of the current interval.
     * 
     * Time: O(n log n) Space: O(1) excluding output
     */
    public List<List<Integer>> mergeIntervals(List<List<Integer>> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        // Sort intervals by start time
        intervals.sort((a, b) -> Integer.compare(a.get(0), b.get(0)));

        List<List<Integer>> merged = new ArrayList<>();
        merged.add(new ArrayList<>(intervals.get(0)));

        for (int i = 1; i < intervals.size(); i++) {
            List<Integer> current = intervals.get(i);
            List<Integer> last = merged.get(merged.size() - 1);

            // If current interval overlaps with the last merged interval
            if (current.get(0) <= last.get(1)) {
                // Merge by updating the end time
                last.set(1, Math.max(last.get(1), current.get(1)));
            } else {
                // No overlap, add current interval
                merged.add(new ArrayList<>(current));
            }
        }

        return merged;
    }

    /**
     * Approach 2: Using Priority Queue
     * 
     * Uses a priority queue to sort intervals and then merges them. Alternative approach that
     * demonstrates different sorting techniques.
     * 
     * Time: O(n log n) Space: O(n)
     */
    public List<List<Integer>> mergeIntervalsPriorityQueue(List<List<Integer>> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        // Use priority queue to sort intervals by start time
        PriorityQueue<List<Integer>> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(a.get(0), b.get(0)));
        for (List<Integer> interval : intervals) {
            pq.offer(new ArrayList<>(interval));
        }

        List<List<Integer>> merged = new ArrayList<>();
        merged.add(pq.poll());

        while (!pq.isEmpty()) {
            List<Integer> current = pq.poll();
            List<Integer> last = merged.get(merged.size() - 1);

            if (current.get(0) <= last.get(1)) {
                last.set(1, Math.max(last.get(1), current.get(1)));
            } else {
                merged.add(current);
            }
        }

        return merged;
    }

    /**
     * Approach 3: In-Place Merging
     * 
     * Sorts the input list in-place and merges intervals without using extra space for the result
     * list (except for the final list creation).
     * 
     * Time: O(n log n) Space: O(1) excluding output
     */
    public List<List<Integer>> mergeIntervalsInPlace(List<List<Integer>> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        // Sort intervals by start time
        intervals.sort((a, b) -> Integer.compare(a.get(0), b.get(0)));

        int writeIndex = 0;

        for (int i = 1; i < intervals.size(); i++) {
            List<Integer> current = intervals.get(i);
            List<Integer> last = intervals.get(writeIndex);

            if (current.get(0) <= last.get(1)) {
                // Merge by updating the end time
                last.set(1, Math.max(last.get(1), current.get(1)));
            } else {
                // No overlap, move to next position
                writeIndex++;
                intervals.set(writeIndex, current);
            }
        }

        // Create result list with correct size
        return new ArrayList<>(intervals.subList(0, writeIndex + 1));
    }

    /**
     * Approach 4: Two-Pointer Technique
     * 
     * Uses two pointers to efficiently merge intervals after sorting. Demonstrates an alternative
     * merging strategy.
     * 
     * Time: O(n log n) Space: O(1) excluding output
     */
    public List<List<Integer>> mergeIntervalsTwoPointers(List<List<Integer>> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        // Sort intervals by start time
        intervals.sort((a, b) -> Integer.compare(a.get(0), b.get(0)));

        List<List<Integer>> merged = new ArrayList<>();
        int i = 0;

        while (i < intervals.size()) {
            int start = intervals.get(i).get(0);
            int end = intervals.get(i).get(1);

            // Find all overlapping intervals
            while (i + 1 < intervals.size() && intervals.get(i + 1).get(0) <= end) {
                i++;
                end = Math.max(end, intervals.get(i).get(1));
            }

            List<Integer> mergedInterval = new ArrayList<>();
            mergedInterval.add(start);
            mergedInterval.add(end);
            merged.add(mergedInterval);
            i++;
        }

        return merged;
    }

    /**
     * Approach 5: Recursive Merge
     * 
     * Recursive approach that demonstrates divide-and-conquer thinking. Less efficient but
     * educational for understanding the problem structure.
     * 
     * Time: O(n log n) Space: O(log n) for recursion stack
     */
    public List<List<Integer>> mergeIntervalsRecursive(List<List<Integer>> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        // Sort intervals by start time
        intervals.sort((a, b) -> Integer.compare(a.get(0), b.get(0)));

        return mergeRecursive(intervals, 0, intervals.size() - 1);
    }

    private List<List<Integer>> mergeRecursive(List<List<Integer>> intervals, int start, int end) {
        if (start == end) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>(intervals.get(start)));
            return result;
        }

        int mid = (start + end) / 2;
        List<List<Integer>> left = mergeRecursive(intervals, start, mid);
        List<List<Integer>> right = mergeRecursive(intervals, mid + 1, end);

        return mergeTwoLists(left, right);
    }

    private List<List<Integer>> mergeTwoLists(List<List<Integer>> left, List<List<Integer>> right) {
        List<List<Integer>> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).get(0) <= right.get(j).get(0)) {
                addOrMerge(result, left.get(i));
                i++;
            } else {
                addOrMerge(result, right.get(j));
                j++;
            }
        }

        while (i < left.size()) {
            addOrMerge(result, left.get(i));
            i++;
        }

        while (j < right.size()) {
            addOrMerge(result, right.get(j));
            j++;
        }

        return result;
    }

    private void addOrMerge(List<List<Integer>> result, List<Integer> interval) {
        if (result.isEmpty() || result.get(result.size() - 1).get(1) < interval.get(0)) {
            result.add(new ArrayList<>(interval));
        } else {
            List<Integer> last = result.get(result.size() - 1);
            last.set(1, Math.max(last.get(1), interval.get(1)));
        }
    }

    /**
     * Utility method to check if two intervals overlap
     */
    public boolean intervalsOverlap(List<Integer> interval1, List<Integer> interval2) {
        return interval1.get(1) >= interval2.get(0) && interval2.get(1) >= interval1.get(0);
    }

    /**
     * Utility method to merge two overlapping intervals
     */
    public List<Integer> mergeTwoIntervals(List<Integer> interval1, List<Integer> interval2) {
        List<Integer> result = new ArrayList<>();
        result.add(Math.min(interval1.get(0), interval2.get(0)));
        result.add(Math.max(interval1.get(1), interval2.get(1)));
        return result;
    }

    /**
     * Utility method to calculate the total length of merged intervals
     */
    public int calculateTotalLength(List<List<Integer>> intervals) {
        int totalLength = 0;
        for (List<Integer> interval : intervals) {
            totalLength += interval.get(1) - interval.get(0);
        }
        return totalLength;
    }

    /**
     * Utility method to find the maximum number of overlapping intervals at any point
     */
    public int findMaxOverlappingIntervals(List<List<Integer>> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return 0;
        }

        // Create events for start and end of intervals
        List<List<Integer>> events = new ArrayList<>();
        for (List<Integer> interval : intervals) {
            List<Integer> startEvent = new ArrayList<>();
            startEvent.add(interval.get(0));
            startEvent.add(1);
            events.add(startEvent);

            List<Integer> endEvent = new ArrayList<>();
            endEvent.add(interval.get(1));
            endEvent.add(-1);
            events.add(endEvent);
        }

        // Sort events by time, then by type (end events before start events at same time)
        events.sort((a, b) -> {
            if (!a.get(0).equals(b.get(0))) {
                return Integer.compare(a.get(0), b.get(0));
            }
            return Integer.compare(a.get(1), b.get(1));
        });

        int maxOverlap = 0;
        int currentOverlap = 0;

        for (List<Integer> event : events) {
            currentOverlap += event.get(1);
            maxOverlap = Math.max(maxOverlap, currentOverlap);
        }

        return maxOverlap;
    }

    /**
     * Utility method to validate intervals (start <= end)
     */
    public boolean validateIntervals(List<List<Integer>> intervals) {
        if (intervals == null) {
            return false;
        }

        for (List<Integer> interval : intervals) {
            if (interval == null || interval.size() != 2 || interval.get(0) > interval.get(1)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        MergeAndSortIntervals solution = new MergeAndSortIntervals();

        // Test cases
        List<List<List<Integer>>> testCases = new ArrayList<>();

        // Test case 1: [[1,3],[2,6],[8,10],[15,18]]
        List<List<Integer>> test1 = new ArrayList<>();
        test1.add(Arrays.asList(1, 3));
        test1.add(Arrays.asList(2, 6));
        test1.add(Arrays.asList(8, 10));
        test1.add(Arrays.asList(15, 18));
        testCases.add(test1);

        // Test case 2: [[1,4],[4,5]]
        List<List<Integer>> test2 = new ArrayList<>();
        test2.add(Arrays.asList(1, 4));
        test2.add(Arrays.asList(4, 5));
        testCases.add(test2);

        // Test case 3: [[1,4],[2,3]]
        List<List<Integer>> test3 = new ArrayList<>();
        test3.add(Arrays.asList(1, 4));
        test3.add(Arrays.asList(2, 3));
        testCases.add(test3);

        // Test case 4: [[1,3],[2,6],[8,10],[15,18],[16,20]]
        List<List<Integer>> test4 = new ArrayList<>();
        test4.add(Arrays.asList(1, 3));
        test4.add(Arrays.asList(2, 6));
        test4.add(Arrays.asList(8, 10));
        test4.add(Arrays.asList(15, 18));
        test4.add(Arrays.asList(16, 20));
        testCases.add(test4);

        // Test case 5: [[1,1],[2,2],[3,3]]
        List<List<Integer>> test5 = new ArrayList<>();
        test5.add(Arrays.asList(1, 1));
        test5.add(Arrays.asList(2, 2));
        test5.add(Arrays.asList(3, 3));
        testCases.add(test5);

        // Test case 6: [[1,10],[2,3],[4,5],[6,7],[8,9]]
        List<List<Integer>> test6 = new ArrayList<>();
        test6.add(Arrays.asList(1, 10));
        test6.add(Arrays.asList(2, 3));
        test6.add(Arrays.asList(4, 5));
        test6.add(Arrays.asList(6, 7));
        test6.add(Arrays.asList(8, 9));
        testCases.add(test6);

        System.out.println("Testing Merge and Sort Intervals Solutions:");
        System.out.println("===========================================");

        for (int i = 0; i < testCases.size(); i++) {
            List<List<Integer>> intervals = testCases.get(i);
            System.out.printf("Test Case %d: %s\n", i + 1, intervals);

            List<List<Integer>> result1 = solution.mergeIntervals(new ArrayList<>(intervals));
            List<List<Integer>> result2 =
                    solution.mergeIntervalsPriorityQueue(new ArrayList<>(intervals));
            List<List<Integer>> result3 =
                    solution.mergeIntervalsInPlace(new ArrayList<>(intervals));
            List<List<Integer>> result4 =
                    solution.mergeIntervalsTwoPointers(new ArrayList<>(intervals));
            List<List<Integer>> result5 =
                    solution.mergeIntervalsRecursive(new ArrayList<>(intervals));

            System.out.printf("Sort & Merge: %s\n", result1);
            System.out.printf("Priority Queue: %s\n", result2);
            System.out.printf("In-Place: %s\n", result3);
            System.out.printf("Two Pointers: %s\n", result4);
            System.out.printf("Recursive: %s\n", result5);

            // Validate results
            boolean allEqual = result1.equals(result2) && result2.equals(result3)
                    && result3.equals(result4) && result4.equals(result5);

            System.out.printf("All approaches consistent: %s\n", allEqual ? "✓" : "✗");
            System.out.printf("Total length: %d\n", solution.calculateTotalLength(result1));
            System.out.printf("Max overlapping: %d\n",
                    solution.findMaxOverlappingIntervals(intervals));
            System.out.println("---");
        }
    }
}

