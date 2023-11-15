package christmas.calculatorTest;

import static christmas.constants.Constants.DAY_3;
import static christmas.constants.Constants.DAY_26;
import static christmas.constants.Constants.DAY_31;

import christmas.domain.Calculator;
import christmas.domain.constants.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static christmas.domain.constants.Constants.SPECIAL_DISCOUNT;
import static org.assertj.core.api.Assertions.assertThat;

public class SpecialDiscountTest {
    private static final Map<Menu, Integer> MENU_INVENTORY_1 = Map.of(
            Menu.SALAD, 1);

    @DisplayName("특별 할인 유효 테스트1")
    @Test
    public void setDateBySpecialDay1() {
        final Calculator calculator = new Calculator(MENU_INVENTORY_1, DAY_3);
        Map<String, Integer> benefits = calculator.createBenefitDetails();
        assertThat(benefits.get(SPECIAL_DISCOUNT)).isEqualTo(1000);
    }

    @DisplayName("특별 할인 유효 테스트2")
    @Test
    public void setDateBySpecialDay2() {
        final Calculator calculator = new Calculator(MENU_INVENTORY_1, DAY_31);
        Map<String, Integer> benefits = calculator.createBenefitDetails();
        assertThat(benefits.get(SPECIAL_DISCOUNT)).isEqualTo(1000);
    }

    @DisplayName("특별 할인 무효 테스트1")
    @Test
    public void setDateByUsualDay1() {
        final Calculator calculator = new Calculator(MENU_INVENTORY_1, DAY_26);
        Map<String, Integer> benefits = calculator.createBenefitDetails();
        assertThat(benefits.containsKey(SPECIAL_DISCOUNT)).isFalse();
    }
}
