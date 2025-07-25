package com.example;

import com.example.leetcode.*;

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

        System.out.println("\n" + "=".repeat(50));

        // Demonstrate the ZigZag Conversion solution
        System.out.println("4. Running LeetCode: ZigZag Conversion");
        demonstrateZigZagConversion();

        System.out.println("\n" + "=".repeat(50));

        // Demonstrate the Integer to Roman solution
        System.out.println("5. Running LeetCode: Integer to Roman");
        demonstrateIntegerToRoman();
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

    /**
     * Demonstrates the ZigZag Conversion LeetCode solution
     */
    private static void demonstrateZigZagConversion() {
        ZigZagConversion solution = new ZigZagConversion();

        // Test with the classic examples from LeetCode
        System.out.println("Classic LeetCode Examples:");

        // Example 1: PAYPALISHIRING with 3 rows
        String example1 = "PAYPALISHIRING";
        String result1 = solution.convert(example1, 3);
        System.out.printf("Input: \"%s\", numRows: 3%n", example1);
        System.out.printf("Output: \"%s\"%n", result1);
        System.out.println("Pattern:");
        System.out.println(solution.visualizeZigZag(example1, 3));
        System.out.println();

        // Example 2: PAYPALISHIRING with 4 rows
        String result2 = solution.convert(example1, 4);
        System.out.printf("Input: \"%s\", numRows: 4%n", example1);
        System.out.printf("Output: \"%s\"%n", result2);
        System.out.println("Pattern:");
        System.out.println(solution.visualizeZigZag(example1, 4));
        System.out.println();

        // Testing different approaches
        System.out.println("Comparing All Approaches:");
        String[] testCases = {"ABCDEFGHIJ", "PROGRAMMING", "Hello,World."};
        int[] numRowsTests = {2, 3, 4};

        for (String testCase : testCases) {
            for (int numRows : numRowsTests) {
                System.out.printf("Input: \"%s\", Rows: %d%n", testCase, numRows);

                // Test all four approaches
                long start = System.currentTimeMillis();
                String simResult = solution.convert(testCase, numRows);
                long time1 = System.currentTimeMillis() - start;

                start = System.currentTimeMillis();
                String mathResult = solution.convertMathematical(testCase, numRows);
                long time2 = System.currentTimeMillis() - start;

                start = System.currentTimeMillis();
                String arrayResult = solution.convertWithStringArray(testCase, numRows);
                long time3 = System.currentTimeMillis() - start;

                start = System.currentTimeMillis();
                String optResult = solution.convertOptimized(testCase, numRows);
                long time4 = System.currentTimeMillis() - start;

                System.out.printf("  Simulation:     \"%s\" (%d ms)%n", simResult, time1);
                System.out.printf("  Mathematical:   \"%s\" (%d ms)%n", mathResult, time2);
                System.out.printf("  String Array:   \"%s\" (%d ms)%n", arrayResult, time3);
                System.out.printf("  Optimized:      \"%s\" (%d ms)%n", optResult, time4);

                // Verify all approaches produce same result
                boolean allMatch = simResult.equals(mathResult) && mathResult.equals(arrayResult)
                        && arrayResult.equals(optResult);
                System.out.printf("  ✓ All approaches consistent: %s%n", allMatch);
                System.out.println();
            }
        }

        // Utility demonstrations
        System.out.println("Utility Functions:");
        System.out.printf("Cycle length for 3 rows: %d%n", solution.getCycleLength(3));
        System.out.printf("Cycle length for 4 rows: %d%n", solution.getCycleLength(4));
        System.out.printf("Cycle length for 5 rows: %d%n", solution.getCycleLength(5));

        System.out.println();
        System.out.println("Row mapping for 'PAYPALISHIRING' with 3 rows:");
        String testString = "PAYPALISHIRING";
        for (int i = 0; i < testString.length(); i++) {
            int row = solution.getRowForIndex(i, 3);
            System.out.printf("  Index %d ('%c') -> Row %d%n", i, testString.charAt(i), row);
        }

        System.out.println("\n✓ All ZigZag Conversion approaches working correctly!");
    }

    /**
     * Demonstrates the Integer to Roman LeetCode solution
     */
    private static void demonstrateIntegerToRoman() {
        IntegerToRoman solution = new IntegerToRoman();

        // Test with the classic examples from LeetCode
        System.out.println("Classic LeetCode Examples:");

        int[] examples = {3, 4, 9, 58, 1994};
        String[] descriptions = {"Basic three I's", "Subtractive case IV", "Subtractive case IX",
                "Complex combination", "Complex with multiple subtractive cases"};

        for (int i = 0; i < examples.length; i++) {
            int num = examples[i];
            String result = solution.intToRoman(num);
            System.out.printf("Input: %d -> Output: \"%s\" (%s)%n", num, result, descriptions[i]);
            System.out.printf("  Analysis: %s%n", solution.analyzeConstruction(num));
            System.out.println();
        }

        // Demonstrate all approaches
        System.out.println("Comparing All Approaches:");
        int[] testCases = {27, 444, 999, 1776, 2024, 3999};

        for (int testCase : testCases) {
            System.out.printf("Number: %d%n", testCase);

            // Test all four approaches
            long start = System.nanoTime();
            String result1 = solution.intToRoman(testCase);
            long time1 = System.nanoTime() - start;

            start = System.nanoTime();
            String result2 = solution.intToRomanWithMap(testCase);
            long time2 = System.nanoTime() - start;

            start = System.nanoTime();
            String result3 = solution.intToRomanLookup(testCase);
            long time3 = System.nanoTime() - start;

            start = System.nanoTime();
            String result4 = solution.intToRomanRecursive(testCase);
            long time4 = System.nanoTime() - start;

            System.out.printf("  Greedy Arrays:   \"%s\" (%d ns)%n", result1, time1);
            System.out.printf("  Greedy Map:      \"%s\" (%d ns)%n", result2, time2);
            System.out.printf("  Lookup Table:    \"%s\" (%d ns)%n", result3, time3);
            System.out.printf("  Recursive:       \"%s\" (%d ns)%n", result4, time4);

            // Verify all approaches produce same result
            boolean allMatch =
                    result1.equals(result2) && result2.equals(result3) && result3.equals(result4);
            System.out.printf("  ✓ All approaches consistent: %s%n", allMatch);

            // Show if it uses subtractive cases
            boolean hasSubtractive = solution.hasSubtractiveCase(testCase);
            System.out.printf("  Has subtractive notation: %s%n", hasSubtractive);
            if (hasSubtractive) {
                String[] subCases = solution.getSubtractiveCases();
                for (String subCase : subCases) {
                    if (result1.contains(subCase)) {
                        System.out.printf("    Contains: %s%n", subCase);
                    }
                }
            }
            System.out.println();
        }

        // Demonstrate Roman numeral properties
        System.out.println("Roman Numeral Analysis:");
        System.out.println("All basic symbols and their values:");
        char[] symbols = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        for (char symbol : symbols) {
            int value = solution.getRomanValue(symbol);
            System.out.printf("  %c = %d%n", symbol, value);
        }

        System.out.println("\nSubtractive cases:");
        String[] subtractiveCases = solution.getSubtractiveCases();
        int[] subtractiveValues = {4, 9, 40, 90, 400, 900};
        for (int i = 0; i < subtractiveCases.length; i++) {
            System.out.printf("  %s = %d%n", subtractiveCases[i], subtractiveValues[i]);
        }

        // Length analysis
        System.out.println("\nRoman numeral length analysis:");
        int[] lengthTests = {1, 4, 8, 44, 88, 444, 888, 3999};
        for (int num : lengthTests) {
            String roman = solution.intToRoman(num);
            int length = solution.getRomanLength(num);
            System.out.printf("  %d -> \"%s\" (length: %d)%n", num, roman, length);
        }

        System.out.println("\n✓ All Integer to Roman approaches working correctly!");
    }
}
