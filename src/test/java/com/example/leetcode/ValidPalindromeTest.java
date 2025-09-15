package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Comprehensive test suite for ValidPalindrome
 * 
 * Tests all approaches with various scenarios: - Basic functionality tests with sample data - Edge
 * cases (empty string, single character, special characters) - Performance tests with large strings
 * - Cross-validation between approaches - Character filtering validation
 */
@DisplayName("Valid Palindrome Tests")
public class ValidPalindromeTest {

    @Nested
    @DisplayName("Two Pointers Approach Tests")
    class TwoPointersApproachTests {

        @Test
        @DisplayName("Basic functionality test with example 1")
        void testBasicFunctionalityExample1() {
            ValidPalindrome.TwoPointersApproach approach =
                    new ValidPalindrome.TwoPointersApproach();

            String input = "A man, a plan, a canal: Panama";
            boolean expected = true;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Should return true for valid palindrome");
        }

        @Test
        @DisplayName("Basic functionality test with example 2")
        void testBasicFunctionalityExample2() {
            ValidPalindrome.TwoPointersApproach approach =
                    new ValidPalindrome.TwoPointersApproach();

            String input = "race a car";
            boolean expected = false;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Should return false for non-palindrome");
        }

        @Test
        @DisplayName("Test with empty string")
        void testEmptyString() {
            ValidPalindrome.TwoPointersApproach approach =
                    new ValidPalindrome.TwoPointersApproach();

            String input = "";
            boolean expected = true;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Empty string should be palindrome");
        }

        @Test
        @DisplayName("Test with single character")
        void testSingleCharacter() {
            ValidPalindrome.TwoPointersApproach approach =
                    new ValidPalindrome.TwoPointersApproach();

            String input = "a";
            boolean expected = true;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Single character should be palindrome");
        }

        @Test
        @DisplayName("Test with only special characters")
        void testOnlySpecialCharacters() {
            ValidPalindrome.TwoPointersApproach approach =
                    new ValidPalindrome.TwoPointersApproach();

            String input = "!@#$%^&*()";
            boolean expected = true;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Only special characters should be palindrome");
        }

        @Test
        @DisplayName("Test with mixed case")
        void testMixedCase() {
            ValidPalindrome.TwoPointersApproach approach =
                    new ValidPalindrome.TwoPointersApproach();

            String input = "Madam";
            boolean expected = true;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Should handle mixed case correctly");
        }

        @Test
        @DisplayName("Test with numbers")
        void testWithNumbers() {
            ValidPalindrome.TwoPointersApproach approach =
                    new ValidPalindrome.TwoPointersApproach();

            String input = "12321";
            boolean expected = true;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Should handle numbers correctly");
        }

        @Test
        @DisplayName("Test with mixed alphanumeric")
        void testMixedAlphanumeric() {
            ValidPalindrome.TwoPointersApproach approach =
                    new ValidPalindrome.TwoPointersApproach();

            String input = "a1b2c3c2b1a";
            boolean expected = true;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Should handle mixed alphanumeric correctly");
        }
    }

    @Nested
    @DisplayName("String Preprocessing Approach Tests")
    class StringPreprocessingApproachTests {

        @Test
        @DisplayName("Basic functionality test with example 1")
        void testBasicFunctionalityExample1() {
            ValidPalindrome.StringPreprocessingApproach approach =
                    new ValidPalindrome.StringPreprocessingApproach();

            String input = "A man, a plan, a canal: Panama";
            boolean expected = true;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Should return true for valid palindrome");
        }

        @Test
        @DisplayName("Basic functionality test with example 2")
        void testBasicFunctionalityExample2() {
            ValidPalindrome.StringPreprocessingApproach approach =
                    new ValidPalindrome.StringPreprocessingApproach();

            String input = "race a car";
            boolean expected = false;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Should return false for non-palindrome");
        }

        @Test
        @DisplayName("Test with empty string")
        void testEmptyString() {
            ValidPalindrome.StringPreprocessingApproach approach =
                    new ValidPalindrome.StringPreprocessingApproach();

            String input = "";
            boolean expected = true;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Empty string should be palindrome");
        }

        @Test
        @DisplayName("Test with only special characters")
        void testOnlySpecialCharacters() {
            ValidPalindrome.StringPreprocessingApproach approach =
                    new ValidPalindrome.StringPreprocessingApproach();

            String input = "!@#$%^&*()";
            boolean expected = true;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Only special characters should be palindrome");
        }
    }

