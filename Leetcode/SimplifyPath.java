import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by abhijeet on 9/20/16.
 */
public class SimplifyPath {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifyPath("/..."));
    }

    public static class Solution {
        public String simplifyPath(String path) {
            if(path == null || path.length() ==0) return "";

            String[] strings = path.split("/");

            LinkedList<String> stack = new LinkedList<>();
            for (String str : strings) {
                if(str.length() != 0) {
                    if (str.equals(".")) {
                        continue;
                    } else if (str.equals("..")) {
                        if (!stack.isEmpty()) {
                            stack.removeLast();
                        }
                    } else {
                        stack.addLast(str);
                    }
                }
            }

            StringBuffer sb = new StringBuffer();
            sb.append("/");
            for (int i = 0; i < stack.size(); i++) {
                sb.append(stack.get(i));
                if( i < stack.size()-1) sb.append("/");
            }
            return sb.toString();
        }
    }
}
