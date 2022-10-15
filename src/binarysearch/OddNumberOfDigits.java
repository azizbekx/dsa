package binarysearch;

public class OddNumberOfDigits {
    public static int solve(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if ((int)Math.log10(num) % 2 == 0)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[]{2,1}));
    }
}
