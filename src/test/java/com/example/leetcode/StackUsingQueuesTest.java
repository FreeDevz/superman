package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Comprehensive test suite for LeetCode #225: Implement Stack using Queues
 * 
 * Tests all 6 algorithmic approaches with extensive test cases including: - Basic functionality
 * tests - Edge cases - Performance tests - Cross-validation between approaches - Utility method
 * tests
 * 
 * @author Superman
 * @version 1.0
 */
@DisplayName("Stack Using Queues Tests")
class StackUsingQueuesTest {

    // Test data providers
    static Stream<Object[]> basicOperationsTestCases() {
        return Stream.of(new Object[] {new int[] {1, 2, 3}, new int[] {3, 2, 1}}, // Basic LIFO test
                new Object[] {new int[] {5}, new int[] {5}}, // Single element
                new Object[] {new int[] {1, 2, 3, 4, 5}, new int[] {5, 4, 3, 2, 1}}, // Multiple
                                                                                     // elements
                new Object[] {new int[] {10, 20, 30, 40}, new int[] {40, 30, 20, 10}}, // Different
                                                                                       // values
                new Object[] {new int[] {0, 1, 2, 3, 4}, new int[] {4, 3, 2, 1, 0}} // Zero-based
        );
    }

    static Stream<Object[]> edgeCaseTestCases() {
        return Stream.of(new Object[] {new int[] {}, new int[] {}}, // Empty stack
                new Object[] {new int[] {1}, new int[] {1}}, // Single element
                new Object[] {new int[] {1, 1, 1}, new int[] {1, 1, 1}}, // Duplicate elements
                new Object[] {new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1},
                        new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}}, // Reverse order
                new Object[] {new int[] {1, 2, 3, 2, 1}, new int[] {1, 2, 3, 2, 1}} // Palindrome
                                                                                    // pattern
        );
    }

    static Stream<Object[]> mixedOperationsTestCases() {
        return Stream.of(
                new Object[] {new String[] {"push", "push", "pop", "push", "top", "pop", "empty"},
                        new int[] {1, 2, 0, 3, 0, 0, 0},
                        new Object[] {null, null, 2, null, 3, 3, false}},
                new Object[] {new String[] {"push", "top", "pop", "empty"}, new int[] {5, 0, 0, 0},
                        new Object[] {null, 5, 5, true}},
                new Object[] {
                        new String[] {"push", "push", "push", "top", "pop", "top", "pop", "top",
                                "pop", "empty"},
                        new int[] {10, 20, 30, 0, 0, 0, 0, 0, 0, 0},
                        new Object[] {null, null, null, 30, 30, 20, 20, 10, 10, true}});
    }

    // Approach test methods
    @Nested
    @DisplayName("Two Queues Approach Tests")
    class TwoQueuesApproachTests {

        @ParameterizedTest
        @MethodSource("com.example.leetcode.StackUsingQueuesTest#basicOperationsTestCases")
        @DisplayName("Basic LIFO operations")
        void testBasicOperations(int[] pushValues, int[] expectedPopOrder) {
            StackUsingQueues.MyStackTwoQueues stack = new StackUsingQueues.MyStackTwoQueues();

            // Push all values
            for (int val : pushValues) {
                stack.push(val);
            }

            // Pop and verify order
            for (int expected : expectedPopOrder) {
                assertEquals(expected, stack.pop());
            }

            // Verify stack is empty
            assertTrue(stack.empty());
        }

        @ParameterizedTest
        @MethodSource("com.example.leetcode.StackUsingQueuesTest#edgeCaseTestCases")
        @DisplayName("Edge case operations")
        void testEdgeCases(int[] pushValues, int[] expectedPopOrder) {
            StackUsingQueues.MyStackTwoQueues stack = new StackUsingQueues.MyStackTwoQueues();

            // Push all values
            for (int val : pushValues) {
                stack.push(val);
            }

            // Pop and verify order
            for (int expected : expectedPopOrder) {
                assertEquals(expected, stack.pop());
            }

            // Verify stack is empty
            assertTrue(stack.empty());
        }

        @Test
        @DisplayName("Top operation tests")
        void testTopOperation() {
            StackUsingQueues.MyStackTwoQueues stack = new StackUsingQueues.MyStackTwoQueues();

            // Test top on empty stack
            assertTrue(stack.empty());

            // Push and test top
            stack.push(10);
            assertEquals(10, stack.top());
            assertFalse(stack.empty());

            stack.push(20);
            assertEquals(20, stack.top());

            stack.push(30);
            assertEquals(30, stack.top());

            // Pop and test top
            stack.pop();
            assertEquals(20, stack.top());

            stack.pop();
            assertEquals(10, stack.top());

            stack.pop();
            assertTrue(stack.empty());
        }

        @Test
        @DisplayName("Mixed operations test")
        void testMixedOperations() {
            StackUsingQueues.MyStackTwoQueues stack = new StackUsingQueues.MyStackTwoQueues();

            // Initial state
            assertTrue(stack.empty());

            // Push 1, 2, 3
            stack.push(1);
            stack.push(2);
            stack.push(3);

            // Test top
            assertEquals(3, stack.top());

            // Pop 3
            assertEquals(3, stack.pop());

            // Push 4
            stack.push(4);

            // Test top
            assertEquals(4, stack.top());

            // Pop 4, 2, 1
            assertEquals(4, stack.pop());
            assertEquals(2, stack.pop());
            assertEquals(1, stack.pop());

            // Verify empty
            assertTrue(stack.empty());
        }
    }

    @Nested
    @DisplayName("Single Queue Approach Tests")
    class SingleQueueApproachTests {

        @ParameterizedTest
        @MethodSource("com.example.leetcode.StackUsingQueuesTest#basicOperationsTestCases")
        @DisplayName("Basic LIFO operations")
        void testBasicOperations(int[] pushValues, int[] expectedPopOrder) {
            StackUsingQueues.MyStackSingleQueue stack = new StackUsingQueues.MyStackSingleQueue();

            // Push all values
            for (int val : pushValues) {
                stack.push(val);
            }

            // Pop and verify order
            for (int expected : expectedPopOrder) {
                assertEquals(expected, stack.pop());
            }

            // Verify stack is empty
            assertTrue(stack.empty());
        }

        @Test
        @DisplayName("Top operation tests")
        void testTopOperation() {
            StackUsingQueues.MyStackSingleQueue stack = new StackUsingQueues.MyStackSingleQueue();

            // Test top on empty stack
            assertTrue(stack.empty());

            // Push and test top
            stack.push(10);
            assertEquals(10, stack.top());
            assertFalse(stack.empty());

            stack.push(20);
            assertEquals(20, stack.top());

            stack.push(30);
            assertEquals(30, stack.top());

            // Pop and test top
            stack.pop();
            assertEquals(20, stack.top());

            stack.pop();
            assertEquals(10, stack.top());

            stack.pop();
            assertTrue(stack.empty());
        }

        @Test
        @DisplayName("Mixed operations test")
        void testMixedOperations() {
            StackUsingQueues.MyStackSingleQueue stack = new StackUsingQueues.MyStackSingleQueue();

            // Initial state
            assertTrue(stack.empty());

            // Push 1, 2, 3
            stack.push(1);
            stack.push(2);
            stack.push(3);

            // Test top
            assertEquals(3, stack.top());

            // Pop 3
            assertEquals(3, stack.pop());

            // Push 4
            stack.push(4);

            // Test top
            assertEquals(4, stack.top());

            // Pop 4, 2, 1
            assertEquals(4, stack.pop());
            assertEquals(2, stack.pop());
            assertEquals(1, stack.pop());

            // Verify empty
            assertTrue(stack.empty());
        }
    }

    @Nested
    @DisplayName("Optimized Two Queues Approach Tests")
    class OptimizedTwoQueuesApproachTests {

        @ParameterizedTest
        @MethodSource("com.example.leetcode.StackUsingQueuesTest#basicOperationsTestCases")
        @DisplayName("Basic LIFO operations")
        void testBasicOperations(int[] pushValues, int[] expectedPopOrder) {
            StackUsingQueues.MyStackOptimized stack = new StackUsingQueues.MyStackOptimized();

            // Push all values
            for (int val : pushValues) {
                stack.push(val);
            }

            // Pop and verify order
            for (int expected : expectedPopOrder) {
                assertEquals(expected, stack.pop());
            }

            // Verify stack is empty
            assertTrue(stack.empty());
        }

        @Test
        @DisplayName("Top operation tests")
        void testTopOperation() {
            StackUsingQueues.MyStackOptimized stack = new StackUsingQueues.MyStackOptimized();

            // Test top on empty stack
            assertTrue(stack.empty());

            // Push and test top
            stack.push(10);
            assertEquals(10, stack.top());
            assertFalse(stack.empty());

            stack.push(20);
            assertEquals(20, stack.top());

            stack.push(30);
            assertEquals(30, stack.top());

            // Pop and test top
            stack.pop();
            assertEquals(20, stack.top());

            stack.pop();
            assertEquals(10, stack.top());

            stack.pop();
            assertTrue(stack.empty());
        }
    }

    @Nested
    @DisplayName("Array-based Approach Tests")
    class ArrayBasedApproachTests {

        @ParameterizedTest
        @MethodSource("com.example.leetcode.StackUsingQueuesTest#basicOperationsTestCases")
        @DisplayName("Basic LIFO operations")
        void testBasicOperations(int[] pushValues, int[] expectedPopOrder) {
            StackUsingQueues.MyStackArrayBased stack = new StackUsingQueues.MyStackArrayBased();

            // Push all values
            for (int val : pushValues) {
                stack.push(val);
            }

            // Pop and verify order
            for (int expected : expectedPopOrder) {
                assertEquals(expected, stack.pop());
            }

            // Verify stack is empty
            assertTrue(stack.empty());
        }

        @Test
        @DisplayName("Top operation tests")
        void testTopOperation() {
            StackUsingQueues.MyStackArrayBased stack = new StackUsingQueues.MyStackArrayBased();

            // Test top on empty stack
            assertTrue(stack.empty());

            // Push and test top
            stack.push(10);
            assertEquals(10, stack.top());
            assertFalse(stack.empty());

            stack.push(20);
            assertEquals(20, stack.top());

            stack.push(30);
            assertEquals(30, stack.top());

            // Pop and test top
            stack.pop();
            assertEquals(20, stack.top());

            stack.pop();
            assertEquals(10, stack.top());

            stack.pop();
            assertTrue(stack.empty());
        }

        @Test
        @DisplayName("Capacity constraint test")
        void testCapacityConstraint() {
            StackUsingQueues.MyStackArrayBased stack = new StackUsingQueues.MyStackArrayBased();

            // Test with maximum constraint (100 elements)
            for (int i = 1; i <= 100; i++) {
                stack.push(i);
            }

            // Verify all elements can be popped in reverse order
            for (int i = 100; i >= 1; i--) {
                assertEquals(i, stack.pop());
            }

            assertTrue(stack.empty());
        }
    }

    @Nested
    @DisplayName("Deque-based Approach Tests")
    class DequeBasedApproachTests {

        @ParameterizedTest
        @MethodSource("com.example.leetcode.StackUsingQueuesTest#basicOperationsTestCases")
        @DisplayName("Basic LIFO operations")
        void testBasicOperations(int[] pushValues, int[] expectedPopOrder) {
            StackUsingQueues.MyStackDeque stack = new StackUsingQueues.MyStackDeque();

            // Push all values
            for (int val : pushValues) {
                stack.push(val);
            }

            // Pop and verify order
            for (int expected : expectedPopOrder) {
                assertEquals(expected, stack.pop());
            }

            // Verify stack is empty
            assertTrue(stack.empty());
        }

        @Test
        @DisplayName("Top operation tests")
        void testTopOperation() {
            StackUsingQueues.MyStackDeque stack = new StackUsingQueues.MyStackDeque();

            // Test top on empty stack
            assertTrue(stack.empty());

            // Push and test top
            stack.push(10);
            assertEquals(10, stack.top());
            assertFalse(stack.empty());

            stack.push(20);
            assertEquals(20, stack.top());

            stack.push(30);
            assertEquals(30, stack.top());

            // Pop and test top
            stack.pop();
            assertEquals(20, stack.top());

            stack.pop();
            assertEquals(10, stack.top());

            stack.pop();
            assertTrue(stack.empty());
        }

        @Test
        @DisplayName("Performance test")
        void testPerformance() {
            StackUsingQueues.MyStackDeque stack = new StackUsingQueues.MyStackDeque();

            // Test with large number of operations
            long startTime = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
                stack.push(i);
            }
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds

            // Verify all elements can be popped
            for (int i = 999; i >= 0; i--) {
                assertEquals(i, stack.pop());
            }

            assertTrue(stack.empty());
            assertTrue(duration < 1000); // Should complete in less than 1 second
        }
    }

    @Nested
    @DisplayName("LinkedList-based Approach Tests")
    class LinkedListBasedApproachTests {

        @ParameterizedTest
        @MethodSource("com.example.leetcode.StackUsingQueuesTest#basicOperationsTestCases")
        @DisplayName("Basic LIFO operations")
        void testBasicOperations(int[] pushValues, int[] expectedPopOrder) {
            StackUsingQueues.MyStackLinkedList stack = new StackUsingQueues.MyStackLinkedList();

            // Push all values
            for (int val : pushValues) {
                stack.push(val);
            }

            // Pop and verify order
            for (int expected : expectedPopOrder) {
                assertEquals(expected, stack.pop());
            }

            // Verify stack is empty
            assertTrue(stack.empty());
        }

        @Test
        @DisplayName("Top operation tests")
        void testTopOperation() {
            StackUsingQueues.MyStackLinkedList stack = new StackUsingQueues.MyStackLinkedList();

            // Test top on empty stack
            assertTrue(stack.empty());

            // Push and test top
            stack.push(10);
            assertEquals(10, stack.top());
            assertFalse(stack.empty());

            stack.push(20);
            assertEquals(20, stack.top());

            stack.push(30);
            assertEquals(30, stack.top());

            // Pop and test top
            stack.pop();
            assertEquals(20, stack.top());

            stack.pop();
            assertEquals(10, stack.top());

            stack.pop();
            assertTrue(stack.empty());
        }
    }

    @Nested
    @DisplayName("Cross-Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @ParameterizedTest
        @MethodSource("com.example.leetcode.StackUsingQueuesTest#basicOperationsTestCases")
        @DisplayName("All approaches produce same results for basic operations")
        void testAllApproachesBasicOperations(int[] pushValues, int[] expectedPopOrder) {
            StackUsingQueues.MyStackTwoQueues stack1 = new StackUsingQueues.MyStackTwoQueues();
            StackUsingQueues.MyStackSingleQueue stack2 = new StackUsingQueues.MyStackSingleQueue();
            StackUsingQueues.MyStackOptimized stack3 = new StackUsingQueues.MyStackOptimized();
            StackUsingQueues.MyStackArrayBased stack4 = new StackUsingQueues.MyStackArrayBased();
            StackUsingQueues.MyStackDeque stack5 = new StackUsingQueues.MyStackDeque();
            StackUsingQueues.MyStackLinkedList stack6 = new StackUsingQueues.MyStackLinkedList();

            // Push all values to all stacks
            for (int val : pushValues) {
                stack1.push(val);
                stack2.push(val);
                stack3.push(val);
                stack4.push(val);
                stack5.push(val);
                stack6.push(val);
            }

            // Verify all stacks have same top
            if (pushValues.length > 0) {
                int expectedTop = expectedPopOrder[0];
                assertEquals(expectedTop, stack1.top());
                assertEquals(expectedTop, stack2.top());
                assertEquals(expectedTop, stack3.top());
                assertEquals(expectedTop, stack4.top());
                assertEquals(expectedTop, stack5.top());
                assertEquals(expectedTop, stack6.top());
            }

            // Pop and verify all stacks produce same results
            for (int expected : expectedPopOrder) {
                assertEquals(expected, stack1.pop());
                assertEquals(expected, stack2.pop());
                assertEquals(expected, stack3.pop());
                assertEquals(expected, stack4.pop());
                assertEquals(expected, stack5.pop());
                assertEquals(expected, stack6.pop());
            }

            // Verify all stacks are empty
            assertTrue(stack1.empty());
            assertTrue(stack2.empty());
            assertTrue(stack3.empty());
            assertTrue(stack4.empty());
            assertTrue(stack5.empty());
            assertTrue(stack6.empty());
        }

        @Test
        @DisplayName("Mixed operations consistency test")
        void testMixedOperationsConsistency() {
            StackUsingQueues.MyStackTwoQueues stack1 = new StackUsingQueues.MyStackTwoQueues();
            StackUsingQueues.MyStackSingleQueue stack2 = new StackUsingQueues.MyStackSingleQueue();
            StackUsingQueues.MyStackOptimized stack3 = new StackUsingQueues.MyStackOptimized();

            // Perform mixed operations
            stack1.push(1);
            stack2.push(1);
            stack3.push(1);

            stack1.push(2);
            stack2.push(2);
            stack3.push(2);

            assertEquals(2, stack1.top());
            assertEquals(2, stack2.top());
            assertEquals(2, stack3.top());

            assertEquals(2, stack1.pop());
            assertEquals(2, stack2.pop());
            assertEquals(2, stack3.pop());

            stack1.push(3);
            stack2.push(3);
            stack3.push(3);

            assertEquals(3, stack1.top());
            assertEquals(3, stack2.top());
            assertEquals(3, stack3.top());

            assertEquals(3, stack1.pop());
            assertEquals(3, stack2.pop());
            assertEquals(3, stack3.pop());

            assertEquals(1, stack1.pop());
            assertEquals(1, stack2.pop());
            assertEquals(1, stack3.pop());

            assertTrue(stack1.empty());
            assertTrue(stack2.empty());
            assertTrue(stack3.empty());
        }
    }

    @Nested
    @DisplayName("Utility Method Tests")
    class UtilityMethodTests {

        @Test
        @DisplayName("Stack properties verification")
        void testStackPropertiesVerification() {
            // This test verifies that our implementation follows LIFO principle
            StackUsingQueues.verifyStackProperties();
        }

        @Test
        @DisplayName("Stack size calculation")
        void testStackSizeCalculation() {
            StackUsingQueues.MyStackTwoQueues stack = new StackUsingQueues.MyStackTwoQueues();

            // Test empty stack
            assertEquals(0, StackUsingQueues.getStackSize((StackUsingQueues.StackInterface) stack));

            // Test with elements
            stack.push(1);
            assertEquals(1, StackUsingQueues.getStackSize((StackUsingQueues.StackInterface) stack));

            stack.push(2);
            assertEquals(2, StackUsingQueues.getStackSize((StackUsingQueues.StackInterface) stack));

            stack.push(3);
            assertEquals(3, StackUsingQueues.getStackSize((StackUsingQueues.StackInterface) stack));

            // Test after popping
            stack.pop();
            assertEquals(2, StackUsingQueues.getStackSize((StackUsingQueues.StackInterface) stack));

            stack.pop();
            assertEquals(1, StackUsingQueues.getStackSize((StackUsingQueues.StackInterface) stack));

            stack.pop();
            assertEquals(0, StackUsingQueues.getStackSize((StackUsingQueues.StackInterface) stack));
        }

        @Test
        @DisplayName("Stack equality comparison")
        void testStackEqualityComparison() {
            StackUsingQueues.MyStackTwoQueues stack1 = new StackUsingQueues.MyStackTwoQueues();
            StackUsingQueues.MyStackTwoQueues stack2 = new StackUsingQueues.MyStackTwoQueues();

            // Test empty stacks
            assertTrue(StackUsingQueues.areStacksEqual((StackUsingQueues.StackInterface) stack1,
                    (StackUsingQueues.StackInterface) stack2));

            // Test with same elements
            stack1.push(1);
            stack1.push(2);
            stack1.push(3);

            stack2.push(1);
            stack2.push(2);
            stack2.push(3);

            assertTrue(StackUsingQueues.areStacksEqual((StackUsingQueues.StackInterface) stack1,
                    (StackUsingQueues.StackInterface) stack2));

            // Test with different elements
            StackUsingQueues.MyStackTwoQueues stack3 = new StackUsingQueues.MyStackTwoQueues();
            stack3.push(1);
            stack3.push(2);
            stack3.push(4); // Different element

            assertFalse(StackUsingQueues.areStacksEqual((StackUsingQueues.StackInterface) stack1,
                    (StackUsingQueues.StackInterface) stack3));

            // Test with different sizes
            StackUsingQueues.MyStackTwoQueues stack4 = new StackUsingQueues.MyStackTwoQueues();
            stack4.push(1);
            stack4.push(2);

            assertFalse(StackUsingQueues.areStacksEqual((StackUsingQueues.StackInterface) stack1,
                    (StackUsingQueues.StackInterface) stack4));
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Large stack performance test")
        void testLargeStackPerformance() {
            StackUsingQueues.MyStackTwoQueues stack = new StackUsingQueues.MyStackTwoQueues();

            // Test with large number of elements
            int testSize = 1000;
            long startTime = System.nanoTime();

            for (int i = 0; i < testSize; i++) {
                stack.push(i);
            }

            long endTime = System.nanoTime();
            long pushDuration = (endTime - startTime) / 1_000_000; // Convert to milliseconds

            // Verify all elements can be popped
            startTime = System.nanoTime();
            for (int i = testSize - 1; i >= 0; i--) {
                assertEquals(i, stack.pop());
            }
            endTime = System.nanoTime();
            long popDuration = (endTime - startTime) / 1_000_000;

            assertTrue(stack.empty());
            assertTrue(pushDuration < 1000); // Should complete in less than 1 second
            assertTrue(popDuration < 100); // Pop should be very fast
        }

        @Test
        @DisplayName("Memory efficiency test")
        void testMemoryEfficiency() {
            // Test with maximum constraint (100 elements)
            StackUsingQueues.MyStackArrayBased stack = new StackUsingQueues.MyStackArrayBased();

            // Push maximum number of elements
            for (int i = 1; i <= 100; i++) {
                stack.push(i);
            }

            // Verify all elements can be popped
            for (int i = 100; i >= 1; i--) {
                assertEquals(i, stack.pop());
            }

            assertTrue(stack.empty());
        }
    }

    @Nested
    @DisplayName("Edge Case Tests")
    class EdgeCaseTests {

        @Test
        @DisplayName("Empty stack operations")
        void testEmptyStackOperations() {
            StackUsingQueues.MyStackTwoQueues stack = new StackUsingQueues.MyStackTwoQueues();

            // Test operations on empty stack
            assertTrue(stack.empty());

            // Note: pop() and top() on empty stack would throw exception in real implementation
            // but our test framework doesn't test for exceptions in this case
        }

        @Test
        @DisplayName("Single element operations")
        void testSingleElementOperations() {
            StackUsingQueues.MyStackTwoQueues stack = new StackUsingQueues.MyStackTwoQueues();

            // Push single element
            stack.push(42);
            assertFalse(stack.empty());
            assertEquals(42, stack.top());
            assertEquals(42, stack.pop());
            assertTrue(stack.empty());
        }

        @Test
        @DisplayName("Duplicate elements test")
        void testDuplicateElements() {
            StackUsingQueues.MyStackTwoQueues stack = new StackUsingQueues.MyStackTwoQueues();

            // Push duplicate elements
            stack.push(1);
            stack.push(1);
            stack.push(1);

            // Pop and verify
            assertEquals(1, stack.pop());
            assertEquals(1, stack.pop());
            assertEquals(1, stack.pop());
            assertTrue(stack.empty());
        }

        @Test
        @DisplayName("Maximum constraint test")
        void testMaximumConstraint() {
            StackUsingQueues.MyStackTwoQueues stack = new StackUsingQueues.MyStackTwoQueues();

            // Test with maximum constraint (100 elements)
            for (int i = 1; i <= 100; i++) {
                stack.push(i);
            }

            // Verify all elements can be popped in reverse order
            for (int i = 100; i >= 1; i--) {
                assertEquals(i, stack.pop());
            }

            assertTrue(stack.empty());
        }
    }

    @Nested
    @DisplayName("Parameterized Tests")
    class ParameterizedTests {

        @ParameterizedTest
        @CsvSource({"1, 1", "2, 2", "3, 3", "10, 10", "100, 100"})
        @DisplayName("Single element push and pop")
        void testSingleElementPushPop(int pushValue, int expectedPopValue) {
            StackUsingQueues.MyStackTwoQueues stack = new StackUsingQueues.MyStackTwoQueues();

            stack.push(pushValue);
            assertEquals(expectedPopValue, stack.top());
            assertEquals(expectedPopValue, stack.pop());
            assertTrue(stack.empty());
        }

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3, 4, 5, 10, 20, 50, 100})
        @DisplayName("Variable size stack operations")
        void testVariableSizeStackOperations(int size) {
            StackUsingQueues.MyStackTwoQueues stack = new StackUsingQueues.MyStackTwoQueues();

            // Push elements
            for (int i = 1; i <= size; i++) {
                stack.push(i);
            }

            // Verify top
            assertEquals(size, stack.top());

            // Pop all elements
            for (int i = size; i >= 1; i--) {
                assertEquals(i, stack.pop());
            }

            assertTrue(stack.empty());
        }
    }
}
