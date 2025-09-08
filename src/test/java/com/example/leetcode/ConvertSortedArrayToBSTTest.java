package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Comprehensive test suite for ConvertSortedArrayToBST (LeetCode 108)
 * 
 * This test suite validates all 6 different algorithmic approaches with extensive test cases
 * covering edge cases, performance scenarios, and cross-validation between approaches.
 */
@DisplayName("Convert Sorted Array to BST Tests")
class ConvertSortedArrayToBSTTest {

    private ConvertSortedArrayToBST solution;

    @BeforeEach
    void setUp() {
        solution = new ConvertSortedArrayToBST();
    }

    @Nested
    @DisplayName("Recursive Divide and Conquer Tests (Recommended Approach)")
    class RecursiveDivideAndConquerTests {

        @Test
        @DisplayName("Basic example: [-10,-3,0,5,9]")
        void testBasicExample() {
            int[] nums = {-10, -3, 0, 5, 9};
            ConvertSortedArrayToBST.TreeNode result = solution.sortedArrayToBST(nums);
            
            // Verify the tree is not null
            assertNotNull(result, "Result should not be null");
            
            // Verify it's a valid BST
            assertTrue(ConvertSortedArrayToBST.isValidBST(result), "Result should be a valid BST");
            
            // Verify it's height-balanced
            assertTrue(ConvertSortedArrayToBST.isHeightBalanced(result), "Result should be height-balanced");
            
            // Verify inorder traversal gives sorted array
            List<Integer> inorder = ConvertSortedArrayToBST.treeToInorderArray(result);
            assertEquals(List.of(-10, -3, 0, 5, 9), inorder, "Inorder traversal should match input");
        }

        @Test
        @DisplayName("Two elements: [1,3]")
        void testTwoElements() {
            int[] nums = {1, 3};
            ConvertSortedArrayToBST.TreeNode result = solution.sortedArrayToBST(nums);
            
            assertNotNull(result, "Result should not be null");
            assertTrue(ConvertSortedArrayToBST.isValidBST(result), "Result should be a valid BST");
            assertTrue(ConvertSortedArrayToBST.isHeightBalanced(result), "Result should be height-balanced");
            
            List<Integer> inorder = ConvertSortedArrayToBST.treeToInorderArray(result);
            assertEquals(List.of(1, 3), inorder, "Inorder traversal should match input");
        }

        @Test
        @DisplayName("Single element: [1]")
        void testSingleElement() {
            int[] nums = {1};
            ConvertSortedArrayToBST.TreeNode result = solution.sortedArrayToBST(nums);
            
            assertNotNull(result, "Result should not be null");
            assertEquals(1, result.val, "Root value should be 1");
            assertNull(result.left, "Left child should be null");
            assertNull(result.right, "Right child should be null");
            assertTrue(ConvertSortedArrayToBST.isValidBST(result), "Result should be a valid BST");
            assertTrue(ConvertSortedArrayToBST.isHeightBalanced(result), "Result should be height-balanced");
        }

        @Test
        @DisplayName("Three elements: [1,2,3]")
        void testThreeElements() {
            int[] nums = {1, 2, 3};
            ConvertSortedArrayToBST.TreeNode result = solution.sortedArrayToBST(nums);
            
            assertNotNull(result, "Result should not be null");
            assertTrue(ConvertSortedArrayToBST.isValidBST(result), "Result should be a valid BST");
            assertTrue(ConvertSortedArrayToBST.isHeightBalanced(result), "Result should be height-balanced");
            
            List<Integer> inorder = ConvertSortedArrayToBST.treeToInorderArray(result);
            assertEquals(List.of(1, 2, 3), inorder, "Inorder traversal should match input");
        }

        @Test
        @DisplayName("Four elements: [1,2,3,4]")
        void testFourElements() {
            int[] nums = {1, 2, 3, 4};
            ConvertSortedArrayToBST.TreeNode result = solution.sortedArrayToBST(nums);
            
            assertNotNull(result, "Result should not be null");
            assertTrue(ConvertSortedArrayToBST.isValidBST(result), "Result should be a valid BST");
            assertTrue(ConvertSortedArrayToBST.isHeightBalanced(result), "Result should be height-balanced");
            
            List<Integer> inorder = ConvertSortedArrayToBST.treeToInorderArray(result);
            assertEquals(List.of(1, 2, 3, 4), inorder, "Inorder traversal should match input");
        }

