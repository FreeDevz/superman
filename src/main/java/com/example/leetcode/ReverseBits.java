package com.example.leetcode;

/**
 * LeetCode #190: Reverse Bits
 * 
 * Problem Description: Reverse bits of a given 32 bits unsigned integer. Given a 32-bit unsigned
 * integer n, reverse its bits and return the resulting integer.
 * 
 * Example 1: Input: n = 43261596 (00000010100101000001111010011100) Output: 964176192
 * (00111001011110000010100101000000)
 * 
 * Example 2: Input: n = 4294967293 (11111111111111111111111111111101) Output: 3221225471
 * (10111111111111111111111111111111)
 * 
 * Constraints: - The input must be a binary string of length 32
 * 
 * Approach Analysis: This problem can be solved using multiple approaches: 1. Bit-by-bit reversal
 * (Simple) - O(32) time, O(1) space 2. Bit manipulation with masks (Optimal) - O(1) time, O(1)
 * space 3. Lookup table approach - O(1) time, O(1) space 4. Divide and conquer approach - O(log 32)
 * time, O(1) space 5. String-based approach - O(32) time, O(32) space
 * 
 * Time Complexity: O(1) for optimal approach Space Complexity: O(1) for optimal approach
 */
public class ReverseBits {

    /**
     * Approach 1: Bit-by-bit Reversal (Simple and Clear)
     * 
     * Extract each bit from the rightmost position and build the result from left to right.
     * 
     * Time: O(32) = O(1) Space: O(1)
     */
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            // Extract the rightmost bit
            int bit = n & 1;

            // Shift result left to make room for new bit
            result = (result << 1) | bit;

