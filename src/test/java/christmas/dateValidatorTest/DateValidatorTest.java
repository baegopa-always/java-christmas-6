package christmas.dateValidatorTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.validator.DateValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DateValidatorTest {
    @DisplayName("날짜 입력에 숫자가 아닌 경우 예외 발생1")
    @Test
    public void setDateByString1() {
        assertThatThrownBy(() -> DateValidator.validate("x"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("날짜 입력에 숫자가 아닌 경우 예외 발생2")
    @Test
    public void setDateByString2() {
        assertThatThrownBy(() -> DateValidator.validate(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("날짜 입력에 숫자가 아닌 경우 예외 발생3")
    @Test
    public void setDateByString3() {
        assertThatThrownBy(() -> DateValidator.validate("."))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("날짜 입력에 숫자가 아닌 경우 예외 발생4")
    @Test
    public void setDateByString4() {
        assertThatThrownBy(() -> DateValidator.validate(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("날짜 입력에 1 이상 31 이하의 숫자가 아닐 경우 예외 발생1")
    @Test
    public void setDateByWrongNumber1() {
        assertThatThrownBy(() -> DateValidator.validate("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("날짜 입력에 1 이상 31 이하의 숫자가 아닐 경우 예외 발생2")
    @Test
    public void setDateByWrongNumber2() {
        assertThatThrownBy(() -> DateValidator.validate("32"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("날짜 입력에 1 이상 31 이하의 숫자가 아닐 경우 예외 발생3")
    @Test
    public void setDateByWrongNumber3() {
        assertThatThrownBy(() -> DateValidator.validate("-25"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("날짜 입력에 1 이상 31 이하의 숫자일 경우 유효1")
    @Test
    public void setDateByCorrectNumber1() {
        assertThat(DateValidator.validate("1")).isEqualTo(1);
    }

    @DisplayName("날짜 입력에 1 이상 31 이하의 숫자일 경우 유효2")
    @Test
    public void setDateByCorrectNumber2() {
        assertThat(DateValidator.validate("31")).isEqualTo(31);
    }
}
