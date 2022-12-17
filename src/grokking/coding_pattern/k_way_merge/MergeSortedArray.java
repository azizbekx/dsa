package grokking.coding_pattern.k_way_merge;

import java.util.Arrays;

public class MergeSortedArray {
    // Tip: You may use some code templates provided
    // in the support file
    public static int[] mergeSorted(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;

        for (int p = m + n - 1; p >= 0; p--) {
            if (p2 < 0)
                break;
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{12, 24, 36, 48, 0, 0};
        int[] arr2 = new int[]{60, 72};
        int m = 4, n = 2;
        System.out.println(Arrays.toString(mergeSorted(arr1, m, arr2, n)));
    }
}
