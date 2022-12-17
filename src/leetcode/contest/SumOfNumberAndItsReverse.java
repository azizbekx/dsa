package leetcode.contest;

public class SumOfNumberAndItsReverse {
    public static boolean sumOfNumberAndReverse(int num) {
        for (int i = num; i > num / 2; i--) {
            int n = i;
            int reverse = 0;
            while (n != 0) {
                int remainder = n % 10;
                reverse = reverse * 10 + remainder;
                n /= 10;
            }
            if (reverse + n == num)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(sumOfNumberAndReverse(63));
    }
}