        @Test
        @DisplayName("Negative numbers: [-5,-3,-1,0,2,4,6]")
        void testNegativeNumbers() {
            int[] nums = {-5, -3, -1, 0, 2, 4, 6};
            ConvertSortedArrayToBST.TreeNode result = solution.sortedArrayToBST(nums);
            
            assertNotNull(result, "Result should not be null");
            assertTrue(ConvertSortedArrayToBST.isValidBST(result), "Result should be a valid BST");
            assertTrue(ConvertSortedArrayToBST.isHeightBalanced(result), "Result should be height-balanced");
            
            List<Integer> inorder = ConvertSortedArrayToBST.treeToInorderArray(result);
            assertEquals(List.of(-5, -3, -1, 0, 2, 4, 6), inorder, "Inorder traversal should match input");
        }

        @Test
        @DisplayName("All negative: [-10,-8,-6,-4,-2]")
        void testAllNegative() {
            int[] nums = {-10, -8, -6, -4, -2};
            ConvertSortedArrayToBST.TreeNode result = solution.sortedArrayToBST(nums);
            
            assertNotNull(result, "Result should not be null");
            assertTrue(ConvertSortedArrayToBST.isValidBST(result), "Result should be a valid BST");
            assertTrue(ConvertSortedArrayToBST.isHeightBalanced(result), "Result should be height-balanced");
            
            List<Integer> inorder = ConvertSortedArrayToBST.treeToInorderArray(result);
            assertEquals(List.of(-10, -8, -6, -4, -2), inorder, "Inorder traversal should match input");
        }

        @Test
        @DisplayName("All positive: [1,3,5,7,9,11]")
        void testAllPositive() {
            int[] nums = {1, 3, 5, 7, 9, 11};
            ConvertSortedArrayToBST.TreeNode result = solution.sortedArrayToBST(nums);
            
            assertNotNull(result, "Result should not be null");
            assertTrue(ConvertSortedArrayToBST.isValidBST(result), "Result should be a valid BST");
            assertTrue(ConvertSortedArrayToBST.isHeightBalanced(result), "Result should be height-balanced");
            
            List<Integer> inorder = ConvertSortedArrayToBST.treeToInorderArray(result);
            assertEquals(List.of(1, 3, 5, 7, 9, 11), inorder, "Inorder traversal should match input");
        }

        @Test
        @DisplayName("Sequential numbers: [1,2,3,4,5,6,7,8]")
        void testSequentialNumbers() {
            int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
            ConvertSortedArrayToBST.TreeNode result = solution.sortedArrayToBST(nums);
            
            assertNotNull(result, "Result should not be null");
            assertTrue(ConvertSortedArrayToBST.isValidBST(result), "Result should be a valid BST");
            assertTrue(ConvertSortedArrayToBST.isHeightBalanced(result), "Result should be height-balanced");
            
            List<Integer> inorder = ConvertSortedArrayToBST.treeToInorderArray(result);
            assertEquals(List.of(1, 2, 3, 4, 5, 6, 7, 8), inorder, "Inorder traversal should match input");
        }

        @Test
        @DisplayName("Large range: [-1000,-500,0,500,1000]")
        void testLargeRange() {
            int[] nums = {-1000, -500, 0, 500, 1000};
            ConvertSortedArrayToBST.TreeNode result = solution.sortedArrayToBST(nums);
            
            assertNotNull(result, "Result should not be null");
            assertTrue(ConvertSortedArrayToBST.isValidBST(result), "Result should be a valid BST");
            assertTrue(ConvertSortedArrayToBST.isHeightBalanced(result), "Result should be height-balanced");
            
            List<Integer> inorder = ConvertSortedArrayToBST.treeToInorderArray(result);
            assertEquals(List.of(-1000, -500, 0, 500, 1000), inorder, "Inorder traversal should match input");
        }

        @Test
        @DisplayName("Null input")
        void testNullInput() {
            ConvertSortedArrayToBST.TreeNode result = solution.sortedArrayToBST(null);
            assertNull(result, "Result should be null for null input");
        }

