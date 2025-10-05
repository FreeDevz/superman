package com.example.leetcode;

/**
 * LeetCode 206: Reverse Linked List
 * 
 * Problem Description: Given the head of a singly linked list, reverse the list, and return the
 * reversed list.
 * 
 * Example 1: Input: head = [1,2,3,4,5] Output: [5,4,3,2,1]
 * 
 * Example 2: Input: head = [1,2] Output: [2,1]
 * 
 * Example 3: Input: head = [] Output: []
 * 
 * Constraints: - The number of nodes in the list is the range [0, 5000] - -5000 <= Node.val <= 5000
 * 
 * Follow-up: A linked list can be reversed either iteratively or recursively. Could you implement
 * both?
 * 
 * Time Complexity Analysis: - Iterative Approach: O(n) time, O(1) space - Recursive Approach: O(n)
 * time, O(n) space (due to recursion stack)
 */
public class ReverseLinkedList {

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

        /**
         * Helper method to create a linked list from an array
         */
        public static ListNode createFromArray(int[] arr) {
            if (arr == null || arr.length == 0) {
                return null;
            }

            ListNode head = new ListNode(arr[0]);
            ListNode current = head;

            for (int i = 1; i < arr.length; i++) {
                current.next = new ListNode(arr[i]);
                current = current.next;
            }

            return head;
        }

        /**
         * Helper method to convert linked list to array for comparison
         */
        public static int[] toArray(ListNode head) {
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

            // Create array and fill it
            int[] result = new int[count];
            current = head;
            int index = 0;
            while (current != null) {
                result[index++] = current.val;
                current = current.next;
            }

            return result;
        }

        /**
         * Helper method to check if two linked lists are equal
         */
        public static boolean areEqual(ListNode l1, ListNode l2) {
            while (l1 != null && l2 != null) {
                if (l1.val != l2.val) {
                    return false;
                }
                l1 = l1.next;
                l2 = l2.next;
            }
            return l1 == null && l2 == null;
        }
    }

    /**
     * Approach 1: Iterative (Three Pointers)
     * 
     * Time Complexity: O(n) where n is the number of nodes Space Complexity: O(1) - only using a
     * constant amount of extra space
     * 
     * Strategy: Use three pointers (prev, curr, next) to reverse the links as we traverse. This is
     * the most efficient approach with constant space complexity.
     */
    public ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next; // Store the next node
            curr.next = prev; // Reverse the current node's pointer
            prev = curr; // Move prev to current node
            curr = next; // Move to the next node
        }

        return prev; // prev becomes the new head of reversed list
    }

    /**
     * Approach 2: Recursive
     * 
     * Time Complexity: O(n) where n is the number of nodes Space Complexity: O(n) due to recursion
     * call stack
     * 
     * Strategy: Recursively reverse the rest of the list, then adjust the current node. The base
     * case is when we reach the end of the list (null or single node).
     */
    public ListNode reverseListRecursive(ListNode head) {
        // Base case: empty list or single node
        if (head == null || head.next == null) {
            return head;
        }

        // Recursively reverse the rest of the list
        ListNode newHead = reverseListRecursive(head.next);

        // Adjust pointers: make the next node point back to current node
        head.next.next = head;
        head.next = null; // Break the original link

        return newHead; // Return the new head (originally the tail)
    }

    /**
     * Approach 3: Recursive with Tail Call Optimization
     * 
     * Time Complexity: O(n) where n is the number of nodes Space Complexity: O(n) due to recursion
     * call stack
     * 
     * Strategy: Uses tail recursion with an accumulator to build the reversed list. This approach
     * processes the list from head to tail, building the reversed list.
     */
    public ListNode reverseListTailRecursive(ListNode head) {
        return reverseListTailRecursiveHelper(head, null);
    }

    private ListNode reverseListTailRecursiveHelper(ListNode current, ListNode reversed) {
        if (current == null) {
            return reversed;
        }

        ListNode next = current.next;
        current.next = reversed;
        return reverseListTailRecursiveHelper(next, current);
    }

    /**
     * Approach 4: Iterative with Stack Simulation
     * 
     * Time Complexity: O(n) where n is the number of nodes Space Complexity: O(n) for the stack
     * 
     * Strategy: Uses a stack-like approach with recursion to reverse the list. This is more
     * intuitive for some people but less space efficient.
     */
    public ListNode reverseListWithStack(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reversed = reverseListWithStack(head.next);
        head.next.next = head;
        head.next = null;

        return reversed;
    }

    /**
     * Utility method to print the linked list for debugging
     */
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    /**
     * Utility method to get the length of the linked list
     */
    public static int getLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    /**
     * Utility method to create a copy of the linked list
     */
    public static ListNode copyList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = new ListNode(head.val);
        ListNode current = newHead;
        ListNode original = head.next;

        while (original != null) {
            current.next = new ListNode(original.val);
            current = current.next;
            original = original.next;
        }

        return newHead;
    }
}
