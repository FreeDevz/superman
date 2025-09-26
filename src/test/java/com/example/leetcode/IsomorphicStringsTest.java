package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.function.BiFunction;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Comprehensive test suite for LeetCode #205: Isomorphic Strings
 * 
 * Tests all 6 algorithmic approaches with extensive test cases including: - Basic functionality
 * tests - Edge cases - Performance tests - Cross-validation between approaches - Utility method
 * tests
 * 
 * @author Superman
 * @version 1.0
 */
@DisplayName("Isomorphic Strings Tests")
class IsomorphicStringsTest {

    // Test data providers
    static Stream<Object[]> basicTestCases() {
        return Stream.of(new Object[] {"egg", "add", true}, new Object[] {"foo", "bar", false},
                new Object[] {"paper", "title", true}, new Object[] {"ab", "aa", false},
                new Object[] {"ab", "ca", true}, new Object[] {"a", "a", true},
                new Object[] {"a", "b", true}, new Object[] {"", "", true});
    }

    static Stream<Object[]> edgeCaseTestCases() {
        return Stream.of(
                new Object[] {"abcdefghijklmnopqrstuvwxyz", "bcdefghijklmnopqrstuvwxyza", true},
                new Object[] {"abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz", true},
                new Object[] {"aabbcc", "ddeeff", true}, new Object[] {"aabbcc", "defdef", false},
                new Object[] {"abc", "def", true}, new Object[] {"abc", "ddd", false},
                new Object[] {"aaa", "bbb", true}, new Object[] {"aaa", "abc", false});
    }

    static Stream<Object[]> lengthMismatchTestCases() {
        return Stream.of(new Object[] {"abc", "ab", false}, new Object[] {"ab", "abc", false},
                new Object[] {"a", "", false}, new Object[] {"", "a", false},
                new Object[] {"hello", "world!", false});
    }

    static Stream<Object[]> specialCharacterTestCases() {
        return Stream.of(new Object[] {"!@#$%", "^&*()", true}, new Object[] {"123", "456", true},
                new Object[] {"a1b2", "c3d4", true}, new Object[] {"a1b2", "c3c4", false},
                new Object[] {" ", " ", true}, new Object[] {" ", "a", true});
    }

    // Approach test methods
    @Nested
    @DisplayName("HashMap Approach Tests")
    class HashMapApproachTests {

        @ParameterizedTest
        @MethodSource("com.example.leetcode.IsomorphicStringsTest#basicTestCases")
        @DisplayName("Basic functionality tests")
        void testBasicCases(String s, String t, boolean expected) {
            assertEquals(expected, IsomorphicStrings.isIsomorphicHashMap(s, t));
        }

        @ParameterizedTest
        @MethodSource("com.example.leetcode.IsomorphicStringsTest#edgeCaseTestCases")
        @DisplayName("Edge case tests")
        void testEdgeCases(String s, String t, boolean expected) {
            assertEquals(expected, IsomorphicStrings.isIsomorphicHashMap(s, t));
        }

        @ParameterizedTest
        @MethodSource("com.example.leetcode.IsomorphicStringsTest#lengthMismatchTestCases")
        @DisplayName("Length mismatch tests")
        void testLengthMismatch(String s, String t, boolean expected) {
            assertEquals(expected, IsomorphicStrings.isIsomorphicHashMap(s, t));
        }

        @ParameterizedTest
        @MethodSource("com.example.leetcode.IsomorphicStringsTest#specialCharacterTestCases")
        @DisplayName("Special character tests")
        void testSpecialCharacters(String s, String t, boolean expected) {
            assertEquals(expected, IsomorphicStrings.isIsomorphicHashMap(s, t));
        }

        @Test
        @DisplayName("Null input handling")
        void testNullInputs() {
            assertThrows(NullPointerException.class,
                    () -> IsomorphicStrings.isIsomorphicHashMap(null, "test"));
            assertThrows(NullPointerException.class,
                    () -> IsomorphicStrings.isIsomorphicHashMap("test", null));
            assertThrows(NullPointerException.class,
                    () -> IsomorphicStrings.isIsomorphicHashMap(null, null));
        }
    }

    @Nested
    @DisplayName("Array-based Approach Tests")
    class ArrayApproachTests {

