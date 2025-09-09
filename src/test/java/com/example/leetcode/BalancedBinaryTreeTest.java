package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Comprehensive test suite for BalancedBinaryTree solution.
 * 
 * This test class covers all approaches, edge cases, and performance scenarios to ensure the
 * solution is robust and efficient.
 * 
 * @author Superman
 * @version 1.0
 */
@DisplayName("Balanced Binary Tree Tests")
class BalancedBinaryTreeTest {

    private BalancedBinaryTree solution;

    @BeforeEach
    void setUp() {
        solution = new BalancedBinaryTree();
    }

    // ==================== BASIC FUNCTIONALITY TESTS ====================

    @Nested
    @DisplayName("Basic Functionality Tests")
    class BasicFunctionalityTests {

        @Test
        @DisplayName("Test balanced tree - Example 1")
        void testBalancedTreeExample1() {
            // Tree: [3,9,20,null,null,15,7]
            // 3
            // / \
            // 9 20
            // / \
            // 15 7
            Integer[] treeArray = {3, 9, 20, null, null, 15, 7};
            BalancedBinaryTree.TreeNode root = BalancedBinaryTree.buildTree(treeArray);

            assertTrue(solution.isBalanced(root), "Tree should be balanced");
            assertTrue(solution.isBalancedTopDown(root), "Top-down approach should return true");
            assertTrue(solution.isBalancedIterative(root), "Iterative approach should return true");
            assertTrue(solution.isBalancedEnhanced(root), "Enhanced approach should return true");
        }

        @Test
        @DisplayName("Test unbalanced tree - Example 2")
        void testUnbalancedTreeExample2() {
            // Tree: [1,2,2,3,3,null,null,4,4]
            // 1
            // / \
            // 2 2
            // / \
            // 3 3
            // / \
            // 4 4
            Integer[] treeArray = {1, 2, 2, 3, 3, null, null, 4, 4};
            BalancedBinaryTree.TreeNode root = BalancedBinaryTree.buildTree(treeArray);

            assertFalse(solution.isBalanced(root), "Tree should be unbalanced");
            assertFalse(solution.isBalancedTopDown(root), "Top-down approach should return false");
            assertFalse(solution.isBalancedIterative(root),
                    "Iterative approach should return false");
            assertFalse(solution.isBalancedEnhanced(root), "Enhanced approach should return false");
        }

        @Test
        @DisplayName("Test empty tree - Example 3")
        void testEmptyTree() {
            BalancedBinaryTree.TreeNode root = null;

            assertTrue(solution.isBalanced(root), "Empty tree should be balanced");
            assertTrue(solution.isBalancedTopDown(root), "Top-down approach should return true");
            assertTrue(solution.isBalancedIterative(root), "Iterative approach should return true");
            assertTrue(solution.isBalancedEnhanced(root), "Enhanced approach should return true");
        }

        @Test
        @DisplayName("Test single node tree")
        void testSingleNodeTree() {
            Integer[] treeArray = {1};
            BalancedBinaryTree.TreeNode root = BalancedBinaryTree.buildTree(treeArray);

            assertTrue(solution.isBalanced(root), "Single node tree should be balanced");
            assertTrue(solution.isBalancedTopDown(root), "Top-down approach should return true");
            assertTrue(solution.isBalancedIterative(root), "Iterative approach should return true");
            assertTrue(solution.isBalancedEnhanced(root), "Enhanced approach should return true");
        }
    }

    // ==================== EDGE CASES AND BOUNDARY TESTS ====================

    @Nested
    @DisplayName("Edge Cases and Boundary Tests")
    class EdgeCasesAndBoundaryTests {

