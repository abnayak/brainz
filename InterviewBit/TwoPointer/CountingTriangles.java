package TwoPointer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by abhijeet on 10/5/16.
 */
public class CountingTriangles {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
    public static class Solution {
        public int nTriang(ArrayList<Integer> A) {
            Collections.sort(A);
            int count = 0;
            for (int i = 0; i < A.size() - 2; i++) {
                int k = i + 2;
                for (int j = i+1; j < A.size() - 1; j++) {
                    while(k < A.size() && A.get(i) + A.get(j) > A.get(k)) k++;

                    count += (k - j) + 1;
                }
            }
            return count;
        }
    }

}
