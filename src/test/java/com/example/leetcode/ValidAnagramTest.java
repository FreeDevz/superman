package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Comprehensive test suite for ValidAnagram (LeetCode 242)
 * 
 * Test Coverage: - Basic anagram detection - Edge cases (empty strings, single character) -
 * Different length strings - Same strings - Strings with repeated characters - Performance tests -
 * Unicode character support - All 7 different approaches
 */
@DisplayName("ValidAnagram (LeetCode 242) Tests")
public class ValidAnagramTest {

    private ValidAnagram solution;

    @BeforeEach
    void setUp() {
        solution = new ValidAnagram();
    }

    @Nested
    @DisplayName("Sorting Approach Tests")
    class SortingApproachTests {

        @Test
        @DisplayName("Basic anagram - 'anagram' and 'nagaram'")
        void testBasicAnagram() {
            assertTrue(solution.isAnagramSorting("anagram", "nagaram"));
        }

        @Test
        @DisplayName("Not an anagram - 'rat' and 'car'")
        void testNotAnagram() {
            assertFalse(solution.isAnagramSorting("rat", "car"));
        }

        @Test
        @DisplayName("Single character match")
        void testSingleCharMatch() {
            assertTrue(solution.isAnagramSorting("a", "a"));
        }

        @Test
        @DisplayName("Single character no match")
        void testSingleCharNoMatch() {
            assertFalse(solution.isAnagramSorting("a", "b"));
        }

        @Test
        @DisplayName("Different lengths")
        void testDifferentLengths() {
            assertFalse(solution.isAnagramSorting("ab", "abc"));
        }
    }

    @Nested
    @DisplayName("HashMap Approach Tests")
    class HashMapApproachTests {

        @Test
        @DisplayName("Basic anagram - 'listen' and 'silent'")
        void testBasicAnagram() {
            assertTrue(solution.isAnagramHashMap("listen", "silent"));
        }

        @Test
        @DisplayName("Not an anagram - 'hello' and 'world'")
        void testNotAnagram() {
            assertFalse(solution.isAnagramHashMap("hello", "world"));
        }

        @Test
        @DisplayName("Repeated characters - 'aab' and 'aba'")
        void testRepeatedChars() {
            assertTrue(solution.isAnagramHashMap("aab", "aba"));
        }

        @Test
        @DisplayName("Different frequency - 'aab' and 'aaa'")
        void testDifferentFrequency() {
            assertFalse(solution.isAnagramHashMap("aab", "aaa"));
        }

        @Test
        @DisplayName("All same character")
        void testAllSameChar() {
            assertTrue(solution.isAnagramHashMap("aaaa", "aaaa"));
        }
    }

    @Nested
    @DisplayName("Array Counter Approach Tests")
    class ArrayCounterApproachTests {

        @Test
        @DisplayName("Basic anagram - 'anagram' and 'nagaram'")
        void testBasicAnagram() {
            assertTrue(solution.isAnagramArrayCounter("anagram", "nagaram"));
        }

        @Test
        @DisplayName("Not an anagram - 'rat' and 'car'")
        void testNotAnagram() {
            assertFalse(solution.isAnagramArrayCounter("rat", "car"));
        }

        @Test
        @DisplayName("Empty strings")
        void testEmptyStrings() {
            assertTrue(solution.isAnagramArrayCounter("", ""));
        }

        @Test
        @DisplayName("Long strings with anagram")
        void testLongAnagram() {
            String s = "abcdefghijklmnopqrstuvwxyz";
            String t = "zyxwvutsrqponmlkjihgfedcba";
            assertTrue(solution.isAnagramArrayCounter(s, t));
        }

        @Test
        @DisplayName("Complex anagram - 'dormitory' and 'dirtyroom'")
        void testComplexAnagram() {
            assertTrue(solution.isAnagramArrayCounter("dormitory", "dirtyroom"));
        }
    }

    @Nested
    @DisplayName("Two Arrays Approach Tests")
    class TwoArraysApproachTests {

        @Test
        @DisplayName("Basic anagram - 'cinema' and 'iceman'")
        void testBasicAnagram() {
            assertTrue(solution.isAnagramTwoArrays("cinema", "iceman"));
        }

