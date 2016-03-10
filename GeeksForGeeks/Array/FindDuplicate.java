/**
 * Created by abhijeet on 2/26/16.
 * http://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
 *
 */
public class FindDuplicate {

    public static void main(String[] args) {
        int[] array =  {1, 2, 3, 1, 3, 6, 6};
        for(int i = 0; i < array.length; i++) {
            if(array[i] > 0)
                count(array, i);
        }

        for(int i : array) {
            System.out.println("count: " + i * -1);
        }
    }

    private static void count(int[] array, int index) {

        if( array[index] < 0) {
            array[index]--;
            return;
        } else {
            int temp = array[index];
            array[index] = -1;
            count(array, temp);
        }
    }
}
