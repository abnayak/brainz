package src;

/**
 * Created by abhijeet on 9/1/16.
 */
public class ModifyIntArrayInMethod {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        reverseArray(array);
        // print the reversed array
        for(int i : array) {
            System.out.println(i);
        }
    }

    private static void reverseArray(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
