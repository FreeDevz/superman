package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Comprehensive test suite for ThreeSum Tests all four approaches: Sorting+TwoPointers, BruteForce,
 * HashSet, and Optimized
 */
public class ThreeSumTest {

    private ThreeSum solution;

    @BeforeEach
    void setUp() {
        solution = new ThreeSum();
    }

    // ========================================
    // TEST DATA PROVIDERS
    // ========================================

    /**
     * Provides test cases with input array and expected triplets
     */
    static Stream<Arguments> threeSumTestCases() {
        return Stream.of(
                // LeetCode examples
                Arguments.of(new int[] {-1, 0, 1, 2, -1, -4},
                        Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1))),
                Arguments.of(new int[] {0, 1, 1}, Arrays.asList()),
                Arguments.of(new int[] {0, 0, 0}, Arrays.asList(Arrays.asList(0, 0, 0))),

                // Edge cases
                Arguments.of(new int[] {1, 2, 3}, // All positive
                        Arrays.asList()),
                Arguments.of(new int[] {-1, -2, -3}, // All negative
                        Arrays.asList()),
                Arguments.of(new int[] {0, 0, 0, 0}, // Multiple zeros
                        Arrays.asList(Arrays.asList(0, 0, 0))),

                // Single solution cases
                Arguments.of(new int[] {-1, 0, 1}, Arrays.asList(Arrays.asList(-1, 0, 1))),
                Arguments.of(new int[] {1, -1, 0}, // Same as above, different order
                        Arrays.asList(Arrays.asList(-1, 0, 1))),

                // Multiple solutions
                Arguments.of(new int[] {-2, 0, 1, 1, 2},
                        Arrays.asList(Arrays.asList(-2, 0, 2), Arrays.asList(-2, 1, 1))),
                Arguments.of(new int[] {-4, -2, 1, -5, -4, -4, 4, -3, 0, 0, 4, 0, -1, 0, 1, 2},
                        Arrays.asList(Arrays.asList(-5, 1, 4), Arrays.asList(-4, 0, 4),
                                Arrays.asList(-3, -1, 4), Arrays.asList(-3, 1, 2),
                                Arrays.asList(-2, 0, 2), Arrays.asList(-2, 1, 1),
                                Arrays.asList(-1, 0, 1), Arrays.asList(0, 0, 0))),

                // Duplicate handling
                Arguments.of(new int[] {-1, -1, 2}, Arrays.asList(Arrays.asList(-1, -1, 2))),
                Arguments.of(new int[] {1, 1, -2}, Arrays.asList(Arrays.asList(-2, 1, 1))),
                Arguments.of(new int[] {3, 0, -2, -1, 1, 2},
                        Arrays.asList(Arrays.asList(-2, -1, 3), Arrays.asList(-2, 0, 2),
                                Arrays.asList(-1, 0, 1))),

                // Large numbers within constraints
                Arguments.of(new int[] {-100000, 50000, 50000},
                        Arrays.asList(Arrays.asList(-100000, 50000, 50000))),
                Arguments.of(new int[] {100000, -50000, -50000},
                        Arrays.asList(Arrays.asList(-50000, -50000, 100000))),

