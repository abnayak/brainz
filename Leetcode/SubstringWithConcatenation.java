import java.util.*;

/**
 * Created by abhijeet on 9/5/16.
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * <p>
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * <p>
 * You should return the indices: [0,9].
 */
public class SubstringWithConcatenation {
    public static void main(String[] args) {
        String[] words = {"fooo", "barr", "wing", "ding", "wing"};
        Solution solution = new Solution();
        List<Integer> result = solution.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", words);
        for (Integer i : result) {
            System.out.println(i);
        }
    }

    public static class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> result = new ArrayList<>();

            if (s == null || s.length() == 0 || words == null || words.length == 0) {
                return result;
            }

            Map<String, Integer> counts = new HashMap<>();

            // Count the occurrence of each word to be found
            for (String word : words) {
                if (counts.containsKey(word)) {
                    // Increment the counter if already present.
                    counts.put(word, counts.get(word) + 1);
                } else {
                    // Insert the word for first time.
                    counts.put(word, 1);
                }
            }

            // Each word in words is of constant length
            int wordLen = words[0].length();

            // Increment the count by wordlen
            Map<String, Integer> found = new HashMap<>();
            for (int i = 0; i <= s.length() - wordLen * words.length; i++) {
                // Count the words found
                found.clear();
                int j = 0;
                for (; j < words.length; j++) {
                    String word = s.substring(i + j * wordLen, i + j * wordLen + wordLen);
                    if (counts.containsKey(word)) {
                        if (found.containsKey(word)) {
                            found.put(word, found.get(word) + 1);
                            if(found.get(word) > counts.get(word)) break;
                        } else found.put(word, 1);
                    } else { // This word never occurs in the required word list
                        break;
                    }
                }
                // How check all the count of all the required words in the found list
                // If they match then we have a solution, otherwise skip
                if (j == words.length) result.add(i);
            }

            return result;
        }
    }
}
