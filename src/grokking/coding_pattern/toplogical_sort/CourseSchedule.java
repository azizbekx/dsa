package grokking.coding_pattern.toplogical_sort;

import java.util.*;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> sortedOrder = new ArrayList<>();
        if (numCourses <= 0)
            return false;
        // Intialize the graph
        // count of incoming prerequisites
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();

        // b. Build the graph
        for (int i =0 ; i < numCourses; i++){
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        if (graph.size() <= 0)
            return false;

        for (int[] request : prerequisites){
            int parent = request[0], child = request[1];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }
        // c. Find all sources i.e., all vertices with 0 in-degrees
        Queue<Integer> courses = new LinkedList<>();
        for(int key : inDegree.keySet()){
            if (inDegree.get(key) == 0)
                courses.add(key);
        }

        // d. For each source, add it to the sorted order and subtract one from
        // all of its children's in-degrees
        // if a child's in-degree becomes zero, add it to the sources queue
        while (!courses.isEmpty()){
            int vertex = courses.poll();
            sortedOrder.add(vertex);
            // get the node's children to decrement their in-degrees
            List<Integer> children = graph.get(vertex);
            for (int child : children){
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0)
                    courses.add(child);
            }
        }
        // topological sort is not possible as the graph has a cycle
        return sortedOrder.size() == numCourses;
    }
    public static void main(String[] args) {

        int[][][] prereq = {
                {{1, 0}, {2, 1}},
                {{1, 0}, {0, 1}},
                {{1, 0}, {2, 1}, {3, 2}, {4, 3}},
                {{1, 0}, {2, 1}, {3, 2}, {4, 3}, {0, 4}},
                {{2, 0}, {2, 1}, {3, 2}, {4, 2}, {3, 1}}
        };
        int[] courses = {3, 2, 10, 5, 5};

        for(int i=0;i<courses.length;i++){
            System.out.println((i + 1)+ ".\tNumber of courses: "+ courses[i]);
            System.out.println("\tNumber of pre-requisites: "+ Arrays.deepToString(prereq[i]));
            System.out.println("\tOutput: "+ canFinish(courses[i], prereq[i]));
//            System.out.println(PrintHyphens.repeat("-", 100));
        }
    }
}
