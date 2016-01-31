
class reverseWordsInString {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "Nayak     1";
        System.out.println(solution.reverseWords(input));
    }
    public static class Solution {
        public String reverseWords(String s) {
            if (s == null) {
                return null;
            }

            if (s.isEmpty()) {
                return "";
            }
            String after = s.trim().replaceAll(" +", " ");
            char[] array = after.toCharArray();

            String[] stringArray = after.split(" ");
            StringBuilder stringBuilder = new StringBuilder();

            for(int i = stringArray.length-1; i >= 0; i--) {
                stringBuilder.append(stringArray[i]);
                if(i != 0){
                    stringBuilder.append(" ");
                }
            }

            return stringBuilder.toString();
        }
    }
}