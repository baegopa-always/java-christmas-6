package christmas.validator;

public class DateValidator {
    public static int validate(String input) {
        int day = parseToInt(input);
        return correctDay(day);
    }

    private static int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private static int correctDay(int day) {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
        return day;
    }
}
