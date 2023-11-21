package christmas.calculatorTest;

import static christmas.constants.Constants.DAY_1;

import christmas.domain.Calculator;
import christmas.domain.constants.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class TotalPriceTest {
    private static final Map<Menu, Integer> MENU_INVENTORY_1 = Map.of(
            Menu.STEAK, 20);
    private static final Map<Menu, Integer> MENU_INVENTORY_2 = Map.of(
            Menu.STEAK, 1,
            Menu.RED_WINE, 1,
            Menu.ICE_CREAM, 1);

    @DisplayName("전체 메뉴 가격 합산 테스트1")
    @Test
    public void setTotalPrice1() {
        final Calculator calculator = new Calculator(MENU_INVENTORY_1, DAY_1);
        assertThat(calculator.calculateTotalPrice()).isEqualTo(1_100_000);
    }

    @DisplayName("전체 메뉴 가격 합산 테스트2")
    @Test
    public void setTotalPrice2() {
        final Calculator calculator = new Calculator(MENU_INVENTORY_2, DAY_1);
        assertThat(calculator.calculateTotalPrice()).isEqualTo(120_000);
    }
}
