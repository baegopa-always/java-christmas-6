package christmas.domain.constants;

public enum EventBadge {
    SANTA("산타", 20_000),
    TREE("트리", 10_000),
    STAR("별", 5_000),
    NONE("없음",0);

    private final String name;
    private final int price;

    EventBadge(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public final String getName() {
        return name;
    }

    public final int getPrice() {
        return price;
    }
}
