package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for MergeIntervals
 */
public class MergeIntervalsTest {

    private MergeIntervals solution;

    @BeforeEach
    void setUp() {
        solution = new MergeIntervals();
    }

    @Test
    void testMerge_Example1() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = solution.merge(intervals);

        int[][] expected = {{1, 6}, {8, 10}, {15, 18}};
        assertArrayEquals(expected, result);
    }

    @Test
    void testMerge_Example2() {
        int[][] intervals = {{1, 4}, {4, 5}};
        int[][] result = solution.merge(intervals);

        int[][] expected = {{1, 5}};
        assertArrayEquals(expected, result);
    }

    @Test
    void testMerge_Example3() {
        int[][] intervals = {{1, 4}, {2, 3}};
        int[][] result = solution.merge(intervals);

        int[][] expected = {{1, 4}};
        assertArrayEquals(expected, result);
    }

    @Test
    void testMerge_SingleInterval() {
        int[][] intervals = {{1, 4}};
        int[][] result = solution.merge(intervals);

        int[][] expected = {{1, 4}};
        assertArrayEquals(expected, result);
    }

    @Test
    void testMerge_NoOverlaps() {
        int[][] intervals = {{1, 2}, {3, 4}, {5, 6}};
        int[][] result = solution.merge(intervals);

        int[][] expected = {{1, 2}, {3, 4}, {5, 6}};
        assertArrayEquals(expected, result);
    }

    @Test
    void testMerge_AllOverlapping() {
        int[][] intervals = {{1, 4}, {2, 3}, {3, 5}};
        int[][] result = solution.merge(intervals);

        int[][] expected = {{1, 5}};
        assertArrayEquals(expected, result);
    }

    @Test
    void testMerge_NullInput() {
        int[][] result = solution.merge(null);
        assertTrue(result == null || result.length == 0);
    }

    @Test
    void testMerge_EmptyInput() {
        int[][] intervals = {};
        int[][] result = solution.merge(intervals);

        int[][] expected = {};
        assertArrayEquals(expected, result);
    }

    @Test
    void testMerge_UnsortedIntervals() {
        int[][] intervals = {{8, 10}, {1, 3}, {15, 18}, {2, 6}};
        int[][] result = solution.merge(intervals);

        int[][] expected = {{1, 6}, {8, 10}, {15, 18}};
        assertArrayEquals(expected, result);
    }

    @Test
    void testMerge_TouchingIntervals() {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}};
        int[][] result = solution.merge(intervals);

        int[][] expected = {{1, 4}};
        assertArrayEquals(expected, result);
    }

    @Test
    void testMerge_ContainsInterval() {
        int[][] intervals = {{1, 10}, {2, 3}, {4, 5}};
        int[][] result = solution.merge(intervals);

        int[][] expected = {{1, 10}};
        assertArrayEquals(expected, result);
    }

    @Test
    void testMerge_LargeIntervals() {
        int[][] intervals = {{1, 100}, {50, 150}, {140, 200}};
        int[][] result = solution.merge(intervals);

        int[][] expected = {{1, 200}};
        assertArrayEquals(expected, result);
    }

    @Test
    void testMerge_PartialOverlap() {
        int[][] intervals = {{1, 3}, {2, 4}, {4, 7}, {6, 9}};
        int[][] result = solution.merge(intervals);

        int[][] expected = {{1, 9}};
        assertArrayEquals(expected, result);
    }

    // Test with Priority Queue approach
    @Test
    void testMergeWithPriorityQueue_Example1() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = solution.mergeWithPriorityQueue(intervals);

        int[][] expected = {{1, 6}, {8, 10}, {15, 18}};
        assertArrayEquals(expected, result);
    }

    @Test
    void testMergeWithPriorityQueue_NoOverlaps() {
        int[][] intervals = {{1, 2}, {3, 4}, {5, 6}};
        int[][] result = solution.mergeWithPriorityQueue(intervals);

        int[][] expected = {{1, 2}, {3, 4}, {5, 6}};
        assertArrayEquals(expected, result);
    }

    // Test with In-Place approach
    @Test
    void testMergeInPlace_Example1() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = solution.mergeInPlace(intervals);

        int[][] expected = {{1, 6}, {8, 10}, {15, 18}};
        assertArrayEquals(expected, result);
    }

    @Test
    void testMergeInPlace_AllOverlapping() {
        int[][] intervals = {{1, 4}, {2, 3}, {3, 5}};
        int[][] result = solution.mergeInPlace(intervals);

        int[][] expected = {{1, 5}};
        assertArrayEquals(expected, result);
    }

    // Test with Two Pointers approach
    @Test
    void testMergeWithTwoPointers_Example1() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = solution.mergeWithTwoPointers(intervals);

        int[][] expected = {{1, 6}, {8, 10}, {15, 18}};
        assertArrayEquals(expected, result);
    }

    @Test
    void testMergeWithTwoPointers_TouchingIntervals() {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}};
        int[][] result = solution.mergeWithTwoPointers(intervals);

        int[][] expected = {{1, 4}};
        assertArrayEquals(expected, result);
    }

    @Test
    void testAllApproachesProduceSameResults() {
        int[][][] testCases = {{{1, 3}, {2, 6}, {8, 10}, {15, 18}}, {{1, 4}, {4, 5}},
                {{1, 4}, {2, 3}}, {{1, 2}, {3, 4}, {5, 6}}, {{1, 4}, {2, 3}, {3, 5}},
                {{8, 10}, {1, 3}, {15, 18}, {2, 6}}, {{1, 2}, {2, 3}, {3, 4}},
                {{1, 10}, {2, 3}, {4, 5}}, {{1, 100}, {50, 150}, {140, 200}}};

        for (int[][] testCase : testCases) {
            int[][] intervals1 = clone2DArray(testCase);
            int[][] result1 = solution.merge(intervals1);

            int[][] intervals2 = clone2DArray(testCase);
            int[][] result2 = solution.mergeWithPriorityQueue(intervals2);

            int[][] intervals3 = clone2DArray(testCase);
            int[][] result3 = solution.mergeInPlace(intervals3);

            int[][] intervals4 = clone2DArray(testCase);
            int[][] result4 = solution.mergeWithTwoPointers(intervals4);

            // All methods should produce the same results
            assertTrue(Arrays.deepEquals(result1, result2),
                    "Methods 1 and 2 differ for: " + Arrays.deepToString(testCase));
            assertTrue(Arrays.deepEquals(result2, result3),
                    "Methods 2 and 3 differ for: " + Arrays.deepToString(testCase));
            assertTrue(Arrays.deepEquals(result3, result4),
                    "Methods 3 and 4 differ for: " + Arrays.deepToString(testCase));
        }
    }

    @Test
    void testIntervalsOverlap_TouchingIntervals() {
        int[] interval1 = {1, 2};
        int[] interval2 = {2, 3};
        assertTrue(solution.intervalsOverlap(interval1, interval2));
    }

    @Test
    void testIntervalsOverlap_OverlappingIntervals() {
        int[] interval1 = {1, 3};
        int[] interval2 = {2, 4};
        assertTrue(solution.intervalsOverlap(interval1, interval2));
    }

    @Test
    void testIntervalsOverlap_NoOverlap() {
        int[] interval1 = {1, 2};
        int[] interval2 = {3, 4};
        assertTrue(!solution.intervalsOverlap(interval1, interval2));
    }

    @Test
    void testMergeTwoIntervals_Overlapping() {
        int[] interval1 = {1, 3};
        int[] interval2 = {2, 4};
        int[] result = solution.mergeTwoIntervals(interval1, interval2);

        int[] expected = {1, 4};
        assertArrayEquals(expected, result);
    }

    @Test
    void testMergeTwoIntervals_Touching() {
        int[] interval1 = {1, 2};
        int[] interval2 = {2, 3};
        int[] result = solution.mergeTwoIntervals(interval1, interval2);

        int[] expected = {1, 3};
        assertArrayEquals(expected, result);
    }

    private int[][] clone2DArray(int[][] array) {
        int[][] clone = new int[array.length][];
        for (int i = 0; i < array.length; i++) {
            clone[i] = array[i].clone();
        }
        return clone;
    }
}

