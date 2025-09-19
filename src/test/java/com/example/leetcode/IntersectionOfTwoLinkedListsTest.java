package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Comprehensive test suite for LeetCode 160: Intersection of Two Linked Lists
 * 
 * This test class validates all solution approaches for the Intersection of Two Linked Lists
 * problem, ensuring correctness across various test cases including edge cases, boundary
 * conditions, and performance scenarios.
 * 
 * @author LeetCode Test Suite
 * @version 1.0
 */
public class IntersectionOfTwoLinkedListsTest {

    private IntersectionOfTwoLinkedLists solution;

    @BeforeEach
    void setUp() {
        solution = new IntersectionOfTwoLinkedLists();
    }

    @Nested
    @DisplayName("Two-Pointer Approach Tests")
    class TwoPointerApproachTests {

        @Test
        @DisplayName("Test with intersection at middle")
        void testWithIntersectionAtMiddle() {
            // Create lists: [4,1,8,4,5] and [5,6,1,8,4,5] intersecting at 8
            int[] listA = {4, 1, 8, 4, 5};
            int[] listB = {5, 6, 1};
            IntersectionOfTwoLinkedLists.ListNode[] result =
                    IntersectionOfTwoLinkedLists.createIntersection(listA, listB, 2, 3);
            IntersectionOfTwoLinkedLists.ListNode headA = result[0];
            IntersectionOfTwoLinkedLists.ListNode headB = result[1];

            IntersectionOfTwoLinkedLists.ListNode intersection =
                    solution.getIntersectionNode(headA, headB);

            assertNotNull(intersection);
            assertEquals(8, intersection.val);
        }

        @Test
        @DisplayName("Test with intersection at end")
        void testWithIntersectionAtEnd() {
            // Create lists: [1,9,1,2,4] and [3,2,4] intersecting at 2
            int[] listA = {1, 9, 1, 2, 4};
            int[] listB = {3};
            IntersectionOfTwoLinkedLists.ListNode[] result =
                    IntersectionOfTwoLinkedLists.createIntersection(listA, listB, 3, 1);
            IntersectionOfTwoLinkedLists.ListNode headA = result[0];
            IntersectionOfTwoLinkedLists.ListNode headB = result[1];

            IntersectionOfTwoLinkedLists.ListNode intersection =
                    solution.getIntersectionNode(headA, headB);

            assertNotNull(intersection);
            assertEquals(2, intersection.val);
        }

        @Test
        @DisplayName("Test with no intersection")
        void testWithNoIntersection() {
            IntersectionOfTwoLinkedLists.ListNode headA =
                    IntersectionOfTwoLinkedLists.createList(new int[] {2, 6, 4});
            IntersectionOfTwoLinkedLists.ListNode headB =
                    IntersectionOfTwoLinkedLists.createList(new int[] {1, 5});

            IntersectionOfTwoLinkedLists.ListNode intersection =
                    solution.getIntersectionNode(headA, headB);

            assertNull(intersection);
        }

        @Test
        @DisplayName("Test with null lists")
        void testWithNullLists() {
            IntersectionOfTwoLinkedLists.ListNode intersection1 =
                    solution.getIntersectionNode(null, null);
            assertNull(intersection1);

            IntersectionOfTwoLinkedLists.ListNode headA =
                    IntersectionOfTwoLinkedLists.createList(new int[] {1, 2, 3});
            IntersectionOfTwoLinkedLists.ListNode intersection2 =
                    solution.getIntersectionNode(headA, null);
            assertNull(intersection2);

            IntersectionOfTwoLinkedLists.ListNode headB =
                    IntersectionOfTwoLinkedLists.createList(new int[] {4, 5, 6});
            IntersectionOfTwoLinkedLists.ListNode intersection3 =
                    solution.getIntersectionNode(null, headB);
            assertNull(intersection3);
        }

