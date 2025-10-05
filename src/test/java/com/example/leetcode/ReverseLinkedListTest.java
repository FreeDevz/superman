package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Comprehensive test suite for ReverseLinkedList problem
 */
public class ReverseLinkedListTest {

    private ReverseLinkedList solution;

    @BeforeEach
    void setUp() {
        solution = new ReverseLinkedList();
    }

    @Nested
    @DisplayName("Iterative Approach Tests")
    class IterativeApproachTests {

        @Test
        @DisplayName("Test reversing a normal linked list")
        void testReverseNormalList() {
            // [1,2,3,4,5] -> [5,4,3,2,1]
            ReverseLinkedList.ListNode head =
                    ReverseLinkedList.ListNode.createFromArray(new int[] {1, 2, 3, 4, 5});
            ReverseLinkedList.ListNode result = solution.reverseListIterative(head);

            int[] expected = {5, 4, 3, 2, 1};
            int[] actual = ReverseLinkedList.ListNode.toArray(result);
            assertArrayEquals(expected, actual);
        }

        @Test
        @DisplayName("Test reversing a two-node list")
        void testReverseTwoNodes() {
            // [1,2] -> [2,1]
            ReverseLinkedList.ListNode head =
                    ReverseLinkedList.ListNode.createFromArray(new int[] {1, 2});
            ReverseLinkedList.ListNode result = solution.reverseListIterative(head);

            int[] expected = {2, 1};
            int[] actual = ReverseLinkedList.ListNode.toArray(result);
            assertArrayEquals(expected, actual);
        }

        @Test
        @DisplayName("Test reversing a single-node list")
        void testReverseSingleNode() {
            // [1] -> [1]
            ReverseLinkedList.ListNode head =
                    ReverseLinkedList.ListNode.createFromArray(new int[] {1});
            ReverseLinkedList.ListNode result = solution.reverseListIterative(head);

            int[] expected = {1};
            int[] actual = ReverseLinkedList.ListNode.toArray(result);
            assertArrayEquals(expected, actual);
        }

        @Test
        @DisplayName("Test reversing an empty list")
        void testReverseEmptyList() {
            ReverseLinkedList.ListNode head = null;
            ReverseLinkedList.ListNode result = solution.reverseListIterative(head);

            assertNull(result);
        }

        @Test
        @DisplayName("Test reversing list with negative values")
        void testReverseListWithNegativeValues() {
            // [-3,-2,-1,0,1,2,3] -> [3,2,1,0,-1,-2,-3]
            ReverseLinkedList.ListNode head =
                    ReverseLinkedList.ListNode.createFromArray(new int[] {-3, -2, -1, 0, 1, 2, 3});
            ReverseLinkedList.ListNode result = solution.reverseListIterative(head);

            int[] expected = {3, 2, 1, 0, -1, -2, -3};
            int[] actual = ReverseLinkedList.ListNode.toArray(result);
            assertArrayEquals(expected, actual);
        }

