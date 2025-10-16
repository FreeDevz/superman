package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Comprehensive test suite for RansomNote problem (LeetCode 383)
 * 
 * Test Categories: 1. LeetCode Examples - Official test cases from problem statement 2. Edge Cases
 * - Boundary conditions and special cases 3. Character Distribution - Various character frequency
 * scenarios 4. Performance Tests - Large input handling 5. Cross Approach Comparison - Verify all
 * approaches produce same results 6. Utility Methods - Test helper methods
 */
@DisplayName("RansomNote Tests")
class RansomNoteTest {

    private RansomNote solution;

    @BeforeEach
    void setUp() {
        solution = new RansomNote();
    }

    @Nested
    @DisplayName("LeetCode Examples Tests")
    class LeetCodeExamplesTests {

        @Test
        @DisplayName("Example 1: Single character mismatch")
        void testExample1() {
            String ransomNote = "a";
            String magazine = "b";
            assertFalse(solution.canConstruct(ransomNote, magazine));
        }

        @Test
        @DisplayName("Example 2: Insufficient duplicate characters")
        void testExample2() {
            String ransomNote = "aa";
            String magazine = "ab";
            assertFalse(solution.canConstruct(ransomNote, magazine));
        }

        @Test
        @DisplayName("Example 3: Sufficient characters")
        void testExample3() {
            String ransomNote = "aa";
            String magazine = "aab";
            assertTrue(solution.canConstruct(ransomNote, magazine));
        }
    }

    @Nested
    @DisplayName("Edge Cases Tests")
    class EdgeCasesTests {

        @Test
        @DisplayName("Empty ransom note")
        void testEmptyRansomNote() {
            assertTrue(solution.canConstruct("", "abc"));
        }

        @Test
        @DisplayName("Empty magazine")
        void testEmptyMagazine() {
            assertFalse(solution.canConstruct("a", ""));
        }

        @Test
        @DisplayName("Both empty strings")
        void testBothEmpty() {
            assertTrue(solution.canConstruct("", ""));
        }

        @Test
        @DisplayName("Null ransom note")
        void testNullRansomNote() {
            assertFalse(solution.canConstruct(null, "abc"));
        }

        @Test
        @DisplayName("Null magazine")
        void testNullMagazine() {
            assertFalse(solution.canConstruct("abc", null));
        }

        @Test
        @DisplayName("Both null strings")
        void testBothNull() {
            assertFalse(solution.canConstruct(null, null));
        }

        @Test
        @DisplayName("Single character match")
        void testSingleCharacterMatch() {
            assertTrue(solution.canConstruct("a", "a"));
        }

        @Test
        @DisplayName("Single character no match")
        void testSingleCharacterNoMatch() {
            assertFalse(solution.canConstruct("a", "b"));
        }

        @Test
        @DisplayName("Ransom note longer than magazine - impossible")
        void testRansomNoteLongerThanMagazine() {
            assertFalse(solution.canConstruct("aaa", "aa"));
        }

        @Test
        @DisplayName("Exact match - same strings")
        void testExactMatch() {
            assertTrue(solution.canConstruct("abc", "abc"));
        }
    }

    @Nested
    @DisplayName("Character Distribution Tests")
    class CharacterDistributionTests {

        @Test
        @DisplayName("All characters available with extras")
        void testAllCharactersWithExtras() {
            assertTrue(solution.canConstruct("abc", "aabbcc"));
        }

        @Test
        @DisplayName("Multiple of same character needed")
        void testMultipleSameCharacter() {
            assertTrue(solution.canConstruct("aaa", "aaab"));
        }

        @Test
        @DisplayName("Missing one character")
        void testMissingOneCharacter() {
            assertFalse(solution.canConstruct("abc", "ab"));
        }

        @Test
        @DisplayName("All 26 letters available")
        void testAllLettersAvailable() {
            String magazine = "abcdefghijklmnopqrstuvwxyz";
            String ransomNote = "world";
            assertTrue(solution.canConstruct(ransomNote, magazine));
        }

        @Test
        @DisplayName("Complex distribution - success")
        void testComplexDistributionSuccess() {
            String ransomNote = "programming";
            String magazine = "agmmnoprrg";
            assertFalse(solution.canConstruct(ransomNote, magazine)); // missing 'i'
        }

        @Test
        @DisplayName("Complex distribution - failure")
        void testComplexDistributionFailure() {
            String ransomNote = "hello";
            String magazine = "helo";
            assertFalse(solution.canConstruct(ransomNote, magazine)); // missing one 'l'
        }

        @Test
        @DisplayName("Repeated characters - sufficient")
        void testRepeatedCharactersSufficient() {
            assertTrue(solution.canConstruct("aabbcc", "aabbccdd"));
        }

