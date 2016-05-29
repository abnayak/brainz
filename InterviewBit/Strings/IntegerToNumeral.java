package Strings;

import java.util.Stack;

/**
 * Created by abhijeet on 3/22/16.
 * Another question which belongs to the category of questions which are intentionally stated vaguely.
 Expectation is that you will ask for correct clarification or you will state your assumptions before you start coding.

 Given an integer, convert it to a roman numeral, and return a string corresponding to its roman numeral version

 Input is guaranteed to be within the range from 1 to 3999.

 Example :

 Input : 5
 Return : "V"

 Input : 14
 Return : "XIV"
 Note : This question has a lot of scope of clarification from the interviewer. Please take a moment to think of all the
 needed clarifications and see the expected response using “See Expected Output” For the purpose of this question,
 https://projecteuler.net/about=roman_numerals has very detailed explanations.
 */
public class IntegerToNumeral {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(49));
    }
    public static class Solution {
        private coin[] coins;
        private Stack<Integer> stack;
        class coin {
            public int value;
            public int count;
            public coin(int value, int count) {
                this.value = value;
                this.count = count;
            }
        }

        public String intToRoman(int a) {
            coins = new coin[7];
            coins[0] = new coin(1000, 10);
            coins[1] = new coin(500,1);
            coins[2] = new coin(100, 10);
            coins[3] = new coin(50, 1);
            coins[4] = new coin(10, 10);
            coins[5] = new coin(5, 1);
            coins[6] = new coin(1, 10);
            stack = new Stack<Integer> ();

            findSolution(a);

            System.out.println(stack.toString());

            return null;
        }

        int solutionFound = 0;
        public void findSolution(int a) {
            if(a < 10) {
                solutionFound = 1;
                stack.push(a);
                return;
            }

            for(int i=0; i < coins.length; i++) {
                if(coins[i].count > 0 && coins[i].value <= a) {
                    stack.push(coins[i].value);
                    coins[i].count = coins[i].count -1;

                    findSolution(a - coins[i].value);
                    if(solutionFound == 0) {
                        stack.pop();
                        coins[i].count = coins[i].count+1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

}
