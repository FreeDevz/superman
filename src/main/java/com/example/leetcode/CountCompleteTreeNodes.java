package com.example.leetcode;

import java.util.*;

/**
 * LeetCode 222. Count Complete Tree Nodes
 * 
 * Problem Description: Given the root of a complete binary tree, return the number of the nodes in
 * the tree.
 * 
 * According to Wikipedia, every level, except possibly the last, is completely filled in a complete
 * binary tree, and all nodes in the last level are as far left as possible. It can have between 1
 * and 2^h nodes inclusive at the last level h.
 * 
 * Example 1: Input: root = [1,2,3,4,5,6] Output: 6
 * 
 * Example 2: Input: root = [] Output: 0
 * 
 * Example 3: Input: root = [1] Output: 1
 * 
 * Constraints: - The number of nodes in the tree is in the range [0, 5 * 10^4]. - 0 <= Node.val <=
 * 5 * 10^4 - The tree is guaranteed to be complete.
 * 
 * Approach Analysis: 1. Recursive Height Comparison: Use height comparison to identify perfect
 * subtrees 2. Level Order Traversal: BFS traversal counting all nodes 3. Inorder Traversal: DFS
 * traversal counting all nodes 4. Postorder Traversal: DFS traversal counting all nodes 5. Preorder
 * Traversal: DFS traversal counting all nodes 6. Binary Search on Leaves: Binary search approach on
 * the last level 7. Iterative Height Comparison: Iterative version of height comparison
 * 
 * Time Complexity: O(log²n) for optimal approaches, O(n) for traversal approaches Space Complexity:
 * O(logn) for optimal approaches, O(n) for traversal approaches
 */
public class CountCompleteTreeNodes {

    /**
     * Definition for a binary tree node
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" + "val=" + val + "}";
        }
    }

    /**
     * Approach 1: Recursive Height Comparison (Optimal)
     * 
     * Leverage the complete binary tree property: if left and right subtrees have same height, the
     * left subtree is perfect and can be calculated using 2^height - 1.
     * 
     * Time Complexity: O(log²n) Space Complexity: O(logn)
     */
    public static class RecursiveHeightComparisonApproach {
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);

