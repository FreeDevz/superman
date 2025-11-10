package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for NetworkDelayTime
 */
public class NetworkDelayTimeTest {

    private NetworkDelayTime solution;

    @BeforeEach
    void setUp() {
        solution = new NetworkDelayTime();
    }

    @Test
    void testNetworkDelayTime_Example1() {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int k = 2;
        int result = solution.networkDelayTime(times, n, k);
        assertEquals(2, result);
    }

    @Test
    void testNetworkDelayTime_Example2() {
        int[][] times = {{1, 2, 1}};
        int n = 2;
        int k = 1;
        int result = solution.networkDelayTime(times, n, k);
        assertEquals(1, result);
    }

    @Test
    void testNetworkDelayTime_Example3() {
        int[][] times = {{1, 2, 1}};
        int n = 2;
        int k = 2;
        int result = solution.networkDelayTime(times, n, k);
        assertEquals(-1, result);
    }

    @Test
    void testNetworkDelayTime_SingleNode() {
        int[][] times = {};
        int n = 1;
        int k = 1;
        int result = solution.networkDelayTime(times, n, k);
        assertEquals(0, result);
    }

    @Test
    void testNetworkDelayTime_AllNodesReachable() {
        int[][] times = {{1, 2, 1}, {1, 3, 4}, {2, 3, 2}, {2, 4, 5}, {3, 4, 1}};
        int n = 4;
        int k = 1;
        int result = solution.networkDelayTime(times, n, k);
        // Shortest paths from node 1:
        // 1->2 = 1
        // 1->3 = min(4, 1+2) = 3 (via 1->2->3)
        // 1->4 = min(1+5, 1+2+1, 4+1) = min(6, 4, 5) = 4 (via 1->2->3->4)
        // Maximum distance is 4
        assertEquals(4, result);
    }

    @Test
    void testNetworkDelayTime_UnreachableNode() {
        int[][] times = {{1, 2, 1}, {2, 3, 1}};
        int n = 4;
        int k = 1;
        int result = solution.networkDelayTime(times, n, k);
        assertEquals(-1, result); // Node 4 is unreachable
    }

    @Test
    void testNetworkDelayTime_DisconnectedGraph() {
        int[][] times = {{1, 2, 1}, {3, 4, 1}};
        int n = 4;
        int k = 1;
        int result = solution.networkDelayTime(times, n, k);
        assertEquals(-1, result); // Nodes 3 and 4 are unreachable from node 1
    }

    @Test
    void testNetworkDelayTime_CircularPath() {
        int[][] times = {{1, 2, 1}, {2, 3, 1}, {3, 1, 1}, {1, 4, 2}};
        int n = 4;
        int k = 1;
        int result = solution.networkDelayTime(times, n, k);
        assertEquals(2, result); // Shortest path to 4 is direct: 1->4 = 2
    }

    @Test
    void testNetworkDelayTime_MultiplePaths() {
        int[][] times = {{1, 2, 3}, {1, 3, 1}, {3, 2, 1}, {2, 4, 2}};
        int n = 4;
        int k = 1;
        int result = solution.networkDelayTime(times, n, k);
        assertEquals(4, result); // Path to 4: 1->3->2->4 = 1+1+2 = 4
    }

    @Test
    void testNetworkDelayTime_LargeWeights() {
        int[][] times = {{1, 2, 100}, {1, 3, 1}, {3, 2, 1}};
        int n = 3;
        int k = 1;
        int result = solution.networkDelayTime(times, n, k);
        assertEquals(2, result); // Path to 2: 1->3->2 = 1+1 = 2 (better than direct 1->2 = 100)
    }

    @Test
    void testNetworkDelayTime_SelfLoop() {
        int[][] times = {{1, 1, 1}, {1, 2, 1}};
        int n = 2;
        int k = 1;
        int result = solution.networkDelayTime(times, n, k);
        assertEquals(1, result); // Self-loop doesn't help, path to 2: 1->2 = 1
    }

