package com.example.hackerrank;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test class for IceCreamParlor
 * 
 * Tests all approaches for the Ice Cream Parlor problem
 */
public class IceCreamParlorTest {

    // ========================================
    // TESTS FOR APPROACH 1: HASH MAP - ONE PASS
    // ========================================

    @Test
    @DisplayName("Hash Map: HackerRank Example 1 - [1, 4, 5, 3, 2], m=4")
    public void testHashMapExample1() {
        int m = 4;
        int[] cost = {1, 4, 5, 3, 2};
        int[] result = IceCreamParlor.icecreamParlor(m, cost);

        assertNotNull(result);
        assertEquals(2, result.length);
        assertArrayEquals(new int[] {1, 4}, result);
        assertTrue(IceCreamParlor.isValidSolution(m, cost, result));
    }

    @Test
    @DisplayName("Hash Map: HackerRank Example 2 - [2, 2, 4, 3], m=4")
    public void testHashMapExample2() {
        int m = 4;
        int[] cost = {2, 2, 4, 3};
        int[] result = IceCreamParlor.icecreamParlor(m, cost);

        assertNotNull(result);
        assertEquals(2, result.length);
        assertArrayEquals(new int[] {1, 2}, result);
        assertTrue(IceCreamParlor.isValidSolution(m, cost, result));
    }

    @Test
    @DisplayName("Hash Map: Large values - [5, 75, 25, 100], m=100")
    public void testHashMapLargeValues() {
        int m = 100;
        int[] cost = {5, 75, 25, 100};
        int[] result = IceCreamParlor.icecreamParlor(m, cost);

        assertNotNull(result);
        assertEquals(2, result.length);
        assertArrayEquals(new int[] {2, 3}, result);
        assertTrue(IceCreamParlor.isValidSolution(m, cost, result));
    }

    @Test
    @DisplayName("Hash Map: Two items only - [3, 7], m=10")
    public void testHashMapTwoItems() {
        int m = 10;
        int[] cost = {3, 7};
        int[] result = IceCreamParlor.icecreamParlor(m, cost);

        assertNotNull(result);
        assertEquals(2, result.length);
        assertArrayEquals(new int[] {1, 2}, result);
        assertTrue(IceCreamParlor.isValidSolution(m, cost, result));
    }

    @Test
    @DisplayName("Hash Map: Solution at the end - [1, 2, 3, 4, 5, 15], m=20")
    public void testHashMapSolutionAtEnd() {
        int m = 20;
        int[] cost = {1, 2, 3, 4, 5, 15};
        int[] result = IceCreamParlor.icecreamParlor(m, cost);

        assertNotNull(result);
        assertEquals(2, result.length);
        assertArrayEquals(new int[] {5, 6}, result);
        assertTrue(IceCreamParlor.isValidSolution(m, cost, result));
    }

    @Test
    @DisplayName("Hash Map: First and last elements - [1, 8, 6, 9], m=10")
    public void testHashMapFirstAndLast() {
        int m = 10;
        int[] cost = {1, 8, 6, 9};
        int[] result = IceCreamParlor.icecreamParlor(m, cost);

        assertNotNull(result);
        assertEquals(2, result.length);
        assertArrayEquals(new int[] {1, 4}, result);
        assertTrue(IceCreamParlor.isValidSolution(m, cost, result));
    }

    @Test
    @DisplayName("Hash Map: Consecutive elements - [5, 3, 7, 2], m=8")
    public void testHashMapConsecutive() {
        int m = 8;
        int[] cost = {5, 3, 7, 2};
        int[] result = IceCreamParlor.icecreamParlor(m, cost);

        assertNotNull(result);
        assertEquals(2, result.length);
        assertArrayEquals(new int[] {1, 2}, result);
        assertTrue(IceCreamParlor.isValidSolution(m, cost, result));
    }

    @Test
    @DisplayName("Hash Map: Large array - 10 elements")
    public void testHashMapLargeArray() {
        int m = 15;
        int[] cost = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] result = IceCreamParlor.icecreamParlor(m, cost);

