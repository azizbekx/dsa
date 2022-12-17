package grokking.coding_pattern.k_way_merge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementInMatrix {
    /*

    Time - O((n + k) logn)
           O(nlogn) - cost of pushing n elements onto the heap is as follows
           O(n) - cost of n iterating over each row or column in the matrix
           O(klogn) - pop push until find the smallest
    Space - O(nxn)
     */
    public static int kthSmallestElement(int[][] matrix, int k) {
        // storing the number of rows in the matrix to use it in a loop later
        int rowCount = matrix.length;
        // declaring a minheap to keep track of smallest elements
        PriorityQueue<HeapNode> minNumbers = new PriorityQueue<>(
                Comparator.comparingInt(item -> matrix[item.listIndex][item.elementIndex])
        );
        // to check if input matrix is empty
        int[] emptyMatrix = {};
        // if matrix row length is zero, then return 0
        if (matrix[0].length == 0)
            return -1;

        // pushing the first element of each row into the min-heap
        int index = 0;
        while (index < rowCount && index < k) {
            // if any matrix row is an empty list, return -1
            if (Arrays.equals(matrix[index], emptyMatrix))
                return -1;
            minNumbers.add(new HeapNode(0, index));
            index++;
        }

        // when numbersChecked equals k, we'll return smallestElement
        int numbersChecked = 0, smallestElement = 0;
        // iterating over the elements pushed in our minHeap
        while (!minNumbers.isEmpty() && numbersChecked < k) {
            // get the smallest number from top of head and its corresponding row
            HeapNode node = minNumbers.poll();
            smallestElement = matrix[node.listIndex][node.elementIndex];
            node.elementIndex++;
            // if the current row of the top elements has more elements, add the next element
            // of that row to the min-heap
            if (matrix[0].length > node.elementIndex)
                minNumbers.add(node);

            numbersChecked++;
        }
        return smallestElement;
    }

    public static void main(String[] args) {
        int[][][] matrix = {{{2, 6, 8},
                {3, 7, 10},
                {5, 8, 11}},

                {{1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}},

                {{},
                        {}},

                {{1, 1, 3, 8},
                        {5, 5, 7, 9},
                        {3, 5, 8, 12}},

                {{2, 2, 6, 6, 8, 9},
                        {1, 4, 7, 10, 10, 22},
                        {5, 7, 9, 11, 13, 15},
                        {44, 55, 66, 77, 88, 99}}};

        int[] k = {3, 4, 1, 30, 8};
        for (int i = 0; i < k.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tInput matrix: " + Arrays.deepToString(matrix[i]));
            System.out.println("\tK =  " + k[i]);
            System.out.println("\tKth smallest number in the matrix is: " + kthSmallestElement(matrix[i], k[i]));
//                System.out.println(PrintHyphens.repeat("-", 100));
        }

    }

}
