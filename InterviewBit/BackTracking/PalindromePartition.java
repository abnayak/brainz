package BackTracking;

import java.util.ArrayList;

/**
 * Created by abhijeet on 10/22/16.
 * https://www.interviewbit.com/problems/palindrome-partitioning/
 * Given a string s, partition s such that every string of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * <p>
 * For example, given s = "aab",
 * Return
 * <p>
 * [
 * ["a","a","b"]
 * ["aa","b"],
 * ]
 * Ordering the results in the answer : Entry i will come before Entry j if :
 * len(Entryi[0]) < len(Entryj[0]) OR
 * (len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR
 * <p>
 * <p>
 * <p>
 * (len(Entryi[0]) == len(Entryj[0]) AND … len(Entryi[k] < len(Entryj[k]))
 * In the given example,
 * ["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa")
 */

public class PalindromePartition {
    public static void main(String[] args) {
        String str = "aa";
        Solution solution = new Solution();
        ArrayList<ArrayList<String>> result = solution.partition(str);
        for (ArrayList<String> i : result) {
            System.out.println(i.toString());
        }
    }

    public static class Solution {
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        public ArrayList<ArrayList<String>> partition(String a) {
            findSolution(new ArrayList<>(), 0, a, "");
            return result;
        }

        private void findSolution(ArrayList<String> partialSolution, int index, String input, String palindromicStr) {
            if (index >= input.length()) {
                result.add(new ArrayList<>(partialSolution));
                return;
            }

            for (int i = index + 1; i <= input.length(); i++) {
                if (isPalindrome(palindromicStr + input.substring(index, i))) {
                    partialSolution.add(palindromicStr + input.substring(index, i));
                    findSolution(partialSolution, i, input, "");
                    partialSolution.remove(partialSolution.size() - 1);
                }
            }
        }

        private boolean isPalindrome(String s) {
            int start = 0;
            int end = s.length() - 1;
            while (start < end) {
                if (s.charAt(start) != s.charAt(end)) return false;
                start++;
                end--;
            }
            return true;
        }
    }
}