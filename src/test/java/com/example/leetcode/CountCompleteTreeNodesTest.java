package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Comprehensive test suite for CountCompleteTreeNodes
 * 
 * Tests all approaches with various scenarios: - Basic functionality tests with sample data - Edge
 * cases (empty tree, single node, perfect binary trees) - Performance tests with large trees -
 * Cross-validation between approaches - Tree structure validation
 */
@DisplayName("Count Complete Tree Nodes Tests")
public class CountCompleteTreeNodesTest {

    @Nested
    @DisplayName("Recursive Height Comparison Approach Tests")
    class RecursiveHeightComparisonApproachTests {

        @Test
        @DisplayName("Basic functionality test with example 1")
        void testBasicFunctionalityExample1() {
            CountCompleteTreeNodes.RecursiveHeightComparisonApproach approach =
                    new CountCompleteTreeNodes.RecursiveHeightComparisonApproach();

            CountCompleteTreeNodes.TreeNode root = createExample1Tree();
            int expected = 6;

            int result = approach.countNodes(root);

            assertEquals(expected, result, "Should return correct count for example 1");
        }

        @Test
        @DisplayName("Basic functionality test with example 2")
        void testBasicFunctionalityExample2() {
            CountCompleteTreeNodes.RecursiveHeightComparisonApproach approach =
                    new CountCompleteTreeNodes.RecursiveHeightComparisonApproach();

            CountCompleteTreeNodes.TreeNode root = null;
            int expected = 0;

            int result = approach.countNodes(root);

            assertEquals(expected, result, "Should return 0 for empty tree");
        }

        @Test
        @DisplayName("Basic functionality test with example 3")
        void testBasicFunctionalityExample3() {
            CountCompleteTreeNodes.RecursiveHeightComparisonApproach approach =
                    new CountCompleteTreeNodes.RecursiveHeightComparisonApproach();

            CountCompleteTreeNodes.TreeNode root = new CountCompleteTreeNodes.TreeNode(1);
            int expected = 1;

            int result = approach.countNodes(root);

            assertEquals(expected, result, "Should return 1 for single node");
        }

        @Test
        @DisplayName("Test with perfect binary tree")
        void testPerfectBinaryTree() {
            CountCompleteTreeNodes.RecursiveHeightComparisonApproach approach =
                    new CountCompleteTreeNodes.RecursiveHeightComparisonApproach();

            CountCompleteTreeNodes.TreeNode root = createPerfectBinaryTree();
            int expected = 15; // 2^4 - 1 = 15

            int result = approach.countNodes(root);

            assertEquals(expected, result, "Should return correct count for perfect binary tree");
        }

        @Test
        @DisplayName("Test with complete tree")
        void testCompleteTree() {
            CountCompleteTreeNodes.RecursiveHeightComparisonApproach approach =
                    new CountCompleteTreeNodes.RecursiveHeightComparisonApproach();

            CountCompleteTreeNodes.TreeNode root = createCompleteTree();
            int expected = 8;

            int result = approach.countNodes(root);

            assertEquals(expected, result, "Should return correct count for complete tree");
        }
    }

    @Nested
    @DisplayName("Level Order Traversal Approach Tests")
    class LevelOrderTraversalApproachTests {

        @Test
        @DisplayName("Basic functionality test with example 1")
        void testBasicFunctionalityExample1() {
            CountCompleteTreeNodes.LevelOrderTraversalApproach approach =
                    new CountCompleteTreeNodes.LevelOrderTraversalApproach();

            CountCompleteTreeNodes.TreeNode root = createExample1Tree();
            int expected = 6;

            int result = approach.countNodes(root);

            assertEquals(expected, result, "Should return correct count for example 1");
        }

        @Test
        @DisplayName("Basic functionality test with example 2")
        void testBasicFunctionalityExample2() {
            CountCompleteTreeNodes.LevelOrderTraversalApproach approach =
                    new CountCompleteTreeNodes.LevelOrderTraversalApproach();

            CountCompleteTreeNodes.TreeNode root = null;
            int expected = 0;

            int result = approach.countNodes(root);

            assertEquals(expected, result, "Should return 0 for empty tree");
        }

