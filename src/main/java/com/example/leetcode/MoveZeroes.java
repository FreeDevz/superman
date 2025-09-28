package com.example.leetcode;

import java.util.Arrays;

/**
 * LeetCode 283: Move Zeroes
 * 
 * Problem Description: Given an integer array nums, move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements. Note that you must do this in-place without making a
 * copy of the array.
 * 
 * Example 1: Input: nums = [0,1,0,3,12] Output: [1,3,12,0,0]
 * 
 * Example 2: Input: nums = [0] Output: [0]
 * 
 * Constraints: - 1 <= nums.length <= 10^4 - -2^31 <= nums[i] <= 2^31 - 1
 * 
 * Time Complexity: O(n) where n is the length of nums Space Complexity: O(1) - in-place operation
 */
public class MoveZeroes {

    /**
     * Approach 1: Two Pointers with Swap (Optimal) Use two pointers to move non-zero elements to
     * the front while maintaining order.
     * 
     * Time Complexity: O(n) Space Complexity: O(1)
     */
    public void moveZeroesTwoPointers(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int writeIndex = 0; // Position for next non-zero element

        // First pass: move all non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != writeIndex) {
                    // Swap only if necessary
                    int temp = nums[writeIndex];
                    nums[writeIndex] = nums[i];
                    nums[i] = temp;
                }
                writeIndex++;
            }
        }
    }

    /**
     * Approach 2: Two Pass Method First pass: move non-zeros to front. Second pass: fill remaining
     * with zeros.
     * 
     * Time Complexity: O(n) Space Complexity: O(1)
     */
    public void moveZeroesTwoPass(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int writeIndex = 0;

        // First pass: move all non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[writeIndex] = nums[i];
                writeIndex++;
            }
        }

        // Second pass: fill remaining positions with zeros
        for (int i = writeIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * Approach 3: Optimized Two Pointers with Early Termination Optimized version that minimizes
     * swaps and operations.
     * 
     * Time Complexity: O(n) Space Complexity: O(1)
     */
    public void moveZeroesOptimized(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int nonZeroIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != nonZeroIndex) {
                    nums[nonZeroIndex] = nums[i];
                    nums[i] = 0;
                }
                nonZeroIndex++;
            }
        }
    }

    /**
     * Approach 4: Count Zeros Method Count zeros and move non-zeros accordingly.
     * 
     * Time Complexity: O(n) Space Complexity: O(1)
     */
    public void moveZeroesCountZeros(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int zeroCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                nums[i - zeroCount] = nums[i];
            }
        }

        // Fill the end with zeros
        for (int i = nums.length - zeroCount; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * Approach 5: Partition Method Use partitioning technique that maintains relative order.
     * 
     * Time Complexity: O(n) Space Complexity: O(1)
     */
    public void moveZeroesPartition(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int writeIndex = 0;

        // Move all non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != writeIndex) {
                    nums[writeIndex] = nums[i];
                    nums[i] = 0;
                }
                writeIndex++;
            }
        }
    }

    /**
     * Approach 6: Recursive Method Recursive approach for educational purposes.
     * 
     * Time Complexity: O(n) Space Complexity: O(n) due to recursion stack
     */
    public void moveZeroesRecursive(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        moveZeroesHelper(nums, 0, 0);
    }

    private void moveZeroesHelper(int[] nums, int currentIndex, int writeIndex) {
        if (currentIndex >= nums.length) {
            // Fill remaining positions with zeros
            for (int i = writeIndex; i < nums.length; i++) {
                nums[i] = 0;
            }
            return;
        }

        if (nums[currentIndex] != 0) {
            if (currentIndex != writeIndex) {
                nums[writeIndex] = nums[currentIndex];
                nums[currentIndex] = 0;
            }
            moveZeroesHelper(nums, currentIndex + 1, writeIndex + 1);
        } else {
            moveZeroesHelper(nums, currentIndex + 1, writeIndex);
        }
    }

    /**
     * Utility method to print array in a formatted way
     */
    public void printArray(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /**
     * Utility method to compare two arrays
     */
    public boolean compareArrays(int[] arr1, int[] arr2) {
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
     * Utility method to count zeros in array
     */
    public int countZeros(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num == 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Utility method to verify that zeros are at the end
     */
    public boolean verifyZeroesAtEnd(int[] nums) {
        boolean foundZero = false;
        for (int num : nums) {
            if (num == 0) {
                foundZero = true;
            } else if (foundZero) {
                return false; // Non-zero found after zero
            }
        }
        return true;
    }

    /**
     * Utility method to count operations (swaps/moves)
     */
    public int countOperations(int[] original, int[] modified) {
        int operations = 0;
        for (int i = 0; i < original.length; i++) {
            if (original[i] != modified[i]) {
                operations++;
            }
        }
        return operations;
    }

    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        MoveZeroes solution = new MoveZeroes();

        // Test cases
        int[][] testCases = {{0, 1, 0, 3, 12}, {0}, {1, 0, 1}, {0, 0, 1}, {1, 2, 3, 4, 5},
                {0, 0, 0, 0, 0}, {1, 0, 0, 0, 1}, {0, 1, 0, 0, 0, 1, 0, 0, 0, 1}};

        int[][] expectedResults = {{1, 3, 12, 0, 0}, {0}, {1, 1, 0}, {1, 0, 0}, {1, 2, 3, 4, 5},
                {0, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 0, 0, 0, 0}};

        System.out.println("Testing Move Zeroes Solutions:");
        System.out.println("==============================");

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("\nTest Case " + (i + 1) + ":");
            System.out.println("Input: " + Arrays.toString(testCases[i]));
            System.out.println("Expected: " + Arrays.toString(expectedResults[i]));

            // Test all approaches
            int[] test1 = testCases[i].clone();
            int[] test2 = testCases[i].clone();
            int[] test3 = testCases[i].clone();
            int[] test4 = testCases[i].clone();
            int[] test5 = testCases[i].clone();
            int[] test6 = testCases[i].clone();

            solution.moveZeroesTwoPointers(test1);
            solution.moveZeroesTwoPass(test2);
            solution.moveZeroesOptimized(test3);
            solution.moveZeroesCountZeros(test4);
            solution.moveZeroesPartition(test5);
            solution.moveZeroesRecursive(test6);

            System.out.println("Two Pointers: " + Arrays.toString(test1));
            System.out.println("Two Pass: " + Arrays.toString(test2));
            System.out.println("Optimized: " + Arrays.toString(test3));
            System.out.println("Count Zeros: " + Arrays.toString(test4));
            System.out.println("Partition: " + Arrays.toString(test5));
            System.out.println("Recursive: " + Arrays.toString(test6));

            // Verify all approaches produce the same result
            boolean allMatch = solution.compareArrays(test1, test2)
                    && solution.compareArrays(test2, test3) && solution.compareArrays(test3, test4)
                    && solution.compareArrays(test4, test5) && solution.compareArrays(test5, test6);

            System.out.println("All approaches match: " + allMatch);
            System.out.println("Zeros at end: " + solution.verifyZeroesAtEnd(test1));
        }

        // Performance comparison
        System.out.println("\nPerformance Analysis:");
        System.out.println("====================");

        int[] largeArray = new int[10000];
        for (int i = 0; i < 10000; i++) {
            largeArray[i] = (i % 3 == 0) ? 0 : i; // Every third element is zero
        }

        long startTime, endTime;

        int[] testArray1 = largeArray.clone();
        startTime = System.nanoTime();
        solution.moveZeroesTwoPointers(testArray1);
        endTime = System.nanoTime();
        System.out.println("Two Pointers: " + (endTime - startTime) + " ns");

        int[] testArray2 = largeArray.clone();
        startTime = System.nanoTime();
        solution.moveZeroesTwoPass(testArray2);
        endTime = System.nanoTime();
        System.out.println("Two Pass: " + (endTime - startTime) + " ns");

        int[] testArray3 = largeArray.clone();
        startTime = System.nanoTime();
        solution.moveZeroesOptimized(testArray3);
        endTime = System.nanoTime();
        System.out.println("Optimized: " + (endTime - startTime) + " ns");

        // Edge case analysis
        System.out.println("\nEdge Case Analysis:");
        System.out.println("==================");

        // Test with all zeros
        int[] allZeros = {0, 0, 0, 0, 0};
        solution.moveZeroesTwoPointers(allZeros);
        System.out.println("All zeros: " + Arrays.toString(allZeros));

        // Test with no zeros
        int[] noZeros = {1, 2, 3, 4, 5};
        solution.moveZeroesTwoPointers(noZeros);
        System.out.println("No zeros: " + Arrays.toString(noZeros));

        // Test with single element
        int[] single = {0};
        solution.moveZeroesTwoPointers(single);
        System.out.println("Single zero: " + Arrays.toString(single));

        int[] singleNonZero = {1};
        solution.moveZeroesTwoPointers(singleNonZero);
        System.out.println("Single non-zero: " + Arrays.toString(singleNonZero));
    }
}