        @Test
        @DisplayName("Repeated characters - insufficient")
        void testRepeatedCharactersInsufficient() {
            assertFalse(solution.canConstruct("aabbcc", "aabbc"));
        }

        @Test
        @DisplayName("Magazine has extra unused characters")
        void testMagazineExtraCharacters() {
            assertTrue(solution.canConstruct("abc", "xyzabcdef"));
        }

        @Test
        @DisplayName("Different order same characters")
        void testDifferentOrderSameCharacters() {
            assertTrue(solution.canConstruct("abc", "cba"));
        }
    }

    @Nested
    @DisplayName("Parameterized Tests")
    class ParameterizedTests {

        @ParameterizedTest(name = "ransomNote=\"{0}\", magazine=\"{1}\" -> {2}")
        @CsvSource({"a, b, false", "aa, ab, false", "aa, aab, true", "abc, aabbcc, true",
                "hello, world, false", "hello, helloworld, true", "test, testing, true",
                "code, decode, true", "java, javascript, true", "python, php, false"})
        @DisplayName("Various ransom note scenarios")
        void testVariousScenarios(String ransomNote, String magazine, boolean expected) {
            assertEquals(expected, solution.canConstruct(ransomNote, magazine));
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Large input - all same character")
        void testLargeInputSameCharacter() {
            String ransomNote = "a".repeat(10000);
            String magazine = "a".repeat(10000);
            assertTrue(solution.canConstruct(ransomNote, magazine));
        }

        @Test
        @DisplayName("Large input - insufficient characters")
        void testLargeInputInsufficient() {
            String ransomNote = "a".repeat(10000);
            String magazine = "a".repeat(9999);
            assertFalse(solution.canConstruct(ransomNote, magazine));
        }

        @Test
        @DisplayName("Large input - mixed characters")
        void testLargeInputMixed() {
            StringBuilder magazine = new StringBuilder();
            for (int i = 0; i < 1000; i++) {
                magazine.append("abcdefghijklmnopqrstuvwxyz");
            }
            String ransomNote = "thequickbrownfoxjumpsoverthelazydog";
            assertTrue(solution.canConstruct(ransomNote, magazine.toString()));
        }

        @Test
        @DisplayName("Maximum length strings")
        void testMaximumLengthStrings() {
            // Test with strings approaching maximum length (10^5)
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 4000; i++) {
                sb.append("abcdefghijklmnopqrstuvwxyz");
            }
            String magazine = sb.toString(); // 104,000 characters
            String ransomNote = "abcdefghijklmnopqrstuvwxyz".repeat(100); // 2,600 characters

            long startTime = System.nanoTime();
            boolean result = solution.canConstruct(ransomNote, magazine);
            long endTime = System.nanoTime();

            assertTrue(result);
            System.out.println("Time taken: " + (endTime - startTime) / 1_000_000.0 + " ms");
        }
    }