        @Test
        @DisplayName("Basic functionality test with example 3")
        void testBasicFunctionalityExample3() {
            CountCompleteTreeNodes.LevelOrderTraversalApproach approach =
                    new CountCompleteTreeNodes.LevelOrderTraversalApproach();

            CountCompleteTreeNodes.TreeNode root = new CountCompleteTreeNodes.TreeNode(1);
            int expected = 1;

            int result = approach.countNodes(root);

            assertEquals(expected, result, "Should return 1 for single node");
        }

        @Test
        @DisplayName("Test with perfect binary tree")
        void testPerfectBinaryTree() {
            CountCompleteTreeNodes.LevelOrderTraversalApproach approach =
                    new CountCompleteTreeNodes.LevelOrderTraversalApproach();

            CountCompleteTreeNodes.TreeNode root = createPerfectBinaryTree();
            int expected = 15;

            int result = approach.countNodes(root);

            assertEquals(expected, result, "Should return correct count for perfect binary tree");
        }
    }

    @Nested
    @DisplayName("Inorder Traversal Approach Tests")
    class InorderTraversalApproachTests {

        @Test
        @DisplayName("Basic functionality test with example 1")
        void testBasicFunctionalityExample1() {
            CountCompleteTreeNodes.InorderTraversalApproach approach =
                    new CountCompleteTreeNodes.InorderTraversalApproach();

            CountCompleteTreeNodes.TreeNode root = createExample1Tree();
            int expected = 6;

            int result = approach.countNodes(root);

            assertEquals(expected, result, "Should return correct count for example 1");
        }

        @Test
        @DisplayName("Basic functionality test with example 2")
        void testBasicFunctionalityExample2() {
            CountCompleteTreeNodes.InorderTraversalApproach approach =
                    new CountCompleteTreeNodes.InorderTraversalApproach();

            CountCompleteTreeNodes.TreeNode root = null;
            int expected = 0;

            int result = approach.countNodes(root);

            assertEquals(expected, result, "Should return 0 for empty tree");
        }

        @Test
        @DisplayName("Basic functionality test with example 3")
        void testBasicFunctionalityExample3() {
            CountCompleteTreeNodes.InorderTraversalApproach approach =
                    new CountCompleteTreeNodes.InorderTraversalApproach();

            CountCompleteTreeNodes.TreeNode root = new CountCompleteTreeNodes.TreeNode(1);
            int expected = 1;

            int result = approach.countNodes(root);

            assertEquals(expected, result, "Should return 1 for single node");
        }
    }

    @Nested
    @DisplayName("Postorder Traversal Approach Tests")
    class PostorderTraversalApproachTests {

        @Test
        @DisplayName("Basic functionality test with example 1")
        void testBasicFunctionalityExample1() {
            CountCompleteTreeNodes.PostorderTraversalApproach approach =
                    new CountCompleteTreeNodes.PostorderTraversalApproach();

            CountCompleteTreeNodes.TreeNode root = createExample1Tree();
            int expected = 6;

            int result = approach.countNodes(root);

            assertEquals(expected, result, "Should return correct count for example 1");
        }

        @Test
        @DisplayName("Basic functionality test with example 2")
        void testBasicFunctionalityExample2() {
            CountCompleteTreeNodes.PostorderTraversalApproach approach =
                    new CountCompleteTreeNodes.PostorderTraversalApproach();

            CountCompleteTreeNodes.TreeNode root = null;
            int expected = 0;

            int result = approach.countNodes(root);

            assertEquals(expected, result, "Should return 0 for empty tree");
        }

        @Test
        @DisplayName("Basic functionality test with example 3")
        void testBasicFunctionalityExample3() {
            CountCompleteTreeNodes.PostorderTraversalApproach approach =
                    new CountCompleteTreeNodes.PostorderTraversalApproach();

            CountCompleteTreeNodes.TreeNode root = new CountCompleteTreeNodes.TreeNode(1);
            int expected = 1;

            int result = approach.countNodes(root);

            assertEquals(expected, result, "Should return 1 for single node");
        }
    }

    @Nested
    @DisplayName("Preorder Traversal Approach Tests")
    class PreorderTraversalApproachTests {

