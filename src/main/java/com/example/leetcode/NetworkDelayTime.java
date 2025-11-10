package com.example.leetcode;

import java.util.*;

/**
 * LeetCode #743: Network Delay Time
 * 
 * Problem Description: You are given a network of n nodes, labeled from 1 to n. You are also given
 * times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source
 * node, vi is the target node, and wi is the time it takes for a signal to travel from source to
 * target.
 * 
 * We will send a signal from a given node k. Return the minimum time it takes for all the n nodes
 * to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
 * 
 * Example 1: Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2 Output: 2 Explanation: We go
 * node 2 -> node 3 -> node 4, which takes 2 time units.
 * 
 * Example 2: Input: times = [[1,2,1]], n = 2, k = 1 Output: 1
 * 
 * Example 3: Input: times = [[1,2,1]], n = 2, k = 2 Output: -1 (node 2 cannot reach node 1)
 * 
 * Constraints: - 1 <= k <= n <= 100 - 1 <= times.length <= 6000 - times[i].length == 3 - 1 <= ui,
 * vi <= n - ui != vi - 0 <= wi <= 100 - There will not be any multiple edges (i.e., no two edges
 * connect the same pair of nodes with different weights).
 * 
 * Approach 1: Dijkstra's Algorithm (Recommended) Time Complexity: O(E log V) Space Complexity: O(V
 * + E)
 * 
 * Approach 2: Bellman-Ford Algorithm Time Complexity: O(V * E) Space Complexity: O(V)
 * 
 * Approach 3: BFS with Distance Tracking (Unweighted Graph Assumption) Time Complexity: O(V + E)
 * Space Complexity: O(V + E)
 */
public class NetworkDelayTime {

    /**
     * Approach 1: Dijkstra's Algorithm (Recommended)
     * 
     * Uses Dijkstra's algorithm to find the shortest path from node k to all other nodes in a
     * weighted directed graph. This is the optimal solution for single-source shortest paths in
     * non-negative weighted graphs.
     * 
     * Algorithm: 1. Build an adjacency list representation of the graph 2. Initialize distances to
     * all nodes as infinity, except source node k = 0 3. Use a priority queue (min-heap) to always
     * process the node with minimum distance 4. For each node, relax its neighbors (update
     * distances if shorter path found) 5. Return the maximum distance (longest time to reach all
     * nodes), or -1 if any node is unreachable
     * 
     * Key insights: - Priority queue ensures we always process the closest unvisited node first -
     * Once a node is processed, its distance is finalized (no shorter path exists) - Maximum
     * distance represents the time for signal to reach all nodes
     * 
     * Time Complexity: O(E log V) where E is edges and V is vertices - Each edge is processed once:
     * O(E) - Priority queue operations: O(log V) per edge - Total: O(E log V) Space Complexity: O(V
     * + E) for graph and priority queue
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        // Build adjacency list: node -> [(neighbor, weight), ...]
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(new int[] {v, w});
        }

        // Distance array: dist[i] = shortest distance from k to node i
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Priority queue: [distance, node] - processes nodes with smallest distance first
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[] {0, k});

        // Visited set to avoid reprocessing nodes
        Set<Integer> visited = new HashSet<>();

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int distance = current[0];
            int node = current[1];

            // Skip if already processed (duplicate entries in PQ)
            if (visited.contains(node)) {
                continue;
            }
            visited.add(node);

            // Relax all neighbors
            if (graph.containsKey(node)) {
                for (int[] edge : graph.get(node)) {
                    int neighbor = edge[0];
                    int weight = edge[1];
                    int newDist = distance + weight;

                    // If shorter path found, update distance and add to queue
                    if (newDist < dist[neighbor]) {
                        dist[neighbor] = newDist;
                        pq.offer(new int[] {newDist, neighbor});
                    }
                }
            }
        }

        // Check if all nodes are reachable and find maximum distance
        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; // Node i is unreachable
            }
            maxDist = Math.max(maxDist, dist[i]);
        }

        return maxDist;
    }

    /**
     * Approach 2: Bellman-Ford Algorithm
     * 
     * Uses Bellman-Ford algorithm for single-source shortest paths. Works with negative weights but
     * is slower than Dijkstra's for non-negative weights.
     * 
     * Algorithm: 1. Initialize distances to infinity, except source = 0 2. Relax all edges (V-1)
     * times 3. After V-1 iterations, all shortest paths should be found 4. Return maximum distance
     * or -1 if unreachable
     * 
     * Key insights: - Requires V-1 iterations to guarantee shortest paths are found - Each
     * iteration relaxes all edges once - Can detect negative cycles (not applicable here since
     * weights are non-negative)
     * 
     * Time Complexity: O(V * E) where V is vertices and E is edges - V-1 iterations, each
     * processing E edges Space Complexity: O(V) for distance array
     */
    public int networkDelayTimeBellmanFord(int[][] times, int n, int k) {
        // Distance array: dist[i] = shortest distance from k to node i
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Relax edges (n-1) times
        for (int i = 0; i < n - 1; i++) {
            for (int[] time : times) {
                int u = time[0];
                int v = time[1];
                int w = time[2];

                // Relax edge (u, v) if u is reachable and shorter path found
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        // Check if all nodes are reachable and find maximum distance
        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; // Node i is unreachable
            }
            maxDist = Math.max(maxDist, dist[i]);
        }

        return maxDist;
    }

