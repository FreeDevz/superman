package com.example.leetcode;

import java.util.*;

/**
 * LeetCode #205: Isomorphic Strings
 * 
 * Problem Description: Given two strings s and t, determine if they are isomorphic. Two strings s
 * and t are isomorphic if the characters in s can be replaced to get t. All occurrences of a
 * character must be replaced with another character while preserving the order of characters. No
 * two characters may map to the same character, but a character may map to itself.
 * 
 * Example 1: Input: s = "egg", t = "add" Output: true
 * 
 * Example 2: Input: s = "foo", t = "bar" Output: false
 * 
 * Example 3: Input: s = "paper", t = "title" Output: true
 * 
 * Constraints: - 1 <= s.length <= 5 * 10^4 - t.length == s.length - s and t consist of any valid
 * ascii character.
 * 
 * @author Superman
 * @version 1.0
 */
public class IsomorphicStrings {

    /**
     * Approach 1: Two HashMaps (Recommended) Time Complexity: O(n) Space Complexity: O(1) - at most
     * 256 characters (ASCII)
     * 
     * This is the most intuitive and commonly used approach for interviews. We maintain two
     * mappings: s->t and t->s to ensure bijection.
     */
    public static boolean isIsomorphicHashMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Check if s->t mapping is consistent
            if (sToT.containsKey(charS)) {
                if (sToT.get(charS) != charT) {
                    return false;
                }
            } else {
                sToT.put(charS, charT);
            }

