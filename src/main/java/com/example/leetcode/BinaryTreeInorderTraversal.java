package com.example.leetcode;

import java.util.*;

/**
 * LeetCode 94: Binary Tree Inorder Traversal
 * 
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * 
 * Inorder traversal visits nodes in this order: left subtree → root → right subtree
 * 
 * Examples:
 * Input: root = [1,null,2,3] Output: [1,3,2]
 * 
 * Input: root = [] Output: []
 * 
 * Input: root = [1] Output: [1]
 * 
 * Constraints: - The number of nodes in the tree is in the range [0, 100] - -100 <= Node.val <= 100
 */
public class BinaryTreeInorderTraversal {

    // Definition for a binary tree node
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
            return String.valueOf(val);
        }
    }

    // ========================================
    // APPROACH 1: RECURSIVE (RECOMMENDED)
    // Time: O(n), Space: O(h) where h is tree height
    // ========================================

    /**
     * Approach 1: Recursive Inorder Traversal
     * 
     * This is the most intuitive and commonly used approach for tree traversal.
     * 
     * Algorithm: 1. Recursively traverse the left subtree 2. Visit the current node (add to result)
     * 3. Recursively traverse the right subtree
     * 
     * Time Complexity: O(n) where n is the number of nodes Space Complexity: O(h) where h is the
     * height of the tree (worst case O(n) for skewed trees)
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversalRecursive(root, result);
        return result;
    }

    private void inorderTraversalRecursive(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        // Traverse left subtree
        inorderTraversalRecursive(node.left, result);

        // Visit current node
        result.add(node.val);

        // Traverse right subtree
        inorderTraversalRecursive(node.right, result);
    }

    // ========================================
    // APPROACH 2: ITERATIVE WITH STACK
    // Time: O(n), Space: O(h) where h is tree height
    // ========================================

    /**
     * Approach 2: Iterative Inorder Traversal with Stack
     * 
     * This approach uses a stack to simulate the recursive call stack, making it useful when
     * recursion depth is a concern.
     * 
     * Algorithm: 1. Push all left nodes to stack until reaching the leftmost leaf 2. Pop from stack
     * and add to result 3. Move to right subtree and repeat
     * 
     * Time Complexity: O(n) where n is the number of nodes Space Complexity: O(h) where h is the
     * height of the tree
     */
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // Push all left nodes to stack
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Pop and visit current node
            current = stack.pop();
            result.add(current.val);

            // Move to right subtree
            current = current.right;
        }

        return result;
    }

    // ========================================
    // APPROACH 3: MORRIS TRAVERSAL (OPTIMAL)
    // Time: O(n), Space: O(1) - constant extra space
    // ========================================

    /**
     * Approach 3: Morris Inorder Traversal
     * 
     * This is the most space-efficient approach that uses threading to traverse the tree without
     * using a stack or recursion.
     * 
     * Algorithm: 1. Find the inorder predecessor of current node 2. Make current node the right
     * child of its predecessor 3. Traverse the modified tree 4. Restore the original tree structure
     * 
     * Time Complexity: O(n) where n is the number of nodes Space Complexity: O(1) - constant extra
     * space (modifies tree temporarily)
     */
    public List<Integer> inorderTraversalMorris(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;

        while (current != null) {
            if (current.left == null) {
                // No left subtree, visit current node
                result.add(current.val);
                current = current.right;
            } else {
                // Find inorder predecessor
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    // Make current node the right child of predecessor
                    predecessor.right = current;
                    current = current.left;
                } else {
                    // Restore tree structure and visit current node
                    predecessor.right = null;
                    result.add(current.val);
                    current = current.right;
                }
            }
        }

        return result;
    }

    // ========================================
    // APPROACH 4: ITERATIVE WITH TWO STACKS
    // Time: O(n), Space: O(n) - uses two stacks
    // ========================================

    /**
     * Approach 4: Iterative with Two Stacks
     * 
     * This approach uses two stacks to simulate the recursive call stack more explicitly.
     * 
     * Algorithm: 1. Use one stack for nodes and another for processing state 2. Track whether a
     * node has been processed 3. Process nodes in the correct order
     * 
     * Time Complexity: O(n) where n is the number of nodes Space Complexity: O(n) for the two
     * stacks
     */
    public List<Integer> inorderTraversalTwoStacks(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Boolean> processedStack = new Stack<>();

        nodeStack.push(root);
        processedStack.push(false);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            boolean processed = processedStack.pop();

            if (processed) {
                // Node has been processed, add to result
                result.add(node.val);
            } else {
                // Push right, current, left (reverse order for stack)
                if (node.right != null) {
                    nodeStack.push(node.right);
                    processedStack.push(false);
                }

                nodeStack.push(node);
                processedStack.push(true);

                if (node.left != null) {
                    nodeStack.push(node.left);
                    processedStack.push(false);
                }
            }
        }

        return result;
    }

    // ========================================
    // APPROACH 5: ITERATIVE WITH HASH SET
    // Time: O(n), Space: O(n) - tracks visited nodes
    // ========================================

    /**
     * Approach 5: Iterative with Hash Set for Visited Nodes
     * 
     * This approach uses a hash set to track which nodes have been processed, ensuring correct
     * traversal order.
     * 
     * Algorithm: 1. Use stack to store nodes and hash set to track processed nodes 2. Process left
     * subtree first 3. Mark nodes as processed when visiting 4. Handle right subtree after
     * processing current node
     * 
     * Time Complexity: O(n) where n is the number of nodes Space Complexity: O(n) for stack and hash
     * set
     */
    public List<Integer> inorderTraversalHashSet(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.peek();

            // If left child exists and hasn't been visited, push it
            if (current.left != null && !visited.contains(current.left)) {
                stack.push(current.left);
            } else {
                // Process current node
                stack.pop();
                result.add(current.val);
                visited.add(current);

                // Push right child if it exists
                if (current.right != null) {
                    stack.push(current.right);
                }
            }
        }

        return result;
    }

    // ========================================
    // UTILITY METHODS
    // ========================================

    /**
     * Create a binary tree from an array representation
     * 
     * @param values Array representation where null represents missing nodes
     * @return Root of the binary tree
     */
    public static TreeNode createTree(Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();

            // Add left child
            if (i < values.length && values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.offer(current.left);
            }
            i++;

            // Add right child
            if (i < values.length && values[i] != null) {
                current.right = new TreeNode(values[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    /**
     * Create a binary tree from a string representation
     * 
     * @param treeString String like "[1,null,2,3]" or "1,null,2,3"
     * @return Root of the binary tree
     */
    public static TreeNode createTreeFromString(String treeString) {
        if (treeString == null || treeString.trim().isEmpty()) {
            return null;
        }

        // Remove brackets if present
        String cleanString = treeString.replaceAll("[\\[\\]]", "");
        String[] parts = cleanString.split(",");

        Integer[] values = new Integer[parts.length];
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i].trim();
            if ("null".equals(part)) {
                values[i] = null;
            } else {
                try {
                    values[i] = Integer.parseInt(part);
                } catch (NumberFormatException e) {
                    values[i] = null;
                }
            }
        }

        return createTree(values);
    }

    /**
     * Convert a binary tree to a string representation
     * 
     * @param root Root of the binary tree
     * @return String representation like "[1,null,2,3]"
     */
    public static String treeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        List<String> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                result.add("null");
            } else {
                result.add(String.valueOf(current.val));
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }

        // Remove trailing nulls
        while (!result.isEmpty() && "null".equals(result.get(result.size() - 1))) {
            result.remove(result.size() - 1);
        }

        return "[" + String.join(",", result) + "]";
    }

    /**
     * Get tree statistics
     * 
     * @param root Root of the binary tree
     * @return String with tree statistics
     */
    public static String getTreeStatistics(TreeNode root) {
        if (root == null) {
            return "Empty tree";
        }

        int nodeCount = countNodes(root);
        int height = getHeight(root);
        int leafCount = countLeaves(root);
        int internalCount = nodeCount - leafCount;

        StringBuilder stats = new StringBuilder();
        stats.append(String.format("Tree Statistics: %d nodes", nodeCount));
        stats.append(String.format(", Height: %d", height));
        stats.append(String.format(", Leaves: %d", leafCount));
        stats.append(String.format(", Internal nodes: %d", internalCount));

        return stats.toString();
    }

    /**
     * Count total nodes in the tree
     */
    private static int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    /**
     * Get height of the tree
     */
    private static int getHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    /**
     * Count leaf nodes in the tree
     */
    private static int countLeaves(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return countLeaves(node.left) + countLeaves(node.right);
    }

    /**
     * Compare results from different approaches
     */
    public boolean compareResults(List<Integer> result1, List<Integer> result2) {
        if (result1 == null && result2 == null) {
            return true;
        }

        if (result1 == null || result2 == null) {
            return false;
        }

        if (result1.size() != result2.size()) {
            return false;
        }

        for (int i = 0; i < result1.size(); i++) {
            if (!Objects.equals(result1.get(i), result2.get(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * Performance analysis helper - measures execution time
     */
    public long measureExecutionTime(Runnable algorithm) {
        long startTime = System.nanoTime();
        algorithm.run();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Validate that the result is a valid inorder traversal
     */
    public boolean isValidInorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return result.isEmpty();
        }

        List<Integer> expected = new ArrayList<>();
        inorderTraversalRecursive(root, expected);

        return compareResults(result, expected);
    }
}
