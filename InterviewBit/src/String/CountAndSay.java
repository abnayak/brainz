package String;

/**
 * Created by abhijeet on 3/16/16.
 * https://www.interviewbit.com/problems/count-and-say/
 * The count-and-say sequence is the sequence of integers beginning as follows:

 1, 11, 21, 1211, 111221, ...
 1 is read off as one 1 or 11.
 11 is read off as two 1s or 21.

 21 is read off as one 2, then one 1 or 1211.

 Given an integer n, generate the nth sequence.

 Note: The sequence of integers will be represented as a string.

 Example:

 if n = 2,
 the sequence is 11.
 */
public class CountAndSay {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countAndSay(2));
    }


    public static class Solution {
        public String countAndSay(int a) {
            StringBuilder previous = new StringBuilder();
            StringBuilder current = new StringBuilder();

            previous.append('1');
            a--;
            while (a > 0) {
                int beginIndex = 0;
                int endIndex = 0;
                while(endIndex < previous.length()) {
                    if(endIndex + 1 < previous.length() && previous.charAt(endIndex) == previous.charAt(endIndex+1)) {
                        endIndex++;
                    } else {
                        int count = (endIndex - beginIndex) + 1;
                        current.append(count);
                        current.append(previous.charAt(beginIndex));
                        endIndex++;
                        beginIndex = endIndex;
                    }
                }
                previous = current;
                current = new StringBuilder();
                a--;
            }
            return previous.toString();
        }
    }

}
