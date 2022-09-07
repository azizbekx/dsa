package codetrus_data_structures.graph.challenge;


import codetrus_data_structures.graph.GraphImpl;
import codetrus_data_structures.linkedlist.DoublyLinkedList;
import codetrus_data_structures.stack_and_queue.QueueImpl;

public class BfsImplementation {
    public static String bfs(GraphImpl g) {
        String result = "";
        if (g.vertices < 1) {
            return result;
        }
        boolean[] visited = new boolean[g.vertices];
        for (int i = 0; i < g.vertices; i++) {
            if (!visited[i]) {
                result += bfsVisit(g, i, visited);
            }
        }
        return result;
    }

    public static String bfsVisit(GraphImpl g, int source, boolean[] visited) {
        String result = "";
        QueueImpl<Integer> queue = new QueueImpl<>(g.vertices);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int current_node = queue.dequeue();
            result += String.valueOf(current_node);
            DoublyLinkedList<Integer>.Node temp = null;

            if (g.adjacencyList[current_node] != null)
                temp = g.adjacencyList[current_node].headNode;
            while (temp != null) {
                if (!visited[temp.data]) {
                    queue.enqueue(temp.data);
                    visited[temp.data] = true;
                }
                temp = temp.nextNode;
            }
        }
        return result;
    }
}
