package leetcode.contest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class One {
    public static void  levelOfNodeInBTree(Node root) {
        if (root == null) {
            System.out.println("Tree is empty");
            return ;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        //level delimiter
        queue.offer(null);
        int level = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            //Level change
            if (null == node) {
                if (!queue.isEmpty()) {
                    //level delimiter
                    queue.offer(null);
                }
                level ++;
            } else {
                boolean isNotNull = false;
                if (node.left != null) {
                    isNotNull = true;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (level % 2 !=0 && isNotNull){
                    int t = node.left.data;
                    node.left.data = node.right.data;
                    node.right.data = t;
                }
                System.out.println(node.data);
            }


        }

    }
    public static void main( String[] args )
    {
        //root level 0
        Node A = Node.createNode(100);
        //Level 1
        Node B = Node.createNode(50);
        Node C = Node.createNode(150);
        //Level 2
        Node D = Node.createNode(25);
        Node E = Node.createNode(75);
        Node F = Node.createNode(125);
        Node G = Node.createNode(175);
        //Level 3
        Node H = Node.createNode(120);
        Node I = Node.createNode(140);

        //connect Level 0 and 1
        A.left = B;
        A.right = C;
        //connect level 1 and level 2
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        //Connect level 2 and level 3
        F.left = H;
        F.right = I;

        //Pass root node and input node
        levelOfNodeInBTree(A);
    }
}
class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int num) {
        this.data = num;
        this.left = null;
        this.right = null;
    }

    public Node() {
        this.left = null;
        this.right = null;
    }
    public static Node createNode(int number)
    {
        return new Node(number);
    }
}
