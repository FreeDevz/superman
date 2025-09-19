package com.example.leetcode;

/**
 * LeetCode 38: Count and Say
 * 
 * Problem Description: The count-and-say sequence is a sequence of digit strings defined by the
 * recursive formula: - countAndSay(1) = "1" - countAndSay(n) is the way you would "say" the digit
 * string from countAndSay(n-1), which is then converted into a different digit string.
 * 
 * To determine how you "say" a digit string, split it into the minimal number of substrings such
 * that each substring contains exactly one unique digit. Then for each substring, say the number of
 * digits, then say the digit. Finally, concatenate every said digit.
 * 
 * For example, the saying and conversion for digit string "3322251": - Two 3's, three 2's, one 5,
 * and one 1 - 2 3 + 3 2 + 1 5 + 1 1 - "23321511"
 * 
 * Given a positive integer n, return the nth term of the count-and-say sequence.
 * 
 * Example 1: Input: n = 1 Output: "1"
 * 
 * Example 2: Input: n = 4 Output: "1211" Explanation: countAndSay(1) = "1" countAndSay(2) = say "1"
 * = one 1 = "11" countAndSay(3) = say "11" = two 1's = "21" countAndSay(4) = say "21" = one 2 + one
 * 1 = "12" + "11" = "1211"
 * 
 * Constraints: - 1 <= n <= 30
 * 
 * Approach Analysis: This is a sequence generation problem where each term is derived by describing
 * the previous term. The key insight is to count consecutive digits and represent them as "count +
 * digit" pairs.
 * 
 * Time Complexity: O(n * m) where n is the input and m is the maximum length of sequence Space
 * Complexity: O(m) for storing the sequence strings
 */
public class CountAndSay {

    /**
     * Approach 1: Iterative String Building (Recommended)
     * 
     * Builds the sequence iteratively by analyzing each term and constructing the next one. Uses
     * StringBuilder for efficient string concatenation.
     * 
     * Time: O(n * m) Space: O(m)
     */
    public String countAndSayIterative(int n) {
        if (n == 1) {
            return "1";
        }

        String result = "1";

        for (int i = 2; i <= n; i++) {
            result = buildNextTerm(result);
        }

        return result;
    }

    /**
     * Approach 2: Recursive with Memoization
     * 
     * Uses recursion to build the sequence, with memoization to avoid redundant calculations. More
     * intuitive but uses more stack space.
     * 
     * Time: O(n * m) Space: O(n * m) including recursion stack
     */
    public String countAndSayRecursive(int n) {
        if (n == 1) {
            return "1";
        }

        String previous = countAndSayRecursive(n - 1);
        return buildNextTerm(previous);
    }

    /**
     * Approach 3: Optimized Iterative with Pre-allocation
     * 
     * Similar to iterative approach but with optimized string building and pre-allocation of
     * StringBuilder capacity based on estimated length.
     * 
     * Time: O(n * m) Space: O(m)
     */
    public String countAndSayOptimized(int n) {
        if (n == 1) {
            return "1";
        }

        String result = "1";

        for (int i = 2; i <= n; i++) {
            result = buildNextTermOptimized(result);
        }

        return result;
    }

    /**
     * Approach 4: Character Array Approach
     * 
     * Uses character arrays instead of strings for potentially better performance in some
     * scenarios, especially for large sequences.
     * 
     * Time: O(n * m) Space: O(m)
     */
    public String countAndSayCharArray(int n) {
        if (n == 1) {
            return "1";
        }

        char[] current = {'1'};

        for (int i = 2; i <= n; i++) {
            current = buildNextTermCharArray(current);
        }

        return new String(current);
    }

    /**
     * Approach 5: Two-Pointer Technique
     * 
     * Uses two pointers to efficiently count consecutive digits without creating intermediate
     * strings during the counting process.
     * 
     * Time: O(n * m) Space: O(m)
     */
    public String countAndSayTwoPointers(int n) {
        if (n == 1) {
            return "1";
        }

        String result = "1";

        for (int i = 2; i <= n; i++) {
            result = buildNextTermTwoPointers(result);
        }

        return result;
    }

