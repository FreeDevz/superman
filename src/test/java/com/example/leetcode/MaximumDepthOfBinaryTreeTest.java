package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Comprehensive test suite for Maximum Depth of Binary Tree (LeetCode 104)
 * 
 * This test suite covers: - All 6 algorithmic approaches - Edge cases and boundary conditions -
 * Performance testing - Cross-validation between approaches - Tree structure validation
 * 
 * @author Superman
 * @version 1.0
 */
@DisplayName("Maximum Depth of Binary Tree Tests")
class MaximumDepthOfBinaryTreeTest {

    private MaximumDepthOfBinaryTree solution;

    @BeforeEach
    void setUp() {
        solution = new MaximumDepthOfBinaryTree();
    }

    // ==================== BASIC FUNCTIONALITY TESTS ====================

    @Nested
    @DisplayName("Basic Functionality Tests")
    class BasicFunctionalityTests {

        @Test
        @DisplayName("Example 1: [3,9,20,null,null,15,7] should return 3")
        void testExample1() {
            Integer[] values = {3, 9, 20, null, null, 15, 7};
            MaximumDepthOfBinaryTree.TreeNode root = MaximumDepthOfBinaryTree.createTree(values);

            assertEquals(3, solution.maxDepthRecursive(root));
            assertEquals(3, solution.maxDepthIterativeBFS(root));
            assertEquals(3, solution.maxDepthIterativeDFS(root));
            assertEquals(3, solution.maxDepthOptimizedRecursive(root));
            assertEquals(3, solution.maxDepthOneLiner(root));
            assertEquals(3, solution.maxDepthWithValidation(root));
        }

        @Test
        @DisplayName("Example 2: [1,null,2] should return 2")
        void testExample2() {
            Integer[] values = {1, null, 2};
            MaximumDepthOfBinaryTree.TreeNode root = MaximumDepthOfBinaryTree.createTree(values);

            assertEquals(2, solution.maxDepthRecursive(root));
            assertEquals(2, solution.maxDepthIterativeBFS(root));
            assertEquals(2, solution.maxDepthIterativeDFS(root));
            assertEquals(2, solution.maxDepthOptimizedRecursive(root));
            assertEquals(2, solution.maxDepthOneLiner(root));
            assertEquals(2, solution.maxDepthWithValidation(root));
        }

        @Test
        @DisplayName("Single node tree should return 1")
        void testSingleNode() {
            Integer[] values = {1};
            MaximumDepthOfBinaryTree.TreeNode root = MaximumDepthOfBinaryTree.createTree(values);

            assertEquals(1, solution.maxDepthRecursive(root));
            assertEquals(1, solution.maxDepthIterativeBFS(root));
            assertEquals(1, solution.maxDepthIterativeDFS(root));
            assertEquals(1, solution.maxDepthOptimizedRecursive(root));
            assertEquals(1, solution.maxDepthOneLiner(root));
            assertEquals(1, solution.maxDepthWithValidation(root));
        }

        @Test
        @DisplayName("Empty tree should return 0")
        void testEmptyTree() {
            MaximumDepthOfBinaryTree.TreeNode root = null;

            assertEquals(0, solution.maxDepthRecursive(root));
            assertEquals(0, solution.maxDepthIterativeBFS(root));
            assertEquals(0, solution.maxDepthIterativeDFS(root));
            assertEquals(0, solution.maxDepthOptimizedRecursive(root));
            assertEquals(0, solution.maxDepthOneLiner(root));
            assertEquals(0, solution.maxDepthWithValidation(root));
        }
    }

    // ==================== EDGE CASES AND BOUNDARY TESTS ====================

    @Nested
    @DisplayName("Edge Cases and Boundary Tests")
    class EdgeCasesAndBoundaryTests {

