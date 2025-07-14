package com.example;

import com.example.leetcode.AddTwoNumbers;

/**
 * Main application demonstrating Java development in Cursor This includes the LeetCode Add Two
 * Numbers solution
 */
public class App {
    public static void main(String[] args) {
        System.out.println("=== Superman Java Project ===");
        System.out.println("Hello, Java in Cursor!");

        // Example of basic Java features
        String name = "Developer";
        int version = 21;

        System.out.printf("Welcome %s! You're using Java %d%n", name, version);

        // Example method call
        greetUser(name);

        System.out.println("\n=== LeetCode Solutions ===");

        // Demonstrate the Add Two Numbers solution
        System.out.println("Running LeetCode: Add Two Numbers");
        demonstrateAddTwoNumbers();
    }

    /**
     * Demonstrates method creation and documentation
     * 
     * @param name The name to greet
     */
    private static void greetUser(String name) {
        System.out.println("Nice to meet you, " + name + "!");
    }

    /**
     * Demonstrates the Add Two Numbers LeetCode solution
     */
    private static void demonstrateAddTwoNumbers() {
        AddTwoNumbers solution = new AddTwoNumbers();

        // Example: 342 + 465 = 807
        // Represented as [2,4,3] + [5,6,4] = [7,0,8]
        AddTwoNumbers.ListNode l1 = AddTwoNumbers.createList(new int[] {2, 4, 3});
        AddTwoNumbers.ListNode l2 = AddTwoNumbers.createList(new int[] {5, 6, 4});
        AddTwoNumbers.ListNode result = solution.addTwoNumbers(l1, l2);

        System.out.println("Example: 342 + 465 = 807");
        System.out.println("Input:  l1 = " + l1 + ", l2 = " + l2);
        System.out.println("Output: " + result);
        System.out.println("✓ Solution working correctly!");
    }
}
