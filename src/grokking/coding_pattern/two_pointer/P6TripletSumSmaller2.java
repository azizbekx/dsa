package grokking.coding_pattern.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P6TripletSumSmaller2 {
    public static List<List<Integer>> searchTriplets(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < arr.length - 2; i++)
            searchPair(arr, target - arr[i], i, result);
        return result;
    }

    public static void searchPair(int[] arr, int targetSum, int first, List<List<Integer>> triplets) {
        int left = first + 1, right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] < targetSum) {
                for (int i = right; i > left; i--)
                    triplets.add(Arrays.asList(arr[first], arr[left], arr[i]));
                left++;
            } else right--;
        }
    }
    public static void main(String[] args) {
        System.out.println(searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
        System.out.println(searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
    }
}