            // Check if t->s mapping is consistent
            if (tToS.containsKey(charT)) {
                if (tToS.get(charT) != charS) {
                    return false;
                }
            } else {
                tToS.put(charT, charS);
            }
        }

        return true;
    }

    /**
     * Approach 2: Array-based Mapping (Most Efficient) Time Complexity: O(n) Space Complexity: O(1)
     * - fixed size arrays
     * 
     * Uses arrays instead of HashMaps for better performance. Assumes ASCII characters (0-255).
     */
    public static boolean isIsomorphicArray(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] sToT = new int[256];
        int[] tToS = new int[256];
        Arrays.fill(sToT, -1);
        Arrays.fill(tToS, -1);

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Check if s->t mapping is consistent
            if (sToT[charS] != -1) {
                if (sToT[charS] != charT) {
                    return false;
                }
            } else {
                sToT[charS] = charT;
            }

            // Check if t->s mapping is consistent
            if (tToS[charT] != -1) {
                if (tToS[charT] != charS) {
                    return false;
                }
            } else {
                tToS[charT] = charS;
            }
        }

        return true;
    }

    /**
     * Approach 3: Single HashMap with Bijection Check Time Complexity: O(n) Space Complexity: O(1)
     * - at most 256 characters
     * 
     * Uses a single HashMap but checks both directions in one pass.
     */
    public static boolean isIsomorphicSingleMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> mapping = new HashMap<>();
        Set<Character> mapped = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (mapping.containsKey(charS)) {
                // Check if existing mapping is consistent
                if (mapping.get(charS) != charT) {
                    return false;
                }
            } else {
                // Check if target character is already mapped to another character
                if (mapped.contains(charT)) {
                    return false;
                }
                mapping.put(charS, charT);
                mapped.add(charT);
            }
        }

        return true;
    }

    /**
     * Approach 4: Character Position Mapping Time Complexity: O(n) Space Complexity: O(1) - at most
     * 256 characters
     * 
     * Maps characters to their first occurrence positions. Two strings are isomorphic if they have
     * the same position pattern.
     */
    public static boolean isIsomorphicPosition(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sPositions = new HashMap<>();
        Map<Character, Integer> tPositions = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Get or put first occurrence position
            final int index = i;
            int sPos = sPositions.computeIfAbsent(charS, k -> index);
            int tPos = tPositions.computeIfAbsent(charT, k -> index);

            // Characters must have same first occurrence position
            if (sPos != tPos) {
                return false;
            }
        }

        return true;
    }

    /**
     * Approach 5: String Transformation Time Complexity: O(n) Space Complexity: O(n)
     * 
     * Transforms both strings to a normalized form and compares them. Educational approach showing
     * isomorphism concept.
     */
    public static boolean isIsomorphicTransform(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        return transformString(s).equals(transformString(t));
    }

    private static String transformString(String str) {
        Map<Character, Integer> charToIndex = new HashMap<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!charToIndex.containsKey(c)) {
                charToIndex.put(c, charToIndex.size());
            }
            result.append(charToIndex.get(c)).append(" ");
        }

        return result.toString();
    }

    /**
     * Approach 6: Optimized Array with Early Termination Time Complexity: O(n) Space Complexity:
     * O(1)
     * 
     * Most efficient approach with early termination optimizations.
     */
    public static boolean isIsomorphicOptimized(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] sToT = new int[256];
        int[] tToS = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Check both mappings in one condition
            if ((sToT[charS] != 0 && sToT[charS] != charT)
                    || (tToS[charT] != 0 && tToS[charT] != charS)) {
                return false;
            }

            sToT[charS] = charT;
            tToS[charT] = charS;
        }

        return true;
    }

    /**
     * Main method to demonstrate all approaches
     */
    public static void main(String[] args) {
        System.out.println("=== LeetCode #205: Isomorphic Strings ===\n");

        // Test cases
        String[][] testCases = {{"egg", "add"}, {"foo", "bar"}, {"paper", "title"}, {"ab", "aa"},
                {"ab", "ca"}, {"a", "a"}, {"a", "b"}, {"", ""},
                {"abcdefghijklmnopqrstuvwxyz", "bcdefghijklmnopqrstuvwxyza"}};

        // Approach names
        String[] approachNames = {"HashMap (Recommended)", "Array-based", "Single HashMap",
                "Position Mapping", "String Transform", "Optimized Array"};

        // Approach functions
        @SuppressWarnings("unchecked")
        java.util.function.BiFunction<String, String, Boolean>[] approaches =
                new java.util.function.BiFunction[] {
                        (s, t) -> isIsomorphicHashMap((String) s, (String) t),
                        (s, t) -> isIsomorphicArray((String) s, (String) t),
                        (s, t) -> isIsomorphicSingleMap((String) s, (String) t),
                        (s, t) -> isIsomorphicPosition((String) s, (String) t),
                        (s, t) -> isIsomorphicTransform((String) s, (String) t),
                        (s, t) -> isIsomorphicOptimized((String) s, (String) t)};

        // Test all approaches
        for (String[] testCase : testCases) {
            String s = testCase[0];
            String t = testCase[1];

            System.out.println("Input: s = \"" + s + "\", t = \"" + t + "\"");

            boolean[] results = new boolean[approaches.length];
            for (int i = 0; i < approaches.length; i++) {
                results[i] = approaches[i].apply(s, t);
                System.out.println("  " + approachNames[i] + ": " + results[i]);
            }

            // Verify all approaches give same result
            boolean allSame = true;
            for (int i = 1; i < results.length; i++) {
                if (results[i] != results[0]) {
                    allSame = false;
                    break;
                }
            }
            System.out.println("  ✓ All approaches consistent: " + allSame);
            System.out.println();
        }

        // Performance comparison
        System.out.println("=== Performance Analysis ===");
        String longS = "abcdefghijklmnopqrstuvwxyz".repeat(1000);
        String longT = "bcdefghijklmnopqrstuvwxyza".repeat(1000);

        for (int i = 0; i < approaches.length; i++) {
            final int index = i;
            long startTime = System.nanoTime();
            approaches[index].apply(longS, longT);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds

            System.out.println(approachNames[index] + ": " + duration + " ms");
        }

        // Utility methods demonstration
        System.out.println("\n=== Utility Methods ===");
        demonstrateUtilityMethods();
    }

    /**
     * Demonstrate utility methods
     */
    private static void demonstrateUtilityMethods() {
        String s = "paper";
        String t = "title";

        System.out.println("String Analysis:");
        System.out.println("  s = \"" + s + "\"");
        System.out.println("  t = \"" + t + "\"");
        System.out.println("  Length: " + s.length());
        System.out.println("  Unique chars in s: " + getUniqueCharCount(s));
        System.out.println("  Unique chars in t: " + getUniqueCharCount(t));
        System.out.println("  Character frequency analysis:");
        printCharFrequency(s, "s");
        printCharFrequency(t, "t");

        System.out.println("\nMapping Analysis:");
        printCharacterMapping(s, t);
    }

    /**
     * Get count of unique characters in string
     */
    public static int getUniqueCharCount(String str) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : str.toCharArray()) {
            uniqueChars.add(c);
        }
        return uniqueChars.size();
    }

    /**
     * Print character frequency analysis
     */
    public static void printCharFrequency(String str, String label) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : str.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        System.out.println("    " + label + ": " + frequency);
    }

    /**
     * Print character mapping between two strings
     */
    public static void printCharacterMapping(String s, String t) {
        if (s.length() != t.length()) {
            System.out.println("  Strings have different lengths");
            return;
        }

        Map<Character, Character> mapping = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            if (!mapping.containsKey(charS)) {
                mapping.put(charS, charT);
            }
        }

        System.out.println("  Character mapping: " + mapping);
        System.out.println("  Is bijection: " + isBijection(mapping));
    }

    /**
     * Check if mapping is a bijection (one-to-one and onto)
     */
    public static boolean isBijection(Map<Character, Character> mapping) {
        Set<Character> values = new HashSet<>(mapping.values());
        return mapping.size() == values.size();
    }

    /**
     * Find isomorphic pattern in string
     */
    public static String findIsomorphicPattern(String str) {
        Map<Character, Integer> charToIndex = new HashMap<>();
        StringBuilder pattern = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (!charToIndex.containsKey(c)) {
                charToIndex.put(c, charToIndex.size());
            }
            pattern.append(charToIndex.get(c));
        }

        return pattern.toString();
    }

    /**
     * Check if two strings have same isomorphic pattern
     */
    public static boolean hasSamePattern(String s, String t) {
        return findIsomorphicPattern(s).equals(findIsomorphicPattern(t));
    }
}
