package grokking.coding_pattern.sliding_window;

public class P2SmallestSubarray {
    public static int findMinSubArray(int S, int[] arr){
        int n = arr.length;
        int lenSmallest = Integer.MAX_VALUE;
        int windowSum = 0;

        int windowStart = 0;
        for(int windowEnd = 0; windowEnd < n; windowEnd++){
            windowSum += arr[windowEnd];
            while(windowSum >= S){
                lenSmallest = Math.min(lenSmallest, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return lenSmallest == Integer.MAX_VALUE ? 0 : lenSmallest;
    }
    public static void main(String[] args) {
        int result = findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = findMinSubArray(8, new int[] { 3, 4, 1, 1, 5});
        System.out.println("Smallest subarray length: " + result);
        result = findMinSubArray(8, new int[] { 2, 1, 5, 2, 3, 2});
        System.out.println("Smallest subarray length: " + result);
    }
}
