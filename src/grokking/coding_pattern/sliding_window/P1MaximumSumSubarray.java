package grokking.coding_pattern.sliding_window;

public class P1MaximumSumSubarray {
    /*
    Time - O(n)
    Space - O(1)
     */
    public static int findMaxSumSubArray(int k, int[] arr) {
        int result = 0;
        int windowStart = 0;
        int windowSum = 0;

        for(int windowEnd=0; windowEnd<arr.length; windowEnd++){
            windowSum += arr[windowEnd];
            if(windowEnd >= k - 1){
                result = Math.max(result, windowSum);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("Maximum sum of a subarray of size K: "
                + findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
    }
}