    /**
     * Helper method to build the next term from the current term
     */
    private String buildNextTerm(String current) {
        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 1; i < current.length(); i++) {
            if (current.charAt(i) == current.charAt(i - 1)) {
                count++;
            } else {
                result.append(count).append(current.charAt(i - 1));
                count = 1;
            }
        }

        // Add the last group
        result.append(count).append(current.charAt(current.length() - 1));

        return result.toString();
    }

    /**
     * Optimized version of buildNextTerm with pre-allocation
     */
    private String buildNextTermOptimized(String current) {
        // Estimate capacity: worst case is 2 * current length (all different digits)
        int estimatedCapacity = current.length() * 2;
        StringBuilder result = new StringBuilder(estimatedCapacity);
        int count = 1;

        for (int i = 1; i < current.length(); i++) {
            if (current.charAt(i) == current.charAt(i - 1)) {
                count++;
            } else {
                result.append(count).append(current.charAt(i - 1));
                count = 1;
            }
        }

        // Add the last group
        result.append(count).append(current.charAt(current.length() - 1));

        return result.toString();
    }

    /**
     * Build next term using character arrays
     */
    private char[] buildNextTermCharArray(char[] current) {
        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 1; i < current.length; i++) {
            if (current[i] == current[i - 1]) {
                count++;
            } else {
                result.append(count).append(current[i - 1]);
                count = 1;
            }
        }

        // Add the last group
        result.append(count).append(current[current.length - 1]);

        return result.toString().toCharArray();
    }

    /**
     * Build next term using two-pointer technique
     */
    private String buildNextTermTwoPointers(String current) {
        StringBuilder result = new StringBuilder();
        int left = 0;

        while (left < current.length()) {
            int right = left;
            // Count consecutive same digits
            while (right < current.length() && current.charAt(right) == current.charAt(left)) {
                right++;
            }

            int count = right - left;
            result.append(count).append(current.charAt(left));
            left = right;
        }

        return result.toString();
    }

    /**
     * Utility method to generate the entire sequence up to n terms
     */
    public String[] generateSequence(int n) {
        String[] sequence = new String[n];
        sequence[0] = "1";

        for (int i = 1; i < n; i++) {
            sequence[i] = buildNextTerm(sequence[i - 1]);
        }

        return sequence;
    }

    /**
     * Utility method to analyze a term and return its composition
     */
    public String analyzeTerm(String term) {
        StringBuilder analysis = new StringBuilder();
        int count = 1;

        for (int i = 1; i < term.length(); i++) {
            if (term.charAt(i) == term.charAt(i - 1)) {
                count++;
            } else {
                analysis.append(count).append(" ").append(term.charAt(i - 1)).append("'s, ");
                count = 1;
            }
        }

        // Add the last group
        analysis.append(count).append(" ").append(term.charAt(term.length() - 1)).append("'s");

        return analysis.toString();
    }

    /**
     * Utility method to get the length of the nth term
     */
    public int getTermLength(int n) {
        return countAndSayIterative(n).length();
    }

    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        CountAndSay solution = new CountAndSay();

        // Test cases
        int[] testCases = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("Testing Count and Say Solutions:");
        System.out.println("=================================");

        for (int n : testCases) {
            String result1 = solution.countAndSayIterative(n);
            String result2 = solution.countAndSayRecursive(n);
            String result3 = solution.countAndSayOptimized(n);
            String result4 = solution.countAndSayCharArray(n);
            String result5 = solution.countAndSayTwoPointers(n);

            System.out.printf("n = %d:\n", n);
            System.out.printf("Iterative: %s\n", result1);
            System.out.printf("Recursive: %s\n", result2);
            System.out.printf("Optimized: %s\n", result3);
            System.out.printf("CharArray: %s\n", result4);
            System.out.printf("TwoPointers: %s\n", result5);
            System.out.printf("Analysis: %s\n", solution.analyzeTerm(result1));
            System.out.println("---");
        }

        // Generate and display the first 10 terms
        System.out.println("First 10 terms of the sequence:");
        String[] sequence = solution.generateSequence(10);
        for (int i = 0; i < sequence.length; i++) {
            System.out.printf("Term %d: %s (length: %d)\n", i + 1, sequence[i],
                    sequence[i].length());
        }
    }
}
