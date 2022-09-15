package code_trust.data_structures.tree;

public class Ch1FindMinimum {
    public static int findMin(Node root) {
        if (root == null)
            return -1;
        else if (root.getLeftChild() == null)
            return root.getData();
        else
            return findMin(root.getLeftChild());
    }
}
