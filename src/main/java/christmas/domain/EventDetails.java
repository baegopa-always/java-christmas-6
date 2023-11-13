package christmas.domain;

import christmas.domain.constants.EventBadge;
import christmas.domain.constants.Menu;

import static christmas.domain.constants.Constants.SPECIAL_DAY;
import static christmas.domain.constants.Constants.THIS_YEAR;
import static christmas.domain.constants.Constants.DECEMBER;
import static christmas.domain.constants.Constants.MIN_PRICE_FOR_GIFT;
import static christmas.domain.constants.Constants.CHRISTMAS_DAY;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class EventDetails {
    private final Map<Menu, Integer> menuInventory;
    private final int day;
    private final LocalDate date;
    private final int dayOfWeek;
    private Map<String, Integer> benefits;

    public EventDetails(Map<Menu, Integer> menuInventory, int day) {
        this.menuInventory = menuInventory;
        this.day = day;
        this.date = LocalDate.of(THIS_YEAR, DECEMBER, day);
        this.dayOfWeek = date.getDayOfWeek().getValue() / 7;
    }

    public int calculateTotalPrice() {
        int price = 0;
        for (Map.Entry<Menu, Integer> menu : menuInventory.entrySet()) {
            price += (menu.getKey().getPrice() * menu.getValue());
        }
        return price;
    }


}
