package racinggame.domain;

import racinggame.exception.CustomException;
import racinggame.exception.ErrorCode;
import racinggame.ui.Input;
import racinggame.ui.Output;

import java.util.List;

public class RacingManager {

    private Cars cars;
    private TryCount tryCount;
    private Status status;

    enum Status {
        INIT_CARS, INPUT_TRY_COUNT, READY
    }

    public RacingManager() {
        this.status = Status.INIT_CARS;
    }

    public void initRacing() {
        while (isInitCarsStatus()) {
            initCars();
        }

        while (isInputTryCountStatus()) {
            inputTryCount();
        }
    }

    public void startRacing() {
        Output.printStartMessage();
        for (int i = 0; i < tryCount.get(); i++) {
            cars.race();
            cars.viewStatus();
        }
    }

    public void viewResult() {
        List<Car> winners = cars.getWinners();
        Result result = new Result(winners);
        Output.printResult(result.toString());
    }

    private void initCars() {
        try {
            inputCars();
        } catch (CustomException e) {
            Output.printErrorMessage(e.getMessage());
        }
    }

    private void inputCars() {
        cars = new Cars();
        String[] input = Input.inputCars();
        if (input.length < 1) {
            throw new CustomException(ErrorCode.EMPTY_NAME);
        }

        for (int i = 0; i < input.length; i++) {
            Car car = new Car(input[i]);
            cars.add(car);
        }

        completeInitCars();
    }

    private void inputTryCount() {
        try {
            String input = Input.inputTryCount();
            tryCount = TryCount.of(input);
            completeInputTryCount();
        } catch (CustomException e) {
            Output.printErrorMessage(e.getMessage());
        }

    }

    private boolean isInitCarsStatus() {
        return this.status == Status.INIT_CARS;
    }

    private boolean isInputTryCountStatus() {
        return this.status == Status.INPUT_TRY_COUNT;
    }

    private void completeInitCars() {
        this.status = Status.INPUT_TRY_COUNT;
    }

    private void completeInputTryCount() {
        this.status = Status.READY;
    }

}
