package grokking.coding_pattern.k_way_merge;

import java.util.*;

public class FindKPairs {
    public static List<List<Integer>> kSmallestPairs(int[] list1, int[] list2, int k) {
        // storing the length of lists to use it in a look later
        int listLength = list1.length;
        // declaring a minHeap to keep track of the smallest sum
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(i -> (i.get(0) + i.get(1)))
        );
        // to store the pairs with smallest sums
        List<List<Integer>> pairs = new ArrayList<>();
        // iterate over the length of list 1
        int i = 0;
        while (i < Math.min(listLength, k)) {
            // computing sum of pairs all elements of lists1 with first index
            // of list2 and placing it in the min-heap
            minHeap.add(new ArrayList<>(Arrays.asList(list1[i], list2[0], 0)));
            i++;
        }
        int counter = 1;
        // iterate over elements of min-heap and only go upto k
        while (!minHeap.isEmpty() && counter <= k) {
            List<Integer> cur = minHeap.poll();
            // add pairs with the smallest sum in the new list
            pairs.add(new ArrayList<>(Arrays.asList(cur.get(0) + cur.get(1))));

            // increment the index for 2nd list, as we've
            // compared all possible pairs with the 1st index of list2
            int nextElement = cur.get(2) + 1;
            // if next element is available for list2 then add it to the heap
            if (nextElement < list2.length)
                minHeap.offer(new ArrayList<>(Arrays.asList(cur.get(0), list2[nextElement], nextElement)));

            counter++;
        }
        return pairs;
    }

    public static void main(String[] args) {

        int[][] list1 = {{2, 8, 9},
                {1, 2, 300},
                {1, 1, 2},
                {4, 6},
                {4, 7, 9},
                {1, 1, 2}
        };

        int[][] list2 = {
                {1, 3, 6},
                {1, 11, 20, 35, 300},
                {1, 2, 3},
                {2, 3},
                {4, 7, 9},
                {1}
        };
        int[] k = {9, 30, 1, 2, 5, 4};
        for (int i = 0; i < k.length; i++) {
            List<List<Integer>> result = kSmallestPairs(list1[i], list2[i], k[i]);
            System.out.print(i + 1);
            System.out.println(".\tInput lists: " + Arrays.toString(list1[i]) + ", " + Arrays.toString(list2[i]));
            System.out.println("\tK = " + k[i]);
            System.out.print("\tPairs with smallest sum are: " + result);
            System.out.println("\n");
//            System.out.println(PrintHyphens.repeat("-", 100));
        }

    }

}