        @ParameterizedTest
        @MethodSource("com.example.leetcode.IsomorphicStringsTest#basicTestCases")
        @DisplayName("Basic functionality tests")
        void testBasicCases(String s, String t, boolean expected) {
            assertEquals(expected, IsomorphicStrings.isIsomorphicArray(s, t));
        }

        @ParameterizedTest
        @MethodSource("com.example.leetcode.IsomorphicStringsTest#edgeCaseTestCases")
        @DisplayName("Edge case tests")
        void testEdgeCases(String s, String t, boolean expected) {
            assertEquals(expected, IsomorphicStrings.isIsomorphicArray(s, t));
        }

        @ParameterizedTest
        @MethodSource("com.example.leetcode.IsomorphicStringsTest#lengthMismatchTestCases")
        @DisplayName("Length mismatch tests")
        void testLengthMismatch(String s, String t, boolean expected) {
            assertEquals(expected, IsomorphicStrings.isIsomorphicArray(s, t));
        }

        @ParameterizedTest
        @MethodSource("com.example.leetcode.IsomorphicStringsTest#specialCharacterTestCases")
        @DisplayName("Special character tests")
        void testSpecialCharacters(String s, String t, boolean expected) {
            assertEquals(expected, IsomorphicStrings.isIsomorphicArray(s, t));
        }

        @Test
        @DisplayName("ASCII character range tests")
        void testASCIICharacters() {
            // Test all ASCII printable characters
            StringBuilder s = new StringBuilder();
            StringBuilder t = new StringBuilder();

            for (int i = 32; i <= 126; i++) {
                s.append((char) i);
                t.append((char) (i + 1 > 126 ? 32 : i + 1));
            }

            assertTrue(IsomorphicStrings.isIsomorphicArray(s.toString(), t.toString()));
        }
    }

    @Nested
    @DisplayName("Single HashMap Approach Tests")
    class SingleHashMapApproachTests {

        @ParameterizedTest
        @MethodSource("com.example.leetcode.IsomorphicStringsTest#basicTestCases")
        @DisplayName("Basic functionality tests")
        void testBasicCases(String s, String t, boolean expected) {
            assertEquals(expected, IsomorphicStrings.isIsomorphicSingleMap(s, t));
        }

        @ParameterizedTest
        @MethodSource("com.example.leetcode.IsomorphicStringsTest#edgeCaseTestCases")
        @DisplayName("Edge case tests")
        void testEdgeCases(String s, String t, boolean expected) {
            assertEquals(expected, IsomorphicStrings.isIsomorphicSingleMap(s, t));
        }

        @ParameterizedTest
        @MethodSource("com.example.leetcode.IsomorphicStringsTest#lengthMismatchTestCases")
        @DisplayName("Length mismatch tests")
        void testLengthMismatch(String s, String t, boolean expected) {
            assertEquals(expected, IsomorphicStrings.isIsomorphicSingleMap(s, t));
        }

        @ParameterizedTest
        @MethodSource("com.example.leetcode.IsomorphicStringsTest#specialCharacterTestCases")
        @DisplayName("Special character tests")
        void testSpecialCharacters(String s, String t, boolean expected) {
            assertEquals(expected, IsomorphicStrings.isIsomorphicSingleMap(s, t));
        }

        @Test
        @DisplayName("Bijection validation tests")
        void testBijectionValidation() {
            // Test cases that specifically test bijection property
            assertTrue(IsomorphicStrings.isIsomorphicSingleMap("abc", "def"));
            assertFalse(IsomorphicStrings.isIsomorphicSingleMap("ab", "aa"));
            assertTrue(IsomorphicStrings.isIsomorphicSingleMap("a", "b"));
            assertFalse(IsomorphicStrings.isIsomorphicSingleMap("ab", "cc"));
        }
    }

    @Nested
    @DisplayName("Position Mapping Approach Tests")
    class PositionMappingApproachTests {

        @ParameterizedTest
        @MethodSource("com.example.leetcode.IsomorphicStringsTest#basicTestCases")
        @DisplayName("Basic functionality tests")
        void testBasicCases(String s, String t, boolean expected) {
            assertEquals(expected, IsomorphicStrings.isIsomorphicPosition(s, t));
        }

