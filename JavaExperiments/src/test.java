package src;

/**
 * Created by abhijeen on 7/1/16.
 */
public class test {
    public static void main(String[] args) {
        int[] array = new int[] {1, 9, 2, 3, 4 ,99, 4, 100};
        System.out.println("The max stock price is " + getMaxStockPrice(array));
    }

    static int getMaxStockPrice(int[] values){
        int maxSum=0, currSum=0;

        for (int i=1;i<values.length;i++){
            int diffValue;

            diffValue = values[i]-values[i-1];
            currSum = currSum + diffValue;

            if(currSum<0){
                currSum = 0;
            }
            else{
                if(currSum>maxSum){
                    maxSum = currSum;
                }
            }
            System.out.printf("index: %d, current: %d, max: %d\n", i, currSum, maxSum);
        }

        return maxSum;

    }

}
