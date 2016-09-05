package src;

/**
 * Created by abhijeet on 9/4/16.
 */
public class ParsingInteger {
    public static void main(String[] args) {
        // By default parseInt sets the base as decimal
        System.out.println(Integer.parseInt("1"));
        System.out.println(Integer.parseInt("01"));
        System.out.println(Integer.parseInt("1", 10));

        // Max and min values of integer
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        System.out.println(Integer.parseInt("2147483647"));
        // Following line will throw exception
        System.out.println(Integer.parseInt("2147483648"));
        
    }
}
