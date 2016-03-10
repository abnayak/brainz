import java.util.ArrayList;

/**
 * Created by abhijeet on 2/14/16.
 * https://www.interviewbit.com/courses/programming/topics/arrays/problems/flip/
 */

public class flip {
    public static void main(String[] args) {


    }

    public static class Solution {
        public ArrayList<Integer> flip(String A) {
            char[] chars = A.toCharArray();
            int oneCount = 0;
            int zeroCount = 0;

            for(int i=0; i< chars.length; i++) {
                if(chars[i] == '1') {
                    oneCount++;
                } else {
                    zeroCount++;
                }
            }

            int begin = 0;
            int end = chars.length-1;
            int l = -1;
            int r = -1;
            oneCount = zeroCount;

            while (begin <= end) {
                if(chars[begin] == 1 && chars[end] == 1) {
                    begin++;
                    end--;
                    oneCount -= 2;
                } else if(chars[begin] == 1 && chars[end] == 0) {
                    begin++;
                    oneCount--;
                } else if(chars[begin] == 0 && chars[end] == 1) {
                    end--;
                    oneCount--;
                } else if(chars[begin] == 0 && chars[end] == 0) {
                    end--;
                    zeroCount--;
                }
            }


            return null;
        }
    }
}
