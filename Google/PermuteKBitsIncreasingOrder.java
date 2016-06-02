import java.util.Arrays;
import java.util.Collections;

/**
 * Created by abhijeet on 5/30/2016.
 * https://www.careercup.com/question?id=5726391455711232
 */
public class PermuteKBitsIncreasingOrder {
    public static void main (String[] args) {
        final int K = 3;

        int[] bits = new int[K];
        Arrays.fill(bits, 0);

        int stop = K;
        while (stop > 0) {
            stop--;
            bits[K-1] = 1;
            bits = printAllPermutations(bits);
        }
    }

    private static int[] printAllPermutations(int[] bits) {
        // print the first bits
        for(int i: bits) {
            System.out.print(i);
        }

        while (true) {
            int i = 0;
            int swapIndex = -1;
            while (i < bits.length-1) {
                if(bits[i] < bits[i+1]) {
                    swapIndex = i;
                }
                i++;
            }

            // No more permutations can be found, return from here.
            if(swapIndex == -1) {
                return bits;
            }

            int bigElementFromEnd = bits.length-1;
            for(i = bits.length-1; i > swapIndex; i--) {
                if(bits[swapIndex] < bits[i]) {
                    bigElementFromEnd = i;
                    break;
                }
            }

            // Swap swapIndex and swapIndex+1
            int temp = bits[swapIndex];
            bits[swapIndex] = bits[bigElementFromEnd];
            bits[bigElementFromEnd] = temp;

            for(int p = swapIndex,  q = bits.length-1; i < q; p++,q--) {
                temp = bits[p];
                bits[p] = bits[q];
                bits[q] = temp;
            }


            System.out.println("");
            for(int val: bits) {
                System.out.printf("%d", val);
            }
            System.out.println("");
            return bits;
        }
    }
}