                // More complex cases
                Arguments.of(new int[] {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4},
                        Arrays.asList(Arrays.asList(-4, 0, 4), Arrays.asList(-4, 1, 3),
                                Arrays.asList(-3, -1, 4), Arrays.asList(-3, 0, 3),
                                Arrays.asList(-3, 1, 2), Arrays.asList(-2, -1, 3),
                                Arrays.asList(-2, 0, 2), Arrays.asList(-1, -1, 2),
                                Arrays.asList(-1, 0, 1))));
    }

    /**
     * Provides edge case test inputs
     */
    static Stream<Arguments> edgeCaseInputs() {
        return Stream.of(Arguments.of(new int[] {}, "Empty array"),
                Arguments.of(new int[] {1}, "Single element"),
                Arguments.of(new int[] {1, 2}, "Two elements"), Arguments.of(null, "Null array"));
    }

    /**
     * Provides performance test arrays of different sizes
     */
    static Stream<Arguments> performanceTestCases() {
        return Stream.of(Arguments.of(generateArray(10), "Small array (10 elements)"),
                Arguments.of(generateArray(50), "Medium array (50 elements)"),
                Arguments.of(generateArray(100), "Large array (100 elements)"),
                Arguments.of(generateArray(200), "Extra large array (200 elements)"));
    }

    private static int[] generateArray(int size) {
        int[] arr = new int[size];
        Random random = new Random(42); // Fixed seed for reproducibility
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(201) - 100; // Range [-100, 100]
        }
        return arr;
    }

    // ========================================
    // APPROACH 1: SORTING + TWO POINTERS TESTS
    // ========================================

    @ParameterizedTest
    @MethodSource("threeSumTestCases")
    @DisplayName("Test Sorting + Two Pointers approach")
    void testThreeSumSortingTwoPointers(int[] input, List<List<Integer>> expected) {
        List<List<Integer>> result = solution.threeSum(input);

        assertEquals(expected.size(), result.size(),
                String.format("Expected %d triplets, got %d", expected.size(), result.size()));

        assertTrue(solution.allTripletsValid(result), "All triplets should sum to zero");
        assertTrue(solution.hasNoDuplicateTriplets(result), "Should have no duplicate triplets");

        // Convert to sets for comparison (order doesn't matter)
        Set<List<Integer>> expectedSet = new HashSet<>();
        Set<List<Integer>> resultSet = new HashSet<>();

        for (List<Integer> triplet : expected) {
            List<Integer> sorted = new ArrayList<>(triplet);
            Collections.sort(sorted);
            expectedSet.add(sorted);
        }

        for (List<Integer> triplet : result) {
            List<Integer> sorted = new ArrayList<>(triplet);
            Collections.sort(sorted);
            resultSet.add(sorted);
        }

        assertEquals(expectedSet, resultSet, "Result should match expected triplets");
    }

    @Test
    @DisplayName("Test Sorting + Two Pointers with specific examples")
    void testSortingTwoPointersSpecificCases() {
        // Test case 1: Classic LeetCode example
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result1 = solution.threeSum(nums1);
        assertEquals(2, result1.size());
        assertTrue(solution.allTripletsValid(result1));

        // Test case 2: No solution
        int[] nums2 = {0, 1, 1};
        List<List<Integer>> result2 = solution.threeSum(nums2);
        assertTrue(result2.isEmpty());

        // Test case 3: All zeros
        int[] nums3 = {0, 0, 0};
        List<List<Integer>> result3 = solution.threeSum(nums3);
        assertEquals(1, result3.size());
        assertEquals(Arrays.asList(0, 0, 0), result3.get(0));
    }

    // ========================================
    // APPROACH 2: BRUTE FORCE TESTS
    // ========================================

    @ParameterizedTest
    @MethodSource("threeSumTestCases")
    @DisplayName("Test Brute Force approach")
    void testThreeSumBruteForce(int[] input, List<List<Integer>> expected) {
        List<List<Integer>> result = solution.threeSumBruteForce(input);

        assertEquals(expected.size(), result.size());
        assertTrue(solution.allTripletsValid(result));
        assertTrue(solution.hasNoDuplicateTriplets(result));

        // Compare with main approach
        List<List<Integer>> mainResult = solution.threeSum(input);
        assertTrue(solution.compareResults(mainResult, result),
                "Brute force should produce same results as main approach");
    }

    @Test
    @DisplayName("Test Brute Force with complex case")
    void testBruteForceComplexCase() {
        int[] nums = {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        List<List<Integer>> result = solution.threeSumBruteForce(nums);

        assertTrue(solution.allTripletsValid(result));
        assertTrue(solution.hasNoDuplicateTriplets(result));

        // Should find multiple valid triplets
        assertTrue(result.size() > 0);
    }

    // ========================================
    // APPROACH 3: HASH SET TESTS
    // ========================================

    @ParameterizedTest
    @MethodSource("threeSumTestCases")
    @DisplayName("Test Hash Set approach")
    void testThreeSumHashSet(int[] input, List<List<Integer>> expected) {
        List<List<Integer>> result = solution.threeSumHashSet(input);

        assertEquals(expected.size(), result.size());
        assertTrue(solution.allTripletsValid(result));
        assertTrue(solution.hasNoDuplicateTriplets(result));

        // Compare with main approach
        List<List<Integer>> mainResult = solution.threeSum(input);
        assertTrue(solution.compareResults(mainResult, result),
                "Hash set should produce same results as main approach");
    }

    @Test
    @DisplayName("Test Hash Set with duplicate elements")
    void testHashSetDuplicateHandling() {
        int[] nums = {0, 0, 0, 0};
        List<List<Integer>> result = solution.threeSumHashSet(nums);

        assertEquals(1, result.size());
        assertEquals(Arrays.asList(0, 0, 0), result.get(0));
    }

    // ========================================
    // APPROACH 4: OPTIMIZED TWO POINTERS TESTS
    // ========================================

    @ParameterizedTest
    @MethodSource("threeSumTestCases")
    @DisplayName("Test Optimized Two Pointers approach")
    void testThreeSumOptimized(int[] input, List<List<Integer>> expected) {
        List<List<Integer>> result = solution.threeSumOptimized(input);

        assertEquals(expected.size(), result.size());
        assertTrue(solution.allTripletsValid(result));
        assertTrue(solution.hasNoDuplicateTriplets(result));

        // Compare with main approach
        List<List<Integer>> mainResult = solution.threeSum(input);
        assertTrue(solution.compareResults(mainResult, result),
                "Optimized should produce same results as main approach");
    }

    @Test
    @DisplayName("Test Optimized approach early termination")
    void testOptimizedEarlyTermination() {
        // All positive numbers - should terminate early
        int[] nums = {1, 2, 3, 4, 5};
        List<List<Integer>> result = solution.threeSumOptimized(nums);
        assertTrue(result.isEmpty());

        // All negative numbers - should skip appropriately
        int[] nums2 = {-1, -2, -3, -4, -5};
        List<List<Integer>> result2 = solution.threeSumOptimized(nums2);
        assertTrue(result2.isEmpty());
    }

    // ========================================
    // CROSS-VALIDATION TESTS
    // ========================================

    @Test
    @DisplayName("Test all approaches return same results")
    void testAllApproachesConsistency() {
        int[][] testCases = {{-1, 0, 1, 2, -1, -4}, {0, 1, 1}, {0, 0, 0}, {-2, 0, 1, 1, 2},
                {1, 2, 3}, {-1, -2, -3}, {3, 0, -2, -1, 1, 2}};

        for (int[] testCase : testCases) {
            List<List<Integer>> result1 = solution.threeSum(testCase);
            List<List<Integer>> result2 = solution.threeSumBruteForce(testCase);
            List<List<Integer>> result3 = solution.threeSumHashSet(testCase);
            List<List<Integer>> result4 = solution.threeSumOptimized(testCase);

            assertTrue(solution.compareResults(result1, result2),
                    String.format("Main and Brute Force differ for %s", Arrays.toString(testCase)));
            assertTrue(solution.compareResults(result1, result3),
                    String.format("Main and Hash Set differ for %s", Arrays.toString(testCase)));
            assertTrue(solution.compareResults(result1, result4),
                    String.format("Main and Optimized differ for %s", Arrays.toString(testCase)));
        }
    }

    // ========================================
    // EDGE CASE TESTS
    // ========================================

    @ParameterizedTest
    @MethodSource("edgeCaseInputs")
    @DisplayName("Test edge cases")
    void testEdgeCases(int[] input, String description) {
        List<List<Integer>> result1 = solution.threeSum(input);
        List<List<Integer>> result2 = solution.threeSumBruteForce(input);
        List<List<Integer>> result3 = solution.threeSumHashSet(input);
        List<List<Integer>> result4 = solution.threeSumOptimized(input);

        // All should return empty list for invalid inputs
        assertTrue(result1.isEmpty(), description + ": Main approach should return empty");
        assertTrue(result2.isEmpty(), description + ": Brute force should return empty");
        assertTrue(result3.isEmpty(), description + ": Hash set should return empty");
        assertTrue(result4.isEmpty(), description + ": Optimized should return empty");
    }

    @Test
    @DisplayName("Test minimum array size requirement")
    void testMinimumArraySize() {
        // Arrays with less than 3 elements should return empty
        assertDoesNotThrow(() -> {
            assertTrue(solution.threeSum(new int[] {}).isEmpty());
            assertTrue(solution.threeSum(new int[] {1}).isEmpty());
            assertTrue(solution.threeSum(new int[] {1, 2}).isEmpty());
        });
    }

    // ========================================
    // UTILITY METHOD TESTS
    // ========================================

    @Test
    @DisplayName("Test utility methods")
    void testUtilityMethods() {
        // Test isValidTriplet
        assertTrue(solution.isValidTriplet(-1, 0, 1));
        assertTrue(solution.isValidTriplet(0, 0, 0));
        assertFalse(solution.isValidTriplet(1, 2, 3));

        // Test hasUniqueElements
        assertTrue(solution.hasUniqueElements(Arrays.asList(1, 2, 3)));
        assertFalse(solution.hasUniqueElements(Arrays.asList(1, 1, 2)));
        assertFalse(solution.hasUniqueElements(Arrays.asList(0, 0, 0))); // All same elements - not
                                                                         // unique

        // Test countTriplets
        List<List<Integer>> triplets =
                Arrays.asList(Arrays.asList(-1, 0, 1), Arrays.asList(-1, -1, 2));
        assertEquals(2, solution.countTriplets(triplets));

        // Test hasNoDuplicateTriplets
        assertTrue(solution.hasNoDuplicateTriplets(triplets));

        List<List<Integer>> duplicateTriplets =
                Arrays.asList(Arrays.asList(-1, 0, 1), Arrays.asList(1, 0, -1) // Same triplet,
                                                                               // different order
                );
        assertFalse(solution.hasNoDuplicateTriplets(duplicateTriplets));

        // Test allTripletsValid
        assertTrue(solution.allTripletsValid(triplets));

        List<List<Integer>> invalidTriplets = Arrays.asList(Arrays.asList(1, 2, 3) // Doesn't sum to
                                                                                   // zero
        );
        assertFalse(solution.allTripletsValid(invalidTriplets));
    }

    @Test
    @DisplayName("Test getTripletStatistics")
    void testGetTripletStatistics() {
        List<List<Integer>> validTriplets =
                Arrays.asList(Arrays.asList(-1, 0, 1), Arrays.asList(-1, -1, 2));
        String stats = solution.getTripletStatistics(validTriplets);
        assertTrue(stats.contains("Found 2 triplet(s)"));
        assertTrue(stats.contains("All valid: true"));
        assertTrue(stats.contains("No duplicates: true"));

        String emptyStats = solution.getTripletStatistics(new ArrayList<>());
        assertEquals("No triplets found", emptyStats);
    }

    @Test
    @DisplayName("Test compareResults utility")
    void testCompareResults() {
        List<List<Integer>> result1 =
                Arrays.asList(Arrays.asList(-1, 0, 1), Arrays.asList(-1, -1, 2));

        List<List<Integer>> result2 = Arrays.asList(Arrays.asList(1, 0, -1), // Same triplet,
                                                                             // different order
                Arrays.asList(2, -1, -1) // Same triplet, different order
        );

        assertTrue(solution.compareResults(result1, result2));

        List<List<Integer>> result3 = Arrays.asList(Arrays.asList(-1, 0, 1));

        assertFalse(solution.compareResults(result1, result3)); // Different sizes
    }

    @Test
    @DisplayName("Test findMinMaxPossibleSums")
    void testFindMinMaxPossibleSums() {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] minMax = solution.findMinMaxPossibleSums(nums);

        assertEquals(-5, minMax[0]); // -4 + (-1) + 0
        assertEquals(13, minMax[1]); // 0 + 3 + 10

        // Edge case: array too small
        int[] tooSmall = {1, 2};
        int[] result = solution.findMinMaxPossibleSums(tooSmall);
        assertArrayEquals(new int[] {0, 0}, result);
    }

    // ========================================
    // PERFORMANCE TESTS
    // ========================================

    @ParameterizedTest
    @MethodSource("performanceTestCases")
    @DisplayName("Test performance comparison")
    void testPerformanceComparison(int[] input, String description) {
        // Skip brute force for large arrays to avoid timeout
        boolean skipBruteForce = input.length > 20;

        long[] times = new long[4];
        List<List<Integer>>[] results = new List[4];

        // Measure each approach
        times[0] = solution.measureExecutionTime(() -> results[0] = solution.threeSum(input));

        if (!skipBruteForce) {
            times[1] = solution
                    .measureExecutionTime(() -> results[1] = solution.threeSumBruteForce(input));
        }

        times[2] =
                solution.measureExecutionTime(() -> results[2] = solution.threeSumHashSet(input));

        times[3] =
                solution.measureExecutionTime(() -> results[3] = solution.threeSumOptimized(input));

        // Verify all produce same results (except brute force for large arrays)
        if (!skipBruteForce) {
            assertTrue(solution.compareResults(results[0], results[1]),
                    description + ": Main and Brute Force should match");
        }
        assertTrue(solution.compareResults(results[0], results[2]),
                description + ": Main and Hash Set should match");
        assertTrue(solution.compareResults(results[0], results[3]),
                description + ": Main and Optimized should match");

        // All should complete within reasonable time (100ms)
        assertTrue(times[0] < 100_000_000, description + ": Main approach should be fast");
        assertTrue(times[2] < 100_000_000, description + ": Hash Set should be fast");
        assertTrue(times[3] < 100_000_000, description + ": Optimized should be fast");

        // For small arrays, brute force should also be reasonable
        if (!skipBruteForce) {
            assertTrue(times[1] < 100_000_000,
                    description + ": Brute Force should be acceptable for small arrays");
        }
    }

    @Test
    @DisplayName("Test constraint boundaries")
    void testConstraintBoundaries() {
        // Test maximum constraint values
        int[] maxValues = {100000, -50000, -50000};
        List<List<Integer>> result = solution.threeSum(maxValues);
        assertNotNull(result);
        assertTrue(solution.allTripletsValid(result));

        // Test minimum constraint values
        int[] minValues = {-100000, 50000, 50000};
        List<List<Integer>> result2 = solution.threeSum(minValues);
        assertNotNull(result2);
        assertTrue(solution.allTripletsValid(result2));
    }

    @Test
    @DisplayName("Test with maximum array size")
    void testMaximumArraySize() {
        // Test with larger array (but not full 3000 to keep tests fast)
        int[] largeArray = new int[300];
        Random random = new Random(42);
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = random.nextInt(201) - 100; // Range [-100, 100]
        }

        assertDoesNotThrow(() -> {
            List<List<Integer>> result = solution.threeSum(largeArray);
            assertNotNull(result);
            assertTrue(solution.allTripletsValid(result));
            assertTrue(solution.hasNoDuplicateTriplets(result));
        });
    }
}
