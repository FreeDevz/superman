package com.example.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LeetCode 12: Integer to Roman
 * 
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * 
 * Symbol Value I 1 V 5 X 10 L 50 C 100 D 500 M 1000
 * 
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as
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
 * Examples: Input: num = 3 -> Output: "III" Input: num = 4 -> Output: "IV" Input: num = 9 ->
 * Output: "IX" Input: num = 58 -> Output: "LVIII" Input: num = 1994 -> Output: "MCMXCIV"
 * 
 * Constraints: - 1 <= num <= 3999
 */
public class IntegerToRoman {

    // ========================================
    // APPROACH 1: GREEDY WITH ARRAYS
    // Time: O(1), Space: O(1)
    // ========================================

    /**
     * Approach 1: Greedy with Parallel Arrays (Recommended)
     * 
     * Uses two parallel arrays containing values and symbols in descending order. Greedily
     * subtracts the largest possible values and builds the result.
     * 
     * Key insight: Include subtractive cases (IV, IX, XL, XC, CD, CM) in the mapping to handle them
     * naturally in the greedy approach.
     * 
     * Time Complexity: O(1) - Fixed number of operations (at most 13 iterations) Space Complexity:
     * O(1) - Constant space for arrays and result
     */
    public String intToRoman(int num) {
        // Values in descending order, including subtractive cases
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            // Use as many of this symbol as possible
            while (num >= values[i]) {
                num -= values[i];
                result.append(symbols[i]);
            }

            // Early termination when num becomes 0
            if (num == 0) {
                break;
            }
        }

