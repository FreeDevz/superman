package com.example.leetcode;

import java.util.*;
import java.util.Map.Entry;

/**
 * LeetCode 729: My Calendar I.
 *
 * <p>
 * Design a calendar class to store non-overlapping events. Each call to {@code book(start, end)}
 * adds a half-open interval {@code [start, end)} to the calendar if it does not overlap with any
 * existing event. Return {@code true} if the booking is successful, otherwise {@code false}.
 *
 * <p>
 * <strong>Constraints</strong>
 * <ul>
 * <li>{@code 0 <= start < end <= 10^9}
 * <li>At most {@code 10^4} calls to {@code book}
 * </ul>
 *
 * <p>
 * This file provides three different approaches with varying trade-offs, along with reusable
 * validation and utility helpers.
 */
public class MyCalendarI {

    private MyCalendarI() {
        // Utility class
    }

    /**
     * Validates the interval bounds for a calendar event.
     *
     * @throws IllegalArgumentException if the interval is invalid
     */
    public static void validateInterval(int start, int end) {
        if (start < 0) {
            throw new IllegalArgumentException("Start time must be non-negative");
        }
        if (end <= start) {
            throw new IllegalArgumentException(
                    "End time must be greater than start time: [" + start + ", " + end + ")");
        }
    }

    /**
     * Returns {@code true} if two half-open intervals overlap.
     *
     * @throws IllegalArgumentException if either interval is invalid
     */
    public static boolean intervalsOverlap(int[] first, int[] second) {
        Objects.requireNonNull(first, "First interval must not be null");
        Objects.requireNonNull(second, "Second interval must not be null");
        if (first.length != 2 || second.length != 2) {
            throw new IllegalArgumentException("Intervals must contain exactly two elements");
        }
        validateInterval(first[0], first[1]);
        validateInterval(second[0], second[1]);
        return overlaps(first[0], first[1], second[0], second[1]);
    }

    /**
     * Returns {@code true} if two intervals {@code [start1, end1)} and {@code [start2, end2)}
     * overlap.
     */
    public static boolean overlaps(int start1, int end1, int start2, int end2) {
        validateInterval(start1, end1);
        validateInterval(start2, end2);
        return Math.max(start1, start2) < Math.min(end1, end2);
    }

    /**
     * Approach 1: TreeMap (Ordered Map) – Optimal for this problem.
     *
     * <p>
     * Maintains events in a {@link TreeMap} keyed by start times. Lookups for the neighboring
     * events (floor and ceiling) allow detecting conflicts in {@code O(log n)} time.
     *
     * <p>
     * Time Complexity: {@code O(log n)} per booking<br>
     * Space Complexity: {@code O(n)} for storing events
     */
    public static class MyCalendarTreeMap {
        private final TreeMap<Integer, Integer> calendar = new TreeMap<>();

        /**
         * Attempts to add the interval {@code [start, end)} to the calendar.
         *
         * @return {@code true} if the booking was successful, {@code false} otherwise
         */
        public boolean book(int start, int end) {
            validateInterval(start, end);

            Entry<Integer, Integer> previous = calendar.floorEntry(start);
            if (previous != null && previous.getValue() > start) {
                return false;
            }

            Entry<Integer, Integer> next = calendar.ceilingEntry(start);
            if (next != null && next.getKey() < end) {
                return false;
            }

            calendar.put(start, end);
            return true;
        }

        /** Returns the number of events currently stored. */
        public int size() {
            return calendar.size();
        }

        /** Returns a snapshot of the booked intervals in ascending order of start time. */
        public List<int[]> snapshot() {
            List<int[]> result = new ArrayList<>(calendar.size());
            for (Entry<Integer, Integer> entry : calendar.entrySet()) {
                result.add(new int[] {entry.getKey(), entry.getValue()});
            }
            return result;
        }
    }

    /**
     * Approach 2: Sorted List with Binary Search.
     *
     * <p>
     * Maintains events in an {@link ArrayList} sorted by start time. Uses binary search to find the
     * insertion point while checking potential neighbors for conflicts.
     *
     * <p>
     * Time Complexity: {@code O(n)} due to list insertion (binary search reduces comparisons to
     * {@code O(log n)} but insertion is {@code O(n)})<br>
     * Space Complexity: {@code O(n)}
     */
    public static class MyCalendarBinarySearch {
        private final List<int[]> bookings = new ArrayList<>();

        public boolean book(int start, int end) {
            validateInterval(start, end);
            int insertIndex = findInsertPosition(start);

            if (insertIndex > 0) {
                int[] previous = bookings.get(insertIndex - 1);
                if (previous[1] > start) {
                    return false;
                }
            }

            if (insertIndex < bookings.size()) {
                int[] next = bookings.get(insertIndex);
                if (next[0] < end) {
                    return false;
                }
            }

            bookings.add(insertIndex, new int[] {start, end});
            return true;
        }

        /** Returns a snapshot of the intervals to assist with testing and debugging. */
        public List<int[]> snapshot() {
            List<int[]> copy = new ArrayList<>(bookings.size());
            for (int[] interval : bookings) {
                copy.add(new int[] {interval[0], interval[1]});
            }
            return copy;
        }

        private int findInsertPosition(int start) {
            int low = 0;
            int high = bookings.size();
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (bookings.get(mid)[0] < start) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }

    /**
     * Approach 3: Brute Force with Linear Scan.
     *
     * <p>
     * Useful for educational purposes or small data volumes. Traverses every stored interval and
     * rejects the booking if any conflict is found.
     *
     * <p>
     * Time Complexity: {@code O(n)} per booking<br>
     * Space Complexity: {@code O(n)}
     */
    public static class MyCalendarLinearScan {
        private final List<int[]> bookings = new ArrayList<>();

        public boolean book(int start, int end) {
            validateInterval(start, end);

            for (int[] interval : bookings) {
                if (overlaps(interval[0], interval[1], start, end)) {
                    return false;
                }
            }

            bookings.add(new int[] {start, end});
            bookings.sort(Comparator.comparingInt(interval -> interval[0]));
            return true;
        }

        /** Returns an immutable view of the current bookings sorted by start time. */
        public List<int[]> snapshot() {
            List<int[]> copy = new ArrayList<>(bookings.size());
            for (int[] interval : bookings) {
                copy.add(new int[] {interval[0], interval[1]});
            }
            copy.sort(Comparator.comparingInt(interval -> interval[0]));
            return Collections.unmodifiableList(copy);
        }
    }
}