    @Test
    void testNetworkDelayTime_StarTopology() {
        int[][] times = {{1, 2, 1}, {1, 3, 1}, {1, 4, 1}, {1, 5, 1}};
        int n = 5;
        int k = 1;
        int result = solution.networkDelayTime(times, n, k);
        assertEquals(1, result); // All nodes reachable in 1 time unit
    }

    @Test
    void testNetworkDelayTime_ChainTopology() {
        int[][] times = {{1, 2, 1}, {2, 3, 1}, {3, 4, 1}, {4, 5, 1}};
        int n = 5;
        int k = 1;
        int result = solution.networkDelayTime(times, n, k);
        assertEquals(4, result); // Longest path: 1->2->3->4->5 = 4
    }

    @Test
    void testNetworkDelayTime_ComplexGraph() {
        int[][] times = {{1, 2, 1}, {1, 3, 4}, {2, 3, 2}, {2, 4, 5}, {3, 4, 1}, {4, 5, 3}};
        int n = 5;
        int k = 1;
        int result = solution.networkDelayTime(times, n, k);
        // Shortest paths from node 1:
        // 1->2 = 1
        // 1->3 = min(4, 1+2) = 3 (via 1->2->3)
        // 1->4 = min(1+5, 1+2+1, 4+1) = min(6, 4, 5) = 4 (via 1->2->3->4)
        // 1->5 = 4+3 = 7 (via 1->2->3->4->5)
        // Maximum distance is 7
        assertEquals(7, result);
    }

    // Test Bellman-Ford approach
    @Test
    void testNetworkDelayTimeBellmanFord_Example1() {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int k = 2;
        int result = solution.networkDelayTimeBellmanFord(times, n, k);
        assertEquals(2, result);
    }

    @Test
    void testNetworkDelayTimeBellmanFord_Example2() {
        int[][] times = {{1, 2, 1}};
        int n = 2;
        int k = 1;
        int result = solution.networkDelayTimeBellmanFord(times, n, k);
        assertEquals(1, result);
    }

    @Test
    void testNetworkDelayTimeBellmanFord_Unreachable() {
        int[][] times = {{1, 2, 1}};
        int n = 2;
        int k = 2;
        int result = solution.networkDelayTimeBellmanFord(times, n, k);
        assertEquals(-1, result);
    }

    @Test
    void testNetworkDelayTimeBellmanFord_ComplexGraph() {
        int[][] times = {{1, 2, 1}, {1, 3, 4}, {2, 3, 2}, {2, 4, 5}, {3, 4, 1}, {4, 5, 3}};
        int n = 5;
        int k = 1;
        int result = solution.networkDelayTimeBellmanFord(times, n, k);
        // Same shortest paths as Dijkstra's: max distance = 7
        assertEquals(7, result);
    }

    // Test BFS approach
    @Test
    void testNetworkDelayTimeBFS_Example1() {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int k = 2;
        int result = solution.networkDelayTimeBFS(times, n, k);
        assertEquals(2, result);
    }

    @Test
    void testNetworkDelayTimeBFS_Example2() {
        int[][] times = {{1, 2, 1}};
        int n = 2;
        int k = 1;
        int result = solution.networkDelayTimeBFS(times, n, k);
        assertEquals(1, result);
    }

    @Test
    void testNetworkDelayTimeBFS_Unreachable() {
        int[][] times = {{1, 2, 1}};
        int n = 2;
        int k = 2;
        int result = solution.networkDelayTimeBFS(times, n, k);
        assertEquals(-1, result);
    }

    @Test
    void testNetworkDelayTimeBFS_MultiplePaths() {
        int[][] times = {{1, 2, 3}, {1, 3, 1}, {3, 2, 1}, {2, 4, 2}};
        int n = 4;
        int k = 1;
        int result = solution.networkDelayTimeBFS(times, n, k);
        assertEquals(4, result);
    }

    // Test Optimized Dijkstra's approach
    @Test
    void testNetworkDelayTimeOptimized_Example1() {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int k = 2;
        int result = solution.networkDelayTimeOptimized(times, n, k);
        assertEquals(2, result);
    }

    @Test
    void testNetworkDelayTimeOptimized_Example2() {
        int[][] times = {{1, 2, 1}};
        int n = 2;
        int k = 1;
        int result = solution.networkDelayTimeOptimized(times, n, k);
        assertEquals(1, result);
    }

