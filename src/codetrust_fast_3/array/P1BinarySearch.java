package codetrust_fast_3.array;

public class P1BinarySearch {
    static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(right >= left){
            int mid = (right + left)/2;
            if(nums[mid] == target)
                return nums[mid];
            if(nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1,3,4,5,6,8,9}, 5));

    }
}
