package racinggame.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


class CarsTest {

    private static final CarName CAR_NAME = new CarName("one");

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    void Cars_차_추가(int input) {
        Cars cars = new Cars();
        for (int i = 0; i < input; i++) {
            cars.add(new Car(CAR_NAME));
        }

        assertThat(cars.get().size()).isEqualTo(input);
    }
}