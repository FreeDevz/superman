package com.example.leetcode;

/**
 * LeetCode #28: Find the Index of the First Occurrence in a String
 * 
 * Problem Statement: Given two strings needle and haystack, return the index of the first
 * occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * 
 * Constraints: - 1 <= haystack.length, needle.length <= 10^4 - haystack and needle consist of only
 * lowercase English letters.
 * 
 * This solution demonstrates multiple algorithmic approaches: 1. Built-in String.indexOf() - O(n*m)
 * time, O(1) space 2. Brute Force - O(n*m) time, O(1) space 3. KMP Algorithm - O(n+m) time, O(m)
 * space (optimal) 4. Rolling Hash (Rabin-Karp) - O(n+m) average, O(n*m) worst case, O(1) space
 * 
 * @author Superman
 * @version 1.0
 */
public class FindFirstOccurrenceInString {

    /**
     * Approach 1: Built-in String.indexOf() Method
     * 
     * Uses Java's optimized string searching implementation. This is the most practical solution
     * for production code.
     * 
     * Time Complexity: O(n*m) where n = haystack.length, m = needle.length Space Complexity: O(1)
     * 
     * @param haystack The string to search in
     * @param needle The string to search for
     * @return Index of first occurrence or -1 if not found
     */
    public int strStrBuiltIn(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        return haystack.indexOf(needle);
    }

    /**
     * Approach 2: Brute Force String Matching
     * 
     * Compares needle with every possible substring of haystack. Educational approach to understand
     * the basic string matching concept.
     * 
     * Time Complexity: O(n*m) where n = haystack.length, m = needle.length Space Complexity: O(1)
     * 
     * @param haystack The string to search in
     * @param needle The string to search for
     * @return Index of first occurrence or -1 if not found
     */
    public int strStrBruteForce(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }

        int haystackLen = haystack.length();
        int needleLen = needle.length();

        // Edge cases
        if (needleLen == 0) {
            return 0;
        }
        if (needleLen > haystackLen) {
            return -1;
        }

        // Try every possible starting position
        for (int i = 0; i <= haystackLen - needleLen; i++) {
            boolean found = true;

            // Check if needle matches substring starting at position i
            for (int j = 0; j < needleLen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    found = false;
                    break;
                }
            }

            if (found) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Approach 3: KMP (Knuth-Morris-Pratt) Algorithm
     * 
     * Uses the failure function (LPS - Longest Proper Prefix which is also Suffix) to avoid
     * unnecessary character comparisons. This is the optimal solution for string matching problems.
     * 
     * Time Complexity: O(n+m) where n = haystack.length, m = needle.length Space Complexity: O(m)
     * for the failure function array
     * 
     * @param haystack The string to search in
     * @param needle The string to search for
     * @return Index of first occurrence or -1 if not found
     */
    public int strStrKMP(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }

        int haystackLen = haystack.length();
        int needleLen = needle.length();

        // Edge cases
        if (needleLen == 0) {
            return 0;
        }
        if (needleLen > haystackLen) {
            return -1;
        }

        // Build the failure function (LPS array)
        int[] lps = buildFailureFunction(needle);

        int i = 0; // index for haystack
        int j = 0; // index for needle

