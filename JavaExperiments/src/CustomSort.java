package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by abhijeet on 5/17/2016.
 */
public class CustomSort {
    public static void main(String[] args) {
        Node[] nodes = new Node[5];
        nodes[0] = new Node(2,20);
        nodes[1] = new Node(3,30);
        nodes[2] = new Node(5,50);
        nodes[3] = new Node(1,10);
        nodes[4] = new Node(4,40);

        List<Node> listNode = new ArrayList<Node>();
        for(Node node : nodes) {
            listNode.add(node);
        }

        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare (Node o1, Node o2) {
                return o1.key - o2.key;
            }
        });

        System.out.println("Sorted array: ");
        for(Node node: nodes) {
            System.out.println("Key: " + node.key + " value: " + node.value);
        }


        // Sort the array list
        Collections.sort(listNode, new Comparator<Node>() {
            @Override
            public int compare (final Node o1, final Node o2) {
                return o1.key - o2.key;
            }
        });

        System.out.println("Sorted list: ");
        for(Node node: listNode) {
            System.out.println("Key: " + node.key + " value: " + node.value);
        }
    }

    public static class Node {
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int key;
        public int value;
    }
}
