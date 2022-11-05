package grokking.coding_pattern.subsets;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class UniqueTrees {
    public static List<TreeNode> findUniqueTrees(int n) {
        if (n <= 0)
            return new ArrayList<TreeNode>();
        // TODO: Write your code here
        return findUniqueRecursive(1, n);
    }

    private static List<TreeNode> findUniqueRecursive(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        // base condition, return 'null' for an empty sub-tree
        // consider n=1, in this case we will have start=end=1, this means we should have only one tree
        // we will have two recursive calls, findUniqueTreesRecursive(1, 0) & (2, 1)
        // both of these should return 'null' for the left and the right child
        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubTrees = findUniqueRecursive(start, i - 1);
            List<TreeNode> rightSubTrees = findUniqueRecursive(i + 1, end);
            for(TreeNode leftTree : leftSubTrees){
                for(TreeNode rightTree : rightSubTrees){
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.right = rightTree;
                    treeNode.left = leftTree;
                    result.add(treeNode);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<TreeNode> result = UniqueTrees.findUniqueTrees(3);
        System.out.print("Total trees: " + result.size());
    }
}
