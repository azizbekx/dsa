package grokking.coding_pattern.top_k_elements;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static int findKthLargest(int[] arr, int k) {
        if (arr.length < k)
            return -1;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        for (int i = 0; i < k; i++)
            maxHeap.add(arr[i]);

        for (int i = k; i < arr.length && !maxHeap.isEmpty(); i++) {
            if (maxHeap.peek() < arr[i]) {
                maxHeap.poll();
                maxHeap.add(arr[i]);
            }
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        // Driver code
        int[][] inputs = {
                {1, 5, 12, 2, 11, 9, 7, 30, 20},
                {23, 13, 17, 19, 10},
                {3, 2, 5, 6, 7},
                {1, 4, 6, 0, 2},
                {1, 2, 3, 4, 5, 6, 7}
        };
        int[] K = {3, 4, 5, 1, 7};

        for (int i = 0; i < K.length; i++) {
            System.out.print(i + 1);
            System.out.print(".\tInput array: " + Arrays.toString(inputs[i]));
            System.out.print(", K:  " + K[i]);
            System.out.println("\n\tkth largest element: " + findKthLargest(inputs[i], K[i]));
//            System.out.println(PrintHyphens.repeat("-", 100));
        }
    }
}
