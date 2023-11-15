package christmas.menuValidatorTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.validator.MenuValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class MainMenuTest {
    @DisplayName("주문 메뉴에 음료만 있을 경우 예외 발생1")
    @Test
    public void setMenuByOnlyDrinks1() {
        assertThatThrownBy(() -> MenuValidator.validate("제로콜라-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 메뉴에 음료만 있을 경우 예외 발생2")
    @Test
    public void setMenuByOnlyDrinks2() {
        assertThatThrownBy(() -> MenuValidator.validate("레드와인-20"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 메뉴에 음료만 있을 경우 예외 발생3")
    @Test
    public void setMenuByOnlyDrinks3() {
        assertThatThrownBy(() -> MenuValidator.validate("제로콜라-1,레드와인-1,샴페인-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 메뉴에 음료 외 메뉴가 포함될 경우 유효1")
    @Test
    public void setMenuWithMain1() {
        assertThat(MenuValidator.validate("타파스-1,제로콜라-19"))
                .isInstanceOf(Map.class);
    }

    @DisplayName("주문 메뉴에 음료 외 메뉴가 포함될 경우 유효2")
    @Test
    public void setMenuWithMain2() {
        assertThat(MenuValidator.validate("제로콜라-3,레드와인-2,샴페인-1,초코케이크-1"))
                .isInstanceOf(Map.class);
    }

}
