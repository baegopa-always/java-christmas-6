package christmas.domain;

import java.time.LocalDate;

public class DateFormatter {
    public DateFormatter() {
    }

    public static int format(int year, int month, int day) {
        LocalDate date = LocalDate.of(year, month, day);
        return date.getDayOfWeek().getValue() % 7;
    }
}
