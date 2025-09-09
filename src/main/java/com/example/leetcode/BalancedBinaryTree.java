package com.example.leetcode;

import java.util.*;

/**
 * LeetCode 110: Balanced Binary Tree
 * 
 * Problem Description: Given a binary tree, determine if it is height-balanced. A height-balanced
 * binary tree is a binary tree in which the depth of the two subtrees of every node never differs
 * by more than 1.
 * 
 * Example 1: Input: root = [3,9,20,null,null,15,7] Output: true
 * 
 * Example 2: Input: root = [1,2,2,3,3,null,null,4,4] Output: false
 * 
 * Example 3: Input: root = [] Output: true
 * 
 * Constraints: - The number of nodes in the tree is in the range [0, 5000] - -10^4 <= Node.val <=
 * 10^4
 * 
 * @author Superman
 * @version 1.0
 */
public class BalancedBinaryTree {

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
     * Approach 1: Bottom-up Recursion (Optimal)
     * 
     * Time Complexity: O(n) - Each node is visited once Space Complexity: O(h) - Where h is the
     * height of the tree (recursion stack)
     * 
     * This approach combines height calculation and balance checking in a single traversal. If any
     * subtree is unbalanced, we return -1 immediately to avoid unnecessary computations.
     */
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    /**
     * Helper method to check height and balance simultaneously. Returns -1 if the subtree is
     * unbalanced, otherwise returns the height.
     */
    private int checkHeight(TreeNode node) {
        // Base case: null node has height 0
        if (node == null) {
            return 0;
        }

        // Check left subtree height
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) {
            return -1; // Left subtree is unbalanced
        }

