package grokking.coding_pattern.fast_and_slow_pointers;

public class P3HappyNumber {
    /*
    Time - O(logN)
    Space - O(1)
     */
    public static boolean find(int num) {
        int fast = num, slow = num;
        do {
            slow = findSquareSum(slow); // move one step
            fast = findSquareSum(findSquareSum(fast)); // move two steps
        }while (fast != slow); // found cycle

        return slow == 1;
    }

    private static int findSquareSum(int num) {
        int sum = 0, digit;
        while(num > 0){
            digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(find(23));
        System.out.println(find(12));
    }
}
