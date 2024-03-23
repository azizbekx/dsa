package neetcode.array;

import java.util.*;

public class TopKFreqeuntNum {
    public int[] topKFrequentO(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int num : nums)
            count.merge(num, 1, Integer::sum);

        for (int key : count.keySet()){
            int freq = count.get(key);
            if (bucket[freq] == null)
                bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }

        int index = 0;
        int[] res = new int[k];
        for (int i = nums.length; i >= 0; i--)
            if (bucket[i] != null)
                for (int val : bucket[i]){
                    res[index++] = val;
                    if(index == k)
                        return res;
                }
        return res;
    }
    /*
    Time - O(nlog(k))
    Space - O(n)
     */
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (i1, i2) -> i2.getValue() - i1.getValue()
        );
        Map<Integer, Integer> numFreq = new HashMap<>();
        for (int num : nums)
            numFreq.put(num, numFreq.getOrDefault(num , 0) + 1);

        maxHeap.addAll(numFreq.entrySet());
        int[] res = new int[k];
        for (int i = 0; i<k; i++)
            res[i] = maxHeap.poll().getKey();
        return res;
    }
}
