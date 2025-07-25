package com.example.leetcode;

/**
 * LeetCode 5: Longest Palindromic Substring
 * 
 * Given a string s, return the longest palindromic substring in s.
 * 
 * Example 1: Input: s = "babad" Output: "bab" or "aba" Explanation: "aba" is also a valid answer.
 * 
 * Example 2: Input: s = "cbbd" Output: "bb"
 * 
 * Constraints: - 1 <= s.length <= 1000 - s consist of only digits and English letters.
 */
public class LongestPalindromicSubstring {

    // ========================================
    // APPROACH 1: EXPAND AROUND CENTERS
    // Time: O(n²), Space: O(1)
    // ========================================

    /**
     * Approach 1: Expand Around Centers
     * 
     * For each possible center (both single character and between characters), expand outward while
     * characters match to find the longest palindrome.
     * 
     * Time Complexity: O(n²) - For each center, we might expand up to n/2 positions Space
     * Complexity: O(1) - Only using a few variables
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int start = 0; // Start index of longest palindrome found
        int maxLength = 1; // Length of longest palindrome found

        for (int i = 0; i < s.length(); i++) {
            // Check for odd-length palindromes (center at i)
            int len1 = expandAroundCenter(s, i, i);

            // Check for even-length palindromes (center between i and i+1)
            int len2 = expandAroundCenter(s, i, i + 1);

            // Get the maximum length palindrome centered at this position
            int currentMaxLength = Math.max(len1, len2);

            // Update our global maximum if we found a longer palindrome
            if (currentMaxLength > maxLength) {
                maxLength = currentMaxLength;
                // Calculate the starting position of this palindrome
                start = i - (currentMaxLength - 1) / 2;
            }
        }

        return s.substring(start, start + maxLength);
    }

    /**
     * Helper method to expand around a center and return the length of palindrome
     * 
     * @param s The input string
     * @param left Left boundary of center
     * @param right Right boundary of center
     * @return Length of the palindrome found
     */
    private int expandAroundCenter(String s, int left, int right) {
        // Expand outward while characters match
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // Return the length of palindrome (right - left - 1)
        // We subtract 1 because we went one step too far in the while loop
        return right - left - 1;
    }

    // ========================================
    // APPROACH 2: MANACHER'S ALGORITHM (OPTIMAL)
    // Time: O(n), Space: O(n)
    // ========================================

    /**
     * Approach 2: Manacher's Algorithm
     * 
     * Transforms the string to handle even/odd palindromes uniformly, then uses previously computed
     * information to avoid redundant comparisons.
     * 
     * Time Complexity: O(n) - Each character is visited at most twice Space Complexity: O(n) - For
     * the transformed string and radius array
     */
    public String longestPalindromeManacher(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        // Transform string: "abc" -> "@#a#b#c#$"
        // This handles both odd and even length palindromes uniformly
        String transformed = preprocessString(s);

        int n = transformed.length();
        int[] radius = new int[n]; // radius[i] = radius of palindrome centered at i
        int center = 0; // Center of the rightmost palindrome found so far
        int rightBoundary = 0; // Right boundary of the rightmost palindrome

        int maxLength = 0; // Length of longest palindrome in original string
        int bestCenter = 0; // Center of longest palindrome in transformed string

        for (int i = 1; i < n - 1; i++) {
            // Mirror of current position with respect to center
            int mirror = 2 * center - i;

            // If current position is within the right boundary,
            // we can use previously computed information
            if (i < rightBoundary) {
                radius[i] = Math.min(rightBoundary - i, radius[mirror]);
            }

            // Try to expand palindrome centered at current position
            try {
                while (transformed.charAt(i + radius[i] + 1) == transformed
                        .charAt(i - radius[i] - 1)) {
                    radius[i]++;
                }
            } catch (StringIndexOutOfBoundsException e) {
                // Handle boundary cases gracefully
            }

            // If palindrome centered at i extends past rightBoundary,
            // adjust center and rightBoundary
            if (i + radius[i] > rightBoundary) {
                center = i;
                rightBoundary = i + radius[i];
            }

            // Update maximum length palindrome found
            if (radius[i] > maxLength) {
                maxLength = radius[i];
                bestCenter = i;
            }
        }

        // Extract the longest palindrome from original string
        int start = (bestCenter - maxLength) / 2;
        return s.substring(start, start + maxLength);
    }

    /**
     * Preprocesses the string for Manacher's algorithm "abc" -> "@#a#b#c#$"
     * 
     * The '@' and '$' are sentinels to avoid boundary checks The '#' are delimiters to make all
     * palindromes odd-length
     */
    private String preprocessString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append('@'); // Start sentinel

        for (char c : s.toCharArray()) {
            sb.append('#');
            sb.append(c);
        }

        sb.append('#');
        sb.append('$'); // End sentinel

        return sb.toString();
    }

    // ========================================
    // APPROACH 3: DYNAMIC PROGRAMMING
    // Time: O(n²), Space: O(n²)
    // ========================================

    /**
     * Approach 3: Dynamic Programming
     * 
     * Build a 2D table where dp[i][j] represents whether substring s[i...j] is a palindrome.
     * 
     * Time Complexity: O(n²) - Fill the entire n×n table Space Complexity: O(n²) - 2D DP table
     */
    public String longestPalindromeDP(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int start = 0;
        int maxLength = 1;

        // Every single character is a palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Check for palindromes of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Check for palindromes of length 3 and more
        for (int length = 3; length <= n; length++) {
            for (int i = 0; i < n - length + 1; i++) {
                int j = i + length - 1; // Ending index

                // Check if substring s[i...j] is palindrome
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    maxLength = length;
                }
            }
        }

        return s.substring(start, start + maxLength);
    }

    // ========================================
    // UTILITY METHODS
    // ========================================

    /**
     * Helper method to check if a string is a palindrome
     */
    public boolean isPalindrome(String s) {
        if (s == null)
            return false;

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    /**
     * Brute force approach for comparison (not recommended for large inputs) Time: O(n³), Space:
     * O(1)
     */
    public String longestPalindromeBruteForce(String s) {
        if (s == null) {
            return "";
        }
        if (s.length() < 2) {
            return s;
        }

        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String substring = s.substring(i, j + 1);
                if (isPalindrome(substring) && substring.length() > longest.length()) {
                    longest = substring;
                }
            }
        }

        return longest;
    }
}
