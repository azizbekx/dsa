package grokking.coding_pattern.bitwise_xor;

public class SingleNumber {
    /*
    Time - O(N)
    Space - O(1)
     */
    public static int findSingleNumber(int[] arr) {
        int num = 0;
        for (int j : arr) num = num ^ j;
        return num;
    }
    public static void main( String args[] ) {
        System.out.println(findSingleNumber(new int[]{1, 4, 2, 1, 3, 2, 3}));
    }
}
