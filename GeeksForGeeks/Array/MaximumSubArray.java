/**
 * Created by abhijeet on 2/15/2016.
 * Find the start and end index of the subarray whose sum is maximum
 */
public class MaximumSubArray {
    public static void main(String[] args) {
        int[] a = {-1, -3, -4, -1, -2, -1, -5, -1};

        int globalMax = a[0];
        int localMax = a[0];

        int startIndex=0;
        int endIndex=0;

        int globalStartIndex=0;
        int globalEndIndex=0;

        for(int i=1; i< a.length; i++) {
            if (localMax + a[i] < a[i]) {
                startIndex = i;
            } else {
                endIndex = i;
            }

            if (globalMax < localMax + a[i]) {
                globalEndIndex = endIndex;
                globalStartIndex = startIndex;
            }

            localMax = Math.max(a[i], localMax + a[i]);
            globalMax = Math.max(globalMax, localMax);
        }

        System.out.println("max sub array: " + globalMax);
        System.out.println("start index: " +  globalStartIndex + " end index: " + globalEndIndex);
    }
}