        @Test
        @DisplayName("Empty array")
        void testEmptyArray() {
            int[] nums = {};
            ConvertSortedArrayToBST.TreeNode result = solution.sortedArrayToBST(nums);
            assertNull(result, "Result should be null for empty array");
        }
    }

    @Nested
    @DisplayName("Iterative with Stack Tests")
    class IterativeWithStackTests {

        @Test
        @DisplayName("Basic example with iterative approach")
        void testBasicExample() {
            int[] nums = {-10, -3, 0, 5, 9};
            ConvertSortedArrayToBST.TreeNode result = solution.sortedArrayToBSTIterative(nums);
            
            assertNotNull(result, "Result should not be null");
            assertTrue(ConvertSortedArrayToBST.isValidBST(result), "Result should be a valid BST");
            assertTrue(ConvertSortedArrayToBST.isHeightBalanced(result), "Result should be height-balanced");
            
            List<Integer> inorder = ConvertSortedArrayToBST.treeToInorderArray(result);
            assertEquals(List.of(-10, -3, 0, 5, 9), inorder, "Inorder traversal should match input");
        }

        @Test
        @DisplayName("Single element with iterative approach")
        void testSingleElement() {
            int[] nums = {1};
            ConvertSortedArrayToBST.TreeNode result = solution.sortedArrayToBSTIterative(nums);
            
            assertNotNull(result, "Result should not be null");
            assertEquals(1, result.val, "Root value should be 1");
            assertNull(result.left, "Left child should be null");
            assertNull(result.right, "Right child should be null");
        }

        @Test
        @DisplayName("Two elements with iterative approach")
        void testTwoElements() {
            int[] nums = {1, 3};
            ConvertSortedArrayToBST.TreeNode result = solution.sortedArrayToBSTIterative(nums);
            
            assertNotNull(result, "Result should not be null");
            assertTrue(ConvertSortedArrayToBST.isValidBST(result), "Result should be a valid BST");
            assertTrue(ConvertSortedArrayToBST.isHeightBalanced(result), "Result should be height-balanced");
        }
    }

    @Nested
    @DisplayName("Recursive with Helper Class Tests")
    class RecursiveWithHelperClassTests {

        @Test
        @DisplayName("Basic example with helper class")
        void testBasicExample() {
            int[] nums = {-10, -3, 0, 5, 9};
            ConvertSortedArrayToBST.TreeNode result = solution.sortedArrayToBSTWithHelper(nums);
            
            assertNotNull(result, "Result should not be null");
            assertTrue(ConvertSortedArrayToBST.isValidBST(result), "Result should be a valid BST");
            assertTrue(ConvertSortedArrayToBST.isHeightBalanced(result), "Result should be height-balanced");
            
            List<Integer> inorder = ConvertSortedArrayToBST.treeToInorderArray(result);
            assertEquals(List.of(-10, -3, 0, 5, 9), inorder, "Inorder traversal should match input");
        }

        @Test
        @DisplayName("Single element with helper class")
        void testSingleElement() {
            int[] nums = {1};
            ConvertSortedArrayToBST.TreeNode result = solution.sortedArrayToBSTWithHelper(nums);
            
            assertNotNull(result, "Result should not be null");
            assertEquals(1, result.val, "Root value should be 1");
        }
    }

    @Nested
    @DisplayName("Recursive with Array Copy Tests")
    class RecursiveWithArrayCopyTests {

        @Test
        @DisplayName("Basic example with array copy")
        void testBasicExample() {
            int[] nums = {-10, -3, 0, 5, 9};
            ConvertSortedArrayToBST.TreeNode result = solution.sortedArrayToBSTWithArrayCopy(nums);
            
            assertNotNull(result, "Result should not be null");
            assertTrue(ConvertSortedArrayToBST.isValidBST(result), "Result should be a valid BST");
            assertTrue(ConvertSortedArrayToBST.isHeightBalanced(result), "Result should be height-balanced");
            
            List<Integer> inorder = ConvertSortedArrayToBST.treeToInorderArray(result);
            assertEquals(List.of(-10, -3, 0, 5, 9), inorder, "Inorder traversal should match input");
        }

