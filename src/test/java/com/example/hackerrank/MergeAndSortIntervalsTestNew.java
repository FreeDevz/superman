package com.example.hackerrank;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Test suite for Merge and Sort Intervals problem using List<List<Integer>>
 */
@DisplayName("Merge and Sort Intervals Tests (List Version)")
class MergeAndSortIntervalsTestNew {

    private MergeAndSortIntervals solution;

    @BeforeEach
    void setUp() {
        solution = new MergeAndSortIntervals();
    }

    // Helper methods for creating test data
    private List<List<Integer>> createIntervals(int[][] data) {
        List<List<Integer>> intervals = new ArrayList<>();
        for (int[] interval : data) {
            intervals.add(Arrays.asList(interval[0], interval[1]));
        }
        return intervals;
    }

    @Test
    @DisplayName("Basic overlapping intervals")
    void testBasicOverlapping() {
        List<List<Integer>> intervals = createIntervals(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        List<List<Integer>> expected = createIntervals(new int[][]{{1, 6}, {8, 10}, {15, 18}});
        List<List<Integer>> result = solution.mergeIntervals(intervals);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Adjacent intervals")
    void testAdjacentIntervals() {
        List<List<Integer>> intervals = createIntervals(new int[][]{{1, 4}, {4, 5}});
        List<List<Integer>> expected = createIntervals(new int[][]{{1, 5}});
        List<List<Integer>> result = solution.mergeIntervals(intervals);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Completely overlapping intervals")
    void testCompletelyOverlapping() {
        List<List<Integer>> intervals = createIntervals(new int[][]{{1, 4}, {2, 3}});
        List<List<Integer>> expected = createIntervals(new int[][]{{1, 4}});
        List<List<Integer>> result = solution.mergeIntervals(intervals);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("No overlapping intervals")
    void testNoOverlapping() {
        List<List<Integer>> intervals = createIntervals(new int[][]{{1, 2}, {3, 4}, {5, 6}});
        List<List<Integer>> expected = createIntervals(new int[][]{{1, 2}, {3, 4}, {5, 6}});
        List<List<Integer>> result = solution.mergeIntervals(intervals);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Single interval")
    void testSingleInterval() {
        List<List<Integer>> intervals = createIntervals(new int[][]{{1, 3}});
        List<List<Integer>> expected = createIntervals(new int[][]{{1, 3}});
        List<List<Integer>> result = solution.mergeIntervals(intervals);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Empty list")
    void testEmptyList() {
        List<List<Integer>> intervals = new ArrayList<>();
        List<List<Integer>> expected = new ArrayList<>();
        List<List<Integer>> result = solution.mergeIntervals(intervals);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Null input")
    void testNullInput() {
        List<List<Integer>> result = solution.mergeIntervals(null);
        assertNull(result);
    }

    @Test
    @DisplayName("All approaches should produce same results")
    void testAllApproachesProduceSameResults() {
        int[][][] testCases = {{{1, 3}, {2, 6}, {8, 10}, {15, 18}}, {{1, 4}, {4, 5}},
                {{1, 4}, {2, 3}}, {{1, 2}, {3, 4}, {5, 6}}, {{1, 3}}, {},
                {{1, 3}, {2, 6}, {8, 10}, {15, 18}, {16, 20}}, {{1, 1}, {2, 2}, {3, 3}},
                {{1, 10}, {2, 3}, {4, 5}, {6, 7}, {8, 9}}};

        for (int[][] testCase : testCases) {
            List<List<Integer>> intervals = createIntervals(testCase);
            List<List<Integer>> result1 = solution.mergeIntervals(new ArrayList<>(intervals));
            List<List<Integer>> result2 = solution.mergeIntervalsPriorityQueue(new ArrayList<>(intervals));
            List<List<Integer>> result3 = solution.mergeIntervalsInPlace(new ArrayList<>(intervals));
            List<List<Integer>> result4 = solution.mergeIntervalsTwoPointers(new ArrayList<>(intervals));
            List<List<Integer>> result5 = solution.mergeIntervalsRecursive(new ArrayList<>(intervals));

            // All approaches should produce the same result
            assertEquals(result1, result2, "Priority Queue differs from Sort & Merge");
            assertEquals(result2, result3, "In-Place differs from Priority Queue");
            assertEquals(result3, result4, "Two Pointers differs from In-Place");
            assertEquals(result4, result5, "Recursive differs from Two Pointers");
        }
    }

    @Test
    @DisplayName("Test interval overlap detection")
    void testIntervalOverlapDetection() {
        assertTrue(solution.intervalsOverlap(Arrays.asList(1, 3), Arrays.asList(2, 4)));
        assertTrue(solution.intervalsOverlap(Arrays.asList(1, 4), Arrays.asList(2, 3)));
        assertTrue(solution.intervalsOverlap(Arrays.asList(1, 3), Arrays.asList(3, 5)));
        assertFalse(solution.intervalsOverlap(Arrays.asList(1, 2), Arrays.asList(3, 4)));
        assertFalse(solution.intervalsOverlap(Arrays.asList(3, 4), Arrays.asList(1, 2)));
    }

    @Test
    @DisplayName("Test merging two intervals")
    void testMergingTwoIntervals() {
        List<Integer> result1 = solution.mergeTwoIntervals(Arrays.asList(1, 3), Arrays.asList(2, 4));
        assertEquals(Arrays.asList(1, 4), result1);

        List<Integer> result2 = solution.mergeTwoIntervals(Arrays.asList(1, 4), Arrays.asList(2, 3));
        assertEquals(Arrays.asList(1, 4), result2);

        List<Integer> result3 = solution.mergeTwoIntervals(Arrays.asList(1, 2), Arrays.asList(3, 4));
        assertEquals(Arrays.asList(1, 4), result3);
    }

    @Test
    @DisplayName("Test total length calculation")
    void testTotalLengthCalculation() {
        List<List<Integer>> intervals = createIntervals(new int[][]{{1, 3}, {5, 7}, {9, 11}});
        int totalLength = solution.calculateTotalLength(intervals);
        assertEquals(6, totalLength); // (3-1) + (7-5) + (11-9) = 2 + 2 + 2 = 6
    }

    @Test
    @DisplayName("Test maximum overlapping intervals")
    void testMaxOverlappingIntervals() {
        List<List<Integer>> intervals = createIntervals(new int[][]{{1, 3}, {2, 4}, {3, 5}});
        int maxOverlap = solution.findMaxOverlappingIntervals(intervals);
        assertEquals(2, maxOverlap);
    }

    @Test
    @DisplayName("Test interval validation")
    void testIntervalValidation() {
        assertTrue(solution.validateIntervals(createIntervals(new int[][]{{1, 3}, {2, 4}})));
        assertFalse(solution.validateIntervals(createIntervals(new int[][]{{3, 1}, {2, 4}}))); // start > end
        // Test with invalid interval
        List<List<Integer>> invalidIntervals = new ArrayList<>();
        invalidIntervals.add(Arrays.asList(1, 3));
        invalidIntervals.add(null);
        assertFalse(solution.validateIntervals(invalidIntervals)); // null interval
        // Test with wrong size
        List<List<Integer>> wrongSizeIntervals = new ArrayList<>();
        wrongSizeIntervals.add(Arrays.asList(1, 3));
        wrongSizeIntervals.add(Arrays.asList(2));
        assertFalse(solution.validateIntervals(wrongSizeIntervals)); // wrong length
    }
}
