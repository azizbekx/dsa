package code_trust.algorithms.searching_sorting;

public class P1TwoSum {
    public static int[] findSum(int[] arr, int n){
        int[] elements  = new int[2];
        int foundIndex = 0, arrSize= arr.length;

        for (int j : arr) {
            foundIndex = Helper.binarySearch(arr, arrSize, n - j);
            if (foundIndex != -1) {
                elements[0] = j;
                elements[1] = arr[foundIndex];
            }
        }
        return elements;
    }
    public static void main(String[] args) {
        int n = 9;
        int[] arr1 = {2, 4, 5, 7, 8};
        int[] arr2 = findSum(arr1, n);
        int num1 = arr2[0];
        int num2 = arr2[1];

        if ((num1 + num2) != n)
            System.out.println("Results not found!");
        else
            System.out.println("Sum of " + n + " found: " + num1 + " and " + num2);
    }
}
