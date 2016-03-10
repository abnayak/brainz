import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by abhijeet on 2/22/16.
 * https://leetcode.com/problems/next-permutation/
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *  1,2,3 → 1,3,2
 *  3,2,1 → 1,2,3
 *  1,1,5 → 1,5,1
 */

public class NextPermutation {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {1,1,5};

        solution.nextPermutation(array);

        for(int i : array) {
            System.out.print(i);
        }

    }
    public static class Solution {
        private void reverse(ArrayList<Integer> nums, int begin, int end) {
            while (begin < end) {
                int temp = nums.get(begin);
                nums.set(begin, nums.get(end));
                nums.set(end, temp);
                begin++;
                end--;
            }
        }

        public void nextPermutation(ArrayList<Integer> a) {
            int index;
            int swapWith = -1;
            for(index = 0; index <= a.size() -2; index++) {
                if(a.get(index) < a.get(index+1)) {
                    swapWith = index;
                }
            }

            if (swapWith == -1) {
                Collections.reverse(a);
                return;
            }


            for (index = a.size()-1; index > swapWith; index--) {
                if(a.get(index) > a.get(swapWith)) {
                    break;
                }
            }

            int temp = a.get(swapWith);
            a.set(swapWith, a.get(index));
            a.set(index, temp);

            reverse(a, swapWith+1, a.size()-1);
        }
    }
}
