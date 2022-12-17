package grokking.coding_pattern.top_k_elements;

import java.util.*;

public class FrequentElements {
    /*
    n - number elements
    k - top k elements
    O(logK) - to insert
    Time - if k < n -> O(n * logk)
           if k = n -> O(n)
    Space - (n + k)
     */
    public static List<Integer> topKFrequentO(int[] arr, int k) {
        // find the frequencies of each number
        Map<Integer, Integer> numFreqMap = new HashMap<>();
        for (int n : arr)
            numFreqMap.put(n, numFreqMap.getOrDefault(n, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> topKElements = new PriorityQueue<>();
        // go through all numbers of the numFrequencyMap and push them in the topKElements, which will have
        // top k frequent numbers. If the heap size is more than k, we remove the smallest (top) number
        for (Map.Entry<Integer, Integer> entry : numFreqMap.entrySet()) {
            topKElements.add(entry);
            if (topKElements.size() > k)
                topKElements.poll();
        }

        // crate a list of top k numbers
        List<Integer> topNumbers = new ArrayList<>(k);
        while (!topKElements.isEmpty())
            topNumbers.add(topKElements.poll().getKey());
        Collections.sort(topNumbers);
        return topNumbers;
    }

    public static List<Integer> topKFrequent(int[] arr, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>();
        Map<Integer, Integer> numFreq = new HashMap<>();

        for (int num : arr) {
            int freq = numFreq.getOrDefault(num, 0) + 1;
            numFreq.put(num, freq);
        }

        for (Map.Entry<Integer, Integer> map : numFreq.entrySet()) {
            minHeap.offer(map);
        }

        int removedElement = minHeap.size() - k;
        while (removedElement-- > 0)
            minHeap.poll();

        // create a list of top k numbers
        List<Integer> list = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            list.add(minHeap.poll().getKey());

        }
        return list;
    }

    public static void main(String[] args) {
        // Driver code
        int[][] inputs = {
                {1, 3, 5, 12, 11, 12, 11, 12, 5},
                {1, 3, 5, 14, 18, 14, 5},
                {2, 3, 4, 5, 6, 7, 7},
                {9, 8, 7, 6, 5, 4, 3, 2, 1},
                {2, 4, 3, 2, 3, 4, 5, 4, 4, 4},
                {1, 1, 1, 1, 1, 1},
                {2, 3}
        };
        int[] inputK = {3, 2, 1, 1, 3, 4, 2};
        for (int i = 0; i < inputK.length; i++) {
            List<Integer> result = topKFrequent(inputs[i], inputK[i]);
            System.out.print(i + 1);
            System.out.println(".\tInput: (" + Arrays.toString(inputs[i]) + ", " + inputK[i] + ")");
            System.out.println("\n\tTop " + inputK[i] + " frequent elements: " + result);
//            System.out.println(PrintHyphens.repeat("-", 100));
        }
    }
}
