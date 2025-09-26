package com.example.leetcode;

import java.util.*;

/**
 * LeetCode #225: Implement Stack using Queues
 * 
 * Problem Description: Implement a last-in-first-out (LIFO) stack using only two queues. The
 * implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
 * 
 * Example 1: Input: ["MyStack", "push", "push", "top", "pop", "empty"] Output: [null, null, null,
 * 2, 2, false]
 * 
 * Constraints: - 1 <= x <= 9 - At most 100 calls will be made to push, pop, top, and empty. - All
 * the calls to pop and top are valid.
 * 
 * @author Superman
 * @version 1.0
 */
public class StackUsingQueues {

    /**
     * Approach 1: Two Queues with Transfer (Recommended) Time Complexity: Push O(n), Pop O(1), Top
     * O(1), Empty O(1) Space Complexity: O(n)
     * 
     * This is the most intuitive approach. We use two queues where q1 maintains the stack order
     * with the newest element at the front, and q2 is used as a temporary buffer during push
     * operations.
     */
    public static class MyStackTwoQueues implements StackInterface {
        private Queue<Integer> q1;
        private Queue<Integer> q2;

        public MyStackTwoQueues() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        public void push(int x) {
            // Add new element to q2
            q2.offer(x);

            // Transfer all elements from q1 to q2
            while (!q1.isEmpty()) {
                q2.offer(q1.poll());
            }

            // Swap q1 and q2 so that q1 has the stack order
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        public int pop() {
            return q1.poll();
        }

        public int top() {
            return q1.peek();
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }

    /**
     * Approach 2: Single Queue with Rotation Time Complexity: Push O(n), Pop O(1), Top O(1), Empty
     * O(1) Space Complexity: O(n)
     * 
     * Uses only one queue by rotating elements to maintain stack order. More space efficient but
     * same time complexity.
     */
    public static class MyStackSingleQueue implements StackInterface {
        private Queue<Integer> queue;

        public MyStackSingleQueue() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.offer(x);

            // Rotate elements to put the new element at the front
            int size = queue.size();
            for (int i = 0; i < size - 1; i++) {
                queue.offer(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

    /**
     * Approach 3: Two Queues with Optimized Transfer Time Complexity: Push O(n), Pop O(1), Top
     * O(1), Empty O(1) Space Complexity: O(n)
     * 
     * Optimized version of the two-queue approach with better variable naming and clearer logic.
     */
    public static class MyStackOptimized implements StackInterface {
        private Queue<Integer> mainQueue;
        private Queue<Integer> helperQueue;

        public MyStackOptimized() {
            mainQueue = new LinkedList<>();
            helperQueue = new LinkedList<>();
        }

        public void push(int x) {
            // Add new element to helper queue
            helperQueue.offer(x);

            // Transfer all elements from main queue to helper queue
            while (!mainQueue.isEmpty()) {
                helperQueue.offer(mainQueue.poll());
            }

            // Swap queues
            Queue<Integer> temp = mainQueue;
            mainQueue = helperQueue;
            helperQueue = temp;
        }

        public int pop() {
            return mainQueue.poll();
        }

        public int top() {
            return mainQueue.peek();
        }

        public boolean empty() {
            return mainQueue.isEmpty();
        }
    }

    /**
     * Approach 4: Array-based Queue Implementation Time Complexity: Push O(n), Pop O(1), Top O(1),
     * Empty O(1) Space Complexity: O(n)
     * 
     * Custom queue implementation using arrays for educational purposes and to understand the
     * underlying mechanics.
     */
    public static class MyStackArrayBased implements StackInterface {
        private int[] queue1;
        private int[] queue2;
        private int front1, rear1, front2, rear2;
        private int capacity;

        public MyStackArrayBased() {
            capacity = 100; // Based on constraint: at most 100 calls
            queue1 = new int[capacity];
            queue2 = new int[capacity];
            front1 = rear1 = front2 = rear2 = 0;
        }

        public void push(int x) {
            // Add to queue2
            queue2[rear2++] = x;

            // Transfer from queue1 to queue2
            while (front1 != rear1) {
                queue2[rear2++] = queue1[front1++];
            }

            // Swap queues
            int[] temp = queue1;
            queue1 = queue2;
            queue2 = temp;

            int tempFront = front1;
            int tempRear = rear1;
            front1 = front2;
            rear1 = rear2;
            front2 = tempFront;
            rear2 = tempRear;

            // Reset the helper queue
            front2 = rear2 = 0;
        }

        public int pop() {
            return queue1[front1++];
        }

        public int top() {
            return queue1[front1];
        }

        public boolean empty() {
            return front1 == rear1;
        }
    }

    /**
     * Approach 5: Deque-based Implementation Time Complexity: Push O(1), Pop O(1), Top O(1), Empty
     * O(1) Space Complexity: O(n)
     * 
     * Uses Java's Deque (double-ended queue) which can simulate both stack and queue operations.
     * This is the most efficient approach but uses a more advanced data structure.
     */
    public static class MyStackDeque implements StackInterface {
        private Deque<Integer> deque;

        public MyStackDeque() {
            deque = new ArrayDeque<>();
        }

        public void push(int x) {
            deque.offerFirst(x);
        }

        public int pop() {
            return deque.pollFirst();
        }

        public int top() {
            return deque.peekFirst();
        }

        public boolean empty() {
            return deque.isEmpty();
        }
    }

    /**
     * Approach 6: LinkedList-based Implementation Time Complexity: Push O(n), Pop O(1), Top O(1),
     * Empty O(1) Space Complexity: O(n)
     * 
     * Uses LinkedList to simulate queue operations with manual element rotation for educational
     * purposes.
     */
    public static class MyStackLinkedList implements StackInterface {
        private LinkedList<Integer> list;

        public MyStackLinkedList() {
            list = new LinkedList<>();
        }

        public void push(int x) {
            list.addLast(x);

            // Rotate to put new element at front
            int size = list.size();
            for (int i = 0; i < size - 1; i++) {
                list.addLast(list.removeFirst());
            }
        }

        public int pop() {
            return list.removeFirst();
        }

        public int top() {
            return list.getFirst();
        }

        public boolean empty() {
            return list.isEmpty();
        }
    }

    /**
     * Main method to demonstrate all approaches
     */
    public static void main(String[] args) {
        System.out.println("=== LeetCode #225: Implement Stack using Queues ===\n");

        // Test cases
        String[] operations = {"push", "push", "push", "top", "pop", "pop", "empty"};
        int[] values = {1, 2, 3, 0, 0, 0, 0}; // 0 means no value needed

        // Test all approaches
        testApproach("Two Queues", new MyStackTwoQueues(), operations, values);
        testApproach("Single Queue", new MyStackSingleQueue(), operations, values);
        testApproach("Optimized Two Queues", new MyStackOptimized(), operations, values);
        testApproach("Array-based", new MyStackArrayBased(), operations, values);
        testApproach("Deque-based", new MyStackDeque(), operations, values);
        testApproach("LinkedList-based", new MyStackLinkedList(), operations, values);

        // Performance comparison
        System.out.println("\n=== Performance Analysis ===");
        performanceComparison();

        // Utility methods demonstration
        System.out.println("\n=== Utility Methods ===");
        demonstrateUtilityMethods();
    }

    /**
     * Test a specific approach
     */
    private static void testApproach(String approachName, StackInterface stack, String[] operations,
            int[] values) {
        System.out.println("Testing " + approachName + ":");
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < operations.length; i++) {
            String op = operations[i];
            Integer result = null;

            switch (op) {
                case "push":
                    stack.push(values[i]);
                    System.out.println("  push(" + values[i] + ") -> null");
                    break;
                case "pop":
                    result = stack.pop();
                    System.out.println("  pop() -> " + result);
                    break;
                case "top":
                    result = stack.top();
                    System.out.println("  top() -> " + result);
                    break;
                case "empty":
                    boolean isEmpty = stack.empty();
                    System.out.println("  empty() -> " + isEmpty);
                    break;
            }

            if (result != null) {
                results.add(result);
            }
        }

        System.out.println("  Results: " + results);
        System.out.println();
    }

    /**
     * Performance comparison between approaches
     */
    private static void performanceComparison() {
        int testSize = 1000;
        String[] operations = new String[testSize];
        int[] values = new int[testSize];

        // Prepare test data
        for (int i = 0; i < testSize; i++) {
            operations[i] = "push";
            values[i] = i;
        }

        // Test each approach
        StackInterface[] stacks =
                {new MyStackTwoQueues(), new MyStackSingleQueue(), new MyStackOptimized(),
                        new MyStackArrayBased(), new MyStackDeque(), new MyStackLinkedList()};
        String[] names =
                {"Two Queues", "Single Queue", "Optimized", "Array-based", "Deque", "LinkedList"};

        for (int i = 0; i < stacks.length; i++) {
            long startTime = System.nanoTime();
            for (int j = 0; j < testSize; j++) {
                stacks[i].push(values[j]);
            }
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds

            System.out.println(names[i] + ": " + duration + " ms for " + testSize + " operations");
        }
    }

    /**
     * Demonstrate utility methods
     */
    private static void demonstrateUtilityMethods() {
        MyStackTwoQueues stack = new MyStackTwoQueues();

        System.out.println("Stack Operations Demo:");
        System.out.println("Initial state - empty: " + stack.empty());

        // Push some elements
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("After pushing 10, 20, 30:");
        System.out.println("  Top: " + stack.top());
        System.out.println("  Empty: " + stack.empty());

        // Pop elements
        System.out.println("Popping: " + stack.pop());
        System.out.println("  Top after pop: " + stack.top());
        System.out.println("  Empty: " + stack.empty());

        System.out.println("Popping: " + stack.pop());
        System.out.println("  Top after pop: " + stack.top());
        System.out.println("  Empty: " + stack.empty());

        System.out.println("Popping: " + stack.pop());
        System.out.println("  Empty after final pop: " + stack.empty());

        // Test stack properties
        System.out.println("\nStack Properties Verification:");
        verifyStackProperties();
    }

    /**
     * Verify that our implementation follows LIFO (Last In, First Out) principle
     */
    public static void verifyStackProperties() {
        MyStackTwoQueues stack = new MyStackTwoQueues();
        List<Integer> pushOrder = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> popOrder = new ArrayList<>();

        // Push elements
        for (int val : pushOrder) {
            stack.push(val);
        }

        // Pop elements
        while (!stack.empty()) {
            popOrder.add(stack.pop());
        }

        // Verify LIFO property
        List<Integer> expectedPopOrder = new ArrayList<>(pushOrder);
        Collections.reverse(expectedPopOrder);

        System.out.println("Push order: " + pushOrder);
        System.out.println("Expected pop order (LIFO): " + expectedPopOrder);
        System.out.println("Actual pop order: " + popOrder);
        System.out.println("LIFO property satisfied: " + expectedPopOrder.equals(popOrder));
    }

    /**
     * Get stack size (utility method)
     */
    public static int getStackSize(StackInterface stack) {
        if (stack.empty()) {
            return 0;
        }

        // Create a temporary stack to count elements
        MyStackTwoQueues tempStack = new MyStackTwoQueues();
        int count = 0;

        // Pop all elements and count them
        while (!stack.empty()) {
            tempStack.push(stack.pop());
            count++;
        }

        // Restore original stack
        while (!tempStack.empty()) {
            stack.push(tempStack.pop());
        }

        return count;
    }

    /**
     * Check if two stacks are equal
     */
    public static boolean areStacksEqual(StackInterface stack1, StackInterface stack2) {
        if (stack1.empty() && stack2.empty()) {
            return true;
        }

        if (stack1.empty() || stack2.empty()) {
            return false;
        }

        // Create temporary stacks to preserve original stacks
        MyStackTwoQueues temp1 = new MyStackTwoQueues();
        MyStackTwoQueues temp2 = new MyStackTwoQueues();
        boolean equal = true;

        // Compare elements
        while (!stack1.empty() && !stack2.empty()) {
            int val1 = stack1.pop();
            int val2 = stack2.pop();

            temp1.push(val1);
            temp2.push(val2);

            if (val1 != val2) {
                equal = false;
                break;
            }
        }

        // Check if both stacks are empty (same size)
        if (equal && (!stack1.empty() || !stack2.empty())) {
            equal = false;
        }

        // Restore original stacks
        while (!temp1.empty()) {
            stack1.push(temp1.pop());
        }
        while (!temp2.empty()) {
            stack2.push(temp2.pop());
        }

        return equal;
    }

    /**
     * Interface for stack operations
     */
    public interface StackInterface {
        void push(int x);

        int pop();

        int top();

        boolean empty();
    }
}
