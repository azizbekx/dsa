package grokking.coding_pattern.cyclic_sort;

public class FindMissingNumber {
    /*
    Time  - O(n) -> O(n) + O(N-1) + O(N)
    Space - O(1)
     */
    public static int findMissingNumber(int[] nums){
        int i = 0;
        while(i< nums.length){
            if(nums[i] < nums.length && nums[i] != nums[nums[i]])
                swap(nums, i, nums[i]);
            else
                i++;
        }
        for(int j=0; j<nums.length; j++){
            if (nums[j] != j)
                return j;
        }
        return nums.length;
    }
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(findMissingNumber(new int[] { 4, 0, 3, 1 }));
        System.out.println(findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
    }
}
