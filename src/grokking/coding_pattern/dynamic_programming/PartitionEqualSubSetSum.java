package grokking.coding_pattern.dynamic_programming;

import java.util.Arrays;

/*
n - size of the input array
s - is the sum of the array
Time - O(n*s)
Space - o(n*s)
 */
public class PartitionEqualSubSetSum {
    public static boolean canPartitionArray(int[] arr) {
        int tsum = 0;
        for (int n : arr)
            tsum += n;
        // if total sum is odd, it cannot be partiioned into equal sum subsets
        if (tsum % 2 != 0) return false;
        int ssum = tsum / 2;
        // create a matrix
        boolean[][] matrix = new boolean[ssum + 1][arr.length + 1];

        // initialize the first row as true
        // because each array has a subset whose sum is zero
        for (int i = 0; i < arr.length + 1; i++)
            matrix[0][i] = true;

        // initialize the first column as false (0), except for [0][0] location
        // because an empty array has no subset whose sum is greater than zero
        for (int i = 1; i < ssum + 1; i++)
            matrix[i][0] = false;

        // fill up the 2d matrix in bottom-up manner
        for (int i = 1; i <= ssum; i++) {
            for (int j = 1; j <= arr.length; j++) {
                if (arr[j - 1] > i)
                    matrix[i][j] = matrix[i][j - 1];
                else
                    matrix[i][j] = matrix[i - arr[j - 1]][j - 1] || matrix[i][j - 1];
            }
        }
        System.out.println("\n\t");
        printGrid(matrix);
        return matrix[ssum][arr.length];
    }

    static void printGrid(boolean[][] grid) {
        for (boolean[] booleans : grid) {
            System.out.print("\t\t[");
            for (int j = 0; j < grid[0].length; j++) {
                if (j < grid[0].length - 1)
                    System.out.print("" + booleans[j] + ", ");
                else
                    System.out.print("" + booleans[j] + "");
            }
            System.out.println("]");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 1, 1, 2, 2, 1};
        int[] arr2 = {1, 3, 7, 3};
        int[] arr3 = {1, 2, 3};
        int[] arr4 = {1, 2, 5};
        int[] arr5 = {1, 3, 4, 8};
        int[] arr6 = {1, 2, 3, 2, 3, 5};
        int[] arr7 = {1, 5, 3, 2, 3, 19, 3};
        int[] arr8 = {1, 2, 3, 5, 3, 2, 1};
        int[][] array = {arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8};

        for (int i = 0; i < array.length; i++) {
            System.out.print(i + 1);
            System.out.print(".\tGiven array: " + Arrays.toString(array[i]));
            boolean result = canPartitionArray(array[i]);
            System.out.print("\tCan we partition the array into equal sum arrays?: " + result + "\n");
//            System.out.println(PrintHyphens.repeat("-", 100));

        }

    }
}
