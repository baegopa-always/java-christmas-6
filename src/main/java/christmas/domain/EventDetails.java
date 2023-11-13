package christmas.domain;

import christmas.domain.constants.EventBadge;
import christmas.domain.constants.Menu;

import static christmas.domain.constants.Constants.SPECIAL_DISCOUNT_PRICE;
import static christmas.domain.constants.Constants.THIS_YEAR;
import static christmas.domain.constants.Constants.DECEMBER;
import static christmas.domain.constants.Constants.MIN_PRICE_FOR_GIFT;
import static christmas.domain.constants.Constants.CHRISTMAS_DISCOUNT;
import static christmas.domain.constants.Constants.WEEKDAY_DISCOUNT;
import static christmas.domain.constants.Constants.WEEKEND_DISCOUNT;
import static christmas.domain.constants.Constants.SPECIAL_DISCOUNT;
import static christmas.domain.constants.Constants.GIFT_EVENT;
import static christmas.domain.constants.Constants.SPECIAL_DAY;
import static christmas.domain.constants.Constants.CHRISTMAS_DAY;
import static christmas.domain.constants.Constants.MIN_PRICE_FOR_EVENT;
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

    public boolean checkEventOperation() {
        return calculateTotalPrice() >= MIN_PRICE_FOR_EVENT;
    }

    public int calculateTotalBenefitPrice() {
        return benefits.values().stream().mapToInt(Integer::intValue).sum();
    }

    public int calculateExpectedTotalPrice() {
        return calculateTotalPrice() + calculateGift() - calculateTotalBenefitPrice();
    }

    public Map<String, Integer> detailBenefits() {
        benefits = new HashMap<>();
        if (checkEventOperation()) {
            addBenefit(CHRISTMAS_DISCOUNT, calculateDDayDiscount());
            if (dayOfWeek >= 0 && dayOfWeek <= 4) {
                addBenefit(WEEKDAY_DISCOUNT, calculateWeekdayDiscount());
            }
            if (dayOfWeek == 5 || dayOfWeek == 6) {
                addBenefit(WEEKEND_DISCOUNT, calculateWeekendDiscount());
            }
            addBenefit(SPECIAL_DISCOUNT, calculateSpecialDiscount());
            addBenefit(GIFT_EVENT, calculateGift());
        }
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
            return SPECIAL_DISCOUNT_PRICE;
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

    public EventBadge getBadge() {
        int price = calculateTotalBenefitPrice();
        for (EventBadge badge : EventBadge.values()) {
            if (badge.getPrice() >= price) {
                return badge;
            }
        }
        return EventBadge.NONE;
    }
}
