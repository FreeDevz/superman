package com.example.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 1763: Longest Nice Substring
 * 
 * Problem Description: A string s is nice if, for every letter of the alphabet that s contains, it
 * appears both in uppercase and lowercase. For example, "abABB" is nice because 'A' and 'a' appear,
 * and 'B' and 'b' appear. However, "abA" is not nice because 'b' appears, but 'B' does not.
 * 
 * Given a string s, return the longest substring of s that is nice. If there are multiple, return
 * the substring of the earliest occurrence. If there are none, return an empty string.
 * 
 * Example 1: Input: s = "YazaAay" Output: "aAa" Explanation: "aAa" is a nice string because 'A/a'
 * is the only letter of the alphabet in s, and hence 'A' and 'a' both appear. "aAa" is the longest
 * nice substring.
 * 
 * Example 2: Input: s = "Bb" Output: "Bb" Explanation: "Bb" is a nice string because both 'B' and
 * 'b' appear. The whole string is a substring.
 * 
 * Example 3: Input: s = "c" Output: "" Explanation: There are no nice substrings.
 * 
 * Constraints: - 1 <= s.length <= 100 - s consists of uppercase and lowercase English letters.
 * 
 * Time Complexity Analysis: - Divide and Conquer: O(n^2) time, O(n) space - Sliding Window: O(n^2)
 * time, O(1) space - Brute Force: O(n^3) time, O(n) space
 */
public class LongestNiceSubstring {

    /**
     * Approach 1: Divide and Conquer (Recommended)
     * 
     * Time Complexity: O(n^2) where n is the length of string Space Complexity: O(n) for recursion
     * stack
     * 
     * Strategy: For each character that doesn't have both uppercase and lowercase versions, split
     * the string at that position and recursively find the longest nice substring in both parts.
     * Return the longer of the two results.
     */
    public String longestNiceSubstringDivideAndConquer(String s) {
        return helper(s);
    }

    private String helper(String s) {
        if (s.length() < 2) {
            return "";
        }

        Set<Character> charSet = new HashSet<>();
        for (char c : s.toCharArray()) {
            charSet.add(c);
        }

        // Find the first character that doesn't have both cases
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!charSet.contains(Character.toLowerCase(c))
                    || !charSet.contains(Character.toUpperCase(c))) {

                // Split at this character and recurse
                String left = helper(s.substring(0, i));
                String right = helper(s.substring(i + 1));

                // Return the longer substring, or left if equal length (earliest occurrence)
                return left.length() >= right.length() ? left : right;
            }
        }

        // If we reach here, the entire string is nice
        return s;
    }

    /**
     * Approach 2: Sliding Window with Character Set Check
     * 
     * Time Complexity: O(n^2) where n is the length of string Space Complexity: O(1) - only using
     * constant extra space
     * 
     * Strategy: Use sliding window to check all possible substrings. For each substring, verify
     * that every character has both uppercase and lowercase versions.
     */
    public String longestNiceSubstringSlidingWindow(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                if (isNice(substring) && substring.length() > result.length()) {
                    result = substring;
                }
            }
        }

        return result;
    }

    /**
     * Approach 3: Brute Force with Early Termination
     * 
     * Time Complexity: O(n^3) where n is the length of string Space Complexity: O(n) for the set
     * 
     * Strategy: Check all possible substrings and find the longest nice one. Uses early termination
     * when checking if a substring is nice.
     */
    public String longestNiceSubstringBruteForce(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                if (isNiceBruteForce(substring) && substring.length() > result.length()) {
                    result = substring;
                }
            }
        }

        return result;
    }

    /**
     * Approach 4: Optimized Divide and Conquer with Set Reuse
     * 
     * Time Complexity: O(n^2) where n is the length of string Space Complexity: O(n) for recursion
     * stack
     * 
     * Strategy: Similar to divide and conquer but optimizes by reusing character sets and avoiding
     * redundant checks.
     */
    public String longestNiceSubstringOptimized(String s) {
        return optimizedHelper(s, 0, s.length());
    }

    private String optimizedHelper(String s, int start, int end) {
        if (end - start < 2) {
            return "";
        }

        Set<Character> charSet = new HashSet<>();
        for (int i = start; i < end; i++) {
            charSet.add(s.charAt(i));
        }

        // Find split points
        for (int i = start; i < end; i++) {
            char c = s.charAt(i);
            if (!charSet.contains(Character.toLowerCase(c))
                    || !charSet.contains(Character.toUpperCase(c))) {

                String left = optimizedHelper(s, start, i);
                String right = optimizedHelper(s, i + 1, end);

                return left.length() >= right.length() ? left : right;
            }
        }

        // Entire substring is nice
        return s.substring(start, end);
    }

    /**
     * Helper method to check if a substring is nice using set operations
     */
    private boolean isNice(String s) {
        if (s.length() < 2) {
            return false;
        }

        Set<Character> charSet = new HashSet<>();
        for (char c : s.toCharArray()) {
            charSet.add(c);
        }

        for (char c : charSet) {
            if (!charSet.contains(Character.toLowerCase(c))
                    || !charSet.contains(Character.toUpperCase(c))) {
                return false;
            }
        }

        return true;
    }

    /**
     * Helper method to check if a substring is nice using brute force
     */
    private boolean isNiceBruteForce(String s) {
        if (s.length() < 2) {
            return false;
        }

        boolean[] hasLower = new boolean[26];
        boolean[] hasUpper = new boolean[26];

        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                hasLower[c - 'a'] = true;
            } else {
                hasUpper[c - 'A'] = true;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (hasLower[i] != hasUpper[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * Approach 5: Two-Pass Approach
     * 
     * Time Complexity: O(n^2) where n is the length of string Space Complexity: O(n) for the set
     * 
     * Strategy: First pass to identify all characters that don't have both cases, second pass to
     * find the longest substring without these "bad" characters.
     */
    public String longestNiceSubstringTwoPass(String s) {
        Set<Character> badChars = new HashSet<>();

        // First pass: identify characters that don't have both cases
        Set<Character> allChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            allChars.add(c);
        }

        for (char c : allChars) {
            if (!allChars.contains(Character.toLowerCase(c))
                    || !allChars.contains(Character.toUpperCase(c))) {
                badChars.add(c);
            }
        }

        if (badChars.isEmpty()) {
            return s; // Entire string is nice
        }

        // Second pass: find longest substring without bad characters
        String result = "";
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            if (badChars.contains(s.charAt(i))) {
                if (i > start) {
                    String substring = s.substring(start, i);
                    if (substring.length() > result.length()) {
                        result = substring;
                    }
                }
                start = i + 1;
            }
        }

        // Check the last substring
        if (start < s.length()) {
            String substring = s.substring(start);
            if (substring.length() > result.length()) {
                result = substring;
            }
        }

        // Recursively check the result
        return result.length() >= 2 ? longestNiceSubstringTwoPass(result) : "";
    }

    /**
     * Utility method to demonstrate the problem with examples
     */
    public void demonstrateExamples() {
        System.out.println("=== Longest Nice Substring Examples ===");

        String[] examples = {"YazaAay", // Expected: "aAa"
                "Bb", // Expected: "Bb"
                "c", // Expected: ""
                "abABB", // Expected: "abABB"
                "abA", // Expected: ""
                "dDzeE", // Expected: "dD"
                "aAaAa" // Expected: "aAaAa"
        };

        for (String example : examples) {
            String result = longestNiceSubstringDivideAndConquer(example);
            System.out.printf("Input: \"%s\" -> Output: \"%s\"\n", example, result);
        }
    }
}
