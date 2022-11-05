package grokking.coding_pattern.tree_depth_first_search;

import grokking.coding_pattern.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllPathsForSum {
    /*
    Time - O(N^2) N - total number of nodes
    Space - O(NlogN) - O(NlogN) for all path + O(N) for currentPath
            O(N) without allPaths list
     */
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();

        findPathRecursively(root, sum, currentPath, allPaths);
        return allPaths;
    }
    private static void findPathRecursively(TreeNode currentNode, int sum,
                                            List<Integer> currentPath,
                                            List<List<Integer>> allPaths){
        if(currentNode == null)
            return;

        currentPath.add(currentNode.val);
        if(currentNode.val == sum && currentNode.left == null && currentNode.right == null)
            allPaths.add(new ArrayList<>(currentPath));
        else{
            // traverse the left sub-tree
            findPathRecursively(currentNode.left, sum - currentNode.val, currentPath, allPaths);
            // traverse the right sub-tree
            findPathRecursively(currentNode.right, sum - currentNode.val, currentPath, allPaths);
        }

        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
