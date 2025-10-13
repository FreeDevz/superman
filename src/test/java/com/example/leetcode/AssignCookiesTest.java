package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Random;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Comprehensive test suite for AssignCookies (LeetCode 455)
 * 
 * Test Categories: 1. LeetCode Examples - Official test cases 2. Edge Cases - Empty arrays, single
 * elements, etc. 3. Boundary Tests - Large values, constraints 4. Pattern Tests - Special patterns
 * in input 5. Greedy Forward Tests - Test forward two-pointer approach 6. Greedy Reverse Tests -
 * Test reverse two-pointer approach 7. Binary Search Tests - Test binary search approach 8. Brute
 * Force Tests - Test backtracking approach (small inputs) 9. Counting Sort Tests - Test counting
 * sort optimization 10. Cross Approach Comparison - Verify all approaches give same result 11.
 * Performance Tests - Test with large inputs 12. Utility Methods Tests - Test helper methods
 */
class AssignCookiesTest {

    private AssignCookies solution;

    @BeforeEach
    void setUp() {
        solution = new AssignCookies();
    }

    @Nested
    @DisplayName("LeetCode Examples")
    class LeetCodeExamplesTests {

        @Test
        @DisplayName("Example 1: More children than cookies")
        void testExample1() {
            int[] g = {1, 2, 3};
            int[] s = {1, 1};
            assertEquals(1, solution.findContentChildren(g, s));
        }

        @Test
        @DisplayName("Example 2: More cookies than children")
        void testExample2() {
            int[] g = {1, 2};
            int[] s = {1, 2, 3};
            assertEquals(2, solution.findContentChildren(g, s));
        }
    }

    @Nested
    @DisplayName("Edge Cases")
    class EdgeCasesTests {

        @Test
        @DisplayName("Empty children array")
        void testEmptyChildren() {
            int[] g = {};
            int[] s = {1, 2, 3};
            assertEquals(0, solution.findContentChildren(g, s));
        }

        @Test
        @DisplayName("Empty cookies array")
        void testEmptyCookies() {
            int[] g = {1, 2, 3};
            int[] s = {};
            assertEquals(0, solution.findContentChildren(g, s));
        }

        @Test
        @DisplayName("Both arrays empty")
        void testBothEmpty() {
            int[] g = {};
            int[] s = {};
            assertEquals(0, solution.findContentChildren(g, s));
        }

        @Test
        @DisplayName("Single child, single cookie - satisfied")
        void testSingleSatisfied() {
            int[] g = {1};
            int[] s = {1};
            assertEquals(1, solution.findContentChildren(g, s));
        }

        @Test
        @DisplayName("Single child, single cookie - not satisfied")
        void testSingleNotSatisfied() {
            int[] g = {2};
            int[] s = {1};
            assertEquals(0, solution.findContentChildren(g, s));
        }

        @Test
        @DisplayName("Single child, multiple cookies")
        void testSingleChildMultipleCookies() {
            int[] g = {5};
            int[] s = {1, 2, 3, 4, 5};
            assertEquals(1, solution.findContentChildren(g, s));
        }

        @Test
        @DisplayName("Multiple children, single cookie")
        void testMultipleChildrenSingleCookie() {
            int[] g = {1, 2, 3, 4, 5};
            int[] s = {3};
            assertEquals(1, solution.findContentChildren(g, s));
        }
    }

    @Nested
    @DisplayName("Boundary Tests")
    class BoundaryTests {

        @Test
        @DisplayName("All children have greed factor 1")
        void testAllGreedOne() {
            int[] g = {1, 1, 1, 1, 1};
            int[] s = {1, 1, 1};
            assertEquals(3, solution.findContentChildren(g, s));
        }

        @Test
        @DisplayName("All cookies same size")
        void testAllCookiesSameSize() {
            int[] g = {1, 2, 3, 4, 5};
            int[] s = {3, 3, 3, 3};
            assertEquals(3, solution.findContentChildren(g, s));
        }

        @Test
        @DisplayName("All children identical, all cookies identical - satisfied")
        void testAllIdenticalSatisfied() {
            int[] g = {2, 2, 2};
            int[] s = {2, 2, 2, 2};
            assertEquals(3, solution.findContentChildren(g, s));
        }

