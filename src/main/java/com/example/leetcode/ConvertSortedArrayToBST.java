package com.example.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode 108: Convert Sorted Array to Binary Search Tree
 * 
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a
 * height-balanced binary search tree. A height-balanced binary tree is a binary tree in which the
 * depth of the two subtrees of every node never differs by more than 1.
 * 
 * Examples: Input: nums = [-10,-3,0,5,9] Output: [0,-3,9,-10,null,5]
 * 
 * Input: nums = [1,3] Output: [3,1]
 * 
 * Constraints: - 1 <= nums.length <= 10^4 - -10^4 <= nums[i] <= 10^4 - nums is sorted in ascending
 * order
 */
public class ConvertSortedArrayToBST {

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
            return "TreeNode{" + "val=" + val + '}';
        }
    }

    // ========================================
    // APPROACH 1: RECURSIVE DIVIDE AND CONQUER (RECOMMENDED)
    // Time: O(n), Space: O(log n) due to recursion stack
    // ========================================

    /**
     * Approach 1: Recursive Divide and Conquer (Optimal Solution)
     * 
     * This is the most intuitive and efficient approach for converting a sorted array to a BST. The
     * key insight is to always choose the middle element as the root to ensure height balance.
     * 
     * Algorithm: 1. Find the middle element of the current array/subarray 2. Create a new node with
     * the middle element as the root 3. Recursively build left subtree with elements before middle
     * 4. Recursively build right subtree with elements after middle
     * 
     * Time Complexity: O(n) where n is the number of elements in the array Space Complexity: O(log
     * n) due to recursion call stack (height of the tree)
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        // Base case: no more elements to process
        if (left > right) {
            return null;
        }

        // Choose middle element as root to ensure height balance
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        // Recursively build left and right subtrees
        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);

        return root;
    }

    // ========================================
    // APPROACH 2: ITERATIVE WITH STACK
    // Time: O(n), Space: O(log n)
    // ========================================

    /**
     * Approach 2: Iterative with Stack
     * 
     * This approach simulates the recursive process using an explicit stack to avoid recursion.
     * Useful when dealing with very deep trees or when recursion stack overflow is a concern.
     * 
     * Algorithm: 1. Use a stack to store ranges (left, right) that need to be processed 2. Use a
     * map to store the created nodes for each range 3. Process ranges iteratively, creating nodes
     * and their children
     * 
     * Time Complexity: O(n) where n is the number of elements in the array Space Complexity: O(log
     * n) for the stack and map storage
     */
    public TreeNode sortedArrayToBSTIterative(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        // Stack to store ranges that need processing
        LinkedList<int[]> stack = new LinkedList<>();
        // Map to store created nodes for each range
        java.util.Map<String, TreeNode> nodeMap = new java.util.HashMap<>();

        // Start with the full array range
        stack.push(new int[] {0, nums.length - 1});

        while (!stack.isEmpty()) {
            int[] range = stack.peek();
            int left = range[0];
            int right = range[1];
            String key = left + "," + right;

            // If we already processed this range, skip
            if (nodeMap.containsKey(key)) {
                stack.pop();
                continue;
            }

            // If range is invalid, mark as processed and continue
            if (left > right) {
                nodeMap.put(key, null);
                stack.pop();
                continue;
            }

            // Check if we can create the node (all children are ready)
            int mid = left + (right - left) / 2;
            String leftKey = left + "," + (mid - 1);
            String rightKey = (mid + 1) + "," + right;

            boolean canCreate = true;
            if (left <= mid - 1 && !nodeMap.containsKey(leftKey)) {
                canCreate = false;
            }
            if (mid + 1 <= right && !nodeMap.containsKey(rightKey)) {
                canCreate = false;
            }

            if (canCreate) {
                // Create the node
                TreeNode node = new TreeNode(nums[mid]);
                node.left = nodeMap.get(leftKey);
                node.right = nodeMap.get(rightKey);
                nodeMap.put(key, node);
                stack.pop();
            } else {
                // Add children to stack for processing
                if (left <= mid - 1) {
                    stack.push(new int[] {left, mid - 1});
                }
                if (mid + 1 <= right) {
                    stack.push(new int[] {mid + 1, right});
                }
            }
        }

        return nodeMap.get("0," + (nums.length - 1));
    }

    // ========================================
    // APPROACH 3: RECURSIVE WITH HELPER CLASS
    // Time: O(n), Space: O(log n)
    // ========================================

    /**
     * Approach 3: Recursive with Helper Class
     * 
     * This approach uses a helper class to encapsulate the range information, making the code more
     * object-oriented and potentially easier to understand.
     * 
     * Algorithm: 1. Create a Range class to hold left and right indices 2. Use recursive approach
     * with Range objects 3. Build tree by processing ranges recursively
     * 
     * Time Complexity: O(n) where n is the number of elements in the array Space Complexity: O(log
     * n) due to recursion call stack
     */
    public TreeNode sortedArrayToBSTWithHelper(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildBSTWithRange(nums, new Range(0, nums.length - 1));
    }

    private TreeNode buildBSTWithRange(int[] nums, Range range) {
        if (range.left > range.right) {
            return null;
        }

        int mid = range.left + (range.right - range.left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = buildBSTWithRange(nums, new Range(range.left, mid - 1));
        root.right = buildBSTWithRange(nums, new Range(mid + 1, range.right));

        return root;
    }

    private static class Range {
        final int left;
        final int right;

        Range(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    // ========================================
    // APPROACH 4: RECURSIVE WITH ARRAY COPY
    // Time: O(n log n), Space: O(n)
    // ========================================

    /**
     * Approach 4: Recursive with Array Copy
     * 
     * This approach creates new subarrays for each recursive call, which is less efficient but
     * might be easier to understand for some developers.
     * 
     * Algorithm: 1. Find the middle element 2. Create new subarrays for left and right parts 3.
     * Recursively build subtrees with the subarrays
     * 
     * Time Complexity: O(n log n) due to array copying Space Complexity: O(n) for storing all the
     * subarrays
     */
    public TreeNode sortedArrayToBSTWithArrayCopy(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);

        // Create left subarray
        if (mid > 0) {
            int[] leftArray = new int[mid];
            System.arraycopy(nums, 0, leftArray, 0, mid);
            root.left = sortedArrayToBSTWithArrayCopy(leftArray);
        }

        // Create right subarray
        if (mid < nums.length - 1) {
            int[] rightArray = new int[nums.length - mid - 1];
            System.arraycopy(nums, mid + 1, rightArray, 0, nums.length - mid - 1);
            root.right = sortedArrayToBSTWithArrayCopy(rightArray);
        }

        return root;
    }

    // ========================================
    // APPROACH 5: OPTIMIZED RECURSIVE
    // Time: O(n), Space: O(log n)
    // ========================================

    /**
     * Approach 5: Optimized Recursive
     * 
     * This is an optimized version of the recursive approach with better variable naming and
     * slightly more efficient index calculations.
     * 
     * Algorithm: 1. Use more descriptive variable names 2. Optimize the middle calculation 3. Add
     * early termination conditions
     * 
     * Time Complexity: O(n) where n is the number of elements in the array Space Complexity: O(log
     * n) due to recursion call stack
     */
    public TreeNode sortedArrayToBSTOptimized(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return constructBST(nums, 0, nums.length - 1);
    }

    private TreeNode constructBST(int[] sortedArray, int startIndex, int endIndex) {
        // Base case: no elements in range
        if (startIndex > endIndex) {
            return null;
        }

        // Base case: single element
        if (startIndex == endIndex) {
            return new TreeNode(sortedArray[startIndex]);
        }

        // Calculate middle index (avoiding overflow)
        int middleIndex = startIndex + (endIndex - startIndex) / 2;

        // Create root node with middle element
        TreeNode rootNode = new TreeNode(sortedArray[middleIndex]);

        // Recursively construct left and right subtrees
        rootNode.left = constructBST(sortedArray, startIndex, middleIndex - 1);
        rootNode.right = constructBST(sortedArray, middleIndex + 1, endIndex);

        return rootNode;
    }

    // ========================================
    // APPROACH 6: RECURSIVE WITH VALIDATION
    // Time: O(n), Space: O(log n)
    // ========================================

    /**
     * Approach 6: Recursive with Validation
     * 
     * This approach includes additional validation and error checking to ensure the input array is
     * properly sorted and valid.
     * 
     * Algorithm: 1. Validate input array is sorted 2. Use standard recursive approach 3. Add
     * additional safety checks
     * 
     * Time Complexity: O(n) where n is the number of elements in the array Space Complexity: O(log
     * n) due to recursion call stack
     */
    public TreeNode sortedArrayToBSTWithValidation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        // Validate that the array is sorted
        if (!isSorted(nums)) {
            throw new IllegalArgumentException("Input array must be sorted in ascending order");
        }

        return buildValidatedBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildValidatedBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = buildValidatedBST(nums, left, mid - 1);
        root.right = buildValidatedBST(nums, mid + 1, right);

        return root;
    }

    private boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // ========================================
    // UTILITY METHODS
    // ========================================

    /**
     * Convert tree to array representation (level-order traversal)
     */
    public static List<Integer> treeToArray(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

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

        return result;
    }

    /**
     * Convert tree to array representation (inorder traversal)
     */
    public static List<Integer> treeToInorderArray(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    private static void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root != null) {
            inorderTraversal(root.left, result);
            result.add(root.val);
            inorderTraversal(root.right, result);
        }
    }

    /**
     * Check if a binary tree is a valid BST
     */
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val < min || root.val > max) {
            return false;
        }

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    /**
     * Calculate the height of a binary tree
     */
    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    /**
     * Check if a binary tree is height-balanced
     */
    public static boolean isHeightBalanced(TreeNode root) {
        return checkHeightBalance(root) != -1;
    }

    private static int checkHeightBalance(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = checkHeightBalance(root.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = checkHeightBalance(root.right);
        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

    /**
     * Count the number of nodes in the tree
     */
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    /**
     * Create a test case with the given array
     */
    public static TestCase createTestCase(int[] nums) {
        return new TestCase(nums);
    }

    /**
     * Test case data structure
     */
    public static class TestCase {
        public final int[] nums;
        public final TreeNode expected;

        public TestCase(int[] nums) {
            this.nums = nums.clone();
            this.expected = buildExpectedTree(nums);
        }

        private TreeNode buildExpectedTree(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }
            return buildBST(nums, 0, nums.length - 1);
        }

        private TreeNode buildBST(int[] nums, int left, int right) {
            if (left > right) {
                return null;
            }
            int mid = left + (right - left) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = buildBST(nums, left, mid - 1);
            root.right = buildBST(nums, mid + 1, right);
            return root;
        }
    }

    /**
     * Create comprehensive test cases
     */
    public static TestCase[] createTestCases() {
        return new TestCase[] {
                // Test case 1: Basic example
                createTestCase(new int[] {-10, -3, 0, 5, 9}),

                // Test case 2: Two elements
                createTestCase(new int[] {1, 3}),

                // Test case 3: Single element
                createTestCase(new int[] {1}),

                // Test case 4: Three elements
                createTestCase(new int[] {1, 2, 3}),

                // Test case 5: Four elements
                createTestCase(new int[] {1, 2, 3, 4}),

                // Test case 6: Five elements
                createTestCase(new int[] {1, 2, 3, 4, 5}),

                // Test case 7: Negative numbers
                createTestCase(new int[] {-5, -3, -1, 0, 2, 4, 6}),

                // Test case 8: All negative
                createTestCase(new int[] {-10, -8, -6, -4, -2}),

                // Test case 9: All positive
                createTestCase(new int[] {1, 3, 5, 7, 9, 11}),

                // Test case 10: Sequential numbers
                createTestCase(new int[] {1, 2, 3, 4, 5, 6, 7, 8}),

                // Test case 11: Large range
                createTestCase(new int[] {-1000, -500, 0, 500, 1000}),

                // Test case 12: Maximum constraint
                createTestCase(createLargeArray(100)),

                // Test case 13: Minimum constraint
                createTestCase(new int[] {0}),

                // Test case 14: Even length
                createTestCase(new int[] {1, 2, 3, 4, 5, 6}),

                // Test case 15: Odd length
                createTestCase(new int[] {1, 2, 3, 4, 5, 6, 7})};
    }

    /**
     * Create a large array for testing
     */
    private static int[] createLargeArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    /**
     * Compare two trees for equality
     */
    public static boolean treesEqual(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }
        if (tree1 == null || tree2 == null) {
            return false;
        }
        return tree1.val == tree2.val && treesEqual(tree1.left, tree2.left)
                && treesEqual(tree1.right, tree2.right);
    }

    /**
     * Print tree structure for debugging
     */
    public static String treeToString(TreeNode root) {
        if (root == null) {
            return "null";
        }
        return "TreeNode{" + "val=" + root.val + ", left=" + treeToString(root.left) + ", right="
                + treeToString(root.right) + "}";
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
     * Compare results from different approaches
     */
    public boolean compareResults(TreeNode result1, TreeNode result2) {
        return treesEqual(result1, result2);
    }

    /**
     * Get tree statistics
     */
    public String getTreeStatistics(TreeNode root) {
        if (root == null) {
            return "Empty tree";
        }

        int nodeCount = countNodes(root);
        int height = getHeight(root);
        boolean isBalanced = isHeightBalanced(root);
        boolean isValid = isValidBST(root);

        return String.format("Tree Statistics: %d nodes, Height=%d, IsBalanced=%s, IsValidBST=%s",
                nodeCount, height, isBalanced, isValid);
    }
}
