package christmas.calculatorTest;

import christmas.domain.Calculator;
import christmas.domain.constants.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static christmas.constants.Constants.DAY_1;
import static christmas.constants.Constants.DAY_3;
import static org.assertj.core.api.Assertions.assertThat;

public class TotalBenefitPriceTest {
    private static final Map<Menu, Integer> MENU_INVENTORY_1 = Map.of(
            Menu.STEAK, 20);
    private static final Map<Menu, Integer> MENU_INVENTORY_2 = Map.of(
            Menu.ICE_CREAM, 10);
    private static final Map<Menu, Integer> MENU_INVENTORY_3 = Map.of(
            Menu.CHOCO_CAKE, 8);

    @DisplayName("총혜택 금액 테스트1")
    @Test
    public void setTotalBenefitPrice1() {
        final Calculator calculator = new Calculator(MENU_INVENTORY_1, DAY_1);
        calculator.createBenefitDetails();
        assertThat(calculator.calculateTotalBenefitPrice()).isEqualTo(66_460);
    }
    @DisplayName("총혜택 금액 테스트2")
    @Test
    public void setTotalBenefitPrice2() {
        final Calculator calculator = new Calculator(MENU_INVENTORY_2, DAY_3);
        calculator.createBenefitDetails();
        assertThat(calculator.calculateTotalBenefitPrice()).isEqualTo(22_430);
    }
    @DisplayName("총혜택 금액 테스트3")
    @Test
    public void setTotalBenefitPrice3() {
        final Calculator calculator = new Calculator(MENU_INVENTORY_3, DAY_3);
        calculator.createBenefitDetails();
        assertThat(calculator.calculateTotalBenefitPrice()).isEqualTo(43_384);
    }
}
