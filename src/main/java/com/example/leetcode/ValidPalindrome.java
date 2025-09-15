package com.example.leetcode;

import java.util.*;

/**
 * LeetCode 125. Valid Palindrome
 * 
 * Problem Description: A phrase is a palindrome if, after converting all uppercase letters into
 * lowercase letters and removing all non-alphanumeric characters, it reads the same forward and
 * backward. Alphanumeric characters include letters and numbers.
 * 
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * 
 * Example 1: Input: s = "A man, a plan, a canal: Panama" Output: true Explanation:
 * "amanaplanacanalpanama" is a palindrome.
 * 
 * Example 2: Input: s = "race a car" Output: false Explanation: "raceacar" is not a palindrome.
 * 
 * Example 3: Input: s = " " Output: true Explanation: s is an empty string "" after removing
 * non-alphanumeric characters. Since an empty string reads the same forward and backward, it is a
 * palindrome.
 * 
 * Constraints: - 1 <= s.length <= 2 * 10^5 - s consists only of printable ASCII characters.
 * 
 * Approach Analysis: 1. Two Pointers Approach: Use two pointers from start and end, skip
 * non-alphanumeric 2. String Preprocessing Approach: Clean string first, then check palindrome 3.
 * Recursive Approach: Recursive palindrome checking with character filtering 4. Stack Approach: Use
 * stack to reverse and compare 5. StringBuilder Approach: Build cleaned string and reverse to
 * compare 6. Character Array Approach: Convert to char array and use two pointers
 * 
 * Time Complexity: O(n) where n is the length of the string Space Complexity: O(1) for two
 * pointers, O(n) for preprocessing approaches
 */
public class ValidPalindrome {

    /**
     * Approach 1: Two Pointers (Optimal)
     * 
     * Use two pointers from start and end, skip non-alphanumeric characters and compare characters
     * (case-insensitive).
     * 
     * Time Complexity: O(n) Space Complexity: O(1)
     */
    public static class TwoPointersApproach {
        public boolean isPalindrome(String s) {
            if (s == null || s.isEmpty()) {
                return true;
            }

            int left = 0;
            int right = s.length() - 1;

            while (left < right) {
                // Skip non-alphanumeric characters from left
                while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                    left++;
                }

                // Skip non-alphanumeric characters from right
                while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                    right--;
                }

                // Compare characters (case-insensitive)
                if (Character.toLowerCase(s.charAt(left)) != Character
                        .toLowerCase(s.charAt(right))) {
                    return false;
                }

                left++;
                right--;
            }