        @Test
        @DisplayName("Test reversing list with duplicate values")
        void testReverseListWithDuplicates() {
            // [1,1,2,2,3,3] -> [3,3,2,2,1,1]
            ReverseLinkedList.ListNode head =
                    ReverseLinkedList.ListNode.createFromArray(new int[] {1, 1, 2, 2, 3, 3});
            ReverseLinkedList.ListNode result = solution.reverseListIterative(head);

            int[] expected = {3, 3, 2, 2, 1, 1};
            int[] actual = ReverseLinkedList.ListNode.toArray(result);
            assertArrayEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("Recursive Approach Tests")
    class RecursiveApproachTests {

        @Test
        @DisplayName("Test recursive reversing a normal linked list")
        void testRecursiveReverseNormalList() {
            // [1,2,3,4,5] -> [5,4,3,2,1]
            ReverseLinkedList.ListNode head =
                    ReverseLinkedList.ListNode.createFromArray(new int[] {1, 2, 3, 4, 5});
            ReverseLinkedList.ListNode result = solution.reverseListRecursive(head);

            int[] expected = {5, 4, 3, 2, 1};
            int[] actual = ReverseLinkedList.ListNode.toArray(result);
            assertArrayEquals(expected, actual);
        }

        @Test
        @DisplayName("Test recursive reversing a two-node list")
        void testRecursiveReverseTwoNodes() {
            // [1,2] -> [2,1]
            ReverseLinkedList.ListNode head =
                    ReverseLinkedList.ListNode.createFromArray(new int[] {1, 2});
            ReverseLinkedList.ListNode result = solution.reverseListRecursive(head);

            int[] expected = {2, 1};
            int[] actual = ReverseLinkedList.ListNode.toArray(result);
            assertArrayEquals(expected, actual);
        }

        @Test
        @DisplayName("Test recursive reversing a single-node list")
        void testRecursiveReverseSingleNode() {
            // [1] -> [1]
            ReverseLinkedList.ListNode head =
                    ReverseLinkedList.ListNode.createFromArray(new int[] {1});
            ReverseLinkedList.ListNode result = solution.reverseListRecursive(head);

            int[] expected = {1};
            int[] actual = ReverseLinkedList.ListNode.toArray(result);
            assertArrayEquals(expected, actual);
        }

        @Test
        @DisplayName("Test recursive reversing an empty list")
        void testRecursiveReverseEmptyList() {
            ReverseLinkedList.ListNode head = null;
            ReverseLinkedList.ListNode result = solution.reverseListRecursive(head);

            assertNull(result);
        }
    }

    @Nested
    @DisplayName("Tail Recursive Approach Tests")
    class TailRecursiveApproachTests {

        @Test
        @DisplayName("Test tail recursive reversing a normal linked list")
        void testTailRecursiveReverseNormalList() {
            // [1,2,3,4,5] -> [5,4,3,2,1]
            ReverseLinkedList.ListNode head =
                    ReverseLinkedList.ListNode.createFromArray(new int[] {1, 2, 3, 4, 5});
            ReverseLinkedList.ListNode result = solution.reverseListTailRecursive(head);

            int[] expected = {5, 4, 3, 2, 1};
            int[] actual = ReverseLinkedList.ListNode.toArray(result);
            assertArrayEquals(expected, actual);
        }

        @Test
        @DisplayName("Test tail recursive reversing an empty list")
        void testTailRecursiveReverseEmptyList() {
            ReverseLinkedList.ListNode head = null;
            ReverseLinkedList.ListNode result = solution.reverseListTailRecursive(head);

            assertNull(result);
        }

        @Test
        @DisplayName("Test tail recursive reversing a single-node list")
        void testTailRecursiveReverseSingleNode() {
            // [42] -> [42]
            ReverseLinkedList.ListNode head =
                    ReverseLinkedList.ListNode.createFromArray(new int[] {42});
            ReverseLinkedList.ListNode result = solution.reverseListTailRecursive(head);

            int[] expected = {42};
            int[] actual = ReverseLinkedList.ListNode.toArray(result);
            assertArrayEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("Stack-based Recursive Approach Tests")
    class StackBasedRecursiveApproachTests {

        @Test
        @DisplayName("Test stack-based recursive reversing a normal linked list")
        void testStackBasedReverseNormalList() {
            // [1,2,3,4,5] -> [5,4,3,2,1]
            ReverseLinkedList.ListNode head =
                    ReverseLinkedList.ListNode.createFromArray(new int[] {1, 2, 3, 4, 5});
            ReverseLinkedList.ListNode result = solution.reverseListWithStack(head);

            int[] expected = {5, 4, 3, 2, 1};
            int[] actual = ReverseLinkedList.ListNode.toArray(result);
            assertArrayEquals(expected, actual);
        }

        @Test
        @DisplayName("Test stack-based recursive reversing an empty list")
        void testStackBasedReverseEmptyList() {
            ReverseLinkedList.ListNode head = null;
            ReverseLinkedList.ListNode result = solution.reverseListWithStack(head);

            assertNull(result);
        }
    }

    @Nested
    @DisplayName("Cross-Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @Test
        @DisplayName("All approaches should produce identical results for normal list")
        void testAllApproachesProduceSameResult() {
            int[] testData = {1, 2, 3, 4, 5};
            ReverseLinkedList.ListNode original =
                    ReverseLinkedList.ListNode.createFromArray(testData);

            // Test all approaches
            ReverseLinkedList.ListNode iterative =
                    solution.reverseListIterative(ReverseLinkedList.copyList(original));
            ReverseLinkedList.ListNode recursive =
                    solution.reverseListRecursive(ReverseLinkedList.copyList(original));
            ReverseLinkedList.ListNode tailRecursive =
                    solution.reverseListTailRecursive(ReverseLinkedList.copyList(original));
            ReverseLinkedList.ListNode stackBased =
                    solution.reverseListWithStack(ReverseLinkedList.copyList(original));

            // All results should be equal
            assertTrue(ReverseLinkedList.ListNode.areEqual(iterative, recursive));
            assertTrue(ReverseLinkedList.ListNode.areEqual(recursive, tailRecursive));
            assertTrue(ReverseLinkedList.ListNode.areEqual(tailRecursive, stackBased));
        }

        @Test
        @DisplayName("All approaches should handle empty list consistently")
        void testAllApproachesHandleEmptyList() {
            ReverseLinkedList.ListNode empty = null;

            ReverseLinkedList.ListNode iterative = solution.reverseListIterative(empty);
            ReverseLinkedList.ListNode recursive = solution.reverseListRecursive(empty);
            ReverseLinkedList.ListNode tailRecursive = solution.reverseListTailRecursive(empty);
            ReverseLinkedList.ListNode stackBased = solution.reverseListWithStack(empty);

            assertNull(iterative);
            assertNull(recursive);
            assertNull(tailRecursive);
            assertNull(stackBased);
        }
    }

    @Nested
    @DisplayName("Edge Case Tests")
    class EdgeCaseTests {

        @Test
        @DisplayName("Test with maximum constraint values")
        void testWithMaxConstraintValues() {
            // Test with values at the edge of constraints (-5000 to 5000)
            ReverseLinkedList.ListNode head =
                    ReverseLinkedList.ListNode.createFromArray(new int[] {-5000, 0, 5000});
            ReverseLinkedList.ListNode result = solution.reverseListIterative(head);

            int[] expected = {5000, 0, -5000};
            int[] actual = ReverseLinkedList.ListNode.toArray(result);
            assertArrayEquals(expected, actual);
        }

        @Test
        @DisplayName("Test with alternating positive and negative values")
        void testWithAlternatingValues() {
            ReverseLinkedList.ListNode head =
                    ReverseLinkedList.ListNode.createFromArray(new int[] {1, -1, 2, -2, 3, -3});
            ReverseLinkedList.ListNode result = solution.reverseListIterative(head);

            int[] expected = {-3, 3, -2, 2, -1, 1};
            int[] actual = ReverseLinkedList.ListNode.toArray(result);
            assertArrayEquals(expected, actual);
        }

        @Test
        @DisplayName("Test with all same values")
        void testWithAllSameValues() {
            ReverseLinkedList.ListNode head =
                    ReverseLinkedList.ListNode.createFromArray(new int[] {7, 7, 7, 7, 7});
            ReverseLinkedList.ListNode result = solution.reverseListIterative(head);

            int[] expected = {7, 7, 7, 7, 7};
            int[] actual = ReverseLinkedList.ListNode.toArray(result);
            assertArrayEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("Utility Method Tests")
    class UtilityMethodTests {

        @Test
        @DisplayName("Test ListNode.createFromArray method")
        void testCreateFromArray() {
            int[] arr = {1, 2, 3, 4, 5};
            ReverseLinkedList.ListNode head = ReverseLinkedList.ListNode.createFromArray(arr);

            int[] result = ReverseLinkedList.ListNode.toArray(head);
            assertArrayEquals(arr, result);
        }

        @Test
        @DisplayName("Test ListNode.createFromArray with empty array")
        void testCreateFromEmptyArray() {
            int[] arr = {};
            ReverseLinkedList.ListNode head = ReverseLinkedList.ListNode.createFromArray(arr);

            assertNull(head);
        }

        @Test
        @DisplayName("Test ListNode.toArray method")
        void testToArray() {
            ReverseLinkedList.ListNode head = new ReverseLinkedList.ListNode(1);
            head.next = new ReverseLinkedList.ListNode(2);
            head.next.next = new ReverseLinkedList.ListNode(3);

            int[] expected = {1, 2, 3};
            int[] actual = ReverseLinkedList.ListNode.toArray(head);
            assertArrayEquals(expected, actual);
        }

        @Test
        @DisplayName("Test ListNode.areEqual method")
        void testAreEqual() {
            ReverseLinkedList.ListNode list1 =
                    ReverseLinkedList.ListNode.createFromArray(new int[] {1, 2, 3});
            ReverseLinkedList.ListNode list2 =
                    ReverseLinkedList.ListNode.createFromArray(new int[] {1, 2, 3});
            ReverseLinkedList.ListNode list3 =
                    ReverseLinkedList.ListNode.createFromArray(new int[] {1, 2, 4});

            assertTrue(ReverseLinkedList.ListNode.areEqual(list1, list2));
            assertFalse(ReverseLinkedList.ListNode.areEqual(list1, list3));
        }

        @Test
        @DisplayName("Test getLength utility method")
        void testGetLength() {
            ReverseLinkedList.ListNode head =
                    ReverseLinkedList.ListNode.createFromArray(new int[] {1, 2, 3, 4, 5});
            assertEquals(5, ReverseLinkedList.getLength(head));

            assertEquals(0, ReverseLinkedList.getLength(null));

            ReverseLinkedList.ListNode single = new ReverseLinkedList.ListNode(42);
            assertEquals(1, ReverseLinkedList.getLength(single));
        }

        @Test
        @DisplayName("Test copyList utility method")
        void testCopyList() {
            ReverseLinkedList.ListNode original =
                    ReverseLinkedList.ListNode.createFromArray(new int[] {1, 2, 3, 4, 5});
            ReverseLinkedList.ListNode copy = ReverseLinkedList.copyList(original);

            // Should be equal but not the same object
            assertTrue(ReverseLinkedList.ListNode.areEqual(original, copy));
            assertNotSame(original, copy);

            // Modifying copy should not affect original
            copy.val = 999;
            assertFalse(ReverseLinkedList.ListNode.areEqual(original, copy));
        }
    }

    @Nested
    @DisplayName("LeetCode Examples Tests")
    class LeetCodeExamplesTests {

        @Test
        @DisplayName("LeetCode Example 1: [1,2,3,4,5] -> [5,4,3,2,1]")
        void testLeetCodeExample1() {
            ReverseLinkedList.ListNode head =
                    ReverseLinkedList.ListNode.createFromArray(new int[] {1, 2, 3, 4, 5});
            ReverseLinkedList.ListNode result = solution.reverseListIterative(head);

            int[] expected = {5, 4, 3, 2, 1};
            int[] actual = ReverseLinkedList.ListNode.toArray(result);
            assertArrayEquals(expected, actual);
        }

        @Test
        @DisplayName("LeetCode Example 2: [1,2] -> [2,1]")
        void testLeetCodeExample2() {
            ReverseLinkedList.ListNode head =
                    ReverseLinkedList.ListNode.createFromArray(new int[] {1, 2});
            ReverseLinkedList.ListNode result = solution.reverseListIterative(head);

            int[] expected = {2, 1};
            int[] actual = ReverseLinkedList.ListNode.toArray(result);
            assertArrayEquals(expected, actual);
        }

        @Test
        @DisplayName("LeetCode Example 3: [] -> []")
        void testLeetCodeExample3() {
            ReverseLinkedList.ListNode head = null;
            ReverseLinkedList.ListNode result = solution.reverseListIterative(head);

            assertNull(result);
        }
    }
}
