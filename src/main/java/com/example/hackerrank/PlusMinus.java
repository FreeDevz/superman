package com.example.hackerrank;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * HackerRank: Plus Minus
 * 
 * Problem Description: Given an array of integers, calculate the ratios of its elements that are
 * positive, negative, and zero. Print the decimal value of each fraction on a new line with 6
 * places after the decimal.
 * 
 * Example: Input: [-4, 3, -9, 0, 4, 1] Output: 0.500000 (positive), 0.333333 (negative), 0.166667
 * (zero)
 * 
 * Constraints: - 1 <= n <= 100 - -100 <= arr[i] <= 100
 * 
 * Approach Analysis: This problem can be solved using multiple approaches: 1. Simple counting
 * approach - O(n) time, O(1) space 2. Stream-based approach - O(n) time, O(1) space 3. Enhanced
 * counting with validation - O(n) time, O(1) space 4. Functional programming approach - O(n) time,
 * O(1) space 5. Array-based approach - O(n) time, O(1) space
 * 
 * Time Complexity: O(n) Space Complexity: O(1)
 */
public class PlusMinus {

    /**
     * Approach 1: Simple Counting (Recommended)
     * 
     * Count positive, negative, and zero elements, then calculate ratios.
     * 
     * Time: O(n) Space: O(1)
     */
    public void plusMinus(int[] arr) {
        int n = arr.length;
        int positive = 0, negative = 0, zero = 0;

        // Count each type
        for (int num : arr) {
            if (num > 0) {
                positive++;
            } else if (num < 0) {
                negative++;
            } else {
                zero++;
            }
        }

        // Calculate and print ratios with 6 decimal places
        System.out.printf("%.6f%n", (double) positive / n);
        System.out.printf("%.6f%n", (double) negative / n);
        System.out.printf("%.6f%n", (double) zero / n);
    }

    /**
     * Approach 2: Stream-based Approach
     * 
     * Use Java streams to count and calculate ratios.
     * 
     * Time: O(n) Space: O(1)
     */
    public void plusMinusStream(int[] arr) {
        int n = arr.length;

        long positive = Arrays.stream(arr).filter(x -> x > 0).count();
        long negative = Arrays.stream(arr).filter(x -> x < 0).count();
        long zero = Arrays.stream(arr).filter(x -> x == 0).count();

        System.out.printf("%.6f%n", (double) positive / n);
        System.out.printf("%.6f%n", (double) negative / n);
        System.out.printf("%.6f%n", (double) zero / n);
    }

    /**
     * Approach 3: Enhanced Counting with Validation
     * 
     * Count with input validation and edge case handling.
     * 
     * Time: O(n) Space: O(1)
     */
    public void plusMinusEnhanced(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("0.000000");
            System.out.println("0.000000");
            System.out.println("0.000000");
            return;
        }

        int n = arr.length;
        int positive = 0, negative = 0, zero = 0;

        for (int num : arr) {
            if (num > 0) {
                positive++;
            } else if (num < 0) {
                negative++;
            } else {
                zero++;
            }
        }

