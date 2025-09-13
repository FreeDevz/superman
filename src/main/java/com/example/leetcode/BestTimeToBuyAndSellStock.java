package com.example.leetcode;

import java.util.Arrays;

/**
 * LeetCode 121: Best Time to Buy and Sell Stock
 * 
 * Problem Description: You are given an array prices where prices[i] is the price of a given stock
 * on the ith day. You want to maximize your profit by choosing a single day to buy one stock and
 * choosing a different day in the future to sell that stock. Return the maximum profit you can
 * achieve from this transaction. If you cannot achieve any profit, return 0.
 * 
 * Example 1: Input: prices = [7,1,5,3,6,4] Output: 5 Explanation: Buy on day 2 (price = 1) and sell
 * on day 5 (price = 6), profit = 6-1 = 5.
 * 
 * Example 2: Input: prices = [7,6,4,3,1] Output: 0 Explanation: In this case, no transactions are
 * done and the max profit = 0.
 * 
 * Constraints: - 1 <= prices.length <= 10^5 - 0 <= prices[i] <= 10^4
 * 
 * Approach 1: One Pass (Optimal) Time Complexity: O(n) Space Complexity: O(1)
 * 
 * Approach 2: Brute Force Time Complexity: O(n²) Space Complexity: O(1)
 * 
 * Approach 3: Dynamic Programming Time Complexity: O(n) Space Complexity: O(n)
 * 
 * Approach 4: Peak Valley Analysis Time Complexity: O(n) Space Complexity: O(1)
 * 
 * Approach 5: Kadane's Algorithm (Maximum Subarray) Time Complexity: O(n) Space Complexity: O(1)
 * 
 * Approach 6: Divide and Conquer Time Complexity: O(n log n) Space Complexity: O(log n)
 */
public class BestTimeToBuyAndSellStock {

    /**
     * Approach 1: One Pass (Optimal Solution)
     * 
     * This is the most efficient solution. We track the minimum price seen so far and calculate the
     * maximum profit at each step.
     * 
     * @param prices array of stock prices
     * @return maximum profit from buying and selling once
     */
    public int maxProfitOnePass(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }

    /**
     * Approach 2: Brute Force
     * 
     * Check all possible buy-sell combinations to find the maximum profit. This approach is
     * inefficient but demonstrates the basic logic.
     * 
     * @param prices array of stock prices
     * @return maximum profit from buying and selling once
     */
    public int maxProfitBruteForce(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int maxProfit = 0;
        int n = prices.length;

        // Try all possible buy-sell combinations
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

    /**
     * Approach 3: Dynamic Programming
     * 
     * Use dynamic programming to track the minimum price and maximum profit at each day.
     * 
     * @param prices array of stock prices
     * @return maximum profit from buying and selling once
     */
    public int maxProfitDynamicProgramming(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int n = prices.length;
        int[] minPrices = new int[n];
        int[] maxProfits = new int[n];

        minPrices[0] = prices[0];
        maxProfits[0] = 0;

        for (int i = 1; i < n; i++) {
            minPrices[i] = Math.min(minPrices[i - 1], prices[i]);
            maxProfits[i] = Math.max(maxProfits[i - 1], prices[i] - minPrices[i - 1]);
        }

        return maxProfits[n - 1];
    }

    /**
     * Approach 4: Peak Valley Analysis
     * 
     * Find valleys (local minimums) and peaks (local maximums) to determine the best buy-sell
     * strategy.
     * 
     * @param prices array of stock prices
     * @return maximum profit from buying and selling once
     */
    public int maxProfitPeakValley(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int valley = Integer.MAX_VALUE;
        int peak = 0;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < valley) {
                valley = price;
                peak = price; // Reset peak when we find a new valley
            } else if (price > peak) {
                peak = price;
                maxProfit = Math.max(maxProfit, peak - valley);
            }
        }

