package christmas.validator;

import christmas.domain.constants.Menu;

import static christmas.domain.constants.Constants.TWO;
import static christmas.domain.constants.Constants.MIN_EA;
import static christmas.domain.constants.Constants.MAX_EA;
import static christmas.domain.constants.MenuCategory.DRINK;
import static christmas.domain.constants.ErrorMessage.MAIN_MENU_ERROR;
import static christmas.domain.constants.ErrorMessage.MENU_FORM_ERROR;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class MenuValidator {
    private static Map<Menu, Integer> menuInventory;

    public static Map<Menu, Integer> validate(String input) {
        menuInventory = new EnumMap<>(Menu.class);
        List<String> splitedMenu = splitByComma(input);
        parseMenu(splitedMenu);
        checkDuplicated(splitedMenu);
        checkTotalEA();
        checkMainMenu();
        return menuInventory;
        // 테스트 위해 나누기
    }

    private static List<String> splitByComma(String input) {
        return List.of(input.split(","));
    }

    private static void parseMenu(List<String> splitedMenu) {
        for (String menu : splitedMenu) {
            List<String> menuInfo = splitByHypen(menu);
            makeMenuInventory(menuInfo);
        }
    }

    private static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException(MENU_FORM_ERROR);
        }
    }

    private static List<String> splitByHypen(String menu) {
        if (menu.split("-").length != TWO) {
            throw new IllegalArgumentException(MENU_FORM_ERROR);
        }
        return List.of(menu.split("-"));
    }

    private static void makeMenuInventory(List<String> menuInfo) {
        int menuEA = parseInt(menuInfo.get(1));
        checkEA(menuEA);
        Menu menu = checkMenuExistence(menuInfo.get(0));
        menuInventory.put(menu, menuEA);
    }

    private static void checkDuplicated(List<String> splitedMenu) {
        if (menuInventory.size() != splitedMenu.size()) {
            throw new IllegalArgumentException(MENU_FORM_ERROR);
        }
    }

    private static Menu checkMenuExistence(String menuName) {
        for (Menu menu : Menu.values()) {
            if (menu.getName().equals(menuName)) {
                return menu;
            }
        }
        throw new IllegalArgumentException(MENU_FORM_ERROR);
    }

    private static void checkEA(int menuEA) {
        if (menuEA < MIN_EA || menuEA > MAX_EA) {
            throw new IllegalArgumentException(MENU_FORM_ERROR);
        }
    }

    private static void checkTotalEA() {
        int count = menuInventory
                .values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
        checkEA(count);
    }

    private static void checkMainMenu() {
        for (Menu menu : menuInventory.keySet()) {
            if (!menu.getCategory().equals(DRINK)) {
                return;
            }
        }
        throw new IllegalArgumentException(MAIN_MENU_ERROR);
    }
}
