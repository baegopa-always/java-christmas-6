package christmas.calculatorTest;

import christmas.domain.Calculator;
import christmas.domain.constants.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static christmas.constants.Constants.DAY_1;
import static christmas.constants.Constants.DAY_3;
import static org.assertj.core.api.Assertions.assertThat;

public class ExpectedTotalPriceTest {
    private static final Map<Menu, Integer> MENU_INVENTORY_1 = Map.of(
            Menu.STEAK, 20);
    private static final Map<Menu, Integer> MENU_INVENTORY_2 = Map.of(
            Menu.ICE_CREAM, 10);
    private static final Map<Menu, Integer> MENU_INVENTORY_3 = Map.of(
            Menu.CHOCO_CAKE, 8);

    @DisplayName("예상 결제 금액 테스트1")
    @Test
    public void setExpectedTotalPrice1() {
        final Calculator calculator = new Calculator(MENU_INVENTORY_1, DAY_1);
        calculator.createBenefitDetails();
        assertThat(calculator.calculateExpectedTotalPrice()).isEqualTo(1_058_540);
    }

    @DisplayName("예상 결제 금액 테스트2")
    @Test
    public void setExpectedTotalPrice2() {
        final Calculator calculator = new Calculator(MENU_INVENTORY_2, DAY_3);
        calculator.createBenefitDetails();
        assertThat(calculator.calculateExpectedTotalPrice()).isEqualTo(27_570);
    }

    @DisplayName("예상 결제 금액 테스트3")
    @Test
    public void setExpectedTotalPrice3() {
        final Calculator calculator = new Calculator(MENU_INVENTORY_3, DAY_3);
        calculator.createBenefitDetails();
        assertThat(calculator.calculateExpectedTotalPrice()).isEqualTo(101_616);
    }
}
