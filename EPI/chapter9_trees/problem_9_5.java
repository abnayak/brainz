package chapter9_trees;

/**
 * Created by abhijeet on 5/18/2016.
 * Print the preorder with and without recursion
 * <p>
 * 5
 * /   \
 * 3     7
 * / \   / \
 * 2  4  6  8
 */
public class problem_9_5 {
    public static void main (String[] args) {
        // Allocate the nodes
        Node two = new Node(2, null, null);
        Node four = new Node(4, null, null);

        Node six = new Node(6, null, null);
        Node eight = new Node(8, null, null);

        Node three = new Node(3, two, four);
        Node seven = new Node(7, six, eight);

        Node five = new Node(5, three, seven);

        // Set the parent Nodes
        five.parent = null;

        three.parent = five;
        seven.parent = five;

        two.parent = three;
        four.parent = three;

        six.parent = seven;
        eight.parent = seven;

        // print the preorder using recursive method;
        preOrderUsingRecursive(five);
        System.out.println("\n");
        preOrderWihoutRecursion(five);
    }

    public static void preOrderUsingRecursive (Node root) {
        if (root == null)
            return;

        preOrderUsingRecursive(root.left);
        System.out.printf("%d:%d, ", root.value, root.parent != null ? root.parent.value : null);
        preOrderUsingRecursive(root.right);
    }

    public static void preOrderWihoutRecursion (Node root) {
        Node previous = null;
        Node current = root;
        while (current != null) {
            if (current.left == null && current.right == null) {
                System.out.printf("%d, ", current.value);
                previous = current;
                current = current.parent;
            }

            if (current.left != null && current.right != previous && current.left != previous) {
                current = current.left;
            } else if (previous == current.left) {
                System.out.printf("%d, ", current.value);
                if (current.right != null) {
                    current = current.right;
                }
            } else if(previous == current.right) {
                previous = current;
                current = current.parent;
            }
        }

    }


    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node (int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