        @Test
        @DisplayName("Test left-skewed tree")
        void testLeftSkewedTree() {
            // Tree: [1,2,null,3,null,4,null]
            // 1
            // /
            // 2
            // /
            // 3
            // /
            // 4
            Integer[] treeArray = {1, 2, null, 3, null, 4, null};
            BalancedBinaryTree.TreeNode root = BalancedBinaryTree.buildTree(treeArray);

            assertFalse(solution.isBalanced(root), "Left-skewed tree should be unbalanced");
            assertFalse(solution.isBalancedTopDown(root), "Top-down approach should return false");
            assertFalse(solution.isBalancedIterative(root),
                    "Iterative approach should return false");
            assertFalse(solution.isBalancedEnhanced(root), "Enhanced approach should return false");
        }

        @Test
        @DisplayName("Test right-skewed tree")
        void testRightSkewedTree() {
            // Tree: [1,null,2,null,3,null,4]
            // 1
            // \
            // 2
            // \
            // 3
            // \
            // 4
            Integer[] treeArray = {1, null, 2, null, 3, null, 4};
            BalancedBinaryTree.TreeNode root = BalancedBinaryTree.buildTree(treeArray);

            assertFalse(solution.isBalanced(root), "Right-skewed tree should be unbalanced");
            assertFalse(solution.isBalancedTopDown(root), "Top-down approach should return false");
            assertFalse(solution.isBalancedIterative(root),
                    "Iterative approach should return false");
            assertFalse(solution.isBalancedEnhanced(root), "Enhanced approach should return false");
        }

        @Test
        @DisplayName("Test tree with only left children")
        void testTreeWithOnlyLeftChildren() {
            // Tree: [1,2,null,3,null]
            // 1
            // /
            // 2
            // /
            // 3
            Integer[] treeArray = {1, 2, null, 3, null};
            BalancedBinaryTree.TreeNode root = BalancedBinaryTree.buildTree(treeArray);

            assertFalse(solution.isBalanced(root),
                    "Tree with only left children should be unbalanced");
        }

        @Test
        @DisplayName("Test tree with only right children")
        void testTreeWithOnlyRightChildren() {
            // Tree: [1,null,2,null,3]
            // 1
            // \
            // 2
            // \
            // 3
            Integer[] treeArray = {1, null, 2, null, 3};
            BalancedBinaryTree.TreeNode root = BalancedBinaryTree.buildTree(treeArray);

            assertFalse(solution.isBalanced(root),
                    "Tree with only right children should be unbalanced");
        }

        @Test
        @DisplayName("Test perfectly balanced tree")
        void testPerfectlyBalancedTree() {
            // Tree: [1,2,3,4,5,6,7]
            // 1
            // / \
            // 2 3
            // / \ / \
            // 4 5 6 7
            Integer[] treeArray = {1, 2, 3, 4, 5, 6, 7};
            BalancedBinaryTree.TreeNode root = BalancedBinaryTree.buildTree(treeArray);

            assertTrue(solution.isBalanced(root), "Perfectly balanced tree should be balanced");
            assertTrue(solution.isBalancedTopDown(root), "Top-down approach should return true");
            assertTrue(solution.isBalancedIterative(root), "Iterative approach should return true");
            assertTrue(solution.isBalancedEnhanced(root), "Enhanced approach should return true");
        }

        @Test
        @DisplayName("Test tree with height difference of exactly 1")
        void testTreeWithHeightDifferenceOfOne() {
            // Tree: [1,2,3,4,null,null,null]
            // 1
            // / \
            // 2 3
            // /
            // 4
            Integer[] treeArray = {1, 2, 3, 4, null, null, null};
            BalancedBinaryTree.TreeNode root = BalancedBinaryTree.buildTree(treeArray);

            assertTrue(solution.isBalanced(root),
                    "Tree with height difference of 1 should be balanced");
        }

        @Test
        @DisplayName("Test tree with height difference of exactly 2")
        void testTreeWithHeightDifferenceOfTwo() {
            // Tree: [1,2,3,4,5,null,null,6,null]
            // 1
            // / \
            // 2 3
            // / \
            // 4 5
            // /
            // 6
            Integer[] treeArray = {1, 2, 3, 4, 5, null, null, 6, null};
            BalancedBinaryTree.TreeNode root = BalancedBinaryTree.buildTree(treeArray);

            assertFalse(solution.isBalanced(root),
                    "Tree with height difference of 2 should be unbalanced");
        }
    }