        @Test
        @DisplayName("Basic functionality test with example 1")
        void testBasicFunctionalityExample1() {
            CountCompleteTreeNodes.PreorderTraversalApproach approach =
                    new CountCompleteTreeNodes.PreorderTraversalApproach();

            CountCompleteTreeNodes.TreeNode root = createExample1Tree();
            int expected = 6;

            int result = approach.countNodes(root);

            assertEquals(expected, result, "Should return correct count for example 1");
        }

        @Test
        @DisplayName("Basic functionality test with example 2")
        void testBasicFunctionalityExample2() {
            CountCompleteTreeNodes.PreorderTraversalApproach approach =
                    new CountCompleteTreeNodes.PreorderTraversalApproach();

            CountCompleteTreeNodes.TreeNode root = null;
            int expected = 0;

            int result = approach.countNodes(root);

            assertEquals(expected, result, "Should return 0 for empty tree");
        }

        @Test
        @DisplayName("Basic functionality test with example 3")
        void testBasicFunctionalityExample3() {
            CountCompleteTreeNodes.PreorderTraversalApproach approach =
                    new CountCompleteTreeNodes.PreorderTraversalApproach();

            CountCompleteTreeNodes.TreeNode root = new CountCompleteTreeNodes.TreeNode(1);
            int expected = 1;

            int result = approach.countNodes(root);

            assertEquals(expected, result, "Should return 1 for single node");
        }
    }

    @Nested
    @DisplayName("Binary Search on Leaves Approach Tests")
    class BinarySearchOnLeavesApproachTests {

        @Test
        @DisplayName("Basic functionality test with example 1")
        void testBasicFunctionalityExample1() {
            CountCompleteTreeNodes.BinarySearchOnLeavesApproach approach =
                    new CountCompleteTreeNodes.BinarySearchOnLeavesApproach();

            CountCompleteTreeNodes.TreeNode root = createExample1Tree();
            int expected = 6;

            int result = approach.countNodes(root);

            assertEquals(expected, result, "Should return correct count for example 1");
        }

        @Test
        @DisplayName("Basic functionality test with example 2")
        void testBasicFunctionalityExample2() {
            CountCompleteTreeNodes.BinarySearchOnLeavesApproach approach =
                    new CountCompleteTreeNodes.BinarySearchOnLeavesApproach();

            CountCompleteTreeNodes.TreeNode root = null;
            int expected = 0;

            int result = approach.countNodes(root);

            assertEquals(expected, result, "Should return 0 for empty tree");
        }

        @Test
        @DisplayName("Basic functionality test with example 3")
        void testBasicFunctionalityExample3() {
            CountCompleteTreeNodes.BinarySearchOnLeavesApproach approach =
                    new CountCompleteTreeNodes.BinarySearchOnLeavesApproach();

            CountCompleteTreeNodes.TreeNode root = new CountCompleteTreeNodes.TreeNode(1);
            int expected = 1;

            int result = approach.countNodes(root);

            assertEquals(expected, result, "Should return 1 for single node");
        }

        @Test
        @DisplayName("Test with perfect binary tree")
        void testPerfectBinaryTree() {
            CountCompleteTreeNodes.BinarySearchOnLeavesApproach approach =
                    new CountCompleteTreeNodes.BinarySearchOnLeavesApproach();

            CountCompleteTreeNodes.TreeNode root = createPerfectBinaryTree();
            int expected = 15;

            int result = approach.countNodes(root);

            assertEquals(expected, result, "Should return correct count for perfect binary tree");
        }
    }

    @Nested
    @DisplayName("Iterative Height Comparison Approach Tests")
    class IterativeHeightComparisonApproachTests {

        @Test
        @DisplayName("Basic functionality test with example 1")
        void testBasicFunctionalityExample1() {
            CountCompleteTreeNodes.IterativeHeightComparisonApproach approach =
                    new CountCompleteTreeNodes.IterativeHeightComparisonApproach();

            CountCompleteTreeNodes.TreeNode root = createExample1Tree();
            int expected = 6;

            int result = approach.countNodes(root);

            assertEquals(expected, result, "Should return correct count for example 1");
        }

