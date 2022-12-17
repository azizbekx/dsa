package leetcode.contest;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubArrayWithKDistinct {
    public static long maximumSubarraySum(int[] arr, int k) {
        int windowStart = 0, windowSum = 0, result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            map.put(arr[windowEnd], map.getOrDefault(arr[windowEnd], 0) + 1);
            windowSum += arr[windowEnd];
            count++;
            if (map.size() == k){
                result = Math.max(result, windowSum);
            }
            while (count >= k) {
                map.put(arr[windowStart], map.get(arr[windowStart]) - 1);
                if (map.get(arr[windowStart]) == 0)
                    map.remove(arr[windowStart]);

                windowSum -= arr[windowStart];
                windowStart++;
                count--;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maximumSubarraySum(new int[] {9,9,9,1,2,3}, 3));
    }
}
