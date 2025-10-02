package com.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 242: Valid Anagram
 * 
 * Problem Description: Given two strings s and t, return true if t is an anagram of s, and false
 * otherwise. An Anagram is a word or phrase formed by rearranging the letters of a different word
 * or phrase, typically using all the original letters exactly once.
 * 
 * Example 1: Input: s = "anagram", t = "nagaram" Output: true
 * 
 * Example 2: Input: s = "rat", t = "car" Output: false
 * 
 * Constraints: - 1 <= s.length, t.length <= 5 * 10^4 - s and t consist of lowercase English
 * letters.
 * 
 * Follow-up: What if the inputs contain Unicode characters? How would you adapt your solution?
 * 
 * Time Complexity Analysis: - Sorting Approach: O(n log n) time, O(n) space - HashMap Approach:
 * O(n) time, O(n) space - Array Counter Approach: O(n) time, O(1) space - Single Array Counter:
 * O(n) time, O(1) space
 */
public class ValidAnagram {

    /**
     * Approach 1: Sorting (Straightforward)
     * 
     * Time Complexity: O(n log n) where n = s.length() Space Complexity: O(n) for char arrays
     * 
     * Strategy: Sort both strings and compare if they are equal.
     */
    public boolean isAnagramSorting(String s, String t) {
        // Early exit: if lengths differ, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Convert to char arrays and sort
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);

        // Compare sorted arrays
        return Arrays.equals(sArr, tArr);
    }

    /**
     * Approach 2: HashMap/Hash Table (Frequency Counter)
     * 
     * Time Complexity: O(n) where n = s.length() Space Complexity: O(k) where k is the number of
     * unique characters
     * 
     * Strategy: Count frequency of each character in s, then decrement for each character in t. If
     * all counts are zero, they are anagrams.
     */
    public boolean isAnagramHashMap(String s, String t) {
        // Early exit: if lengths differ, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Count character frequencies in s
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Decrement counts for characters in t
        for (char c : t.toCharArray()) {
            if (!charCount.containsKey(c)) {
                return false; // Character in t not present in s
            }
            int count = charCount.get(c);
            if (count == 0) {
                return false; // More occurrences of c in t than in s
            }
            charCount.put(c, count - 1);
        }

        // All counts should be zero if strings are anagrams
        for (int count : charCount.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Approach 3: Array Counter (Optimized for lowercase English letters)
     * 
     * Time Complexity: O(n) where n = s.length() Space Complexity: O(1) - fixed size array of 26
     * elements
     * 
     * Strategy: Use a fixed-size array (26 for lowercase English letters) to count character
     * frequencies.
     */
    public boolean isAnagramArrayCounter(String s, String t) {
        // Early exit: if lengths differ, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Array to count frequency of each letter (a-z)
        int[] count = new int[26];

        // Increment for characters in s, decrement for characters in t
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // All counts should be zero if strings are anagrams
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Approach 4: Two Array Counters
     * 
     * Time Complexity: O(n) where n = s.length() Space Complexity: O(1) - two fixed size arrays of
     * 26 elements
     * 
     * Strategy: Count frequencies separately for both strings and compare the arrays.
     */
    public boolean isAnagramTwoArrays(String s, String t) {
        // Early exit: if lengths differ, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Arrays to count frequency of each letter (a-z)
        int[] sCount = new int[26];
        int[] tCount = new int[26];

        // Count character frequencies
        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            tCount[t.charAt(i) - 'a']++;
        }

        // Compare frequency arrays
        return Arrays.equals(sCount, tCount);
    }

    /**
     * Approach 5: Unicode-friendly HashMap Approach
     * 
     * Time Complexity: O(n) where n = s.length() Space Complexity: O(k) where k is the number of
     * unique characters
     * 
     * Strategy: Similar to Approach 2 but explicitly handles Unicode characters. This works for any
     * character set, not just lowercase English letters.
     */
    public boolean isAnagramUnicode(String s, String t) {
        // Early exit: if lengths differ, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Use HashMap to handle any Unicode character
        Map<Character, Integer> charCount = new HashMap<>();

        // Count all characters in s
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Decrement for all characters in t
        for (char c : t.toCharArray()) {
            Integer count = charCount.get(c);
            if (count == null || count == 0) {
                return false;
            }
            charCount.put(c, count - 1);
        }

        return true;
    }

    /**
     * Approach 6: Single Pass HashMap (Optimized)
     * 
     * Time Complexity: O(n) where n = s.length() Space Complexity: O(k) where k is the number of
     * unique characters
     * 
     * Strategy: Increment counter for s characters, decrement for t characters, check all zero at
     * the end.
     */
    public boolean isAnagramSinglePassHashMap(String s, String t) {
        // Early exit: if lengths differ, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> charCount = new HashMap<>();

        // Single pass: increment for s, decrement for t
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            charCount.put(sChar, charCount.getOrDefault(sChar, 0) + 1);
            charCount.put(tChar, charCount.getOrDefault(tChar, 0) - 1);
        }

        // Check if all counts are zero
        for (int count : charCount.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Default method using the most efficient approach for lowercase English letters
     */
    public boolean isAnagram(String s, String t) {
        return isAnagramArrayCounter(s, t);
    }

    /**
     * Utility method to validate if strings contain only lowercase English letters
     */
    public boolean isLowercaseEnglish(String s) {
        for (char c : s.toCharArray()) {
            if (c < 'a' || c > 'z') {
                return false;
            }
        }
        return true;
    }

    /**
     * Smart method that chooses the best approach based on input characteristics
     */
    public boolean isAnagramSmart(String s, String t) {
        // Early exit: if lengths differ, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Check if both strings contain only lowercase English letters
        boolean isLowercase = isLowercaseEnglish(s) && isLowercaseEnglish(t);

        // Use array counter for lowercase English, HashMap for Unicode
        if (isLowercase) {
            return isAnagramArrayCounter(s, t);
        } else {
            return isAnagramUnicode(s, t);
        }
    }

    /**
     * Approach 7: Optimized Array Counter with Early Exit
     * 
     * Time Complexity: O(n) where n = s.length() Space Complexity: O(1) - fixed size array of 26
     * elements
     * 
     * Strategy: Similar to array counter but with early exit optimization when we detect a
     * mismatch.
     */
    public boolean isAnagramArrayCounterOptimized(String s, String t) {
        // Early exit: if lengths differ, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        int uniqueChars = 0; // Track number of unique characters
        int matchedChars = 0; // Track number of characters with count = 0

        // Process string s
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            if (count[index] == 0) {
                uniqueChars++;
            }
            count[index]++;
        }

        // Process string t with early exit
        for (char c : t.toCharArray()) {
            int index = c - 'a';
            count[index]--;

            if (count[index] == 0) {
                matchedChars++;
                // Early exit: if all unique chars are matched
                if (matchedChars == uniqueChars) {
                    return true;
                }
            } else if (count[index] < 0) {
                // Early exit: character in t appears more than in s
                return false;
            }
        }

        return matchedChars == uniqueChars;
    }
}

