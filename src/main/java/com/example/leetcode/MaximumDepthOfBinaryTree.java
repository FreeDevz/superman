package com.example.leetcode;

import java.util.*;

/**
 * LeetCode 104: Maximum Depth of Binary Tree
 * 
 * Problem Description: Given the root of a binary tree, return its maximum depth. A binary tree's
 * maximum depth is the number of nodes along the longest path from the root node down to the
 * farthest leaf node.
 * 
 * Example 1: Input: root = [3,9,20,null,null,15,7] Output: 3
 * 
 * Example 2: Input: root = [1,null,2] Output: 2
 * 
 * Constraints: - The number of nodes in the tree is in the range [0, 10^4]. - -100 <= Node.val <=
 * 100
 * 
 * @author Superman
 * @version 1.0
 */
public class MaximumDepthOfBinaryTree {

    /**
     * Definition for a binary tree node.
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
            return "TreeNode{" + "val=" + val + '}';
        }
    }

    /**
     * Approach 1: Recursive DFS (Depth-First Search)
     * 
     * Time Complexity: O(n) - where n is the number of nodes in the tree Space Complexity: O(h) -
     * where h is the height of the tree (recursion stack)
     * 
     * This is the most intuitive and commonly used approach for tree problems. We recursively
     * calculate the depth of left and right subtrees and return the maximum plus one for the
     * current node.
     */
    public int maxDepthRecursive(TreeNode root) {
        // Base case: if root is null, depth is 0
        if (root == null) {
            return 0;
        }

        // Recursively find depth of left and right subtrees
        int leftDepth = maxDepthRecursive(root.left);
        int rightDepth = maxDepthRecursive(root.right);

        // Return maximum depth plus 1 for current node
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * Approach 2: Iterative BFS (Breadth-First Search) using Queue
     * 
     * Time Complexity: O(n) - where n is the number of nodes in the tree Space Complexity: O(w) -
     * where w is the maximum width of the tree
     * 
     * This approach uses level-order traversal to count the number of levels. We process each level
     * completely before moving to the next level.
     */
    public int maxDepthIterativeBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // Process all nodes at current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                // Add children to queue for next level
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            depth++; // Increment depth after processing each level
        }

