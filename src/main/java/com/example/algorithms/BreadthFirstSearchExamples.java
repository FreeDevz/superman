package com.example.algorithms;

import java.util.*;

/**
 * Comprehensive examples of Breadth-First Search (BFS) algorithm.
 * 
 * BFS is a graph/tree traversal algorithm that explores all nodes at the present depth before
 * moving to nodes at the next depth level.
 * 
 * Time Complexity: O(V + E) where V is vertices and E is edges Space Complexity: O(V) for the queue
 * 
 * @author Superman Project
 * @version 1.0.0
 */
public class BreadthFirstSearchExamples {

    /**
     * TreeNode class for binary tree BFS examples
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
     * GraphNode class for graph BFS examples
     */
    public static class GraphNode {
        int val;
        List<GraphNode> neighbors;

        GraphNode(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }

    // ==================== BASIC BFS ====================

    /**
     * Example 1: BFS on a Binary Tree (Level Order Traversal) Visit nodes level by level from left
     * to right
     * 
     * Time Complexity: O(n) where n is number of nodes Space Complexity: O(w) where w is maximum
     * width of tree
     */
    public static class TreeBFS {
        public List<Integer> levelOrderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                result.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            return result;
        }

        /**
         * Level order traversal with level separation Returns a list of lists, where each inner
         * list represents one level
         */
        public List<List<Integer>> levelOrderByLevels(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                List<Integer> currentLevel = new ArrayList<>();

                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();
                    currentLevel.add(node.val);

                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }

                result.add(currentLevel);
            }

