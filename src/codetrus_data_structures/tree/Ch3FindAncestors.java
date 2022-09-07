package codetrus_data_structures.tree;

public class Ch3FindAncestors {
    public static String findAncestors(Node root, int k) {
        StringBuilder result = new StringBuilder();
        Node current = root;
        while(current != null && current.getData() != k){
            result.append(current.getData()).append(",");
            if (k < current.getData()){
                current = current.getLeftChild();
            }else{
                current = current.getRightChild();
            }
        }
        if (current == null){
            return "";
        }
        return result.toString();
    }
    // Driver code
    public static void main(String[] args)
    {
        BinarySearchTree tree = new BinarySearchTree();
		/* Construct a binary tree like this
				6
			   / \
			  4   9
			 / \  |  \
			2	5 8	  12
					  / \
					 10  14
		*/
        tree.add(6);
        tree.add(4);
        tree.add(9);
        tree.add(2);
        tree.add(5);
        tree.add(8);
        tree.add(8);
        tree.add(12);
        tree.add(10);
        tree.add(14);

        int key = 10;
        System.out.print(key + " --> ");
        System.out.print(findAncestors(tree.getRoot(), key));

        System.out.println();
        key = 5;
        System.out.print(key + " --> ");
        System.out.print(findAncestors(tree.getRoot(), key));
    }
}
