package src;

/**
 * Created by abhijeen on 7/14/16.
 */
public class EnumTest {
    public static void main(String[] args) {
        // Test the new enum class
        System.out.println(Events.FIRST_EVENT);
        Events events = Events.valueOf("secondEvent");
        System.out.println(events.toString());
    }

    public enum Events {
        FIRST_EVENT("firstEvent"),
        SECOND_EVENT("secondEvent");

        String eventName;

        Events(String eventName) {
            this.eventName = eventName;
        }

        @Override
        public String toString() {
            return eventName;
        }
    }


}
