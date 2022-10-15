package code_trust.algorithms.divide_and_conquer;

import java.util.Random;

public class P1EuclidenAlgorithm {
    private static int[] GCDO(int a, int b, int x, int y){
        int[] ans = new int[3];

        if(a == 0){
            ans[0] = b;
            ans[1] = x;
            ans[2] = y;
            return ans;
        }
        int x1 = x, y1 = y;
        ans = GCDO(b % a, a, x1, y1);

        x = ans[2] - (b/a) * ans[1];
        y = ans[1];

        ans[1] = x;
        ans[2] = y;

        return ans;
    }
    /*
    Time - O(log(min(a,b))
     */
    private static int GCD(int a, int b){
        if (a == 0)
            return b;
        return GCD(b % a, a);
    }
    public static void main(String[] args) {
        Random rand = new Random(); // built-in funtion provided by the library java.util.Random in Java for Random Number Generation
        int a = rand.nextInt(50);   // use random inputs
        int b = a * rand.nextInt(10) + rand.nextInt(35);
        System.out.println("GCD(" + a +  " , " + b+ ") = " + GCD(a, b));

        a = (rand.nextInt(150)%50); b = (rand.nextInt(200)%5);   // you can play around with the range of random numbers to see different outputs
        System.out.println("GCD(" + a +  " , " + b+ ") = " + GCD(a, b));

        a = rand.nextInt(10); b = rand.nextInt(10);
        System.out.println("GCD(" + a +  " , " + b+ ") = " + GCD(a, b));

    }
}
