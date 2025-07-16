package com.example.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LeetCode Problem #3: Longest Substring Without Repeating Characters
 * 
 * Given a string s, find the length of the longest substring without repeating characters.
 * 
 * Examples: - Input: s = "abcabcbb", Output: 3 (The answer is "abc", with length 3) - Input: s =
 * "bbbbb", Output: 1 (The answer is "b", with length 1) - Input: s = "pwwkew", Output: 3 (The
 * answer is "wke", with length 3)
 * 
 * Constraints: - 0 <= s.length <= 5 * 10^4 - s consists of English letters, digits, symbols and
 * spaces.
 */
public class LongestSubstringWithoutRepeating {

    /**
     * Main solution using sliding window with HashMap Time Complexity: O(n) Space Complexity:
     * O(min(m,n)) where m is charset size
     * 
     * @param s input string
     * @return length of longest substring without repeating characters
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If character is already in the window, move left pointer
            if (charIndexMap.containsKey(currentChar)) {
                left = Math.max(left, charIndexMap.get(currentChar) + 1);
            }

            // Update the character's index
            charIndexMap.put(currentChar, right);

            // Update max length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    /**
     * Alternative solution using HashSet (slightly less efficient) Time Complexity: O(n) Space
     * Complexity: O(min(m,n)) where m is charset size
     * 
     * @param s input string
     * @return length of longest substring without repeating characters
     */
    public int lengthOfLongestSubstringHashSet(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Set<Character> window = new HashSet<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            // Shrink window until no duplicates
            while (window.contains(s.charAt(right))) {
                window.remove(s.charAt(left));
                left++;
            }

            // Add current character to window
            window.add(s.charAt(right));

            // Update max length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    /**
     * Brute force solution (for comparison) Time Complexity: O(n^3) Space Complexity: O(min(m,n))
     * 
     * @param s input string
     * @return length of longest substring without repeating characters
     */
    public int lengthOfLongestSubstringBruteForce(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (allUnique(s, i, j)) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }

    /**
     * Helper method for brute force solution
     */
    private boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i <= end; i++) {
            if (set.contains(s.charAt(i))) {
                return false;
            }
            set.add(s.charAt(i));
        }
        return true;
    }

    /**
     * Test method with examples
     */
    public static void main(String[] args) {
        LongestSubstringWithoutRepeating solution = new LongestSubstringWithoutRepeating();

        // Test cases
        String[] testCases = {"abcabcbb", // Expected: 3 ("abc")
                "bbbbb", // Expected: 1 ("b")
                "pwwkew", // Expected: 3 ("wke")
                "", // Expected: 0
                "au", // Expected: 2 ("au")
                "dvdf", // Expected: 3 ("vdf")
                " ", // Expected: 1 (" ")
                "abcdef" // Expected: 6 ("abcdef")
        };

        System.out.println("=== LeetCode: Longest Substring Without Repeating Characters ===");

        for (String testCase : testCases) {
            int result = solution.lengthOfLongestSubstring(testCase);
            int resultHashSet = solution.lengthOfLongestSubstringHashSet(testCase);

            System.out.printf("Input: \"%s\"%n", testCase);
            System.out.printf("Output (HashMap): %d%n", result);
            System.out.printf("Output (HashSet): %d%n", resultHashSet);
            System.out.println("---");
        }

        // Performance comparison for larger input
        String largeInput = "abcdefghijklmnopqrstuvwxyz".repeat(1000);
        long startTime = System.nanoTime();
        int result = solution.lengthOfLongestSubstring(largeInput);
        long endTime = System.nanoTime();

        System.out.printf("Large input test (26000 chars): %d%n", result);
        System.out.printf("Time taken: %.2f ms%n", (endTime - startTime) / 1_000_000.0);
    }
}
