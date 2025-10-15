package com.example.leetcode;

import java.util.*;

/**
 * LeetCode 1604: Alert Using Same Key-Card Three or More Times in a One Hour Period Difficulty:
 * Medium
 * 
 * Problem Description: LeetCode company workers use key-cards to unlock office doors. Each time a
 * worker uses their card, the security system saves the worker's name and the time when it was
 * used. The system emits an alert if any worker uses the key-card three or more times in a one-hour
 * period.
 * 
 * You are given a list of strings keyName where keyName[i] is the name of the person who used the
 * key-card and a list of strings keyTime where keyTime[i] is the corresponding time in "HH:MM"
 * format.
 * 
 * Return a list of unique worker names who received an alert for frequent keycard use. Sort the
 * names in ascending order alphabetically.
 * 
 * Notice that "10:00" - "11:00" is considered to be within a one-hour period, while "22:51" -
 * "23:52" is not considered to be within a one-hour period.
 * 
 * Constraints: - 1 <= keyName.length, keyTime.length <= 10^5 - keyName.length == keyTime.length -
 * keyTime[i] is in the format "HH:MM" - [keyName[i], keyTime[i]] is unique - 1 <= keyName[i].length
 * <= 10 - keyName[i] contains only lowercase English letters
 * 
 * Examples:
 * 
 * Example 1: Input: keyName = ["daniel","daniel","daniel","luis","luis","luis","luis"], keyTime =
 * ["10:00","10:40","11:00","09:00","11:00","13:00","15:00"] Output: ["daniel"] Explanation:
 * "daniel" used the keycard 3 times in a one-hour period ("10:00","10:40","11:00").
 * 
 * Example 2: Input: keyName = ["alice","alice","alice","bob","bob","bob","bob"], keyTime =
 * ["12:01","12:00","18:00","21:00","21:20","21:30","23:00"] Output: ["bob"] Explanation: "bob" used
 * the keycard 3 times in a one-hour period ("21:00","21:20","21:30").
 * 
 * Example 3: Input: keyName = ["john","john","john"], keyTime = ["23:58","23:59","00:01"] Output:
 * [] Explanation: No one used the keycard 3 times in a one-hour period.
 */
public class AlertUsingKeyCard {

    /**
     * Approach 1: HashMap + Sorting with Sliding Window
     * 
     * Algorithm: 1. Group all access times by worker name using a HashMap 2. Convert each time
     * string "HH:MM" to minutes since midnight 3. Sort each worker's access times 4. For each
     * worker, use a sliding window to check if any 3 consecutive accesses fall within 60 minutes 5.
     * Collect workers who trigger alerts and sort alphabetically
     * 
     * Time Complexity: O(N * log(N)) where N is the number of total accesses - Grouping: O(N) -
     * Sorting each worker's times: O(N * log(N)) in worst case (all accesses by one worker) -
     * Checking alerts: O(N) - Final sorting: O(K * log(K)) where K is number of unique workers
     * 
     * Space Complexity: O(N) for storing all access times in the HashMap
     * 
     * @param keyName Array of worker names
     * @param keyTime Array of access times in "HH:MM" format
     * @return List of workers who received alerts, sorted alphabetically
     */
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        // Group access times by worker name
        Map<String, List<Integer>> accessMap = new HashMap<>();

        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            int minutes = convertToMinutes(keyTime[i]);

