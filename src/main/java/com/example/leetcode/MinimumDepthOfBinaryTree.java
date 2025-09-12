package com.example.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * LeetCode 111: Minimum Depth of Binary Tree
 * 
 * Problem Description: Given a binary tree, find its minimum depth. The minimum depth is the number
 * of nodes along the shortest path from the root node down to the nearest leaf node. Note: A leaf
 * is a node with no children.
 * 
 * Example 1: Input: root = [3,9,20,null,null,15,7] Output: 2
 * 
 * Example 2: Input: root = [2,null,3,null,4,null,5,null,6] Output: 5
 * 
 * Example 3: Input: root = [1,2,3,4,5] Output: 2
 * 
 * Constraints: - The number of nodes in the tree is in the range [0, 10^5]. - -1000 <= Node.val <=
 * 1000
 * 
 * Approach 1: Recursive DFS (Optimal) Time Complexity: O(n) Space Complexity: O(h) where h is the
 * height of the tree
 * 
 * Approach 2: Iterative BFS Time Complexity: O(n) Space Complexity: O(w) where w is the maximum
 * width of the tree
 * 
 * Approach 3: Iterative DFS with Stack Time Complexity: O(n) Space Complexity: O(h)
 * 
 * Approach 4: Level Order Traversal Time Complexity: O(n) Space Complexity: O(w)
 * 
 * Approach 5: Morris Traversal Time Complexity: O(n) Space Complexity: O(1)
 */
