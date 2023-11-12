package christmas.domain.constants;

public enum Menu {
    SOUP("Appetizer", "양송이수프", 6_000),
    TAPAS("Appetizer", "타파스", 5_500),
    SALAD("Appetizer", "시저샐러드", 8_000),
    STAKE("MainDish", "티본스테이크", 55_000),
    BBQ("MainDish", "바비큐립", 54_000),
    SEAFOOD_PASTA("MainDish", "해산물파스타", 35_000),
    CHRISTMAS_PASTA("MainDish", "크리스마스파스타", 25_000),
    CHOCO_CAKE("Dessert", "초코케이크", 15_000),
    ICE_CREAM("Dessert", "아이스크림", 5_000),
    ZERO_COKE("Drink", "제로콜라", 3_000),
    RED_WINE("Drink", "레드와인", 60_000),
    CHAMPAGNE("Drink", "샴페인", 25_000);
    private final String category;
    private final String name;
    private final int price;

    Menu(String category, String name, int price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public final String getName() {
        return name;
    }

    public final int getPrice() {
        return price;
    }

    public final String getCategory() {
        return category;
    }
}
