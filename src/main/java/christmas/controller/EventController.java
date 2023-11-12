package christmas.controller;

import christmas.ui.InputView;
import christmas.ui.OutputView;

import java.util.HashMap;

public class EventController {
    private int day;
    private HashMap<String, Integer> menuInventory;
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

    }
}