            // Shift n right to process next bit
            n = n >>> 1; // Use unsigned right shift
        }

        return result;
    }

    /**
     * Approach 2: Bit Manipulation with Masks (Optimal)
     * 
     * Use bit manipulation to swap bits in chunks, starting with large chunks and working down to
     * individual bits.
     * 
     * Time: O(1) Space: O(1)
     */
    public int reverseBitsOptimal(int n) {
        // Swap 16-bit halves
        n = (n >>> 16) | (n << 16);

        // Swap 8-bit chunks
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);

        // Swap 4-bit chunks (nibbles)
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);

        // Swap 2-bit chunks
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);

        // Swap individual bits
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);

        return n;
    }

    /**
     * Approach 3: Lookup Table Approach
     * 
     * Use a lookup table to reverse 8-bit chunks, then combine them.
     * 
     * Time: O(1) Space: O(1)
     */
    public int reverseBitsLookupTable(int n) {
        // Lookup table for reversing 8-bit values
        int[] lookup = {0, 128, 64, 192, 32, 160, 96, 224, 16, 144, 80, 208, 48, 176, 112, 240, 8,
                136, 72, 200, 40, 168, 104, 232, 24, 152, 88, 216, 56, 184, 120, 248, 4, 132, 68,
                196, 36, 164, 100, 228, 20, 148, 84, 212, 52, 180, 116, 244, 12, 140, 76, 204, 44,
                172, 108, 236, 28, 156, 92, 220, 60, 188, 124, 252, 2, 130, 66, 194, 34, 162, 98,
                226, 18, 146, 82, 210, 50, 178, 114, 242, 10, 138, 74, 202, 42, 170, 106, 234, 26,
                154, 90, 218, 58, 186, 122, 250, 6, 134, 70, 198, 38, 166, 102, 230, 22, 150, 86,
                214, 54, 182, 118, 246, 14, 142, 78, 206, 46, 174, 110, 238, 30, 158, 94, 222, 62,
                190, 126, 254, 1, 129, 65, 193, 33, 161, 97, 225, 17, 145, 81, 209, 49, 177, 113,
                241, 9, 137, 73, 201, 41, 169, 105, 233, 25, 153, 89, 217, 57, 185, 121, 249, 5,
                133, 69, 197, 37, 165, 101, 229, 21, 149, 85, 213, 53, 181, 117, 245, 13, 141, 77,
                205, 45, 173, 109, 237, 29, 157, 93, 221, 61, 189, 125, 253, 3, 131, 67, 195, 35,
                163, 99, 227, 19, 147, 83, 211, 51, 179, 115, 243, 11, 139, 75, 203, 43, 171, 107,
                235, 27, 155, 91, 219, 59, 187, 123, 251, 7, 135, 71, 199, 39, 167, 103, 231, 23,
                151, 87, 215, 55, 183, 119, 247, 15, 143, 79, 207, 47, 175, 111, 239, 31, 159, 95,
                223, 63, 191, 127, 255};

        // Reverse each 8-bit chunk and combine
        return (lookup[n & 0xff] << 24) | (lookup[(n >>> 8) & 0xff] << 16)
                | (lookup[(n >>> 16) & 0xff] << 8) | lookup[(n >>> 24) & 0xff];
    }

    /**
     * Approach 4: Divide and Conquer
     * 
     * Recursively swap halves of the number until we reach individual bits.
     * 
     * Time: O(log 32) = O(1) Space: O(1)
     */
    public int reverseBitsDivideConquer(int n) {
        return reverseBitsRecursive(n, 32);
    }

    private int reverseBitsRecursive(int n, int bits) {
        if (bits == 1) {
            return n;
        }

        int halfBits = bits / 2;
        int mask = (1 << halfBits) - 1;

        // Get left and right halves
        int left = (n >>> halfBits) & mask;
        int right = n & mask;

        // Recursively reverse each half and swap them
        int reversedLeft = reverseBitsRecursive(left, halfBits);
        int reversedRight = reverseBitsRecursive(right, halfBits);

        // Combine reversed halves (swap positions)
        return (reversedRight << halfBits) | reversedLeft;
    }

    /**
     * Approach 5: String-based Approach (Educational)
     * 
     * Convert to binary string, reverse it, and convert back. Not optimal but educational.
     * 
     * Time: O(32) Space: O(32)
     */
    public int reverseBitsString(int n) {
        // Convert to binary string with leading zeros
        String binary = String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0');

        // Reverse the string
        StringBuilder reversed = new StringBuilder(binary).reverse();

        // Convert back to integer (treating as unsigned)
        return (int) Long.parseLong(reversed.toString(), 2);
    }

    /**
     * Approach 6: Bit Manipulation with Precomputed Masks
     * 
     * Use precomputed masks for more efficient bit swapping.
     * 
     * Time: O(1) Space: O(1)
     */
    public int reverseBitsPrecomputedMasks(int n) {
        // Precomputed masks for different bit positions
        int[] masks = {0x55555555, 0x33333333, 0x0f0f0f0f, 0x00ff00ff, 0x0000ffff};
        int[] shifts = {1, 2, 4, 8, 16};

        for (int i = 0; i < masks.length; i++) {
            n = ((n & masks[i]) << shifts[i]) | ((n & ~masks[i]) >>> shifts[i]);
        }

        return n;
    }

    /**
     * Approach 7: Two-Pointer Bit Swapping
     * 
     * Use two pointers to swap bits from both ends moving towards center.
     * 
     * Time: O(32) = O(1) Space: O(1)
     */
    public int reverseBitsTwoPointer(int n) {
        int left = 31;
        int right = 0;

        while (left > right) {
            // Extract bits at left and right positions
            int leftBit = (n >>> left) & 1;
            int rightBit = (n >>> right) & 1;

            // Clear bits at both positions
            n &= ~(1 << left);
            n &= ~(1 << right);

            // Set swapped bits
            n |= (rightBit << left);
            n |= (leftBit << right);

            left--;
            right++;
        }

        return n;
    }

    /**
     * Utility method to convert integer to 32-bit binary string
     */
    public String toBinaryString(int n) {
        return String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0');
    }

    /**
     * Utility method to count the number of set bits (Hamming weight)
     */
    public int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }

    /**
     * Utility method to check if a number is a power of 2
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    /**
     * Utility method to get the position of the rightmost set bit
     */
    public int getRightmostSetBitPosition(int n) {
        if (n == 0) {
            return -1;
        }
        return Integer.numberOfTrailingZeros(n);
    }

    /**
     * Utility method to toggle all bits
     */
    public int toggleAllBits(int n) {
        return ~n;
    }

    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        ReverseBits solution = new ReverseBits();

        // Test cases
        int[] testCases = {43261596, -3, 0, 1, 2147483647, 1431655765, -1431655766};

        System.out.println("Testing Reverse Bits Solutions:");
        System.out.println("===============================");

        for (int i = 0; i < testCases.length; i++) {
            int n = testCases[i];
            System.out.printf("Test Case %d: %d\n", i + 1, n);
            System.out.printf("Binary: %s\n", solution.toBinaryString(n));

            int result1 = solution.reverseBits(n);
            int result2 = solution.reverseBitsOptimal(n);
            int result3 = solution.reverseBitsLookupTable(n);
            int result4 = solution.reverseBitsDivideConquer(n);
            int result5 = solution.reverseBitsString(n);
            int result6 = solution.reverseBitsPrecomputedMasks(n);
            int result7 = solution.reverseBitsTwoPointer(n);

            System.out.printf("Bit-by-bit: %d (%s)\n", result1, solution.toBinaryString(result1));
            System.out.printf("Optimal: %d (%s)\n", result2, solution.toBinaryString(result2));
            System.out.printf("Lookup Table: %d (%s)\n", result3, solution.toBinaryString(result3));
            System.out.printf("Divide & Conquer: %d (%s)\n", result4,
                    solution.toBinaryString(result4));
            System.out.printf("String-based: %d (%s)\n", result5, solution.toBinaryString(result5));
            System.out.printf("Precomputed Masks: %d (%s)\n", result6,
                    solution.toBinaryString(result6));
            System.out.printf("Two-Pointer: %d (%s)\n", result7, solution.toBinaryString(result7));

            // Validate results
            boolean allEqual = result1 == result2 && result2 == result3 && result3 == result4
                    && result4 == result5 && result5 == result6 && result6 == result7;

            System.out.printf("All approaches consistent: %s\n", allEqual ? "✓" : "✗");
            System.out.printf("Set bits count: %d\n", solution.countSetBits(n));
            System.out.println("---");
        }

        // Test utility methods
        System.out.println("Testing Utility Methods:");
        System.out.println("========================");
        int testNum = 43261596;
        System.out.printf("Number: %d\n", testNum);
        System.out.printf("Binary: %s\n", solution.toBinaryString(testNum));
        System.out.printf("Set bits count: %d\n", solution.countSetBits(testNum));
        System.out.printf("Is power of 2: %s\n", solution.isPowerOfTwo(testNum));
        System.out.printf("Rightmost set bit position: %d\n",
                solution.getRightmostSetBitPosition(testNum));
        System.out.printf("Toggle all bits: %d (%s)\n", solution.toggleAllBits(testNum),
                solution.toBinaryString(solution.toggleAllBits(testNum)));
    }
}
