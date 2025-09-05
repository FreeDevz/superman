package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * LeetCode 20: Valid Parentheses
 * 
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the
 * input string is valid.
 * 
 * An input string is valid if: 1. Open brackets must be closed by the same type of brackets. 2.
 * Open brackets must be closed in the correct order. 3. Every close bracket has a corresponding
 * open bracket of the same type.
 * 
 * Examples: Input: s = "()" Output: true
 * 
 * Input: s = "()[]{}" Output: true
 * 
 * Input: s = "(]" Output: false
 * 
 * Input: s = "([)]" Output: false
 * 
 * Input: s = "{[]}" Output: true
 * 
 * Constraints: - 1 <= s.length <= 10^4 - s consists of only parentheses characters '()[]{}'.
 */
public class ValidParentheses {

    // ========================================
    // APPROACH 1: STACK (RECOMMENDED)
    // Time: O(n), Space: O(n) where n is string length
    // ========================================

    /**
     * Approach 1: Stack-based Validation
     * 
     * This is the most efficient and commonly used approach for validating parentheses.
     * 
     * Algorithm: 1. Use a stack to keep track of opening brackets 2. For each character: - If it's
     * an opening bracket, push to stack - If it's a closing bracket, check if stack is empty or top
     * doesn't match 3. At the end, stack should be empty for valid string
     * 
     * Time Complexity: O(n) where n is the length of the string Space Complexity: O(n) for the
     * stack in worst case
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        // Odd length strings cannot be valid
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');

        for (char c : s.toCharArray()) {
            if (mapping.containsKey(c)) {
                // Closing bracket
                if (stack.isEmpty() || stack.pop() != mapping.get(c)) {
                    return false;
                }
            } else {
                // Opening bracket
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    // ========================================
    // APPROACH 2: STACK WITH ARRAY
    // Time: O(n), Space: O(n) - using array instead of Stack
    // ========================================

    /**
     * Approach 2: Stack with Array Implementation
     * 
     * This approach uses an array to simulate a stack, which can be more memory efficient in some
     * cases.
     * 
     * Algorithm: 1. Use an array to simulate stack operations 2. Keep track of stack size with a
     * pointer 3. Same logic as stack approach but with array implementation
     * 
     * Time Complexity: O(n) where n is the length of the string Space Complexity: O(n) for the
     * array
     */
    public boolean isValidArrayStack(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        if (s.length() % 2 != 0) {
            return false;
        }

        char[] stack = new char[s.length()];
        int top = -1;

        for (char c : s.toCharArray()) {
            if (c == ')' || c == '}' || c == ']') {
                // Closing bracket
                if (top < 0) {
                    return false;
                }
                char expected = getMatchingOpening(c);
                if (stack[top] != expected) {
                    return false;
                }
                top--; // Pop
            } else {
                // Opening bracket
                stack[++top] = c; // Push
            }
        }

        return top == -1; // Stack should be empty
    }

    /**
     * Helper method to get matching opening bracket
     */
    private char getMatchingOpening(char closing) {
        switch (closing) {
            case ')':
                return '(';
            case '}':
                return '{';
            case ']':
                return '[';
            default:
                return '\0';
        }
    }

    // ========================================
    // APPROACH 3: COUNTER-BASED
    // Time: O(n), Space: O(1) - but only works for single type
    // ========================================

