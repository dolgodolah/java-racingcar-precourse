package racinggame.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    private static final String CAR_NAME = "name";
    private static final String BAR = "-";

    @Test
    void Car_초기생성() {
        Car car = new Car(CAR_NAME);

        assertThat(car.getCarName()).isEqualTo(CAR_NAME);
        assertThat(car.getProgressBar().length()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void Car_4이상이면_전진(int value) {
        Car car = new Car(CAR_NAME);
        Move move = new Move(value);
        car.forwardOrStop(move);

        assertThat(car.getProgressBar()).isEqualTo(BAR);
        assertThat(car.getProgressBar().length()).isEqualTo(1);
        assertThat(car.toString()).isEqualTo(CAR_NAME + " : " + BAR);

    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void Car_3이하이면_멈춤(int value) {
        Car car = new Car(CAR_NAME);
        Move move = new Move(value);
        car.forwardOrStop(move);

        assertThat(car.getProgressBar()).isEqualTo("");
        assertThat(car.getProgressBar().length()).isEqualTo(0);
    }

}
