package christmas.ui;

import static christmas.domain.constants.Message.EVENT_DATE;
import static christmas.domain.constants.Message.INTRO;
import static christmas.domain.constants.Message.ORDER_MENU;
import static christmas.domain.constants.Message.MENU_INFO;
import static christmas.domain.constants.Message.TOTAL_RAW_PRICE;
import static christmas.domain.constants.Message.NONE;
import static christmas.domain.constants.Message.GIFT_MENU;
import static christmas.domain.constants.Message.BENEFIT_DETAILS;
import static christmas.domain.constants.Message.BENEFIT;
import static christmas.domain.constants.Message.TOTAL_BENEFIT_PRICE;
import static christmas.domain.constants.Message.PRICE;
import static christmas.domain.constants.Message.TOTAL_EXPECTED_PRICE;
import static christmas.domain.constants.Message.DECEMBER_BADGE;

import christmas.domain.Converter;
import christmas.domain.constants.EventBadge;
import christmas.domain.constants.Menu;


import java.util.Map;


public class OutputView {
    public OutputView() {
    }

    public void printIntro() {
        System.out.println(INTRO);
    }

    public void printEventDate(int day) {
        System.out.printf(EVENT_DATE, day);
    }

    public void printMenu(Map<Menu, Integer> menuInventory) {
        System.out.println(ORDER_MENU);
        for (Map.Entry<Menu, Integer> menu : menuInventory.entrySet()) {
            System.out.printf(MENU_INFO, menu.getKey().getName(), menu.getValue());
        }
        System.out.println();
    }

    public void printTotalRawPrice(int price) {
        System.out.printf(TOTAL_RAW_PRICE, Converter.formatPrice(price));
        System.out.println();
    }

    public void printGiftMenu(boolean hasGift) {
        System.out.println(GIFT_MENU);
        if (hasGift) {
            System.out.printf(MENU_INFO, Menu.CHAMPAGNE.getName(), 1);
        }
        if (!hasGift) {
            System.out.print(NONE);
        }
        System.out.println();
    }

    public void printBenefits(Map<String, Integer> benefits) {
        System.out.println(BENEFIT_DETAILS);
        if (benefits.isEmpty()) {
            System.out.println(NONE);
            return;
        }
        for (Map.Entry<String, Integer> benefit : benefits.entrySet()) {
            System.out.printf(BENEFIT, benefit.getKey(), Converter.formatPrice(-benefit.getValue()));
        }
        System.out.println();
    }

    public void printTotalBenefitPrice(int price) {
        System.out.println(TOTAL_BENEFIT_PRICE);
        System.out.printf(PRICE, Converter.formatPrice(-price));
        System.out.println();
    }

    public void printTotalDiscountedPrice(int price) {
        System.out.println(TOTAL_EXPECTED_PRICE);
        System.out.printf(PRICE, Converter.formatPrice(price));
        System.out.println();
    }

    public void printEventBadge(EventBadge badge) {
        System.out.println(DECEMBER_BADGE);
        System.out.println(badge.getName());
    }

}
