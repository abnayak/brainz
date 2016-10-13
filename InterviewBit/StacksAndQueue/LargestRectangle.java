package StacksAndQueue;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by abhijeet on 10/9/16.
 * https://www.interviewbit.com/problems/largest-rectangle-in-histogram/
 * Given n non-negative integers representing the histogram’s bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 */
public class LargestRectangle {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int[] array = {6, 2, 5, 4, 5, 1, 6};
        for (int i : array) {
            arrayList.add(i);
        }
        Solution solution = new Solution();
        System.out.println(solution.largestRectangleArea(arrayList));
    }

    public static class Solution {
        public int largestRectangleArea(ArrayList<Integer> a) {
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            int maxArea = 0;
            int i = 1;
            for (; i < a.size(); i++) {
                if (a.get(i) >= a.get(stack.peek())) {
                    stack.push(i);
                } else {
                    while (!stack.isEmpty() && a.get(stack.peek()) > a.get(i)) {
                        int stackTopIndex = stack.pop();
                        int tempArea;
                        if (stack.isEmpty()) {
                            tempArea = a.get(stackTopIndex) * i;
                        } else {
                            tempArea = a.get(stackTopIndex) * (i - stack.peek() - 1);
                        }
                        maxArea = tempArea > maxArea ? tempArea : maxArea;
                    }
                    stack.push(i);
                }
            }
            while (!stack.isEmpty()) {
                int stackTopIndex = stack.pop();
                int tempArea ;
                if (stack.isEmpty()) {
                    tempArea = a.get(stackTopIndex) * i;
                } else {
                    tempArea = a.get(stackTopIndex) * (i - stack.peek() - 1);
                }
                maxArea = tempArea > maxArea ? tempArea : maxArea;
            }
            return maxArea;
        }
    }
}