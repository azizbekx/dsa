package grokking.coding_pattern.tree_depth_first_search;

import grokking.coding_pattern.TreeNode;

public class BinaryTreePathSum {
    /*
    Time - O(N) N - number of nodes
    Space - O(N) in worst case, in recursive function
     */
    public static boolean hasPath(TreeNode root, int sum) {
        if(root == null)
            return false;

        // if the current node is a leaf and its value is equal to sum we found path
        if(root.val == sum && root.left == null && root.right == null)
            return true;

        return hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + hasPath(root, 23));
        System.out.println("Tree has path: " + hasPath(root, 16));
    }
}