        return result.toString();
    }

    // ========================================
    // APPROACH 2: GREEDY WITH MAP
    // Time: O(1), Space: O(1)
    // ========================================

    /**
     * Approach 2: Greedy with LinkedHashMap
     * 
     * Similar to approach 1 but uses a LinkedHashMap to maintain insertion order. This approach is
     * more readable and easier to modify.
     * 
     * Time Complexity: O(1) - Fixed number of operations Space Complexity: O(1) - Constant space
     * for map and result
     */
    public String intToRomanWithMap(int num) {
        // LinkedHashMap maintains insertion order
        Map<Integer, String> valueToSymbol = new LinkedHashMap<>();
        valueToSymbol.put(1000, "M");
        valueToSymbol.put(900, "CM");
        valueToSymbol.put(500, "D");
        valueToSymbol.put(400, "CD");
        valueToSymbol.put(100, "C");
        valueToSymbol.put(90, "XC");
        valueToSymbol.put(50, "L");
        valueToSymbol.put(40, "XL");
        valueToSymbol.put(10, "X");
        valueToSymbol.put(9, "IX");
        valueToSymbol.put(5, "V");
        valueToSymbol.put(4, "IV");
        valueToSymbol.put(1, "I");

        StringBuilder result = new StringBuilder();

        for (Map.Entry<Integer, String> entry : valueToSymbol.entrySet()) {
            int value = entry.getKey();
            String symbol = entry.getValue();

            while (num >= value) {
                num -= value;
                result.append(symbol);
            }

            if (num == 0) {
                break;
            }
        }

        return result.toString();
    }

    // ========================================
    // APPROACH 3: DIGIT-BY-DIGIT LOOKUP
    // Time: O(1), Space: O(1)
    // ========================================

    /**
     * Approach 3: Digit-by-Digit Lookup
     * 
     * Pre-computes all possible Roman numeral representations for each digit position (thousands,
     * hundreds, tens, ones) and directly looks up the result.
     * 
     * This approach is very fast as it requires only 4 array lookups and concatenations.
     * 
     * Time Complexity: O(1) - Only 4 operations Space Complexity: O(1) - Pre-computed lookup tables
     */
    public String intToRomanLookup(int num) {
        // Pre-computed lookup tables for each digit position
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return thousands[num / 1000] + hundreds[(num % 1000) / 100] + tens[(num % 100) / 10]
                + ones[num % 10];
    }

    // ========================================
    // APPROACH 4: RECURSIVE APPROACH
    // Time: O(1), Space: O(1)
    // ========================================

    /**
     * Approach 4: Recursive Approach
     * 
     * Recursively breaks down the number by finding the largest Roman numeral that fits and
     * recursively processing the remainder.
     * 
     * This approach demonstrates recursion but is not more efficient than iterative approaches.
     * 
     * Time Complexity: O(1) - Fixed recursion depth Space Complexity: O(1) - Recursion stack is
     * bounded
     */
    public String intToRomanRecursive(int num) {
        return intToRomanHelper(num);
    }

    private String intToRomanHelper(int num) {
        if (num == 0) {
            return "";
        }

        // Find the largest value that fits
        if (num >= 1000)
            return "M" + intToRomanHelper(num - 1000);
        if (num >= 900)
            return "CM" + intToRomanHelper(num - 900);
        if (num >= 500)
            return "D" + intToRomanHelper(num - 500);
        if (num >= 400)
            return "CD" + intToRomanHelper(num - 400);
        if (num >= 100)
            return "C" + intToRomanHelper(num - 100);
        if (num >= 90)
            return "XC" + intToRomanHelper(num - 90);
        if (num >= 50)
            return "L" + intToRomanHelper(num - 50);
        if (num >= 40)
            return "XL" + intToRomanHelper(num - 40);
        if (num >= 10)
            return "X" + intToRomanHelper(num - 10);
        if (num >= 9)
            return "IX" + intToRomanHelper(num - 9);
        if (num >= 5)
            return "V" + intToRomanHelper(num - 5);
        if (num >= 4)
            return "IV" + intToRomanHelper(num - 4);
        return "I" + intToRomanHelper(num - 1);
    }

    // ========================================
    // UTILITY METHODS
    // ========================================

    /**
     * Helper method to validate if a string is a valid Roman numeral Useful for testing and
     * verification
     */
    public boolean isValidRoman(String roman) {
        if (roman == null || roman.isEmpty()) {
            return false;
        }

        // Check if string contains only valid Roman numeral characters
        if (!roman.matches("^[IVXLCDM]+$")) {
            return false;
        }

        // Additional validation for proper Roman numeral rules
        // This is a simple validation - for a complete validator, we'd need more complex rules

        // Check for invalid repetitions (more than 3 consecutive identical characters for I, X, C,
        // M)
        if (roman.matches(".*I{4,}.*") || roman.matches(".*X{4,}.*") || roman.matches(".*C{4,}.*")
                || roman.matches(".*M{4,}.*")) {
            return false; // More than 3 consecutive I, X, C, or M
        }

        // Check for invalid repetitions of V, L, D (these should never repeat the same character)
        if (roman.matches(".*V{2,}.*") || roman.matches(".*L{2,}.*")
                || roman.matches(".*D{2,}.*")) {
            return false; // V, L, D should not repeat themselves
        }

        // Check for invalid subtractive combinations
        // Valid: IV, IX, XL, XC, CD, CM
        // Invalid patterns like IL, IC, XD, XM, etc.
        if (roman.matches(".*(IL|IC|ID|IM|XD|XM|VX|VL|VC|VD|VM|LC|LD|LM|DM).*")) {
            return false; // Invalid subtractive combinations
        }

        // For our purposes, if it passes these basic checks, consider it valid
        // A complete Roman numeral validator would be much more complex
        return true;
    }

    /**
     * Helper method to get the integer value of a Roman numeral character
     */
    public int getRomanValue(char c) {
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
     * Helper method to count the length of Roman numeral for a given number Useful for analysis and
     * optimization
     */
    public int getRomanLength(int num) {
        return intToRoman(num).length();
    }

    /**
     * Helper method to get all subtractive cases
     */
    public String[] getSubtractiveCases() {
        return new String[] {"IV", "IX", "XL", "XC", "CD", "CM"};
    }

    /**
     * Helper method to check if a number requires subtractive notation
     */
    public boolean hasSubtractiveCase(int num) {
        String roman = intToRoman(num);
        String[] subtractiveCases = getSubtractiveCases();

        for (String subCase : subtractiveCases) {
            if (roman.contains(subCase)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Analysis method: Get breakdown of Roman numeral construction
     */
    public String analyzeConstruction(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder analysis = new StringBuilder();
        analysis.append("Number: ").append(num).append(" -> ");

        StringBuilder result = new StringBuilder();
        int remaining = num;

        for (int i = 0; i < values.length; i++) {
            int count = remaining / values[i];
            if (count > 0) {
                if (analysis.length() > analysis.indexOf(" -> ") + 4) {
                    analysis.append(" + ");
                }
                analysis.append(count).append("×").append(symbols[i]);

                // Add the symbol 'count' times to result
                for (int j = 0; j < count; j++) {
                    result.append(symbols[i]);
                }
                remaining -= count * values[i];
            }
        }

        analysis.append(" = ").append(result.toString());
        return analysis.toString();
    }
}
