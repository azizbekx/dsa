package code_trust.data_structures.graph.challenge;

import code_trust.data_structures.graph.GraphImpl;
import code_trust.data_structures.linkedlist.DoublyLinkedList;
import code_trust.data_structures.stack_and_queue.StackImpl;

public class CheckIfExistBetweenPath {
    public static boolean checkPathO(GraphImpl g, int source, int destination) {
        if (source == destination)
            return true;

        boolean[] visited = new boolean[g.vertices];
        StackImpl<Integer> stack = new StackImpl<>(g.vertices);
        stack.push(source);
        visited[source] = true;

        while (!stack.isEmpty()) {
            int current_node = stack.pop();
            DoublyLinkedList<Integer>.Node temp = null;
            if (g.adjacencyList[current_node] != null)
                temp = g.adjacencyList[current_node].headNode;
            while (temp != null) {
                if (!visited[temp.data]) {
                    if (temp.data == destination)
                        return true;
                    stack.push(temp.data);
                    visited[temp.data] = true;
                }
                temp = temp.nextNode;
            }
        }
        return false;

    }

    public static boolean checkPath(GraphImpl g, int source, int destination) {
        boolean[] visited = new boolean[g.vertices];
        int ans = 0;
        for (int i = source; i < g.vertices; i++) {
            if (!visited[i])
                ans += bfs(g, i, visited, destination);
        }
        return ans >= 1;
    }

    public static int bfs(GraphImpl g, int source, boolean[] visited, int destination) {
        int count = 0;
        StackImpl<Integer> stack = new StackImpl<>(g.vertices);
        stack.push(source);

        while (!stack.isEmpty()) {
            int current_node = stack.pop();
            DoublyLinkedList<Integer>.Node temp = null;

            if (g.adjacencyList[current_node] != null)
                temp = g.adjacencyList[current_node].headNode;

            while (temp != null) {
                if (!visited[temp.data])
                    stack.push(temp.data);

                if (temp.data == destination)
                    count++;
                temp = temp.nextNode;
            }
            visited[current_node] = true;
        }
        return count;
    }

    public static void main(String[] args) {
        GraphImpl g1 = new GraphImpl(9);
        g1.addEdge(0, 2);
        g1.addEdge(0, 5);
        g1.addEdge(2, 3);
        g1.addEdge(2, 4);
        g1.addEdge(5, 3);
        g1.addEdge(5, 6);
        g1.addEdge(3, 6);
        g1.addEdge(6, 7);
        g1.addEdge(6, 8);
        g1.addEdge(6, 4);
        g1.addEdge(7, 8);
        g1.printGraph();
        System.out.println("Path exists: " + checkPathO(g1, 0, 7));
        System.out.println();
        GraphImpl g2 = new GraphImpl(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(1, 3);
        g2.addEdge(2, 3);

        g2.printGraph();
        System.out.println("Path exists: " + checkPathO(g2, 3, 0));
    }
}
