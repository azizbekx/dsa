package code_trust.data_structures.heap;

import java.util.Arrays;

public class HeapMin {
    /*
    Time  - O(n)
     */
    public void buildMinHeap(int[] heapArr, int heapSize) {
        //swap smallest child to parent node
        for (int i = (heapSize - 1) / 2; i >= 0; i--)
            mindHeapify(heapArr, i, heapSize);
    }

    private void mindHeapify(int[] heapArr, int index, int heapSize) {
        int smallest = index;

        //check parents only
        while (smallest < heapSize / 2) {
            int left = (2 * index) + 1; // left child
            int right = (2 * index) + 2; // right child
            if (left < heapSize && heapArr[left] < heapArr[index]) smallest = left;

            if (right < heapSize && heapArr[right] < heapArr[smallest]) smallest = right;

            //swap parent with the smallest child
            if (smallest != index) {
                int temp = heapArr[index];
                heapArr[index] = heapArr[smallest];
                heapArr[smallest] = temp;
                index = smallest;
            } else break; // if heap property is satisfied
        }// end of while
    }

    public static void main(String[] args) {
        int[] heapArray = {9,4,7,1,-2,6,5};

        System.out.println("Before heapify: " + Arrays.toString(heapArray));
        new HeapMin().buildMinHeap(heapArray, heapArray.length);
        System.out.println("After heapify: " + Arrays.toString(heapArray));

    }
}
