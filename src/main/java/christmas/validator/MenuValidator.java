package christmas.validator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuValidator {
    private static Map<String, Integer> menuInventory;

    public static Map<String, Integer> validate(String input) {
        menuInventory = new HashMap();
        List<String> splitedMenu = splitByComma(input); // 쉼표 단위로 구분,, 패턴 ?
        // 하이픈 단위로 구분
        // 중복
        // 있는 메뉴인가
        // 메뉴의 개수가 1이상 20 이하인가
        // 전체 메뉴 개수가 20이하 인가
        // 해시맵으로 리턴
        // menu들은 enum으로 ? 매칭되는가
        // 음료만 주문했는가
        return menuInventory;
    }

    private static List<String> splitByComma(String input) {
        try {
            if (!input.contains(",")) {
                throw new IllegalArgumentException();
            }
            return List.of(input.split(","));
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("컴마로 안나뉨");
        }
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
            throw new IllegalArgumentException("숫자가 아님");
        }
    }

    private static List<String> splitByHypen(String menu) {
        try {
            return List.of(menu.split("-"));
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("하이픈으로 나뉘어지지 않음");
        }
    }

    private static void makeMenuInventory(List<String> menuInfo) {
        int menuEA = parseInt(menuInfo.get(1));
        checkEA(menuEA);
        Menu menu = checkMenuExistence(menuInfo.get(0));
        menuInventory.put(menu, menuEA);
    }

    private static void checkDuplicated(List<String> splitedMenu) {
        if (menuInventory.size() != splitedMenu.size()) {
            throw new IllegalArgumentException("중복된 메뉴 존재");
        }
    }

    private static Menu checkMenuExistence(String menuName) {
        for (Menu menu : Menu.values()) {
            if (menu.getName().equals(menuName)) {
                return menu;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 메뉴");
    }

    private static void checkEA(int menuEA) {
        if (menuEA < MIN_EA || menuEA > MAX_EA) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
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
        throw new IllegalArgumentException("음료만 주문 시, 주문할 수 없습니다.");
    }
}
