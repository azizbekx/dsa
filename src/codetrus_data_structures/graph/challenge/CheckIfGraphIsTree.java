package codetrus_data_structures.graph.challenge;

import codetrus_data_structures.graph.GraphImpl;
import codetrus_data_structures.linkedlist.DoublyLinkedList;
import codetrus_data_structures.stack_and_queue.QueueImpl;
import codetrus_data_structures.stack_and_queue.StackImpl;


public class CheckIfGraphIsTree {
    public static boolean isTreeO(GraphImpl g){
        int root = 0;
        int numOfVisited = 1;
        boolean[] visited = new boolean[g.vertices];
        QueueImpl<Integer> queue = new QueueImpl<>(g.vertices);

        queue.enqueue(root);
        visited[root] = true;

        while (!queue.isEmpty()){
            int current_node = queue.dequeue();
            DoublyLinkedList<Integer>.Node temp = null;
            if (g.adjacencyList[current_node] != null)
                temp = g.adjacencyList[current_node].headNode;
            while(temp != null){
                if (!visited[temp.data]){
                    queue.enqueue(temp.data);
                    visited[temp.data]= true;
                    numOfVisited++;
                }else return false;
                temp = temp.nextNode;
            }
        }

        return numOfVisited == g.vertices;

    }
    public static boolean isTreeO2(GraphImpl g) {
        if (!checkOneParent(g))
            return false;
        if (detectCycleO(g))
            return false;
        if (!checkConnected(g, 0))
            return false;

        return true;
    }

    private static boolean checkConnected(GraphImpl g, int v) {
        int numOfVertices = g.vertices;
        int verticesReached = 0;

        boolean[] visited = new boolean[g.vertices];
        StackImpl<Integer> stack = new StackImpl<>(numOfVertices);
        stack.push(v);

        while (!stack.isEmpty()) {
            int current_node = stack.pop();
            DoublyLinkedList<Integer>.Node temp = null;
            if (g.adjacencyList[current_node] != null)
                temp = g.adjacencyList[current_node].headNode;
            while (temp != null) {
                if (!visited[temp.data]) {
                    stack.push(temp.data);
                    visited[temp.data] = true;
                    verticesReached++;
                }
                temp = temp.nextNode;
            }

        }
        return (verticesReached + 1) == g.vertices;
    }


    private static boolean detectCycleO(GraphImpl g) {
        int numOfVertices = g.vertices;
        boolean[] visited = new boolean[g.vertices];
        boolean[] stackFlag = new boolean[g.vertices];
        for (int i = 0; i < numOfVertices; i++) {
            if (cyclic(g, i, visited, stackFlag))
                return true;
        }
        return false;
    }

    private static boolean cyclic(GraphImpl g, int v, boolean[] visited, boolean[] stackFlag) {
        if (stackFlag[v])
            return true;
        if (visited[v])
            return false;
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

    private static boolean checkOneParent(GraphImpl g) {
        int numOfVertices = g.vertices;
        boolean[] hasOneParent = new boolean[numOfVertices];

        for (int i = 0; i < numOfVertices; i++) {
            DoublyLinkedList<Integer>.Node temp = null;
            if (g.adjacencyList[i] != null) {
                temp = g.adjacencyList[i].headNode;
                while (temp != null) {
                    if (hasOneParent[temp.data])
                        return false;
                    hasOneParent[temp.data] = true;
                    temp = temp.nextNode;
                }
            }
        }
        for (int i = 0; i < numOfVertices; i++) {
            if (i == 0 && hasOneParent[i])
                return false;
            else if (i != 0 && !hasOneParent[i])
                return false;
        }
        return true;
    }

    public static boolean isTree(GraphImpl g) {
        int ans = 0;
        boolean[] visited = new boolean[g.vertices];

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                ans += detectCycle(g, i, visited) + checkPath(g, i, visited);
            }
        }

        return ans == 0;
    }

    private static int checkPath(GraphImpl g, int v, boolean[] visited) {
        int ans = 0;
        StackImpl<Integer> stack = new StackImpl<>(g.vertices);
        stack.push(v);

        while (!stack.isEmpty()) {
            int current_node = stack.pop();
            DoublyLinkedList<Integer>.Node temp = null;

            if (g.adjacencyList[current_node] != null)
                temp = g.adjacencyList[current_node].headNode;
            while (temp != null) {
                if (temp.data == g.vertices)
                    return --ans;
                if (!visited[temp.data])
                    stack.push(temp.data);
                temp = temp.nextNode;
            }
            visited[current_node] = true;
        }
        return ans;

    }

    public static int detectCycle(GraphImpl g, int v, boolean[] visited) {
        int len = g.vertices;
        StackImpl<Integer> stack = new StackImpl<>(g.vertices);
        stack.push(v);
        int ans = 0;

        while (!stack.isEmpty()) {
            int current_node = stack.pop();
            DoublyLinkedList<Integer>.Node temp = null;

            if (g.adjacencyList[current_node] != null)
                temp = g.adjacencyList[current_node].headNode;
            while (temp != null) {
                if (temp.data == len)
                    ans++;
                if (!visited[temp.data])
                    stack.push(temp.data);
                else
                    return ++ans;
                temp = temp.nextNode;
            }
            visited[current_node] = true;
        }
        return ans;
    }

    public static void main(String[] args) {
        GraphImpl g1 = new GraphImpl(9);
        g1.addEdge(0, 2);
        g1.addEdge(0, 5);
        g1.addEdge(0, 1);
        g1.addEdge(2, 3);
        g1.printGraph();

        System.out.println("Path exists: " + isTreeO(g1));
        System.out.println();
    }
}
