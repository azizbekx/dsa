package grokking.coding_pattern.tree_depth_first_search;

import grokking.coding_pattern.TreeNode;

public class TreeDiameter {
    private static int treeDiameter = 0;
    /*
    Time - O(N)
    Space - O(N)
     */
    public static int findDiameter(TreeNode root){
        calculateHeight(root);
        return treeDiameter;
    }
    public static int calculateHeight(TreeNode node){
        if(node == null)
            return 0;

        int leftTreeHeight = calculateHeight(node.left);
        int rightTreeHeight = calculateHeight(node.right);

        // if the current node doesn't have a left or right subtree, we can't have
        // a path passing through it, since we need a lead node on each side
        if(leftTreeHeight != 0 && rightTreeHeight != 0){
            // diameter at eh current node will be equal to the height of left subtree +
            // the height of right subtrees + '1' for the current node
            int diameter = leftTreeHeight + rightTreeHeight + 1;
            // update the global tree diameter
            treeDiameter = Math.max(treeDiameter, diameter);
        }
        // height of the current node will be equal to the maximum of the heights of
        // left or right subtrees plus '1'for the current node
        return Math.max(leftTreeHeight, rightTreeHeight) + 1;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
        root.left.left = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
    }
}
