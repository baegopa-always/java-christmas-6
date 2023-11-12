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

    private static void splitByHypen(List<String> splitedMenu) {
        for (String menu : splitedMenu) {
            menu.split("-");
        }

    }
}