        @Test
        @DisplayName("Complete binary tree should return correct depth")
        void testCompleteBinaryTree() {
            Integer[] values = {1, 2, 3, 4, 5, 6, 7};
            MaximumDepthOfBinaryTree.TreeNode root = MaximumDepthOfBinaryTree.createTree(values);

            assertEquals(3, solution.maxDepthRecursive(root));
            assertEquals(3, solution.maxDepthIterativeBFS(root));
            assertEquals(3, solution.maxDepthIterativeDFS(root));
            assertEquals(3, solution.maxDepthOptimizedRecursive(root));
            assertEquals(3, solution.maxDepthOneLiner(root));
            assertEquals(3, solution.maxDepthWithValidation(root));
        }

        @Test
        @DisplayName("Skewed tree (left) should return correct depth")
        void testSkewedLeftTree() {
            Integer[] values = {1, 2, null, 3, null, 4, null, 5};
            MaximumDepthOfBinaryTree.TreeNode root = MaximumDepthOfBinaryTree.createTree(values);

            assertEquals(5, solution.maxDepthRecursive(root));
            assertEquals(5, solution.maxDepthIterativeBFS(root));
            assertEquals(5, solution.maxDepthIterativeDFS(root));
            assertEquals(5, solution.maxDepthOptimizedRecursive(root));
            assertEquals(5, solution.maxDepthOneLiner(root));
            assertEquals(5, solution.maxDepthWithValidation(root));
        }

        @Test
        @DisplayName("Skewed tree (right) should return correct depth")
        void testSkewedRightTree() {
            Integer[] values = {1, null, 2, null, 3, null, 4, null, 5};
            MaximumDepthOfBinaryTree.TreeNode root = MaximumDepthOfBinaryTree.createTree(values);

            assertEquals(5, solution.maxDepthRecursive(root));
            assertEquals(5, solution.maxDepthIterativeBFS(root));
            assertEquals(5, solution.maxDepthIterativeDFS(root));
            assertEquals(5, solution.maxDepthOptimizedRecursive(root));
            assertEquals(5, solution.maxDepthOneLiner(root));
            assertEquals(5, solution.maxDepthWithValidation(root));
        }

        @Test
        @DisplayName("Tree with only left children should return correct depth")
        void testOnlyLeftChildren() {
            Integer[] values = {1, 2, null, 3, null, 4, null};
            MaximumDepthOfBinaryTree.TreeNode root = MaximumDepthOfBinaryTree.createTree(values);

            assertEquals(4, solution.maxDepthRecursive(root));
            assertEquals(4, solution.maxDepthIterativeBFS(root));
            assertEquals(4, solution.maxDepthIterativeDFS(root));
            assertEquals(4, solution.maxDepthOptimizedRecursive(root));
            assertEquals(4, solution.maxDepthOneLiner(root));
            assertEquals(4, solution.maxDepthWithValidation(root));
        }

        @Test
        @DisplayName("Tree with only right children should return correct depth")
        void testOnlyRightChildren() {
            Integer[] values = {1, null, 2, null, 3, null, 4};
            MaximumDepthOfBinaryTree.TreeNode root = MaximumDepthOfBinaryTree.createTree(values);

            assertEquals(4, solution.maxDepthRecursive(root));
            assertEquals(4, solution.maxDepthIterativeBFS(root));
            assertEquals(4, solution.maxDepthIterativeDFS(root));
            assertEquals(4, solution.maxDepthOptimizedRecursive(root));
            assertEquals(4, solution.maxDepthOneLiner(root));
            assertEquals(4, solution.maxDepthWithValidation(root));
        }

        @Test
        @DisplayName("Tree with negative values should work correctly")
        void testNegativeValues() {
            Integer[] values = {-1, -2, -3, -4, -5};
            MaximumDepthOfBinaryTree.TreeNode root = MaximumDepthOfBinaryTree.createTree(values);

            assertEquals(3, solution.maxDepthRecursive(root));
            assertEquals(3, solution.maxDepthIterativeBFS(root));
            assertEquals(3, solution.maxDepthIterativeDFS(root));
            assertEquals(3, solution.maxDepthOptimizedRecursive(root));
            assertEquals(3, solution.maxDepthOneLiner(root));
            assertEquals(3, solution.maxDepthWithValidation(root));
        }