        @Test
        @DisplayName("Single element with array copy")
        void testSingleElement() {
            int[] nums = {1};
            ConvertSortedArrayToBST.TreeNode result = solution.sortedArrayToBSTWithArrayCopy(nums);
            
            assertNotNull(result, "Result should not be null");
            assertEquals(1, result.val, "Root value should be 1");
        }
    }

    @Nested
    @DisplayName("Optimized Recursive Tests")
    class OptimizedRecursiveTests {

        @Test
        @DisplayName("Basic example with optimized approach")
        void testBasicExample() {
            int[] nums = {-10, -3, 0, 5, 9};
            ConvertSortedArrayToBST.TreeNode result = solution.sortedArrayToBSTOptimized(nums);
            
            assertNotNull(result, "Result should not be null");
            assertTrue(ConvertSortedArrayToBST.isValidBST(result), "Result should be a valid BST");
            assertTrue(ConvertSortedArrayToBST.isHeightBalanced(result), "Result should be height-balanced");
            
            List<Integer> inorder = ConvertSortedArrayToBST.treeToInorderArray(result);
            assertEquals(List.of(-10, -3, 0, 5, 9), inorder, "Inorder traversal should match input");
        }

        @Test
        @DisplayName("Single element with optimized approach")
        void testSingleElement() {
            int[] nums = {1};
            ConvertSortedArrayToBST.TreeNode result = solution.sortedArrayToBSTOptimized(nums);
            
            assertNotNull(result, "Result should not be null");
            assertEquals(1, result.val, "Root value should be 1");
        }
    }

    @Nested
    @DisplayName("Recursive with Validation Tests")
    class RecursiveWithValidationTests {

        @Test
        @DisplayName("Basic example with validation")
        void testBasicExample() {
            int[] nums = {-10, -3, 0, 5, 9};
            ConvertSortedArrayToBST.TreeNode result = solution.sortedArrayToBSTWithValidation(nums);
            
            assertNotNull(result, "Result should not be null");
            assertTrue(ConvertSortedArrayToBST.isValidBST(result), "Result should be a valid BST");
            assertTrue(ConvertSortedArrayToBST.isHeightBalanced(result), "Result should be height-balanced");
            
            List<Integer> inorder = ConvertSortedArrayToBST.treeToInorderArray(result);
            assertEquals(List.of(-10, -3, 0, 5, 9), inorder, "Inorder traversal should match input");
        }

        @Test
        @DisplayName("Unsorted array should throw exception")
        void testUnsortedArray() {
            int[] nums = {3, 1, 2}; // Not sorted
            assertThrows(IllegalArgumentException.class, () -> {
                solution.sortedArrayToBSTWithValidation(nums);
            }, "Should throw exception for unsorted array");
        }

        @Test
        @DisplayName("Single element with validation")
        void testSingleElement() {
            int[] nums = {1};
            ConvertSortedArrayToBST.TreeNode result = solution.sortedArrayToBSTWithValidation(nums);
            
            assertNotNull(result, "Result should not be null");
            assertEquals(1, result.val, "Root value should be 1");
        }
    }

    @Nested
    @DisplayName("Cross-Approach Consistency Tests")
    class CrossApproachConsistencyTests {

