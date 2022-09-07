package g_algorithms.search_sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSorting {
    public static int choosePivot(int left, int right) {
        Random rand = new Random();
        // Pick 3 random numbers within the range of the array
        int i1 = left + (rand.nextInt(right - left));
        int i2 = left + (rand.nextInt(right - left));
        int i3 = left + (rand.nextInt(right - left));
        //return their median
        return Math.max(Math.min(i1, i2), Math.min(Math.max(i2, i1), i3));
    }

    public static int partition(int[] arr, int left, int right) {
        int pivotInd = choosePivot(left, right);
        swap(arr, right, pivotInd);
        int pivot = arr[right];
        int i = (left - 1);
        //pivot go berfore or at i

        for (int j = left; j <= right - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, right); // putting the pivot back place
        return (i+1);

    }
    public static void quickSort(int[] arr, int left, int right){
        if (left < right){
            int pi = partition(arr, left, right);
            //separetely sort elements before and after
            quickSort(arr, left, pi-1);
            quickSort(arr, pi+1, right);
        }
    }
    public static void main(String args[]) {
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        int arrSize = 10;
        quickSort(arr, 0, arrSize - 1);
        System.out.print("Sorted array: ");
        System.out.println(Arrays.toString(arr));
    }
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
