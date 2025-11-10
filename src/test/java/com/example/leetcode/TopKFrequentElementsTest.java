package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link TopKFrequentElements}.
 */
public class TopKFrequentElementsTest {

    private TopKFrequentElements solution;

    @BeforeEach
    void setUp() {
        solution = new TopKFrequentElements();
    }

    @Test
    void testTopKFrequentBucket_Example1() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] result = solution.topKFrequentBucket(nums, 2);
        assertSameElements(new int[] {1, 2}, result);
    }

    @Test
    void testTopKFrequentBucket_Example2() {
        int[] nums = {1};
        int[] result = solution.topKFrequentBucket(nums, 1);
        assertSameElements(new int[] {1}, result);
    }

    @Test
    void testTopKFrequentMinHeap_WithNegativeNumbers() {
        int[] nums = {4, -1, -1, 2, 2, 2, 3, 3};
        int[] result = solution.topKFrequentMinHeap(nums, 2);
        assertValidTopK(nums, 2, result);
        assertTrue(containsValue(result, 2));
    }

    @Test
    void testTopKFrequentSorting_MultipleModes() {
        int[] nums = {4, 4, 4, 6, 6, 7, 7, 7, 7};
        int[] result = solution.topKFrequentSorting(nums, 2);
        assertValidTopK(nums, 2, result);
    }

    @Test
    void testTopKFrequentQuickselect_KEqualsUniqueCount() {
        int[] nums = {5, 6, 7, 8};
        int[] result = solution.topKFrequentQuickselect(nums, 4);
        assertValidTopK(nums, 4, result);
    }

    @Test
    void testTopKFrequent_AllApproachesMatch() {
        int[] nums = {5, 7, -1, -1, -1, 5, 5, 5, 7, 7, 8, 8, 8};
        int k = 3;

        int[] bucket = solution.topKFrequentBucket(nums, k);
        int[] minHeap = solution.topKFrequentMinHeap(nums, k);
        int[] sorting = solution.topKFrequentSorting(nums, k);
        int[] quickselect = solution.topKFrequentQuickselect(nums, k);

        assertValidTopK(nums, k, bucket);
        assertValidTopK(nums, k, minHeap);
        assertValidTopK(nums, k, sorting);
        assertValidTopK(nums, k, quickselect);
    }

    @Test
    void testHaveSameElements_True() {
        int[] first = {3, 1, 2};
        int[] second = {2, 3, 1};
        assertTrue(solution.haveSameElements(first, second));
    }

    @Test
    void testHaveSameElements_FalseDifferentLength() {
        int[] first = {1, 2};
        int[] second = {1, 2, 3};
        assertFalse(solution.haveSameElements(first, second));
    }

    @Test
    void testBuildFrequencyMap() {
        int[] nums = {1, 1, 2, 3, 3, 3};
        Map<Integer, Integer> frequencyMap = solution.buildFrequencyMap(nums);

        assertEquals(3, frequencyMap.size());
        assertEquals(2, frequencyMap.get(1));
        assertEquals(1, frequencyMap.get(2));
        assertEquals(3, frequencyMap.get(3));
    }

    @Test
    void testTopKFrequentBucket_TiesResolvedByOrder() {
        int[] nums = {10, 20, 30, 40};
        int[] result = solution.topKFrequentBucket(nums, 2);
        assertValidTopK(nums, 2, result);
    }

    @Test
    void testTopKFrequentMinHeap_KEqualsOne() {
        int[] nums = {9, 9, 9, 8, 8, 7};
        int[] result = solution.topKFrequentMinHeap(nums, 1);
        assertSameElements(new int[] {9}, result);
    }

    private void assertSameElements(int[] expected, int[] actual) {
        int[] expectedCopy = Arrays.copyOf(expected, expected.length);
        int[] actualCopy = Arrays.copyOf(actual, actual.length);
        Arrays.sort(expectedCopy);
        Arrays.sort(actualCopy);
        assertArrayEquals(expectedCopy, actualCopy);
    }

    private void assertValidTopK(int[] nums, int k, int[] actual) {
        Map<Integer, Integer> frequencyMap = solution.buildFrequencyMap(nums);
        assertEquals(k, actual.length, "Result should contain exactly k elements");

        Set<Integer> actualSet = new HashSet<>();
        for (int value : actual) {
            actualSet.add(value);
        }
        assertEquals(k, actualSet.size(), "Result should contain k unique elements");

        int threshold = kthLargestFrequency(frequencyMap, k);
        Set<Integer> mustInclude = new HashSet<>();

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > threshold) {
                mustInclude.add(entry.getKey());
            }
        }

        for (int value : actual) {
            assertTrue(frequencyMap.containsKey(value),
                    "Result contains value not present in original array: " + value);
            assertTrue(frequencyMap.get(value) >= threshold,
                    "Frequency of value " + value + " is below threshold " + threshold);
        }

        assertTrue(actualSet.containsAll(mustInclude),
                "Result must contain all elements with frequency greater than the threshold: "
                        + mustInclude);
    }

    private int kthLargestFrequency(Map<Integer, Integer> frequencyMap, int k) {
        int[] counts = new int[frequencyMap.size()];
        int index = 0;
        for (int count : frequencyMap.values()) {
            counts[index++] = count;
        }
        Arrays.sort(counts);
        return counts[counts.length - k];
    }

    private boolean containsValue(int[] arr, int target) {
        for (int value : arr) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }
}

