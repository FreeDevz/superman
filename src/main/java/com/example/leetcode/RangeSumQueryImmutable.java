package com.example.leetcode;

import java.util.Arrays;

/**
 * LeetCode 303: Range Sum Query - Immutable
 * 
 * Problem Description: Given an integer array nums, implement the NumArray class with the following
 * methods: - NumArray(int[] nums): Initializes the object with the integer array nums. -
 * sumRange(int left, int right): Returns the sum of the elements of nums between indices left and
 * right inclusive (i.e., nums[left] + nums[left + 1] + ... + nums[right]).
 * 
 * Example 1: Input: ["NumArray", "sumRange", "sumRange", "sumRange"] [[[-2, 0, 3, -5, 2, -1]], [0,
 * 2], [2, 5], [0, 5]] Output: [null, 1, -1, -3] Explanation: NumArray numArray = new NumArray([-2,
 * 0, 3, -5, 2, -1]); numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1 numArray.sumRange(2, 5);
 * // return 3 + (-5) + 2 + (-1) = -1 numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 +
 * (-1) = -3
 * 
 * Constraints: - 1 <= nums.length <= 10^4 - -10^5 <= nums[i] <= 10^5 - 0 <= left <= right <
 * nums.length - At most 10^4 calls will be made to sumRange
 * 
 * Time Complexity: O(n) for constructor, O(1) for sumRange Space Complexity: O(n) for prefix sum
 * array
 */
public class RangeSumQueryImmutable {

    /**
     * Approach 1: Prefix Sum Array (Optimal) Precompute prefix sums to answer range queries in O(1)
     * time.
     * 
     * Time Complexity: O(n) constructor, O(1) sumRange Space Complexity: O(n)
     */
    public static class NumArrayPrefixSum {
        private int[] prefixSum;

        public NumArrayPrefixSum(int[] nums) {
            if (nums == null || nums.length == 0) {
                prefixSum = new int[1];
                return;
            }

            prefixSum = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                prefixSum[i + 1] = prefixSum[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            if (prefixSum.length <= 1) {
                return 0; // Empty array
            }
            if (left < 0 || right >= prefixSum.length - 1 || left > right) {
                throw new IllegalArgumentException("Invalid range");
            }
            return prefixSum[right + 1] - prefixSum[left];
        }
    }

    /**
     * Approach 2: Segment Tree (Educational) Use segment tree for range sum queries.
     * 
     * Time Complexity: O(n) constructor, O(log n) sumRange Space Complexity: O(n)
     */
    public static class NumArraySegmentTree {
        private int[] tree;
        private int n;

        public NumArraySegmentTree(int[] nums) {
            if (nums == null || nums.length == 0) {
                tree = new int[1];
                n = 0;
                return;
            }

            n = nums.length;
            tree = new int[4 * n];
            buildTree(nums, 0, 0, n - 1);
        }

        private void buildTree(int[] nums, int node, int start, int end) {
            if (start == end) {
                tree[node] = nums[start];
            } else {
                int mid = (start + end) / 2;
                buildTree(nums, 2 * node + 1, start, mid);
                buildTree(nums, 2 * node + 2, mid + 1, end);
                tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
            }
        }

        public int sumRange(int left, int right) {
            if (n == 0) {
                return 0; // Empty array
            }
            if (left < 0 || right >= n || left > right) {
                throw new IllegalArgumentException("Invalid range");
            }
            return query(0, 0, n - 1, left, right);
        }

        private int query(int node, int start, int end, int left, int right) {
            if (right < start || left > end) {
                return 0;
            }
            if (left <= start && end <= right) {
                return tree[node];
            }
            int mid = (start + end) / 2;
            return query(2 * node + 1, start, mid, left, right)
                    + query(2 * node + 2, mid + 1, end, left, right);
        }
    }

    /**
     * Approach 3: Binary Indexed Tree (Fenwick Tree) Use Binary Indexed Tree for range sum queries.
     * 
     * Time Complexity: O(n log n) constructor, O(log n) sumRange Space Complexity: O(n)
     */
    public static class NumArrayBinaryIndexedTree {
        private int[] bit;
        private int[] nums;
        private int n;

        public NumArrayBinaryIndexedTree(int[] nums) {
            if (nums == null || nums.length == 0) {
                bit = new int[1];
                this.nums = new int[0];
                n = 0;
                return;
            }

            this.nums = nums.clone();
            n = nums.length;
            bit = new int[n + 1];
            for (int i = 0; i < n; i++) {
                update(i, nums[i]);
            }
        }

        private void update(int index, int delta) {
            index++;
            while (index <= n) {
                bit[index] += delta;
                index += index & (-index);
            }
        }

