package christmas.calculatorTest;

import static christmas.constants.Constants.DAY_1;
import static christmas.constants.Constants.DAY_25;
import static christmas.constants.Constants.DAY_31;

import christmas.domain.Calculator;
import christmas.domain.constants.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class DDayDiscountTest {
    private static final Map<Menu, Integer> menuInventory1 = Map.of(
            Menu.SALAD, 1);

    @DisplayName("크리스마스 디데이 할인 유효 테스트1")
    @Test
    public void setDayByOne() {
        final Calculator calculator = new Calculator(menuInventory1, DAY_1);
        assertThat(calculator.calculateDDayDiscount()).isEqualTo(1000);
    }

    @DisplayName("크리스마스 디데이 할인 유효 테스트2")
    @Test
    public void setDayByChristmas() {
        final Calculator calculator = new Calculator(menuInventory1, DAY_25);
        assertThat(calculator.calculateDDayDiscount()).isEqualTo(3400);
    }

    @DisplayName("크리스마스 디데이 할인 무효 테스트1")
    @Test
    public void setDayByAfterChristmas() {
        final Calculator calculator = new Calculator(menuInventory1, DAY_31);
        assertThat(calculator.calculateDDayDiscount()).isEqualTo(0);
    }
}
