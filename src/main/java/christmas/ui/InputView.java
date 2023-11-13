package christmas.ui;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.constants.Menu;
import christmas.validator.DateValidator;
import christmas.validator.MenuValidator;

import java.util.Map;

import static christmas.domain.constants.Message.READ_DATE;
import static christmas.domain.constants.Message.READ_MENU;

public class InputView {
    public InputView() {
    }

    public int readDate() {
        try {
            System.out.println(READ_DATE);
            String input = Console.readLine();
            return DateValidator.validate(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return readDate();
        }
    }

    public Map<Menu, Integer> readMenu() {
        try {
            System.out.println(READ_MENU);
            String input = Console.readLine();
            return MenuValidator.validate(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return readMenu();
        }
    }
}