    @Nested
    @DisplayName("Recursive Approach Tests")
    class RecursiveApproachTests {

        @Test
        @DisplayName("Basic functionality test with example 1")
        void testBasicFunctionalityExample1() {
            ValidPalindrome.RecursiveApproach approach = new ValidPalindrome.RecursiveApproach();

            String input = "A man, a plan, a canal: Panama";
            boolean expected = true;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Should return true for valid palindrome");
        }

        @Test
        @DisplayName("Basic functionality test with example 2")
        void testBasicFunctionalityExample2() {
            ValidPalindrome.RecursiveApproach approach = new ValidPalindrome.RecursiveApproach();

            String input = "race a car";
            boolean expected = false;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Should return false for non-palindrome");
        }

        @Test
        @DisplayName("Test with empty string")
        void testEmptyString() {
            ValidPalindrome.RecursiveApproach approach = new ValidPalindrome.RecursiveApproach();

            String input = "";
            boolean expected = true;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Empty string should be palindrome");
        }

        @Test
        @DisplayName("Test with single character")
        void testSingleCharacter() {
            ValidPalindrome.RecursiveApproach approach = new ValidPalindrome.RecursiveApproach();

            String input = "a";
            boolean expected = true;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Single character should be palindrome");
        }
    }

    @Nested
    @DisplayName("Stack Approach Tests")
    class StackApproachTests {

        @Test
        @DisplayName("Basic functionality test with example 1")
        void testBasicFunctionalityExample1() {
            ValidPalindrome.StackApproach approach = new ValidPalindrome.StackApproach();

            String input = "A man, a plan, a canal: Panama";
            boolean expected = true;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Should return true for valid palindrome");
        }

        @Test
        @DisplayName("Basic functionality test with example 2")
        void testBasicFunctionalityExample2() {
            ValidPalindrome.StackApproach approach = new ValidPalindrome.StackApproach();

            String input = "race a car";
            boolean expected = false;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Should return false for non-palindrome");
        }

        @Test
        @DisplayName("Test with empty string")
        void testEmptyString() {
            ValidPalindrome.StackApproach approach = new ValidPalindrome.StackApproach();

            String input = "";
            boolean expected = true;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Empty string should be palindrome");
        }
    }

    @Nested
    @DisplayName("StringBuilder Approach Tests")
    class StringBuilderApproachTests {

        @Test
        @DisplayName("Basic functionality test with example 1")
        void testBasicFunctionalityExample1() {
            ValidPalindrome.StringBuilderApproach approach =
                    new ValidPalindrome.StringBuilderApproach();

            String input = "A man, a plan, a canal: Panama";
            boolean expected = true;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Should return true for valid palindrome");
        }

        @Test
        @DisplayName("Basic functionality test with example 2")
        void testBasicFunctionalityExample2() {
            ValidPalindrome.StringBuilderApproach approach =
                    new ValidPalindrome.StringBuilderApproach();

            String input = "race a car";
            boolean expected = false;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Should return false for non-palindrome");
        }

        @Test
        @DisplayName("Test with empty string")
        void testEmptyString() {
            ValidPalindrome.StringBuilderApproach approach =
                    new ValidPalindrome.StringBuilderApproach();

            String input = "";
            boolean expected = true;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Empty string should be palindrome");
        }
    }

    @Nested
    @DisplayName("Character Array Approach Tests")
    class CharacterArrayApproachTests {

        @Test
        @DisplayName("Basic functionality test with example 1")
        void testBasicFunctionalityExample1() {
            ValidPalindrome.CharacterArrayApproach approach =
                    new ValidPalindrome.CharacterArrayApproach();

            String input = "A man, a plan, a canal: Panama";
            boolean expected = true;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Should return true for valid palindrome");
        }

        @Test
        @DisplayName("Basic functionality test with example 2")
        void testBasicFunctionalityExample2() {
            ValidPalindrome.CharacterArrayApproach approach =
                    new ValidPalindrome.CharacterArrayApproach();

            String input = "race a car";
            boolean expected = false;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Should return false for non-palindrome");
        }

        @Test
        @DisplayName("Test with empty string")
        void testEmptyString() {
            ValidPalindrome.CharacterArrayApproach approach =
                    new ValidPalindrome.CharacterArrayApproach();

            String input = "";
            boolean expected = true;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Empty string should be palindrome");
        }
    }

