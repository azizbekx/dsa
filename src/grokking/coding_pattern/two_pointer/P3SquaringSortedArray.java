package grokking.coding_pattern.two_pointer;

import java.util.Arrays;

public class P3SquaringSortedArray {
    /*
    Time - O(n)
    Space - O(n)
     */
    public static int[] makeSquaresO(int[] arr){
        int n = arr.length;
        int[] squares = new int[n];
        int highestSquareIndex = n - 1;
        int left = 0, right = n-1;
        while (left <= right){
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];

            if (leftSquare > rightSquare){
                squares[highestSquareIndex--] = leftSquare;
                left++;
            }else{
                squares[highestSquareIndex--] = rightSquare;
                right--;
            }
        }
        return squares;
    }
    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];

        int middle = (arr.length - 1) / 2;
        int left = middle - 1;
        int right = middle + 1;
        squares[0] = arr[middle];
        for (int i = 1; i < arr.length; i++) {
            int powLeft = left > -1 ? arr[left] * arr[left] : Integer.MAX_VALUE;
            int powRight = right < arr.length ? arr[right] * arr[right] : Integer.MAX_VALUE;
            if (powLeft < powRight) {
                squares[i] = powLeft;
                left--;
            } else {
                squares[i] = powRight;
                right++;
            }
        }
        return squares;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(makeSquares(new int[]{-3, -1, 0, 1, 2})));
    }
}