        @ParameterizedTest
        @MethodSource("com.example.leetcode.IsomorphicStringsTest#edgeCaseTestCases")
        @DisplayName("Edge case tests")
        void testEdgeCases(String s, String t, boolean expected) {
            assertEquals(expected, IsomorphicStrings.isIsomorphicPosition(s, t));
        }

        @ParameterizedTest
        @MethodSource("com.example.leetcode.IsomorphicStringsTest#lengthMismatchTestCases")
        @DisplayName("Length mismatch tests")
        void testLengthMismatch(String s, String t, boolean expected) {
            assertEquals(expected, IsomorphicStrings.isIsomorphicPosition(s, t));
        }

        @ParameterizedTest
        @MethodSource("com.example.leetcode.IsomorphicStringsTest#specialCharacterTestCases")
        @DisplayName("Special character tests")
        void testSpecialCharacters(String s, String t, boolean expected) {
            assertEquals(expected, IsomorphicStrings.isIsomorphicPosition(s, t));
        }

        @Test
        @DisplayName("Position pattern tests")
        void testPositionPatterns() {
            // Test specific position patterns
            assertTrue(IsomorphicStrings.isIsomorphicPosition("abc", "def"));
            assertTrue(IsomorphicStrings.isIsomorphicPosition("aab", "ccd"));
            assertFalse(IsomorphicStrings.isIsomorphicPosition("aab", "cdc"));
            assertTrue(IsomorphicStrings.isIsomorphicPosition("abcdef", "ghijkl"));
        }
    }

    @Nested
    @DisplayName("String Transform Approach Tests")
    class StringTransformApproachTests {

        @ParameterizedTest
        @MethodSource("com.example.leetcode.IsomorphicStringsTest#basicTestCases")
        @DisplayName("Basic functionality tests")
        void testBasicCases(String s, String t, boolean expected) {
            assertEquals(expected, IsomorphicStrings.isIsomorphicTransform(s, t));
        }

        @ParameterizedTest
        @MethodSource("com.example.leetcode.IsomorphicStringsTest#edgeCaseTestCases")
        @DisplayName("Edge case tests")
        void testEdgeCases(String s, String t, boolean expected) {
            assertEquals(expected, IsomorphicStrings.isIsomorphicTransform(s, t));
        }

        @ParameterizedTest
        @MethodSource("com.example.leetcode.IsomorphicStringsTest#lengthMismatchTestCases")
        @DisplayName("Length mismatch tests")
        void testLengthMismatch(String s, String t, boolean expected) {
            assertEquals(expected, IsomorphicStrings.isIsomorphicTransform(s, t));
        }

        @ParameterizedTest
        @MethodSource("com.example.leetcode.IsomorphicStringsTest#specialCharacterTestCases")
        @DisplayName("Special character tests")
        void testSpecialCharacters(String s, String t, boolean expected) {
            assertEquals(expected, IsomorphicStrings.isIsomorphicTransform(s, t));
        }

        @Test
        @DisplayName("Transform pattern tests")
        void testTransformPatterns() {
            // Test transformation patterns
            assertEquals("012", IsomorphicStrings.findIsomorphicPattern("abc"));
            assertEquals("001", IsomorphicStrings.findIsomorphicPattern("aab"));
            assertEquals("010", IsomorphicStrings.findIsomorphicPattern("aba"));

            assertTrue(IsomorphicStrings.hasSamePattern("abc", "def"));
            assertTrue(IsomorphicStrings.hasSamePattern("aab", "ccd"));
            assertFalse(IsomorphicStrings.hasSamePattern("abc", "aab"));
        }
    }

    @Nested
    @DisplayName("Optimized Array Approach Tests")
    class OptimizedArrayApproachTests {

        @ParameterizedTest
        @MethodSource("com.example.leetcode.IsomorphicStringsTest#basicTestCases")
        @DisplayName("Basic functionality tests")
        void testBasicCases(String s, String t, boolean expected) {
            assertEquals(expected, IsomorphicStrings.isIsomorphicOptimized(s, t));
        }