    @Nested
    @DisplayName("Optimized Two Pointers Approach Tests")
    class OptimizedTwoPointersApproachTests {

        @Test
        @DisplayName("Basic functionality test with example 1")
        void testBasicFunctionalityExample1() {
            ValidPalindrome.OptimizedTwoPointersApproach approach =
                    new ValidPalindrome.OptimizedTwoPointersApproach();

            String input = "A man, a plan, a canal: Panama";
            boolean expected = true;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Should return true for valid palindrome");
        }

        @Test
        @DisplayName("Basic functionality test with example 2")
        void testBasicFunctionalityExample2() {
            ValidPalindrome.OptimizedTwoPointersApproach approach =
                    new ValidPalindrome.OptimizedTwoPointersApproach();

            String input = "race a car";
            boolean expected = false;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Should return false for non-palindrome");
        }

        @Test
        @DisplayName("Test with empty string")
        void testEmptyString() {
            ValidPalindrome.OptimizedTwoPointersApproach approach =
                    new ValidPalindrome.OptimizedTwoPointersApproach();

            String input = "";
            boolean expected = true;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Empty string should be palindrome");
        }
    }

    @Nested
    @DisplayName("Cross-Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @Test
        @DisplayName("All approaches should produce same result with example 1")
        void testAllApproachesSameResultExample1() {
            String input = "A man, a plan, a canal: Panama";
            boolean expected = true;

            // Test all approaches
            boolean twoPointersResult =
                    new ValidPalindrome.TwoPointersApproach().isPalindrome(input);
            boolean stringPreprocessingResult =
                    new ValidPalindrome.StringPreprocessingApproach().isPalindrome(input);
            boolean recursiveResult = new ValidPalindrome.RecursiveApproach().isPalindrome(input);
            boolean stackResult = new ValidPalindrome.StackApproach().isPalindrome(input);
            boolean stringBuilderResult =
                    new ValidPalindrome.StringBuilderApproach().isPalindrome(input);
            boolean characterArrayResult =
                    new ValidPalindrome.CharacterArrayApproach().isPalindrome(input);
            boolean optimizedResult =
                    new ValidPalindrome.OptimizedTwoPointersApproach().isPalindrome(input);

            // All results should be the same
            assertEquals(expected, twoPointersResult, "Two Pointers should match expected");
            assertEquals(expected, stringPreprocessingResult,
                    "String Preprocessing should match expected");
            assertEquals(expected, recursiveResult, "Recursive should match expected");
            assertEquals(expected, stackResult, "Stack should match expected");
            assertEquals(expected, stringBuilderResult, "StringBuilder should match expected");
            assertEquals(expected, characterArrayResult, "Character Array should match expected");
            assertEquals(expected, optimizedResult, "Optimized Two Pointers should match expected");
        }

        @Test
        @DisplayName("All approaches should produce same result with example 2")
        void testAllApproachesSameResultExample2() {
            String input = "race a car";
            boolean expected = false;

            // Test all approaches
            boolean twoPointersResult =
                    new ValidPalindrome.TwoPointersApproach().isPalindrome(input);
            boolean stringPreprocessingResult =
                    new ValidPalindrome.StringPreprocessingApproach().isPalindrome(input);
            boolean recursiveResult = new ValidPalindrome.RecursiveApproach().isPalindrome(input);
            boolean stackResult = new ValidPalindrome.StackApproach().isPalindrome(input);
            boolean stringBuilderResult =
                    new ValidPalindrome.StringBuilderApproach().isPalindrome(input);
            boolean characterArrayResult =
                    new ValidPalindrome.CharacterArrayApproach().isPalindrome(input);
            boolean optimizedResult =
                    new ValidPalindrome.OptimizedTwoPointersApproach().isPalindrome(input);

            // All results should be the same
            assertEquals(expected, twoPointersResult, "Two Pointers should match expected");
            assertEquals(expected, stringPreprocessingResult,
                    "String Preprocessing should match expected");
            assertEquals(expected, recursiveResult, "Recursive should match expected");
            assertEquals(expected, stackResult, "Stack should match expected");
            assertEquals(expected, stringBuilderResult, "StringBuilder should match expected");
            assertEquals(expected, characterArrayResult, "Character Array should match expected");
            assertEquals(expected, optimizedResult, "Optimized Two Pointers should match expected");
        }

        @Test
        @DisplayName("All approaches should produce same result with test cases")
        void testAllApproachesSameResultWithTestCases() {
            List<ValidPalindrome.TestData.TestCase> testCases =
                    ValidPalindrome.TestData.getTestCases();

            for (ValidPalindrome.TestData.TestCase testCase : testCases) {
                // Test all approaches
                boolean twoPointersResult =
                        new ValidPalindrome.TwoPointersApproach().isPalindrome(testCase.getInput());
                boolean stringPreprocessingResult =
                        new ValidPalindrome.StringPreprocessingApproach()
                                .isPalindrome(testCase.getInput());
                boolean recursiveResult =
                        new ValidPalindrome.RecursiveApproach().isPalindrome(testCase.getInput());
                boolean stackResult =
                        new ValidPalindrome.StackApproach().isPalindrome(testCase.getInput());
                boolean stringBuilderResult = new ValidPalindrome.StringBuilderApproach()
                        .isPalindrome(testCase.getInput());
                boolean characterArrayResult = new ValidPalindrome.CharacterArrayApproach()
                        .isPalindrome(testCase.getInput());
                boolean optimizedResult = new ValidPalindrome.OptimizedTwoPointersApproach()
                        .isPalindrome(testCase.getInput());

                // All results should be the same
                assertTrue(twoPointersResult == stringPreprocessingResult,
                        "Two Pointers and String Preprocessing should match for: "
                                + testCase.getDescription());
                assertTrue(twoPointersResult == recursiveResult,
                        "Two Pointers and Recursive should match for: "
                                + testCase.getDescription());
                assertTrue(twoPointersResult == stackResult,
                        "Two Pointers and Stack should match for: " + testCase.getDescription());
                assertTrue(twoPointersResult == stringBuilderResult,
                        "Two Pointers and StringBuilder should match for: "
                                + testCase.getDescription());
                assertTrue(twoPointersResult == characterArrayResult,
                        "Two Pointers and Character Array should match for: "
                                + testCase.getDescription());
                assertTrue(twoPointersResult == optimizedResult,
                        "Two Pointers and Optimized should match for: "
                                + testCase.getDescription());

                // All should match expected
                assertEquals(testCase.getExpected(), twoPointersResult,
                        "Result should match expected for: " + testCase.getDescription());
            }
        }
    }

