package christmas.menuValidatorTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.validator.MenuValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class CommaTest {
    @DisplayName("메뉴 입력에 쉼표 단위로 메뉴의 개수가 맞지 않으면 예외 발생1")
    @Test
    public void setMenuByWrongMenuFormForComma1() {
        assertThatThrownBy(() -> MenuValidator.validate(","))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("메뉴 입력에 쉼표 단위로 메뉴의 개수가 맞지 않으면 예외 발생2")
    @Test
    public void setMenuByWrongMenuFormForComma2() {
        assertThatThrownBy(() -> MenuValidator.validate(",,,"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("메뉴 입력에 쉼표 단위로 메뉴의 개수가 맞지 않으면 예외 발생3")
    @Test
    public void setMenuByWrongMenuFormForComma3() {
        assertThatThrownBy(() -> MenuValidator.validate("타파스-1,"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("메뉴 입력에 쉼표 단위로 메뉴의 개수가 맞지 않으면 예외 발생4")
    @Test
    public void setMenuByWrongMenuFormForComma4() {
        assertThatThrownBy(() -> MenuValidator.validate("타파스-1,,"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("메뉴 입력에 쉼표 단위로 메뉴의 개수가 맞지 않으면 예외 발생5")
    @Test
    public void setMenuByWrongMenuFormForComma5() {
        assertThatThrownBy(() -> MenuValidator.validate(",타파스-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("메뉴 입력에 쉼표 단위로 메뉴의 개수가 맞지 않으면 예외 발생6")
    @Test
    public void setMenuByWrongMenuFormForComma6() {
        assertThatThrownBy(() -> MenuValidator.validate(",,타파스-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 입력에 쉼표 단위로 메뉴의 개수가 맞지 않으면 예외 발생7")
    @Test
    public void setMenuByWrongMenuFormForComma7() {
        assertThatThrownBy(() -> MenuValidator.validate(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("메뉴 입력에 쉼표 단위로 메뉴의 개수가 맞지 않으면 예외 발생8")
    @Test
    public void setMenuByWrongMenuFormForComma8() {
        assertThatThrownBy(() -> MenuValidator.validate(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 입력에 쉼표 단위로 메뉴의 개수가 맞지 않으면 예외 발생9")
    @Test
    public void setMenuByWrongMenuFormForComma9() {
        assertThatThrownBy(() -> MenuValidator.validate("타파스-1, ,제로콜라-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 입력에 쉼표 단위로 메뉴의 개수가 맞지 않으면 예외 발생10")
    @Test
    public void setMenuByWrongMenuFormForComma10() {
        assertThatThrownBy(() -> MenuValidator.validate("타파스-1,제로콜라-1,"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("메뉴 입력에 쉼표 단위로 메뉴의 개수가 맞지 않으면 예외 발생11")
    @Test
    public void setMenuByWrongMenuFormForComma11() {
        assertThatThrownBy(() -> MenuValidator.validate(",타파스-1,제로콜라-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 입력 한 개일 경우 유효")
    @Test
    public void setOneMenu() {
        assertThat(MenuValidator.validate("타파스-1"))
                .isInstanceOf(Map.class);
    }
    @DisplayName("메뉴 입력 두 개일 경우 유효")
    @Test
    public void setTwoMenu() {
        assertThat(MenuValidator.validate("타파스-1,제로콜라-1"))
                .isInstanceOf(Map.class);
    }
}
