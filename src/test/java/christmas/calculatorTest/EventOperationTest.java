package christmas.calculatorTest;

import static christmas.constants.Constants.DAY_1;

import christmas.domain.Calculator;
import christmas.domain.constants.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class EventOperationTest {
    private static final Map<Menu, Integer> MENU_INVENTORY_1 = Map.of(
            Menu.SALAD, 1);
    private static final Map<Menu, Integer> MENU_INVENTORY_2 = Map.of(
            Menu.TAPAS, 1,
            Menu.ZERO_COKE, 1);
    private static final Map<Menu, Integer> MENU_INVENTORY_3 = Map.of(
            Menu.ICE_CREAM, 2);

    @DisplayName("이벤트 적용 불가 테스트1")
    @Test
    public void setEventByFalse1() {
        final Calculator calculator = new Calculator(MENU_INVENTORY_1, DAY_1);
        assertThat(calculator.checkEventOperation()).isFalse();
    }

    @DisplayName("이벤트 적용 불가 테스트2")
    @Test
    public void setEventByFalse2() {
        final Calculator calculator = new Calculator(MENU_INVENTORY_2, DAY_1);
        assertThat(calculator.checkEventOperation()).isFalse();
    }

    @DisplayName("이벤트 적용 가능 테스트1")
    @Test
    public void setEventByTrue1() {
        final Calculator calculator = new Calculator(MENU_INVENTORY_3, DAY_1);
        assertThat(calculator.checkEventOperation()).isTrue();
    }
}