    @Nested
    @DisplayName("Edge Case Tests")
    class EdgeCaseTests {

        @Test
        @DisplayName("Test with null input")
        void testNullInput() {
            ValidPalindrome.TwoPointersApproach approach =
                    new ValidPalindrome.TwoPointersApproach();

            String input = null;
            boolean expected = true;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Null input should be considered palindrome");
        }

        @Test
        @DisplayName("Test with single space")
        void testSingleSpace() {
            ValidPalindrome.TwoPointersApproach approach =
                    new ValidPalindrome.TwoPointersApproach();

            String input = " ";
            boolean expected = true;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Single space should be palindrome");
        }

        @Test
        @DisplayName("Test with two different characters")
        void testTwoDifferentCharacters() {
            ValidPalindrome.TwoPointersApproach approach =
                    new ValidPalindrome.TwoPointersApproach();

            String input = "ab";
            boolean expected = false;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Two different characters should not be palindrome");
        }

        @Test
        @DisplayName("Test with two same characters")
        void testTwoSameCharacters() {
            ValidPalindrome.TwoPointersApproach approach =
                    new ValidPalindrome.TwoPointersApproach();

            String input = "aa";
            boolean expected = true;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Two same characters should be palindrome");
        }

        @Test
        @DisplayName("Test with three character palindrome")
        void testThreeCharacterPalindrome() {
            ValidPalindrome.TwoPointersApproach approach =
                    new ValidPalindrome.TwoPointersApproach();

            String input = "aba";
            boolean expected = true;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Three character palindrome should be valid");
        }

        @Test
        @DisplayName("Test with three character non-palindrome")
        void testThreeCharacterNonPalindrome() {
            ValidPalindrome.TwoPointersApproach approach =
                    new ValidPalindrome.TwoPointersApproach();

            String input = "abc";
            boolean expected = false;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Three character non-palindrome should be invalid");
        }

        @Test
        @DisplayName("Test with complex palindrome")
        void testComplexPalindrome() {
            ValidPalindrome.TwoPointersApproach approach =
                    new ValidPalindrome.TwoPointersApproach();

            String input = "A Santa at NASA";
            boolean expected = true;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Complex palindrome should be valid");
        }

