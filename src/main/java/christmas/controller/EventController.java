package christmas.controller;

import christmas.domain.EventDetails;
import christmas.domain.constants.Menu;
import christmas.ui.InputView;
import christmas.ui.OutputView;

import java.util.Map;

public class EventController {
    private int day;
    private Map<Menu, Integer> menuInventory;
    private final InputView inputView;
    private final OutputView outputView;

    public EventController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.printIntro();
        input();
        EventDetails eventDetails = new EventDetails(menuInventory, day);
        eventDetails.checkEventOperation();
        displayBenefits(eventDetails);
    }

    private void input() {
        this.day = inputView.readDate();
        this.menuInventory = inputView.readMenu();
    }

    private void displayBenefits(EventDetails eventDetails) {
        outputView.printEventDate(day);
        outputView.printMenu(menuInventory);
        outputView.printTotalRawPrice(eventDetails.calculateTotalPrice());
        outputView.printGiftMenu(eventDetails.hasGift());
        outputView.printBenefits(eventDetails.detailBenefits());
        outputView.printTotalBenefitPrice(eventDetails.calculateTotalBenefitPrice());
        outputView.printTotalDiscountedPrice(eventDetails.calculateExpectedTotalPrice());
        outputView.printEventBadge(eventDetails.getBadge());
    }
}
