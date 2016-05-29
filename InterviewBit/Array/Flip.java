package Array;

import java.util.ArrayList;

/**
 * Created by abhijeet on 2/15/2016.
 */
public class Flip {
    public static void main(String[] args) {
        String A = "010";
        Solution solution = new Solution();
        ArrayList<Integer> list = solution.flip(A);

        System.out.println("solution: " + list.toString());
    }

    public static class Solution {
        public ArrayList<Integer> flip(String A) {
            ArrayList<Integer> solution = new ArrayList<Integer>();
            char[] array = A.toCharArray();
            int[] intArray = new int[array.length];

            for(int i=0; i < array.length; i++) {
                if(array[i] == '0') {
                    intArray[i] = 1;
                } else {
                    intArray[i] = -1;
                }
            }

            int globalMax = 0;
            int localMax = 0;

            int globalStartIndex = intArray.length;
            int globalEndIndex = intArray.length;

            int localStartIndex = 0;
            int localEndIndex = 0;

            for(int i = 0; i< intArray.length; i++) {

                if (localMax + intArray[i] < intArray[i]) {
                    localStartIndex = i;
                    localEndIndex = i;
                } else {
                    localEndIndex = i;
                }

                localMax = Math.max(intArray[i], localMax + intArray[i]);


                if (localMax > 0 && localMax > globalMax) {
                    if(globalEndIndex == array.length) {
                        if ((localStartIndex == localEndIndex && localEndIndex < globalEndIndex) || (localStartIndex < globalStartIndex)) {
                            globalStartIndex = localStartIndex;
                            globalEndIndex = localEndIndex;
                        }
                    } else {
                        if((globalStartIndex == localStartIndex && globalEndIndex < localEndIndex) || (globalStartIndex < localStartIndex)) {
                            globalStartIndex = localStartIndex;
                            globalEndIndex = localEndIndex;
                        }
                    }
                }
                globalMax = Math.max(globalMax, localMax);
            }

            if(globalMax >0) {
                solution.add(globalStartIndex+1);
                solution.add(globalEndIndex+1);
            }

            return solution;
        }
    }

}
