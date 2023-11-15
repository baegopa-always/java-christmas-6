package christmas.calculatorTest;

import christmas.domain.Calculator;
import christmas.domain.constants.EventBadge;
import christmas.domain.constants.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static christmas.constants.Constants.DAY_1;
import static christmas.constants.Constants.PRICE_3000;
import static christmas.constants.Constants.PRICE_5000;
import static christmas.constants.Constants.PRICE_10000;
import static christmas.constants.Constants.PRICE_20000;
import static org.assertj.core.api.Assertions.assertThat;

public class BadgeTest {
    private static final Map<Menu, Integer> menuInventory1 = Map.of(
            Menu.SALAD, 1);

    @DisplayName("뱃지 유효성 테스트 - 별")
    @Test
    public void setBadgeByStar() {
        final Calculator calculator = new Calculator(menuInventory1, DAY_1);
        assertThat(calculator.checkBadge(PRICE_5000)).isEqualTo(EventBadge.STAR);
    }

    @DisplayName("뱃지 유효성 테스트 - 트리")
    @Test
    public void setBadgeByTree() {
        final Calculator calculator = new Calculator(menuInventory1, DAY_1);
        assertThat(calculator.checkBadge(PRICE_10000)).isEqualTo(EventBadge.TREE);
    }

    @DisplayName("뱃지 유효성 테스트 - 산타")
    @Test
    public void setBadgeBySanta() {
        final Calculator calculator = new Calculator(menuInventory1, DAY_1);
        assertThat(calculator.checkBadge(PRICE_20000)).isEqualTo(EventBadge.SANTA);
    }

    @DisplayName("뱃지 유효성 테스트 - 없음")
    @Test
    public void setBadgeByNone() {
        final Calculator calculator = new Calculator(menuInventory1, DAY_1);
        assertThat(calculator.checkBadge(PRICE_3000)).isEqualTo(EventBadge.NONE);
    }
}
