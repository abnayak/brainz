package src;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
    public static void main(String[] args) {
        String str = "Dee-Domain-Music#ACRI#864a7419-6963-484c-a3ad-68196cbd2c6c";
        Utility.fromString(str);
    }

    public static class Utility {
        private String clientId;
        private String cardId;

        public Utility(String clientId, String cardId) {
            this.clientId = clientId;
            this.cardId = cardId;
        }

        private static final String REGEX_CAPTURE_ANYTHING = "(.*)";
        protected static final String SEPARATOR = "#ACRI#";

        private static final String REGEX = new StringBuilder()
                .append('^')
                .append(REGEX_CAPTURE_ANYTHING)
                .append(SEPARATOR)
                .append(REGEX_CAPTURE_ANYTHING)
                .append('$')
                .toString();
        private static final Pattern PATTERN = Pattern.compile(REGEX);

        // --------------
        // Public Methods

        @Override
        public String toString() {
            return new StringBuilder()
                    .append(clientId)
                    .append(SEPARATOR)
                    .append(cardId)
                    .toString();
        }

        /**
         * Convert a String into a CardRenderer token if the input string is in the correct format. Example:
         * Dee-Domain-Music#ACRI#864a7419-6963-484c-a3ad-68196cbd2c6c
         * @param token Input String to convert from.
         * @return A ContentToken converted from the input String.
         * @throws IllegalArgumentException If the input string is not in the expected format.
         */
        public static void fromString(String token) {
            if (token == null) {
                throw new IllegalArgumentException("Content token string cannot be null");
            }

            Matcher matcher = PATTERN.matcher(token);
            if (matcher.matches()) {
                String clientId = matcher.group(1);
                String cardId = matcher.group(2);
                System.out.println(clientId +" ..... Hollla .... "+  cardId);
            }
        }
    }

}