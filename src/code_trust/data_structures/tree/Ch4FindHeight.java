package code_trust.data_structures.tree;

public class Ch4FindHeight {
    public static int findHeight(Node root){
        if (root == null) return -1;
        else
            return 1+Math.max(findHeight(root.getLeftChild()), findHeight(root.getRightChild()));
    }
}
