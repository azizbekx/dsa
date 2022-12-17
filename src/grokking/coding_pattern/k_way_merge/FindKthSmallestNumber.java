package grokking.coding_pattern.k_way_merge;

import java.util.*;

public class FindKthSmallestNumber {
    public static int findKthSmallest(List<Integer[]> lists, int k){
        int listLen = lists.size();
        PriorityQueue<HeapNode> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(item -> lists.get(item.listIndex)[item.elementIndex]));

        int index = 0;
        while (index  < listLen) {
            if (lists.get(index).length == 0) {
                index++;
                continue;
            } else {
                minHeap.add(new HeapNode(0, index));
            }
            index++;
        }

        int numbersChecked = 0, smallestNumber = 0;
        while (!minHeap.isEmpty() && numbersChecked < k) {
            HeapNode node = minHeap.poll();
            smallestNumber = lists.get(node.listIndex)[node.elementIndex];
            node.elementIndex++;

            if (lists.get(node.listIndex).length > node.elementIndex)
                minHeap.add(node);

            numbersChecked++;
        }
        return smallestNumber;
    }
    /*
    n - total number of m sorted list
    k - most k elements
    m - number of sorted lists
    Time - O(klogm)
    Space - O(n)
     */
    public static int findKthSmallestO(List<Integer[]> lists, int k) {
        // storing the length of lists to use it in a loop later
        int listLength = lists.size();
        // declaring a min-heap to keep track of smallest elements
        PriorityQueue<HeapNode> minHeap = new PriorityQueue<HeapNode>(
                Comparator.comparingInt(item -> lists.get(item.listIndex)[item.elementIndex]));

        // put the 1st element of each array in the min heap
        int index = 0;
        while(index < listLength){
            // if there are no elements in the input lists, return -1
            if (lists.get(index).length == 0){
                index++;
                continue;
            }
            else{
                minHeap.add(new HeapNode(0, index));
            }
            index++;
        }

        // set a counter to match if our kth element
        // equals to that counter, return that number
        int numbersChecked = 0, smallestNumber = 0;
        // iterating over the elements pushed in our min-heap
        while (!minHeap.isEmpty() && numbersChecked < k) {
            // get the smallest number from top of heap and its corresponding list
            HeapNode node = minHeap.poll();
            smallestNumber = lists.get(node.listIndex)[node.elementIndex];
            node.elementIndex++;
            // if there are more elements in list of the top element,
            // add the next element of that list to the minHeap
            if (lists.get(node.listIndex).length > node.elementIndex)
                minHeap.add(node);

            numbersChecked++;
        }
        // return the Kth number found in input lists
        return smallestNumber;
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 2, 6, 8 };
        Integer[] l2 = new Integer[] { 3, 6, 10 };
        Integer[] l3 = new Integer[] { 5, 8, 11};
        int k = 5;
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        System.out.println("1.\tInput lists: ["+Arrays.toString(lists.get(0))+Arrays.toString(lists.get(1))+Arrays.toString(lists.get(2)) + "]");
        int result = FindKthSmallestNumber.findKthSmallest(lists, k);
        System.out.println("\tK: "+ k);
        System.out.println("\t" + k+ "th smallest number from the lists is: " + result);

//        System.out.println(PrintHyphens.repeat("-", 100));
        // 2nd
        Integer[] l11 = new Integer[] { 1, 2, 3};
        Integer[] l21 = new Integer[] { 4, 5};
        Integer[] l31 = new Integer[] {6, 7, 8, 15};
        Integer[] l41 = new Integer[] {10, 11, 12, 13};
        Integer[] l51 = new Integer[] {5, 10};

        k = 50;
        List<Integer[]> lists1 = new ArrayList<Integer[]>();
        lists1.add(l11);
        lists1.add(l21);
        lists1.add(l31);
        lists1.add(l41);
        lists1.add(l51);
        System.out.println("2.\tInput lists: ["+Arrays.toString(lists1.get(0))+Arrays.toString(lists1.get(1))+Arrays.toString(lists1.get(2))+Arrays.toString(lists1.get(3))+ Arrays.toString(lists1.get(4)) + "]");
        result = FindKthSmallestNumber.findKthSmallest(lists1, k);
        System.out.println("\tK: "+ k);
        System.out.println("\t" + k+ "th smallest number from the lists is: " + result);

//        System.out.println(PrintHyphens.repeat("-", 100));
        // 3rd
        Integer[] l111 = new Integer[] {};
        Integer[] l211 = new Integer[] {};
        Integer[] l311 = new Integer[] {};

        k = 4;
        List<Integer[]> lists2 = new ArrayList<Integer[]>();
        lists2.add(l111);
        lists2.add(l211);
        lists2.add(l311);
        System.out.println("3.\tInput lists: ["+Arrays.toString(lists2.get(0))+Arrays.toString(lists2.get(1))+Arrays.toString(lists2.get(2))+ "]");
        result = FindKthSmallestNumber.findKthSmallest(lists2, k);
        System.out.println("\tK: "+ k);
        System.out.println("\t" + k+ "th smallest number from the lists is: " + result);
//        System.out.println(PrintHyphens.repeat("-", 100));
        // 4th
        Integer[] l1111 = new Integer[] {1, 1, 3, 8};
        Integer[] l2111 = new Integer[] {5, 5, 7, 9};
        Integer[] l3111 = new Integer[] {3, 5, 8, 12};

        k = 4;
        List<Integer[]> lists3 = new ArrayList<Integer[]>();
        lists3.add(l1111);
        lists3.add(l2111);
        lists3.add(l3111);
        System.out.println("4.\tInput lists: ["+Arrays.toString(lists3.get(0))+Arrays.toString(lists3.get(1))+Arrays.toString(lists3.get(2))+ "]");
        result = FindKthSmallestNumber.findKthSmallest(lists3, k);
        System.out.println("\tK: "+ k);
        System.out.println("\t" + k+ "th smallest number from the lists is: " + result);
//        System.out.println(PrintHyphens.repeat("-", 100));
        // 5th
        Integer[] l11111 = new Integer[] {5, 8, 9, 17};
        Integer[] l21111 = new Integer[] { };
        Integer[] l31111 = new Integer[] {21, 22, 23, 24};

        k = 8;
        List<Integer[]> lists4 = new ArrayList<Integer[]>();
        lists4.add(l11111);
        lists4.add(l21111);
        lists4.add(l31111);
        System.out.println("5.\tInput lists: ["+ Arrays.toString(lists4.get(0))+Arrays.toString(lists4.get(1))+Arrays.toString(lists4.get(2))+ "]");
        result = FindKthSmallestNumber.findKthSmallest(lists4, k);
        System.out.println("\tK: "+ k);
        System.out.println("\t" + k+ "th smallest number from the lists is: " + result);

    }
}
