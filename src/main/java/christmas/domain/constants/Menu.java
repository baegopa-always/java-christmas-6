package christmas.domain.constants;

import static christmas.domain.constants.MenuCategory.APPETIZER;
import static christmas.domain.constants.MenuCategory.MAINDISH;
import static christmas.domain.constants.MenuCategory.DESSERT;
import static christmas.domain.constants.MenuCategory.DRINK;

public enum Menu {
    SOUP(APPETIZER, "양송이수프", 6_000),
    TAPAS(APPETIZER, "타파스", 5_500),
    SALAD(APPETIZER, "시저샐러드", 8_000),
    STEAK(MAINDISH, "티본스테이크", 55_000),
    BBQ(MAINDISH, "바비큐립", 54_000),
    SEAFOOD_PASTA(MAINDISH, "해산물파스타", 35_000),
    CHRISTMAS_PASTA(MAINDISH, "크리스마스파스타", 25_000),
    CHOCO_CAKE(DESSERT, "초코케이크", 15_000),
    ICE_CREAM(DESSERT, "아이스크림", 5_000),
    ZERO_COKE(DRINK, "제로콜라", 3_000),
    RED_WINE(DRINK, "레드와인", 60_000),
    CHAMPAGNE(DRINK, "샴페인", 25_000);

    private final MenuCategory menuCategory;
    private final String name;
    private final int price;

    Menu(MenuCategory menuCategory, String name, int price) {
        this.menuCategory = menuCategory;
        this.name = name;
        this.price = price;
    }

    public final String getName() {
        return name;
    }

    public final int getPrice() {
        return price;
    }

    public final MenuCategory getCategory() {
        return menuCategory;
    }
}
