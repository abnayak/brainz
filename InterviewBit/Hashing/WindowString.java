package Hashing;

import java.util.Hashtable;

/**
 * Created by abhijeet on 12/6/16.
 */
public class WindowString {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }

    public static class Solution {
        public String minWindow(String S, String T) {
            String solution = "";
            if (S == null || T == null || S.length() == 0 || T.length() == 0 || S.length() < T.length())
                return solution;

            int begin = 0;
            int end = 0;
            Hashtable<Character, Integer> table = new Hashtable<>();
            for (int i = 0; i < T.length(); i++) {
                char ch = T.charAt(i);
                if (table.containsKey(ch)) {
                    table.put(ch, table.get(ch) + 1);
                } else {
                    table.put(ch, 1);
                }
            }

            Hashtable<Character, Integer> tempTable = new Hashtable<>(table);

            while (end < S.length()) {
                while (tempTable.size() > 0 && end < S.length()) {
                    char ch = S.charAt(end);
                    if (tempTable.containsKey(ch)) {
                        int count = tempTable.get(ch);
                        if (count == 1) {
                            tempTable.remove(ch);
                        } else {
                            tempTable.put(ch, count - 1);
                        }
                    }
                    end++;
                }

                end--;
                if (tempTable.size() == 0) {
                    String tempSolution = S.substring(begin, end + 1);
                    if (solution.length() == 0) {
                        solution = tempSolution;
                    } else {
                        solution = solution.length() < tempSolution.length() ? solution : tempSolution;
                    }
                }

                while (begin <= end) {
                    char ch = S.charAt(begin);
                    if (table.containsKey(ch)) {
                        tempTable.put(ch, 1);
                        begin++;
                        break;
                    }
                    begin++;
                }
            }

            return solution;
        }
    }
}