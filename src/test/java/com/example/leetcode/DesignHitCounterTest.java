package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link DesignHitCounter}.
 */
class DesignHitCounterTest {

    @Nested
    class QueueHitCounterTests {

        private final DesignHitCounter.QueueHitCounter counter =
                new DesignHitCounter.QueueHitCounter();

        @Test
        void matchesLeetCodeExample() {
            counter.hit(1);
            counter.hit(2);
            counter.hit(3);
            assertEquals(3, counter.getHits(4));
            counter.hit(300);
            assertEquals(4, counter.getHits(300));
            assertEquals(3, counter.getHits(301));
        }

        @Test
        void supportsMultipleHitsAtSameTimestamp() {
            counter.hit(50);
            counter.hit(50);
            counter.hit(50);
            assertEquals(3, counter.getHits(50));
        }

        @Test
        void evictsHitsOlderThanFiveMinutes() {
            counter.hit(10);
            counter.hit(300);
            counter.hit(301);
            assertEquals(3, counter.getHits(301));
            assertEquals(2, counter.getHits(310));
            assertEquals(0, counter.getHits(611));
        }

        @Test
        void enforcingChronologicalOrder() {
            counter.hit(100);
            IllegalArgumentException ex =
                    assertThrows(IllegalArgumentException.class, () -> counter.getHits(99));
            assertTrue(ex.getMessage().contains("non-decreasing"));
        }

        @Test
        void rejectsNonPositiveTimestamps() {
            IllegalArgumentException ex =
                    assertThrows(IllegalArgumentException.class, () -> counter.hit(0));
            assertTrue(ex.getMessage().contains("positive"));
        }
    }

    @Nested
    class CircularBufferHitCounterTests {

        private final DesignHitCounter.CircularBufferHitCounter counter =
                new DesignHitCounter.CircularBufferHitCounter();

        @Test
        void matchesLeetCodeExample() {
            counter.hit(1);
            counter.hit(2);
            counter.hit(3);
            assertEquals(3, counter.getHits(4));
            counter.hit(300);
            assertEquals(4, counter.getHits(300));
            assertEquals(3, counter.getHits(301));
        }

        @Test
        void aggregatesHitsBySecond() {
            for (int i = 0; i < 10; i++) {
                counter.hit(100);
            }
            counter.hit(250);
            assertEquals(11, counter.getHits(250));
            counter.hit(399);
            assertEquals(12, counter.getHits(399));
            assertEquals(2, counter.getHits(401));
        }

        @Test
        void preventsTimestampRegression() {
            counter.hit(42);
            IllegalArgumentException ex =
                    assertThrows(IllegalArgumentException.class, () -> counter.hit(41));
            assertTrue(ex.getMessage().contains("non-decreasing"));
        }
    }
}

