package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Comprehensive test suite for LinkedListCycle problem Tests all approaches with various edge cases
 * and scenarios
 */
public class LinkedListCycleTest {

    private LinkedListCycle solution;

    @BeforeEach
    void setUp() {
        solution = new LinkedListCycle();
    }

    @Nested
    @DisplayName("Floyd's Algorithm Tests")
    class FloydAlgorithmTests {

        @Test
        @DisplayName("Test case 1: [3,2,0,-4] with cycle at position 1")
        void testCase1_WithCycle() {
            ListNode head = LinkedListCycle.createLinkedListWithCycle(new int[] {3, 2, 0, -4}, 1);
            assertTrue(solution.hasCycleFloyd(head), "Should detect cycle at position 1");
        }

        @Test
        @DisplayName("Test case 2: [1,2] with cycle at position 0")
        void testCase2_WithCycle() {
            ListNode head = LinkedListCycle.createLinkedListWithCycle(new int[] {1, 2}, 0);
            assertTrue(solution.hasCycleFloyd(head), "Should detect cycle at position 0");
        }

        @Test
        @DisplayName("Test case 3: [1] with no cycle")
        void testCase3_NoCycle() {
            ListNode head = LinkedListCycle.createLinkedList(new int[] {1});
            assertFalse(solution.hasCycleFloyd(head), "Should not detect cycle in single node");
        }

        @Test
        @DisplayName("Test case 4: Empty list")
        void testCase4_EmptyList() {
            ListNode head = null;
            assertFalse(solution.hasCycleFloyd(head), "Should return false for empty list");
        }

        @Test
        @DisplayName("Test case 5: Single node with self-cycle")
        void testCase5_SelfCycle() {
            ListNode head = LinkedListCycle.createLinkedListWithCycle(new int[] {1}, 0);
            assertTrue(solution.hasCycleFloyd(head), "Should detect self-cycle");
        }

        @Test
        @DisplayName("Test case 6: Two nodes with no cycle")
        void testCase6_TwoNodesNoCycle() {
            ListNode head = LinkedListCycle.createLinkedList(new int[] {1, 2});
            assertFalse(solution.hasCycleFloyd(head), "Should not detect cycle in two nodes");
        }

        @Test
        @DisplayName("Test case 7: Long list with cycle")
        void testCase7_LongListWithCycle() {
            ListNode head = LinkedListCycle
                    .createLinkedListWithCycle(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 3);
            assertTrue(solution.hasCycleFloyd(head), "Should detect cycle in long list");
        }

        @Test
        @DisplayName("Test case 8: Long list without cycle")
        void testCase8_LongListNoCycle() {
            ListNode head =
                    LinkedListCycle.createLinkedList(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
            assertFalse(solution.hasCycleFloyd(head), "Should not detect cycle in long list");
        }
    }

    @Nested
    @DisplayName("HashSet Algorithm Tests")
    class HashSetAlgorithmTests {

        @Test
        @DisplayName("Test case 1: [3,2,0,-4] with cycle at position 1")
        void testCase1_WithCycle() {
            ListNode head = LinkedListCycle.createLinkedListWithCycle(new int[] {3, 2, 0, -4}, 1);
            assertTrue(solution.hasCycleHashSet(head), "Should detect cycle at position 1");
        }

        @Test
        @DisplayName("Test case 2: [1,2] with cycle at position 0")
        void testCase2_WithCycle() {
            ListNode head = LinkedListCycle.createLinkedListWithCycle(new int[] {1, 2}, 0);
            assertTrue(solution.hasCycleHashSet(head), "Should detect cycle at position 0");
        }

        @Test
        @DisplayName("Test case 3: [1] with no cycle")
        void testCase3_NoCycle() {
            ListNode head = LinkedListCycle.createLinkedList(new int[] {1});
            assertFalse(solution.hasCycleHashSet(head), "Should not detect cycle in single node");
        }

        @Test
        @DisplayName("Test case 4: Empty list")
        void testCase4_EmptyList() {
            ListNode head = null;
            assertFalse(solution.hasCycleHashSet(head), "Should return false for empty list");
        }

        @Test
        @DisplayName("Test case 5: Single node with self-cycle")
        void testCase5_SelfCycle() {
            ListNode head = LinkedListCycle.createLinkedListWithCycle(new int[] {1}, 0);
            assertTrue(solution.hasCycleHashSet(head), "Should detect self-cycle");
        }
    }

