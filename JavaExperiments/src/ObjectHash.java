package src;

/**
 * Created by abhijeet on 10/26/2016.
 * This class is testing various hash values using Object.hash() method.
 */
public class ObjectHash {
    public static void main(String[] args) {
        String name1 = "Abhijeet";
        String name2 = "Abhijeet";
        System.out.println(name1.hashCode());
        System.out.println(name2.hashCode());
    }
}
