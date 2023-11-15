package christmas.validator;

import christmas.domain.constants.Menu;

import static christmas.domain.constants.Constants.MIN_EA;
import static christmas.domain.constants.Constants.MAX_EA;
import static christmas.domain.constants.MenuCategory.DRINK;
import static christmas.domain.constants.ErrorMessage.MAIN_MENU_ERROR;
import static christmas.domain.constants.ErrorMessage.MENU_FORM_ERROR;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class MenuValidator {
    public MenuValidator() {
    }

    private static Map<Menu, Integer> menuInventory;

    public static Map<Menu, Integer> validate(String input) {
        menuInventory = new EnumMap<>(Menu.class);
        List<String> splitedMenu = splitByComma(input);
        parseMenu(splitedMenu);
        checkDuplicated(splitedMenu);
        checkTotalEA();
        checkMainMenu();
        return menuInventory;
    }

    private static List<String> splitByComma(String input) {
        if (correctItemCount(input)) {
            return List.of(input.split(","));
        }
        throw new IllegalArgumentException(MENU_FORM_ERROR);
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
        if (correctMenu(menu)) {
            return List.of(menu.split("-"));
        }
        throw new IllegalArgumentException(MENU_FORM_ERROR);
    }

    private static void makeMenuInventory(List<String> menuInfo) {
        int menuEA = countMenu(menuInfo);
        checkEA(menuEA);
        Menu menu = checkMenuExistence(getMenuName(menuInfo));
        menuInventory.put(menu, menuEA);
    }

    private static void checkDuplicated(List<String> splitedMenu) {
        if (menuInventory.size() != splitedMenu.size()) {
            throw new IllegalArgumentException(MENU_FORM_ERROR);
        }
    }

    private static Menu checkMenuExistence(String menuName) {
        for (Menu menu : Menu.values()) {
            if (matchName(menu, menuName)) {
                return menu;
            }
        }
        throw new IllegalArgumentException(MENU_FORM_ERROR);
    }

    private static void checkEA(int menuEA) {
        if (underMinSize(menuEA) || overMaxSize(menuEA)) {
            throw new IllegalArgumentException(MENU_FORM_ERROR);
        }
    }

    private static void checkTotalEA() {
        int sum = menuInventory
                .values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
        checkEA(sum);
    }

    private static void checkMainMenu() {
        for (Menu menu : menuInventory.keySet()) {
            if (hasMainMenu(menu)) {
                return;
            }
        }
        throw new IllegalArgumentException(MAIN_MENU_ERROR);
    }

    private static boolean correctItemCount(String input) {
        int count = (int) input.chars()
                .filter(comma -> comma == ',')
                .count() + 1;
        return count == input.split(",").length;
    }

    private static boolean correctMenu(String menu) {
        return menu.split("-").length == 2;
    }

    private static boolean underMinSize(int EA) {
        return EA < MIN_EA;
    }

    private static boolean overMaxSize(int EA) {
        return EA > MAX_EA;
    }

    private static boolean hasMainMenu(Menu menu) {
        return !menu.getCategory().equals(DRINK);
    }

    private static boolean matchName(Menu menu, String menuName) {
        return menu.getName().equals(menuName);
    }

    private static int countMenu(List<String> menuInfo) {
        return parseInt(menuInfo.get(1));
    }

    private static String getMenuName(List<String> menuInfo) {
        return menuInfo.get(0);
    }

}
