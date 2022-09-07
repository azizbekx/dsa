package codetrus_data_structures.graph.challenge;

import codetrus_data_structures.graph.GraphImpl;
import codetrus_data_structures.linkedlist.DoublyLinkedList;
import codetrus_data_structures.stack_and_queue.QueueImpl;

public class CounterNumberOfEdges {
    public static int numEdgesO(GraphImpl g){
        int sum = 0;
        for (int i = 0; i < g.vertices; i++) {
            DoublyLinkedList<Integer>.Node temp = null;
            if (g.adjacencyList[i] != null)
                temp = g.adjacencyList[i].headNode;
            while (temp != null){
                sum++;
                temp = temp.nextNode;
            }
        }
        return sum;
    }
    public static int numEdges(GraphImpl g) {
        boolean[] visited = new boolean[g.vertices];
        int count=0;
        for(int i=0; i<g.vertices; i++){
            if(!visited[i])
                count += BFS(g, i, visited);
        }
        return count;

    }
    public static int BFS(GraphImpl g, int node, boolean[] visited){
        int count=0;
        QueueImpl<Integer> queue = new QueueImpl<>(g.vertices);
        queue.enqueue(node);

        visited[node] = true;
        while(!queue.isEmpty()){
            int current_node = queue.dequeue();
            count++;

            DoublyLinkedList<Integer>.Node temp = null;
            if(g.adjacencyList[current_node] != null)
                temp = g.adjacencyList[current_node].headNode;

            while(temp != null){
                if(!visited[temp.data]){
                    queue.enqueue(temp.data);
                    visited[temp.data] = true;
                }
                temp = temp.nextNode;
            }
        }
        return ++count;
    }
}
