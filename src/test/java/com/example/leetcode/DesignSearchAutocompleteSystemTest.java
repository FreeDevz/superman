package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link DesignSearchAutocompleteSystem}.
 */
class DesignSearchAutocompleteSystemTest {

    private DesignSearchAutocompleteSystem.AutocompleteSystem newSystem(String[] sentences,
            int[] times) {
        return new DesignSearchAutocompleteSystem.AutocompleteSystem(sentences, times);
    }

    @Test
    @DisplayName("Matches the canonical LeetCode example sequence")
    void matchesLeetCodeExample() {
        DesignSearchAutocompleteSystem.AutocompleteSystem system =
                newSystem(new String[] {"i love you", "island", "iroman", "i love leetcode"},
                        new int[] {5, 3, 2, 2});

        assertEquals(List.of("i love you", "island", "i love leetcode"), system.input('i'));
        assertEquals(List.of("i love you", "i love leetcode"), system.input(' '));
        assertEquals(List.of(), system.input('a'));
        assertEquals(List.of(), system.input('#'));

        assertEquals(List.of("i love you", "island", "i love leetcode"), system.input('i'));
    }

    @Test
    @DisplayName("Maintains ASCII ordering when frequencies tie")
    void respectsAsciiOrderingOnTies() {
        DesignSearchAutocompleteSystem.AutocompleteSystem system =
                newSystem(new String[] {"ab ", "aba", "abf"}, new int[] {1, 1, 1});

        assertEquals(List.of("ab ", "aba", "abf"), system.input('a'));
        assertEquals(List.of("ab ", "aba", "abf"), system.input('b'));
    }

    @Test
    @DisplayName("Learns unseen sentences added during the session")
    void learnsNewSentences() {
        DesignSearchAutocompleteSystem.AutocompleteSystem system =
                newSystem(new String[] {"hello world"}, new int[] {2});

        assertEquals(List.of(), system.input('x'));
        assertEquals(List.of(), system.input('y'));
        assertEquals(List.of(), system.input('#'));

        assertEquals(List.of("xy"), system.input('x'));
        assertEquals(List.of("xy"), system.input('y'));
    }

    @Test
    @DisplayName("Rejects unsupported characters in input stream")
    void rejectsUnsupportedCharacters() {
        DesignSearchAutocompleteSystem.AutocompleteSystem system =
                newSystem(new String[] {"leetcode"}, new int[] {1});

        IllegalArgumentException ex =
                assertThrows(IllegalArgumentException.class, () -> system.input('L'));
        assertEquals("Unsupported character: 'L'. Expect lowercase letters or space.",
                ex.getMessage());
    }

    @Nested
    class ConstructorValidationTests {

        @Test
        void rejectsMismatchedArrayLengths() {
            assertThrows(IllegalArgumentException.class,
                    () -> newSystem(new String[] {"a"}, new int[] {1, 2}));
        }

        @Test
        void rejectsInvalidCharactersInSeedData() {
            assertThrows(IllegalArgumentException.class,
                    () -> newSystem(new String[] {"Uppercase"}, new int[] {1}));
        }

        @Test
        void rejectsNonPositiveFrequencies() {
            assertThrows(IllegalArgumentException.class,
                    () -> newSystem(new String[] {"valid"}, new int[] {0}));
        }
    }
}

