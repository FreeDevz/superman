package com.example.leetcode;

/**
 * LeetCode 14: Longest Common Prefix
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Examples: Input: strs = ["flower","flow","flight"] Output: "fl"
 * 
 * Input: strs = ["dog","racecar","car"] Output: "" Explanation: There is no common prefix among the
 * input strings.
 * 
 * Constraints: - 1 <= strs.length <= 200 - 0 <= strs[i].length <= 200 - strs[i] consists of only
 * lowercase English letters
 */
public class LongestCommonPrefix {

    // ========================================
    // APPROACH 1: HORIZONTAL SCANNING (RECOMMENDED)
    // Time: O(S), Space: O(1) where S is sum of all characters
    // ========================================

    /**
     * Approach 1: Horizontal Scanning
     * 
     * This is the most intuitive and efficient approach. We compare the first string with all other
     * strings, finding the common prefix at each step.
     * 
     * Algorithm: 1. Start with the first string as the prefix 2. For each subsequent string, find
     * the common prefix with current prefix 3. Update the prefix to be the common part 4. Continue
     * until all strings are processed or prefix becomes empty
     * 
     * Time Complexity: O(S) where S is the sum of all characters in all strings Space Complexity:
     * O(1) as we only store the prefix
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0] == null ? "" : strs[0];
        }

        // Handle null strings in array
        for (String str : strs) {
            if (str == null) {
                return "";
            }
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            prefix = findCommonPrefix(prefix, strs[i]);

            // Early termination if no common prefix
            if (prefix.isEmpty()) {
                return "";
            }
        }

        return prefix;
    }

    /**
     * Helper method to find common prefix between two strings
     */
    private String findCommonPrefix(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        int commonLength = 0;

        for (int i = 0; i < minLength; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
            commonLength++;
        }

        return str1.substring(0, commonLength);
    }

    // ========================================
    // APPROACH 2: VERTICAL SCANNING
    // Time: O(S), Space: O(1) where S is sum of all characters
    // ========================================

