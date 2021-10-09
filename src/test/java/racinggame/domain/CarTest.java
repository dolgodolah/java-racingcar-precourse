package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    private static final String CAR_NAME = "name";

    @Test
    void Car_초기생성() {
        Car car = new Car(CAR_NAME);

        assertThat(car.getCarName()).isEqualTo(CAR_NAME);
        assertThat(car.getProgressBar().length()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    void Car_전진(int forwardCount) {
        Car car = new Car(CAR_NAME);
        StringBuilder progressBar = new StringBuilder();
        for (int i = 0; i < forwardCount; i++) {
            car.forward();
            progressBar.append("-");
        }

        assertThat(car.getProgressBar()).isEqualTo(progressBar.toString());
        assertThat(car.getProgressBar().length()).isEqualTo(forwardCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    void Car_전진_상태_출력(int forwardCount) {
        Car car = new Car(CAR_NAME);
        StringBuilder progressBar = new StringBuilder();
        for (int i = 0; i< forwardCount; i++) {
            car.forward();
            progressBar.append("-");
        }

        assertThat(car.toString()).isEqualTo(CAR_NAME + " : " + progressBar.toString());
    }
}
