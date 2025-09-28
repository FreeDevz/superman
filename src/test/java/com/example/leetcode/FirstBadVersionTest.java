package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Comprehensive test suite for FirstBadVersion LeetCode problem Tests all seven different
 * approaches with various edge cases
 */
public class FirstBadVersionTest {

    @Nested
    @DisplayName("Binary Search Approach Tests")
    class BinarySearchApproachTests {

        @Test
        @DisplayName("Basic example from LeetCode")
        void testBasicExample() {
            FirstBadVersion solution = new FirstBadVersion(4);
            assertEquals(4, solution.firstBadVersionBinarySearch(5));
        }

        @Test
        @DisplayName("Single version")
        void testSingleVersion() {
            FirstBadVersion solution = new FirstBadVersion(1);
            assertEquals(1, solution.firstBadVersionBinarySearch(1));
        }

        @Test
        @DisplayName("First version is bad")
        void testFirstVersionBad() {
            FirstBadVersion solution = new FirstBadVersion(1);
            assertEquals(1, solution.firstBadVersionBinarySearch(5));
        }

        @Test
        @DisplayName("Last version is bad")
        void testLastVersionBad() {
            FirstBadVersion solution = new FirstBadVersion(5);
            assertEquals(5, solution.firstBadVersionBinarySearch(5));
        }

        @Test
        @DisplayName("Middle version is bad")
        void testMiddleVersionBad() {
            FirstBadVersion solution = new FirstBadVersion(3);
            assertEquals(3, solution.firstBadVersionBinarySearch(5));
        }

        @Test
        @DisplayName("Large input")
        void testLargeInput() {
            FirstBadVersion solution = new FirstBadVersion(1000);
            assertEquals(1000, solution.firstBadVersionBinarySearch(10000));
        }

        @Test
        @DisplayName("Invalid input throws exception")
        void testInvalidInput() {
            FirstBadVersion solution = new FirstBadVersion(1);
            assertThrows(IllegalArgumentException.class,
                    () -> solution.firstBadVersionBinarySearch(0));
            assertThrows(IllegalArgumentException.class,
                    () -> solution.firstBadVersionBinarySearch(-1));
        }
    }

    @Nested
    @DisplayName("Recursive Approach Tests")
    class RecursiveApproachTests {

        @Test
        @DisplayName("Basic functionality")
        void testBasicFunctionality() {
            FirstBadVersion solution = new FirstBadVersion(4);
            assertEquals(4, solution.firstBadVersionRecursive(5));
        }

        @Test
        @DisplayName("Single version")
        void testSingleVersion() {
            FirstBadVersion solution = new FirstBadVersion(1);
            assertEquals(1, solution.firstBadVersionRecursive(1));
        }

        @Test
        @DisplayName("First version is bad")
        void testFirstVersionBad() {
            FirstBadVersion solution = new FirstBadVersion(1);
            assertEquals(1, solution.firstBadVersionRecursive(5));
        }

        @Test
        @DisplayName("Last version is bad")
        void testLastVersionBad() {
            FirstBadVersion solution = new FirstBadVersion(5);
            assertEquals(5, solution.firstBadVersionRecursive(5));
        }

        @Test
        @DisplayName("Invalid input throws exception")
        void testInvalidInput() {
            FirstBadVersion solution = new FirstBadVersion(1);
            assertThrows(IllegalArgumentException.class,
                    () -> solution.firstBadVersionRecursive(0));
        }
    }

    @Nested
    @DisplayName("Linear Search Approach Tests")
    class LinearSearchApproachTests {

        @Test
        @DisplayName("Basic functionality")
        void testBasicFunctionality() {
            FirstBadVersion solution = new FirstBadVersion(4);
            assertEquals(4, solution.firstBadVersionLinear(5));
        }

        @Test
        @DisplayName("Single version")
        void testSingleVersion() {
            FirstBadVersion solution = new FirstBadVersion(1);
            assertEquals(1, solution.firstBadVersionLinear(1));
        }