        @ParameterizedTest
        @MethodSource("com.example.leetcode.IsomorphicStringsTest#edgeCaseTestCases")
        @DisplayName("Edge case tests")
        void testEdgeCases(String s, String t, boolean expected) {
            assertEquals(expected, IsomorphicStrings.isIsomorphicOptimized(s, t));
        }

        @ParameterizedTest
        @MethodSource("com.example.leetcode.IsomorphicStringsTest#lengthMismatchTestCases")
        @DisplayName("Length mismatch tests")
        void testLengthMismatch(String s, String t, boolean expected) {
            assertEquals(expected, IsomorphicStrings.isIsomorphicOptimized(s, t));
        }

        @ParameterizedTest
        @MethodSource("com.example.leetcode.IsomorphicStringsTest#specialCharacterTestCases")
        @DisplayName("Special character tests")
        void testSpecialCharacters(String s, String t, boolean expected) {
            assertEquals(expected, IsomorphicStrings.isIsomorphicOptimized(s, t));
        }

        @Test
        @DisplayName("Performance optimization tests")
        void testPerformanceOptimizations() {
            // Test with large strings to verify performance
            String largeS = "abcdefghijklmnopqrstuvwxyz".repeat(1000);
            String largeT = "bcdefghijklmnopqrstuvwxyza".repeat(1000);

            long startTime = System.nanoTime();
            boolean result = IsomorphicStrings.isIsomorphicOptimized(largeS, largeT);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            assertTrue(result);
            assertTrue(duration < 1_000_000_000L); // Should complete in less than 1 second
        }
    }

    @Nested
    @DisplayName("Cross-Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @SuppressWarnings("unchecked")
        private final BiFunction<String, String, Boolean>[] approaches = new BiFunction[] {
                (s, t) -> IsomorphicStrings.isIsomorphicHashMap((String) s, (String) t),
                (s, t) -> IsomorphicStrings.isIsomorphicArray((String) s, (String) t),
                (s, t) -> IsomorphicStrings.isIsomorphicSingleMap((String) s, (String) t),
                (s, t) -> IsomorphicStrings.isIsomorphicPosition((String) s, (String) t),
                (s, t) -> IsomorphicStrings.isIsomorphicTransform((String) s, (String) t),
                (s, t) -> IsomorphicStrings.isIsomorphicOptimized((String) s, (String) t)};

        @ParameterizedTest
        @MethodSource("com.example.leetcode.IsomorphicStringsTest#basicTestCases")
        @DisplayName("All approaches produce same results for basic cases")
        void testAllApproachesBasicCases(String s, String t, boolean expected) {
            for (BiFunction<String, String, Boolean> approach : approaches) {
                assertEquals(expected, approach.apply(s, t),
                        "Approach failed for s=\"" + s + "\", t=\"" + t + "\"");
            }
        }

        @ParameterizedTest
        @MethodSource("com.example.leetcode.IsomorphicStringsTest#edgeCaseTestCases")
        @DisplayName("All approaches produce same results for edge cases")
        void testAllApproachesEdgeCases(String s, String t, boolean expected) {
            for (BiFunction<String, String, Boolean> approach : approaches) {
                assertEquals(expected, approach.apply(s, t),
                        "Approach failed for s=\"" + s + "\", t=\"" + t + "\"");
            }
        }

        @Test
        @DisplayName("Random test case consistency")
        void testRandomCaseConsistency() {
            String[] testStrings = {"abcdefghijklmnopqrstuvwxyz", "bcdefghijklmnopqrstuvwxyza",
                    "zyxwvutsrqponmlkjihgfedcba", "aabbccddeeffgghhiijjkkllmm",
                    "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"};

            for (String s : testStrings) {
                for (String t : testStrings) {
                    boolean[] results = new boolean[approaches.length];
                    for (int i = 0; i < approaches.length; i++) {
                        results[i] = approaches[i].apply(s, t);
                    }

                    // All approaches should give the same result
                    for (int i = 1; i < results.length; i++) {
                        assertEquals(results[0], results[i],
                                "Inconsistent results for s=\"" + s + "\", t=\"" + t + "\"");
                    }
                }
            }
        }
    }

    @Nested
    @DisplayName("Utility Method Tests")
    class UtilityMethodTests {

