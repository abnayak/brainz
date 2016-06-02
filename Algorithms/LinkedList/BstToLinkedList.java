import java.util.ArrayList;
import java.util.Arrays;

/**
 * Convert a bst to double linked list
 */
public class BstToLinkedList {
    public static void main (String[] args) {
        BST bst = new BST();
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(5, 3, 4, 2, 8, 7, 9));

        for (Integer i : list) {
            bst.insert(i);
        }

        bst.printInOrder(bst.root);
    }
}
