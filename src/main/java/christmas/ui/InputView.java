package christmas.ui;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.constants.Menu;
import christmas.validator.DateValidator;
import christmas.validator.MenuValidator;

import static christmas.domain.constants.Message.INTRO;
import static christmas.domain.constants.Message.MENU_GUIDE;

import java.util.Map;

public class InputView {
    public InputView() {
    }

    public int readDate() {
        try {
            System.out.println(INTRO);
            String input = Console.readLine();
            return DateValidator.validate(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return readDate();
        }
    }

    public Map<Menu, Integer> readMenu() {
        try {
            System.out.println(MENU_GUIDE);
            String input = Console.readLine();
            return MenuValidator.validate(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return readMenu();
        }
    }
}