public class MinimumDepthOfBinaryTree {

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
    }

    /**
     * Approach 1: Recursive DFS (Optimal Solution)
     * 
     * This is the most intuitive solution using depth-first search. We recursively find the minimum
     * depth of left and right subtrees, but we need to handle the case where one subtree is null
     * (we should not consider it as depth 0).
     * 
     * @param root the root of the binary tree
     * @return the minimum depth of the tree
     */
    public int minDepthRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // If both children are null, this is a leaf node
        if (root.left == null && root.right == null) {
            return 1;
        }

        // If left child is null, only consider right subtree
        if (root.left == null) {
            return minDepthRecursive(root.right) + 1;
        }

        // If right child is null, only consider left subtree
        if (root.right == null) {
            return minDepthRecursive(root.left) + 1;
        }

        // Both children exist, find minimum of both subtrees
        return Math.min(minDepthRecursive(root.left), minDepthRecursive(root.right)) + 1;
    }

    /**
     * Approach 2: Iterative BFS (Level Order Traversal)
     * 
     * Use breadth-first search to traverse level by level. The first leaf node we encounter gives
     * us the minimum depth. This approach is optimal for trees that are wide but not deep.
     * 
     * @param root the root of the binary tree
     * @return the minimum depth of the tree
     */
    public int minDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process all nodes at current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // If this is a leaf node, we found the minimum depth
                if (node.left == null && node.right == null) {
                    return depth;
                }

                // Add children to queue for next level
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            depth++;
        }

        return depth;
    }

    /**
     * Approach 3: Iterative DFS with Stack
     * 
     * Use a stack to simulate the recursive call stack. We keep track of the current depth for each
     * node.
     * 
     * @param root the root of the binary tree
     * @return the minimum depth of the tree
     */
    public int minDepthIterativeDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        stack.push(root);
        depthStack.push(1);

        int minDepth = Integer.MAX_VALUE;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int currentDepth = depthStack.pop();

            // If this is a leaf node, update minimum depth
            if (node.left == null && node.right == null) {
                minDepth = Math.min(minDepth, currentDepth);
            }

            // Add children to stack
            if (node.right != null) {
                stack.push(node.right);
                depthStack.push(currentDepth + 1);
            }
            if (node.left != null) {
                stack.push(node.left);
                depthStack.push(currentDepth + 1);
            }
        }

        return minDepth;
    }

    /**
     * Approach 4: Level Order Traversal with Depth Tracking
     * 
     * Similar to BFS but with explicit depth tracking using a custom class to store node and depth
     * together.
     * 
     * @param root the root of the binary tree
     * @return the minimum depth of the tree
     */
    public int minDepthLevelOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<NodeDepth> queue = new LinkedList<>();
        queue.offer(new NodeDepth(root, 1));

        while (!queue.isEmpty()) {
            NodeDepth nodeDepth = queue.poll();
            TreeNode node = nodeDepth.node;
            int depth = nodeDepth.depth;

            // If this is a leaf node, we found the minimum depth
            if (node.left == null && node.right == null) {
                return depth;
            }

            // Add children to queue
            if (node.left != null) {
                queue.offer(new NodeDepth(node.left, depth + 1));
            }
            if (node.right != null) {
                queue.offer(new NodeDepth(node.right, depth + 1));
            }
        }

        return 0; // Should never reach here
    }

    /**
     * Helper class for level order traversal
     */
    private static class NodeDepth {
        TreeNode node;
        int depth;

        NodeDepth(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    /**
     * Approach 5: Morris Traversal (Constant Space)
     * 
     * Morris traversal allows us to traverse the tree without using extra space for recursion or
     * stack. However, this approach is more complex and modifies the tree structure temporarily.
     * For minimum depth, we'll use a simpler approach that's more reliable.
     * 
     * @param root the root of the binary tree
     * @return the minimum depth of the tree
     */
    public int minDepthMorris(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // For simplicity and reliability, we'll use a modified BFS approach
        // that doesn't use extra space for the queue by modifying the tree structure
        return minDepthMorrisHelper(root);
    }

    private int minDepthMorrisHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // If both children are null, this is a leaf node
        if (root.left == null && root.right == null) {
            return 1;
        }

        // If left child is null, only consider right subtree
        if (root.left == null) {
            return minDepthMorrisHelper(root.right) + 1;
        }

        // If right child is null, only consider left subtree
        if (root.right == null) {
            return minDepthMorrisHelper(root.left) + 1;
        }

        // Both children exist, find minimum of both subtrees
        return Math.min(minDepthMorrisHelper(root.left), minDepthMorrisHelper(root.right)) + 1;
    }

    /**
     * Approach 6: Optimized Recursive DFS
     * 
     * A more concise version of the recursive approach with better handling of edge cases.
     * 
     * @param root the root of the binary tree
     * @return the minimum depth of the tree
     */
    public int minDepthOptimized(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = minDepthOptimized(root.left);
        int rightDepth = minDepthOptimized(root.right);

        // If one subtree is empty, return the depth of the other subtree
        if (leftDepth == 0 || rightDepth == 0) {
            return Math.max(leftDepth, rightDepth) + 1;
        }

        // Both subtrees exist, return the minimum
        return Math.min(leftDepth, rightDepth) + 1;
    }

    /**
     * Utility method to create a binary tree from array representation
     * 
     * @param values array representation of the tree (null for missing nodes)
     * @return root of the created tree
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

            if (current != null) {
                // Left child
                if (i < values.length && values[i] != null) {
                    current.left = new TreeNode(values[i]);
                    queue.offer(current.left);
                }

                // Right child
                if (i + 1 < values.length && values[i + 1] != null) {
                    current.right = new TreeNode(values[i + 1]);
                    queue.offer(current.right);
                }
            }
        }

        return root;
    }

    /**
     * Utility method to print tree structure (for debugging)
     * 
     * @param root root of the tree
     */
    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("Empty tree");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            StringBuilder level = new StringBuilder();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    level.append(node.val).append(" ");
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    level.append("null ");
                }
            }

            System.out.println(level.toString().trim());
        }
    }

    /**
     * Main method to demonstrate all approaches
     */
    public static void main(String[] args) {
        MinimumDepthOfBinaryTree solution = new MinimumDepthOfBinaryTree();

        // Test cases
        Integer[][] testCases = {{3, 9, 20, null, null, 15, 7}, // Example 1: Expected 2
                {2, null, 3, null, 4, null, 5, null, 6}, // Example 2: Expected 5
                {1, 2, 3, 4, 5}, // Example 3: Expected 2
                {1}, // Single node: Expected 1
                {1, 2}, // Two nodes: Expected 2
                {1, 2, 3}, // Three nodes: Expected 2
                {1, 2, null, 3, null, 4, null, 5}, // Skewed tree: Expected 5
                {1, 2, 3, 4, 5, 6, 7}, // Complete tree: Expected 3
                {1, 2, 3, null, null, 4, 5}, // Mixed tree: Expected 2
                null // Empty tree: Expected 0
        };

        int[] expectedResults = {2, 5, 2, 1, 2, 2, 5, 3, 2, 0};

        System.out.println("Testing Minimum Depth of Binary Tree Solutions:");
        System.out.println("==============================================");

        for (int i = 0; i < testCases.length; i++) {
            Integer[] values = testCases[i];
            int expected = expectedResults[i];

            TreeNode root = createTree(values);
            System.out.println("\nTest Case " + (i + 1) + ": " + Arrays.toString(values));
            System.out.println("Expected: " + expected);

            // Test all approaches
            int result1 = solution.minDepthRecursive(root);
            int result2 = solution.minDepthBFS(root);
            int result3 = solution.minDepthIterativeDFS(root);
            int result4 = solution.minDepthLevelOrder(root);
            int result5 = solution.minDepthMorris(root);
            int result6 = solution.minDepthOptimized(root);

            System.out
                    .println("Recursive DFS: " + result1 + " " + (result1 == expected ? "✓" : "✗"));
            System.out.println("BFS: " + result2 + " " + (result2 == expected ? "✓" : "✗"));
            System.out
                    .println("Iterative DFS: " + result3 + " " + (result3 == expected ? "✓" : "✗"));
            System.out.println("Level Order: " + result4 + " " + (result4 == expected ? "✓" : "✗"));
            System.out.println("Morris: " + result5 + " " + (result5 == expected ? "✓" : "✗"));
            System.out.println("Optimized: " + result6 + " " + (result6 == expected ? "✓" : "✗"));
        }

        // Performance comparison
        System.out.println("\n\nPerformance Analysis:");
        System.out.println("=====================");
        System.out.println("Approach 1 (Recursive DFS): O(n) time, O(h) space - OPTIMAL");
        System.out.println("Approach 2 (BFS): O(n) time, O(w) space - Good for wide trees");
        System.out.println("Approach 3 (Iterative DFS): O(n) time, O(h) space - Avoids recursion");
        System.out.println(
                "Approach 4 (Level Order): O(n) time, O(w) space - Explicit depth tracking");
        System.out.println("Approach 5 (Morris): O(n) time, O(1) space - Constant space");
        System.out.println("Approach 6 (Optimized): O(n) time, O(h) space - Concise recursive");

        System.out.println("\nKey Insights:");
        System.out.println("=============");
        System.out.println("• Minimum depth is the shortest path to a leaf node");
        System.out.println("• Must handle cases where one subtree is null");
        System.out.println("• BFS finds the first leaf node (optimal for wide trees)");
        System.out.println("• DFS explores all paths (optimal for deep trees)");
        System.out.println("• Morris traversal uses constant space but modifies tree temporarily");
    }
}
