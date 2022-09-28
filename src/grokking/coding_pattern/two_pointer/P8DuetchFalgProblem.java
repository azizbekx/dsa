package grokking.coding_pattern.two_pointer;

public class P8DuetchFalgProblem {
    /*
    Time - O(n)
    Space - O(1)
     */
    public static void sort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int mid = (left + right) / 2;
        while (mid <= right) {
            if (arr[mid] == 2) swap(arr, mid, right--);
            else if (arr[mid] == 0) swap(arr, left++, mid);
            else mid++;

        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
