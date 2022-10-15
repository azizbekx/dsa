package grokking.book;

public class Ch3QuickSort {
    public static void quickSort(int[] arr){

    }
    public static int sumRecursive(int[] arr, int index, int max){
        if (index >= arr.length) return max;
        max = Math.max(max, arr[index]);
        return sumRecursive(arr, index + 1, max);
    }

    public static void main(String[] args) {
        System.out.println(sumRecursive(new int[]{1,2,3,4,5,6}, 0, Integer.MIN_VALUE));
    }
}
