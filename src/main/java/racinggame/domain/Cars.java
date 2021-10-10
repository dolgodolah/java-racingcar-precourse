package racinggame.domain;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void add(Car car) {
        this.cars.add(car);
    }

    public List<Car> get() {
        return cars;
    }

    public void race() {
        for (int i = 0; i < cars.size(); i++) {
            Move move = new Move(Randoms.pickNumberInRange(0, 9));
            cars.get(i).forwardOrStop(move);
        }
    }
}
