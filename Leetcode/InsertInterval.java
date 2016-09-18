import java.util.*;

/**
 * Created by abhijeet on 9/18/16.
 * https://leetcode.com/problems/insert-interval/
 */
public class InsertInterval {
    public static void main(String[] args) {

    }

    public static class Interval {
        int start;
        int end;

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

        public List<Interval> insert(List<Interval> intervals, Interval intervalToAdd) {
            // Add the intervalToAdd into existing intervals and merge all the of them.
            intervals.add(intervalToAdd);

            // Sort the intervals first
            Collections.sort(intervals, new IntervalComparator());

            // Create a stack to do the sorting of the intervals
            Deque<Interval> list = new ArrayDeque<>(intervals.size());

            for (Interval interval : intervals) {
                if (list.isEmpty()) {
                    list.add(interval);
                } else {
                    // Check if two intervals are overlapping each other
                    if (interval.start >= list.getLast().start && interval.start <= list.getLast().end) {
                        Interval oldInterval = list.removeLast();
                        int start = oldInterval.start;
                        int end = oldInterval.end;
                        if (interval.end > end) end = interval.end;
                        list.addLast(new Interval(start, end));
                    } else { // Add the {@code interval} if this does not overlap with the current stack.top interval
                        list.addLast(interval);
                    }
                }
            }

            ArrayList<Interval> solution = new ArrayList<>(list.size());
            for (Interval interval : list) {
                solution.add(interval);
            }
            return solution;
        }
    }
}
