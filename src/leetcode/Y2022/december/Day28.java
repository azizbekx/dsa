package leetcode.Y2022.december;

import java.util.PriorityQueue;

public class Day28 {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int stones : piles) maxHeap.add(stones);
        while (!maxHeap.isEmpty() && k != 0) {
            int stones = maxHeap.poll();
            int remainStones = stones - stones / 2;
            maxHeap.add(remainStones);
            k--;
        }
        int sum = 0;
        while (!maxHeap.isEmpty())
            sum += maxHeap.poll();
        return sum;
    }
    //--Instead of  using PriorityQueue , we can use array to track number of piles with same heigth

    public int minStoneSumO(int[] piles, int k) {
        int sum = 0;
        int a[] = new int[10001];
        for (int i : piles) {
            sum += i;
            a[i]++;
        }
        for (int i = 10000; i > 0 && k > 0; i--) {
            if (a[i] > 0) {
                int b = i / 2;
                sum -= Math.min(k, a[i]) * b;
                a[i - i / 2] += a[i];
                k -= a[i];
            }
        }
        return sum;

    }

    // Time complexity : O(n)
    public int minStoneSumO2(int[] A, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int res = 0;
        for (int a : A) {
            pq.add(a);
            res += a;
        }
        while (k-- > 0) {
            int a = pq.poll();
            pq.add(a - a / 2);
            res -= a / 2;
        }
        return res;
    }
}