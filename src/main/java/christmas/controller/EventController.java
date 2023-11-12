package christmas.controller;

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
        displayBenefits();

    }

    private void input() {
        this.day = inputView.readDate();
        this.menuInventory = inputView.readMenu();
    }

    private void displayBenefits() {
        outputView.printEventDate(day);
        outputView.printMenu(menuInventory);
    }
}