    /**
     * Approach 3: Counter-based Validation (Single Type)
     * 
     * This approach uses counters for each type of bracket, but only works when brackets don't
     * interleave incorrectly.
     * 
     * Algorithm: 1. Use counters for each bracket type 2. Increment for opening, decrement for
     * closing 3. Check if all counters are zero at the end
     * 
     * Note: This approach has limitations and may not work for all cases like "([)]"
     * 
     * Time Complexity: O(n) where n is the length of the string Space Complexity: O(1)
     */
    public boolean isValidCounter(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        if (s.length() % 2 != 0) {
            return false;
        }

        int roundCount = 0;
        int curlyCount = 0;
        int squareCount = 0;

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    roundCount++;
                    break;
                case ')':
                    roundCount--;
                    if (roundCount < 0) {
                        return false;
                    }
                    break;
                case '{':
                    curlyCount++;
                    break;
                case '}':
                    curlyCount--;
                    if (curlyCount < 0) {
                        return false;
                    }
                    break;
                case '[':
                    squareCount++;
                    break;
                case ']':
                    squareCount--;
                    if (squareCount < 0) {
                        return false;
                    }
                    break;
                default:
                    return false; // Invalid character
            }
        }

        return roundCount == 0 && curlyCount == 0 && squareCount == 0;
    }

    // ========================================
    // APPROACH 4: RECURSIVE
    // Time: O(n), Space: O(n) due to recursion stack
    // ========================================

    /**
     * Approach 4: Recursive Validation
     * 
     * This approach uses recursion to validate parentheses, which can be elegant but uses more
     * space due to the call stack.
     * 
     * Algorithm: 1. Use recursion to process the string 2. Keep track of expected closing bracket
     * 3. Recursively validate nested structures
     * 
     * Time Complexity: O(n) where n is the length of the string Space Complexity: O(n) due to
     * recursion call stack
     */
    public boolean isValidRecursive(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        if (s.length() % 2 != 0) {
            return false;
        }

        return isValidRecursiveHelper(s, 0, new int[1]);
    }

    private boolean isValidRecursiveHelper(String s, int index, int[] nextIndex) {
        if (index >= s.length()) {
            return true;
        }

        char current = s.charAt(index);
        if (isClosingBracket(current)) {
            return false; // Cannot start with closing bracket
        }

        char expectedClosing = getMatchingClosing(current);
        int i = index + 1;

        while (i < s.length()) {
            char next = s.charAt(i);
            if (next == expectedClosing) {
                // Found matching closing bracket
                nextIndex[0] = i + 1;
                return true;
            } else if (isOpeningBracket(next)) {
                // Found nested opening bracket, recurse
                if (!isValidRecursiveHelper(s, i, nextIndex)) {
                    return false;
                }
                i = nextIndex[0];
            } else {
                return false; // Invalid character or unmatched closing
            }
        }

        return false; // No matching closing bracket found
    }

    /**
     * Helper method to check if character is opening bracket
     */
    private boolean isOpeningBracket(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    /**
     * Helper method to check if character is closing bracket
     */
    private boolean isClosingBracket(char c) {
        return c == ')' || c == '}' || c == ']';
    }

    /**
     * Helper method to get matching closing bracket
     */
    private char getMatchingClosing(char opening) {
        switch (opening) {
            case '(':
                return ')';
            case '{':
                return '}';
            case '[':
                return ']';
            default:
                return '\0';
        }
    }

    // ========================================
    // APPROACH 5: STRING REPLACEMENT
    // Time: O(n^2), Space: O(n) - less efficient but simple
    // ========================================

    /**
     * Approach 5: String Replacement
     * 
     * This approach repeatedly removes valid pairs until no more can be removed, then checks if
     * string is empty.
     * 
     * Algorithm: 1. Keep removing valid pairs "()", "{}", "[]" from the string 2. If string becomes
     * empty, it's valid 3. If no more pairs can be removed and string is not empty, it's invalid
     * 
     * Time Complexity: O(n^2) in worst case due to string operations Space Complexity: O(n)
     */
    public boolean isValidStringReplacement(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        if (s.length() % 2 != 0) {
            return false;
        }

        String current = s;
        String previous = "";

        while (!current.equals(previous)) {
            previous = current;
            current = current.replace("()", "").replace("{}", "").replace("[]", "");
        }

        return current.isEmpty();
    }

    // ========================================
    // UTILITY METHODS
    // ========================================

    /**
     * Get string statistics for analysis
     * 
     * @param s Input string
     * @return String with statistics
     */
    public static String getStringStatistics(String s) {
        if (s == null) {
            return "String is null";
        }

        int length = s.length();
        int roundOpen = 0, roundClose = 0;
        int curlyOpen = 0, curlyClose = 0;
        int squareOpen = 0, squareClose = 0;
        int invalidChars = 0;

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    roundOpen++;
                    break;
                case ')':
                    roundClose++;
                    break;
                case '{':
                    curlyOpen++;
                    break;
                case '}':
                    curlyClose++;
                    break;
                case '[':
                    squareOpen++;
                    break;
                case ']':
                    squareClose++;
                    break;
                default:
                    invalidChars++;
            }
        }

        StringBuilder stats = new StringBuilder();
        stats.append(String.format("String Statistics: Length=%d", length));
        stats.append(String.format(", Round brackets: %d open, %d close", roundOpen, roundClose));
        stats.append(String.format(", Curly brackets: %d open, %d close", curlyOpen, curlyClose));
        stats.append(
                String.format(", Square brackets: %d open, %d close", squareOpen, squareClose));
        stats.append(String.format(", Invalid characters: %d", invalidChars));
        stats.append(String.format(", Balanced: %s",
                (roundOpen == roundClose && curlyOpen == curlyClose && squareOpen == squareClose)));

        return stats.toString();
    }

    /**
     * Compare results from different approaches
     */
    public boolean compareResults(boolean result1, boolean result2) {
        return result1 == result2;
    }

    /**
     * Validate that all approaches return the same result
     */
    public boolean validateAllApproaches(String s) {
        boolean result1 = isValid(s);
        boolean result2 = isValidArrayStack(s);
        boolean result3 = isValidCounter(s);
        boolean result4 = isValidRecursive(s);
        boolean result5 = isValidStringReplacement(s);

        return result1 == result2 && result2 == result3 && result3 == result4 && result4 == result5;
    }

    /**
     * Performance analysis helper - measures execution time
     */
    public long measureExecutionTime(Runnable algorithm) {
        long startTime = System.nanoTime();
        algorithm.run();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Create test cases with different scenarios
     */
    public static String[] createTestCases() {
        return new String[] {
                // Valid cases
                "()", "()[]{}", "{[]}", "((()))", "{[()]}", "()()()", "(([]))",

                // Invalid cases
                "(]", "([)]", "(((", ")))", "([)]", "{[}]", "((())", "(()))",

                // Edge cases
                "", "(", ")", "[", "]", "{", "}", "([", ")]", "({[", "}])",

                // Complex cases
                "(((((())))))", "{[()()()]}", "((()))[[[]]]{{}}", "([{}])",

                // Invalid characters (should be handled gracefully)
                "a", "()a", "a()", "()[]{}a"};
    }

    /**
     * Check if string contains only valid parentheses characters
     */
    public static boolean containsOnlyValidCharacters(String s) {
        if (s == null) {
            return true;
        }

        for (char c : s.toCharArray()) {
            if (c != '(' && c != ')' && c != '{' && c != '}' && c != '[' && c != ']') {
                return false;
            }
        }
        return true;
    }

    /**
     * Get the depth of nested parentheses
     */
    public static int getMaxDepth(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int maxDepth = 0;
        int currentDepth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            } else if (c == ')' || c == '}' || c == ']') {
                currentDepth--;
            }
        }

        return maxDepth;
    }

    /**
     * Count the number of valid pairs in the string
     */
    public static int countValidPairs(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int count = 0;
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');

        for (char c : s.toCharArray()) {
            if (mapping.containsKey(c)) {
                if (!stack.isEmpty() && stack.pop() == mapping.get(c)) {
                    count++;
                }
            } else {
                stack.push(c);
            }
        }

        return count;
    }
}
