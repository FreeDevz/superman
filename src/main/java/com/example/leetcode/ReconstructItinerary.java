package com.example.leetcode;

import java.util.*;

/**
 * LeetCode 332: Reconstruct Itinerary
 * 
 * You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure
 * and the arrival airports of one flight. Reconstruct the itinerary in order and return it.
 * 
 * All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with
 * "JFK". If there are multiple valid itineraries, you should return the itinerary that has the
 * smallest lexical order when read as a single string.
 * 
 * For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"]. You
 * may assume all tickets form at least one valid itinerary. You must use all the tickets once and
 * only once.
 * 
 * Examples: Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]] Output:
 * ["JFK","MUC","LHR","SFO","SJC"]
 * 
 * Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]] Output:
 * ["JFK","ATL","JFK","SFO","ATL","SFO"] Explanation: Another possible reconstruction is
 * ["JFK","SFO","ATL","JFK","ATL","SFO"] but it is larger in lexical order.
 * 
 * Constraints: - 1 <= tickets.length <= 300 - tickets[i].length == 2 - fromi.length == 3 -
 * toi.length == 3 - fromi and toi consist of uppercase English letters. - fromi != toi
 */
public class ReconstructItinerary {

    // ========================================
    // APPROACH 1: HIERHOLZER'S ALGORITHM - DFS WITH POSTORDER (OPTIMAL)
    // Time: O(E log E), Space: O(E + V)
    // ========================================

    /**
     * Approach 1: Hierholzer's Algorithm - DFS with Postorder (Recommended)
     * 
     * This is the optimal solution using Hierholzer's algorithm to find an Eulerian path.
     * 
     * Algorithm: 1. Build an adjacency list graph where each airport maps to a priority queue of
     * destinations 2. Use a priority queue to ensure we always visit destinations in lexical order
     * 3. Perform DFS from "JFK", visiting destinations and removing edges as we go 4. Add airports
     * to result in postorder (after visiting all destinations) 5. Reverse the result to get the
     * correct order
     * 
     * Key insights: - This is an Eulerian path problem (visiting all edges exactly once) -
     * Hierholzer's algorithm: visit edges recursively, add nodes in postorder - Priority queue
     * ensures lexical ordering - Postorder insertion creates reverse path, which we then reverse
     * 
     * Why postorder works: - When we get stuck (no more outgoing edges), that's the end of the path
     * - We backtrack and add airports in reverse order of completion - This naturally builds the
     * path from end to start
     * 
     * Time Complexity: O(E log E) where E is number of tickets - Sorting takes O(E log E) for
     * building priority queues - Each edge is visited exactly once Space Complexity: O(E + V) for
     * graph and recursion stack
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        // Build adjacency list with priority queues for lexical ordering
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).offer(to);
        }

        LinkedList<String> result = new LinkedList<>();
        dfsPostorder(graph, "JFK", result);

        return result;
    }

    /**
     * Helper method: DFS traversal with postorder insertion
     * 
     * @param graph The adjacency list representation
     * @param airport Current airport
     * @param result Result list to build the itinerary
     */
    private void dfsPostorder(Map<String, PriorityQueue<String>> graph, String airport,
            LinkedList<String> result) {
        PriorityQueue<String> destinations = graph.get(airport);

        // Visit all destinations from current airport
        while (destinations != null && !destinations.isEmpty()) {
            String nextAirport = destinations.poll();
            dfsPostorder(graph, nextAirport, result);
        }

        // Add to front (postorder = reverse order)
        result.addFirst(airport);
    }

    // ========================================
    // APPROACH 2: ITERATIVE WITH STACK
    // Time: O(E log E), Space: O(E + V)
    // ========================================