        @Test
        @DisplayName("Test with single node lists")
        void testWithSingleNodeLists() {
            // Test with same single node (intersection)
            IntersectionOfTwoLinkedLists.ListNode sharedNode =
                    new IntersectionOfTwoLinkedLists.ListNode(1);
            IntersectionOfTwoLinkedLists.ListNode headA = sharedNode;
            IntersectionOfTwoLinkedLists.ListNode headB = sharedNode;

            IntersectionOfTwoLinkedLists.ListNode intersection =
                    solution.getIntersectionNode(headA, headB);

            assertNotNull(intersection);
            assertEquals(1, intersection.val);
            assertEquals(sharedNode, intersection);
        }

        @Test
        @DisplayName("Test with identical lists")
        void testWithIdenticalLists() {
            IntersectionOfTwoLinkedLists.ListNode headA =
                    IntersectionOfTwoLinkedLists.createList(new int[] {1, 2, 3, 4, 5});
            IntersectionOfTwoLinkedLists.ListNode headB = headA; // Same list

            IntersectionOfTwoLinkedLists.ListNode intersection =
                    solution.getIntersectionNode(headA, headB);

            assertNotNull(intersection);
            assertEquals(1, intersection.val);
            assertEquals(headA, intersection);
        }
    }

    @Nested
    @DisplayName("Length Difference Approach Tests")
    class LengthDifferenceApproachTests {

        @Test
        @DisplayName("Test with different length lists")
        void testWithDifferentLengthLists() {
            int[] listA = {1, 2, 3, 4, 5, 6};
            int[] listB = {7, 8};
            IntersectionOfTwoLinkedLists.ListNode[] result =
                    IntersectionOfTwoLinkedLists.createIntersection(listA, listB, 3, 2);
            IntersectionOfTwoLinkedLists.ListNode headA = result[0];
            IntersectionOfTwoLinkedLists.ListNode headB = result[1];

            IntersectionOfTwoLinkedLists.ListNode intersection =
                    solution.getIntersectionNodeLengthDiff(headA, headB);

            assertNotNull(intersection);
            assertEquals(4, intersection.val);
        }

        @Test
        @DisplayName("Test with same length lists")
        void testWithSameLengthLists() {
            int[] listA = {1, 2, 3};
            int[] listB = {4, 5};
            IntersectionOfTwoLinkedLists.ListNode[] result =
                    IntersectionOfTwoLinkedLists.createIntersection(listA, listB, 1, 2);
            IntersectionOfTwoLinkedLists.ListNode headA = result[0];
            IntersectionOfTwoLinkedLists.ListNode headB = result[1];

            IntersectionOfTwoLinkedLists.ListNode intersection =
                    solution.getIntersectionNodeLengthDiff(headA, headB);

            assertNotNull(intersection);
            assertEquals(2, intersection.val);
        }
    }

    @Nested
    @DisplayName("HashSet Approach Tests")
    class HashSetApproachTests {

        @Test
        @DisplayName("Test HashSet approach with intersection")
        void testHashSetApproachWithIntersection() {
            int[] listA = {1, 2, 3, 4, 5};
            int[] listB = {6, 7};
            IntersectionOfTwoLinkedLists.ListNode[] result =
                    IntersectionOfTwoLinkedLists.createIntersection(listA, listB, 2, 2);
            IntersectionOfTwoLinkedLists.ListNode headA = result[0];
            IntersectionOfTwoLinkedLists.ListNode headB = result[1];

            IntersectionOfTwoLinkedLists.ListNode intersection =
                    solution.getIntersectionNodeHashSet(headA, headB);

            assertNotNull(intersection);
            assertEquals(3, intersection.val);
        }

        @Test
        @DisplayName("Test HashSet approach with no intersection")
        void testHashSetApproachWithNoIntersection() {
            IntersectionOfTwoLinkedLists.ListNode headA =
                    IntersectionOfTwoLinkedLists.createList(new int[] {1, 2, 3});
            IntersectionOfTwoLinkedLists.ListNode headB =
                    IntersectionOfTwoLinkedLists.createList(new int[] {4, 5, 6});

            IntersectionOfTwoLinkedLists.ListNode intersection =
                    solution.getIntersectionNodeHashSet(headA, headB);

            assertNull(intersection);
        }
    }

