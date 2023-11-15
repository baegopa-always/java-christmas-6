package christmas.domain;

import christmas.domain.constants.EventBadge;
import christmas.domain.constants.Menu;

import java.util.HashMap;
import java.util.Map;

import static christmas.domain.constants.Constants.THIS_YEAR;
import static christmas.domain.constants.Constants.DECEMBER;
import static christmas.domain.constants.Constants.MIN_PRICE_FOR_EVENT;
import static christmas.domain.constants.Constants.MIN_PRICE_FOR_GIFT;
import static christmas.domain.constants.Constants.CHRISTMAS_DAY;
import static christmas.domain.constants.Constants.CHRISTMAS_DISCOUNT;
import static christmas.domain.constants.Constants.WEEKEND_DISCOUNT;
import static christmas.domain.constants.Constants.WEEKDAY_DISCOUNT;
import static christmas.domain.constants.Constants.SPECIAL_DISCOUNT;
import static christmas.domain.constants.Constants.GIFT_EVENT;
import static christmas.domain.constants.Constants.SPECIAL_DISCOUNT_PRICE;
import static christmas.domain.constants.Constants.SPECIAL_DAY;
import static christmas.domain.constants.Constants.SUNDAY_NUM;
import static christmas.domain.constants.Constants.THURSDAY_NUM;
import static christmas.domain.constants.Constants.FRIDAY_NUM;
import static christmas.domain.constants.Constants.SATURDAY_NUM;
import static christmas.domain.constants.MenuCategory.DESSERT;
import static christmas.domain.constants.MenuCategory.MAINDISH;


public class Calculator {
    private final int dayOfWeek;
    private final Map<Menu, Integer> menuInventory;
    private final int day;
    private final Map<String, Integer> benefits;

    public Calculator(Map<Menu, Integer> menuInventory, int day) {
        this.menuInventory = menuInventory;
        this.day = day;
        this.dayOfWeek = Converter.formatDate(THIS_YEAR, DECEMBER, day);
        benefits = new HashMap<>();
    }

    public int calculateTotalPrice() {
        int price = 0;
        for (Map.Entry<Menu, Integer> menu : menuInventory.entrySet()) {
            price += menu.getKey().getPrice() * menu.getValue();
        }
        return price;
    }

    public boolean checkEventOperation() {
        return calculateTotalPrice() >= MIN_PRICE_FOR_EVENT;
    }

    public boolean hasGift() {
        return calculateTotalPrice() > MIN_PRICE_FOR_GIFT;
    }

    public Map<String, Integer> createBenefitDetails() {
        addBenefit(CHRISTMAS_DISCOUNT, calculateDDayDiscount());
        if (isWeekDay()) {
            addBenefit(WEEKDAY_DISCOUNT, calculateWeekdayDiscount());
        }
        if (isWeekEnd()) {
            addBenefit(WEEKEND_DISCOUNT, calculateWeekendDiscount());
        }
        addBenefit(SPECIAL_DISCOUNT, calculateSpecialDiscount());
        addBenefit(GIFT_EVENT, calculateGift());
        return benefits;
    }

    private void addBenefit(String benefit, int price) {
        if (price > 0) {
            benefits.put(benefit, price);
        }
    }

    public int calculateDDayDiscount() {
        if (day <= CHRISTMAS_DAY) {
            return (day + 9) * 100;
        }
        return 0;
    }

    private int calculateWeekdayDiscount() {
        int discount = 0;
        for (Map.Entry<Menu, Integer> menu : menuInventory.entrySet()) {
            if (isDessert(menu.getKey())) {
                discount += calculateWeekDiscount(menu.getValue());
            }
        }
        return discount;
    }

    private int calculateWeekendDiscount() {
        int discount = 0;
        for (Map.Entry<Menu, Integer> menu : menuInventory.entrySet()) {
            if (isMainDish(menu.getKey())) {
                discount += calculateWeekDiscount(menu.getValue());
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

    public int calculateTotalBenefitPrice() {
        return benefits.values().stream().mapToInt(Integer::intValue).sum();
    }

    public int calculateExpectedTotalPrice() {
        return calculateTotalPrice() + calculateGift() - calculateTotalBenefitPrice();
    }

    public EventBadge checkBadge(int price) {
        for (EventBadge badge : EventBadge.values()) {
            if (badge.getPrice() <= price) {
                return badge;
            }
        }
        return EventBadge.NONE;
    }

    private int calculateWeekDiscount(int count) {
        return count * THIS_YEAR;
    }

    private boolean isWeekDay() {
        return dayOfWeek >= SUNDAY_NUM && dayOfWeek <= THURSDAY_NUM;
    }

    private boolean isWeekEnd() {
        return dayOfWeek == FRIDAY_NUM || dayOfWeek == SATURDAY_NUM;
    }

    private boolean isDessert(Menu menu) {
        return menu.getCategory().equals(DESSERT);
    }

    private boolean isMainDish(Menu menu) {
        return menu.getCategory().equals(MAINDISH);
    }
}