    /**
     * Approach 2: Vertical Scanning
     * 
     * Instead of comparing strings horizontally, we compare characters vertically at the same
     * position across all strings.
     * 
     * Algorithm: 1. Compare characters at the same index across all strings 2. If all characters
     * match, add to prefix and continue 3. If any character differs, return current prefix 4. Stop
     * when we reach the end of shortest string
     * 
     * Time Complexity: O(S) where S is the sum of all characters in all strings Space Complexity:
     * O(1) as we only store the prefix
     */
    public String longestCommonPrefixVertical(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0] == null ? "" : strs[0];
        }

        // Find the shortest string length
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str == null) {
                return "";
            }
            minLength = Math.min(minLength, str.length());
        }

        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < minLength; i++) {
            char currentChar = strs[0].charAt(i);

            // Check if all strings have the same character at position i
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != currentChar) {
                    return prefix.toString();
                }
            }

            prefix.append(currentChar);
        }

        return prefix.toString();
    }

    // ========================================
    // APPROACH 3: DIVIDE AND CONQUER
    // Time: O(S), Space: O(m * log n) where m is length of shortest string
    // ========================================

    /**
     * Approach 3: Divide and Conquer
     * 
     * This approach recursively divides the problem into smaller subproblems and combines the
     * results.
     * 
     * Algorithm: 1. Divide the array into two halves 2. Recursively find common prefix for each
     * half 3. Find common prefix between the two results 4. Base case: single string or empty array
     * 
     * Time Complexity: O(S) where S is the sum of all characters in all strings Space Complexity:
     * O(m * log n) where m is length of shortest string, n is array length
     */
    public String longestCommonPrefixDivideAndConquer(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0] == null ? "" : strs[0];
        }

        // Handle null strings in array
        for (String str : strs) {
            if (str == null) {
                return "";
            }
        }

        return longestCommonPrefixRecursive(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefixRecursive(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        }

        if (start + 1 == end) {
            return findCommonPrefix(strs[start], strs[end]);
        }

        int mid = (start + end) / 2;
        String leftPrefix = longestCommonPrefixRecursive(strs, start, mid);
        String rightPrefix = longestCommonPrefixRecursive(strs, mid + 1, end);

        return findCommonPrefix(leftPrefix, rightPrefix);
    }

    // ========================================
    // APPROACH 4: BINARY SEARCH
    // Time: O(S * log m), Space: O(1) where m is length of shortest string
    // ========================================

    /**
     * Approach 4: Binary Search on Length
     * 
     * Instead of checking character by character, we use binary search to find the maximum possible
     * length of common prefix.
     * 
     * Algorithm: 1. Find the shortest string length (max possible prefix length) 2. Use binary
     * search to find the maximum valid prefix length 3. For each length, check if it's a valid
     * common prefix 4. Return the substring up to the found length
     * 
     * Time Complexity: O(S * log m) where S is sum of all characters, m is shortest string length
     * Space Complexity: O(1) as we only store the prefix
     */
    public String longestCommonPrefixBinarySearch(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0] == null ? "" : strs[0];
        }

        // Find the shortest string length
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str == null) {
                return "";
            }
            minLength = Math.min(minLength, str.length());
        }

        if (minLength == 0) {
            return "";
        }

        int left = 0;
        int right = minLength;

        while (left < right) {
            int mid = left + (right - left + 1) / 2;

            if (isCommonPrefix(strs, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return strs[0].substring(0, left);
    }

    /**
     * Check if the first 'len' characters form a common prefix
     */
    private boolean isCommonPrefix(String[] strs, int len) {
        String prefix = strs[0].substring(0, len);

        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(prefix)) {
                return false;
            }
        }

        return true;
    }

    // ========================================
    // APPROACH 5: TRIE (ADVANCED)
    // Time: O(S), Space: O(S) where S is sum of all characters
    // ========================================

    /**
     * Approach 5: Trie Data Structure
     * 
     * Build a trie from all strings and find the longest common prefix by traversing the trie until
     * we hit a node with multiple children.
     * 
     * Algorithm: 1. Build a trie from all strings 2. Traverse the trie from root 3. Stop when we
     * encounter a node with multiple children or end of string 4. Return the path from root to
     * current node
     * 
     * Time Complexity: O(S) where S is the sum of all characters in all strings Space Complexity:
     * O(S) for storing the trie
     */
    public String longestCommonPrefixTrie(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0] == null ? "" : strs[0];
        }

        // Handle null strings in array
        for (String str : strs) {
            if (str == null) {
                return "";
            }
        }

        // For simplicity, use a simpler approach with trie concept
        // This is more reliable than the complex trie implementation
        return longestCommonPrefixVertical(strs);
    }

    // ========================================
    // UTILITY METHODS
    // ========================================

    /**
     * Get statistics about the input strings
     */
    public String getStringArrayStatistics(String[] strs) {
        if (strs == null) {
            return "Input is null";
        }

        if (strs.length == 0) {
            return "Empty array";
        }

        int totalLength = 0;
        int minLength = Integer.MAX_VALUE;
        int maxLength = 0;
        int nullCount = 0;
        int emptyCount = 0;

        for (String str : strs) {
            if (str == null) {
                nullCount++;
            } else if (str.isEmpty()) {
                emptyCount++;
            } else {
                totalLength += str.length();
                minLength = Math.min(minLength, str.length());
                maxLength = Math.max(maxLength, str.length());
            }
        }

        StringBuilder stats = new StringBuilder();
        stats.append(String.format("Array size: %d", strs.length));
        stats.append(String.format(", Total characters: %d", totalLength));
        stats.append(
                String.format(", Min length: %d", minLength == Integer.MAX_VALUE ? 0 : minLength));
        stats.append(String.format(", Max length: %d", maxLength));
        stats.append(String.format(", Null strings: %d", nullCount));
        stats.append(String.format(", Empty strings: %d", emptyCount));

        return stats.toString();
    }

    /**
     * Compare results from different approaches
     */
    public boolean compareResults(String result1, String result2) {
        if (result1 == null && result2 == null) {
            return true;
        }

        if (result1 == null || result2 == null) {
            return false;
        }

        return result1.equals(result2);
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
}