        while (i < haystackLen) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }

            if (j == needleLen) {
                // Found the pattern
                return i - j;
            } else if (i < haystackLen && haystack.charAt(i) != needle.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return -1;
    }

    /**
     * Builds the failure function (LPS array) for KMP algorithm. LPS[i] = length of the longest
     * proper prefix of needle[0..i] which is also a suffix of needle[0..i].
     * 
     * @param needle The pattern string
     * @return LPS array
     */
    private int[] buildFailureFunction(String needle) {
        int len = needle.length();
        int[] lps = new int[len];
        int lenOfLPS = 0; // length of the previous longest prefix suffix
        int i = 1;

        // lps[0] is always 0
        while (i < len) {
            if (needle.charAt(i) == needle.charAt(lenOfLPS)) {
                lenOfLPS++;
                lps[i] = lenOfLPS;
                i++;
            } else {
                if (lenOfLPS != 0) {
                    lenOfLPS = lps[lenOfLPS - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    /**
     * Approach 4: Rolling Hash (Rabin-Karp Algorithm)
     * 
     * Uses rolling hash to compare substrings efficiently. Average case is O(n+m), but worst case
     * is O(n*m) due to hash collisions.
     * 
     * Time Complexity: O(n+m) average, O(n*m) worst case Space Complexity: O(1)
     * 
     * @param haystack The string to search in
     * @param needle The string to search for
     * @return Index of first occurrence or -1 if not found
     */
    public int strStrRollingHash(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }

        int haystackLen = haystack.length();
        int needleLen = needle.length();

        // Edge cases
        if (needleLen == 0) {
            return 0;
        }
        if (needleLen > haystackLen) {
            return -1;
        }

        // Calculate hash of needle
        long needleHash = calculateHash(needle, 0, needleLen);
        long haystackHash = calculateHash(haystack, 0, needleLen);

        // Base for rolling hash (prime number)
        long base = 256;
        long power = 1;

        // Calculate base^(needleLen-1) for rolling hash
        for (int i = 0; i < needleLen - 1; i++) {
            power = (power * base) % Long.MAX_VALUE;
        }

        // Check first window
        if (haystackHash == needleHash && haystack.substring(0, needleLen).equals(needle)) {
            return 0;
        }

        // Rolling hash for remaining windows
        for (int i = needleLen; i < haystackLen; i++) {
            // Remove leftmost character and add rightmost character
            haystackHash = (haystackHash - haystack.charAt(i - needleLen) * power) % Long.MAX_VALUE;
            haystackHash = (haystackHash * base + haystack.charAt(i)) % Long.MAX_VALUE;

            // Handle negative hash values
            if (haystackHash < 0) {
                haystackHash += Long.MAX_VALUE;
            }

            // Check if hash matches and verify with actual string comparison
            if (haystackHash == needleHash
                    && haystack.substring(i - needleLen + 1, i + 1).equals(needle)) {
                return i - needleLen + 1;
            }
        }

        return -1;
    }

    /**
     * Calculates hash value for a substring.
     * 
     * @param str The input string
     * @param start Starting index
     * @param length Length of substring
     * @return Hash value
     */
    private long calculateHash(String str, int start, int length) {
        long hash = 0;
        long base = 256;

        for (int i = start; i < start + length; i++) {
            hash = (hash * base + str.charAt(i)) % Long.MAX_VALUE;
        }

        return hash;
    }

    /**
     * Approach 5: Optimized Brute Force with Early Termination
     * 
     * Enhanced brute force with optimizations like character frequency checking and early
     * termination conditions.
     * 
     * Time Complexity: O(n*m) worst case, but often much better in practice Space Complexity: O(1)
     * 
     * @param haystack The string to search in
     * @param needle The string to search for
     * @return Index of first occurrence or -1 if not found
     */
    public int strStrOptimizedBruteForce(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }

        int haystackLen = haystack.length();
        int needleLen = needle.length();

        // Edge cases
        if (needleLen == 0) {
            return 0;
        }
        if (needleLen > haystackLen) {
            return -1;
        }

        // Quick check: if needle contains characters not in haystack, return -1
        boolean[] haystackChars = new boolean[26];
        for (char c : haystack.toCharArray()) {
            haystackChars[c - 'a'] = true;
        }

        for (char c : needle.toCharArray()) {
            if (!haystackChars[c - 'a']) {
                return -1;
            }
        }

        // Optimized brute force matching
        for (int i = 0; i <= haystackLen - needleLen; i++) {
            // Quick check: first and last characters must match
            if (haystack.charAt(i) == needle.charAt(0)
                    && haystack.charAt(i + needleLen - 1) == needle.charAt(needleLen - 1)) {

                boolean found = true;
                for (int j = 1; j < needleLen - 1; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        found = false;
                        break;
                    }
                }

                if (found) {
                    return i;
                }
            }
        }

        return -1;
    }

    /**
     * Utility method to demonstrate all approaches and compare results.
     * 
     * @param haystack The string to search in
     * @param needle The string to search for
     */
    public void demonstrateAllApproaches(String haystack, String needle) {
        System.out.println("=== Find First Occurrence in String ===");
        System.out.println("Haystack: \"" + haystack + "\"");
        System.out.println("Needle: \"" + needle + "\"");
        System.out.println();

        long startTime, endTime;

        // Approach 1: Built-in
        startTime = System.nanoTime();
        int result1 = strStrBuiltIn(haystack, needle);
        endTime = System.nanoTime();
        System.out.println("1. Built-in String.indexOf(): " + result1 + " (Time: "
                + (endTime - startTime) / 1000 + " μs)");

        // Approach 2: Brute Force
        startTime = System.nanoTime();
        int result2 = strStrBruteForce(haystack, needle);
        endTime = System.nanoTime();
        System.out.println(
                "2. Brute Force: " + result2 + " (Time: " + (endTime - startTime) / 1000 + " μs)");

        // Approach 3: KMP
        startTime = System.nanoTime();
        int result3 = strStrKMP(haystack, needle);
        endTime = System.nanoTime();
        System.out.println("3. KMP Algorithm: " + result3 + " (Time: "
                + (endTime - startTime) / 1000 + " μs)");

        // Approach 4: Rolling Hash
        startTime = System.nanoTime();
        int result4 = strStrRollingHash(haystack, needle);
        endTime = System.nanoTime();
        System.out.println(
                "4. Rolling Hash: " + result4 + " (Time: " + (endTime - startTime) / 1000 + " μs)");

        // Approach 5: Optimized Brute Force
        startTime = System.nanoTime();
        int result5 = strStrOptimizedBruteForce(haystack, needle);
        endTime = System.nanoTime();
        System.out.println("5. Optimized Brute Force: " + result5 + " (Time: "
                + (endTime - startTime) / 1000 + " μs)");

        // Verify all results are the same
        boolean allMatch = (result1 == result2 && result2 == result3 && result3 == result4
                && result4 == result5);
        System.out.println("\n✅ All approaches produce identical results: " + allMatch);

        if (result1 != -1) {
            System.out.println("Found at index " + result1 + ": \""
                    + haystack.substring(result1, result1 + needle.length()) + "\"");
        } else {
            System.out.println("Needle not found in haystack.");
        }

        System.out.println();
    }

    /**
     * Main method for demonstration and testing.
     */
    public static void main(String[] args) {
        FindFirstOccurrenceInString solution = new FindFirstOccurrenceInString();

        System.out.println("🚀 LeetCode #28: Find the Index of the First Occurrence in a String");
        System.out.println("=".repeat(80));

        // Test cases
        String[][] testCases = {{"sadbutsad", "sad"}, {"leetcode", "leeto"}, {"hello", "ll"},
                {"a", "a"}, {"abc", "c"}, {"mississippi", "issip"}, {"aabaaabaaac", "aabaaac"},
                {"", ""}, {"abc", ""}, {"", "abc"}, {"abcdefghijklmnopqrstuvwxyz", "xyz"},
                {"aaaaaaaaab", "aaab"}, {"ababababab", "ababab"},
                {"thequickbrownfoxjumpsoverthelazydog", "fox"}};

        for (String[] testCase : testCases) {
            solution.demonstrateAllApproaches(testCase[0], testCase[1]);
        }

        System.out.println("🎯 Algorithm Analysis:");
        System.out
                .println("• Built-in: Most practical for production (uses optimized native code)");
        System.out.println("• Brute Force: Educational, easy to understand O(n*m) approach");
        System.out.println("• KMP: Optimal O(n+m) solution, best for repeated searches");
        System.out.println(
                "• Rolling Hash: Good average case, but hash collisions can degrade performance");
        System.out.println(
                "• Optimized Brute Force: Enhanced with early termination and character filtering");
        System.out.println();
        System.out.println(
                "🏆 Recommendation: Use Built-in for production, KMP for interview discussions!");
    }
}
