package com.example.leetcode;

/**
 * LeetCode #66: Plus One
 * 
 * Problem Statement: You are given a large integer represented as an integer array digits, where
 * each digits[i] is the ith digit of the integer. The digits are ordered from most significant to
 * least significant in left-to-right order. The large integer does not contain any leading zeros.
 * Increment the large integer by one and return the resulting array of digits.
 * 
 * Constraints: - 1 <= digits.length <= 100 - 0 <= digits[i] <= 9 - digits does not contain any
 * leading zeros.
 * 
 * This solution demonstrates multiple algorithmic approaches: 1. Simple Iterative - O(n) time, O(1)
 * space (most efficient) 2. Recursive Approach - O(n) time, O(n) space (educational) 3. String
 * Conversion - O(n) time, O(n) space (alternative approach) 4. Mathematical Approach - O(n) time,
 * O(1) space (optimized) 5. Two-Pass Approach - O(n) time, O(1) space (alternative optimization)
 * 
 * @author Superman
 * @version 1.0
 */
public class PlusOne {

    /**
     * Approach 1: Simple Iterative (Recommended)
     * 
     * Iterates from right to left, handling carry propagation. This is the most efficient and
     * interview-friendly approach.
     * 
     * Time Complexity: O(n) where n = digits.length Space Complexity: O(1) for in-place
     * modification, O(n) for new array creation
     * 
     * @param digits Array of digits representing the large integer
     * @return Array of digits after adding one
     */
    public int[] plusOneSimple(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[] {1};
        }