    @Nested
    @DisplayName("Brute Force Approach Tests")
    class BruteForceApproachTests {

        @Test
        @DisplayName("Test brute force approach")
        void testBruteForceApproach() {
            int[] listA = {1, 2, 3, 4};
            int[] listB = {5, 6};
            IntersectionOfTwoLinkedLists.ListNode[] result =
                    IntersectionOfTwoLinkedLists.createIntersection(listA, listB, 1, 2);
            IntersectionOfTwoLinkedLists.ListNode headA = result[0];
            IntersectionOfTwoLinkedLists.ListNode headB = result[1];

            IntersectionOfTwoLinkedLists.ListNode intersection =
                    solution.getIntersectionNodeBruteForce(headA, headB);

            assertNotNull(intersection);
            assertEquals(2, intersection.val);
        }
    }

    @Nested
    @DisplayName("Stack Approach Tests")
    class StackApproachTests {

        @Test
        @DisplayName("Test stack approach")
        void testStackApproach() {
            int[] listA = {1, 2, 3, 4, 5};
            int[] listB = {6, 7, 8};
            IntersectionOfTwoLinkedLists.ListNode[] result =
                    IntersectionOfTwoLinkedLists.createIntersection(listA, listB, 2, 3);
            IntersectionOfTwoLinkedLists.ListNode headA = result[0];
            IntersectionOfTwoLinkedLists.ListNode headB = result[1];

            IntersectionOfTwoLinkedLists.ListNode intersection =
                    solution.getIntersectionNodeStack(headA, headB);

            assertNotNull(intersection);
            assertEquals(3, intersection.val);
        }
    }

    @Nested
    @DisplayName("Cross Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @Test
        @DisplayName("All approaches should produce same result with intersection")
        void testAllApproachesWithIntersection() {
            int[] listA = {1, 2, 3, 4, 5, 6};
            int[] listB = {7, 8, 9};
            IntersectionOfTwoLinkedLists.ListNode[] result =
                    IntersectionOfTwoLinkedLists.createIntersection(listA, listB, 3, 3);
            IntersectionOfTwoLinkedLists.ListNode headA = result[0];
            IntersectionOfTwoLinkedLists.ListNode headB = result[1];

            IntersectionOfTwoLinkedLists.ListNode result1 =
                    solution.getIntersectionNode(headA, headB);
            IntersectionOfTwoLinkedLists.ListNode result2 =
                    solution.getIntersectionNodeLengthDiff(headA, headB);
            IntersectionOfTwoLinkedLists.ListNode result3 =
                    solution.getIntersectionNodeHashSet(headA, headB);
            IntersectionOfTwoLinkedLists.ListNode result4 =
                    solution.getIntersectionNodeBruteForce(headA, headB);
            IntersectionOfTwoLinkedLists.ListNode result5 =
                    solution.getIntersectionNodeStack(headA, headB);

            assertNotNull(result1);
            assertNotNull(result2);
            assertNotNull(result3);
            assertNotNull(result4);
            assertNotNull(result5);

            assertEquals(result1, result2);
            assertEquals(result2, result3);
            assertEquals(result3, result4);
            assertEquals(result4, result5);
            assertEquals(4, result1.val);
        }

        @Test
        @DisplayName("All approaches should produce same result with no intersection")
        void testAllApproachesWithNoIntersection() {
            IntersectionOfTwoLinkedLists.ListNode headA =
                    IntersectionOfTwoLinkedLists.createList(new int[] {1, 2, 3});
            IntersectionOfTwoLinkedLists.ListNode headB =
                    IntersectionOfTwoLinkedLists.createList(new int[] {4, 5, 6});

            IntersectionOfTwoLinkedLists.ListNode result1 =
                    solution.getIntersectionNode(headA, headB);
            IntersectionOfTwoLinkedLists.ListNode result2 =
                    solution.getIntersectionNodeLengthDiff(headA, headB);
            IntersectionOfTwoLinkedLists.ListNode result3 =
                    solution.getIntersectionNodeHashSet(headA, headB);
            IntersectionOfTwoLinkedLists.ListNode result4 =
                    solution.getIntersectionNodeBruteForce(headA, headB);
            IntersectionOfTwoLinkedLists.ListNode result5 =
                    solution.getIntersectionNodeStack(headA, headB);

            assertNull(result1);
            assertNull(result2);
            assertNull(result3);
            assertNull(result4);
            assertNull(result5);
        }
    }