        return depth;
    }

    /**
     * Approach 3: Iterative DFS using Stack
     * 
     * Time Complexity: O(n) - where n is the number of nodes in the tree Space Complexity: O(h) -
     * where h is the height of the tree
     * 
     * This approach simulates the recursive call stack using an explicit stack. We store both the
     * node and its current depth in the stack.
     */
    public int maxDepthIterativeDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));
        int maxDepth = 0;

        while (!stack.isEmpty()) {
            Pair current = stack.pop();
            TreeNode node = current.node;
            int depth = current.depth;

            maxDepth = Math.max(maxDepth, depth);

            // Add children to stack with incremented depth
            if (node.left != null) {
                stack.push(new Pair(node.left, depth + 1));
            }
            if (node.right != null) {
                stack.push(new Pair(node.right, depth + 1));
            }
        }

        return maxDepth;
    }

    /**
     * Helper class for storing node and depth pairs in the stack
     */
    private static class Pair {
        TreeNode node;
        int depth;

        Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    /**
     * Approach 4: Optimized Recursive with Early Termination
     * 
     * Time Complexity: O(n) - where n is the number of nodes in the tree Space Complexity: O(h) -
     * where h is the height of the tree
     * 
     * This is an optimized version of the recursive approach with better variable naming and
     * potential for early termination optimizations.
     */
    public int maxDepthOptimizedRecursive(TreeNode root) {
        return calculateDepth(root, 0);
    }

    private int calculateDepth(TreeNode node, int currentDepth) {
        if (node == null) {
            return currentDepth;
        }

        int leftDepth = calculateDepth(node.left, currentDepth + 1);
        int rightDepth = calculateDepth(node.right, currentDepth + 1);

        return Math.max(leftDepth, rightDepth);
    }

    /**
     * Approach 5: One-liner Recursive (Most Concise)
     * 
     * Time Complexity: O(n) - where n is the number of nodes in the tree Space Complexity: O(h) -
     * where h is the height of the tree
     * 
     * This is the most concise version of the recursive solution.
     */
    public int maxDepthOneLiner(TreeNode root) {
        return root == null ? 0
                : Math.max(maxDepthOneLiner(root.left), maxDepthOneLiner(root.right)) + 1;
    }

    /**
     * Approach 6: Recursive with Validation
     * 
     * Time Complexity: O(n) - where n is the number of nodes in the tree Space Complexity: O(h) -
     * where h is the height of the tree
     * 
     * This approach includes input validation and additional safety checks.
     */
    public int maxDepthWithValidation(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Validate node value is within constraints
        if (root.val < -100 || root.val > 100) {
            throw new IllegalArgumentException("Node value must be between -100 and 100");
        }

        int leftDepth = root.left != null ? maxDepthWithValidation(root.left) : 0;
        int rightDepth = root.right != null ? maxDepthWithValidation(root.right) : 0;

        return Math.max(leftDepth, rightDepth) + 1;
    }

    // ==================== UTILITY METHODS ====================

    /**
     * Create a binary tree from an array representation Uses level-order traversal to build the
     * tree
     */
    public static TreeNode createTree(Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < values.length; i += 2) {
            TreeNode current = queue.poll();

            if (current == null)
                continue;

            // Add left child
            if (i < values.length && values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.offer(current.left);
            }

            // Add right child
            if (i + 1 < values.length && values[i + 1] != null) {
                current.right = new TreeNode(values[i + 1]);
                queue.offer(current.right);
            }
        }

        return root;
    }

    /**
     * Convert tree to array representation (level-order)
     */
    public static Integer[] treeToArray(TreeNode root) {
        if (root == null) {
            return new Integer[0];
        }

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                result.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                result.add(null);
            }
        }

        // Remove trailing nulls
        while (!result.isEmpty() && result.get(result.size() - 1) == null) {
            result.remove(result.size() - 1);
        }

        return result.toArray(new Integer[0]);
    }

    /**
     * Calculate the actual height of the tree for verification
     */
    public static int getActualHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getActualHeight(root.left);
        int rightHeight = getActualHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * Count total nodes in the tree
     */
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    /**
     * Check if tree is balanced (height difference <= 1)
     */
    public static boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;
    }

    private static int checkBalance(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = checkBalance(node.left);
        if (leftHeight == -1)
            return -1;

        int rightHeight = checkBalance(node.right);
        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * Print tree structure for debugging
     */
    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        System.out.println("Tree structure:");
        printTreeHelper(root, "", true);
    }

    private static void printTreeHelper(TreeNode node, String prefix, boolean isLast) {
        if (node == null)
            return;

        System.out.println(prefix + (isLast ? "└── " : "├── ") + node.val);

        String newPrefix = prefix + (isLast ? "    " : "│   ");

        if (node.left != null || node.right != null) {
            if (node.right != null) {
                printTreeHelper(node.left, newPrefix, node.right == null);
                printTreeHelper(node.right, newPrefix, true);
            } else {
                printTreeHelper(node.left, newPrefix, true);
            }
        }
    }

    // ==================== DEMONSTRATION ====================

    /**
     * Demonstrate all approaches with example trees
     */
    public static void demonstrate() {
        System.out.println("🌳 Maximum Depth of Binary Tree - All Approaches Demo");
        System.out.println("=".repeat(60));

        MaximumDepthOfBinaryTree solution = new MaximumDepthOfBinaryTree();

        // Test cases
        Integer[][] testCases = {{3, 9, 20, null, null, 15, 7}, // Example 1: depth = 3
                {1, null, 2}, // Example 2: depth = 2
                {1}, // Single node: depth = 1
                {}, // Empty tree: depth = 0
                {1, 2, 3, 4, 5, 6, 7}, // Complete binary tree: depth = 3
                {1, 2, null, 3, null, 4, null, 5}, // Skewed tree: depth = 5
                {1, 2, 3, null, null, 4, 5}, // Mixed tree: depth = 3
        };

        String[] descriptions = {"Example 1: [3,9,20,null,null,15,7]", "Example 2: [1,null,2]",
                "Single node: [1]", "Empty tree: []", "Complete binary tree: [1,2,3,4,5,6,7]",
                "Skewed tree: [1,2,null,3,null,4,null,5]", "Mixed tree: [1,2,3,null,null,4,5]"};

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("\n📊 Test Case " + (i + 1) + ": " + descriptions[i]);
            System.out.println("-".repeat(50));

            TreeNode root = createTree(testCases[i]);

            if (root != null) {
                printTree(root);
                System.out.println("\nTree Statistics:");
                System.out.println("  Total nodes: " + countNodes(root));
                System.out.println("  Is balanced: " + isBalanced(root));
            } else {
                System.out.println("Tree is empty");
            }

            // Test all approaches
            System.out.println("\n🔍 All Approaches Results:");
            long startTime, endTime;

            startTime = System.nanoTime();
            int result1 = solution.maxDepthRecursive(root);
            endTime = System.nanoTime();
            System.out.printf("  1. Recursive DFS:        %d (Time: %d ns)%n", result1,
                    endTime - startTime);

            startTime = System.nanoTime();
            int result2 = solution.maxDepthIterativeBFS(root);
            endTime = System.nanoTime();
            System.out.printf("  2. Iterative BFS:        %d (Time: %d ns)%n", result2,
                    endTime - startTime);

            startTime = System.nanoTime();
            int result3 = solution.maxDepthIterativeDFS(root);
            endTime = System.nanoTime();
            System.out.printf("  3. Iterative DFS:        %d (Time: %d ns)%n", result3,
                    endTime - startTime);

            startTime = System.nanoTime();
            int result4 = solution.maxDepthOptimizedRecursive(root);
            endTime = System.nanoTime();
            System.out.printf("  4. Optimized Recursive:  %d (Time: %d ns)%n", result4,
                    endTime - startTime);

            startTime = System.nanoTime();
            int result5 = solution.maxDepthOneLiner(root);
            endTime = System.nanoTime();
            System.out.printf("  5. One-liner Recursive:  %d (Time: %d ns)%n", result5,
                    endTime - startTime);

            startTime = System.nanoTime();
            int result6 = solution.maxDepthWithValidation(root);
            endTime = System.nanoTime();
            System.out.printf("  6. With Validation:      %d (Time: %d ns)%n", result6,
                    endTime - startTime);

            // Verify all results are the same
            boolean allSame = (result1 == result2 && result2 == result3 && result3 == result4
                    && result4 == result5 && result5 == result6);
            System.out.println("\n✅ All approaches produce same result: " + allSame);

            if (root != null) {
                int actualHeight = getActualHeight(root);
                System.out.println("🔍 Verification - Actual height: " + actualHeight);
                System.out.println("✅ Results match actual height: " + (result1 == actualHeight));
            }
        }

        System.out.println("\n" + "=".repeat(60));
        System.out.println("🎯 Key Insights:");
        System.out.println("• Recursive DFS is most intuitive and commonly used in interviews");
        System.out.println("• Iterative BFS is useful when you need level-by-level processing");
        System.out.println("• Iterative DFS avoids recursion stack overflow for deep trees");
        System.out.println("• All approaches have O(n) time complexity");
        System.out.println("• Space complexity varies: O(h) for DFS, O(w) for BFS");
        System.out.println("• Choose approach based on specific requirements and constraints");
    }

    /**
     * Main method for direct execution and demonstration
     */
    public static void main(String[] args) {
        demonstrate();
    }
}
