package com.example.leetcode;

/**
 * LeetCode 278: First Bad Version
 * 
 * Problem Description: You are a product manager and currently leading a team to develop a new
 * product. Unfortunately, the latest version of your product fails the quality check. Since each
 * version is developed based on the previous version, all the versions after a bad version are also
 * bad.
 * 
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which
 * causes all the following ones to be bad.
 * 
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a
 * function to find the first bad version. You should minimize the number of calls to the API.
 * 
 * Example 1: Input: n = 5, bad = 4 Output: 4 Explanation: call isBadVersion(3) -> false call
 * isBadVersion(5) -> true call isBadVersion(4) -> true Then 4 is the first bad version.
 * 
 * Example 2: Input: n = 1, bad = 1 Output: 1
 * 
 * Constraints: - 1 <= bad <= n <= 2^31 - 1
 * 
 * Time Complexity: O(log n) Space Complexity: O(1)
 */
public class FirstBadVersion {

    // Mock API for testing purposes
    private int firstBadVersion;

    public FirstBadVersion(int firstBadVersion) {
        this.firstBadVersion = firstBadVersion;
    }

    /**
     * Mock API that simulates the isBadVersion function
     */
    public boolean isBadVersion(int version) {
        return version >= firstBadVersion;
    }

    /**
     * Approach 1: Binary Search (Optimal) Use binary search to find the first bad version.
     * 
     * Time Complexity: O(log n) Space Complexity: O(1)
     */
    public int firstBadVersionBinarySearch(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be at least 1");
        }

        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2; // Avoid overflow
            if (isBadVersion(mid)) {
                right = mid; // First bad version is at mid or before
            } else {
                left = mid + 1; // First bad version is after mid
            }
        }

        return left;
    }

    /**
     * Approach 2: Recursive Binary Search Use recursive binary search to find the first bad
     * version.
     * 
     * Time Complexity: O(log n) Space Complexity: O(log n) due to recursion stack
     */
    public int firstBadVersionRecursive(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be at least 1");
        }
        return firstBadVersionRecursiveHelper(1, n);
    }

    private int firstBadVersionRecursiveHelper(int left, int right) {
        if (left == right) {
            return left;
        }

        int mid = left + (right - left) / 2;
        if (isBadVersion(mid)) {
            return firstBadVersionRecursiveHelper(left, mid);
        } else {
            return firstBadVersionRecursiveHelper(mid + 1, right);
        }
    }

    /**
     * Approach 3: Linear Search (Educational) Use linear search to find the first bad version.
     * 
     * Time Complexity: O(n) Space Complexity: O(1)
     */
    public int firstBadVersionLinear(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be at least 1");
        }

        for (int i = 1; i <= n; i++) {
            if (isBadVersion(i)) {
                return i;
            }
        }

        return n; // All versions are bad
    }

    /**
     * Approach 4: Optimized Binary Search with Early Termination Use binary search with additional
     * optimizations.
     * 
     * Time Complexity: O(log n) Space Complexity: O(1)
     */
    public int firstBadVersionOptimized(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be at least 1");
        }

        // Early termination: if first version is bad, return 1
        if (isBadVersion(1)) {
            return 1;
        }

        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    /**
     * Approach 5: Binary Search with API Call Counting Use binary search while counting API calls.
     * 
     * Time Complexity: O(log n) Space Complexity: O(1)
     */
    public int firstBadVersionWithCounting(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be at least 1");
        }

        int left = 1;
        int right = n;
        int apiCalls = 0;

        while (left < right) {
            int mid = left + (right - left) / 2;
            apiCalls++;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // System.out.println("API calls made: " + apiCalls);
        return left;
    }

    /**
     * Approach 6: Ternary Search (Alternative) Use ternary search to find the first bad version.
     * 
     * Time Complexity: O(log n) Space Complexity: O(1)
     */
    public int firstBadVersionTernary(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be at least 1");
        }

        int left = 1;
        int right = n;

        while (left < right) {
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;

            if (isBadVersion(mid1)) {
                right = mid1;
            } else if (isBadVersion(mid2)) {
                left = mid1 + 1;
                right = mid2;
            } else {
                left = mid2 + 1;
            }
        }

        return left;
    }

    /**
     * Approach 7: Binary Search with Boundary Optimization Use binary search with boundary
     * optimizations.
     * 
     * Time Complexity: O(log n) Space Complexity: O(1)
     */
    public int firstBadVersionBoundaryOptimized(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be at least 1");
        }

        // Check boundaries first
        if (isBadVersion(1)) {
            return 1;
        }
        if (!isBadVersion(n)) {
            return -1; // No bad version found
        }

        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    /**
     * Utility method to count API calls for performance analysis
     */
    public int countApiCalls(int n, int approach) {
        int apiCalls = 0;
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            apiCalls++;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return apiCalls;
    }

    /**
     * Utility method to verify if a version is the first bad version
     */
    public boolean verifyFirstBadVersion(int version) {
        if (version < 1) {
            return false;
        }
        return isBadVersion(version) && (version == 1 || !isBadVersion(version - 1));
    }

    /**
     * Utility method to generate test cases
     */
    public static int[][] generateTestCases() {
        return new int[][] {{5, 4}, {1, 1}, {10, 3}, {100, 50}, {1000, 1}, {1000, 1000},
                {Integer.MAX_VALUE / 2, Integer.MAX_VALUE / 4}};
    }

    /**
     * Utility method to calculate expected API calls for binary search
     */
    public static int calculateExpectedApiCalls(int n) {
        if (n <= 1) {
            return 1;
        }
        return (int) Math.ceil(Math.log(n) / Math.log(2));
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
     * Main method for testing
     */
    public static void main(String[] args) {
        System.out.println("Testing First Bad Version Solutions:");
        System.out.println("====================================");

        int[][] testCases = generateTestCases();

        for (int i = 0; i < testCases.length; i++) {
            int n = testCases[i][0];
            int expectedBad = testCases[i][1];

            System.out.println("\nTest Case " + (i + 1) + ":");
            System.out.println("n = " + n + ", Expected first bad version = " + expectedBad);

            // Test all approaches
            FirstBadVersion solution = new FirstBadVersion(expectedBad);

            int result1 = solution.firstBadVersionBinarySearch(n);
            int result2 = solution.firstBadVersionRecursive(n);
            int result3 = solution.firstBadVersionLinear(n);
            int result4 = solution.firstBadVersionOptimized(n);
            int result5 = solution.firstBadVersionWithCounting(n);
            int result6 = solution.firstBadVersionTernary(n);
            int result7 = solution.firstBadVersionBoundaryOptimized(n);

            System.out.println("Binary Search: " + result1);
            System.out.println("Recursive: " + result2);
            System.out.println("Linear: " + result3);
            System.out.println("Optimized: " + result4);
            System.out.println("With Counting: " + result5);
            System.out.println("Ternary: " + result6);
            System.out.println("Boundary Optimized: " + result7);

            // Verify all approaches produce the same result
            boolean allMatch = (result1 == result2) && (result2 == result3) && (result3 == result4)
                    && (result4 == result5) && (result5 == result6) && (result6 == result7)
                    && (result1 == expectedBad);

            System.out.println("All approaches match: " + allMatch);
            System.out.println("Result matches expected: " + (result1 == expectedBad));
        }

        // Performance comparison
        System.out.println("\nPerformance Analysis:");
        System.out.println("====================");

        int largeN = 1000000;
        int expectedBad = 500000;

        long startTime, endTime;

        // Test binary search approach
        FirstBadVersion solution = new FirstBadVersion(expectedBad);
        startTime = System.nanoTime();
        int result = solution.firstBadVersionBinarySearch(largeN);
        endTime = System.nanoTime();
        System.out.println("Binary Search (n=" + largeN + "): " + (endTime - startTime) + " ns");

        // Test linear search approach
        startTime = System.nanoTime();
        result = solution.firstBadVersionLinear(largeN);
        endTime = System.nanoTime();
        System.out.println("Linear Search (n=" + largeN + "): " + (endTime - startTime) + " ns");

        // API call analysis
        System.out.println("\nAPI Call Analysis:");
        System.out.println("==================");
        for (int n = 10; n <= 1000; n *= 10) {
            int apiCalls = solution.countApiCalls(n, 1);
            int expectedCalls = calculateExpectedApiCalls(n);
            System.out.println(
                    "n=" + n + ": Actual calls=" + apiCalls + ", Expected=" + expectedCalls);
        }

        // Edge case analysis
        System.out.println("\nEdge Case Analysis:");
        System.out.println("==================");

        // Test with n = 1
        FirstBadVersion edgeCase1 = new FirstBadVersion(1);
        System.out.println("n=1, bad=1: " + edgeCase1.firstBadVersionBinarySearch(1));

        // Test with all versions bad
        FirstBadVersion edgeCase2 = new FirstBadVersion(1);
        System.out.println("n=5, bad=1: " + edgeCase2.firstBadVersionBinarySearch(5));

        // Test with last version bad
        FirstBadVersion edgeCase3 = new FirstBadVersion(5);
        System.out.println("n=5, bad=5: " + edgeCase3.firstBadVersionBinarySearch(5));
    }
}
