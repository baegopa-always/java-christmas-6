package christmas.menuValidatorTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.validator.MenuValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DuplicatedTest {
    @DisplayName("메뉴 입력에 중복이 있으면 예외 발생1")
    @Test
    public void setDuplicatedMenu1() {
        assertThatThrownBy(() -> MenuValidator.validate("타파스-1,타파스-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("메뉴 입력에 중복이 있으면 예외 발생2")
    @Test
    public void setDuplicatedMenu2() {
        assertThatThrownBy(() -> MenuValidator.validate("타파스-1,제로콜라-1,티본스테이크-3,제로콜라-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
