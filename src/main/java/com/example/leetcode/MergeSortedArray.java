package com.example.leetcode;

import java.util.Arrays;

/**
 * LeetCode 88: Merge Sorted Array
 * 
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two
 * integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * 
 * Merge nums2 into nums1 as one sorted array. The final sorted array should not be returned by the
 * function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length
 * of m + n, where the first m elements denote the elements that should be merged, and the last n
 * elements are set to 0 and should be ignored. nums2 has a length of n.
 * 
 * Examples: Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3 Output: [1,2,2,3,5,6]
 * 
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0 Output: [1]
 * 
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1 Output: [1]
 * 
 * Constraints: - nums1.length == m + n - nums2.length == n - 0 <= m, n <= 200 - 1 <= m + n <= 200 -
 * -10^9 <= nums1[i], nums2[j] <= 10^9
 */
public class MergeSortedArray {

    // ========================================
    // APPROACH 1: TWO POINTERS FROM END (RECOMMENDED)
    // Time: O(m + n), Space: O(1)
    // ========================================

    /**
     * Approach 1: Two Pointers from End (Optimal Solution)
     * 
     * This is the most efficient approach for merging sorted arrays in-place. The key insight is to
     * work backwards from the end of nums1 to avoid overwriting elements that haven't been
     * processed yet.
     * 
     * Algorithm: 1. Start from the end of both arrays (last valid elements) 2. Compare elements and
     * place the larger one at the end of nums1 3. Move pointers backwards 4. Continue until all
     * elements from nums2 are processed
     * 
     * Time Complexity: O(m + n) where m and n are the lengths of the arrays Space Complexity: O(1)
     * as we modify nums1 in-place
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Pointers for the last valid elements in each array
        int i = m - 1; // Last valid element in nums1
        int j = n - 1; // Last element in nums2
        int k = m + n - 1; // Last position in nums1

        // Merge from the end
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }

    // ========================================
    // APPROACH 2: COPY AND SORT
    // Time: O((m + n) log(m + n)), Space: O(1)
    // ========================================

    /**
     * Approach 2: Copy and Sort
     * 
     * This approach copies all elements from nums2 to nums1 and then sorts the entire array. While
     * simple, it's not optimal due to the sorting step.
     * 
     * Algorithm: 1. Copy all elements from nums2 to the end of nums1 2. Sort the entire nums1 array
     * 
     * Time Complexity: O((m + n) log(m + n)) due to sorting Space Complexity: O(1) as we modify
     * nums1 in-place
     */
    public void mergeCopyAndSort(int[] nums1, int m, int[] nums2, int n) {
        // Copy nums2 to the end of nums1
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        // Sort only the merged portion (first m + n elements)
        Arrays.sort(nums1, 0, m + n);
    }

    // ========================================
    // APPROACH 3: AUXILIARY ARRAY
    // Time: O(m + n), Space: O(m + n)
    // ========================================

    /**
     * Approach 3: Auxiliary Array
     * 
     * This approach uses an auxiliary array to store the merged result, then copies it back to
     * nums1. While it has optimal time complexity, it uses extra space.
     * 
     * Algorithm: 1. Create an auxiliary array of size m + n 2. Use two pointers to merge elements
     * into the auxiliary array 3. Copy the result back to nums1
     * 
     * Time Complexity: O(m + n) where m and n are the lengths of the arrays Space Complexity: O(m +
     * n) for the auxiliary array
     */
    public void mergeAuxiliaryArray(int[] nums1, int m, int[] nums2, int n) {
        int[] merged = new int[m + n];
        int i = 0, j = 0, k = 0;

        // Merge elements from both arrays
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        // Copy remaining elements from nums1
        while (i < m) {
            merged[k++] = nums1[i++];
        }

        // Copy remaining elements from nums2
        while (j < n) {
            merged[k++] = nums2[j++];
        }

        // Copy result back to nums1
        for (int idx = 0; idx < m + n; idx++) {
            nums1[idx] = merged[idx];
        }
    }

    // ========================================
    // APPROACH 4: TWO POINTERS FROM START
    // Time: O(m + n), Space: O(m)
    // ========================================

