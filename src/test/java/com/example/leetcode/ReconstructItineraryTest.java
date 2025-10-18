package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Comprehensive test suite for LeetCode 332: Reconstruct Itinerary
 * 
 * Test Categories: 1. LeetCode Examples Tests - Official test cases from LeetCode 2. Basic
 * Functionality Tests - Core functionality validation 3. Edge Cases Tests - Boundary conditions and
 * special scenarios 4. Lexical Ordering Tests - Verify smallest lexical order 5. Circular Route
 * Tests - Test with circular paths 6. Complex Graph Tests - Multiple paths and dead ends 7.
 * Performance Tests - Large input handling 8. Cross-Approach Comparison - Verify all approaches
 * return same result 9. Utility Methods Tests - Test helper methods 10. Stress Tests - Extreme
 * scenarios
 */
@DisplayName("LeetCode 332: Reconstruct Itinerary - Comprehensive Test Suite")
class ReconstructItineraryTest {

    private ReconstructItinerary solution;

    @BeforeEach
    void setUp() {
        solution = new ReconstructItinerary();
    }

    // ========================================
    // LEETCODE EXAMPLES TESTS
    // ========================================

    @Nested
    @DisplayName("LeetCode Examples Tests")
    class LeetCodeExamplesTests {

        @Test
        @DisplayName("Example 1: Linear path")
        void testExample1() {
            List<List<String>> tickets =
                    Arrays.asList(Arrays.asList("MUC", "LHR"), Arrays.asList("JFK", "MUC"),
                            Arrays.asList("SFO", "SJC"), Arrays.asList("LHR", "SFO"));

            List<String> expected = Arrays.asList("JFK", "MUC", "LHR", "SFO", "SJC");
            List<String> result = solution.findItinerary(tickets);

            assertEquals(expected, result);
            assertTrue(solution.isValidItinerary(tickets, result));
        }

        @Test
        @DisplayName("Example 2: Multiple valid paths - choose lexically smallest")
        void testExample2() {
            List<List<String>> tickets = Arrays.asList(Arrays.asList("JFK", "SFO"),
                    Arrays.asList("JFK", "ATL"), Arrays.asList("SFO", "ATL"),
                    Arrays.asList("ATL", "JFK"), Arrays.asList("ATL", "SFO"));

            List<String> expected = Arrays.asList("JFK", "ATL", "JFK", "SFO", "ATL", "SFO");
            List<String> result = solution.findItinerary(tickets);

            assertEquals(expected, result);
            assertTrue(solution.isValidItinerary(tickets, result));
        }

        @Test
        @DisplayName("Example 3: Simple round trip")
        void testExample3() {
            List<List<String>> tickets =
                    Arrays.asList(Arrays.asList("JFK", "KUL"), Arrays.asList("KUL", "JFK"));

            List<String> expected = Arrays.asList("JFK", "KUL", "JFK");
            List<String> result = solution.findItinerary(tickets);

            assertEquals(expected, result);
            assertTrue(solution.isValidItinerary(tickets, result));
        }
    }

    // ========================================
    // BASIC FUNCTIONALITY TESTS
    // ========================================

    @Nested
    @DisplayName("Basic Functionality Tests")
    class BasicFunctionalityTests {