            return result;
        }

        /**
         * Right side view of binary tree Returns the rightmost node at each level
         */
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int levelSize = queue.size();

                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();

                    // Add the last node of each level
                    if (i == levelSize - 1) {
                        result.add(node.val);
                    }

                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }

            return result;
        }
    }

    /**
     * Example 2: BFS on a Graph (Adjacency List)
     * 
     * Time Complexity: O(V + E) Space Complexity: O(V)
     */
    public static class GraphBFS {
        public List<Integer> bfsTraversal(Map<Integer, List<Integer>> graph, int start) {
            List<Integer> result = new ArrayList<>();
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();

            queue.offer(start);
            visited.add(start);

            while (!queue.isEmpty()) {
                int node = queue.poll();
                result.add(node);

                if (graph.containsKey(node)) {
                    for (int neighbor : graph.get(node)) {
                        if (!visited.contains(neighbor)) {
                            visited.add(neighbor);
                            queue.offer(neighbor);
                        }
                    }
                }
            }

            return result;
        }

        /**
         * BFS with level tracking Returns nodes grouped by their distance from start
         */
        public Map<Integer, List<Integer>> bfsWithLevels(Map<Integer, List<Integer>> graph,
                int start) {
            Map<Integer, List<Integer>> result = new HashMap<>();
            Set<Integer> visited = new HashSet<>();
            Queue<int[]> queue = new LinkedList<>(); // [node, level]

            queue.offer(new int[] {start, 0});
            visited.add(start);

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int node = current[0];
                int level = current[1];

                result.computeIfAbsent(level, k -> new ArrayList<>()).add(node);

                if (graph.containsKey(node)) {
                    for (int neighbor : graph.get(node)) {
                        if (!visited.contains(neighbor)) {
                            visited.add(neighbor);
                            queue.offer(new int[] {neighbor, level + 1});
                        }
                    }
                }
            }

            return result;
        }
    }

    // ==================== BFS APPLICATIONS ====================

    /**
     * Example 3: Shortest Path in Unweighted Graph BFS naturally finds the shortest path in
     * unweighted graphs
     * 
     * Time Complexity: O(V + E) Space Complexity: O(V)
     */
    public static class ShortestPath {
        public int shortestPathLength(Map<Integer, List<Integer>> graph, int start, int end) {
            if (start == end) {
                return 0;
            }

            Set<Integer> visited = new HashSet<>();
            Queue<int[]> queue = new LinkedList<>(); // [node, distance]

            queue.offer(new int[] {start, 0});
            visited.add(start);

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int node = current[0];
                int distance = current[1];

                if (graph.containsKey(node)) {
                    for (int neighbor : graph.get(node)) {
                        if (neighbor == end) {
                            return distance + 1;
                        }

                        if (!visited.contains(neighbor)) {
                            visited.add(neighbor);
                            queue.offer(new int[] {neighbor, distance + 1});
                        }
                    }
                }
            }

            return -1; // No path exists
        }

        /**
         * Find the actual path, not just the length
         */
        public List<Integer> shortestPath(Map<Integer, List<Integer>> graph, int start, int end) {
            if (start == end) {
                return Arrays.asList(start);
            }

            Set<Integer> visited = new HashSet<>();
            Queue<List<Integer>> queue = new LinkedList<>();

            queue.offer(Arrays.asList(start));
            visited.add(start);

            while (!queue.isEmpty()) {
                List<Integer> path = queue.poll();
                int node = path.get(path.size() - 1);

                if (graph.containsKey(node)) {
                    for (int neighbor : graph.get(node)) {
                        if (neighbor == end) {
                            List<Integer> result = new ArrayList<>(path);
                            result.add(neighbor);
                            return result;
                        }

                        if (!visited.contains(neighbor)) {
                            visited.add(neighbor);
                            List<Integer> newPath = new ArrayList<>(path);
                            newPath.add(neighbor);
                            queue.offer(newPath);
                        }
                    }
                }
            }

            return new ArrayList<>(); // No path exists
        }
    }

    /**
     * Example 4: Minimum Depth of Binary Tree Find the shortest path from root to any leaf
     * 
     * Time Complexity: O(n) Space Complexity: O(w) where w is maximum width
     */
    public static class MinimumDepth {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int depth = 1;

            while (!queue.isEmpty()) {
                int levelSize = queue.size();

                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();

                    // First leaf node found
                    if (node.left == null && node.right == null) {
                        return depth;
                    }

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
    }

    /**
     * Example 5: Connected Components in Undirected Graph Count the number of connected components
     * using BFS
     * 
     * Time Complexity: O(V + E) Space Complexity: O(V)
     */
    public static class ConnectedComponents {
        public int countComponents(int n, Map<Integer, List<Integer>> graph) {
            Set<Integer> visited = new HashSet<>();
            int count = 0;

            for (int i = 0; i < n; i++) {
                if (!visited.contains(i)) {
                    bfs(graph, i, visited);
                    count++;
                }
            }

            return count;
        }

        private void bfs(Map<Integer, List<Integer>> graph, int start, Set<Integer> visited) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            visited.add(start);

            while (!queue.isEmpty()) {
                int node = queue.poll();

                if (graph.containsKey(node)) {
                    for (int neighbor : graph.get(node)) {
                        if (!visited.contains(neighbor)) {
                            visited.add(neighbor);
                            queue.offer(neighbor);
                        }
                    }
                }
            }
        }
    }

    /**
     * Example 6: Bipartite Graph Detection Check if a graph can be colored with two colors such
     * that no adjacent nodes have the same color
     * 
     * Time Complexity: O(V + E) Space Complexity: O(V)
     */
    public static class BipartiteGraph {
        public boolean isBipartite(Map<Integer, List<Integer>> graph, int numNodes) {
            int[] colors = new int[numNodes]; // 0: uncolored, 1: color1, -1: color2
            Arrays.fill(colors, 0);

            for (int i = 0; i < numNodes; i++) {
                if (colors[i] == 0) {
                    if (!bfs(graph, i, colors)) {
                        return false;
                    }
                }
            }

            return true;
        }

        private boolean bfs(Map<Integer, List<Integer>> graph, int start, int[] colors) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            colors[start] = 1;

            while (!queue.isEmpty()) {
                int node = queue.poll();

                if (graph.containsKey(node)) {
                    for (int neighbor : graph.get(node)) {
                        if (colors[neighbor] == 0) {
                            colors[neighbor] = -colors[node];
                            queue.offer(neighbor);
                        } else if (colors[neighbor] == colors[node]) {
                            return false; // Adjacent nodes have same color
                        }
                    }
                }
            }

            return true;
        }
    }

    /**
     * Example 7: Word Ladder Find shortest transformation sequence from beginWord to endWord
     * 
     * Time Complexity: O(M * N) where M is word length and N is total number of words Space
     * Complexity: O(N)
     */
    public static class WordLadder {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> wordSet = new HashSet<>(wordList);
            if (!wordSet.contains(endWord)) {
                return 0;
            }

            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);
            int level = 1;

            while (!queue.isEmpty()) {
                int levelSize = queue.size();

                for (int i = 0; i < levelSize; i++) {
                    String word = queue.poll();

                    if (word.equals(endWord)) {
                        return level;
                    }

                    // Try changing each character
                    char[] chars = word.toCharArray();
                    for (int j = 0; j < chars.length; j++) {
                        char originalChar = chars[j];

                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c == originalChar) {
                                continue;
                            }

                            chars[j] = c;
                            String newWord = String.valueOf(chars);

                            if (wordSet.contains(newWord)) {
                                queue.offer(newWord);
                                wordSet.remove(newWord); // Mark as visited
                            }
                        }

                        chars[j] = originalChar; // Restore original character
                    }
                }

                level++;
            }

            return 0; // No transformation sequence exists
        }
    }

    /**
     * Example 8: Island Counter using BFS (2D Grid) Count number of islands in a grid where 1 is
     * land and 0 is water
     * 
     * Time Complexity: O(rows * cols) Space Complexity: O(min(rows, cols)) for queue
     */
    public static class IslandCounter {
        private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

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
                        bfs(grid, i, j);
                        count++;
                    }
                }
            }

            return count;
        }

        private void bfs(int[][] grid, int startRow, int startCol) {
            int rows = grid.length;
            int cols = grid[0].length;
            Queue<int[]> queue = new LinkedList<>();

            queue.offer(new int[] {startRow, startCol});
            grid[startRow][startCol] = 0; // Mark as visited

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                for (int[] dir : DIRECTIONS) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                            && grid[newRow][newCol] == 1) {
                        queue.offer(new int[] {newRow, newCol});
                        grid[newRow][newCol] = 0; // Mark as visited
                    }
                }
            }
        }
    }

    /**
     * Example 9: Rotting Oranges Find minimum time for all oranges to rot
     * 
     * Time Complexity: O(rows * cols) Space Complexity: O(rows * cols)
     */
    public static class RottingOranges {
        private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        public int orangesRotting(int[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int rows = grid.length;
            int cols = grid[0].length;
            Queue<int[]> queue = new LinkedList<>();
            int freshOranges = 0;

            // Count fresh oranges and add rotten ones to queue
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 2) {
                        queue.offer(new int[] {i, j});
                    } else if (grid[i][j] == 1) {
                        freshOranges++;
                    }
                }
            }

            if (freshOranges == 0) {
                return 0;
            }

            int minutes = 0;

            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                boolean rottedThisMinute = false;

                for (int i = 0; i < levelSize; i++) {
                    int[] current = queue.poll();
                    int row = current[0];
                    int col = current[1];

                    for (int[] dir : DIRECTIONS) {
                        int newRow = row + dir[0];
                        int newCol = col + dir[1];

                        if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                                && grid[newRow][newCol] == 1) {
                            grid[newRow][newCol] = 2;
                            queue.offer(new int[] {newRow, newCol});
                            freshOranges--;
                            rottedThisMinute = true;
                        }
                    }
                }

                if (rottedThisMinute) {
                    minutes++;
                }
            }

            return freshOranges == 0 ? minutes : -1;
        }
    }

    /**
     * Example 10: Binary Tree Zigzag Level Order Traversal Traverse tree in zigzag pattern
     * (left-to-right, then right-to-left alternating)
     * 
     * Time Complexity: O(n) Space Complexity: O(w) where w is maximum width
     */
    public static class ZigzagTraversal {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            boolean leftToRight = true;

            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                List<Integer> currentLevel = new ArrayList<>();

                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();

                    if (leftToRight) {
                        currentLevel.add(node.val);
                    } else {
                        currentLevel.add(0, node.val); // Add to front for reverse order
                    }

                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }

                result.add(currentLevel);
                leftToRight = !leftToRight;
            }

            return result;
        }
    }

    /**
     * Example 11: Snake and Ladder Game Find minimum number of moves to reach the end of the board
     * 
     * Time Complexity: O(n²) Space Complexity: O(n²)
     */
    public static class SnakeAndLadder {
        public int snakesAndLadders(int[][] board) {
            int n = board.length;
            int target = n * n;

            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();

            queue.offer(1);
            visited.add(1);
            int moves = 0;

            while (!queue.isEmpty()) {
                int levelSize = queue.size();

                for (int i = 0; i < levelSize; i++) {
                    int current = queue.poll();

                    if (current == target) {
                        return moves;
                    }

                    // Try all 6 dice rolls
                    for (int dice = 1; dice <= 6 && current + dice <= target; dice++) {
                        int next = current + dice;
                        int[] pos = getPosition(next, n);
                        int row = pos[0];
                        int col = pos[1];

                        // Check for snake or ladder
                        if (board[row][col] != -1) {
                            next = board[row][col];
                        }

                        if (!visited.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                }

                moves++;
            }

            return -1; // Cannot reach the end
        }

        private int[] getPosition(int num, int n) {
            int row = n - 1 - (num - 1) / n;
            int col = (num - 1) % n;

            // Handle zigzag pattern
            if ((n - 1 - row) % 2 == 1) {
                col = n - 1 - col;
            }

            return new int[] {row, col};
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
        System.out.println("=== Breadth-First Search Examples ===\n");

        // Example 1: Tree BFS
        System.out.println("1. Tree BFS (Level Order Traversal):");
        TreeNode tree = createSampleTree();
        TreeBFS treeBFS = new TreeBFS();
        System.out.println("Level Order: " + treeBFS.levelOrderTraversal(tree));
        System.out.println("By Levels: " + treeBFS.levelOrderByLevels(tree));
        System.out.println("Right Side View: " + treeBFS.rightSideView(tree));
        System.out.println();

        // Example 2: Graph BFS
        System.out.println("2. Graph BFS:");
        Map<Integer, List<Integer>> graph = createSampleGraph();
        GraphBFS graphBFS = new GraphBFS();
        System.out.println("BFS from node 0: " + graphBFS.bfsTraversal(graph, 0));
        System.out.println("BFS with levels: " + graphBFS.bfsWithLevels(graph, 0));
        System.out.println();

        // Example 3: Shortest Path
        System.out.println("3. Shortest Path:");
        ShortestPath pathFinder = new ShortestPath();
        System.out.println(
                "Shortest path length (0 to 4): " + pathFinder.shortestPathLength(graph, 0, 4));
        System.out.println("Shortest path (0 to 4): " + pathFinder.shortestPath(graph, 0, 4));
        System.out.println();

        // Example 4: Minimum Depth
        System.out.println("4. Minimum Depth of Binary Tree:");
        MinimumDepth minDepth = new MinimumDepth();
        System.out.println("Minimum depth: " + minDepth.minDepth(tree));
        System.out.println();

        // Example 5: Connected Components
        System.out.println("5. Connected Components:");
        ConnectedComponents ccCounter = new ConnectedComponents();
        System.out.println("Number of components: " + ccCounter.countComponents(5, graph));
        System.out.println();

        // Example 6: Bipartite Graph
        System.out.println("6. Bipartite Graph Detection:");
        BipartiteGraph bipartite = new BipartiteGraph();
        System.out.println("Is bipartite: " + bipartite.isBipartite(graph, 5));
        System.out.println();

        // Example 7: Word Ladder
        System.out.println("7. Word Ladder:");
        WordLadder wordLadder = new WordLadder();
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(
                "Ladder length (hit -> cog): " + wordLadder.ladderLength("hit", "cog", wordList));
        System.out.println();

        // Example 8: Island Counter
        System.out.println("8. Island Counter:");
        int[][] grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 1}};
        IslandCounter islandCounter = new IslandCounter();
        System.out.println("Number of islands: " + islandCounter.countIslands(grid));
        System.out.println();

        // Example 9: Rotting Oranges
        System.out.println("9. Rotting Oranges:");
        int[][] orangeGrid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        RottingOranges rottingOranges = new RottingOranges();
        System.out.println(
                "Minutes until all oranges rot: " + rottingOranges.orangesRotting(orangeGrid));
        System.out.println();

        // Example 10: Zigzag Traversal
        System.out.println("10. Zigzag Level Order Traversal:");
        ZigzagTraversal zigzag = new ZigzagTraversal();
        System.out.println("Zigzag order: " + zigzag.zigzagLevelOrder(tree));
    }
}

