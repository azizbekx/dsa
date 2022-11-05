package grokking.coding_pattern.tree_depth_first_search;

import grokking.coding_pattern.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class CountPathsForSum {
    /*
    Time - O(N^2), best case -> O(NlogN)
    Space - O(N)
     */
    public static int countPaths(TreeNode root, int S) {
        List<Integer> currentPath = new LinkedList<>();
        return countPathsRecursively(root, S, currentPath);
    }
    private static int countPathsRecursively(TreeNode curNode, int S, List<Integer> currentPath){
        if(curNode == null)
            return 0;

        // add the current node to the path
        currentPath.add(curNode.val);
        int pathCount = 0, pathSum = 0;
        // find the sums of all sub-paths in the current list
        ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());
        while(pathIterator.hasPrevious()){
            pathSum += pathIterator.previous();
            // if the sum of any sub-path is equal to 'S' we increment our path count.
            if(pathSum == S)
                pathCount++;
        }
        // traverse the left sub-tree
        pathCount += countPathsRecursively(curNode.left, S, currentPath);
        // traverse the right sub-tree
        pathCount += countPathsRecursively(curNode.right, S, currentPath);

        // remove the current node from the path to backtrack,
        // we need to remove the current node while we are going up the recursive call stack
        currentPath.remove(currentPath.size()-1);
        return pathCount;


    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + countPaths(root, 11));
    }
}