    @Nested
    @DisplayName("Edge Case Tests")
    class EdgeCaseTests {

        @Test
        @DisplayName("Test with maximum constraint values")
        void testWithMaximumConstraintValues() {
            // Create large lists to test performance
            int[] listA = new int[1000];
            int[] listB = new int[500];
            for (int i = 0; i < listA.length; i++) {
                listA[i] = i + 1;
            }
            for (int i = 0; i < listB.length; i++) {
                listB[i] = i + 1001;
            }

            IntersectionOfTwoLinkedLists.ListNode[] result =
                    IntersectionOfTwoLinkedLists.createIntersection(listA, listB, 500, 500);
            IntersectionOfTwoLinkedLists.ListNode headA = result[0];
            IntersectionOfTwoLinkedLists.ListNode headB = result[1];

            IntersectionOfTwoLinkedLists.ListNode intersection =
                    solution.getIntersectionNode(headA, headB);

            assertNotNull(intersection);
            assertEquals(501, intersection.val);
        }

        @Test
        @DisplayName("Test with intersection at first node")
        void testWithIntersectionAtFirstNode() {
            IntersectionOfTwoLinkedLists.ListNode sharedNode =
                    new IntersectionOfTwoLinkedLists.ListNode(1);
            sharedNode.next = new IntersectionOfTwoLinkedLists.ListNode(2);
            sharedNode.next.next = new IntersectionOfTwoLinkedLists.ListNode(3);

            IntersectionOfTwoLinkedLists.ListNode headA = sharedNode;
            IntersectionOfTwoLinkedLists.ListNode headB = sharedNode;

            IntersectionOfTwoLinkedLists.ListNode intersection =
                    solution.getIntersectionNode(headA, headB);

            assertNotNull(intersection);
            assertEquals(1, intersection.val);
            assertEquals(sharedNode, intersection);
        }

        @Test
        @DisplayName("Test with intersection at last node")
        void testWithIntersectionAtLastNode() {
            IntersectionOfTwoLinkedLists.ListNode sharedNode =
                    new IntersectionOfTwoLinkedLists.ListNode(5);
            IntersectionOfTwoLinkedLists.ListNode headA =
                    new IntersectionOfTwoLinkedLists.ListNode(1);
            headA.next = new IntersectionOfTwoLinkedLists.ListNode(2);
            headA.next.next = sharedNode;

            IntersectionOfTwoLinkedLists.ListNode headB =
                    new IntersectionOfTwoLinkedLists.ListNode(3);
            headB.next = new IntersectionOfTwoLinkedLists.ListNode(4);
            headB.next.next = sharedNode;

            IntersectionOfTwoLinkedLists.ListNode intersection =
                    solution.getIntersectionNode(headA, headB);

            assertNotNull(intersection);
            assertEquals(5, intersection.val);
            assertEquals(sharedNode, intersection);
        }

