package StacksAndQueue;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by abhijeet on 10/9/16.
 */
public class NearestSmallestElement {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int[] array = {4, 5, 2, 10};
        for(int i : array) {
            arrayList.add(i);
        }
        Solution solution = new Solution();
        System.out.println(solution.prevSmaller(arrayList));
    }

    public static class Solution {
        public ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {
            Stack<Integer> stack = new Stack<>();
            ArrayList<Integer> solution = new ArrayList<>();
            for (int i : arr) {
                while (!stack.isEmpty() && stack.peek() > i) stack.pop();
                if (!stack.isEmpty()) {
                    solution.add(stack.peek());
                } else {
                    solution.add(-1);
                }
                stack.add(i);
            }
            return solution;
        }
    }
}
