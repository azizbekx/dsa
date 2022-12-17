package grokking.coding_pattern.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class NthTribonacciNumber {
    public static int findTribonacciO(int n) {
        // if n is less than 4, then it's the base case
        if (n < 3)
            return n==0 ? 0 : 1;
        // initializing first three numbers
        int firstNum = 0, secondNum = 1, thirdNum = 1;
        int temp = 0;
        // loops proceeds for n - 2 times
        for (int i = 3; i <= n; i++){
            // temp stores sum of last three computed Tribonacci numbers
            temp = firstNum + secondNum + thirdNum;
            // replace firstNum by secondNum
            firstNum = secondNum;
            // replaces secondNum by thirdNum
            secondNum = thirdNum;
            // replaces thirdNum by sum of last three
            // computed Tribonacci numbers, which are stored in temp
            thirdNum = temp;
        }
        // retrun nth tribonacci Number
        return thirdNum;
    }
    public static int findTribonacci(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(1);
        if (n < 3)
            return list.get(n);
        for (int i = 0; i < n-2; i++){
            list.add(list.get(i) + list.get(i+1) + list.get(i+2));
        }
        return list.get(n);
    }

    public static void main(String[] args) {
        System.out.println(findTribonacci(5));
    }
}