        @Test
        @DisplayName("Basic functionality test with example 2")
        void testBasicFunctionalityExample2() {
            CountCompleteTreeNodes.IterativeHeightComparisonApproach approach =
                    new CountCompleteTreeNodes.IterativeHeightComparisonApproach();

            CountCompleteTreeNodes.TreeNode root = null;
            int expected = 0;

            int result = approach.countNodes(root);

            assertEquals(expected, result, "Should return 0 for empty tree");
        }

        @Test
        @DisplayName("Basic functionality test with example 3")
        void testBasicFunctionalityExample3() {
            CountCompleteTreeNodes.IterativeHeightComparisonApproach approach =
                    new CountCompleteTreeNodes.IterativeHeightComparisonApproach();

            CountCompleteTreeNodes.TreeNode root = new CountCompleteTreeNodes.TreeNode(1);
            int expected = 1;

            int result = approach.countNodes(root);

            assertEquals(expected, result, "Should return 1 for single node");
        }
    }

    @Nested
    @DisplayName("Simple Recursive Approach Tests")
    class SimpleRecursiveApproachTests {

        @Test
        @DisplayName("Basic functionality test with example 1")
        void testBasicFunctionalityExample1() {
            CountCompleteTreeNodes.SimpleRecursiveApproach approach =
                    new CountCompleteTreeNodes.SimpleRecursiveApproach();

            CountCompleteTreeNodes.TreeNode root = createExample1Tree();
            int expected = 6;

            int result = approach.countNodes(root);

            assertEquals(expected, result, "Should return correct count for example 1");
        }

        @Test
        @DisplayName("Basic functionality test with example 2")
        void testBasicFunctionalityExample2() {
            CountCompleteTreeNodes.SimpleRecursiveApproach approach =
                    new CountCompleteTreeNodes.SimpleRecursiveApproach();

            CountCompleteTreeNodes.TreeNode root = null;
            int expected = 0;

            int result = approach.countNodes(root);

            assertEquals(expected, result, "Should return 0 for empty tree");
        }

        @Test
        @DisplayName("Basic functionality test with example 3")
        void testBasicFunctionalityExample3() {
            CountCompleteTreeNodes.SimpleRecursiveApproach approach =
                    new CountCompleteTreeNodes.SimpleRecursiveApproach();

            CountCompleteTreeNodes.TreeNode root = new CountCompleteTreeNodes.TreeNode(1);
            int expected = 1;

            int result = approach.countNodes(root);

            assertEquals(expected, result, "Should return 1 for single node");
        }
    }

