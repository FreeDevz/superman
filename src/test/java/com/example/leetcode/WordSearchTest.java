package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Comprehensive test suite for WordSearch (LeetCode #79)
 * 
 * Test Categories: 1. LeetCode Examples - Official test cases 2. Edge Cases - Boundary conditions
 * and special cases 3. Directional Search - Tests for all movement directions 4. Backtracking -
 * Complex paths requiring backtracking 5. Performance - Large boards and long words 6.
 * Cross-Approach Comparison - Verify all approaches work 7. Utility Methods - Path finding and
 * statistics 8. Pattern Tests - Specific search patterns
 */
class WordSearchTest {

    private WordSearch wordSearch;

    @BeforeEach
    void setUp() {
        wordSearch = new WordSearch();
    }

    // ========================================
    // LEETCODE EXAMPLES TESTS
    // ========================================

    @Nested
    @DisplayName("LeetCode Example Tests")
    class LeetCodeExamplesTests {

        @Test
        @DisplayName("Example 1: ABCCED found in board")
        void testExample1() {
            char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
            String word = "ABCCED";
            assertTrue(wordSearch.exist(board, word));
        }

        @Test
        @DisplayName("Example 2: SEE found in board")
        void testExample2() {
            char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
            String word = "SEE";
            assertTrue(wordSearch.exist(board, word));
        }

        @Test
        @DisplayName("Example 3: ABCB not found (cannot reuse cells)")
        void testExample3() {
            char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
            String word = "ABCB";
            assertFalse(wordSearch.exist(board, word));
        }

        @Test
        @DisplayName("Example 4: Simple 3x3 board with word found")
        void testExample4() {
            char[][] board = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
            String word = "AAB";
            assertTrue(wordSearch.exist(board, word));
        }

        @Test
        @DisplayName("Example 5: Word forms a path")
        void testExample5() {
            char[][] board = {{'A', 'B'}, {'C', 'D'}};
            String word = "ABDC";
            assertTrue(wordSearch.exist(board, word));
        }
    }

    // ========================================
    // EDGE CASES TESTS
    // ========================================

    @Nested
    @DisplayName("Edge Cases Tests")
    class EdgeCasesTests {

        @Test
        @DisplayName("Single cell board with matching character")
        void testSingleCellMatch() {
            char[][] board = {{'A'}};
            String word = "A";
            assertTrue(wordSearch.exist(board, word));
        }

        @Test
        @DisplayName("Single cell board with non-matching character")
        void testSingleCellNoMatch() {
            char[][] board = {{'A'}};
            String word = "B";
            assertFalse(wordSearch.exist(board, word));
        }

        @Test
        @DisplayName("Word longer than board cells")
        void testWordLongerThanBoard() {
            char[][] board = {{'A', 'B'}, {'C', 'D'}};
            String word = "ABCDEFGH";
            assertFalse(wordSearch.exist(board, word));
        }

        @Test
        @DisplayName("Empty word should return false")
        void testEmptyWord() {
            char[][] board = {{'A', 'B'}, {'C', 'D'}};
            String word = "";
            assertFalse(wordSearch.exist(board, word));
        }

        @Test
        @DisplayName("Null board should return false")
        void testNullBoard() {
            assertFalse(wordSearch.exist(null, "ABC"));
        }

        @Test
        @DisplayName("Null word should return false")
        void testNullWord() {
            char[][] board = {{'A', 'B'}, {'C', 'D'}};
            assertFalse(wordSearch.exist(board, null));
        }

        @Test
        @DisplayName("Single row board")
        void testSingleRow() {
            char[][] board = {{'A', 'B', 'C', 'D', 'E'}};
            String word = "ACE";
            assertFalse(wordSearch.exist(board, word));
            assertTrue(wordSearch.exist(board, "ABC"));
        }

        @Test
        @DisplayName("Single column board")
        void testSingleColumn() {
            char[][] board = {{'A'}, {'B'}, {'C'}, {'D'}};
            String word = "ABCD";
            assertTrue(wordSearch.exist(board, word));
        }

        @Test
        @DisplayName("Word is entire board")
        void testWordIsEntireBoard() {
            char[][] board = {{'A', 'B'}, {'D', 'C'}};
            String word = "ABCD";
            assertTrue(wordSearch.exist(board, word));
        }

        @Test
        @DisplayName("All same characters")
        void testAllSameCharacters() {
            char[][] board = {{'A', 'A', 'A'}, {'A', 'A', 'A'}, {'A', 'A', 'A'}};
            String word = "AAAA";
            assertTrue(wordSearch.exist(board, word));
        }
    }

    // ========================================
    // DIRECTIONAL SEARCH TESTS
    // ========================================

    @Nested
    @DisplayName("Directional Search Tests")
    class DirectionalSearchTests {

        @Test
        @DisplayName("Horizontal search - left to right")
        void testHorizontalLeftToRight() {
            char[][] board = {{'A', 'B', 'C', 'D'}, {'E', 'F', 'G', 'H'}};
            String word = "ABCD";
            assertTrue(wordSearch.exist(board, word));
        }

        @Test
        @DisplayName("Horizontal search - right to left")
        void testHorizontalRightToLeft() {
            char[][] board = {{'A', 'B', 'C', 'D'}, {'E', 'F', 'G', 'H'}};
            String word = "DCBA";
            assertTrue(wordSearch.exist(board, word));
        }

        @Test
        @DisplayName("Vertical search - top to bottom")
        void testVerticalTopToBottom() {
            char[][] board = {{'A', 'E'}, {'B', 'F'}, {'C', 'G'}, {'D', 'H'}};
            String word = "ABCD";
            assertTrue(wordSearch.exist(board, word));
        }

        @Test
        @DisplayName("Vertical search - bottom to top")
        void testVerticalBottomToTop() {
            char[][] board = {{'A', 'E'}, {'B', 'F'}, {'C', 'G'}, {'D', 'H'}};
            String word = "DCBA";
            assertTrue(wordSearch.exist(board, word));
        }

        @Test
        @DisplayName("Diagonal-like zigzag path")
        void testZigzagPath() {
            char[][] board = {{'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}};
            String word = "ABEF";
            assertTrue(wordSearch.exist(board, word));
        }

        @Test
        @DisplayName("Spiral path")
        void testSpiralPath() {
            char[][] board = {{'A', 'B', 'C'}, {'H', 'I', 'D'}, {'G', 'F', 'E'}};
            String word = "ABCDEFGHI";
            assertTrue(wordSearch.exist(board, word));
        }

        @Test
        @DisplayName("Snake pattern")
        void testSnakePattern() {
            char[][] board = {{'A', 'B', 'C'}, {'F', 'E', 'D'}, {'G', 'H', 'I'}};
            String word = "ABCDEFGHI";
            assertTrue(wordSearch.exist(board, word));
        }
    }

    // ========================================
    // BACKTRACKING TESTS
    // ========================================

    @Nested
    @DisplayName("Backtracking Required Tests")
    class BacktrackingTests {

        @Test
        @DisplayName("Simple backtracking case")
        void testSimpleBacktracking() {
            char[][] board = {{'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}};
            String word = "ABEH";
            assertTrue(wordSearch.exist(board, word));
        }

        @Test
        @DisplayName("Complex backtracking with dead ends")
        void testComplexBacktracking() {
            char[][] board = {{'A', 'A', 'A', 'A'}, {'B', 'C', 'D', 'E'}, {'A', 'A', 'A', 'F'},
                    {'A', 'A', 'A', 'A'}};
            String word = "BCDEF";
            assertTrue(wordSearch.exist(board, word));
        }

        @Test
        @DisplayName("Backtracking with multiple same characters")
        void testBacktrackingMultipleSame() {
            char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
            String word = "ABCESEEEFS";
            assertTrue(wordSearch.exist(board, word));
        }

        @Test
        @DisplayName("False path that requires backtracking")
        void testFalsePathBacktracking() {
            char[][] board = {{'A', 'B', 'C'}, {'D', 'C', 'E'}, {'F', 'G', 'H'}};
            String word = "ABCE";
            assertTrue(wordSearch.exist(board, word));
        }

        @Test
        @DisplayName("Multiple potential starting points")
        void testMultipleStartingPoints() {
            char[][] board = {{'A', 'B', 'A'}, {'C', 'D', 'E'}, {'A', 'F', 'G'}};
            String word = "ABDE";
            assertTrue(wordSearch.exist(board, word));
        }

        @Test
        @DisplayName("T-shaped path requiring backtracking")
        void testTShapedPath() {
            char[][] board = {{'B', 'C', 'D'}, {'E', 'F', 'G'}, {'X', 'X', 'X'}};
            String word = "BCDEFG";
            assertFalse(wordSearch.exist(board, word)); // This path doesn't exist - testing
                                                        // backtracking
        }
    }

    // ========================================
    // PARAMETERIZED TESTS
    // ========================================

    @Nested
    @DisplayName("Parameterized Tests")
    class ParameterizedTests {

        static Stream<Arguments> provideTestCases() {
            return Stream.of(
                    // Basic cases
                    Arguments.of(new char[][] {{'A'}}, "A", true, "Single character match"),
                    Arguments.of(new char[][] {{'A', 'B'}, {'C', 'D'}}, "AB", true,
                            "Simple horizontal word"),
                    Arguments.of(new char[][] {{'A', 'B'}, {'C', 'D'}}, "AC", true,
                            "Simple vertical word"),
                    // Complex patterns
                    Arguments.of(
                            new char[][] {{'F', 'I', 'N', 'X', 'X', 'X', 'X'},
                                    {'X', 'X', 'L', 'X', 'X', 'X', 'X'},
                                    {'X', 'X', 'A', 'X', 'X', 'X', 'X'},
                                    {'X', 'X', 'N', 'X', 'X', 'X', 'X'},
                                    {'X', 'X', 'D', 'X', 'X', 'X', 'X'},
                                    {'X', 'X', 'X', 'X', 'X', 'X', 'X'},
                                    {'X', 'X', 'X', 'X', 'X', 'X', 'X'}},
                            "FINLAND", true, "Complex path in large board"),
                    // Should not exist
                    Arguments.of(new char[][] {{'A', 'B'}, {'C', 'D'}}, "XY", false,
                            "Characters not in board"),
                    Arguments.of(new char[][] {{'A', 'B'}, {'C', 'D'}}, "BA", true,
                            "Reverse horizontal"));
        }

        @ParameterizedTest(name = "{3}")
        @MethodSource("provideTestCases")
        @DisplayName("Various board and word combinations")
        void testVariousCases(char[][] board, String word, boolean expected, String description) {
            assertEquals(expected, wordSearch.exist(board, word), description);
        }
    }

    // ========================================
    // PERFORMANCE TESTS
    // ========================================

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Maximum size board (6x6)")
        void testMaximumSizeBoard() {
            char[][] board = {{'A', 'B', 'C', 'D', 'E', 'F'}, {'G', 'H', 'I', 'J', 'K', 'L'},
                    {'M', 'N', 'O', 'P', 'Q', 'R'}, {'S', 'T', 'U', 'V', 'W', 'X'},
                    {'Y', 'Z', 'A', 'B', 'C', 'D'}, {'E', 'F', 'G', 'H', 'I', 'J'}};
            String word = "ABCDEF";
            assertTrue(wordSearch.exist(board, word));
        }

        @Test
        @DisplayName("Maximum length word (15 characters)")
        void testMaximumLengthWord() {
            char[][] board = {{'A', 'B', 'C', 'D', 'E', 'F'}, {'L', 'K', 'J', 'I', 'H', 'G'},
                    {'M', 'N', 'O', 'P', 'Q', 'R'}, {'X', 'W', 'V', 'U', 'T', 'S'},
                    {'Y', 'Z', 'A', 'B', 'C', 'D'}, {'J', 'I', 'H', 'G', 'F', 'E'}};
            String word = "ABCDEFGHIJKLMNO";
            assertTrue(wordSearch.exist(board, word));
        }

        @Test
        @DisplayName("Worst case - word not found after exploring many paths")
        void testWorstCaseNotFound() {
            char[][] board = {{'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A'},
                    {'A', 'A', 'A', 'B'}};
            String word = "AAAAAAAAAAAAAAAAB";
            assertFalse(wordSearch.exist(board, word));
        }

        @Test
        @DisplayName("Performance with repeated characters")
        void testPerformanceRepeatedChars() {
            char[][] board = {{'A', 'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A', 'A'},
                    {'A', 'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A', 'A'},
                    {'A', 'A', 'A', 'A', 'B'}};
            String word = "AAAAAAAAAAB";

            long startTime = System.nanoTime();
            boolean result = wordSearch.exist(board, word);
            long endTime = System.nanoTime();

            assertTrue(result);
            assertTrue((endTime - startTime) < 100_000_000, "Should complete within 100ms");
        }
    }

    // ========================================
    // CROSS-APPROACH COMPARISON TESTS
    // ========================================

    @Nested
    @DisplayName("Cross-Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @Test
        @DisplayName("All approaches produce same result - word found")
        void testAllApproachesFoundWord() {
            char[][] board1 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
            char[][] board2 = copyBoard(board1);
            char[][] board3 = copyBoard(board1);
            char[][] board4 = copyBoard(board1);

            String word = "ABCCED";

            boolean result1 = wordSearch.exist(board1, word);
            boolean result2 = wordSearch.existWithVisitedArray(board2, word);
            boolean result3 = wordSearch.existOptimized(board3, word);
            boolean result4 = wordSearch.existIterative(board4, word);

            assertTrue(result1, "Approach 1 failed");
            assertTrue(result2, "Approach 2 failed");
            assertTrue(result3, "Approach 3 failed");
            assertTrue(result4, "Approach 4 failed");

            assertEquals(result1, result2);
            assertEquals(result2, result3);
            assertEquals(result3, result4);
        }

        @Test
        @DisplayName("All approaches produce same result - word not found")
        void testAllApproachesWordNotFound() {
            char[][] board1 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
            char[][] board2 = copyBoard(board1);
            char[][] board3 = copyBoard(board1);
            char[][] board4 = copyBoard(board1);

            String word = "ABCB";

            boolean result1 = wordSearch.exist(board1, word);
            boolean result2 = wordSearch.existWithVisitedArray(board2, word);
            boolean result3 = wordSearch.existOptimized(board3, word);
            boolean result4 = wordSearch.existIterative(board4, word);

            assertFalse(result1, "Approach 1 incorrect");
            assertFalse(result2, "Approach 2 incorrect");
            assertFalse(result3, "Approach 3 incorrect");
            assertFalse(result4, "Approach 4 incorrect");
        }

        @Test
        @DisplayName("Compare all approaches on complex board")
        void testAllApproachesComplexBoard() {
            char[][] board1 = {{'F', 'Y', 'C', 'E', 'N', 'R'}, {'K', 'L', 'N', 'F', 'I', 'N'},
                    {'A', 'A', 'A', 'R', 'A', 'H'}, {'N', 'D', 'K', 'L', 'P', 'N'},
                    {'A', 'L', 'A', 'N', 'S', 'A'}, {'O', 'O', 'G', 'O', 'T', 'P'}};
            char[][] board2 = copyBoard(board1);
            char[][] board3 = copyBoard(board1);
            char[][] board4 = copyBoard(board1);

            String word = "FINLAND";

            boolean result1 = wordSearch.exist(board1, word);
            boolean result2 = wordSearch.existWithVisitedArray(board2, word);
            boolean result3 = wordSearch.existOptimized(board3, word);
            boolean result4 = wordSearch.existIterative(board4, word);

            assertEquals(result1, result2);
            assertEquals(result2, result3);
            assertEquals(result3, result4);
        }

        private char[][] copyBoard(char[][] original) {
            char[][] copy = new char[original.length][];
            for (int i = 0; i < original.length; i++) {
                copy[i] = original[i].clone();
            }
            return copy;
        }
    }

    // ========================================
    // UTILITY METHODS TESTS
    // ========================================

    @Nested
    @DisplayName("Utility Methods Tests")
    class UtilityMethodsTests {

        @Test
        @DisplayName("Find path returns valid path for existing word")
        void testFindPathExists() {
            char[][] board = {{'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}};
            String word = "ABC";
            String path = wordSearch.findPath(board, word);

            assertNotNull(path);
            assertFalse(path.equals("Word not found"));
            assertTrue(path.contains("A"));
            assertTrue(path.contains("B"));
            assertTrue(path.contains("C"));
        }

        @Test
        @DisplayName("Find path returns 'Word not found' for non-existing word")
        void testFindPathNotExists() {
            char[][] board = {{'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}};
            String word = "XYZ";
            String path = wordSearch.findPath(board, word);

            assertEquals("Word not found", path);
        }

        @Test
        @DisplayName("Count all paths finds single path")
        void testCountAllPathsSingle() {
            char[][] board = {{'A', 'B', 'C'}, {'X', 'X', 'X'}, {'X', 'X', 'X'}};
            String word = "ABC";
            int count = wordSearch.countAllPaths(board, word);

            assertTrue(count >= 1, "Should find at least 1 path");
        }

        @Test
        @DisplayName("Count all paths finds multiple paths")
        void testCountAllPathsMultiple() {
            char[][] board = {{'A', 'B'}, {'B', 'A'}};
            String word = "AB";
            int count = wordSearch.countAllPaths(board, word);

            assertTrue(count >= 2, "Should find at least 2 paths");
        }

        @Test
        @DisplayName("Find words from dictionary")
        void testFindWords() {
            char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
            String[] dictionary = {"ABCCED", "SEE", "ABCB", "AS", "FCS"};

            List<String> found = wordSearch.findWords(board, dictionary);

            assertTrue(found.contains("ABCCED"));
            assertTrue(found.contains("SEE"));
            assertTrue(found.contains("AS"));
            assertFalse(found.contains("ABCB"));
        }

        @Test
        @DisplayName("Get search statistics")
        void testGetSearchStats() {
            char[][] board = {{'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}};
            String word = "ABC";

            WordSearch.SearchStats stats = wordSearch.getSearchStats(board, word);

            assertNotNull(stats);
            assertTrue(stats.found);
            assertTrue(stats.cellsExplored > 0);
            assertTrue(stats.maxDepth >= 0);
            assertTrue(stats.timeNanos > 0);
        }

        @Test
        @DisplayName("Search statistics for word not found")
        void testSearchStatsNotFound() {
            char[][] board = {{'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}};
            String word = "XYZ";

            WordSearch.SearchStats stats = wordSearch.getSearchStats(board, word);

            assertNotNull(stats);
            assertFalse(stats.found);
            assertTrue(stats.cellsExplored > 0);
        }
    }

    // ========================================
    // PATTERN TESTS
    // ========================================

    @Nested
    @DisplayName("Special Pattern Tests")
    class PatternTests {

        @Test
        @DisplayName("L-shaped pattern")
        void testLShapedPattern() {
            char[][] board = {{'A', 'X', 'X'}, {'B', 'X', 'X'}, {'C', 'D', 'E'}};
            String word = "ABCDE";
            assertTrue(wordSearch.exist(board, word));
        }

        @Test
        @DisplayName("U-shaped pattern")
        void testUShapedPattern() {
            char[][] board = {{'A', 'X', 'E'}, {'B', 'X', 'D'}, {'C', 'D', 'C'}};
            String word = "ABCD";
            assertTrue(wordSearch.exist(board, word));
        }

        @Test
        @DisplayName("Cross pattern center")
        void testCrossPattern() {
            char[][] board = {{'X', 'A', 'X'}, {'B', 'C', 'D'}, {'X', 'X', 'X'}};
            String word = "BCD";
            assertTrue(wordSearch.exist(board, word));
        }

        @Test
        @DisplayName("Border traversal")
        void testBorderTraversal() {
            char[][] board = {{'A', 'B', 'C', 'D'}, {'L', 'X', 'X', 'E'}, {'K', 'X', 'X', 'F'},
                    {'J', 'I', 'H', 'G'}};
            String word = "ABCDEFGHIJKL";
            assertTrue(wordSearch.exist(board, word));
        }

        @Test
        @DisplayName("Word with alternating directions")
        void testAlternatingDirections() {
            char[][] board = {{'A', 'B', 'X'}, {'D', 'C', 'X'}, {'E', 'F', 'X'}};
            String word = "ABCDEF";
            assertTrue(wordSearch.exist(board, word));
        }

        @Test
        @DisplayName("Palindrome word in board")
        void testPalindromeWord() {
            char[][] board = {{'R', 'A', 'C'}, {'X', 'C', 'E'}, {'X', 'A', 'R'}};
            String word = "RACECAR";
            assertTrue(wordSearch.exist(board, word));
        }
    }

    // ========================================
    // CHARACTER TYPE TESTS
    // ========================================

    @Nested
    @DisplayName("Character Type Tests")
    class CharacterTypeTests {

        @Test
        @DisplayName("Uppercase letters only")
        void testUppercaseOnly() {
            char[][] board = {{'H', 'E', 'L', 'L', 'O'}};
            String word = "HELLO";
            assertTrue(wordSearch.exist(board, word));
        }

        @Test
        @DisplayName("Lowercase letters only")
        void testLowercaseOnly() {
            char[][] board = {{'h', 'e', 'l', 'l', 'o'}};
            String word = "hello";
            assertTrue(wordSearch.exist(board, word));
        }

        @Test
        @DisplayName("Mixed case - exact match required")
        void testMixedCase() {
            char[][] board = {{'H', 'e', 'L', 'l', 'O'}};
            String word = "HeLlO";
            assertTrue(wordSearch.exist(board, word));

            // Different case should not match
            assertFalse(wordSearch.exist(board, "HELLO"));
        }

        @Test
        @DisplayName("Case sensitivity test")
        void testCaseSensitivity() {
            char[][] board = {{'a', 'B', 'c'}, {'D', 'e', 'F'}};
            assertTrue(wordSearch.exist(board, "aBc"));
            assertFalse(wordSearch.exist(board, "ABC"));
            assertFalse(wordSearch.exist(board, "abc"));
        }
    }

    // ========================================
    // STRESS TESTS
    // ========================================

    @Nested
    @DisplayName("Stress Tests")
    class StressTests {

        @Test
        @DisplayName("Dense board with many matching prefixes")
        void testDenseBoardManyPrefixes() {
            char[][] board = {{'A', 'A', 'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A', 'A', 'A'},
                    {'A', 'A', 'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A', 'A', 'A'},
                    {'A', 'A', 'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A', 'A', 'B'}};
            String word = "AAAAAAAAAAAAAAB";
            assertTrue(wordSearch.exist(board, word));
        }

        @Test
        @DisplayName("Sparse matches requiring extensive search")
        void testSparseMatches() {
            char[][] board = {{'X', 'X', 'X', 'X', 'X', 'A'}, {'X', 'X', 'X', 'X', 'X', 'B'},
                    {'X', 'X', 'X', 'X', 'X', 'C'}, {'X', 'X', 'X', 'X', 'X', 'X'},
                    {'X', 'X', 'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X', 'X', 'X'}};
            String word = "ABC";
            assertTrue(wordSearch.exist(board, word));
        }

        @Test
        @DisplayName("Full grid traversal required")
        void testFullGridTraversal() {
            char[][] board = {{'A', 'B', 'C', 'D', 'E', 'F'}, {'V', 'U', 'T', 'S', 'R', 'G'},
                    {'W', 'X', 'Y', 'Z', 'Q', 'H'}, {'L', 'K', 'J', 'I', 'P', 'I'},
                    {'M', 'N', 'O', 'P', 'O', 'J'}, {'A', 'B', 'C', 'D', 'E', 'F'}};
            String word = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            boolean result = wordSearch.exist(board, word);
            // This may or may not exist depending on the path, just testing it doesn't crash
            assertNotNull(result);
        }
    }
}

