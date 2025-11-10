package com.example.leetcode;

import java.util.*;

/**
 * LeetCode #347: Top K Frequent Elements
 *
 * <p>
 * Problem Description:
 * </p>
 *
 * <p>
 * Given an integer array {@code nums} and an integer {@code k}, return the {@code k} most frequent
 * elements. You may return the answer in any order.
 * </p>
 *
 * <p>
 * Example 1:
 * </p>
 *
 * <pre>
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * </pre>
 *
 * <p>
 * Example 2:
 * </p>
 *
 * <pre>
 * Input: nums = [1], k = 1
 * Output: [1]
 * </pre>
 *
 * <p>
 * Constraints:
 * </p>
 *
 * <ul>
 * <li>1 &lt;= nums.length &lt;= 10⁵</li>
 * <li>-10⁴ &lt;= nums[i] &lt;= 10⁴</li>
 * <li>k is in the range [1, the number of unique elements in the array]</li>
 * <li>It is guaranteed that the answer is unique.</li>
 * </ul>
 *
 * <p>
 * Approaches:
 * </p>
 *
 * <ol>
 * <li><strong>Bucket Sort (Recommended)</strong> – O(n) time, O(n) space</li>
 * <li><strong>Min Heap (Priority Queue)</strong> – O(n log k) time, O(n) space</li>
 * <li><strong>Sorting by Frequency</strong> – O(n log n) time, O(n) space</li>
 * <li><strong>Quickselect (Hoare Selection)</strong> – Average O(n) time, O(n) space</li>
 * </ol>
 */
public class TopKFrequentElements {

    /**
     * Default helper that delegates to the bucket sort implementation.
     *
     * @param nums input array
     * @param k number of most frequent elements to return
     * @return the {@code k} most frequent elements
     */
    public int[] topKFrequent(int[] nums, int k) {
        return topKFrequentBucket(nums, k);
    }

    /**
     * Approach 1: Bucket Sort (Recommended)
     *
     * <p>
     * Counts frequencies and places numbers into buckets indexed by frequency. Iterate buckets from
     * highest to lowest frequency to collect the top {@code k} numbers.
     * </p>
     *
     * @param nums input array
     * @param k number of most frequent elements to return
     * @return the {@code k} most frequent elements
     */
    public int[] topKFrequentBucket(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = buildFrequencyMap(nums);
        @SuppressWarnings("unchecked")
        List<Integer>[] buckets = (List<Integer>[]) new List[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int frequency = entry.getValue();
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(entry.getKey());
        }

        List<Integer> result = new ArrayList<>(k);
        for (int freq = buckets.length - 1; freq >= 0 && result.size() < k; freq--) {
            if (buckets[freq] != null) {
                result.addAll(buckets[freq]);
            }
        }

        return toArray(result, k);
    }

    /**
     * Approach 2: Min Heap (Priority Queue)
     *
     * <p>
     * Maintains a min heap of size {@code k}. For each element, push into the heap and pop the
     * least frequent when heap size exceeds {@code k}.
     * </p>
     *
     * @param nums input array
     * @param k number of most frequent elements to return
     * @return the {@code k} most frequent elements
     */
    public int[] topKFrequentMinHeap(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = buildFrequencyMap(nums);
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }

    /**
     * Approach 3: Sorting by Frequency
     *
     * <p>
     * Sorts entries by frequency in descending order and returns the first {@code k} keys.
     * </p>
     *
     * @param nums input array
     * @param k number of most frequent elements to return
     * @return the {@code k} most frequent elements
     */
    public int[] topKFrequentSorting(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = buildFrequencyMap(nums);
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(frequencyMap.entrySet());
        entries.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        int[] result = new int[Math.min(k, entries.size())];
        for (int i = 0; i < result.length; i++) {
            result[i] = entries.get(i).getKey();
        }
        return result;
    }

