package christmas.domain;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class Converter {
    public Converter() {
    }

    public static int formatDate(int year, int month, int day) {
        LocalDate date = LocalDate.of(year, month, day);
        return date.getDayOfWeek().getValue() % 7;
    }

    public static String formatPrice(int price) {
        return new DecimalFormat("###,###").format(price);
    }
}