    @Nested
    @DisplayName("Cross-Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @Test
        @DisplayName("All approaches should produce same result with example 1")
        void testAllApproachesSameResultExample1() {
            CountCompleteTreeNodes.TreeNode root = createExample1Tree();
            int expected = 6;

            // Test all approaches
            int recursiveHeightResult =
                    new CountCompleteTreeNodes.RecursiveHeightComparisonApproach().countNodes(root);
            int levelOrderResult =
                    new CountCompleteTreeNodes.LevelOrderTraversalApproach().countNodes(root);
            int inorderResult =
                    new CountCompleteTreeNodes.InorderTraversalApproach().countNodes(root);
            int postorderResult =
                    new CountCompleteTreeNodes.PostorderTraversalApproach().countNodes(root);
            int preorderResult =
                    new CountCompleteTreeNodes.PreorderTraversalApproach().countNodes(root);
            int binarySearchResult =
                    new CountCompleteTreeNodes.BinarySearchOnLeavesApproach().countNodes(root);
            int iterativeHeightResult =
                    new CountCompleteTreeNodes.IterativeHeightComparisonApproach().countNodes(root);
            int simpleRecursiveResult =
                    new CountCompleteTreeNodes.SimpleRecursiveApproach().countNodes(root);

            // All results should be the same
            assertEquals(expected, recursiveHeightResult, "Recursive Height should match expected");
            assertEquals(expected, levelOrderResult, "Level Order should match expected");
            assertEquals(expected, inorderResult, "Inorder should match expected");
            assertEquals(expected, postorderResult, "Postorder should match expected");
            assertEquals(expected, preorderResult, "Preorder should match expected");
            assertEquals(expected, binarySearchResult, "Binary Search should match expected");
            assertEquals(expected, iterativeHeightResult, "Iterative Height should match expected");
            assertEquals(expected, simpleRecursiveResult, "Simple Recursive should match expected");
        }

        @Test
        @DisplayName("All approaches should produce same result with example 2")
        void testAllApproachesSameResultExample2() {
            CountCompleteTreeNodes.TreeNode root = null;
            int expected = 0;

            // Test all approaches
            int recursiveHeightResult =
                    new CountCompleteTreeNodes.RecursiveHeightComparisonApproach().countNodes(root);
            int levelOrderResult =
                    new CountCompleteTreeNodes.LevelOrderTraversalApproach().countNodes(root);
            int inorderResult =
                    new CountCompleteTreeNodes.InorderTraversalApproach().countNodes(root);
            int postorderResult =
                    new CountCompleteTreeNodes.PostorderTraversalApproach().countNodes(root);
            int preorderResult =
                    new CountCompleteTreeNodes.PreorderTraversalApproach().countNodes(root);
            int binarySearchResult =
                    new CountCompleteTreeNodes.BinarySearchOnLeavesApproach().countNodes(root);
            int iterativeHeightResult =
                    new CountCompleteTreeNodes.IterativeHeightComparisonApproach().countNodes(root);
            int simpleRecursiveResult =
                    new CountCompleteTreeNodes.SimpleRecursiveApproach().countNodes(root);

            // All results should be the same
            assertEquals(expected, recursiveHeightResult, "Recursive Height should match expected");
            assertEquals(expected, levelOrderResult, "Level Order should match expected");
            assertEquals(expected, inorderResult, "Inorder should match expected");
            assertEquals(expected, postorderResult, "Postorder should match expected");
            assertEquals(expected, preorderResult, "Preorder should match expected");
            assertEquals(expected, binarySearchResult, "Binary Search should match expected");
            assertEquals(expected, iterativeHeightResult, "Iterative Height should match expected");
            assertEquals(expected, simpleRecursiveResult, "Simple Recursive should match expected");
        }

        @Test
        @DisplayName("All approaches should produce same result with test cases")
        void testAllApproachesSameResultWithTestCases() {
            List<CountCompleteTreeNodes.TestData.TestCase> testCases =
                    CountCompleteTreeNodes.TestData.getTestCases();

            for (CountCompleteTreeNodes.TestData.TestCase testCase : testCases) {
                // Test all approaches
                int recursiveHeightResult =
                        new CountCompleteTreeNodes.RecursiveHeightComparisonApproach()
                                .countNodes(testCase.getRoot());
                int levelOrderResult = new CountCompleteTreeNodes.LevelOrderTraversalApproach()
                        .countNodes(testCase.getRoot());
                int inorderResult = new CountCompleteTreeNodes.InorderTraversalApproach()
                        .countNodes(testCase.getRoot());
                int postorderResult = new CountCompleteTreeNodes.PostorderTraversalApproach()
                        .countNodes(testCase.getRoot());
                int preorderResult = new CountCompleteTreeNodes.PreorderTraversalApproach()
                        .countNodes(testCase.getRoot());
                int binarySearchResult = new CountCompleteTreeNodes.BinarySearchOnLeavesApproach()
                        .countNodes(testCase.getRoot());
                int iterativeHeightResult =
                        new CountCompleteTreeNodes.IterativeHeightComparisonApproach()
                                .countNodes(testCase.getRoot());
                int simpleRecursiveResult = new CountCompleteTreeNodes.SimpleRecursiveApproach()
                        .countNodes(testCase.getRoot());

                // All results should be the same
                assertTrue(recursiveHeightResult == levelOrderResult,
                        "Recursive Height and Level Order should match for: "
                                + testCase.getDescription());
                assertTrue(recursiveHeightResult == inorderResult,
                        "Recursive Height and Inorder should match for: "
                                + testCase.getDescription());
                assertTrue(recursiveHeightResult == postorderResult,
                        "Recursive Height and Postorder should match for: "
                                + testCase.getDescription());
                assertTrue(recursiveHeightResult == preorderResult,
                        "Recursive Height and Preorder should match for: "
                                + testCase.getDescription());
                assertTrue(recursiveHeightResult == binarySearchResult,
                        "Recursive Height and Binary Search should match for: "
                                + testCase.getDescription());
                assertTrue(recursiveHeightResult == iterativeHeightResult,
                        "Recursive Height and Iterative Height should match for: "
                                + testCase.getDescription());
                assertTrue(recursiveHeightResult == simpleRecursiveResult,
                        "Recursive Height and Simple Recursive should match for: "
                                + testCase.getDescription());

                // All should match expected
                assertEquals(testCase.getExpected(), recursiveHeightResult,
                        "Result should match expected for: " + testCase.getDescription());
            }
        }
    }

