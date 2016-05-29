package Strings;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by abhijeet on 3/22/16.
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
 You should pack your words in a greedy approach; that is, pack as many words as you can in each line.

 Pad extra spaces ‘ ‘ when necessary so that each line has exactly L characters.
 Extra spaces between words should be distributed as evenly as possible.
 If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 For the last line of text, it should be left justified and no extra space is inserted between words.

 Your program should return a list of strings, where each string represents a single line.

 Example:

 words: ["This", "is", "an", "example", "of", "text", "justification."]

 L: 16.

 Return the formatted lines as:

 [
 "This    is    an",
 "example  of text",
 "justification.  "
 ]

 https://www.interviewbit.com/problems/justified-text/
 */
public class JustifiedText {
    public static void main(String[] args) {

        Solution solution = new Solution();
        //ArrayList<String> stringList = new ArrayList<>(Arrays.asList( "glu", "muskzjyen", "ahxkp", "t", "djmgzzyh", "jzudvh", "raji", "vmipiz", "sg", "rv", "mekoexzfmq", "fsrihvdnt", "yvnppem", "gidia", "fxjlzekp", "uvdaj", "ua", "pzagn", "bjffryz", "nkdd", "osrownxj", "fvluvpdj", "kkrpr", "khp", "eef", "aogrl", "gqfwfnaen", "qhujt", "vabjsmj", "ji", "f", "opihimudj", "awi", "jyjlyfavbg", "tqxupaaknt", "dvqxay", "ny", "ezxsvmqk", "ncsckq", "nzlce", "cxzdirg", "dnmaxql", "bhrgyuyc", "qtqt", "yka", "wkjriv", "xyfoxfcqzb", "fttsfs", "m" ));
        ArrayList<String> stringList = new ArrayList<>(Arrays.asList("What", "must", "be", "shall", "be." ));
        ArrayList<String> result = solution.fullJustify(stringList, 12);

        for(String string : result) {
            System.out.println("[" + string + "]");
        }
    }
    public static class Solution {
        public ArrayList<String> fullJustify(ArrayList<String> a, int b) {
            ArrayList<String> result = new ArrayList<>();
            if(a.size() == 0) {
                return result;
            }

            int i = 0;
            while(i < a.size()) {
                ArrayList<String> strings = new ArrayList<>();
                int len = 0;
                while (i < a.size() && len + a.get(i).length() <= b) {
                    len = len + a.get(i).length() + 1;
                    strings.add(a.get(i));
                    i++;
                }

                int stringLen = 0;
                ArrayList<StringBuilder> builder = new ArrayList<>();
                for(String str : strings) {
                    stringLen += str.length();
                    builder.add(new StringBuilder(str));
                }

                int spaces = b - stringLen;

                if (i >= a.size()) {
                    if (builder.size() > 1) {
                        int anotherSize =0;
                        for (int j = 0; j < builder.size() - 1; j++) {
                            builder.get(j % (builder.size() - 1)).append(" ");
                            anotherSize += builder.get(j % (builder.size() - 1)).toString().length();
                        }

                        anotherSize += builder.get(builder.size()-1).toString().length();
                        char[] chars = new char[b - anotherSize];
                        for (int k = 0; k < b - anotherSize; k++) {
                            chars[k] = ' ';
                        }
                        builder.get(builder.size()-1).append(chars);

                    } else {
                        char[] chars = new char[b - builder.get(0).length()];
                        for (int k = 0; k < b - builder.get(0).length(); k++) {
                            chars[k] = ' ';
                        }
                        builder.get(0).append(chars);
                    }
                } else {
                    if (builder.size() > 1) {
                        for (int j = 0; j < spaces; j++) {
                            builder.get(j % (builder.size() - 1)).append(" ");
                        }
                    } else {
                        char[] chars = new char[b - builder.get(0).length()];
                        for (int k = 0; k < b - builder.get(0).length(); k++) {
                            chars[k] = ' ';
                        }
                        builder.get(0).append(chars);
                    }
                }


                StringBuilder oneString = new StringBuilder();
                for(StringBuilder stringBuilder : builder) {
                    oneString.append(stringBuilder.toString());
                }

                result.add(oneString.toString());
            }
            return result;
        }
    }

}
