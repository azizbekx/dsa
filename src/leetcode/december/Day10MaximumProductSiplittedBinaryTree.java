package leetcode.december;

import grokking.coding_pattern.TreeNode;

public class Day10MaximumProductSiplittedBinaryTree {
    long res = 0, total = 0, sub;
    public int maxProduct(TreeNode root) {
        total = s(root);
        return (int)(res % (int)(1e9+1));
    }
    private long s(TreeNode root){
        if (root == null) return 0;
        sub = root.val + s(root.left) + s(root.right);
        res = Math.max(res, sub * (total-sub));
        return sub;
    }
}
