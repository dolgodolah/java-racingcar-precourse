package racinggame.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.exception.CustomException;
import racinggame.exception.ErrorCode;

import static org.assertj.core.api.Assertions.*;

class TryCountTest {

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3", "100:100"}, delimiter = ':')
    void 시도회수_입력값은_숫자만_가능(String input, int expected) {
        assertThat(TryCount.of(input).get()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "abc", "number"})
    void 시도회수_입력값으로_숫자외_불가능(String input) {
        assertThatThrownBy(() -> {
            TryCount.of(input);
        }).isInstanceOf(CustomException.class)
                .hasMessageContaining(ErrorCode.INVALID_TRY_COUNT.getMessage());
    }
}