        @Test
        @DisplayName("All children identical, all cookies identical - not satisfied")
        void testAllIdenticalNotSatisfied() {
            int[] g = {3, 3, 3};
            int[] s = {2, 2, 2, 2};
            assertEquals(0, solution.findContentChildren(g, s));
        }

        @Test
        @DisplayName("Large values near Integer.MAX_VALUE")
        void testLargeValues() {
            int[] g = {Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 2};
            int[] s = {Integer.MAX_VALUE - 1, Integer.MAX_VALUE};
            assertEquals(2, solution.findContentChildren(g, s));
        }

        @Test
        @DisplayName("Minimum greed factors (all 1)")
        void testMinimumGreed() {
            int[] g = {1, 1, 1, 1};
            int[] s = {1, 2, 3};
            assertEquals(3, solution.findContentChildren(g, s));
        }
    }

    @Nested
    @DisplayName("Pattern Tests")
    class PatternTests {

        @Test
        @DisplayName("All children can be satisfied")
        void testAllSatisfied() {
            int[] g = {1, 2, 3};
            int[] s = {1, 2, 3};
            assertEquals(3, solution.findContentChildren(g, s));
        }

        @Test
        @DisplayName("No children can be satisfied")
        void testNoneSatisfied() {
            int[] g = {5, 6, 7, 8};
            int[] s = {1, 2, 3, 4};
            assertEquals(0, solution.findContentChildren(g, s));
        }

        @Test
        @DisplayName("Ascending greed factors, descending cookie sizes")
        void testAscendingDescending() {
            int[] g = {1, 2, 3, 4, 5};
            int[] s = {5, 4, 3, 2, 1};
            assertEquals(5, solution.findContentChildren(g, s));
        }

        @Test
        @DisplayName("Descending greed factors, ascending cookie sizes")
        void testDescendingAscending() {
            int[] g = {5, 4, 3, 2, 1};
            int[] s = {1, 2, 3, 4, 5};
            assertEquals(5, solution.findContentChildren(g, s));
        }

        @Test
        @DisplayName("Random unsorted arrays")
        void testUnsortedArrays() {
            int[] g = {10, 9, 8, 7};
            int[] s = {5, 6, 7, 8};
            assertEquals(2, solution.findContentChildren(g, s));
        }

        @Test
        @DisplayName("Cookies much larger than needed")
        void testCookiesTooLarge() {
            int[] g = {1, 2, 3};
            int[] s = {100, 200, 300};
            assertEquals(3, solution.findContentChildren(g, s));
        }

        @Test
        @DisplayName("Mixed satisfied and unsatisfied")
        void testMixedResults() {
            int[] g = {1, 2, 7, 8, 9};
            int[] s = {1, 3, 5, 6};
            assertEquals(2, solution.findContentChildren(g, s));
        }
    }

    @Nested
    @DisplayName("Greedy Forward Tests")
    class GreedyForwardTests {

        @Test
        @DisplayName("Forward approach - basic test")
        void testForwardBasic() {
            int[] g = {1, 2, 3};
            int[] s = {1, 1};
            assertEquals(1, solution.findContentChildren(g, s));
        }

        @Test
        @DisplayName("Forward approach - optimal assignment")
        void testForwardOptimal() {
            int[] g = {1, 2, 3};
            int[] s = {1, 2, 3};
            assertEquals(3, solution.findContentChildren(g, s));
        }

        @Test
        @DisplayName("Forward approach - partial satisfaction")
        void testForwardPartial() {
            int[] g = {1, 5, 6};
            int[] s = {1, 2, 3};
            assertEquals(1, solution.findContentChildren(g, s));
        }
    }

    @Nested
    @DisplayName("Greedy Reverse Tests")
    class GreedyReverseTests {

        @Test
        @DisplayName("Reverse approach - basic test")
        void testReverseBasic() {
            int[] g = {1, 2, 3};
            int[] s = {1, 1};
            assertEquals(1, solution.findContentChildrenReverse(g, s));
        }

        @Test
        @DisplayName("Reverse approach - optimal assignment")
        void testReverseOptimal() {
            int[] g = {1, 2, 3};
            int[] s = {1, 2, 3};
            assertEquals(3, solution.findContentChildrenReverse(g, s));
        }

