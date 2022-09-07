package codetrus_data_structures.graph.challenge;

import codetrus_data_structures.graph.GraphImpl;
import codetrus_data_structures.linkedlist.DoublyLinkedList;

import java.util.Arrays;

public class FindMotherVertex {
    public static int findMotherVertext(GraphImpl g){
        //visited[] is used for DFS. Initially all are
        //initilized are not visited
        boolean[] visited = new boolean[g.vertices];

        //to store last finished vertex (or mother vertex)
        int lastV = 0;

        //Do a DFS traversal and find last finished vertex
        for (int i = 0; i < g.vertices; i++) {
            if (!visited[i]){
                DFS(g,i,visited);
                lastV = i;
            }
        }

        /*
        If There exist mother vertex (or vertices) in give
        graph, then lastV must be one (or one of them)

        Now check if lastV is actually a mother vertex (or graph
        hast a mother vertex). We basically check
        if every vertex is reachable from last V or not.

        Reset all values in visited[  as false and do
        DFS beginnning from lastV to ckeck if all vertices a
        reachable from it or not
         */
        Arrays.fill(visited, false);
        DFS(g,lastV, visited);

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                return -1;
        }
        return lastV;
    }
    public static void DFS(GraphImpl  g, int node, boolean[] visited){
        visited[node] = true;
        DoublyLinkedList<Integer>.Node temp = null;
        if (g.adjacencyList[node] != null)
            temp = g.adjacencyList[node].headNode;
        while(temp != null){
            if (visited[temp.data])
                temp = temp.nextNode;
            else{
                visited[temp.data] = true;
                DFS(g,temp.data,visited);
                temp = temp.nextNode;
            }
        }
    }
    public static void main(String[] args) {

        GraphImpl g = new GraphImpl(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(3,0);
        g.addEdge(3,1);
        g.printGraph();
        System.out.println("Mother Vertex is: " + findMotherVertext(g));

    }
}
