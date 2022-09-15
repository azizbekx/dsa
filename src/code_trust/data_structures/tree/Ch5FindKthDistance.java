package code_trust.data_structures.tree;

public class Ch5FindKthDistance {
    public static int d = 0;
    public static String findKNodes(Node root, int k) {
        StringBuilder result = new StringBuilder();
        result = findK(root,k, result);
        return result.toString();
    }

    private static StringBuilder findK(Node root, int k, StringBuilder result) {
        if (root == null) return null;
        if (k==0){
            result.append(root.getData()).append(",");
        }else{
            findK(root.getLeftChild(), k-1, result);
            findK(root.getRightChild(), k-1, result);
        }
        return result;
    }

}
