package String;

import java.util.Arrays;

/**
 * Created by abhijeet on 3/9/16.
 * Find all the permutations of a string without recursion and string might have duplicates
 * Solution is discussed at:
 * https://www.quora.com/Whats-an-algorithm-to-print-the-permutations-of-a-string-without-recursion
 */
public class PermutationWithoutRecursion {

    public static void main(String[] args) {
        char[] array = {'1','2','3', '1'};
        printPermutation(array);
    }

    public static void printPermutation(char[] array) {
        Arrays.sort(array);

        while(true) {
            int i = -1;
            for(int index = 0; index+1 < array.length; index++) {
                if(array[index] < array[index+1]) {
                    i = index;
                }
            }

            // If there is no such i then finish the loop
            if ( i == -1)
                return;

            int j = -1;
            for(int index = array.length-1; index > i; index--) {
                if(array[index] > array[i]) {
                    j = index;
                    break;
                }
            }

            // Swap ith and jth element
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;

            // rotate elements begining i+1 to end of array
            int begin = i+1;
            int end = array.length-1;
            while(begin < end) {
                temp = array[begin];
                array[begin] = array[end];
                array[end] = temp;

                begin++;
                end--;
            }
            System.out.println(array);
        }
    }

}
