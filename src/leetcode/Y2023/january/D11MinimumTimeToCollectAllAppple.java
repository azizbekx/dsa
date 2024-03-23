package leetcode.Y2023.january;

import java.util.*;

public class D11MinimumTimeToCollectAllAppple {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            adj.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
        }
        return dfs(0, -1, adj, hasApple);
    }

    public int dfs(int node, int parent, Map<Integer, List<Integer>> adj, List<Boolean> hasApple) {
        if (!adj.containsKey(node))
            return 0;
        int totalTime = 0, childTime = 0;
        for (int child : adj.get(node)) {
            if (child == parent)
                continue;
            childTime = dfs(child, node, adj, hasApple);
            // childTime > 0 indicates subtree of child has apples
            // subtree doesnt contribute to the time, even if it has an apple, we have to check
            if (childTime > 0 || hasApple.get(child))
                totalTime += childTime + 2;
        }
        return totalTime;
    }
}
