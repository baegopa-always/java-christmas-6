package christmas.domain;

import java.text.DecimalFormat;

public class PriceFormatter {
    public PriceFormatter() {
    }

    public static String format(int price) {
        return new DecimalFormat("###,###").format(price);
    }
}