        @Test
        @DisplayName("First version is bad")
        void testFirstVersionBad() {
            FirstBadVersion solution = new FirstBadVersion(1);
            assertEquals(1, solution.firstBadVersionLinear(5));
        }

        @Test
        @DisplayName("Last version is bad")
        void testLastVersionBad() {
            FirstBadVersion solution = new FirstBadVersion(5);
            assertEquals(5, solution.firstBadVersionLinear(5));
        }

        @Test
        @DisplayName("Invalid input throws exception")
        void testInvalidInput() {
            FirstBadVersion solution = new FirstBadVersion(1);
            assertThrows(IllegalArgumentException.class, () -> solution.firstBadVersionLinear(0));
        }
    }

    @Nested
    @DisplayName("Optimized Approach Tests")
    class OptimizedApproachTests {

        @Test
        @DisplayName("Basic functionality")
        void testBasicFunctionality() {
            FirstBadVersion solution = new FirstBadVersion(4);
            assertEquals(4, solution.firstBadVersionOptimized(5));
        }

        @Test
        @DisplayName("Single version")
        void testSingleVersion() {
            FirstBadVersion solution = new FirstBadVersion(1);
            assertEquals(1, solution.firstBadVersionOptimized(1));
        }

        @Test
        @DisplayName("First version is bad")
        void testFirstVersionBad() {
            FirstBadVersion solution = new FirstBadVersion(1);
            assertEquals(1, solution.firstBadVersionOptimized(5));
        }

        @Test
        @DisplayName("Last version is bad")
        void testLastVersionBad() {
            FirstBadVersion solution = new FirstBadVersion(5);
            assertEquals(5, solution.firstBadVersionOptimized(5));
        }

        @Test
        @DisplayName("Invalid input throws exception")
        void testInvalidInput() {
            FirstBadVersion solution = new FirstBadVersion(1);
            assertThrows(IllegalArgumentException.class,
                    () -> solution.firstBadVersionOptimized(0));
        }
    }

    @Nested
    @DisplayName("With Counting Approach Tests")
    class WithCountingApproachTests {

        @Test
        @DisplayName("Basic functionality")
        void testBasicFunctionality() {
            FirstBadVersion solution = new FirstBadVersion(4);
            assertEquals(4, solution.firstBadVersionWithCounting(5));
        }

        @Test
        @DisplayName("Single version")
        void testSingleVersion() {
            FirstBadVersion solution = new FirstBadVersion(1);
            assertEquals(1, solution.firstBadVersionWithCounting(1));
        }

        @Test
        @DisplayName("First version is bad")
        void testFirstVersionBad() {
            FirstBadVersion solution = new FirstBadVersion(1);
            assertEquals(1, solution.firstBadVersionWithCounting(5));
        }

        @Test
        @DisplayName("Last version is bad")
        void testLastVersionBad() {
            FirstBadVersion solution = new FirstBadVersion(5);
            assertEquals(5, solution.firstBadVersionWithCounting(5));
        }

        @Test
        @DisplayName("Invalid input throws exception")
        void testInvalidInput() {
            FirstBadVersion solution = new FirstBadVersion(1);
            assertThrows(IllegalArgumentException.class,
                    () -> solution.firstBadVersionWithCounting(0));
        }
    }

    @Nested
    @DisplayName("Ternary Search Approach Tests")
    class TernarySearchApproachTests {

        @Test
        @DisplayName("Basic functionality")
        void testBasicFunctionality() {
            FirstBadVersion solution = new FirstBadVersion(4);
            assertEquals(4, solution.firstBadVersionTernary(5));
        }

        @Test
        @DisplayName("Single version")
        void testSingleVersion() {
            FirstBadVersion solution = new FirstBadVersion(1);
            assertEquals(1, solution.firstBadVersionTernary(1));
        }

        @Test
        @DisplayName("First version is bad")
        void testFirstVersionBad() {
            FirstBadVersion solution = new FirstBadVersion(1);
            assertEquals(1, solution.firstBadVersionTernary(5));
        }

