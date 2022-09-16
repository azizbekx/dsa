package code_trust.algorithms.searching_sorting;

import java.util.Random;

public class Helper {
    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static int choosePivot(int left, int right) {
        Random rand = new Random();
        // Pick 3 random numbers within the range of the array
        int i1 = left + (rand.nextInt(right - left + 1));
        int i2 = left + (rand.nextInt(right - left + 1));
        int i3 = left + (rand.nextInt(right - left + 1));

        // Return their median
        return Math.max(Math.min(i1, i2), Math.min(Math.max(i1, i2), i3));
    }

    public static int partition(int arr[], int left, int right) {
        int pivotInd = choosePivot(left, right); // Index of pivot
        swap(arr, right, pivotInd); // self created function to swap two indices of an array
        int pivot = arr[right]; // Pivot
        int i = (left - 1); // All the elements less than or equal to the
        // pivot go before or at i

        for (int j = left; j <= right - 1; j++) {
            if (arr[j] <= pivot) {
                i++; // increment the index
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right); // Putting the pivot back in place
        return (i + 1);
    }

    public static void quickSort(int arr[], int left, int right) {
        if (left < right) {
            // pi is where the pivot is at
            int pi = partition(arr, left, right);

            // Separately sort elements before and after partition
            quickSort(arr, left, pi - 1);
            quickSort(arr, pi + 1, right);
        }
    }
    static int binarySearch(int arr[], int arrSize, int s) {
        int start = 0;
        int end = arrSize - 1;
        int mid;

        while (start <= end) {
            mid = (end + start) / 2;
            if (arr[mid] < s)
                start = mid + 1;
            else if (arr[mid] > s)
                end = mid - 1;
            else
                return mid;
        }
        return -1;
    }
}