        @Test
        @DisplayName("Reverse approach - large to small")
        void testReverseLargeToSmall() {
            int[] g = {10, 9, 8, 7};
            int[] s = {5, 6, 7, 8, 9, 10, 11};
            assertEquals(4, solution.findContentChildrenReverse(g, s));
        }
    }

    @Nested
    @DisplayName("Binary Search Tests")
    class BinarySearchTests {

        @Test
        @DisplayName("Binary search - basic test")
        void testBinarySearchBasic() {
            int[] g = {1, 2, 3};
            int[] s = {1, 1};
            assertEquals(1, solution.findContentChildrenBinarySearch(g, s));
        }

        @Test
        @DisplayName("Binary search - empty cookies")
        void testBinarySearchEmptyCookies() {
            int[] g = {1, 2, 3};
            int[] s = {};
            assertEquals(0, solution.findContentChildrenBinarySearch(g, s));
        }

        @Test
        @DisplayName("Binary search - all satisfied")
        void testBinarySearchAllSatisfied() {
            int[] g = {1, 2, 3};
            int[] s = {3, 4, 5};
            assertEquals(3, solution.findContentChildrenBinarySearch(g, s));
        }
    }

    @Nested
    @DisplayName("Brute Force Tests")
    class BruteForceTests {

        @Test
        @DisplayName("Brute force - small input 1")
        void testBruteForceSmall1() {
            int[] g = {1, 2};
            int[] s = {1, 2, 3};
            assertEquals(2, solution.findContentChildrenBruteForce(g, s));
        }

        @Test
        @DisplayName("Brute force - small input 2")
        void testBruteForceSmall2() {
            int[] g = {1, 2, 3};
            int[] s = {1, 1};
            assertEquals(1, solution.findContentChildrenBruteForce(g, s));
        }

        @Test
        @DisplayName("Brute force - empty cookies")
        void testBruteForceEmptyCookies() {
            int[] g = {1, 2};
            int[] s = {};
            assertEquals(0, solution.findContentChildrenBruteForce(g, s));
        }

        @Test
        @DisplayName("Brute force - single elements")
        void testBruteForceSingle() {
            int[] g = {2};
            int[] s = {2};
            assertEquals(1, solution.findContentChildrenBruteForce(g, s));
        }
    }

    @Nested
    @DisplayName("Counting Sort Tests")
    class CountingSortTests {

        @Test
        @DisplayName("Counting sort - basic test")
        void testCountingSortBasic() {
            int[] g = {1, 2, 3};
            int[] s = {1, 1};
            assertEquals(1, solution.findContentChildrenCountingSort(g, s, 10));
        }

        @Test
        @DisplayName("Counting sort - empty cookies")
        void testCountingSortEmptyCookies() {
            int[] g = {1, 2, 3};
            int[] s = {};
            assertEquals(0, solution.findContentChildrenCountingSort(g, s, 10));
        }

        @Test
        @DisplayName("Counting sort - all satisfied")
        void testCountingSortAllSatisfied() {
            int[] g = {1, 2, 3, 4, 5};
            int[] s = {1, 2, 3, 4, 5};
            assertEquals(5, solution.findContentChildrenCountingSort(g, s, 10));
        }

        @Test
        @DisplayName("Counting sort - duplicates")
        void testCountingSortDuplicates() {
            int[] g = {2, 2, 2, 2};
            int[] s = {2, 2, 3, 3};
            assertEquals(4, solution.findContentChildrenCountingSort(g, s, 10));
        }

        @Test
        @DisplayName("Counting sort - larger range")
        void testCountingSortLargerRange() {
            int[] g = {10, 20, 30};
            int[] s = {5, 15, 25, 35};
            assertEquals(3, solution.findContentChildrenCountingSort(g, s, 100));
        }
    }

    @Nested
    @DisplayName("Cross Approach Comparison")
    class CrossApproachComparisonTests {

