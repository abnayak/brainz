package StacksAndQueue;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by abhijeet on 10/12/16.
 * https://www.interviewbit.com/problems/nextgreater/
 */
public class NearestGreatestElement {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int[] array = {4, 5, 2, 10};
        for(int i : array) {
            arrayList.add(i);
        }
        Solution solution = new Solution();
        System.out.println(solution.nextGreater(arrayList));
    }
    public static class Solution {
        public ArrayList<Integer> nextGreater(ArrayList<Integer> a) {
            int[] solution = new int[a.size()];
            Stack<Integer> stack = new Stack<>();
            solution[a.size() - 1] = -1;
            stack.add(a.get(a.size() - 1));
            for (int i = a.size() - 2; i >= 0; i--) {
                while (!stack.isEmpty() && stack.peek() <= a.get(i)) stack.pop();
                if(stack.isEmpty()) {
                    solution[i] = -1;
                } else {
                    solution[i] = stack.peek();
                }
                stack.add(a.get(i));
            }
            ArrayList<Integer> listSolution = new ArrayList<>();
            for(int i : solution) {
                listSolution.add(i);
            }
            return listSolution;
        }
    }

}
