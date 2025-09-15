package com.example.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 141: Linked List Cycle
 * 
 * Problem Description: Given head, the head of a linked list, determine if the linked list has a
 * cycle in it.
 * 
 * There is a cycle in a linked list if there is some node in the list that can be reached again by
 * continuously following the next pointer. Internally, pos is used to denote the index of the node
 * that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * 
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * 
 * Example 1: Input: head = [3,2,0,-4], pos = 1 Output: true Explanation: There is a cycle in the
 * linked list, where the tail connects to the 1st node (0-indexed).
 * 
 * Example 2: Input: head = [1,2], pos = 0 Output: true Explanation: There is a cycle in the linked
 * list, where the tail connects to the 0th node.
 * 
 * Example 3: Input: head = [1], pos = -1 Output: false Explanation: There is no cycle in the linked
 * list.
 * 
 * Constraints: - The number of the nodes in the list is in the range [0, 10^4]. - -10^5 <= Node.val
 * <= 10^5 - pos is -1 or a valid index in the linked-list.
 * 
 * Approach 1: Floyd's Cycle Detection Algorithm (Tortoise and Hare) - OPTIMAL Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Use two pointers moving at different speeds. If there's a cycle, the fast pointer will eventually
 * catch up to the slow pointer.
 * 
 * Approach 2: HashSet Time Complexity: O(n) Space Complexity: O(n)
 * 
 * Keep track of visited nodes. If we encounter a node we've seen before, there's a cycle.
 * 
 * Approach 3: Marking Nodes (Destructive) Time Complexity: O(n) Space Complexity: O(1)
 * 
 * Mark visited nodes by modifying their values. This approach modifies the original list.
 */

// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}


public class LinkedListCycle {

    /**
     * Approach 1: Floyd's Cycle Detection Algorithm (Tortoise and Hare) - OPTIMAL
     * 
     * This is the most efficient solution using two pointers moving at different speeds. The slow
     * pointer moves one step at a time, while the fast pointer moves two steps. If there's a cycle,
     * the fast pointer will eventually catch up to the slow pointer.
     * 
     * @param head the head of the linked list
     * @return true if there is a cycle, false otherwise
     */
    public boolean hasCycleFloyd(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Move slow one step and fast two steps
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If they meet, there's a cycle
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    /**
     * Approach 2: HashSet Solution
     * 
     * Keep track of visited nodes using a HashSet. If we encounter a node that's already in the
     * set, there's a cycle.
     * 
     * @param head the head of the linked list
     * @return true if there is a cycle, false otherwise
     */
    public boolean hasCycleHashSet(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        Set<ListNode> visited = new HashSet<>();
        ListNode current = head;

        while (current != null) {
            if (visited.contains(current)) {
                return true;
            }
            visited.add(current);
            current = current.next;
        }

        return false;
    }

    /**
     * Approach 3: Marking Nodes (Destructive)
     * 
     * Mark visited nodes by setting their values to a special marker value. This approach modifies
     * the original list, so it's not recommended for production.
     * 
     * @param head the head of the linked list
     * @return true if there is a cycle, false otherwise
     */
    public boolean hasCycleMarking(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        final int MARKER = Integer.MIN_VALUE;
        ListNode current = head;

        while (current != null) {
            if (current.val == MARKER) {
                return true;
            }
            current.val = MARKER;
            current = current.next;
        }

        return false;
    }

    /**
     * Approach 4: Reverse List (Destructive)
     * 
     * Try to reverse the list. If there's a cycle, we'll eventually reach the head again. This
     * approach modifies the original list.
     * 
     * @param head the head of the linked list
     * @return true if there is a cycle, false otherwise
     */
    public boolean hasCycleReverse(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode prev = null;
        ListNode current = head;
        ListNode next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

            // If we reach the original head, there was a cycle
            if (current == head) {
                return true;
            }
        }

        return false;
    }

