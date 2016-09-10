package src;

/**
 * Created by abhijeet on 9/8/16.
 */
public class PassByValue {
    public static void main(String[] args) {
        int i = 1;
        int j = 2;
        test(i, j);
        System.out.println(i + " " + j);

        Integer ii = new Integer(1);
        Integer jj = new Integer(2);
        testInteger(ii, jj);
        System.out.println(ii + " " + jj);
    }

    public static void test(int i, int j) {
        i = 10;
        j = 20;
    }

    public static void testInteger(Integer i, Integer j) {
        // dummy method
    }
}
