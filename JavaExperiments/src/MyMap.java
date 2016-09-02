package src;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abhijeen on 7/13/16.
 */
public class MyMap {
    public static void main(String[] args) {
        Map<String, String> idNameMap = test.getMap();

        for(String key : idNameMap.keySet()) {
            System.out.println(idNameMap.get(key));
        }
    }

    public static class test {
        private static Map<String, String> idNameMap;
        static {
            idNameMap = new HashMap<>();
            idNameMap.put("1", "Abhijeet");
            idNameMap.put("2", "Pankaj");
            idNameMap.put("3", "Narula");
        }

        public static Map<String, String> getMap() {
            return idNameMap;
        }
    }
}
