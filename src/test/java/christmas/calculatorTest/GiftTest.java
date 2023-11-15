package christmas.calculatorTest;

import static christmas.constants.Constants.DAY_1;

import christmas.domain.Calculator;
import christmas.domain.constants.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GiftTest {
    private static final Map<Menu, Integer> MENU_INVENTORY_1 = Map.of(
            Menu.SALAD, 1);
    private static final Map<Menu, Integer> MENU_INVENTORY_2 = Map.of(
            Menu.SOUP, 20);
    private static final Map<Menu, Integer> MENU_INVENTORY_3 = Map.of(
            Menu.CHOCO_CAKE, 8);

    @DisplayName("증정 이벤트 무효 테스트1")
    @Test
    public void setGiftByFalse1() {
        final Calculator calculator = new Calculator(MENU_INVENTORY_1, DAY_1);
        assertThat(calculator.hasGift()).isFalse();
    }

    @DisplayName("증정 이벤트 유효 테스트1")
    @Test
    public void setGiftByTrue1() {
        final Calculator calculator = new Calculator(MENU_INVENTORY_2, DAY_1);
        assertThat(calculator.hasGift()).isTrue();
    }

    @DisplayName("증정 이벤트 유효 테스트2")
    @Test
    public void setGiftByTrue2() {
        final Calculator calculator = new Calculator(MENU_INVENTORY_3, DAY_1);
        assertThat(calculator.hasGift()).isTrue();
    }
}
