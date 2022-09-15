package code_trust.data_structures.graph.challenge;

import code_trust.data_structures.graph.GraphImpl;
import code_trust.data_structures.linkedlist.DoublyLinkedList;
import code_trust.data_structures.stack_and_queue.StackImpl;

public class DetectCycle {
    public static boolean detectCycleO(GraphImpl g) {
        int numOfVertices = g.vertices;

        boolean[] visited = new boolean[numOfVertices];
        boolean[] stackFlag = new boolean[numOfVertices];
        for (int i = 0; i < numOfVertices; i++) {
            if (cyclic(g, i, visited, stackFlag)) {
                return true;
            }
        }
        return false;
    }

    private static boolean cyclic(GraphImpl g, int v, boolean[] visited, boolean[] stackFlag) {
        if (stackFlag[v]) {
            return true;
        }
        if (visited[v]) {
            return false;
        }
        visited[v] = true;
        stackFlag[v] = true;

        DoublyLinkedList<Integer>.Node temp = null;
        if (g.adjacencyList[v] != null)
            temp = g.adjacencyList[v].headNode;
        while (temp != null) {
            if (cyclic(g, temp.data, visited, stackFlag))
                return true;
            temp = temp.nextNode;
        }
        stackFlag[v] = false;
        return false;
    }

    public static boolean detectCycle(GraphImpl g) {

        boolean[] visited = new boolean[g.vertices];
        boolean ans = false;

        for (int i = 0; i < g.vertices; i++) {
            ans = visitDfs(g, i, visited);
        }
        return ans;

    }

    public static boolean visitDfs(GraphImpl g, int source, boolean[] visited) {
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
                else
                    return true;
                temp = temp.nextNode;
            }
            visited[current_node] = true;
        }
        return false;
    }
}
