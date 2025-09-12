package com.example.leetcode;

import java.util.*;

/**
 * LeetCode 119: Pascal's Triangle II
 * 
 * Problem Description: Given an integer rowIndex, return the rowIndexth (0-indexed) row of the
 * Pascal's triangle. In Pascal's triangle, each number is the sum of the two numbers directly above
 * it as shown:
 * 
 * Example 1: Input: rowIndex = 3 Output: [1,3,3,1]
 * 
 * Example 2: Input: rowIndex = 0 Output: [1]
 * 
 * Example 3: Input: rowIndex = 1 Output: [1,1]
 * 
 * Constraints: - 0 <= rowIndex <= 33
 * 
 * Approach 1: Iterative In-Place (Optimal) Time Complexity: O(k²) Space Complexity: O(k)
 * 
 * Approach 2: Mathematical Formula Time Complexity: O(k) Space Complexity: O(k)
 * 
 * Approach 3: Recursive Approach Time Complexity: O(2^k) Space Complexity: O(k)
 * 
 * Approach 4: Two Arrays Time Complexity: O(k²) Space Complexity: O(k)
 * 
 * Approach 5: Combinatorial Formula Time Complexity: O(k) Space Complexity: O(k)
 * 
 * Approach 6: Dynamic Programming Time Complexity: O(k²) Space Complexity: O(k)
 */
public class PascalsTriangleII {

    /**
     * Approach 1: Iterative In-Place (Optimal Solution)
     * 
     * This is the most efficient solution. We build the row in-place by iterating from right to
     * left to avoid overwriting values we need for the current calculation.
     * 
     * @param rowIndex the 0-indexed row number to return
     * @return the rowIndexth row of Pascal's triangle
     */
    public List<Integer> getRowIterative(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        // Initialize the row with all 1s
        for (int i = 0; i <= rowIndex; i++) {
            row.add(1);
        }

        // Build the row in-place from right to left
        for (int i = 2; i <= rowIndex; i++) {
            for (int j = i - 1; j >= 1; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }

        return row;
    }

    /**
     * Approach 2: Mathematical Formula (Combinatorial)
     * 
     * Each element in Pascal's triangle can be calculated using the combinatorial formula: C(n, k)
     * = n! / (k! * (n-k)!)
     * 
     * @param rowIndex the 0-indexed row number to return
     * @return the rowIndexth row of Pascal's triangle
     */
    public List<Integer> getRowMathematical(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        for (int k = 0; k <= rowIndex; k++) {
            row.add(combinations(rowIndex, k));
        }

        return row;
    }

    /**
     * Calculate combinations C(n, k) = n! / (k! * (n-k)!) Optimized to avoid overflow by
     * calculating incrementally
     */
    private int combinations(int n, int k) {
        if (k > n - k) {
            k = n - k; // Take advantage of symmetry
        }

        long result = 1;
        for (int i = 0; i < k; i++) {
            result = result * (n - i) / (i + 1);
        }

        return (int) result;
    }

    /**
     * Approach 3: Recursive Approach
     * 
     * Recursively calculate each element using the property that each element is the sum of the two
     * elements above it. This approach is inefficient but demonstrates the recursive nature of
     * Pascal's triangle.
     * 
     * @param rowIndex the 0-indexed row number to return
     * @return the rowIndexth row of Pascal's triangle
     */
    public List<Integer> getRowRecursive(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        for (int k = 0; k <= rowIndex; k++) {
            row.add(getElementRecursive(rowIndex, k));
        }

        return row;
    }

    /**
     * Recursively calculate the element at position (row, col) in Pascal's triangle
     */
    private int getElementRecursive(int row, int col) {
        // Base cases
        if (col == 0 || col == row) {
            return 1;
        }

        // Recursive case: sum of two elements above
        return getElementRecursive(row - 1, col - 1) + getElementRecursive(row - 1, col);
    }

    /**
     * Approach 4: Two Arrays
     * 
     * Use two arrays to build the current row from the previous row. This approach is more
     * intuitive but uses more space.
     * 
     * @param rowIndex the 0-indexed row number to return
     * @return the rowIndexth row of Pascal's triangle
     */
    public List<Integer> getRowTwoArrays(int rowIndex) {
        if (rowIndex == 0) {
            return Arrays.asList(1);
        }

        List<Integer> prevRow = Arrays.asList(1, 1);

        for (int i = 2; i <= rowIndex; i++) {
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1); // First element is always 1

            // Calculate middle elements
            for (int j = 1; j < i; j++) {
                currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            currentRow.add(1); // Last element is always 1
            prevRow = currentRow;
        }

        return prevRow;
    }

    /**
     * Approach 5: Combinatorial Formula with Memoization
     * 
     * Use the combinatorial formula with memoization to avoid recalculating factorials.
     * 
     * @param rowIndex the 0-indexed row number to return
     * @return the rowIndexth row of Pascal's triangle
     */
    public List<Integer> getRowCombinatorial(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        for (int k = 0; k <= rowIndex; k++) {
            row.add(combinationsMemoized(rowIndex, k));
        }

        return row;
    }

    private Map<String, Integer> memo = new HashMap<>();

    /**
     * Calculate combinations with memoization
     */
    private int combinationsMemoized(int n, int k) {
        if (k > n - k) {
            k = n - k;
        }

        String key = n + "," + k;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        long result = 1;
        for (int i = 0; i < k; i++) {
            result = result * (n - i) / (i + 1);
        }

        int intResult = (int) result;
        memo.put(key, intResult);
        return intResult;
    }

    /**
     * Approach 6: Dynamic Programming
     * 
     * Use dynamic programming to build the triangle row by row, storing only the current row.
     * 
     * @param rowIndex the 0-indexed row number to return
     * @return the rowIndexth row of Pascal's triangle
     */
    public List<Integer> getRowDynamicProgramming(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        // Initialize with first element
        row.add(1);

        // Build the row incrementally
        for (int i = 1; i <= rowIndex; i++) {
            // Add new element at the end
            row.add(1);

            // Update elements from right to left
            for (int j = i - 1; j >= 1; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }

        return row;
    }

    /**
     * Utility method to print a row for debugging
     * 
     * @param row the row to print
     */
    public static void printRow(List<Integer> row) {
        System.out.println("Row: " + row);
    }

    /**
     * Utility method to generate the entire Pascal's triangle up to a given row
     * 
     * @param numRows the number of rows to generate
     * @return the complete Pascal's triangle
     */
    public static List<List<Integer>> generatePascalsTriangle(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
                }
            }
            triangle.add(row);
        }

