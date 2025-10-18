package com.example.hackerrank;

import java.util.HashMap;
import java.util.Map;

/**
 * HackerRank: Ice Cream Parlor Difficulty: Easy
 * 
 * Problem: Two friends like to pool their money and go to the ice cream parlor. They always choose
 * two distinct flavors and they spend all of their money.
 * 
 * Given a list of prices for the flavors of ice cream, select the two that will cost all of the
 * money they have.
 * 
 * Function Description: Complete the icecreamParlor function. It should return an array containing
 * the indices of the prices of the two flavors they buy, sorted ascending.
 * 
 * Parameters: - int m: the amount of money they have to spend - int[] cost: the cost of each flavor
 * of ice cream
 * 
 * Returns: - int[2]: the indices of the prices of the two flavors they buy, sorted ascending
 * (1-based indexing)
 * 
 * Example: m = 4 cost = [1, 4, 5, 3, 2] Output: [1, 4] Explanation: cost[0] + cost[3] = 1 + 3 = 4,
 * so return 1-based indices [1, 4]
 * 
 * Constraints: - 1 <= t <= 50 - 2 <= m <= 10^4 - 2 <= n <= 10^4 - 1 <= cost[i] <= 10^4 - There will
 * always be a unique solution
 */
public class IceCreamParlor {

    // ========================================
    // APPROACH 1: HASH MAP - ONE PASS (OPTIMAL)
    // Time: O(n), Space: O(n)
    // ========================================

    /**
     * Approach 1: Hash Map - One Pass (Recommended)
     * 
     * This is the optimal solution for the Ice Cream Parlor problem.
     * 
     * Algorithm: 1. Create a hash map to store each price and its index (1-based) 2. For each
     * price, calculate its complement (m - current price) 3. Check if the complement exists in the
     * hash map 4. If found, return the indices in ascending order (1-based) 5. Otherwise, add
     * current price to map
     * 
     * Key insights: - We only need to traverse the array once - Hash map provides O(1) lookup time
     * - We check for complement before adding current element to avoid using same element twice -
     * Return indices in ascending order and with 1-based indexing
     * 
     * Time Complexity: O(n) where n is the length of the cost array Space Complexity: O(n) for the
     * hash map
     */
    public static int[] icecreamParlor(int m, int[] cost) {
        if (cost == null || cost.length < 2) {
            return new int[0];
        }

        // Map to store: price -> 1-based index
        Map<Integer, Integer> priceToIndex = new HashMap<>();

        for (int i = 0; i < cost.length; i++) {
            int currentPrice = cost[i];
            int complement = m - currentPrice;

            // Check if complement exists in the map
            if (priceToIndex.containsKey(complement)) {
                int firstIndex = priceToIndex.get(complement);
                int secondIndex = i + 1; // Convert to 1-based index

                // Return in ascending order
                return new int[] {Math.min(firstIndex, secondIndex),
                        Math.max(firstIndex, secondIndex)};
            }

            // Add current price and its 1-based index to the map
            priceToIndex.put(currentPrice, i + 1);
        }

        // No solution found (shouldn't happen based on problem constraints)
        return new int[0];
    }

    // ========================================
    // APPROACH 2: BRUTE FORCE
    // Time: O(n²), Space: O(1)
    // ========================================

    /**
     * Approach 2: Brute Force
     * 
     * This is the simplest but least efficient approach.
     * 
     * Algorithm: 1. Use two nested loops to check all possible pairs 2. For each pair (i, j) where
     * i < j, check if cost[i] + cost[j] == m 3. Return 1-based indices when a valid pair is found
     * 
     * Time Complexity: O(n²) where n is the length of the cost array Space Complexity: O(1) - only
     * uses constant extra space
     */
    public static int[] icecreamParlorBruteForce(int m, int[] cost) {
        if (cost == null || cost.length < 2) {
            return new int[0];
        }

        for (int i = 0; i < cost.length - 1; i++) {
            for (int j = i + 1; j < cost.length; j++) {
                if (cost[i] + cost[j] == m) {
                    // Return 1-based indices
                    return new int[] {i + 1, j + 1};
                }
            }
        }

        return new int[0];
    }