        @Test
        @DisplayName("Tree with zero values should work correctly")
        void testZeroValues() {
            Integer[] values = {0, 0, 0, 0, 0, 0, 0};
            MaximumDepthOfBinaryTree.TreeNode root = MaximumDepthOfBinaryTree.createTree(values);

            assertEquals(3, solution.maxDepthRecursive(root));
            assertEquals(3, solution.maxDepthIterativeBFS(root));
            assertEquals(3, solution.maxDepthIterativeDFS(root));
            assertEquals(3, solution.maxDepthOptimizedRecursive(root));
            assertEquals(3, solution.maxDepthOneLiner(root));
            assertEquals(3, solution.maxDepthWithValidation(root));
        }
    }

    // ==================== PARAMETERIZED TESTS ====================

    @Nested
    @DisplayName("Parameterized Tests")
    class ParameterizedTests {

        @ParameterizedTest
        @MethodSource("provideTestCases")
        @DisplayName("All approaches should return same result for various test cases")
        void testAllApproachesConsistency(Integer[] values, int expectedDepth) {
            MaximumDepthOfBinaryTree.TreeNode root = MaximumDepthOfBinaryTree.createTree(values);

            int result1 = solution.maxDepthRecursive(root);
            int result2 = solution.maxDepthIterativeBFS(root);
            int result3 = solution.maxDepthIterativeDFS(root);
            int result4 = solution.maxDepthOptimizedRecursive(root);
            int result5 = solution.maxDepthOneLiner(root);
            int result6 = solution.maxDepthWithValidation(root);

            assertEquals(expectedDepth, result1);
            assertEquals(expectedDepth, result2);
            assertEquals(expectedDepth, result3);
            assertEquals(expectedDepth, result4);
            assertEquals(expectedDepth, result5);
            assertEquals(expectedDepth, result6);

            // Verify all approaches produce the same result
            assertEquals(result1, result2);
            assertEquals(result2, result3);
            assertEquals(result3, result4);
            assertEquals(result4, result5);
            assertEquals(result5, result6);
        }

