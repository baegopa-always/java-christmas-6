package christmas.domain;

import christmas.domain.constants.EventBadge;
import christmas.domain.constants.Menu;

import java.util.Map;

public class EventDetails {
    private final Calculator calculator;
    private Map<String, Integer> benefits;
    private int totalPrice;
    private int totalBenefitPrice;
    private int expectedTotalPrice;
    private boolean giftFlag;
    private boolean eventOperation;
    private EventBadge badge;

    public EventDetails(Map<Menu, Integer> menuInventory, int day) {
        this.calculator = new Calculator(menuInventory, day);
        setDetails();
    }

    private void setDetails() {
        setTotalPrice();
        setEventOperation();
        setGift();
        setDetailBenefits();
        setTotalBenefitPrice();
        setExpectedTotalPrice();
        setBadge();
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    private void setTotalPrice() {
        totalPrice = calculator.calculateTotalPrice();
    }

    private void setEventOperation() {
        eventOperation = calculator.checkEventOperation();
    }

    public boolean getGift() {
        return giftFlag;
    }

    private void setGift() {
        giftFlag = calculator.hasGift();
    }

    public Map<String, Integer> getDetailBenefits() {
        return benefits;
    }

    private void setDetailBenefits() {
        if (eventOperation) {
            benefits = calculator.createBenefitDetails();
        }
    }

    public int getTotalBenefitPrice() {
        return totalBenefitPrice;
    }

    private void setTotalBenefitPrice() {
        totalBenefitPrice = calculator.calculateTotalBenefitPrice();
    }

    public int getExpectedTotalPrice() {
        return expectedTotalPrice;
    }

    private void setExpectedTotalPrice() {
        expectedTotalPrice = calculator.calculateExpectedTotalPrice();
    }

    public EventBadge getBadge() {
        return badge;
    }

    private void setBadge() {
        badge = calculator.checkBadge(totalBenefitPrice);
    }
}
