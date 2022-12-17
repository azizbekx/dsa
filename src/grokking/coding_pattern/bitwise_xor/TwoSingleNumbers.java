package grokking.coding_pattern.bitwise_xor;

import java.util.Arrays;

public class TwoSingleNumbers {
    /*
    Time - O(n)
    Space - O(1)
     */
    public static int[] twoSingleNumbers(int[] nums) {
        int bitwise = 0;
        for (int i : nums)
            bitwise ^= i;
        // the least significant bit can be found with number ^ (-number)
        int bitmask = bitwise & (-bitwise);
        // divide into two groups of numbers, here we want the group with bit set
        // which results in one of the numbers we want due to the property X^X = 0
        int result = 0;
        for (int i : nums)
            if ((bitmask & i) == 0)
                result = result ^ i;

        int[] res = new int[2];
        res[0] = result;
        res[1] = bitwise ^ result;

        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 2, 3},
                {4, 4, 3, 2, 3, 5},
                {1, 1, 7, 4, 5, 5, 8, 8},
                {1, 0},
                {9, 8, 8, 7, 6, 6, 4, 4}
        };
        for (int i = 0; i < arr.length; i++) {
            int[] result = twoSingleNumbers(arr[i]);
            System.out.print(i + 1 + ".\tInput list:" + Arrays.toString(arr[i]));
            System.out.print("\n\tTwo Singles numbers in a list: ");
            System.out.println(Arrays.toString(result));
//            System.out.println(PrintHyphens.repeat("-", 100));
        }

    }
}
