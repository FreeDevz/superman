package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link MyCalendarI}.
 */
public class MyCalendarITest {

    private static final int[] INTERVAL_A = {10, 20};
    private static final int[] INTERVAL_B = {20, 30};
    private static final int[] INTERVAL_C = {15, 25};

    @Nested
    class TreeMapApproach {
        private MyCalendarI.MyCalendarTreeMap calendar;

        @BeforeEach
        void setUp() {
            calendar = new MyCalendarI.MyCalendarTreeMap();
        }

        @Test
        void bookFollowLeetCodeExample() {
            assertTrue(calendar.book(10, 20));
            assertFalse(calendar.book(15, 25));
            assertTrue(calendar.book(20, 30));
            assertEquals(2, calendar.size());
        }

        @Test
        void bookAdjacentIntervalsAreAllowed() {
            assertTrue(calendar.book(0, 10));
            assertTrue(calendar.book(10, 20));
            assertTrue(calendar.book(20, 30));
        }

        @Test
        void snapshotReturnsOrderedIntervals() {
            assertTrue(calendar.book(25, 35));
            assertTrue(calendar.book(5, 10));
            assertTrue(calendar.book(40, 50));

            List<int[]> intervals = calendar.snapshot();
            assertEquals(3, intervals.size());
            assertEquals(5, intervals.get(0)[0]);
            assertEquals(10, intervals.get(0)[1]);
            assertEquals(25, intervals.get(1)[0]);
            assertEquals(35, intervals.get(1)[1]);
            assertEquals(40, intervals.get(2)[0]);
            assertEquals(50, intervals.get(2)[1]);
        }

        @Test
        void bookThrowsForInvalidInterval() {
            assertThrows(IllegalArgumentException.class, () -> calendar.book(-1, 5));
            assertThrows(IllegalArgumentException.class, () -> calendar.book(10, 10));
            assertThrows(IllegalArgumentException.class, () -> calendar.book(25, 15));
        }
    }

    @Nested
    class BinarySearchApproach {
        private MyCalendarI.MyCalendarBinarySearch calendar;

        @BeforeEach
        void setUp() {
            calendar = new MyCalendarI.MyCalendarBinarySearch();
        }

        @Test
        void bookMaintainsSortedOrder() {
            assertTrue(calendar.book(30, 40));
            assertTrue(calendar.book(10, 20));
            assertTrue(calendar.book(50, 70));
            assertFalse(calendar.book(35, 45));

            List<int[]> intervals = calendar.snapshot();
            assertEquals(3, intervals.size());
            assertEquals(10, intervals.get(0)[0]);
            assertEquals(20, intervals.get(0)[1]);
            assertEquals(30, intervals.get(1)[0]);
            assertEquals(40, intervals.get(1)[1]);
            assertEquals(50, intervals.get(2)[0]);
            assertEquals(70, intervals.get(2)[1]);
        }

        @Test
        void bookAllowsNestedBinarySearchEdgeCases() {
            assertTrue(calendar.book(0, 5));
            assertTrue(calendar.book(5, 10));
            assertTrue(calendar.book(10, 15));
            assertFalse(calendar.book(3, 6));
            assertFalse(calendar.book(8, 12));
        }

        @Test
        void bookThrowsForInvalidInterval() {
            assertThrows(IllegalArgumentException.class, () -> calendar.book(-5, 0));
            assertThrows(IllegalArgumentException.class, () -> calendar.book(10, 10));
        }
    }

    @Nested
    class LinearScanApproach {
        private MyCalendarI.MyCalendarLinearScan calendar;

        @BeforeEach
        void setUp() {
            calendar = new MyCalendarI.MyCalendarLinearScan();
        }

        @Test
        void bookDetectsConflicts() {
            assertTrue(calendar.book(1, 5));
            assertTrue(calendar.book(10, 15));
            assertTrue(calendar.book(20, 30));
            assertFalse(calendar.book(4, 12));
        }

        @Test
        void snapshotIsImmutableCopy() {
            assertTrue(calendar.book(0, 10));
            assertTrue(calendar.book(15, 25));

            List<int[]> snapshot = calendar.snapshot();
            assertEquals(2, snapshot.size());

            snapshot.get(0)[0] = 99; // mutate snapshot
            List<int[]> refreshed = calendar.snapshot();
            assertEquals(0, refreshed.get(0)[0], "Original intervals should remain unchanged");
        }

        @Test
        void bookThrowsForInvalidInterval() {
            assertThrows(IllegalArgumentException.class, () -> calendar.book(5, 5));
            assertThrows(IllegalArgumentException.class, () -> calendar.book(10, 1));
        }
    }

    @Nested
    class UtilityMethods {

        @Test
        void intervalsOverlapDetectsOverlapCorrectly() {
            assertTrue(MyCalendarI.intervalsOverlap(INTERVAL_A, INTERVAL_C));
            assertFalse(MyCalendarI.intervalsOverlap(INTERVAL_A, INTERVAL_B));
        }

        @Test
        void intervalsOverlapThrowsForInvalidInterval() {
            assertThrows(IllegalArgumentException.class,
                    () -> MyCalendarI.intervalsOverlap(new int[] {5, 5}, INTERVAL_B));
            assertThrows(IllegalArgumentException.class,
                    () -> MyCalendarI.intervalsOverlap(INTERVAL_A, new int[] {8, 7}));
        }

        @Test
        void overlapsUtilityHandlesPrimitiveArguments() {
            assertTrue(MyCalendarI.overlaps(0, 10, 5, 15));
            assertFalse(MyCalendarI.overlaps(0, 10, 10, 20));
        }

        @Test
        void validateIntervalRejectsInvalidRanges() {
            assertThrows(IllegalArgumentException.class, () -> MyCalendarI.validateInterval(-1, 5));
            assertThrows(IllegalArgumentException.class,
                    () -> MyCalendarI.validateInterval(10, 10));
            assertThrows(IllegalArgumentException.class,
                    () -> MyCalendarI.validateInterval(15, 14));
        }
    }
}