        // Print with 6 decimal places
        System.out.printf("%.6f%n", (double) positive / n);
        System.out.printf("%.6f%n", (double) negative / n);
        System.out.printf("%.6f%n", (double) zero / n);
    }

    /**
     * Approach 4: Functional Programming Approach
     * 
     * Use functional programming concepts with IntStream.
     * 
     * Time: O(n) Space: O(1)
     */
    public void plusMinusFunctional(int[] arr) {
        int n = arr.length;

        double positiveRatio = (double) IntStream.of(arr).filter(x -> x > 0).count() / n;
        double negativeRatio = (double) IntStream.of(arr).filter(x -> x < 0).count() / n;
        double zeroRatio = (double) IntStream.of(arr).filter(x -> x == 0).count() / n;

        System.out.printf("%.6f%n", positiveRatio);
        System.out.printf("%.6f%n", negativeRatio);
        System.out.printf("%.6f%n", zeroRatio);
    }

    /**
     * Approach 5: Array-based Approach
     * 
     * Use array to store counts and calculate ratios.
     * 
     * Time: O(n) Space: O(1)
     */
    public void plusMinusArray(int[] arr) {
        int n = arr.length;
        int[] counts = new int[3]; // [positive, negative, zero]

        for (int num : arr) {
            if (num > 0) {
                counts[0]++;
            } else if (num < 0) {
                counts[1]++;
            } else {
                counts[2]++;
            }
        }

        System.out.printf("%.6f%n", (double) counts[0] / n);
        System.out.printf("%.6f%n", (double) counts[1] / n);
        System.out.printf("%.6f%n", (double) counts[2] / n);
    }

    /**
     * Approach 6: Single Pass with Math Operations
     * 
     * Use mathematical operations to avoid multiple conditions.
     * 
     * Time: O(n) Space: O(1)
     */
    public void plusMinusMath(int[] arr) {
        int n = arr.length;
        int positive = 0, negative = 0, zero = 0;

        for (int num : arr) {
            // Use signum to determine type
            int sign = Integer.signum(num);
            if (sign == 1) {
                positive++;
            } else if (sign == -1) {
                negative++;
            } else {
                zero++;
            }
        }

        System.out.printf("%.6f%n", (double) positive / n);
        System.out.printf("%.6f%n", (double) negative / n);
        System.out.printf("%.6f%n", (double) zero / n);
    }

    /**
     * Approach 7: Bit Manipulation Approach
     * 
     * Use bit manipulation to count (educational approach).
     * 
     * Time: O(n) Space: O(1)
     */
    public void plusMinusBitManipulation(int[] arr) {
        int n = arr.length;
        int positive = 0, negative = 0, zero = 0;

        for (int num : arr) {
            // Check if number is zero
            if (num == 0) {
                zero++;
            } else {
                // Check sign bit (31st bit for 32-bit integers)
                if ((num >>> 31) == 0) {
                    positive++;
                } else {
                    negative++;
                }
            }
        }

        System.out.printf("%.6f%n", (double) positive / n);
        System.out.printf("%.6f%n", (double) negative / n);
        System.out.printf("%.6f%n", (double) zero / n);
    }

    /**
     * Utility method to get ratios as array
     */
    public double[] getRatios(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new double[] {0.0, 0.0, 0.0};
        }

        int n = arr.length;
        int positive = 0, negative = 0, zero = 0;

        for (int num : arr) {
            if (num > 0) {
                positive++;
            } else if (num < 0) {
                negative++;
            } else {
                zero++;
            }
        }

        return new double[] {(double) positive / n, (double) negative / n, (double) zero / n};
    }

    /**
     * Utility method to validate input array
     */
    public boolean isValidInput(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        if (arr.length > 100) {
            return false;
        }
        for (int num : arr) {
            if (num < -100 || num > 100) {
                return false;
            }
        }
        return true;
    }

    /**
     * Utility method to count elements by type
     */
    public int[] countElements(int[] arr) {
        int positive = 0, negative = 0, zero = 0;

        for (int num : arr) {
            if (num > 0) {
                positive++;
            } else if (num < 0) {
                negative++;
            } else {
                zero++;
            }
        }

        return new int[] {positive, negative, zero};
    }

    /**
     * Utility method to format ratio with 6 decimal places
     */
    public String formatRatio(double ratio) {
        return String.format("%.6f", ratio);
    }

    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        PlusMinus solution = new PlusMinus();

        // Test cases
        int[][] testCases = {{-4, 3, -9, 0, 4, 1}, {1, 2, 3, -1, -2, -3, 0, 0}, {1, 1, 0, -1, -1},
                {0, 0, 0}, {1, 2, 3}, {-1, -2, -3}, {0}};

        System.out.println("Testing Plus Minus Solutions:");
        System.out.println("=============================");

        for (int i = 0; i < testCases.length; i++) {
            int[] arr = testCases[i];
            System.out.printf("Test Case %d: %s\n", i + 1, Arrays.toString(arr));

            // Test all approaches
            System.out.println("Simple Counting:");
            solution.plusMinus(arr);
            System.out.println();

            System.out.println("Stream-based:");
            solution.plusMinusStream(arr);
            System.out.println();

            System.out.println("Enhanced Counting:");
            solution.plusMinusEnhanced(arr);
            System.out.println();

            System.out.println("Functional Programming:");
            solution.plusMinusFunctional(arr);
            System.out.println();

            System.out.println("Array-based:");
            solution.plusMinusArray(arr);
            System.out.println();

            System.out.println("Math Operations:");
            solution.plusMinusMath(arr);
            System.out.println();

            System.out.println("Bit Manipulation:");
            solution.plusMinusBitManipulation(arr);
            System.out.println();

            // Test utility methods
            double[] ratios = solution.getRatios(arr);
            int[] counts = solution.countElements(arr);
            boolean isValid = solution.isValidInput(arr);

            System.out.printf("Ratios: [%.6f, %.6f, %.6f]\n", ratios[0], ratios[1], ratios[2]);
            System.out.printf("Counts: [%d, %d, %d]\n", counts[0], counts[1], counts[2]);
            System.out.printf("Valid input: %s\n", isValid ? "Yes" : "No");
            System.out.println("---");
        }

        // Test edge cases
        System.out.println("Testing Edge Cases:");
        System.out.println("==================");

        // Null array
        System.out.println("Null array:");
        solution.plusMinusEnhanced(null);
        System.out.println();

        // Empty array
        System.out.println("Empty array:");
        solution.plusMinusEnhanced(new int[0]);
        System.out.println();

        // Single element
        System.out.println("Single element [5]:");
        solution.plusMinusEnhanced(new int[] {5});
        System.out.println();

        // All zeros
        System.out.println("All zeros [0, 0, 0]:");
        solution.plusMinusEnhanced(new int[] {0, 0, 0});
        System.out.println();

        // All positive
        System.out.println("All positive [1, 2, 3]:");
        solution.plusMinusEnhanced(new int[] {1, 2, 3});
        System.out.println();

        // All negative
        System.out.println("All negative [-1, -2, -3]:");
        solution.plusMinusEnhanced(new int[] {-1, -2, -3});
        System.out.println();
    }
}
