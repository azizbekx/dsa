package grokking.coding_pattern.subsets;

import java.util.HashMap;
import java.util.Map;

public class CountUniqueTrees {
    /*
    Memoized version
    Time - O(N^2)
    Space - O(N)
     */
    Map<Integer, Integer> map = new HashMap<>();
    public int countTreesM(int n){
        if(map.containsKey(n))
            return map.get(n);
        if(n <= 1)
            return 1;
        int count = 0;
        for(int i = 1; i <= n; i++){
            // making 'i' root of the tree
            int countLeftOfTree = countTreesM(i - 1);
            int countRightOfTree = countTreesM(n - i);
            count += (countLeftOfTree * countRightOfTree);
        }
        map.put(n, count);
        return count;
    }
    public int countTrees(int n) {
        if (n <= 1)
            return 1;
        int count = 0;
        for(int i = 1; i <= n; i++){
            // making 'i' root of tree
            int countOfLeftSubTrees = countTrees(i - 1);
            int countOfRightSubTrees = countTrees(n - i);
            count += (countOfLeftSubTrees * countOfRightSubTrees);
        }
        return count;
    }
    public static void main(String[] args) {
        CountUniqueTrees ct = new CountUniqueTrees();
        int count = ct.countTreesM(3);
        System.out.print("Total trees: " + count);
    }
}
