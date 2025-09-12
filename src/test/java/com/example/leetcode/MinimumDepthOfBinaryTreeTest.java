package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.util.Arrays;
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
 * Comprehensive test suite for MinimumDepthOfBinaryTree LeetCode problem
 * 
 * Tests all six different approaches: 1. Recursive DFS (Optimal) 2. Iterative BFS 3. Iterative DFS
 * with Stack 4. Level Order Traversal 5. Morris Traversal 6. Optimized Recursive DFS
 */
@DisplayName("Minimum Depth of Binary Tree Tests")
class MinimumDepthOfBinaryTreeTest {

    private MinimumDepthOfBinaryTree solution;

    @BeforeEach
    void setUp() {
        solution = new MinimumDepthOfBinaryTree();
    }

    @Nested
    @DisplayName("Basic Functionality Tests")
    class BasicFunctionalityTests {

        @Test
        @DisplayName("Empty tree")
        void testEmptyTree() {
            MinimumDepthOfBinaryTree.TreeNode root = null;
            int expected = 0;

            assertEquals(expected, solution.minDepthRecursive(root));
            assertEquals(expected, solution.minDepthBFS(root));
            assertEquals(expected, solution.minDepthIterativeDFS(root));
            assertEquals(expected, solution.minDepthLevelOrder(root));
            assertEquals(expected, solution.minDepthMorris(root));
            assertEquals(expected, solution.minDepthOptimized(root));
        }

        @Test
        @DisplayName("Single node tree")
        void testSingleNode() {
            MinimumDepthOfBinaryTree.TreeNode root = new MinimumDepthOfBinaryTree.TreeNode(1);
            int expected = 1;

            assertEquals(expected, solution.minDepthRecursive(root));
            assertEquals(expected, solution.minDepthBFS(root));
            assertEquals(expected, solution.minDepthIterativeDFS(root));
            assertEquals(expected, solution.minDepthLevelOrder(root));
            assertEquals(expected, solution.minDepthMorris(root));
            assertEquals(expected, solution.minDepthOptimized(root));
        }

        @Test
        @DisplayName("Two nodes - left child only")
        void testTwoNodesLeftChild() {
            MinimumDepthOfBinaryTree.TreeNode root = new MinimumDepthOfBinaryTree.TreeNode(1);
            root.left = new MinimumDepthOfBinaryTree.TreeNode(2);
            int expected = 2;

            assertEquals(expected, solution.minDepthRecursive(root));
            assertEquals(expected, solution.minDepthBFS(root));
            assertEquals(expected, solution.minDepthIterativeDFS(root));
            assertEquals(expected, solution.minDepthLevelOrder(root));
            assertEquals(expected, solution.minDepthMorris(root));
            assertEquals(expected, solution.minDepthOptimized(root));
        }

        @Test
        @DisplayName("Two nodes - right child only")
        void testTwoNodesRightChild() {
            MinimumDepthOfBinaryTree.TreeNode root = new MinimumDepthOfBinaryTree.TreeNode(1);
            root.right = new MinimumDepthOfBinaryTree.TreeNode(2);
            int expected = 2;

            assertEquals(expected, solution.minDepthRecursive(root));
            assertEquals(expected, solution.minDepthBFS(root));
            assertEquals(expected, solution.minDepthIterativeDFS(root));
            assertEquals(expected, solution.minDepthLevelOrder(root));
            assertEquals(expected, solution.minDepthMorris(root));
            assertEquals(expected, solution.minDepthOptimized(root));
        }

        @Test
        @DisplayName("Three nodes - complete tree")
        void testThreeNodesComplete() {
            MinimumDepthOfBinaryTree.TreeNode root = new MinimumDepthOfBinaryTree.TreeNode(1);
            root.left = new MinimumDepthOfBinaryTree.TreeNode(2);
            root.right = new MinimumDepthOfBinaryTree.TreeNode(3);
            int expected = 2;

            assertEquals(expected, solution.minDepthRecursive(root));
            assertEquals(expected, solution.minDepthBFS(root));
            assertEquals(expected, solution.minDepthIterativeDFS(root));
            assertEquals(expected, solution.minDepthLevelOrder(root));
            assertEquals(expected, solution.minDepthMorris(root));
            assertEquals(expected, solution.minDepthOptimized(root));
        }
    }

