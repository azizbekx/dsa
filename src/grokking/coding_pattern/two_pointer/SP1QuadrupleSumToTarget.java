package grokking.coding_pattern.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SP1QuadrupleSumToTarget {
    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> quadruplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            for (int j = i + 1; j < arr.length - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;
                searchPair(arr, target, i, j, quadruplets);
            }
        }
        return quadruplets;
    }

    private static void searchPair(int[] arr, int targetSum, int first, int second, List<List<Integer>> quadruplets) {
        int right = arr.length - 1;
        int left = second + 1;
        while (left < right) {
            int currentSum = arr[first] + arr[second] + arr[left] + arr[right];
            if (currentSum == targetSum) {
                quadruplets.add(Arrays.asList(arr[first], arr[second], arr[left], arr[right]));
                left++;
                right--;
                while (left < right && arr[left] == arr[left - 1])
                    // skip the same element to avoid duplicate triplet
                    left++;
                while (right > left && arr[right] == arr[right - 1])
                    // skip the same element to avoid duplicate triplet
                    right--;
            } else if (currentSum > targetSum)
                left++;
            else right--;

        }
    }

    public static void main(String[] args) {
        System.out.println(searchQuadruplets(new int[]{4, 1, 2, -1, 1, -3}, 1));
        System.out.println(searchQuadruplets(new int[]{2, 0, -1, 1, -2, 2}, 2));
    }
}
