package com.example.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 455: Assign Cookies Difficulty: Easy
 * 
 * Problem Description: Assume you are an awesome parent and want to give your children some
 * cookies. But, you should give each child at most one cookie.
 * 
 * Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will
 * be content with; and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j
 * to the child i, and the child i will be content. Your goal is to maximize the number of your
 * content children and output the maximum number.
 * 
 * Example 1: Input: g = [1,2,3], s = [1,1] Output: 1 Explanation: You have 3 children and 2
 * cookies. The greed factors of 3 children are 1, 2, 3. And even though you have 2 cookies, since
 * their size is both 1, you could only make the child whose greed factor is 1 content. You need to
 * output 1.
 * 
 * Example 2: Input: g = [1,2], s = [1,2,3] Output: 2 Explanation: You have 2 children and 3
 * cookies. The greed factors of 2 children are 1, 2. You have 3 cookies and their sizes are big
 * enough to gratify all of the children, You need to output 2.
 * 
 * Constraints: - 1 <= g.length <= 3 * 10^4 - 0 <= s.length <= 3 * 10^4 - 1 <= g[i], s[j] <= 2^31 -
 * 1
 * 
 * Related Topics: Array, Two Pointers, Greedy, Sorting
 */
public class AssignCookies {

    /**
     * Approach 1: Greedy Two Pointer (Optimal)
     * 
     * Algorithm: 1. Sort both greed factors and cookie sizes 2. Use two pointers: one for children
     * (g) and one for cookies (s) 3. Try to satisfy each child with the smallest available cookie
     * 4. If current cookie satisfies current child, move both pointers 5. Otherwise, try next
     * cookie (move only cookie pointer)
     * 
     * Key Insight: - By sorting, we ensure optimal assignment - We want to use smallest cookie that
     * can satisfy each child - This leaves larger cookies for children with larger greed factors
     * 
     * Time Complexity: O(n log n + m log m) where n = g.length, m = s.length - Sorting g takes O(n
     * log n) - Sorting s takes O(m log m) - Two pointer traversal takes O(n + m)
     * 
     * Space Complexity: O(log n + log m) - Space used by sorting algorithms (typically O(log n) for
     * quicksort) - Can be O(1) if we consider sorting in-place
     * 
     * @param g array of greed factors for children
     * @param s array of cookie sizes
     * @return maximum number of content children
     */
    public int findContentChildren(int[] g, int[] s) {
        // Sort both arrays in ascending order
        Arrays.sort(g);
        Arrays.sort(s);

        int childIndex = 0; // Pointer for children
        int cookieIndex = 0; // Pointer for cookies

        // Try to assign cookies to children
        while (childIndex < g.length && cookieIndex < s.length) {
            // If current cookie can satisfy current child
            if (s[cookieIndex] >= g[childIndex]) {
                childIndex++; // Move to next child (this child is satisfied)
            }
            cookieIndex++; // Move to next cookie (whether assigned or not)
        }

        // Number of satisfied children
        return childIndex;
    }

    /**
     * Approach 2: Greedy Two Pointer (Reverse Order)
     * 
     * Algorithm: 1. Sort both arrays 2. Start from the end (largest greed factor and largest
     * cookie) 3. Try to satisfy children with highest greed factor first 4. Use largest available
     * cookies for them
     * 
     * Key Insight: - Alternative approach: satisfy greediest children first - Works equally well
     * due to greedy nature - Sometimes more intuitive to understand
     * 
     * Time Complexity: O(n log n + m log m) Space Complexity: O(log n + log m)
     * 
     * @param g array of greed factors for children
     * @param s array of cookie sizes
     * @return maximum number of content children
     */
    public int findContentChildrenReverse(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int childIndex = g.length - 1; // Start from greediest child
        int cookieIndex = s.length - 1; // Start from largest cookie
        int count = 0;

        // Try to assign cookies starting from largest
        while (childIndex >= 0 && cookieIndex >= 0) {
            // If current cookie can satisfy current child
            if (s[cookieIndex] >= g[childIndex]) {
                count++;
                cookieIndex--; // Use this cookie
            }
            childIndex--; // Move to next (less greedy) child
        }

        return count;
    }