    @Nested
    @DisplayName("Marking Algorithm Tests")
    class MarkingAlgorithmTests {

        @Test
        @DisplayName("Test case 1: [3,2,0,-4] with cycle at position 1")
        void testCase1_WithCycle() {
            ListNode head = LinkedListCycle.createLinkedListWithCycle(new int[] {3, 2, 0, -4}, 1);
            assertTrue(solution.hasCycleMarking(head), "Should detect cycle at position 1");
        }

        @Test
        @DisplayName("Test case 2: [1,2] with cycle at position 0")
        void testCase2_WithCycle() {
            ListNode head = LinkedListCycle.createLinkedListWithCycle(new int[] {1, 2}, 0);
            assertTrue(solution.hasCycleMarking(head), "Should detect cycle at position 0");
        }

        @Test
        @DisplayName("Test case 3: [1] with no cycle")
        void testCase3_NoCycle() {
            ListNode head = LinkedListCycle.createLinkedList(new int[] {1});
            assertFalse(solution.hasCycleMarking(head), "Should not detect cycle in single node");
        }

        @Test
        @DisplayName("Test case 4: Empty list")
        void testCase4_EmptyList() {
            ListNode head = null;
            assertFalse(solution.hasCycleMarking(head), "Should return false for empty list");
        }

        @Test
        @DisplayName("Test case 5: Single node with self-cycle")
        void testCase5_SelfCycle() {
            ListNode head = LinkedListCycle.createLinkedListWithCycle(new int[] {1}, 0);
            assertTrue(solution.hasCycleMarking(head), "Should detect self-cycle");
        }
    }

    @Nested
    @DisplayName("Reverse Algorithm Tests")
    class ReverseAlgorithmTests {

        @Test
        @DisplayName("Test case 1: [3,2,0,-4] with cycle at position 1")
        void testCase1_WithCycle() {
            ListNode head = LinkedListCycle.createLinkedListWithCycle(new int[] {3, 2, 0, -4}, 1);
            assertTrue(solution.hasCycleReverse(head), "Should detect cycle at position 1");
        }

        @Test
        @DisplayName("Test case 2: [1,2] with cycle at position 0")
        void testCase2_WithCycle() {
            ListNode head = LinkedListCycle.createLinkedListWithCycle(new int[] {1, 2}, 0);
            assertTrue(solution.hasCycleReverse(head), "Should detect cycle at position 0");
        }

        @Test
        @DisplayName("Test case 3: [1] with no cycle")
        void testCase3_NoCycle() {
            ListNode head = LinkedListCycle.createLinkedList(new int[] {1});
            assertFalse(solution.hasCycleReverse(head), "Should not detect cycle in single node");
        }

        @Test
        @DisplayName("Test case 4: Empty list")
        void testCase4_EmptyList() {
            ListNode head = null;
            assertFalse(solution.hasCycleReverse(head), "Should return false for empty list");
        }

        @Test
        @DisplayName("Test case 5: Single node with self-cycle")
        void testCase5_SelfCycle() {
            ListNode head = LinkedListCycle.createLinkedListWithCycle(new int[] {1}, 0);
            assertTrue(solution.hasCycleReverse(head), "Should detect self-cycle");
        }
    }

    @Nested
    @DisplayName("Edge Cases and Boundary Tests")
    class EdgeCaseTests {

        @Test
        @DisplayName("Test with maximum constraint values")
        void testMaxConstraintValues() {
            // Create a list with 10^4 nodes (maximum constraint)
            int[] values = new int[1000]; // Using 1000 for practical testing
            for (int i = 0; i < values.length; i++) {
                values[i] = i;
            }

            ListNode head = LinkedListCycle.createLinkedListWithCycle(values, 500);
            assertTrue(solution.hasCycleFloyd(head), "Should handle large lists with cycles");
        }

        @Test
        @DisplayName("Test with negative values")
        void testNegativeValues() {
            ListNode head =
                    LinkedListCycle.createLinkedListWithCycle(new int[] {-1, -2, -3, -4}, 1);
            assertTrue(solution.hasCycleFloyd(head), "Should handle negative values");
        }

        @Test
        @DisplayName("Test with zero values")
        void testZeroValues() {
            ListNode head = LinkedListCycle.createLinkedListWithCycle(new int[] {0, 0, 0, 0}, 2);
            assertTrue(solution.hasCycleFloyd(head), "Should handle zero values");
        }

