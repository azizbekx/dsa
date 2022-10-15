package code_trust.algorithms.divide_and_conquer;

import java.util.Arrays;

public class P5FindClosestNumber {
    public static int closer(int first, int second, int target) {
        if (target - first >= second - target) return second;
        else return first;
    }

    public static int closestNumber(int arr[], int target) {

        int n = arr.length;
        if (target <= arr[0]) return arr[0];
        if (target >= arr[n - 1]) return arr[n - 1];

        int i = 0, j = n, mid = 0;
        while (i < j) {
            mid = (i + j) / 2;

            if (arr[mid] == target)
                return arr[mid];

            // if target is greater than the element at middle, search in the left subarray
            if (target < arr[mid]) {
                if (mid > 0 && target > arr[mid - 1])
                    return closer(arr[mid - 1], arr[mid], target);
                j = mid;

                // if target is greater than the element at middle, search in the right subarray
            } else {
                if (mid < n - 1 && target < arr[mid + 1])
                    return closer(arr[mid], arr[mid + 1], target);
                // search in rest of the right subarray
                i = mid + 1;
            }
        }
        // one element left after search, that must be the closest, return that
        return arr[mid];

    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 4, 5, 6, 6, 8, 9};
        int target = 11;
        System.out.println(Arrays.toString(arr) + "\tTarget = " + target + "  --->   Closest Number = " + closestNumber(arr, target));

        int arr1[] = {3, 5, 7, 9, 11, 17};
        target = 10;
        System.out.println(Arrays.toString(arr1) + "\t\tTarget = " + target + "  --->   Closest Number = " + closestNumber(arr1, target));
    }
}
