import java.util.ArrayList;

/**
 * Created by abhijeet on 2/22/16.
 */
public class Interval {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<IntervalNode> list = new ArrayList<>();

        list.add(new IntervalNode(1,2));
        list.add(new IntervalNode(8,10));


        ArrayList<IntervalNode> result = solution.insert(list, new IntervalNode(3,6));

        for(IntervalNode node : result) {
            System.out.print(node);
        }
    }

    public static class IntervalNode {
        int start;
        int end;

        IntervalNode(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }


    public static class Solution {
        public ArrayList<IntervalNode> insert(ArrayList<IntervalNode> intervals, IntervalNode newInterval) {
            if(newInterval.start > intervals.get(intervals.size()-1).end) {
                intervals.add(newInterval);
                return intervals;
            }

            if(newInterval.end < intervals.get(0).start) {
                intervals.add(0, newInterval);
                return intervals;
            }

            for(int i = 0; i < intervals.size(); i++) {
                if (newInterval.start >= intervals.get(i).start && newInterval.end <= intervals.get(i).end) {
                    return intervals;
                }
            }

            ArrayList<IntervalNode> result = new ArrayList<>();
            for(int i = 0; i < intervals.size(); i++) {
                if (newInterval.start >= intervals.get(i).start && newInterval.start <= intervals.get(i).end && newInterval.end > intervals.get(i).end) {
                    if(newInterval.end > intervals.get(intervals.size()-1).end) {
                        result.add(new IntervalNode(intervals.get(i).start, newInterval.end));
                        return result;
                    } else {
                        int j = intervals.size() -1;
                        for (; j > i; j--) {
                            if (newInterval.end >= intervals.get(j).start && newInterval.end <= intervals.get(j).end) {
                                break;
                            }
                        }
                        if(j == i) {
                            result.add(new IntervalNode(intervals.get(i).start, newInterval.end));
                        } else {
                            result.add(new IntervalNode(intervals.get(i).start, intervals.get(j).end));
                        }
                        j++;
                        if(j <= intervals.size()-1) {
                            while (j <= intervals.size()-1) {
                                result.add(intervals.get(j));
                                j++;
                            }
                        }
                        return result;
                    }
                }
                result.add(intervals.get(i));
            }

            for(int i = 0; i < intervals.size()-1; i++) {
                if (intervals.get(i).end < newInterval.start && intervals.get(i+1).start > newInterval.end) {
                    intervals.add(i+1, newInterval);
                }
            }
            return intervals;
        }
    }

}
