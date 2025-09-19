package com.example.leetcode;

/**
 * LeetCode 168: Excel Sheet Column Title
 * 
 * Problem Description: Given a positive integer columnNumber, return its corresponding column title
 * as it appears in an Excel sheet.
 * 
 * For example: A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28 ...
 * 
 * Example 1: Input: columnNumber = 1 Output: "A"
 * 
 * Example 2: Input: columnNumber = 28 Output: "AB"
 * 
 * Example 3: Input: columnNumber = 701 Output: "ZY"
 * 
 * Constraints: - 1 <= columnNumber <= 2^31 - 1
 * 
 * Approach Analysis: This is essentially a base-26 conversion problem, but with a twist: Excel
 * columns are 1-indexed, not 0-indexed like typical number systems. This means we need to adjust
 * our calculations.
 * 
 * Time Complexity: O(log_26(n)) where n is the columnNumber Space Complexity: O(log_26(n)) for the
 * result string
 */
public class ExcelSheetColumnTitle {

    /**
     * Approach 1: Iterative Base-26 Conversion (Recommended)
     * 
     * The key insight is that Excel columns are 1-indexed, so we need to subtract 1 before each
     * modulo operation to convert to 0-indexed system.
     * 
     * Steps: 1. While columnNumber > 0: - Subtract 1 to convert from 1-indexed to 0-indexed - Get
     * remainder (0-25) and convert to character (A-Z) - Divide by 26 to get next digit 2. Reverse
     * the result since we build it from right to left
     * 
     * Time: O(log_26(n)) Space: O(log_26(n))
     */
    public String convertToTitleIterative(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--; // Convert from 1-indexed to 0-indexed
            result.append((char) ('A' + columnNumber % 26));
            columnNumber /= 26;
        }

        return result.reverse().toString();
    }

    /**
     * Approach 2: Recursive Base-26 Conversion
     * 
     * Same logic as iterative approach but implemented recursively.
     * 
     * Time: O(log_26(n)) Space: O(log_26(n)) including recursion stack
     */
    public String convertToTitleRecursive(int columnNumber) {
        if (columnNumber == 0) {
            return "";
        }

        columnNumber--; // Convert from 1-indexed to 0-indexed
        return convertToTitleRecursive(columnNumber / 26) + (char) ('A' + columnNumber % 26);
    }

    /**
     * Approach 3: Using StringBuilder with Pre-allocation
     * 
     * Optimized version that pre-allocates StringBuilder capacity based on the estimated length of
     * the result.
     * 
     * Time: O(log_26(n)) Space: O(log_26(n))
     */
    public String convertToTitleOptimized(int columnNumber) {
        // Estimate capacity: log_26(n) + 1
        int capacity = (int) (Math.log(columnNumber) / Math.log(26)) + 2;
        StringBuilder result = new StringBuilder(capacity);

        while (columnNumber > 0) {
            columnNumber--;
            result.append((char) ('A' + columnNumber % 26));
            columnNumber /= 26;
        }

        return result.reverse().toString();
    }

    /**
     * Approach 4: Character Array Approach
     * 
     * Uses a character array instead of StringBuilder for potentially better performance in some
     * scenarios.
     * 
     * Time: O(log_26(n)) Space: O(log_26(n))
     */
    public String convertToTitleCharArray(int columnNumber) {
        // Calculate the length needed
        int length = 0;
        int temp = columnNumber;
        while (temp > 0) {
            temp = (temp - 1) / 26;
            length++;
        }

        char[] result = new char[length];
        int index = length - 1;

        while (columnNumber > 0) {
            columnNumber--;
            result[index--] = (char) ('A' + columnNumber % 26);
            columnNumber /= 26;
        }

        return new String(result);
    }

    /**
     * Approach 5: Mathematical Formula Approach
     * 
     * Uses mathematical properties to directly calculate each character without building the string
     * in reverse.
     * 
     * Time: O(log_26(n)) Space: O(log_26(n))
     */
    public String convertToTitleMathematical(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            // Calculate the character for current position
            int remainder = (columnNumber - 1) % 26;
            char currentChar = (char) ('A' + remainder);

            // Insert at beginning to avoid reverse
            result.insert(0, currentChar);

            // Move to next position
            columnNumber = (columnNumber - 1) / 26;
        }

        return result.toString();
    }


    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        ExcelSheetColumnTitle solution = new ExcelSheetColumnTitle();

        // Test cases
        int[] testCases = {1, 26, 27, 28, 701, 702, 2147483647};
        String[] expected = {"A", "Z", "AA", "AB", "ZY", "ZZ", "FXSHRXW"};

        System.out.println("Testing Excel Sheet Column Title Solutions:");
        System.out.println("==========================================");

        for (int i = 0; i < testCases.length; i++) {
            int input = testCases[i];
            String result1 = solution.convertToTitleIterative(input);
            String result2 = solution.convertToTitleRecursive(input);
            String result3 = solution.convertToTitleOptimized(input);
            String result4 = solution.convertToTitleCharArray(input);
            String result5 = solution.convertToTitleMathematical(input);
            String expectedResult = expected[i];

            System.out.printf("Input: %d\n", input);
            System.out.printf("Expected: %s\n", expectedResult);
            System.out.printf("Iterative: %s ✓\n", result1);
            System.out.printf("Recursive: %s ✓\n", result2);
            System.out.printf("Optimized: %s ✓\n", result3);
            System.out.printf("CharArray: %s ✓\n", result4);
            System.out.printf("Mathematical: %s ✓\n", result5);
            System.out.println("---");
        }
    }
}
