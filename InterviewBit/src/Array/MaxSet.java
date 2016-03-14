package Array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by abhijeet on 2/16/2016.
 * https://www.interviewbit.com/courses/programming/topics/arrays/problems/maxset/
 */
public class MaxSet {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = { 1967513926, 1540383426, -1303455736, -521595368};

        ArrayList<Integer> input = new ArrayList<Integer>();
        for(int i : ints) {
            input.add(i);
        }
        ArrayList<Integer> result = solution.maxset(input);

        System.out.println("result: " + result.toString());
    }
    public static class Solution {
        public ArrayList<Integer> maxset(ArrayList<Integer> a) {
            ArrayList<Integer> solution = new ArrayList<Integer>();
            long globalMax = a.get(0);
            long localmax = a.get(0);

            System.out.println("maz size: " + Integer.MAX_VALUE);

            int globalStartIndex = 0;
            int globalEndIndex = 0;

            int localStartIndex = 0;
            int localEndIndex = 0;

            for(int i = 1; i <= a.size(); i++) {
                if (i == a.size() || a.get(i) < 0) {
                    if (localmax > globalMax) {
                        globalMax = localmax;
                        globalStartIndex = localStartIndex;
                        globalEndIndex = localEndIndex;
                    } else if(localmax == globalMax) {
                        if(globalEndIndex - globalStartIndex == localEndIndex - localStartIndex) {
                            if (localStartIndex < globalStartIndex) {
                                globalStartIndex = localStartIndex;
                                globalEndIndex = localEndIndex;
                            }
                        } else if( localEndIndex - localStartIndex > globalEndIndex - globalStartIndex){
                            globalStartIndex = localStartIndex;
                            globalEndIndex = localEndIndex;
                        }
                    }
                    continue;
                }

                if(a.get(i-1) < 0) {
                    localStartIndex = i;
                    localEndIndex = i;
                    localmax = 0;
                }

                localmax += a.get(i);
                localEndIndex = i;
            }

            if(globalMax >=0 )
            for(int i = globalStartIndex; i <= globalEndIndex; i++) {
                solution.add(a.get(i));
            }

            return solution;
        }
    }

}
