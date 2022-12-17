package grokking.coding_pattern.toplogical_sort;

import java.util.*;

public class CourseScheduleII {
    public static List<Integer> findOrder(int n, int[][] prerequisites) {
        List<Integer> sortedOrder = new ArrayList<>();
        if (n <= 0)
            return sortedOrder;

        // Store the count of incoming prerequisities in a hashmap
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // a. Initialize the graph
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < n; i++){
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }
        // b. Build the graph
        for (int[] request : prerequisites){
            int parent = request[1], child = request[0];
            graph.get(parent).add(child); // put the child int it's parent's list
            inDegree.put(child, inDegree.get(child) + 1); // increment child's inDegree
        }
        // c. Find all sources i.e., all n with 0 in-degrees
        Queue<Integer> courses = new LinkedList<>();
        // traverse in inDegree using key
        for (int key : inDegree.keySet()){
            if (inDegree.get(key) == 0)
                courses.add(key);
        }

        // d. For each source, add it to the sorted Order and subtract one from
        // all of its children's in-degrees if a child's in-degree becomes zero, add it to the sources queue
        while (!courses.isEmpty()) {
            // pop an element form the start of the sources and store
            // the element in vertex
            int vertex = courses.poll();
            // append the vertex at the end of the sorted_order
            sortedOrder.add(vertex);
            // get the node's children to decrement their in-degrees
            List<Integer> children = graph.get(vertex);
            // traverse in graph[vertex] using child
            // get the nodes' children to decrement
            // their in-degrees
            for (int child: children){
                inDegree.put(child, inDegree.get(child) - 1);
                // if InDegree[child] is 0 append the child in the deque sources
                if (inDegree.get(child) == 0)
                    courses.add(child);
            }
        }
        // topological sort is not possible as the graph has a cycle
        if (sortedOrder.size() != n)
            return new ArrayList<>();
        return sortedOrder;
    }
    public static void main(String[] args){
        // Driver code

        int[]n = {4, 5, 2, 4, 7};
        int[][][]prerequisites = {
                {{1, 0}, {2, 0}, {3, 1}, {3, 2}},
                {{1, 0}, {2, 0}, {3, 1}},
                {{1, 0}}, {{1, 0}, {2, 0}, {3, 1}, {3, 2}},
                {{1, 0}, {0, 3}, {0, 2}, {3, 2}, {2, 5}, {4, 5}, {5, 6}, {2, 4}}};
        for(int i=0; i<n.length; i++){
            System.out.print(i+1);
            System.out.println(".\tPrerequisites: "+Arrays.deepToString(prerequisites[i])+"\n\tTotal number of courses, n = "+n[i]);
            List<Integer> result = findOrder(n[i], prerequisites[i]);
            System.out.println("\tValid courses order: " + result);
//            System.out.println(PrintHyphens.repeat("-", 100));
        }

    }
}
