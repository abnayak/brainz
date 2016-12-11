package Hashing;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by abhijeet on 12/6/16.
 */
public class PointsOnStraightLine {
    public static void main(String[] args) {

    }

    public class Solution {
        Hashtable<Double, Integer> table = new Hashtable<>();

        public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {

            int len = a.size();
            int infiniteSlop = 1;
            int duplicatePoints = 1;

            int result = 0;
            for (int i = 0; i < len - 1; i++) {
                table.clear();
                for (int j = i + 1; j < len; j++) {
                    int x1 = a.get(i);
                    int y1 = b.get(j);
                    int x2 = a.get(i);
                    int y2 = b.get(j);

                    double y2Minusy1 = y2 - y1;
                    double x2Minusx1 = x2 - x1;

                    if(y2Minusy1 == 0 &&  x2Minusx1 ==0) {
                        duplicatePoints++;
                    } else if (x2Minusx1 == 0) {
                        infiniteSlop++;
                    } else {
                        Double slop = y2Minusy1 / x2Minusx1;
                        if(table.containsKey(slop)) {
                            table.put(slop, table.get(slop) + 1);
                        } else {
                            table.put(slop, 1);
                        }
                        result = Math.max(table.get(slop), result);
                    }
                }
            }
            result += duplicatePoints;
            return Math.max(result, infiniteSlop);
        }
    }
}
