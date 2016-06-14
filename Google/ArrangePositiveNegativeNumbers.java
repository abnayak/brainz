import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by abhijeet on 6/9/2016.
 */
public class ArrangePositiveNegativeNumbers {
    public static void main (String[] args) {
        List<Integer> array = new ArrayList<Integer>() {{
            add(1);
            add(-2);
            add(3);
            add(-4);
            add(5);
            add(-6);
            add(7);
            add(-8);
            add(9);
            add(-10);
        }};


    }
    public static void sort(List<Integer> array, int begin) {

    }
    public static void merge(List<Integer> array, int begin1, int end1, int begin2, int end2) {
        int i = begin1;
        int j = begin2;

        while (i <= end1 && j <= end2) {
            while (i <= end1 && array.get(i) < 0) i++;
            while (j <= end2 && array.get(j) > 0) j++;

            Collections.swap(array, i , j);
            i++;
            j++;
        }
    }


}