            accessMap.putIfAbsent(name, new ArrayList<>());
            accessMap.get(name).add(minutes);
        }

        List<String> alerts = new ArrayList<>();

        // Check each worker's access pattern
        for (Map.Entry<String, List<Integer>> entry : accessMap.entrySet()) {
            String name = entry.getKey();
            List<Integer> times = entry.getValue();

            // Sort times in ascending order
            Collections.sort(times);

            // Check for 3 or more accesses within 60 minutes
            if (hasAlert(times)) {
                alerts.add(name);
            }
        }

        // Sort alphabetically
        Collections.sort(alerts);
        return alerts;
    }

    /**
     * Approach 2: TreeMap for Auto-Sorting
     * 
     * Uses TreeMap to automatically maintain sorted order of access times for each worker. This can
     * be more efficient when access times are added incrementally.
     * 
     * Time Complexity: O(N * log(M)) where M is average accesses per worker Space Complexity: O(N)
     * 
     * @param keyName Array of worker names
     * @param keyTime Array of access times in "HH:MM" format
     * @return List of workers who received alerts, sorted alphabetically
     */
    public List<String> alertNamesTreeMap(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> accessMap = new HashMap<>();

        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            int minutes = convertToMinutes(keyTime[i]);

            accessMap.putIfAbsent(name, new ArrayList<>());
            accessMap.get(name).add(minutes);
        }

        // Use TreeSet to automatically sort results
        Set<String> alertSet = new TreeSet<>();

        for (Map.Entry<String, List<Integer>> entry : accessMap.entrySet()) {
            String name = entry.getKey();
            List<Integer> times = entry.getValue();

            Collections.sort(times);

            if (hasAlert(times)) {
                alertSet.add(name);
            }
        }

        return new ArrayList<>(alertSet);
    }

    /**
     * Approach 3: Optimized with Early Termination
     * 
     * Same as Approach 1 but with early termination optimization in the alert check. Once we find
     * one alert window for a worker, we can stop checking.
     * 
     * Time Complexity: O(N * log(N)) Space Complexity: O(N)
     * 
     * @param keyName Array of worker names
     * @param keyTime Array of access times in "HH:MM" format
     * @return List of workers who received alerts, sorted alphabetically
     */
    public List<String> alertNamesOptimized(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> accessMap = new HashMap<>();

        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            int minutes = convertToMinutes(keyTime[i]);

            accessMap.putIfAbsent(name, new ArrayList<>());
            accessMap.get(name).add(minutes);
        }

        List<String> alerts = new ArrayList<>();

        for (Map.Entry<String, List<Integer>> entry : accessMap.entrySet()) {
            String name = entry.getKey();
            List<Integer> times = entry.getValue();

            // Skip if less than 3 accesses
            if (times.size() < 3) {
                continue;
            }

            Collections.sort(times);

            if (hasAlert(times)) {
                alerts.add(name);
            }
        }

        Collections.sort(alerts);
        return alerts;
    }

    /**
     * Approach 4: Stream API (Modern Java)
     * 
     * Functional programming approach using Java Streams for cleaner code.
     * 
     * Time Complexity: O(N * log(N)) Space Complexity: O(N)
     * 
     * @param keyName Array of worker names
     * @param keyTime Array of access times in "HH:MM" format
     * @return List of workers who received alerts, sorted alphabetically
     */
    public List<String> alertNamesStream(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> accessMap = new HashMap<>();

        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            int minutes = convertToMinutes(keyTime[i]);

            accessMap.computeIfAbsent(name, k -> new ArrayList<>()).add(minutes);
        }

        return accessMap.entrySet().stream().filter(entry -> {
            List<Integer> times = entry.getValue();
            Collections.sort(times);
            return hasAlert(times);
        }).map(Map.Entry::getKey).sorted().collect(java.util.stream.Collectors.toList());
    }

    /**
     * Helper method to convert "HH:MM" format to minutes since midnight
     * 
     * @param time Time string in "HH:MM" format
     * @return Total minutes since midnight
     */
    private int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }

    /**
     * Helper method to check if a sorted list of access times has any window of 3 or more accesses
     * within 60 minutes
     * 
     * @param sortedTimes Sorted list of access times in minutes
     * @return true if there's an alert window, false otherwise
     */
    private boolean hasAlert(List<Integer> sortedTimes) {
        if (sortedTimes.size() < 3) {
            return false;
        }

        // Check every consecutive triplet
        for (int i = 0; i <= sortedTimes.size() - 3; i++) {
            // If 3rd access is within 60 minutes of 1st access
            if (sortedTimes.get(i + 2) - sortedTimes.get(i) <= 60) {
                return true;
            }
        }

        return false;
    }

    /**
     * Utility method to print the access pattern for debugging
     * 
     * @param keyName Array of worker names
     * @param keyTime Array of access times
     */
    public void printAccessPattern(String[] keyName, String[] keyTime) {
        Map<String, List<String>> accessMap = new HashMap<>();

        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            String time = keyTime[i];

            accessMap.putIfAbsent(name, new ArrayList<>());
            accessMap.get(name).add(time);
        }

        System.out.println("Access Pattern:");
        for (Map.Entry<String, List<String>> entry : accessMap.entrySet()) {
            List<String> times = entry.getValue();
            Collections.sort(times);
            System.out.println(entry.getKey() + ": " + times);
        }
    }

    /**
     * Utility method to get detailed alert information
     * 
     * @param keyName Array of worker names
     * @param keyTime Array of access times
     * @return Map of worker names to their alert windows
     */
    public Map<String, List<String>> getAlertDetails(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> accessMap = new HashMap<>();
        Map<String, List<String>> timeStrMap = new HashMap<>();

        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            int minutes = convertToMinutes(keyTime[i]);

            accessMap.putIfAbsent(name, new ArrayList<>());
            timeStrMap.putIfAbsent(name, new ArrayList<>());

            accessMap.get(name).add(minutes);
            timeStrMap.get(name).add(keyTime[i]);
        }

        Map<String, List<String>> alertDetails = new HashMap<>();

        for (Map.Entry<String, List<Integer>> entry : accessMap.entrySet()) {
            String name = entry.getKey();
            List<Integer> times = entry.getValue();
            List<String> timeStrs = timeStrMap.get(name);

            if (times.size() < 3) {
                continue;
            }

            // Sort both lists together
            List<Integer> indices = new ArrayList<>();
            for (int i = 0; i < times.size(); i++) {
                indices.add(i);
            }
            indices.sort(Comparator.comparingInt(times::get));

            List<Integer> sortedTimes = new ArrayList<>();
            List<String> sortedTimeStrs = new ArrayList<>();
            for (int idx : indices) {
                sortedTimes.add(times.get(idx));
                sortedTimeStrs.add(timeStrs.get(idx));
            }

            // Find first alert window
            for (int i = 0; i <= sortedTimes.size() - 3; i++) {
                if (sortedTimes.get(i + 2) - sortedTimes.get(i) <= 60) {
                    List<String> alertWindow = new ArrayList<>();
                    alertWindow.add(sortedTimeStrs.get(i));
                    alertWindow.add(sortedTimeStrs.get(i + 1));
                    alertWindow.add(sortedTimeStrs.get(i + 2));
                    alertDetails.put(name, alertWindow);
                    break;
                }
            }
        }

        return alertDetails;
    }
}

