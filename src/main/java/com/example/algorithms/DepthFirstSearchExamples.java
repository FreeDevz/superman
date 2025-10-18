package com.example.algorithms;

import java.util.*;

/**
 * Comprehensive examples of Depth-First Search (DFS) algorithm.
 * 
 * DFS is a graph/tree traversal algorithm that explores as far as possible along each branch before
 * backtracking.
 * 
 * Time Complexity: O(V + E) where V is vertices and E is edges Space Complexity: O(V) for the
 * recursion stack/explicit stack
 * 
 * @author Superman Project
 * @version 1.0.0
 */
public class DepthFirstSearchExamples {

    /**
     * TreeNode class for binary tree DFS examples
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

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
     * GraphNode class for graph DFS examples
     */
    public static class GraphNode {
        int val;
        List<GraphNode> neighbors;

        GraphNode(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }

    // ==================== RECURSIVE DFS ====================

    /**
     * Example 1: Recursive DFS on a Binary Tree (Preorder Traversal) Visit order: Root -> Left ->
     * Right
     * 
     * Time Complexity: O(n) where n is number of nodes Space Complexity: O(h) where h is height of
     * tree (recursion stack)
     */
    public static class RecursiveTreeDFS {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            dfsPreorder(root, result);
            return result;
        }

        private void dfsPreorder(TreeNode node, List<Integer> result) {
            if (node == null) {
                return;
            }

            result.add(node.val); // Visit root
            dfsPreorder(node.left, result); // Visit left subtree
            dfsPreorder(node.right, result); // Visit right subtree
        }

        /**
         * Inorder Traversal: Left -> Root -> Right
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            dfsInorder(root, result);
            return result;
        }

        private void dfsInorder(TreeNode node, List<Integer> result) {
            if (node == null) {
                return;
            }

            dfsInorder(node.left, result); // Visit left subtree
            result.add(node.val); // Visit root
            dfsInorder(node.right, result); // Visit right subtree
        }

        /**
         * Postorder Traversal: Left -> Right -> Root
         */
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            dfsPostorder(root, result);
            return result;
        }