        @Test
        @DisplayName("Last version is bad")
        void testLastVersionBad() {
            FirstBadVersion solution = new FirstBadVersion(5);
            assertEquals(5, solution.firstBadVersionTernary(5));
        }

        @Test
        @DisplayName("Invalid input throws exception")
        void testInvalidInput() {
            FirstBadVersion solution = new FirstBadVersion(1);
            assertThrows(IllegalArgumentException.class, () -> solution.firstBadVersionTernary(0));
        }
    }

    @Nested
    @DisplayName("Boundary Optimized Approach Tests")
    class BoundaryOptimizedApproachTests {

        @Test
        @DisplayName("Basic functionality")
        void testBasicFunctionality() {
            FirstBadVersion solution = new FirstBadVersion(4);
            assertEquals(4, solution.firstBadVersionBoundaryOptimized(5));
        }

        @Test
        @DisplayName("Single version")
        void testSingleVersion() {
            FirstBadVersion solution = new FirstBadVersion(1);
            assertEquals(1, solution.firstBadVersionBoundaryOptimized(1));
        }

        @Test
        @DisplayName("First version is bad")
        void testFirstVersionBad() {
            FirstBadVersion solution = new FirstBadVersion(1);
            assertEquals(1, solution.firstBadVersionBoundaryOptimized(5));
        }

        @Test
        @DisplayName("Last version is bad")
        void testLastVersionBad() {
            FirstBadVersion solution = new FirstBadVersion(5);
            assertEquals(5, solution.firstBadVersionBoundaryOptimized(5));
        }

        @Test
        @DisplayName("Invalid input throws exception")
        void testInvalidInput() {
            FirstBadVersion solution = new FirstBadVersion(1);
            assertThrows(IllegalArgumentException.class,
                    () -> solution.firstBadVersionBoundaryOptimized(0));
        }

        @Test
        @DisplayName("No bad version found")
        void testNoBadVersion() {
            // Create a solution where no version is bad
            FirstBadVersion solution = new FirstBadVersion(Integer.MAX_VALUE);
            assertEquals(-1, solution.firstBadVersionBoundaryOptimized(5));
        }
    }

    @Nested
    @DisplayName("Cross Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @ParameterizedTest
        @MethodSource("provideTestCases")
        @DisplayName("All approaches produce same result")
        void testAllApproachesConsistency(int n, int expectedBad) {
            FirstBadVersion solution = new FirstBadVersion(expectedBad);

            int result1 = solution.firstBadVersionBinarySearch(n);
            int result2 = solution.firstBadVersionRecursive(n);
            int result3 = solution.firstBadVersionLinear(n);
            int result4 = solution.firstBadVersionOptimized(n);
            int result5 = solution.firstBadVersionWithCounting(n);
            int result6 = solution.firstBadVersionTernary(n);
            int result7 = solution.firstBadVersionBoundaryOptimized(n);

            assertEquals(expectedBad, result1, "Binary Search approach failed");
            assertEquals(expectedBad, result2, "Recursive approach failed");
            assertEquals(expectedBad, result3, "Linear approach failed");
            assertEquals(expectedBad, result4, "Optimized approach failed");
            assertEquals(expectedBad, result5, "With Counting approach failed");
            assertEquals(expectedBad, result6, "Ternary approach failed");
            assertEquals(expectedBad, result7, "Boundary Optimized approach failed");

            // All approaches should produce the same result
            assertEquals(result1, result2);
            assertEquals(result2, result3);
            assertEquals(result3, result4);
            assertEquals(result4, result5);
            assertEquals(result5, result6);
            assertEquals(result6, result7);
        }

        static Stream<Arguments> provideTestCases() {
            return Stream.of(Arguments.of(5, 4), Arguments.of(1, 1), Arguments.of(10, 3),
                    Arguments.of(100, 50), Arguments.of(1000, 1), Arguments.of(1000, 1000),
                    Arguments.of(10000, 5000), Arguments.of(100000, 1),
                    Arguments.of(100000, 100000));
        }
    }

    @Nested
    @DisplayName("Edge Case Tests")
    class EdgeCaseTests {

