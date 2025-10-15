package com.example.leetcode;

/**
 * LeetCode 231: Power of Two
 * 
 * Problem Description: Given an integer n, return true if it is a power of two. Otherwise, return
 * false. An integer n is a power of two, if there exists an integer x such that n == 2^x.
 * 
 * Example 1: Input: n = 1 Output: true Explanation: 2^0 = 1
 * 
 * Example 2: Input: n = 16 Output: true Explanation: 2^4 = 16
 * 
 * Example 3: Input: n = 3 Output: false
 * 
 * Constraints: - -2^31 <= n <= 2^31 - 1
 * 
 * Follow up: Could you solve it without loops/recursion?
 * 
 * Approach 1: Bit Manipulation (Optimal) Time Complexity: O(1) Space Complexity: O(1)
 * 
 * Approach 2: Iterative Division Time Complexity: O(log n) Space Complexity: O(1)
 * 
 * Approach 3: Recursive Division Time Complexity: O(log n) Space Complexity: O(log n)
 * 
 * Approach 4: Logarithm Method Time Complexity: O(1) Space Complexity: O(1)
 * 
 * Approach 5: Count Set Bits Time Complexity: O(1) Space Complexity: O(1)
 * 
 * Approach 6: Iterative Multiplication Time Complexity: O(log n) Space Complexity: O(1)
 * 
 * Approach 7: Remove Rightmost Bit Time Complexity: O(1) Space Complexity: O(1)
 * 
 * Approach 8: Check Against All Powers Time Complexity: O(1) Space Complexity: O(1)
 */
public class PowerOfTwo {

    /**
     * Approach 1: Bit Manipulation (Optimal Solution)
     * 
     * Powers of two have exactly one bit set to 1 in their binary representation. For example: - 1
     * (2^0) = 0001 - 2 (2^1) = 0010 - 4 (2^2) = 0100 - 8 (2^3) = 1000
     * 
     * When we subtract 1 from a power of two, all bits after the single '1' bit become '1', and the
     * original '1' bit becomes '0'. For example: - 8 (1000) - 1 = 7 (0111) - 4 (0100) - 1 = 3
     * (0011)
     * 
     * Performing a bitwise AND between n and (n-1) will yield 0 if n is a power of two: - 8 & 7 =
     * 1000 & 0111 = 0000 - 4 & 3 = 0100 & 0011 = 0000
     * 
     * @param n the integer to check
     * @return true if n is a power of two, false otherwise
     */
    public boolean isPowerOfTwoBitManipulation(int n) {
        // Must be positive and n & (n-1) must be 0
        return n > 0 && (n & (n - 1)) == 0;
    }

    /**
     * Approach 2: Iterative Division
     * 
     * Continuously divide n by 2 until it becomes 1 (power of two) or until it's no longer
     * divisible by 2 (not a power of two).
     * 
     * @param n the integer to check
     * @return true if n is a power of two, false otherwise
     */
    public boolean isPowerOfTwoIterativeDivision(int n) {
        if (n <= 0) {
            return false;
        }

        while (n > 1) {
            if (n % 2 != 0) {
                return false; // Not divisible by 2, so not a power of two
            }
            n /= 2;
        }

        return true; // Reached 1, so it's a power of two
    }

