package grokking.coding_pattern.tree_breadth_first_search;

public class TreeNodeN {
    public int val;
    public TreeNodeN left;
    public TreeNodeN right;
    public TreeNodeN next;

    public TreeNodeN(int x) {
        val = x;
        left = right = next = null;
    }

    // level order traversal using 'next' pointer
    void printLevelOrder() {
        TreeNodeN nextLevelRoot = this;
        while (nextLevelRoot != null) {
            TreeNodeN current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null)
                        nextLevelRoot = current.left;
                    else if (current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }
    }
};