package grokking.coding_pattern.sliding_window;

import java.util.Arrays;

public class Introduction {
    public static double[] findAveragesO(int K, int[] arr) {
        double[] result = new double[arr.length - K + 1];
        int windowStart = 0;
        double windowSum = 0;

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            windowSum += arr[windowEnd];
            if (windowEnd >= K - 1){
                result[windowStart] = windowSum/K;
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return result;
    }

    public static double[] findAverages(int K, int[] arr) {
        double[] result = new double[arr.length - K + 1];
        for (int i = 0; i < arr.length - K; i++) {
            double sum = 0;
            for (int j = i; j < i + K; j++)
                sum += arr[j];
            result[i] = sum / K;
        }
        return result;

    }
    public static void main(String[] args) {
        double[] result = findAveragesO(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
        System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
    }
}
