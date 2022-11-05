package grokking.coding_pattern.tree_depth_first_search;

import grokking.coding_pattern.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class CountPathsForSumO {
    /*
    Time - O(N)
    Space - O(N) - This space will be used to store the recursion stack, as well as for the prefix sum.
     */
    public static int countPaths(TreeNode root, int S) {
        // a map that stores the number times a prefix sum has occurred so far.
        Map<Integer, Integer> map = new HashMap<>();
        return countPathsPrefixSum(root, S, map, 0);
    }
    public static int countPathsPrefixSum(TreeNode node, int targetSum,
                                          Map<Integer, Integer> map,
                                          Integer currentPathSum){
        if(node == null)
            return 0;

        // The number of paths that have the required sum;
        int pathCount = 0;

        /*
        'currentPathSum' is the prefix sum, i.e.,
         sum of all node values from root to current node
         */
        currentPathSum += node.val;

        /*
        This is the base case. if the current sum is equal to the target sum, we have found a path
        from root to the current node having the required sum. Hence, we increment the path count by 1
         */
        if(targetSum == currentPathSum)
            pathCount++;

        /*
        'currentPathSum' is the path sum from root to the current node. If within this path, there is a
        valid solution, then there must be an 'oldPathSum' such that:
        => currentPath - oldPathSum = targetSum
        => currentPathSum - targetSum = oldPathSum
        Hence, we can search such an 'oldPathSum' in the map from the key 'currentPathSum - targetSum'.
         */
        pathCount += map.getOrDefault(currentPathSum - targetSum, 0);

        /*
        This is the key step in the algorithm. We are storing the number of time the prefix sum
        'currentPathSum' has occured so far
        */
        map.put(currentPathSum, map.getOrDefault(currentPathSum, 0) + 1);

        // counting the number of paths from the left and right subtrees.
        pathCount += countPathsPrefixSum(node.left, targetSum, map, currentPathSum);
        pathCount += countPathsPrefixSum(node.right, targetSum, map, currentPathSum);
       /*
        Removing the current path sum from the map for backtracking
        'currentPathSum' is the prefix sum to the current node. When we go back (i.e., backtrack), then
        the current node is no more a part of the path, hence, we should remove its prefix sum from the map.
        */
        map.put(currentPathSum, map.getOrDefault(currentPathSum, 1) - 1);

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