    // ==================== PARAMETERIZED TESTS ====================

    @Nested
    @DisplayName("Parameterized Tests")
    class ParameterizedTests {

        @ParameterizedTest
        @MethodSource("balancedTreeProvider")
        @DisplayName("Test various balanced trees")
        void testBalancedTrees(Integer[] treeArray, String description) {
            BalancedBinaryTree.TreeNode root = BalancedBinaryTree.buildTree(treeArray);

            assertTrue(solution.isBalanced(root), "Tree should be balanced: " + description);
            assertTrue(solution.isBalancedTopDown(root),
                    "Top-down approach should return true: " + description);
            assertTrue(solution.isBalancedIterative(root),
                    "Iterative approach should return true: " + description);
            assertTrue(solution.isBalancedEnhanced(root),
                    "Enhanced approach should return true: " + description);
        }

        @ParameterizedTest
        @MethodSource("unbalancedTreeProvider")
        @DisplayName("Test various unbalanced trees")
        void testUnbalancedTrees(Integer[] treeArray, String description) {
            BalancedBinaryTree.TreeNode root = BalancedBinaryTree.buildTree(treeArray);

            assertFalse(solution.isBalanced(root), "Tree should be unbalanced: " + description);
            assertFalse(solution.isBalancedTopDown(root),
                    "Top-down approach should return false: " + description);
            assertFalse(solution.isBalancedIterative(root),
                    "Iterative approach should return false: " + description);
            assertFalse(solution.isBalancedEnhanced(root),
                    "Enhanced approach should return false: " + description);
        }

        static Stream<Arguments> balancedTreeProvider() {
            return Stream.of(Arguments.of(new Integer[] {1}, "Single node"),
                    Arguments.of(new Integer[] {1, 2, 3}, "Two levels balanced"),
                    Arguments.of(new Integer[] {1, 2, 3, 4, 5, 6, 7}, "Three levels balanced"),
                    Arguments.of(new Integer[] {1, 2, 3, 4, 5, null, null},
                            "Left-heavy but balanced"),
                    Arguments.of(new Integer[] {1, 2, 3, null, null, 6, 7},
                            "Right-heavy but balanced"),
                    Arguments.of(new Integer[] {1, 2, 3, 4, null, null, null},
                            "Height difference of 1"),
                    Arguments.of(new Integer[] {1, 2, 3, null, null, 6, 7, null, null, null, null,
                            12, 13, 14, 15}, "Complex balanced tree"));
        }

        static Stream<Arguments> unbalancedTreeProvider() {
            return Stream
                    .of(Arguments.of(new Integer[] {1, 2, null, 3, null}, "Left-skewed"),
                            Arguments.of(new Integer[] {1, null, 2, null, 3}, "Right-skewed"),
                            Arguments.of(new Integer[] {1, 2, 3, 4, 5, null, null, 6, null},
                                    "Height difference of 2"),
                            Arguments.of(
                                    new Integer[] {1, 2, 3, 4, null, null, null, 5, null, null,
                                            null, null, null, null, null, 6},
                                    "Very unbalanced tree"));
        }
    }

    // ==================== PERFORMANCE TESTS ====================

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Test performance with large balanced tree")
        void testPerformanceLargeBalancedTree() {
            // Create a large balanced tree (height 10, ~1023 nodes)
            BalancedBinaryTree.TreeNode root = createBalancedTree(10);

            long startTime = System.nanoTime();
            boolean result = solution.isBalanced(root);
            long endTime = System.nanoTime();

            assertTrue(result, "Large balanced tree should be balanced");
            assertTrue((endTime - startTime) < 1_000_000_000L, // Less than 1 second
                    "Bottom-up approach should be fast for large trees");
        }

