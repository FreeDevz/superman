package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 383: Ransom Note Difficulty: Easy
 * 
 * Problem Description: Given two strings ransomNote and magazine, return true if ransomNote can be
 * constructed by using the letters from magazine and false otherwise. Each letter in magazine can
 * only be used once in ransomNote.
 * 
 * Examples: Example 1: Input: ransomNote = "a", magazine = "b" Output: false
 * 
 * Example 2: Input: ransomNote = "aa", magazine = "ab" Output: false
 * 
 * Example 3: Input: ransomNote = "aa", magazine = "aab" Output: true
 * 
 * Constraints: - 1 <= ransomNote.length, magazine.length <= 10^5 - ransomNote and magazine consist
 * of lowercase English letters.
 * 
 * Tags: Hash Table, String, Counting
 */
public class RansomNote {

    /**
     * Approach 1: HashMap (Frequency Count)
     * 
     * Algorithm: 1. Count frequency of each character in magazine using HashMap 2. For each
     * character in ransomNote: - Check if character exists in magazine with sufficient count -
     * Decrement the count in HashMap 3. If all characters are available, return true; otherwise
     * false
     * 
     * Time Complexity: O(m + n), where m = ransomNote.length, n = magazine.length Space Complexity:
     * O(k), where k = number of unique characters in magazine (max 26 for lowercase letters)
     * 
     * Pros: - Clear and intuitive - Works for any character set - Easy to understand and maintain
     * 
     * Cons: - Additional overhead of HashMap operations - More memory usage compared to array-based
     * approach
     * 
     * @param ransomNote the ransom note string to construct
     * @param magazine the magazine string to use letters from
     * @return true if ransomNote can be constructed from magazine, false otherwise
     */
    public boolean canConstructHashMap(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) {
            return false;
        }

        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        // Count frequency of each character in magazine
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Check if ransomNote can be constructed
        for (char c : ransomNote.toCharArray()) {
            Integer count = charCount.get(c);
            if (count == null || count == 0) {
                return false;
            }
            charCount.put(c, count - 1);
        }

