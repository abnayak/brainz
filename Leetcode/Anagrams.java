import java.util.*;

/**
 * Created by abhijeet on 9/12/16.
 * https://leetcode.com/problems/anagrams/
 */
public class Anagrams {
    public static void main(String[] args) {

    }

    public class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> table = new HashMap<>();
            for (String str : strs) {
                char[] array = str.toCharArray();
                Arrays.sort(array);
                String key = new String(array);
                if(table.containsKey(key)) {
                    table.get(key).add(str);
                } else {
                    List<String> value = new LinkedList<>();
                    value.add(str);
                    table.put(key, value);
                }
            }

            Set<String> keys = table.keySet();
            List<List<String>> solution = new ArrayList<>();
            for(String key : keys) {
                solution.add(table.get(key));
            }

            return solution;
        }
    }
}
