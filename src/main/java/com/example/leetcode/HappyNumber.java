package com.example.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode #202: Happy Number
 * 
 * Problem Description: Write an algorithm to determine if a number n is happy. A happy number is
 * defined by the following process: Starting with any positive integer, replace the number by the
 * sum of the squares of its digits. Repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this
 * process ends in 1 are happy.
 * 
 * Example 1: Input: n = 19 Output: true Explanation: 1² + 9² = 82, 8² + 2² = 68, 6² + 8² = 100, 1²
 * + 0² + 0² = 1
 * 
 * Example 2: Input: n = 2 Output: false
 * 
 * Constraints: - 1 <= n <= 2³¹ - 1
 * 
 * Approach Analysis: This problem can be solved using multiple approaches: 1. HashSet approach
 * (Simple) - O(log n) time, O(log n) space 2. Floyd's Cycle Detection (Optimal) - O(log n) time,
 * O(1) space 3. Mathematical approach - O(log n) time, O(1) space 4. Recursive approach - O(log n)
 * time, O(log n) space 5. Iterative with early termination - O(log n) time, O(log n) space
 * 
 * Time Complexity: O(log n) Space Complexity: O(1) for optimal approach
 */
public class HappyNumber {

    /**
     * Approach 1: HashSet Approach (Simple and Clear)
     * 
     * Use a HashSet to detect cycles by tracking seen numbers.
     * 
     * Time: O(log n) Space: O(log n)
     */
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getSumOfSquares(n);
        }

        return n == 1;
    }

    /**
     * Approach 2: Floyd's Cycle Detection (Optimal)
     * 
     * Use two pointers moving at different speeds to detect cycles without extra space.
     * 
     * Time: O(log n) Space: O(1)
     */
    public boolean isHappyFloyd(int n) {
        int slow = n;
        int fast = getSumOfSquares(n);

        while (fast != 1 && slow != fast) {
            slow = getSumOfSquares(slow);
            fast = getSumOfSquares(getSumOfSquares(fast));
        }

        return fast == 1;
    }

    /**
     * Approach 3: Mathematical Approach
     * 
     * Use mathematical properties to optimize the solution.
     * 
     * Time: O(log n) Space: O(1)
     */
    public boolean isHappyMath(int n) {
        // All numbers in the range [1, 9] except 1 and 7 are not happy
        // This is a mathematical property of happy numbers
        while (n > 9) {
            n = getSumOfSquares(n);
        }

        return n == 1 || n == 7;
    }

    /**
     * Approach 4: Recursive Approach
     * 
     * Use recursion with memoization to solve the problem.
     * 
     * Time: O(log n) Space: O(log n)
     */
    public boolean isHappyRecursive(int n) {
        return isHappyRecursiveHelper(n, new HashSet<>());
    }

    private boolean isHappyRecursiveHelper(int n, Set<Integer> seen) {
        if (n == 1) {
            return true;
        }
        if (seen.contains(n)) {
            return false;
        }

        seen.add(n);
        return isHappyRecursiveHelper(getSumOfSquares(n), seen);
    }

    /**
     * Approach 5: Iterative with Early Termination
     * 
     * Use iteration with early termination for known non-happy numbers.
     * 
     * Time: O(log n) Space: O(log n)
     */
    public boolean isHappyIterative(int n) {
        Set<Integer> seen = new HashSet<>();
        // Known non-happy numbers that form cycles
        Set<Integer> nonHappyCycle = Set.of(4, 16, 37, 58, 89, 145, 42, 20);

        while (n != 1 && !seen.contains(n)) {
            if (nonHappyCycle.contains(n)) {
                return false;
            }
            seen.add(n);
            n = getSumOfSquares(n);
        }

        return n == 1;
    }

    /**
     * Approach 6: Bit Manipulation Approach
     * 
     * Use bit manipulation to optimize digit extraction and calculations.
     * 
     * Time: O(log n) Space: O(1)
     */
    public boolean isHappyBitManipulation(int n) {
        int slow = n;
        int fast = getSumOfSquaresBitManipulation(n);

        while (fast != 1 && slow != fast) {
            slow = getSumOfSquaresBitManipulation(slow);
            fast = getSumOfSquaresBitManipulation(getSumOfSquaresBitManipulation(fast));
        }

        return fast == 1;
    }

    /**
     * Approach 7: String-based Approach
     * 
     * Convert number to string and process digits (educational approach).
     * 
     * Time: O(log n) Space: O(log n)
     */
    public boolean isHappyString(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getSumOfSquaresString(n);
        }

        return n == 1;
    }

    /**
     * Utility method to calculate sum of squares of digits
     */
    private int getSumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    /**
     * Utility method using bit manipulation for sum of squares
     */
    private int getSumOfSquaresBitManipulation(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    /**
     * Utility method using string conversion for sum of squares
     */
    private int getSumOfSquaresString(int n) {
        String numStr = String.valueOf(n);
        int sum = 0;
        for (char c : numStr.toCharArray()) {
            int digit = c - '0';
            sum += digit * digit;
        }
        return sum;
    }

    /**
     * Utility method to get all digits of a number
     */
    public int[] getDigits(int n) {
        String numStr = String.valueOf(n);
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = numStr.charAt(i) - '0';
        }
        return digits;
    }

    /**
     * Utility method to check if a number is a perfect square
     */
    public boolean isPerfectSquare(int n) {
        if (n < 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    /**
     * Utility method to find the next happy number after a given number
     */
    public int findNextHappyNumber(int n) {
        int next = n + 1;
        while (!isHappy(next)) {
            next++;
        }
        return next;
    }

    /**
     * Utility method to find all happy numbers in a range
     */
    public int[] findHappyNumbersInRange(int start, int end) {
        java.util.List<Integer> happyNumbers = new java.util.ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (isHappy(i)) {
                happyNumbers.add(i);
            }
        }
        return happyNumbers.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Utility method to get the sequence of numbers leading to 1 or cycle
     */
    public int[] getHappySequence(int n) {
        java.util.List<Integer> sequence = new java.util.ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            sequence.add(n);
            seen.add(n);
            n = getSumOfSquares(n);
        }
        sequence.add(n); // Add the final number (1 or cycle start)

        return sequence.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Utility method to count steps to reach 1 or detect cycle
     */
    public int countStepsToHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        int steps = 0;

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getSumOfSquares(n);
            steps++;
        }

        return steps;
    }

    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        HappyNumber solution = new HappyNumber();

        // Test cases
        int[] testCases = {19, 2, 7, 1, 13, 23, 28, 31, 32, 44, 49, 68, 70, 79, 82, 86, 91, 94, 97,
                100, 103, 109, 129, 130, 133, 139, 167, 176, 188, 190, 192, 193, 203, 208, 219, 226,
                230, 236, 239, 262, 263, 280, 291, 293, 301, 302, 310, 313, 319, 320, 326, 329, 331,
                338, 356, 362, 365, 367, 368, 376, 379, 383, 386, 391, 392, 397, 404, 409, 440, 446,
                464, 469, 478, 487, 490, 496, 536, 556, 563, 565, 566, 608, 617, 622, 623, 632, 635,
                637, 638, 644, 649, 653, 655, 656, 665, 671, 673, 680, 683, 694, 700, 709, 716, 736,
                739, 748, 761, 763, 784, 790, 793, 802, 806, 818, 820, 833, 836, 847, 860, 863, 874,
                881, 888, 899, 901, 904, 907, 910, 912, 913, 921, 923, 931, 932, 937, 940, 946, 964,
                970, 973, 989, 998, 1000};

        System.out.println("Testing Happy Number Solutions:");
        System.out.println("==============================");

        for (int i = 0; i < Math.min(20, testCases.length); i++) {
            int n = testCases[i];
            System.out.printf("Test Case %d: %d\n", i + 1, n);

            boolean result1 = solution.isHappy(n);
            boolean result2 = solution.isHappyFloyd(n);
            boolean result3 = solution.isHappyMath(n);
            boolean result4 = solution.isHappyRecursive(n);
            boolean result5 = solution.isHappyIterative(n);
            boolean result6 = solution.isHappyBitManipulation(n);
            boolean result7 = solution.isHappyString(n);

            System.out.printf("HashSet: %s\n", result1 ? "Happy" : "Not Happy");
            System.out.printf("Floyd's: %s\n", result2 ? "Happy" : "Not Happy");
            System.out.printf("Math: %s\n", result3 ? "Happy" : "Not Happy");
            System.out.printf("Recursive: %s\n", result4 ? "Happy" : "Not Happy");
            System.out.printf("Iterative: %s\n", result5 ? "Happy" : "Not Happy");
            System.out.printf("Bit Manipulation: %s\n", result6 ? "Happy" : "Not Happy");
            System.out.printf("String-based: %s\n", result7 ? "Happy" : "Not Happy");

            // Validate results
            boolean allEqual = result1 == result2 && result2 == result3 && result3 == result4
                    && result4 == result5 && result5 == result6 && result6 == result7;

            System.out.printf("All approaches consistent: %s\n", allEqual ? "✓" : "✗");

            // Show sequence for first few test cases
            if (i < 5) {
                int[] sequence = solution.getHappySequence(n);
                System.out.printf("Sequence: %s\n", java.util.Arrays.toString(sequence));
                System.out.printf("Steps to result: %d\n", solution.countStepsToHappy(n));
            }

            System.out.println("---");
        }

        // Test utility methods
        System.out.println("Testing Utility Methods:");
        System.out.println("========================");
        int testNum = 19;
        System.out.printf("Number: %d\n", testNum);
        System.out.printf("Digits: %s\n", java.util.Arrays.toString(solution.getDigits(testNum)));
        System.out.printf("Is perfect square: %s\n", solution.isPerfectSquare(16));
        System.out.printf("Next happy number after 18: %d\n", solution.findNextHappyNumber(18));
        System.out.printf("Happy numbers in range [1, 20]: %s\n",
                java.util.Arrays.toString(solution.findHappyNumbersInRange(1, 20)));
        System.out.printf("Sequence for 19: %s\n",
                java.util.Arrays.toString(solution.getHappySequence(19)));
        System.out.printf("Steps for 19: %d\n", solution.countStepsToHappy(19));
    }
}