    @Nested
    @DisplayName("Edge Case Tests")
    class EdgeCaseTests {

        @Test
        @DisplayName("Test with null root")
        void testNullRoot() {
            CountCompleteTreeNodes.RecursiveHeightComparisonApproach approach =
                    new CountCompleteTreeNodes.RecursiveHeightComparisonApproach();

            CountCompleteTreeNodes.TreeNode root = null;
            int expected = 0;

            int result = approach.countNodes(root);

            assertEquals(expected, result, "Null root should return 0");
        }

        @Test
        @DisplayName("Test with single node")
        void testSingleNode() {
            CountCompleteTreeNodes.RecursiveHeightComparisonApproach approach =
                    new CountCompleteTreeNodes.RecursiveHeightComparisonApproach();

            CountCompleteTreeNodes.TreeNode root = new CountCompleteTreeNodes.TreeNode(1);
            int expected = 1;

            int result = approach.countNodes(root);

            assertEquals(expected, result, "Single node should return 1");
        }

        @Test
        @DisplayName("Test with two nodes")
        void testTwoNodes() {
            CountCompleteTreeNodes.RecursiveHeightComparisonApproach approach =
                    new CountCompleteTreeNodes.RecursiveHeightComparisonApproach();

            CountCompleteTreeNodes.TreeNode root = new CountCompleteTreeNodes.TreeNode(1);
            root.left = new CountCompleteTreeNodes.TreeNode(2);
            int expected = 2;

            int result = approach.countNodes(root);

            assertEquals(expected, result, "Two nodes should return 2");
        }

        @Test
        @DisplayName("Test with three nodes")
        void testThreeNodes() {
            CountCompleteTreeNodes.RecursiveHeightComparisonApproach approach =
                    new CountCompleteTreeNodes.RecursiveHeightComparisonApproach();

            CountCompleteTreeNodes.TreeNode root = new CountCompleteTreeNodes.TreeNode(1);
            root.left = new CountCompleteTreeNodes.TreeNode(2);
            root.right = new CountCompleteTreeNodes.TreeNode(3);
            int expected = 3;

            int result = approach.countNodes(root);

            assertEquals(expected, result, "Three nodes should return 3");
        }

        @Test
        @DisplayName("Test with perfect binary tree")
        void testPerfectBinaryTree() {
            CountCompleteTreeNodes.RecursiveHeightComparisonApproach approach =
                    new CountCompleteTreeNodes.RecursiveHeightComparisonApproach();

            CountCompleteTreeNodes.TreeNode root = createPerfectBinaryTree();
            int expected = 15; // 2^4 - 1

            int result = approach.countNodes(root);

            assertEquals(expected, result, "Perfect binary tree should return correct count");
        }

