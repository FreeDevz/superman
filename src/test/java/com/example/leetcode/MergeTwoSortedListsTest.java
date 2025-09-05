package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Minimal test suite for Merge Two Sorted Lists Tests only the basic iterative approach to isolate
 * hanging issues
 */
public class MergeTwoSortedListsTest {

    private MergeTwoSortedLists solution;

    @BeforeEach
    void setUp() {
        solution = new MergeTwoSortedLists();
    }

    @Test
    void testMergeTwoLists_Basic() {
        // Test case 1: Classic LeetCode example
        MergeTwoSortedLists.ListNode list1 = MergeTwoSortedLists.createList(new int[] {1, 2, 4});
        MergeTwoSortedLists.ListNode list2 = MergeTwoSortedLists.createList(new int[] {1, 3, 4});
        MergeTwoSortedLists.ListNode result = solution.mergeTwoLists(list1, list2);

        int[] expected = {1, 1, 2, 3, 4, 4};
        assertArrayEquals(expected, MergeTwoSortedLists.listToArray(result));
    }

    @Test
    void testMergeTwoLists_EmptyLists() {
        // Test case 2: One empty list
        MergeTwoSortedLists.ListNode emptyList = MergeTwoSortedLists.createList(new int[] {});
        MergeTwoSortedLists.ListNode singleList = MergeTwoSortedLists.createList(new int[] {42});
        MergeTwoSortedLists.ListNode result = solution.mergeTwoLists(emptyList, singleList);

        assertEquals(42, result.val);
        assertNull(result.next);
    }

    @Test
    void testMergeTwoLists_BothEmpty() {
        // Test case 3: Both empty lists
        MergeTwoSortedLists.ListNode emptyList1 = MergeTwoSortedLists.createList(new int[] {});
        MergeTwoSortedLists.ListNode emptyList2 = MergeTwoSortedLists.createList(new int[] {});
        MergeTwoSortedLists.ListNode result = solution.mergeTwoLists(emptyList1, emptyList2);

        assertNull(result);
    }

    @Test
    void testMergeTwoListsRecursive_Basic() {
        // Test recursive approach
        MergeTwoSortedLists.ListNode list1 = MergeTwoSortedLists.createList(new int[] {1, 2, 4});
        MergeTwoSortedLists.ListNode list2 = MergeTwoSortedLists.createList(new int[] {1, 3, 4});
        MergeTwoSortedLists.ListNode result = solution.mergeTwoListsRecursive(list1, list2);

        int[] expected = {1, 1, 2, 3, 4, 4};
        assertArrayEquals(expected, MergeTwoSortedLists.listToArray(result));
    }

    @Test
    void testMergeTwoListsInPlace_Basic() {
        // Test in-place approach
        MergeTwoSortedLists.ListNode list1 = MergeTwoSortedLists.createList(new int[] {1, 2, 4});
        MergeTwoSortedLists.ListNode list2 = MergeTwoSortedLists.createList(new int[] {1, 3, 4});
        MergeTwoSortedLists.ListNode result = solution.mergeTwoListsInPlace(list1, list2);

        int[] expected = {1, 1, 2, 3, 4, 4};
        assertArrayEquals(expected, MergeTwoSortedLists.listToArray(result));
    }

    @Test
    void testMergeTwoListsPriorityQueue_Basic() {
        // Test priority queue approach
        MergeTwoSortedLists.ListNode list1 = MergeTwoSortedLists.createList(new int[] {1, 2, 4});
        MergeTwoSortedLists.ListNode list2 = MergeTwoSortedLists.createList(new int[] {1, 3, 4});
        MergeTwoSortedLists.ListNode result = solution.mergeTwoListsPriorityQueue(list1, list2);

        int[] expected = {1, 1, 2, 3, 4, 4};
        assertArrayEquals(expected, MergeTwoSortedLists.listToArray(result));
    }

    @Test
    void testMergeTwoListsWithReversal_Basic() {
        // Test two pointers with reversal approach
        MergeTwoSortedLists.ListNode list1 = MergeTwoSortedLists.createList(new int[] {1, 2, 4});
        MergeTwoSortedLists.ListNode list2 = MergeTwoSortedLists.createList(new int[] {1, 3, 4});
        MergeTwoSortedLists.ListNode result = solution.mergeTwoListsWithReversal(list1, list2);

        int[] expected = {1, 1, 2, 3, 4, 4};
        assertArrayEquals(expected, MergeTwoSortedLists.listToArray(result));
    }

}
