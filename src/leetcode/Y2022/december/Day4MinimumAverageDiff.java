package leetcode.Y2022.december;

public class Day4MinimumAverageDiff {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        int ans = -1;
        int minAvgDiff = Integer.MAX_VALUE;

        // generating prefix and suffix sum
        long[] prefixSum = new long[n + 1];
        long[] suffixSum = new long[n + 1];

        for (int index = 0; index < n; index++)
            prefixSum[index + 1] = prefixSum[index] + nums[index];

        for (int index = n - 1; index >= 0; index--)
            suffixSum[index] = suffixSum[index + 1] + nums[index];

        for (int index = 0; index < n; index++) {
            // calculate averageof left parto fo array, index 0 to 1
            long leftPartAverage = prefixSum[index + 1];
            leftPartAverage /= (index + 1);

            // calculate average of righ part of array, index i + 1 to n - 1
            long rightPartAverage = suffixSum[index + 1];
            if (index != n - 1)
                rightPartAverage /= (n - index - 1);

            int currDifference = (int) Math.abs(leftPartAverage - rightPartAverage);
            // if current diff of averages is smaller
            // then current index can be our answer
            if (currDifference < minAvgDiff) {
                minAvgDiff = currDifference;
                ans = index;
            }
        }
        return ans;
    }
}
