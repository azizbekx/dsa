package grokking.coding_pattern.tree_breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;



public class ConnectLevelOrderSibling {
    /*
    Time - O(N)
    Space - O(1)
     */

    public static void connect(TreeNodeN root) {
        if (root == null)
            return;

        Queue<TreeNodeN> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNodeN prevNode = null;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNodeN currentNode = queue.poll();
                if (prevNode != null)
                    prevNode.next = currentNode;
                prevNode = currentNode;

                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNodeN root = new TreeNodeN(12);
        root.left = new TreeNodeN(7);
        root.right = new TreeNodeN(1);
        root.left.left = new TreeNodeN(9);
        root.right.left = new TreeNodeN(10);
        root.right.right = new TreeNodeN(5);
        connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }


}