        @ParameterizedTest
        @MethodSource("com.example.leetcode.ConvertSortedArrayToBSTTest#createTestCases")
        @DisplayName("All approaches produce identical results")
        void testAllApproachesConsistency(ConvertSortedArrayToBST.TestCase testCase) {
            // Test all approaches
            ConvertSortedArrayToBST.TreeNode result1 = solution.sortedArrayToBST(testCase.nums);
            ConvertSortedArrayToBST.TreeNode result2 = solution.sortedArrayToBSTIterative(testCase.nums);
            ConvertSortedArrayToBST.TreeNode result3 = solution.sortedArrayToBSTWithHelper(testCase.nums);
            ConvertSortedArrayToBST.TreeNode result4 = solution.sortedArrayToBSTWithArrayCopy(testCase.nums);
            ConvertSortedArrayToBST.TreeNode result5 = solution.sortedArrayToBSTOptimized(testCase.nums);
            ConvertSortedArrayToBST.TreeNode result6 = solution.sortedArrayToBSTWithValidation(testCase.nums);

            // All results should be valid BSTs
            assertTrue(ConvertSortedArrayToBST.isValidBST(result1), "Approach 1 should produce valid BST");
            assertTrue(ConvertSortedArrayToBST.isValidBST(result2), "Approach 2 should produce valid BST");
            assertTrue(ConvertSortedArrayToBST.isValidBST(result3), "Approach 3 should produce valid BST");
            assertTrue(ConvertSortedArrayToBST.isValidBST(result4), "Approach 4 should produce valid BST");
            assertTrue(ConvertSortedArrayToBST.isValidBST(result5), "Approach 5 should produce valid BST");
            assertTrue(ConvertSortedArrayToBST.isValidBST(result6), "Approach 6 should produce valid BST");

            // All results should be height-balanced
            assertTrue(ConvertSortedArrayToBST.isHeightBalanced(result1), "Approach 1 should be height-balanced");
            assertTrue(ConvertSortedArrayToBST.isHeightBalanced(result2), "Approach 2 should be height-balanced");
            assertTrue(ConvertSortedArrayToBST.isHeightBalanced(result3), "Approach 3 should be height-balanced");
            assertTrue(ConvertSortedArrayToBST.isHeightBalanced(result4), "Approach 4 should be height-balanced");
            assertTrue(ConvertSortedArrayToBST.isHeightBalanced(result5), "Approach 5 should be height-balanced");
            assertTrue(ConvertSortedArrayToBST.isHeightBalanced(result6), "Approach 6 should be height-balanced");

            // All results should have same inorder traversal
            List<Integer> inorder1 = ConvertSortedArrayToBST.treeToInorderArray(result1);
            List<Integer> inorder2 = ConvertSortedArrayToBST.treeToInorderArray(result2);
            List<Integer> inorder3 = ConvertSortedArrayToBST.treeToInorderArray(result3);
            List<Integer> inorder4 = ConvertSortedArrayToBST.treeToInorderArray(result4);
            List<Integer> inorder5 = ConvertSortedArrayToBST.treeToInorderArray(result5);
            List<Integer> inorder6 = ConvertSortedArrayToBST.treeToInorderArray(result6);

            assertEquals(inorder1, inorder2, "Approaches 1 and 2 should have same inorder");
            assertEquals(inorder1, inorder3, "Approaches 1 and 3 should have same inorder");
            assertEquals(inorder1, inorder4, "Approaches 1 and 4 should have same inorder");
            assertEquals(inorder1, inorder5, "Approaches 1 and 5 should have same inorder");
            assertEquals(inorder1, inorder6, "Approaches 1 and 6 should have same inorder");
        }
    }

    @Nested
    @DisplayName("Edge Cases and Boundary Tests")
    class EdgeCasesAndBoundaryTests {

        @Test
        @DisplayName("Minimum constraint test")
        void testMinimumConstraint() {
            int[] nums = {0};
            ConvertSortedArrayToBST.TreeNode result = solution.sortedArrayToBST(nums);
            
            assertNotNull(result, "Result should not be null");
            assertEquals(0, result.val, "Root value should be 0");
            assertTrue(ConvertSortedArrayToBST.isValidBST(result), "Result should be a valid BST");
            assertTrue(ConvertSortedArrayToBST.isHeightBalanced(result), "Result should be height-balanced");
        }

        @Test
        @DisplayName("Maximum constraint test (100 elements)")
        void testMaximumConstraint() {
            int[] nums = new int[100];
            for (int i = 0; i < 100; i++) {
                nums[i] = i;
            }
            
            ConvertSortedArrayToBST.TreeNode result = solution.sortedArrayToBST(nums);
            
            assertNotNull(result, "Result should not be null");
            assertTrue(ConvertSortedArrayToBST.isValidBST(result), "Result should be a valid BST");
            assertTrue(ConvertSortedArrayToBST.isHeightBalanced(result), "Result should be height-balanced");
            
            // Verify all elements are present
            List<Integer> inorder = ConvertSortedArrayToBST.treeToInorderArray(result);
            assertEquals(100, inorder.size(), "Should have 100 elements");
            for (int i = 0; i < 100; i++) {
                assertEquals(i, inorder.get(i), "Element at index " + i + " should be " + i);
            }
        }