        // Check right subtree height
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) {
            return -1; // Right subtree is unbalanced
        }

        // Check if current node is balanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Current node is unbalanced
        }

        // Return height of current subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }

    /**
     * Approach 2: Top-down Recursion (Less Efficient)
     * 
     * Time Complexity: O(n^2) - For each node, we calculate height of its subtrees Space
     * Complexity: O(h) - Where h is the height of the tree
     * 
     * This approach first calculates the height of each subtree, then checks balance. Less
     * efficient because height calculation is repeated for each node.
     */
    public boolean isBalancedTopDown(TreeNode root) {
        if (root == null) {
            return true;
        }

        // Check if current node is balanced
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        // Recursively check left and right subtrees
        return isBalancedTopDown(root.left) && isBalancedTopDown(root.right);
    }

    /**
     * Helper method to calculate the height of a tree.
     */
    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    /**
     * Approach 3: Iterative Solution using Stack
     * 
     * Time Complexity: O(n) - Each node is visited once Space Complexity: O(h) - Stack space for
     * tree traversal
     * 
     * This approach uses a stack to simulate the recursive calls and track the height of each
     * subtree.
     */
    public boolean isBalancedIterative(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> heights = new HashMap<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();

            // If we've already processed this node's children
            if (heights.containsKey(node)) {
                stack.pop();

                int leftHeight = heights.getOrDefault(node.left, 0);
                int rightHeight = heights.getOrDefault(node.right, 0);

                if (Math.abs(leftHeight - rightHeight) > 1) {
                    return false;
                }

                heights.put(node, 1 + Math.max(leftHeight, rightHeight));
            } else {
                // Mark as processed and add children to stack
                heights.put(node, -1); // Temporary marker

                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }

        return true;
    }

    /**
     * Approach 4: Enhanced Bottom-up with Early Termination
     * 
     * Time Complexity: O(n) - Each node is visited once Space Complexity: O(h) - Recursion stack
     * space
     * 
     * This is an enhanced version of the bottom-up approach with additional optimizations and
     * clearer separation of concerns.
     */
    public boolean isBalancedEnhanced(TreeNode root) {
        return getHeightAndCheckBalance(root) != -1;
    }

    /**
     * Enhanced helper method that returns height if balanced, -1 if unbalanced.
     */
    private int getHeightAndCheckBalance(TreeNode node) {
        // Base case
        if (node == null) {
            return 0;
        }

        // Recursively check left and right subtrees
        int leftHeight = getHeightAndCheckBalance(node.left);
        if (leftHeight == -1) {
            return -1; // Early termination if left subtree is unbalanced
        }

        int rightHeight = getHeightAndCheckBalance(node.right);
        if (rightHeight == -1) {
            return -1; // Early termination if right subtree is unbalanced
        }

        // Check balance condition
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Current node is unbalanced
        }

        // Return height of current subtree
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // ==================== UTILITY METHODS ====================

    /**
     * Creates a binary tree from an array representation. Uses level-order traversal to build the
     * tree.
     */
    public static TreeNode buildTree(Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode node = queue.poll();

            // Add left child
            if (i < values.length && values[i] != null) {
                node.left = new TreeNode(values[i]);
                queue.offer(node.left);
            }
            i++;

            // Add right child
            if (i < values.length && values[i] != null) {
                node.right = new TreeNode(values[i]);
                queue.offer(node.right);
            }
            i++;
        }

        return root;
    }

    /**
     * Converts a binary tree to array representation using level-order traversal.
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
     * Prints the tree structure in a readable format.
     */
    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("Empty tree");
            return;
        }

        System.out.println("Tree structure:");
        printTreeHelper(root, "", true);
    }

    private static void printTreeHelper(TreeNode node, String prefix, boolean isLast) {
        if (node == null) {
            return;
        }

        System.out.println(prefix + (isLast ? "└── " : "├── ") + node.val);

        String newPrefix = prefix + (isLast ? "    " : "│   ");

        if (node.left != null || node.right != null) {
            if (node.left != null) {
                printTreeHelper(node.left, newPrefix, node.right == null);
            }
            if (node.right != null) {
                printTreeHelper(node.right, newPrefix, true);
            }
        }
    }

    /**
     * Calculates the actual height of a tree for verification purposes.
     */
    public static int calculateHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(calculateHeight(root.left), calculateHeight(root.right));
    }

    /**
     * Checks if a tree is balanced using a simple recursive approach for verification.
     */
    public static boolean isBalancedSimple(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);

        return Math.abs(leftHeight - rightHeight) <= 1 && isBalancedSimple(root.left)
                && isBalancedSimple(root.right);
    }

    // ==================== DEMONSTRATION ====================

    /**
     * Demonstrates the solution with various test cases.
     */
    public static void demonstrate() {
        System.out.println("=== Balanced Binary Tree Solution Demonstration ===\n");

        BalancedBinaryTree solution = new BalancedBinaryTree();

        // Test Case 1: Balanced tree
        System.out.println("Test Case 1: Balanced tree [3,9,20,null,null,15,7]");
        Integer[] tree1 = {3, 9, 20, null, null, 15, 7};
        TreeNode root1 = buildTree(tree1);
        printTree(root1);
        System.out.println("Is balanced (bottom-up): " + solution.isBalanced(root1));
        System.out.println("Is balanced (top-down): " + solution.isBalancedTopDown(root1));
        System.out.println("Is balanced (iterative): " + solution.isBalancedIterative(root1));
        System.out.println("Is balanced (enhanced): " + solution.isBalancedEnhanced(root1));
        System.out.println();

        // Test Case 2: Unbalanced tree
        System.out.println("Test Case 2: Unbalanced tree [1,2,2,3,3,null,null,4,4]");
        Integer[] tree2 = {1, 2, 2, 3, 3, null, null, 4, 4};
        TreeNode root2 = buildTree(tree2);
        printTree(root2);
        System.out.println("Is balanced (bottom-up): " + solution.isBalanced(root2));
        System.out.println("Is balanced (top-down): " + solution.isBalancedTopDown(root2));
        System.out.println("Is balanced (iterative): " + solution.isBalancedIterative(root2));
        System.out.println("Is balanced (enhanced): " + solution.isBalancedEnhanced(root2));
        System.out.println();

        // Test Case 3: Empty tree
        System.out.println("Test Case 3: Empty tree []");
        TreeNode root3 = null;
        printTree(root3);
        System.out.println("Is balanced (bottom-up): " + solution.isBalanced(root3));
        System.out.println("Is balanced (top-down): " + solution.isBalancedTopDown(root3));
        System.out.println("Is balanced (iterative): " + solution.isBalancedIterative(root3));
        System.out.println("Is balanced (enhanced): " + solution.isBalancedEnhanced(root3));
        System.out.println();

        // Test Case 4: Single node
        System.out.println("Test Case 4: Single node [1]");
        Integer[] tree4 = {1};
        TreeNode root4 = buildTree(tree4);
        printTree(root4);
        System.out.println("Is balanced (bottom-up): " + solution.isBalanced(root4));
        System.out.println("Is balanced (top-down): " + solution.isBalancedTopDown(root4));
        System.out.println("Is balanced (iterative): " + solution.isBalancedIterative(root4));
        System.out.println("Is balanced (enhanced): " + solution.isBalancedEnhanced(root4));
        System.out.println();

        // Test Case 5: Skewed tree
        System.out.println("Test Case 5: Skewed tree [1,2,null,3,null,4,null]");
        Integer[] tree5 = {1, 2, null, 3, null, 4, null};
        TreeNode root5 = buildTree(tree5);
        printTree(root5);
        System.out.println("Is balanced (bottom-up): " + solution.isBalanced(root5));
        System.out.println("Is balanced (top-down): " + solution.isBalancedTopDown(root5));
        System.out.println("Is balanced (iterative): " + solution.isBalancedIterative(root5));
        System.out.println("Is balanced (enhanced): " + solution.isBalancedEnhanced(root5));
        System.out.println();

        System.out.println("=== Performance Comparison ===");
        System.out.println("Bottom-up approach: O(n) time, O(h) space - RECOMMENDED");
        System.out.println("Top-down approach: O(n^2) time, O(h) space - Less efficient");
        System.out.println("Iterative approach: O(n) time, O(h) space - Alternative to recursion");
        System.out.println("Enhanced approach: O(n) time, O(h) space - Optimized version");
    }

    /**
     * Main method for testing and demonstration.
     */
    public static void main(String[] args) {
        demonstrate();
    }
}