    @Nested
    @DisplayName("Cross Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @Test
        @DisplayName("Compare HashMap and Array approaches")
        void testHashMapVsArray() {
            String[][] testCases = {{"a", "b"}, {"aa", "aab"}, {"hello", "helloworld"},
                    {"test", "testing"}, {"", "abc"}, {"abc", ""}};

            for (String[] testCase : testCases) {
                String ransomNote = testCase[0];
                String magazine = testCase[1];
                boolean hashMapResult = solution.canConstructHashMap(ransomNote, magazine);
                boolean arrayResult = solution.canConstructArray(ransomNote, magazine);

                assertEquals(hashMapResult, arrayResult, String.format(
                        "Results differ for ransomNote='%s', magazine='%s'", ransomNote, magazine));
            }
        }

        @Test
        @DisplayName("Compare all four approaches")
        void testAllApproaches() {
            String[][] testCases = {{"a", "b"}, {"aa", "aab"}, {"hello", "helloworld"},
                    {"programming", "programming"}, {"abc", "xyz"}};

            for (String[] testCase : testCases) {
                String ransomNote = testCase[0];
                String magazine = testCase[1];

                boolean hashMapResult = solution.canConstructHashMap(ransomNote, magazine);
                boolean arrayResult = solution.canConstructArray(ransomNote, magazine);
                boolean twoArraysResult = solution.canConstructTwoArrays(ransomNote, magazine);
                boolean optimizedResult = solution.canConstructOptimized(ransomNote, magazine);

                assertEquals(hashMapResult, arrayResult, String
                        .format("HashMap and Array differ for '%s', '%s'", ransomNote, magazine));
                assertEquals(arrayResult, twoArraysResult, String
                        .format("Array and TwoArrays differ for '%s', '%s'", ransomNote, magazine));
                assertEquals(twoArraysResult, optimizedResult, String.format(
                        "TwoArrays and Optimized differ for '%s', '%s'", ransomNote, magazine));
            }
        }

        @Test
        @DisplayName("Performance comparison of all approaches")
        void testPerformanceComparison() {
            // Create a large test case
            StringBuilder magazine = new StringBuilder();
            for (int i = 0; i < 1000; i++) {
                magazine.append("abcdefghijklmnopqrstuvwxyz");
            }
            String magazineStr = magazine.toString();
            String ransomNote = "thequickbrownfoxjumpsoverthelazydog".repeat(50);

            // Test HashMap approach
            long start = System.nanoTime();
            solution.canConstructHashMap(ransomNote, magazineStr);
            long hashMapTime = System.nanoTime() - start;

            // Test Array approach
            start = System.nanoTime();
            solution.canConstructArray(ransomNote, magazineStr);
            long arrayTime = System.nanoTime() - start;

            // Test TwoArrays approach
            start = System.nanoTime();
            solution.canConstructTwoArrays(ransomNote, magazineStr);
            long twoArraysTime = System.nanoTime() - start;

            // Test Optimized approach
            start = System.nanoTime();
            solution.canConstructOptimized(ransomNote, magazineStr);
            long optimizedTime = System.nanoTime() - start;

            System.out.println("Performance Comparison:");
            System.out.println("HashMap: " + hashMapTime / 1_000_000.0 + " ms");
            System.out.println("Array: " + arrayTime / 1_000_000.0 + " ms");
            System.out.println("TwoArrays: " + twoArraysTime / 1_000_000.0 + " ms");
            System.out.println("Optimized: " + optimizedTime / 1_000_000.0 + " ms");
        }
    }

    @Nested
    @DisplayName("Utility Methods Tests")
    class UtilityMethodsTests {

        @Test
        @DisplayName("Get character frequency")
        void testGetCharacterFrequency() {
            String result = solution.getCharacterFrequency("hello");
            assertTrue(result.contains("h:1"));
            assertTrue(result.contains("e:1"));
            assertTrue(result.contains("l:2"));
            assertTrue(result.contains("o:1"));
        }

        @Test
        @DisplayName("Get character frequency - empty string")
        void testGetCharacterFrequencyEmpty() {
            assertEquals("[]", solution.getCharacterFrequency(""));
        }

        @Test
        @DisplayName("Get character frequency - null string")
        void testGetCharacterFrequencyNull() {
            assertEquals("[]", solution.getCharacterFrequency(null));
        }

        @Test
        @DisplayName("Get missing characters")
        void testGetMissingCharacters() {
            String result = solution.getMissingCharacters("hello", "helo");
            assertTrue(result.contains("l:1"));
        }

        @Test
        @DisplayName("Get missing characters - all available")
        void testGetMissingCharactersNone() {
            String result = solution.getMissingCharacters("hello", "helloworld");
            assertEquals("[]", result);
        }

        @Test
        @DisplayName("Get missing characters - multiple missing")
        void testGetMissingCharactersMultiple() {
            String result = solution.getMissingCharacters("aabbcc", "abc");
            assertTrue(result.contains("a:1"));
            assertTrue(result.contains("b:1"));
            assertTrue(result.contains("c:1"));
        }
    }

    @Nested
    @DisplayName("Special Pattern Tests")
    class SpecialPatternTests {

        @Test
        @DisplayName("Palindrome ransom note")
        void testPalindromeRansomNote() {
            assertTrue(solution.canConstruct("racecar", "aacceerr"));
        }

        @Test
        @DisplayName("Anagram scenario")
        void testAnagramScenario() {
            assertTrue(solution.canConstruct("listen", "silent"));
        }

        @Test
        @DisplayName("Magazine is subset of ransom note")
        void testMagazineSubsetOfRansomNote() {
            assertFalse(solution.canConstruct("abcdef", "abc"));
        }

        @Test
        @DisplayName("All same character different counts")
        void testAllSameCharacterDifferentCounts() {
            assertTrue(solution.canConstruct("aaaa", "aaaaa"));
            assertFalse(solution.canConstruct("aaaaa", "aaaa"));
        }

        @Test
        @DisplayName("Alphabetically ordered strings")
        void testAlphabeticallyOrdered() {
            assertTrue(solution.canConstruct("abc", "abcdef"));
        }

        @Test
        @DisplayName("Reverse alphabetically ordered strings")
        void testReverseAlphabeticallyOrdered() {
            assertTrue(solution.canConstruct("cba", "fedcba"));
        }
    }
}

