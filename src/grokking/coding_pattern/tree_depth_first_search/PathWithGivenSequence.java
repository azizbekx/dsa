package grokking.coding_pattern.tree_depth_first_search;

import grokking.coding_pattern.TreeNode;

public class PathWithGivenSequence {
    /*
    Time - O(N)
    Space - O(N)
     */
    public static boolean findPath(TreeNode root, int[] sequence) {
        if(root == null)
            return sequence.length == 0;
        return dfs(root, sequence, 0);
    }
    public static boolean dfs(TreeNode curNode, int[] seq, int seqIndex ){
        if(curNode == null)
            return false;

        if(seqIndex >= seq.length || curNode.val != seq[seqIndex])
            return false;

        // if the current node is a leaf, add it is the end of the seq we found that
        if(curNode.left == null && curNode.right == null && seqIndex == seq.length - 1)
            return true;

        // return true if any of the two recursive call return true
        return dfs(curNode.left, seq, seqIndex + 1)
                || dfs(curNode.right, seq, seqIndex + 1);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
    }
}