        return true;
    }

    /**
     * Approach 2: Array (Character Frequency Count)
     * 
     * Algorithm: 1. Use an array of size 26 to count frequency of each lowercase letter in magazine
     * 2. For each character in ransomNote: - Decrement the count in array - If count becomes
     * negative, return false 3. If all characters are available, return true
     * 
     * Time Complexity: O(m + n), where m = ransomNote.length, n = magazine.length Space Complexity:
     * O(1), fixed size array of 26 elements
     * 
     * Pros: - Most efficient space complexity (constant space) - Faster than HashMap due to direct
     * array access - No object creation overhead
     * 
     * Cons: - Only works for lowercase English letters - Less flexible for other character sets
     * 
     * @param ransomNote the ransom note string to construct
     * @param magazine the magazine string to use letters from
     * @return true if ransomNote can be constructed from magazine, false otherwise
     */
    public boolean canConstructArray(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) {
            return false;
        }

        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        // Count frequency of each character in magazine
        int[] charCount = new int[26];
        for (char c : magazine.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Check if ransomNote can be constructed
        for (char c : ransomNote.toCharArray()) {
            if (charCount[c - 'a'] == 0) {
                return false;
            }
            charCount[c - 'a']--;
        }

        return true;
    }

    /**
     * Approach 3: Two Arrays (Separate Frequency Counts)
     * 
     * Algorithm: 1. Count frequency of each character in both ransomNote and magazine using
     * separate arrays 2. For each character (a-z): - Check if magazine has at least as many as
     * ransomNote needs 3. Return true if all checks pass
     * 
     * Time Complexity: O(m + n + 26) = O(m + n), where m = ransomNote.length, n = magazine.length
     * Space Complexity: O(1), fixed size arrays (2 * 26 elements)
     * 
     * Pros: - No modification of counts during iteration - Clear separation of concerns - Efficient
     * for small strings
     * 
     * Cons: - Extra space for second array - Extra iteration through alphabet
     * 
     * @param ransomNote the ransom note string to construct
     * @param magazine the magazine string to use letters from
     * @return true if ransomNote can be constructed from magazine, false otherwise
     */
    public boolean canConstructTwoArrays(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) {
            return false;
        }

        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        // Count frequency of each character in both strings
        int[] ransomCount = new int[26];
        int[] magazineCount = new int[26];

        for (char c : ransomNote.toCharArray()) {
            ransomCount[c - 'a']++;
        }

        for (char c : magazine.toCharArray()) {
            magazineCount[c - 'a']++;
        }

        // Check if magazine has sufficient characters
        for (int i = 0; i < 26; i++) {
            if (ransomCount[i] > magazineCount[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * Approach 4: Optimized Single Pass
     * 
     * Algorithm: 1. Count frequency of characters in magazine 2. While counting, also process
     * ransomNote characters 3. Keep track of remaining characters needed from ransomNote
     * 
     * Time Complexity: O(max(m, n)), where m = ransomNote.length, n = magazine.length Space
     * Complexity: O(1), fixed size array of 26 elements
     * 
     * Pros: - Optimized for cases where magazine is much longer than ransomNote - Can early exit
     * when all characters are found
     * 
     * Cons: - More complex logic - Not significantly faster in practice
     * 
     * @param ransomNote the ransom note string to construct
     * @param magazine the magazine string to use letters from
     * @return true if ransomNote can be constructed from magazine, false otherwise
     */
    public boolean canConstructOptimized(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) {
            return false;
        }

        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] count = new int[26];

        // Count characters needed from ransomNote (negative)
        for (char c : ransomNote.toCharArray()) {
            count[c - 'a']--;
        }

        // Add characters from magazine (positive)
        for (char c : magazine.toCharArray()) {
            int idx = c - 'a';
            if (count[idx] < 0) {
                count[idx]++;
            }
        }

        // Check if all characters are satisfied
        for (int i = 0; i < 26; i++) {
            if (count[i] < 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Default method using the most efficient approach
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        return canConstructArray(ransomNote, magazine);
    }

    // ==================== Utility Methods ====================

    /**
     * Prints the frequency count of characters in a string
     * 
     * @param str the input string
     * @return a formatted string showing character frequencies
     */
    public String getCharacterFrequency(String str) {
        if (str == null || str.isEmpty()) {
            return "[]";
        }

        int[] count = new int[26];
        for (char c : str.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean first = true;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append((char) ('a' + i)).append(":").append(count[i]);
                first = false;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Gets the missing characters needed to construct ransomNote from magazine
     * 
     * @param ransomNote the ransom note string
     * @param magazine the magazine string
     * @return a string showing which characters are missing
     */
    public String getMissingCharacters(String ransomNote, String magazine) {
        int[] ransomCount = new int[26];
        int[] magazineCount = new int[26];

        for (char c : ransomNote.toCharArray()) {
            ransomCount[c - 'a']++;
        }

        for (char c : magazine.toCharArray()) {
            magazineCount[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean first = true;
        for (int i = 0; i < 26; i++) {
            if (ransomCount[i] > magazineCount[i]) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append((char) ('a' + i)).append(":");
                sb.append(ransomCount[i] - magazineCount[i]);
                first = false;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        RansomNote solution = new RansomNote();

        // Test Case 1
        String ransomNote1 = "a";
        String magazine1 = "b";
        System.out.println("Test Case 1:");
        System.out.println("ransomNote: " + ransomNote1 + ", magazine: " + magazine1);
        System.out.println("Result: " + solution.canConstruct(ransomNote1, magazine1));
        System.out.println("Expected: false\n");

        // Test Case 2
        String ransomNote2 = "aa";
        String magazine2 = "ab";
        System.out.println("Test Case 2:");
        System.out.println("ransomNote: " + ransomNote2 + ", magazine: " + magazine2);
        System.out.println("Result: " + solution.canConstruct(ransomNote2, magazine2));
        System.out.println("Expected: false\n");

        // Test Case 3
        String ransomNote3 = "aa";
        String magazine3 = "aab";
        System.out.println("Test Case 3:");
        System.out.println("ransomNote: " + ransomNote3 + ", magazine: " + magazine3);
        System.out.println("Result: " + solution.canConstruct(ransomNote3, magazine3));
        System.out.println("Expected: true\n");
    }
}

