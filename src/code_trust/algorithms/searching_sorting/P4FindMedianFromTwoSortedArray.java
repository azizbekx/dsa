package code_trust.algorithms.searching_sorting;

import java.util.Arrays;

public class P4FindMedianFromTwoSortedArray {
    public static double getMedian(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            return getMedian(nums2, nums1);
        }

        int total = m + n;
        int half = (total + 1) / 2;
        int left = 0;
        int right = m;
        double result = 0.0;

        while (left <= right) {
            int i = left + (right - left) / 2;
            int j = half - i;

            //get the four points around possible median
            int left1 = (i > 0) ? nums1[i - 1] : Integer.MIN_VALUE;
            int right1 = (i < m) ? nums1[i] : Integer.MAX_VALUE;
            int left2 = (j > 0) ? nums2[j - 1] : Integer.MIN_VALUE;
            int right2 = (j < n) ? nums2[j] : Integer.MAX_VALUE;

            //partition is correct
            if (left1 <= right2 && left2 <= right1) {
                //even
                if (total % 2 == 0) {
                    result = (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                    //odd
                } else {
                    result = Math.max(left1, left2);
                }
                break;
            }
            // partition is wrong (update left / right pointers)
            else if (left1 > right2)
                right = i - 1;
            else
                left = i + 1;
        }
        return result;

    }

    public static double getMedianO(int[] arr1, int[] arr2) {
        int size1 = arr1.length;
        int size2 = arr2.length;
        int end_index = size1;
        int start_index = 0, i = 0, j = 0, median = 0;

        while (start_index <= end_index) {
            i = (start_index + end_index) / 2;
            j = ((size1 + size2 + 1) / 2) - i;

            if (i < size1 && j > 0 && arr2[j - 1] > arr1[i]) start_index = i + 1;

            else if (i > 0 && j < size2 && arr2[j] < arr1[i - 1]) end_index = i - 1;

            else {
                if (i == 0) median = arr2[j - 1];
                else if (j == 0) median = arr1[i - 1];
                else median = Math.max(arr1[i - 1], arr2[j - 1]);
                break;
            }
        }
        if ((size1 + size2) % 2 == 1) return median;

        if (i == size1) return (median + arr2[j]) / 2.0;

        if (j == size2) return (median + arr1[i]) / 2.0;

        return (median + Math.min(arr1[i], arr2[j])) / 2.0;
    }


    public static double getMedianBF(int[] arr1, int[] arr2) {
        int sizeOfArr1 = arr1.length;
        int sizeOfArr2 = arr2.length;
        int arrSize = sizeOfArr1 + sizeOfArr2;
        int arraySizeMid = arrSize / 2;

        int i = 0;
        int j = 0;
        int count;

        int median = -1;
        int previousMedian = -1;

        for (count = 0; count <= arraySizeMid; count++) {
            // For even elements, we need to take the average of two medians and for that we are storing previous median
            previousMedian = median;
            if (i != sizeOfArr1 && j != sizeOfArr2) {
                if (arr1[i] > arr2[j]) {
                    median = arr2[j];
                    j++;
                } else {
                    median = arr1[i];
                }
            } else if (i < sizeOfArr1) {
                median = arr1[i];
                i++;
            } else {
                median = arr2[j];
                j++;
            }
        }
        // if the total size of the two arrays is odd
        if (arrSize % 2 == 1) {
            return median;
        } else {
            return (median + previousMedian) / 2.0;
        }
    }

    public static void main(String args[]) {
        int array1[] = {4, 5, 7, 10};
        int array2[] = {12, 13, 15, 18, 20, 24};

        System.out.println("The median of " + Arrays.toString(array1) + " and " + Arrays.toString(array2) + " is " + getMedian(array1, array2));

        // Example 2
        int array3[] = {1, 2, 3, 4, 5};
        int array4[] = {100, 200, 300, 400};

        System.out.println("The median of " + Arrays.toString(array3) + " and " + Arrays.toString(array4) + " is " + getMedian(array3, array4));
    }
}