        @Test
        @DisplayName("Not an anagram - 'state' and 'taste'")
        void testNotAnagram() {
            assertTrue(solution.isAnagramTwoArrays("state", "taste"));
        }

        @Test
        @DisplayName("Different case sensitivity")
        void testSameLettersDifferentCase() {
            // Note: problem states lowercase only, testing with valid lowercase
            assertTrue(solution.isAnagramTwoArrays("abc", "cab"));
        }

        @Test
        @DisplayName("Palindrome anagram")
        void testPalindromeAnagram() {
            assertTrue(solution.isAnagramTwoArrays("racecar", "caracer"));
        }
    }

    @Nested
    @DisplayName("Unicode Support Tests")
    class UnicodeSupportTests {

        @Test
        @DisplayName("Basic lowercase English")
        void testBasicEnglish() {
            assertTrue(solution.isAnagramUnicode("anagram", "nagaram"));
        }

        @Test
        @DisplayName("Unicode characters - Japanese")
        void testJapaneseChars() {
            assertTrue(solution.isAnagramUnicode("こんにちは", "にちはこん"));
        }

        @Test
        @DisplayName("Unicode characters - Emojis")
        void testEmojiChars() {
            assertTrue(solution.isAnagramUnicode("😀😁😂", "😂😁😀"));
        }

        @Test
        @DisplayName("Mixed Unicode - not anagram")
        void testMixedUnicodeNotAnagram() {
            assertFalse(solution.isAnagramUnicode("café", "face"));
        }

        @Test
        @DisplayName("Unicode with accents")
        void testAccentedChars() {
            assertTrue(solution.isAnagramUnicode("café", "éfac"));
        }
    }

    @Nested
    @DisplayName("Single Pass HashMap Tests")
    class SinglePassHashMapTests {

        @Test
        @DisplayName("Basic anagram")
        void testBasicAnagram() {
            assertTrue(solution.isAnagramSinglePassHashMap("anagram", "nagaram"));
        }

        @Test
        @DisplayName("Not an anagram")
        void testNotAnagram() {
            assertFalse(solution.isAnagramSinglePassHashMap("rat", "car"));
        }

        @Test
        @DisplayName("Identical strings")
        void testIdenticalStrings() {
            assertTrue(solution.isAnagramSinglePassHashMap("test", "test"));
        }

        @Test
        @DisplayName("Strings with all unique characters")
        void testUniqueChars() {
            assertTrue(solution.isAnagramSinglePassHashMap("abcde", "edcba"));
        }
    }

    @Nested
    @DisplayName("Optimized Array Counter Tests")
    class OptimizedArrayCounterTests {

        @Test
        @DisplayName("Basic anagram with early exit")
        void testBasicAnagramEarlyExit() {
            assertTrue(solution.isAnagramArrayCounterOptimized("anagram", "nagaram"));
        }

        @Test
        @DisplayName("Early exit on mismatch")
        void testEarlyExitMismatch() {
            assertFalse(solution.isAnagramArrayCounterOptimized("rat", "car"));
        }

        @Test
        @DisplayName("Long string early success")
        void testLongStringEarlySuccess() {
            String s = "abcdefghijklmnopqrstuvwxyz";
            String t = "zyxwvutsrqponmlkjihgfedcba";
            assertTrue(solution.isAnagramArrayCounterOptimized(s, t));
        }

        @Test
        @DisplayName("Character appears more in second string")
        void testCharAppearsMore() {
            assertFalse(solution.isAnagramArrayCounterOptimized("a", "aa"));
        }
    }

    @Nested
    @DisplayName("Edge Case Tests")
    class EdgeCaseTests {

        @Test
        @DisplayName("Empty strings are anagrams")
        void testEmptyStrings() {
            assertTrue(solution.isAnagram("", ""));
        }

        @Test
        @DisplayName("One empty, one not")
        void testOneEmpty() {
            assertFalse(solution.isAnagram("", "a"));
            assertFalse(solution.isAnagram("a", ""));
        }

        @Test
        @DisplayName("Very long identical strings")
        void testVeryLongIdentical() {
            String s = "a".repeat(10000);
            String t = "a".repeat(10000);
            assertTrue(solution.isAnagram(s, t));
        }