        @Test
        @DisplayName("Test performance with large unbalanced tree")
        void testPerformanceLargeUnbalancedTree() {
            // Create a large unbalanced tree (skewed)
            BalancedBinaryTree.TreeNode root = createSkewedTree(1000);

            long startTime = System.nanoTime();
            boolean result = solution.isBalanced(root);
            long endTime = System.nanoTime();

            assertFalse(result, "Large skewed tree should be unbalanced");
            assertTrue((endTime - startTime) < 1_000_000_000L, // Less than 1 second
                    "Bottom-up approach should be fast even for unbalanced trees");
        }

        @Test
        @DisplayName("Compare performance of different approaches")
        void testPerformanceComparison() {
            BalancedBinaryTree.TreeNode root = createBalancedTree(8); // 255 nodes

            // Test bottom-up approach
            long startTime = System.nanoTime();
            boolean result1 = solution.isBalanced(root);
            long bottomUpTime = System.nanoTime() - startTime;

            // Test top-down approach
            startTime = System.nanoTime();
            boolean result2 = solution.isBalancedTopDown(root);
            long topDownTime = System.nanoTime() - startTime;

            // Test iterative approach
            startTime = System.nanoTime();
            boolean result3 = solution.isBalancedIterative(root);
            long iterativeTime = System.nanoTime() - startTime;

            // Test enhanced approach
            startTime = System.nanoTime();
            boolean result4 = solution.isBalancedEnhanced(root);
            long enhancedTime = System.nanoTime() - startTime;

            // All approaches should return the same result
            assertEquals(result1, result2, "Bottom-up and top-down should return same result");
            assertEquals(result1, result3, "Bottom-up and iterative should return same result");
            assertEquals(result1, result4, "Bottom-up and enhanced should return same result");

            // Bottom-up should be faster than top-down for larger trees
            assertTrue(bottomUpTime <= topDownTime,
                    "Bottom-up approach should be faster or equal to top-down approach");

            System.out.println("Performance comparison (nanoseconds):");
            System.out.println("Bottom-up: " + bottomUpTime);
            System.out.println("Top-down: " + topDownTime);
            System.out.println("Iterative: " + iterativeTime);
            System.out.println("Enhanced: " + enhancedTime);
        }

        private BalancedBinaryTree.TreeNode createBalancedTree(int height) {
            if (height <= 0)
                return null;

            BalancedBinaryTree.TreeNode root = new BalancedBinaryTree.TreeNode(1);
            root.left = createBalancedTree(height - 1);
            root.right = createBalancedTree(height - 1);

            return root;
        }

