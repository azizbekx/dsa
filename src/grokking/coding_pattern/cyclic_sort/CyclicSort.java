package grokking.coding_pattern.cyclic_sort;

public class CyclicSort {
    public static void sort(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int j = nums[i] - 1;
            if(nums[i] != nums[j])
                swap(nums, i, j);
            else
                i++;
        }
    }
    private static void swap(int[] arr, int one, int two){
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }
}
