package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Comprehensive test suite for LeetCode 1604: Alert Using Same Key-Card Three or More Times
 * 
 * Test Categories: 1. LeetCode Examples - Official test cases from the problem 2. Edge Cases -
 * Minimal inputs, boundary conditions 3. Boundary Tests - Exactly 60 minutes, just over 60 minutes
 * 4. Multiple Workers - Multiple workers with and without alerts 5. Special Cases - Same time
 * accesses, multiple alert windows 6. Performance Tests - Large inputs 7. Cross Approach Comparison
 * - Verify all approaches give same results
 */
@DisplayName("Alert Using Same Key-Card Three or More Times Tests")
public class AlertUsingKeyCardTest {

    private AlertUsingKeyCard solution;

    @BeforeEach
    void setUp() {
        solution = new AlertUsingKeyCard();
    }

    @Nested
    @DisplayName("LeetCode Example Tests")
    class LeetCodeExamplesTests {

        @Test
        @DisplayName("Example 1: Daniel triggers alert")
        void testExample1() {
            String[] keyName = {"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"};
            String[] keyTime = {"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"};

            List<String> expected = Arrays.asList("daniel");
            List<String> result = solution.alertNames(keyName, keyTime);

            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Example 2: Bob triggers alert")
        void testExample2() {
            String[] keyName = {"alice", "alice", "alice", "bob", "bob", "bob", "bob"};
            String[] keyTime = {"12:01", "12:00", "18:00", "21:00", "21:20", "21:30", "23:00"};

            List<String> expected = Arrays.asList("bob");
            List<String> result = solution.alertNames(keyName, keyTime);

            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Example 3: No alerts (crosses midnight)")
        void testExample3() {
            String[] keyName = {"john", "john", "john"};
            String[] keyTime = {"23:58", "23:59", "00:01"};

            List<String> expected = Arrays.asList();
            List<String> result = solution.alertNames(keyName, keyTime);

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Edge Cases Tests")
    class EdgeCasesTests {

        @Test
        @DisplayName("Minimum input - Single worker, 1 access")
        void testSingleAccess() {
            String[] keyName = {"alice"};
            String[] keyTime = {"10:00"};

            List<String> expected = Arrays.asList();
            List<String> result = solution.alertNames(keyName, keyTime);

            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Single worker - 2 accesses (not enough)")
        void testTwoAccesses() {
            String[] keyName = {"alice", "alice"};
            String[] keyTime = {"10:00", "10:30"};

            List<String> expected = Arrays.asList();
            List<String> result = solution.alertNames(keyName, keyTime);

            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Single worker - Exactly 3 accesses within 60 minutes")
        void testExactlyThreeAccesses() {
            String[] keyName = {"alice", "alice", "alice"};
            String[] keyTime = {"10:00", "10:30", "11:00"};

            List<String> expected = Arrays.asList("alice");
            List<String> result = solution.alertNames(keyName, keyTime);

            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Empty arrays")
        void testEmptyArrays() {
            String[] keyName = {};
            String[] keyTime = {};

            List<String> expected = Arrays.asList();
            List<String> result = solution.alertNames(keyName, keyTime);

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Boundary Tests - Time Windows")
    class BoundaryTests {

        @Test
        @DisplayName("Exactly 60 minutes between first and third access")
        void testExactly60Minutes() {
            String[] keyName = {"alice", "alice", "alice"};
            String[] keyTime = {"10:00", "10:30", "11:00"};

            List<String> expected = Arrays.asList("alice");
            List<String> result = solution.alertNames(keyName, keyTime);

            assertEquals(expected, result);
        }

        @Test
        @DisplayName("61 minutes between first and third access - No alert")
        void test61Minutes() {
            String[] keyName = {"alice", "alice", "alice"};
            String[] keyTime = {"10:00", "10:30", "11:01"};

            List<String> expected = Arrays.asList();
            List<String> result = solution.alertNames(keyName, keyTime);

            assertEquals(expected, result);
        }

        @Test
        @DisplayName("59 minutes between first and third access - Alert")
        void test59Minutes() {
            String[] keyName = {"alice", "alice", "alice"};
            String[] keyTime = {"10:00", "10:29", "10:59"};

            List<String> expected = Arrays.asList("alice");
            List<String> result = solution.alertNames(keyName, keyTime);

            assertEquals(expected, result);
        }

        @Test
        @DisplayName("All three accesses at same minute")
        void testSameMinute() {
            String[] keyName = {"alice", "alice", "alice"};
            String[] keyTime = {"10:00", "10:00", "10:00"};

            List<String> expected = Arrays.asList("alice");
            List<String> result = solution.alertNames(keyName, keyTime);

            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Midnight boundary - 23:00 to 00:00")
        void testMidnightBoundary() {
            String[] keyName = {"alice", "alice", "alice"};
            String[] keyTime = {"23:00", "23:30", "00:00"};

            // 23:00 = 1380 minutes, 00:00 = 0 minutes
            // 0 - 1380 = -1380, which is > 60, so no alert
            List<String> expected = Arrays.asList();
            List<String> result = solution.alertNames(keyName, keyTime);

            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Early morning - 00:00 to 01:00")
        void testEarlyMorning() {
            String[] keyName = {"alice", "alice", "alice"};
            String[] keyTime = {"00:00", "00:30", "01:00"};

            List<String> expected = Arrays.asList("alice");
            List<String> result = solution.alertNames(keyName, keyTime);

            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Late night - 22:30 to 23:30")
        void testLateNight() {
            String[] keyName = {"alice", "alice", "alice"};
            String[] keyTime = {"22:30", "23:00", "23:30"};

            List<String> expected = Arrays.asList("alice");
            List<String> result = solution.alertNames(keyName, keyTime);

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Multiple Workers Tests")
    class MultipleWorkersTests {

        @Test
        @DisplayName("Multiple workers - All trigger alerts")
        void testMultipleWorkersAllAlert() {
            String[] keyName = {"alice", "alice", "alice", "bob", "bob", "bob"};
            String[] keyTime = {"10:00", "10:30", "11:00", "14:00", "14:20", "14:40"};

            List<String> expected = Arrays.asList("alice", "bob");
            List<String> result = solution.alertNames(keyName, keyTime);

            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Multiple workers - None trigger alerts")
        void testMultipleWorkersNoAlert() {
            String[] keyName = {"alice", "alice", "bob", "bob"};
            String[] keyTime = {"10:00", "11:30", "14:00", "15:30"};

            List<String> expected = Arrays.asList();
            List<String> result = solution.alertNames(keyName, keyTime);

            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Multiple workers - Mixed results")
        void testMultipleWorkersMixed() {
            String[] keyName =
                    {"alice", "alice", "alice", "bob", "bob", "charlie", "charlie", "charlie"};
            String[] keyTime =
                    {"10:00", "10:30", "11:00", "14:00", "16:00", "09:00", "09:15", "09:30"};

            List<String> expected = Arrays.asList("alice", "charlie");
            List<String> result = solution.alertNames(keyName, keyTime);

            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Alphabetical ordering - Multiple alerts")
        void testAlphabeticalOrdering() {
            String[] keyName =
                    {"zoe", "zoe", "zoe", "alice", "alice", "alice", "mike", "mike", "mike"};
            String[] keyTime = {"10:00", "10:20", "10:40", "11:00", "11:20", "11:40", "12:00",
                    "12:20", "12:40"};

            List<String> expected = Arrays.asList("alice", "mike", "zoe");
            List<String> result = solution.alertNames(keyName, keyTime);

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Special Cases Tests")
    class SpecialCasesTests {

        @Test
        @DisplayName("Multiple alert windows for same worker")
        void testMultipleAlertWindows() {
            String[] keyName = {"alice", "alice", "alice", "alice", "alice", "alice"};
            String[] keyTime = {"10:00", "10:20", "10:40", "14:00", "14:20", "14:40"};

            // Two separate alert windows
            List<String> expected = Arrays.asList("alice");
            List<String> result = solution.alertNames(keyName, keyTime);

            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Overlapping alert windows")
        void testOverlappingAlertWindows() {
            String[] keyName = {"alice", "alice", "alice", "alice"};
            String[] keyTime = {"10:00", "10:20", "10:40", "10:50"};

            // Multiple overlapping 3-access windows all within 60 min
            List<String> expected = Arrays.asList("alice");
            List<String> result = solution.alertNames(keyName, keyTime);

            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Unsorted input times")
        void testUnsortedTimes() {
            String[] keyName = {"alice", "alice", "alice"};
            String[] keyTime = {"11:00", "10:00", "10:30"};

            List<String> expected = Arrays.asList("alice");
            List<String> result = solution.alertNames(keyName, keyTime);

            assertEquals(expected, result);
        }

        @Test
        @DisplayName("4 accesses - First 3 no alert, Last 3 alert")
        void testFourAccessesLastThreeAlert() {
            String[] keyName = {"alice", "alice", "alice", "alice"};
            String[] keyTime = {"10:00", "11:30", "12:00", "12:30"};

            // 10:00, 11:30, 12:00 -> 120 minutes (no alert)
            // 11:30, 12:00, 12:30 -> 60 minutes (alert)
            List<String> expected = Arrays.asList("alice");
            List<String> result = solution.alertNames(keyName, keyTime);

            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Many accesses - Only one alert window")
        void testManyAccessesOneAlert() {
            String[] keyName = {"alice", "alice", "alice", "alice", "alice", "alice"};
            String[] keyTime = {"08:00", "10:00", "12:00", "14:00", "14:30", "15:00"};

            // Only 14:00, 14:30, 15:00 forms an alert window
            List<String> expected = Arrays.asList("alice");
            List<String> result = solution.alertNames(keyName, keyTime);

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Pattern Tests")
    class PatternTests {

        @Test
        @DisplayName("Evenly spaced accesses within 60 min")
        void testEvenlySpacedAccesses() {
            String[] keyName = {"alice", "alice", "alice", "alice"};
            String[] keyTime = {"10:00", "10:20", "10:40", "11:00"};

            List<String> expected = Arrays.asList("alice");
            List<String> result = solution.alertNames(keyName, keyTime);

            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Clustered accesses at start of window")
        void testClusteredAtStart() {
            String[] keyName = {"alice", "alice", "alice"};
            String[] keyTime = {"10:00", "10:01", "10:02"};

            List<String> expected = Arrays.asList("alice");
            List<String> result = solution.alertNames(keyName, keyTime);

            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Clustered accesses at end of window")
        void testClusteredAtEnd() {
            String[] keyName = {"alice", "alice", "alice"};
            String[] keyTime = {"10:58", "10:59", "11:00"};

            List<String> expected = Arrays.asList("alice");
            List<String> result = solution.alertNames(keyName, keyTime);

            assertEquals(expected, result);
        }

        @Test
        @DisplayName("5 accesses - Various windows")
        void testFiveAccesses() {
            String[] keyName = {"alice", "alice", "alice", "alice", "alice"};
            String[] keyTime = {"09:00", "09:30", "10:00", "10:15", "10:30"};

            List<String> expected = Arrays.asList("alice");
            List<String> result = solution.alertNames(keyName, keyTime);

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Large input - 1000 accesses, single worker with alerts")
        void testLargeInputSingleWorker() {
            int n = 1000;
            String[] keyName = new String[n];
            String[] keyTime = new String[n];

            Arrays.fill(keyName, "worker");

            // Create times: 00:00, 00:01, 00:02, ...
            for (int i = 0; i < n; i++) {
                int hours = i / 60;
                int minutes = i % 60;
                keyTime[i] = String.format("%02d:%02d", hours, minutes);
            }

            List<String> result = solution.alertNames(keyName, keyTime);

            assertEquals(1, result.size());
            assertEquals("worker", result.get(0));
        }

        @Test
        @DisplayName("Large input - 100 workers, each with 10 accesses")
        void testLargeInputMultipleWorkers() {
            int workers = 100;
            int accessesPerWorker = 10;
            int total = workers * accessesPerWorker;

            String[] keyName = new String[total];
            String[] keyTime = new String[total];

            int idx = 0;
            for (int w = 0; w < workers; w++) {
                String worker = "worker" + w;
                for (int a = 0; a < accessesPerWorker; a++) {
                    keyName[idx] = worker;
                    // All within 1 hour: 10:00, 10:06, 10:12, ...
                    int minutes = 10 * 60 + a * 6;
                    keyTime[idx] = String.format("%02d:%02d", minutes / 60, minutes % 60);
                    idx++;
                }
            }

            List<String> result = solution.alertNames(keyName, keyTime);

            // All workers should trigger alerts
            assertEquals(workers, result.size());
        }

        @Test
        @DisplayName("Large input - No alerts")
        void testLargeInputNoAlerts() {
            int n = 1000;
            String[] keyName = new String[n];
            String[] keyTime = new String[n];

            // Each worker appears only twice
            for (int i = 0; i < n; i++) {
                keyName[i] = "worker" + (i / 2);
                int minutes = i * 5;
                keyTime[i] = String.format("%02d:%02d", (minutes / 60) % 24, minutes % 60);
            }

            List<String> result = solution.alertNames(keyName, keyTime);

            assertEquals(0, result.size());
        }
    }

    @Nested
    @DisplayName("Cross Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @Test
        @DisplayName("All approaches give same result - Example 1")
        void testAllApproachesExample1() {
            String[] keyName = {"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"};
            String[] keyTime = {"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"};

            List<String> result1 = solution.alertNames(keyName, keyTime);
            List<String> result2 = solution.alertNamesTreeMap(keyName, keyTime);
            List<String> result3 = solution.alertNamesOptimized(keyName, keyTime);
            List<String> result4 = solution.alertNamesStream(keyName, keyTime);

            assertEquals(result1, result2);
            assertEquals(result1, result3);
            assertEquals(result1, result4);
        }

        @Test
        @DisplayName("All approaches give same result - Multiple workers")
        void testAllApproachesMultipleWorkers() {
            String[] keyName =
                    {"alice", "alice", "alice", "bob", "bob", "charlie", "charlie", "charlie"};
            String[] keyTime =
                    {"10:00", "10:30", "11:00", "14:00", "16:00", "09:00", "09:15", "09:30"};

            List<String> result1 = solution.alertNames(keyName, keyTime);
            List<String> result2 = solution.alertNamesTreeMap(keyName, keyTime);
            List<String> result3 = solution.alertNamesOptimized(keyName, keyTime);
            List<String> result4 = solution.alertNamesStream(keyName, keyTime);

            assertEquals(result1, result2);
            assertEquals(result1, result3);
            assertEquals(result1, result4);
        }

        @Test
        @DisplayName("All approaches give same result - Edge cases")
        void testAllApproachesEdgeCases() {
            String[] keyName = {"alice", "alice", "alice"};
            String[] keyTime = {"10:00", "10:30", "11:01"};

            List<String> result1 = solution.alertNames(keyName, keyTime);
            List<String> result2 = solution.alertNamesTreeMap(keyName, keyTime);
            List<String> result3 = solution.alertNamesOptimized(keyName, keyTime);
            List<String> result4 = solution.alertNamesStream(keyName, keyTime);

            assertEquals(result1, result2);
            assertEquals(result1, result3);
            assertEquals(result1, result4);
        }
    }

    @Nested
    @DisplayName("Utility Methods Tests")
    class UtilityMethodsTests {

        @Test
        @DisplayName("getAlertDetails - Returns correct alert window")
        void testGetAlertDetails() {
            String[] keyName = {"alice", "alice", "alice", "alice"};
            String[] keyTime = {"10:00", "10:30", "11:00", "12:00"};

            Map<String, List<String>> details = solution.getAlertDetails(keyName, keyTime);

            assertTrue(details.containsKey("alice"));
            List<String> window = details.get("alice");
            assertEquals(3, window.size());
            assertTrue(window.contains("10:00"));
            assertTrue(window.contains("10:30"));
            assertTrue(window.contains("11:00"));
        }

        @Test
        @DisplayName("getAlertDetails - No alerts")
        void testGetAlertDetailsNoAlert() {
            String[] keyName = {"alice", "alice"};
            String[] keyTime = {"10:00", "12:00"};

            Map<String, List<String>> details = solution.getAlertDetails(keyName, keyTime);

            assertFalse(details.containsKey("alice"));
            assertEquals(0, details.size());
        }

        @Test
        @DisplayName("printAccessPattern - No exceptions")
        void testPrintAccessPattern() {
            String[] keyName = {"alice", "alice", "bob", "bob"};
            String[] keyTime = {"10:00", "11:00", "12:00", "13:00"};

            assertDoesNotThrow(() -> solution.printAccessPattern(keyName, keyTime));
        }
    }

    @Nested
    @DisplayName("Complex Scenarios Tests")
    class ComplexScenariosTests {

        @Test
        @DisplayName("Real-world scenario - Office building")
        void testRealWorldScenario() {
            String[] keyName = {"employee1", "employee1", "employee1", "employee1", "employee2",
                    "employee2", "employee2", "employee3", "employee3", "employee3", "employee3",
                    "employee3", "employee4", "employee4"};
            String[] keyTime = {"08:00", "08:30", "09:00", "17:00", // employee1 - alert (3 in 60
                                                                    // min)
                    "09:00", "12:00", "15:00", // employee2 - no alert
                    "10:00", "10:15", "10:30", "10:45", "11:00", // employee3 - alert
                    "14:00", "16:00" // employee4 - no alert
            };

            List<String> result = solution.alertNames(keyName, keyTime);

            List<String> expected = Arrays.asList("employee1", "employee3");
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Suspicious activity - Rapid consecutive accesses")
        void testSuspiciousActivity() {
            String[] keyName = {"suspect", "suspect", "suspect", "suspect", "suspect"};
            String[] keyTime = {"02:00", "02:05", "02:10", "02:15", "02:20"};

            List<String> result = solution.alertNames(keyName, keyTime);

            assertEquals(1, result.size());
            assertEquals("suspect", result.get(0));
        }

        @Test
        @DisplayName("Mixed time zones simulation")
        void testMixedPatterns() {
            String[] keyName =
                    {"nightshift", "nightshift", "nightshift", "dayshift", "dayshift", "dayshift"};
            String[] keyTime = {"00:00", "00:30", "01:00", "09:00", "09:30", "10:00"};

            List<String> result = solution.alertNames(keyName, keyTime);

            assertEquals(2, result.size());
            assertTrue(result.contains("dayshift"));
            assertTrue(result.contains("nightshift"));
        }
    }
}

