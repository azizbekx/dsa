package code_trust.algorithms.searching_sorting;

import java.util.Arrays;
import java.util.Random;

public class P10DuetchFlag {
    public static void dutchNationalFlagO(int[] arr) {
        int l = 0;
        int mid = 0;
        int r = arr.length - 1;
        while (mid <= r) {
            //if value at mid equals to zero
            if (arr[mid] == 0)
                swap(arr, l++, mid++);
            else if (arr[mid] == 2)
                swap(arr, mid, r--);
            else if (arr[mid] == 1)
                mid++;
        }
    }

    public static void dutchNationalFlag(int[] arr) {
        quicksort(arr);
        System.out.print("None");
    }

    private static void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    private static void quicksort(int[] arr, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = arr[pivotIndex];
        int leftPointer = partition(arr, lowIndex, highIndex, pivot);

        quicksort(arr, lowIndex, leftPointer - 1);
        quicksort(arr, leftPointer + 1, highIndex);
    }

    private static int partition(int[] arr, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {
            while (arr[leftPointer] <= pivot && leftPointer < rightPointer)
                leftPointer++;
            while (arr[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(arr, leftPointer, rightPointer);
        }
        swap(arr, leftPointer, highIndex);
        return leftPointer;
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String args[])
    {
        int[] arr = {2, 0, 0, 1, 2, 1};
        dutchNationalFlagO(arr);
        System.out.println(Arrays.toString(arr)); // import java.util.Arrays; for this functionality
    }
}