        @Test
        @DisplayName("Even length array")
        void testEvenLength() {
            int[] nums = {1, 2, 3, 4, 5, 6};
            ConvertSortedArrayToBST.TreeNode result = solution.sortedArrayToBST(nums);
            
            assertNotNull(result, "Result should not be null");
            assertTrue(ConvertSortedArrayToBST.isValidBST(result), "Result should be a valid BST");
            assertTrue(ConvertSortedArrayToBST.isHeightBalanced(result), "Result should be height-balanced");
        }

        @Test
        @DisplayName("Odd length array")
        void testOddLength() {
            int[] nums = {1, 2, 3, 4, 5, 6, 7};
            ConvertSortedArrayToBST.TreeNode result = solution.sortedArrayToBST(nums);
            
            assertNotNull(result, "Result should not be null");
            assertTrue(ConvertSortedArrayToBST.isValidBST(result), "Result should be a valid BST");
            assertTrue(ConvertSortedArrayToBST.isHeightBalanced(result), "Result should be height-balanced");
        }

        @Test
        @DisplayName("Large negative range")
        void testLargeNegativeRange() {
            int[] nums = {-10000, -5000, -1000, -500, -100, -50, -10, -5, -1, 0};
            ConvertSortedArrayToBST.TreeNode result = solution.sortedArrayToBST(nums);
            
            assertNotNull(result, "Result should not be null");
            assertTrue(ConvertSortedArrayToBST.isValidBST(result), "Result should be a valid BST");
            assertTrue(ConvertSortedArrayToBST.isHeightBalanced(result), "Result should be height-balanced");
        }

        @Test
        @DisplayName("Large positive range")
        void testLargePositiveRange() {
            int[] nums = {0, 1, 5, 10, 50, 100, 500, 1000, 5000, 10000};
            ConvertSortedArrayToBST.TreeNode result = solution.sortedArrayToBST(nums);
            
            assertNotNull(result, "Result should not be null");
            assertTrue(ConvertSortedArrayToBST.isValidBST(result), "Result should be a valid BST");
            assertTrue(ConvertSortedArrayToBST.isHeightBalanced(result), "Result should be height-balanced");
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Performance comparison between approaches")
        void testPerformanceComparison() {
            // Create large test case
            int[] nums = new int[1000];
            for (int i = 0; i < 1000; i++) {
                nums[i] = i;
            }
            
            // Measure execution time for each approach
            long time1 = solution.measureExecutionTime(() -> {
                solution.sortedArrayToBST(nums);
            });
            
            long time2 = solution.measureExecutionTime(() -> {
                solution.sortedArrayToBSTIterative(nums);
            });
            
            long time3 = solution.measureExecutionTime(() -> {
                solution.sortedArrayToBSTWithHelper(nums);
            });
            
            long time4 = solution.measureExecutionTime(() -> {
                solution.sortedArrayToBSTWithArrayCopy(nums);
            });
            
            long time5 = solution.measureExecutionTime(() -> {
                solution.sortedArrayToBSTOptimized(nums);
            });
            
            long time6 = solution.measureExecutionTime(() -> {
                solution.sortedArrayToBSTWithValidation(nums);
            });
            
            // Print performance results (for debugging/analysis)
            System.out.println("Performance Results (nanoseconds):");
            System.out.println("Recursive Divide and Conquer: " + time1);
            System.out.println("Iterative with Stack: " + time2);
            System.out.println("Recursive with Helper: " + time3);
            System.out.println("Recursive with Array Copy: " + time4);
            System.out.println("Optimized Recursive: " + time5);
            System.out.println("Recursive with Validation: " + time6);
            
            // Verify all approaches complete successfully
            assertTrue(time1 > 0, "Recursive approach should complete");
            assertTrue(time2 > 0, "Iterative approach should complete");
            assertTrue(time3 > 0, "Helper approach should complete");
            assertTrue(time4 > 0, "Array copy approach should complete");
            assertTrue(time5 > 0, "Optimized approach should complete");
            assertTrue(time6 > 0, "Validation approach should complete");
        }
    }

    @Nested
    @DisplayName("Utility Method Tests")
    class UtilityMethodTests {

