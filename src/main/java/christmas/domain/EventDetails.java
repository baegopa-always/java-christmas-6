package christmas.domain;

import christmas.domain.constants.EventBadge;
import christmas.domain.constants.Menu;

import static christmas.domain.constants.Constants.*;
import static christmas.domain.constants.MenuCategory.DESSERT;
import static christmas.domain.constants.MenuCategory.MAINDISH;

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

    public boolean hasGift() {
        return calculateTotalPrice() > MIN_PRICE_FOR_GIFT;
    }

    public Map<String, Integer> detailBenefits() {
        benefits = new HashMap<>();
        return benefits;
    }

    private int calculateDDayDiscount() {
        if (day <= CHRISTMAS_DAY) {
            return (day + 9) * 100;
        }
        return 0;
    }

    private int calculateWeekdayDiscount() {
        int discount = 0;
        for (Map.Entry<Menu, Integer> menu : menuInventory.entrySet()) {
            if (menu.getKey().getCategory().equals(DESSERT)) {
                discount += menu.getValue() * THIS_YEAR;
            }
        }
        return discount;
    }

    private int calculateWeekendDiscount() {
        int discount = 0;
        for (Map.Entry<Menu, Integer> menu : menuInventory.entrySet()) {
            if (menu.getKey().getCategory().equals(MAINDISH)) {
                discount += menu.getValue() * THIS_YEAR;
            }
        }
        return discount;
    }

    private int calculateSpecialDiscount() {
        if (SPECIAL_DAY.contains(day)) {
            return SPECIAL_DISCOUNT;
        }
        return 0;
    }

    private int calculateGift() {
        if (hasGift()) {
            return Menu.CHAMPAGNE.getPrice();
        }
        return 0;
    }

    private void addBenefit(String Benefit, int price) {
        if (price > 0) {
            benefits.put(Benefit, price);
        }
    }

}
