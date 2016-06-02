/**
 * Created by abhijeet on 4/10/2016.
 */
public class BST {
    public Node root;

    public BST() {
        root = null;
    }

    public class Node {
        public int value;
        public Node left, right;
        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public void insert(int[] values) {
        for(int value : values) {
            insert(value);
        }
    }

    /**
     * Add the <tt>value</tt> to the tree
     * @param value
     */
    public void insert(int value) {
        if(root == null) {
            root = new Node(value);
        } else {
            Node temp = root;
            while(true) {
                if(temp.value >= value) { // Value should be part of left tree
                    if(temp.left == null) {
                        temp.left = new Node(value);
                        break;
                    } else {
                        temp = temp.left;
                    }
                } else { // Value should be part of right tree
                    if(temp.right == null) {
                        temp.right = new Node(value);
                        break;
                    } else {
                        temp = temp.right;
                    }
                }
            }
        }
    }

    /**
     * Print the elements in-order
     */
    public void printInOrder(Node node) {
        if(node == null) {
            return;
        }

        printInOrder(node.left);
        System.out.println(node.value);
        printInOrder(node.right);
    }
}