        @ParameterizedTest
        @MethodSource("provideTestCases")
        @DisplayName("All approaches produce same result")
        void testAllApproaches(int[] g, int[] s, int expected) {
            int result1 = solution.findContentChildren(g.clone(), s.clone());
            int result2 = solution.findContentChildrenReverse(g.clone(), s.clone());
            int result3 = solution.findContentChildrenBinarySearch(g.clone(), s.clone());

            assertEquals(expected, result1, "Greedy forward failed");
            assertEquals(expected, result2, "Greedy reverse failed");
            assertEquals(expected, result3, "Binary search failed");

            // Test brute force only for small inputs
            if (g.length <= 6 && s.length <= 6) {
                int result4 = solution.findContentChildrenBruteForce(g.clone(), s.clone());
                assertEquals(expected, result4, "Brute force failed");
            }

            // Test counting sort for limited range
            if (canUseCountingSort(g, s)) {
                int maxValue = Math.max(getMax(g), getMax(s));
                if (maxValue <= 1000) {
                    int result5 = solution.findContentChildrenCountingSort(g.clone(), s.clone(),
                            maxValue);
                    assertEquals(expected, result5, "Counting sort failed");
                }
            }
        }

        static Stream<Arguments> provideTestCases() {
            return Stream.of(Arguments.of(new int[] {1, 2, 3}, new int[] {1, 1}, 1),
                    Arguments.of(new int[] {1, 2}, new int[] {1, 2, 3}, 2),
                    Arguments.of(new int[] {1, 2, 7, 8, 9}, new int[] {1, 3, 5, 6}, 2),
                    Arguments.of(new int[] {5, 4, 3, 2, 1}, new int[] {1, 2, 3, 4, 5}, 5),
                    Arguments.of(new int[] {}, new int[] {1, 2, 3}, 0),
                    Arguments.of(new int[] {1, 2, 3}, new int[] {}, 0),
                    Arguments.of(new int[] {10, 9, 8, 7}, new int[] {5, 6, 7, 8}, 2));
        }

        private boolean canUseCountingSort(int[] g, int[] s) {
            return g.length > 0 && s.length > 0;
        }

        private int getMax(int[] arr) {
            if (arr.length == 0)
                return 0;
            int max = arr[0];
            for (int val : arr) {
                max = Math.max(max, val);
            }
            return max;
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Large input - many children and cookies")
        void testLargeInput() {
            int[] g = new int[1000];
            int[] s = new int[1000];
            for (int i = 0; i < 1000; i++) {
                g[i] = i + 1;
                s[i] = i + 1;
            }
            assertEquals(1000, solution.findContentChildren(g, s));
        }

        @Test
        @DisplayName("Large input - more children than cookies")
        void testLargeInputMoreChildren() {
            int[] g = new int[2000];
            int[] s = new int[1000];
            for (int i = 0; i < 2000; i++) {
                g[i] = i + 1;
            }
            for (int i = 0; i < 1000; i++) {
                s[i] = i * 2 + 1; // Every other greed can be satisfied
            }
            int result = solution.findContentChildren(g, s);
            assertTrue(result <= 1000);
        }

        @Test
        @DisplayName("Large input - random values")
        void testLargeInputRandom() {
            Random rand = new Random(42); // Fixed seed for reproducibility
            int[] g = new int[1000];
            int[] s = new int[1000];
            for (int i = 0; i < 1000; i++) {
                g[i] = rand.nextInt(100) + 1;
                s[i] = rand.nextInt(100) + 1;
            }

            int result = solution.findContentChildren(g, s);
            assertTrue(result >= 0 && result <= 1000);
        }

        @Test
        @DisplayName("Worst case - almost no children can be satisfied")
        void testWorstCase() {
            int[] g = new int[1000];
            int[] s = new int[1000];
            for (int i = 0; i < 1000; i++) {
                g[i] = 1000 + i; // greed: 1000, 1001, ..., 1999
                s[i] = i + 1; // cookies: 1, 2, ..., 1000
            }
            // Only one child (greed=1000) can be satisfied with cookie size 1000
            assertEquals(1, solution.findContentChildren(g, s));
        }

        @Test
        @DisplayName("Best case - all children can be satisfied")
        void testBestCase() {
            int[] g = new int[1000];
            int[] s = new int[1000];
            for (int i = 0; i < 1000; i++) {
                g[i] = i + 1;
                s[i] = 1000 + i;
            }
            assertEquals(1000, solution.findContentChildren(g, s));
        }
    }

    @Nested
    @DisplayName("Utility Methods Tests")
    class UtilityMethodsTests {

