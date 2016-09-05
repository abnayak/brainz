package src;

/**
 * Created by abhijeen on 8/8/16.
 */
public class EnumWithNull {
    public static void main(String[] args) {

    }
    public static enum colors  {
        WHITE("white"),
        BLACK("Black");

        String color;

        colors(String color) {
            this.color = color;
        }
    }
}
