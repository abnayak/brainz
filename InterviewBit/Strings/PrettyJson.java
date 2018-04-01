package Strings;

import java.util.ArrayList;

public class PrettyJson {
    public static void main(String[] args) {
        String line = "[\"foo\", {\"bar\":[\"baz\",null,1.0,2]}]";
        Solution solution = new Solution();
        ArrayList<String> result = solution.prettyJSON(line);
        System.out.println(result);
    }

    public static class Solution {
        public ArrayList<String> prettyJSON(String A) {
            ArrayList<Integer> tabCount = new ArrayList<>();
            tabCount.add(0);
            ArrayList<String> result = new ArrayList<>();

            for (int i = 0; i < A.length(); ) {
                char ch = A.charAt(i);
                String line = "";
                if (ch == '[' || ch == '{') {
                    int tabs = tabCount.get(tabCount.size() - 1);
                    for (int j = 1; j < tabs; j++) {
                        line += "\t";
                    }
                    line += ch;
                    i++;
                } else if (ch == ']' || ch == '}') {
                    int tabs = tabCount.get(tabCount.size() - 1) - 1;
                    for (int j = 1; j < tabs; j++) {
                        line += "\t";
                    }
                    line += ch;
                    i++;
                } else {
                    // Add tabs
                    int tabs = tabCount.get(tabCount.size() - 1) + 1;
                    tabCount.add(tabs);
                    for (int j = 1; j < tabs; j++) {
                        line += "\t";
                    }
                    while (ch != '{' || ch != '[' || ch != '}' || ch != ']') {
                        line += ch;
                        i++;
                        if (ch == ':' || ch == ',') {
                            break;
                        }
                        if(i < A.length())
                            ch = A.charAt(i);
                    }
                }
                result.add(line);
            }
            return result;
        }
    }


}
