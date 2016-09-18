/**
 * Created by abhijeet on 9/18/16.
 */
public class LenghtOfLastWord {
    public class Solution {
        public int lengthOfLastWord(String s) {
            String[] strings = s.split(" ");
            if(strings.length == 0) {
                return 0;
            }
            return strings[strings.length -1].length();
        }
    }
}