    // ========================================
    // UTILITY METHODS
    // ========================================

    /**
     * Validates if the returned indices form a valid solution
     */
    public static boolean isValidSolution(int m, int[] cost, int[] result) {
        if (result == null || result.length != 2) {
            return false;
        }

        int i = result[0] - 1; // Convert to 0-based
        int j = result[1] - 1; // Convert to 0-based

        if (i < 0 || i >= cost.length || j < 0 || j >= cost.length || i == j) {
            return false;
        }

        return cost[i] + cost[j] == m;
    }

    /**
     * Formats the result for display
     */
    public static String formatResult(int m, int[] cost, int[] result) {
        if (result == null || result.length == 0) {
            return "No solution found";
        }

        int idx1 = result[0] - 1; // Convert to 0-based for array access
        int idx2 = result[1] - 1;

        return String.format("Money: %d, Indices: [%d, %d] (1-based), Prices: [%d, %d], Sum: %d", m,
                result[0], result[1], cost[idx1], cost[idx2], cost[idx1] + cost[idx2]);
    }

    // ========================================
    // MAIN METHOD FOR TESTING
    // ========================================

    public static void main(String[] args) {
        System.out.println("=== Ice Cream Parlor - Test Cases ===\n");

        // Test Case 1: HackerRank Example 1
        int m1 = 4;
        int[] cost1 = {1, 4, 5, 3, 2};
        int[] result1 = icecreamParlor(m1, cost1);
        System.out.println("Test 1: " + formatResult(m1, cost1, result1));
        System.out.println("Expected: [1, 4], Got: [" + result1[0] + ", " + result1[1] + "]");
        System.out.println("Valid: " + isValidSolution(m1, cost1, result1) + "\n");

        // Test Case 2: HackerRank Example 2
        int m2 = 4;
        int[] cost2 = {2, 2, 4, 3};
        int[] result2 = icecreamParlor(m2, cost2);
        System.out.println("Test 2: " + formatResult(m2, cost2, result2));
        System.out.println("Expected: [1, 2], Got: [" + result2[0] + ", " + result2[1] + "]");
        System.out.println("Valid: " + isValidSolution(m2, cost2, result2) + "\n");

        // Test Case 3: Large values
        int m3 = 100;
        int[] cost3 = {5, 75, 25, 100};
        int[] result3 = icecreamParlor(m3, cost3);
        System.out.println("Test 3: " + formatResult(m3, cost3, result3));
        System.out.println("Expected: [2, 3], Got: [" + result3[0] + ", " + result3[1] + "]");
        System.out.println("Valid: " + isValidSolution(m3, cost3, result3) + "\n");

        // Test Case 4: Two items only
        int m4 = 10;
        int[] cost4 = {3, 7};
        int[] result4 = icecreamParlor(m4, cost4);
        System.out.println("Test 4: " + formatResult(m4, cost4, result4));
        System.out.println("Expected: [1, 2], Got: [" + result4[0] + ", " + result4[1] + "]");
        System.out.println("Valid: " + isValidSolution(m4, cost4, result4) + "\n");

        // Test Case 5: Solution at the end
        int m5 = 20;
        int[] cost5 = {1, 2, 3, 4, 5, 15};
        int[] result5 = icecreamParlor(m5, cost5);
        System.out.println("Test 5: " + formatResult(m5, cost5, result5));
        System.out.println("Expected: [5, 6], Got: [" + result5[0] + ", " + result5[1] + "]");
        System.out.println("Valid: " + isValidSolution(m5, cost5, result5) + "\n");

        System.out.println("=== Approach Comparison ===");

        // Compare both approaches
        int testM = 4;
        int[] testCost = {1, 4, 5, 3, 2};

        System.out.println("Money: " + testM);
        System.out.println("Costs: [1, 4, 5, 3, 2]");

        int[] hashMapResult = icecreamParlor(testM, testCost);
        System.out.println(
                "Hash Map (One Pass): [" + hashMapResult[0] + ", " + hashMapResult[1] + "]");

        int[] bruteForceResult = icecreamParlorBruteForce(testM, testCost);
        System.out
                .println("Brute Force: [" + bruteForceResult[0] + ", " + bruteForceResult[1] + "]");
    }
}

