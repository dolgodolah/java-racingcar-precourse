package racinggame.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class ProgressBarTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    void ProgressBar_전진(int forwardCount) {
        StringBuilder expected = new StringBuilder();
        ProgressBar progressBar = new ProgressBar();

        for (int i = 0; i < forwardCount; i++) {
            progressBar.forward();
            expected.append("-");
        }

        assertThat(progressBar.toString()).isEqualTo(expected.toString());
        assertThat(progressBar.getProgressBar().length()).isEqualTo(forwardCount);
    }
}