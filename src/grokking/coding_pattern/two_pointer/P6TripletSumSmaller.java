package grokking.coding_pattern.two_pointer;

import java.util.Arrays;

public class P6TripletSumSmaller {
    public static int searchTriplets(int[] arr, int target) {
       Arrays.sort(arr);
       int count = 0;
       for (int i = 0; i<arr.length  -2; i++)
           count+=searchPair(arr, target - arr[i], i);
       return count;
    }
    private static int searchPair(int[] arr, int targetSum, int first){
        int count = 0;
        int left = first + 1, right = arr.length - 1;
        while(left < right){
            // found the triplet
            if (arr[left] + arr[right] < targetSum) {
                //since arr[right] >= arr[left], therefore, we can replace arr[right] by any number between
                // left and right to get a sum less than the target sum
                count += right - left;
                left++;
            }else
                //we need a pair with smaller sum
                right--;
        }
        return count;
    }
}