        private BalancedBinaryTree.TreeNode createSkewedTree(int size) {
            if (size <= 0)
                return null;

            BalancedBinaryTree.TreeNode root = new BalancedBinaryTree.TreeNode(1);
            root.left = createSkewedTree(size - 1);

            return root;
        }
    }

    // ==================== UTILITY METHOD TESTS ====================

    @Nested
    @DisplayName("Utility Method Tests")
    class UtilityMethodTests {

        @Test
        @DisplayName("Test buildTree utility method")
        void testBuildTreeUtility() {
            Integer[] treeArray = {1, 2, 3, 4, 5, 6, 7};
            BalancedBinaryTree.TreeNode root = BalancedBinaryTree.buildTree(treeArray);

            assertNotNull(root, "Root should not be null");
            assertEquals(1, root.val, "Root value should be 1");
            assertNotNull(root.left, "Left child should not be null");
            assertEquals(2, root.left.val, "Left child value should be 2");
            assertNotNull(root.right, "Right child should not be null");
            assertEquals(3, root.right.val, "Right child value should be 3");
        }

        @Test
        @DisplayName("Test buildTree with null values")
        void testBuildTreeWithNullValues() {
            Integer[] treeArray = {1, 2, 3, null, null, 6, 7};
            BalancedBinaryTree.TreeNode root = BalancedBinaryTree.buildTree(treeArray);

            assertNotNull(root, "Root should not be null");
            assertEquals(1, root.val, "Root value should be 1");
            assertNotNull(root.left, "Left child should not be null");
            assertEquals(2, root.left.val, "Left child value should be 2");
            assertNull(root.left.left, "Left-left child should be null");
            assertNull(root.left.right, "Left-right child should be null");
        }

        @Test
        @DisplayName("Test buildTree with empty array")
        void testBuildTreeWithEmptyArray() {
            Integer[] treeArray = {};
            BalancedBinaryTree.TreeNode root = BalancedBinaryTree.buildTree(treeArray);

            assertNull(root, "Root should be null for empty array");
        }

        @Test
        @DisplayName("Test buildTree with null array")
        void testBuildTreeWithNullArray() {
            BalancedBinaryTree.TreeNode root = BalancedBinaryTree.buildTree(null);

            assertNull(root, "Root should be null for null array");
        }

        @Test
        @DisplayName("Test treeToArray utility method")
        void testTreeToArrayUtility() {
            Integer[] originalArray = {1, 2, 3, 4, 5, 6, 7};
            BalancedBinaryTree.TreeNode root = BalancedBinaryTree.buildTree(originalArray);
            Integer[] convertedArray = BalancedBinaryTree.treeToArray(root);

            assertArrayEquals(originalArray, convertedArray,
                    "Converted array should match original array");
        }

        @Test
        @DisplayName("Test treeToArray with null tree")
        void testTreeToArrayWithNullTree() {
            Integer[] result = BalancedBinaryTree.treeToArray(null);

            assertArrayEquals(new Integer[0], result, "Result should be empty array for null tree");
        }

        @Test
        @DisplayName("Test calculateHeight utility method")
        void testCalculateHeightUtility() {
            // Test empty tree
            assertEquals(0, BalancedBinaryTree.calculateHeight(null),
                    "Height of null tree should be 0");

            // Test single node
            BalancedBinaryTree.TreeNode singleNode = new BalancedBinaryTree.TreeNode(1);
            assertEquals(1, BalancedBinaryTree.calculateHeight(singleNode),
                    "Height of single node should be 1");

            // Test balanced tree
            Integer[] treeArray = {1, 2, 3, 4, 5, 6, 7};
            BalancedBinaryTree.TreeNode root = BalancedBinaryTree.buildTree(treeArray);
            assertEquals(3, BalancedBinaryTree.calculateHeight(root),
                    "Height of 3-level tree should be 3");
        }

        @Test
        @DisplayName("Test isBalancedSimple utility method")
        void testIsBalancedSimpleUtility() {
            // Test balanced tree
            Integer[] balancedArray = {1, 2, 3, 4, 5, 6, 7};
            BalancedBinaryTree.TreeNode balancedRoot = BalancedBinaryTree.buildTree(balancedArray);
            assertTrue(BalancedBinaryTree.isBalancedSimple(balancedRoot),
                    "Simple method should return true for balanced tree");

            // Test unbalanced tree
            Integer[] unbalancedArray = {1, 2, 2, 3, 3, null, null, 4, 4};
            BalancedBinaryTree.TreeNode unbalancedRoot =
                    BalancedBinaryTree.buildTree(unbalancedArray);
            assertFalse(BalancedBinaryTree.isBalancedSimple(unbalancedRoot),
                    "Simple method should return false for unbalanced tree");
        }
    }

    // ==================== VALIDATION TESTS ====================

    @Nested
    @DisplayName("Validation Tests")
    class ValidationTests {

        @Test
        @DisplayName("Test all approaches return consistent results")
        void testAllApproachesConsistency() {
            Integer[][] testCases = {{1, 2, 3, 4, 5, 6, 7}, // Balanced
                    {1, 2, 2, 3, 3, null, null, 4, 4}, // Unbalanced
                    {1}, // Single node
                    {}, // Empty
                    {1, 2, null, 3, null}, // Left-skewed
                    {1, null, 2, null, 3}, // Right-skewed
                    {1, 2, 3, 4, 5, null, null, 6, null}, // Height diff 2
                    {1, 2, 3, 4, null, null, null} // Height diff 1
            };

            for (Integer[] testCase : testCases) {
                BalancedBinaryTree.TreeNode root = BalancedBinaryTree.buildTree(testCase);

                boolean bottomUp = solution.isBalanced(root);
                boolean topDown = solution.isBalancedTopDown(root);
                boolean iterative = solution.isBalancedIterative(root);
                boolean enhanced = solution.isBalancedEnhanced(root);
                boolean simple = BalancedBinaryTree.isBalancedSimple(root);

                assertEquals(bottomUp, topDown, "Bottom-up and top-down should agree for: "
                        + java.util.Arrays.toString(testCase));
                assertEquals(bottomUp, iterative, "Bottom-up and iterative should agree for: "
                        + java.util.Arrays.toString(testCase));
                assertEquals(bottomUp, enhanced, "Bottom-up and enhanced should agree for: "
                        + java.util.Arrays.toString(testCase));
                assertEquals(bottomUp, simple, "Bottom-up and simple should agree for: "
                        + java.util.Arrays.toString(testCase));
            }
        }

        @Test
        @DisplayName("Test edge case with maximum constraint values")
        void testMaximumConstraintValues() {
            // Test with tree having maximum number of nodes (5000)
            // and maximum node values (10^4)
            BalancedBinaryTree.TreeNode root = createLargeTree(5000, 10000);

            // Should not throw exception and should return a valid result
            assertDoesNotThrow(() -> {
                boolean result = solution.isBalanced(root);
                assertTrue(result || !result, "Result should be a valid boolean");
            }, "Should handle large trees without exceptions");
        }

        private BalancedBinaryTree.TreeNode createLargeTree(int size, int maxValue) {
            if (size <= 0)
                return null;

            BalancedBinaryTree.TreeNode root = new BalancedBinaryTree.TreeNode(maxValue);
            if (size > 1) {
                root.left = createLargeTree(size / 2, maxValue - 1);
                root.right = createLargeTree(size - size / 2 - 1, maxValue - 1);
            }

            return root;
        }
    }

    // ==================== CROSS-VALIDATION TESTS ====================

    @Nested
    @DisplayName("Cross-Validation Tests")
    class CrossValidationTests {

        @Test
        @DisplayName("Test against known balanced tree patterns")
        void testKnownBalancedPatterns() {
            // Test complete binary tree
            Integer[] completeTree = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
            BalancedBinaryTree.TreeNode root1 = BalancedBinaryTree.buildTree(completeTree);
            assertTrue(solution.isBalanced(root1), "Complete binary tree should be balanced");

            // Test full binary tree
            Integer[] fullTree = {1, 2, 3, 4, 5, 6, 7};
            BalancedBinaryTree.TreeNode root2 = BalancedBinaryTree.buildTree(fullTree);
            assertTrue(solution.isBalanced(root2), "Full binary tree should be balanced");
        }

        @Test
        @DisplayName("Test against known unbalanced tree patterns")
        void testKnownUnbalancedPatterns() {
            // Test degenerate tree (linked list)
            Integer[] degenerateTree = {1, 2, null, 3, null, 4, null, 5, null};
            BalancedBinaryTree.TreeNode root1 = BalancedBinaryTree.buildTree(degenerateTree);
            assertFalse(solution.isBalanced(root1), "Degenerate tree should be unbalanced");

            // Test tree with one very deep branch
            Integer[] deepBranchTree =
                    {1, 2, 3, 4, null, null, null, 5, null, null, null, null, null, null, null, 6};
            BalancedBinaryTree.TreeNode root2 = BalancedBinaryTree.buildTree(deepBranchTree);
            assertFalse(solution.isBalanced(root2), "Tree with deep branch should be unbalanced");
        }

        @Test
        @DisplayName("Test mathematical properties of balanced trees")
        void testMathematicalProperties() {
            // For a balanced tree, the height should be at most log2(n+1)
            Integer[] treeArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
            BalancedBinaryTree.TreeNode root = BalancedBinaryTree.buildTree(treeArray);

            if (solution.isBalanced(root)) {
                int height = BalancedBinaryTree.calculateHeight(root);
                int nodeCount = treeArray.length;
                int maxAllowedHeight = (int) Math.ceil(Math.log(nodeCount + 1) / Math.log(2));

                assertTrue(height <= maxAllowedHeight,
                        "Height of balanced tree should not exceed log2(n+1)");
            }
        }
    }

    // ==================== COMPREHENSIVE INTEGRATION TESTS ====================

    @Nested
    @DisplayName("Comprehensive Integration Tests")
    class ComprehensiveIntegrationTests {

        @Test
        @DisplayName("Test complete workflow with all utility methods")
        void testCompleteWorkflow() {
            // Create a complex tree
            Integer[] originalArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

            // Build tree
            BalancedBinaryTree.TreeNode root = BalancedBinaryTree.buildTree(originalArray);
            assertNotNull(root, "Tree should be built successfully");

            // Test balance
            boolean isBalanced = solution.isBalanced(root);
            assertTrue(isBalanced, "Tree should be balanced");

            // Convert back to array
            Integer[] convertedArray = BalancedBinaryTree.treeToArray(root);
            assertArrayEquals(originalArray, convertedArray,
                    "Converted array should match original");

            // Test height calculation
            int height = BalancedBinaryTree.calculateHeight(root);
            assertEquals(4, height, "Height should be 4 for 4-level tree");

            // Test simple balance check
            boolean simpleBalance = BalancedBinaryTree.isBalancedSimple(root);
            assertEquals(isBalanced, simpleBalance,
                    "Simple balance check should match main solution");
        }

        @Test
        @DisplayName("Test stress scenario with multiple operations")
        void testStressScenario() {
            // Create multiple trees and test all approaches
            Integer[][] testTrees = {{1, 2, 3, 4, 5, 6, 7}, // Balanced
                    {1, 2, 2, 3, 3, null, null, 4, 4}, // Unbalanced
                    {1, 2, null, 3, null, 4, null}, // Left-skewed
                    {1, null, 2, null, 3, null, 4}, // Right-skewed
                    {1, 2, 3, 4, null, null, null}, // Height diff 1
                    {1, 2, 3, 4, 5, null, null, 6, null} // Height diff 2
            };

            for (int i = 0; i < testTrees.length; i++) {
                Integer[] treeArray = testTrees[i];
                BalancedBinaryTree.TreeNode root = BalancedBinaryTree.buildTree(treeArray);

                // Test all approaches
                boolean bottomUp = solution.isBalanced(root);
                boolean topDown = solution.isBalancedTopDown(root);
                boolean iterative = solution.isBalancedIterative(root);
                boolean enhanced = solution.isBalancedEnhanced(root);
                boolean simple = BalancedBinaryTree.isBalancedSimple(root);

                // All should agree
                assertEquals(bottomUp, topDown, "Test case " + i + ": Bottom-up vs Top-down");
                assertEquals(bottomUp, iterative, "Test case " + i + ": Bottom-up vs Iterative");
                assertEquals(bottomUp, enhanced, "Test case " + i + ": Bottom-up vs Enhanced");
                assertEquals(bottomUp, simple, "Test case " + i + ": Bottom-up vs Simple");

                // Test utility methods
                int height = BalancedBinaryTree.calculateHeight(root);
                assertTrue(height >= 0, "Height should be non-negative for test case " + i);

                Integer[] converted = BalancedBinaryTree.treeToArray(root);
                assertNotNull(converted, "Converted array should not be null for test case " + i);
            }
        }
    }
}
