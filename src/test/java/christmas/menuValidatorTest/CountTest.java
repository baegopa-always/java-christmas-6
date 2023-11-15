package christmas.menuValidatorTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.validator.MenuValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class CountTest {
    @DisplayName("주문 메뉴의 수량이 1 미만 일 경우 예외 발생1")
    @Test
    public void setMenuByUnderSize1() {
        assertThatThrownBy(() -> MenuValidator.validate("타파스-0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 메뉴의 수량이 1 미만 일 경우 예외 발생2")
    @Test
    public void setMenuByUnderSize2() {
        assertThatThrownBy(() -> MenuValidator.validate("타파스-1,제로콜라-0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 메뉴의 수량이 20을 초과할 경우 예외 발생1")
    @Test
    public void setMenuByOverSize1() {
        assertThatThrownBy(() -> MenuValidator.validate("타파스-21"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 메뉴의 수량이 20을 초과할 경우 예외 발생2")
    @Test
    public void setMenuByOverSize2() {
        assertThatThrownBy(() -> MenuValidator.validate("타파스-20,제로콜라-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 메뉴의 수량이 20을 초과할 경우 예외 발생3")
    @Test
    public void setMenuByOverSize3() {
        assertThatThrownBy(() -> MenuValidator.validate("티본스테이크-2,바비큐립-1,초코케이크-2,제로콜라-1,양송이수프-4,타파스-6,시저샐러드-5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 메뉴의 수량이 20을 초과할 경우 예외 발생4")
    @Test
    public void setMenuByOverSize4() {
        assertThatThrownBy(() -> MenuValidator.validate("티본스테이크-999999999999999999"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 메뉴의 수량이 20을 초과할 경우 예외 발생5")
    @Test
    public void setMenuByOverSize5() {
        assertThatThrownBy(() -> MenuValidator.validate("티본스테이크-11,제로콜라-10"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 메뉴의 수량이 1이상 20 이하일 경우 유효1")
    @Test
    public void setMenuByMaxSize1() {
        assertThat(MenuValidator.validate("타파스-10,제로콜라-10"))
                .isInstanceOf(Map.class);
    }

    @DisplayName("주문 메뉴의 수량이 1이상 20 이하일 경우 유효2")
    @Test
    public void setMenuByMaxSize2() {
        assertThat(MenuValidator.validate("타파스-1"))
                .isInstanceOf(Map.class);
    }

}