        @Test
        @DisplayName("Maximum constraint test")
        void testMaximumConstraint() {
            int n = 1000000;
            int expectedBad = 500000;
            FirstBadVersion solution = new FirstBadVersion(expectedBad);

            assertEquals(expectedBad, solution.firstBadVersionBinarySearch(n));
            assertEquals(expectedBad, solution.firstBadVersionRecursive(n));
            assertEquals(expectedBad, solution.firstBadVersionLinear(n));
            assertEquals(expectedBad, solution.firstBadVersionOptimized(n));
        }

        @Test
        @DisplayName("Large range queries")
        void testLargeRangeQueries() {
            int n = 100000;
            int expectedBad = 1;
            FirstBadVersion solution = new FirstBadVersion(expectedBad);

            assertEquals(expectedBad, solution.firstBadVersionBinarySearch(n));
            assertEquals(expectedBad, solution.firstBadVersionRecursive(n));
            assertEquals(expectedBad, solution.firstBadVersionLinear(n));
            assertEquals(expectedBad, solution.firstBadVersionOptimized(n));
        }

        @Test
        @DisplayName("Single element queries")
        void testSingleElementQueries() {
            FirstBadVersion solution = new FirstBadVersion(1);
            assertEquals(1, solution.firstBadVersionBinarySearch(1));
            assertEquals(1, solution.firstBadVersionRecursive(1));
            assertEquals(1, solution.firstBadVersionLinear(1));
            assertEquals(1, solution.firstBadVersionOptimized(1));
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Large input performance test")
        void testLargeInputPerformance() {
            int n = 1000000;
            int expectedBad = 500000;
            FirstBadVersion solution = new FirstBadVersion(expectedBad);

            long startTime, endTime;

            // Test binary search approach
            startTime = System.nanoTime();
            int result1 = solution.firstBadVersionBinarySearch(n);
            endTime = System.nanoTime();
            long binarySearchTime = endTime - startTime;

            // Test linear search approach
            startTime = System.nanoTime();
            int result2 = solution.firstBadVersionLinear(n);
            endTime = System.nanoTime();
            long linearSearchTime = endTime - startTime;

            // Test optimized approach
            startTime = System.nanoTime();
            int result3 = solution.firstBadVersionOptimized(n);
            endTime = System.nanoTime();
            long optimizedTime = endTime - startTime;

            System.out.println("Binary Search: " + binarySearchTime + " ns");
            System.out.println("Linear Search: " + linearSearchTime + " ns");
            System.out.println("Optimized: " + optimizedTime + " ns");

            assertEquals(expectedBad, result1);
            assertEquals(expectedBad, result2);
            assertEquals(expectedBad, result3);

            // Binary search should be much faster than linear search for large inputs
            assertTrue(binarySearchTime < linearSearchTime || binarySearchTime < 10000);
        }

        @Test
        @DisplayName("API call efficiency test")
        void testApiCallEfficiency() {
            int n = 1000;
            int expectedBad = 500;
            FirstBadVersion solution = new FirstBadVersion(expectedBad);

            int apiCalls = solution.countApiCalls(n, 1);
            int expectedCalls = FirstBadVersion.calculateExpectedApiCalls(n);

            System.out.println("Actual API calls: " + apiCalls);
            System.out.println("Expected API calls: " + expectedCalls);

            // API calls should be close to expected (log n)
            assertTrue(apiCalls <= expectedCalls + 2); // Allow some tolerance
        }
    }