    /**
     * Approach 3: Binary Search for Each Child
     * 
     * Algorithm: 1. Sort cookie sizes 2. For each child (in sorted order), binary search for
     * smallest suitable cookie 3. Mark used cookies to avoid reuse
     * 
     * Key Insight: - Uses binary search to find suitable cookies - Not as efficient as two-pointer
     * approach - Demonstrates alternative problem-solving strategy
     * 
     * Time Complexity: O(n log n + m log m + n * m) - Sorting: O(n log n + m log m) - For each
     * child, binary search and marking: O(n * m) in worst case
     * 
     * Space Complexity: O(m) for used cookie tracking
     * 
     * @param g array of greed factors for children
     * @param s array of cookie sizes
     * @return maximum number of content children
     */
    public int findContentChildrenBinarySearch(int[] g, int[] s) {
        if (s.length == 0)
            return 0;

        Arrays.sort(g);
        Arrays.sort(s);

        boolean[] used = new boolean[s.length];
        int count = 0;

        for (int greed : g) {
            // Find smallest unused cookie that satisfies this child
            int cookieIdx = findSmallestSuitableCookie(s, used, greed);
            if (cookieIdx != -1) {
                used[cookieIdx] = true;
                count++;
            }
        }

        return count;
    }

    /**
     * Helper method: Find smallest unused cookie that can satisfy greed factor
     * 
     * @param s sorted array of cookie sizes
     * @param used array indicating which cookies are used
     * @param greed minimum size needed
     * @return index of smallest suitable unused cookie, or -1 if none found
     */
    private int findSmallestSuitableCookie(int[] s, boolean[] used, int greed) {
        for (int i = 0; i < s.length; i++) {
            if (!used[i] && s[i] >= greed) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Approach 4: Brute Force with Backtracking (Educational)
     * 
     * Algorithm: 1. Try all possible cookie assignments to children 2. Use backtracking to explore
     * all combinations 3. Return maximum number of satisfied children
     * 
     * Key Insight: - Exhaustive search approach - Very inefficient but demonstrates the problem
     * space - Good for understanding why greedy works
     * 
     * Time Complexity: O(2^m * n) where m = s.length, n = g.length - For each cookie, we decide
     * whether to use it (2^m combinations) - For each combination, check against all children (n)
     * 
     * Space Complexity: O(m) for recursion stack
     * 
     * Note: Only suitable for very small inputs due to exponential complexity
     * 
     * @param g array of greed factors for children
     * @param s array of cookie sizes
     * @return maximum number of content children
     */
    public int findContentChildrenBruteForce(int[] g, int[] s) {
        if (s.length == 0)
            return 0;

        Arrays.sort(g);
        return backtrack(g, s, 0, new HashSet<>());
    }

    /**
     * Helper method: Backtracking to find maximum satisfied children
     * 
     * @param g sorted greed factors
     * @param s cookie sizes
     * @param childIdx current child index
     * @param usedCookies set of used cookie indices
     * @return maximum satisfied children from this state
     */
    private int backtrack(int[] g, int[] s, int childIdx, Set<Integer> usedCookies) {
        // Base case: all children processed
        if (childIdx >= g.length) {
            return 0;
        }

        int maxSatisfied = 0;

        // Try to satisfy current child with each available cookie
        for (int i = 0; i < s.length; i++) {
            if (!usedCookies.contains(i) && s[i] >= g[childIdx]) {
                usedCookies.add(i);
                int satisfied = 1 + backtrack(g, s, childIdx + 1, usedCookies);
                maxSatisfied = Math.max(maxSatisfied, satisfied);
                usedCookies.remove(i);
            }
        }

        // Option: Skip current child (don't satisfy them)
        int skipCurrent = backtrack(g, s, childIdx + 1, usedCookies);
        maxSatisfied = Math.max(maxSatisfied, skipCurrent);

        return maxSatisfied;
    }

    /**
     * Approach 5: Counting Sort Optimization (for limited range)
     * 
     * Algorithm: 1. If the range of values is limited, use counting sort 2. Count frequency of each
     * greed factor and cookie size 3. Match them greedily from smallest to largest
     * 
     * Key Insight: - When values are in limited range, counting sort is O(n + k) - More efficient
     * than comparison-based sorting - Trade-off: requires extra space for counting
     * 
     * Time Complexity: O(n + m + k) where k is the range of values Space Complexity: O(k) for
     * counting arrays
     * 
     * Note: Only efficient when k is small (e.g., k <= 10^4)
     * 
     * @param g array of greed factors for children
     * @param s array of cookie sizes
     * @param maxValue maximum possible value in arrays
     * @return maximum number of content children
     */
    public int findContentChildrenCountingSort(int[] g, int[] s, int maxValue) {
        if (s.length == 0)
            return 0;

        // Count frequencies
        int[] greedCount = new int[maxValue + 1];
        int[] cookieCount = new int[maxValue + 1];

        for (int greed : g) {
            greedCount[greed]++;
        }

        for (int size : s) {
            cookieCount[size]++;
        }

        int satisfied = 0;

        // For each greed factor (from smallest to largest)
        for (int greed = 1; greed <= maxValue; greed++) {
            while (greedCount[greed] > 0) {
                // Find next available cookie >= greed
                int cookiePointer = greed;
                while (cookiePointer <= maxValue && cookieCount[cookiePointer] == 0) {
                    cookiePointer++;
                }

                // If we found a suitable cookie
                if (cookiePointer <= maxValue) {
                    satisfied++;
                    cookieCount[cookiePointer]--;
                    greedCount[greed]--;
                } else {
                    // No suitable cookie available for this greed level
                    break;
                }
            }
        }

        return satisfied;
    }

    /**
     * Utility method: Verify if assignment is valid
     * 
     * @param g greed factors
     * @param s cookie sizes
     * @param assignments array where assignments[i] = j means child i gets cookie j (-1 if
     *        unassigned)
     * @return number of valid assignments
     */
    public int verifyAssignment(int[] g, int[] s, int[] assignments) {
        int count = 0;
        Set<Integer> usedCookies = new HashSet<>();

        for (int i = 0; i < assignments.length; i++) {
            int cookieIdx = assignments[i];
            if (cookieIdx != -1) {
                // Check if assignment is valid
                if (cookieIdx < 0 || cookieIdx >= s.length) {
                    throw new IllegalArgumentException("Invalid cookie index");
                }
                if (usedCookies.contains(cookieIdx)) {
                    throw new IllegalArgumentException("Cookie used multiple times");
                }
                if (s[cookieIdx] < g[i]) {
                    throw new IllegalArgumentException("Cookie too small for child");
                }

                usedCookies.add(cookieIdx);
                count++;
            }
        }

        return count;
    }

    /**
     * Utility method: Get statistics about the problem instance
     * 
     * @param g greed factors
     * @param s cookie sizes
     * @return string with statistics
     */
    public String getStatistics(int[] g, int[] s) {
        if (g.length == 0 && s.length == 0) {
            return "Empty input";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Children: ").append(g.length).append(", ");
        sb.append("Cookies: ").append(s.length).append("\n");

        if (g.length > 0) {
            int minGreed = Arrays.stream(g).min().getAsInt();
            int maxGreed = Arrays.stream(g).max().getAsInt();
            double avgGreed = Arrays.stream(g).average().getAsDouble();
            sb.append("Greed range: [").append(minGreed).append(", ").append(maxGreed)
                    .append("], ");
            sb.append("Avg: ").append(String.format("%.2f", avgGreed)).append("\n");
        }

        if (s.length > 0) {
            int minSize = Arrays.stream(s).min().getAsInt();
            int maxSize = Arrays.stream(s).max().getAsInt();
            double avgSize = Arrays.stream(s).average().getAsDouble();
            sb.append("Cookie size range: [").append(minSize).append(", ").append(maxSize)
                    .append("], ");
            sb.append("Avg: ").append(String.format("%.2f", avgSize));
        }

        return sb.toString();
    }
}

