package Array;

import java.util.ArrayList;

/**
 * Created by abhijeet on 6/4/2016.
 * https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
 * <p>
 * You are in an infinite 2D grid where you can move in any of the 8 directions :
 * <p>
 * (x,y) to
 * (x+1, y),
 * (x - 1, y),
 * (x, y+1),
 * (x, y-1),
 * (x-1, y-1),
 * (x+1,y+1),
 * (x-1,y+1),
 * (x+1,y-1)
 * You are given a sequence of points and the order in which you need to cover the points. Give the minimum number of steps in which you can achieve it. You start from the first point.
 * <p>
 * Example :
 * <p>
 * Input : [(0, 0), (1, 1), (1, 2)]
 * Output : 2
 * It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).
 */
public class MaxStepInInfiniteGrid {
    public static void main (String[] args) {
        ArrayList<Integer> X = new ArrayList<>();
        X.add(-7);
        X.add(-13);
        //X.add(1);

        ArrayList<Integer> Y = new ArrayList<>();
        Y.add(1);
        Y.add(5);
        //Y.add(2);

        Solution solution = new Solution();

        System.out.println(solution.coverPoints(X, Y));

    }

    public static class Solution {
        // X and Y co-ordinates of the points in order.
        // Each point is represented by (X.get(i), Y.get(i))
        public int coverPoints (ArrayList<Integer> X, ArrayList<Integer> Y) {
            int maxDistance = 0;
            if (X.size() == 1 || X.size() == 0 || X.size() != Y.size()) {
                return maxDistance;
            }

            for (int i = 0; i <= X.size() - 2; i++) {
                int xDiff = Math.abs(X.get(i)- X.get(i+1));
                int yDiff = Math.abs(Y.get(i) - Y.get(i+1));
                maxDistance += Math.max(xDiff, yDiff);
            }
            return maxDistance;
        }
    }

}
