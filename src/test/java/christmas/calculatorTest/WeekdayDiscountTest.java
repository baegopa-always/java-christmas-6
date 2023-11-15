package christmas.calculatorTest;

import christmas.domain.Calculator;
import christmas.domain.constants.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static christmas.constants.Constants.DAY_3;
import static christmas.domain.constants.Constants.WEEKDAY_DISCOUNT;
import static org.assertj.core.api.Assertions.assertThat;

public class WeekdayDiscountTest {
    private static final Map<Menu, Integer> MENU_INVENTORY_1 = Map.of(
            Menu.BBQ, 1);
    private static final Map<Menu, Integer> MENU_INVENTORY_2 = Map.of(
            Menu.SEAFOOD_PASTA, 20);
    private static final Map<Menu, Integer> MENU_INVENTORY_3 = Map.of(
            Menu.CHOCO_CAKE, 8);
    private static final Map<Menu, Integer> MENU_INVENTORY_4 = Map.of(
            Menu.CHOCO_CAKE, 8,
            Menu.ZERO_COKE, 3,
            Menu.ICE_CREAM, 3);

    @DisplayName("평일 메인 메뉴 할인 예외 테스트1")
    @Test
    public void setMenuWithMainDish1() {
        final Calculator calculator = new Calculator(MENU_INVENTORY_1, DAY_3);
        Map<String, Integer> benefits = calculator.createBenefitDetails();
        assertThat(benefits.containsKey(WEEKDAY_DISCOUNT)).isFalse();
    }

    @DisplayName("평일 메인 메뉴 할인 예외 테스트2")
    @Test
    public void setMenuWithMainDish2() {
        final Calculator calculator = new Calculator(MENU_INVENTORY_2, DAY_3);
        Map<String, Integer> benefits = calculator.createBenefitDetails();
        assertThat(benefits.containsKey(WEEKDAY_DISCOUNT)).isFalse();
    }

    @DisplayName("평일 디저트 할인 테스트1")
    @Test
    public void setMenuWithDessert1() {
        final Calculator calculator = new Calculator(MENU_INVENTORY_3, DAY_3);
        Map<String, Integer> benefits = calculator.createBenefitDetails();
        assertThat(benefits.get(WEEKDAY_DISCOUNT)).isEqualTo(16_184);
    }

    @DisplayName("평일 디저트 할인 테스트2")
    @Test
    public void setMenuWithDessert2() {
        final Calculator calculator = new Calculator(MENU_INVENTORY_4, DAY_3);
        Map<String, Integer> benefits = calculator.createBenefitDetails();
        assertThat(benefits.get(WEEKDAY_DISCOUNT)).isEqualTo(22_253);
    }

}
