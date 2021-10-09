package racinggame.domain;

import racinggame.exception.CustomException;
import racinggame.ui.Input;
import racinggame.ui.Output;

public class RacingManager {

    private Cars cars;
    private Status status;

    enum Status {
        READY
    }

    public void initRacing() {
        try {
            initCars();
            ready();
        } catch (CustomException e) {
            Output.printErrorMessage(e.getMessage());
        }
    }

    private void initCars() {
        cars = new Cars();
        String[] input = Input.inputCars();
        for (int i = 0; i < input.length; i++) {
            CarName name = new CarName(input[i]);
            Car car = new Car(name);
            cars.add(car);
        }
    }

    public boolean isReady() {
        return this.status == Status.READY;
    }

    private void ready() {
        this.status = Status.READY;
    }
}
