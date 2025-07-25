package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 6: ZigZag Conversion
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * 
 * P A H N A P L S I I G Y I R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Example 1: Input: s = "PAYPALISHIRING", numRows = 3 Output: "PAHNAPLSIIGYIR"
 * 
 * Example 2: Input: s = "PAYPALISHIRING", numRows = 4 Output: "PINALSIGYAHRPI"
 * 
 * Example 3: Input: s = "A", numRows = 1 Output: "A"
 * 
 * Constraints: - 1 <= s.length <= 1000 - s consists of English letters (lower-case and upper-case),
 * ',' and '.'. - 1 <= numRows <= 1000
 */
public class ZigZagConversion {

    // ========================================
    // APPROACH 1: SIMULATION (RECOMMENDED)
    // Time: O(n), Space: O(n)
    // ========================================

    /**
     * Approach 1: Simulation - Simulate the zigzag movement
     * 
     * We simulate the process of writing the string in zigzag pattern: 1. Start at row 0, moving
     * downward 2. When we reach the bottom (row numRows-1), change direction to upward 3. When we
     * reach the top (row 0), change direction to downward 4. Continue until all characters are
     * placed 5. Concatenate all rows to get the result
     * 
     * Time Complexity: O(n) - Visit each character once Space Complexity: O(n) - Store all
     * characters in row arrays
     */
    public String convert(String s, int numRows) {
        // Edge case: if only 1 row, return original string
        if (numRows == 1) {
            return s;
        }

        // Create a list for each row
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int currentRow = 0;
        boolean goingDown = false; // Start by going down

        // Process each character in the string
        for (char c : s.toCharArray()) {
            // Add character to current row
            rows.get(currentRow).append(c);

            // Change direction if we hit the top or bottom
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Move to next row based on direction
            currentRow += goingDown ? 1 : -1;
        }

        // Concatenate all rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    // ========================================
    // APPROACH 2: MATHEMATICAL PATTERN
    // Time: O(n), Space: O(1) excluding output
    // ========================================

    /**
     * Approach 2: Mathematical Pattern - Calculate positions directly
     * 
     * Instead of simulating, we can observe the pattern and calculate which characters belong to
     * each row directly.
     * 
     * For numRows = n, the pattern repeats every (2n-2) characters. - Row 0: characters at
     * positions 0, 2n-2, 2(2n-2), ... - Row n-1: characters at positions n-1, n-1+(2n-2),
     * n-1+2(2n-2), ... - Middle rows: have characters at regular intervals plus diagonal positions
     * 
     * Time Complexity: O(n) - Visit each position once Space Complexity: O(1) - No extra space
     * except for result
     */
    public String convertMathematical(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder result = new StringBuilder();
        int n = s.length();
        int cycleLength = 2 * numRows - 2; // Pattern repeats every cycleLength characters

        for (int row = 0; row < numRows; row++) {
            for (int i = 0; i + row < n; i += cycleLength) {
                // Add character from main cycle
                result.append(s.charAt(i + row));

                // For middle rows, add diagonal character if it exists
                if (row != 0 && row != numRows - 1 && i + cycleLength - row < n) {
                    result.append(s.charAt(i + cycleLength - row));
                }
            }
        }

        return result.toString();
    }

    // ========================================
    // APPROACH 3: STRING ARRAY APPROACH
    // Time: O(n), Space: O(n)
    // ========================================

    /**
     * Approach 3: String Array Approach - Similar to simulation but using String array
     * 
     * This is a variation of the simulation approach using String array instead of StringBuilder
     * list. Good for understanding the problem pattern.
     * 
     * Time Complexity: O(n) - Visit each character once Space Complexity: O(n) - Store characters
     * in string array
     */
    public String convertWithStringArray(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        // Create string array for each row
        String[] rows = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = "";
        }

        int currentRow = 0;
        int direction = -1; // -1 means going up, 1 means going down

        for (char c : s.toCharArray()) {
            // Add character to current row
            rows[currentRow] += c;

            // Change direction at boundaries
            if (currentRow == 0 || currentRow == numRows - 1) {
                direction = -direction;
            }

            // Move to next row
            currentRow += direction;
        }

        // Concatenate all rows
        String result = "";
        for (String row : rows) {
            result += row;
        }

        return result;
    }

    // ========================================
    // APPROACH 4: OPTIMIZED SIMULATION
    // Time: O(n), Space: O(n)
    // ========================================

    /**
     * Approach 4: Optimized Simulation - More concise version
     * 
     * A cleaner implementation of the simulation approach with better variable naming.
     * 
     * Time Complexity: O(n) - Single pass through string Space Complexity: O(n) - Store result in
     * StringBuilder array
     */
    public String convertOptimized(String s, int numRows) {
        if (numRows == 1)
            return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int row = 0;
        int step = 1;

        for (char c : s.toCharArray()) {
            rows[row].append(c);

            // Change direction at boundaries
            if (row == 0) {
                step = 1; // Go down
            } else if (row == numRows - 1) {
                step = -1; // Go up
            }

            row += step;
        }

        // Combine all rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rows) {
            result.append(sb);
        }

        return result.toString();
    }

    // ========================================
    // UTILITY METHODS
    // ========================================

    /**
     * Helper method to visualize the zigzag pattern Useful for debugging and understanding the
     * problem
     */
    public String visualizeZigZag(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        // Create a 2D grid to visualize the pattern
        int cols = s.length(); // Maximum possible columns
        char[][] grid = new char[numRows][cols];

        // Initialize grid with spaces
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = ' ';
            }
        }

        int row = 0, col = 0;
        boolean goingDown = true;

        // Place characters in zigzag pattern
        for (char c : s.toCharArray()) {
            grid[row][col] = c;

            if (goingDown) {
                if (row == numRows - 1) {
                    // Hit bottom, start going diagonally up
                    goingDown = false;
                    row--;
                    col++;
                } else {
                    // Continue going down
                    row++;
                }
            } else {
                if (row == 0) {
                    // Hit top, start going down
                    goingDown = true;
                    row++;
                } else {
                    // Continue going diagonally up
                    row--;
                    col++;
                }
            }
        }

        // Build visualization string
        StringBuilder visualization = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < col; j++) {
                visualization.append(grid[i][j]);
            }
            if (i < numRows - 1) {
                visualization.append('\n');
            }
        }

        return visualization.toString();
    }

    /**
     * Get the pattern cycle length for given number of rows
     */
    public int getCycleLength(int numRows) {
        if (numRows <= 1) {
            return 1;
        }
        return 2 * numRows - 2;
    }

    /**
     * Calculate which row a character at given index belongs to
     */
    public int getRowForIndex(int index, int numRows) {
        if (numRows == 1) {
            return 0;
        }

        int cycleLength = 2 * numRows - 2;
        int positionInCycle = index % cycleLength;

        if (positionInCycle < numRows) {
            return positionInCycle;
        } else {
            return 2 * numRows - 2 - positionInCycle;
        }
    }
}
