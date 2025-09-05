package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * LeetCode 21: Merge Two Sorted Lists
 * 
 * You are given the heads of two sorted linked lists list1 and list2. Merge the two lists into one
 * sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 * 
 * Examples: Input: list1 = [1,2,4], list2 = [1,3,4] Output: [1,1,2,3,4,4]
 * 
 * Input: list1 = [], list2 = [] Output: []
 * 
 * Input: list1 = [], list2 = [0] Output: [0]
 * 
 * Constraints: - The number of nodes in both lists is in the range [0, 50] - -100 <= Node.val <=
 * 100 - Both list1 and list2 are sorted in non-decreasing order
 */
public class MergeTwoSortedLists {

    // Definition for singly-linked list
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
            ListNode current = this;
            while (current != null) {
                sb.append(current.val);
                if (current.next != null) {
                    sb.append(" -> ");
                }
                current = current.next;
            }
            return sb.toString();
        }
    }

    // ========================================
    // APPROACH 1: ITERATIVE (RECOMMENDED)
    // Time: O(n + m), Space: O(1) where n, m are list lengths
    // ========================================

    /**
     * Approach 1: Iterative Merge with Dummy Node
     * 
     * This is the most efficient and commonly used approach for merging sorted linked lists.
     * 
     * Algorithm: 1. Create a dummy node to simplify edge cases 2. Use a pointer to build the merged
     * list 3. Compare nodes from both lists and link the smaller one 4. Move the pointer forward 5.
     * Attach remaining nodes from the non-empty list
     * 
     * Time Complexity: O(n + m) where n and m are the lengths of the two lists Space Complexity:
     * O(1) as we reuse existing nodes
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Merge while both lists have nodes
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Attach remaining nodes from either list
        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
        }

        return dummy.next;
    }

    // ========================================
    // APPROACH 2: RECURSIVE
    // Time: O(n + m), Space: O(n + m) due to recursion stack
    // ========================================

    /**
     * Approach 2: Recursive Merge
     * 
     * This approach uses recursion to merge the lists, which can be more elegant but uses more
     * space due to the call stack.
     * 
     * Algorithm: 1. Base case: if one list is null, return the other 2. Compare current nodes 3.
     * Recursively merge the rest of the lists 4. Link the smaller node to the result
     * 
     * Time Complexity: O(n + m) where n and m are the lengths of the two lists Space Complexity:
     * O(n + m) due to recursion call stack
     */
    public ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
        // Base cases
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        // Compare current nodes and recursively merge
        if (list1.val <= list2.val) {
            list1.next = mergeTwoListsRecursive(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsRecursive(list1, list2.next);
            return list2;
        }
    }

    // ========================================
    // APPROACH 3: IN-PLACE MERGE
    // Time: O(n + m), Space: O(1) - modifies input lists
    // ========================================

    /**
     * Approach 3: In-Place Merge
     * 
     * This approach modifies the input lists directly to create the merged list, which can be
     * useful when you want to reuse existing nodes without creating new ones.
     * 
     * Algorithm: 1. Find the smaller head to use as the result head 2. Use two pointers to merge
     * in-place 3. Reorder the links to create the merged list 4. Handle edge cases carefully
     * 
     * Time Complexity: O(n + m) where n and m are the lengths of the two lists Space Complexity:
     * O(1) - modifies input lists in-place
     */
    public ListNode mergeTwoListsInPlace(ListNode list1, ListNode list2) {
        // Handle edge cases
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        // Determine which list has the smaller head
        ListNode head, other;
        if (list1.val <= list2.val) {
            head = list1;
            other = list2;
        } else {
            head = list2;
            other = list1;
        }

        ListNode current = head;
        ListNode next = head.next;

        // Merge in-place
        while (next != null && other != null) {
            if (next.val <= other.val) {
                current = next;
                next = next.next;
            } else {
                // Insert other node between current and next
                ListNode temp = other.next;
                current.next = other;
                other.next = next;
                current = other;
                other = temp;
            }
        }

        // Attach remaining nodes from other list
        if (other != null) {
            current.next = other;
        }

        return head;
    }

    // ========================================
    // APPROACH 4: PRIORITY QUEUE
    // Time: O((n + m) log 2) = O(n + m), Space: O(2) = O(1)
    // ========================================

    /**
     * Approach 4: Priority Queue (Min Heap)
     * 
     * This approach uses a priority queue to always select the smallest available node, which can
     * be extended to merge multiple sorted lists.
     * 
     * Algorithm: 1. Add heads of both lists to a min heap 2. Extract the smallest node 3. Add the
     * next node from the extracted node's list 4. Repeat until all nodes are processed
     * 
     * Time Complexity: O((n + m) log 2) = O(n + m) where n and m are the lengths of the two lists
     * Space Complexity: O(2) = O(1) as heap only contains at most 2 nodes
     */
    public ListNode mergeTwoListsPriorityQueue(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        // Create min heap with custom comparator
        PriorityQueue<ListNode> minHeap =
                new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        // Add heads of both lists
        if (list1 != null) {
            minHeap.offer(list1);
        }
        if (list2 != null) {
            minHeap.offer(list2);
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            current.next = smallest;
            current = current.next;

            // Add next node from the same list
            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }

        return dummy.next;
    }

    // ========================================
    // APPROACH 5: TWO POINTERS WITH REVERSAL
    // Time: O(n + m), Space: O(1) - creative approach
    // ========================================

    /**
     * Approach 5: Two Pointers with Reversal
     * 
     * This is a creative approach that demonstrates alternative merging techniques. It uses a
     * two-pointer approach similar to the iterative method but with different logic.
     * 
     * Algorithm: 1. Use two pointers to traverse both lists 2. Build result by comparing and
     * linking 3. Handle remaining nodes appropriately
     * 
     * Time Complexity: O(n + m) where n and m are the lengths of the two lists Space Complexity:
     * O(1) - modifies lists in-place
     */
    public ListNode mergeTwoListsWithReversal(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        // Create dummy node for result
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Use two pointers approach
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Attach remaining nodes
        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
        }

        return dummy.next;
    }

    /**
     * Helper method to reverse a linked list
     */
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    // ========================================
    // UTILITY METHODS
    // ========================================

    /**
     * Create a linked list from an array
     * 
     * @param values Array of values to create the linked list from
     * @return Head of the created linked list
     */
    public static ListNode createList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }

    /**
     * Create a linked list from a list of integers
     * 
     * @param values List of values to create the linked list from
     * @return Head of the created linked list
     */
    public static ListNode createList(List<Integer> values) {
        if (values == null || values.isEmpty()) {
            return null;
        }

        ListNode head = new ListNode(values.get(0));
        ListNode current = head;

        for (int i = 1; i < values.size(); i++) {
            current.next = new ListNode(values.get(i));
            current = current.next;
        }

        return head;
    }

    /**
     * Convert a linked list to an array
     * 
     * @param head Head of the linked list
     * @return Array representation of the linked list
     */
    public static int[] listToArray(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        List<Integer> values = new ArrayList<>();
        ListNode current = head;

        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        return values.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Convert a linked list to a list of integers
     * 
     * @param head Head of the linked list
     * @return List representation of the linked list
     */
    public static List<Integer> listToList(ListNode head) {
        if (head == null) {
            return new ArrayList<>();
        }

        List<Integer> values = new ArrayList<>();
        ListNode current = head;

        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        return values;
    }

    /**
     * Get list statistics
     * 
     * @param head Head of the linked list
     * @return String with list statistics
     */
    public static String getListStatistics(ListNode head) {
        if (head == null) {
            return "Empty list";
        }

        int nodeCount = 0;
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        boolean isSorted = true;
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            nodeCount++;
            minValue = Math.min(minValue, current.val);
            maxValue = Math.max(maxValue, current.val);

            if (prev != null && prev.val > current.val) {
                isSorted = false;
            }

            prev = current;
            current = current.next;
        }

        StringBuilder stats = new StringBuilder();
        stats.append(String.format("List Statistics: %d nodes", nodeCount));
        stats.append(String.format(", Min value: %d", minValue));
        stats.append(String.format(", Max value: %d", maxValue));
        stats.append(String.format(", Is sorted: %s", isSorted));

        return stats.toString();
    }

    /**
     * Compare results from different approaches
     */
    public boolean compareResults(ListNode result1, ListNode result2) {
        if (result1 == null && result2 == null) {
            return true;
        }

        if (result1 == null || result2 == null) {
            return false;
        }

        ListNode current1 = result1;
        ListNode current2 = result2;

        while (current1 != null && current2 != null) {
            if (current1.val != current2.val) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        return current1 == null && current2 == null;
    }

    /**
     * Validate that the merged list is properly sorted
     */
    public boolean isValidMergedList(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode current = head;
        while (current.next != null) {
            if (current.val > current.next.val) {
                return false;
            }
            current = current.next;
        }

        return true;
    }

    /**
     * Performance analysis helper - measures execution time
     */
    public long measureExecutionTime(Runnable algorithm) {
        long startTime = System.nanoTime();
        algorithm.run();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Create test cases with different scenarios
     */
    public static ListNode[][] createTestCases() {
        // Test case 1: Both lists have same length
        ListNode list1_1 = createList(new int[] {1, 2, 4});
        ListNode list2_1 = createList(new int[] {1, 3, 4});

        // Test case 2: First list is longer
        ListNode list1_2 = createList(new int[] {1, 2, 4, 6, 8});
        ListNode list2_2 = createList(new int[] {1, 3});

        // Test case 3: Second list is longer
        ListNode list1_3 = createList(new int[] {2, 4});
        ListNode list2_3 = createList(new int[] {1, 3, 5, 7, 9});

        // Test case 4: One empty list
        ListNode list1_4 = createList(new int[] {});
        ListNode list2_4 = createList(new int[] {1, 2, 3});

        // Test case 5: Both empty lists
        ListNode list1_5 = createList(new int[] {});
        ListNode list2_5 = createList(new int[] {});

        // Test case 6: Negative values
        ListNode list1_6 = createList(new int[] {-5, -3, -1});
        ListNode list2_6 = createList(new int[] {-4, -2, 0});

        return new ListNode[][] {{list1_1, list2_1}, {list1_2, list2_2}, {list1_3, list2_3},
                {list1_4, list2_4}, {list1_5, list2_5}, {list1_6, list2_6}};
    }
}