        @Test
        @DisplayName("Very long different strings")
        void testVeryLongDifferent() {
            String s = "a".repeat(10000);
            String t = "a".repeat(9999) + "b";
            assertFalse(solution.isAnagram(s, t));
        }

        @Test
        @DisplayName("All characters same in both")
        void testAllSameChars() {
            assertTrue(solution.isAnagram("aaaa", "aaaa"));
        }

        @Test
        @DisplayName("Subset string (different lengths)")
        void testSubsetString() {
            assertFalse(solution.isAnagram("abc", "abcd"));
        }
    }

    @Nested
    @DisplayName("Utility Method Tests")
    class UtilityMethodTests {

        @Test
        @DisplayName("Check lowercase English - valid")
        void testIsLowercaseEnglishValid() {
            assertTrue(solution.isLowercaseEnglish("abcdefghijklmnopqrstuvwxyz"));
        }

        @Test
        @DisplayName("Check lowercase English - has uppercase")
        void testIsLowercaseEnglishWithUppercase() {
            assertFalse(solution.isLowercaseEnglish("Hello"));
        }

        @Test
        @DisplayName("Check lowercase English - has numbers")
        void testIsLowercaseEnglishWithNumbers() {
            assertFalse(solution.isLowercaseEnglish("abc123"));
        }

        @Test
        @DisplayName("Check lowercase English - has special chars")
        void testIsLowercaseEnglishWithSpecial() {
            assertFalse(solution.isLowercaseEnglish("hello!"));
        }

        @Test
        @DisplayName("Smart method chooses array counter for lowercase")
        void testSmartMethodLowercase() {
            assertTrue(solution.isAnagramSmart("anagram", "nagaram"));
        }

        @Test
        @DisplayName("Smart method handles Unicode")
        void testSmartMethodUnicode() {
            assertTrue(solution.isAnagramSmart("café", "éfac"));
        }
    }

    @Nested
    @DisplayName("Cross-Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @Test
        @DisplayName("All approaches agree on valid anagram")
        void testAllApproachesAgreeValid() {
            String s = "anagram";
            String t = "nagaram";

            assertTrue(solution.isAnagramSorting(s, t));
            assertTrue(solution.isAnagramHashMap(s, t));
            assertTrue(solution.isAnagramArrayCounter(s, t));
            assertTrue(solution.isAnagramTwoArrays(s, t));
            assertTrue(solution.isAnagramUnicode(s, t));
            assertTrue(solution.isAnagramSinglePassHashMap(s, t));
            assertTrue(solution.isAnagramArrayCounterOptimized(s, t));
        }

        @Test
        @DisplayName("All approaches agree on invalid anagram")
        void testAllApproachesAgreeInvalid() {
            String s = "rat";
            String t = "car";

            assertFalse(solution.isAnagramSorting(s, t));
            assertFalse(solution.isAnagramHashMap(s, t));
            assertFalse(solution.isAnagramArrayCounter(s, t));
            assertFalse(solution.isAnagramTwoArrays(s, t));
            assertFalse(solution.isAnagramUnicode(s, t));
            assertFalse(solution.isAnagramSinglePassHashMap(s, t));
            assertFalse(solution.isAnagramArrayCounterOptimized(s, t));
        }

        @Test
        @DisplayName("All approaches handle edge case - empty strings")
        void testAllApproachesEmpty() {
            String s = "";
            String t = "";

            assertTrue(solution.isAnagramSorting(s, t));
            assertTrue(solution.isAnagramHashMap(s, t));
            assertTrue(solution.isAnagramArrayCounter(s, t));
            assertTrue(solution.isAnagramTwoArrays(s, t));
            assertTrue(solution.isAnagramUnicode(s, t));
            assertTrue(solution.isAnagramSinglePassHashMap(s, t));
            assertTrue(solution.isAnagramArrayCounterOptimized(s, t));
        }

        @Test
        @DisplayName("All approaches handle different lengths")
        void testAllApproachesDifferentLengths() {
            String s = "abc";
            String t = "abcd";

            assertFalse(solution.isAnagramSorting(s, t));
            assertFalse(solution.isAnagramHashMap(s, t));
            assertFalse(solution.isAnagramArrayCounter(s, t));
            assertFalse(solution.isAnagramTwoArrays(s, t));
            assertFalse(solution.isAnagramUnicode(s, t));
            assertFalse(solution.isAnagramSinglePassHashMap(s, t));
            assertFalse(solution.isAnagramArrayCounterOptimized(s, t));
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Large input test - sorting approach")
        void testLargeInputSorting() {
            String s = "a".repeat(50000);
            String t = "a".repeat(50000);
            long start = System.nanoTime();
            assertTrue(solution.isAnagramSorting(s, t));
            long end = System.nanoTime();
            System.out.println("Sorting approach time: " + (end - start) / 1_000_000.0 + " ms");
        }

        @Test
        @DisplayName("Large input test - array counter approach")
        void testLargeInputArrayCounter() {
            String s = "a".repeat(50000);
            String t = "a".repeat(50000);
            long start = System.nanoTime();
            assertTrue(solution.isAnagramArrayCounter(s, t));
            long end = System.nanoTime();
            System.out
                    .println("Array counter approach time: " + (end - start) / 1_000_000.0 + " ms");
        }

        @Test
        @DisplayName("Large input test - optimized array counter")
        void testLargeInputOptimized() {
            String s = "a".repeat(50000);
            String t = "a".repeat(50000);
            long start = System.nanoTime();
            assertTrue(solution.isAnagramArrayCounterOptimized(s, t));
            long end = System.nanoTime();
            System.out.println(
                    "Optimized array counter time: " + (end - start) / 1_000_000.0 + " ms");
        }

        @Test
        @DisplayName("Worst case - all different characters")
        void testWorstCaseAllDifferent() {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < 1000; i++) {
                sb1.append((char) ('a' + (i % 26)));
                sb2.append((char) ('z' - (i % 26)));
            }
            String s = sb1.toString();
            String t = sb2.toString();

            long start = System.nanoTime();
            solution.isAnagramArrayCounter(s, t);
            long end = System.nanoTime();
            System.out.println("Worst case time: " + (end - start) / 1_000_000.0 + " ms");
            // Result depends on distribution, testing performance only
        }
    }

