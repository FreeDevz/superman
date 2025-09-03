package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Comprehensive test suite for Binary Tree Inorder Traversal Tests all five approaches: Recursive,
 * Iterative with Stack, Morris Traversal, Two Stacks, and Hash Set
 */
public class BinaryTreeInorderTraversalTest {

    private BinaryTreeInorderTraversal solution;

    @BeforeEach
    void setUp() {
        solution = new BinaryTreeInorderTraversal();
    }

    // ========================================
    // TEST DATA PROVIDERS
    // ========================================

    /**
     * Provides test cases with input tree and expected inorder traversal
     */
    static Stream<Arguments> inorderTraversalTestCases() {
        return Stream.of(
                // LeetCode examples
                Arguments.of(new Integer[] {1, null, 2, 3}, List.of(1, 3, 2)),
                Arguments.of(new Integer[] {}, List.of()),
                Arguments.of(new Integer[] {1}, List.of(1)),

                // Simple trees
                Arguments.of(new Integer[] {1, 2, 3}, List.of(2, 1, 3)),
                Arguments.of(new Integer[] {1, 2, null}, List.of(2, 1)),
                Arguments.of(new Integer[] {1, null, 2}, List.of(1, 2)),

                // Balanced trees
                Arguments.of(new Integer[] {1, 2, 3, 4, 5, 6, 7}, List.of(4, 2, 5, 1, 6, 3, 7)),
                Arguments.of(new Integer[] {1, 2, 3, 4, 5}, List.of(4, 2, 5, 1, 3)),

                // Left-skewed trees
                Arguments.of(new Integer[] {3, 2, null, 1}, List.of(1, 2, 3)),
                Arguments.of(new Integer[] {4, 3, null, 2, null, 1}, List.of(1, 2, 3, 4)),

                // Right-skewed trees
                Arguments.of(new Integer[] {1, null, 2, null, 3}, List.of(1, 2, 3)),
                Arguments.of(new Integer[] {1, null, 2, null, 3, null, 4}, List.of(1, 2, 3, 4)),

                // Complex trees
                Arguments.of(new Integer[] {5, 3, 7, 1, 4, 6, 8}, List.of(1, 3, 4, 5, 6, 7, 8)),
                Arguments.of(new Integer[] {10, 5, 15, 3, 7, 12, 18},
                        List.of(3, 5, 7, 10, 12, 15, 18)),

                // Trees with negative values
                Arguments.of(new Integer[] {-1, -2, -3}, List.of(-2, -1, -3)),
                Arguments.of(new Integer[] {0, -1, 1}, List.of(-1, 0, 1)),

                // Edge cases
                Arguments.of(new Integer[] {100}, List.of(100)),
                Arguments.of(new Integer[] {-100}, List.of(-100)),
                Arguments.of(new Integer[] {0}, List.of(0)));
    }

    /**
     * Provides edge case test inputs
     */
    static Stream<Arguments> edgeCaseInputs() {
        return Stream.of(Arguments.of((Integer[]) null, "Null array"),
                Arguments.of(new Integer[] {}, "Empty array"),
                Arguments.of(new Integer[] {null}, "Single null"),
                Arguments.of(new Integer[] {null, null, null}, "Multiple nulls"));
    }

    /**
     * Provides performance test trees of different sizes
     */
    static Stream<Arguments> performanceTestCases() {
        return Stream.of(Arguments.of(generateBalancedTree(3), "Small balanced tree (7 nodes)"),
                Arguments.of(generateBalancedTree(4), "Medium balanced tree (15 nodes)"),
                Arguments.of(generateBalancedTree(5), "Large balanced tree (31 nodes)"),
                Arguments.of(generateBalancedTree(6), "Extra large balanced tree (63 nodes)"));
    }

    private static Integer[] generateBalancedTree(int height) {
        int size = (1 << height) - 1; // 2^height - 1
        Integer[] tree = new Integer[size];

        for (int i = 0; i < size; i++) {
            tree[i] = i + 1; // Fill with consecutive numbers
        }

        return tree;
    }

    // ========================================
    // APPROACH 1: RECURSIVE TESTS
    // ========================================

