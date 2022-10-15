package grokking.coding_pattern.cyclic_sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindCorruptPair {
    /*
    Time - O(n)
    Space - O(1)
     */
    public static int[] findNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                    return new int[]{nums[j], j + 1};
            }
        }
        return new int[]{-1,-1};
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findNumbers(new int[]{3, 1, 2, 5, 2})));
    }
}
