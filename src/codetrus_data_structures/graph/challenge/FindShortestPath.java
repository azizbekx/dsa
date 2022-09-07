package codetrus_data_structures.graph.challenge;

import codetrus_data_structures.graph.GraphImpl;
import codetrus_data_structures.linkedlist.DoublyLinkedList;
import codetrus_data_structures.stack_and_queue.QueueImpl;

public class FindShortestPath {
    public static int findShortestPathLength(GraphImpl g, int source, int destination) {
        if (source == destination)
            return 0;
        int result = 0;
        int numOfVertices = g.vertices;
        boolean[] visited = new boolean[numOfVertices];
        int[] distance = new int[numOfVertices];

        QueueImpl<Integer> queue = new QueueImpl<>(numOfVertices);
        queue.enqueue(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.dequeue();
            DoublyLinkedList<Integer>.Node temp = null;
            if (g.adjacencyList[currentNode] != null)
                temp = g.adjacencyList[currentNode].headNode;
            while (temp != null) {
                if (!visited[temp.data]) {
                    queue.enqueue(temp.data);
                    visited[temp.data] = true;
                    distance[temp.data] = distance[currentNode] + 1;

                }
                if (temp.data == destination)
                    return distance[destination];
                temp = temp.nextNode;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        GraphImpl g1 = new GraphImpl(6);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(0, 3);
        g1.addEdge(2, 4);
        g1.addEdge(3, 5);
        g1.addEdge(5, 4);

        g1.printGraph();

        System.out.println("Path exists: " + findShortestPathLength(g1,0,4));
        System.out.println();
    }
}
