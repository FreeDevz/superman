package com.example.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 362: Design Hit Counter.
 *
 * <p>
 * Provides two implementations for counting hits within the most recent five minutes (300 seconds)
 * under the assumption that operations arrive in non-decreasing timestamp order.
 *
 * <ul>
 * <li>{@link QueueHitCounter}: Stores every hit timestamp in an {@link ArrayDeque} and evicts
 * entries that fall outside the trailing five-minute window.</li>
 * <li>{@link CircularBufferHitCounter}: Uses a fixed-size circular buffer of size 300 to track how
 * many hits occurred at each second, which is the follow-up friendly design when the hit volume per
 * second can be large.</li>
 * </ul>
 *
 * <p>
 * Both implementations run in {@code O(1)} amortised time per operation and {@code O(W)} space,
 * where {@code W} is the window size (300 seconds).
 *
 * <p>
 * Inspired by the discussion at
 * <a href="https://leetcode.ca/2016-11-26-362-Design-Hit-Counter/">leetcode.ca</a>.
 */
public final class DesignHitCounter {

    /** Number of seconds included in the trailing window (5 minutes). */
    public static final int WINDOW_DURATION_SECONDS = 300;

    private DesignHitCounter() {
        // Utility class
    }

    /**
     * Common contract for hit counter implementations.
     */
    public interface HitCounter {
        /**
         * Records a new hit occurring at {@code timestamp}.
         *
         * @param timestamp the current timestamp in seconds granularity (must be positive and
         *        non-decreasing across operations)
         */
        void hit(int timestamp);

        /**
         * Returns the number of hits received during the most recent
         * {@value #WINDOW_DURATION_SECONDS} seconds, inclusive of the current timestamp.
         *
         * @param timestamp the current timestamp in seconds granularity (must be positive and
         *        non-decreasing across operations)
         * @return number of hits within the trailing window
         */
        int getHits(int timestamp);
    }

    /**
     * Validates that the provided timestamp complies with LeetCode constraints.
     *
     * @param timestamp timestamp to validate
     * @throws IllegalArgumentException if {@code timestamp} is non-positive
     */
    public static void validateTimestamp(int timestamp) {
        if (timestamp <= 0) {
            throw new IllegalArgumentException("Timestamp must be positive: " + timestamp);
        }
    }

    /**
     * Ensures that calls arrive in chronological order, matching the problem statement's guarantee.
     *
     * @param previousTimestamp the timestamp used by the previous operation
     * @param currentTimestamp the timestamp for the current operation
     * @throws IllegalArgumentException if operations arrive out of order
     */
    static void validateChronologicalOrder(int previousTimestamp, int currentTimestamp) {
        if (currentTimestamp < previousTimestamp) {
            throw new IllegalArgumentException("Timestamps must be non-decreasing. Previous: "
                    + previousTimestamp + ", current: " + currentTimestamp);
        }
    }

    /**
     * Approach 1: Queue-based hit counter.
     *
     * <p>
     * Maintains a deque of timestamps and evicts entries older than 300 seconds as new operations
     * arrive. This mirrors the canonical interview solution and keeps all historical hits within
     * the active window.
     *
     * <p>
     * Time Complexity: {@code O(1)} amortised per operation.<br>
     * Space Complexity: {@code O(W)} where {@code W = 300}.
     */
    public static final class QueueHitCounter implements HitCounter {

        private final Deque<Integer> timestamps = new ArrayDeque<>();
        private int lastTimestamp;

        @Override
        public void hit(int timestamp) {
            validateTimestamp(timestamp);
            purge(timestamp);
            timestamps.addLast(timestamp);
            lastTimestamp = timestamp;
        }

        @Override
        public int getHits(int timestamp) {
            validateTimestamp(timestamp);
            purge(timestamp);
            lastTimestamp = timestamp;
            return timestamps.size();
        }

        private void purge(int timestamp) {
            validateChronologicalOrder(lastTimestamp, timestamp);
            int threshold = timestamp - WINDOW_DURATION_SECONDS;
            while (!timestamps.isEmpty() && timestamps.peekFirst() <= threshold) {
                timestamps.removeFirst();
            }
        }
    }

    /**
     * Approach 2: Circular buffer hit counter (follow-up ready).
     *
     * <p>
     * Stores aggregate hit counts for each second modulo 300, overwriting stale entries as time
     * advances. This design supports very high hit throughput without retaining every individual
     * timestamp.
     *
     * <p>
     * Time Complexity: {@code O(1)} for {@link #hit(int)} and {@link #getHits(int)} (with a
     * constant factor of 300 for the latter).<br>
     * Space Complexity: {@code O(W)} where {@code W = 300}.
     */
    public static final class CircularBufferHitCounter implements HitCounter {

        private final int[] times = new int[WINDOW_DURATION_SECONDS];
        private final int[] hits = new int[WINDOW_DURATION_SECONDS];
        private int lastTimestamp;

        @Override
        public void hit(int timestamp) {
            validateTimestamp(timestamp);
            validateChronologicalOrder(lastTimestamp, timestamp);
            int index = timestamp % WINDOW_DURATION_SECONDS;
            if (times[index] != timestamp) {
                times[index] = timestamp;
                hits[index] = 1;
            } else {
                hits[index]++;
            }
            lastTimestamp = timestamp;
        }

        @Override
        public int getHits(int timestamp) {
            validateTimestamp(timestamp);
            validateChronologicalOrder(lastTimestamp, timestamp);
            int total = 0;
            for (int i = 0; i < WINDOW_DURATION_SECONDS; i++) {
                if (timestamp - times[i] < WINDOW_DURATION_SECONDS) {
                    total += hits[i];
                }
            }
            lastTimestamp = timestamp;
            return total;
        }
    }
}

