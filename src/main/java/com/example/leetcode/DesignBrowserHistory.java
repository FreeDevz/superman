package com.example.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * LeetCode 1472: Design Browser History.
 *
 * <p>
 * Implements a simplified browser history mechanism that supports visiting URLs, moving backward
 * and forward through the history, and retrieving helpful state information for testing.
 *
 * <p>
 * <strong>Constraints</strong>
 * <ul>
 * <li>{@code 1 <= url.length() <= 2048}
 * <li>{@code url} consists of printable ASCII characters without spaces
 * <li>{@code 1 <= calls.length <= 5 * 10^4}
 * </ul>
 *
 * <p>
 * This file provides two distinct approaches:
 * <ol>
 * <li>An {@link ArrayList}-backed implementation that mirrors LeetCode's canonical design.
 * <li>A doubly linked list implementation that more closely imitates real browser history data
 * structures.
 * </ol>
 */
public final class DesignBrowserHistory {

    private static final int MAX_URL_LENGTH = 2048;

    private DesignBrowserHistory() {
        // Utility class
    }

    /**
     * Validates that the provided URL adheres to LeetCode constraints.
     *
     * @param url the URL to validate
     * @throws NullPointerException if {@code url} is {@code null}
     * @throws IllegalArgumentException if {@code url} is blank or exceeds the maximum length
     */
    public static void validateUrl(String url) {
        Objects.requireNonNull(url, "URL must not be null");
        if (url.isBlank()) {
            throw new IllegalArgumentException("URL must contain non-whitespace characters");
        }
        if (url.length() > MAX_URL_LENGTH) {
            throw new IllegalArgumentException(
                    "URL length must be <= " + MAX_URL_LENGTH + " characters");
        }
        if (url.indexOf(' ') >= 0) {
            throw new IllegalArgumentException("URL must not contain whitespace characters");
        }
    }

    /**
     * Validates that the step count is not negative.
     *
     * @param steps number of steps to move backward or forward
     * @throws IllegalArgumentException if {@code steps} is negative
     */
    public static void validateSteps(int steps) {
        if (steps < 0) {
            throw new IllegalArgumentException("Step count must be non-negative");
        }
    }

    /**
     * Approach 1: Dynamic Array + Pointer.
     *
     * <p>
     * Maintains the browser history in a resizable array while tracking the current index. When a
     * new URL is visited, all forward history is discarded in {@code O(n)} time in the worst case
     * by clearing the tail of the list. Moving backward or forward runs in {@code O(1)} time.
     *
     * <p>
     * Time Complexity: {@code O(n)} for {@link #visit(String)} due to trimming, {@code O(1)} for
     * {@link #back(int)} and {@link #forward(int)}<br>
     * Space Complexity: {@code O(n)} where {@code n} is the number of stored URLs
     */
    public static final class BrowserHistoryArray {
        private final List<String> history;
        private int currentIndex;

        /**
         * Creates a new browser history with the supplied homepage.
         *
         * @param homepage initial page to load
         */
        public BrowserHistoryArray(String homepage) {
            validateUrl(homepage);
            this.history = new ArrayList<>();
            this.history.add(homepage);
            this.currentIndex = 0;
        }

        /**
         * Visits a new URL and discards any forward history.
         *
         * @param url new URL to visit
         */
        public void visit(String url) {
            validateUrl(url);
            if (currentIndex < history.size() - 1) {
                history.subList(currentIndex + 1, history.size()).clear();
            }
            history.add(url);
            currentIndex = history.size() - 1;
        }

        /**
         * Moves backward in history by up to {@code steps} entries.
         *
         * @param steps number of steps to move backward
         * @return the URL at the new current position
         */
        public String back(int steps) {
            validateSteps(steps);
            currentIndex = Math.max(0, currentIndex - steps);
            return history.get(currentIndex);
        }

        /**
         * Moves forward in history by up to {@code steps} entries.
         *
         * @param steps number of steps to move forward
         * @return the URL at the new current position
         */
        public String forward(int steps) {
            validateSteps(steps);
            currentIndex = Math.min(history.size() - 1, currentIndex + steps);
            return history.get(currentIndex);
        }

        /** Returns the URL currently displayed. */
        public String current() {
            return history.get(currentIndex);
        }

        /**
         * Returns a snapshot of the history list for testing and debugging.
         *
         * <p>
         * The returned list is immutable to guard against accidental modifications.
         */
        public List<String> snapshot() {
            return Collections.unmodifiableList(new ArrayList<>(history));
        }

        /** Returns the index of the current page in the history list. */
        public int cursorIndex() {
            return currentIndex;
        }

        /** Returns the number of stored pages. */
        public int size() {
            return history.size();
        }
    }

    /**
     * Approach 2: Doubly Linked List.
     *
     * <p>
     * Maintains the history as a doubly linked list. Visiting a new page truncates any forward
     * nodes, while back and forward navigation translate to pointer adjustments.
     *
     * <p>
     * Time Complexity: {@code O(k)} for {@link #back(int)} and {@link #forward(int)} where
     * {@code k} is the number of steps moved;<br>
     * Space Complexity: {@code O(n)} where {@code n} is the number of stored URLs
     */
    public static final class BrowserHistoryLinkedList {
        private Node current;

        /** Creates a new browser history starting at the provided homepage. */
        public BrowserHistoryLinkedList(String homepage) {
            validateUrl(homepage);
            this.current = new Node(homepage);
        }

        /** Visits a new URL and discards any forward history. */
        public void visit(String url) {
            validateUrl(url);
            detachForwardNodes();

            Node next = new Node(url);
            current.next = next;
            next.prev = current;
            current = next;
        }

        /** Moves backward by up to {@code steps} nodes and returns the current URL. */
        public String back(int steps) {
            validateSteps(steps);
            while (steps > 0 && current.prev != null) {
                current = current.prev;
                steps--;
            }
            return current.url;
        }

        /** Moves forward by up to {@code steps} nodes and returns the current URL. */
        public String forward(int steps) {
            validateSteps(steps);
            while (steps > 0 && current.next != null) {
                current = current.next;
                steps--;
            }
            return current.url;
        }

        /** Returns the URL currently displayed. */
        public String current() {
            return current.url;
        }

        /**
         * Returns the entire history in order from the earliest visited page to the most recent.
         */
        public List<String> snapshot() {
            Node head = current;
            while (head.prev != null) {
                head = head.prev;
            }

            List<String> pages = new ArrayList<>();
            Node cursor = head;
            while (cursor != null) {
                pages.add(cursor.url);
                cursor = cursor.next;
            }
            return Collections.unmodifiableList(pages);
        }

        /** Returns the number of entries in the history. */
        public int size() {
            int count = 0;
            Node head = current;
            while (head.prev != null) {
                head = head.prev;
            }
            for (Node node = head; node != null; node = node.next) {
                count++;
            }
            return count;
        }

        /**
         * Returns the zero-based offset of {@link #current()} from the head of the history list.
         */
        public int cursorIndex() {
            int index = 0;
            Node cursor = current;
            while (cursor.prev != null) {
                cursor = cursor.prev;
                index++;
            }
            return index;
        }

        private void detachForwardNodes() {
            Node toDetach = current.next;
            current.next = null;
            while (toDetach != null) {
                Node next = toDetach.next;
                toDetach.prev = null;
                toDetach.next = null;
                toDetach = next;
            }
        }

        /** Doubly linked list node representing a single page visit. */
        private static final class Node {
            private final String url;
            private Node prev;
            private Node next;

            private Node(String url) {
                this.url = url;
            }
        }
    }
}


