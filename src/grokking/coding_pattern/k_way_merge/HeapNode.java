package grokking.coding_pattern.k_way_merge;

public class HeapNode {
    int elementIndex;
    int listIndex;

    HeapNode(int elementIndex, int col) {
        this.elementIndex = elementIndex;
        this.listIndex = col;
    }
}