            return true;
        }
    }

    /**
     * Approach 2: String Preprocessing
     * 
     * Clean the string first by removing non-alphanumeric characters and converting to lowercase,
     * then check if it's a palindrome.
     * 
     * Time Complexity: O(n) Space Complexity: O(n)
     */
    public static class StringPreprocessingApproach {
        public boolean isPalindrome(String s) {
            if (s == null || s.isEmpty()) {
                return true;
            }

            // Clean the string: remove non-alphanumeric and convert to lowercase
            String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

            // Check if cleaned string is palindrome
            int left = 0;
            int right = cleaned.length() - 1;

            while (left < right) {
                if (cleaned.charAt(left) != cleaned.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }

            return true;
        }
    }

    /**
     * Approach 3: Recursive Approach
     * 
     * Recursive palindrome checking with character filtering.
     * 
     * Time Complexity: O(n) Space Complexity: O(n) due to recursion stack
     */
    public static class RecursiveApproach {
        public boolean isPalindrome(String s) {
            if (s == null || s.isEmpty()) {
                return true;
            }

            return isPalindromeHelper(s, 0, s.length() - 1);
        }

        private boolean isPalindromeHelper(String s, int left, int right) {
            // Base case: pointers have met or crossed
            if (left >= right) {
                return true;
            }

            // Skip non-alphanumeric characters from left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Skip non-alphanumeric characters from right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters (case-insensitive)
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            // Recursive call for next characters
            return isPalindromeHelper(s, left + 1, right - 1);
        }
    }

    /**
     * Approach 4: Stack Approach
     * 
     * Use stack to reverse the cleaned string and compare.
     * 
     * Time Complexity: O(n) Space Complexity: O(n)
     */
    public static class StackApproach {
        public boolean isPalindrome(String s) {
            if (s == null || s.isEmpty()) {
                return true;
            }

            // Clean the string
            String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

            if (cleaned.isEmpty()) {
                return true;
            }

            // Use stack to reverse
            Stack<Character> stack = new Stack<>();
            for (char c : cleaned.toCharArray()) {
                stack.push(c);
            }

            // Compare with original
            for (char c : cleaned.toCharArray()) {
                if (c != stack.pop()) {
                    return false;
                }
            }

            return true;
        }
    }

    /**
     * Approach 5: StringBuilder Approach
     * 
     * Build cleaned string and reverse to compare.
     * 
     * Time Complexity: O(n) Space Complexity: O(n)
     */
    public static class StringBuilderApproach {
        public boolean isPalindrome(String s) {
            if (s == null || s.isEmpty()) {
                return true;
            }

            // Build cleaned string
            StringBuilder cleaned = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (Character.isLetterOrDigit(c)) {
                    cleaned.append(Character.toLowerCase(c));
                }
            }

            String cleanedStr = cleaned.toString();
            String reversed = cleaned.reverse().toString();

            return cleanedStr.equals(reversed);
        }
    }

    /**
     * Approach 6: Character Array Approach
     * 
     * Convert to character array and use two pointers.
     * 
     * Time Complexity: O(n) Space Complexity: O(n)
     */
    public static class CharacterArrayApproach {
        public boolean isPalindrome(String s) {
            if (s == null || s.isEmpty()) {
                return true;
            }

            char[] chars = s.toCharArray();
            int left = 0;
            int right = chars.length - 1;

            while (left < right) {
                // Skip non-alphanumeric characters from left
                while (left < right && !Character.isLetterOrDigit(chars[left])) {
                    left++;
                }

                // Skip non-alphanumeric characters from right
                while (left < right && !Character.isLetterOrDigit(chars[right])) {
                    right--;
                }

                // Compare characters (case-insensitive)
                if (Character.toLowerCase(chars[left]) != Character.toLowerCase(chars[right])) {
                    return false;
                }

                left++;
                right--;
            }

            return true;
        }
    }

    /**
     * Approach 7: Optimized Two Pointers with Helper Methods
     * 
     * Two pointers approach with helper methods for better readability.
     * 
     * Time Complexity: O(n) Space Complexity: O(1)
     */
    public static class OptimizedTwoPointersApproach {
        public boolean isPalindrome(String s) {
            if (s == null || s.isEmpty()) {
                return true;
            }

            int left = 0;
            int right = s.length() - 1;

            while (left < right) {
                // Find next valid character from left
                while (left < right && !isAlphanumeric(s.charAt(left))) {
                    left++;
                }

                // Find next valid character from right
                while (left < right && !isAlphanumeric(s.charAt(right))) {
                    right--;
                }

                // Compare characters
                if (toLowerCase(s.charAt(left)) != toLowerCase(s.charAt(right))) {
                    return false;
                }

                left++;
                right--;
            }

            return true;
        }

        private boolean isAlphanumeric(char c) {
            return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
        }

        private char toLowerCase(char c) {
            if (c >= 'A' && c <= 'Z') {
                return (char) (c + 32);
            }
            return c;
        }
    }

    /**
     * Helper method to create test data
     */
    public static class TestData {
        public static List<TestCase> getTestCases() {
            return Arrays.asList(new TestCase("A man, a plan, a canal: Panama", true, "Example 1"),
                    new TestCase("race a car", false, "Example 2"),
                    new TestCase(" ", true, "Example 3 - empty string"),
                    new TestCase("", true, "Empty string"),
                    new TestCase("a", true, "Single character"),
                    new TestCase("ab", false, "Two different characters"),
                    new TestCase("aa", true, "Two same characters"),
                    new TestCase("aba", true, "Three character palindrome"),
                    new TestCase("abc", false, "Three character non-palindrome"),
                    new TestCase("Madam", true, "Case insensitive"),
                    new TestCase("No 'x' in Nixon", true, "With punctuation"),
                    new TestCase("A Santa at NASA", true, "Complex palindrome"),
                    new TestCase("Was it a car or a cat I saw?", true, "Question mark"),
                    new TestCase("race a car", false, "Non-palindrome"),
                    new TestCase("12321", true, "Numeric palindrome"),
                    new TestCase("12345", false, "Numeric non-palindrome"),
                    new TestCase("a1b2c3c2b1a", true, "Mixed alphanumeric"),
                    new TestCase("a1b2c3d2b1a", false, "Mixed alphanumeric non-palindrome"),
                    new TestCase("!@#$%^&*()", true, "Only special characters"),
                    new TestCase("A man, a plan, a canal: Panama!", true, "With exclamation"),
                    new TestCase("Mr. Owl ate my metal worm", true, "Complex sentence"),
                    new TestCase("Do geese see God?", true, "Question palindrome"),
                    new TestCase("Was it a rat I saw?", true, "Another question"),
                    new TestCase("A Toyota! Race fast, safe car! A Toyota!", true,
                            "Long palindrome"),
                    new TestCase("Not a palindrome", false, "Clear non-palindrome"));
        }

        public static class TestCase {
            private final String input;
            private final boolean expected;
            private final String description;

            public TestCase(String input, boolean expected, String description) {
                this.input = input;
                this.expected = expected;
                this.description = description;
            }

            public String getInput() {
                return input;
            }

            public boolean getExpected() {
                return expected;
            }

            public String getDescription() {
                return description;
            }
        }
    }

    /**
     * Helper method to run a test with given approach
     */
    public static void runTest(String approachName, Object approach, String input,
            boolean expected) {
        System.out.println("\n=== Testing " + approachName + " ===");
        System.out.println("Input: \"" + input + "\"");
        System.out.println("Expected: " + expected);

        try {
            long startTime = System.nanoTime();
            boolean result;

            if (approach instanceof TwoPointersApproach) {
                result = ((TwoPointersApproach) approach).isPalindrome(input);
            } else if (approach instanceof StringPreprocessingApproach) {
                result = ((StringPreprocessingApproach) approach).isPalindrome(input);
            } else if (approach instanceof RecursiveApproach) {
                result = ((RecursiveApproach) approach).isPalindrome(input);
            } else if (approach instanceof StackApproach) {
                result = ((StackApproach) approach).isPalindrome(input);
            } else if (approach instanceof StringBuilderApproach) {
                result = ((StringBuilderApproach) approach).isPalindrome(input);
            } else if (approach instanceof CharacterArrayApproach) {
                result = ((CharacterArrayApproach) approach).isPalindrome(input);
            } else if (approach instanceof OptimizedTwoPointersApproach) {
                result = ((OptimizedTwoPointersApproach) approach).isPalindrome(input);
            } else {
                throw new IllegalArgumentException("Unknown approach: " + approachName);
            }

            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1_000; // Convert to microseconds

            System.out.println("Result: " + result);
            System.out.println("Correct: " + (result == expected));
            System.out.println("Execution time: " + duration + "μs");

        } catch (Exception e) {
            System.err.println("Error in " + approachName + ": " + e.getMessage());
        }
    }

    /**
     * Helper method to validate results
     */
    public static boolean validateResult(boolean actual, boolean expected) {
        return actual == expected;
    }

    /**
     * Helper method to get cleaned string for debugging
     */
    public static String getCleanedString(String s) {
        if (s == null)
            return "null";
        return s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    /**
     * Main method for testing all approaches
     */
    public static void main(String[] args) {
        System.out.println("Valid Palindrome - Multiple Approaches Demo");
        System.out.println("==========================================");

        // Test with sample data
        List<TestData.TestCase> testCases = TestData.getTestCases();

        // Test all approaches
        String[] approachNames = {"Two Pointers", "String Preprocessing", "Recursive", "Stack",
                "StringBuilder", "Character Array", "Optimized Two Pointers"};

        Object[] approaches = {new TwoPointersApproach(), new StringPreprocessingApproach(),
                new RecursiveApproach(), new StackApproach(), new StringBuilderApproach(),
                new CharacterArrayApproach(), new OptimizedTwoPointersApproach()};

        // Test with first few test cases
        System.out.println("\nTesting with sample cases:");
        for (int i = 0; i < Math.min(5, testCases.size()); i++) {
            TestData.TestCase testCase = testCases.get(i);
            System.out.println("\n" + "=".repeat(60));
            System.out.println("Test Case: " + testCase.getDescription());
            System.out.println("Cleaned string: \"" + getCleanedString(testCase.getInput()) + "\"");

            for (int j = 0; j < approachNames.length; j++) {
                runTest(approachNames[j], approaches[j], testCase.getInput(),
                        testCase.getExpected());
            }
        }

        // Performance test with larger strings
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Performance Test with Large Strings");
        System.out.println("=".repeat(60));

        String largePalindrome = generateLargePalindrome(1000);
        String largeNonPalindrome = generateLargeNonPalindrome(1000);

        System.out.println("Large Palindrome (1000 chars):");
        for (int i = 0; i < approachNames.length; i++) {
            runTest(approachNames[i], approaches[i], largePalindrome, true);
        }

        System.out.println("\nLarge Non-Palindrome (1000 chars):");
        for (int i = 0; i < approachNames.length; i++) {
            runTest(approachNames[i], approaches[i], largeNonPalindrome, false);
        }

        // Cross-validation test
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Cross-Validation Test");
        System.out.println("=".repeat(60));

        boolean allCorrect = true;
        for (TestData.TestCase testCase : testCases) {
            List<Boolean> results = new ArrayList<>();

            for (Object approach : approaches) {
                boolean result;
                if (approach instanceof TwoPointersApproach) {
                    result = ((TwoPointersApproach) approach).isPalindrome(testCase.getInput());
                } else if (approach instanceof StringPreprocessingApproach) {
                    result = ((StringPreprocessingApproach) approach)
                            .isPalindrome(testCase.getInput());
                } else if (approach instanceof RecursiveApproach) {
                    result = ((RecursiveApproach) approach).isPalindrome(testCase.getInput());
                } else if (approach instanceof StackApproach) {
                    result = ((StackApproach) approach).isPalindrome(testCase.getInput());
                } else if (approach instanceof StringBuilderApproach) {
                    result = ((StringBuilderApproach) approach).isPalindrome(testCase.getInput());
                } else if (approach instanceof CharacterArrayApproach) {
                    result = ((CharacterArrayApproach) approach).isPalindrome(testCase.getInput());
                } else if (approach instanceof OptimizedTwoPointersApproach) {
                    result = ((OptimizedTwoPointersApproach) approach)
                            .isPalindrome(testCase.getInput());
                } else {
                    continue;
                }
                results.add(result);
            }

            // Check if all approaches produce same result
            boolean allSame = results.stream().allMatch(r -> r.equals(results.get(0)));
            boolean correct = results.get(0) == testCase.getExpected();

            if (!allSame || !correct) {
                allCorrect = false;
                System.out.println("FAILED: " + testCase.getDescription());
                System.out.println("  Input: \"" + testCase.getInput() + "\"");
                System.out.println("  Expected: " + testCase.getExpected());
                System.out.println("  Results: " + results);
            }
        }

        System.out.println("All approaches produce consistent results: " + allCorrect);
    }

    /**
     * Helper method to generate large palindrome for performance testing
     */
    private static String generateLargePalindrome(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random(42); // Fixed seed for reproducibility

        for (int i = 0; i < length / 2; i++) {
            char c = (char) ('a' + random.nextInt(26));
            sb.append(c);
            // Add some non-alphanumeric characters
            if (i % 10 == 0) {
                sb.append("!@#$%^&*()");
            }
        }

        String firstHalf = sb.toString();
        String secondHalf = new StringBuilder(firstHalf).reverse().toString();

        return firstHalf + secondHalf;
    }

    /**
     * Helper method to generate large non-palindrome for performance testing
     */
    private static String generateLargeNonPalindrome(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random(123); // Different seed

        for (int i = 0; i < length; i++) {
            char c = (char) ('a' + random.nextInt(26));
            sb.append(c);
            // Add some non-alphanumeric characters
            if (i % 15 == 0) {
                sb.append("!@#$%^&*()");
            }
        }

        return sb.toString();
    }
}
