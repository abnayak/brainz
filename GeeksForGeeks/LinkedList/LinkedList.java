package LinkedList;

/**
 * Created by abhijeen on 1/15/16.
 */
public class LinkedList {
    public Node root = null;

    public void printLinkedList() {
        Node temp = root;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void addNode(int val) {
        if (root == null) {
            root = new Node(val);
        } else {
            Node temp = root;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(val);
        }
    }

    public class Node {
        public Node(int val) {
            value = val;
            next = null;
        }

        public int value;
        public Node next;
    }
}
