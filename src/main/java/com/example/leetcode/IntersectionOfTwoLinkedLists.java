package com.example.leetcode;

/**
 * LeetCode 160: Intersection of Two Linked Lists
 * 
 * Problem Statement: Given the heads of two singly linked lists headA and headB, return the node at
 * which the two lists intersect. If the two linked lists have no intersection, return null.
 * 
 * Example 1: Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB
 * = 3 Output: Intersected at '8' Explanation: The intersected node's value is 8 (note that this
 * must not be 0 if you want to return the node). From the head of A, it reads as [4,1,8,4,5]. From
 * the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A;
 * There are 3 nodes before the intersected node in B.
 * 
 * Example 2: Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Intersected at '2' Explanation: The intersected node's value is 2 (note that this must
 * not be 0 if you want to return the node). From the head of A, it reads as [1,9,1,2,4]. From the
 * head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1
 * nodes before the intersected node in B.
 * 
 * Example 3: Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2 Output:
 * No intersection Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it
 * reads as [1,5]. Since the two lists do not intersect, intersectVal is 0, while skipA and skipB
 * are arbitrary values.
 * 
 * Constraints: - The number of nodes of listA is in the m. - The number of nodes of listB is in the
 * n. - 1 <= m, n <= 3 * 10^4 - 1 <= Node.val <= 10^5 - 0 <= skipA < m - 0 <= skipB < n -
 * intersectVal is 0 if listA and listB do not intersect. - intersectVal == listA[skipA] ==
 * listB[skipB] if listA and listB intersect.
 * 
 * Follow up: Could you write a solution that runs in O(m + n) time and use only O(1) memory?
 * 
 * @author LeetCode
 * @version 1.0
 */
public class IntersectionOfTwoLinkedLists {