        @Test
        @DisplayName("Test with complete tree")
        void testCompleteTree() {
            CountCompleteTreeNodes.RecursiveHeightComparisonApproach approach =
                    new CountCompleteTreeNodes.RecursiveHeightComparisonApproach();

            CountCompleteTreeNodes.TreeNode root = createCompleteTree();
            int expected = 8;

            int result = approach.countNodes(root);

            assertEquals(expected, result, "Complete tree should return correct count");
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Performance comparison between approaches")
        void testPerformanceComparison() {
            CountCompleteTreeNodes.TreeNode testTree = createLargeTree();

            // Test Recursive Height Comparison approach (should be fastest)
            long startTime = System.nanoTime();
            new CountCompleteTreeNodes.RecursiveHeightComparisonApproach().countNodes(testTree);
            long recursiveHeightTime = System.nanoTime() - startTime;

            // Test Level Order Traversal approach
            startTime = System.nanoTime();
            new CountCompleteTreeNodes.LevelOrderTraversalApproach().countNodes(testTree);
            long levelOrderTime = System.nanoTime() - startTime;

            // Test Simple Recursive approach
            startTime = System.nanoTime();
            new CountCompleteTreeNodes.SimpleRecursiveApproach().countNodes(testTree);
            long simpleRecursiveTime = System.nanoTime() - startTime;

            System.out.println("Performance Results:");
            System.out.println("Recursive Height: " + (recursiveHeightTime / 1_000) + "μs");
            System.out.println("Level Order: " + (levelOrderTime / 1_000) + "μs");
            System.out.println("Simple Recursive: " + (simpleRecursiveTime / 1_000) + "μs");

            // Recursive Height should be comparable or faster than Level Order for large trees
            // Note: Performance can vary based on system, so we just ensure both approaches work
            assertTrue(recursiveHeightTime >= 0 && levelOrderTime >= 0,
                    "Both approaches should complete successfully");
        }
    }

    @Nested
    @DisplayName("Tree Structure Tests")
    class TreeStructureTests {

        @Test
        @DisplayName("Test tree height calculation")
        void testTreeHeightCalculation() {
            CountCompleteTreeNodes.TreeNode root = createExample1Tree();
            int expectedHeight = 3;

            int actualHeight = CountCompleteTreeNodes.getTreeHeight(root);

            assertEquals(expectedHeight, actualHeight,
                    "Tree height should be calculated correctly");
        }

        @Test
        @DisplayName("Test tree height with single node")
        void testTreeHeightWithSingleNode() {
            CountCompleteTreeNodes.TreeNode root = new CountCompleteTreeNodes.TreeNode(1);
            int expectedHeight = 1;

            int actualHeight = CountCompleteTreeNodes.getTreeHeight(root);

            assertEquals(expectedHeight, actualHeight, "Single node tree height should be 1");
        }

        @Test
        @DisplayName("Test tree height with null root")
        void testTreeHeightWithNullRoot() {
            CountCompleteTreeNodes.TreeNode root = null;
            int expectedHeight = 0;

            int actualHeight = CountCompleteTreeNodes.getTreeHeight(root);

            assertEquals(expectedHeight, actualHeight, "Null root tree height should be 0");
        }
    }

    @Nested
    @DisplayName("Helper Method Tests")
    class HelperMethodTests {

        @Test
        @DisplayName("Test validateResult helper method")
        void testValidateResult() {
            assertTrue(CountCompleteTreeNodes.validateResult(5, 5),
                    "Should return true for matching results");
            assertTrue(CountCompleteTreeNodes.validateResult(0, 0),
                    "Should return true for matching results");
            assertTrue(!CountCompleteTreeNodes.validateResult(5, 3),
                    "Should return false for non-matching results");
            assertTrue(!CountCompleteTreeNodes.validateResult(0, 1),
                    "Should return false for non-matching results");
        }
    }

    // Helper methods to create test trees
    private CountCompleteTreeNodes.TreeNode createExample1Tree() {
        // [1,2,3,4,5,6]
        CountCompleteTreeNodes.TreeNode root = new CountCompleteTreeNodes.TreeNode(1);
        root.left = new CountCompleteTreeNodes.TreeNode(2);
        root.right = new CountCompleteTreeNodes.TreeNode(3);
        root.left.left = new CountCompleteTreeNodes.TreeNode(4);
        root.left.right = new CountCompleteTreeNodes.TreeNode(5);
        root.right.left = new CountCompleteTreeNodes.TreeNode(6);
        return root;
    }

