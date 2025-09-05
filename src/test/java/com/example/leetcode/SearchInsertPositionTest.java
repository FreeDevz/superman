package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test cases for LeetCode 35. Search Insert Position
 * 
 * Tests various scenarios including: - Target found in array - Target not found (insert at
 * beginning, middle, end) - Edge cases (single element, empty array behavior) - Multiple solution
 * approaches
 */
public class SearchInsertPositionTest {

    private SearchInsertPosition solution;

    @BeforeEach
    void setUp() {
        solution = new SearchInsertPosition();
    }

    @Test
    void testSearchInsert_TargetFound() {
        // Test case 1: Target found in array
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        int expected = 2;
        int actual = solution.searchInsert(nums, target);
        assertEquals(expected, actual, "Target 5 should be found at index 2");
    }

    @Test
    void testSearchInsert_TargetNotFound_InsertMiddle() {
        // Test case 2: Target not found, insert in middle
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        int expected = 1;
        int actual = solution.searchInsert(nums, target);
        assertEquals(expected, actual, "Target 2 should be inserted at index 1");
    }

    @Test
    void testSearchInsert_TargetNotFound_InsertEnd() {
        // Test case 3: Target not found, insert at end
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        int expected = 4;
        int actual = solution.searchInsert(nums, target);
        assertEquals(expected, actual, "Target 7 should be inserted at index 4");
    }

    @Test
    void testSearchInsert_TargetNotFound_InsertBeginning() {
        // Test case 4: Target not found, insert at beginning
        int[] nums = {1, 3, 5, 6};
        int target = 0;
        int expected = 0;
        int actual = solution.searchInsert(nums, target);
        assertEquals(expected, actual, "Target 0 should be inserted at index 0");
    }

    @Test
    void testSearchInsert_SingleElement_Found() {
        // Test case 5: Single element array, target found
        int[] nums = {1};
        int target = 1;
        int expected = 0;
        int actual = solution.searchInsert(nums, target);
        assertEquals(expected, actual,
                "Target 1 should be found at index 0 in single element array");
    }

    @Test
    void testSearchInsert_SingleElement_InsertBefore() {
        // Test case 6: Single element array, insert before
        int[] nums = {1};
        int target = 0;
        int expected = 0;
        int actual = solution.searchInsert(nums, target);
        assertEquals(expected, actual, "Target 0 should be inserted at index 0");
    }

    @Test
    void testSearchInsert_SingleElement_InsertAfter() {
        // Test case 7: Single element array, insert after
        int[] nums = {1};
        int target = 2;
        int expected = 1;
        int actual = solution.searchInsert(nums, target);
        assertEquals(expected, actual, "Target 2 should be inserted at index 1");
    }

    @Test
    void testSearchInsert_TwoElements_Found() {
        // Test case 8: Two elements, target found
        int[] nums = {1, 3};
        int target = 1;
        int expected = 0;
        int actual = solution.searchInsert(nums, target);
        assertEquals(expected, actual, "Target 1 should be found at index 0");

        target = 3;
        expected = 1;
        actual = solution.searchInsert(nums, target);
        assertEquals(expected, actual, "Target 3 should be found at index 1");
    }

    @Test
    void testSearchInsert_TwoElements_InsertBetween() {
        // Test case 9: Two elements, insert between
        int[] nums = {1, 3};
        int target = 2;
        int expected = 1;
        int actual = solution.searchInsert(nums, target);
        assertEquals(expected, actual, "Target 2 should be inserted at index 1");
    }

    @Test
    void testSearchInsert_NegativeNumbers() {
        // Test case 10: Array with negative numbers
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 2;
        int expected = 2;
        int actual = solution.searchInsert(nums, target);
        assertEquals(expected, actual, "Target 2 should be inserted at index 2");

        target = -2;
        expected = 0;
        actual = solution.searchInsert(nums, target);
        assertEquals(expected, actual, "Target -2 should be inserted at index 0");
    }