    /**
     * Approach 4: Quickselect (Hoare Selection)
     *
     * <p>
     * Uses a selection algorithm to partition entries such that the {@code k} most frequent
     * elements reside in the rightmost positions. Average time O(n).
     * </p>
     *
     * @param nums input array
     * @param k number of most frequent elements to return
     * @return the {@code k} most frequent elements
     */
    public int[] topKFrequentQuickselect(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = buildFrequencyMap(nums);
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(frequencyMap.entrySet());

        int size = entries.size();
        int target = size - k;

        quickselect(entries, 0, size - 1, target);

        int[] result = new int[k];
        for (int i = target; i < size; i++) {
            result[i - target] = entries.get(i).getKey();
        }
        return result;
    }

    /**
     * Helper to build a frequency map.
     */
    public Map<Integer, Integer> buildFrequencyMap(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.merge(num, 1, Integer::sum);
        }
        return frequencyMap;
    }

    /**
     * Utility to check if two result arrays contain the same multiset of elements (order agnostic).
     *
     * @param first first result array
     * @param second second result array
     * @return {@code true} if both arrays represent the same multiset, otherwise {@code false}
     */
    public boolean haveSameElements(int[] first, int[] second) {
        if (first == null || second == null || first.length != second.length) {
            return false;
        }
        int[] copyFirst = Arrays.copyOf(first, first.length);
        int[] copySecond = Arrays.copyOf(second, second.length);
        Arrays.sort(copyFirst);
        Arrays.sort(copySecond);
        return Arrays.equals(copyFirst, copySecond);
    }

    /**
     * Demonstration via main method.
     *
     * @param args program arguments
     */
    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();

        System.out.println("🚀 LeetCode #347: Top K Frequent Elements");
        System.out.println("=".repeat(60));

        int[][] testCases =
                {{1, 1, 1, 2, 2, 3}, {1}, {4, 4, 4, 6, 6, 7, 7, 7, 7}, {5, 7, -1, -1, -1, 5, 5}};
        int[] kValues = {2, 1, 2, 2};

        for (int i = 0; i < testCases.length; i++) {
            int[] nums = testCases[i];
            int k = kValues[i];
            System.out.printf("Test Case %d -> nums=%s, k=%d%n", i + 1, Arrays.toString(nums), k);

            int[] bucket = solution.topKFrequentBucket(nums, k);
            int[] minHeap = solution.topKFrequentMinHeap(nums, k);
            int[] sorting = solution.topKFrequentSorting(nums, k);
            int[] quickselect = solution.topKFrequentQuickselect(nums, k);

            System.out.println("Bucket Sort      : " + Arrays.toString(bucket));
            System.out.println("Min Heap         : " + Arrays.toString(minHeap));
            System.out.println("Sorting          : " + Arrays.toString(sorting));
            System.out.println("Quickselect      : " + Arrays.toString(quickselect));
            System.out.println("All Match        : " + (solution.haveSameElements(bucket, minHeap)
                    && solution.haveSameElements(bucket, sorting)
                    && solution.haveSameElements(bucket, quickselect)));
            System.out.println("-".repeat(60));
        }
    }

    private int[] toArray(List<Integer> values, int k) {
        int[] result = new int[Math.min(k, values.size())];
        for (int i = 0; i < result.length; i++) {
            result[i] = values.get(i);
        }
        return result;
    }

    private void quickselect(List<Map.Entry<Integer, Integer>> entries, int left, int right,
            int kSmallest) {
        while (left <= right) {
            int pivotIndex = partition(entries, left, right);
            if (pivotIndex == kSmallest) {
                return;
            } else if (pivotIndex < kSmallest) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
    }

    private int partition(List<Map.Entry<Integer, Integer>> entries, int left, int right) {
        int pivotFreq = entries.get(right).getValue();
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (entries.get(i).getValue() < pivotFreq) {
                swap(entries, storeIndex, i);
                storeIndex++;
            }
        }

        swap(entries, storeIndex, right);
        return storeIndex;
    }

    private void swap(List<Map.Entry<Integer, Integer>> entries, int i, int j) {
        if (i == j) {
            return;
        }
        Map.Entry<Integer, Integer> temp = entries.get(i);
        entries.set(i, entries.get(j));
        entries.set(j, temp);
    }
}

