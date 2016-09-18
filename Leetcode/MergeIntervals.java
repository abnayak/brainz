import java.util.*;

/**
 * Created by abhijeet on 9/18/16.
 * https://leetcode.com/problems/merge-intervals/
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */

public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //
        // [1,3],[2,6],[8,10],[15,18]
        Interval first = new Interval(1,3);
        Interval second = new Interval(2,6);
        Interval third = new Interval(8,10);
        Interval fourth = new Interval(15, 18);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(first);
        intervals.add(second);
        intervals.add(third);
        intervals.add(fourth);
        List<Interval> result = solution.merge(intervals);
        for(Interval interval : result) {
            System.out.println(interval.start + " " + interval.end);
        }
    }

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static class Solution {
        public class IntervalComparator implements Comparator<Interval> {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        }

        public List<Interval> merge(List<Interval> intervals) {
            // Sort the intervals first
            Collections.sort(intervals, new IntervalComparator());

            // Create a stack to do the sorting of the intervals
            Deque<Interval> list = new ArrayDeque<>(intervals.size());

            for(Interval interval : intervals) {
                if(list.isEmpty()) {
                    list.add(interval);
                } else {
                    // Check if two intervals are overlapping each other
                    if(interval.start >= list.getLast().start && interval.start <= list.getLast().end) {
                        Interval oldInterval = list.removeLast();
                        int start = oldInterval.start;
                        int end = oldInterval.end;
                        if(interval.end > end) end = interval.end;
                        list.addLast(new Interval(start, end));
                    } else { // Add the {@code interval} if this does not overlap with the current stack.top interval
                        list.addLast(interval);
                    }
                }
            }

            ArrayList<Interval> solution = new ArrayList<>(list.size());
            for(Interval interval : list) {
                solution.add(interval);
            }
            return solution;
        }
    }
}