            if (leftHeight == rightHeight) {
                // Left subtree is perfect binary tree
                // Total nodes = left subtree nodes (2^leftHeight - 1) + root (1) + right subtree
                // nodes
                return (1 << leftHeight) + countNodes(root.right);
            } else {
                // Right subtree is perfect binary tree
                // Total nodes = right subtree nodes (2^rightHeight - 1) + root (1) + left subtree
                // nodes
                return (1 << rightHeight) + countNodes(root.left);
            }
        }

        private int getHeight(TreeNode node) {
            int height = 0;
            while (node != null) {
                height++;
                node = node.left;
            }
            return height;
        }
    }

    /**
     * Approach 2: Level Order Traversal (BFS)
     * 
     * Use BFS to traverse all levels and count nodes.
     * 
     * Time Complexity: O(n) Space Complexity: O(n)
     */
    public static class LevelOrderTraversalApproach {
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int count = 0;

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                count++;

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            return count;
        }
    }

    /**
     * Approach 3: Inorder Traversal (DFS)
     * 
     * Use inorder traversal to count all nodes.
     * 
     * Time Complexity: O(n) Space Complexity: O(logn) average, O(n) worst case
     */
    public static class InorderTraversalApproach {
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }

            return inorderTraversal(root);
        }

        private int inorderTraversal(TreeNode node) {
            if (node == null) {
                return 0;
            }

            int leftCount = inorderTraversal(node.left);
            int rightCount = inorderTraversal(node.right);

            return leftCount + 1 + rightCount;
        }
    }

    /**
     * Approach 4: Postorder Traversal (DFS)
     * 
     * Use postorder traversal to count all nodes.
     * 
     * Time Complexity: O(n) Space Complexity: O(logn) average, O(n) worst case
     */
    public static class PostorderTraversalApproach {
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }

            return postorderTraversal(root);
        }

        private int postorderTraversal(TreeNode node) {
            if (node == null) {
                return 0;
            }

            int leftCount = postorderTraversal(node.left);
            int rightCount = postorderTraversal(node.right);

            return leftCount + rightCount + 1;
        }
    }

    /**
     * Approach 5: Preorder Traversal (DFS)
     * 
     * Use preorder traversal to count all nodes.
     * 
     * Time Complexity: O(n) Space Complexity: O(logn) average, O(n) worst case
     */
    public static class PreorderTraversalApproach {
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }

            return preorderTraversal(root);
        }

        private int preorderTraversal(TreeNode node) {
            if (node == null) {
                return 0;
            }

            int leftCount = preorderTraversal(node.left);
            int rightCount = preorderTraversal(node.right);

            return 1 + leftCount + rightCount;
        }
    }

    /**
     * Approach 6: Binary Search on Leaves
     * 
     * Use binary search to find the number of nodes in the last level.
     * 
     * Time Complexity: O(log²n) Space Complexity: O(logn)
     */
    public static class BinarySearchOnLeavesApproach {
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int height = getHeight(root);
            if (height == 1) {
                return 1;
            }

            // Number of nodes in all levels except the last
            int upperLevelNodes = (1 << (height - 1)) - 1;

            // Binary search for the number of nodes in the last level
            int left = 0;
            int right = (1 << (height - 1)) - 1;

            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (exists(root, height, mid)) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }

            return upperLevelNodes + left + 1;
        }

        private int getHeight(TreeNode node) {
            int height = 0;
            while (node != null) {
                height++;
                node = node.left;
            }
            return height;
        }

        private boolean exists(TreeNode root, int height, int index) {
            int left = 0;
            int right = (1 << (height - 1)) - 1;

            for (int i = 0; i < height - 1; i++) {
                int mid = left + (right - left) / 2;
                if (index <= mid) {
                    root = root.left;
                    right = mid;
                } else {
                    root = root.right;
                    left = mid + 1;
                }
            }

            return root != null;
        }
    }

    /**
     * Approach 7: Iterative Height Comparison
     * 
     * Iterative version of the height comparison approach.
     * 
     * Time Complexity: O(log²n) Space Complexity: O(1)
     */
    public static class IterativeHeightComparisonApproach {
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int count = 0;
            TreeNode current = root;

            while (current != null) {
                int leftHeight = getHeight(current.left);
                int rightHeight = getHeight(current.right);

                if (leftHeight == rightHeight) {
                    // Left subtree is perfect
                    count += (1 << leftHeight);
                    current = current.right;
                } else {
                    // Right subtree is perfect
                    count += (1 << rightHeight);
                    current = current.left;
                }
            }

            return count;
        }

        private int getHeight(TreeNode node) {
            int height = 0;
            while (node != null) {
                height++;
                node = node.left;
            }
            return height;
        }
    }

    /**
     * Approach 8: Simple Recursive Count
     * 
     * Simple recursive approach that counts all nodes.
     * 
     * Time Complexity: O(n) Space Complexity: O(logn) average, O(n) worst case
     */
    public static class SimpleRecursiveApproach {
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }

            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    /**
     * Helper method to create test data
     */
    public static class TestData {
        public static List<TestCase> getTestCases() {
            return Arrays.asList(new TestCase(createTree1(), 6, "Example 1: [1,2,3,4,5,6]"),
                    new TestCase(null, 0, "Example 2: Empty tree"),
                    new TestCase(new TreeNode(1), 1, "Example 3: Single node"),
                    new TestCase(createTree2(), 1, "Single node tree"),
                    new TestCase(createTree3(), 3, "Three nodes tree"),
                    new TestCase(createTree4(), 7, "Seven nodes tree"),
                    new TestCase(createTree5(), 15, "Perfect binary tree (15 nodes)"),
                    new TestCase(createTree6(), 8, "Complete tree with 8 nodes"),
                    new TestCase(createTree7(), 12, "Complete tree with 12 nodes"),
                    new TestCase(createTree8(), 31, "Large complete tree (31 nodes)"));
        }

        public static class TestCase {
            private final TreeNode root;
            private final int expected;
            private final String description;

            public TestCase(TreeNode root, int expected, String description) {
                this.root = root;
                this.expected = expected;
                this.description = description;
            }

            public TreeNode getRoot() {
                return root;
            }

            public int getExpected() {
                return expected;
            }

            public String getDescription() {
                return description;
            }
        }

        // Helper methods to create test trees
        private static TreeNode createTree1() {
            // [1,2,3,4,5,6]
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.right.left = new TreeNode(6);
            return root;
        }

        private static TreeNode createTree2() {
            // Single node
            return new TreeNode(1);
        }

        private static TreeNode createTree3() {
            // Three nodes
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            return root;
        }

        private static TreeNode createTree4() {
            // Seven nodes
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(7);
            return root;
        }

        private static TreeNode createTree5() {
            // Perfect binary tree with 15 nodes (4 levels)
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(7);
            root.left.left.left = new TreeNode(8);
            root.left.left.right = new TreeNode(9);
            root.left.right.left = new TreeNode(10);
            root.left.right.right = new TreeNode(11);
            root.right.left.left = new TreeNode(12);
            root.right.left.right = new TreeNode(13);
            root.right.right.left = new TreeNode(14);
            root.right.right.right = new TreeNode(15);
            return root;
        }

        private static TreeNode createTree6() {
            // Complete tree with 8 nodes
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(7);
            root.left.left.left = new TreeNode(8);
            return root;
        }

        private static TreeNode createTree7() {
            // Complete tree with 12 nodes
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(7);
            root.left.left.left = new TreeNode(8);
            root.left.left.right = new TreeNode(9);
            root.left.right.left = new TreeNode(10);
            root.left.right.right = new TreeNode(11);
            root.right.left.left = new TreeNode(12);
            return root;
        }

        private static TreeNode createTree8() {
            // Large complete tree with 31 nodes (5 levels)
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(7);
            root.left.left.left = new TreeNode(8);
            root.left.left.right = new TreeNode(9);
            root.left.right.left = new TreeNode(10);
            root.left.right.right = new TreeNode(11);
            root.right.left.left = new TreeNode(12);
            root.right.left.right = new TreeNode(13);
            root.right.right.left = new TreeNode(14);
            root.right.right.right = new TreeNode(15);
            root.left.left.left.left = new TreeNode(16);
            root.left.left.left.right = new TreeNode(17);
            root.left.left.right.left = new TreeNode(18);
            root.left.left.right.right = new TreeNode(19);
            root.left.right.left.left = new TreeNode(20);
            root.left.right.left.right = new TreeNode(21);
            root.left.right.right.left = new TreeNode(22);
            root.left.right.right.right = new TreeNode(23);
            root.right.left.left.left = new TreeNode(24);
            root.right.left.left.right = new TreeNode(25);
            root.right.left.right.left = new TreeNode(26);
            root.right.left.right.right = new TreeNode(27);
            root.right.right.left.left = new TreeNode(28);
            root.right.right.left.right = new TreeNode(29);
            root.right.right.right.left = new TreeNode(30);
            root.right.right.right.right = new TreeNode(31);
            return root;
        }
    }

    /**
     * Helper method to run a test with given approach
     */
    public static void runTest(String approachName, Object approach, TreeNode root, int expected) {
        System.out.println("\n=== Testing " + approachName + " ===");
        System.out.println("Expected: " + expected);

        try {
            long startTime = System.nanoTime();
            int result;

            if (approach instanceof RecursiveHeightComparisonApproach) {
                result = ((RecursiveHeightComparisonApproach) approach).countNodes(root);
            } else if (approach instanceof LevelOrderTraversalApproach) {
                result = ((LevelOrderTraversalApproach) approach).countNodes(root);
            } else if (approach instanceof InorderTraversalApproach) {
                result = ((InorderTraversalApproach) approach).countNodes(root);
            } else if (approach instanceof PostorderTraversalApproach) {
                result = ((PostorderTraversalApproach) approach).countNodes(root);
            } else if (approach instanceof PreorderTraversalApproach) {
                result = ((PreorderTraversalApproach) approach).countNodes(root);
            } else if (approach instanceof BinarySearchOnLeavesApproach) {
                result = ((BinarySearchOnLeavesApproach) approach).countNodes(root);
            } else if (approach instanceof IterativeHeightComparisonApproach) {
                result = ((IterativeHeightComparisonApproach) approach).countNodes(root);
            } else if (approach instanceof SimpleRecursiveApproach) {
                result = ((SimpleRecursiveApproach) approach).countNodes(root);
            } else {
                throw new IllegalArgumentException("Unknown approach: " + approachName);
            }

            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1_000; // Convert to microseconds

            System.out.println("Result: " + result);
            System.out.println("Correct: " + (result == expected));
            System.out.println("Execution time: " + duration + "μs");

        } catch (Exception e) {
            System.err.println("Error in " + approachName + ": " + e.getMessage());
        }
    }

    /**
     * Helper method to validate results
     */
    public static boolean validateResult(int actual, int expected) {
        return actual == expected;
    }

    /**
     * Helper method to get tree height
     */
    public static int getTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getTreeHeight(root.left), getTreeHeight(root.right));
    }

    /**
     * Helper method to print tree structure (for debugging)
     */
    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("Empty tree");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            System.out.println();
        }
    }

    /**
     * Main method for testing all approaches
     */
    public static void main(String[] args) {
        System.out.println("Count Complete Tree Nodes - Multiple Approaches Demo");
        System.out.println("===================================================");

        // Test with sample data
        List<TestData.TestCase> testCases = TestData.getTestCases();

        // Test all approaches
        String[] approachNames = {"Recursive Height Comparison", "Level Order Traversal",
                "Inorder Traversal", "Postorder Traversal", "Preorder Traversal",
                "Binary Search on Leaves", "Iterative Height Comparison", "Simple Recursive"};

        Object[] approaches =
                {new RecursiveHeightComparisonApproach(), new LevelOrderTraversalApproach(),
                        new InorderTraversalApproach(), new PostorderTraversalApproach(),
                        new PreorderTraversalApproach(), new BinarySearchOnLeavesApproach(),
                        new IterativeHeightComparisonApproach(), new SimpleRecursiveApproach()};

        // Test with first few test cases
        System.out.println("\nTesting with sample cases:");
        for (int i = 0; i < Math.min(5, testCases.size()); i++) {
            TestData.TestCase testCase = testCases.get(i);
            System.out.println("\n" + "=".repeat(60));
            System.out.println("Test Case: " + testCase.getDescription());
            System.out.println("Tree Height: " + getTreeHeight(testCase.getRoot()));

            for (int j = 0; j < approachNames.length; j++) {
                runTest(approachNames[j], approaches[j], testCase.getRoot(),
                        testCase.getExpected());
            }
        }

        // Performance test with larger trees
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Performance Test with Large Trees");
        System.out.println("=".repeat(60));

        TreeNode largeTree = TestData.createTree8(); // 31 nodes
        int largeExpected = 31;

        System.out.println("Large Tree (31 nodes):");
        for (int i = 0; i < approachNames.length; i++) {
            runTest(approachNames[i], approaches[i], largeTree, largeExpected);
        }

        // Cross-validation test
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Cross-Validation Test");
        System.out.println("=".repeat(60));

        boolean allCorrect = true;
        for (TestData.TestCase testCase : testCases) {
            List<Integer> results = new ArrayList<>();

            for (Object approach : approaches) {
                int result;
                if (approach instanceof RecursiveHeightComparisonApproach) {
                    result = ((RecursiveHeightComparisonApproach) approach)
                            .countNodes(testCase.getRoot());
                } else if (approach instanceof LevelOrderTraversalApproach) {
                    result = ((LevelOrderTraversalApproach) approach)
                            .countNodes(testCase.getRoot());
                } else if (approach instanceof InorderTraversalApproach) {
                    result = ((InorderTraversalApproach) approach).countNodes(testCase.getRoot());
                } else if (approach instanceof PostorderTraversalApproach) {
                    result = ((PostorderTraversalApproach) approach).countNodes(testCase.getRoot());
                } else if (approach instanceof PreorderTraversalApproach) {
                    result = ((PreorderTraversalApproach) approach).countNodes(testCase.getRoot());
                } else if (approach instanceof BinarySearchOnLeavesApproach) {
                    result = ((BinarySearchOnLeavesApproach) approach)
                            .countNodes(testCase.getRoot());
                } else if (approach instanceof IterativeHeightComparisonApproach) {
                    result = ((IterativeHeightComparisonApproach) approach)
                            .countNodes(testCase.getRoot());
                } else if (approach instanceof SimpleRecursiveApproach) {
                    result = ((SimpleRecursiveApproach) approach).countNodes(testCase.getRoot());
                } else {
                    continue;
                }
                results.add(result);
            }

            // Check if all approaches produce same result
            boolean allSame = results.stream().allMatch(r -> r.equals(results.get(0)));
            boolean correct = results.get(0) == testCase.getExpected();

            if (!allSame || !correct) {
                allCorrect = false;
                System.out.println("FAILED: " + testCase.getDescription());
                System.out.println("  Expected: " + testCase.getExpected());
                System.out.println("  Results: " + results);
            }
        }

        System.out.println("All approaches produce consistent results: " + allCorrect);
    }
}