        @Test
        @DisplayName("Verify valid assignment")
        void testVerifyValidAssignment() {
            int[] g = {1, 2, 3};
            int[] s = {1, 2, 3};
            int[] assignments = {0, 1, 2}; // Child i gets cookie i
            assertEquals(3, solution.verifyAssignment(g, s, assignments));
        }

        @Test
        @DisplayName("Verify partial assignment")
        void testVerifyPartialAssignment() {
            int[] g = {1, 2, 3};
            int[] s = {1, 2, 3};
            int[] assignments = {0, -1, 2}; // Child 1 not assigned
            assertEquals(2, solution.verifyAssignment(g, s, assignments));
        }

        @Test
        @DisplayName("Verify assignment - cookie too small")
        void testVerifyInvalidCookieTooSmall() {
            int[] g = {5, 2, 3};
            int[] s = {1, 2, 3};
            int[] assignments = {0, 1, 2}; // Cookie 0 (size 1) too small for child 0 (greed 5)
            assertThrows(IllegalArgumentException.class,
                    () -> solution.verifyAssignment(g, s, assignments));
        }

        @Test
        @DisplayName("Verify assignment - duplicate cookie")
        void testVerifyDuplicateCookie() {
            int[] g = {1, 2, 3};
            int[] s = {1, 2, 3};
            int[] assignments = {0, 0, 2}; // Cookie 0 used twice
            assertThrows(IllegalArgumentException.class,
                    () -> solution.verifyAssignment(g, s, assignments));
        }

        @Test
        @DisplayName("Get statistics - normal case")
        void testGetStatistics() {
            int[] g = {1, 2, 3, 4, 5};
            int[] s = {2, 4, 6};
            String stats = solution.getStatistics(g, s);
            assertTrue(stats.contains("Children: 5"));
            assertTrue(stats.contains("Cookies: 3"));
            assertTrue(stats.contains("Greed range"));
            assertTrue(stats.contains("Cookie size range"));
        }

        @Test
        @DisplayName("Get statistics - empty input")
        void testGetStatisticsEmpty() {
            int[] g = {};
            int[] s = {};
            String stats = solution.getStatistics(g, s);
            assertEquals("Empty input", stats);
        }

        @Test
        @DisplayName("Get statistics - only children")
        void testGetStatisticsOnlyChildren() {
            int[] g = {1, 2, 3};
            int[] s = {};
            String stats = solution.getStatistics(g, s);
            assertTrue(stats.contains("Children: 3"));
            assertTrue(stats.contains("Cookies: 0"));
        }
    }

    @Nested
    @DisplayName("Special Cases")
    class SpecialCasesTests {

        @Test
        @DisplayName("All cookies too small")
        void testAllCookiesTooSmall() {
            int[] g = {10, 20, 30};
            int[] s = {1, 2, 3};
            assertEquals(0, solution.findContentChildren(g, s));
        }

        @Test
        @DisplayName("Cookies barely sufficient")
        void testCookiesBarelySufficient() {
            int[] g = {5, 10, 15};
            int[] s = {5, 10, 15};
            assertEquals(3, solution.findContentChildren(g, s));
        }

        @Test
        @DisplayName("One cookie satisfies multiple children")
        void testOneCookieMultipleChildren() {
            // Of course, one cookie can only be given to one child
            // But the cookie size might satisfy multiple children's greed
            int[] g = {1, 2, 3};
            int[] s = {5};
            assertEquals(1, solution.findContentChildren(g, s));
        }

        @Test
        @DisplayName("Alternating satisfaction pattern")
        void testAlternatingSatisfaction() {
            int[] g = {1, 10, 2, 20, 3};
            int[] s = {1, 2, 3, 4};
            int result = solution.findContentChildren(g, s);
            assertEquals(3, result); // Children with greed 1, 2, 3 can be satisfied
        }

        @Test
        @DisplayName("Many duplicate values")
        void testManyDuplicates() {
            int[] g = {5, 5, 5, 5, 5};
            int[] s = {5, 5, 5};
            assertEquals(3, solution.findContentChildren(g, s));
        }

        @Test
        @DisplayName("Gap in values")
        void testGapInValues() {
            int[] g = {1, 2, 100, 101};
            int[] s = {1, 2, 3, 4};
            assertEquals(2, solution.findContentChildren(g, s));
        }
    }
}

