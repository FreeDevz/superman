package com.example.leetcode;

import java.util.*;

/**
 * LeetCode 17: Letter Combinations of a Phone Number
 * 
 * Problem Description: Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent. Return the answer in any order.
 * 
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1
 * does not map to any letters.
 * 
 * 2 -> "abc" 3 -> "def" 4 -> "ghi" 5 -> "jkl" 6 -> "mno" 7 -> "pqrs" 8 -> "tuv" 9 -> "wxyz"
 * 
 * Example 1: Input: digits = "23" Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 
 * Example 2: Input: digits = "" Output: []
 * 
 * Example 3: Input: digits = "2" Output: ["a","b","c"]
 * 
 * Constraints: - 0 <= digits.length <= 4 - digits[i] is a digit in the range ['2', '9'].
 * 
 * Approach 1: Recursive Backtracking Time Complexity: O(3^N * 4^M) where N is digits mapping to 3
 * letters, M is digits mapping to 4 letters Space Complexity: O(3^N * 4^M) for storing results +
 * O(N+M) for recursion stack
 * 
 * Approach 2: Iterative BFS Time Complexity: O(3^N * 4^M) Space Complexity: O(3^N * 4^M) for
 * storing results
 */
public class LetterCombinationsOfPhoneNumber {

    // Mapping of digits to their corresponding letters
    private static final Map<Character, String> digitToLetters = Map.of('2', "abc", '3', "def", '4',
            "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

    /**
     * Solution 1: Recursive Backtracking
     * 
     * This approach uses recursion to build all possible combinations. For each digit, we try all
     * possible letters and recursively build combinations for the remaining digits.
     */
    public List<String> letterCombinationsRecursive(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        // Base case: if we've processed all digits, add current combination to result
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get letters for current digit
        char digit = digits.charAt(index);
        String letters = digitToLetters.get(digit);

        // Try each letter for current digit
        for (char letter : letters.toCharArray()) {
            current.append(letter); // Choose
            backtrack(digits, index + 1, current, result); // Explore
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }

    /**
     * Solution 2: Iterative BFS (Breadth-First Search)
     * 
     * This approach builds combinations level by level using a queue. Start with empty string, then
     * for each digit, expand all existing combinations by adding each possible letter for that
     * digit.
     */
    public List<String> letterCombinationsIterative(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(""); // Start with empty string

        for (char digit : digits.toCharArray()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                String letters = digitToLetters.get(digit);

                for (char letter : letters.toCharArray()) {
                    queue.offer(current + letter);
                }
            }
        }

        result.addAll(queue);
        return result;
    }

    /**
     * Solution 3: Iterative with List (Alternative approach)
     * 
     * Similar to BFS but using a list instead of queue. More memory efficient as we don't need to
     * maintain a queue.
     */
    public List<String> letterCombinationsIterativeList(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        result.add(""); // Start with empty string

        for (char digit : digits.toCharArray()) {
            List<String> temp = new ArrayList<>();
            String letters = digitToLetters.get(digit);

            for (String combination : result) {
                for (char letter : letters.toCharArray()) {
                    temp.add(combination + letter);
                }
            }

            result = temp;
        }

        return result;
    }

    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber solution = new LetterCombinationsOfPhoneNumber();

        // Test cases
        String[] testCases = {"23", "", "2", "234", "7"};

        for (String digits : testCases) {
            System.out.println("Input: \"" + digits + "\"");

            List<String> recursive = solution.letterCombinationsRecursive(digits);
            List<String> iterative = solution.letterCombinationsIterative(digits);
            List<String> iterativeList = solution.letterCombinationsIterativeList(digits);

            System.out.println("Recursive: " + recursive);
            System.out.println("Iterative: " + iterative);
            System.out.println("IterativeList: " + iterativeList);
            System.out.println("All methods match: "
                    + (recursive.equals(iterative) && iterative.equals(iterativeList)));
            System.out.println("---");
        }
    }
}