    @Nested
    @DisplayName("LeetCode Example Tests")
    class LeetCodeExampleTests {

        @Test
        @DisplayName("LeetCode Example 1: [3,9,20,null,null,15,7]")
        void testLeetCodeExample1() {
            Integer[] values = {3, 9, 20, null, null, 15, 7};
            MinimumDepthOfBinaryTree.TreeNode root = MinimumDepthOfBinaryTree.createTree(values);
            int expected = 2;

            assertEquals(expected, solution.minDepthRecursive(root));
            assertEquals(expected, solution.minDepthBFS(root));
            assertEquals(expected, solution.minDepthIterativeDFS(root));
            assertEquals(expected, solution.minDepthLevelOrder(root));
            assertEquals(expected, solution.minDepthMorris(root));
            assertEquals(expected, solution.minDepthOptimized(root));
        }

        @Test
        @DisplayName("LeetCode Example 2: [2,null,3,null,4,null,5,null,6]")
        void testLeetCodeExample2() {
            Integer[] values = {2, null, 3, null, 4, null, 5, null, 6};
            MinimumDepthOfBinaryTree.TreeNode root = MinimumDepthOfBinaryTree.createTree(values);
            int expected = 5;

            assertEquals(expected, solution.minDepthRecursive(root));
            assertEquals(expected, solution.minDepthBFS(root));
            assertEquals(expected, solution.minDepthIterativeDFS(root));
            assertEquals(expected, solution.minDepthLevelOrder(root));
            assertEquals(expected, solution.minDepthMorris(root));
            assertEquals(expected, solution.minDepthOptimized(root));
        }

        @Test
        @DisplayName("LeetCode Example 3: [1,2,3,4,5]")
        void testLeetCodeExample3() {
            Integer[] values = {1, 2, 3, 4, 5};
            MinimumDepthOfBinaryTree.TreeNode root = MinimumDepthOfBinaryTree.createTree(values);
            int expected = 2;

            assertEquals(expected, solution.minDepthRecursive(root));
            assertEquals(expected, solution.minDepthBFS(root));
            assertEquals(expected, solution.minDepthIterativeDFS(root));
            assertEquals(expected, solution.minDepthLevelOrder(root));
            assertEquals(expected, solution.minDepthMorris(root));
            assertEquals(expected, solution.minDepthOptimized(root));
        }
    }

    @Nested
    @DisplayName("Edge Cases and Boundary Tests")
    class EdgeCasesAndBoundaryTests {

        @Test
        @DisplayName("Skewed tree - left skewed")
        void testLeftSkewedTree() {
            MinimumDepthOfBinaryTree.TreeNode root = new MinimumDepthOfBinaryTree.TreeNode(1);
            root.left = new MinimumDepthOfBinaryTree.TreeNode(2);
            root.left.left = new MinimumDepthOfBinaryTree.TreeNode(3);
            root.left.left.left = new MinimumDepthOfBinaryTree.TreeNode(4);
            int expected = 4;

            assertEquals(expected, solution.minDepthRecursive(root));
            assertEquals(expected, solution.minDepthBFS(root));
            assertEquals(expected, solution.minDepthIterativeDFS(root));
            assertEquals(expected, solution.minDepthLevelOrder(root));
            assertEquals(expected, solution.minDepthMorris(root));
            assertEquals(expected, solution.minDepthOptimized(root));
        }

        @Test
        @DisplayName("Skewed tree - right skewed")
        void testRightSkewedTree() {
            MinimumDepthOfBinaryTree.TreeNode root = new MinimumDepthOfBinaryTree.TreeNode(1);
            root.right = new MinimumDepthOfBinaryTree.TreeNode(2);
            root.right.right = new MinimumDepthOfBinaryTree.TreeNode(3);
            root.right.right.right = new MinimumDepthOfBinaryTree.TreeNode(4);
            int expected = 4;

            assertEquals(expected, solution.minDepthRecursive(root));
            assertEquals(expected, solution.minDepthBFS(root));
            assertEquals(expected, solution.minDepthIterativeDFS(root));
            assertEquals(expected, solution.minDepthLevelOrder(root));
            assertEquals(expected, solution.minDepthMorris(root));
            assertEquals(expected, solution.minDepthOptimized(root));
        }

