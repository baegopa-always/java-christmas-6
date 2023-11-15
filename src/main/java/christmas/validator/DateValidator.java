package christmas.validator;

import static christmas.domain.constants.ErrorMessage.DATE_ERROR;
import static christmas.domain.constants.Constants.MIN_DAY;
import static christmas.domain.constants.Constants.MAX_DAY;


public class DateValidator {
    public DateValidator() {
    }

    public static int validate(String input) {
        int day = parseToInt(input);
        return correctDay(day);
    }

    private static int parseToInt(String input) {
        try {
            if (startWithZero(input)) {
                throw new IllegalArgumentException();
            }
            return Integer.parseInt(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException(DATE_ERROR);
        }
    }

    private static int correctDay(int day) {
        if (underMinDay(day) || overMaxDay(day)) {
            throw new IllegalArgumentException(DATE_ERROR);
        }
        return day;
    }

    private static boolean startWithZero(String input) {
        try {
            return input.charAt(0) == '0';
        } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean underMinDay(int day) {
        return day < MIN_DAY;
    }

    private static boolean overMaxDay(int day) {
        return day > MAX_DAY;
    }
}