    @ParameterizedTest
    @MethodSource("inorderTraversalTestCases")
    @DisplayName("Test Recursive approach")
    void testInorderTraversalRecursive(Integer[] input, List<Integer> expected) {
        BinaryTreeInorderTraversal.TreeNode root = BinaryTreeInorderTraversal.createTree(input);
        List<Integer> result = solution.inorderTraversal(root);
        assertEquals(expected, result, String.format("Expected %s, got %s for input %s", expected,
                result, java.util.Arrays.toString(input)));
    }

    @Test
    @DisplayName("Test Recursive with specific examples")
    void testRecursiveSpecificCases() {
        // Test case 1: Classic LeetCode example
        Integer[] input1 = {1, null, 2, 3};
        BinaryTreeInorderTraversal.TreeNode root1 = BinaryTreeInorderTraversal.createTree(input1);
        List<Integer> result1 = solution.inorderTraversal(root1);
        assertEquals(List.of(1, 3, 2), result1);

        // Test case 2: Balanced tree
        Integer[] input2 = {1, 2, 3, 4, 5, 6, 7};
        BinaryTreeInorderTraversal.TreeNode root2 = BinaryTreeInorderTraversal.createTree(input2);
        List<Integer> result2 = solution.inorderTraversal(root2);
        assertEquals(List.of(4, 2, 5, 1, 6, 3, 7), result2);

        // Test case 3: Single node
        Integer[] input3 = {42};
        BinaryTreeInorderTraversal.TreeNode root3 = BinaryTreeInorderTraversal.createTree(input3);
        List<Integer> result3 = solution.inorderTraversal(root3);
        assertEquals(List.of(42), result3);
    }

    // ========================================
    // APPROACH 2: ITERATIVE WITH STACK TESTS
    // ========================================

    @ParameterizedTest
    @MethodSource("inorderTraversalTestCases")
    @DisplayName("Test Iterative with Stack approach")
    void testInorderTraversalIterative(Integer[] input, List<Integer> expected) {
        BinaryTreeInorderTraversal.TreeNode root = BinaryTreeInorderTraversal.createTree(input);
        List<Integer> result = solution.inorderTraversalIterative(root);
        assertEquals(expected, result, String.format("Expected %s, got %s for input %s", expected,
                result, java.util.Arrays.toString(input)));
    }

    @Test
    @DisplayName("Test Iterative with Stack complex case")
    void testIterativeComplexCase() {
        Integer[] input = {10, 5, 15, 3, 7, 12, 18, 1, 4, 6, 8, 11, 13, 16, 19};
        BinaryTreeInorderTraversal.TreeNode root = BinaryTreeInorderTraversal.createTree(input);
        List<Integer> result = solution.inorderTraversalIterative(root);

        // Expected: left subtree (1,3,4,5,6,7,8) + root (10) + right subtree (11,12,13,15,16,18,19)
        List<Integer> expected = List.of(1, 3, 4, 5, 6, 7, 8, 10, 11, 12, 13, 15, 16, 18, 19);
        assertEquals(expected, result);
    }

    // ========================================
    // APPROACH 3: MORRIS TRAVERSAL TESTS
    // ========================================

    @ParameterizedTest
    @MethodSource("inorderTraversalTestCases")
    @DisplayName("Test Morris Traversal approach")
    void testInorderTraversalMorris(Integer[] input, List<Integer> expected) {
        BinaryTreeInorderTraversal.TreeNode root = BinaryTreeInorderTraversal.createTree(input);
        List<Integer> result = solution.inorderTraversalMorris(root);
        assertEquals(expected, result, String.format("Expected %s, got %s for input %s", expected,
                result, java.util.Arrays.toString(input)));
    }

    @Test
    @DisplayName("Test Morris Traversal with left-skewed tree")
    void testMorrisLeftSkewed() {
        Integer[] input = {4, 3, null, 2, null, 1};
        BinaryTreeInorderTraversal.TreeNode root = BinaryTreeInorderTraversal.createTree(input);
        List<Integer> result = solution.inorderTraversalMorris(root);
        assertEquals(List.of(1, 2, 3, 4), result);
    }