        // Start from the rightmost digit
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                // No carry needed, just increment and return
                digits[i]++;
                return digits;
            }
            // Set current digit to 0 and continue to next digit
            digits[i] = 0;
        }

        // If we reach here, all digits were 9, need to create new array
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    /**
     * Approach 2: Recursive Approach
     * 
     * Recursive implementation that processes digits from right to left. Educational approach to
     * understand the problem structure.
     * 
     * Time Complexity: O(n) where n = digits.length Space Complexity: O(n) for recursion stack
     * 
     * @param digits Array of digits representing the large integer
     * @return Array of digits after adding one
     */
    public int[] plusOneRecursive(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[] {1};
        }

        // Create a copy to avoid modifying original array
        int[] result = digits.clone();
        boolean carry = plusOneRecursiveHelper(result, result.length - 1);

        if (carry) {
            // Need to create new array with leading 1
            int[] newResult = new int[result.length + 1];
            newResult[0] = 1;
            System.arraycopy(result, 0, newResult, 1, result.length);
            return newResult;
        }

        return result;
    }

    /**
     * Helper method for recursive plus one operation.
     * 
     * @param digits Array of digits
     * @param index Current position being processed
     * @return true if carry is needed for next position
     */
    private boolean plusOneRecursiveHelper(int[] digits, int index) {
        if (index < 0) {
            return true; // Need to create new array
        }

        if (digits[index] < 9) {
            digits[index]++;
            return false; // No carry needed
        }

        digits[index] = 0;
        return plusOneRecursiveHelper(digits, index - 1);
    }

    /**
     * Approach 3: String Conversion
     * 
     * Converts array to string, performs addition, then converts back. Alternative approach that
     * some developers find intuitive.
     * 
     * Time Complexity: O(n) where n = digits.length Space Complexity: O(n)
     * 
     * @param digits Array of digits representing the large integer
     * @return Array of digits after adding one
     */
    public int[] plusOneStringConversion(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[] {1};
        }

        // Convert array to string
        StringBuilder sb = new StringBuilder();
        for (int digit : digits) {
            sb.append(digit);
        }

        // Convert to BigInteger, add 1, convert back to string
        java.math.BigInteger num = new java.math.BigInteger(sb.toString());
        String resultStr = num.add(java.math.BigInteger.ONE).toString();

        // Convert back to array
        int[] result = new int[resultStr.length()];
        for (int i = 0; i < resultStr.length(); i++) {
            result[i] = resultStr.charAt(i) - '0';
        }

        return result;
    }

    /**
     * Approach 4: Mathematical Approach
     * 
     * Uses mathematical operations to handle the addition. Optimized approach with minimal
     * operations.
     * 
     * Time Complexity: O(n) where n = digits.length Space Complexity: O(1) for in-place
     * modification, O(n) for new array creation
     * 
     * @param digits Array of digits representing the large integer
     * @return Array of digits after adding one
     */
    public int[] plusOneMathematical(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[] {1};
        }

        int carry = 1; // Start with carry of 1 (adding one)
        int[] result = digits.clone();

        for (int i = result.length - 1; i >= 0 && carry > 0; i--) {
            int sum = result[i] + carry;
            result[i] = sum % 10;
            carry = sum / 10;
        }

        if (carry > 0) {
            // Need to create new array with leading 1
            int[] newResult = new int[result.length + 1];
            newResult[0] = 1;
            System.arraycopy(result, 0, newResult, 1, result.length);
            return newResult;
        }

        return result;
    }

    /**
     * Approach 5: Two-Pass Approach
     * 
     * First pass: find the rightmost non-9 digit. Second pass: increment and handle carry. This
     * approach minimizes operations in the best case.
     * 
     * Time Complexity: O(n) where n = digits.length Space Complexity: O(1) for in-place
     * modification, O(n) for new array creation
     * 
     * @param digits Array of digits representing the large integer
     * @return Array of digits after adding one
     */
    public int[] plusOneTwoPass(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[] {1};
        }

        // First pass: find the rightmost non-9 digit
        int lastNonNine = -1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                lastNonNine = i;
                break;
            }
        }

        if (lastNonNine == -1) {
            // All digits are 9, need to create new array
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }

        // Second pass: increment the last non-9 digit and set all following 9s to 0
        int[] result = digits.clone();
        result[lastNonNine]++;
        for (int i = lastNonNine + 1; i < result.length; i++) {
            result[i] = 0;
        }

        return result;
    }

    /**
     * Approach 6: Optimized In-Place
     * 
     * Optimized version that modifies the input array in-place when possible, only creating a new
     * array when necessary.
     * 
     * Time Complexity: O(n) where n = digits.length Space Complexity: O(1) for in-place
     * modification, O(n) for new array creation
     * 
     * @param digits Array of digits representing the large integer
     * @return Array of digits after adding one
     */
    public int[] plusOneOptimized(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[] {1};
        }

        // Check if we can modify in-place
        boolean canModifyInPlace = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                canModifyInPlace = true;
                digits[i]++;
                // Set all following digits to 0
                for (int j = i + 1; j < digits.length; j++) {
                    digits[j] = 0;
                }
                break;
            }
        }

        if (canModifyInPlace) {
            return digits;
        }

        // All digits were 9, need to create new array
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    /**
     * Utility method to demonstrate all approaches and compare results.
     * 
     * @param digits Array of digits representing the large integer
     */
    public void demonstrateAllApproaches(int[] digits) {
        System.out.println("=== Plus One ===");
        System.out.println(
                "Input: " + arrayToString(digits) + " (Value: " + arrayToValue(digits) + ")");
        System.out.println();

        long startTime, endTime;

        // Approach 1: Simple Iterative
        startTime = System.nanoTime();
        int[] result1 = plusOneSimple(digits.clone());
        endTime = System.nanoTime();
        System.out.println("1. Simple Iterative: " + arrayToString(result1) + " (Time: "
                + (endTime - startTime) / 1000 + " μs)");

        // Approach 2: Recursive
        startTime = System.nanoTime();
        int[] result2 = plusOneRecursive(digits);
        endTime = System.nanoTime();
        System.out.println("2. Recursive: " + arrayToString(result2) + " (Time: "
                + (endTime - startTime) / 1000 + " μs)");

        // Approach 3: String Conversion
        startTime = System.nanoTime();
        int[] result3 = plusOneStringConversion(digits);
        endTime = System.nanoTime();
        System.out.println("3. String Conversion: " + arrayToString(result3) + " (Time: "
                + (endTime - startTime) / 1000 + " μs)");

        // Approach 4: Mathematical
        startTime = System.nanoTime();
        int[] result4 = plusOneMathematical(digits);
        endTime = System.nanoTime();
        System.out.println("4. Mathematical: " + arrayToString(result4) + " (Time: "
                + (endTime - startTime) / 1000 + " μs)");

        // Approach 5: Two-Pass
        startTime = System.nanoTime();
        int[] result5 = plusOneTwoPass(digits);
        endTime = System.nanoTime();
        System.out.println("5. Two-Pass: " + arrayToString(result5) + " (Time: "
                + (endTime - startTime) / 1000 + " μs)");

        // Approach 6: Optimized In-Place
        startTime = System.nanoTime();
        int[] result6 = plusOneOptimized(digits.clone());
        endTime = System.nanoTime();
        System.out.println("6. Optimized In-Place: " + arrayToString(result6) + " (Time: "
                + (endTime - startTime) / 1000 + " μs)");

        // Verify all results are the same
        boolean allMatch = (arraysEqual(result1, result2) && arraysEqual(result2, result3)
                && arraysEqual(result3, result4) && arraysEqual(result4, result5)
                && arraysEqual(result5, result6));
        System.out.println("\n✅ All approaches produce identical results: " + allMatch);

        if (allMatch) {
            System.out.println("Result: " + arrayToString(result1) + " (Value: "
                    + arrayToValue(result1) + ")");
            System.out.println("Verification: " + arrayToValue(digits) + " + 1 = "
                    + (arrayToValue(digits) + 1));
        }

        System.out.println();
    }

    /**
     * Converts array to string representation.
     * 
     * @param arr Array of digits
     * @return String representation
     */
    private String arrayToString(int[] arr) {
        if (arr == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Converts array to its numerical value for verification.
     * 
     * @param arr Array of digits
     * @return Numerical value
     */
    private long arrayToValue(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        long value = 0;
        for (int digit : arr) {
            value = value * 10 + digit;
        }
        return value;
    }

    /**
     * Checks if two arrays are equal.
     * 
     * @param arr1 First array
     * @param arr2 Second array
     * @return true if arrays are equal
     */
    private boolean arraysEqual(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1 == null || arr2 == null) {
            return false;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Main method for demonstration and testing.
     */
    public static void main(String[] args) {
        PlusOne solution = new PlusOne();

        System.out.println("🚀 LeetCode #66: Plus One");
        System.out.println("=".repeat(50));

        // Test cases
        int[][] testCases = {{1, 2, 3}, {4, 3, 2, 1}, {9}, {9, 9}, {9, 9, 9}, {1, 0, 0, 0}, {0},
                {1}, {8, 9, 9}, {9, 8, 9}, {1, 9, 9}, {9, 0, 9}, {1, 2, 3, 4, 5, 6, 7, 8, 9}};

        for (int[] testCase : testCases) {
            solution.demonstrateAllApproaches(testCase);
        }

        System.out.println("🎯 Algorithm Analysis:");
        System.out
                .println("• Simple Iterative: Most efficient and interview-friendly (recommended)");
        System.out.println("• Recursive: Educational, demonstrates problem structure");
        System.out.println("• String Conversion: Alternative approach using string manipulation");
        System.out.println("• Mathematical: Optimized with mathematical operations");
        System.out.println("• Two-Pass: Minimizes operations in best case");
        System.out.println("• Optimized In-Place: Modifies input when possible");
        System.out.println();
        System.out
                .println("🏆 Recommendation: Use Simple Iterative for interviews and production!");
    }
}