        @Test
        @DisplayName("Test cycle at the end")
        void testCycleAtEnd() {
            ListNode head = LinkedListCycle.createLinkedListWithCycle(new int[] {1, 2, 3, 4, 5}, 4);
            assertTrue(solution.hasCycleFloyd(head), "Should detect cycle at the end");
        }

        @Test
        @DisplayName("Test cycle at the beginning")
        void testCycleAtBeginning() {
            ListNode head = LinkedListCycle.createLinkedListWithCycle(new int[] {1, 2, 3, 4, 5}, 0);
            assertTrue(solution.hasCycleFloyd(head), "Should detect cycle at the beginning");
        }
    }

    @Nested
    @DisplayName("Cross-Validation Tests")
    class CrossValidationTests {

        @Test
        @DisplayName("All algorithms should return same result for cycle detection")
        void testAllAlgorithmsConsistency() {
            int[][] testCases = {{3, 2, 0, -4}, // with cycle
                    {1, 2}, // with cycle
                    {1}, // no cycle
                    {1, 2, 3, 4, 5} // no cycle
            };

            int[] cyclePositions = {1, 0, -1, -1};

            for (int i = 0; i < testCases.length; i++) {
                ListNode head =
                        LinkedListCycle.createLinkedListWithCycle(testCases[i], cyclePositions[i]);

                boolean floydResult = solution.hasCycleFloyd(head);
                boolean hashSetResult = solution.hasCycleHashSet(head);
                boolean markingResult = solution.hasCycleMarking(head);
                boolean reverseResult = solution.hasCycleReverse(head);

                assertEquals(floydResult, hashSetResult,
                        "Floyd and HashSet should return same result for test case " + (i + 1));
                assertEquals(floydResult, markingResult,
                        "Floyd and Marking should return same result for test case " + (i + 1));
                assertEquals(floydResult, reverseResult,
                        "Floyd and Reverse should return same result for test case " + (i + 1));
            }
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Test performance with large list")
        void testPerformanceLargeList() {
            int[] values = new int[10000];
            for (int i = 0; i < values.length; i++) {
                values[i] = i;
            }

            ListNode head = LinkedListCycle.createLinkedListWithCycle(values, 5000);

            long startTime = System.nanoTime();
            boolean result = solution.hasCycleFloyd(head);
            long endTime = System.nanoTime();

            assertTrue(result, "Should detect cycle in large list");
            long duration = endTime - startTime;
            System.out.println("Floyd's algorithm execution time: " + duration + " nanoseconds");

            // Performance should be reasonable (less than 1 second for 10k nodes)
            assertTrue(duration < 1_000_000_000,
                    "Algorithm should complete within reasonable time");
        }
    }

    @Nested
    @DisplayName("Helper Method Tests")
    class HelperMethodTests {

        @Test
        @DisplayName("Test createLinkedListWithCycle method")
        void testCreateLinkedListWithCycle() {
            ListNode head = LinkedListCycle.createLinkedListWithCycle(new int[] {1, 2, 3}, 1);

            assertNotNull(head, "Head should not be null");
            assertEquals(1, head.val, "First node value should be 1");
            assertNotNull(head.next, "Second node should exist");
            assertEquals(2, head.next.val, "Second node value should be 2");
            assertNotNull(head.next.next, "Third node should exist");
            assertEquals(3, head.next.next.val, "Third node value should be 3");
            assertEquals(head.next, head.next.next.next, "Cycle should point back to second node");
        }

        @Test
        @DisplayName("Test createLinkedList method")
        void testCreateLinkedList() {
            ListNode head = LinkedListCycle.createLinkedList(new int[] {1, 2, 3});

            assertNotNull(head, "Head should not be null");
            assertEquals(1, head.val, "First node value should be 1");
            assertNotNull(head.next, "Second node should exist");
            assertEquals(2, head.next.val, "Second node value should be 2");
            assertNotNull(head.next.next, "Third node should exist");
            assertEquals(3, head.next.next.val, "Third node value should be 3");
            assertNull(head.next.next.next, "Last node should point to null");
        }

        @Test
        @DisplayName("Test createLinkedListWithCycle with empty array")
        void testCreateLinkedListWithCycleEmpty() {
            ListNode head = LinkedListCycle.createLinkedListWithCycle(new int[] {}, -1);
            assertNull(head, "Head should be null for empty array");
        }
    }
}