    // ========================================
    // APPROACH 4: TWO STACKS TESTS
    // ========================================

    @ParameterizedTest
    @MethodSource("inorderTraversalTestCases")
    @DisplayName("Test Two Stacks approach")
    void testInorderTraversalTwoStacks(Integer[] input, List<Integer> expected) {
        BinaryTreeInorderTraversal.TreeNode root = BinaryTreeInorderTraversal.createTree(input);
        List<Integer> result = solution.inorderTraversalTwoStacks(root);
        assertEquals(expected, result, String.format("Expected %s, got %s for input %s", expected,
                result, java.util.Arrays.toString(input)));
    }

    @Test
    @DisplayName("Test Two Stacks with right-skewed tree")
    void testTwoStacksRightSkewed() {
        Integer[] input = {1, null, 2, null, 3, null, 4};
        BinaryTreeInorderTraversal.TreeNode root = BinaryTreeInorderTraversal.createTree(input);
        List<Integer> result = solution.inorderTraversalTwoStacks(root);
        assertEquals(List.of(1, 2, 3, 4), result);
    }

    // ========================================
    // APPROACH 5: HASH SET TESTS
    // ========================================

    @ParameterizedTest
    @MethodSource("inorderTraversalTestCases")
    @DisplayName("Test Hash Set approach")
    void testInorderTraversalHashSet(Integer[] input, List<Integer> expected) {
        BinaryTreeInorderTraversal.TreeNode root = BinaryTreeInorderTraversal.createTree(input);
        List<Integer> result = solution.inorderTraversalHashSet(root);
        assertEquals(expected, result, String.format("Expected %s, got %s for input %s", expected,
                result, java.util.Arrays.toString(input)));
    }

    @Test
    @DisplayName("Test Hash Set with balanced tree")
    void testHashSetBalanced() {
        Integer[] input = {5, 3, 7, 1, 4, 6, 8};
        BinaryTreeInorderTraversal.TreeNode root = BinaryTreeInorderTraversal.createTree(input);
        List<Integer> result = solution.inorderTraversalHashSet(root);
        assertEquals(List.of(1, 3, 4, 5, 6, 7, 8), result);
    }

    // ========================================
    // CROSS-VALIDATION TESTS
    // ========================================

    @Test
    @DisplayName("Test all approaches return same results")
    void testAllApproachesConsistency() {
        Integer[][] testCases = {{1, null, 2, 3}, {1, 2, 3, 4, 5, 6, 7}, {10, 5, 15, 3, 7, 12, 18},
                {1, 2, null}, {1, null, 2}, {5, 3, 7, 1, 4, 6, 8}};

        for (Integer[] testCase : testCases) {
            BinaryTreeInorderTraversal.TreeNode root =
                    BinaryTreeInorderTraversal.createTree(testCase);

            List<Integer> result1 = solution.inorderTraversal(root);
            List<Integer> result2 = solution.inorderTraversalIterative(root);
            List<Integer> result3 = solution.inorderTraversalMorris(root);
            List<Integer> result4 = solution.inorderTraversalTwoStacks(root);
            List<Integer> result5 = solution.inorderTraversalHashSet(root);

            assertTrue(solution.compareResults(result1, result2), String.format(
                    "Recursive and Iterative differ for %s", java.util.Arrays.toString(testCase)));
            assertTrue(solution.compareResults(result1, result3), String.format(
                    "Recursive and Morris differ for %s", java.util.Arrays.toString(testCase)));
            assertTrue(solution.compareResults(result1, result4), String.format(
                    "Recursive and Two Stacks differ for %s", java.util.Arrays.toString(testCase)));
            assertTrue(solution.compareResults(result1, result5), String.format(
                    "Recursive and Hash Set differ for %s", java.util.Arrays.toString(testCase)));
        }
    }

    // ========================================
    // EDGE CASE TESTS
    // ========================================

