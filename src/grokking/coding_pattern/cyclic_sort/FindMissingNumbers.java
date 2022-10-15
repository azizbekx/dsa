package grokking.coding_pattern.cyclic_sort;

import java.util.ArrayList;
import java.util.List;

public class FindMissingNumbers {
    /*
    Time - O(n)
    Space - O(1)
     */
    public static List<Integer> findNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1;
            if (nums[i] != nums[j])
                swap(nums, i, j);
            else
                i++;
        }
        List<Integer> missingNumbers = new ArrayList<>();
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != k + 1)
                missingNumbers.add(k + 1);
        }
        return missingNumbers;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        List<Integer> missing = findNumbers(new int[] { 2, 3, 1, 8, 2, 3, 5, 1 });
        System.out.println("Missing numbers: " + missing);

        missing = findNumbers(new int[] { 2, 4, 1, 2 });
        System.out.println("Missing numbers: " + missing);

        missing = findNumbers(new int[] { 2, 3, 2, 1 });
        System.out.println("Missing numbers: " + missing);
    }
}