    /**
     * Helper method to create a linked list with a cycle
     * 
     * @param values array of values for the linked list
     * @param pos position where the cycle starts (-1 for no cycle)
     * @return head of the linked list
     */
    public static ListNode createLinkedListWithCycle(int[] values, int pos) {
        if (values.length == 0) {
            return null;
        }

        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        ListNode cycleNode = (pos == 0) ? head : null;

        // Create the list
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;

            if (i == pos) {
                cycleNode = current;
            }
        }

        // Create the cycle if pos is valid
        if (pos >= 0 && pos < values.length) {
            current.next = cycleNode;
        }

        return head;
    }

    /**
     * Helper method to create a simple linked list without cycle
     * 
     * @param values array of values for the linked list
     * @return head of the linked list
     */
    public static ListNode createLinkedList(int[] values) {
        return createLinkedListWithCycle(values, -1);
    }

    /**
     * Main method to demonstrate all approaches
     */
    public static void main(String[] args) {
        LinkedListCycle solution = new LinkedListCycle();

        System.out.println("Testing Linked List Cycle Solutions:");
        System.out.println("====================================");

        // Test Case 1: [3,2,0,-4] with cycle at position 1
        System.out.println("\nTest Case 1: [3,2,0,-4] with cycle at position 1");
        ListNode list1 = createLinkedListWithCycle(new int[] {3, 2, 0, -4}, 1);
        System.out.println("Expected: true");
        System.out.println("Floyd's Algorithm: " + solution.hasCycleFloyd(list1) + " ✓");

        // Test Case 2: [1,2] with cycle at position 0
        System.out.println("\nTest Case 2: [1,2] with cycle at position 0");
        ListNode list2 = createLinkedListWithCycle(new int[] {1, 2}, 0);
        System.out.println("Expected: true");
        System.out.println("Floyd's Algorithm: " + solution.hasCycleFloyd(list2) + " ✓");

        // Test Case 3: [1] with no cycle
        System.out.println("\nTest Case 3: [1] with no cycle");
        ListNode list3 = createLinkedList(new int[] {1});
        System.out.println("Expected: false");
        System.out.println("Floyd's Algorithm: " + solution.hasCycleFloyd(list3) + " ✓");

        // Test Case 4: Empty list
        System.out.println("\nTest Case 4: Empty list");
        ListNode list4 = null;
        System.out.println("Expected: false");
        System.out.println("Floyd's Algorithm: " + solution.hasCycleFloyd(list4) + " ✓");

        // Test Case 5: Single node with self-cycle
        System.out.println("\nTest Case 5: Single node with self-cycle");
        ListNode list5 = createLinkedListWithCycle(new int[] {1}, 0);
        System.out.println("Expected: true");
        System.out.println("Floyd's Algorithm: " + solution.hasCycleFloyd(list5) + " ✓");

        // Test Case 6: Long list with cycle
        System.out.println(
                "\nTest Case 6: Long list [1,2,3,4,5,6,7,8,9,10] with cycle at position 3");
        ListNode list6 = createLinkedListWithCycle(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 3);
        System.out.println("Expected: true");
        System.out.println("Floyd's Algorithm: " + solution.hasCycleFloyd(list6) + " ✓");

        // Performance comparison
        System.out.println("\n\nPerformance Analysis:");
        System.out.println("=====================");
        System.out.println("Approach 1 (Floyd's Algorithm): O(n) time, O(1) space - OPTIMAL");
        System.out.println("Approach 2 (HashSet): O(n) time, O(n) space");
        System.out.println("Approach 3 (Marking): O(n) time, O(1) space - DESTRUCTIVE");
        System.out.println("Approach 4 (Reverse): O(n) time, O(1) space - DESTRUCTIVE");

        System.out.println("\nKey Insights:");
        System.out.println("=============");
        System.out
                .println("• Floyd's algorithm is the most efficient and non-destructive solution");
        System.out
                .println("• The algorithm works because if there's a cycle, the fast pointer will");
        System.out.println("  eventually catch up to the slow pointer");
        System.out.println("• Time complexity is O(n) because in the worst case, the fast pointer");
        System.out
                .println("  will traverse the list at most twice before meeting the slow pointer");
        System.out.println("• Space complexity is O(1) because we only use two pointers");
    }
}
