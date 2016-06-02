package src;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by abhijeen on 5/29/16.
 */
public class Heap {
    public static void main(String[] args) {
        int[] randomInput = new int[]{ 2,1,1,3,4,5,4,10};
        // Test a min heap with repeatition
        minHeapMethod(randomInput);

        // Test max heap with repeatition
        maxHeapMethod(randomInput);

        // Test min heap without repeatition

    }

    /**
     * Min heap implementation but does not discard the duplicate numbers.
     * @param randomInput
     */
    public static void minHeapMethod(int[] randomInput) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(10, new MinHeapComparator());

        for(int i : randomInput) {
            minHeap.add(i);
        }

        System.out.println("Output from min heap: ");
        while(minHeap.size() > 0) {
            System.out.printf("%d " , minHeap.poll());
        }
    }

    /**
     * Max heap implementation but does not discard the duplicate numbers.
     * @param randomInput
     */
    public static void maxHeapMethod(int[] randomInput) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(10, new MaxHeapComparator());

        for(int i : randomInput) {
            maxHeap.add(i);
        }

        System.out.println("\nOutput from max heap: ");
        while(maxHeap.size() > 0) {
            System.out.printf("%d ", maxHeap.poll());
        }
    }

    /**
     * Min heap implementation which discards the duplicate elements.
     */
    public static void minHeapWithoutRepeatition() {
        // PriorityQueue by default supports the duplicate, If we want to implement a PriorityQueue
        // without duplicate, we need to implement a priorityQueue

        class PriorityQueueWithoutDuplicate<E> extends PriorityQueue<E> {
            @Override
            public boolean offer(E element){
                if(!contains(element)) {
                    add(element);
                    return true;
                }
                return false;
            }
        }
    }

    /**
     * Comparator used by the priority queue to keep the smallest numbers at the front of the queue.
     */
    public static class MinHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer first, Integer second) {
            return first - second;
        }
    }

    /**
     * Comparator used by the priority queue to keep the largest numbers at the front of the queue.
     */
    public static class MaxHeapComparator implements Comparator<Integer> {
        @Override
            public int compare(Integer first, Integer second) {
                return second - first;
        }
    }
}
