/**
 * Created by abhijeet on 9/5/16.
 * https://leetcode.com/problems/implement-strstr/
 */
public class StrStr {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("aaa", "a"));
    }

    public static class Solution {
        public int strStr(String haystack, String needle) {
            final int needleLen = needle.length();
            final int hayStackLen = haystack.length();

            // Invalid cases
            if (haystack == null || needle == null) return -1;
            if (hayStackLen == 0 && needleLen == 0) return 0;
            if (needleLen == 0) return 0;
            if (needleLen > hayStackLen) return -1;

            final char[] haystackArray = haystack.toCharArray();
            final char[] needleArray = needle.toCharArray();
            // Do the actual search
            for (int i = 0; i <= hayStackLen - needleLen; i++) {
                int j = 0;
                for (; j < needleLen; j++) {
                    if (haystackArray[i + j] != needleArray[j])
                        break;
                }
                if (j == needleLen) return i;
            }
            // If you reached here, then needle was not found in the haystack
            return -1;
        }
    }
}