        @Test
        @DisplayName("Single ticket from JFK")
        void testSingleTicket() {
            List<List<String>> tickets = Arrays.asList(Arrays.asList("JFK", "LAX"));

            List<String> expected = Arrays.asList("JFK", "LAX");
            List<String> result = solution.findItinerary(tickets);

            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Two tickets in sequence")
        void testTwoTicketsSequence() {
            List<List<String>> tickets =
                    Arrays.asList(Arrays.asList("JFK", "ATL"), Arrays.asList("ATL", "SFO"));

            List<String> expected = Arrays.asList("JFK", "ATL", "SFO");
            List<String> result = solution.findItinerary(tickets);

            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Three tickets forming simple path")
        void testThreeTicketsPath() {
            List<List<String>> tickets = Arrays.asList(Arrays.asList("JFK", "A"),
                    Arrays.asList("A", "B"), Arrays.asList("B", "C"));

            List<String> expected = Arrays.asList("JFK", "A", "B", "C");
            List<String> result = solution.findItinerary(tickets);

            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Result starts with JFK")
        void testStartsWithJFK() {
            List<List<String>> tickets =
                    Arrays.asList(Arrays.asList("JFK", "ATL"), Arrays.asList("ATL", "JFK"));

            List<String> result = solution.findItinerary(tickets);

            assertEquals("JFK", result.get(0));
        }

        @Test
        @DisplayName("All tickets are used")
        void testAllTicketsUsed() {
            List<List<String>> tickets = Arrays.asList(Arrays.asList("JFK", "A"),
                    Arrays.asList("A", "B"), Arrays.asList("B", "C"), Arrays.asList("C", "D"));

            List<String> result = solution.findItinerary(tickets);

            // Should have n+1 airports for n tickets
            assertEquals(tickets.size() + 1, result.size());
        }
    }

    // ========================================
    // EDGE CASES TESTS
    // ========================================

    @Nested
    @DisplayName("Edge Cases Tests")
    class EdgeCasesTests {

        @Test
        @DisplayName("Multiple tickets between same airports")
        void testMultipleTicketsSameRoute() {
            List<List<String>> tickets = Arrays.asList(Arrays.asList("JFK", "ATL"),
                    Arrays.asList("JFK", "ATL"), Arrays.asList("ATL", "JFK"));

            List<String> result = solution.findItinerary(tickets);

            assertEquals(4, result.size());
            assertTrue(solution.isValidItinerary(tickets, result));
        }

        @Test
        @DisplayName("Requires backtracking - dead end first")
        void testBacktrackingRequired() {
            List<List<String>> tickets = Arrays.asList(Arrays.asList("JFK", "A"),
                    Arrays.asList("JFK", "B"), Arrays.asList("B", "JFK"));

            List<String> expected = Arrays.asList("JFK", "A"); // Wait, this needs reconsideration
            List<String> result = solution.findItinerary(tickets);

            // The correct answer should use all tickets
            assertEquals(4, result.size());
            assertTrue(solution.isValidItinerary(tickets, result));
        }

        @Test
        @DisplayName("Graph with multiple branches")
        void testMultipleBranches() {
            List<List<String>> tickets = Arrays.asList(Arrays.asList("JFK", "A"),
                    Arrays.asList("JFK", "B"), Arrays.asList("JFK", "C"), Arrays.asList("A", "D"),
                    Arrays.asList("B", "D"), Arrays.asList("C", "D"), Arrays.asList("D", "E"));

            List<String> result = solution.findItinerary(tickets);

            assertEquals(8, result.size());
            assertEquals("JFK", result.get(0));
            assertEquals("E", result.get(result.size() - 1));
        }

        @Test
        @DisplayName("Self loop ticket")
        void testSelfLoop() {
            List<List<String>> tickets = Arrays.asList(Arrays.asList("JFK", "JFK"));

            List<String> expected = Arrays.asList("JFK", "JFK");
            List<String> result = solution.findItinerary(tickets);

            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Multiple self loops")
        void testMultipleSelfLoops() {
            List<List<String>> tickets = Arrays.asList(Arrays.asList("JFK", "JFK"),
                    Arrays.asList("JFK", "JFK"), Arrays.asList("JFK", "A"));

            List<String> result = solution.findItinerary(tickets);

            assertEquals(4, result.size());
            assertTrue(solution.isValidItinerary(tickets, result));
        }
    }

    // ========================================
    // LEXICAL ORDERING TESTS
    // ========================================

    @Nested
    @DisplayName("Lexical Ordering Tests")
    class LexicalOrderingTests {

        @Test
        @DisplayName("Choose lexically smaller destination")
        void testLexicalChoice() {
            // Create valid Eulerian path: JFK->A->JFK->B
            List<List<String>> tickets = Arrays.asList(Arrays.asList("JFK", "B"),
                    Arrays.asList("JFK", "A"), Arrays.asList("A", "JFK"));

            List<String> result = solution.findItinerary(tickets);

            // Should go JFK -> A first (lexically smaller), then JFK -> B
            List<String> expected = Arrays.asList("JFK", "A", "JFK", "B");
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Lexical ordering with many choices")
        void testMultipleLexicalChoices() {
            // Create valid Eulerian path with lexical ordering
            List<List<String>> tickets = Arrays.asList(Arrays.asList("JFK", "D"),
                    Arrays.asList("JFK", "C"), Arrays.asList("JFK", "B"), Arrays.asList("JFK", "A"),
                    Arrays.asList("A", "JFK"), Arrays.asList("B", "JFK"), Arrays.asList("C", "JFK"),
                    Arrays.asList("D", "END"));

            List<String> result = solution.findItinerary(tickets);

            // Should visit in lexical order: A, then B, then C, then D
            assertEquals("JFK", result.get(0));
            assertEquals("A", result.get(1));
            assertEquals("JFK", result.get(2));
        }

        @Test
        @DisplayName("Lexical ordering matters for final result")
        void testLexicalFinalOrder() {
            // Valid Eulerian path: JFK->ATL->JFK->SFO
            List<List<String>> tickets = Arrays.asList(Arrays.asList("JFK", "ATL"),
                    Arrays.asList("JFK", "SFO"), Arrays.asList("ATL", "JFK"));

            List<String> result = solution.findItinerary(tickets);

            // Should choose ATL first (lexically smaller than SFO)
            assertEquals("ATL", result.get(1));
            List<String> expected = Arrays.asList("JFK", "ATL", "JFK", "SFO");
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Compare similar airport codes")
        void testSimilarAirportCodes() {
            // Valid Eulerian path
            List<List<String>> tickets =
                    Arrays.asList(Arrays.asList("JFK", "LAX"), Arrays.asList("JFK", "LAA"),
                            Arrays.asList("LAA", "JFK"), Arrays.asList("LAX", "END"));

            List<String> result = solution.findItinerary(tickets);

            // Should choose LAA first (LAA < LAX lexically)
            List<String> expected = Arrays.asList("JFK", "LAA", "JFK", "LAX", "END");
            assertEquals(expected, result);
        }
    }

    // ========================================
    // CIRCULAR ROUTE TESTS
    // ========================================

    @Nested
    @DisplayName("Circular Route Tests")
    class CircularRouteTests {

        @Test
        @DisplayName("Simple circular route")
        void testSimpleCircle() {
            List<List<String>> tickets = Arrays.asList(Arrays.asList("JFK", "A"),
                    Arrays.asList("A", "B"), Arrays.asList("B", "C"), Arrays.asList("C", "JFK"));

            List<String> expected = Arrays.asList("JFK", "A", "B", "C", "JFK");
            List<String> result = solution.findItinerary(tickets);

            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Multiple circles")
        void testMultipleCircles() {
            List<List<String>> tickets =
                    Arrays.asList(Arrays.asList("JFK", "A"), Arrays.asList("A", "JFK"),
                            Arrays.asList("JFK", "B"), Arrays.asList("B", "JFK"));

            List<String> result = solution.findItinerary(tickets);

            assertEquals(5, result.size());
            assertEquals("JFK", result.get(0));
            assertEquals("JFK", result.get(result.size() - 1));
        }

        @Test
        @DisplayName("Nested circles")
        void testNestedCircles() {
            List<List<String>> tickets = Arrays.asList(Arrays.asList("JFK", "A"),
                    Arrays.asList("A", "B"), Arrays.asList("B", "A"), Arrays.asList("A", "JFK"));

            List<String> result = solution.findItinerary(tickets);

            assertEquals(5, result.size());
            assertTrue(solution.isValidItinerary(tickets, result));
        }

        @Test
        @DisplayName("Eulerian circuit")
        void testEulerianCircuit() {
            List<List<String>> tickets = Arrays.asList(Arrays.asList("JFK", "A"),
                    Arrays.asList("A", "B"), Arrays.asList("B", "C"), Arrays.asList("C", "A"),
                    Arrays.asList("A", "D"), Arrays.asList("D", "JFK"));

            List<String> result = solution.findItinerary(tickets);

            assertEquals(7, result.size());
            assertEquals("JFK", result.get(0));
            assertEquals("JFK", result.get(result.size() - 1));
        }
    }

    // ========================================
    // COMPLEX GRAPH TESTS
    // ========================================

    @Nested
    @DisplayName("Complex Graph Tests")
    class ComplexGraphTests {

        @Test
        @DisplayName("Large connected graph")
        void testLargeConnectedGraph() {
            List<List<String>> tickets = new ArrayList<>();
            // Create a chain: JFK -> A -> B -> ... -> Z
            tickets.add(Arrays.asList("JFK", "A"));
            char prev = 'A';
            for (char c = 'B'; c <= 'Z'; c++) {
                tickets.add(Arrays.asList(String.valueOf(prev), String.valueOf(c)));
                prev = c;
            }

            List<String> result = solution.findItinerary(tickets);

            assertEquals(27, result.size()); // 26 tickets + 1
            assertEquals("JFK", result.get(0));
            assertEquals("Z", result.get(result.size() - 1));
        }

        @Test
        @DisplayName("Graph with multiple valid Eulerian paths")
        void testMultipleEulerianPaths() {
            List<List<String>> tickets =
                    Arrays.asList(Arrays.asList("JFK", "AAA"), Arrays.asList("JFK", "BBB"),
                            Arrays.asList("AAA", "JFK"), Arrays.asList("BBB", "JFK"));

            List<String> result = solution.findItinerary(tickets);

            // Should choose AAA path first (lexically smaller)
            assertEquals(Arrays.asList("JFK", "AAA", "JFK", "BBB", "JFK"), result);
        }

        @Test
        @DisplayName("Dense graph with many edges")
        void testDenseGraph() {
            List<List<String>> tickets = Arrays.asList(Arrays.asList("JFK", "A"),
                    Arrays.asList("JFK", "B"), Arrays.asList("A", "JFK"), Arrays.asList("B", "JFK"),
                    Arrays.asList("JFK", "C"), Arrays.asList("C", "JFK"));

            List<String> result = solution.findItinerary(tickets);

            assertEquals(7, result.size());
            assertTrue(solution.isValidItinerary(tickets, result));
        }

        @Test
        @DisplayName("Graph requiring careful ordering")
        void testCarefulOrdering() {
            // Classic test case that requires Hierholzer's algorithm
            List<List<String>> tickets = Arrays.asList(Arrays.asList("JFK", "KUL"),
                    Arrays.asList("JFK", "NRT"), Arrays.asList("NRT", "JFK"));

            List<String> result = solution.findItinerary(tickets);

            // Must go JFK -> NRT -> JFK -> KUL (not JFK -> KUL -> dead end)
            List<String> expected = Arrays.asList("JFK", "NRT", "JFK", "KUL");
            assertEquals(expected, result);
        }
    }

    // ========================================
    // PERFORMANCE TESTS
    // ========================================

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Large number of tickets (100)")
        @Timeout(value = 2)
        void testLargeInput100() {
            List<List<String>> tickets = new ArrayList<>();

            // Create linear path
            tickets.add(Arrays.asList("JFK", "A0"));
            for (int i = 0; i < 99; i++) {
                tickets.add(Arrays.asList("A" + i, "A" + (i + 1)));
            }

            List<String> result = solution.findItinerary(tickets);

            assertEquals(101, result.size());
            assertEquals("JFK", result.get(0));
        }

        @Test
        @DisplayName("Many duplicate routes")
        @Timeout(value = 2)
        void testManyDuplicateRoutes() {
            List<List<String>> tickets = new ArrayList<>();

            // Add many JFK -> ATL tickets
            for (int i = 0; i < 50; i++) {
                tickets.add(Arrays.asList("JFK", "ATL"));
            }

            // Add return path
            for (int i = 0; i < 49; i++) {
                tickets.add(Arrays.asList("ATL", "JFK"));
            }

            tickets.add(Arrays.asList("ATL", "END"));

            List<String> result = solution.findItinerary(tickets);

            assertEquals(101, result.size());
            assertEquals("END", result.get(result.size() - 1));
        }

        @Test
        @DisplayName("Wide branching factor")
        @Timeout(value = 2)
        void testWideBranching() {
            List<List<String>> tickets = new ArrayList<>();

            // Create 50 destinations from JFK, all leading to END
            for (int i = 0; i < 49; i++) {
                tickets.add(Arrays.asList("JFK", "DEST" + String.format("%02d", i)));
                tickets.add(Arrays.asList("DEST" + String.format("%02d", i), "JFK"));
            }
            // Last one goes to END
            tickets.add(Arrays.asList("JFK", "DEST49"));
            tickets.add(Arrays.asList("DEST49", "END"));

            List<String> result = solution.findItinerary(tickets);

            assertEquals(101, result.size());
            assertEquals("DEST00", result.get(1)); // Should choose lexically first
        }
    }

    // ========================================
    // CROSS-APPROACH COMPARISON TESTS
    // ========================================

    @Nested
    @DisplayName("Cross-Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @ParameterizedTest(name = "Test case {index}: {0}")
        @MethodSource("provideTestCases")
        @DisplayName("All approaches return same result")
        void testAllApproachesSameResult(String description, List<List<String>> tickets) {
            List<String> result1 = solution.findItinerary(tickets);
            List<String> result2 = solution.findItineraryIterative(tickets);
            List<String> result3 = solution.findItineraryBacktracking(tickets);

            assertEquals(result1, result2, "Approach 1 and 2 differ");
            assertEquals(result1, result3, "Approach 1 and 3 differ");
            assertTrue(solution.isValidItinerary(tickets, result1));
        }

        private static Stream<Arguments> provideTestCases() {
            return Stream.of(
                    Arguments.of("Simple path",
                            Arrays.asList(Arrays.asList("JFK", "ATL"),
                                    Arrays.asList("ATL", "SFO"))),
                    Arguments.of("Round trip",
                            Arrays.asList(Arrays.asList("JFK", "ATL"),
                                    Arrays.asList("ATL", "JFK"))),
                    Arguments.of("Multiple choices",
                            Arrays.asList(Arrays.asList("JFK", "B"), Arrays.asList("JFK", "A"),
                                    Arrays.asList("A", "JFK"), Arrays.asList("B", "JFK"))),
                    Arguments.of("Complex graph",
                            Arrays.asList(Arrays.asList("JFK", "SFO"), Arrays.asList("JFK", "ATL"),
                                    Arrays.asList("SFO", "ATL"), Arrays.asList("ATL", "JFK"),
                                    Arrays.asList("ATL", "SFO"))));
        }
    }

    // ========================================
    // UTILITY METHODS TESTS
    // ========================================

    @Nested
    @DisplayName("Utility Methods Tests")
    class UtilityMethodsTests {

        @Test
        @DisplayName("isValidItinerary - valid itinerary")
        void testIsValidItineraryValid() {
            List<List<String>> tickets =
                    Arrays.asList(Arrays.asList("JFK", "ATL"), Arrays.asList("ATL", "SFO"));

            List<String> itinerary = Arrays.asList("JFK", "ATL", "SFO");

            assertTrue(solution.isValidItinerary(tickets, itinerary));
        }

        @Test
        @DisplayName("isValidItinerary - doesn't start with JFK")
        void testIsValidItineraryNotJFK() {
            List<List<String>> tickets = Arrays.asList(Arrays.asList("JFK", "ATL"));

            List<String> itinerary = Arrays.asList("ATL", "JFK");

            assertFalse(solution.isValidItinerary(tickets, itinerary));
        }

        @Test
        @DisplayName("isValidItinerary - wrong number of stops")
        void testIsValidItineraryWrongSize() {
            List<List<String>> tickets =
                    Arrays.asList(Arrays.asList("JFK", "ATL"), Arrays.asList("ATL", "SFO"));

            List<String> itinerary = Arrays.asList("JFK", "ATL");

            assertFalse(solution.isValidItinerary(tickets, itinerary));
        }

        @Test
        @DisplayName("compareItineraries - first is smaller")
        void testCompareItinerariesFirstSmaller() {
            List<String> itin1 = Arrays.asList("JFK", "ATL", "SFO");
            List<String> itin2 = Arrays.asList("JFK", "SFO", "ATL");

            assertTrue(solution.compareItineraries(itin1, itin2) < 0);
        }

        @Test
        @DisplayName("compareItineraries - equal")
        void testCompareItinerariesEqual() {
            List<String> itin1 = Arrays.asList("JFK", "ATL", "SFO");
            List<String> itin2 = Arrays.asList("JFK", "ATL", "SFO");

            assertEquals(0, solution.compareItineraries(itin1, itin2));
        }

        @Test
        @DisplayName("compareItineraries - second is smaller")
        void testCompareItinerariesSecondSmaller() {
            List<String> itin1 = Arrays.asList("JFK", "SFO", "ATL");
            List<String> itin2 = Arrays.asList("JFK", "ATL", "SFO");

            assertTrue(solution.compareItineraries(itin1, itin2) > 0);
        }

        @Test
        @DisplayName("getComplexityAnalysis returns info for all approaches")
        void testGetComplexityAnalysis() {
            assertNotNull(solution.getComplexityAnalysis(1));
            assertNotNull(solution.getComplexityAnalysis(2));
            assertNotNull(solution.getComplexityAnalysis(3));
            assertTrue(solution.getComplexityAnalysis(1).contains("O(E"));
        }

        @Test
        @DisplayName("getApproachName returns correct names")
        void testGetApproachName() {
            assertTrue(solution.getApproachName(1).contains("Hierholzer"));
            assertTrue(solution.getApproachName(2).contains("Iterative"));
            assertTrue(solution.getApproachName(3).contains("Backtracking"));
        }

        @Test
        @DisplayName("findItineraryFromArray works correctly")
        void testFindItineraryFromArray() {
            String[][] tickets = {{"JFK", "ATL"}, {"ATL", "SFO"}};

            List<String> result = solution.findItineraryFromArray(tickets);

            assertEquals(Arrays.asList("JFK", "ATL", "SFO"), result);
        }
    }

    // ========================================
    // STRESS TESTS
    // ========================================

    @Nested
    @DisplayName("Stress Tests")
    class StressTests {

        @Test
        @DisplayName("Maximum tickets (300)")
        @Timeout(value = 5)
        void testMaximumTickets() {
            List<List<String>> tickets = new ArrayList<>();

            // Create a valid Eulerian path with 300 tickets
            tickets.add(Arrays.asList("JFK", "A"));
            for (int i = 0; i < 299; i++) {
                tickets.add(Arrays.asList("A", "A"));
            }

            List<String> result = solution.findItinerary(tickets);

            assertEquals(301, result.size());
            assertTrue(solution.isValidItinerary(tickets, result));
        }

        @Test
        @DisplayName("Maximum lexical sorting required")
        @Timeout(value = 3)
        void testMaximumLexicalSorting() {
            List<List<String>> tickets = new ArrayList<>();

            // Create many choices from JFK, testing that priority queue sorts them
            // All return to JFK except the last alphabetically chosen one
            for (int i = 25; i >= 1; i--) {
                char c = (char) ('A' + i);
                // Add in reverse order to test priority queue sorting
                tickets.add(Arrays.asList("JFK", String.valueOf(c)));
                tickets.add(Arrays.asList(String.valueOf(c), "JFK"));
            }
            // 'A' and 'Z' have special paths
            tickets.add(Arrays.asList("JFK", "A"));
            tickets.add(Arrays.asList("A", "Z"));
            tickets.add(Arrays.asList("Z", "END"));

            List<String> result = solution.findItinerary(tickets);

            // Hierholzer's algorithm should process lexically: visit A's branch last (dead-end)
            // So circular paths (B-Z returning to JFK) are processed, then A->Z->END
            assertEquals("JFK", result.get(0));
            assertEquals("END", result.get(result.size() - 1));
            // Verify correct length
            assertEquals(54, result.size()); // 26 round trips + A->Z->END = 52+2 = 54 airports
        }

        @Test
        @DisplayName("Deep recursion path")
        @Timeout(value = 3)
        void testDeepRecursion() {
            List<List<String>> tickets = new ArrayList<>();

            // Create deep linear path
            tickets.add(Arrays.asList("JFK", "L0"));
            for (int i = 0; i < 200; i++) {
                tickets.add(Arrays.asList("L" + i, "L" + (i + 1)));
            }

            List<String> result = solution.findItinerary(tickets);

            assertEquals(202, result.size());
            assertEquals("JFK", result.get(0));
            assertEquals("L200", result.get(result.size() - 1));
        }

        @Test
        @DisplayName("All same airport pairs")
        void testAllSameAirportPairs() {
            List<List<String>> tickets = new ArrayList<>();

            // 100 tickets: 99 round trips JFK<->ATL, then JFK->ATL->END
            for (int i = 0; i < 99; i++) {
                tickets.add(Arrays.asList("JFK", "ATL"));
                tickets.add(Arrays.asList("ATL", "JFK"));
            }
            tickets.add(Arrays.asList("JFK", "ATL"));
            tickets.add(Arrays.asList("ATL", "END"));

            List<String> result = solution.findItinerary(tickets);

            assertEquals(201, result.size());
            assertEquals("JFK", result.get(0));
            assertEquals("END", result.get(result.size() - 1));
        }
    }

    // ========================================
    // PARAMETERIZED TESTS
    // ========================================

    @Nested
    @DisplayName("Parameterized Tests")
    class ParameterizedTests {

        @ParameterizedTest(name = "Approach {0}: {1}")
        @MethodSource("provideApproachTests")
        @DisplayName("Each approach handles basic cases")
        void testEachApproach(int approach, String name, List<List<String>> tickets,
                List<String> expected) {
            List<String> result = solution.executeApproach(approach, tickets);
            assertEquals(expected, result);
        }

        private static Stream<Arguments> provideApproachTests() {
            List<List<String>> simpleTickets =
                    Arrays.asList(Arrays.asList("JFK", "ATL"), Arrays.asList("ATL", "SFO"));
            List<String> simpleExpected = Arrays.asList("JFK", "ATL", "SFO");

            return Stream.of(Arguments.of(1, "Hierholzer's DFS", simpleTickets, simpleExpected),
                    Arguments.of(2, "Iterative", simpleTickets, simpleExpected),
                    Arguments.of(3, "Backtracking", simpleTickets, simpleExpected));
        }
    }
}