    /**
     * Definition for singly-linked list node.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" + "val=" + val + '}';
        }
    }

    /**
     * Approach 1: Two-Pointer Technique (Optimal)
     * 
     * Key Insight: Use two pointers that traverse both lists. When a pointer reaches the end of its
     * list, redirect it to the head of the other list. Both pointers will traverse the same total
     * distance (m + n), so they will meet at the intersection point or both reach null.
     * 
     * Time Complexity: O(m + n) Space Complexity: O(1)
     * 
     * @param headA the head of the first linked list
     * @param headB the head of the second linked list
     * @return the intersection node, or null if no intersection
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pointerA = headA;
        ListNode pointerB = headB;

        // Traverse until both pointers meet or both reach null
        while (pointerA != pointerB) {
            // Move to next node, or to head of other list if at end
            pointerA = (pointerA == null) ? headB : pointerA.next;
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }

        return pointerA; // This will be the intersection node or null
    }

    /**
     * Approach 2: Length Difference Method
     * 
     * Key Insight: Calculate the lengths of both lists, then move the longer list's pointer ahead
     * by the difference. Then traverse both lists simultaneously until they meet.
     * 
     * Time Complexity: O(m + n) Space Complexity: O(1)
     * 
     * @param headA the head of the first linked list
     * @param headB the head of the second linked list
     * @return the intersection node, or null if no intersection
     */
    public ListNode getIntersectionNodeLengthDiff(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        // Calculate lengths of both lists
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        // Move the longer list's pointer ahead by the difference
        ListNode currA = headA;
        ListNode currB = headB;

        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                currA = currA.next;
            }
        } else if (lenB > lenA) {
            for (int i = 0; i < lenB - lenA; i++) {
                currB = currB.next;
            }
        }

        // Traverse both lists simultaneously
        while (currA != null && currB != null) {
            if (currA == currB) {
                return currA; // Found intersection
            }
            currA = currA.next;
            currB = currB.next;
        }

        return null; // No intersection
    }

    /**
     * Approach 3: HashSet Method
     * 
     * Key Insight: Traverse the first list and store all nodes in a HashSet. Then traverse the
     * second list and check if any node is already in the HashSet.
     * 
     * Time Complexity: O(m + n) Space Complexity: O(m) or O(n)
     * 
     * @param headA the head of the first linked list
     * @param headB the head of the second linked list
     * @return the intersection node, or null if no intersection
     */
    public ListNode getIntersectionNodeHashSet(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        java.util.Set<ListNode> visited = new java.util.HashSet<>();

        // Traverse first list and add all nodes to HashSet
        ListNode curr = headA;
        while (curr != null) {
            visited.add(curr);
            curr = curr.next;
        }

        // Traverse second list and check for intersection
        curr = headB;
        while (curr != null) {
            if (visited.contains(curr)) {
                return curr; // Found intersection
            }
            curr = curr.next;
        }

        return null; // No intersection
    }

    /**
     * Approach 4: Brute Force Method
     * 
     * Key Insight: For each node in listA, check if it exists in listB by traversing the entire
     * listB.
     * 
     * Time Complexity: O(m * n) Space Complexity: O(1)
     * 
     * @param headA the head of the first linked list
     * @param headB the head of the second linked list
     * @return the intersection node, or null if no intersection
     */
    public ListNode getIntersectionNodeBruteForce(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode currA = headA;
        while (currA != null) {
            ListNode currB = headB;
            while (currB != null) {
                if (currA == currB) {
                    return currA; // Found intersection
                }
                currB = currB.next;
            }
            currA = currA.next;
        }

        return null; // No intersection
    }

    /**
     * Approach 5: Stack Method
     * 
     * Key Insight: Push all nodes from both lists onto separate stacks, then pop from both stacks
     * until we find the last common node.
     * 
     * Time Complexity: O(m + n) Space Complexity: O(m + n)
     * 
     * @param headA the head of the first linked list
     * @param headB the head of the second linked list
     * @return the intersection node, or null if no intersection
     */
    public ListNode getIntersectionNodeStack(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        java.util.Stack<ListNode> stackA = new java.util.Stack<>();
        java.util.Stack<ListNode> stackB = new java.util.Stack<>();

        // Push all nodes from listA onto stackA
        ListNode curr = headA;
        while (curr != null) {
            stackA.push(curr);
            curr = curr.next;
        }

        // Push all nodes from listB onto stackB
        curr = headB;
        while (curr != null) {
            stackB.push(curr);
            curr = curr.next;
        }

        // Pop from both stacks until we find the last common node
        ListNode intersection = null;
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            ListNode nodeA = stackA.pop();
            ListNode nodeB = stackB.pop();
            if (nodeA == nodeB) {
                intersection = nodeA;
            } else {
                break;
            }
        }

        return intersection;
    }

    /**
     * Approach 6: Reverse and Compare Method
     * 
     * Key Insight: Reverse both lists, then traverse from the end to find the intersection point.
     * This is more complex but demonstrates another approach.
     * 
     * Time Complexity: O(m + n) Space Complexity: O(1)
     * 
     * @param headA the head of the first linked list
     * @param headB the head of the second linked list
     * @return the intersection node, or null if no intersection
     */
    public ListNode getIntersectionNodeReverse(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        // Reverse both lists
        headA = reverseList(headA);
        headB = reverseList(headB);

        // Find intersection by comparing from the end
        ListNode intersection = null;
        ListNode currA = headA;
        ListNode currB = headB;

        while (currA != null && currB != null && currA == currB) {
            intersection = currA;
            currA = currA.next;
            currB = currB.next;
        }

        // Restore original lists
        reverseList(headA);
        reverseList(headB);

        return intersection;
    }

    /**
     * Helper method to calculate the length of a linked list.
     * 
     * @param head the head of the linked list
     * @return the length of the linked list
     */
    private int getLength(ListNode head) {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        return length;
    }

    /**
     * Helper method to reverse a linked list.
     * 
     * @param head the head of the linked list to reverse
     * @return the new head of the reversed linked list
     */
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * Utility method to create a linked list from an array of values.
     * 
     * @param values the array of values
     * @return the head of the created linked list
     */
    public static ListNode createList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode head = new ListNode(values[0]);
        ListNode curr = head;
        for (int i = 1; i < values.length; i++) {
            curr.next = new ListNode(values[i]);
            curr = curr.next;
        }
        return head;
    }

    /**
     * Utility method to create an intersection between two lists.
     * 
     * @param listA the first list
     * @param listB the second list
     * @param intersectPos the position in listA where intersection should occur
     * @param skipB the number of nodes to skip in listB before intersection
     * @return an array containing [headA, headB, intersectionNode]
     */
    public static ListNode[] createIntersection(int[] listA, int[] listB, int intersectPos,
            int skipB) {
        ListNode headA = createList(listA);
        ListNode headB = createList(listB);

        if (intersectPos >= 0 && intersectPos < listA.length) {
            // Find the intersection node in listA
            ListNode intersectNode = headA;
            for (int i = 0; i < intersectPos; i++) {
                intersectNode = intersectNode.next;
            }

            // Connect listB to the intersection node
            ListNode currB = headB;
            for (int i = 0; i < skipB - 1; i++) {
                currB = currB.next;
            }
            currB.next = intersectNode;
        }

        return new ListNode[] {headA, headB, intersectPos >= 0 ? headA : null};
    }

    /**
     * Main method to demonstrate the solution approaches.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists solution = new IntersectionOfTwoLinkedLists();

        // Test Case 1: Lists with intersection
        System.out.println("=== Test Case 1: Lists with intersection ===");
        int[] listA1 = {4, 1, 8, 4, 5};
        int[] listB1 = {5, 6, 1};
        ListNode[] result1 = createIntersection(listA1, listB1, 2, 3);
        ListNode headA1 = result1[0];
        ListNode headB1 = result1[1];

        ListNode intersection1 = solution.getIntersectionNode(headA1, headB1);
        System.out.println("Two-Pointer: " + (intersection1 != null ? intersection1.val : "null"));

        // Test Case 2: Lists without intersection
        System.out.println("\n=== Test Case 2: Lists without intersection ===");
        ListNode headA2 = createList(new int[] {2, 6, 4});
        ListNode headB2 = createList(new int[] {1, 5});

        ListNode intersection2 = solution.getIntersectionNode(headA2, headB2);
        System.out.println("Two-Pointer: " + (intersection2 != null ? intersection2.val : "null"));

        // Test Case 3: One list is null
        System.out.println("\n=== Test Case 3: One list is null ===");
        ListNode headA3 = createList(new int[] {1, 2, 3});
        ListNode intersection3 = solution.getIntersectionNode(headA3, null);
        System.out.println("Two-Pointer: " + (intersection3 != null ? intersection3.val : "null"));

        // Test all approaches with the same test case
        System.out.println("\n=== All Approaches Comparison ===");
        ListNode[] testCase = createIntersection(new int[] {1, 9, 1, 2, 4}, new int[] {3}, 3, 1);
        ListNode testHeadA = testCase[0];
        ListNode testHeadB = testCase[1];

        ListNode resultA = solution.getIntersectionNode(testHeadA, testHeadB);
        ListNode resultB = solution.getIntersectionNodeLengthDiff(testHeadA, testHeadB);
        ListNode resultC = solution.getIntersectionNodeHashSet(testHeadA, testHeadB);
        ListNode resultD = solution.getIntersectionNodeBruteForce(testHeadA, testHeadB);
        ListNode resultE = solution.getIntersectionNodeStack(testHeadA, testHeadB);

        System.out.println("Two-Pointer: " + (resultA != null ? resultA.val : "null"));
        System.out.println("Length Diff: " + (resultB != null ? resultB.val : "null"));
        System.out.println("HashSet: " + (resultC != null ? resultC.val : "null"));
        System.out.println("Brute Force: " + (resultD != null ? resultD.val : "null"));
        System.out.println("Stack: " + (resultE != null ? resultE.val : "null"));

        // Verify all approaches produce the same result
        boolean allEqual = (resultA == resultB) && (resultB == resultC) && (resultC == resultD)
                && (resultD == resultE);
        System.out.println("All approaches produce same result: " + allEqual);
    }
}
