/**
 * Created by abhijeen on 1/18/16.
 */
public class ReverserLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 9; i++) {
            linkedList.addNode(i);
        }
        linkedList.printLinkedList();

        // Reverse the linked list
        LinkedList.Node root = reverseLinkedList(linkedList.root);
        linkedList.root = root;

        linkedList.printLinkedList();
    }

    private static LinkedList.Node reverseLinkedList(LinkedList.Node root) {
        if (root == null || root.next == null) {
            return root;
        }
        LinkedList.Node next = root.next;
        LinkedList.Node previous = root;
        previous.next = null;

        while (next != null) {
            LinkedList.Node temp = next.next;
            next.next = previous;
            previous = next;
            next = temp;
        }
        return previous;
    }
}
