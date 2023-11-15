package christmas.menuValidatorTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.validator.MenuValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParsingTest {
    @DisplayName("메뉴 입력에 유형이 맞지 않으면 예외 발생1")
    @Test
    public void setMenuByWrongMenuFormForParsing1() {
        assertThatThrownBy(() -> MenuValidator.validate("타파스--1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 입력에 유형이 맞지 않으면 예외 발생2")
    @Test
    public void setMenuByWrongMenuFormForParsing2() {
        assertThatThrownBy(() -> MenuValidator.validate("타파스-1,제로콜라--1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 입력에 유형이 맞지 않으면 예외 발생3")
    @Test
    public void setMenuByWrongMenuFormForParsing3() {
        assertThatThrownBy(() -> MenuValidator.validate("타파-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 입력에 유형이 맞지 않으면 예외 발생4")
    @Test
    public void setMenuByWrongMenuFormForParsing4() {
        assertThatThrownBy(() -> MenuValidator.validate("티본스테이크-0,타파스-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 입력에 유형이 맞지 않으면 예외 발생5")
    @Test
    public void setMenuByWrongMenuFormForParsing5() {
        assertThatThrownBy(() -> MenuValidator.validate("티본스테이크-20,타파스--1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
