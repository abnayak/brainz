package Array;

import java.util.*;

/**
 * Created by abhijeet on 2/22/16.
 */
public class IntervalSolution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<Interval> list = new ArrayList<>();

        list.add(new Interval(1,2));
        list.add(new Interval(8,10));


        ArrayList<Interval> result = solution.insert(list, new Interval(2,6));

        for(Interval node : result) {
            System.out.print(node);
        }
    }

    private static class Interval {
        public int start;
        public int end;

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }


    public static class Solution {
        public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
            Stack<Interval> stack  = new Stack<>();
            intervals.add(newInterval);

            Collections.sort(intervals, new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    return o1.start - o2.start;
                }
            });

            for(Interval interval : intervals) {
                if(stack.empty()) {
                    stack.push(interval);
                } else {

                    Interval top = stack.pop();

                    if(top.start <= interval.start && interval.start <= top.end) {
                        if(interval.end > top.end) {
                            top.end = interval.end;
                        }
                        stack.push(top);
                    } else {
                        stack.push(top);
                        stack.push(interval);
                    }

                }
            }

            ArrayList<Interval> solution = new ArrayList<>();
            for(int i = 0; i < stack.size(); i++) {
                solution.add(stack.get(i));
            }
            return solution;
        }
    }

}
