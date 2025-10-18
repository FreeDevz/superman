package com.example.leetcode;

/**
 * LeetCode 79: Word Search
 * 
 * Given an m x n grid of characters board and a string word, return true if word exists in the
 * grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are
 * horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * 
 * Examples: Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * 
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE" Output: true
 * 
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB" Output:
 * false
 * 
 * Constraints: - m == board.length - n = board[i].length - 1 <= m, n <= 6 - 1 <= word.length <= 15
 * - board and word consists of only lowercase and uppercase English letters
 */
public class WordSearch {

    // ========================================
    // APPROACH 1: BACKTRACKING WITH IN-PLACE MARKING (RECOMMENDED)
    // Time: O(M * N * 4^L), Space: O(L) where M,N = board dimensions, L = word length
    // ========================================

    /**
     * Approach 1: Backtracking with In-Place Marking
     * 
     * This is the most space-efficient approach that modifies the board temporarily to mark visited
     * cells.
     * 
     * Algorithm: 1. Iterate through each cell in the board 2. When we find a cell matching the
     * first character, start DFS 3. During DFS: - Check if current cell matches current character
     * in word - Mark cell as visited by replacing with a special character - Recursively explore
     * all 4 directions (up, down, left, right) - Backtrack by restoring the original character 4.
     * Return true if word is found, false otherwise
     * 
     * Time Complexity: O(M * N * 4^L) where: - M * N: iterate through all cells - 4^L: worst case
     * DFS explores 4 directions for each character Space Complexity: O(L) for recursion stack depth
     * 
     * Pros: Most space-efficient, no extra data structures needed Cons: Modifies input (though
     * temporarily), slightly harder to understand
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;

        // Early termination: check if board has enough characters
        if (word.length() > m * n) {
            return false;
        }

        // Try starting from each cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        // Found the entire word
        if (index == word.length()) {
            return true;
        }

        // Boundary checks and character match check
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || board[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark current cell as visited
        char temp = board[i][j];
        board[i][j] = '#';

        // Explore all 4 directions
        boolean found = dfs(board, word, i + 1, j, index + 1) || // down
                dfs(board, word, i - 1, j, index + 1) || // up
                dfs(board, word, i, j + 1, index + 1) || // right
                dfs(board, word, i, j - 1, index + 1); // left

        // Backtrack: restore the cell
        board[i][j] = temp;

        return found;
    }

    // ========================================
    // APPROACH 2: BACKTRACKING WITH VISITED ARRAY
    // Time: O(M * N * 4^L), Space: O(M * N + L)
    // ========================================

    /**
     * Approach 2: Backtracking with Visited Array
     * 
     * This approach uses a separate boolean array to track visited cells, keeping the original
     * board unchanged.
     * 
     * Algorithm: 1. Create a visited array to track which cells have been used 2. Iterate through
     * each cell as potential starting point 3. Use DFS with backtracking, marking cells in visited
     * array 4. Unmark cells during backtracking
     * 
     * Time Complexity: O(M * N * 4^L) Space Complexity: O(M * N + L) for visited array and
     * recursion stack
     * 
     * Pros: Cleaner, doesn't modify input, easier to debug Cons: Uses extra O(M*N) space
     */
    public boolean existWithVisitedArray(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfsWithVisited(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfsWithVisited(char[][] board, String word, int i, int j, int index,
            boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]
                || board[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true;

        boolean found = dfsWithVisited(board, word, i + 1, j, index + 1, visited)
                || dfsWithVisited(board, word, i - 1, j, index + 1, visited)
                || dfsWithVisited(board, word, i, j + 1, index + 1, visited)
                || dfsWithVisited(board, word, i, j - 1, index + 1, visited);

        visited[i][j] = false; // Backtrack

        return found;
    }

    // ========================================
    // APPROACH 3: OPTIMIZED WITH EARLY PRUNING
    // Time: O(M * N * 4^L), Space: O(L)
    // ========================================

    /**
     * Approach 3: Optimized Backtracking with Early Pruning
     * 
     * This approach adds optimizations to reduce unnecessary search: 1. Check character frequency
     * before searching 2. Search from rarer character first 3. Early termination for impossible
     * cases
     * 
     * Algorithm: 1. Count character frequencies in board and word 2. Check if board has enough of
     * each character 3. If first char is rarer than last, reverse the word 4. Apply standard
     * backtracking
     * 
     * Time Complexity: O(M * N * 4^L) but with better average case Space Complexity: O(L)
     * 
     * Pros: Faster in practice with early pruning Cons: Slightly more complex code
     */
    public boolean existOptimized(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;

        // Early termination
        if (word.length() > m * n) {
            return false;
        }

        // Count character frequencies
        int[] boardFreq = new int[128];
        int[] wordFreq = new int[128];

        for (char[] row : board) {
            for (char c : row) {
                boardFreq[c]++;
            }
        }

        for (char c : word.toCharArray()) {
            wordFreq[c]++;
        }

        // Check if board has enough characters
        for (int i = 0; i < 128; i++) {
            if (wordFreq[i] > boardFreq[i]) {
                return false;
            }
        }

        // Optimization: search from rarer character
        // If first char appears more than last char, reverse the search
        if (boardFreq[word.charAt(0)] > boardFreq[word.charAt(word.length() - 1)]) {
            word = new StringBuilder(word).reverse().toString();
        }

        // Standard backtracking
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    // ========================================
    // APPROACH 4: ITERATIVE WITH EXPLICIT STACK
    // Time: O(M * N * 4^L), Space: O(M * N * L)
    // ========================================

    /**
     * Approach 4: Iterative Approach with Explicit Stack
     * 
     * This approach converts the recursive DFS into an iterative version using an explicit stack.
     * This can be useful to avoid stack overflow for very long words.
     * 
     * Algorithm: 1. Use a stack to store state (position, index, visited set) 2. For each starting
     * position, push initial state 3. Pop states and explore neighbors 4. Track visited cells in
     * each path
     * 
     * Time Complexity: O(M * N * 4^L) Space Complexity: O(M * N * L) for stack and visited tracking
     * 
     * Pros: Avoids recursion stack overflow Cons: More complex, uses more memory
     */
    public boolean existIterative(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;

        if (word.length() > m * n) {
            return false;
        }

        // Try each cell as starting point
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (searchIterative(board, word, i, j)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static class State {
        int row, col, index;
        boolean[][] visited;

        State(int row, int col, int index, boolean[][] visited) {
            this.row = row;
            this.col = col;
            this.index = index;
            this.visited = copyArray(visited);
        }

        private static boolean[][] copyArray(boolean[][] arr) {
            if (arr == null)
                return null;
            boolean[][] copy = new boolean[arr.length][arr[0].length];
            for (int i = 0; i < arr.length; i++) {
                System.arraycopy(arr[i], 0, copy[i], 0, arr[i].length);
            }
            return copy;
        }
    }

    private boolean searchIterative(char[][] board, String word, int startRow, int startCol) {
        int m = board.length;
        int n = board[0].length;

        java.util.Stack<State> stack = new java.util.Stack<>();
        boolean[][] initialVisited = new boolean[m][n];
        stack.push(new State(startRow, startCol, 0, initialVisited));

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!stack.isEmpty()) {
            State curr = stack.pop();

            if (curr.index == word.length()) {
                return true;
            }

            if (curr.row < 0 || curr.row >= m || curr.col < 0 || curr.col >= n
                    || curr.visited[curr.row][curr.col]
                    || board[curr.row][curr.col] != word.charAt(curr.index)) {
                continue;
            }

            curr.visited[curr.row][curr.col] = true;

            if (curr.index == word.length() - 1) {
                return true;
            }

            for (int[] dir : directions) {
                int newRow = curr.row + dir[0];
                int newCol = curr.col + dir[1];
                stack.push(new State(newRow, newCol, curr.index + 1, curr.visited));
            }
        }

        return false;
    }

    // ========================================
    // UTILITY METHODS
    // ========================================

    /**
     * Helper method to visualize the search path
     */
    public String findPath(char[][] board, String word) {
        if (!exist(board, word)) {
            return "Word not found";
        }

        // Find and record the path
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                java.util.List<String> path = new java.util.ArrayList<>();
                if (findPathDFS(board, word, i, j, 0, path)) {
                    return String.join(" -> ", path);
                }
            }
        }

        return "Word not found";
    }

    private boolean findPathDFS(char[][] board, String word, int i, int j, int index,
            java.util.List<String> path) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#';
        path.add("(" + i + "," + j + ":" + temp + ")");

        boolean found = findPathDFS(board, word, i + 1, j, index + 1, path)
                || findPathDFS(board, word, i - 1, j, index + 1, path)
                || findPathDFS(board, word, i, j + 1, index + 1, path)
                || findPathDFS(board, word, i, j - 1, index + 1, path);

        if (!found) {
            path.remove(path.size() - 1);
        }

        board[i][j] = temp;
        return found;
    }

    /**
     * Count total possible paths that match the word
     */
    public int countAllPaths(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return 0;
        }

        int m = board.length;
        int n = board[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count += countPathsDFS(board, word, i, j, 0);
            }
        }