    @Test
    void testSearchInsert_LargeArray() {
        // Test case 11: Larger array
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 5;
        int expected = 4;
        int actual = solution.searchInsert(nums, target);
        assertEquals(expected, actual, "Target 5 should be found at index 4");

        target = 11;
        expected = 10;
        actual = solution.searchInsert(nums, target);
        assertEquals(expected, actual, "Target 11 should be inserted at index 10");
    }

    @Test
    void testSearchInsert_ConsecutiveNumbers() {
        // Test case 12: Array with consecutive numbers
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 5;
        int expected = 4; // Should find the target
        int actual = solution.searchInsert(nums, target);
        assertEquals(expected, actual, "Target 5 should be found at index 4");

        target = 11;
        expected = 10;
        actual = solution.searchInsert(nums, target);
        assertEquals(expected, actual, "Target 11 should be inserted at index 10");
    }

    @Test
    void testSearchInsertAlternative() {
        // Test alternative solution approach
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        int expected = 1;
        int actual = solution.searchInsertAlternative(nums, target);
        assertEquals(expected, actual, "Alternative solution should return same result");

        target = 5;
        expected = 2;
        actual = solution.searchInsertAlternative(nums, target);
        assertEquals(expected, actual, "Alternative solution should find existing target");
    }

    @Test
    void testSearchInsertRecursive() {
        // Test recursive solution approach
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        int expected = 4;
        int actual = solution.searchInsertRecursive(nums, target);
        assertEquals(expected, actual, "Recursive solution should return same result");

        target = 0;
        expected = 0;
        actual = solution.searchInsertRecursive(nums, target);
        assertEquals(expected, actual, "Recursive solution should handle insert at beginning");
    }

    @Test
    void testSearchInsertLinear() {
        // Test linear search solution (for comparison)
        int[] nums = {1, 3, 5, 6};
        int target = 4;
        int expected = 2;
        int actual = solution.searchInsertLinear(nums, target);
        assertEquals(expected, actual, "Linear solution should return same result");
    }

    @Test
    void testSearchInsert_AllApproachesConsistent() {
        // Test that all solution approaches return consistent results
        int[] nums = {1, 3, 5, 6, 8, 10, 12, 15, 18, 20};
        int[] targets = {0, 1, 2, 5, 7, 10, 13, 16, 20, 25};

        for (int target : targets) {
            int result1 = solution.searchInsert(nums, target);
            int result2 = solution.searchInsertAlternative(nums, target);
            int result3 = solution.searchInsertRecursive(nums, target);
            int result4 = solution.searchInsertLinear(nums, target);

            assertEquals(result1, result2,
                    "Binary search and alternative should match for target " + target);
            assertEquals(result1, result3,
                    "Binary search and recursive should match for target " + target);
            assertEquals(result1, result4,
                    "Binary search and linear should match for target " + target);
        }
    }

    @Test
    void testSearchInsert_EdgeCases() {
        // Test edge cases
        int[] nums = {1, 3, 5, 6};

        // Test with target equal to first element
        assertEquals(0, solution.searchInsert(nums, 1), "Target equal to first element");

        // Test with target equal to last element
        assertEquals(3, solution.searchInsert(nums, 6), "Target equal to last element");

        // Test with target between first two elements
        assertEquals(1, solution.searchInsert(nums, 2), "Target between first two elements");

        // Test with target equal to middle element
        assertEquals(2, solution.searchInsert(nums, 5), "Target equal to middle element");
    }

    @Test
    void testSearchInsert_Performance() {
        // Test with larger array to verify O(log n) performance
        int[] nums = new int[1000];
        for (int i = 0; i < 1000; i++) {
            nums[i] = i * 2; // Even numbers: 0, 2, 4, 6, ...
        }

        // Test various targets
        assertEquals(0, solution.searchInsert(nums, 0), "Target 0 in large array");
        assertEquals(500, solution.searchInsert(nums, 1000), "Target 1000 in large array");
        assertEquals(1000, solution.searchInsert(nums, 2000), "Target 2000 in large array");
        assertEquals(250, solution.searchInsert(nums, 500), "Target 500 in large array");
    }
}
