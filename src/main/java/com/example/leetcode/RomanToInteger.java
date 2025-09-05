package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 13: Roman to Integer
 * 
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * 
 * Symbol Value I 1 V 5 X 10 L 50 C 100 D 500 M 1000
 * 
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as
 * XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * 
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral
 * for four is not IIII. Instead, the number four is written as IV. Because the one is before the
 * five we subtract it making four. The same principle applies to the number nine, which is written
 * as IX.
 * 
 * There are six instances where subtraction is used: - I can be placed before V (5) and X (10) to
 * make 4 and 9. - X can be placed before L (50) and C (100) to make 40 and 90. - C can be placed
 * before D (500) and M (1000) to make 400 and 900.
 * 
 * Given a roman numeral, convert it to an integer.
 * 
 * Examples: Input: s = "III" -> Output: 3 Input: s = "IV" -> Output: 4 Input: s = "IX" -> Output: 9
 * Input: s = "LVIII" -> Output: 58 Input: s = "MCMXCIV" -> Output: 1994
 * 
 * Constraints: - 1 <= s.length <= 15 - s contains only the characters ('I', 'V', 'X', 'L', 'C',
 * 'D', 'M') - It is guaranteed that s is a valid roman numeral in the range [1, 3999]
 */
public class RomanToInteger {

    // ========================================
    // APPROACH 1: LEFT-TO-RIGHT WITH LOOKAHEAD
    // Time: O(n), Space: O(1)
    // ========================================

    /**
     * Approach 1: Left-to-Right with Lookahead (Recommended)
     * 
     * Iterate through the string from left to right. For each character, check if it should be
     * subtracted (current < next) or added (current >= next). This handles subtractive cases
     * naturally by comparing adjacent values.
     * 
     * Key insight: If current value < next value, subtract current; otherwise add current.
     * 
     * Time Complexity: O(n) - Single pass through the string Space Complexity: O(1) - Only using
     * constant extra space
     */
    public int romanToInt(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int result = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int currentValue = getRomanValue(s.charAt(i));

            // Check if we need to subtract (current < next)
            if (i < n - 1 && currentValue < getRomanValue(s.charAt(i + 1))) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
        }

