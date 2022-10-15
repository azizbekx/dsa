package binarysearch;

public class FixedPoint {
    public static int solve(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == mid)
                return mid;
            else if (nums[mid] > mid)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return - 1;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[]{-5, -2, 0, 3, 4}));
    }
}