        @Test
        @DisplayName("Tree equality test")
        void testTreeEquality() {
            int[] nums = {1, 2, 3};
            ConvertSortedArrayToBST.TreeNode tree1 = solution.sortedArrayToBST(nums);
            ConvertSortedArrayToBST.TreeNode tree2 = solution.sortedArrayToBST(nums);
            
            assertTrue(ConvertSortedArrayToBST.treesEqual(tree1, tree2), "Identical trees should be equal");
        }

        @Test
        @DisplayName("Tree height calculation")
        void testTreeHeight() {
            int[] nums = {1, 2, 3, 4, 5};
            ConvertSortedArrayToBST.TreeNode tree = solution.sortedArrayToBST(nums);
            
            int height = ConvertSortedArrayToBST.getHeight(tree);
            assertTrue(height > 0, "Height should be positive");
            assertTrue(height <= 5, "Height should not exceed number of nodes");
        }

        @Test
        @DisplayName("Node counting")
        void testNodeCounting() {
            int[] nums = {1, 2, 3, 4, 5};
            ConvertSortedArrayToBST.TreeNode tree = solution.sortedArrayToBST(nums);
            
            int count = ConvertSortedArrayToBST.countNodes(tree);
            assertEquals(5, count, "Should have 5 nodes");
        }

        @Test
        @DisplayName("Tree statistics")
        void testTreeStatistics() {
            int[] nums = {1, 2, 3, 4, 5};
            ConvertSortedArrayToBST.TreeNode tree = solution.sortedArrayToBST(nums);
            
            String stats = solution.getTreeStatistics(tree);
            assertNotNull(stats, "Statistics should not be null");
            assertTrue(stats.length() > 0, "Statistics should not be empty");
            assertTrue(stats.contains("5 nodes"), "Stats should contain node count");
            assertTrue(stats.contains("IsBalanced=true"), "Stats should indicate balance");
            assertTrue(stats.contains("IsValidBST=true"), "Stats should indicate valid BST");
        }

        @Test
        @DisplayName("Test case creation")
        void testTestCaseCreation() {
            ConvertSortedArrayToBST.TestCase testCase = ConvertSortedArrayToBST.createTestCase(new int[]{1, 2, 3});
            
            assertArrayEquals(new int[]{1, 2, 3}, testCase.nums);
            assertNotNull(testCase.expected, "Expected tree should not be null");
            assertTrue(ConvertSortedArrayToBST.isValidBST(testCase.expected), "Expected should be valid BST");
        }
    }

    @Nested
    @DisplayName("Comprehensive Test Cases")
    class ComprehensiveTestCases {

        @ParameterizedTest
        @MethodSource("com.example.leetcode.ConvertSortedArrayToBSTTest#createTestCases")
        @DisplayName("Comprehensive test case validation")
        void testComprehensiveCases(ConvertSortedArrayToBST.TestCase testCase) {
            // Test the recommended approach
            ConvertSortedArrayToBST.TreeNode result = solution.sortedArrayToBST(testCase.nums);
            
            // Verify result is not null
            assertNotNull(result, "Result should not be null for: " + java.util.Arrays.toString(testCase.nums));
            
            // Verify it's a valid BST
            assertTrue(ConvertSortedArrayToBST.isValidBST(result), "Result should be a valid BST");
            
            // Verify it's height-balanced
            assertTrue(ConvertSortedArrayToBST.isHeightBalanced(result), "Result should be height-balanced");
            
            // Verify inorder traversal matches input
            List<Integer> inorder = ConvertSortedArrayToBST.treeToInorderArray(result);
            List<Integer> expected = new java.util.ArrayList<>();
            for (int num : testCase.nums) {
                expected.add(num);
            }
            assertEquals(expected, inorder, "Inorder traversal should match input");
            
            // Verify tree statistics
            String stats = solution.getTreeStatistics(result);
            assertNotNull(stats, "Statistics should not be null");
            assertTrue(stats.length() > 0, "Statistics should not be empty");
        }
    }

    /**
     * Create comprehensive test cases for parameterized testing
     */
    static java.util.stream.Stream<ConvertSortedArrayToBST.TestCase> createTestCases() {
        return java.util.stream.Stream.of(ConvertSortedArrayToBST.createTestCases());
    }
}