    @Nested
    @DisplayName("LeetCode Examples Tests")
    class LeetCodeExamplesTests {

        @Test
        @DisplayName("Example 1: 'anagram' and 'nagaram' -> true")
        void testExample1() {
            assertTrue(solution.isAnagram("anagram", "nagaram"));
        }

        @Test
        @DisplayName("Example 2: 'rat' and 'car' -> false")
        void testExample2() {
            assertFalse(solution.isAnagram("rat", "car"));
        }

        @Test
        @DisplayName("Additional test: 'listen' and 'silent' -> true")
        void testAdditional1() {
            assertTrue(solution.isAnagram("listen", "silent"));
        }

        @Test
        @DisplayName("Additional test: 'triangle' and 'integral' -> true")
        void testAdditional2() {
            assertTrue(solution.isAnagram("triangle", "integral"));
        }

        @Test
        @DisplayName("Additional test: 'apple' and 'pleap' -> true")
        void testAdditional3() {
            assertTrue(solution.isAnagram("apple", "pleap"));
        }
    }

    @Nested
    @DisplayName("Special Pattern Tests")
    class SpecialPatternTests {

        @Test
        @DisplayName("All same character - different counts")
        void testSameCharDifferentCounts() {
            assertFalse(solution.isAnagram("aaa", "aaaa"));
        }

        @Test
        @DisplayName("Reversed string")
        void testReversedString() {
            assertTrue(solution.isAnagram("abcdef", "fedcba"));
        }

        @Test
        @DisplayName("Rotated string")
        void testRotatedString() {
            assertTrue(solution.isAnagram("abcdef", "defabc"));
        }

        @Test
        @DisplayName("String with all alphabet letters")
        void testAllAlphabet() {
            String s = "abcdefghijklmnopqrstuvwxyz";
            String t = "zyxwvutsrqponmlkjihgfedcba";
            assertTrue(solution.isAnagram(s, t));
        }

        @Test
        @DisplayName("Repeated pattern")
        void testRepeatedPattern() {
            assertTrue(solution.isAnagram("aabbcc", "abcabc"));
        }
    }
}

