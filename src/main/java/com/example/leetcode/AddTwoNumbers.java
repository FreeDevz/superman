package com.example.leetcode;

/**
 * LeetCode Problem 2: Add Two Numbers
 * 
 * Problem Description: You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order, and each of their nodes contains a single
 * digit. Add the two numbers and return the sum as a linked list.
 * 
 * Example: Input: l1 = [2,4,3], l2 = [5,6,4] Output: [7,0,8] Explanation: 342 + 465 = 807
 * 
 * Constraints: - The number of nodes in each linked list is in the range [1, 100]. - 0 <= Node.val
 * <= 9 - It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class AddTwoNumbers {

    /**
     * Definition for singly-linked list node
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            ListNode current = this;
            while (current != null) {
                sb.append(current.val);
                if (current.next != null) {
                    sb.append(",");
                }
                current = current.next;
            }
            sb.append("]");
            return sb.toString();
        }
    }

    /**
     * Solution: Iterative approach with carry handling
     * 
     * Time Complexity: O(max(m, n)) where m and n are the lengths of the two lists Space
     * Complexity: O(max(m, n)) for the result list
     * 
     * Algorithm: 1. Create a dummy head node to simplify list construction 2. Use a carry variable
     * to handle sums >= 10 3. Iterate through both lists simultaneously 4. For each position, add
     * the digits and carry 5. Create new nodes with the sum % 10 6. Continue until both lists are
     * exhausted and no carry remains
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // Dummy head to simplify construction
        ListNode current = dummy; // Pointer to build the result list
        int carry = 0; // Carry for sums >= 10

        // Continue while there are nodes to process or carry exists
        while (l1 != null || l2 != null || carry != 0) {
            // Get values from current nodes (0 if node is null)
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            // Calculate sum and new carry
            int sum = val1 + val2 + carry;
            carry = sum / 10; // New carry (1 if sum >= 10, 0 otherwise)

            // Create new node with the digit (sum % 10)
            current.next = new ListNode(sum % 10);
            current = current.next;

            // Move to next nodes if they exist
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        return dummy.next; // Return the actual head (skip dummy)
    }

    /**
     * Alternative recursive solution
     */
    public ListNode addTwoNumbersRecursive(ListNode l1, ListNode l2) {
        return addTwoNumbersRecursive(l1, l2, 0);
    }

    private ListNode addTwoNumbersRecursive(ListNode l1, ListNode l2, int carry) {
        // Base case: if both lists are null and no carry, return null
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        // Calculate sum
        int sum = carry;
        if (l1 != null) {
            sum += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            sum += l2.val;
            l2 = l2.next;
        }

        // Create result node and recursively build the rest
        ListNode result = new ListNode(sum % 10);
        result.next = addTwoNumbersRecursive(l1, l2, sum / 10);

        return result;
    }

    /**
     * Helper method to create a linked list from an array
     */
    public static ListNode createList(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int digit : digits) {
            current.next = new ListNode(digit);
            current = current.next;
        }

        return dummy.next;
    }

    /**
     * Helper method to convert linked list to array for testing
     */
    public static int[] listToArray(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        // Count nodes
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }

        // Create array
        int[] result = new int[count];
        current = head;
        for (int i = 0; i < count; i++) {
            result[i] = current.val;
            current = current.next;
        }

        return result;
    }

    /**
     * Test the solution with example cases
     */
    public static void main(String[] args) {
        AddTwoNumbers solution = new AddTwoNumbers();

        // Test Case 1: [2,4,3] + [5,6,4] = [7,0,8] (342 + 465 = 807)
        System.out.println("Test Case 1:");
        ListNode l1 = createList(new int[] {2, 4, 3});
        ListNode l2 = createList(new int[] {5, 6, 4});
        ListNode result1 = solution.addTwoNumbers(l1, l2);
        System.out.println("Input: l1 = " + l1 + ", l2 = " + l2);
        System.out.println("Output: " + result1);
        System.out.println("Expected: [7,0,8]");
        System.out.println();

        // Test Case 2: [0] + [0] = [0]
        System.out.println("Test Case 2:");
        ListNode l3 = createList(new int[] {0});
        ListNode l4 = createList(new int[] {0});
        ListNode result2 = solution.addTwoNumbers(l3, l4);
        System.out.println("Input: l1 = " + l3 + ", l2 = " + l4);
        System.out.println("Output: " + result2);
        System.out.println("Expected: [0]");
        System.out.println();

        // Test Case 3: [9,9,9,9,9,9,9] + [9,9,9,9] = [8,9,9,9,0,0,0,1]
        System.out.println("Test Case 3:");
        ListNode l5 = createList(new int[] {9, 9, 9, 9, 9, 9, 9});
        ListNode l6 = createList(new int[] {9, 9, 9, 9});
        ListNode result3 = solution.addTwoNumbers(l5, l6);
        System.out.println("Input: l1 = " + l5 + ", l2 = " + l6);
        System.out.println("Output: " + result3);
        System.out.println("Expected: [8,9,9,9,0,0,0,1]");
        System.out.println();

        // Test Case 4: Different lengths [9,9] + [1] = [0,0,1]
        System.out.println("Test Case 4:");
        ListNode l7 = createList(new int[] {9, 9});
        ListNode l8 = createList(new int[] {1});
        ListNode result4 = solution.addTwoNumbers(l7, l8);
        System.out.println("Input: l1 = " + l7 + ", l2 = " + l8);
        System.out.println("Output: " + result4);
        System.out.println("Expected: [0,0,1]");
        System.out.println();

        // Test recursive solution
        System.out.println("Testing Recursive Solution:");
        ListNode result5 = solution.addTwoNumbersRecursive(createList(new int[] {2, 4, 3}),
                createList(new int[] {5, 6, 4}));
        System.out.println("Recursive result: " + result5);
        System.out.println("Expected: [7,0,8]");
    }
}
