package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.example.leetcode.AddTwoNumbers.ListNode;

/**
 * Unit tests for AddTwoNumbers solution
 */
public class AddTwoNumbersTest {

    private final AddTwoNumbers solution = new AddTwoNumbers();

    @Test
    @DisplayName("Test case 1: [2,4,3] + [5,6,4] = [7,0,8]")
    public void testAddTwoNumbers_Example1() {
        ListNode l1 = AddTwoNumbers.createList(new int[] {2, 4, 3});
        ListNode l2 = AddTwoNumbers.createList(new int[] {5, 6, 4});
        ListNode result = solution.addTwoNumbers(l1, l2);

        int[] expected = {7, 0, 8};
        assertArrayEquals(expected, AddTwoNumbers.listToArray(result));
    }

    @Test
    @DisplayName("Test case 2: [0] + [0] = [0]")
    public void testAddTwoNumbers_Example2() {
        ListNode l1 = AddTwoNumbers.createList(new int[] {0});
        ListNode l2 = AddTwoNumbers.createList(new int[] {0});
        ListNode result = solution.addTwoNumbers(l1, l2);

        int[] expected = {0};
        assertArrayEquals(expected, AddTwoNumbers.listToArray(result));
    }

    @Test
    @DisplayName("Test case 3: [9,9,9,9,9,9,9] + [9,9,9,9] = [8,9,9,9,0,0,0,1]")
    public void testAddTwoNumbers_Example3() {
        ListNode l1 = AddTwoNumbers.createList(new int[] {9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = AddTwoNumbers.createList(new int[] {9, 9, 9, 9});
        ListNode result = solution.addTwoNumbers(l1, l2);

        int[] expected = {8, 9, 9, 9, 0, 0, 0, 1};
        assertArrayEquals(expected, AddTwoNumbers.listToArray(result));
    }

    @Test
    @DisplayName("Test case 4: Different lengths [9,9] + [1] = [0,0,1]")
    public void testAddTwoNumbers_DifferentLengths() {
        ListNode l1 = AddTwoNumbers.createList(new int[] {9, 9});
        ListNode l2 = AddTwoNumbers.createList(new int[] {1});
        ListNode result = solution.addTwoNumbers(l1, l2);

        int[] expected = {0, 0, 1};
        assertArrayEquals(expected, AddTwoNumbers.listToArray(result));
    }

    @Test
    @DisplayName("Test case 5: Single digits [5] + [5] = [0,1]")
    public void testAddTwoNumbers_SingleDigits() {
        ListNode l1 = AddTwoNumbers.createList(new int[] {5});
        ListNode l2 = AddTwoNumbers.createList(new int[] {5});
        ListNode result = solution.addTwoNumbers(l1, l2);

        int[] expected = {0, 1};
        assertArrayEquals(expected, AddTwoNumbers.listToArray(result));
    }

    @Test
    @DisplayName("Test case 6: No carry [1,2,3] + [4,5,6] = [5,7,9]")
    public void testAddTwoNumbers_NoCarry() {
        ListNode l1 = AddTwoNumbers.createList(new int[] {1, 2, 3});
        ListNode l2 = AddTwoNumbers.createList(new int[] {4, 5, 6});
        ListNode result = solution.addTwoNumbers(l1, l2);

        int[] expected = {5, 7, 9};
        assertArrayEquals(expected, AddTwoNumbers.listToArray(result));
    }

    @Test
    @DisplayName("Test recursive solution with example 1")
    public void testAddTwoNumbersRecursive_Example1() {
        ListNode l1 = AddTwoNumbers.createList(new int[] {2, 4, 3});
        ListNode l2 = AddTwoNumbers.createList(new int[] {5, 6, 4});
        ListNode result = solution.addTwoNumbersRecursive(l1, l2);

        int[] expected = {7, 0, 8};
        assertArrayEquals(expected, AddTwoNumbers.listToArray(result));
    }

    @Test
    @DisplayName("Test recursive solution with carry at end")
    public void testAddTwoNumbersRecursive_CarryAtEnd() {
        ListNode l1 = AddTwoNumbers.createList(new int[] {9, 9});
        ListNode l2 = AddTwoNumbers.createList(new int[] {1});
        ListNode result = solution.addTwoNumbersRecursive(l1, l2);

        int[] expected = {0, 0, 1};
        assertArrayEquals(expected, AddTwoNumbers.listToArray(result));
    }

    @Test
    @DisplayName("Test helper method: createList")
    public void testCreateList() {
        int[] digits = {1, 2, 3};
        ListNode head = AddTwoNumbers.createList(digits);

        assertNotNull(head);
        assertEquals(1, head.val);
        assertEquals(2, head.next.val);
        assertEquals(3, head.next.next.val);
        assertNull(head.next.next.next);
    }

    @Test
    @DisplayName("Test helper method: listToArray")
    public void testListToArray() {
        ListNode head = AddTwoNumbers.createList(new int[] {1, 2, 3});
        int[] result = AddTwoNumbers.listToArray(head);

        int[] expected = {1, 2, 3};
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Test edge case: empty list")
    public void testCreateList_Empty() {
        ListNode head = AddTwoNumbers.createList(new int[] {});
        assertNull(head);
    }

    @Test
    @DisplayName("Test edge case: null array")
    public void testCreateList_Null() {
        ListNode head = AddTwoNumbers.createList(null);
        assertNull(head);
    }
}