    @ParameterizedTest
    @MethodSource("edgeCaseInputs")
    @DisplayName("Test edge cases")
    void testEdgeCases(Integer[] input, String description) {
        BinaryTreeInorderTraversal.TreeNode root = BinaryTreeInorderTraversal.createTree(input);

        List<Integer> result1 = solution.inorderTraversal(root);
        List<Integer> result2 = solution.inorderTraversalIterative(root);
        List<Integer> result3 = solution.inorderTraversalMorris(root);
        List<Integer> result4 = solution.inorderTraversalTwoStacks(root);
        List<Integer> result5 = solution.inorderTraversalHashSet(root);

        // All should return empty list for invalid inputs
        assertTrue(result1.isEmpty(), description + ": Recursive should return empty");
        assertTrue(result2.isEmpty(), description + ": Iterative should return empty");
        assertTrue(result3.isEmpty(), description + ": Morris should return empty");
        assertTrue(result4.isEmpty(), description + ": Two Stacks should return empty");
        assertTrue(result5.isEmpty(), description + ": Hash Set should return empty");
    }

    @Test
    @DisplayName("Test null root handling")
    void testNullRoot() {
        assertDoesNotThrow(() -> {
            assertTrue(solution.inorderTraversal(null).isEmpty());
            assertTrue(solution.inorderTraversalIterative(null).isEmpty());
            assertTrue(solution.inorderTraversalMorris(null).isEmpty());
            assertTrue(solution.inorderTraversalTwoStacks(null).isEmpty());
            assertTrue(solution.inorderTraversalHashSet(null).isEmpty());
        });
    }

    // ========================================
    // UTILITY METHOD TESTS
    // ========================================

    @Test
    @DisplayName("Test utility methods")
    void testUtilityMethods() {
        // Test createTree
        Integer[] values = {1, 2, 3, 4, 5};
        BinaryTreeInorderTraversal.TreeNode root = BinaryTreeInorderTraversal.createTree(values);
        assertNotNull(root);
        assertEquals(1, root.val);
        assertEquals(2, root.left.val);
        assertEquals(3, root.right.val);

        // Test createTreeFromString
        BinaryTreeInorderTraversal.TreeNode rootFromString =
                BinaryTreeInorderTraversal.createTreeFromString("[1,2,3,4,5]");
        assertNotNull(rootFromString);
        assertEquals(1, rootFromString.val);

        // Test treeToString
        String treeString = BinaryTreeInorderTraversal.treeToString(root);
        assertTrue(treeString.contains("1"));
        assertTrue(treeString.contains("2"));
        assertTrue(treeString.contains("3"));

        // Test getTreeStatistics
        String stats = BinaryTreeInorderTraversal.getTreeStatistics(root);
        assertTrue(stats.contains("5 nodes"));
        assertTrue(stats.contains("Height: 2"));
        assertTrue(stats.contains("Leaves: 3"));

        // Test compareResults
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(1, 2, 3);
        List<Integer> list3 = List.of(1, 2, 4);

        assertTrue(solution.compareResults(list1, list2));
        assertFalse(solution.compareResults(list1, list3));

        // Test isValidInorderTraversal
        List<Integer> result = solution.inorderTraversal(root);
        assertTrue(solution.isValidInorderTraversal(root, result));
    }

    @Test
    @DisplayName("Test tree creation edge cases")
    void testTreeCreationEdgeCases() {
        // Test empty array
        BinaryTreeInorderTraversal.TreeNode emptyRoot =
                BinaryTreeInorderTraversal.createTree(new Integer[] {});
        assertNull(emptyRoot);

        // Test array with null root
        BinaryTreeInorderTraversal.TreeNode nullRoot =
                BinaryTreeInorderTraversal.createTree(new Integer[] {null});
        assertNull(nullRoot);

        // Test string creation
        BinaryTreeInorderTraversal.TreeNode stringRoot =
                BinaryTreeInorderTraversal.createTreeFromString("1,null,2,3");
        assertNotNull(stringRoot);
        assertEquals(1, stringRoot.val);
        assertNull(stringRoot.left);
        assertEquals(2, stringRoot.right.val);
        assertEquals(3, stringRoot.right.left.val);
    }

    // ========================================
    // PERFORMANCE TESTS
    // ========================================

