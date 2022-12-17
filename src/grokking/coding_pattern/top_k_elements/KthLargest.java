package grokking.coding_pattern.top_k_elements;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

class KthLargest {
    public int k;
    public PriorityQueue<Integer> topKHeap;
    private String printHeapWithMarkers(PriorityQueue<Integer> arr, int pvalue) {
        String out = "[";
        Iterator value = arr.iterator();
        for (int i = 0; i<arr.size(); i++) {
            if (pvalue == i) {
                out += '«';
                out += value.next().toString() + '»' + ", ";
            } else if (i != arr.size() - 1)
                out += value.next().toString() + ", ";
            else
                out += value.next().toString();
        }
        out += "]";
        return out;
    }
    // constructor to initialize topKHeap and add values in it
    public KthLargest(int k, int[] nums) {
        System.out.println("\tInitializing the topKHeap");
        this.k = k;
        topKHeap = new PriorityQueue<Integer> ();
        for (int num: nums) {
            topKHeap.offer(num);
        }
        System.out.println("\t\tk = " + this.k);
        System.out.println("\t\tHeap: " + this.topKHeap);
        while (topKHeap.size() > k) {
            System.out.println("\t\tLength of the topKHeap = " + this.topKHeap.size() + ", which is greater than k = " + k);
            System.out.print("\t\t\tPopping from the topKHeap: " + this.topKHeap + " ⟶ ");
            topKHeap.poll();
            System.out.println(this.topKHeap);
        }
    }
    // adds element in the topKHeap
    public int add(int val) {
        System.out.print("\t\tAdding " + val + " to the topKHeap: " + this.topKHeap + " ⟶ ");
        topKHeap.offer(val);
        System.out.println(this.topKHeap);
        if (topKHeap.size() > k) {
            System.out.println("\t\tHeap size = " + this.topKHeap.size());
            System.out.println("\t\tk = " + this.k);
            System.out.print("\t\tSince topKHeap size > k, popping from the topKHeap: " + printHeapWithMarkers(this.topKHeap, 0) + " ⟶ ");
            topKHeap.poll();
            System.out.println(this.topKHeap + "\n");
        }
        return returnKthLargest();
    }
    // returns kth largest element from topKHeap
    public int returnKthLargest() {
        System.out.println("\tHeap: " + printHeapWithMarkers(this.topKHeap, 0));
        return this.topKHeap.peek();
    }
    public static void main(String args[]) {
        int[] nums = { 3, 6, 9, 10 };
        int[] temp = { 3, 6, 9, 10 };
        System.out.println("Initial stream: " + Arrays.toString(nums));
        KthLargest kLargest = new KthLargest(3, nums);
        int[] val = { 4, 7, 10, 8, 15 };
        System.out.println();
        for (int i = 0; i<val.length; i++) {
            System.out.println("\tAdding a new number " + val[i] + " to the stream");
            temp = Arrays.copyOf(temp, temp.length + 1);
            temp[temp.length - 1] = val[i];
            System.out.println("\t\tNumber stream: " + Arrays.toString(temp));
            System.out.println("\tKth largest element in the stream: " + kLargest.add(val[i]));

//            System.out.println(PrintHyphens.repeat("-", 100));
        }
    }
}