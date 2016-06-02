package src;

import java.util.Arrays;

/**
 * Created by abhijeet on 5/29/2016.
 * Generate randSeven() method given randFive() method
 */
public class Rand7FromRand5 {
    private static int RANGE = 8;
    private static int SAMPLES = 10000;

    public static void main (String[] args) {
        int[] count = new int[RANGE];
        Arrays.fill(count, 0);

        for (int i = 0; i < SAMPLES; i++) {
            count[randSeven()]++;
        }

        for (int i = 1; i < RANGE; i++) {
            System.out.println(i + " : " + count[i]);
        }
    }

    /**
     * Generate random number 1 - 7 using randFour.
     * @return
     */
    public static int randSeven () {
        return 1 * (getOneToFour() % 2) + 2 * (getOneToFour() % 2) + 4 * (getOneToFour()%2);
    }

    /**
     * Use randFive() and generate random number between 1 - 4
     * @return
     */
    public static int getOneToFour () {
        int oneToFour = randFive();
        while (oneToFour > 4) {
            oneToFour = randFive();
        }
        return oneToFour;
    }

    /**
     * Returns random number between 1 to 5. This is the given method.
     *
     * @return
     */
    public static int randFive () {
        return 1 + ((int) (Math.random() * 10)) % 5;
    }
}