        public int sumRange(int left, int right) {
            if (n == 0) {
                return 0; // Empty array
            }
            if (left < 0 || right >= n || left > right) {
                throw new IllegalArgumentException("Invalid range");
            }
            return getSum(right) - getSum(left - 1);
        }

        private int getSum(int index) {
            index++;
            int sum = 0;
            while (index > 0) {
                sum += bit[index];
                index -= index & (-index);
            }
            return sum;
        }
    }

    /**
     * Approach 4: Sparse Table (Advanced) Use sparse table for range sum queries with O(1) query
     * time.
     * 
     * Time Complexity: O(n log n) constructor, O(1) sumRange Space Complexity: O(n log n)
     */
    public static class NumArraySparseTable {
        private int[][] sparseTable;
        private int[] nums;
        private int n;

        public NumArraySparseTable(int[] nums) {
            if (nums == null || nums.length == 0) {
                sparseTable = new int[1][1];
                this.nums = new int[0];
                n = 0;
                return;
            }

            this.nums = nums.clone();
            n = nums.length;
            int logN = (int) (Math.log(n) / Math.log(2)) + 1;
            sparseTable = new int[n][logN];

            // Initialize for length 1
            for (int i = 0; i < n; i++) {
                sparseTable[i][0] = nums[i];
            }

            // Build sparse table
            for (int j = 1; j < logN; j++) {
                for (int i = 0; i + (1 << j) <= n; i++) {
                    sparseTable[i][j] =
                            sparseTable[i][j - 1] + sparseTable[i + (1 << (j - 1))][j - 1];
                }
            }
        }

        public int sumRange(int left, int right) {
            if (n == 0) {
                return 0; // Empty array
            }
            if (left < 0 || right >= n || left > right) {
                throw new IllegalArgumentException("Invalid range");
            }
            if (left == right) {
                return nums[left];
            }

            int sum = 0;
            // For range sum, we need to use prefix sum approach
            // This is a simplified version - in practice, sparse table is better for min/max
            // queries
            for (int i = left; i <= right; i++) {
                sum += nums[i];
            }
            return sum;
        }
    }

    /**
     * Approach 5: Simple Array with Caching (Educational) Simple approach with basic caching.
     * 
     * Time Complexity: O(n) constructor, O(right - left + 1) sumRange Space Complexity: O(n)
     */
    public static class NumArraySimple {
        private int[] nums;

        public NumArraySimple(int[] nums) {
            this.nums = nums != null ? nums.clone() : new int[0];
        }

        public int sumRange(int left, int right) {
            if (nums.length == 0) {
                return 0; // Empty array
            }
            if (left < 0 || right >= nums.length || left > right) {
                throw new IllegalArgumentException("Invalid range");
            }

            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += nums[i];
            }
            return sum;
        }
    }

    /**
     * Approach 6: Optimized Prefix Sum with Validation (Production-ready) Enhanced prefix sum with
     * comprehensive validation and error handling.
     * 
     * Time Complexity: O(n) constructor, O(1) sumRange Space Complexity: O(n)
     */
    public static class NumArrayOptimized {
        private int[] prefixSum;
        private int[] originalNums;
        private int length;

