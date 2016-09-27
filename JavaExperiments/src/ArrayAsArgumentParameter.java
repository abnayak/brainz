package src;

/**
 * Created by abhijeet on 9/23/16.
 */
public class ArrayAsArgumentParameter {
    public static void main(String[] args) {
        int[] array = new int[2];
        array[0] = 1;
        array[1] = 2;
        for (int i : array) {
            System.out.println(i);
        }
    }
    private static void test(int[] array) {
        array[0] = 10;
        array[1] = 20;
    }
}
