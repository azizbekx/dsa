package grokking.coding_pattern.toplogical_sort;

import code_trust.data_structures.linkedlist.DoublyLinkedList;

import java.util.*;

public class CompilationOrder {
    public static String repeat(String str, int pValue) {
        String out = "";
        for (int i = 0; i < pValue; i++) {
            out += str;
        }
        return out;
    }

    public static List<Character> findCompilationOrder(ArrayList<ArrayList<Character>> dependencies) {
        List<Character> sortedOrder = new ArrayList<>();
        // a. Initialize the graph and inDegree
        HashMap<Character, List<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> inDegree = new HashMap<>();
        for (ArrayList<Character> dependency : dependencies) {
            char parent = dependency.get(0);
            char child = dependency.get(1);
            graph.put(parent, new ArrayList<>());
            graph.put(child, new ArrayList<>());
            inDegree.put(parent, 0);
            inDegree.put(child, 0);
        }
        if (graph.size() <= 0) {
            return sortedOrder;
        }
        // b. Build the graph
        for (ArrayList<Character> characters : dependencies) {
            char parent = characters.get(1);
            char child = characters.get(0);
            graph.get(parent).add(child); // put the child into it's parent's list
            inDegree.put(child, inDegree.get(child) + 1); // increment child's inDegree
        }
        // c. Find all sources i.e., all n with 0 in-degrees
        Queue<Character> sources = new LinkedList<>();
        for (char key : inDegree.keySet())
            if (inDegree.get(key) == 0)
                sources.add(key);

        // d. For each source, add it to the sorted_order and subtract one from all its children
        // if a child's in degree becomes zero, add it to source queue
        while (!sources.isEmpty()) {
            char vertex = sources.poll();

            sortedOrder.add(vertex);
            for (int child = 0; child < graph.get(vertex).size(); child++) {
                inDegree.put(graph.get(vertex).get(child), inDegree.get(graph.get(vertex).get(child)) - 1);
                if (inDegree.get(graph.get(vertex).get(child)) == 0)
                    sources.add(graph.get(vertex).get(child));
            }
        }
        if(sortedOrder.size() != graph.size()){
            return new ArrayList<>();
        }
        return sortedOrder;
    }

    public static void main(String[] args) {
        List<List<List<Character>>> inputs = Arrays.asList(
                Arrays.asList(Arrays.asList('B', 'A'), Arrays.asList('C', 'A'), Arrays.asList('D', 'C'), Arrays.asList('E', 'D'), Arrays.asList('E', 'B')),
                Arrays.asList(Arrays.asList('B', 'A'), Arrays.asList('C', 'A'), Arrays.asList('D', 'B'), Arrays.asList('E', 'B'), Arrays.asList('E', 'D'), Arrays.asList('E', 'C'), Arrays.asList('F', 'D'), Arrays.asList('F', 'E'), Arrays.asList('F', 'C')),
                Arrays.asList(Arrays.asList('A', 'B'), Arrays.asList('B', 'A')),
                Arrays.asList(Arrays.asList('B', 'C'), Arrays.asList('C', 'A'), Arrays.asList('A', 'F')),
                List.of(Arrays.asList('C', 'C'))
        );
        ArrayList<ArrayList<ArrayList<Character>>> dependencies = new ArrayList<ArrayList<ArrayList<Character>>>();
        for (int j = 0; j < inputs.size(); j++) {
            dependencies.add(new ArrayList<ArrayList<Character>>());
            for (int k = 0; k < inputs.get(j).size(); k++) {
                dependencies.get(j).add(new ArrayList<Character>());
                for (int g = 0; g < inputs.get(j).get(k).size(); g++) {
                    dependencies.get(j).get(k).add(inputs.get(j).get(k).get(g));
                }
            }
        }
        for (int i = 0; i < dependencies.size(); i++) {
            System.out.println(i + 1 + ".\tdependencies: " + dependencies.get(i));
            System.out.println("\tCompilation Order: " + findCompilationOrder(dependencies.get(i)));
            System.out.println(repeat("-", 100));
        }
    }
}
