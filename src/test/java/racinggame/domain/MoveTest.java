package racinggame.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class MoveTest {

    @ParameterizedTest
    @CsvSource(value = {"0:false", "1:false", "2:false", "3:false", "4:true",
            "5:true", "6:true", "7:true", "8:true", "9:true"}, delimiter = ':')
    void VALUE가_4이상이면_true_3이하이면_false(int input, boolean expected) {
        Move move = new Move(input);
        assertThat(move.isForward()).isEqualTo(expected);
    }
}