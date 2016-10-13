package StacksAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by abhijeet on 10/12/16.
 */
public class MyStack {
    public static void main(String[] args) {

    }

    class Solution {
        Deque<Integer> list = new LinkedList<>();
        Deque<Integer> min = new LinkedList<>();

        public void push(int x) {
            if(min.isEmpty()) {
                min.addLast(x);
            } else {
                if (x < min.peekLast()) {
                    min.add(x);
                } else {
                    min.add(min.peekLast());
                }
            }
            list.addLast(x);
        }

        public void pop() {
            if (list.isEmpty()) return;

            list.removeLast();
            min.removeLast();
        }

        public int top() {
            if (list.isEmpty()) return -1;

            return list.peekLast();
        }

        public int getMin() {
            if (min.isEmpty()) return -1;

            return min.peekLast();
        }
    }
}
