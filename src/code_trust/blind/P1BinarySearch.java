package code_trust.blind;

public class P1BinarySearch {
    /*
    Time - O(logN)
    Space - O(logN)
     */
    static int binarySearchRec(int[] nums, int target, int low, int high) {
        if (low > high)
            return -1;

        int middle = (low + high) / 2;
        if(nums[middle] == target)
            return middle;
        else if(nums[middle] > target)
            return binarySearchRec(nums, target, middle + 1, high);
        else
            return binarySearchRec(nums, target, low, middle - 1);

    }

    /*
    Time - O(logN)
    Space - O(1)
     */
    static int binarySearchR(int[] nums, int targetSum, int length) {
        return binarySearchRec(nums, targetSum, 0, length - 1);
    }

    static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (right >= left) {
            int mid = (right + left) / 2;
            if (nums[mid] == target)
                return nums[mid];
            if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearchR(new int[]{1, 3, 4, 5, 6, 8, 9}, 5, 7));
    }
}