        @Test
        @DisplayName("Test with empty lists")
        void testWithEmptyLists() {
            IntersectionOfTwoLinkedLists.ListNode intersection1 =
                    solution.getIntersectionNode(null, null);
            assertNull(intersection1);
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Performance comparison for moderate input size")
        void testPerformanceComparison() {
            int[] listA = new int[1000];
            int[] listB = new int[500];
            for (int i = 0; i < listA.length; i++) {
                listA[i] = i + 1;
            }
            for (int i = 0; i < listB.length; i++) {
                listB[i] = i + 1001;
            }

            IntersectionOfTwoLinkedLists.ListNode[] result =
                    IntersectionOfTwoLinkedLists.createIntersection(listA, listB, 500, 500);
            IntersectionOfTwoLinkedLists.ListNode headA = result[0];
            IntersectionOfTwoLinkedLists.ListNode headB = result[1];

            long startTime, endTime;

            // Test Two-Pointer approach
            startTime = System.nanoTime();
            IntersectionOfTwoLinkedLists.ListNode twoPointerResult =
                    solution.getIntersectionNode(headA, headB);
            endTime = System.nanoTime();
            long twoPointerTime = endTime - startTime;

            // Test Length Difference approach
            startTime = System.nanoTime();
            IntersectionOfTwoLinkedLists.ListNode lengthDiffResult =
                    solution.getIntersectionNodeLengthDiff(headA, headB);
            endTime = System.nanoTime();
            long lengthDiffTime = endTime - startTime;

            // Test HashSet approach
            startTime = System.nanoTime();
            IntersectionOfTwoLinkedLists.ListNode hashSetResult =
                    solution.getIntersectionNodeHashSet(headA, headB);
            endTime = System.nanoTime();
            long hashSetTime = endTime - startTime;

            // Verify all approaches produce same result
            assertEquals(twoPointerResult, lengthDiffResult);
            assertEquals(lengthDiffResult, hashSetResult);
            assertNotNull(twoPointerResult);
            assertEquals(501, twoPointerResult.val);

            // Performance should be reasonable (less than 1 second for n=1000)
            assertTrue(twoPointerTime < 1_000_000_000L,
                    "Two-pointer approach took too long: " + twoPointerTime + " ns");
            assertTrue(lengthDiffTime < 1_000_000_000L,
                    "Length difference approach took too long: " + lengthDiffTime + " ns");
            assertTrue(hashSetTime < 1_000_000_000L,
                    "HashSet approach took too long: " + hashSetTime + " ns");
        }
    }

    @Nested
    @DisplayName("Utility Method Tests")
    class UtilityMethodTests {

        @Test
        @DisplayName("Test createList utility method")
        void testCreateListUtility() {
            int[] values = {1, 2, 3, 4, 5};
            IntersectionOfTwoLinkedLists.ListNode head =
                    IntersectionOfTwoLinkedLists.createList(values);

            assertNotNull(head);
            assertEquals(1, head.val);

            IntersectionOfTwoLinkedLists.ListNode curr = head;
            for (int i = 0; i < values.length; i++) {
                assertNotNull(curr);
                assertEquals(values[i], curr.val);
                curr = curr.next;
            }
            assertNull(curr); // Should reach end
        }

        @Test
        @DisplayName("Test createList with empty array")
        void testCreateListWithEmptyArray() {
            IntersectionOfTwoLinkedLists.ListNode head =
                    IntersectionOfTwoLinkedLists.createList(new int[] {});
            assertNull(head);

            IntersectionOfTwoLinkedLists.ListNode head2 =
                    IntersectionOfTwoLinkedLists.createList(null);
            assertNull(head2);
        }

        @Test
        @DisplayName("Test createIntersection utility method")
        void testCreateIntersectionUtility() {
            int[] listA = {1, 2, 3, 4, 5};
            int[] listB = {6, 7, 8};
            IntersectionOfTwoLinkedLists.ListNode[] result =
                    IntersectionOfTwoLinkedLists.createIntersection(listA, listB, 2, 3);

            assertNotNull(result);
            assertEquals(3, result.length);
            assertNotNull(result[0]); // headA
            assertNotNull(result[1]); // headB
            assertNotNull(result[2]); // intersection node

            // Verify intersection
            IntersectionOfTwoLinkedLists.ListNode intersection =
                    solution.getIntersectionNode(result[0], result[1]);
            assertNotNull(intersection);
            assertEquals(3, intersection.val);
        }
    }
}
