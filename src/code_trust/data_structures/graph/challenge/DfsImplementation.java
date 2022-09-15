package code_trust.data_structures.graph.challenge;

import code_trust.data_structures.graph.GraphImpl;
import code_trust.data_structures.linkedlist.DoublyLinkedList;
import code_trust.data_structures.stack_and_queue.StackImpl;


public class DfsImplementation {
    public static String dfs(GraphImpl g) {
        String result = "";
        boolean[] visited = new boolean[g.vertices];

        for (int i = 0; i < g.vertices; i++)
            if (!visited[i])
                result += visitBfs(g, i, visited);

        return result;
    }

    private static String visitBfs(GraphImpl g, int source, boolean[] visited) {
        String result = "";
        StackImpl<Integer> stack = new StackImpl<>(g.vertices);
        stack.push(source);

        while (!stack.isEmpty()) {
            int current_node = stack.pop();
            result += String.valueOf(current_node);

            DoublyLinkedList<Integer>.Node temp = null;
            if (g.adjacencyList[current_node] != null)
                temp = g.adjacencyList[current_node].headNode;
            while (temp != null) {
                if (!visited[temp.data])
                    stack.push(temp.data);
                else
                    System.out.println("Detected Cycle");
                temp = temp.nextNode;
            }
            visited[current_node] = true;
        }
        return result;
    }

    public static void main(String[] args) {
        GraphImpl g = new GraphImpl(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);

        System.out.println("Graph1:");
        g.printGraph();
        System.out.println("DFS traversal of Graph1 : " + dfs(g));
        System.out.println();

    }
}
