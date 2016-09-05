package src;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by abhijeet on 8/31/16.
 * Priority queue example
 */
public class PriorityQueueExample {
    public static class CustomComparator implements Comparator<Integer> {
        public int compare(Integer i, Integer j) {
            return i - j;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new CustomComparator());

        int[] array = {3, 2, 4, 1, 5};
        for (int i : array) {
            priorityQueue.offer(i);
        }

        while (!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.poll());
        }
    }
}