        static Stream<Arguments> provideTestCases() {
            return Stream.of(
                    Arguments.of(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15},
                            4),
                    Arguments.of(new Integer[] {1, 2, 3, null, null, 4, 5}, 3),
                    Arguments.of(new Integer[] {1, 2, null, 3, null, 4, null, 5, null, 6}, 6),
                    Arguments.of(new Integer[] {1, null, 2, null, 3, null, 4, null, 5, null, 6}, 6),
                    Arguments.of(new Integer[] {1, 2, 3, 4, null, null, 5}, 3),
                    Arguments.of(new Integer[] {1, 2, 3, null, 4, null, 5}, 3),
                    Arguments.of(new Integer[] {1, 2, 3, 4, 5, null, null, 6, 7}, 4),
                    Arguments.of(
                            new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16},
                            5),
                    Arguments.of(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
                            16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31}, 5),
                    Arguments.of(
                            new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
                                    17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32},
                            6));
        }

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
        @DisplayName("Skewed trees of various depths should work correctly")
        void testSkewedTreesOfVariousDepths(int depth) {
            Integer[] values = new Integer[depth * 2 - 1];
            values[0] = 1;
            for (int i = 1; i < values.length; i += 2) {
                values[i] = i + 1;
                if (i + 1 < values.length) {
                    values[i + 1] = null;
                }
            }

            MaximumDepthOfBinaryTree.TreeNode root = MaximumDepthOfBinaryTree.createTree(values);

            assertEquals(depth, solution.maxDepthRecursive(root));
            assertEquals(depth, solution.maxDepthIterativeBFS(root));
            assertEquals(depth, solution.maxDepthIterativeDFS(root));
            assertEquals(depth, solution.maxDepthOptimizedRecursive(root));
            assertEquals(depth, solution.maxDepthOneLiner(root));
            assertEquals(depth, solution.maxDepthWithValidation(root));
        }
    }

    // ==================== CROSS-VALIDATION TESTS ====================

    @Nested
    @DisplayName("Cross-Validation Tests")
    class CrossValidationTests {

        @Test
        @DisplayName("All approaches should produce identical results")
        void testCrossValidation() {
            Integer[][] testCases = {{1, 2, 3, 4, 5, 6, 7}, {1, 2, 3, null, null, 4, 5},
                    {1, 2, null, 3, null, 4, null, 5}, {1, null, 2, null, 3, null, 4, null, 5},
                    {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15},
                    {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16},
                    {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22,
                            23, 24, 25, 26, 27, 28, 29, 30, 31}};

            for (Integer[] values : testCases) {
                MaximumDepthOfBinaryTree.TreeNode root =
                        MaximumDepthOfBinaryTree.createTree(values);

                int result1 = solution.maxDepthRecursive(root);
                int result2 = solution.maxDepthIterativeBFS(root);
                int result3 = solution.maxDepthIterativeDFS(root);
                int result4 = solution.maxDepthOptimizedRecursive(root);
                int result5 = solution.maxDepthOneLiner(root);
                int result6 = solution.maxDepthWithValidation(root);

                assertEquals(result1, result2,
                        "Recursive vs BFS mismatch for: " + Arrays.toString(values));
                assertEquals(result2, result3,
                        "BFS vs DFS mismatch for: " + Arrays.toString(values));
                assertEquals(result3, result4,
                        "DFS vs Optimized mismatch for: " + Arrays.toString(values));
                assertEquals(result4, result5,
                        "Optimized vs One-liner mismatch for: " + Arrays.toString(values));
                assertEquals(result5, result6,
                        "One-liner vs Validation mismatch for: " + Arrays.toString(values));
            }
        }

        @Test
        @DisplayName("Results should match actual tree height")
        void testHeightVerification() {
            Integer[][] testCases = {{1, 2, 3, 4, 5, 6, 7}, {1, 2, 3, null, null, 4, 5},
                    {1, 2, null, 3, null, 4, null, 5}, {1, null, 2, null, 3, null, 4, null, 5},
                    {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}};

            for (Integer[] values : testCases) {
                MaximumDepthOfBinaryTree.TreeNode root =
                        MaximumDepthOfBinaryTree.createTree(values);

                int actualHeight = MaximumDepthOfBinaryTree.getActualHeight(root);
                int result = solution.maxDepthRecursive(root);

                assertEquals(actualHeight, result,
                        "Result should match actual height for: " + Arrays.toString(values));
            }
        }
    }

    // ==================== PERFORMANCE TESTS ====================

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Performance comparison between approaches")
        void testPerformanceComparison() {
            // Create a large tree for performance testing (using valid values -100 to 100)
            Integer[] values = new Integer[1000];
            for (int i = 0; i < values.length; i++) {
                values[i] = (i % 201) - 100; // Values from -100 to 100
            }

            MaximumDepthOfBinaryTree.TreeNode root = MaximumDepthOfBinaryTree.createTree(values);

            // Measure performance of each approach
            long startTime, endTime;

            startTime = System.nanoTime();
            int result1 = solution.maxDepthRecursive(root);
            endTime = System.nanoTime();
            long recursiveTime = endTime - startTime;

            startTime = System.nanoTime();
            int result2 = solution.maxDepthIterativeBFS(root);
            endTime = System.nanoTime();
            long bfsTime = endTime - startTime;

            startTime = System.nanoTime();
            int result3 = solution.maxDepthIterativeDFS(root);
            endTime = System.nanoTime();
            long dfsTime = endTime - startTime;

            startTime = System.nanoTime();
            int result4 = solution.maxDepthOptimizedRecursive(root);
            endTime = System.nanoTime();
            long optimizedTime = endTime - startTime;

            startTime = System.nanoTime();
            int result5 = solution.maxDepthOneLiner(root);
            endTime = System.nanoTime();
            long oneLinerTime = endTime - startTime;

            startTime = System.nanoTime();
            int result6 = solution.maxDepthWithValidation(root);
            endTime = System.nanoTime();
            long validationTime = endTime - startTime;

            // Verify all results are the same
            assertEquals(result1, result2);
            assertEquals(result2, result3);
            assertEquals(result3, result4);
            assertEquals(result4, result5);
            assertEquals(result5, result6);

            // Print performance results
            System.out.println("\nPerformance Results (1000 nodes):");
            System.out.printf("Recursive DFS:        %d ns%n", recursiveTime);
            System.out.printf("Iterative BFS:        %d ns%n", bfsTime);
            System.out.printf("Iterative DFS:        %d ns%n", dfsTime);
            System.out.printf("Optimized Recursive:  %d ns%n", optimizedTime);
            System.out.printf("One-liner Recursive:  %d ns%n", oneLinerTime);
            System.out.printf("With Validation:      %d ns%n", validationTime);
        }

        @Test
        @DisplayName("Performance with maximum constraint tree")
        void testMaximumConstraintPerformance() {
            // Create tree with maximum constraint (10^4 nodes, using valid values -100 to 100)
            Integer[] values = new Integer[10000];
            for (int i = 0; i < values.length; i++) {
                values[i] = (i % 201) - 100; // Values from -100 to 100
            }

            MaximumDepthOfBinaryTree.TreeNode root = MaximumDepthOfBinaryTree.createTree(values);

            long startTime = System.nanoTime();
            int result = solution.maxDepthRecursive(root);
            long endTime = System.nanoTime();

            long executionTime = endTime - startTime;

            // Verify result is reasonable (should be around 14 for 10000 nodes in complete tree)
            assertTrue(result >= 10 && result <= 20, "Result should be reasonable for 10000 nodes");

            // Verify execution time is reasonable (should be under 1 second)
            assertTrue(executionTime < 1_000_000_000, "Execution time should be under 1 second");

            System.out.printf("Maximum constraint test (10000 nodes): %d depth in %d ns%n", result,
                    executionTime);
        }
    }

    // ==================== UTILITY METHOD TESTS ====================

    @Nested
    @DisplayName("Utility Method Tests")
    class UtilityMethodTests {

        @Test
        @DisplayName("createTree should create correct tree structure")
        void testCreateTree() {
            Integer[] values = {1, 2, 3, 4, 5, 6, 7};
            MaximumDepthOfBinaryTree.TreeNode root = MaximumDepthOfBinaryTree.createTree(values);

            assertNotNull(root);
            assertEquals(1, root.val);
            assertNotNull(root.left);
            assertEquals(2, root.left.val);
            assertNotNull(root.right);
            assertEquals(3, root.right.val);
            assertNotNull(root.left.left);
            assertEquals(4, root.left.left.val);
            assertNotNull(root.left.right);
            assertEquals(5, root.left.right.val);
            assertNotNull(root.right.left);
            assertEquals(6, root.right.left.val);
            assertNotNull(root.right.right);
            assertEquals(7, root.right.right.val);
        }

        @Test
        @DisplayName("createTree should handle null values correctly")
        void testCreateTreeWithNulls() {
            Integer[] values = {1, 2, null, 3, null, 4, null};
            MaximumDepthOfBinaryTree.TreeNode root = MaximumDepthOfBinaryTree.createTree(values);

            assertNotNull(root);
            assertEquals(1, root.val);
            assertNotNull(root.left);
            assertEquals(2, root.left.val);
            assertNull(root.right);
            assertNotNull(root.left.left);
            assertEquals(3, root.left.left.val);
            assertNull(root.left.right);
            assertNotNull(root.left.left.left);
            assertEquals(4, root.left.left.left.val);
        }

        @Test
        @DisplayName("createTree should handle empty array")
        void testCreateTreeEmpty() {
            Integer[] values = {};
            MaximumDepthOfBinaryTree.TreeNode root = MaximumDepthOfBinaryTree.createTree(values);
            assertNull(root);
        }

        @Test
        @DisplayName("createTree should handle null array")
        void testCreateTreeNull() {
            MaximumDepthOfBinaryTree.TreeNode root = MaximumDepthOfBinaryTree.createTree(null);
            assertNull(root);
        }

        @Test
        @DisplayName("treeToArray should convert tree back to array")
        void testTreeToArray() {
            Integer[] original = {1, 2, 3, 4, 5, 6, 7};
            MaximumDepthOfBinaryTree.TreeNode root = MaximumDepthOfBinaryTree.createTree(original);
            Integer[] converted = MaximumDepthOfBinaryTree.treeToArray(root);

            assertArrayEquals(original, converted);
        }

        @Test
        @DisplayName("treeToArray should handle null tree")
        void testTreeToArrayNull() {
            Integer[] result = MaximumDepthOfBinaryTree.treeToArray(null);
            assertArrayEquals(new Integer[0], result);
        }

        @Test
        @DisplayName("countNodes should return correct node count")
        void testCountNodes() {
            Integer[] values = {1, 2, 3, 4, 5, 6, 7};
            MaximumDepthOfBinaryTree.TreeNode root = MaximumDepthOfBinaryTree.createTree(values);

            assertEquals(7, MaximumDepthOfBinaryTree.countNodes(root));
        }

        @Test
        @DisplayName("countNodes should return 0 for null tree")
        void testCountNodesNull() {
            assertEquals(0, MaximumDepthOfBinaryTree.countNodes(null));
        }

        @Test
        @DisplayName("isBalanced should correctly identify balanced trees")
        void testIsBalanced() {
            Integer[] balancedValues = {1, 2, 3, 4, 5, 6, 7};
            MaximumDepthOfBinaryTree.TreeNode balancedRoot =
                    MaximumDepthOfBinaryTree.createTree(balancedValues);
            assertTrue(MaximumDepthOfBinaryTree.isBalanced(balancedRoot));

            Integer[] unbalancedValues = {1, 2, null, 3, null, 4, null, 5};
            MaximumDepthOfBinaryTree.TreeNode unbalancedRoot =
                    MaximumDepthOfBinaryTree.createTree(unbalancedValues);
            assertFalse(MaximumDepthOfBinaryTree.isBalanced(unbalancedRoot));
        }

        @Test
        @DisplayName("isBalanced should return true for null tree")
        void testIsBalancedNull() {
            assertTrue(MaximumDepthOfBinaryTree.isBalanced(null));
        }
    }

    // ==================== VALIDATION TESTS ====================

    @Nested
    @DisplayName("Validation Tests")
    class ValidationTests {

        @Test
        @DisplayName("maxDepthWithValidation should throw exception for invalid values")
        void testValidationException() {
            // Create a tree with invalid value (outside -100 to 100 range)
            MaximumDepthOfBinaryTree.TreeNode root = new MaximumDepthOfBinaryTree.TreeNode(150);

            assertThrows(IllegalArgumentException.class, () -> {
                solution.maxDepthWithValidation(root);
            });
        }

        @Test
        @DisplayName("maxDepthWithValidation should work with valid values")
        void testValidationSuccess() {
            Integer[] values = {1, 2, 3, 4, 5, 6, 7};
            MaximumDepthOfBinaryTree.TreeNode root = MaximumDepthOfBinaryTree.createTree(values);

            // Should not throw exception
            assertDoesNotThrow(() -> {
                int result = solution.maxDepthWithValidation(root);
                assertEquals(3, result);
            });
        }
    }

    // ==================== COMPREHENSIVE INTEGRATION TESTS ====================

    @Nested
    @DisplayName("Comprehensive Integration Tests")
    class ComprehensiveIntegrationTests {

        @Test
        @DisplayName("Complete integration test with all features")
        void testCompleteIntegration() {
            // Test with a complex tree structure
            Integer[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
                    20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
            MaximumDepthOfBinaryTree.TreeNode root = MaximumDepthOfBinaryTree.createTree(values);

            // Test all approaches
            int result1 = solution.maxDepthRecursive(root);
            int result2 = solution.maxDepthIterativeBFS(root);
            int result3 = solution.maxDepthIterativeDFS(root);
            int result4 = solution.maxDepthOptimizedRecursive(root);
            int result5 = solution.maxDepthOneLiner(root);
            int result6 = solution.maxDepthWithValidation(root);

            // Verify all results are the same
            assertEquals(result1, result2);
            assertEquals(result2, result3);
            assertEquals(result3, result4);
            assertEquals(result4, result5);
            assertEquals(result5, result6);

            // Verify result matches actual height
            int actualHeight = MaximumDepthOfBinaryTree.getActualHeight(root);
            assertEquals(actualHeight, result1);

            // Verify tree statistics
            int nodeCount = MaximumDepthOfBinaryTree.countNodes(root);
            assertEquals(31, nodeCount);

            boolean isBalanced = MaximumDepthOfBinaryTree.isBalanced(root);
            assertTrue(isBalanced);

            // Verify tree can be converted back to array
            Integer[] converted = MaximumDepthOfBinaryTree.treeToArray(root);
            assertArrayEquals(values, converted);
        }

        @Test
        @DisplayName("Stress test with multiple tree types")
        void testStressTest() {
            List<Integer[]> testCases = new ArrayList<>();

            // Generate various tree structures (using valid values -100 to 100)
            for (int depth = 1; depth <= 10; depth++) {
                // Complete binary tree
                int completeSize = (1 << depth) - 1;
                Integer[] complete = new Integer[completeSize];
                for (int i = 0; i < completeSize; i++) {
                    complete[i] = (i % 201) - 100; // Values from -100 to 100
                }
                testCases.add(complete);

                // Skewed left tree
                Integer[] skewedLeft = new Integer[depth * 2 - 1];
                skewedLeft[0] = 1;
                for (int i = 1; i < skewedLeft.length; i += 2) {
                    skewedLeft[i] = (i % 201) - 100; // Values from -100 to 100
                    if (i + 1 < skewedLeft.length) {
                        skewedLeft[i + 1] = null;
                    }
                }
                testCases.add(skewedLeft);

                // Skewed right tree
                Integer[] skewedRight = new Integer[depth * 2 - 1];
                skewedRight[0] = 1;
                for (int i = 1; i < skewedRight.length; i += 2) {
                    skewedRight[i] = null;
                    if (i + 1 < skewedRight.length) {
                        skewedRight[i + 1] = (i % 201) - 100; // Values from -100 to 100
                    }
                }
                testCases.add(skewedRight);
            }

            // Test all cases
            for (Integer[] values : testCases) {
                MaximumDepthOfBinaryTree.TreeNode root =
                        MaximumDepthOfBinaryTree.createTree(values);

                int result1 = solution.maxDepthRecursive(root);
                int result2 = solution.maxDepthIterativeBFS(root);
                int result3 = solution.maxDepthIterativeDFS(root);
                int result4 = solution.maxDepthOptimizedRecursive(root);
                int result5 = solution.maxDepthOneLiner(root);
                int result6 = solution.maxDepthWithValidation(root);

                // All approaches should produce the same result
                assertEquals(result1, result2);
                assertEquals(result2, result3);
                assertEquals(result3, result4);
                assertEquals(result4, result5);
                assertEquals(result5, result6);

                // Result should match actual height
                int actualHeight = MaximumDepthOfBinaryTree.getActualHeight(root);
                assertEquals(actualHeight, result1);
            }
        }
    }
}