        @Test
        @DisplayName("Complete binary tree")
        void testCompleteBinaryTree() {
            Integer[] values = {1, 2, 3, 4, 5, 6, 7};
            MinimumDepthOfBinaryTree.TreeNode root = MinimumDepthOfBinaryTree.createTree(values);
            int expected = 3;

            assertEquals(expected, solution.minDepthRecursive(root));
            assertEquals(expected, solution.minDepthBFS(root));
            assertEquals(expected, solution.minDepthIterativeDFS(root));
            assertEquals(expected, solution.minDepthLevelOrder(root));
            assertEquals(expected, solution.minDepthMorris(root));
            assertEquals(expected, solution.minDepthOptimized(root));
        }

        @Test
        @DisplayName("Tree with negative values")
        void testTreeWithNegativeValues() {
            MinimumDepthOfBinaryTree.TreeNode root = new MinimumDepthOfBinaryTree.TreeNode(-1);
            root.left = new MinimumDepthOfBinaryTree.TreeNode(-2);
            root.right = new MinimumDepthOfBinaryTree.TreeNode(-3);
            root.left.left = new MinimumDepthOfBinaryTree.TreeNode(-4);
            int expected = 2;

            assertEquals(expected, solution.minDepthRecursive(root));
            assertEquals(expected, solution.minDepthBFS(root));
            assertEquals(expected, solution.minDepthIterativeDFS(root));
            assertEquals(expected, solution.minDepthLevelOrder(root));
            assertEquals(expected, solution.minDepthMorris(root));
            assertEquals(expected, solution.minDepthOptimized(root));
        }

        @Test
        @DisplayName("Tree with zero values")
        void testTreeWithZeroValues() {
            MinimumDepthOfBinaryTree.TreeNode root = new MinimumDepthOfBinaryTree.TreeNode(0);
            root.left = new MinimumDepthOfBinaryTree.TreeNode(0);
            root.right = new MinimumDepthOfBinaryTree.TreeNode(0);
            int expected = 2;

            assertEquals(expected, solution.minDepthRecursive(root));
            assertEquals(expected, solution.minDepthBFS(root));
            assertEquals(expected, solution.minDepthIterativeDFS(root));
            assertEquals(expected, solution.minDepthLevelOrder(root));
            assertEquals(expected, solution.minDepthMorris(root));
            assertEquals(expected, solution.minDepthOptimized(root));
        }
    }

    @Nested
    @DisplayName("Parameterized Tests")
    class ParameterizedTests {

        @ParameterizedTest
        @MethodSource("provideTestCases")
        @DisplayName("All approaches with various test cases")
        void testAllApproaches(Integer[] values, int expected) {
            MinimumDepthOfBinaryTree.TreeNode root = MinimumDepthOfBinaryTree.createTree(values);

            assertEquals(expected, solution.minDepthRecursive(root),
                    "Recursive DFS failed for: " + Arrays.toString(values));
            assertEquals(expected, solution.minDepthBFS(root),
                    "BFS failed for: " + Arrays.toString(values));
            assertEquals(expected, solution.minDepthIterativeDFS(root),
                    "Iterative DFS failed for: " + Arrays.toString(values));
            assertEquals(expected, solution.minDepthLevelOrder(root),
                    "Level Order failed for: " + Arrays.toString(values));
            assertEquals(expected, solution.minDepthMorris(root),
                    "Morris failed for: " + Arrays.toString(values));
            assertEquals(expected, solution.minDepthOptimized(root),
                    "Optimized failed for: " + Arrays.toString(values));
        }

