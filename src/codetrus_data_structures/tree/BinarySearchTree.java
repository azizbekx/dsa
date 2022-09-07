package codetrus_data_structures.tree;

public class BinarySearchTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public boolean add(int value) {
        root = recursive_insert(this.root, value);
        return true;
    }

    public Node recursive_insert(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.getData()) {
            current.setLeftChild(recursive_insert(current.getLeftChild(), value));
        } else if (value > current.getData()) {
            current.setRightChild(recursive_insert(current.getRightChild(), value));
        } else {
            return current;
        }
        return current;
    }
    /*
    Iterative insert

    public boolean add(int value) {
        if (isEmpty()) {
            root = new Node(value);
            return true;
        }
        Node current = root;
        while (current != null) {
            Node left = current.getLeftChild();
            Node right = current.getRightChild();

            if (current.getData() > value) {
                if (left == null) {
                    left = new Node(value);
                    current.setLeftChild(left);
                    return true;
                }
                current = left;
            } else {
                if (right == null) {
                    right = new Node(value);
                    current.setRightChild(right);
                    return true;
                }
                current = right;
            }
        }
        return false;
    }
     */

    public Node search(int value) {
        if (isEmpty()) return null;

        return searchRecursive(root, value);
    }

    public Node searchRecursive(Node currentNode, int value) {
        if (currentNode == null || currentNode.getData() == value)
            return currentNode;

        if (currentNode.getData() > value)
            return searchRecursive(currentNode.getLeftChild(), value);
        else
            return searchRecursive(currentNode.getRightChild(), value);
    }

    public boolean delete(int value, Node currentNode) {
        if (root == null)
            return false;

        Node parent = null; //to store parent of currentNode
        while (currentNode != null && (currentNode.getData() != value)) {
            parent = currentNode;
            if (currentNode.getData() > value)
                currentNode = currentNode.getLeftChild();
            else
                currentNode = currentNode.getRightChild();
        }
        if (currentNode == null)
            return false;
        else if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
            //1. Node is leaf Node
            //if that leaf node is the root ( a tree with just root)
            if (root.getData() == currentNode.getData()) {
                setRoot(null);
                return true;
            } else if (currentNode.getData() < parent.getData()) {
                parent.setLeftChild(null);
                return true;
            } else {
                parent.setRightChild(null);
                return true;
            }
        } else if (currentNode.getRightChild() == null) {
            if (root.getData() == currentNode.getData()) {
                setRoot(currentNode.getLeftChild());
                return true;
            } else if (currentNode.getData() < parent.getData()) {
                parent.setLeftChild(currentNode.getLeftChild());
                return true;
            } else {
                parent.setRightChild(currentNode.getLeftChild());
                return true;
            }
        } else if (currentNode.getLeftChild() == null) {
            if (root.getData() == currentNode.getData()) {
                setRoot(currentNode.getRightChild());
                return true;
            } else if (currentNode.getData() < parent.getData()) {
                parent.setLeftChild(currentNode.getRightChild());
                return true;
            } else {
                parent.setRightChild(currentNode.getRightChild());
                return true;
            }
        } else {
            Node leastNode = findLeastNode(currentNode.getRightChild());
            int temp = leastNode.getData();
            delete(temp, root);
            currentNode.setData(temp);
            return true;
        }
    }

    private Node findLeastNode(Node currentNode) {
        Node temp = currentNode;
        while (temp.getLeftChild() != null) {
            temp = temp.getLeftChild();
        }
        return temp;
    }

    /*
    public Node search(int value) {
        if (isEmpty()) return null;
        Node currentNode = this.root;

        while (currentNode != null) {
            if (currentNode.getData() == value)
                return currentNode;
            if (currentNode.getData() > value)
                currentNode = currentNode.getLeftChild();
            else
                currentNode = currentNode.getRightChild();
        }

        System.out.println(value + " Not found in the Tree!");
        return null;
    }
    */


    public boolean isEmpty() {
        return root == null;
    }

    public void printTree(Node current) {
        if (current == null) return;
        System.out.println(current.getData() + ",");
        printTree(current.getLeftChild());
        printTree(current.getRightChild());

    }
}
