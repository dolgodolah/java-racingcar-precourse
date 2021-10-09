package racinggame.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.exception.CustomException;
import racinggame.exception.ErrorCode;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class CarNameTest {

    @Test
    void 차_이름_5자초과() {
        assertThatThrownBy(() -> {
            new CarName("developer");
        }).isInstanceOf(CustomException.class)
                .hasMessageContaining(ErrorCode.INVALID_NAME_LENGTH.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    void 차_이름_5자이하(String input) {
        CarName carName = new CarName(input);
        assertThat(carName.getName()).isEqualTo(input);
    }

}