package grokking.coding_pattern.cyclic_sort;

import java.util.ArrayList;
import java.util.List;

public class FindFirstKMissingPositiveNumber {
    public static List<Integer> findNumbers(int[] nums, int t) {
        List<Integer> missingNumbers = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }
        int count = 0;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != k + 1) {
                missingNumbers.add(k + 1);
                count++;
            }
            // if(count == t)
            //   break;
        }
        return missingNumbers;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(findNumbers(new int[]{3, -1, 4, 5, 5}, 3));
        System.out.println(findNumbers(new int[]{2, 3, 4}, 3));
        System.out.println(findNumbers(new int[]{-2, -3, 4}, 2));
    }
}
