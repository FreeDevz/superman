package com.example.leetcode;

/**
 * LeetCode #67: Add Binary
 * 
 * Problem Statement: Given two binary strings a and b, return their sum as a binary string.
 * 
 * Constraints: - 1 <= a.length, b.length <= 10^4 - a and b consist only of '0' or '1' characters. -
 * Each string does not contain leading zeros except for the zero itself.
 * 
 * This solution demonstrates multiple algorithmic approaches: 1. Built-in BigInteger - O(n) time,
 * O(n) space (simple but not optimal for large inputs) 2. Manual Addition with StringBuilder - O(n)
 * time, O(n) space (most efficient) 3. Manual Addition with Array - O(n) time, O(n) space
 * (alternative approach) 4. Recursive Approach - O(n) time, O(n) space (educational) 5. Bit
 * Manipulation - O(n) time, O(n) space (advanced approach)
 * 
 * @author Superman
 * @version 1.0
 */
public class AddBinary {

    /**
     * Approach 1: Built-in BigInteger Conversion
     * 
     * Converts binary strings to BigInteger, adds them, then converts back to binary. Simple but
     * not optimal for very large inputs due to BigInteger overhead.
     * 
     * Time Complexity: O(n) where n = max(a.length, b.length) Space Complexity: O(n)
     * 
     * @param a First binary string
     * @param b Second binary string
     * @return Sum as binary string
     */
    public String addBinaryBuiltIn(String a, String b) {
        if (a == null || b == null) {
            return "0";
        }

        try {
            // Convert binary strings to BigInteger
            java.math.BigInteger numA = new java.math.BigInteger(a, 2);
            java.math.BigInteger numB = new java.math.BigInteger(b, 2);

            // Add and convert back to binary
            return numA.add(numB).toString(2);
        } catch (NumberFormatException e) {
            return "0";
        }
    }

    /**
     * Approach 2: Manual Addition with StringBuilder (Recommended)
     * 
     * Manually performs binary addition from right to left, handling carry propagation. This is the
     * most efficient and interview-friendly approach.
     * 
     * Time Complexity: O(n) where n = max(a.length, b.length) Space Complexity: O(n)
     * 
     * @param a First binary string
     * @param b Second binary string
     * @return Sum as binary string
     */
    public String addBinaryManual(String a, String b) {
        if (a == null || b == null) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        // Process from right to left
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            result.append(sum % 2);
            carry = sum / 2;
        }