    /**
     * Approach 2: Iterative Solution with Stack
     * 
     * This approach uses an iterative method with a stack to simulate the DFS.
     * 
     * Algorithm: 1. Build adjacency list with priority queues (same as approach 1) 2. Use a stack
     * to simulate DFS traversal 3. Pop airports from stack and visit their destinations 4. When no
     * more destinations, add airport to result 5. Result is built in correct order
     * 
     * Key insights: - Stack simulates call stack of recursive DFS - Same Hierholzer's algorithm but
     * iterative - Useful for avoiding stack overflow with large inputs
     * 
     * Time Complexity: O(E log E) where E is number of tickets Space Complexity: O(E + V) for graph
     * and stack
     */
    public List<String> findItineraryIterative(List<List<String>> tickets) {
        // Build adjacency list with priority queues
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).offer(to);
        }

        LinkedList<String> result = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");

        while (!stack.isEmpty()) {
            String airport = stack.peek();
            PriorityQueue<String> destinations = graph.get(airport);

            if (destinations == null || destinations.isEmpty()) {
                // No more destinations, add to result and backtrack
                result.addFirst(stack.pop());
            } else {
                // Visit next destination
                stack.push(destinations.poll());
            }
        }

        return result;
    }

    // ========================================
    // APPROACH 3: DFS WITH BACKTRACKING (ALTERNATIVE)
    // Time: O(E^E) worst case, Space: O(E + V)
    // ========================================

    /**
     * Approach 3: DFS with Backtracking (Less Efficient)
     * 
     * This approach uses traditional DFS with backtracking to try all possible paths.
     * 
     * Algorithm: 1. Build adjacency list and sort destinations for each airport 2. Start DFS from
     * "JFK", trying each destination 3. Mark tickets as used and backtrack if path doesn't work 4.
     * Return first valid complete path (which will be lexically smallest)
     * 
     * Key insights: - More intuitive but less efficient than Hierholzer's algorithm - Tries all
     * possible paths until finding valid one - Sorting ensures first valid path is lexically
     * smallest
     * 
     * Time Complexity: O(E^E) worst case (trying all permutations) Space Complexity: O(E) for
     * recursion stack and path
     * 
     * Note: This is included for educational purposes but is less efficient than Approach 1.
     */
    public List<String> findItineraryBacktracking(List<List<String>> tickets) {
        // Build adjacency list
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, boolean[]> used = new HashMap<>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(to);
        }

        // Sort destinations for lexical order
        for (String airport : graph.keySet()) {
            Collections.sort(graph.get(airport));
            used.put(airport, new boolean[graph.get(airport).size()]);
        }

        List<String> result = new ArrayList<>();
        result.add("JFK");

        dfsBacktracking(graph, used, "JFK", result, tickets.size());

        return result;
    }

    /**
     * Helper method: DFS with backtracking
     * 
     * @param graph The adjacency list
     * @param used Map tracking which edges have been used
     * @param airport Current airport
     * @param path Current path being built
     * @param totalTickets Total number of tickets to use
     * @return true if valid path found, false otherwise
     */
    private boolean dfsBacktracking(Map<String, List<String>> graph, Map<String, boolean[]> used,
            String airport, List<String> path, int totalTickets) {
        // Found valid path using all tickets
        if (path.size() == totalTickets + 1) {
            return true;
        }

        List<String> destinations = graph.get(airport);
        if (destinations == null) {
            return false;
        }

        boolean[] usedFromAirport = used.get(airport);

        for (int i = 0; i < destinations.size(); i++) {
            if (!usedFromAirport[i]) {
                String nextAirport = destinations.get(i);

                // Try this path
                path.add(nextAirport);
                usedFromAirport[i] = true;

                if (dfsBacktracking(graph, used, nextAirport, path, totalTickets)) {
                    return true;
                }

                // Backtrack
                path.remove(path.size() - 1);
                usedFromAirport[i] = false;
            }
        }

        return false;
    }

    // ========================================
    // UTILITY METHODS
    // ========================================

    /**
     * Helper method to convert array of string arrays to list of lists Useful for testing with
     * various input formats
     */
    public List<String> findItineraryFromArray(String[][] tickets) {
        List<List<String>> ticketList = new ArrayList<>();
        for (String[] ticket : tickets) {
            ticketList.add(Arrays.asList(ticket[0], ticket[1]));
        }
        return findItinerary(ticketList);
    }

    /**
     * Get approach name for testing
     */
    public String getApproachName(int approach) {
        switch (approach) {
            case 1:
                return "Hierholzer's DFS Postorder";
            case 2:
                return "Iterative with Stack";
            case 3:
                return "DFS with Backtracking";
            default:
                return "Unknown";
        }
    }

    /**
     * Execute specific approach
     */
    public List<String> executeApproach(int approach, List<List<String>> tickets) {
        switch (approach) {
            case 1:
                return findItinerary(tickets);
            case 2:
                return findItineraryIterative(tickets);
            case 3:
                return findItineraryBacktracking(tickets);
            default:
                throw new IllegalArgumentException("Invalid approach: " + approach);
        }
    }

    /**
     * Validate if itinerary is valid
     * 
     * @param tickets Original tickets
     * @param itinerary Proposed itinerary
     * @return true if valid, false otherwise
     */
    public boolean isValidItinerary(List<List<String>> tickets, List<String> itinerary) {
        if (itinerary == null || itinerary.isEmpty()) {
            return false;
        }

        // Must start with JFK
        if (!"JFK".equals(itinerary.get(0))) {
            return false;
        }

        // Must have correct number of airports
        if (itinerary.size() != tickets.size() + 1) {
            return false;
        }

        // Check if all tickets are used
        Map<String, List<String>> ticketMap = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            ticketMap.putIfAbsent(from, new ArrayList<>());
            ticketMap.get(from).add(to);
        }

        // Verify each step in itinerary
        for (int i = 0; i < itinerary.size() - 1; i++) {
            String from = itinerary.get(i);
            String to = itinerary.get(i + 1);

            List<String> destinations = ticketMap.get(from);
            if (destinations == null || !destinations.contains(to)) {
                return false;
            }

            // Remove used ticket
            destinations.remove(to);
            if (destinations.isEmpty()) {
                ticketMap.remove(from);
            }
        }

        // All tickets should be used
        return ticketMap.isEmpty();
    }

    /**
     * Compare two itineraries lexicographically
     * 
     * @return negative if itinerary1 < itinerary2, 0 if equal, positive if itinerary1 > itinerary2
     */
    public int compareItineraries(List<String> itinerary1, List<String> itinerary2) {
        int minLength = Math.min(itinerary1.size(), itinerary2.size());

        for (int i = 0; i < minLength; i++) {
            int cmp = itinerary1.get(i).compareTo(itinerary2.get(i));
            if (cmp != 0) {
                return cmp;
            }
        }

        return Integer.compare(itinerary1.size(), itinerary2.size());
    }

    /**
     * Get complexity analysis for each approach
     */
    public String getComplexityAnalysis(int approach) {
        switch (approach) {
            case 1:
                return "Time: O(E log E) for sorting edges, O(E) for traversal. Space: O(E + V) for graph and recursion.";
            case 2:
                return "Time: O(E log E) for sorting edges, O(E) for traversal. Space: O(E + V) for graph and stack.";
            case 3:
                return "Time: O(E^E) worst case for backtracking. Space: O(E) for recursion and path.";
            default:
                return "Unknown approach";
        }
    }
}