        return maxProfit;
    }

    /**
     * Approach 5: Kadane's Algorithm (Maximum Subarray)
     * 
     * Convert the problem to finding the maximum subarray sum of price differences. This approach
     * treats the problem as finding the maximum sum of consecutive elements.
     * 
     * @param prices array of stock prices
     * @return maximum profit from buying and selling once
     */
    public int maxProfitKadane(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int maxCur = 0;
        int maxSoFar = 0;

        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            maxCur = Math.max(0, maxCur + diff);
            maxSoFar = Math.max(maxSoFar, maxCur);
        }

        return maxSoFar;
    }

    /**
     * Approach 6: Divide and Conquer
     * 
     * Split the array into two halves and find the maximum profit in each half, then check for
     * cross-half transactions.
     * 
     * @param prices array of stock prices
     * @return maximum profit from buying and selling once
     */
    public int maxProfitDivideAndConquer(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        return maxProfitHelper(prices, 0, prices.length - 1);
    }

    /**
     * Helper method for divide and conquer approach
     */
    private int maxProfitHelper(int[] prices, int left, int right) {
        if (left >= right) {
            return 0;
        }

        if (left == right - 1) {
            return Math.max(0, prices[right] - prices[left]);
        }

        int mid = left + (right - left) / 2;

        // Find maximum profit in left half
        int leftProfit = maxProfitHelper(prices, left, mid);

        // Find maximum profit in right half
        int rightProfit = maxProfitHelper(prices, mid + 1, right);

        // Find maximum profit across both halves
        int crossProfit = findCrossProfit(prices, left, mid, right);

        return Math.max(Math.max(leftProfit, rightProfit), crossProfit);
    }

    /**
     * Find maximum profit that crosses the middle point
     */
    private int findCrossProfit(int[] prices, int left, int mid, int right) {
        // Find minimum price in left half
        int minLeft = Integer.MAX_VALUE;
        for (int i = left; i <= mid; i++) {
            minLeft = Math.min(minLeft, prices[i]);
        }

        // Find maximum price in right half
        int maxRight = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= right; i++) {
            maxRight = Math.max(maxRight, prices[i]);
        }

        return Math.max(0, maxRight - minLeft);
    }

    /**
     * Utility method to find the actual buy and sell days that yield maximum profit
     * 
     * @param prices array of stock prices
     * @return array with [buyDay, sellDay, profit] or [-1, -1, 0] if no profit
     */
    public int[] findBestTransaction(int[] prices) {
        if (prices == null || prices.length < 2) {
            return new int[] {-1, -1, 0};
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        int buyDay = -1;
        int sellDay = -1;
        int minPriceDay = -1;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                minPriceDay = i;
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
                buyDay = minPriceDay;
                sellDay = i;
            }
        }

        return new int[] {buyDay, sellDay, maxProfit};
    }

    /**
     * Utility method to calculate profit for a specific buy-sell transaction
     * 
     * @param prices array of stock prices
     * @param buyDay day to buy (0-indexed)
     * @param sellDay day to sell (0-indexed)
     * @return profit from the transaction
     */
    public int calculateProfit(int[] prices, int buyDay, int sellDay) {
        if (prices == null || buyDay < 0 || sellDay >= prices.length || buyDay >= sellDay) {
            return 0;
        }
        return prices[sellDay] - prices[buyDay];
    }

    /**
     * Utility method to validate if a transaction is valid
     * 
     * @param prices array of stock prices
     * @param buyDay day to buy (0-indexed)
     * @param sellDay day to sell (0-indexed)
     * @return true if transaction is valid
     */
    public boolean isValidTransaction(int[] prices, int buyDay, int sellDay) {
        return prices != null && buyDay >= 0 && sellDay < prices.length && buyDay < sellDay;
    }

    /**
     * Utility method to print price analysis
     * 
     * @param prices array of stock prices
     */
    public static void printPriceAnalysis(int[] prices) {
        if (prices == null || prices.length == 0) {
            System.out.println("No prices to analyze");
            return;
        }

        System.out.println("Price Analysis:");
        System.out.println("===============");
        for (int i = 0; i < prices.length; i++) {
            System.out.println("Day " + i + ": $" + prices[i]);
        }

        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();
        int[] transaction = solution.findBestTransaction(prices);
        int maxProfit = solution.maxProfitOnePass(prices);

        System.out.println("\nBest Transaction:");
        if (transaction[2] > 0) {
            System.out.println("Buy on day " + transaction[0] + " at $" + prices[transaction[0]]);
            System.out.println("Sell on day " + transaction[1] + " at $" + prices[transaction[1]]);
            System.out.println("Maximum profit: $" + transaction[2]);
        } else {
            System.out.println("No profitable transaction possible");
        }
    }

    /**
     * Main method to demonstrate all approaches
     */
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();

        // Test cases
        int[][] testCases = {{7, 1, 5, 3, 6, 4}, {7, 6, 4, 3, 1}, {1, 2, 3, 4, 5}, {5, 4, 3, 2, 1},
                {2, 4, 1}, {1, 2}, {2, 1}, {1}, {}, null, {3, 3, 5, 0, 0, 3, 1, 4},
                {1, 2, 4, 2, 5, 7, 2, 4, 9, 0}, {2, 1, 2, 0, 1}, {6, 1, 3, 2, 4, 7}};

        int[] expectedResults = {5, 0, 4, 0, 2, 1, 0, 0, 0, 0, 4, 8, 1, 6};

        System.out.println("Testing Best Time to Buy and Sell Stock Solutions:");
        System.out.println("================================================");

        for (int i = 0; i < testCases.length; i++) {
            int[] prices = testCases[i];
            int expected = expectedResults[i];

            System.out.println("\nTest Case " + (i + 1) + ": " + Arrays.toString(prices));
            System.out.println("Expected: " + expected);

            // Test all approaches
            int result1 = solution.maxProfitOnePass(prices);
            int result2 = solution.maxProfitBruteForce(prices);
            int result3 = solution.maxProfitDynamicProgramming(prices);
            int result4 = solution.maxProfitPeakValley(prices);
            int result5 = solution.maxProfitKadane(prices);
            int result6 = solution.maxProfitDivideAndConquer(prices);

            System.out.println("One Pass: " + result1 + " " + (result1 == expected ? "✓" : "✗"));
            System.out.println("Brute Force: " + result2 + " " + (result2 == expected ? "✓" : "✗"));
            System.out.println(
                    "Dynamic Programming: " + result3 + " " + (result3 == expected ? "✓" : "✗"));
            System.out.println("Peak Valley: " + result4 + " " + (result4 == expected ? "✓" : "✗"));
            System.out.println("Kadane's: " + result5 + " " + (result5 == expected ? "✓" : "✗"));
            System.out.println(
                    "Divide & Conquer: " + result6 + " " + (result6 == expected ? "✓" : "✗"));
        }

        // Performance analysis
        System.out.println("\n\nPerformance Analysis:");
        System.out.println("====================");
        System.out.println("Approach 1 (One Pass): O(n) time, O(1) space - OPTIMAL");
        System.out.println("Approach 2 (Brute Force): O(n²) time, O(1) space - INEFFICIENT");
        System.out.println("Approach 3 (Dynamic Programming): O(n) time, O(n) space - CLEAR LOGIC");
        System.out.println("Approach 4 (Peak Valley): O(n) time, O(1) space - INTUITIVE");
        System.out.println("Approach 5 (Kadane's): O(n) time, O(1) space - ELEGANT");
        System.out.println(
                "Approach 6 (Divide & Conquer): O(n log n) time, O(log n) space - EDUCATIONAL");

        System.out.println("\nKey Insights:");
        System.out.println("=============");
        System.out.println("• Track minimum price seen so far and calculate profit at each step");
        System.out.println("• One pass algorithm is optimal with O(n) time and O(1) space");
        System.out.println(
                "• Problem can be converted to maximum subarray sum using Kadane's algorithm");
        System.out.println("• Peak valley analysis helps understand the problem conceptually");
        System.out.println("• Dynamic programming approach is clear but uses extra space");
        System.out.println("• Divide and conquer is educational but less efficient");
    }
}
