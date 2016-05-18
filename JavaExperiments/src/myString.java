package src;

/**
 * Created by abhijeet on 3/15/16.
 */

// Bench mark the stringbuilder and stringbuffer

public class myString {
    public static void main(String[] args) {
        String string = "abcdefghijklmnopqrstuvwxyz";
        final long count = 100000;
        long beginTime  = 0;
        long endTime = 0;

        // bench mark the stringbuffer
        StringBuffer stringBuffer = new StringBuffer();
        beginTime = System.currentTimeMillis();
        for(long i = 0; i < count; i++) {
            stringBuffer.append(stringBuffer.toString());
        }
        endTime = System.currentTimeMillis();
        stringBuffer = null;

        System.out.println("Total time taken by StringBuffer : " + (endTime - beginTime));

        StringBuilder stringBuilder = new StringBuilder();
        beginTime = System.currentTimeMillis();
        for(long i = 0; i < count; i++) {
            stringBuilder.append(string);
        }
        endTime = System.currentTimeMillis();

        System.out.println("Total time taken by StringBuilder : " + (endTime - beginTime));

        beginTime = System.currentTimeMillis();
        String newString = new String();
        beginTime = System.currentTimeMillis();
        /*for(long i = 0; i < count; i++) {
            newString += string;
        }*/
        endTime = System.currentTimeMillis();

        System.out.println("Total time taken by normal String : " + (endTime - beginTime));


    }

    private void testFun() {
        String str = "abhijeet";
        System.out.printf("char: " + str.charAt(0));
    }



}