    /**
     * Approach 4: Two Pointers from Start with Backup
     * 
     * This approach works from the start but requires backing up the first m elements of nums1 to
     * avoid overwriting them during the merge process.
     * 
     * Algorithm: 1. Create a backup of the first m elements of nums1 2. Use two pointers to merge
     * from the start 3. Compare elements from backup and nums2
     * 
     * Time Complexity: O(m + n) where m and n are the lengths of the arrays Space Complexity: O(m)
     * for backing up the first m elements
     */
    public void mergeTwoPointersFromStart(int[] nums1, int m, int[] nums2, int n) {
        // Create backup of first m elements
        int[] nums1Backup = new int[m];
        for (int i = 0; i < m; i++) {
            nums1Backup[i] = nums1[i];
        }

        int i = 0, j = 0, k = 0;

        // Merge from the start
        while (i < m && j < n) {
            if (nums1Backup[i] <= nums2[j]) {
                nums1[k++] = nums1Backup[i++];
            } else {
                nums1[k++] = nums2[j++];
            }
        }

        // Copy remaining elements from backup
        while (i < m) {
            nums1[k++] = nums1Backup[i++];
        }

        // Copy remaining elements from nums2
        while (j < n) {
            nums1[k++] = nums2[j++];
        }
    }

    // ========================================
    // APPROACH 5: OPTIMIZED TWO POINTERS FROM END
    // Time: O(m + n), Space: O(1)
    // ========================================

    /**
     * Approach 5: Optimized Two Pointers from End
     * 
     * This is an optimized version of the two pointers from end approach with better variable
     * naming and slightly more efficient logic.
     * 
     * Algorithm: 1. Use three pointers: last valid in nums1, last in nums2, last position in nums1
     * 2. Compare and place larger elements at the end 3. Handle remaining elements efficiently
     * 
     * Time Complexity: O(m + n) where m and n are the lengths of the arrays Space Complexity: O(1)
     * as we modify nums1 in-place
     */
    public void mergeOptimized(int[] nums1, int m, int[] nums2, int n) {
        int nums1Last = m - 1; // Last valid element in nums1
        int nums2Last = n - 1; // Last element in nums2
        int mergedLast = m + n - 1; // Last position in merged array

        // Merge from the end
        while (nums2Last >= 0) {
            if (nums1Last >= 0 && nums1[nums1Last] > nums2[nums2Last]) {
                nums1[mergedLast] = nums1[nums1Last];
                nums1Last--;
            } else {
                nums1[mergedLast] = nums2[nums2Last];
                nums2Last--;
            }
            mergedLast--;
        }
    }

    // ========================================
    // APPROACH 6: RECURSIVE MERGE
    // Time: O(m + n), Space: O(m + n) due to recursion stack
    // ========================================

    /**
     * Approach 6: Recursive Merge
     * 
     * This approach uses recursion to merge the arrays, demonstrating an alternative way to think
     * about the problem. While elegant, it uses more space due to the call stack.
     * 
     * Algorithm: 1. Base case: if one array is empty, copy the other 2. Recursive case: compare
     * elements and recursively merge the rest
     * 
     * Time Complexity: O(m + n) where m and n are the lengths of the arrays Space Complexity: O(m +
     * n) due to recursion call stack
     */
    public void mergeRecursive(int[] nums1, int m, int[] nums2, int n) {
        mergeRecursiveHelper(nums1, m, nums2, n, m + n - 1);
    }

