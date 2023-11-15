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
            if (input.charAt(0) == '0') {
                throw new IllegalArgumentException();
            }
            return Integer.parseInt(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException(DATE_ERROR);
        }
    }

    private static int correctDay(int day) {
        if (day < MIN_DAY || day > MAX_DAY) {
            throw new IllegalArgumentException(DATE_ERROR);
        }
        return day;
    }
}
