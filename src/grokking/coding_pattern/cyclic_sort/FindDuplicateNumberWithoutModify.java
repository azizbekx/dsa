package grokking.coding_pattern.cyclic_sort;

public class FindDuplicateNumberWithoutModify {
    /*
    Time - O(n)
    Space - O(1)
     */
    public static int findDuplicate(int[] nums){
        int slow = 0, fast = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        int currLen = 0;
        int curr = nums[slow];
        do{
            curr = nums[curr];
            currLen++;
        }while(curr != nums[slow]);

        return findStart(nums, currLen);
    }
    public static int findStart(int[] arr, int len){
        int pointer1 = arr[0], pointer2 = arr[0];
        while(len > 0){
            pointer2 = arr[pointer2];
            len--;
        }
        while(pointer1 != pointer2){
            pointer1 = arr[pointer1];
            pointer2 = arr[pointer2];
        }
        return pointer1;
    }
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[] { 1, 4, 4, 3, 2 }));
        System.out.println(findDuplicate(new int[] { 2, 1, 3, 3, 5, 4 }));
        System.out.println(findDuplicate(new int[] { 2, 4, 1, 4, 4 }));
    }
}