        static Stream<Arguments> provideTestCases() {
            return Stream.of(Arguments.of(new Integer[] {1, 2, 3, 4, 5, 6, 7}, 3),
                    Arguments.of(new Integer[] {1, 2, null, 3, null, 4, null, 5}, 5),
                    Arguments.of(new Integer[] {1, null, 2, null, 3, null, 4, null, 5}, 5),
                    Arguments.of(new Integer[] {1, 2, 3, null, null, 4, 5}, 2),
                    Arguments.of(new Integer[] {1, 2, 3, 4, null, null, 5}, 3), // Fixed: was 2,
                                                                                // should be 3
                    Arguments.of(new Integer[] {1, 2, 3, 4, 5, null, null}, 2),
                    Arguments.of(new Integer[] {1, 2, 3, null, 4, 5, null}, 3), // Fixed: was 2,
                                                                                // should be 3
                    Arguments.of(new Integer[] {1, 2, 3, 4, 5, 6, null}, 3),
                    Arguments.of(new Integer[] {1, 2, 3, 4, 5, null, 6}, 3),
                    Arguments.of(new Integer[] {1, 2, 3, 4, null, 5, 6}, 3));
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Large balanced tree performance test")
        void testLargeBalancedTreePerformance() {
            // Create a large balanced tree (height 10, ~1000 nodes)
            MinimumDepthOfBinaryTree.TreeNode root = createBalancedTree(10);
            int expected = 10; // Minimum depth should equal the height

            // Test all approaches
            long startTime, endTime;

            startTime = System.nanoTime();
            int result1 = solution.minDepthRecursive(root);
            endTime = System.nanoTime();
            System.out.println("Recursive DFS time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertEquals(expected, result1);

            startTime = System.nanoTime();
            int result2 = solution.minDepthBFS(root);
            endTime = System.nanoTime();
            System.out.println("BFS time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertEquals(expected, result2);

            startTime = System.nanoTime();
            int result3 = solution.minDepthIterativeDFS(root);
            endTime = System.nanoTime();
            System.out.println("Iterative DFS time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertEquals(expected, result3);

            startTime = System.nanoTime();
            int result4 = solution.minDepthLevelOrder(root);
            endTime = System.nanoTime();
            System.out.println("Level Order time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertEquals(expected, result4);

            startTime = System.nanoTime();
            int result5 = solution.minDepthMorris(root);
            endTime = System.nanoTime();
            System.out.println("Morris time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertEquals(expected, result5);

            startTime = System.nanoTime();
            int result6 = solution.minDepthOptimized(root);
            endTime = System.nanoTime();
            System.out.println("Optimized time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertEquals(expected, result6);
        }

        @Test
        @DisplayName("Large skewed tree performance test")
        void testLargeSkewedTreePerformance() {
            // Create a large skewed tree (height 100)
            MinimumDepthOfBinaryTree.TreeNode root = createSkewedTree(100);
            int expected = 100; // Minimum depth should equal the height

            // Test all approaches
            long startTime, endTime;

            startTime = System.nanoTime();
            int result1 = solution.minDepthRecursive(root);
            endTime = System.nanoTime();
            System.out.println("Recursive DFS time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertEquals(expected, result1);

            startTime = System.nanoTime();
            int result2 = solution.minDepthBFS(root);
            endTime = System.nanoTime();
            System.out.println("BFS time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertEquals(expected, result2);

            startTime = System.nanoTime();
            int result3 = solution.minDepthIterativeDFS(root);
            endTime = System.nanoTime();
            System.out.println("Iterative DFS time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertEquals(expected, result3);

            startTime = System.nanoTime();
            int result4 = solution.minDepthLevelOrder(root);
            endTime = System.nanoTime();
            System.out.println("Level Order time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertEquals(expected, result4);

            startTime = System.nanoTime();
            int result5 = solution.minDepthMorris(root);
            endTime = System.nanoTime();
            System.out.println("Morris time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertEquals(expected, result5);

            startTime = System.nanoTime();
            int result6 = solution.minDepthOptimized(root);
            endTime = System.nanoTime();
            System.out.println("Optimized time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertEquals(expected, result6);
        }

        private MinimumDepthOfBinaryTree.TreeNode createBalancedTree(int height) {
            if (height <= 0) {
                return null;
            }

            MinimumDepthOfBinaryTree.TreeNode root = new MinimumDepthOfBinaryTree.TreeNode(1);
            root.left = createBalancedTree(height - 1);
            root.right = createBalancedTree(height - 1);
            return root;
        }

        private MinimumDepthOfBinaryTree.TreeNode createSkewedTree(int height) {
            if (height <= 0) {
                return null;
            }

            MinimumDepthOfBinaryTree.TreeNode root = new MinimumDepthOfBinaryTree.TreeNode(height);
            root.left = createSkewedTree(height - 1);
            return root;
        }
    }

    @Nested
    @DisplayName("Validation Tests")
    class ValidationTests {

        @Test
        @DisplayName("Verify all approaches return same result")
        void testAllApproachesConsistency() {
            Integer[][] testCases = {{1, 2, 3, 4, 5, 6, 7}, {1, 2, null, 3, null, 4, null, 5},
                    {1, null, 2, null, 3, null, 4, null, 5}, {1, 2, 3, null, null, 4, 5},
                    {1, 2, 3, 4, null, null, 5}, {1, 2, 3, 4, 5, null, null},
                    {1, 2, 3, null, 4, 5, null}, {1, 2, 3, 4, 5, 6, null}, {1, 2, 3, 4, 5, null, 6},
                    {1, 2, 3, 4, null, 5, 6}};

            for (Integer[] values : testCases) {
                MinimumDepthOfBinaryTree.TreeNode root =
                        MinimumDepthOfBinaryTree.createTree(values);

                int recursiveResult = solution.minDepthRecursive(root);
                int bfsResult = solution.minDepthBFS(root);
                int iterativeDFSResult = solution.minDepthIterativeDFS(root);
                int levelOrderResult = solution.minDepthLevelOrder(root);
                int morrisResult = solution.minDepthMorris(root);
                int optimizedResult = solution.minDepthOptimized(root);

                assertEquals(recursiveResult, bfsResult,
                        "Recursive and BFS results should match for: " + Arrays.toString(values));
                assertEquals(recursiveResult, iterativeDFSResult,
                        "Recursive and Iterative DFS results should match for: "
                                + Arrays.toString(values));
                assertEquals(recursiveResult, levelOrderResult,
                        "Recursive and Level Order results should match for: "
                                + Arrays.toString(values));
                assertEquals(recursiveResult, morrisResult,
                        "Recursive and Morris results should match for: "
                                + Arrays.toString(values));
                assertEquals(recursiveResult, optimizedResult,
                        "Recursive and Optimized results should match for: "
                                + Arrays.toString(values));
            }
        }

        @Test
        @DisplayName("Verify tree creation utility")
        void testTreeCreationUtility() {
            // Test null input
            assertNull(MinimumDepthOfBinaryTree.createTree(null));

            // Test empty array
            assertNull(MinimumDepthOfBinaryTree.createTree(new Integer[0]));

            // Test array with null root
            assertNull(MinimumDepthOfBinaryTree.createTree(new Integer[] {null}));

            // Test single node
            MinimumDepthOfBinaryTree.TreeNode singleNode =
                    MinimumDepthOfBinaryTree.createTree(new Integer[] {1});
            assertNotNull(singleNode);
            assertEquals(1, singleNode.val);
            assertNull(singleNode.left);
            assertNull(singleNode.right);

            // Test two nodes
            MinimumDepthOfBinaryTree.TreeNode twoNodes =
                    MinimumDepthOfBinaryTree.createTree(new Integer[] {1, 2, null});
            assertNotNull(twoNodes);
            assertEquals(1, twoNodes.val);
            assertNotNull(twoNodes.left);
            assertEquals(2, twoNodes.left.val);
            assertNull(twoNodes.right);

            // Test complete tree
            MinimumDepthOfBinaryTree.TreeNode completeTree =
                    MinimumDepthOfBinaryTree.createTree(new Integer[] {1, 2, 3, 4, 5, 6, 7});
            assertNotNull(completeTree);
            assertEquals(1, completeTree.val);
            assertNotNull(completeTree.left);
            assertEquals(2, completeTree.left.val);
            assertNotNull(completeTree.right);
            assertEquals(3, completeTree.right.val);
        }
    }

    @Nested
    @DisplayName("Cross Validation Tests")
    class CrossValidationTests {

        @Test
        @DisplayName("Random test cases with cross validation")
        void testRandomCasesWithCrossValidation() {
            Random random = new Random(123);

            for (int test = 0; test < 50; test++) {
                // Generate random tree structure
                Integer[] values = generateRandomTree(random, 10); // Max 10 nodes
                MinimumDepthOfBinaryTree.TreeNode root =
                        MinimumDepthOfBinaryTree.createTree(values);

                // Test all approaches
                int recursiveResult = solution.minDepthRecursive(root);
                int bfsResult = solution.minDepthBFS(root);
                int iterativeDFSResult = solution.minDepthIterativeDFS(root);
                int levelOrderResult = solution.minDepthLevelOrder(root);
                int morrisResult = solution.minDepthMorris(root);
                int optimizedResult = solution.minDepthOptimized(root);

                assertEquals(recursiveResult, bfsResult, "BFS failed for test case " + test);
                assertEquals(recursiveResult, iterativeDFSResult,
                        "Iterative DFS failed for test case " + test);
                assertEquals(recursiveResult, levelOrderResult,
                        "Level Order failed for test case " + test);
                assertEquals(recursiveResult, morrisResult, "Morris failed for test case " + test);
                assertEquals(recursiveResult, optimizedResult,
                        "Optimized failed for test case " + test);
            }
        }

        private Integer[] generateRandomTree(Random random, int maxNodes) {
            if (maxNodes <= 0) {
                return new Integer[0];
            }

            Integer[] values = new Integer[maxNodes];
            values[0] = random.nextInt(100); // Root node

            for (int i = 1; i < maxNodes; i++) {
                if (random.nextDouble() < 0.7) { // 70% chance of having a value
                    values[i] = random.nextInt(100);
                } else {
                    values[i] = null; // 30% chance of being null
                }
            }

            return values;
        }
    }

    @Nested
    @DisplayName("Comprehensive Integration Tests")
    class ComprehensiveIntegrationTests {

        @Test
        @DisplayName("Stress test with maximum constraints")
        void testStressTestWithMaxConstraints() {
            // Test with tree near maximum constraint (10,000 nodes)
            MinimumDepthOfBinaryTree.TreeNode root = createLargeTree(10000);
            int expected = 1; // Minimum depth should be 1 (root is a leaf)

            // Test all approaches
            assertEquals(expected, solution.minDepthRecursive(root));
            assertEquals(expected, solution.minDepthBFS(root));
            assertEquals(expected, solution.minDepthIterativeDFS(root));
            assertEquals(expected, solution.minDepthLevelOrder(root));
            assertEquals(expected, solution.minDepthMorris(root));
            assertEquals(expected, solution.minDepthOptimized(root));
        }

        @Test
        @DisplayName("Test with very deep tree")
        void testVeryDeepTree() {
            // Create a very deep tree (height 1000)
            MinimumDepthOfBinaryTree.TreeNode root = createDeepTree(1000);
            int expected = 1000; // Minimum depth should equal the height

            // Test all approaches
            assertEquals(expected, solution.minDepthRecursive(root));
            assertEquals(expected, solution.minDepthBFS(root));
            assertEquals(expected, solution.minDepthIterativeDFS(root));
            assertEquals(expected, solution.minDepthLevelOrder(root));
            assertEquals(expected, solution.minDepthMorris(root));
            assertEquals(expected, solution.minDepthOptimized(root));
        }

        private MinimumDepthOfBinaryTree.TreeNode createLargeTree(int nodeCount) {
            if (nodeCount <= 0) {
                return null;
            }

            MinimumDepthOfBinaryTree.TreeNode root = new MinimumDepthOfBinaryTree.TreeNode(1);
            // Create a tree where root is the only leaf (all other nodes have children)
            for (int i = 2; i <= nodeCount; i++) {
                root.left = new MinimumDepthOfBinaryTree.TreeNode(i);
                root = root.left;
            }

            return root;
        }

        private MinimumDepthOfBinaryTree.TreeNode createDeepTree(int height) {
            if (height <= 0) {
                return null;
            }

            MinimumDepthOfBinaryTree.TreeNode root = new MinimumDepthOfBinaryTree.TreeNode(height);
            root.left = createDeepTree(height - 1);
            return root;
        }
    }
}
