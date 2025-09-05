package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for RemoveDuplicatesFromSortedArray
 * 
 * This class contains comprehensive test cases for all approaches of the Remove Duplicates from
 * Sorted Array problem.
 */
public class RemoveDuplicatesFromSortedArrayTest {

    private RemoveDuplicatesFromSortedArray solution;

    @BeforeEach
    void setUp() {
        solution = new RemoveDuplicatesFromSortedArray();
    }

    // Test cases for Approach 1: Two Pointers (Optimal)

    @Test
    void testRemoveDuplicates_BasicCase() {
        int[] nums = {1, 1, 2};
        int result = solution.removeDuplicates(nums);

        assertEquals(2, result);
        assertEquals(1, nums[0]);
        assertEquals(2, nums[1]);
    }

    @Test
    void testRemoveDuplicates_ComplexCase() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int result = solution.removeDuplicates(nums);

        assertEquals(5, result);
        assertEquals(0, nums[0]);
        assertEquals(1, nums[1]);
        assertEquals(2, nums[2]);
        assertEquals(3, nums[3]);
        assertEquals(4, nums[4]);
    }

    @Test
    void testRemoveDuplicates_SingleElement() {
        int[] nums = {1};
        int result = solution.removeDuplicates(nums);

        assertEquals(1, result);
        assertEquals(1, nums[0]);
    }

    @Test
    void testRemoveDuplicates_AllSameElements() {
        int[] nums = {1, 1, 1, 1};
        int result = solution.removeDuplicates(nums);

        assertEquals(1, result);
        assertEquals(1, nums[0]);
    }

    @Test
    void testRemoveDuplicates_NoDuplicates() {
        int[] nums = {1, 2, 3, 4, 5};
        int result = solution.removeDuplicates(nums);

        assertEquals(5, result);
        assertEquals(1, nums[0]);
        assertEquals(2, nums[1]);
        assertEquals(3, nums[2]);
        assertEquals(4, nums[3]);
        assertEquals(5, nums[4]);
    }

    @Test
    void testRemoveDuplicates_EmptyArray() {
        int[] nums = {};
        int result = solution.removeDuplicates(nums);

        assertEquals(0, result);
    }

    @Test
    void testRemoveDuplicates_NullArray() {
        int[] nums = null;
        int result = solution.removeDuplicates(nums);

        assertEquals(0, result);
    }

    @Test
    void testRemoveDuplicates_TwoElements() {
        int[] nums = {1, 2};
        int result = solution.removeDuplicates(nums);

        assertEquals(2, result);
        assertEquals(1, nums[0]);
        assertEquals(2, nums[1]);
    }

    @Test
    void testRemoveDuplicates_TwoSameElements() {
        int[] nums = {1, 1};
        int result = solution.removeDuplicates(nums);

        assertEquals(1, result);
        assertEquals(1, nums[0]);
    }

    @Test
    void testRemoveDuplicates_NegativeNumbers() {
        int[] nums = {-1, -1, 0, 0, 1, 1};
        int result = solution.removeDuplicates(nums);

        assertEquals(3, result);
        assertEquals(-1, nums[0]);
        assertEquals(0, nums[1]);
        assertEquals(1, nums[2]);
    }

    @Test
    void testRemoveDuplicates_LargeArray() {
        int[] nums = new int[1000];
        for (int i = 0; i < 1000; i++) {
            nums[i] = i / 2; // Creates duplicates
        }

        int result = solution.removeDuplicates(nums);

        assertEquals(500, result);
        for (int i = 0; i < 500; i++) {
            assertEquals(i, nums[i]);
        }
    }

    // Test cases for Approach 2: Using Set

    @Test
    void testRemoveDuplicatesWithSet_BasicCase() {
        int[] nums = {1, 1, 2};
        int result = solution.removeDuplicatesWithSet(nums);

        assertEquals(2, result);
        assertEquals(1, nums[0]);
        assertEquals(2, nums[1]);
    }

    @Test
    void testRemoveDuplicatesWithSet_ComplexCase() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int result = solution.removeDuplicatesWithSet(nums);

        assertEquals(5, result);
        assertEquals(0, nums[0]);
        assertEquals(1, nums[1]);
        assertEquals(2, nums[2]);
        assertEquals(3, nums[3]);
        assertEquals(4, nums[4]);
    }

    @Test
    void testRemoveDuplicatesWithSet_EmptyArray() {
        int[] nums = {};
        int result = solution.removeDuplicatesWithSet(nums);

        assertEquals(0, result);
    }

    @Test
    void testRemoveDuplicatesWithSet_NullArray() {
        int[] nums = null;
        int result = solution.removeDuplicatesWithSet(nums);

        assertEquals(0, result);
    }

    // Test cases for Approach 3: Brute Force

    @Test
    void testRemoveDuplicatesBruteForce_BasicCase() {
        int[] nums = {1, 1, 2};
        int result = solution.removeDuplicatesBruteForce(nums);

        assertEquals(2, result);
        assertEquals(1, nums[0]);
        assertEquals(2, nums[1]);
    }

    @Test
    void testRemoveDuplicatesBruteForce_ComplexCase() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int result = solution.removeDuplicatesBruteForce(nums);

        assertEquals(5, result);
        assertEquals(0, nums[0]);
        assertEquals(1, nums[1]);
        assertEquals(2, nums[2]);
        assertEquals(3, nums[3]);
        assertEquals(4, nums[4]);
    }

    @Test
    void testRemoveDuplicatesBruteForce_EmptyArray() {
        int[] nums = {};
        int result = solution.removeDuplicatesBruteForce(nums);

        assertEquals(0, result);
    }

    @Test
    void testRemoveDuplicatesBruteForce_NullArray() {
        int[] nums = null;
        int result = solution.removeDuplicatesBruteForce(nums);

        assertEquals(0, result);
    }

    // Test cases for Approach 4: Optimized Two Pointers

    @Test
    void testRemoveDuplicatesOptimized_BasicCase() {
        int[] nums = {1, 1, 2};
        int result = solution.removeDuplicatesOptimized(nums);

        assertEquals(2, result);
        assertEquals(1, nums[0]);
        assertEquals(2, nums[1]);
    }

    @Test
    void testRemoveDuplicatesOptimized_ComplexCase() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int result = solution.removeDuplicatesOptimized(nums);

        assertEquals(5, result);
        assertEquals(0, nums[0]);
        assertEquals(1, nums[1]);
        assertEquals(2, nums[2]);
        assertEquals(3, nums[3]);
        assertEquals(4, nums[4]);
    }

    @Test
    void testRemoveDuplicatesOptimized_SingleElement() {
        int[] nums = {1};
        int result = solution.removeDuplicatesOptimized(nums);

        assertEquals(1, result);
        assertEquals(1, nums[0]);
    }

    @Test
    void testRemoveDuplicatesOptimized_EmptyArray() {
        int[] nums = {};
        int result = solution.removeDuplicatesOptimized(nums);

        assertEquals(0, result);
    }

    @Test
    void testRemoveDuplicatesOptimized_NullArray() {
        int[] nums = null;
        int result = solution.removeDuplicatesOptimized(nums);

        assertEquals(0, result);
    }

    // Performance and Edge Case Tests

    @Test
    void testAllApproaches_Consistency() {
        int[] testCases = {1, 1, 2, 2, 3, 3, 3, 4, 5, 5};

        int[] nums1 = testCases.clone();
        int[] nums2 = testCases.clone();
        int[] nums3 = testCases.clone();
        int[] nums4 = testCases.clone();

        int result1 = solution.removeDuplicates(nums1);
        int result2 = solution.removeDuplicatesWithSet(nums2);
        int result3 = solution.removeDuplicatesBruteForce(nums3);
        int result4 = solution.removeDuplicatesOptimized(nums4);

        // All approaches should return the same result
        assertEquals(result1, result2);
        assertEquals(result2, result3);
        assertEquals(result3, result4);

        // All approaches should produce the same array
        for (int i = 0; i < result1; i++) {
            assertEquals(nums1[i], nums2[i]);
            assertEquals(nums2[i], nums3[i]);
            assertEquals(nums3[i], nums4[i]);
        }
    }

    @Test
    void testBoundaryValues() {
        // Test with minimum constraint values
        int[] nums1 = {-100, -100, 100};
        int result1 = solution.removeDuplicates(nums1);
        assertEquals(2, result1);
        assertEquals(-100, nums1[0]);
        assertEquals(100, nums1[1]);

        // Test with maximum constraint values
        int[] nums2 = new int[30000];
        for (int i = 0; i < 30000; i++) {
            nums2[i] = i / 2; // Creates duplicates
        }
        int result2 = solution.removeDuplicates(nums2);
        assertEquals(15000, result2);
    }

    @Test
    void testPrintArray() {
        int[] nums = {1, 2, 3};
        // This test just ensures the method doesn't throw an exception
        assertDoesNotThrow(() -> solution.printArray(nums, 3));
    }
}