    @ParameterizedTest
    @MethodSource("performanceTestCases")
    @DisplayName("Test performance comparison")
    void testPerformanceComparison(Integer[] input, String description) {
        BinaryTreeInorderTraversal.TreeNode root = BinaryTreeInorderTraversal.createTree(input);

        long[] times = new long[5];

        // Measure each approach
        times[0] = solution.measureExecutionTime(() -> solution.inorderTraversal(root));
        times[1] = solution.measureExecutionTime(() -> solution.inorderTraversalIterative(root));
        times[2] = solution.measureExecutionTime(() -> solution.inorderTraversalMorris(root));
        times[3] = solution.measureExecutionTime(() -> solution.inorderTraversalTwoStacks(root));
        times[4] = solution.measureExecutionTime(() -> solution.inorderTraversalHashSet(root));

        // Verify all produce same results
        List<Integer> result1 = solution.inorderTraversal(root);
        List<Integer> result2 = solution.inorderTraversalIterative(root);
        List<Integer> result3 = solution.inorderTraversalMorris(root);
        List<Integer> result4 = solution.inorderTraversalTwoStacks(root);
        List<Integer> result5 = solution.inorderTraversalHashSet(root);

        assertTrue(solution.compareResults(result1, result2),
                description + ": Recursive and Iterative should match");
        assertTrue(solution.compareResults(result1, result3),
                description + ": Recursive and Morris should match");
        assertTrue(solution.compareResults(result1, result4),
                description + ": Recursive and Two Stacks should match");
        assertTrue(solution.compareResults(result1, result5),
                description + ": Recursive and Hash Set should match");

        // All should complete within reasonable time (100ms)
        assertTrue(times[0] < 100_000_000, description + ": Recursive should be fast");
        assertTrue(times[1] < 100_000_000, description + ": Iterative should be fast");
        assertTrue(times[2] < 100_000_000, description + ": Morris should be fast");
        assertTrue(times[3] < 100_000_000, description + ": Two Stacks should be fast");
        assertTrue(times[4] < 100_000_000, description + ": Hash Set should be fast");
    }

    @Test
    @DisplayName("Test constraint boundaries")
    void testConstraintBoundaries() {
        // Test maximum constraint values (100 nodes)
        Integer[] maxSizeArray = new Integer[100];
        for (int i = 0; i < 100; i++) {
            maxSizeArray[i] = i + 1; // Fill with consecutive numbers
        }

        assertDoesNotThrow(() -> {
            BinaryTreeInorderTraversal.TreeNode root =
                    BinaryTreeInorderTraversal.createTree(maxSizeArray);
            List<Integer> result = solution.inorderTraversal(root);
            assertNotNull(result);
            assertEquals(100, result.size());
        });
    }

    @Test
    @DisplayName("Test with maximum node values")
    void testMaximumNodeValues() {
        // Test with maximum constraint values (-100 to 100)
        Integer[] extremeValues = {-100, 0, 100, -50, 50, -25, 25};
        BinaryTreeInorderTraversal.TreeNode root =
                BinaryTreeInorderTraversal.createTree(extremeValues);

        assertDoesNotThrow(() -> {
            List<Integer> result = solution.inorderTraversal(root);
            assertNotNull(result);
            assertTrue(result.contains(-100));
            assertTrue(result.contains(100));
            assertTrue(result.contains(0));
        });
    }

    @Test
    @DisplayName("Test tree structure preservation")
    void testTreeStructurePreservation() {
        // Create a complex tree
        Integer[] complexTree = {10, 5, 15, 3, 7, 12, 18, 1, 4, 6, 8, 11, 13, 16, 19};
        BinaryTreeInorderTraversal.TreeNode root =
                BinaryTreeInorderTraversal.createTree(complexTree);

        // Verify tree structure is preserved after all traversals
        String originalTree = BinaryTreeInorderTraversal.treeToString(root);

        // Run all traversal methods
        solution.inorderTraversal(root);
        solution.inorderTraversalIterative(root);
        solution.inorderTraversalMorris(root);
        solution.inorderTraversalTwoStacks(root);
        solution.inorderTraversalHashSet(root);

        String afterTraversals = BinaryTreeInorderTraversal.treeToString(root);
        assertEquals(originalTree, afterTraversals,
                "Tree structure should be preserved after all traversals");
    }
}
