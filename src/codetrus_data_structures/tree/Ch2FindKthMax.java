package codetrus_data_structures.tree;

public class Ch2FindKthMax {
    public static int counter;
    /*
    Time  - O(n)
    Best case when it would be left-skewed time -> O(1)
    Worst case - O(n)
     */
    public static int findKthMaxR(Node root, int k){
        counter = 0;
        Node node = findKthMaxRecursive(root, k);
        if (node != null)
            return node.getData();
        return -1;
    }
    public static Node findKthMaxRecursive(Node root, int k){
        if (root == null)
            return null;
        Node node = findKthMaxRecursive(root.getRightChild(), k);
        if (counter != k){
            counter++;
            node = root;
        }
        if (counter == k){
            return node;
        }else{
            return findKthMaxRecursive(root.getLeftChild(),k);
        }
    }
    /*
    Time - O(n)
    Best case and worst case is the same - O(n)
     */
    public static int findKthMax(Node root, int k){
        StringBuilder result = new StringBuilder();
        inOrderTraversal(root, result);
        String[] arr = result.toString().split(",");
        if ((arr.length - k) >= 0) return Integer.parseInt(arr[arr.length - k]);
        return -1;
    }
    public static void inOrderTraversal(Node root, StringBuilder result){
        if (root.getLeftChild() != null) inOrderTraversal(root.getLeftChild(),result);
        result.append(root.getData()).append(",");
        if (root.getRightChild() != null) inOrderTraversal(root.getRightChild(), result);
    }
    public static void main(String args[]) {

        BinarySearchTree bsT = new BinarySearchTree();

        bsT.add(6);

        bsT.add(4);
        bsT.add(9);
        bsT.add(5);
        bsT.add(2);
        bsT.add(8);

        System.out.println(findKthMaxR(bsT.getRoot(),3));
    }

}