    /**
     * Approach 3: BFS with Distance Tracking
     * 
     * Uses BFS to traverse the graph and track minimum distances. This approach works well when
     * treating the graph as unweighted (each edge as cost 1) or when adapted for weighted graphs
     * with early termination.
     * 
     * Algorithm: 1. Build adjacency list 2. Use queue to process nodes level by level 3. Track
     * minimum distance to each node 4. Process nodes and update neighbors' distances 5. Return
     * maximum distance
     * 
     * Key insights: - BFS naturally finds shortest paths in unweighted graphs - For weighted
     * graphs, may need multiple visits to same node - Less efficient than Dijkstra's for weighted
     * graphs
     * 
     * Time Complexity: O(V + E) for unweighted, O(V * E) worst case for weighted Space Complexity:
     * O(V + E)
     */
    public int networkDelayTimeBFS(int[][] times, int n, int k) {
        // Build adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(new int[] {v, w});
        }

        // Distance array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Queue for BFS: [node, distance]
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {k, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int distance = current[1];

            // Process neighbors
            if (graph.containsKey(node)) {
                for (int[] edge : graph.get(node)) {
                    int neighbor = edge[0];
                    int weight = edge[1];
                    int newDist = distance + weight;

                    // Update if shorter path found (may revisit nodes)
                    if (newDist < dist[neighbor]) {
                        dist[neighbor] = newDist;
                        queue.offer(new int[] {neighbor, newDist});
                    }
                }
            }
        }

        // Check if all nodes are reachable and find maximum distance
        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; // Node i is unreachable
            }
            maxDist = Math.max(maxDist, dist[i]);
        }

        return maxDist;
    }

    /**
     * Approach 4: Dijkstra's with Early Termination Optimization
     * 
     * Optimized version of Dijkstra's that can terminate early if we only need to check
     * reachability. However, for this problem we need maximum distance, so we must process all
     * nodes.
     * 
     * Time Complexity: O(E log V) Space Complexity: O(V + E)
     */
    public int networkDelayTimeOptimized(int[][] times, int n, int k) {
        // Build adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(new int[] {v, w});
        }

        // Distance array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Priority queue with optimization: track processed count
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[] {0, k});

        int processedCount = 0;

        while (!pq.isEmpty() && processedCount < n) {
            int[] current = pq.poll();
            int distance = current[0];
            int node = current[1];

            // Skip if already processed (duplicate entries)
            if (dist[node] < distance) {
                continue;
            }

            processedCount++;

            // Relax neighbors
            if (graph.containsKey(node)) {
                for (int[] edge : graph.get(node)) {
                    int neighbor = edge[0];
                    int weight = edge[1];
                    int newDist = distance + weight;

                    if (newDist < dist[neighbor]) {
                        dist[neighbor] = newDist;
                        pq.offer(new int[] {newDist, neighbor});
                    }
                }
            }
        }

        // Check if all nodes are reachable and find maximum distance
        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxDist = Math.max(maxDist, dist[i]);
        }

        return maxDist;
    }

    /**
     * Utility method to build graph from times array
     */
    public Map<Integer, List<int[]>> buildGraph(int[][] times) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(new int[] {v, w});
        }
        return graph;
    }

    /**
     * Utility method to check if all nodes are reachable from k
     */
    public boolean allNodesReachable(int[][] times, int n, int k) {
        int result = networkDelayTime(times, n, k);
        return result != -1;
    }

    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        NetworkDelayTime solution = new NetworkDelayTime();

        System.out.println("🚀 LeetCode #743: Network Delay Time");
        System.out.println("=".repeat(50));

        // Test case 1
        int[][] times1 = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n1 = 4;
        int k1 = 2;
        System.out.println("Test Case 1:");
        System.out.println("Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2");
        int result1 = solution.networkDelayTime(times1, n1, k1);
        System.out.println("Output: " + result1);
        System.out.println("Expected: 2");
        System.out.println();

        // Test case 2
        int[][] times2 = {{1, 2, 1}};
        int n2 = 2;
        int k2 = 1;
        System.out.println("Test Case 2:");
        System.out.println("Input: times = [[1,2,1]], n = 2, k = 1");
        int result2 = solution.networkDelayTime(times2, n2, k2);
        System.out.println("Output: " + result2);
        System.out.println("Expected: 1");
        System.out.println();

        // Test case 3
        int[][] times3 = {{1, 2, 1}};
        int n3 = 2;
        int k3 = 2;
        System.out.println("Test Case 3:");
        System.out.println("Input: times = [[1,2,1]], n = 2, k = 2");
        int result3 = solution.networkDelayTime(times3, n3, k3);
        System.out.println("Output: " + result3);
        System.out.println("Expected: -1");
        System.out.println();

        // Test all approaches
        System.out.println("Testing all approaches:");
        testAllApproaches(solution, times1, n1, k1);
    }

    private static void testAllApproaches(NetworkDelayTime solution, int[][] times, int n, int k) {
        System.out.println("\nInput: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2");

        int result1 = solution.networkDelayTime(times, n, k);
        System.out.println("Approach 1 (Dijkstra's): " + result1);

        int result2 = solution.networkDelayTimeBellmanFord(times, n, k);
        System.out.println("Approach 2 (Bellman-Ford): " + result2);

        int result3 = solution.networkDelayTimeBFS(times, n, k);
        System.out.println("Approach 3 (BFS): " + result3);

        int result4 = solution.networkDelayTimeOptimized(times, n, k);
        System.out.println("Approach 4 (Optimized Dijkstra's): " + result4);

        // Verify all approaches produce the same result
        boolean allSame = result1 == result2 && result2 == result3 && result3 == result4;
        System.out.println("All approaches produce same result: " + allSame);
    }
}

