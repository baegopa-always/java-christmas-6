package christmas.validator;

import static christmas.domain.constants.ErrorMessage.DATE_ERROR;

public class DateValidator {
    public static int validate(String input) {
        int day = parseToInt(input);
        return correctDay(day);
    }

    private static int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException(DATE_ERROR);
        }
    }

    private static int correctDay(int day) {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException(DATE_ERROR);
        }
        return day;
    }
}
