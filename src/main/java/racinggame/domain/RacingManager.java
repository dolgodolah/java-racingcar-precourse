package racinggame.domain;

import racinggame.exception.CustomException;
import racinggame.exception.ErrorCode;
import racinggame.ui.Input;
import racinggame.ui.Output;

public class RacingManager {

    private Cars cars;
    private TryCount tryCount;
    private Status status;

    enum Status {
        READY
    }

    public void initRacing() {
        try {
            initCars();
            inputTryCount();
            ready();
        } catch (CustomException e) {
            Output.printErrorMessage(e.getMessage());
        }
    }

    private void initCars() {
        cars = new Cars();
        String[] input = Input.inputCars();
        for (int i = 0; i < input.length; i++) {
            Car car = new Car(input[i]);
            cars.add(car);
        }
    }

    private void inputTryCount() {
        String input = Input.inputTryCount();
        tryCount = TryCount.of(input);
    }

    public boolean isReady() {
        return this.status == Status.READY;
    }

    private void ready() {
        this.status = Status.READY;
    }
}
