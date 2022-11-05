package grokking.coding_pattern.tree_breadth_first_search;

import java.util.*;


public class ConnectAllLevelOrder {
    /*
    Time - O(N)
    Space - O(N)
     */
    public static void connectO(TreeNodeN root) {
        if (root == null)
            return;

        Queue<TreeNodeN> queue = new LinkedList<>();
        queue.offer(root);
        TreeNodeN currentNode = null, previousNode = null;
        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            if (previousNode != null)
                previousNode.next = currentNode;
            previousNode = currentNode;

            // insert the children of current node in the queue
            if (currentNode.left != null)
                queue.offer(currentNode.left);
            if (currentNode.right != null)
                queue.offer(currentNode.right);
        }
    }

    public static void connect(TreeNodeN root) {
        if (root == null)
            return;

        Queue<TreeNodeN> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNodeN prevNode = null;
            for (int i = 0; i < levelSize; i++) {
                TreeNodeN currNode = queue.poll();
                if (prevNode != null)
                    prevNode.next = currNode;
                prevNode = currNode;
                if (currNode.left != null)
                    queue.add(currNode.left);
                if (currNode.right != null)
                    queue.add(currNode.right);
            }
            prevNode.next = queue.peek();
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

        // level order traversal using 'next' pointer
        TreeNodeN current = root;
        System.out.println("Traversal using 'next' pointer: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}

