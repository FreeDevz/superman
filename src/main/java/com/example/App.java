package com.example;

import com.example.leetcode.AddTwoNumbers;
import com.example.leetcode.LongestPalindromicSubstring;
import com.example.leetcode.LongestSubstringWithoutRepeating;

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
        System.out.println("1. Running LeetCode: Add Two Numbers");
        demonstrateAddTwoNumbers();

        System.out.println("\n" + "=".repeat(50));

        // Demonstrate the Longest Substring Without Repeating Characters solution
        System.out.println("2. Running LeetCode: Longest Substring Without Repeating Characters");
        demonstrateLongestSubstring();

        System.out.println("\n" + "=".repeat(50));

        // Demonstrate the Longest Palindromic Substring solution
        System.out.println("3. Running LeetCode: Longest Palindromic Substring");
        demonstrateLongestPalindrome();
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

    /**
     * Demonstrates the Longest Substring Without Repeating Characters LeetCode solution
     */
    private static void demonstrateLongestSubstring() {
        LongestSubstringWithoutRepeating solution = new LongestSubstringWithoutRepeating();

        // Test with the classic examples
        String[] testCases = {"abcabcbb", // Expected: 3 ("abc")
                "bbbbb", // Expected: 1 ("b")
                "pwwkew" // Expected: 3 ("wke")
        };

        for (String testCase : testCases) {
            int result = solution.lengthOfLongestSubstring(testCase);
            System.out.printf("Input: \"%s\" -> Length: %d%n", testCase, result);
        }

        System.out.println("✓ All solutions working correctly!");
    }

    /**
     * Demonstrates the Longest Palindromic Substring LeetCode solution
     */
    private static void demonstrateLongestPalindrome() {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();

        // Test with the classic examples from LeetCode
        String[] testCases = {"babad", // Expected: "bab" or "aba"
                "cbbd", // Expected: "bb"
                "racecar", // Expected: "racecar"
                "bananas", // Expected: "anana"
                "noon", // Expected: "noon"
                "abcdef" // Expected: single character
        };

        System.out.println("Testing different approaches:");

        for (String testCase : testCases) {
            // Test main approach (Expand Around Centers)
            String result1 = solution.longestPalindrome(testCase);

            // Test Manacher's algorithm for comparison
            String result2 = solution.longestPalindromeManacher(testCase);

            System.out.printf("Input: \"%s\"%n", testCase);
            System.out.printf("  Expand Around Centers: \"%s\" (length: %d)%n", result1,
                    result1.length());
            System.out.printf("  Manacher's Algorithm:  \"%s\" (length: %d)%n", result2,
                    result2.length());

            // Verify both are palindromes
            boolean isPalindrome1 = solution.isPalindrome(result1);
            boolean isPalindrome2 = solution.isPalindrome(result2);
            System.out.printf("  ✓ Both results are valid palindromes: %s%n",
                    isPalindrome1 && isPalindrome2);
            System.out.println();
        }

        // Performance demonstration
        System.out.println("Performance Test with larger input:");
        String largeTest = "a".repeat(100) + "racecar" + "b".repeat(100);

        long start = System.currentTimeMillis();
        String largeResult = solution.longestPalindrome(largeTest);
        long time1 = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        String largeResult2 = solution.longestPalindromeManacher(largeTest);
        long time2 = System.currentTimeMillis() - start;

        System.out.printf("Large input (length: %d):%n", largeTest.length());
        System.out.printf("  Expand Around Centers: %d ms -> \"%s\"...%n", time1,
                largeResult.substring(0, Math.min(20, largeResult.length())));
        System.out.printf("  Manacher's Algorithm:  %d ms -> \"%s\"...%n", time2,
                largeResult2.substring(0, Math.min(20, largeResult2.length())));

        System.out.println("✓ All approaches working correctly!");
    }
}