    /**
     * Approach 3: Recursive Division
     * 
     * Recursively divide n by 2 until we reach 1 (power of two) or find an odd number greater than
     * 1 (not a power of two).
     * 
     * @param n the integer to check
     * @return true if n is a power of two, false otherwise
     */
    public boolean isPowerOfTwoRecursiveDivision(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 2 != 0) {
            return false;
        }
        return isPowerOfTwoRecursiveDivision(n / 2);
    }

    /**
     * Approach 4: Logarithm Method
     * 
     * If n is a power of two, then log2(n) will be an integer. We can check if log2(n) is an
     * integer by comparing 2^(log2(n)) with n.
     * 
     * Note: This approach has precision issues with floating-point arithmetic, so it's not
     * recommended for production use.
     * 
     * @param n the integer to check
     * @return true if n is a power of two, false otherwise
     */
    public boolean isPowerOfTwoLogarithm(int n) {
        if (n <= 0) {
            return false;
        }

        double log2 = Math.log(n) / Math.log(2);
        return (log2 - Math.floor(log2)) == 0;
    }

    /**
     * Approach 5: Count Set Bits
     * 
     * A power of two has exactly one bit set to 1 in its binary representation. We can count the
     * number of set bits using Integer.bitCount().
     * 
     * @param n the integer to check
     * @return true if n is a power of two, false otherwise
     */
    public boolean isPowerOfTwoCountSetBits(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }

    /**
     * Approach 6: Iterative Multiplication
     * 
     * Start with 1 (2^0) and keep multiplying by 2 until we either find n or exceed n.
     * 
     * @param n the integer to check
     * @return true if n is a power of two, false otherwise
     */
    public boolean isPowerOfTwoIterativeMultiplication(int n) {
        if (n <= 0) {
            return false;
        }

        long power = 1;
        while (power < n) {
            power *= 2;
        }

        return power == n;
    }

    /**
     * Approach 7: Remove Rightmost Bit
     * 
     * Similar to Approach 1 but using a different bit manipulation technique. The operation n &
     * (-n) isolates the rightmost set bit. If n is a power of two, removing this bit should result
     * in 0.
     * 
     * @param n the integer to check
     * @return true if n is a power of two, false otherwise
     */
    public boolean isPowerOfTwoRemoveRightmostBit(int n) {
        return n > 0 && (n & (-n)) == n;
    }

    /**
     * Approach 8: Check Against All Powers (Bit Trick)
     * 
     * The largest power of 2 that fits in a 32-bit signed integer is 2^30 = 1073741824. If n is a
     * power of two, then the largest power of 2 must be divisible by n.
     * 
     * @param n the integer to check
     * @return true if n is a power of two, false otherwise
     */
    public boolean isPowerOfTwoCheckAgainstLargest(int n) {
        // 2^30 is the largest power of 2 that fits in a 32-bit signed integer
        return n > 0 && (1073741824 % n == 0);
    }

    /**
     * Utility method to get the power of 2 if n is a power of 2, or -1 if it's not.
     * 
     * @param n the integer to check
     * @return the power x where n = 2^x, or -1 if n is not a power of 2
     */
    public int getPowerOfTwo(int n) {
        if (!isPowerOfTwoBitManipulation(n)) {
            return -1;
        }

        int power = 0;
        while ((1 << power) != n) {
            power++;
        }
        return power;
    }

    /**
     * Utility method to generate the next power of 2 greater than or equal to n.
     * 
     * @param n the integer
     * @return the next power of 2 >= n
     */
    public int nextPowerOfTwo(int n) {
        if (n <= 0) {
            return 1;
        }

        // If already a power of 2, return it
        if (isPowerOfTwoBitManipulation(n)) {
            return n;
        }

        // Fill all bits after the highest set bit
        n--;
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        n++;

        return n;
    }

    /**
     * Utility method to generate the previous power of 2 less than or equal to n.
     * 
     * @param n the integer
     * @return the previous power of 2 <= n
     */
    public int previousPowerOfTwo(int n) {
        if (n <= 0) {
            return 0;
        }

        // If already a power of 2, return it
        if (isPowerOfTwoBitManipulation(n)) {
            return n;
        }

        // Keep only the highest set bit
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;

        return n - (n >> 1);
    }

    /**
     * Utility method to check if a number is a power of 2 and print binary representation.
     * 
     * @param n the integer to check
     * @return a string with the result and binary representation
     */
    public String checkWithBinaryRepresentation(int n) {
        boolean result = isPowerOfTwoBitManipulation(n);
        String binary = n > 0 ? String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0')
                : "N/A (negative or zero)";
        return String.format("n=%d, isPowerOfTwo=%b, binary=%s", n, result, binary);
    }

    /**
     * Main method to demonstrate all approaches
     */
    public static void main(String[] args) {
        PowerOfTwo solution = new PowerOfTwo();

        // Test cases
        int[] testCases = {1, 2, 3, 4, 5, 8, 16, 31, 32, 64, 100, 128, 256, 512, 1024, 1023, 1025,
                0, -1, -16, Integer.MAX_VALUE, 1073741824};

        System.out.println("Testing Power of Two Solutions:");
        System.out.println("===============================");

        for (int n : testCases) {
            System.out.println("\n" + solution.checkWithBinaryRepresentation(n));

            boolean result1 = solution.isPowerOfTwoBitManipulation(n);
            boolean result2 = solution.isPowerOfTwoIterativeDivision(n);
            boolean result3 = solution.isPowerOfTwoRecursiveDivision(n);
            boolean result4 = solution.isPowerOfTwoLogarithm(n);
            boolean result5 = solution.isPowerOfTwoCountSetBits(n);
            boolean result6 = solution.isPowerOfTwoIterativeMultiplication(n);
            boolean result7 = solution.isPowerOfTwoRemoveRightmostBit(n);
            boolean result8 = solution.isPowerOfTwoCheckAgainstLargest(n);

            // Verify all approaches agree (except logarithm which may have precision issues)
            boolean allAgree = result1 == result2 && result2 == result3 && result3 == result5
                    && result5 == result6 && result6 == result7 && result7 == result8;

            System.out.println("Bit Manipulation: " + result1);
            System.out.println("Iterative Division: " + result2);
            System.out.println("Recursive Division: " + result3);
            System.out.println("Logarithm: " + result4);
            System.out.println("Count Set Bits: " + result5);
            System.out.println("Iterative Multiplication: " + result6);
            System.out.println("Remove Rightmost Bit: " + result7);
            System.out.println("Check Against Largest: " + result8);
            System.out.println("All approaches agree: " + (allAgree ? "✓" : "✗"));

            if (result1) {
                System.out.println("Power: 2^" + solution.getPowerOfTwo(n) + " = " + n);
            }
        }

        // Additional utility demonstrations
        System.out.println("\n\nUtility Method Demonstrations:");
        System.out.println("===============================");

        int[] utilityTests = {5, 7, 15, 17, 100, 1000};
        for (int n : utilityTests) {
            System.out.println("\nFor n = " + n + ":");
            System.out.println("  Next power of 2: " + solution.nextPowerOfTwo(n));
            System.out.println("  Previous power of 2: " + solution.previousPowerOfTwo(n));
        }

        // Performance comparison
        System.out.println("\n\nPerformance Analysis:");
        System.out.println("=====================");
        System.out.println("Approach 1 (Bit Manipulation): O(1) time, O(1) space - OPTIMAL");
        System.out.println("Approach 2 (Iterative Division): O(log n) time, O(1) space");
        System.out.println("Approach 3 (Recursive Division): O(log n) time, O(log n) space");
        System.out.println("Approach 4 (Logarithm): O(1) time, O(1) space - PRECISION ISSUES");
        System.out.println("Approach 5 (Count Set Bits): O(1) time, O(1) space");
        System.out.println("Approach 6 (Iterative Multiplication): O(log n) time, O(1) space");
        System.out.println("Approach 7 (Remove Rightmost Bit): O(1) time, O(1) space - ELEGANT");
        System.out.println("Approach 8 (Check Against Largest): O(1) time, O(1) space - CLEVER");

        System.out.println("\nKey Insights:");
        System.out.println("=============");
        System.out.println("• Powers of 2 have exactly one bit set in binary representation");
        System.out.println("• n & (n-1) removes the rightmost set bit");
        System.out.println("• For powers of 2, n & (n-1) equals 0");
        System.out.println("• n & (-n) isolates the rightmost set bit");
        System.out.println("• For powers of 2, n & (-n) equals n itself");
        System.out.println("• Binary of 2^x: single 1 bit followed by x zeros");
        System.out.println("• The largest power of 2 in 32-bit signed int is 2^30 = 1073741824");
        System.out.println("• Any power of 2 divides the largest power of 2 evenly");
    }
}