        return result.reverse().toString();
    }

    /**
     * Approach 3: Manual Addition with Array
     * 
     * Similar to StringBuilder approach but uses array for result storage. Alternative
     * implementation that some developers prefer.
     * 
     * Time Complexity: O(n) where n = max(a.length, b.length) Space Complexity: O(n)
     * 
     * @param a First binary string
     * @param b Second binary string
     * @return Sum as binary string
     */
    public String addBinaryArray(String a, String b) {
        if (a == null || b == null) {
            return "0";
        }

        int maxLen = Math.max(a.length(), b.length());
        char[] result = new char[maxLen + 1]; // +1 for potential carry
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        int k = result.length - 1;

        // Process from right to left
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            result[k] = (char) ('0' + (sum % 2));
            carry = sum / 2;
            k--;
        }

        // Convert array to string, skipping leading zeros
        int start = 0;
        while (start < result.length - 1 && result[start] == '0') {
            start++;
        }

        return new String(result, start, result.length - start);
    }

    /**
     * Approach 4: Recursive Approach
     * 
     * Recursive implementation that processes one digit at a time. Educational approach to
     * understand the problem structure.
     * 
     * Time Complexity: O(n) where n = max(a.length, b.length) Space Complexity: O(n) for recursion
     * stack
     * 
     * @param a First binary string
     * @param b Second binary string
     * @return Sum as binary string
     */
    public String addBinaryRecursive(String a, String b) {
        if (a == null || b == null) {
            return "0";
        }

        // Pad shorter string with leading zeros
        int maxLen = Math.max(a.length(), b.length());
        a = padWithZeros(a, maxLen);
        b = padWithZeros(b, maxLen);

        StringBuilder result = new StringBuilder();
        addBinaryRecursiveHelper(a, b, maxLen - 1, 0, result);
        return result.toString();
    }

    /**
     * Helper method for recursive binary addition.
     * 
     * @param a First binary string (padded)
     * @param b Second binary string (padded)
     * @param index Current position being processed
     * @param carry Carry from previous position
     * @param result StringBuilder to store result
     */
    private void addBinaryRecursiveHelper(String a, String b, int index, int carry,
            StringBuilder result) {
        if (index < 0) {
            if (carry > 0) {
                result.append(carry);
            }
            return;
        }

        int sum = carry + (a.charAt(index) - '0') + (b.charAt(index) - '0');
        addBinaryRecursiveHelper(a, b, index - 1, sum / 2, result);
        result.append(sum % 2);
    }

    /**
     * Pads a string with leading zeros to reach target length.
     * 
     * @param str Input string
     * @param targetLength Target length
     * @return Padded string
     */
    private String padWithZeros(String str, int targetLength) {
        if (str.length() >= targetLength) {
            return str;
        }
        return "0".repeat(targetLength - str.length()) + str;
    }

    /**
     * Approach 5: Bit Manipulation (Advanced)
     * 
     * Uses bit manipulation techniques to perform binary addition. More complex but demonstrates
     * advanced programming concepts.
     * 
     * Time Complexity: O(n) where n = max(a.length, b.length) Space Complexity: O(n)
     * 
     * @param a First binary string
     * @param b Second binary string
     * @return Sum as binary string
     */
    public String addBinaryBitManipulation(String a, String b) {
        if (a == null || b == null) {
            return "0";
        }

        // Convert to integers (assuming they fit in long)
        long numA = binaryStringToLong(a);
        long numB = binaryStringToLong(b);

        // Use bit manipulation for addition
        long sum = addWithBitManipulation(numA, numB);

        return longToBinaryString(sum);
    }

    /**
     * Converts binary string to long integer.
     * 
     * @param binary Binary string
     * @return Long integer value
     */
    private long binaryStringToLong(String binary) {
        long result = 0;
        for (char c : binary.toCharArray()) {
            result = (result << 1) | (c - '0');
        }
        return result;
    }

    /**
     * Adds two numbers using bit manipulation.
     * 
     * @param a First number
     * @param b Second number
     * @return Sum
     */
    private long addWithBitManipulation(long a, long b) {
        while (b != 0) {
            long carry = a & b; // Calculate carry
            a = a ^ b; // Sum without carry
            b = carry << 1; // Shift carry to next position
        }
        return a;
    }

    /**
     * Converts long integer to binary string.
     * 
     * @param num Long integer
     * @return Binary string
     */
    private String longToBinaryString(long num) {
        if (num == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        while (num > 0) {
            result.append(num & 1);
            num >>= 1;
        }
        return result.reverse().toString();
    }

    /**
     * Approach 6: Optimized Manual Addition
     * 
     * Optimized version of manual addition with early termination and efficient string building.
     * 
     * Time Complexity: O(n) where n = max(a.length, b.length) Space Complexity: O(n)
     * 
     * @param a First binary string
     * @param b Second binary string
     * @return Sum as binary string
     */
    public String addBinaryOptimized(String a, String b) {
        if (a == null || b == null) {
            return "0";
        }

        // Handle edge cases
        if (a.equals("0")) {
            return b;
        }
        if (b.equals("0")) {
            return a;
        }

        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        // Process from right to left
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            result.append(sum % 2);
            carry = sum / 2;
        }

        return result.reverse().toString();
    }

    /**
     * Utility method to demonstrate all approaches and compare results.
     * 
     * @param a First binary string
     * @param b Second binary string
     */
    public void demonstrateAllApproaches(String a, String b) {
        System.out.println("=== Add Binary ===");
        System.out.println("Binary A: \"" + a + "\" (Decimal: " + binaryToDecimal(a) + ")");
        System.out.println("Binary B: \"" + b + "\" (Decimal: " + binaryToDecimal(b) + ")");
        System.out.println();

        long startTime, endTime;

        // Approach 1: Built-in BigInteger
        startTime = System.nanoTime();
        String result1 = addBinaryBuiltIn(a, b);
        endTime = System.nanoTime();
        System.out.println("1. Built-in BigInteger: \"" + result1 + "\" (Time: "
                + (endTime - startTime) / 1000 + " μs)");

        // Approach 2: Manual Addition
        startTime = System.nanoTime();
        String result2 = addBinaryManual(a, b);
        endTime = System.nanoTime();
        System.out.println("2. Manual Addition: \"" + result2 + "\" (Time: "
                + (endTime - startTime) / 1000 + " μs)");

        // Approach 3: Array-based
        startTime = System.nanoTime();
        String result3 = addBinaryArray(a, b);
        endTime = System.nanoTime();
        System.out.println("3. Array-based: \"" + result3 + "\" (Time: "
                + (endTime - startTime) / 1000 + " μs)");

        // Approach 4: Recursive
        startTime = System.nanoTime();
        String result4 = addBinaryRecursive(a, b);
        endTime = System.nanoTime();
        System.out.println("4. Recursive: \"" + result4 + "\" (Time: "
                + (endTime - startTime) / 1000 + " μs)");

        // Approach 5: Bit Manipulation
        startTime = System.nanoTime();
        String result5 = addBinaryBitManipulation(a, b);
        endTime = System.nanoTime();
        System.out.println("5. Bit Manipulation: \"" + result5 + "\" (Time: "
                + (endTime - startTime) / 1000 + " μs)");

        // Approach 6: Optimized Manual
        startTime = System.nanoTime();
        String result6 = addBinaryOptimized(a, b);
        endTime = System.nanoTime();
        System.out.println("6. Optimized Manual: \"" + result6 + "\" (Time: "
                + (endTime - startTime) / 1000 + " μs)");

        // Verify all results are the same
        boolean allMatch = (result1.equals(result2) && result2.equals(result3)
                && result3.equals(result4) && result4.equals(result5) && result5.equals(result6));
        System.out.println("\n✅ All approaches produce identical results: " + allMatch);

        if (allMatch) {
            System.out.println(
                    "Result: \"" + result1 + "\" (Decimal: " + binaryToDecimal(result1) + ")");
            System.out.println("Verification: " + binaryToDecimal(a) + " + " + binaryToDecimal(b)
                    + " = " + (binaryToDecimal(a) + binaryToDecimal(b)));
        }

        System.out.println();
    }

    /**
     * Converts binary string to decimal for verification.
     * 
     * @param binary Binary string
     * @return Decimal value
     */
    private long binaryToDecimal(String binary) {
        if (binary == null || binary.isEmpty()) {
            return 0;
        }
        return Long.parseLong(binary, 2);
    }

    /**
     * Main method for demonstration and testing.
     */
    public static void main(String[] args) {
        AddBinary solution = new AddBinary();

        System.out.println("🚀 LeetCode #67: Add Binary");
        System.out.println("=".repeat(60));

        // Test cases
        String[][] testCases = {{"11", "1"}, {"1010", "1011"}, {"0", "0"}, {"1", "1"},
                {"1111", "1111"}, {"100", "110010"}, {"10101", "1010"}, {"0", "1"},
                {"1111111111", "1"}, {"1010101010", "1010101010"}, {"1", "1111111111"},
                {"1000000000", "1000000000"}};

        for (String[] testCase : testCases) {
            solution.demonstrateAllApproaches(testCase[0], testCase[1]);
        }

        System.out.println("🎯 Algorithm Analysis:");
        System.out.println("• Built-in BigInteger: Simple but has overhead for large inputs");
        System.out
                .println("• Manual Addition: Most efficient and interview-friendly (recommended)");
        System.out.println("• Array-based: Alternative to StringBuilder approach");
        System.out.println("• Recursive: Educational, demonstrates problem structure");
        System.out.println("• Bit Manipulation: Advanced approach using bit operations");
        System.out.println("• Optimized Manual: Enhanced with early termination");
        System.out.println();
        System.out.println("🏆 Recommendation: Use Manual Addition for interviews and production!");
    }
}