        return count;
    }

    private int countPathsDFS(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return 1;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || board[i][j] != word.charAt(index)) {
            return 0;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        int count = countPathsDFS(board, word, i + 1, j, index + 1)
                + countPathsDFS(board, word, i - 1, j, index + 1)
                + countPathsDFS(board, word, i, j + 1, index + 1)
                + countPathsDFS(board, word, i, j - 1, index + 1);

        board[i][j] = temp;
        return count;
    }

    /**
     * Find all words from a dictionary that exist in the board
     */
    public java.util.List<String> findWords(char[][] board, String[] dictionary) {
        java.util.List<String> result = new java.util.ArrayList<>();
        for (String word : dictionary) {
            if (exist(board, word)) {
                result.add(word);
            }
        }
        return result;
    }

    /**
     * Get statistics about the search
     */
    public static class SearchStats {
        public int cellsExplored;
        public int maxDepth;
        public long timeNanos;
        public boolean found;

        @Override
        public String toString() {
            return String.format(
                    "SearchStats{found=%b, cellsExplored=%d, maxDepth=%d, timeNanos=%d}", found,
                    cellsExplored, maxDepth, timeNanos);
        }
    }

    public SearchStats getSearchStats(char[][] board, String word) {
        SearchStats stats = new SearchStats();
        stats.timeNanos = System.nanoTime();

        // Create a wrapper to track statistics
        int[] cellsExplored = {0};
        int[] maxDepth = {0};

        stats.found = existWithStats(board, word, cellsExplored, maxDepth);
        stats.cellsExplored = cellsExplored[0];
        stats.maxDepth = maxDepth[0];
        stats.timeNanos = System.nanoTime() - stats.timeNanos;

        return stats;
    }

    private boolean existWithStats(char[][] board, String word, int[] cellsExplored,
            int[] maxDepth) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfsWithStats(board, word, i, j, 0, cellsExplored, maxDepth)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfsWithStats(char[][] board, String word, int i, int j, int index,
            int[] cellsExplored, int[] maxDepth) {
        cellsExplored[0]++;
        maxDepth[0] = Math.max(maxDepth[0], index);

        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        boolean found = dfsWithStats(board, word, i + 1, j, index + 1, cellsExplored, maxDepth)
                || dfsWithStats(board, word, i - 1, j, index + 1, cellsExplored, maxDepth)
                || dfsWithStats(board, word, i, j + 1, index + 1, cellsExplored, maxDepth)
                || dfsWithStats(board, word, i, j - 1, index + 1, cellsExplored, maxDepth);

        board[i][j] = temp;
        return found;
    }
}