        @Test
        @DisplayName("Unique character count tests")
        void testUniqueCharCount() {
            assertEquals(3, IsomorphicStrings.getUniqueCharCount("abc"));
            assertEquals(2, IsomorphicStrings.getUniqueCharCount("aab"));
            assertEquals(1, IsomorphicStrings.getUniqueCharCount("aaa"));
            assertEquals(0, IsomorphicStrings.getUniqueCharCount(""));
            assertEquals(26, IsomorphicStrings.getUniqueCharCount("abcdefghijklmnopqrstuvwxyz"));
        }

        @Test
        @DisplayName("Bijection validation tests")
        void testBijectionValidation() {
            java.util.Map<Character, Character> bijection = new java.util.HashMap<>();
            bijection.put('a', 'x');
            bijection.put('b', 'y');
            bijection.put('c', 'z');
            assertTrue(IsomorphicStrings.isBijection(bijection));

            java.util.Map<Character, Character> notBijection = new java.util.HashMap<>();
            notBijection.put('a', 'x');
            notBijection.put('b', 'x'); // Two keys map to same value
            assertFalse(IsomorphicStrings.isBijection(notBijection));
        }

        @Test
        @DisplayName("Isomorphic pattern tests")
        void testIsomorphicPattern() {
            assertEquals("012", IsomorphicStrings.findIsomorphicPattern("abc"));
            assertEquals("001", IsomorphicStrings.findIsomorphicPattern("aab"));
            assertEquals("010", IsomorphicStrings.findIsomorphicPattern("aba"));
            assertEquals("", IsomorphicStrings.findIsomorphicPattern(""));
        }

        @Test
        @DisplayName("Same pattern tests")
        void testSamePattern() {
            assertTrue(IsomorphicStrings.hasSamePattern("abc", "def"));
            assertTrue(IsomorphicStrings.hasSamePattern("aab", "ccd"));
            assertFalse(IsomorphicStrings.hasSamePattern("abc", "aab"));
            assertTrue(IsomorphicStrings.hasSamePattern("", ""));
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Large string performance test")
        void testLargeStringPerformance() {
            String largeS = "abcdefghijklmnopqrstuvwxyz".repeat(1000);
            String largeT = "bcdefghijklmnopqrstuvwxyza".repeat(1000);

            @SuppressWarnings("unchecked")
            BiFunction<String, String, Boolean>[] approaches = new BiFunction[] {
                    (s, t) -> IsomorphicStrings.isIsomorphicHashMap((String) s, (String) t),
                    (s, t) -> IsomorphicStrings.isIsomorphicArray((String) s, (String) t),
                    (s, t) -> IsomorphicStrings.isIsomorphicSingleMap((String) s, (String) t),
                    (s, t) -> IsomorphicStrings.isIsomorphicPosition((String) s, (String) t),
                    (s, t) -> IsomorphicStrings.isIsomorphicTransform((String) s, (String) t),
                    (s, t) -> IsomorphicStrings.isIsomorphicOptimized((String) s, (String) t)};

            String[] approachNames =
                    {"HashMap", "Array", "SingleMap", "Position", "Transform", "Optimized"};

            for (int i = 0; i < approaches.length; i++) {
                long startTime = System.nanoTime();
                boolean result = approaches[i].apply(largeS, largeT);
                long endTime = System.nanoTime();
                long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds

                assertTrue(result);
                assertTrue(duration < 1000,
                        approachNames[i] + " took too long: " + duration + "ms");
            }
        }

        @Test
        @DisplayName("Memory efficiency test")
        void testMemoryEfficiency() {
            // Test with maximum constraint strings
            StringBuilder s = new StringBuilder();
            StringBuilder t = new StringBuilder();

            for (int i = 0; i < 50000; i++) {
                s.append((char) ('a' + (i % 26)));
                t.append((char) ('a' + ((i + 1) % 26)));
            }

            // All approaches should handle large strings efficiently
            assertTrue(IsomorphicStrings.isIsomorphicOptimized(s.toString(), t.toString()));
            assertTrue(IsomorphicStrings.isIsomorphicArray(s.toString(), t.toString()));
            assertTrue(IsomorphicStrings.isIsomorphicHashMap(s.toString(), t.toString()));
        }
    }

    @Nested
    @DisplayName("Edge Case Tests")
    class EdgeCaseTests {