    @Test
    void testNetworkDelayTimeOptimized_ComplexGraph() {
        int[][] times = {{1, 2, 1}, {1, 3, 4}, {2, 3, 2}, {2, 4, 5}, {3, 4, 1}, {4, 5, 3}};
        int n = 5;
        int k = 1;
        int result = solution.networkDelayTimeOptimized(times, n, k);
        // Same shortest paths as Dijkstra's: max distance = 7
        assertEquals(7, result);
    }

    // Test all approaches produce same results
    @Test
    void testAllApproachesProduceSameResults() {
        int[][][] testCases = {{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, {{1, 2, 1}},
                {{1, 2, 1}, {1, 3, 4}, {2, 3, 2}, {2, 4, 5}},
                {{1, 2, 1}, {2, 3, 1}, {3, 4, 1}, {4, 5, 1}},
                {{1, 2, 1}, {1, 3, 1}, {1, 4, 1}, {1, 5, 1}},
                {{1, 2, 3}, {1, 3, 1}, {3, 2, 1}, {2, 4, 2}}};

        int[] nValues = {4, 2, 4, 5, 5, 4};
        int[] kValues = {2, 1, 1, 1, 1, 1};

        for (int i = 0; i < testCases.length; i++) {
            int[][] times = testCases[i];
            int n = nValues[i];
            int k = kValues[i];

            int result1 = solution.networkDelayTime(times, n, k);
            int result2 = solution.networkDelayTimeBellmanFord(times, n, k);
            int result3 = solution.networkDelayTimeBFS(times, n, k);
            int result4 = solution.networkDelayTimeOptimized(times, n, k);

            assertTrue(result1 == result2 && result2 == result3 && result3 == result4,
                    "All approaches should produce same result for test case " + i);
        }
    }

    // Test utility methods
    @Test
    void testBuildGraph() {
        int[][] times = {{1, 2, 1}, {1, 3, 2}, {2, 3, 3}};
        var graph = solution.buildGraph(times);
        assertEquals(2, graph.size()); // Nodes 1 and 2 have outgoing edges
        assertTrue(graph.containsKey(1));
        assertTrue(graph.containsKey(2));
        assertEquals(2, graph.get(1).size()); // Node 1 has 2 outgoing edges
        assertEquals(1, graph.get(2).size()); // Node 2 has 1 outgoing edge
    }

    @Test
    void testAllNodesReachable_True() {
        int[][] times = {{1, 2, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int k = 1;
        assertTrue(solution.allNodesReachable(times, n, k));
    }

    @Test
    void testAllNodesReachable_False() {
        int[][] times = {{1, 2, 1}};
        int n = 3;
        int k = 1;
        assertTrue(!solution.allNodesReachable(times, n, k)); // Node 3 is unreachable
    }

    @Test
    void testNetworkDelayTime_EdgeCase_EmptyTimes() {
        int[][] times = {};
        int n = 1;
        int k = 1;
        int result = solution.networkDelayTime(times, n, k);
        assertEquals(0, result);
    }

    @Test
    void testNetworkDelayTime_EdgeCase_LargeN() {
        int[][] times = {{1, 2, 1}, {2, 3, 1}, {3, 4, 1}, {4, 5, 1}, {5, 6, 1}};
        int n = 6;
        int k = 1;
        int result = solution.networkDelayTime(times, n, k);
        assertEquals(5, result);
    }

    @Test
    void testNetworkDelayTime_EdgeCase_ZeroWeight() {
        int[][] times = {{1, 2, 0}, {2, 3, 1}};
        int n = 3;
        int k = 1;
        int result = solution.networkDelayTime(times, n, k);
        assertEquals(1, result); // Path: 1->2 (0) ->3 (1) = 1
    }

    @Test
    void testNetworkDelayTime_EdgeCase_MaximumWeight() {
        int[][] times = {{1, 2, 100}};
        int n = 2;
        int k = 1;
        int result = solution.networkDelayTime(times, n, k);
        assertEquals(100, result);
    }
}