        private void dfsPostorder(TreeNode node, List<Integer> result) {
            if (node == null) {
                return;
            }

            dfsPostorder(node.left, result); // Visit left subtree
            dfsPostorder(node.right, result); // Visit right subtree
            result.add(node.val); // Visit root
        }
    }

    /**
     * Example 2: Recursive DFS on a Graph (Adjacency List)
     * 
     * Time Complexity: O(V + E) Space Complexity: O(V)
     */
    public static class RecursiveGraphDFS {
        public List<Integer> dfsTraversal(Map<Integer, List<Integer>> graph, int start) {
            List<Integer> result = new ArrayList<>();
            Set<Integer> visited = new HashSet<>();
            dfs(graph, start, visited, result);
            return result;
        }

        private void dfs(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited,
                List<Integer> result) {
            if (visited.contains(node)) {
                return;
            }

            visited.add(node);
            result.add(node);

            // Visit all neighbors
            if (graph.containsKey(node)) {
                for (int neighbor : graph.get(node)) {
                    dfs(graph, neighbor, visited, result);
                }
            }
        }
    }

    // ==================== ITERATIVE DFS ====================

    /**
     * Example 3: Iterative DFS on a Binary Tree using Stack
     * 
     * Time Complexity: O(n) Space Complexity: O(h) in best case, O(n) in worst case
     */
    public static class IterativeTreeDFS {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                result.add(node.val);

                // Push right first, then left (so left is processed first)
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }

            return result;
        }

        /**
         * Iterative Inorder Traversal
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode current = root;

            while (current != null || !stack.isEmpty()) {
                // Go to the leftmost node
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }

                // Process the node
                current = stack.pop();
                result.add(current.val);

                // Visit right subtree
                current = current.right;
            }

            return result;
        }

        /**
         * Iterative Postorder Traversal using two stacks
         */
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();

            stack1.push(root);

            while (!stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                stack2.push(node);

                if (node.left != null) {
                    stack1.push(node.left);
                }
                if (node.right != null) {
                    stack1.push(node.right);
                }
            }

            while (!stack2.isEmpty()) {
                result.add(stack2.pop().val);
            }

            return result;
        }
    }

    /**
     * Example 4: Iterative DFS on a Graph using Stack
     * 
     * Time Complexity: O(V + E) Space Complexity: O(V)
     */
    public static class IterativeGraphDFS {
        public List<Integer> dfsTraversal(Map<Integer, List<Integer>> graph, int start) {
            List<Integer> result = new ArrayList<>();
            Set<Integer> visited = new HashSet<>();
            Stack<Integer> stack = new Stack<>();

            stack.push(start);

            while (!stack.isEmpty()) {
                int node = stack.pop();

                if (visited.contains(node)) {
                    continue;
                }

                visited.add(node);
                result.add(node);

                // Add neighbors to stack (in reverse order for correct DFS order)
                if (graph.containsKey(node)) {
                    List<Integer> neighbors = graph.get(node);
                    for (int i = neighbors.size() - 1; i >= 0; i--) {
                        if (!visited.contains(neighbors.get(i))) {
                            stack.push(neighbors.get(i));
                        }
                    }
                }
            }

            return result;
        }
    }

    // ==================== DFS APPLICATIONS ====================

    /**
     * Example 5: Path Finding using DFS Find if a path exists from start to end node
     * 
     * Time Complexity: O(V + E) Space Complexity: O(V)
     */
    public static class PathFinding {
        public boolean hasPath(Map<Integer, List<Integer>> graph, int start, int end) {
            Set<Integer> visited = new HashSet<>();
            return dfs(graph, start, end, visited);
        }

        private boolean dfs(Map<Integer, List<Integer>> graph, int current, int target,
                Set<Integer> visited) {
            if (current == target) {
                return true;
            }

            if (visited.contains(current)) {
                return false;
            }

            visited.add(current);

            if (graph.containsKey(current)) {
                for (int neighbor : graph.get(current)) {
                    if (dfs(graph, neighbor, target, visited)) {
                        return true;
                    }
                }
            }

            return false;
        }

        /**
         * Find all paths from start to end
         */
        public List<List<Integer>> findAllPaths(Map<Integer, List<Integer>> graph, int start,
                int end) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            Set<Integer> visited = new HashSet<>();

            path.add(start);
            dfsAllPaths(graph, start, end, visited, path, result);
            return result;
        }

        private void dfsAllPaths(Map<Integer, List<Integer>> graph, int current, int target,
                Set<Integer> visited, List<Integer> path, List<List<Integer>> result) {
            if (current == target) {
                result.add(new ArrayList<>(path));
                return;
            }

            visited.add(current);

            if (graph.containsKey(current)) {
                for (int neighbor : graph.get(current)) {
                    if (!visited.contains(neighbor)) {
                        path.add(neighbor);
                        dfsAllPaths(graph, neighbor, target, visited, path, result);
                        path.remove(path.size() - 1); // Backtrack
                    }
                }
            }

            visited.remove(current); // Backtrack
        }
    }

    /**
     * Example 6: Cycle Detection in Directed Graph
     * 
     * Time Complexity: O(V + E) Space Complexity: O(V)
     */
    public static class CycleDetection {
        public boolean hasCycle(Map<Integer, List<Integer>> graph) {
            Set<Integer> visited = new HashSet<>();
            Set<Integer> recursionStack = new HashSet<>();

            for (int node : graph.keySet()) {
                if (dfs(graph, node, visited, recursionStack)) {
                    return true;
                }
            }

            return false;
        }

        private boolean dfs(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited,
                Set<Integer> recursionStack) {
            if (recursionStack.contains(node)) {
                return true; // Cycle detected
            }

            if (visited.contains(node)) {
                return false;
            }

            visited.add(node);
            recursionStack.add(node);

            if (graph.containsKey(node)) {
                for (int neighbor : graph.get(node)) {
                    if (dfs(graph, neighbor, visited, recursionStack)) {
                        return true;
                    }
                }
            }

            recursionStack.remove(node); // Backtrack
            return false;
        }
    }

    /**
     * Example 7: Connected Components in Undirected Graph Count the number of connected components
     * 
     * Time Complexity: O(V + E) Space Complexity: O(V)
     */
    public static class ConnectedComponents {
        public int countComponents(int n, Map<Integer, List<Integer>> graph) {
            Set<Integer> visited = new HashSet<>();
            int count = 0;

            for (int i = 0; i < n; i++) {
                if (!visited.contains(i)) {
                    dfs(graph, i, visited);
                    count++;
                }
            }

            return count;
        }

        private void dfs(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited) {
            visited.add(node);

            if (graph.containsKey(node)) {
                for (int neighbor : graph.get(node)) {
                    if (!visited.contains(neighbor)) {
                        dfs(graph, neighbor, visited);
                    }
                }
            }
        }
    }

    /**
     * Example 8: Topological Sort using DFS Only works on Directed Acyclic Graph (DAG)
     * 
     * Time Complexity: O(V + E) Space Complexity: O(V)
     */
    public static class TopologicalSort {
        public List<Integer> topologicalSort(Map<Integer, List<Integer>> graph, int numNodes) {
            Set<Integer> visited = new HashSet<>();
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < numNodes; i++) {
                if (!visited.contains(i)) {
                    dfs(graph, i, visited, stack);
                }
            }

            List<Integer> result = new ArrayList<>();
            while (!stack.isEmpty()) {
                result.add(stack.pop());
            }

            return result;
        }

        private void dfs(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited,
                Stack<Integer> stack) {
            visited.add(node);

            if (graph.containsKey(node)) {
                for (int neighbor : graph.get(node)) {
                    if (!visited.contains(neighbor)) {
                        dfs(graph, neighbor, visited, stack);
                    }
                }
            }

            stack.push(node); // Add to stack after visiting all neighbors
        }
    }

    /**
     * Example 9: Island Count (2D Grid DFS) Count number of islands in a grid where 1 is land and 0
     * is water
     * 
     * Time Complexity: O(rows * cols) Space Complexity: O(rows * cols) in worst case for recursion
     * stack
     */
    public static class IslandCounter {
        public int countIslands(int[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int rows = grid.length;
            int cols = grid[0].length;
            int count = 0;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 1) {
                        dfs(grid, i, j);
                        count++;
                    }
                }
            }

            return count;
        }

        private void dfs(int[][] grid, int row, int col) {
            int rows = grid.length;
            int cols = grid[0].length;

            // Base cases
            if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0) {
                return;
            }

            // Mark as visited
            grid[row][col] = 0;

            // Visit all 4 directions
            dfs(grid, row + 1, col); // Down
            dfs(grid, row - 1, col); // Up
            dfs(grid, row, col + 1); // Right
            dfs(grid, row, col - 1); // Left
        }
    }

    /**
     * Example 10: Maximum Depth of Binary Tree
     * 
     * Time Complexity: O(n) Space Complexity: O(h) where h is height
     */
    public static class TreeDepth {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);

            return Math.max(leftDepth, rightDepth) + 1;
        }

        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            if (root.left == null && root.right == null) {
                return 1;
            }

            int minDepth = Integer.MAX_VALUE;

            if (root.left != null) {
                minDepth = Math.min(minDepth, minDepth(root.left));
            }

            if (root.right != null) {
                minDepth = Math.min(minDepth, minDepth(root.right));
            }

            return minDepth + 1;
        }
    }

    // ==================== UTILITY METHODS ====================

    /**
     * Helper method to create a sample binary tree
     */
    public static TreeNode createSampleTree() {
        /*
         * 1 / \ 2 3 / \ \ 4 5 6
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        return root;
    }

    /**
     * Helper method to create a sample graph
     */
    public static Map<Integer, List<Integer>> createSampleGraph() {
        /*
         * Graph structure: 0 -> 1, 2 1 -> 3 2 -> 3, 4 3 -> 4 4 -> (no outgoing edges)
         */
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(3));
        graph.put(2, Arrays.asList(3, 4));
        graph.put(3, Arrays.asList(4));
        graph.put(4, new ArrayList<>());
        return graph;
    }

    /**
     * Main method with examples
     */
    public static void main(String[] args) {
        System.out.println("=== Depth-First Search Examples ===\n");

        // Example 1: Tree DFS
        System.out.println("1. Recursive Tree DFS:");
        TreeNode tree = createSampleTree();
        RecursiveTreeDFS treeDFS = new RecursiveTreeDFS();
        System.out.println("Preorder:  " + treeDFS.preorderTraversal(tree));
        System.out.println("Inorder:   " + treeDFS.inorderTraversal(tree));
        System.out.println("Postorder: " + treeDFS.postorderTraversal(tree));
        System.out.println();

        // Example 2: Graph DFS
        System.out.println("2. Recursive Graph DFS:");
        Map<Integer, List<Integer>> graph = createSampleGraph();
        RecursiveGraphDFS graphDFS = new RecursiveGraphDFS();
        System.out.println("DFS from node 0: " + graphDFS.dfsTraversal(graph, 0));
        System.out.println();

        // Example 3: Iterative Tree DFS
        System.out.println("3. Iterative Tree DFS:");
        IterativeTreeDFS iterTreeDFS = new IterativeTreeDFS();
        System.out.println("Preorder:  " + iterTreeDFS.preorderTraversal(tree));
        System.out.println("Inorder:   " + iterTreeDFS.inorderTraversal(tree));
        System.out.println("Postorder: " + iterTreeDFS.postorderTraversal(tree));
        System.out.println();

        // Example 4: Path Finding
        System.out.println("4. Path Finding:");
        PathFinding pathFinder = new PathFinding();
        System.out.println("Path exists from 0 to 4: " + pathFinder.hasPath(graph, 0, 4));
        System.out.println("All paths from 0 to 4: " + pathFinder.findAllPaths(graph, 0, 4));
        System.out.println();

        // Example 5: Cycle Detection
        System.out.println("5. Cycle Detection:");
        CycleDetection cycleDetector = new CycleDetection();
        System.out.println("Graph has cycle: " + cycleDetector.hasCycle(graph));
        System.out.println();

        // Example 6: Connected Components
        System.out.println("6. Connected Components:");
        ConnectedComponents ccCounter = new ConnectedComponents();
        System.out.println("Number of components: " + ccCounter.countComponents(5, graph));
        System.out.println();

        // Example 7: Topological Sort
        System.out.println("7. Topological Sort:");
        TopologicalSort topoSort = new TopologicalSort();
        System.out.println("Topological order: " + topoSort.topologicalSort(graph, 5));
        System.out.println();

        // Example 8: Island Counter
        System.out.println("8. Island Counter:");
        int[][] grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 1}};
        IslandCounter islandCounter = new IslandCounter();
        System.out.println("Number of islands: " + islandCounter.countIslands(grid));
        System.out.println();

        // Example 9: Tree Depth
        System.out.println("9. Tree Depth:");
        TreeDepth depthCalculator = new TreeDepth();
        System.out.println("Max depth: " + depthCalculator.maxDepth(tree));
        System.out.println("Min depth: " + depthCalculator.minDepth(tree));
    }
}

