package code_trust.algorithms.divide_and_conquer;

import java.util.Arrays;

public class P2PeekElement {
    public static int findPeakO(int[] arr) {
        int n = arr.length;
        return findPeakRecursive(0, n - 1, n, arr);
    }

    private static int findPeakRecursive(int low, int high, int size, int[] arr) {
        int middle = low + (high - low) / 2;
        if ((middle == size - 1 || arr[middle + 1] <= arr[middle]) && (middle == 0 || arr[middle - 1] <= arr[middle]))
            return middle;
        else if (arr[middle - 1] > arr[middle] && middle > 0) return findPeakRecursive(low, middle - 1, size, arr);
        else return findPeakRecursive(middle + 1, high, size, arr);
    }

    public static int findPeak(int arr[]) {
        // calculating array length
        int len = arr.length;
        if (len == 0) return -1;
        if (len == 1) return arr[0];
        if (arr[0] > arr[1]) return arr[0];

        //traversing array
        for (int i = 1; i < len - 1; i++) {
            //if current value is greater than previous and the next value return it
            if ((arr[i] >= arr[i - 1]) & (arr[i] >= arr[i + 1])) return arr[i];
        }
        if (arr[len - 1] >= arr[len - 2]) return arr[len - 1];
        return -1;
    }

    public static void main(String args[]) {
        // A 2D array to store integer input arrays
        int[][] inputs = {{7, 11, 22, 13, 4, 0}, {13, 27, 54, 11, 99, 1}, {0, 1, 2, 3, 4, 5}, {10, 9, 8, 7, 6}};

        int peak = 0; // variable to store the peak value for each input array

        for (int i = 0; i < inputs.length; i++) {
            peak = findPeakO(inputs[i]);
            if (i == 2)
                System.out.println("Input Array: " + Arrays.toString(inputs[i]) + " ----> Peak = \"" + inputs[i][peak] + "\"\t\t (Ascending Order - Peak = Last Element)\n");
            else if (i == 3)
                System.out.println("Input Array: " + Arrays.toString(inputs[i]) + " ----> Peak = \"" + inputs[i][peak] + "\"\t\t(Descending Order - Peak = First Element)\n");
            else
                System.out.println("Input Array: " + Arrays.toString(inputs[i]) + " ----> Peak = \"" + inputs[i][peak] + "\"\n");

        }

    }
}