    private void mergeRecursiveHelper(int[] nums1, int m, int[] nums2, int n, int pos) {
        // Base cases
        if (n == 0) {
            return; // nums2 is empty, nums1 is already correct
        }
        if (m == 0) {
            // nums1 is empty, copy remaining elements from nums2
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        // Recursive case: place the larger element at position pos
        if (nums1[m - 1] > nums2[n - 1]) {
            nums1[pos] = nums1[m - 1];
            mergeRecursiveHelper(nums1, m - 1, nums2, n, pos - 1);
        } else {
            nums1[pos] = nums2[n - 1];
            mergeRecursiveHelper(nums1, m, nums2, n - 1, pos - 1);
        }
    }

    // ========================================
    // UTILITY METHODS
    // ========================================

    /**
     * Create a test case with the given parameters
     * 
     * @param nums1Values Values for nums1 (including zeros for padding)
     * @param m Number of valid elements in nums1
     * @param nums2Values Values for nums2
     * @param n Number of elements in nums2
     * @return Test case data
     */
    public static TestCase createTestCase(int[] nums1Values, int m, int[] nums2Values, int n) {
        return new TestCase(nums1Values, m, nums2Values, n);
    }

    /**
     * Test case data structure
     */
    public static class TestCase {
        public final int[] nums1;
        public final int m;
        public final int[] nums2;
        public final int n;
        public final int[] expected;

        public TestCase(int[] nums1Values, int m, int[] nums2Values, int n) {
            this.nums1 = nums1Values.clone();
            this.m = m;
            this.nums2 = nums2Values.clone();
            this.n = n;

            // Calculate expected result - should be the full nums1 array after merging
            int[] expectedArray = nums1Values.clone();
            int i = m - 1; // Last valid element in nums1
            int j = n - 1; // Last element in nums2
            int k = m + n - 1; // Last position in nums1

            // Merge from the end (same logic as the optimal solution)
            while (j >= 0) {
                if (i >= 0 && expectedArray[i] > nums2Values[j]) {
                    expectedArray[k] = expectedArray[i];
                    i--;
                } else {
                    expectedArray[k] = nums2Values[j];
                    j--;
                }
                k--;
            }

            this.expected = expectedArray;
        }
    }

    /**
     * Create comprehensive test cases
     */
    public static TestCase[] createTestCases() {
        return new TestCase[] {
                // Test case 1: Basic merge
                createTestCase(new int[] {1, 2, 3, 0, 0, 0}, 3, new int[] {2, 5, 6}, 3),

                // Test case 2: nums1 has only one element
                createTestCase(new int[] {1}, 1, new int[] {}, 0),

                // Test case 3: nums2 has only one element
                createTestCase(new int[] {0}, 0, new int[] {1}, 1),

                // Test case 4: nums1 is empty
                createTestCase(new int[] {0, 0}, 0, new int[] {1, 2}, 2),

                // Test case 5: nums2 is empty
                createTestCase(new int[] {1, 2, 3, 0, 0}, 3, new int[] {}, 0),

                // Test case 6: All elements in nums1 are smaller
                createTestCase(new int[] {1, 2, 3, 0, 0, 0}, 3, new int[] {4, 5, 6}, 3),

                // Test case 7: All elements in nums2 are smaller
                createTestCase(new int[] {4, 5, 6, 0, 0, 0}, 3, new int[] {1, 2, 3}, 3),

                // Test case 8: Single elements
                createTestCase(new int[] {2, 0}, 1, new int[] {1}, 1),

                // Test case 9: Negative numbers
                createTestCase(new int[] {-1, 0, 0, 3, 3, 3, 0, 0, 0}, 6, new int[] {1, 2, 2}, 3),

                // Test case 10: Duplicate elements
                createTestCase(new int[] {1, 1, 1, 0, 0, 0}, 3, new int[] {1, 1, 1}, 3),

                // Test case 11: Large numbers
                createTestCase(new int[] {1000000000, 0}, 1, new int[] {1000000000}, 1),

                // Test case 12: Minimum constraint
                createTestCase(new int[] {1, 0}, 1, new int[] {2}, 1),

                // Test case 13: Maximum constraint (200 elements)
                createTestCase(createLargeArray(100, 200), 100, createLargeArray(100, 200), 100),

                // Test case 14: Edge case with zeros
                createTestCase(new int[] {0, 0, 0, 0, 0}, 0, new int[] {1, 2, 3, 4, 5}, 5),

                // Test case 15: Edge case with all same values
                createTestCase(new int[] {5, 5, 5, 0, 0, 0}, 3, new int[] {5, 5, 5}, 3)};
    }

    /**
     * Create a large array for testing
     */
    private static int[] createLargeArray(int size, int maxSize) {
        int[] array = new int[maxSize];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    /**
     * Compare two arrays for equality
     */
    public boolean arraysEqual(int[] arr1, int[] arr2) {
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
     * Print array for debugging
     */
    public String arrayToString(int[] arr) {
        return Arrays.toString(arr);
    }

    /**
     * Validate that the merged array is sorted
     */
    public boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Validate that the merged array is sorted up to a given length
     */
    public boolean isSorted(int[] arr, int length) {
        for (int i = 1; i < length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
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
     * Compare results from different approaches
     */
    public boolean compareResults(int[] result1, int[] result2) {
        return arraysEqual(result1, result2);
    }

    /**
     * Get array statistics
     */
    public String getArrayStatistics(int[] arr) {
        if (arr.length == 0) {
            return "Empty array";
        }

        int min = arr[0];
        int max = arr[0];
        int sum = 0;
        boolean isSorted = true;

        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            sum += arr[i];

            if (i > 0 && arr[i] < arr[i - 1]) {
                isSorted = false;
            }
        }

        return String.format("Array Statistics: Length=%d, Min=%d, Max=%d, Sum=%d, IsSorted=%s",
                arr.length, min, max, sum, isSorted);
    }
}