        return triangle;
    }

    /**
     * Utility method to verify if a row is correct by comparing with the complete triangle
     * 
     * @param rowIndex the row index to verify
     * @param row the row to verify
     * @return true if the row is correct
     */
    public static boolean verifyRow(int rowIndex, List<Integer> row) {
        List<List<Integer>> triangle = generatePascalsTriangle(rowIndex + 1);
        return triangle.get(rowIndex).equals(row);
    }

    /**
     * Main method to demonstrate all approaches
     */
    public static void main(String[] args) {
        PascalsTriangleII solution = new PascalsTriangleII();

        // Test cases
        int[] testCases = {0, 1, 2, 3, 4, 5, 10, 15, 20, 25, 30, 33};
        List<List<Integer>> expectedResults = Arrays.asList(Arrays.asList(1), Arrays.asList(1, 1),
                Arrays.asList(1, 2, 1), Arrays.asList(1, 3, 3, 1), Arrays.asList(1, 4, 6, 4, 1),
                Arrays.asList(1, 5, 10, 10, 5, 1),
                Arrays.asList(1, 10, 45, 120, 210, 252, 210, 120, 45, 10, 1),
                Arrays.asList(1, 15, 105, 455, 1365, 3003, 5005, 6435, 6435, 5005, 3003, 1365, 455,
                        105, 15, 1),
                Arrays.asList(1, 20, 190, 1140, 4845, 15504, 38760, 77520, 125970, 167960, 184756,
                        167960, 125970, 77520, 38760, 15504, 4845, 1140, 190, 20, 1),
                Arrays.asList(1, 25, 300, 2300, 12650, 53130, 177100, 480700, 1081575, 2042975,
                        3268760, 4457400, 5200300, 5200300, 4457400, 3268760, 2042975, 1081575,
                        480700, 177100, 53130, 12650, 2300, 300, 25, 1),
                Arrays.asList(1, 30, 435, 4060, 27405, 142506, 593775, 2035800, 5852925, 14307150,
                        30045015, 54627300, 86493225, 119759850, 145422675, 155117520, 145422675,
                        119759850, 86493225, 54627300, 30045015, 14307150, 5852925, 2035800, 593775,
                        142506, 27405, 4060, 435, 30, 1),
                Arrays.asList(1, 33, 528, 5456, 40920, 237336, 1107568, 4272048, 13884156, 38567100,
                        92561040, 193536720, 354817320, 573166440, 818809200, 1037158320,
                        1166803110, 1166803110, 1037158320, 818809200, 573166440, 354817320,
                        193536720, 92561040, 38567100, 13884156, 4272048, 1107568, 237336, 40920,
                        5456, 528, 33, 1));

        System.out.println("Testing Pascal's Triangle II Solutions:");
        System.out.println("======================================");

        for (int i = 0; i < testCases.length; i++) {
            int rowIndex = testCases[i];
            List<Integer> expected = expectedResults.get(i);

            System.out.println("\nTest Case " + (i + 1) + ": rowIndex = " + rowIndex);
            System.out.println("Expected: " + expected);

            // Test all approaches
            List<Integer> result1 = solution.getRowIterative(rowIndex);
            List<Integer> result2 = solution.getRowMathematical(rowIndex);
            List<Integer> result3 = solution.getRowRecursive(rowIndex);
            List<Integer> result4 = solution.getRowTwoArrays(rowIndex);
            List<Integer> result5 = solution.getRowCombinatorial(rowIndex);
            List<Integer> result6 = solution.getRowDynamicProgramming(rowIndex);

            System.out.println(
                    "Iterative: " + result1 + " " + (result1.equals(expected) ? "✓" : "✗"));
            System.out.println(
                    "Mathematical: " + result2 + " " + (result2.equals(expected) ? "✓" : "✗"));
            System.out.println(
                    "Recursive: " + result3 + " " + (result3.equals(expected) ? "✓" : "✗"));
            System.out.println(
                    "Two Arrays: " + result4 + " " + (result4.equals(expected) ? "✓" : "✗"));
            System.out.println(
                    "Combinatorial: " + result5 + " " + (result5.equals(expected) ? "✓" : "✗"));
            System.out.println("Dynamic Programming: " + result6 + " "
                    + (result6.equals(expected) ? "✓" : "✗"));
        }

        // Performance comparison
        System.out.println("\n\nPerformance Analysis:");
        System.out.println("=====================");
        System.out.println("Approach 1 (Iterative): O(k²) time, O(k) space - OPTIMAL");
        System.out.println("Approach 2 (Mathematical): O(k) time, O(k) space - FASTEST");
        System.out.println("Approach 3 (Recursive): O(2^k) time, O(k) space - SLOWEST");
        System.out.println("Approach 4 (Two Arrays): O(k²) time, O(k) space - INTUITIVE");
        System.out.println("Approach 5 (Combinatorial): O(k) time, O(k) space - WITH MEMOIZATION");
        System.out.println("Approach 6 (Dynamic Programming): O(k²) time, O(k) space - CLEAN");

        System.out.println("\nKey Insights:");
        System.out.println("=============");
        System.out
                .println("• Pascal's triangle follows the pattern: C(n,k) = C(n-1,k-1) + C(n-1,k)");
        System.out.println(
                "• Each element can be calculated using combinatorial formula: C(n,k) = n!/(k!(n-k)!)");
        System.out
                .println("• Building in-place from right to left avoids overwriting needed values");
        System.out.println("• Mathematical approach is fastest for large row indices");
        System.out.println(
                "• Recursive approach is exponential and should be avoided for large inputs");
    }
}