        @Test
        @DisplayName("Test with question mark palindrome")
        void testQuestionMarkPalindrome() {
            ValidPalindrome.TwoPointersApproach approach =
                    new ValidPalindrome.TwoPointersApproach();

            String input = "Was it a car or a cat I saw?";
            boolean expected = true;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Question mark palindrome should be valid");
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Performance comparison between approaches")
        void testPerformanceComparison() {
            String testString =
                    "A man, a plan, a canal: Panama! This is a very long string with many characters to test performance.";

            // Test Two Pointers approach (should be fastest)
            long startTime = System.nanoTime();
            new ValidPalindrome.TwoPointersApproach().isPalindrome(testString);
            long twoPointersTime = System.nanoTime() - startTime;

            // Test String Preprocessing approach
            startTime = System.nanoTime();
            new ValidPalindrome.StringPreprocessingApproach().isPalindrome(testString);
            long stringPreprocessingTime = System.nanoTime() - startTime;

            // Test Recursive approach
            startTime = System.nanoTime();
            new ValidPalindrome.RecursiveApproach().isPalindrome(testString);
            long recursiveTime = System.nanoTime() - startTime;

            System.out.println("Performance Results:");
            System.out.println("Two Pointers: " + (twoPointersTime / 1_000) + "μs");
            System.out.println("String Preprocessing: " + (stringPreprocessingTime / 1_000) + "μs");
            System.out.println("Recursive: " + (recursiveTime / 1_000) + "μs");

            // Two Pointers should be faster than String Preprocessing (no string creation)
            assertTrue(twoPointersTime <= stringPreprocessingTime,
                    "Two Pointers should be faster than String Preprocessing");
        }
    }

    @Nested
    @DisplayName("Character Filtering Tests")
    class CharacterFilteringTests {

        @Test
        @DisplayName("Test character filtering with various special characters")
        void testCharacterFiltering() {
            ValidPalindrome.TwoPointersApproach approach =
                    new ValidPalindrome.TwoPointersApproach();

            String input = "a!@#$%^&*()b";
            boolean expected = false; // "ab" is not a palindrome after filtering special characters

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Should filter out special characters correctly");
        }

        @Test
        @DisplayName("Test with mixed case and numbers")
        void testMixedCaseAndNumbers() {
            ValidPalindrome.TwoPointersApproach approach =
                    new ValidPalindrome.TwoPointersApproach();

            String input = "A1B2C3C2B1A";
            boolean expected = true;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Should handle mixed case and numbers correctly");
        }

        @Test
        @DisplayName("Test with punctuation and spaces")
        void testPunctuationAndSpaces() {
            ValidPalindrome.TwoPointersApproach approach =
                    new ValidPalindrome.TwoPointersApproach();

            String input = "Mr. Owl ate my metal worm";
            boolean expected = true;

            boolean result = approach.isPalindrome(input);

            assertEquals(expected, result, "Should handle punctuation and spaces correctly");
        }
    }

    @Nested
    @DisplayName("Helper Method Tests")
    class HelperMethodTests {

        @Test
        @DisplayName("Test getCleanedString helper method")
        void testGetCleanedString() {
            String input = "A man, a plan, a canal: Panama";
            String expected = "amanaplanacanalpanama";

            String result = ValidPalindrome.getCleanedString(input);

            assertEquals(expected, result, "Should clean string correctly");
        }

        @Test
        @DisplayName("Test getCleanedString with null input")
        void testGetCleanedStringWithNull() {
            String input = null;
            String expected = "null";

            String result = ValidPalindrome.getCleanedString(input);

            assertEquals(expected, result, "Should handle null input correctly");
        }

        @Test
        @DisplayName("Test getCleanedString with only special characters")
        void testGetCleanedStringWithOnlySpecialCharacters() {
            String input = "!@#$%^&*()";
            String expected = "";

            String result = ValidPalindrome.getCleanedString(input);

            assertEquals(expected, result,
                    "Should return empty string for only special characters");
        }

        @Test
        @DisplayName("Test validateResult helper method")
        void testValidateResult() {
            assertTrue(ValidPalindrome.validateResult(true, true),
                    "Should return true for matching results");
            assertTrue(ValidPalindrome.validateResult(false, false),
                    "Should return true for matching results");
            assertTrue(!ValidPalindrome.validateResult(true, false),
                    "Should return false for non-matching results");
            assertTrue(!ValidPalindrome.validateResult(false, true),
                    "Should return false for non-matching results");
        }
    }
}