        return result;
    }

    // ========================================
    // APPROACH 2: HASHMAP WITH LOOKAHEAD
    // Time: O(n), Space: O(1)
    // ========================================

    /**
     * Approach 2: HashMap with Lookahead
     * 
     * Similar to approach 1 but uses a HashMap for character-to-value mapping. This approach is
     * more readable and easier to extend if more Roman numerals are added.
     * 
     * Time Complexity: O(n) - Single pass through the string Space Complexity: O(1) - HashMap has
     * constant size (7 entries)
     */
    public int romanToIntWithMap(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> romanMap = createRomanMap();
        int result = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int currentValue = romanMap.get(s.charAt(i));

            // Check if we need to subtract (current < next)
            if (i < n - 1 && currentValue < romanMap.get(s.charAt(i + 1))) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
        }

        return result;
    }

    // ========================================
    // APPROACH 3: RIGHT-TO-LEFT PROCESSING
    // Time: O(n), Space: O(1)
    // ========================================

    /**
     * Approach 3: Right-to-Left Processing
     * 
     * Process the string from right to left, always adding values. If the current value is smaller
     * than the previous value, subtract it instead. This approach avoids lookahead by using the
     * previous value as reference.
     * 
     * Time Complexity: O(n) - Single pass through the string Space Complexity: O(1) - Only using
     * constant extra space
     */
    public int romanToIntRightToLeft(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int result = 0;
        int previousValue = 0;

        // Process from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = getRomanValue(s.charAt(i));

            // If current value is smaller than previous, subtract it
            if (currentValue < previousValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }

            previousValue = currentValue;
        }

        return result;
    }

    // ========================================
    // APPROACH 4: SUBTRACTIVE PAIRS LOOKUP
    // Time: O(n), Space: O(1)
    // ========================================

    /**
     * Approach 4: Subtractive Pairs Lookup
     * 
     * Pre-define all possible subtractive pairs (IV, IX, XL, XC, CD, CM) and check for them first.
     * This approach explicitly handles subtractive cases by looking for two-character patterns
     * before processing single characters.
     * 
     * Time Complexity: O(n) - Single pass through the string Space Complexity: O(1) - Constant
     * space for subtractive pairs map
     */
    public int romanToIntSubtractivePairs(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Map<String, Integer> subtractivePairs = createSubtractivePairsMap();
        Map<Character, Integer> romanMap = createRomanMap();

        int result = 0;
        int i = 0;

        while (i < s.length()) {
            // Check for subtractive pair (two characters)
            if (i < s.length() - 1) {
                String pair = s.substring(i, i + 2);
                if (subtractivePairs.containsKey(pair)) {
                    result += subtractivePairs.get(pair);
                    i += 2; // Skip both characters
                    continue;
                }
            }

            // Single character
            result += romanMap.get(s.charAt(i));
            i++;
        }

        return result;
    }

    // ========================================
    // APPROACH 5: ARRAY-BASED LOOKUP
    // Time: O(n), Space: O(1)
    // ========================================

    /**
     * Approach 5: Array-Based Lookup
     * 
     * Uses an array indexed by character ASCII values for O(1) character-to-value lookup. This
     * approach is the most efficient for character lookups as it avoids HashMap overhead.
     * 
     * Time Complexity: O(n) - Single pass through the string Space Complexity: O(1) - Array has
     * constant size (128 entries for ASCII)
     */
    public int romanToIntArray(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int[] romanValues = createRomanArray();
        int result = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int currentValue = romanValues[s.charAt(i)];

            // Check if we need to subtract (current < next)
            if (i < n - 1 && currentValue < romanValues[s.charAt(i + 1)]) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
        }

        return result;
    }

    // ========================================
    // UTILITY METHODS
    // ========================================

    /**
     * Helper method to get the integer value of a Roman numeral character
     */
    private int getRomanValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    /**
     * Create a HashMap for Roman numeral character to value mapping
     */
    private Map<Character, Integer> createRomanMap() {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        return romanMap;
    }

    /**
     * Create a HashMap for subtractive pairs
     */
    private Map<String, Integer> createSubtractivePairsMap() {
        Map<String, Integer> subtractivePairs = new HashMap<>();
        subtractivePairs.put("IV", 4);
        subtractivePairs.put("IX", 9);
        subtractivePairs.put("XL", 40);
        subtractivePairs.put("XC", 90);
        subtractivePairs.put("CD", 400);
        subtractivePairs.put("CM", 900);
        return subtractivePairs;
    }

    /**
     * Create an array for Roman numeral character to value mapping Uses ASCII values as indices for
     * O(1) lookup
     */
    private int[] createRomanArray() {
        int[] romanValues = new int[128]; // ASCII table size
        romanValues['I'] = 1;
        romanValues['V'] = 5;
        romanValues['X'] = 10;
        romanValues['L'] = 50;
        romanValues['C'] = 100;
        romanValues['D'] = 500;
        romanValues['M'] = 1000;
        return romanValues;
    }

    // ========================================
    // VALIDATION AND UTILITY METHODS
    // ========================================

    /**
     * Validate if a string is a valid Roman numeral
     */
    public boolean isValidRoman(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        // Check if string contains only valid Roman numeral characters
        if (!s.matches("^[IVXLCDM]+$")) {
            return false;
        }

        // Check for invalid repetitions (more than 3 consecutive identical characters for I, X, C,
        // M)
        if (s.matches(".*I{4,}.*") || s.matches(".*X{4,}.*") || s.matches(".*C{4,}.*")
                || s.matches(".*M{4,}.*")) {
            return false;
        }

        // Check for invalid repetitions of V, L, D (these should never repeat)
        if (s.matches(".*V{2,}.*") || s.matches(".*L{2,}.*") || s.matches(".*D{2,}.*")) {
            return false;
        }

        // Check for invalid subtractive combinations
        if (s.matches(".*(IL|IC|ID|IM|XD|XM|VX|VL|VC|VD|VM|LC|LD|LM|DM).*")) {
            return false;
        }

        return true;
    }

    /**
     * Get all subtractive cases
     */
    public String[] getSubtractiveCases() {
        return new String[] {"IV", "IX", "XL", "XC", "CD", "CM"};
    }

    /**
     * Check if a Roman numeral contains subtractive notation
     */
    public boolean hasSubtractiveCase(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }

        String[] subtractiveCases = getSubtractiveCases();
        for (String subCase : subtractiveCases) {
            if (s.contains(subCase)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Analysis method: Get breakdown of Roman numeral conversion
     */
    public String analyzeConversion(String s) {
        if (s == null || s.isEmpty()) {
            return "Invalid input";
        }

        StringBuilder analysis = new StringBuilder();
        analysis.append("Roman: ").append(s).append(" -> ");

        int result = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int currentValue = getRomanValue(s.charAt(i));
            char currentChar = s.charAt(i);

            if (i < n - 1) {
                int nextValue = getRomanValue(s.charAt(i + 1));
                if (currentValue < nextValue) {
                    analysis.append("-").append(currentValue);
                    result -= currentValue;
                } else {
                    analysis.append("+").append(currentValue);
                    result += currentValue;
                }
            } else {
                analysis.append("+").append(currentValue);
                result += currentValue;
            }

            if (i < n - 1) {
                analysis.append(" ");
            }
        }

        analysis.append(" = ").append(result);
        return analysis.toString();
    }

    /**
     * Get the length of a Roman numeral string
     */
    public int getRomanLength(String s) {
        return s != null ? s.length() : 0;
    }

    /**
     * Count occurrences of each Roman numeral character
     */
    public Map<Character, Integer> getCharacterCounts(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        if (s == null) {
            return counts;
        }

        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        return counts;
    }

    /**
     * Performance comparison method
     */
    public void performanceComparison(String s) {
        System.out.println("Performance comparison for: " + s);

        long start, end;

        // Approach 1: Left-to-Right with Lookahead
        start = System.nanoTime();
        int result1 = romanToInt(s);
        end = System.nanoTime();
        System.out.println(
                "Approach 1 (Lookahead): " + result1 + " - Time: " + (end - start) + " ns");

        // Approach 2: HashMap with Lookahead
        start = System.nanoTime();
        int result2 = romanToIntWithMap(s);
        end = System.nanoTime();
        System.out
                .println("Approach 2 (HashMap): " + result2 + " - Time: " + (end - start) + " ns");

        // Approach 3: Right-to-Left Processing
        start = System.nanoTime();
        int result3 = romanToIntRightToLeft(s);
        end = System.nanoTime();
        System.out.println(
                "Approach 3 (Right-to-Left): " + result3 + " - Time: " + (end - start) + " ns");

        // Approach 4: Subtractive Pairs Lookup
        start = System.nanoTime();
        int result4 = romanToIntSubtractivePairs(s);
        end = System.nanoTime();
        System.out.println(
                "Approach 4 (Subtractive Pairs): " + result4 + " - Time: " + (end - start) + " ns");

        // Approach 5: Array-Based Lookup
        start = System.nanoTime();
        int result5 = romanToIntArray(s);
        end = System.nanoTime();
        System.out.println("Approach 5 (Array): " + result5 + " - Time: " + (end - start) + " ns");

        // Verify all approaches produce the same result
        boolean allEqual = (result1 == result2 && result2 == result3 && result3 == result4
                && result4 == result5);
        System.out.println("All approaches produce same result: " + allEqual);
        System.out.println();
    }
}
