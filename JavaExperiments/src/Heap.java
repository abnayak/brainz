package src;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by abhijeen on 5/29/16.
 */
public class Heap {
    public static void main(String[] args) {
        int[] randomInput = new int[]{ 2,1,1,3,4,5,4,10};
        // Test a min heap
        minHeapMethod(randomInput);

        // Test max heap
        maxHeapMethod(randomInput);
    }

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
    public static class MinHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer first, Integer second) {
            return first - second;
        }
    }

    public static class MaxHeapComparator implements Comparator<Integer> {
        @Override
            public int compare(Integer first, Integer second) {
                return second - first;
        }
    }
}
