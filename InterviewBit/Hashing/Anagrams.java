package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by abhijeet on 12/4/16.
 */
public class Anagrams {
    public static void main(String[] args) {

    }

    public class Solution {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
            if (a == null || a.size() == 0) return list;
            HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();
            for (int i = 0; i < a.size(); i++) {
                String s = a.get(i);
                char[] array = s.toCharArray();
                Arrays.sort(array);
                String str = new String(array);
                if (hashMap.containsKey(str)) {
                    ArrayList<Integer> list = hashMap.get(str);
                    list.add(i+1);
                    hashMap.put(str, list);
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i+1);
                    hashMap.put(str, list);
                }
            }

            for(String s : hashMap.keySet()) {
                list.add(hashMap.get(s));
            }
            return list;
        }
    }
}
