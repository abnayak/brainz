package StacksAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by abhijeet on 10/12/16.
 */
public class Stack {
    public static void main(String[] args) {

    }

    class Solution {
        Deque<Integer> list = new LinkedList<>();
        Deque<Integer> min = new LinkedList<>();

        public void push(int x) {
            if(x < min.peekLast()) {
                min.add(x);
            } else {
                min.add(min.peekLast());
            }
            list.addLast(x);
        }

        public void pop() {
            if(list)
        }

        public int top() {

        }

        public int getMin() {

        }
    }
}
