/**
 * Created by abhijeet on 6/1/2016.
 */
public class FindPermutationByMergingTwoStrings {
    public static void main (String[] args) {
        String s1 = "hey";
        String s2 = "sam";
        StringBuffer stringBuffer = new StringBuffer();
        printPermutation(s1, s2, 0, 0, stringBuffer);
    }

    private static void printPermutation (String s1, String s2, int i, int j, StringBuffer stringBuffer) {
        if(s1 == null || s2 == null)
            return;

        if(s1 == null && s2 != null)
            System.out.println(s2);

        if(s1 != null && s2 == null)
            System.out.println(s1);

        if(i == s1.length() && j == s2.length()) {
            System.out.println(stringBuffer.toString());
        }

        if(i < s1.length()) {
            StringBuffer temp = new StringBuffer(stringBuffer);
            temp.append(s1.charAt(i));
            printPermutation(s1,s2, i+1, j, temp);
        }

        if(j < s2.length()) {
            StringBuffer temp = new StringBuffer(stringBuffer);
            temp.append(s2.charAt(j));
            printPermutation(s1,s2,i,j+1, temp);
        }
    }
}
