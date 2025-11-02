package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for LetterCombinationsOfPhoneNumber
 */
public class LetterCombinationsOfPhoneNumberTest {

    private LetterCombinationsOfPhoneNumber solution;

    @BeforeEach
    void setUp() {
        solution = new LetterCombinationsOfPhoneNumber();
    }

    @Test
    void testLetterCombinationsRecursive_Example1() {
        String digits = "23";
        List<String> result = solution.letterCombinationsRecursive(digits);

        List<String> expected = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
        assertTrue(expected.containsAll(result));
    }

    @Test
    void testLetterCombinationsRecursive_Example2() {
        String digits = "";
        List<String> result = solution.letterCombinationsRecursive(digits);

        assertTrue(result.isEmpty());
    }

    @Test
    void testLetterCombinationsRecursive_Example3() {
        String digits = "2";
        List<String> result = solution.letterCombinationsRecursive(digits);

        List<String> expected = Arrays.asList("a", "b", "c");
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
        assertTrue(expected.containsAll(result));
    }

    @Test
    void testLetterCombinationsRecursive_SingleDigit() {
        String digits = "7";
        List<String> result = solution.letterCombinationsRecursive(digits);

        List<String> expected = Arrays.asList("p", "q", "r", "s");
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
        assertTrue(expected.containsAll(result));
    }

    @Test
    void testLetterCombinationsRecursive_ThreeDigits() {
        String digits = "234";
        List<String> result = solution.letterCombinationsRecursive(digits);

        // Should have 3 * 3 * 3 = 27 combinations
        assertEquals(27, result.size());

        // Check some specific combinations
        assertTrue(result.contains("adg"));
        assertTrue(result.contains("adh"));
        assertTrue(result.contains("adi"));
        assertTrue(result.contains("cfi"));
    }

    @Test
    void testLetterCombinationsRecursive_FourDigits() {
        String digits = "2345";
        List<String> result = solution.letterCombinationsRecursive(digits);

        // Should have 3 * 3 * 3 * 3 = 81 combinations
        assertEquals(81, result.size());
    }

    @Test
    void testLetterCombinationsRecursive_WithSevenAndNine() {
        String digits = "79";
        List<String> result = solution.letterCombinationsRecursive(digits);

        // Should have 4 * 4 = 16 combinations
        assertEquals(16, result.size());

        // Check some specific combinations
        assertTrue(result.contains("pw"));
        assertTrue(result.contains("px"));
        assertTrue(result.contains("py"));
        assertTrue(result.contains("pz"));
        assertTrue(result.contains("sw"));
        assertTrue(result.contains("sz"));
    }

    @Test
    void testLetterCombinationsIterative_Example1() {
        String digits = "23";
        List<String> result = solution.letterCombinationsIterative(digits);

        List<String> expected = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
        assertTrue(expected.containsAll(result));
    }

    @Test
    void testLetterCombinationsIterative_EmptyString() {
        String digits = "";
        List<String> result = solution.letterCombinationsIterative(digits);

        assertTrue(result.isEmpty());
    }

    @Test
    void testLetterCombinationsIterative_SingleDigit() {
        String digits = "2";
        List<String> result = solution.letterCombinationsIterative(digits);

        List<String> expected = Arrays.asList("a", "b", "c");
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
        assertTrue(expected.containsAll(result));
    }

    @Test
    void testLetterCombinationsIterativeList_Example1() {
        String digits = "23";
        List<String> result = solution.letterCombinationsIterativeList(digits);

        List<String> expected = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
        assertTrue(expected.containsAll(result));
    }

    @Test
    void testLetterCombinationsIterativeList_EmptyString() {
        String digits = "";
        List<String> result = solution.letterCombinationsIterativeList(digits);

        assertTrue(result.isEmpty());
    }

    @Test
    void testAllMethodsProduceSameResults() {
        String[] testCases = {"23", "", "2", "234", "7", "79", "2345"};

        for (String digits : testCases) {
            List<String> recursive = solution.letterCombinationsRecursive(digits);
            List<String> iterative = solution.letterCombinationsIterative(digits);
            List<String> iterativeList = solution.letterCombinationsIterativeList(digits);

            // All methods should produce the same results
            assertTrue(recursive.containsAll(iterative) && iterative.containsAll(recursive),
                    "Recursive and Iterative methods differ for input: " + digits);
            assertTrue(iterative.containsAll(iterativeList) && iterativeList.containsAll(iterative),
                    "Iterative and IterativeList methods differ for input: " + digits);
        }
    }

    @Test
    void testNullInput() {
        List<String> recursive = solution.letterCombinationsRecursive(null);
        List<String> iterative = solution.letterCombinationsIterative(null);
        List<String> iterativeList = solution.letterCombinationsIterativeList(null);

        assertTrue(recursive.isEmpty());
        assertTrue(iterative.isEmpty());
        assertTrue(iterativeList.isEmpty());
    }

    @Test
    void testEdgeCase_SingleDigitWithFourLetters() {
        String digits = "9";
        List<String> result = solution.letterCombinationsRecursive(digits);

        List<String> expected = Arrays.asList("w", "x", "y", "z");
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
        assertTrue(expected.containsAll(result));
    }

    @Test
    void testEdgeCase_MaximumLength() {
        String digits = "2345";
        List<String> result = solution.letterCombinationsRecursive(digits);

        // Maximum length is 4 digits, each with 3 letters = 3^4 = 81 combinations
        assertEquals(81, result.size());

        // All combinations should be unique
        Set<String> uniqueCombinations = new HashSet<>(result);
        assertEquals(81, uniqueCombinations.size());
    }
}