        assertNotNull(result);
        assertEquals(2, result.length);
        assertTrue(result[0] < result[1], "Indices should be in ascending order");
        assertTrue(IceCreamParlor.isValidSolution(m, cost, result));
    }

    @Test
    @DisplayName("Hash Map: Same price at different positions - [3, 5, 3, 7], m=6")
    public void testHashMapDuplicatePrices() {
        int m = 6;
        int[] cost = {3, 5, 3, 7};
        int[] result = IceCreamParlor.icecreamParlor(m, cost);

        assertNotNull(result);
        assertEquals(2, result.length);
        assertArrayEquals(new int[] {1, 3}, result);
        assertTrue(IceCreamParlor.isValidSolution(m, cost, result));
    }

    @Test
    @DisplayName("Hash Map: Equal prices that sum to m - [5, 5], m=10")
    public void testHashMapEqualPrices() {
        int m = 10;
        int[] cost = {5, 5};
        int[] result = IceCreamParlor.icecreamParlor(m, cost);

        assertNotNull(result);
        assertEquals(2, result.length);
        assertArrayEquals(new int[] {1, 2}, result);
        assertTrue(IceCreamParlor.isValidSolution(m, cost, result));
    }

    // ========================================
    // TESTS FOR APPROACH 2: BRUTE FORCE
    // ========================================

    @Test
    @DisplayName("Brute Force: HackerRank Example 1")
    public void testBruteForceExample1() {
        int m = 4;
        int[] cost = {1, 4, 5, 3, 2};
        int[] result = IceCreamParlor.icecreamParlorBruteForce(m, cost);

        assertNotNull(result);
        assertEquals(2, result.length);
        assertArrayEquals(new int[] {1, 4}, result);
        assertTrue(IceCreamParlor.isValidSolution(m, cost, result));
    }

    @Test
    @DisplayName("Brute Force: HackerRank Example 2")
    public void testBruteForceExample2() {
        int m = 4;
        int[] cost = {2, 2, 4, 3};
        int[] result = IceCreamParlor.icecreamParlorBruteForce(m, cost);

        assertNotNull(result);
        assertEquals(2, result.length);
        assertArrayEquals(new int[] {1, 2}, result);
        assertTrue(IceCreamParlor.isValidSolution(m, cost, result));
    }

    @Test
    @DisplayName("Brute Force: Large values")
    public void testBruteForceLargeValues() {
        int m = 100;
        int[] cost = {5, 75, 25, 100};
        int[] result = IceCreamParlor.icecreamParlorBruteForce(m, cost);

        assertNotNull(result);
        assertEquals(2, result.length);
        assertArrayEquals(new int[] {2, 3}, result);
        assertTrue(IceCreamParlor.isValidSolution(m, cost, result));
    }

    @Test
    @DisplayName("Brute Force: Two items only")
    public void testBruteForceTwoItems() {
        int m = 10;
        int[] cost = {3, 7};
        int[] result = IceCreamParlor.icecreamParlorBruteForce(m, cost);

        assertNotNull(result);
        assertEquals(2, result.length);
        assertArrayEquals(new int[] {1, 2}, result);
        assertTrue(IceCreamParlor.isValidSolution(m, cost, result));
    }

    // ========================================
    // EDGE CASE TESTS
    // ========================================

    @Test
    @DisplayName("Edge Case: Null array")
    public void testNullArray() {
        int m = 10;
        int[] cost = null;
        int[] result = IceCreamParlor.icecreamParlor(m, cost);

        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    @DisplayName("Edge Case: Single element array")
    public void testSingleElement() {
        int m = 5;
        int[] cost = {5};
        int[] result = IceCreamParlor.icecreamParlor(m, cost);

        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    @DisplayName("Edge Case: Empty array")
    public void testEmptyArray() {
        int m = 10;
        int[] cost = {};
        int[] result = IceCreamParlor.icecreamParlor(m, cost);

        assertNotNull(result);
        assertEquals(0, result.length);
    }

    // ========================================
    // COMPARISON TESTS (Hash Map vs Brute Force)
    // ========================================

    @Test
    @DisplayName("Comparison: Both approaches produce same result for Example 1")
    public void testComparisonExample1() {
        int m = 4;
        int[] cost = {1, 4, 5, 3, 2};

        int[] hashMapResult = IceCreamParlor.icecreamParlor(m, cost);
        int[] bruteForceResult = IceCreamParlor.icecreamParlorBruteForce(m, cost);

        assertArrayEquals(hashMapResult, bruteForceResult);
    }

    @Test
    @DisplayName("Comparison: Both approaches produce same result for Example 2")
    public void testComparisonExample2() {
        int m = 4;
        int[] cost = {2, 2, 4, 3};

        int[] hashMapResult = IceCreamParlor.icecreamParlor(m, cost);
        int[] bruteForceResult = IceCreamParlor.icecreamParlorBruteForce(m, cost);

        assertArrayEquals(hashMapResult, bruteForceResult);
    }

    @Test
    @DisplayName("Comparison: Both approaches produce valid result for large array")
    public void testComparisonLargeArray() {
        int m = 15;
        int[] cost = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int[] hashMapResult = IceCreamParlor.icecreamParlor(m, cost);
        int[] bruteForceResult = IceCreamParlor.icecreamParlorBruteForce(m, cost);

        // Both should be valid solutions (may be different since multiple solutions exist)
        assertTrue(IceCreamParlor.isValidSolution(m, cost, hashMapResult));
        assertTrue(IceCreamParlor.isValidSolution(m, cost, bruteForceResult));
    }

    // ========================================
    // VALIDATION TESTS
    // ========================================

    @Test
    @DisplayName("Validation: Valid solution returns true")
    public void testValidSolutionTrue() {
        int m = 4;
        int[] cost = {1, 4, 5, 3, 2};
        int[] result = {1, 4};

        assertTrue(IceCreamParlor.isValidSolution(m, cost, result));
    }

    @Test
    @DisplayName("Validation: Invalid solution returns false")
    public void testValidSolutionFalse() {
        int m = 4;
        int[] cost = {1, 4, 5, 3, 2};
        int[] result = {1, 2}; // Wrong indices

        assertFalse(IceCreamParlor.isValidSolution(m, cost, result));
    }

    @Test
    @DisplayName("Validation: Null result returns false")
    public void testValidSolutionNull() {
        int m = 4;
        int[] cost = {1, 4, 5, 3, 2};
        int[] result = null;

        assertFalse(IceCreamParlor.isValidSolution(m, cost, result));
    }

    @Test
    @DisplayName("Validation: Same index used twice returns false")
    public void testValidSolutionSameIndex() {
        int m = 4;
        int[] cost = {2, 4, 5, 3, 2};
        int[] result = {1, 1}; // Same index

        assertFalse(IceCreamParlor.isValidSolution(m, cost, result));
    }

    @Test
    @DisplayName("Validation: Out of bounds index returns false")
    public void testValidSolutionOutOfBounds() {
        int m = 4;
        int[] cost = {1, 4, 5, 3, 2};
        int[] result = {1, 10}; // Index 10 is out of bounds

        assertFalse(IceCreamParlor.isValidSolution(m, cost, result));
    }

    // ========================================
    // FORMAT RESULT TESTS
    // ========================================

    @Test
    @DisplayName("Format: Valid result produces proper format")
    public void testFormatValidResult() {
        int m = 4;
        int[] cost = {1, 4, 5, 3, 2};
        int[] result = {1, 4};

        String formatted = IceCreamParlor.formatResult(m, cost, result);

        assertNotNull(formatted);
        assertTrue(formatted.contains("Money: 4"));
        assertTrue(formatted.contains("Indices: [1, 4]"));
        assertTrue(formatted.contains("Prices: [1, 3]"));
        assertTrue(formatted.contains("Sum: 4"));
    }

    @Test
    @DisplayName("Format: Empty result produces no solution message")
    public void testFormatEmptyResult() {
        int m = 4;
        int[] cost = {1, 4, 5, 3, 2};
        int[] result = {};

        String formatted = IceCreamParlor.formatResult(m, cost, result);

        assertEquals("No solution found", formatted);
    }
}

