package grokking.coding_pattern.tree_depth_first_search;

import grokking.coding_pattern.TreeNode;

public class SumOfPathNumber {
    /*
    Time - O(N)
    Space - O(N)
        N - number of nodes
        This space will be used to store the recursion stack.
        The worst case will happen when the given tree is a linked list
     */
    public static int findSumOfPathNumbers(TreeNode root) {
        return findSumRecursively(root, 0);
    }

    public static int findSumRecursively(TreeNode curNode, int pathSum) {
        if (curNode == null)
            return 0;
        // calculate the path number of the current node
        pathSum = 10 * pathSum + curNode.val;

        // if the current node is a leaf, return the current path sum.
        if (curNode.left == null && curNode.right == null)
            return pathSum;
        // traverse the left and the right sub-tree
        return findSumRecursively(curNode.left, pathSum) +
                findSumRecursively(curNode.right, pathSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + findSumOfPathNumbers(root));
    }
}
