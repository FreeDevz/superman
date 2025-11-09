package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link DesignBrowserHistory}.
 */
public class DesignBrowserHistoryTest {

    @Nested
    class ArrayApproach {
        private DesignBrowserHistory.BrowserHistoryArray history;

        @BeforeEach
        void setUp() {
            history = new DesignBrowserHistory.BrowserHistoryArray("leetcode.com");
        }

        @Test
        void followsLeetCodeExample() {
            history.visit("google.com");
            history.visit("facebook.com");
            history.visit("youtube.com");

            assertEquals("facebook.com", history.back(1));
            assertEquals("google.com", history.back(1));
            assertEquals("facebook.com", history.forward(1));

            history.visit("linkedin.com");
            assertEquals("linkedin.com", history.current());
            assertEquals(List.of("leetcode.com", "google.com", "facebook.com", "linkedin.com"),
                    history.snapshot());

            assertEquals("linkedin.com", history.forward(2), "Forward should clamp at the tail");
            assertEquals("google.com", history.back(2));
            assertEquals("leetcode.com", history.back(7), "Back should clamp at the head");
            assertEquals(0, history.cursorIndex());
        }

        @Test
        void visitTrimsForwardHistory() {
            history.visit("google.com");
            history.visit("facebook.com");
            assertEquals("google.com", history.back(1));

            history.visit("stackoverflow.com");
            assertEquals("stackoverflow.com", history.current());
            assertEquals(List.of("leetcode.com", "google.com", "stackoverflow.com"),
                    history.snapshot());
            assertEquals("stackoverflow.com", history.forward(5));
        }

        @Test
        void snapshotIsImmutable() {
            history.visit("google.com");
            List<String> snapshot = history.snapshot();
            assertThrows(UnsupportedOperationException.class,
                    () -> snapshot.set(0, "modified.com"));
        }

        @Test
        void negativeStepsThrowIllegalArgumentException() {
            assertThrows(IllegalArgumentException.class, () -> history.back(-1));
            assertThrows(IllegalArgumentException.class, () -> history.forward(-5));
        }
    }

    @Nested
    class LinkedListApproach {
        private DesignBrowserHistory.BrowserHistoryLinkedList history;

        @BeforeEach
        void setUp() {
            history = new DesignBrowserHistory.BrowserHistoryLinkedList("leetcode.com");
        }

        @Test
        void followsLeetCodeExample() {
            history.visit("google.com");
            history.visit("facebook.com");
            history.visit("youtube.com");

            assertEquals("facebook.com", history.back(1));
            assertEquals("google.com", history.back(1));
            assertEquals("facebook.com", history.forward(1));

            history.visit("linkedin.com");
            assertEquals("linkedin.com", history.current());
            assertEquals(List.of("leetcode.com", "google.com", "facebook.com", "linkedin.com"),
                    history.snapshot());

            assertEquals("linkedin.com", history.forward(2));
            assertEquals("google.com", history.back(2));
            assertEquals("leetcode.com", history.back(7));
            assertEquals(0, history.cursorIndex());
            assertEquals(4, history.size());
        }

        @Test
        void visitTrimsForwardHistory() {
            history.visit("google.com");
            history.visit("facebook.com");
            assertEquals("google.com", history.back(1));

            history.visit("leetcode.com/problems");
            assertEquals("leetcode.com/problems", history.current());
            assertEquals(List.of("leetcode.com", "google.com", "leetcode.com/problems"),
                    history.snapshot());
            assertEquals("leetcode.com/problems", history.forward(4));
        }
    }

    @Nested
    class Validation {

        @Test
        void validateUrlRejectsNullOrBlank() {
            assertThrows(NullPointerException.class, () -> DesignBrowserHistory.validateUrl(null));
            assertThrows(IllegalArgumentException.class,
                    () -> DesignBrowserHistory.validateUrl("  "));
        }

        @Test
        void validateUrlRejectsWhitespace() {
            assertThrows(IllegalArgumentException.class,
                    () -> DesignBrowserHistory.validateUrl("example space.com"));
        }

        @Test
        void validateUrlAcceptsCommonCharacters() {
            assertDoesNotThrow(
                    () -> DesignBrowserHistory.validateUrl("https://leetcode.com/problemset"));
            assertDoesNotThrow(() -> DesignBrowserHistory
                    .validateUrl("docs.oracle.com/javase/8/docs/api/java/util/List.html"));
        }
    }
}


