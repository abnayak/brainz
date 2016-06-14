import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by abhijeet on 6/12/2016.
 */
public class DiffK {

    public static void main (String[] args) {

    }

    public class Solution {
        public int diffPossible (ArrayList<Integer> a, int b) {
            int solution = 0;
            int diff = a.get(a.size()-1) - a.get(0);
            if( diff < b ) {
                return solution;
            }

            Set<Integer> set = new HashSet<>();

            for(int i : a) {

            }

        }
    }

}
