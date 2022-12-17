package grokking.coding_pattern.k_way_merge;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static LinkedListNode mergeKLists(List<LinkedList> lists) {
        LinkedList result = new LinkedList();
        PriorityQueue<LinkedListNode> maxHeap = new PriorityQueue<>(
                (i1, i2) -> (i2.data - i1.data)
//                Comparator.comparingInt(item -> (item.head.data))
        );
        // Your code will replace this placeholder return statement
        for (LinkedList linkedList : lists) {
            LinkedListNode cur = linkedList.head;
            while (cur != null) {
                maxHeap.add(cur);
                cur = cur.next;
            }
        }
        while (!maxHeap.isEmpty()){
            result.insertNodeAtHead(maxHeap.poll());
        }
        return result.head;
    }
}
