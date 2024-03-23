package leetcode.Y2022.december;

import java.util.Arrays;

public class MaxiumBags2279 {
    public int maximumBagsO(int[] capacity, int[] rocks, int additionalRocks) {
        long total = 0;
        int length = capacity.length;
        for (int i = 0; i < length; i++) {
            capacity[i] -= rocks[i];
            total += capacity[i];
        }
        if (total > additionalRocks) {
            Arrays.sort(capacity);
            for (int i = 0; i < length; i++) {
                if (additionalRocks < capacity[i]) {
                    return i;
                }
                additionalRocks -= capacity[i];
            }
        }
        return length;
    }
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int res = 0, n = rocks.length;
        int[] remain = new int[n];
        for (int i = 0; i < n; i++){
            remain[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(remain);
        for (int num : remain){
            if (additionalRocks >= num){
                additionalRocks -= num;
                res++;
            } else {
                break;
            }
        }
        return res;
    }
}