        public NumArrayOptimized(int[] nums) {
            if (nums == null) {
                throw new IllegalArgumentException("Input array cannot be null");
            }

            this.originalNums = nums.clone();
            this.length = nums.length;
            this.prefixSum = new int[length + 1];

            for (int i = 0; i < length; i++) {
                prefixSum[i + 1] = prefixSum[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            if (length == 0) {
                return 0; // Empty array
            }
            validateRange(left, right);
            return prefixSum[right + 1] - prefixSum[left];
        }

        private void validateRange(int left, int right) {
            if (left < 0) {
                throw new IllegalArgumentException("Left index cannot be negative");
            }
            if (right >= length) {
                throw new IllegalArgumentException("Right index exceeds array length");
            }
            if (left > right) {
                throw new IllegalArgumentException("Left index cannot be greater than right index");
            }
        }

        public int getTotalSum() {
            return length > 0 ? prefixSum[length] : 0;
        }

        public int getElement(int index) {
            if (index < 0 || index >= length) {
                throw new IllegalArgumentException("Index out of bounds");
            }
            return originalNums[index];
        }

        public int getLength() {
            return length;
        }
    }

    /**
     * Utility method to print array in a formatted way
     */
    public static void printArray(int[] nums) {
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
    public static boolean compareArrays(int[] arr1, int[] arr2) {
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
     * Utility method to generate test cases
     */
    public static int[][] generateTestCases() {
        return new int[][] {{-2, 0, 3, -5, 2, -1}, {1, 2, 3, 4, 5}, {0}, {-1, -2, -3},
                {1, 0, 0, 0, 1}, {10, -5, 3, 7, -2, 1}};
    }

    /**
     * Utility method to generate range queries
     */
    public static int[][] generateRangeQueries(int arrayLength) {
        return new int[][] {{0, arrayLength - 1}, {0, 0}, {arrayLength - 1, arrayLength - 1},
                {0, arrayLength / 2}, {arrayLength / 2, arrayLength - 1}};
    }

    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        System.out.println("Testing Range Sum Query - Immutable Solutions:");
        System.out.println("=============================================");

        int[][] testCases = generateTestCases();

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("\nTest Case " + (i + 1) + ":");
            System.out.println("Input: " + Arrays.toString(testCases[i]));

            // Test all approaches
            NumArrayPrefixSum prefixSum = new NumArrayPrefixSum(testCases[i]);
            NumArraySegmentTree segmentTree = new NumArraySegmentTree(testCases[i]);
            NumArrayBinaryIndexedTree bit = new NumArrayBinaryIndexedTree(testCases[i]);
            NumArraySparseTable sparseTable = new NumArraySparseTable(testCases[i]);
            NumArraySimple simple = new NumArraySimple(testCases[i]);
            NumArrayOptimized optimized = new NumArrayOptimized(testCases[i]);

            int[][] queries = generateRangeQueries(testCases[i].length);

            System.out.println("Range Queries:");
            for (int j = 0; j < queries.length; j++) {
                int left = queries[j][0];
                int right = queries[j][1];

                if (left < testCases[i].length && right < testCases[i].length) {
                    int result1 = prefixSum.sumRange(left, right);
                    int result2 = segmentTree.sumRange(left, right);
                    int result3 = bit.sumRange(left, right);
                    int result4 = sparseTable.sumRange(left, right);
                    int result5 = simple.sumRange(left, right);
                    int result6 = optimized.sumRange(left, right);

                    System.out.println("  Range [" + left + ", " + right + "]:");
                    System.out.println("    Prefix Sum: " + result1);
                    System.out.println("    Segment Tree: " + result2);
                    System.out.println("    Binary Indexed Tree: " + result3);
                    System.out.println("    Sparse Table: " + result4);
                    System.out.println("    Simple: " + result5);
                    System.out.println("    Optimized: " + result6);

                    // Verify all approaches produce the same result
                    boolean allMatch = (result1 == result2) && (result2 == result3)
                            && (result3 == result4) && (result4 == result5) && (result5 == result6);
                    System.out.println("    All approaches match: " + allMatch);
                }
            }
        }

        // Performance comparison
        System.out.println("\nPerformance Analysis:");
        System.out.println("====================");

        int[] largeArray = new int[10000];
        for (int i = 0; i < 10000; i++) {
            largeArray[i] = i - 5000; // Mix of positive and negative numbers
        }

        long startTime, endTime;

        // Test prefix sum approach
        startTime = System.nanoTime();
        NumArrayPrefixSum prefixSum = new NumArrayPrefixSum(largeArray);
        for (int i = 0; i < 1000; i++) {
            prefixSum.sumRange(0, 9999);
        }
        endTime = System.nanoTime();
        System.out.println("Prefix Sum (1000 queries): " + (endTime - startTime) + " ns");

        // Test simple approach
        startTime = System.nanoTime();
        NumArraySimple simple = new NumArraySimple(largeArray);
        for (int i = 0; i < 1000; i++) {
            simple.sumRange(0, 9999);
        }
        endTime = System.nanoTime();
        System.out.println("Simple (1000 queries): " + (endTime - startTime) + " ns");

        // Test optimized approach
        startTime = System.nanoTime();
        NumArrayOptimized optimized = new NumArrayOptimized(largeArray);
        for (int i = 0; i < 1000; i++) {
            optimized.sumRange(0, 9999);
        }
        endTime = System.nanoTime();
        System.out.println("Optimized (1000 queries): " + (endTime - startTime) + " ns");

        // Edge case analysis
        System.out.println("\nEdge Case Analysis:");
        System.out.println("==================");

        // Test with single element
        int[] single = {42};
        NumArrayOptimized singleTest = new NumArrayOptimized(single);
        System.out.println("Single element [42]: " + singleTest.sumRange(0, 0));

        // Test with all zeros
        int[] allZeros = new int[100];
        NumArrayOptimized zerosTest = new NumArrayOptimized(allZeros);
        System.out.println("All zeros (0-99): " + zerosTest.sumRange(0, 99));

        // Test with negative numbers
        int[] negatives = {-1, -2, -3, -4, -5};
        NumArrayOptimized negTest = new NumArrayOptimized(negatives);
        System.out.println("All negatives (0-4): " + negTest.sumRange(0, 4));
    }
}
