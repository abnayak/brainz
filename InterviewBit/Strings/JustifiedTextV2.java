package Strings;

import java.util.ArrayList;
import java.util.List;

public class JustifiedTextV2 {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("This");
        words.add("is");
        words.add("an");
        words.add("example");
        words.add("of");
        words.add("text");
        words.add("justification");

        Solution solution = new Solution();
        ArrayList<String> result = solution.fullJustify(words, 16);
        System.out.println(result);
    }

    public static class Solution {
        public ArrayList<String> fullJustify(ArrayList<String> A, int B) {
            ArrayList<String> strings = new ArrayList<>();
            LineBuilder lineBuilder = new LineBuilder(B);
            for (String word : A) {
                if (lineBuilder.canAcceptMore(word)) {
                    lineBuilder.addWord(word);
                } else {
                    strings.add(lineBuilder.build());
                    lineBuilder = new LineBuilder(B);
                    lineBuilder.addWord(word);
                }
            }

            if (lineBuilder.totalStringLength > 0) {
                strings.add(lineBuilder.plainBuild());
            }

            return strings;
        }

        public static class LineBuilder {
            public int totalStringLength = 0;
            int maxLen;
            List<StringBuffer> stringBuffers = new ArrayList<>();

            public LineBuilder(int maxLen) {
                this.maxLen = maxLen;
            }

            public boolean canAcceptMore(String word) {
                int spaceCount = stringBuffers.size() - 1;
                if (word.length() + totalStringLength + spaceCount <= maxLen) {
                    return true;
                } else {
                    return false;
                }
            }

            public void addWord(String word) {
                totalStringLength += word.length();
                stringBuffers.add(new StringBuffer().append(word));
            }

            public String build() {
                StringBuilder result = new StringBuilder();
                int spacesNeeded = maxLen - totalStringLength;

                if (stringBuffers.size() == 1 || stringBuffers.size() == 2) {
                    for (int i = 1; i < spacesNeeded; i++) {
                        stringBuffers.get(0).append(" ");
                    }
                } else {
                    int divisor = stringBuffers.size() - 1;
                    for (int i = 0; i < spacesNeeded; i++) {
                        stringBuffers.get(i % divisor).append(" ");
                    }
                }

                for (StringBuffer stringBuffer : stringBuffers) {
                    result.append(stringBuffer.toString());
                }

                return result.toString();
            }

            public String plainBuild() {
                StringBuffer result = new StringBuffer();

                for (StringBuffer stringBuffer : stringBuffers) {
                    if (result.length() == 0) {
                        result.append(stringBuffer.toString());
                    } else {
                        result.append(" ").append(stringBuffer.toString());
                    }
                }
                return result.toString();
            }

        }
    }
}