        @Test
        @DisplayName("Empty string tests")
        void testEmptyStrings() {
            assertTrue(IsomorphicStrings.isIsomorphicHashMap("", ""));
            assertTrue(IsomorphicStrings.isIsomorphicArray("", ""));
            assertTrue(IsomorphicStrings.isIsomorphicSingleMap("", ""));
            assertTrue(IsomorphicStrings.isIsomorphicPosition("", ""));
            assertTrue(IsomorphicStrings.isIsomorphicTransform("", ""));
            assertTrue(IsomorphicStrings.isIsomorphicOptimized("", ""));
        }

        @Test
        @DisplayName("Single character tests")
        void testSingleCharacters() {
            assertTrue(IsomorphicStrings.isIsomorphicHashMap("a", "a"));
            assertTrue(IsomorphicStrings.isIsomorphicHashMap("a", "b"));
            assertTrue(IsomorphicStrings.isIsomorphicHashMap("a", "z"));
            assertTrue(IsomorphicStrings.isIsomorphicHashMap("a", "1"));
            assertTrue(IsomorphicStrings.isIsomorphicHashMap("a", "!"));
        }

        @Test
        @DisplayName("All same characters tests")
        void testAllSameCharacters() {
            assertTrue(IsomorphicStrings.isIsomorphicHashMap("aaa", "bbb"));
            assertTrue(IsomorphicStrings.isIsomorphicHashMap("aaa", "ccc"));
            assertFalse(IsomorphicStrings.isIsomorphicHashMap("aaa", "abc"));
            assertFalse(IsomorphicStrings.isIsomorphicHashMap("aaa", "aab"));
        }

        @Test
        @DisplayName("Maximum constraint tests")
        void testMaximumConstraints() {
            // Test with maximum length strings (50,000 characters)
            StringBuilder s = new StringBuilder();
            StringBuilder t = new StringBuilder();

            for (int i = 0; i < 50000; i++) {
                s.append((char) ('a' + (i % 26)));
                t.append((char) ('a' + ((i + 1) % 26)));
            }

            assertTrue(IsomorphicStrings.isIsomorphicOptimized(s.toString(), t.toString()));
        }

        @Test
        @DisplayName("Special ASCII character tests")
        void testSpecialASCIICharacters() {
            // Test with various ASCII characters
            assertTrue(IsomorphicStrings.isIsomorphicHashMap("!@#$%", "^&*()"));
            assertTrue(IsomorphicStrings.isIsomorphicHashMap("123", "456"));
            assertTrue(IsomorphicStrings.isIsomorphicHashMap("a1b2", "c3d4"));
            assertFalse(IsomorphicStrings.isIsomorphicHashMap("a1b2", "c3c4"));
        }
    }

    @Nested
    @DisplayName("Parameterized Tests")
    class ParameterizedTests {

        @ParameterizedTest
        @CsvSource({"egg, add, true", "foo, bar, false", "paper, title, true", "ab, aa, false",
                "ab, ca, true", "a, a, true", "a, b, true", "'', '', true"})
        @DisplayName("CSV parameterized tests")
        void testCSVParameterized(String s, String t, boolean expected) {
            assertEquals(expected, IsomorphicStrings.isIsomorphicHashMap(s, t));
            assertEquals(expected, IsomorphicStrings.isIsomorphicArray(s, t));
            assertEquals(expected, IsomorphicStrings.isIsomorphicSingleMap(s, t));
            assertEquals(expected, IsomorphicStrings.isIsomorphicPosition(s, t));
            assertEquals(expected, IsomorphicStrings.isIsomorphicTransform(s, t));
            assertEquals(expected, IsomorphicStrings.isIsomorphicOptimized(s, t));
        }

        @ParameterizedTest
        @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
        @DisplayName("Value source parameterized tests")
        void testValueSourceParameterized(String s) {
            // Test with identity mapping
            assertTrue(IsomorphicStrings.isIsomorphicHashMap(s, s));

            // Test with shifted mapping
            StringBuilder shifted = new StringBuilder();
            for (char c : s.toCharArray()) {
                shifted.append((char) (c + 1));
            }
            assertTrue(IsomorphicStrings.isIsomorphicHashMap(s, shifted.toString()));
        }
    }
}