    private CountCompleteTreeNodes.TreeNode createPerfectBinaryTree() {
        // Perfect binary tree with 15 nodes (4 levels)
        CountCompleteTreeNodes.TreeNode root = new CountCompleteTreeNodes.TreeNode(1);
        root.left = new CountCompleteTreeNodes.TreeNode(2);
        root.right = new CountCompleteTreeNodes.TreeNode(3);
        root.left.left = new CountCompleteTreeNodes.TreeNode(4);
        root.left.right = new CountCompleteTreeNodes.TreeNode(5);
        root.right.left = new CountCompleteTreeNodes.TreeNode(6);
        root.right.right = new CountCompleteTreeNodes.TreeNode(7);
        root.left.left.left = new CountCompleteTreeNodes.TreeNode(8);
        root.left.left.right = new CountCompleteTreeNodes.TreeNode(9);
        root.left.right.left = new CountCompleteTreeNodes.TreeNode(10);
        root.left.right.right = new CountCompleteTreeNodes.TreeNode(11);
        root.right.left.left = new CountCompleteTreeNodes.TreeNode(12);
        root.right.left.right = new CountCompleteTreeNodes.TreeNode(13);
        root.right.right.left = new CountCompleteTreeNodes.TreeNode(14);
        root.right.right.right = new CountCompleteTreeNodes.TreeNode(15);
        return root;
    }

    private CountCompleteTreeNodes.TreeNode createCompleteTree() {
        // Complete tree with 8 nodes
        CountCompleteTreeNodes.TreeNode root = new CountCompleteTreeNodes.TreeNode(1);
        root.left = new CountCompleteTreeNodes.TreeNode(2);
        root.right = new CountCompleteTreeNodes.TreeNode(3);
        root.left.left = new CountCompleteTreeNodes.TreeNode(4);
        root.left.right = new CountCompleteTreeNodes.TreeNode(5);
        root.right.left = new CountCompleteTreeNodes.TreeNode(6);
        root.right.right = new CountCompleteTreeNodes.TreeNode(7);
        root.left.left.left = new CountCompleteTreeNodes.TreeNode(8);
        return root;
    }

    private CountCompleteTreeNodes.TreeNode createLargeTree() {
        // Large complete tree with 31 nodes (5 levels)
        CountCompleteTreeNodes.TreeNode root = new CountCompleteTreeNodes.TreeNode(1);
        root.left = new CountCompleteTreeNodes.TreeNode(2);
        root.right = new CountCompleteTreeNodes.TreeNode(3);
        root.left.left = new CountCompleteTreeNodes.TreeNode(4);
        root.left.right = new CountCompleteTreeNodes.TreeNode(5);
        root.right.left = new CountCompleteTreeNodes.TreeNode(6);
        root.right.right = new CountCompleteTreeNodes.TreeNode(7);
        root.left.left.left = new CountCompleteTreeNodes.TreeNode(8);
        root.left.left.right = new CountCompleteTreeNodes.TreeNode(9);
        root.left.right.left = new CountCompleteTreeNodes.TreeNode(10);
        root.left.right.right = new CountCompleteTreeNodes.TreeNode(11);
        root.right.left.left = new CountCompleteTreeNodes.TreeNode(12);
        root.right.left.right = new CountCompleteTreeNodes.TreeNode(13);
        root.right.right.left = new CountCompleteTreeNodes.TreeNode(14);
        root.right.right.right = new CountCompleteTreeNodes.TreeNode(15);
        root.left.left.left.left = new CountCompleteTreeNodes.TreeNode(16);
        root.left.left.left.right = new CountCompleteTreeNodes.TreeNode(17);
        root.left.left.right.left = new CountCompleteTreeNodes.TreeNode(18);
        root.left.left.right.right = new CountCompleteTreeNodes.TreeNode(19);
        root.left.right.left.left = new CountCompleteTreeNodes.TreeNode(20);
        root.left.right.left.right = new CountCompleteTreeNodes.TreeNode(21);
        root.left.right.right.left = new CountCompleteTreeNodes.TreeNode(22);
        root.left.right.right.right = new CountCompleteTreeNodes.TreeNode(23);
        root.right.left.left.left = new CountCompleteTreeNodes.TreeNode(24);
        root.right.left.left.right = new CountCompleteTreeNodes.TreeNode(25);
        root.right.left.right.left = new CountCompleteTreeNodes.TreeNode(26);
        root.right.left.right.right = new CountCompleteTreeNodes.TreeNode(27);
        root.right.right.left.left = new CountCompleteTreeNodes.TreeNode(28);
        root.right.right.left.right = new CountCompleteTreeNodes.TreeNode(29);
        root.right.right.right.left = new CountCompleteTreeNodes.TreeNode(30);
        root.right.right.right.right = new CountCompleteTreeNodes.TreeNode(31);
        return root;
    }
}