    @Nested
    @DisplayName("Parameterized Tests")
    class ParameterizedTests {

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 5, 10, 20, 50, 100, 1000, 10000})
        @DisplayName("Test with different input sizes")
        void testDifferentInputSizes(int n) {
            int expectedBad = Math.max(1, n / 2); // Middle version is bad, but at least 1
            FirstBadVersion solution = new FirstBadVersion(expectedBad);

            assertEquals(expectedBad, solution.firstBadVersionBinarySearch(n));
            assertEquals(expectedBad, solution.firstBadVersionRecursive(n));
            assertEquals(expectedBad, solution.firstBadVersionLinear(n));
            assertEquals(expectedBad, solution.firstBadVersionOptimized(n));
        }

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3, 4, 5, 10, 20, 50, 100})
        @DisplayName("Test with different bad versions")
        void testDifferentBadVersions(int badVersion) {
            int n = 100;
            FirstBadVersion solution = new FirstBadVersion(badVersion);

            assertEquals(badVersion, solution.firstBadVersionBinarySearch(n));
            assertEquals(badVersion, solution.firstBadVersionRecursive(n));
            assertEquals(badVersion, solution.firstBadVersionLinear(n));
            assertEquals(badVersion, solution.firstBadVersionOptimized(n));
        }
    }

    @Nested
    @DisplayName("Utility Method Tests")
    class UtilityMethodTests {

        @Test
        @DisplayName("Verify first bad version")
        void testVerifyFirstBadVersion() {
            FirstBadVersion solution = new FirstBadVersion(4);

            // Only version 4 should be the first bad version
            assertTrue(solution.verifyFirstBadVersion(4));
            // Versions 5, 6, etc. are bad but not the first bad version
            assertTrue(!solution.verifyFirstBadVersion(5));
            assertTrue(!solution.verifyFirstBadVersion(6));

            // Test with different bad versions
            FirstBadVersion solution2 = new FirstBadVersion(1);
            assertTrue(solution2.verifyFirstBadVersion(1));
            assertTrue(!solution2.verifyFirstBadVersion(2));
            assertTrue(!solution2.verifyFirstBadVersion(3));
        }

        @Test
        @DisplayName("Calculate expected API calls")
        void testCalculateExpectedApiCalls() {
            assertEquals(1, FirstBadVersion.calculateExpectedApiCalls(1));
            assertEquals(1, FirstBadVersion.calculateExpectedApiCalls(2));
            assertEquals(2, FirstBadVersion.calculateExpectedApiCalls(3));
            assertEquals(2, FirstBadVersion.calculateExpectedApiCalls(4));
            assertEquals(3, FirstBadVersion.calculateExpectedApiCalls(5));
            assertEquals(3, FirstBadVersion.calculateExpectedApiCalls(8));
            assertEquals(10, FirstBadVersion.calculateExpectedApiCalls(1000));
        }

        @Test
        @DisplayName("Generate test cases")
        void testGenerateTestCases() {
            int[][] testCases = FirstBadVersion.generateTestCases();
            assertTrue(testCases.length > 0);

            for (int[] testCase : testCases) {
                assertTrue(testCase.length == 2);
                assertTrue(testCase[0] > 0); // n > 0
                assertTrue(testCase[1] > 0); // bad version > 0
                assertTrue(testCase[1] <= testCase[0]); // bad version <= n
            }
        }
    }

    @Nested
    @DisplayName("Stress Tests")
    class StressTests {

        @Test
        @DisplayName("Maximum constraint stress test")
        void testMaximumConstraintStress() {
            int n = 1000000;
            int expectedBad = 1;
            FirstBadVersion solution = new FirstBadVersion(expectedBad);

            assertEquals(expectedBad, solution.firstBadVersionBinarySearch(n));
            assertEquals(expectedBad, solution.firstBadVersionRecursive(n));
            assertEquals(expectedBad, solution.firstBadVersionLinear(n));
            assertEquals(expectedBad, solution.firstBadVersionOptimized(n));
        }

        @Test
        @DisplayName("Multiple query stress test")
        void testMultipleQueryStress() {
            int n = 10000;
            FirstBadVersion solution = new FirstBadVersion(5000);

            // Perform many queries
            for (int i = 0; i < 100; i++) {
                assertEquals(5000, solution.firstBadVersionBinarySearch(n));
                assertEquals(5000, solution.firstBadVersionRecursive(n));
                assertEquals(5000, solution.firstBadVersionLinear(n));
                assertEquals(5000, solution.firstBadVersionOptimized(n));
            }
        }
    }
}
